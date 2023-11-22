package com.iap.ac.android.biz.common.internal.oauth;

import android.text.TextUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.internal.foundation.FoundationProxy;
import com.iap.ac.android.biz.common.storage.ACStorageProvider;
import com.iap.ac.android.biz.common.utils.cookie.CookieUtils;

/* loaded from: classes3.dex */
public class OAuthUtil {
    public static final String KEY_CLIENTKEY_INTERVAL = "KEY_CLIENTKEY_INTERVAL";
    public static final String KEY_CLIENTKEY_UPDATED_TIME = "key_clientkey_updated_time";
    public static final String KEY_SESSIONID_UPDATED_TIME = "key_sessionid_updated_time";
    public static final String StorageOauth = "StorageOauth";
    public static volatile OAuthUtil mInstance;
    public long clientKeyUpdatedTimeStamp;
    public long sessionIdUpdatedTimeStamp;
    public long DEFAULT_CLIENTKEY_EXPIREDTIME = 1296000;
    public long DEFAULT_SESSION_EXPIREDTIME = 1800;
    public long sessionIdExpiredTimeInterval = 1800;
    public long clientKeyExpiredTimeInterval = 1296000;

    public static OAuthUtil getInstance() {
        if (mInstance == null) {
            synchronized (OAuthUtil.class) {
                if (mInstance == null) {
                    mInstance = new OAuthUtil();
                }
            }
        }
        return mInstance;
    }

    public long getClientKeyExpiredTimeInterval() {
        String fetch = new ACStorageProvider(ACManager.getInstance().getContext(), StorageOauth).fetch(KEY_CLIENTKEY_INTERVAL);
        return TextUtils.isEmpty(fetch) ? this.DEFAULT_CLIENTKEY_EXPIREDTIME : Long.parseLong(fetch);
    }

    public long getClientKeyUpdatedTimeStamp() {
        String fetch = new ACStorageProvider(ACManager.getInstance().getContext(), StorageOauth).fetch(KEY_CLIENTKEY_UPDATED_TIME);
        if (TextUtils.isEmpty(fetch)) {
            return 0L;
        }
        return Long.parseLong(fetch);
    }

    public int getOAuthChainType() {
        if (!ConfigCenter.INSTANCE.isOAuthOptimizedEnable()) {
            return OauthChainType.STATUS_UNKNOW.ordinal();
        }
        if (TextUtils.isEmpty(CookieUtils.getCookie(FoundationProxy.getInstance("ac_biz").getGateWayUrl(), "ALIPAYINTLACJSESSIONID"))) {
            return OauthChainType.STATUS_COOKIE_IS_NULL.ordinal();
        }
        if (getSessionIdUpdatedTimeStamp() > 0 && getClientKeyUpdatedTimeStamp() > 0) {
            if (isAvailable(getSessionIdUpdatedTimeStamp(), this.sessionIdExpiredTimeInterval * 1000)) {
                return OauthChainType.STATUS_COOKIE_NOT_EXPIRED.ordinal();
            }
            if (!isAvailable(getSessionIdUpdatedTimeStamp(), this.sessionIdExpiredTimeInterval * 1000) && isAvailable(getClientKeyUpdatedTimeStamp(), getClientKeyExpiredTimeInterval() * 1000)) {
                return OauthChainType.STATUS_ONLY_COOKIE_EXPIRED.ordinal();
            }
            if (!isAvailable(getSessionIdUpdatedTimeStamp(), this.sessionIdExpiredTimeInterval * 1000) && !isAvailable(getClientKeyUpdatedTimeStamp(), getClientKeyExpiredTimeInterval() * 1000)) {
                return OauthChainType.STATUS_CLIENTKEY_EXPIRED.ordinal();
            }
            return OauthChainType.STATUS_UNKNOW.ordinal();
        }
        return OauthChainType.STATUS_UPDATETIME_INVALID.ordinal();
    }

    public long getSessionIdUpdatedTimeStamp() {
        String fetch = new ACStorageProvider(ACManager.getInstance().getContext(), StorageOauth).fetch(KEY_SESSIONID_UPDATED_TIME);
        if (TextUtils.isEmpty(fetch)) {
            return 0L;
        }
        return Long.parseLong(fetch);
    }

    public boolean hasSessionId(String str, String str2) {
        if (TextUtils.isEmpty(CookieUtils.getCookie(str, str2))) {
            return false;
        }
        if (ConfigCenter.INSTANCE.isOAuthOptimizedEnable()) {
            return isAvailable(getSessionIdUpdatedTimeStamp(), this.DEFAULT_SESSION_EXPIREDTIME * 1000);
        }
        return true;
    }

    public boolean isAvailable(long j, long j2) {
        return j <= 0 || j2 <= 0 || System.currentTimeMillis() - j < j2;
    }

    public boolean loginPreCheck(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (ConfigCenter.INSTANCE.isOAuthOptimizedEnable()) {
            return isAvailable(getClientKeyUpdatedTimeStamp(), getClientKeyExpiredTimeInterval() * 1000);
        }
        return true;
    }

    public void updateClientKeyTime(String str) {
        if (ConfigCenter.INSTANCE.isOAuthOptimizedEnable()) {
            ACStorageProvider aCStorageProvider = new ACStorageProvider(ACManager.getInstance().getContext(), StorageOauth);
            long currentTimeMillis = System.currentTimeMillis();
            this.clientKeyUpdatedTimeStamp = currentTimeMillis;
            aCStorageProvider.save(KEY_CLIENTKEY_UPDATED_TIME, String.valueOf(currentTimeMillis));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return;
                }
                this.clientKeyExpiredTimeInterval = parseLong;
                aCStorageProvider.save(KEY_CLIENTKEY_INTERVAL, String.valueOf(parseLong));
            } catch (Exception unused) {
            }
        }
    }

    public void updateSessionTime() {
        if (ConfigCenter.INSTANCE.isOAuthOptimizedEnable()) {
            ACStorageProvider aCStorageProvider = new ACStorageProvider(ACManager.getInstance().getContext(), StorageOauth);
            long currentTimeMillis = System.currentTimeMillis();
            this.sessionIdUpdatedTimeStamp = currentTimeMillis;
            aCStorageProvider.save(KEY_SESSIONID_UPDATED_TIME, String.valueOf(currentTimeMillis));
        }
    }
}
