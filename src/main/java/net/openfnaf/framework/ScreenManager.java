package net.openfnaf.framework;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ObjectMap;

public final class ScreenManager {
    public interface ScreenProvider {
        Screen create();
    }

    private final Game game;
    private final ObjectMap<String, ScreenProvider> providers = new ObjectMap<>();
    private final ObjectMap<String, Screen> screens = new ObjectMap<>();
    private String currentId;

    public ScreenManager(Game game) {
        this.game = game;
    }

    public void register(String id, ScreenProvider provider) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Screen id must be set.");
        }
        if (provider == null) {
            throw new IllegalArgumentException("Screen provider must be set.");
        }
        providers.put(id, provider);
    }

    public boolean has(String id) {
        return providers.containsKey(id);
    }

    public void show(String id) {
        setScreen(id, false);
    }

    public void showAndDisposeCurrent(String id) {
        setScreen(id, true);
    }

    public void disposeAll() {
        for (ObjectMap.Entry<String, Screen> entry : screens) {
            entry.value.dispose();
        }
        screens.clear();
    }

    private void setScreen(String id, boolean disposeCurrent) {
        ScreenProvider provider = providers.get(id);
        if (provider == null) {
            throw new IllegalStateException("No screen registered with id: " + id);
        }
        Screen current = game.getScreen();
        Screen next = screens.get(id);
        if (next == null) {
            next = provider.create();
            screens.put(id, next);
        }
        game.setScreen(next);
        if (disposeCurrent && current != null) {
            if (currentId != null) {
                screens.remove(currentId);
            }
            current.dispose();
        }
        currentId = id;
    }
}
