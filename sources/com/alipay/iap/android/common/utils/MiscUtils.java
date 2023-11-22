package com.alipay.iap.android.common.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.TypedValue;
import com.alibaba.griver.base.common.utils.MD5Util;
import com.alipay.iap.android.common.log.LoggerWrapper;
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

/* loaded from: classes.dex */
public class MiscUtils {
    private static int PlaceComponentResult = 1;
    private static final String TAG = "MiscUtils";
    private static int getAuthRequestContext;

    private MiscUtils() {
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
            LoggerWrapper.e("MiscUtils", "Calculate MD5 Error!", e);
            return "";
        }
    }

    public static String getAssetContent(Context context, String str) {
        Throwable th;
        BufferedReader bufferedReader;
        IOException e;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            try {
            } catch (IOException e2) {
                e = e2;
            }
            try {
                Object[] objArr = {context.getAssets(), str};
                Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                if (obj == null) {
                    obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (58133 - TextUtils.indexOf("", "")), (-1) - TextUtils.lastIndexOf("", '0'), 49 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                }
                bufferedReader = new BufferedReader(new InputStreamReader((InputStream) ((Method) obj).invoke(null, objArr)));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (!(readLine != null)) {
                            try {
                                break;
                            } catch (Exception e3) {
                                throw e3;
                            }
                        }
                        int i = getAuthRequestContext + 65;
                        PlaceComponentResult = i % 128;
                        if (!(i % 2 == 0)) {
                            sb.append(readLine);
                            sb.append("\r\n");
                        } else {
                            sb.append(readLine);
                            sb.append("\r\n");
                            int i2 = 5 / 0;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        bufferedReader2 = bufferedReader;
                        LoggerWrapper.e("MiscUtils", "getAssetContent Error!", e);
                        close(bufferedReader2);
                        String obj2 = sb.toString();
                        int i3 = PlaceComponentResult + 3;
                        getAuthRequestContext = i3 % 128;
                        int i4 = i3 % 2;
                        return obj2;
                    } catch (Throwable th2) {
                        th = th2;
                        close(bufferedReader);
                        throw th;
                    }
                }
                close(bufferedReader);
                String obj22 = sb.toString();
                try {
                    int i32 = PlaceComponentResult + 3;
                    getAuthRequestContext = i32 % 128;
                    int i42 = i32 % 2;
                    return obj22;
                } catch (Exception e5) {
                    throw e5;
                }
            } catch (Throwable th3) {
                Throwable cause = th3.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th3;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    public static void close(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            LoggerWrapper.w("MiscUtils", "Take it easy, just cannot close stream.", e);
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getVersionName error! message: ");
            sb.append(e.getMessage());
            LoggerWrapper.e("MiscUtils", sb.toString());
            return null;
        }
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getVersionCode error! message: ");
            sb.append(e.getMessage());
            LoggerWrapper.e("MiscUtils", sb.toString());
            return 0;
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
            StringBuilder sb = new StringBuilder();
            sb.append("isDebuggable error: ");
            sb.append(e.getMessage());
            LoggerWrapper.e("MiscUtils", sb.toString());
            return false;
        }
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean isMainProcess(Context context) {
        try {
            return context.getPackageName().equals(getCurrentProcessName(context));
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("isMainProcess error: ");
            sb.append(th.toString());
            LoggerWrapper.e("MiscUtils", sb.toString());
            return false;
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

    public static boolean isClassValid(String str) {
        try {
            return Class.forName(str) != null;
        } catch (ClassNotFoundException unused) {
            LoggerWrapper.d("MiscUtils", String.format("Take it easy, class %s not found!", str));
            return false;
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
            LoggerWrapper.e("MiscUtils", "getApkSignatureMd5 error!", e);
            return null;
        }
    }
}
