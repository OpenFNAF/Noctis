package net.openfnaf.framework;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import net.openfnaf.framework.utils.message.MessageManager;

/**
 * This is an abstract base class for the game framework, extending the functionality of the {@link Game} class.
 * Implementations of this class are expected to define configuration and screen registration logic.
 * This class is primarily responsible for managing core gameplay components such as configuration,
 * assets, rendering, and screen management.
 */
public abstract class NoctisGame extends Game {
    private FrameworkConfig config;
    private AssetManager assets;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Viewport viewport;
    private ScreenManager screenManager;
    private MessageManager messages;

    @Override
    public final void create() {
        config = createConfig();
        assets = new AssetManager();
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new FitViewport(config.getVirtualWidth(), config.getVirtualHeight(), camera);
        screenManager = new ScreenManager(this);
        registerScreens(screenManager);
        messages = new MessageManager(this);
        screenManager.show(config.getStartScreenId());
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        super.dispose();
        if (screenManager != null) {
            screenManager.disposeAll();
        }
        if (assets != null) {
            assets.dispose();
        }
        if (batch != null) {
            batch.dispose();
        }
    }

    protected abstract FrameworkConfig createConfig();

    protected abstract void registerScreens(ScreenManager screenManager);

    public FrameworkConfig getConfig() {
        return config;
    }

    public AssetManager getAssets() {
        return assets;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public ScreenManager getScreenManager() {
        return screenManager;
    }

    public MessageManager getMessageManager() {
        return messages;
    }
}
