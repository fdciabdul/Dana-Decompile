package com.alipay.iap.android.wallet.acl.onboarding;

import com.alipay.iap.android.wallet.acl.base.APIContext;
import com.alipay.iap.android.wallet.acl.base.BaseService;
import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.acl.base.ServiceCategory;
import com.alipay.iap.android.wallet.acl.base.ServiceMetaInfo;
import com.alipay.iap.android.wallet.acl.base.ServiceType;

@ServiceMetaInfo(category = ServiceCategory.ACL, serviceName = "aplus.service.onboarding", type = ServiceType.ONBOARDING)
/* loaded from: classes2.dex */
public interface OnboardingService extends BaseService {
    void fetchTrustLoginCredentials(APIContext aPIContext, Callback<TrustLoginInfoFetchResult> callback);
}
