package com.iap.ac.android.biz.common.spi;

import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.acl.base.ResultError;
import com.alipay.iap.android.wallet.acl.onboarding.OnboardingService;
import com.alipay.iap.android.wallet.acl.onboarding.TrustLoginInfoFetchResult;
import com.iap.ac.android.biz.common.model.AcCallback;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.model.acl.AclAPIContext;
import com.iap.ac.android.biz.common.model.auth.TrustLoginInfo;

/* loaded from: classes3.dex */
public class AclOnboardingImpl extends AclBaseImpl {
    public OnboardingService mOnboardingService;

    public AclOnboardingImpl() {
        if (isAclAvailable()) {
            this.mOnboardingService = (OnboardingService) getAclService(OnboardingService.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TrustLoginInfo buildFailTrustLoginInfo(String str) {
        TrustLoginInfo trustLoginInfo = new TrustLoginInfo();
        trustLoginInfo.success = false;
        trustLoginInfo.errorCode = ResultCode.UNKNOWN_EXCEPTION;
        trustLoginInfo.errorMessage = str;
        return trustLoginInfo;
    }

    public void fetchTrustLoginCredentials(AclAPIContext aclAPIContext, final AcCallback<TrustLoginInfo> acCallback) {
        OnboardingService onboardingService = this.mOnboardingService;
        if (onboardingService != null) {
            onboardingService.fetchTrustLoginCredentials(APIContextFactory.convertToAPIContext(aclAPIContext), new Callback<TrustLoginInfoFetchResult>() { // from class: com.iap.ac.android.biz.common.spi.AclOnboardingImpl.1
                @Override // com.alipay.iap.android.wallet.acl.base.Callback
                public void result(TrustLoginInfoFetchResult trustLoginInfoFetchResult) {
                    TrustLoginInfo trustLoginInfo;
                    if (acCallback != null) {
                        if (trustLoginInfoFetchResult == null) {
                            trustLoginInfo = AclOnboardingImpl.this.buildFailTrustLoginInfo("null result from ACL");
                        } else {
                            TrustLoginInfo trustLoginInfo2 = new TrustLoginInfo();
                            trustLoginInfo2.signedCredential = trustLoginInfoFetchResult.getSignedCredential();
                            trustLoginInfo2.success = !trustLoginInfoFetchResult.isHasError();
                            ResultError resultError = trustLoginInfoFetchResult.getResultError();
                            if (resultError != null) {
                                trustLoginInfo2.errorCode = String.valueOf(resultError.errorCode);
                                trustLoginInfo2.errorMessage = resultError.errorDesc;
                            }
                            trustLoginInfo = trustLoginInfo2;
                        }
                        acCallback.onResult(trustLoginInfo);
                    }
                }
            });
            return;
        }
        if (acCallback != null) {
            acCallback.onResult(buildFailTrustLoginInfo("ACL OnboardingService is empty"));
        }
        handleForAclCallError("fetchTrustLoginCredentials", "ACL OnboardingService is empty");
    }
}
