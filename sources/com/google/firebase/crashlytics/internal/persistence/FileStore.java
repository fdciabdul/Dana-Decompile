package com.google.firebase.crashlytics.internal.persistence;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class FileStore {
    private static final String CRASHLYTICS_PATH_V1 = ".com.google.firebase.crashlytics.files.v1";
    private static final String CRASHLYTICS_PATH_V2 = ".com.google.firebase.crashlytics.files.v2";
    private static final String NATIVE_REPORTS_PATH = "native-reports";
    private static final String NATIVE_SESSION_SUBDIR = "native";
    private static final String PRIORITY_REPORTS_PATH = "priority-reports";
    private static final String REPORTS_PATH = "reports";
    private static final String SESSIONS_PATH = "open-sessions";
    private final File crashlyticsDir;
    private final File filesDir;
    private final File nativeReportsDir;
    private final File priorityReportsDir;
    private final File reportsDir;
    private final File sessionsDir;

    public FileStore(Context context) {
        String str;
        File filesDir = context.getFilesDir();
        this.filesDir = filesDir;
        if (useV2FileSystem()) {
            StringBuilder sb = new StringBuilder();
            sb.append(CRASHLYTICS_PATH_V2);
            sb.append(File.pathSeparator);
            sb.append(sanitizeName(Application.getProcessName()));
            str = sb.toString();
        } else {
            str = CRASHLYTICS_PATH_V1;
        }
        File prepareBaseDir = prepareBaseDir(new File(filesDir, str));
        this.crashlyticsDir = prepareBaseDir;
        this.sessionsDir = prepareBaseDir(new File(prepareBaseDir, SESSIONS_PATH));
        this.reportsDir = prepareBaseDir(new File(prepareBaseDir, REPORTS_PATH));
        this.priorityReportsDir = prepareBaseDir(new File(prepareBaseDir, PRIORITY_REPORTS_PATH));
        this.nativeReportsDir = prepareBaseDir(new File(prepareBaseDir, NATIVE_REPORTS_PATH));
    }

    public void deleteAllCrashlyticsFiles() {
        recursiveDelete(this.crashlyticsDir);
    }

    public void cleanupPreviousFileSystems() {
        cleanupDir(new File(this.filesDir, ".com.google.firebase.crashlytics"));
        cleanupDir(new File(this.filesDir, ".com.google.firebase.crashlytics-ndk"));
        if (useV2FileSystem()) {
            cleanupDir(new File(this.filesDir, CRASHLYTICS_PATH_V1));
        }
    }

    private void cleanupDir(File file) {
        if (file.exists() && recursiveDelete(file)) {
            Logger logger = Logger.getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("Deleted previous Crashlytics file system: ");
            sb.append(file.getPath());
            logger.d(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean recursiveDelete(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                recursiveDelete(file2);
            }
        }
        return file.delete();
    }

    public File getCommonFile(String str) {
        return new File(this.crashlyticsDir, str);
    }

    public List<File> getCommonFiles(FilenameFilter filenameFilter) {
        return safeArrayToList(this.crashlyticsDir.listFiles(filenameFilter));
    }

    private File getSessionDir(String str) {
        return prepareDir(new File(this.sessionsDir, str));
    }

    public File getSessionFile(String str, String str2) {
        return new File(getSessionDir(str), str2);
    }

    public List<File> getSessionFiles(String str, FilenameFilter filenameFilter) {
        return safeArrayToList(getSessionDir(str).listFiles(filenameFilter));
    }

    public File getNativeSessionDir(String str) {
        return prepareDir(new File(getSessionDir(str), "native"));
    }

    public boolean deleteSessionFiles(String str) {
        return recursiveDelete(new File(this.sessionsDir, str));
    }

    public List<String> getAllOpenSessionIds() {
        return safeArrayToList(this.sessionsDir.list());
    }

    public File getReport(String str) {
        return new File(this.reportsDir, str);
    }

    public List<File> getReports() {
        return safeArrayToList(this.reportsDir.listFiles());
    }

    public File getPriorityReport(String str) {
        return new File(this.priorityReportsDir, str);
    }

    public List<File> getPriorityReports() {
        return safeArrayToList(this.priorityReportsDir.listFiles());
    }

    public File getNativeReport(String str) {
        return new File(this.nativeReportsDir, str);
    }

    public List<File> getNativeReports() {
        return safeArrayToList(this.nativeReportsDir.listFiles());
    }

    private static File prepareDir(File file) {
        file.mkdirs();
        return file;
    }

    private static File prepareBaseDir(File file) {
        synchronized (FileStore.class) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return file;
                }
                Logger logger = Logger.getLogger();
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected non-directory file: ");
                sb.append(file);
                sb.append("; deleting file and creating new directory.");
                logger.d(sb.toString());
                file.delete();
            }
            if (!file.mkdirs()) {
                Logger logger2 = Logger.getLogger();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not create Crashlytics-specific directory: ");
                sb2.append(file);
                logger2.e(sb2.toString());
            }
            return file;
        }
    }

    private static <T> List<T> safeArrayToList(T[] tArr) {
        return tArr == null ? Collections.emptyList() : Arrays.asList(tArr);
    }

    private static boolean useV2FileSystem() {
        return Build.VERSION.SDK_INT >= 28;
    }

    static String sanitizeName(String str) {
        return str.replaceAll("[^a-zA-Z0-9.]", "_");
    }
}
