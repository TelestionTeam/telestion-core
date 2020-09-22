package org.telestion.mavlink.messages.mavlink.common;

import org.telestion.adapter.mavlink.annotation.MavField;
import org.telestion.adapter.mavlink.annotation.MavInfo;
import org.telestion.adapter.mavlink.annotation.NativeType;
import org.telestion.adapter.mavlink.message.MavlinkMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This message is emitted as response to MISSION_REQUEST_LIST by the MAV and to initiate a write transaction. The GCS can then request the individual mission item based on the knowledge of the total number of waypoints.</br>
 * </br>
 * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
 * 
 * @author Autogenerated by XML2Record-Tool (by Cedric Boes)
 * @version 1.0 (autogenerated)
 */
@MavInfo(id = 44, crc = 221)
@SuppressWarnings("preview")
public record MissionCount(
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
         * Number of mission items in the sequence</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_16)
        @JsonProperty int count, 
        /**
         * Mission type.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.3.7</i>
         */
        @MavField(nativeType = NativeType.UINT_8, extension = true)
        @JsonProperty int missionType) implements MavlinkMessage {
    /**
     * There shall be no default-constructor for normal developers.
     */
    @SuppressWarnings("unused")
    private MissionCount() {
        this(0, 0, 0, 0);
    }
}