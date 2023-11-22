package com.iap.ac.android.acs.operation.biz.region.foundation.facade;

import android.content.Context;
import com.iap.ac.android.acs.operation.biz.region.config.RegionCommonConfig;
import com.iap.ac.android.acs.operation.biz.region.foundation.BaseRegionFacade;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.common.account.ACUserInfo;
import com.iap.ac.android.common.account.ACUserInfoManager;
import com.iap.ac.android.common.account.IUserInfoManager;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes8.dex */
public class RegionUserInfoFacade extends BaseRegionFacade implements IUserInfoManager {
    public static boolean mInitialized;
    public ACUserInfo mUserInfo;

    @Override // com.iap.ac.android.common.account.IUserInfoManager
    public String getOpenId() {
        ACUserInfo aCUserInfo = this.mUserInfo;
        if (aCUserInfo == null) {
            ACLog.w("IAPConnectPlugin", "RegionUserInfoFacade#getOpenId userInfo is null, try to get from SPIManager#getOpenId");
            return SPIManager.getInstance().getOpenId();
        }
        return aCUserInfo.openId;
    }

    @Override // com.iap.ac.android.common.account.IUserInfoManager
    public ACUserInfo getUserInfo() {
        return this.mUserInfo;
    }

    @Override // com.iap.ac.android.acs.operation.biz.region.foundation.BaseRegionFacade
    public void initComponent(Context context, String str, RegionCommonConfig regionCommonConfig) {
        super.initComponent(context, str, regionCommonConfig);
        synchronized (this) {
            mInitialized = false;
            ACUserInfoManager.setUserInfoManager(this, str);
            StringBuilder sb = new StringBuilder();
            sb.append("RegionUserInfoFacade, initComponent finish, openId: ");
            sb.append(getOpenId());
            ACLog.i("IAPConnectPlugin", sb.toString());
            mInitialized = true;
        }
    }

    @Override // com.iap.ac.android.acs.operation.biz.region.foundation.BaseRegionFacade
    public boolean isInitialized() {
        return mInitialized;
    }

    @Override // com.iap.ac.android.common.account.IUserInfoManager
    public boolean setUserInfo(ACUserInfo aCUserInfo) {
        this.mUserInfo = aCUserInfo;
        return true;
    }
}
