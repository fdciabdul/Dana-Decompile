package com.alipay.iap.android.common.securitydata.encrypt.provider;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.alipay.iap.android.common.log.LoggerWrapper;

/* loaded from: classes6.dex */
public class SecurityGuardProvider implements IDataEncryptProvider {
    private static final String TAG = "SecurityGuardProvider";
    private static volatile SecurityGuardProvider instance;
    private IDynamicDataEncryptComponent dynamicDataEncryptComponent;

    public static SecurityGuardProvider getInstance(Context context) {
        if (instance == null) {
            synchronized (SecurityGuardManager.class) {
                if (instance == null) {
                    instance = new SecurityGuardProvider(context);
                }
            }
        }
        return instance;
    }

    private SecurityGuardProvider(Context context) {
        try {
            this.dynamicDataEncryptComponent = SecurityGuardManager.getInstance(context).getDynamicDataEncryptComp();
        } catch (SecException unused) {
            LoggerWrapper.e(TAG, "SecurityGuard is not ready");
        }
    }

    @Override // com.alipay.iap.android.common.securitydata.encrypt.IDataEncrypt
    public String encrypt(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                LoggerWrapper.w(TAG, "encrypt data is empty, return empty data");
                return "";
            }
            IDynamicDataEncryptComponent iDynamicDataEncryptComponent = this.dynamicDataEncryptComponent;
            if (iDynamicDataEncryptComponent == null) {
                LoggerWrapper.w(TAG, "SecurityGuard not ready, return original data");
                return str;
            }
            try {
                return iDynamicDataEncryptComponent.dynamicEncryptDDp(str);
            } catch (SecException e) {
                LoggerWrapper.e(TAG, LoggerWrapper.buildMessage("encrypt data failed: %s, return original data", e));
                return str;
            }
        }
    }

    @Override // com.alipay.iap.android.common.securitydata.encrypt.IDataEncrypt
    public String decrypt(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                LoggerWrapper.w(TAG, "decrypt data is empty, return empty data");
                return "";
            }
            IDynamicDataEncryptComponent iDynamicDataEncryptComponent = this.dynamicDataEncryptComponent;
            if (iDynamicDataEncryptComponent == null) {
                LoggerWrapper.w(TAG, "SecurityGuard not ready, return original data");
                return str;
            }
            try {
                return iDynamicDataEncryptComponent.dynamicDecryptDDp(str);
            } catch (SecException e) {
                LoggerWrapper.e(TAG, LoggerWrapper.buildMessage("decrypt data failed: %s, return original data", e));
                return str;
            }
        }
    }

    public static void unInit() {
        instance = null;
    }
}
