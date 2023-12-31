package com.iap.ac.android.biz.common.internal.foundation.facade;

import android.content.Context;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.gradient.Gradient;

/* loaded from: classes8.dex */
public class GradientFacade extends BaseFacade {
    public static boolean mInitialized;

    @Override // com.iap.ac.android.biz.common.internal.foundation.facade.BaseFacade
    public void initComponent(Context context, String str, CommonConfig commonConfig) {
        super.initComponent(context, str, commonConfig);
        if (!Utils.checkClassExist("com.iap.ac.android.gradient.Gradient")) {
            ACLog.e(Constants.TAG, "GradientFacade#initComponent, gradient init error, without dependent libraries");
            return;
        }
        Gradient.getInstance().initialize(context, str);
        mInitialized = true;
    }

    @Override // com.iap.ac.android.biz.common.internal.foundation.facade.BaseFacade
    public boolean isInitialized() {
        return mInitialized;
    }
}
