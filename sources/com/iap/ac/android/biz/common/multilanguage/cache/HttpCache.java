package com.iap.ac.android.biz.common.multilanguage.cache;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.utils.MiscUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/* loaded from: classes8.dex */
public class HttpCache {
    public static final String CACHE_DIR = "ac_multi_language";
    public static final String TAG = "HttpCache";
    public static final Object writeLock = new Object();

    public static void clearInvalidCache(Context context) {
        synchronized (writeLock) {
            File cacheDir = getCacheDir(context);
            if (cacheDir == null) {
                return;
            }
            for (File file : cacheDir.listFiles()) {
                if (file.exists() && file.lastModified() + ConfigCenter.INSTANCE.getMultiLanguageCacheExpirationTime() < System.currentTimeMillis()) {
                    boolean delete = file.delete();
                    StringBuilder sb = new StringBuilder();
                    sb.append("HttpCache#clearInvalidCache delete");
                    sb.append(file.getName());
                    sb.append(",result=");
                    sb.append(delete);
                    ACLog.d(TAG, sb.toString());
                }
            }
        }
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                ACLog.e(TAG, Utils.e(th));
            }
        }
    }

    public static File createCacheFile(Context context, String str) {
        File cacheDir = getCacheDir(context);
        if (cacheDir == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cacheDir.getAbsolutePath());
        sb.append(File.separator);
        sb.append(str);
        File file = new File(sb.toString());
        boolean z = true;
        if (!file.exists()) {
            try {
                z = file.createNewFile();
            } catch (Throwable th) {
                ACLog.e(TAG, String.format("Create %s error, the error=%s", str, Utils.e(th)));
            }
        }
        if (z) {
            return file;
        }
        return null;
    }

    public static String generateFileName(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        return MiscUtils.md5(sb.toString());
    }

    public static File getCacheDir(Context context) {
        if (context == null) {
            return null;
        }
        File cacheDir = context.getCacheDir();
        if (cacheDir.canWrite()) {
            StringBuilder sb = new StringBuilder();
            sb.append(cacheDir.getAbsolutePath());
            sb.append(File.separator);
            sb.append(CACHE_DIR);
            File file = new File(sb.toString());
            if (file.exists() ? true : file.mkdir()) {
                return file;
            }
            return null;
        }
        return null;
    }

    public static File getCacheFile(Context context, String str) {
        File cacheDir = getCacheDir(context);
        if (cacheDir == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cacheDir.getAbsolutePath());
        sb.append(File.separator);
        sb.append(str);
        File file = new File(sb.toString());
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public static String queryCache(Context context, String str, String str2) {
        File cacheFile = getCacheFile(context, generateFileName(str, str2));
        if (cacheFile == null) {
            return "";
        }
        return ConfigCenter.INSTANCE.getMultiLanguageCacheExpirationTime() + cacheFile.lastModified() > System.currentTimeMillis() ? read(cacheFile) : "";
    }

    public static String queryCacheAndClearInvalidCache(Context context, String str, String str2) {
        clearInvalidCache(context);
        return queryCache(context, str, str2);
    }

    public static String read(File file) {
        Throwable th;
        BufferedReader bufferedReader;
        if (file == null || !file.exists()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        ACLog.e(TAG, String.format("Read str error, error=%s", Utils.e(th)));
                        return sb.toString();
                    } finally {
                        close(bufferedReader);
                    }
                }
            }
            close(bufferedReader);
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        return sb.toString();
    }

    public static boolean saveCache(Context context, String str, String str2, String str3) {
        synchronized (writeLock) {
            File createCacheFile = createCacheFile(context, generateFileName(str, str2));
            if (createCacheFile == null) {
                return false;
            }
            return write(createCacheFile, str3);
        }
    }

    public static boolean write(File file, String str) {
        Throwable th;
        BufferedWriter bufferedWriter;
        if (file == null || !file.exists()) {
            return false;
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter = null;
        }
        try {
            bufferedWriter.write(str);
            return true;
        } catch (Throwable th3) {
            th = th3;
            try {
                ACLog.e(TAG, String.format("Write str error, error=%s", Utils.e(th)));
                return false;
            } finally {
                close(bufferedWriter);
            }
        }
    }
}
