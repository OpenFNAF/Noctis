package net.openfnaf.framework.utils.message;

import java.util.ArrayList;

public class MessageContainer {
    private final MessageManager manager;
    private final String id;
    private final ArrayList<String> args;

    public MessageContainer(MessageManager manager, String id, ArrayList<String> args) {
        this.manager = manager;
        this.id = id;
        this.args = args == null ? new ArrayList<>() : args;
    }

    public String getId() {
        return id;
    }

    public ArrayList<String> getArgs() {
        return args;
    }

    public String getMessage() {
        return manager.getMessage(this);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
