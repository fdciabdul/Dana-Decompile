package org.yaml.snakeyaml.internal;

/* loaded from: classes6.dex */
public class Logger {
    public final java.util.logging.Logger PlaceComponentResult;

    /* loaded from: classes6.dex */
    public enum Level {
        WARNING(java.util.logging.Level.FINE);

        private final java.util.logging.Level level;

        Level(java.util.logging.Level level) {
            this.level = level;
        }
    }

    private Logger(String str) {
        this.PlaceComponentResult = java.util.logging.Logger.getLogger(str);
    }

    public static Logger KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        return new Logger(str);
    }

    public final boolean PlaceComponentResult(Level level) {
        return this.PlaceComponentResult.isLoggable(level.level);
    }
}
