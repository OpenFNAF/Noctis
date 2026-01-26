package net.openfnaf.framework;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class NoctisGame extends Game {
    private FrameworkConfig config;
    private AssetManager assets;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Viewport viewport;
    private ScreenManager screens;

    @Override
    public final void create() {
        config = createConfig();
        assets = new AssetManager();
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new FitViewport(config.getVirtualWidth(), config.getVirtualHeight(), camera);
        screens = new ScreenManager(this);
        registerScreens(screens);
        screens.show(config.getStartScreenId());
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        super.dispose();
        if (screens != null) {
            screens.disposeAll();
        }
        if (assets != null) {
            assets.dispose();
        }
        if (batch != null) {
            batch.dispose();
        }
    }

    protected abstract FrameworkConfig createConfig();

    protected abstract void registerScreens(ScreenManager screens);

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

    public ScreenManager getScreens() {
        return screens;
    }
}
