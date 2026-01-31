package net.openfnaf.framework.utils.message;

import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.openfnaf.framework.NoctisGame;

public class MessageManager {
    private final NoctisGame game;
    private final Map<String, String> messages = new HashMap<>();

    public MessageManager(NoctisGame game) {
        this.game = game;
    }

    public NoctisGame getGame() {
        return game;
    }

    public Map<String, String> getMessages() {
        return messages;
    }

    public MessageContainer container(String id, ArrayList<String> args) {
        return new MessageContainer(this, id, args);
    }

    public MessageContainer container(String id, String... args) {
        ArrayList<String> list = new ArrayList<>();
        if (args != null) {
            java.util.Collections.addAll(list, args);
        }
        return new MessageContainer(this, id, list);
    }

    public String getMessage(MessageContainer container) {
        return getMessage(container.getId(), container.getArgs());
    }

    public String getMessage(String id, ArrayList<String> args) {
        String message = messages.get(id);
        if (message == null) {
            message = "Message (" + id + ") not found";
        }
        if (args != null) {
            for (int i = 0; i < args.size(); i++) {
                message = message.replace("{" + i + "}", args.get(i));
            }
        }
        return message;
    }

    public String getMessage(String id, String... args) {
        ArrayList<String> list = new ArrayList<>();
        if (args != null) {
            java.util.Collections.addAll(list, args);
        }
        return getMessage(id, list);
    }

    public void init(String path) throws IOException {
        Map<String, String> loaded = loadMessages(openStream(path));
        messages.clear();
        messages.putAll(loaded);
    }

    private InputStream openStream(String path) throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (loader == null) {
            loader = MessageManager.class.getClassLoader();
        }
        InputStream stream = loader.getResourceAsStream(path);
        if (stream != null) {
            return stream;
        }
        File file = new File(path);
        if (file.exists()) {
            return new FileInputStream(file);
        }
        throw new IOException("Message file not found: " + path);
    }

    private static Map<String, String> loadMessages(InputStream input) throws IOException {
        JsonValue root = new JsonReader().parse(new InputStreamReader(input, StandardCharsets.UTF_8));
        if (!root.isObject()) {
            throw new IOException("Message JSON must be an object.");
        }
        Map<String, String> messages = new HashMap<>();
        flatten(root, "", messages);
        return messages;
    }

    private static void flatten(JsonValue node, String prefix, Map<String, String> output) throws IOException {
        for (JsonValue value = node.child; value != null; value = value.next) {
            String key = prefix.isEmpty() ? value.name : prefix + "." + value.name;
            if (value.isObject()) {
                flatten(value, key, output);
            } else if (value.isArray()) {
                throw new IOException("Arrays are not supported in message JSON for key: " + key);
            } else {
                output.put(key, value.asString());
            }
        }
    }
}
