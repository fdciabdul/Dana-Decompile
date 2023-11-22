package com.iap.ac.android.biz.a;

import android.text.TextUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.oauth.BaseRewardsAutoOAuthInterceptor;
import com.iap.ac.android.biz.common.model.remoteconfig.common.OAuthConfig;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class b extends BaseRewardsAutoOAuthInterceptor {

    /* renamed from: a  reason: collision with root package name */
    public static Set<String> f7537a;

    static {
        HashSet hashSet = new HashSet();
        f7537a = hashSet;
        hashSet.add(Constants.APlusRewardsOperationType.REWARDS_AUTH_LOGIN);
        f7537a.add(Constants.APlusRewardsOperationType.REWARDS_HOLD_LOGIN);
    }

    public b(String str) {
        super(str);
    }

    @Override // com.iap.ac.android.biz.common.internal.oauth.BaseRewardsAutoOAuthInterceptor
    public Set<String> getLoginIgnoredOpSet() {
        return f7537a;
    }

    @Override // com.iap.ac.android.biz.common.internal.oauth.BaseRewardsAutoOAuthInterceptor
    public String getLoginSessionKeyInCookie() {
        return "ALIPAYPLUSREWARDSJSESSIONID";
    }

    @Override // com.iap.ac.android.biz.common.internal.oauth.BaseRewardsAutoOAuthInterceptor
    public OAuthConfig getOAuthConfig() {
        return ACManager.getInstance().getOAuthConfig();
    }

    @Override // com.iap.ac.android.biz.common.internal.oauth.BaseRewardsAutoOAuthInterceptor
    public boolean isLoginStatusRequired(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("ap.alipayplusrewards");
    }
}
