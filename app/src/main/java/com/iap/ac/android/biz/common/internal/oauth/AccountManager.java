package com.iap.ac.android.biz.common.internal.oauth;

import android.text.TextUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.internal.consts.InnerConstants;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.common.account.ACUserInfoManager;

/* loaded from: classes3.dex */
public class AccountManager {
    public static volatile AccountManager mInstance;
    public String mBizCode;
    public OAuthManager oAuthManager;
    public RewardsOAuthManager rewardsOAuthManager;

    public AccountManager(String str) {
        this.mBizCode = str;
    }

    public static AccountManager getInstance(String str) {
        if (mInstance == null) {
            synchronized (AccountManager.class) {
                if (mInstance == null) {
                    mInstance = new AccountManager(str);
                }
            }
        }
        return mInstance;
    }

    public boolean clearLoginStatus() {
        String openId = SPIManager.getInstance().getOpenId();
        if (TextUtils.isEmpty(openId) || openId.equals(ACManager.getInstance().fetch(InnerConstants.STORAGE_KEY_AC_LOCAL_OPEN_ID))) {
            return true;
        }
        RewardsOAuthManager rewardsOAuthManager = this.rewardsOAuthManager;
        if (rewardsOAuthManager != null) {
            rewardsOAuthManager.syncStartOAuthLogout();
        }
        OAuthManager oAuthManager = this.oAuthManager;
        if (oAuthManager != null) {
            oAuthManager.syncStartOAuthLogout();
        }
        ACManager.getInstance().clear();
        ACUserInfoManager.getInstance(this.mBizCode).setUserInfo(null);
        ACManager.getInstance().save(InnerConstants.STORAGE_KEY_AC_LOCAL_OPEN_ID, openId);
        return false;
    }

    public OAuthManager getOAuthManager() {
        return this.oAuthManager;
    }

    public RewardsOAuthManager getRewardsOAuthManager() {
        return this.rewardsOAuthManager;
    }

    public void setRewardsOAuthManager(RewardsOAuthManager rewardsOAuthManager) {
        this.rewardsOAuthManager = rewardsOAuthManager;
    }

    public void setoAuthManager(OAuthManager oAuthManager) {
        this.oAuthManager = oAuthManager;
    }
}
