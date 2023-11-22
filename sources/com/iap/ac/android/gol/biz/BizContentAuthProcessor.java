package com.iap.ac.android.gol.biz;

import android.os.SystemClock;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.callback.IAuthCallback;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.AcBaseResult;
import com.iap.ac.android.biz.common.model.AcCallback;
import com.iap.ac.android.biz.common.model.AuthResult;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.model.auth.AuthPageRequest;
import com.iap.ac.android.biz.common.model.auth.AuthPageResult;
import com.iap.ac.android.biz.common.model.auth.AuthRequest;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.gol.model.SignContractBizContent;

/* loaded from: classes3.dex */
public class BizContentAuthProcessor extends BaseAuthProcessor {
    private SignContractBizContent mBizContent;

    public BizContentAuthProcessor(boolean z) {
        super(z);
        this.mBizContent = new SignContractBizContent();
    }

    public void signContract(final SignContractBizContent signContractBizContent, boolean z, AcCallback<AcBaseResult> acCallback) {
        ACLog.i(Constants.TAG, "signContract BizContentAuthProcessor enter");
        this.mStartTime = SystemClock.elapsedRealtime();
        this.mAuthRedirectUrl = signContractBizContent.authRedirectUrl;
        this.mAuthState = signContractBizContent.authState;
        this.mNeedCallback = z;
        this.mBizContent = signContractBizContent;
        this.mCallback = acCallback;
        this.mReferenceAgreementId = signContractBizContent.referenceAgreementId;
        this.mPassThroughInfo = signContractBizContent.passThroughInfo;
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.gol.biz.BizContentAuthProcessor.1
            @Override // java.lang.Runnable
            public void run() {
                BizContentAuthProcessor.this.signContractInThread(signContractBizContent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signContractInThread(SignContractBizContent signContractBizContent) {
        ACLog.i(Constants.TAG, "signContract BizContentAuthProcessor enter in thread");
        AuthPageRequest authPageRequest = new AuthPageRequest();
        authPageRequest.authClientLogo = signContractBizContent.authClientLogo;
        authPageRequest.authClientName = signContractBizContent.authClientName;
        authPageRequest.clientId = signContractBizContent.clientId;
        authPageRequest.passThroughInfo = signContractBizContent.passThroughInfo;
        SPIManager.getInstance().showAuthPage(authPageRequest, new AcCallback<AuthPageResult>() { // from class: com.iap.ac.android.gol.biz.BizContentAuthProcessor.2
            @Override // com.iap.ac.android.biz.common.model.AcCallback
            public void onResult(AuthPageResult authPageResult) {
                BizContentAuthProcessor.this.handleAuthPageResult(authPageResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthPageResult(AuthPageResult authPageResult) {
        if (authPageResult != null && authPageResult.success) {
            AuthRequest authRequest = new AuthRequest();
            authRequest.acquirerId = this.mBizContent.acquirerId;
            authRequest.authClientId = this.mBizContent.authClientId;
            authRequest.authRedirectUrl = this.mBizContent.authRedirectUrl;
            authRequest.clientId = this.mBizContent.clientId;
            authRequest.referenceAgreementId = this.mBizContent.referenceAgreementId;
            if (!TextUtils.isEmpty(authPageResult.referenceAgreementId)) {
                authRequest.referenceAgreementId = authPageResult.referenceAgreementId;
            }
            authRequest.scopes = this.mBizContent.scopes;
            authRequest.passThroughInfo = this.mBizContent.passThroughInfo;
            SPIManager.getInstance().getAuthCode(authRequest, new IAuthCallback() { // from class: com.iap.ac.android.gol.biz.BizContentAuthProcessor.3
                @Override // com.iap.ac.android.biz.common.callback.IAuthCallback
                public void onResult(AuthResult authResult) {
                    BizContentAuthProcessor.this.handleAuthResult(authResult);
                }
            });
            return;
        }
        String str = (authPageResult == null || TextUtils.isEmpty(authPageResult.errorCode)) ? ResultCode.UNKNOWN_EXCEPTION : authPageResult.errorCode;
        String str2 = (authPageResult == null || TextUtils.isEmpty(authPageResult.errorMessage)) ? "Oops! System busy. Try again later!" : authPageResult.errorMessage;
        handleCallback(false, str, str2, String.format("signContract error with showAuthPage: %s, %s ", str, str2));
    }
}
