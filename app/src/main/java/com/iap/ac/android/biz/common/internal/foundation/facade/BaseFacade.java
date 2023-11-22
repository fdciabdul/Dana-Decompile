package com.iap.ac.android.biz.common.internal.foundation.facade;

import android.content.Context;
import com.iap.ac.android.biz.common.model.CommonConfig;

/* loaded from: classes3.dex */
public abstract class BaseFacade {
    public String mBizCode;
    public CommonConfig mConfig;
    public Context mContext;

    public void initComponent(Context context, String str, CommonConfig commonConfig) {
        this.mContext = context;
        this.mBizCode = str;
        this.mConfig = commonConfig;
    }

    public abstract boolean isInitialized();
}
