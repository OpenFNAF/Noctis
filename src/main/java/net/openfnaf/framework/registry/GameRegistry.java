package net.openfnaf.framework.registry;

import com.badlogic.gdx.utils.ObjectMap;
import net.openfnaf.framework.ai.Animatronic;
import net.openfnaf.framework.world.CameraNode;
import net.openfnaf.framework.world.Room;

public final class GameRegistry {
    private final ObjectMap<String, Animatronic> animatronics = new ObjectMap<>();
    private final ObjectMap<String, Room> rooms = new ObjectMap<>();
    private final ObjectMap<String, CameraNode> cameras = new ObjectMap<>();

    public void registerAnimatronic(Animatronic animatronic) {
        animatronics.put(animatronic.getId(), animatronic);
    }

    public void registerRoom(Room room) {
        rooms.put(room.getId(), room);
    }

    public void registerCamera(CameraNode camera) {
        cameras.put(camera.getId(), camera);
    }

    public ObjectMap<String, Animatronic> getAnimatronics() {
        return animatronics;
    }

    public ObjectMap<String, Room> getRooms() {
        return rooms;
    }

    public ObjectMap<String, CameraNode> getCameras() {
        return cameras;
    }
}
