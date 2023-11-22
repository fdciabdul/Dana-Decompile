package com.j256.ormlite.logger;

import com.j256.ormlite.logger.Log;

/* loaded from: classes8.dex */
public class Slf4jLoggingLog implements Log {
    private final org.slf4j.Logger logger;

    public Slf4jLoggingLog(String str) {
        this.logger = org.slf4j.LoggerFactory.getLogger(str);
    }

    /* renamed from: com.j256.ormlite.logger.Slf4jLoggingLog$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$logger$Log$Level;

        static {
            int[] iArr = new int[Log.Level.values().length];
            $SwitchMap$com$j256$ormlite$logger$Log$Level = iArr;
            try {
                iArr[Log.Level.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.WARNING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.FATAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // com.j256.ormlite.logger.Log
    public boolean isLevelEnabled(Log.Level level) {
        switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$logger$Log$Level[level.ordinal()]) {
            case 1:
                return this.logger.isTraceEnabled();
            case 2:
                return this.logger.isDebugEnabled();
            case 3:
                return this.logger.isInfoEnabled();
            case 4:
                return this.logger.isWarnEnabled();
            case 5:
                return this.logger.isErrorEnabled();
            case 6:
                return this.logger.isErrorEnabled();
            default:
                return this.logger.isInfoEnabled();
        }
    }

    @Override // com.j256.ormlite.logger.Log
    public void log(Log.Level level, String str) {
        switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$logger$Log$Level[level.ordinal()]) {
            case 1:
                this.logger.trace(str);
                return;
            case 2:
                this.logger.debug(str);
                return;
            case 3:
                this.logger.info(str);
                return;
            case 4:
                this.logger.warn(str);
                return;
            case 5:
                this.logger.error(str);
                return;
            case 6:
                this.logger.error(str);
                return;
            default:
                this.logger.info(str);
                return;
        }
    }

    @Override // com.j256.ormlite.logger.Log
    public void log(Log.Level level, String str, Throwable th) {
        switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$logger$Log$Level[level.ordinal()]) {
            case 1:
                this.logger.trace(str, th);
                return;
            case 2:
                this.logger.debug(str, th);
                return;
            case 3:
                this.logger.info(str, th);
                return;
            case 4:
                this.logger.warn(str, th);
                return;
            case 5:
                this.logger.error(str, th);
                return;
            case 6:
                this.logger.error(str, th);
                return;
            default:
                this.logger.info(str, th);
                return;
        }
    }
}
