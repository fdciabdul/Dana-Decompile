package com.iap.ac.android.biz.common.callback;

import com.iap.ac.android.biz.common.model.AcCallback;
import com.iap.ac.android.biz.common.model.auth.AuthPageRequest;
import com.iap.ac.android.biz.common.model.auth.AuthPageResult;
import com.iap.ac.android.biz.common.model.auth.AuthRequest;
import java.util.List;

/* loaded from: classes3.dex */
public interface IOAuth {
    void getAuthCode(AuthRequest authRequest, IAuthCallback iAuthCallback);

    void getAuthCode(String str, IAuthCallback iAuthCallback);

    void getAuthCode(String str, String str2, List<String> list, IAuthCallback iAuthCallback);

    void showAuthPage(AuthPageRequest authPageRequest, AcCallback<AuthPageResult> acCallback);
}
