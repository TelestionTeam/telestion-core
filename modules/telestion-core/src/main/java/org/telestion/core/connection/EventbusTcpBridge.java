package org.telestion.core.connection;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.SockJSBridgeOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telestion.core.config.Config;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * WidgetBridge is a verticle which uses SockJS-WebSockets to extend the
 * vertx.eventBus() to an HTTP-Server.
 * <p>
 *     It creates <code>Router</code> using vertx, which handles HTTP-Requests
 *     coming to the HTTP-Server.
 *     The EventBusBridge by default works after the deny-any-principle, which
 *     means that any message which is not permitted explicitly will be denied (reply messages are an exception).
 *     To permit the desired messages for the frontend to go through you have to configure
 *     <code>SockJSBridgeOptions</code> and mount them as a SubRouter to the Router.
 *
 *     You have to configure the following options:
 *     <ul>
 *         <li>httpServerOptions - the HttpServerOptions to configure the HTTP-Server</li>
 *         <li>defaultSockJSBridgeOptions - the SockJSBridgeOptions to configure rules to allow messages to go through</li>
 *     </ul>
 *     To do that you have four constructors to initialize the HTTP-Server.
 * </p>
 * <p>
 *     To define rules for messages to be allowed through
 *     you have to add <code>new PermittedOptions()</code> to the sockJSBridgeOptions.
 *     You can either do that in the third constructor
 *     by passing <code>new SockJSBridgeOptions</code> as parameter
 *     or modify the defaultSockJSBridgeOptions and add your rules there.
 * </p>
 * <p>
 * An example looks like this:
 * <pre>
 * {@code
 *       SockJSBridgeOptions defaultSockJSBridgeOptions = new SockJSBridgeOptions()
 *          .addInboundPermitted(new PermittedOptions()
 *              .setAddress(Address.incoming(<YourClass>.class, "<method>")))
 *          .addOutboundPermitted(new PermittedOptions()
 *              .setAddress(Address.outgoing(<YourClass>.class, "<method>)));
 * }
 * </pre>
 * </p>
 *
 * {@link ./README.md} for more information
 */
public final class EventbusTcpBridge extends AbstractVerticle {

    /**
     * The bridge configuration
     *
     * @param host the ip address of the host on which the HTTP-Server should run
     * @param port the port on which the HTTP-Server should listen
     * @param inboundPermitted the permitted eventbus addresses for inbound connections
     * @param outboundPermitted the permitted eventbus addresses for outbound connections
     */
    private static record Configuration(
            @JsonProperty String host,
            @JsonProperty int port,
            @JsonProperty List<String> inboundPermitted,
            @JsonProperty List<String> outboundPermitted) {
        private Configuration() {
            this("127.0.0.1", 9870, Collections.emptyList(), Collections.emptyList());
        }
    }

    private final Logger logger = LoggerFactory.getLogger(EventbusTcpBridge.class);

    private final Configuration forcedConfig;

    /**
     * This constructor supplies default options
     * and uses the defaultSockJSBridgeOptions for the applied rules.
     *
     * @param host the ip address of the host on which the HTTP-Server should run
     * @param port the port on which the HTTP-Server should listen
     * @param inboundPermitted the permitted eventbus addresses for inbound connections
     * @param outboundPermitted the permitted eventbus addresses for outbound connections
     */
    public EventbusTcpBridge(String host, int port, List<String> inboundPermitted, List<String> outboundPermitted) {
        this.forcedConfig = new Configuration(host, port, inboundPermitted, outboundPermitted);
    }

    /**
     * If this constructor is used all, settings have to be specified in the config file
     */
    public EventbusTcpBridge() {
        this.forcedConfig = null;
    }

    @Override
    public void start(Promise<Void> startPromise) {
        var config = Config.get(forcedConfig, config(), Configuration.class);
        
        HttpServerOptions httpOptions = new HttpServerOptions()
                .setHost(config.host)
                .setPort(config.port);

        Router router = Router.router(vertx);

        router.mountSubRouter("/bridge", bridgeHandler(config.inboundPermitted, config.outboundPermitted));
        router.route().handler(staticHandler());

        vertx.createHttpServer(httpOptions)
                .requestHandler(router)
                .listen();

        logger.info("Server listening on {}:{}/bridge", httpOptions.getHost(), httpOptions.getPort());
        startPromise.complete();
    }

    /**
     * Creates a sockJSHandler using vertx.
     *
     * @return Router to be mounted on an existing Router bridging the eventBus with the defined sockJSBridgeOptions
     */
    private Router bridgeHandler(List<String> inboundPermitted, List<String> outboundPermitted) {
        logger.info("Inbound permitted: "+inboundPermitted);
        logger.info("Outbound permitted: "+outboundPermitted);
        SockJSBridgeOptions sockJSBridgeOptions = new SockJSBridgeOptions();
        inboundPermitted.forEach(addr -> sockJSBridgeOptions.addInboundPermitted(new PermittedOptions().setAddress(addr)));
        outboundPermitted.forEach(addr -> sockJSBridgeOptions.addOutboundPermitted(new PermittedOptions().setAddress(addr)));

        SockJSHandler sockJSHandler = SockJSHandler.create(vertx);
        return sockJSHandler.bridge(sockJSBridgeOptions);
    }

    /**
     * Creates a staticHandler for serving static resources from the file system or classpath.
     * May be used to display HTML-Page explaining how to use the WidgetBridge
     * or to redirect users to the right url: {@link "http://localhost:8080"}
     *
     * @return StaticHandler
     */
    private StaticHandler staticHandler() {
        return StaticHandler.create()
                .setCachingEnabled(false);
    }
}
