package net.openfnaf.framework.power;

import net.openfnaf.framework.game.GameState;

public class PowerSystem {
    private static final int MIN_USAGE = 1;
    private static final int MAX_USAGE = 4;

    private float baseDrain = 0.08f;
    private float drainScale = 10f;
    private float[] usageMultipliers = {1f, 1.5f, 2f, 3f};

    public void update(float delta, GameState state) {
        if (state.isPowerOut()) {
            return;
        }
        int usage = computeUsage(state);
        float multiplier = usageMultipliers[usage - 1];
        float drainRate = baseDrain * multiplier;
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

    public int computeUsage(GameState state) {
        int usage = MIN_USAGE;
        if (state.isLeftDoorClosed() || state.isRightDoorClosed()) {
            usage++;
        }
        if (state.isLeftLightOn() || state.isRightLightOn()) {
            usage++;
        }
        if (state.isCamerasUp()) {
            usage++;
        }
        return Math.max(MIN_USAGE, Math.min(usage, MAX_USAGE));
    }

    public void setBaseDrain(float baseDrain) {
        this.baseDrain = baseDrain;
    }

    public void setDrainScale(float drainScale) {
        this.drainScale = drainScale;
    }

    public void setUsageMultipliers(float[] usageMultipliers) {
        if (usageMultipliers == null || usageMultipliers.length < MAX_USAGE) {
            throw new IllegalArgumentException("usageMultipliers must have at least " + MAX_USAGE + " entries.");
        }
        this.usageMultipliers = usageMultipliers;
    }
}
