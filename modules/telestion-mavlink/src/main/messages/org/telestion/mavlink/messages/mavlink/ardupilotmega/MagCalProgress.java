package org.telestion.mavlink.messages.mavlink.ardupilotmega;

import org.telestion.adapter.mavlink.annotation.MavField;
import org.telestion.adapter.mavlink.annotation.MavInfo;
import org.telestion.adapter.mavlink.annotation.NativeType;
import org.telestion.adapter.mavlink.annotation.MavArray;
import org.telestion.adapter.mavlink.message.MavlinkMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Reports progress of compass calibration.</br>
 * </br>
 * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
 * 
 * @author Autogenerated by XML2Record-Tool (by Cedric Boes)
 * @version 1.0 (autogenerated)
 */
@MavInfo(id = 191, crc = 92)
@SuppressWarnings("preview")
public record MagCalProgress(
        /**
         * Compass being calibrated.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int compassId, 
        /**
         * Bitmask of compasses being calibrated.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int calMask, 
        /**
         * Calibration Status.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int calStatus, 
        /**
         * Attempt number.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int attempt, 
        /**
         * Completion percentage.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int completionPct, 
        /**
         * Bitmask of sphere sections (see http://en.wikipedia.org/wiki/Geodesic_grid).</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavArray(length = 10)
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int[] completionMask, 
        /**
         * Body frame direction vector for display.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.FLOAT)
        @JsonProperty double directionX, 
        /**
         * Body frame direction vector for display.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.FLOAT)
        @JsonProperty double directionY, 
        /**
         * Body frame direction vector for display.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.FLOAT)
        @JsonProperty double directionZ) implements MavlinkMessage {
    /**
     * There shall be no default-constructor for normal developers.
     */
    @SuppressWarnings("unused")
    private MagCalProgress() {
        this(0, 0, 0, 0, 0, null, 0, 0, 0);
    }
}