package com.appsflyer;

import android.content.Context;
import android.content.SharedPreferences;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.ae;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AppsFlyerProperties {
    public static final String ADDITIONAL_CUSTOM_DATA = "additionalCustomData";
    private static AppsFlyerProperties AFKeystoreWrapper = new AppsFlyerProperties();
    public static final String AF_KEY = "AppsFlyerKey";
    public static final String AF_WAITFOR_CUSTOMERID = "waitForCustomerId";
    public static final String APP_ID = "appid";
    public static final String APP_USER_ID = "AppUserId";
    public static final String CHANNEL = "channel";
    public static final String COLLECT_ANDROID_ID = "collectAndroidId";
    public static final String COLLECT_ANDROID_ID_FORCE_BY_USER = "collectAndroidIdForceByUser";
    public static final String COLLECT_FACEBOOK_ATTR_ID = "collectFacebookAttrId";
    public static final String COLLECT_FINGER_PRINT = "collectFingerPrint";
    public static final String COLLECT_IMEI = "collectIMEI";
    public static final String COLLECT_IMEI_FORCE_BY_USER = "collectIMEIForceByUser";
    public static final String COLLECT_MAC = "collectMAC";
    public static final String COLLECT_OAID = "collectOAID";
    public static final String CURRENCY_CODE = "currencyCode";
    public static final String DEVICE_TRACKING_DISABLED = "deviceTrackingDisabled";
    public static final String DISABLE_KEYSTORE = "keyPropDisableAFKeystore";
    public static final String DISABLE_LOGS_COMPLETELY = "disableLogs";
    public static final String DISABLE_OTHER_SDK = "disableOtherSdk";
    public static final String DPM = "disableProxy";
    public static final String EMAIL_CRYPT_TYPE = "userEmailsCryptType";
    public static final String ENABLE_GPS_FALLBACK = "enableGpsFallback";
    public static final String EXTENSION = "sdkExtension";
    public static final String HTTP_CACHE = "http_cache";
    public static final String IS_UPDATE = "IS_UPDATE";
    public static final String LAUNCH_PROTECT_ENABLED = "launchProtectEnabled";
    public static final String NEW_REFERRER_SENT = "newGPReferrerSent";
    public static final String ONELINK_DOMAIN = "onelinkDomain";
    public static final String ONELINK_ID = "oneLinkSlug";
    public static final String ONELINK_SCHEME = "onelinkScheme";
    public static final String USER_EMAIL = "userEmail";
    public static final String USER_EMAILS = "userEmails";
    public static final String USE_HTTP_FALLBACK = "useHttpFallback";
    public boolean AFInAppEventParameterName;
    public String valueOf;
    private Map<String, Object> values = new HashMap();
    private boolean AFInAppEventType = false;

    private AppsFlyerProperties() {
    }

    public static AppsFlyerProperties getInstance() {
        return AFKeystoreWrapper;
    }

    public void remove(String str) {
        synchronized (this) {
            this.values.remove(str);
        }
    }

    public void set(String str, String str2) {
        synchronized (this) {
            this.values.put(str, str2);
        }
    }

    public void set(String str, String[] strArr) {
        synchronized (this) {
            this.values.put(str, strArr);
        }
    }

    public void set(String str, int i) {
        synchronized (this) {
            this.values.put(str, Integer.toString(i));
        }
    }

    public void set(String str, long j) {
        synchronized (this) {
            this.values.put(str, Long.toString(j));
        }
    }

    public void set(String str, boolean z) {
        synchronized (this) {
            this.values.put(str, Boolean.toString(z));
        }
    }

    public void setCustomData(String str) {
        synchronized (this) {
            this.values.put(ADDITIONAL_CUSTOM_DATA, str);
        }
    }

    public void setUserEmails(String str) {
        synchronized (this) {
            this.values.put(USER_EMAILS, str);
        }
    }

    public String getString(String str) {
        String str2;
        synchronized (this) {
            str2 = (String) this.values.get(str);
        }
        return str2;
    }

    public boolean getBoolean(String str, boolean z) {
        String string = getString(str);
        return string == null ? z : Boolean.valueOf(string).booleanValue();
    }

    public int getInt(String str, int i) {
        String string = getString(str);
        return string == null ? i : Integer.valueOf(string).intValue();
    }

    public long getLong(String str, long j) {
        String string = getString(str);
        return string == null ? j : Long.valueOf(string).longValue();
    }

    public Object getObject(String str) {
        Object obj;
        synchronized (this) {
            obj = this.values.get(str);
        }
        return obj;
    }

    public final boolean values() {
        return this.AFInAppEventParameterName;
    }

    public String getReferrer(Context context) {
        String str = this.valueOf;
        if (str != null) {
            return str;
        }
        if (getString("AF_REFERRER") != null) {
            return getString("AF_REFERRER");
        }
        if (context == null) {
            return null;
        }
        return ae.values(context).getString("referrer", null);
    }

    public boolean isLogsDisabledCompletely() {
        return getBoolean(DISABLE_LOGS_COMPLETELY, false);
    }

    public boolean isOtherSdkStringDisabled() {
        return getBoolean(DISABLE_OTHER_SDK, false);
    }

    public void saveProperties(SharedPreferences sharedPreferences) {
        synchronized (this) {
            sharedPreferences.edit().putString("savedProperties", new JSONObject(this.values).toString()).apply();
        }
    }

    public void loadProperties(Context context) {
        synchronized (this) {
            if (AFKeystoreWrapper()) {
                return;
            }
            String string = ae.values(context).getString("savedProperties", null);
            if (string != null) {
                AFLogger.values("Loading properties..");
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (this.values.get(next) == null) {
                            this.values.put(next, jSONObject.getString(next));
                        }
                    }
                    this.AFInAppEventType = true;
                } catch (JSONException e) {
                    AFLogger.AFInAppEventType("Failed loading properties", e);
                }
                StringBuilder sb = new StringBuilder("Done loading properties: ");
                sb.append(this.AFInAppEventType);
                AFLogger.values(sb.toString());
            }
        }
    }

    private boolean AFKeystoreWrapper() {
        return this.AFInAppEventType;
    }

    /* loaded from: classes.dex */
    public enum EmailsCryptType {
        NONE(0),
        SHA256(3);

        private final int AFKeystoreWrapper;

        EmailsCryptType(int i) {
            this.AFKeystoreWrapper = i;
        }

        public final int getValue() {
            return this.AFKeystoreWrapper;
        }
    }

    public boolean isEnableLog() {
        return getInt("logLevel", AFLogger.LogLevel.NONE.getLevel()) > AFLogger.LogLevel.NONE.getLevel();
    }
}
