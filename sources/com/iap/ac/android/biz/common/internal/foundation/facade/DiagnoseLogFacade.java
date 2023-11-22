package com.iap.ac.android.biz.common.internal.foundation.facade;

import android.app.Application;
import android.content.Context;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.config.ACConfig;
import com.iap.ac.android.common.config.IConfigChangeListener;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.diagnoselog.api.DiagnoseLogService;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class DiagnoseLogFacade extends BaseFacade {
    public static final boolean DEFAULT_DIAGNOSE_ENABLE = true;
    public static final String DIAGNOSE_DISABLE_VALUE = "no";
    public static final String KEY_ENABLE_DIAGNOSE = "diagnose_enable";
    public static boolean mInitialized;

    /* JADX INFO: Access modifiers changed from: private */
    public void setDiagnoseEnabled(String str) {
        DiagnoseLogService.setEnabled(!"no".equalsIgnoreCase(str));
    }

    @Override // com.iap.ac.android.biz.common.internal.foundation.facade.BaseFacade
    public void initComponent(Context context, String str, CommonConfig commonConfig) {
        super.initComponent(context, str, commonConfig);
        synchronized (this) {
            mInitialized = false;
            if (!Utils.checkClassExist("com.iap.ac.android.diagnoselog.api.DiagnoseLogService")) {
                ACLog.e(Constants.TAG, "diagnose log init error, without dependent libraries");
            } else if (context instanceof Application) {
                DiagnoseLogService.init((Application) context);
                setDiagnoseEnabled(ACConfig.getInstance(str).getString(KEY_ENABLE_DIAGNOSE));
                ACConfig.getInstance(str).addCommonConfigChangeListener(KEY_ENABLE_DIAGNOSE, new IConfigChangeListener() { // from class: com.iap.ac.android.biz.common.internal.foundation.facade.DiagnoseLogFacade.1
                    @Override // com.iap.ac.android.common.config.IConfigChangeListener
                    public void onConfigChanged(String str2, Object obj) {
                        if (DiagnoseLogFacade.KEY_ENABLE_DIAGNOSE.equals(str2) && (obj instanceof String)) {
                            DiagnoseLogFacade.this.setDiagnoseEnabled((String) obj);
                        }
                    }

                    @Override // com.iap.ac.android.common.config.IConfigChangeListener
                    public void onSectionConfigChanged(String str2, JSONObject jSONObject) {
                    }
                });
                ACLog.i(Constants.TAG, "diagnose log init success");
                mInitialized = true;
            } else {
                ACLog.w(Constants.TAG, "diagnose log init not complete, context is not application");
            }
        }
    }

    @Override // com.iap.ac.android.biz.common.internal.foundation.facade.BaseFacade
    public boolean isInitialized() {
        return mInitialized;
    }
}
