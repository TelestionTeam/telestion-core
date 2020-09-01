package org.telestion.adapter.mavlink.message.internal;

import org.telestion.api.message.JsonMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TODO: Java-Docs to make @pklaschka happy ;)
 *
 * @author Cedric Boes
 * @version 1.0
 */
@SuppressWarnings("preview")
public final record MavConnection(
		@JsonProperty byte[] bytes,
		@JsonProperty String remoteAddress) implements JsonMessage {
	
	@SuppressWarnings("unused")
	private MavConnection() {
		this(null, null);
	}
}