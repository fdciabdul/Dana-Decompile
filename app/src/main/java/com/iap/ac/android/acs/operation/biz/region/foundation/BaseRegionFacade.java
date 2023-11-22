package com.iap.ac.android.acs.operation.biz.region.foundation;

import android.content.Context;
import com.iap.ac.android.acs.operation.biz.region.config.RegionCommonConfig;

/* loaded from: classes8.dex */
public abstract class BaseRegionFacade {
    public String mBizCode;
    public RegionCommonConfig mConfig;
    public Context mContext;

    public void initComponent(Context context, String str, RegionCommonConfig regionCommonConfig) {
        this.mContext = context;
        this.mBizCode = str;
        this.mConfig = regionCommonConfig;
    }

    public abstract boolean isInitialized();
}
