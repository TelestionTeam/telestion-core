package de.wuespace.telestion.services.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import de.wuespace.telestion.api.config.Config;

/**
 * A simple WebServer which publishes the index page.
 *
 * @author Jan von Pichowski
 */
public final class WebServer extends AbstractVerticle {

	private Configuration forcedConfig;

	/**
 	 * Creating a WebServer on the specified port.
	 *
	 * @param port to bind to
	 */
	public WebServer(int port) {
		forcedConfig = new Configuration(port);
	}

	/**
	 * Web server with default port 8080.
	 */
	public WebServer() {
		forcedConfig = null;
	}

	@Override
	public void start(Promise<Void> startPromise) throws Exception {
		var config = Config.get(forcedConfig, config(), Configuration.class);

		var data = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("index.html")).readAllBytes();
		var content = new String(data, StandardCharsets.UTF_8);

		HttpServer server = vertx.createHttpServer();

		Router router = Router.router(vertx);

		router.route().handler(routingContext -> {
			HttpServerResponse response = routingContext.response();
			response.putHeader("content-type", "text/html");
			response.end(content);
		});

		server.requestHandler(router).listen(config.port);
	}

	/**
	 * Web server configuration.
	 *
	 * @param port the port to bind to
	 */
	@SuppressWarnings({ "preview", "unused" })
	private static record Configuration(@JsonProperty int port) {
		private Configuration() {
			this(8080);
		}
	}
}
