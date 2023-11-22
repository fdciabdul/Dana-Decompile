package com.iap.ac.android.common.account;

import android.text.TextUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.ACMonitor;
import com.iap.ac.android.common.log.event.LogEvent;
import com.iap.ac.android.common.log.event.LogEventType;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public enum ACUserInfoManager implements IUserInfoManager {
    INSTANCE;

    public static final String EVENT_GET_DEFAULT_IMPL = "ac_common_get_user_info_defalut_impl";
    public static final String EVENT_GET_IMPL_ERROR = "ac_common_get_user_info_impl_error";
    public static final String TAG = "ACUserInfoManager";
    public static IUserInfoManager sUserInfoManager;
    public static final Map<String, IUserInfoManager> userInfoManagerMap = new HashMap();
    public static IUserInfoManager defaultManager = new IUserInfoManager() { // from class: com.iap.ac.android.common.account.ACUserInfoManager.1
        @Override // com.iap.ac.android.common.account.IUserInfoManager
        public final String getOpenId() {
            ACUserInfoManager.noImplementationError();
            return null;
        }

        @Override // com.iap.ac.android.common.account.IUserInfoManager
        public final ACUserInfo getUserInfo() {
            ACUserInfoManager.noImplementationError();
            return null;
        }

        @Override // com.iap.ac.android.common.account.IUserInfoManager
        public final boolean setUserInfo(ACUserInfo aCUserInfo) {
            ACUserInfoManager.noImplementationError();
            return false;
        }
    };

    public static IUserInfoManager getInstance(String str) {
        if (TextUtils.isEmpty(str)) {
            return getInstance();
        }
        IUserInfoManager iUserInfoManager = userInfoManagerMap.get(str);
        if (iUserInfoManager == null && (iUserInfoManager = sUserInfoManager) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bizCode", str);
            hashMap.put("msg", "Cannot find the implemetation for this bizCode. Using default instead.");
            LogEvent logEvent = new LogEvent(EVENT_GET_DEFAULT_IMPL, hashMap);
            logEvent.bizCode = str;
            ACMonitor.getInstance(str).logEvent(logEvent);
        }
        if (iUserInfoManager == null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("bizCode", str);
            hashMap2.put("errorMsg", "Cannot find the implemetation for this bizCode.");
            LogEvent logEvent2 = new LogEvent(EVENT_GET_IMPL_ERROR, hashMap2);
            logEvent2.bizCode = str;
            logEvent2.eventType = LogEventType.CRUCIAL_LOG;
            ACMonitor.getInstance(str).logEvent(logEvent2);
            return defaultManager;
        }
        return iUserInfoManager;
    }

    public static void noImplementationError() {
        ACLog.e(TAG, "No implementation of userInfoManager is found. Please setUserInfoManager first.");
    }

    public static void setUserInfoManager(IUserInfoManager iUserInfoManager) {
        sUserInfoManager = iUserInfoManager;
    }

    @Override // com.iap.ac.android.common.account.IUserInfoManager
    public final String getOpenId() {
        IUserInfoManager iUserInfoManager = sUserInfoManager;
        if (iUserInfoManager == null) {
            noImplementationError();
            return null;
        }
        return iUserInfoManager.getOpenId();
    }

    @Override // com.iap.ac.android.common.account.IUserInfoManager
    public final ACUserInfo getUserInfo() {
        IUserInfoManager iUserInfoManager = sUserInfoManager;
        if (iUserInfoManager == null) {
            noImplementationError();
            return null;
        }
        return iUserInfoManager.getUserInfo();
    }

    @Override // com.iap.ac.android.common.account.IUserInfoManager
    public final boolean setUserInfo(ACUserInfo aCUserInfo) {
        IUserInfoManager iUserInfoManager = sUserInfoManager;
        if (iUserInfoManager == null) {
            noImplementationError();
            return false;
        }
        return iUserInfoManager.setUserInfo(aCUserInfo);
    }

    public static void setUserInfoManager(IUserInfoManager iUserInfoManager, String str) {
        userInfoManagerMap.put(str, iUserInfoManager);
    }

    public static IUserInfoManager getInstance() {
        IUserInfoManager iUserInfoManager = sUserInfoManager;
        return iUserInfoManager != null ? iUserInfoManager : defaultManager;
    }
}
