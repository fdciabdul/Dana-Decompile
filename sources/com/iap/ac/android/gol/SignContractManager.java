package com.iap.ac.android.gol;

import android.os.SystemClock;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.config.utils.ConfigUtils;
import com.iap.ac.android.biz.common.model.AcBaseResult;
import com.iap.ac.android.biz.common.model.AcCallback;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.model.gol.SignContractRequest;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.gol.biz.AuthUrlProcessor;
import com.iap.ac.android.gol.biz.BizContentAuthProcessor;
import com.iap.ac.android.gol.model.SignContractBizContent;
import com.iap.ac.android.gol.utils.GolMonitorUtils;

/* loaded from: classes3.dex */
public class SignContractManager {
    private static volatile SignContractManager mInstance;

    private SignContractManager() {
    }

    public static SignContractManager getInstance() {
        if (mInstance == null) {
            synchronized (SignContractManager.class) {
                if (mInstance == null) {
                    mInstance = new SignContractManager();
                }
            }
        }
        return mInstance;
    }

    public void signContract(boolean z, SignContractRequest signContractRequest, AcCallback<AcBaseResult> acCallback) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        sb.append("signContract enter: ");
        sb.append(signContractRequest);
        ACLog.i(Constants.TAG, sb.toString());
        if (signContractRequest == null || acCallback == null) {
            ACLog.e(Constants.TAG, "request or callback can not be null");
            return;
        }
        SignContractBizContent signContractBizContent = TextUtils.isEmpty(signContractRequest.bizContent) ? null : (SignContractBizContent) ConfigUtils.fromJson(signContractRequest.bizContent, SignContractBizContent.class);
        if (!z) {
            GolMonitorUtils.signContractBegin(signContractBizContent);
        }
        if (!ConfigCenter.INSTANCE.getGolSignContractToggle()) {
            handleFailCallback(acCallback, ResultCode.UNKNOWN_EXCEPTION, "Oops! System busy. Try again later!", "signContract feature is closed by configuration.", elapsedRealtime, z);
        } else if (signContractBizContent != null) {
            new BizContentAuthProcessor(z).signContract(signContractBizContent, signContractRequest.needCallback, acCallback);
        } else if (!TextUtils.isEmpty(signContractRequest.authUrl)) {
            new AuthUrlProcessor(z).handleAuthUrl(signContractRequest.authUrl, signContractRequest.needCallback, acCallback);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("bizContent and authUrl are both empty or bizContent invalid, bizContent:");
            sb2.append(signContractRequest.bizContent);
            handleFailCallback(acCallback, "PARAM_ILLEGAL", "Oops! System busy. Try again later!", sb2.toString(), elapsedRealtime, z);
        }
    }

    private void handleFailCallback(AcCallback<AcBaseResult> acCallback, String str, String str2, String str3, long j, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("signContract fail: ");
        sb.append(str3);
        ACLog.i(Constants.TAG, sb.toString());
        GolMonitorUtils.signContractFail(str3, null, j, z);
        AcBaseResult acBaseResult = new AcBaseResult();
        acBaseResult.success = false;
        acBaseResult.errorCode = str;
        acBaseResult.errorMessage = str2;
        acCallback.onResult(acBaseResult);
    }
}
