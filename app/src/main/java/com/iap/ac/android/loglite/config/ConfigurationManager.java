package com.iap.ac.android.loglite.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.iap.android.aplog.api.LogCategory;
import com.alipay.iap.android.aplog.api.LogEventType;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.biz.common.internal.consts.InnerConstants;
import com.iap.ac.android.biz.common.internal.foundation.FoundationProxy;
import com.iap.ac.android.loglite.core.CrashReporter;
import com.iap.ac.android.loglite.utils.LoggerWrapper;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ConfigurationManager {
    public SharedPreferences b;
    public String c;
    public boolean d;
    public boolean e = true;
    public boolean f = false;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, LogStrategyInfo> f7585a = new ConcurrentHashMap();

    public ConfigurationManager(Context context) {
        this.b = context.getSharedPreferences("aplus_loglite.prefs", 0);
        b(a());
    }

    public final void a(boolean z) {
        CrashReporter crashReporter;
        if (z) {
            crashReporter = CrashReporter.c;
            if (crashReporter != null) {
                synchronized (crashReporter) {
                    if (!crashReporter.b) {
                        crashReporter.f7590a = InstrumentInjector.getDefaultUncaughtExceptionHandler();
                        InstrumentInjector.setDefaultUncaughtExceptionHandler(crashReporter);
                        crashReporter.b = true;
                    }
                }
            } else {
                throw new IllegalStateException("need init befor use");
            }
        } else {
            crashReporter = CrashReporter.c;
            if (crashReporter != null) {
                synchronized (crashReporter) {
                    if (crashReporter.b) {
                        InstrumentInjector.setDefaultUncaughtExceptionHandler(crashReporter.f7590a);
                        crashReporter.b = false;
                    }
                }
            } else {
                throw new IllegalStateException("need init befor use");
            }
        }
    }

    public void b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("uploadUrl");
            if (!TextUtils.isEmpty(optString)) {
                this.c = optString;
            }
            this.e = jSONObject.optBoolean("enable", true);
            this.d = jSONObject.optBoolean("autoTrackEnable", false);
            boolean optBoolean = jSONObject.optBoolean("http2Enable", false);
            LoggerWrapper.i("ConfigurationManager", String.format("current enable = %b, will be set = %b", Boolean.valueOf(this.f), Boolean.valueOf(optBoolean)));
            this.f = optBoolean;
            a(jSONObject.optBoolean("crashTrackEnable", false));
            b(jSONObject);
            a(jSONObject);
        } catch (Exception e) {
            LoggerWrapper.w("ConfigurationManager", e);
        }
    }

    public boolean c(String str) {
        LogStrategyInfo a2;
        boolean z = this.e;
        return (!z || TextUtils.isEmpty(str) || (a2 = a(str)) == null) ? z : a2.isWrite;
    }

    public LogStrategyInfo a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f7585a.get(str);
    }

    public String a() {
        SharedPreferences sharedPreferences = this.b;
        return sharedPreferences != null ? sharedPreferences.getString("logStrategy", "") : "";
    }

    public final void a(JSONObject jSONObject) throws JSONException {
        Object opt;
        SharedPreferences sharedPreferences = this.b;
        String string = sharedPreferences != null ? sharedPreferences.getString("logStrategy", "") : "";
        if (!TextUtils.isEmpty(string)) {
            JSONObject jSONObject2 = new JSONObject(string);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!"bizSettings".equals(next) && (opt = jSONObject.opt(next)) != null) {
                    jSONObject2.put(next, opt);
                }
            }
            JSONObject optJSONObject = jSONObject2.optJSONObject("bizSettings");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("bizSettings");
            Iterator<String> keys2 = optJSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(next2);
                if (optJSONObject3 != null) {
                    optJSONObject.put(next2, optJSONObject3);
                }
            }
            String jSONObject3 = jSONObject2.toString();
            SharedPreferences sharedPreferences2 = this.b;
            if (sharedPreferences2 != null) {
                sharedPreferences2.edit().putString("logStrategy", jSONObject3).apply();
                return;
            }
            return;
        }
        String jSONObject4 = jSONObject.toString();
        SharedPreferences sharedPreferences3 = this.b;
        if (sharedPreferences3 != null) {
            sharedPreferences3.edit().putString("logStrategy", jSONObject4).apply();
        }
    }

    public final void b(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("bizSettings");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                if (optJSONObject2 != null) {
                    LogStrategyInfo logStrategyInfo = new LogStrategyInfo();
                    logStrategyInfo.isWrite = optJSONObject2.optBoolean("write", true);
                    logStrategyInfo.openId = optJSONObject2.optBoolean(InnerConstants.STORAGE_KEY_OPENID);
                    logStrategyInfo.instanceId = optJSONObject2.optBoolean(FoundationProxy.COMPONENT_INSTANCE_ID);
                    logStrategyInfo.maxLogCount = optJSONObject2.optInt(LogEventType.CATEGOTY_MAX_LOG_COUNT);
                    this.f7585a.put(next, logStrategyInfo);
                }
            }
        }
    }

    public boolean a(String str, int i, String str2) {
        int i2;
        if ("crash".equals(str) || LogCategory.LOG_CATEGORY_HIGHAVAIL.equals(str)) {
            i2 = 1;
        } else {
            LogStrategyInfo a2 = a(str2);
            if (a2 == null || (i2 = a2.maxLogCount) <= 0) {
                i2 = 20;
            }
        }
        return i >= i2;
    }
}
