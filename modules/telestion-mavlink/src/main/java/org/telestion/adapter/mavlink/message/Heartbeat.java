package org.telestion.adapter.mavlink.message;

import org.telestion.adapter.mavlink.annotation.MavField;
import org.telestion.adapter.mavlink.annotation.MavInfo;
import org.telestion.adapter.mavlink.annotation.NativeType;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The heartbeat message shows that a system or component is present and responding. The type and autopilot fields (along with the message component id), allow the receiving system to treat further messages from this system appropriately (e.g. by laying out the user interface based on the autopilot). This microservice is documented at https://mavlink.io/en/services/heartbeat.html</br>
 * </br>
 * <i>Autogenerated by XML2Record-Tool v1.0.0</i>
 * 
 * @author Autogenerated by XML2Record-Tool (by Cedric Boes)
 * @version 1.0 (autogenerated)
 */
@MavInfo(id = 0, crc = 50)
@SuppressWarnings("preview")
public record Heartbeat(
        /**
         * A bitfield for use for autopilot-specific flags</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.0.0</i>
         */
        @MavField(nativeType = NativeType.UINT_32)
        @JsonProperty long customMode, 
        /**
         * Vehicle or component type. For a flight controller component the vehicle type (quadrotor, helicopter, etc.). For other components the component type (e.g. camera, gimbal, etc.). This should be used in preference to component id for identifying the component type.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.0.0</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int type, 
        /**
         * Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight controllers.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.0.0</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int autopilot, 
        /**
         * System mode bitmap.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.0.0</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int baseMode, 
        /**
         * System status flag.</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.0.0</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int systemStatus, 
        /**
         * MAVLink version, not writable by user, gets added by protocol because of magic data type: uint8_t_mavlink_version</br>
         * </br>
         * <i>Autogenerated by XML2Record-Tool v1.0.0</i>
         */
        @MavField(nativeType = NativeType.UINT_8)
        @JsonProperty int mavlinkVersion) implements MavlinkMessage {
    /**
     * There shall be no default-constructor for normal developers.
     */
    @SuppressWarnings("unused")
    private Heartbeat() {
        this(0, 0, 0, 0, 0, 0);
    }
}
    