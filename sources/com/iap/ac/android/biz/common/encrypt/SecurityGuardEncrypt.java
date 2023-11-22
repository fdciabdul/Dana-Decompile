package com.iap.ac.android.biz.common.encrypt;

import android.content.Context;
import com.alibaba.griver.base.common.constants.SecurityConstants;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.iap.ac.android.biz.accommon.a.a;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes3.dex */
public class SecurityGuardEncrypt {
    public static boolean mInitialized;
    public Context mContext;

    public SecurityGuardEncrypt(Context context) {
        mInitialized = checkSecurityGuardExist();
        this.mContext = context;
    }

    private boolean checkSecurityGuardExist() {
        if (Utils.checkClassExist(SecurityConstants.SG_CLASS) && Utils.checkClassExist("com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent")) {
            ACLog.i(Constants.TAG, "encrypt powered by securityGuard exist");
            return true;
        }
        ACLog.e(Constants.TAG, "encrypt powered by securityGuard does not exist");
        return false;
    }

    public String dynamicDataDecrypt(String str) {
        String obj;
        SecurityGuardManager securityGuardManager;
        synchronized (this) {
            if (mInitialized) {
                try {
                    securityGuardManager = SecurityGuardManager.getInstance(this.mContext);
                } catch (Exception e) {
                    StringBuilder a2 = a.a("decrypt ddp string failed with error msg:");
                    a2.append(Utils.formatSecurityGuardException(e));
                    obj = a2.toString();
                    ACLog.e(Constants.TAG, obj);
                }
                if (securityGuardManager != null) {
                    IDynamicDataEncryptComponent dynamicDataEncryptComp = securityGuardManager.getDynamicDataEncryptComp();
                    if (dynamicDataEncryptComp == null) {
                        ACLog.e(Constants.TAG, "decrypt ddp string failed ddeComp is null");
                        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_DECRYPT_FAIL, "decrypt ddp string failed ddeComp is null");
                        return null;
                    }
                    String dynamicDecryptDDp = dynamicDataEncryptComp.dynamicDecryptDDp(str);
                    if (dynamicDecryptDDp != null) {
                        return dynamicDecryptDDp;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("decrypt return null string with sourceStr: ");
                    sb.append(str);
                    obj = sb.toString();
                    ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_DECRYPT_FAIL, obj);
                    return null;
                }
            }
            obj = "check security guard not exist";
            ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_DECRYPT_FAIL, obj);
            return null;
        }
    }

    public String dynamicDataEncrypt(String str) {
        String obj;
        SecurityGuardManager securityGuardManager;
        synchronized (this) {
            if (mInitialized) {
                try {
                    securityGuardManager = SecurityGuardManager.getInstance(this.mContext);
                } catch (Throwable th) {
                    StringBuilder a2 = a.a("encrypt ddp string failed with error msg:");
                    a2.append(Utils.formatSecurityGuardException(th));
                    obj = a2.toString();
                    ACLog.e(Constants.TAG, obj);
                }
                if (securityGuardManager != null) {
                    IDynamicDataEncryptComponent dynamicDataEncryptComp = securityGuardManager.getDynamicDataEncryptComp();
                    if (dynamicDataEncryptComp == null) {
                        ACLog.e(Constants.TAG, "encrypt ddp string failed ddeComp is null");
                        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_ENCRYPT_FAIL, "encrypt ddp string failed ddeComp is null");
                        return null;
                    }
                    String dynamicEncryptDDp = dynamicDataEncryptComp.dynamicEncryptDDp(str);
                    if (dynamicEncryptDDp != null) {
                        return dynamicEncryptDDp;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("encrypt return null string with sourceStr: ");
                    sb.append(str);
                    obj = sb.toString();
                    ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_ENCRYPT_FAIL, obj);
                    return null;
                }
            }
            obj = "check security guard not exist";
            ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_ENCRYPT_FAIL, obj);
            return null;
        }
    }
}
