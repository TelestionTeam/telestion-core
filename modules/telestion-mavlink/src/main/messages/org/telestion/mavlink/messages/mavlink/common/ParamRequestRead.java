package org.telestion.mavlink.messages.mavlink.common;

import org.telestion.adapter.mavlink.annotation.MavField;
import org.telestion.adapter.mavlink.annotation.MavInfo;
import org.telestion.adapter.mavlink.annotation.NativeType;
import org.telestion.adapter.mavlink.annotation.MavArray;
import org.telestion.adapter.mavlink.message.MavlinkMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request to read the onboard parameter with the param_id string id. Onboard parameters are stored as key[const char*] -> value[float]. This allows to send a parameter to any other component (such as the GCS) without the need of previous knowledge of possible parameter names. Thus the same GCS can store different parameters for different autopilots. See also https://mavlink.io/en/services/parameter.html for a full documentation of QGroundControl and IMU code.</br>
 * </br>
 * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
 * 
 * @author Autogenerated by XML2Record-Tool (by Cedric Boes)
 * @version 1.0 (autogenerated)
 */
@MavInfo(id = 20, crc = 214)
@SuppressWarnings("preview")
public record ParamRequestRead(
        /**
         * System ID</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int targetSystem, 
        /**
         * Component ID</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int targetComponent, 
        /**
         * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavArray(length = 16)
        @MavField(nativeType = NativeType.CHAR)
        @JsonProperty int[] paramId, 
        /**
         * Parameter index. Send -1 to use the param ID field as identifier (else the param id will be ignored)</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.INT_16)
        @JsonProperty int paramIndex) implements MavlinkMessage {
    /**
     * There shall be no default-constructor for normal developers.
     */
    @SuppressWarnings("unused")
    private ParamRequestRead() {
        this(0, 0, null, 0);
    }
}