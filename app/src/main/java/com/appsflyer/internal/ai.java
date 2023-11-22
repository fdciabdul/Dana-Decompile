package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ai {
    private static ai AFInAppEventType = new ai();

    private ai() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ai AFKeystoreWrapper() {
        return AFInAppEventType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File AFKeystoreWrapper(Context context) {
        return new File(context.getFilesDir(), "AFRequestCache");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<h> AFInAppEventParameterName(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(context.getFilesDir(), "AFRequestCache");
            if (!file.exists()) {
                file.mkdir();
            } else {
                for (File file2 : file.listFiles()) {
                    StringBuilder sb = new StringBuilder("Found cached request");
                    sb.append(file2.getName());
                    AFLogger.AFKeystoreWrapper(sb.toString());
                    arrayList.add(AFInAppEventParameterName(file2));
                }
            }
        } catch (Exception e) {
            AFLogger.AFInAppEventType("Could not cache request", e);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h AFInAppEventParameterName(File file) {
        FileReader fileReader;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(file);
        } catch (Exception unused) {
            fileReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            char[] cArr = new char[(int) file.length()];
            fileReader.read(cArr);
            h hVar = new h(cArr);
            hVar.valueOf = file.getName();
            try {
                fileReader.close();
            } catch (IOException e) {
                AFLogger.values(e);
            }
            return hVar;
        } catch (Exception unused2) {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e2) {
                    AFLogger.values(e2);
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileReader2 = fileReader;
            if (fileReader2 != null) {
                try {
                    fileReader2.close();
                } catch (IOException e3) {
                    AFLogger.values(e3);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void valueOf(String str, Context context) {
        File file = new File(new File(context.getFilesDir(), "AFRequestCache"), str);
        StringBuilder sb = new StringBuilder("Deleting ");
        sb.append(str);
        sb.append(" from cache");
        AFLogger.AFKeystoreWrapper(sb.toString());
        if (file.exists()) {
            try {
                file.delete();
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder("Could not delete ");
                sb2.append(str);
                sb2.append(" from cache");
                AFLogger.AFInAppEventType(sb2.toString(), e);
            }
        }
    }
}
