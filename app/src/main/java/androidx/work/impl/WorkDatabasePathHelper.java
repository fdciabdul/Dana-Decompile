package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.Logger;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class WorkDatabasePathHelper {
    private static final String getAuthRequestContext = Logger.MyBillsEntityDataFactory("WrkDbPathHelper");
    private static final String[] MyBillsEntityDataFactory = {"-journal", "-shm", "-wal"};

    public static String PlaceComponentResult() {
        return "androidx.work.workdb";
    }

    private WorkDatabasePathHelper() {
    }

    public static void MyBillsEntityDataFactory(Context context) {
        String format;
        File file;
        File databasePath = context.getDatabasePath("androidx.work.workdb");
        if (Build.VERSION.SDK_INT < 23 || !databasePath.exists()) {
            return;
        }
        Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
        HashMap hashMap = new HashMap();
        if (Build.VERSION.SDK_INT >= 23) {
            File databasePath2 = context.getDatabasePath("androidx.work.workdb");
            if (Build.VERSION.SDK_INT < 23) {
                file = context.getDatabasePath("androidx.work.workdb");
            } else {
                file = new File(context.getNoBackupFilesDir(), "androidx.work.workdb");
            }
            hashMap.put(databasePath2, file);
            for (String str : MyBillsEntityDataFactory) {
                StringBuilder sb = new StringBuilder();
                sb.append(databasePath2.getPath());
                sb.append(str);
                File file2 = new File(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(file.getPath());
                sb2.append(str);
                hashMap.put(file2, new File(sb2.toString()));
            }
        }
        for (File file3 : hashMap.keySet()) {
            File file4 = (File) hashMap.get(file3);
            if (file3.exists() && file4 != null) {
                if (file4.exists()) {
                    Logger.getAuthRequestContext().getAuthRequestContext(getAuthRequestContext, String.format("Over-writing contents of %s", file4), new Throwable[0]);
                }
                if (file3.renameTo(file4)) {
                    format = String.format("Migrated %s to %s", file3, file4);
                } else {
                    format = String.format("Renaming %s to %s failed", file3, file4);
                }
                Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, format, new Throwable[0]);
            }
        }
    }
}
