package com.j256.ormlite.logger;

import com.j256.ormlite.logger.Log;
import com.j256.ormlite.misc.IOUtils;
import id.dana.cashier.view.InputCardNumberView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes8.dex */
public class LocalLog implements Log {
    public static final String LOCAL_LOG_FILE_PROPERTY = "com.j256.ormlite.logger.file";
    public static final String LOCAL_LOG_LEVEL_PROPERTY = "com.j256.ormlite.logger.level";
    private static PrintStream printStream;
    private final String className;
    private final Log.Level level;
    private static final Log.Level DEFAULT_LEVEL = Log.Level.DEBUG;
    private static final ThreadLocal<DateFormat> dateFormatThreadLocal = new ThreadLocal<DateFormat>() { // from class: com.j256.ormlite.logger.LocalLog.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public final DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        }
    };
    public static final String LOCAL_LOG_PROPERTIES_FILE = "/ormliteLocalLog.properties";
    private static final List<PatternLevel> classLevels = readLevelResourceFile(LocalLog.class.getResourceAsStream(LOCAL_LOG_PROPERTIES_FILE));

    static {
        openLogFile(System.getProperty(LOCAL_LOG_FILE_PROPERTY));
    }

    public LocalLog(String str) {
        this.className = LoggerFactory.getSimpleClassName(str);
        List<PatternLevel> list = classLevels;
        Log.Level level = null;
        if (list != null) {
            for (PatternLevel patternLevel : list) {
                if (patternLevel.pattern.matcher(str).matches() && (level == null || patternLevel.level.ordinal() < level.ordinal())) {
                    level = patternLevel.level;
                }
            }
        }
        if (level == null) {
            String property = System.getProperty(LOCAL_LOG_LEVEL_PROPERTY);
            if (property == null) {
                level = DEFAULT_LEVEL;
            } else {
                try {
                    try {
                        level = Log.Level.valueOf(property.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Level '");
                        sb.append(property);
                        sb.append("' was not found");
                        throw new IllegalArgumentException(sb.toString(), e);
                    }
                } catch (IllegalArgumentException unused) {
                    level = Log.Level.valueOf(property.toUpperCase(Locale.ENGLISH));
                }
            }
        }
        this.level = level;
    }

    public static void openLogFile(String str) {
        if (str == null) {
            printStream = System.out;
            return;
        }
        try {
            printStream = new PrintStream(new File(str));
        } catch (FileNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Log file ");
            sb.append(str);
            sb.append(" was not found");
            throw new IllegalArgumentException(sb.toString(), e);
        }
    }

    @Override // com.j256.ormlite.logger.Log
    public boolean isLevelEnabled(Log.Level level) {
        return this.level.isEnabled(level);
    }

    @Override // com.j256.ormlite.logger.Log
    public void log(Log.Level level, String str) {
        printMessage(level, str, null);
    }

    @Override // com.j256.ormlite.logger.Log
    public void log(Log.Level level, String str, Throwable th) {
        printMessage(level, str, th);
    }

    void flush() {
        printStream.flush();
    }

    static List<PatternLevel> readLevelResourceFile(InputStream inputStream) {
        try {
            if (inputStream != null) {
                return configureClassLevels(inputStream);
            }
        } catch (IOException e) {
            PrintStream printStream2 = System.err;
            StringBuilder sb = new StringBuilder();
            sb.append("IO exception reading the log properties file '/ormliteLocalLog.properties': ");
            sb.append(e);
            printStream2.println(sb.toString());
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        return null;
    }

    private static List<PatternLevel> configureClassLevels(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            if (readLine.length() != 0 && readLine.charAt(0) != '#') {
                String[] split = readLine.split("=");
                if (split.length != 2) {
                    PrintStream printStream2 = System.err;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Line is not in the format of 'pattern = level': ");
                    sb.append(readLine);
                    printStream2.println(sb.toString());
                } else {
                    try {
                        arrayList.add(new PatternLevel(Pattern.compile(split[0].trim()), Log.Level.valueOf(split[1].trim())));
                    } catch (IllegalArgumentException unused) {
                        PrintStream printStream3 = System.err;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Level '");
                        sb2.append(split[1]);
                        sb2.append("' was not found");
                        printStream3.println(sb2.toString());
                    }
                }
            }
        }
    }

    private void printMessage(Log.Level level, String str, Throwable th) {
        if (isLevelEnabled(level)) {
            StringBuilder sb = new StringBuilder(128);
            sb.append(dateFormatThreadLocal.get().format(new Date()));
            sb.append(" [");
            sb.append(level.name());
            sb.append("] ");
            sb.append(this.className);
            sb.append(InputCardNumberView.DIVIDER);
            sb.append(str);
            printStream.println(sb.toString());
            if (th != null) {
                th.printStackTrace(printStream);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class PatternLevel {
        Log.Level level;
        Pattern pattern;

        public PatternLevel(Pattern pattern, Log.Level level) {
            this.pattern = pattern;
            this.level = level;
        }
    }
}
