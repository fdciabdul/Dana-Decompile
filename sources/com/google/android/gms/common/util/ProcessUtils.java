package com.google.android.gms.common.util;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.internal.Preconditions;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class ProcessUtils {
    @Nullable
    private static String zza;
    private static int zzb;

    private ProcessUtils() {
    }

    public static String getMyProcessName() {
        String str;
        String obj;
        StrictMode.ThreadPolicy allowThreadDiskReads;
        if (zza == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                zza = Application.getProcessName();
            } else {
                int i = zzb;
                if (i == 0) {
                    i = Process.myPid();
                    zzb = i;
                }
                String str2 = null;
                String str3 = null;
                BufferedReader bufferedReader = null;
                BufferedReader bufferedReader2 = null;
                if (i > 0) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append("/proc/");
                        sb.append(i);
                        sb.append("/cmdline");
                        obj = sb.toString();
                        allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    } catch (IOException unused) {
                        str = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        BufferedReader bufferedReader3 = new BufferedReader(new FileReader(obj));
                        try {
                            String readLine = bufferedReader3.readLine();
                            Preconditions.checkNotNull(readLine);
                            str3 = readLine.trim();
                        } catch (IOException unused2) {
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader3;
                            IOUtils.closeQuietly(bufferedReader2);
                            throw th;
                        }
                        str = str3;
                        bufferedReader = bufferedReader3;
                        IOUtils.closeQuietly(bufferedReader);
                        str2 = str;
                    } finally {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                    }
                }
                zza = str2;
            }
        }
        return zza;
    }
}
