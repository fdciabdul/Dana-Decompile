package com.iap.ac.android.biz.common.encrypt;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.plus.security.lite.SecurityGuardLiteManager;
import com.iap.ac.android.biz.accommon.a.a;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes3.dex */
public class SecurityGuardLiteEncrypt {
    public static boolean mInitialized;
    public Context mContext;

    public SecurityGuardLiteEncrypt(Context context) {
        mInitialized = checkSecurityGuardExist();
        this.mContext = context;
    }

    private boolean checkSecurityGuardExist() {
        if (!Utils.checkClassExist("com.alipay.plus.security.lite.SecurityGuardLiteManager")) {
            ACLog.e(Constants.TAG, "encrypt powered by security lite does not exist");
            return false;
        }
        ACLog.i(Constants.TAG, "encrypt powered by security lite exist");
        return true;
    }

    public String dynamicDataDecrypt(String str) {
        synchronized (this) {
            if (mInitialized) {
                try {
                    String decrypt = SecurityGuardLiteManager.getInstance(this.mContext).decrypt(str);
                    if (TextUtils.isEmpty(decrypt)) {
                        ACLog.e(Constants.TAG, "decrypt ddp string failed decrypt is null");
                    }
                    return decrypt;
                } catch (Exception e) {
                    StringBuilder a2 = a.a("decrypt ddp string failed with error msg:");
                    a2.append(Utils.formatSecurityGuardException(e));
                    ACLog.e(Constants.TAG, a2.toString());
                }
            }
            return null;
        }
    }

    public String dynamicDataEncrypt(String str) {
        synchronized (this) {
            if (mInitialized) {
                try {
                    String encrypt = SecurityGuardLiteManager.getInstance(this.mContext).encrypt(str);
                    if (TextUtils.isEmpty(encrypt)) {
                        ACLog.e(Constants.TAG, "encrypt ddp string failed ddeComp is null");
                        return null;
                    }
                    return encrypt;
                } catch (Throwable th) {
                    StringBuilder a2 = a.a("encrypt ddp string failed with error msg:");
                    a2.append(Utils.formatSecurityGuardException(th));
                    ACLog.e(Constants.TAG, a2.toString());
                }
            }
            return null;
        }
    }
}
