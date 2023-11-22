package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes8.dex */
public abstract class FileUtil {
    public static final String LOCAL_REPORT_FILE = "hms/HwMobileServiceReport.txt";
    public static final String LOCAL_REPORT_FILE_CONFIG = "hms/config.txt";
    public static final long LOCAL_REPORT_FILE_MAX_SIZE = 10240;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7508a;
    public static ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor();

    /* loaded from: classes8.dex */
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f7509a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;

        public a(File file, long j, String str) {
            this.f7509a = file;
            this.b = j;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RandomAccessFile randomAccessFile;
            Throwable th;
            File file = this.f7509a;
            if (file == null) {
                HMSLog.e("FileUtil", "In writeFile Failed to get local file.");
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && (parentFile.mkdirs() || parentFile.isDirectory())) {
                RandomAccessFile randomAccessFile2 = null;
                try {
                    try {
                        long length = this.f7509a.length();
                        if (length > this.b) {
                            String canonicalPath = this.f7509a.getCanonicalPath();
                            if (!this.f7509a.delete()) {
                                HMSLog.e("FileUtil", "last file delete failed.");
                            }
                            randomAccessFile2 = new RandomAccessFile(new File(canonicalPath), "rw");
                        } else {
                            randomAccessFile = new RandomAccessFile(this.f7509a, "rw");
                            try {
                                randomAccessFile.seek(length);
                                randomAccessFile2 = randomAccessFile;
                            } catch (IOException e) {
                                e = e;
                                randomAccessFile2 = randomAccessFile;
                                HMSLog.e("FileUtil", "writeFile exception:", e);
                                IOUtils.closeQuietly(randomAccessFile2);
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                IOUtils.closeQuietly(randomAccessFile);
                                throw th;
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.c);
                        sb.append(System.getProperty("line.separator"));
                        randomAccessFile2.writeBytes(sb.toString());
                    } catch (Throwable th3) {
                        randomAccessFile = randomAccessFile2;
                        th = th3;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
                IOUtils.closeQuietly(randomAccessFile2);
                return;
            }
            HMSLog.e("FileUtil", "In writeFile, Failed to create directory.");
        }
    }

    public static boolean verifyHash(String str, File file) {
        byte[] digest = SHA256.digest(file);
        return digest != null && HEX.encodeHexString(digest, true).equalsIgnoreCase(str);
    }

    public static void writeFile(File file, String str, long j) {
        b.execute(new a(file, j, str));
    }

    public static void writeFileReport(Context context, File file, File file2, String str, long j, int i) {
        if (file != null && file.isFile() && file.exists()) {
            if (!f7508a) {
                if (file2 != null && file2.exists() && !file2.delete()) {
                    HMSLog.e("FileUtil", "file delete failed.");
                }
                f7508a = true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(j);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(i);
            writeFile(file2, sb.toString(), LOCAL_REPORT_FILE_MAX_SIZE);
        }
    }
}
