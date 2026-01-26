package net.openfnaf.framework.world;

public interface Room {
    String getId();

    String getName();

    void setName(String name);

    String getTexturePath();

    void setTexturePath(String texturePath);
}
