package net.openfnaf.framework.game;

public class NightSystem {
    private final float hourDurationSeconds;
    private NightEvents events;

    public NightSystem(float hourDurationSeconds) {
        this.hourDurationSeconds = hourDurationSeconds;
    }

    public void setEvents(NightEvents events) {
        this.events = events;
    }

    public void update(float delta, GameState state) {
        state.setNightTimer(state.getNightTimer() + delta);
        int hoursPassed = (int) (state.getNightTimer() / hourDurationSeconds);
        if (hoursPassed >= 6) {
            if (events != null) {
                events.onNightComplete(state.getNight());
            }
            return;
        }
        state.setHour(hoursPassed == 0 ? 12 : hoursPassed);
    }
}
