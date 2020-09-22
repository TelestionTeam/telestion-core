package org.telestion.mavlink.messages.mavlink.common;

import org.telestion.adapter.mavlink.annotation.MavField;
import org.telestion.adapter.mavlink.annotation.MavInfo;
import org.telestion.adapter.mavlink.annotation.NativeType;
import org.telestion.adapter.mavlink.message.MavlinkMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Status generated in each node in the communication chain and injected into MAVLink stream.</br>
 * </br>
 * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
 * 
 * @author Autogenerated by XML2Record-Tool (by Cedric Boes)
 * @version 1.0 (autogenerated)
 * @deprecated This is still WIP and might change!
 */
@Deprecated
@MavInfo(id = 8, crc = 117)
@SuppressWarnings("preview")
public record LinkNodeStatus(
        /**
         * Timestamp (time since system boot).</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_64)
        @JsonProperty long timestamp, 
        /**
         * Remaining free transmit buffer space</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int txBuf, 
        /**
         * Remaining free receive buffer space</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int rxBuf, 
        /**
         * Transmit rate</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_32)
        @JsonProperty long txRate, 
        /**
         * Receive rate</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_32)
        @JsonProperty long rxRate, 
        /**
         * Number of bytes that could not be parsed correctly.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_16)
        @JsonProperty int rxParseErr, 
        /**
         * Transmit buffer overflows. This number wraps around as it reaches UINT16_MAX</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_16)
        @JsonProperty int txOverflows, 
        /**
         * Receive buffer overflows. This number wraps around as it reaches UINT16_MAX</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_16)
        @JsonProperty int rxOverflows, 
        /**
         * Messages sent</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_32)
        @JsonProperty long messagesSent, 
        /**
         * Messages received (estimated from counting seq)</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_32)
        @JsonProperty long messagesReceived, 
        /**
         * Messages lost (estimated from counting seq)</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_32)
        @JsonProperty long messagesLost) implements MavlinkMessage {
    /**
     * There shall be no default-constructor for normal developers.
     */
    @SuppressWarnings("unused")
    private LinkNodeStatus() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }
}