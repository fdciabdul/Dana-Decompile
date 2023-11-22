package com.iap.ac.config.lite.d;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.alipay.iap.android.f2fpay.components.defaults.DefaultInitializeComponent;
import com.alipay.mobile.common.rpc.RpcException;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.utils.MiscUtils;
import com.iap.ac.config.lite.ConfigCenter;
import com.iap.ac.config.lite.ConfigCenterContext;
import com.iap.ac.config.lite.ConfigGetter;
import com.iap.ac.config.lite.common.AmcsConstants;
import com.iap.ac.config.lite.delegate.ConfigIdentifierProvider;
import com.iap.ac.config.lite.fetcher.FetchException;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class e {
    private static int MyBillsEntityDataFactory = 0;

    /* renamed from: a  reason: collision with root package name */
    private static final String f7632a = b("SdkUtils");
    private static int getAuthRequestContext = 1;

    public static FetchException a(Throwable th, boolean z) {
        Throwable undeclaredThrowable;
        while (!(th instanceof FetchException)) {
            if (th instanceof RpcException) {
                RpcException rpcException = (RpcException) th;
                return new FetchException(String.valueOf(rpcException.getCode()), a(rpcException.getMsg(), "unknown_rpc_exception"));
            } else if (!(th instanceof UndeclaredThrowableException) || !z || (undeclaredThrowable = ((UndeclaredThrowableException) th).getUndeclaredThrowable()) == null) {
                String message = th.getMessage();
                if (TextUtils.isEmpty(message)) {
                    message = "unknown_fetch_exception";
                }
                return new FetchException(message);
            } else {
                th = undeclaredThrowable;
                z = false;
            }
        }
        return (FetchException) th;
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Amcs-");
        sb.append(str);
        return sb.toString();
    }

    public static String b(Context context, String str) {
        Throwable th;
        InputStream inputStream;
        Exception e;
        InputStreamReader inputStreamReader;
        Exception e2;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            Object[] objArr = {context.getAssets(), str};
            Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
            if (obj == null) {
                obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 58133), TextUtils.indexOf("", "", 0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 49)).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
            }
            inputStream = (InputStream) ((Method) obj).invoke(null, objArr);
            try {
                inputStreamReader = new InputStreamReader(inputStream);
            } catch (Exception e3) {
                e = e3;
                int i = MyBillsEntityDataFactory + 39;
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                e2 = e;
                inputStreamReader = null;
                bufferedReader = null;
                String str2 = f7632a;
                StringBuilder sb = new StringBuilder();
                sb.append("readAssetFile failed: ");
                sb.append(e2);
                ACLog.e(str2, sb.toString());
                a(bufferedReader);
                a(inputStreamReader);
                a((Closeable) inputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
                a(bufferedReader2);
                a(inputStreamReader);
                a((Closeable) inputStream);
                throw th;
            }
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
            } catch (Exception e4) {
                e2 = e4;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                a(bufferedReader2);
                a(inputStreamReader);
                a((Closeable) inputStream);
                throw th;
            }
            try {
                try {
                    StringBuilder sb2 = new StringBuilder();
                    int i3 = getAuthRequestContext + 9;
                    MyBillsEntityDataFactory = i3 % 128;
                    while (true) {
                        int i4 = i3 % 2;
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb2.append(readLine);
                            sb2.append("\n");
                            i3 = MyBillsEntityDataFactory + 49;
                            getAuthRequestContext = i3 % 128;
                        } else {
                            String obj2 = sb2.toString();
                            a(bufferedReader);
                            a(inputStreamReader);
                            a((Closeable) inputStream);
                            return obj2;
                        }
                    }
                } catch (Throwable th4) {
                    inputStreamReader = inputStreamReader;
                    bufferedReader2 = bufferedReader;
                    th = th4;
                    a(bufferedReader2);
                    a(inputStreamReader);
                    a((Closeable) inputStream);
                    throw th;
                }
            } catch (Exception e5) {
                e2 = e5;
                String str22 = f7632a;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("readAssetFile failed: ");
                sb3.append(e2);
                ACLog.e(str22, sb3.toString());
                a(bufferedReader);
                a(inputStreamReader);
                a((Closeable) inputStream);
                return null;
            }
        } catch (Throwable th5) {
            try {
                Throwable cause = th5.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th5;
            } catch (Exception e6) {
                e = e6;
                inputStream = null;
                int i5 = MyBillsEntityDataFactory + 39;
                getAuthRequestContext = i5 % 128;
                int i22 = i5 % 2;
                e2 = e;
                inputStreamReader = null;
                bufferedReader = null;
                String str222 = f7632a;
                StringBuilder sb32 = new StringBuilder();
                sb32.append("readAssetFile failed: ");
                sb32.append(e2);
                ACLog.e(str222, sb32.toString());
                a(bufferedReader);
                a(inputStreamReader);
                a((Closeable) inputStream);
                return null;
            } catch (Throwable th6) {
                th = th6;
                inputStream = null;
                inputStreamReader = null;
                a(bufferedReader2);
                a(inputStreamReader);
                a((Closeable) inputStream);
                throw th;
            }
        }
    }

    private static String a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }

    public static boolean a(Context context) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            activityManager = (ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
        } catch (Throwable th) {
            String str = f7632a;
            StringBuilder sb = new StringBuilder();
            sb.append("isAppInForeground error: ");
            sb.append(th.getMessage());
            ACLog.e(str, sb.toString());
        }
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    public static String a() {
        return Build.VERSION.RELEASE;
    }

    public static String a(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
    }

    public static String a(Iterator<? extends CharSequence> it, char c) {
        if (it == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(c);
        }
        if (sb.length() <= 0) {
            return null;
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static JSONObject a(ConfigCenterContext configCenterContext, Map<String, Object> map) {
        Context context = configCenterContext.getContext();
        ConfigIdentifierProvider identifierProvider = configCenterContext.getIdentifierProvider();
        String versionName = MiscUtils.getVersionName(configCenterContext.getContext());
        if (TextUtils.isEmpty(versionName)) {
            versionName = "1.0";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("utdid", identifierProvider.getUtdId(context));
            jSONObject.put("reference", identifierProvider.getConfigUserId(context));
            jSONObject.put("mobileModel", Build.MODEL);
            jSONObject.put("osVersion", a());
            jSONObject.put(TinyAppLogUtil.TINY_APP_STANDARD_EXTRA_CLIENTVERSION, versionName);
            jSONObject.put("systemType", DefaultInitializeComponent.PLATFORM_TYPE);
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (JSONException e) {
            ACLog.w(f7632a, "buildParameters failed", e);
        }
        return jSONObject;
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                String str = f7632a;
                StringBuilder sb = new StringBuilder();
                sb.append("safeClose failed: ");
                sb.append(e);
                ACLog.e(str, sb.toString());
            }
        }
    }

    public static boolean a(String str) {
        try {
            return Class.forName(str) != null;
        } catch (Exception e) {
            String str2 = f7632a;
            StringBuilder sb = new StringBuilder();
            sb.append("check class [");
            sb.append(str);
            sb.append("] exception: ");
            sb.append(e);
            ACLog.e(str2, sb.toString());
            return false;
        }
    }

    private static String a(InputStream inputStream) {
        Throwable th;
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader = null;
        }
        try {
            char[] cArr = new char[1024];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read != -1) {
                    sb.append(cArr, 0, read);
                } else {
                    return sb.toString();
                }
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                ACLog.e(f7632a, "readInputStream", th);
                return null;
            } finally {
                a(inputStreamReader);
                a((Closeable) inputStream);
            }
        }
    }

    public static String a(Context context, String str) {
        try {
            FileInputStream openFileInput = context.openFileInput(str);
            if (openFileInput == null) {
                return null;
            }
            String a2 = a((InputStream) openFileInput);
            ACLog.i(f7632a, String.format("** loadFile Success! bytes = %s.", Integer.valueOf(a2 != null ? a2.getBytes().length : 0)));
            return a2;
        } catch (Throwable th) {
            ACLog.w(f7632a, String.format("** loadFile Failed! Take it easy, cache file not exists. message = %s.", th.getMessage()));
            return null;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = context.openFileOutput(str, 0);
            if (fileOutputStream == null) {
                return false;
            }
            try {
                byte[] bytes = str2 != null ? str2.getBytes() : new byte[0];
                fileOutputStream.write(bytes);
                ACLog.i(f7632a, String.format("** saveFile Success! bytes = %s.", Integer.valueOf(bytes.length)));
                return true;
            } catch (Throwable th) {
                th = th;
                try {
                    ACLog.e(f7632a, "saveFile Error!", th);
                    return false;
                } finally {
                    a(fileOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static boolean a(ConfigCenter configCenter) {
        JSONObject jSONConfig;
        ConfigGetter sectionConfigGetter = configCenter.getSectionConfigGetter(AmcsConstants.X_AMCS_SECTION_KEY);
        return sectionConfigGetter != null && (jSONConfig = sectionConfigGetter.getJSONConfig(AmcsConstants.CDN_END_COMPUTING_KEY)) != null && jSONConfig.optBoolean(AmcsConstants.CDN_ENABLE) && configCenter.getConfigContext().getVersion() == ConfigCenterContext.SchemeVersion.V2;
    }
}
