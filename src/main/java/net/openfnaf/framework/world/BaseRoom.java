package net.openfnaf.framework.world;

public class BaseRoom implements Room {
    private final String id;
    private String name;
    private String texturePath;

    public BaseRoom(String id) {
        this.id = id;
    }

    public BaseRoom(String id, String name, String texturePath) {
        this.id = id;
        this.name = name;
        this.texturePath = texturePath;
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
    public String getTexturePath() {
        return texturePath;
    }

    @Override
    public void setTexturePath(String texturePath) {
        this.texturePath = texturePath;
    }
}
