package net.openfnaf.framework.game;

public class GameState {
    private int night = 1;
    private int hour = 12;
    private float nightTimer = 0f;
    private float power = 100f;
    private boolean powerOut = false;
    private boolean leftDoorClosed = false;
    private boolean rightDoorClosed = false;
    private boolean leftLightOn = false;
    private boolean rightLightOn = false;
    private boolean camerasUp = false;
    private int cameraIndex = 0;

    public int getNight() {
        return night;
    }

    public void setNight(int night) {
        this.night = night;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public float getNightTimer() {
        return nightTimer;
    }

    public void setNightTimer(float nightTimer) {
        this.nightTimer = nightTimer;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public boolean isPowerOut() {
        return powerOut;
    }

    public void setPowerOut(boolean powerOut) {
        this.powerOut = powerOut;
    }

    public boolean isLeftDoorClosed() {
        return leftDoorClosed;
    }

    public void setLeftDoorClosed(boolean leftDoorClosed) {
        this.leftDoorClosed = leftDoorClosed;
    }

    public boolean isRightDoorClosed() {
        return rightDoorClosed;
    }

    public void setRightDoorClosed(boolean rightDoorClosed) {
        this.rightDoorClosed = rightDoorClosed;
    }

    public boolean isLeftLightOn() {
        return leftLightOn;
    }

    public void setLeftLightOn(boolean leftLightOn) {
        this.leftLightOn = leftLightOn;
    }

    public boolean isRightLightOn() {
        return rightLightOn;
    }

    public void setRightLightOn(boolean rightLightOn) {
        this.rightLightOn = rightLightOn;
    }

    public boolean isCamerasUp() {
        return camerasUp;
    }

    public void setCamerasUp(boolean camerasUp) {
        this.camerasUp = camerasUp;
    }

    public int getCameraIndex() {
        return cameraIndex;
    }

    public void setCameraIndex(int cameraIndex) {
        this.cameraIndex = cameraIndex;
    }
}
