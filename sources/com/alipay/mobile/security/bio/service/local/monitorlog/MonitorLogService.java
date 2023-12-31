package com.alipay.mobile.security.bio.service.local.monitorlog;

import android.content.Context;
import com.alipay.mobile.security.bio.log.BehaviourIdEnum;
import com.alipay.mobile.security.bio.log.VerifyBehavior;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.local.LocalService;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class MonitorLogService extends LocalService {
    protected static boolean sInitialized;

    public void install(Context context) {
    }

    public void keyBizTrace(String str, String str2, String str3, Map<String, String> map) {
    }

    public abstract void logBehavior(BehaviourIdEnum behaviourIdEnum, VerifyBehavior verifyBehavior);

    public void trigUpload() {
    }

    @Override // com.alipay.mobile.security.bio.service.local.LocalService, com.alipay.mobile.security.bio.service.BioService
    public void onCreate(BioServiceManager bioServiceManager) {
        Context bioApplicationContext;
        super.onCreate(bioServiceManager);
        if (sInitialized || bioServiceManager == null || (bioApplicationContext = bioServiceManager.getBioApplicationContext()) == null) {
            return;
        }
        install(bioApplicationContext);
        sInitialized = true;
    }
}
