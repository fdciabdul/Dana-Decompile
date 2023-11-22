package com.iap.ac.android.biz.common.internal.foundation.facade;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.common.account.ACUserInfo;
import com.iap.ac.android.common.account.ACUserInfoManager;
import com.iap.ac.android.common.account.IOAuthLoginCallback;
import com.iap.ac.android.common.account.IOAuthService;
import com.iap.ac.android.common.account.IUserInfoManager;
import com.iap.ac.android.common.account.OAuthObserver;
import com.iap.ac.android.common.account.OAuthService;
import com.iap.ac.android.common.log.ACLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class UserInfoFacade extends BaseFacade implements IUserInfoManager, IOAuthService {
    public static boolean mInitialized;
    public List<OAuthObserver> mOAuthObservers = new ArrayList();
    public ACUserInfo mUserInfo;

    @Override // com.iap.ac.android.common.account.IUserInfoManager
    public String getOpenId() {
        ACUserInfo aCUserInfo = this.mUserInfo;
        if (aCUserInfo == null) {
            ACLog.e(Constants.TAG, "UserInfoFacade, getOpenId error, null userInfo");
            return null;
        }
        return aCUserInfo.openId;
    }

    @Override // com.iap.ac.android.common.account.IUserInfoManager
    public ACUserInfo getUserInfo() {
        return this.mUserInfo;
    }

    @Override // com.iap.ac.android.biz.common.internal.foundation.facade.BaseFacade
    public void initComponent(Context context, String str, CommonConfig commonConfig) {
        super.initComponent(context, str, commonConfig);
        synchronized (this) {
            mInitialized = false;
            ACUserInfoManager.setUserInfoManager(this, str);
            String fetch = ACManager.getInstance().fetch(ACManager.getInstance().getOpenIdStorageKey(str));
            if (!TextUtils.isEmpty(fetch)) {
                ACUserInfo aCUserInfo = new ACUserInfo();
                this.mUserInfo = aCUserInfo;
                aCUserInfo.openId = fetch;
            }
            OAuthService.INSTANCE.setOAuthService(this);
            StringBuilder sb = new StringBuilder();
            sb.append("UserInfo component initialize finish, openId: ");
            sb.append(getOpenId());
            ACLog.i(Constants.TAG, sb.toString());
            mInitialized = true;
        }
    }

    @Override // com.iap.ac.android.common.account.IOAuthService
    public boolean isAuthorized() {
        return false;
    }

    @Override // com.iap.ac.android.biz.common.internal.foundation.facade.BaseFacade
    public boolean isInitialized() {
        return mInitialized;
    }

    @Override // com.iap.ac.android.common.account.IOAuthService
    public void notifyOAuthLogin(String str, IOAuthLoginCallback iOAuthLoginCallback) {
        ACLog.i(Constants.TAG, "notifyOAuthLogin enter");
        synchronized (this.mOAuthObservers) {
            Iterator<OAuthObserver> it = this.mOAuthObservers.iterator();
            while (it.hasNext()) {
                it.next().onOAuthLogin();
            }
        }
    }

    @Override // com.iap.ac.android.common.account.IOAuthService
    public void notifyOAuthLogout() {
        ACLog.i(Constants.TAG, "notifyOAuthLogout enter");
        synchronized (this.mOAuthObservers) {
            Iterator<OAuthObserver> it = this.mOAuthObservers.iterator();
            while (it.hasNext()) {
                it.next().onOAuthLogout();
            }
        }
    }

    @Override // com.iap.ac.android.common.account.IOAuthService
    public void registerOAuthEventObserver(OAuthObserver oAuthObserver) {
        ACLog.i(Constants.TAG, "registerOAuthEventObserver enter");
        if (oAuthObserver == null) {
            ACLog.e(Constants.TAG, "registerOAuthEventObserver with null observer");
            return;
        }
        synchronized (this.mOAuthObservers) {
            this.mOAuthObservers.add(oAuthObserver);
        }
    }

    @Override // com.iap.ac.android.common.account.IUserInfoManager
    public boolean setUserInfo(ACUserInfo aCUserInfo) {
        this.mUserInfo = aCUserInfo;
        return true;
    }

    @Override // com.iap.ac.android.common.account.IOAuthService
    public void unregisterAllOAuthEventObservers() {
        ACLog.i(Constants.TAG, "unregisterAllOAuthEventObservers enter");
        synchronized (this.mOAuthObservers) {
            this.mOAuthObservers.clear();
        }
    }

    @Override // com.iap.ac.android.common.account.IOAuthService
    public void unregisterOAuthEventObserver(OAuthObserver oAuthObserver) {
        ACLog.i(Constants.TAG, "unregisterOAuthEventObserver enter");
        if (oAuthObserver == null) {
            ACLog.e(Constants.TAG, "unregisterOAuthEventObserver with null observer");
            return;
        }
        synchronized (this.mOAuthObservers) {
            this.mOAuthObservers.remove(oAuthObserver);
        }
    }
}
