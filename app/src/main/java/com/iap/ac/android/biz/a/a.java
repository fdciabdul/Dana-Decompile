package com.iap.ac.android.biz.a;

import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.oauth.BaseAutoOAuthInterceptor;
import com.iap.ac.android.biz.common.model.remoteconfig.common.OAuthConfig;
import com.iap.ac.android.common.log.ACLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class a extends BaseAutoOAuthInterceptor {

    /* renamed from: a  reason: collision with root package name */
    public static Set<String> f7536a;
    public static Set<String> b;

    static {
        HashSet hashSet = new HashSet();
        f7536a = hashSet;
        hashSet.add(Constants.OperationType.CPM_ENCODE);
        f7536a.add(Constants.OperationType.CODE_SCAN);
        f7536a.add(Constants.OperationType.PAGE_QUERY);
        f7536a.add(Constants.OperationType.USER_INFO_QUERY);
        f7536a.add("ac.mobilepayment.user.phone.query");
        HashSet hashSet2 = new HashSet();
        b = hashSet2;
        hashSet2.add(Constants.OperationType.HOLD_LOGIN);
        b.add(Constants.OperationType.AUTH_LOGIN);
        b.add(Constants.OperationType.LOGOUT);
    }

    public a(String str) {
        super(str);
    }

    @Override // com.iap.ac.android.biz.common.internal.oauth.BaseAutoOAuthInterceptor
    public Set<String> getLoginIgnoredOpSet() {
        return b;
    }

    @Override // com.iap.ac.android.biz.common.internal.oauth.BaseAutoOAuthInterceptor
    public Set<String> getLoginRequiredOpSet() {
        HashSet hashSet = new HashSet(f7536a);
        List<String> authList = ConfigCenter.INSTANCE.getAuthList();
        if (authList != null) {
            hashSet.addAll(authList);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ACAutoOAuthInterceptor#getLoginRequiredOpSet, ");
        sb.append(hashSet);
        ACLog.d(Constants.TAG, sb.toString());
        return hashSet;
    }

    @Override // com.iap.ac.android.biz.common.internal.oauth.BaseAutoOAuthInterceptor
    public String getLoginSessionKeyInCookie() {
        return "ALIPAYINTLACJSESSIONID";
    }

    @Override // com.iap.ac.android.biz.common.internal.oauth.BaseAutoOAuthInterceptor
    public OAuthConfig getOAuthConfig() {
        return ACManager.getInstance().getOAuthConfig();
    }
}
