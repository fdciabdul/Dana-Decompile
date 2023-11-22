package com.iap.ac.android.biz.common.internal.config.common;

import android.text.TextUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.config.utils.ConfigUtils;
import com.iap.ac.android.biz.common.model.remoteconfig.common.OAuthConfig;
import com.iap.ac.android.common.log.ACLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class OAuthConfigModel {
    public List<String> mBakScopes;
    public OAuthConfig mOAuthConfig;

    private void checkScopes() {
        List<String> list;
        OAuthConfig oAuthConfig = this.mOAuthConfig;
        if (oAuthConfig == null || (list = this.mBakScopes) == null || oAuthConfig.scopes == null || list.size() <= 0 || this.mOAuthConfig.scopes.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mOAuthConfig.scopes);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(this.mBakScopes);
        Collections.sort(arrayList);
        Collections.sort(arrayList2);
        if (arrayList.equals(arrayList2)) {
            return;
        }
        ACManager.getInstance().clear();
    }

    public OAuthConfig getAuthConfig() {
        OAuthConfig oAuthConfig;
        synchronized (this) {
            oAuthConfig = this.mOAuthConfig;
        }
        return oAuthConfig;
    }

    public boolean isValid() {
        return this.mOAuthConfig != null;
    }

    public boolean parseFromJson(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            ACLog.e(Constants.TAG, "OAuthConfigModel, parse error, invalid input");
            return false;
        }
        OAuthConfig oAuthConfig = this.mOAuthConfig;
        if (oAuthConfig != null) {
            this.mBakScopes = oAuthConfig.scopes;
        }
        synchronized (this) {
            this.mOAuthConfig = (OAuthConfig) ConfigUtils.fromJson(str, OAuthConfig.class);
            checkScopes();
            StringBuilder sb = new StringBuilder();
            sb.append("OAuthConfigModel, parse finish, success: ");
            sb.append(this.mOAuthConfig != null);
            ACLog.i(Constants.TAG, sb.toString());
            z = this.mOAuthConfig != null;
        }
        return z;
    }
}
