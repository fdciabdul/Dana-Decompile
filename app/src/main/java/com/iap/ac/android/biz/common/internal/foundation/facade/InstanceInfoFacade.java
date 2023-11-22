package com.iap.ac.android.biz.common.internal.foundation.facade;

import android.content.Context;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.instance.IInstanceInfo;
import com.iap.ac.android.common.instance.InstanceInfo;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.instance.IAPInstanceInfo;

/* loaded from: classes8.dex */
public class InstanceInfoFacade extends BaseFacade {
    public static boolean mInitialized;

    @Override // com.iap.ac.android.biz.common.internal.foundation.facade.BaseFacade
    public void initComponent(Context context, String str, CommonConfig commonConfig) {
        super.initComponent(context, str, commonConfig);
        synchronized (this) {
            mInitialized = false;
            if (Utils.checkClassExist("com.iap.ac.android.instance.IAPInstanceInfo")) {
                InstanceInfo.setInstanceInfoImpl(new IInstanceInfo() { // from class: com.iap.ac.android.biz.common.internal.foundation.facade.InstanceInfoFacade.1
                    @Override // com.iap.ac.android.common.instance.IInstanceInfo
                    public String getInstanceId(Context context2) {
                        return IAPInstanceInfo.instanceId(context2);
                    }

                    @Override // com.iap.ac.android.common.instance.IInstanceInfo
                    public String getTid(Context context2) {
                        return IAPInstanceInfo.tid(context2);
                    }
                });
                ACLog.i(Constants.TAG, "InstanceInfo component initialize finish");
                mInitialized = true;
            } else {
                ACLog.e(Constants.TAG, "InstanceInfoFacade initialize error, cannot find class");
            }
        }
    }

    @Override // com.iap.ac.android.biz.common.internal.foundation.facade.BaseFacade
    public boolean isInitialized() {
        return mInitialized;
    }
}
