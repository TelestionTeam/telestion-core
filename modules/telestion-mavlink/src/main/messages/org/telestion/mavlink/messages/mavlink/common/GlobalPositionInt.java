package org.telestion.mavlink.messages.mavlink.common;

import org.telestion.adapter.mavlink.annotation.MavField;
import org.telestion.adapter.mavlink.annotation.MavInfo;
import org.telestion.adapter.mavlink.annotation.NativeType;
import org.telestion.adapter.mavlink.message.MavlinkMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The filtered global position (e.g. fused GPS and accelerometers). The position is in GPS-frame (right-handed, Z-up). It
               is designed as scaled integer message since the resolution of float is not sufficient.</br>
 * </br>
 * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
 * 
 * @author Autogenerated by XML2Record-Tool (by Cedric Boes)
 * @version 1.0 (autogenerated)
 */
@MavInfo(id = 33, crc = 104)
@SuppressWarnings("preview")
public record GlobalPositionInt(
        /**
         * Timestamp (time since system boot).</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_32)
        @JsonProperty long timeBootMs, 
        /**
         * Latitude, expressed</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.INT_32)
        @JsonProperty int lat, 
        /**
         * Longitude, expressed</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.INT_32)
        @JsonProperty int lon, 
        /**
         * Altitude (MSL). Note that virtually all GPS modules provide both WGS84 and MSL.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.INT_32)
        @JsonProperty int alt, 
        /**
         * Altitude above ground</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.INT_32)
        @JsonProperty int relativeAlt, 
        /**
         * Ground X Speed (Latitude, positive north)</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.INT_16)
        @JsonProperty int vx, 
        /**
         * Ground Y Speed (Longitude, positive east)</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.INT_16)
        @JsonProperty int vy, 
        /**
         * Ground Z Speed (Altitude, positive down)</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.INT_16)
        @JsonProperty int vz, 
        /**
         * Vehicle heading (yaw angle), 0.0..359.99 degrees. If unknown, set to: UINT16_MAX</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_16)
        @JsonProperty int hdg) implements MavlinkMessage {
    /**
     * There shall be no default-constructor for normal developers.
     */
    @SuppressWarnings("unused")
    private GlobalPositionInt() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0);
    }
}