package net.openfnaf.framework.ai;

import com.badlogic.gdx.utils.Array;

public interface Animatronic {
    String getId();

    String getName();

    void setName(String name);

    int getAiLevel();

    void setAiLevel(int aiLevel);

    DoorSide getDoorSide();

    void setDoorSide(DoorSide side);

    Array<String> getRoute();

    void setRoute(Array<String> route);

    int getRouteIndex();

    void setRouteIndex(int index);

    float getMoveTimer();

    void setMoveTimer(float timer);

    float getAttackTimer();

    void setAttackTimer(float timer);

    float getMoveInterval();

    void setMoveInterval(float interval);

    float getAttackDelayMin();

    float getAttackDelayMax();

    void setAttackDelayRange(float min, float max);
}
