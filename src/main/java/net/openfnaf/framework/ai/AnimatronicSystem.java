package net.openfnaf.framework.ai;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ObjectMap;
import java.util.Random;
import net.openfnaf.framework.game.GameState;
import net.openfnaf.framework.registry.GameRegistry;

public class AnimatronicSystem {
    private final GameRegistry registry;
    private final Random rng;
    private AnimatronicEvents events;

    public AnimatronicSystem(GameRegistry registry, Random rng) {
        this.registry = registry;
        this.rng = rng;
    }

    public void setEvents(AnimatronicEvents events) {
        this.events = events;
    }

    public void update(float delta, GameState state) {
        ObjectMap<String, Animatronic> animatronics = registry.getAnimatronics();
        for (ObjectMap.Entry<String, Animatronic> entry : animatronics) {
            Animatronic anim = entry.value;
            anim.setMoveTimer(anim.getMoveTimer() - delta);
            if (anim.getMoveTimer() <= 0f) {
                float jitter = rng.nextFloat() * 1.4f;
                anim.setMoveTimer(anim.getMoveInterval() + jitter);
                attemptMove(anim, state);
            }

            if (anim.getAttackTimer() > 0f) {
                anim.setAttackTimer(anim.getAttackTimer() - delta);
                if (anim.getAttackTimer() <= 0f && events != null) {
                    events.onAttack(anim);
                }
            }
        }
    }

    private void attemptMove(Animatronic anim, GameState state) {
        if (anim.getRoute().size == 0) {
            return;
        }
        int roll = rng.nextInt(20) + 1;
        if (roll > anim.getAiLevel()) {
            return;
        }
        if (anim.getRouteIndex() < anim.getRoute().size - 1) {
            anim.setRouteIndex(anim.getRouteIndex() + 1);
        }
        if (isAtDoor(anim)) {
            boolean doorClosed = anim.getDoorSide() == DoorSide.LEFT
                ? state.isLeftDoorClosed()
                : state.isRightDoorClosed();
            if (doorClosed) {
                reset(anim);
            } else {
                float delay = MathUtils.random(anim.getAttackDelayMin(), anim.getAttackDelayMax());
                anim.setAttackTimer(delay);
            }
        }
    }

    private boolean isAtDoor(Animatronic anim) {
        if (anim.getRoute().size == 0) {
            return false;
        }
        return anim.getRouteIndex() >= anim.getRoute().size - 1;
    }

    private void reset(Animatronic anim) {
        anim.setRouteIndex(0);
        anim.setAttackTimer(0f);
        anim.setMoveTimer(anim.getMoveInterval() + 1f);
    }
}
