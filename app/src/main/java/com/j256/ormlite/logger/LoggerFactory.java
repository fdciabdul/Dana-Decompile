package com.j256.ormlite.logger;

import com.j256.ormlite.logger.Log;

/* loaded from: classes8.dex */
public class LoggerFactory {
    public static final String LOG_TYPE_SYSTEM_PROPERTY = "com.j256.ormlite.logger.type";
    private static LogType logType;

    private LoggerFactory() {
    }

    public static Logger getLogger(Class<?> cls) {
        return getLogger(cls.getName());
    }

    public static Logger getLogger(String str) {
        if (logType == null) {
            logType = findLogType();
        }
        return new Logger(logType.createLog(str));
    }

    public static String getSimpleClassName(String str) {
        String[] split = str.split("\\.");
        return split.length <= 1 ? str : split[split.length - 1];
    }

    private static LogType findLogType() {
        String property = System.getProperty(LOG_TYPE_SYSTEM_PROPERTY);
        if (property != null) {
            try {
                return LogType.valueOf(property);
            } catch (IllegalArgumentException unused) {
                LocalLog localLog = new LocalLog(LoggerFactory.class.getName());
                Log.Level level = Log.Level.WARNING;
                StringBuilder sb = new StringBuilder();
                sb.append("Could not find valid log-type from system property 'com.j256.ormlite.logger.type', value '");
                sb.append(property);
                sb.append("'");
                localLog.log(level, sb.toString());
            }
        }
        for (LogType logType2 : LogType.values()) {
            if (logType2.isAvailable()) {
                return logType2;
            }
        }
        return LogType.LOCAL;
    }

    /* loaded from: classes8.dex */
    public enum LogType {
        SLF4J("org.slf4j.LoggerFactory", "com.j256.ormlite.logger.Slf4jLoggingLog"),
        ANDROID("android.util.Log", "com.j256.ormlite.android.AndroidLog"),
        COMMONS_LOGGING("org.apache.commons.logging.LogFactory", "com.j256.ormlite.logger.CommonsLoggingLog"),
        LOG4J2("org.apache.logging.log4j.LogManager", "com.j256.ormlite.logger.Log4j2Log"),
        LOG4J("org.apache.log4j.Logger", "com.j256.ormlite.logger.Log4jLog"),
        LOCAL(LocalLog.class.getName(), LocalLog.class.getName()) { // from class: com.j256.ormlite.logger.LoggerFactory.LogType.1
            @Override // com.j256.ormlite.logger.LoggerFactory.LogType
            public final boolean isAvailable() {
                return true;
            }

            @Override // com.j256.ormlite.logger.LoggerFactory.LogType
            public final Log createLog(String str) {
                return new LocalLog(str);
            }
        };

        private final String detectClassName;
        private final String logClassName;

        LogType(String str, String str2) {
            this.detectClassName = str;
            this.logClassName = str2;
        }

        public Log createLog(String str) {
            try {
                return createLogFromClassName(str);
            } catch (Exception e) {
                LocalLog localLog = new LocalLog(str);
                Log.Level level = Log.Level.WARNING;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to call constructor with single String argument for class ");
                sb.append(this.logClassName);
                sb.append(", so had to use local log: ");
                sb.append(e.getMessage());
                localLog.log(level, sb.toString());
                return localLog;
            }
        }

        public boolean isAvailable() {
            if (isAvailableTestClass()) {
                try {
                    createLogFromClassName(getClass().getName()).isLevelEnabled(Log.Level.INFO);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }

        private Log createLogFromClassName(String str) throws Exception {
            return (Log) Class.forName(this.logClassName).getConstructor(String.class).newInstance(str);
        }

        boolean isAvailableTestClass() {
            try {
                Class.forName(this.detectClassName);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }
}
