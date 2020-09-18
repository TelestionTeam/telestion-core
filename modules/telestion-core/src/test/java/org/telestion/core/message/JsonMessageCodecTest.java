package org.telestion.core.message;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.telestion.example.Position;
import org.telestion.example.Positions;

@ExtendWith(VertxExtension.class)
public class JsonMessageCodecTest {

    @Test void testEncodeDecode(){
        var expected = new Position(5.3, 4.2, 7.1);
        var buf = Buffer.buffer();
        var codec = JsonMessageCodec.instance(Position.class);
        codec.encodeToWire(buf, expected);
        var actual = codec.decodeFromWire(0, buf);
        Assertions.assertEquals(expected, actual);
    }

    @Test void testMultiRegister(Vertx vertx, VertxTestContext testContext) throws Throwable {
        vertx.eventBus().registerDefaultCodec(Position.class, JsonMessageCodec.instance(Position.class));
        vertx.eventBus().registerDefaultCodec(Positions.class, JsonMessageCodec.instance(Positions.class));
        testContext.completeNow();
    }
}
