package com.iap.ac.config.lite.i;

import com.iap.ac.android.common.account.ACUserInfo;
import com.iap.ac.android.common.account.IUserInfoManager;
import com.iap.ac.config.lite.ConfigCenterContext;

/* loaded from: classes8.dex */
public class a implements IUserInfoManager {

    /* renamed from: a  reason: collision with root package name */
    ConfigCenterContext f7644a;
    ACUserInfo b;

    public a(ConfigCenterContext configCenterContext) {
        this.f7644a = configCenterContext;
    }

    @Override // com.iap.ac.android.common.account.IUserInfoManager
    public String getOpenId() {
        return this.f7644a.getIdentifierProvider().getConfigUserId(this.f7644a.getContext());
    }

    @Override // com.iap.ac.android.common.account.IUserInfoManager
    public ACUserInfo getUserInfo() {
        if (this.b == null) {
            ACUserInfo aCUserInfo = new ACUserInfo();
            this.b = aCUserInfo;
            aCUserInfo.openId = getOpenId();
        }
        return this.b;
    }

    @Override // com.iap.ac.android.common.account.IUserInfoManager
    public boolean setUserInfo(ACUserInfo aCUserInfo) {
        return false;
    }
}
