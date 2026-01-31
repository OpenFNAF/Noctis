package net.openfnaf.framework.ai;

import com.badlogic.gdx.utils.Array;

/**
 * The BaseAnimatronic class is an abstract representation of an animatronic entity in the game
 * framework. It serves as a base class for specific animatronic implementations by providing
 * core functionality and properties.
 * <p>
 * This class implements the Animatronic interface and encapsulates details such as identity,
 * AI configuration, movement patterns, attack timing and interactions with doors. It's intended
 * to be used as part of the animatronic system to simulate behavior and interactions within the game(s).
 */
public class BaseAnimatronic implements Animatronic {
    private final String id;
    private String name;
    private int aiLevel = 1;
    private DoorSide doorSide = DoorSide.LEFT;
    private Array<String> route = new Array<>();
    private int routeIndex = 0;
    private float moveTimer = 0f;
    private float attackTimer = 0f;
    private float moveInterval = 4f;
    private float attackDelayMin = 2f;
    private float attackDelayMax = 3f;

    public BaseAnimatronic(String id) {
        this.id = id;
    }

    public BaseAnimatronic(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAiLevel() {
        return aiLevel;
    }

    @Override
    public void setAiLevel(int aiLevel) {
        this.aiLevel = aiLevel;
    }

    @Override
    public DoorSide getDoorSide() {
        return doorSide;
    }

    @Override
    public void setDoorSide(DoorSide side) {
        this.doorSide = side;
    }

    @Override
    public Array<String> getRoute() {
        return route;
    }

    @Override
    public void setRoute(Array<String> route) {
        this.route = route == null ? new Array<>() : route;
    }

    @Override
    public int getRouteIndex() {
        return routeIndex;
    }

    @Override
    public void setRouteIndex(int index) {
        this.routeIndex = index;
    }

    @Override
    public float getMoveTimer() {
        return moveTimer;
    }

    @Override
    public void setMoveTimer(float timer) {
        this.moveTimer = timer;
    }

    @Override
    public float getAttackTimer() {
        return attackTimer;
    }

    @Override
    public void setAttackTimer(float timer) {
        this.attackTimer = timer;
    }

    @Override
    public float getMoveInterval() {
        return moveInterval;
    }

    @Override
    public void setMoveInterval(float interval) {
        this.moveInterval = interval;
    }

    @Override
    public float getAttackDelayMin() {
        return attackDelayMin;
    }

    @Override
    public float getAttackDelayMax() {
        return attackDelayMax;
    }

    @Override
    public void setAttackDelayRange(float min, float max) {
        this.attackDelayMin = min;
        this.attackDelayMax = max;
    }
}
