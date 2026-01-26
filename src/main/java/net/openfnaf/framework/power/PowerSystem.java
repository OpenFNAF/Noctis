package net.openfnaf.framework.power;

import net.openfnaf.framework.game.GameState;

public class PowerSystem {
    private float baseDrain = 0.08f;
    private float doorDrain = 0.14f;
    private float lightDrain = 0.08f;
    private float cameraDrain = 0.12f;
    private float drainScale = 10f;

    public void update(float delta, GameState state) {
        if (state.isPowerOut()) {
            return;
        }
        float drainRate = baseDrain;
        if (state.isLeftDoorClosed()) {
            drainRate += doorDrain;
        }
        if (state.isRightDoorClosed()) {
            drainRate += doorDrain;
        }
        if (state.isLeftLightOn()) {
            drainRate += lightDrain;
        }
        if (state.isRightLightOn()) {
            drainRate += lightDrain;
        }
        if (state.isCamerasUp()) {
            drainRate += cameraDrain;
        }
        float nextPower = Math.max(0f, state.getPower() - drainRate * delta * drainScale);
        state.setPower(nextPower);
        if (nextPower <= 0f) {
            state.setPowerOut(true);
            state.setLeftDoorClosed(false);
            state.setRightDoorClosed(false);
            state.setLeftLightOn(false);
            state.setRightLightOn(false);
            state.setCamerasUp(false);
        }
    }

    public void setBaseDrain(float baseDrain) {
        this.baseDrain = baseDrain;
    }

    public void setDoorDrain(float doorDrain) {
        this.doorDrain = doorDrain;
    }

    public void setLightDrain(float lightDrain) {
        this.lightDrain = lightDrain;
    }

    public void setCameraDrain(float cameraDrain) {
        this.cameraDrain = cameraDrain;
    }

    public void setDrainScale(float drainScale) {
        this.drainScale = drainScale;
    }
}
