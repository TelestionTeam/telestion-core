package org.telestion.core.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.vertx.core.json.JsonObject;
import org.telestion.api.message.JsonMessage;

import java.util.Collections;
import java.util.List;

public record DBResponse(
        @JsonProperty Class<?> dataType,
        @JsonProperty List<JsonObject> result) implements JsonMessage {

    private DBResponse() { this(null, Collections.emptyList()); }
}
