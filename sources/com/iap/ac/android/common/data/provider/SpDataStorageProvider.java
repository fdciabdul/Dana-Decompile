package com.iap.ac.android.common.data.provider;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes8.dex */
public class SpDataStorageProvider implements IDataStorageProvider {
    public static final String SP_PREFIX = "sp_";
    public static final String TAG = "SpDataStorageProvider";
    public SharedPreferences sharedPreferences;

    public SpDataStorageProvider(Context context, String str) {
        if (context == null) {
            ACLog.w(TAG, "Context should not be null");
        } else if (TextUtils.isEmpty(str)) {
            ACLog.w(TAG, "bizType should not be null");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(SP_PREFIX);
            sb.append(str);
            this.sharedPreferences = context.getSharedPreferences(sb.toString(), 0);
        }
    }

    @Override // com.iap.ac.android.common.data.IDataStorage
    public boolean clear() {
        synchronized (this) {
            try {
                this.sharedPreferences.edit().clear().apply();
            } catch (Exception e) {
                ACLog.e(TAG, String.format("clear data failed because of exception: %s", e.getMessage()));
                return false;
            }
        }
        return true;
    }

    @Override // com.iap.ac.android.common.data.IDataStorage
    public boolean delete(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                ACLog.e(TAG, "key should not be null, delete failed");
                return false;
            }
            try {
                this.sharedPreferences.edit().remove(str).apply();
                return true;
            } catch (Exception e) {
                ACLog.e(TAG, String.format("delete %s failed because of exception: %s", str, e.getMessage()));
                return false;
            }
        }
    }

    @Override // com.iap.ac.android.common.data.IDataStorage
    public String get(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                ACLog.e(TAG, "key should not be null, return null");
                return null;
            }
            try {
                if (!this.sharedPreferences.contains(str)) {
                    ACLog.w(TAG, String.format("value of key: %s does not exist, return null", str));
                    return null;
                }
                return this.sharedPreferences.getString(str, "");
            } catch (Exception e) {
                ACLog.e(TAG, String.format("fetch %s failed because of exception: %s", str, e.getMessage()));
                return null;
            }
        }
    }

    @Override // com.iap.ac.android.common.data.IDataStorage
    public boolean save(String str, String str2) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                ACLog.e(TAG, "key should not be null, save failed");
                return false;
            }
            try {
                this.sharedPreferences.edit().putString(str, str2).apply();
                return true;
            } catch (Exception e) {
                ACLog.e(TAG, String.format("Save %s failed because of exception: %s", str, e.getMessage()));
                return false;
            }
        }
    }
}
