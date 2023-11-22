package com.iap.ac.android.biz.common.storage.lite;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes3.dex */
public class ACStorageLiteProvider {
    public static final String SP_PREFIX = "ACConnect_sp_lite";
    public SharedPreferences sharedPreferences;

    public ACStorageLiteProvider(Context context, String str) {
        if (context == null) {
            ACLog.e(Constants.TAG, "ACStorageProvider, Context should not be null");
        } else if (TextUtils.isEmpty(str)) {
            ACLog.e(Constants.TAG, "ACStorageProvider, bizType should not be null");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(SP_PREFIX);
            sb.append(str);
            this.sharedPreferences = context.getSharedPreferences(sb.toString(), 0);
        }
    }

    public boolean clear() {
        synchronized (this) {
            try {
                this.sharedPreferences.edit().clear().apply();
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("ACStorageProvider, clear exception: ");
                sb.append(e);
                ACLog.e(Constants.TAG, sb.toString());
                return false;
            }
        }
        return true;
    }

    public boolean delete(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                ACLog.e(Constants.TAG, "ACStorageProvider, delete, key should not be null, delete failed.");
                return false;
            }
            try {
                this.sharedPreferences.edit().remove(str).apply();
                return true;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("ACStorageProvider, delete exception: ");
                sb.append(e);
                ACLog.e(Constants.TAG, sb.toString());
                return false;
            }
        }
    }

    public String fetch(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                ACLog.e(Constants.TAG, "ACStorageProvider, fetch, key should not be null, return null");
                return null;
            }
            try {
                if (!this.sharedPreferences.contains(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ACStorageProvider, fetch, value of key ");
                    sb.append(str);
                    sb.append(" does not exist, return null");
                    ACLog.e(Constants.TAG, sb.toString());
                    return null;
                }
                return this.sharedPreferences.getString(str, "");
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ACStorageProvider, fetch exception: ");
                sb2.append(e);
                ACLog.e(Constants.TAG, sb2.toString());
                return null;
            }
        }
    }

    public boolean save(String str, String str2) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("ACStorageProvider, key should not be null, save fail for key: ");
                sb.append(str);
                sb.append(", value: ");
                sb.append(str2);
                ACLog.e(Constants.TAG, sb.toString());
                return false;
            }
            try {
                this.sharedPreferences.edit().putString(str, str2).apply();
                return true;
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ACStorageProvider, save exception: ");
                sb2.append(e);
                ACLog.e(Constants.TAG, sb2.toString());
                return false;
            }
        }
    }
}
