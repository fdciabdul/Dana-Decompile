package com.iap.ac.android.biz.common.callback;

import com.iap.ac.android.biz.common.model.OAuthUserInfo;
import com.iap.ac.android.biz.common.model.OpenUserInfoCallback;

/* loaded from: classes3.dex */
public interface UserDelegate {
    String getOpenId();

    void getOpenUserInfo(OAuthUserInfo oAuthUserInfo, OpenUserInfoCallback openUserInfoCallback);
}
