package com.j256.ormlite.logger;

/* loaded from: classes8.dex */
public interface Log {
    boolean isLevelEnabled(Level level);

    void log(Level level, String str);

    void log(Level level, String str, Throwable th);

    /* loaded from: classes8.dex */
    public enum Level {
        TRACE(1),
        DEBUG(2),
        INFO(3),
        WARNING(4),
        ERROR(5),
        FATAL(6);

        private int level;

        Level(int i) {
            this.level = i;
        }

        public final boolean isEnabled(Level level) {
            return this.level <= level.level;
        }
    }
}
