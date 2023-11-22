package com.iap.ac.config.lite.utils;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.common.config.ACConfig;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.config.lite.d.e;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ConfigUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7658a = e.b("ConfigUtils");

    /* loaded from: classes.dex */
    static final class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f7659a;

        a(Runnable runnable) {
            this.f7659a = runnable;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a  reason: merged with bridge method [inline-methods] */
        public final Void doInBackground(Void... voidArr) {
            this.f7659a.run();
            return null;
        }
    }

    public static <T> T deepCopyObject(T t) {
        if (t == null) {
            return null;
        }
        try {
            return (T) JsonUtils.fromJson(JsonUtils.toJson(t), (Class) t.getClass());
        } catch (Exception e) {
            ACLog.e(f7658a, "deep copy object failed!", e);
            return null;
        }
    }

    public static void doAsyncTask(Runnable runnable) {
        new a(runnable).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    public static String formatConfigVersionWithTime(long j) {
        return String.format("%s [ %s ]", Long.valueOf(j), e.a(j));
    }

    public static JSONObject kv(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, obj);
        } catch (Exception e) {
            InstrumentInjector.log_w(f7658a, "kv: error", e);
        }
        return jSONObject;
    }

    public static double parseDouble(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (Throwable unused) {
            ACLog.w(f7658a, String.format("Cannot parse %s to double!", str));
            return d;
        }
    }

    public static long parseLong(String str, long j) {
        try {
            return (long) Double.parseDouble(str);
        } catch (Throwable unused) {
            ACLog.w(f7658a, String.format("Cannot parse %s to long!", str));
            return j;
        }
    }

    public static void setConfigProxy() {
        setConfigProxy(null);
    }

    public static String toJSONString(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return JsonUtils.toJson(obj);
        } catch (Throwable th) {
            String str = f7658a;
            StringBuilder sb = new StringBuilder();
            sb.append("toJSONString failed. error = ");
            sb.append(th.getMessage());
            ACLog.e(str, sb.toString());
            return null;
        }
    }

    public static void setConfigProxy(String str) {
        if (TextUtils.isEmpty(str)) {
            ACConfig.setConfigImpl(ConfigProxy.newInstance());
        } else {
            ACConfig.setConfigImpl(ConfigProxy.newInstance(str), str);
        }
    }
}
