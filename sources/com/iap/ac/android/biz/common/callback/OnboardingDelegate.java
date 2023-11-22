package com.iap.ac.android.biz.common.callback;

import com.iap.ac.android.biz.common.model.AcCallback;
import com.iap.ac.android.biz.common.model.auth.TrustLoginInfo;

/* loaded from: classes8.dex */
public interface OnboardingDelegate {
    void fetchTrustLoginCredentials(AcCallback<TrustLoginInfo> acCallback);
}
