package com.alipay.iap.android.common.securitydata.storage.provider;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;

/* loaded from: classes3.dex */
public class SpDataStorageProvider implements IDataStorageProvider {
    private static final String SP_PREFIX = "sp_";
    private static final String TAG = "SpDataStorageProvider";
    private SharedPreferences sharedPreferences;

    public SpDataStorageProvider(Context context, String str) {
        if (context == null) {
            LoggerWrapper.w("SpDataStorageProvider", "Context should not be null");
        } else if (TextUtils.isEmpty(str)) {
            LoggerWrapper.w("SpDataStorageProvider", "bizType should not be null");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("sp_");
            sb.append(str);
            this.sharedPreferences = context.getSharedPreferences(sb.toString(), 0);
        }
    }

    @Override // com.alipay.iap.android.common.securitydata.storage.IDataStorage
    public boolean save(String str, String str2) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                LoggerWrapper.e("SpDataStorageProvider", "key should not be null, save failed");
                return false;
            }
            try {
                this.sharedPreferences.edit().putString(str, str2).apply();
                return true;
            } catch (Exception e) {
                LoggerWrapper.e("SpDataStorageProvider", LoggerWrapper.buildMessage("Save %s failed because of exception: %s", str, e.getMessage()));
                return false;
            }
        }
    }

    @Override // com.alipay.iap.android.common.securitydata.storage.IDataStorage
    public String fetch(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                LoggerWrapper.e("SpDataStorageProvider", "key should not be null, return null");
                return null;
            }
            try {
                if (!this.sharedPreferences.contains(str)) {
                    LoggerWrapper.w("SpDataStorageProvider", LoggerWrapper.buildMessage("value of key: %s does not exist, return null", str));
                    return null;
                }
                return this.sharedPreferences.getString(str, "");
            } catch (Exception e) {
                LoggerWrapper.e("SpDataStorageProvider", LoggerWrapper.buildMessage("fetch %s failed because of exception: %s", str, e.getMessage()));
                return null;
            }
        }
    }

    @Override // com.alipay.iap.android.common.securitydata.storage.IDataStorage
    public boolean delete(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                LoggerWrapper.e("SpDataStorageProvider", "key should not be null, delete failed");
                return false;
            }
            try {
                this.sharedPreferences.edit().remove(str).apply();
                return true;
            } catch (Exception e) {
                LoggerWrapper.e("SpDataStorageProvider", LoggerWrapper.buildMessage("delete %s failed because of exception: %s", str, e.getMessage()));
                return false;
            }
        }
    }

    @Override // com.alipay.iap.android.common.securitydata.storage.IDataStorage
    public boolean clear() {
        synchronized (this) {
            try {
                this.sharedPreferences.edit().clear().apply();
            } catch (Exception e) {
                LoggerWrapper.e("SpDataStorageProvider", LoggerWrapper.buildMessage("clear data failed because of exception: %s", e.getMessage()));
                return false;
            }
        }
        return true;
    }
}
