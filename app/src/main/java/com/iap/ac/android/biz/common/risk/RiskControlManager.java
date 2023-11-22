package com.iap.ac.android.biz.common.risk;

import android.text.TextUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.configcenter.Constant;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes3.dex */
public class RiskControlManager {
    public static String mApdidToken;
    public static volatile RiskControlManager mInstance;
    public ApdidTokenReportProcessor mApdidTokenReportProcessor;

    public static RiskControlManager getInstance() {
        if (mInstance == null) {
            synchronized (RiskControlManager.class) {
                if (mInstance == null) {
                    mInstance = new RiskControlManager();
                }
            }
        }
        return mInstance;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String tryGetSecuritySDKToken(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "com.alipay.alipaysecuritysdk.apdid.face.APSecuritySdk"
            boolean r0 = com.iap.ac.android.biz.common.utils.Utils.checkClassExist(r0)     // Catch: java.lang.Throwable -> L11
            if (r0 == 0) goto L29
            com.alipay.alipaysecuritysdk.apdid.face.APSecuritySdk r4 = com.alipay.alipaysecuritysdk.apdid.face.APSecuritySdk.getInstance(r4)     // Catch: java.lang.Throwable -> L11
            java.lang.String r4 = r4.getApdidToken()     // Catch: java.lang.Throwable -> L11
            goto L2a
        L11:
            r4 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "tryGetSecuritySDKToken error: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = "IAPConnect"
            com.iap.ac.android.common.log.ACLog.e(r0, r4)
        L29:
            r4 = 0
        L2a:
            java.lang.String r0 = "iapconnect_center"
            java.lang.String r1 = "ac_apdidtoken_generate"
            com.iap.ac.android.biz.common.utils.log.ACLogEvent r0 = com.iap.ac.android.biz.common.utils.log.ACLogEvent.newLogger(r0, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 == 0) goto L3b
            java.lang.String r1 = "F"
            goto L3d
        L3b:
            java.lang.String r1 = "T"
        L3d:
            java.lang.String r2 = "result"
            com.iap.ac.android.biz.common.utils.log.ACLogEvent r0 = r0.addParams(r2, r1)
            r0.event()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.biz.common.risk.RiskControlManager.tryGetSecuritySDKToken(android.content.Context):java.lang.String");
    }

    public String getApdidTokenUploadMode() {
        return (String) ConfigCenter.INSTANCE.getKeyOrDefault(Constant.KEY_APDID_TOKEN_UPLOAD_MODE, "from_psp");
    }

    public boolean getApdidTokenUploadToggle() {
        return ((Boolean) ConfigCenter.INSTANCE.getKeyOrDefault(Constant.KEY_TOGGLE_APDID_TOKEN_UPLOAD, Boolean.FALSE)).booleanValue();
    }

    public String getTokenId() {
        return mApdidToken;
    }

    public void init() {
        reportApdidToken();
    }

    public void reportApdidToken() {
        if (!getApdidTokenUploadToggle()) {
            ACLog.d(Constants.TAG, "apdidToken upload toggle is closed");
            return;
        }
        String apdidTokenUploadMode = getApdidTokenUploadMode();
        if (!TextUtils.equals(apdidTokenUploadMode, "from_psp")) {
            ACLog.d(Constants.TAG, String.format("apdidToken upload mode is %s, no need to upload.", apdidTokenUploadMode));
            return;
        }
        String tryGetSecuritySDKToken = tryGetSecuritySDKToken(ACManager.getInstance().getContext());
        mApdidToken = tryGetSecuritySDKToken;
        if (TextUtils.isEmpty(tryGetSecuritySDKToken)) {
            ACLog.d(Constants.TAG, "apdidToken is empty");
        }
    }
}
