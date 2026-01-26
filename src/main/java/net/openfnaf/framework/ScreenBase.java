package net.openfnaf.framework;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class ScreenBase extends ScreenAdapter {
    protected final NoctisGame game;
    protected final FrameworkConfig config;
    protected final AssetManager assets;
    protected final SpriteBatch batch;
    protected final OrthographicCamera camera;
    protected final Viewport viewport;
    protected final Stage stage;

    protected ScreenBase(NoctisGame game) {
        this.game = game;
        this.config = game.getConfig();
        this.assets = game.getAssets();
        this.batch = game.getBatch();
        this.camera = game.getCamera();
        this.viewport = game.getViewport();
        this.stage = new Stage(viewport, batch);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
