package de.wuespace.telestion.services.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.wuespace.telestion.api.verticle.TelestionConfiguration;
import de.wuespace.telestion.api.verticle.TelestionVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.SockJSBridgeOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;

import java.util.Collections;
import java.util.List;

/**
 * The WebClient bridge is a verticle which uses SockJS-WebSockets to extend the vertx.eventBus() to an HTTP-Server.
 * <p>
 * It creates <code>Router</code> using vertx, which handles HTTP-Requests coming to the HTTP-Server.
 * The EventBusBridge by default works after the deny-any-principle, which means that any message
 * which is not permitted explicitly will be denied (reply messages are an exception).
 * To permit the desired messages for the frontend to go through you have to configure
 * <code>SockJSBridgeOptions</code> and mount them as a SubRouter to the Router.
 * </p>
 * <p>
 * You have to configure the following options:
 * <ul>
 *     <li>httpServerOptions - the HttpServerOptions to configure the HTTP-Server</li>
 *     <li>defaultSockJSBridgeOptions - the SockJSBridgeOptions to configure rules to allow messages to go through</li>
 * </ul>
 * To do that you have four constructors to initialize the HTTP-Server.
 *
 * <p>
 *     To define rules for messages to be allowed through you have to add
 *     <code>new PermittedOptions()</code> to the sockJSBridgeOptions.
 *     You can either do that in the third constructor by passing <code>new SockJSBridgeOptions</code>
 *     as parameter or modify the defaultSockJSBridgeOptions and add your rules there.
 * </p>
 * <p>
 * An example looks like this:
 * <pre>{@code SockJSBridgeOptions defaultSockJSBridgeOptions = new SockJSBridgeOptions()
 * 	.addInboundPermitted(new PermittedOptions()
 * 	.setAddress(Address.incoming(<YourClass>.class, "<method>")))
 * 	.addOutboundPermitted(new PermittedOptions()
 * 	.setAddress(Address.outgoing(<YourClass>.class, "<method>)));}</pre>
 *
 * <p>
 *     To support that the one can send data type specific data on the outbound address vertx supports regex.
 *     You can add a regex to <code>new PermittedOptions()</code>.
 * </p>
 * <p>
 * An example looks like this:
 * <pre>{@code SockJSBridgeOptions sockJSBridgeOptions = new SockJSBridgeOptions()
 * 	.addOutboundPermitted(new PermittedOptions().setAddressRegex("(<Address>)(\/(\S+))?"));}</pre>
 * Which results in permission granted to all messages to the given address optionally suffixed with e.g. "/className.
 *
 * @author Jan Tischhoefer (@jantischhoefer), Jan von Pichovski (@jvpichovski), Ludwig Richter (@fussel178)
 * @see <a href="../../../../../../../README.md">README.md</a> for more information
 */
public class WebClientBridge extends TelestionVerticle<WebClientBridge.Configuration> {

	/**
	 * The bridge configuration.
	 *
	 * @param host              of the host on which the HTTP-Server should run
	 * @param port              on which the HTTP-Server should listen
	 * @param inboundPermitted  permitted eventbus addresses for inbound connections
	 * @param outboundPermitted permitted eventbus addresses for outbound connections
	 */
	public record Configuration(
			@JsonProperty String host,
			@JsonProperty int port,
			@JsonProperty List<String> inboundPermitted,
			@JsonProperty List<String> outboundPermitted
	) implements TelestionConfiguration {
		public Configuration() {
			this("127.0.0.1", 9870, Collections.emptyList(), Collections.emptyList());
		}
	}

	@Override
	public void onStart(Promise<Void> startPromise) throws Exception {
		var router = Router.router(vertx);
		// handle "/bridge" route via SockJS bridge handler
		router.route("/bridge")
				.subRouter(bridgeHandler(getConfig().inboundPermitted(), getConfig().outboundPermitted()));
		// handle remaining via static handler
		router.route().handler(staticHandler());

		var server = vertx.createHttpServer().requestHandler(router);
		server.listen(getConfig().port(), getConfig().host())
				.onSuccess(s -> {
					logger.info("Eventbus TCP Bridge listening on {}:{}", getConfig().host(), getConfig().port());
				})
				.onSuccess(s -> startPromise.complete())
				.onFailure(startPromise::fail);
	}

	/**
	 * Creates a sockJSHandler using vertx.
	 *
	 * @return Router to be mounted on an existing Router bridging the eventBus with the defined sockJSBridgeOptions
	 */
	private Router bridgeHandler(List<String> inboundPermitted, List<String> outboundPermitted) {
		logger.info("Inbound permitted: " + inboundPermitted);
		logger.info("Outbound permitted: " + outboundPermitted);
		SockJSBridgeOptions sockJsBridgeOptions = new SockJSBridgeOptions();
		inboundPermitted
				.forEach(addr -> sockJsBridgeOptions.addInboundPermitted(new PermittedOptions().setAddress(addr)));
		outboundPermitted
				.forEach(addr -> sockJsBridgeOptions.addOutboundPermitted(new PermittedOptions().setAddressRegex(
						"(" + addr + ")(\\/(\\S+))?"
				)));

		SockJSHandler sockJsHandler = SockJSHandler.create(vertx);
		return sockJsHandler.bridge(sockJsBridgeOptions);
	}

	/**
	 * Creates a staticHandler for serving static resources from the file system or classpath. May be used to display
	 * HTML-Page explaining how to use the WidgetBridge or to redirect users to the right url:<br>
	 * <a href="http://localhost:8080">localhost:8080</a>
	 *
	 * @return {@link StaticHandler}
	 */
	private StaticHandler staticHandler() {
		return StaticHandler.create().setCachingEnabled(false);
	}
}
