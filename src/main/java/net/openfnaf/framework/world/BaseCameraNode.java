package net.openfnaf.framework.world;

public class BaseCameraNode implements CameraNode {
    private final String id;
    private String label;
    private String roomId;

    public BaseCameraNode(String id) {
        this.id = id;
    }

    public BaseCameraNode(String id, String label, String roomId) {
        this.id = id;
        this.label = label;
        this.roomId = roomId;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getRoomId() {
        return roomId;
    }

    @Override
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
