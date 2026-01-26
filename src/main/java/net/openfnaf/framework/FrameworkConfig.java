package net.openfnaf.framework;

public final class FrameworkConfig {
    private final int virtualWidth;
    private final int virtualHeight;
    private final String startScreenId;
    private final boolean debug;

    private FrameworkConfig(Builder builder) {
        this.virtualWidth = builder.virtualWidth;
        this.virtualHeight = builder.virtualHeight;
        this.startScreenId = builder.startScreenId;
        this.debug = builder.debug;
    }

    public int getVirtualWidth() {
        return virtualWidth;
    }

    public int getVirtualHeight() {
        return virtualHeight;
    }

    public String getStartScreenId() {
        return startScreenId;
    }

    public boolean isDebug() {
        return debug;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private int virtualWidth = 1280;
        private int virtualHeight = 720;
        private String startScreenId = "boot";
        private boolean debug = false;

        public Builder virtualSize(int width, int height) {
            this.virtualWidth = width;
            this.virtualHeight = height;
            return this;
        }

        public Builder startScreenId(String startScreenId) {
            this.startScreenId = startScreenId;
            return this;
        }

        public Builder debug(boolean debug) {
            this.debug = debug;
            return this;
        }

        public FrameworkConfig build() {
            if (startScreenId == null || startScreenId.isBlank()) {
                throw new IllegalStateException("startScreenId must be set.");
            }
            return new FrameworkConfig(this);
        }
    }
}
