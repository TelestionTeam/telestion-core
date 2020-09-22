package org.telestion.mavlink.messages.mavlink.common;

import org.telestion.adapter.mavlink.annotation.MavField;
import org.telestion.adapter.mavlink.annotation.MavInfo;
import org.telestion.adapter.mavlink.annotation.NativeType;
import org.telestion.adapter.mavlink.message.MavlinkMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Read out the safety zone the MAV currently assumes.</br>
 * </br>
 * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
 * 
 * @author Autogenerated by XML2Record-Tool (by Cedric Boes)
 * @version 1.0 (autogenerated)
 */
@MavInfo(id = 55, crc = 3)
@SuppressWarnings("preview")
public record SafetyAllowedArea(
        /**
         * Coordinate frame. Can be either global, GPS, right-handed with Z axis up or local, right handed, Z axis down.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int frame, 
        /**
         * x position 1 / Latitude 1</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.FLOAT)
        @JsonProperty double p1X, 
        /**
         * y position 1 / Longitude 1</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.FLOAT)
        @JsonProperty double p1Y, 
        /**
         * z position 1 / Altitude 1</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.FLOAT)
        @JsonProperty double p1Z, 
        /**
         * x position 2 / Latitude 2</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.FLOAT)
        @JsonProperty double p2X, 
        /**
         * y position 2 / Longitude 2</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.FLOAT)
        @JsonProperty double p2Y, 
        /**
         * z position 2 / Altitude 2</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.FLOAT)
        @JsonProperty double p2Z) implements MavlinkMessage {
    /**
     * There shall be no default-constructor for normal developers.
     */
    @SuppressWarnings("unused")
    private SafetyAllowedArea() {
        this(0, 0, 0, 0, 0, 0, 0);
    }
}