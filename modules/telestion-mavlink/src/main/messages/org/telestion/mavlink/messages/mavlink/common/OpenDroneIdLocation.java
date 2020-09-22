package org.telestion.mavlink.messages.mavlink.common;

import org.telestion.adapter.mavlink.annotation.MavField;
import org.telestion.adapter.mavlink.annotation.MavInfo;
import org.telestion.adapter.mavlink.annotation.NativeType;
import org.telestion.adapter.mavlink.annotation.MavArray;
import org.telestion.adapter.mavlink.message.MavlinkMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data for filling the OpenDroneID Location message. The float data types are 32-bit IEEE 754. The Location message provides the location, altitude, direction and speed of the aircraft.</br>
 * </br>
 * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
 * 
 * @author Autogenerated by XML2Record-Tool (by Cedric Boes)
 * @version 1.0 (autogenerated)
 * @deprecated This is still WIP and might change!
 */
@Deprecated
@MavInfo(id = 12901, crc = 254)
@SuppressWarnings("preview")
public record OpenDroneIdLocation(
        /**
         * System ID (0 for broadcast).</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int targetSystem, 
        /**
         * Component ID (0 for broadcast).</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int targetComponent, 
        /**
         * Only used for drone ID data received from other UAs. See detailed description at https://mavlink.io/en/services/opendroneid.html. </br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavArray(length = 20)
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int[] idOrMac, 
        /**
         * Indicates whether the unmanned aircraft is on the ground or in the air.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int status, 
        /**
         * Direction over ground (not heading, but direction of movement) measured clockwise from true North: 0 - 35999 centi-degrees. If unknown: 36100 centi-degrees.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_16)
        @JsonProperty int direction, 
        /**
         * Ground speed. Positive only. If unknown: 25500 cm/s. If speed is larger than 25425 cm/s, use 25425 cm/s.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_16)
        @JsonProperty int speedHorizontal, 
        /**
         * The vertical speed. Up is positive. If unknown: 6300 cm/s. If speed is larger than 6200 cm/s, use 6200 cm/s. If lower than -6200 cm/s, use -6200 cm/s.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.INT_16)
        @JsonProperty int speedVertical, 
        /**
         * Current latitude of the unmanned aircraft. If unknown: 0 (both Lat/Lon).</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.INT_32)
        @JsonProperty int latitude, 
        /**
         * Current longitude of the unmanned aircraft. If unknown: 0 (both Lat/Lon).</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.INT_32)
        @JsonProperty int longitude, 
        /**
         * The altitude calculated from the barometric pressue. Reference is against 29.92inHg or 1013.2mb. If unknown: -1000 m.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.FLOAT)
        @JsonProperty double altitudeBarometric, 
        /**
         * The geodetic altitude as defined by WGS84. If unknown: -1000 m.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.FLOAT)
        @JsonProperty double altitudeGeodetic, 
        /**
         * Indicates the reference point for the height field.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int heightReference, 
        /**
         * The current height of the unmanned aircraft above the take-off location or the ground as indicated by height_reference. If unknown: -1000 m.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.FLOAT)
        @JsonProperty double height, 
        /**
         * The accuracy of the horizontal position.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int horizontalAccuracy, 
        /**
         * The accuracy of the vertical position.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int verticalAccuracy, 
        /**
         * The accuracy of the barometric altitude.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int barometerAccuracy, 
        /**
         * The accuracy of the horizontal and vertical speed.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int speedAccuracy, 
        /**
         * Seconds after the full hour with reference to UTC time. Typically the GPS outputs a time-of-week value in milliseconds. First convert that to UTC and then convert for this field using ((float) (time_week_ms % (60*60*1000))) / 1000.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.FLOAT)
        @JsonProperty double timestamp, 
        /**
         * The accuracy of the timestamps.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int timestampAccuracy) implements MavlinkMessage {
    /**
     * There shall be no default-constructor for normal developers.
     */
    @SuppressWarnings("unused")
    private OpenDroneIdLocation() {
        this(0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }
}