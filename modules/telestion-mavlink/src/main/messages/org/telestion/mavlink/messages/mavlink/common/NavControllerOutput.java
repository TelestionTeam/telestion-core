package org.telestion.mavlink.messages.mavlink.common;

import org.telestion.adapter.mavlink.annotation.MavField;
import org.telestion.adapter.mavlink.annotation.MavInfo;
import org.telestion.adapter.mavlink.annotation.NativeType;
import org.telestion.adapter.mavlink.message.MavlinkMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The state of the fixed wing navigation and position controller.</br>
 * </br>
 * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
 * 
 * @author Autogenerated by XML2Record-Tool (by Cedric Boes)
 * @version 1.0 (autogenerated)
 */
@MavInfo(id = 62, crc = 183)
@SuppressWarnings("preview")
public record NavControllerOutput(
        /**
         * Current desired roll</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.FLOAT)
        @JsonProperty double navRoll, 
        /**
         * Current desired pitch</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.FLOAT)
        @JsonProperty double navPitch, 
        /**
         * Current desired heading</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.INT_16)
        @JsonProperty int navBearing, 
        /**
         * Bearing to current waypoint/target</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.INT_16)
        @JsonProperty int targetBearing, 
        /**
         * Distance to active waypoint</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_16)
        @JsonProperty int wpDist, 
        /**
         * Current altitude error</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.FLOAT)
        @JsonProperty double altError, 
        /**
         * Current airspeed error</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.FLOAT)
        @JsonProperty double aspdError, 
        /**
         * Current crosstrack error on x-y plane</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.FLOAT)
        @JsonProperty double xtrackError) implements MavlinkMessage {
    /**
     * There shall be no default-constructor for normal developers.
     */
    @SuppressWarnings("unused")
    private NavControllerOutput() {
        this(0, 0, 0, 0, 0, 0, 0, 0);
    }
}