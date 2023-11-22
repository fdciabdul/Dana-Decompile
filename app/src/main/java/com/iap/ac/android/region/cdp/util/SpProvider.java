package com.iap.ac.android.region.cdp.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.iap.ac.android.region.cdp.WalletCdpKit;

/* loaded from: classes3.dex */
public class SpProvider {
    public static final String KEY_FATIGUE_RECORD_ID = "fatigue_record_id";
    public static final String KEY_HTTP_RESP_TIME_MILLIS = "http_resp_time_millis";
    public static final String KEY_HTTP_RESP_TIME_MILLIS_START = "http_resp_time_millis_start";
    public static final String KEY_LAST_UPDATE_TIME = "last_update_time_";
    public static final String KEY_UNIQUE_CLEAR_TAG = "unique_clear_tag_";
    public static final String SP_NAME = "wallet_cdp_sp";
    public static SpProvider sInstance;
    public final Context mContext;
    public final SharedPreferences mSharedPreferences;

    public SpProvider() {
        Context applicationContextOrThrow = WalletCdpKit.getInstance().getApplicationContextOrThrow();
        this.mContext = applicationContextOrThrow;
        this.mSharedPreferences = applicationContextOrThrow.getSharedPreferences(SP_NAME, 0);
    }

    public static SpProvider getInstance() {
        if (sInstance == null) {
            synchronized (SpProvider.class) {
                if (sInstance == null) {
                    sInstance = new SpProvider();
                }
            }
        }
        return sInstance;
    }

    public long getHttpRespTimeMillis() {
        return this.mSharedPreferences.getLong(KEY_HTTP_RESP_TIME_MILLIS, 0L);
    }

    public long getHttpRespTimeMillisStart() {
        return this.mSharedPreferences.getLong(KEY_HTTP_RESP_TIME_MILLIS_START, 0L);
    }

    public long getLastUpdateTime(String str) {
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        StringBuilder sb = new StringBuilder();
        sb.append(KEY_LAST_UPDATE_TIME);
        sb.append(str);
        return sharedPreferences.getLong(sb.toString(), 0L);
    }

    public String getRecordId() {
        return this.mSharedPreferences.getString(KEY_FATIGUE_RECORD_ID, null);
    }

    public String getUniqueClearTag(String str) {
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        StringBuilder sb = new StringBuilder();
        sb.append(KEY_UNIQUE_CLEAR_TAG);
        sb.append(str);
        return sharedPreferences.getString(sb.toString(), "");
    }

    public void saveHttpRespTimeMillis(long j) {
        this.mSharedPreferences.edit().putLong(KEY_HTTP_RESP_TIME_MILLIS, j).apply();
    }

    public void saveHttpRespTimeMillisStart() {
        this.mSharedPreferences.edit().putLong(KEY_HTTP_RESP_TIME_MILLIS_START, System.currentTimeMillis()).apply();
    }

    public void saveLastUpdateTime(String str, long j) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        StringBuilder sb = new StringBuilder();
        sb.append(KEY_LAST_UPDATE_TIME);
        sb.append(str);
        edit.putLong(sb.toString(), j).apply();
    }

    public void saveRecordId(String str) {
        this.mSharedPreferences.edit().putString(KEY_FATIGUE_RECORD_ID, str).apply();
    }

    public void saveUniqueClearTag(String str, String str2) {
        if (TextUtils.equals(str2, getUniqueClearTag(str))) {
            return;
        }
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        StringBuilder sb = new StringBuilder();
        sb.append(KEY_UNIQUE_CLEAR_TAG);
        sb.append(str);
        edit.putString(sb.toString(), str2).apply();
    }
}
