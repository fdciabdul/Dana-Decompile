package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class Store {
    static final String NO_BACKUP_FILE = "com.google.android.gms.appid-no-backup";
    static final String PREFERENCES = "com.google.android.gms.appid";
    private static final String SCOPE_ALL = "*";
    private static final String STORE_KEY_TOKEN = "|T|";
    final SharedPreferences store;

    public Store(Context context) {
        this.store = context.getSharedPreferences(PREFERENCES, 0);
        checkForRestore(context, NO_BACKUP_FILE);
    }

    private void checkForRestore(Context context, String str) {
        File file = new File(ContextCompat.getAuthRequestContext(context), str);
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || isEmpty()) {
                return;
            }
            InstrumentInjector.log_i(Constants.TAG, "App restored, clearing state");
            deleteAll();
        } catch (IOException e) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error creating file in no backup dir: ");
                sb.append(e.getMessage());
                InstrumentInjector.log_d(Constants.TAG, sb.toString());
            }
        }
    }

    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this) {
            isEmpty = this.store.getAll().isEmpty();
        }
        return isEmpty;
    }

    private String createTokenKey(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(STORE_KEY_TOKEN);
        sb.append(str2);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("*");
        return sb.toString();
    }

    public void deleteAll() {
        synchronized (this) {
            this.store.edit().clear().commit();
        }
    }

    public Token getToken(String str, String str2) {
        Token parse;
        synchronized (this) {
            parse = Token.parse(this.store.getString(createTokenKey(str, str2), null));
        }
        return parse;
    }

    public void saveToken(String str, String str2, String str3, String str4) {
        synchronized (this) {
            String encode = Token.encode(str3, str4, System.currentTimeMillis());
            if (encode == null) {
                return;
            }
            SharedPreferences.Editor edit = this.store.edit();
            edit.putString(createTokenKey(str, str2), encode);
            edit.commit();
        }
    }

    public void deleteToken(String str, String str2) {
        synchronized (this) {
            String createTokenKey = createTokenKey(str, str2);
            SharedPreferences.Editor edit = this.store.edit();
            edit.remove(createTokenKey);
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Token {
        private static final String KEY_APP_VERSION = "appVersion";
        private static final String KEY_TIMESTAMP = "timestamp";
        private static final String KEY_TOKEN = "token";
        private static final long REFRESH_PERIOD_MILLIS = TimeUnit.DAYS.toMillis(7);
        final String appVersion;
        final long timestamp;
        final String token;

        private Token(String str, String str2, long j) {
            this.token = str;
            this.appVersion = str2;
            this.timestamp = j;
        }

        static Token parse(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith("{")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    return new Token(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
                } catch (JSONException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to parse token: ");
                    sb.append(e);
                    InstrumentInjector.log_w(Constants.TAG, sb.toString());
                    return null;
                }
            }
            return new Token(str, null, 0L);
        }

        static String encode(String str, String str2, long j) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put("appVersion", str2);
                jSONObject.put("timestamp", j);
                return jSONObject.toString();
            } catch (JSONException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to encode token: ");
                sb.append(e);
                InstrumentInjector.log_w(Constants.TAG, sb.toString());
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean needsRefresh(String str) {
            return System.currentTimeMillis() > this.timestamp + REFRESH_PERIOD_MILLIS || !str.equals(this.appVersion);
        }
    }
}
