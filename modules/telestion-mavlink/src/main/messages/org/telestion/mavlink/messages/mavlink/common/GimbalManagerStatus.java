package org.telestion.mavlink.messages.mavlink.common;

import org.telestion.adapter.mavlink.annotation.MavField;
import org.telestion.adapter.mavlink.annotation.MavInfo;
import org.telestion.adapter.mavlink.annotation.NativeType;
import org.telestion.adapter.mavlink.message.MavlinkMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Current status about a high level gimbal manager. This message should be broadcast at a low regular rate (e.g. 5Hz).</br>
 * </br>
 * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
 * 
 * @author Autogenerated by XML2Record-Tool (by Cedric Boes)
 * @version 1.0 (autogenerated)
 * @deprecated This is still WIP and might change!
 */
@Deprecated
@MavInfo(id = 281, crc = 0)
@SuppressWarnings("preview")
public record GimbalManagerStatus(
        /**
         * Timestamp (time since system boot).</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_32)
        @JsonProperty long timeBootMs, 
        /**
         * High level gimbal manager flags currently applied.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_32)
        @JsonProperty long flags, 
        /**
         * Gimbal device ID that this gimbal manager is responsible for.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int gimbalDeviceId) implements MavlinkMessage {
    /**
     * There shall be no default-constructor for normal developers.
     */
    @SuppressWarnings("unused")
    private GimbalManagerStatus() {
        this(0, 0, 0);
    }
}