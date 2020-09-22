package org.telestion.mavlink.messages.mavlink.ardupilotmega;

import org.telestion.adapter.mavlink.annotation.MavField;
import org.telestion.adapter.mavlink.annotation.MavInfo;
import org.telestion.adapter.mavlink.annotation.NativeType;
import org.telestion.adapter.mavlink.annotation.MavArray;
import org.telestion.adapter.mavlink.message.MavlinkMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ESC Telemetry Data for ESCs 1 to 4, matching data sent by BLHeli ESCs.</br>
 * </br>
 * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
 * 
 * @author Autogenerated by XML2Record-Tool (by Cedric Boes)
 * @version 1.0 (autogenerated)
 */
@MavInfo(id = 11030, crc = 144)
@SuppressWarnings("preview")
public record EscTelemetry1To4(
        /**
         * Temperature.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavArray(length = 4)
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int[] temperature, 
        /**
         * Voltage.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavArray(length = 4)
        @MavField(nativeType = NativeType.UINT_16)
        @JsonProperty int[] voltage, 
        /**
         * Current.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavArray(length = 4)
        @MavField(nativeType = NativeType.UINT_16)
        @JsonProperty int[] current, 
        /**
         * Total current.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavArray(length = 4)
        @MavField(nativeType = NativeType.UINT_16)
        @JsonProperty int[] totalcurrent, 
        /**
         * RPM (eRPM).</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavArray(length = 4)
        @MavField(nativeType = NativeType.UINT_16)
        @JsonProperty int[] rpm, 
        /**
         * count of telemetry packets received (wraps at 65535).</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavArray(length = 4)
        @MavField(nativeType = NativeType.UINT_16)
        @JsonProperty int[] count) implements MavlinkMessage {
    /**
     * There shall be no default-constructor for normal developers.
     */
    @SuppressWarnings("unused")
    private EscTelemetry1To4() {
        this(null, null, null, null, null, null);
    }
}