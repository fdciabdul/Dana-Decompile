package com.iap.ac.android.common.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.widget.ExpandableListView;
import com.alibaba.griver.base.common.utils.MD5Util;
import com.iap.ac.android.common.a.a;
import com.iap.ac.android.common.log.ACLog;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes3.dex */
public class MiscUtils {
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 1;
    public static final String TAG = "MiscUtils";

    public static void close(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            ACLog.w(TAG, "Take it easy, just cannot close stream.", e);
        }
    }

    public static String getApkSignatureMd5(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr != null && signatureArr.length != 0) {
                return md5(signatureArr[0].toByteArray());
            }
            return null;
        } catch (Exception e) {
            ACLog.e(TAG, "getApkSignatureMd5 error!", e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public static String getAssetContent(Context context, String str) {
        Throwable th;
        IOException e;
        StringBuilder sb = new StringBuilder();
        ?? r2 = 0;
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    Object[] objArr = {context.getAssets(), str};
                    Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                    if (obj == null) {
                        obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (58133 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), Process.myTid() >> 22, 49 - Color.blue(0))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                        NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                    }
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader((InputStream) ((Method) obj).invoke(null, objArr)));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (!(readLine != null)) {
                                break;
                            }
                            int i = MyBillsEntityDataFactory + 83;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                            if (i % 2 != 0) {
                                sb.append(readLine);
                                sb.append("\r\n");
                                int length = r2.length;
                            } else {
                                sb.append(readLine);
                                sb.append("\r\n");
                            }
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader = bufferedReader2;
                            ACLog.e(TAG, "getAssetContent Error!", e);
                            close(bufferedReader);
                            int i2 = MyBillsEntityDataFactory + 95;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                            int i3 = i2 % 2;
                            return sb.toString();
                        } catch (Throwable th2) {
                            th = th2;
                            r2 = bufferedReader2;
                            close(r2);
                            throw th;
                        }
                    }
                    close(bufferedReader2);
                } catch (Throwable th3) {
                    Throwable cause = th3.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th3;
                }
            } catch (IOException e3) {
                e = e3;
            }
            return sb.toString();
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static String getCurrentProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            StringBuilder a2 = a.a("getVersionCode error! message: ");
            a2.append(e.getMessage());
            ACLog.e(TAG, a2.toString());
            return 0;
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            StringBuilder a2 = a.a("getVersionName error! message: ");
            a2.append(th.getMessage());
            ACLog.e(TAG, a2.toString());
            return null;
        }
    }

    public static boolean isClassValid(String str) {
        try {
            return Class.forName(str) != null;
        } catch (ClassNotFoundException unused) {
            ACLog.d(TAG, String.format("Take it easy, class %s not found!", str));
            return false;
        }
    }

    public static boolean isDebuggable(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                return (applicationInfo.flags & 2) != 0;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            StringBuilder a2 = a.a("isDebuggable error: ");
            a2.append(e.getMessage());
            ACLog.e(TAG, a2.toString());
            return false;
        }
    }

    public static boolean isMainProcess(Context context) {
        try {
            return context.getPackageName().equals(getCurrentProcessName(context));
        } catch (Throwable th) {
            StringBuilder a2 = a.a("isMainProcess error: ");
            a2.append(th.toString());
            ACLog.e(TAG, a2.toString());
            return false;
        }
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String md5(String str) {
        return TextUtils.isEmpty(str) ? "" : md5(str.getBytes());
    }

    public static String md5(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance(MD5Util.ALGORIGTHM_MD5).digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            ACLog.e(TAG, "Calculate MD5 Error!", e);
            return "";
        }
    }
}
