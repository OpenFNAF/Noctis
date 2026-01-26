package net.openfnaf.framework.camera;

import com.badlogic.gdx.utils.ObjectMap;
import net.openfnaf.framework.game.GameState;
import net.openfnaf.framework.registry.GameRegistry;
import net.openfnaf.framework.world.CameraNode;

public class CameraSystem {
    private final GameRegistry registry;

    public CameraSystem(GameRegistry registry) {
        this.registry = registry;
    }

    public CameraNode getCameraByIndex(int index) {
        ObjectMap<String, CameraNode> cameras = registry.getCameras();
        if (cameras.size == 0) {
            return null;
        }
        int clamped = Math.max(0, Math.min(index, cameras.size - 1));
        int i = 0;
        for (ObjectMap.Entry<String, CameraNode> entry : cameras) {
            if (i == clamped) {
                return entry.value;
            }
            i++;
        }
        return null;
    }

    public String getCameraIdByIndex(int index) {
        CameraNode node = getCameraByIndex(index);
        return node == null ? null : node.getId();
    }

    public int clampIndex(int index) {
        int size = registry.getCameras().size;
        if (size == 0) {
            return 0;
        }
        return Math.max(0, Math.min(index, size - 1));
    }

    public void selectCamera(GameState state, int index) {
        state.setCameraIndex(clampIndex(index));
    }
}
