package com.alipay.plus.push.core;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.rome.longlinkservice.LongLinkMsgConstants;
import com.alipay.plus.push.core.api.util.MetaDataUtil;
import com.alipay.plus.push.core.model.PushSource;
import com.alipay.plus.push.core.model.ServiceDescription;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
public class PushServiceManager implements IPushServiceManager {
    private static Application application;
    private static Context context;
    private static PushServiceManager instance;
    private PushService pushService;

    @Override // com.alipay.plus.push.core.IPushServiceManager
    public void init(Application application2, PushSource pushSource) {
        if (this.pushService != null) {
            return;
        }
        if (application == null && pushSource != null) {
            application = application2;
            context = application2.getApplicationContext();
            initPushServiceImpl(pushSource);
        }
        initSDKConfig();
    }

    public void initSDKConfig() {
        Context context2 = context;
        if (context2 == null) {
            return;
        }
        PushConfig.appId = MetaDataUtil.getMetaData(context2, "ALIPUSH_APPID");
        PushConfig.workSpaceId = MetaDataUtil.getMetaData(context, "workspaceId");
        if (TextUtils.isEmpty(MetaDataUtil.getMetaData(context, "host"))) {
            PushConfig.mpsHost = "https://cn-hangzhou-mps-api.cloud.alipay.com";
        } else {
            PushConfig.mpsHost = MetaDataUtil.getMetaData(context, "host");
        }
        if (TextUtils.isEmpty(MetaDataUtil.getMetaData(context, "push.secret"))) {
            InstrumentInjector.log_e(LongLinkMsgConstants.MSG_PACKET_CHANNEL_PUSH, "rsa is empty");
        } else {
            PushConfig.rsa = MetaDataUtil.getMetaData(context, "push.secret");
        }
        if (TextUtils.isEmpty(PushConfig.appId)) {
            InstrumentInjector.log_e(LongLinkMsgConstants.MSG_PACKET_CHANNEL_PUSH, "appid is empty");
            return;
        }
        String str = PushConfig.appId;
        StringBuilder sb = new StringBuilder();
        sb.append("-");
        sb.append(PushConfig.workSpaceId);
        PushConfig.appId = str.replace(sb.toString(), "");
    }

    public void initialize(Application application2, PushService pushService) {
        if (application != null || pushService == null) {
            return;
        }
        application = application2;
        context = application2.getApplicationContext();
        initPushServiceImpl(pushService);
    }

    @Override // com.alipay.plus.push.core.IPushServiceManager
    public PushService getPushService() {
        return this.pushService;
    }

    private void initPushServiceImpl(PushSource pushSource) {
        if (application == null) {
            InstrumentInjector.log_e(PushExtConstants.GLOBAL_TAG, "We must init global context first");
        } else if (this.pushService != null) {
            InstrumentInjector.log_e(PushExtConstants.GLOBAL_TAG, "Now only support one push source");
        } else if (PushSource.FCM.equals(pushSource)) {
            ServiceDescription serviceDescription = new ServiceDescription();
            serviceDescription.setInterfaceClass("PushService");
            serviceDescription.setClassName("com.alipay.plus.android.push.fcm.FcmPushService");
            initService(serviceDescription);
        } else if (PushSource.JPUSH.equals(pushSource)) {
            ServiceDescription serviceDescription2 = new ServiceDescription();
            serviceDescription2.setInterfaceClass("PushService");
            serviceDescription2.setClassName("com.alipay.plus.android.push.jpush.JpushService");
            initService(serviceDescription2);
        } else if (PushSource.ALIPAY.equals(pushSource)) {
            ServiceDescription serviceDescription3 = new ServiceDescription();
            serviceDescription3.setInterfaceClass("PushService");
            serviceDescription3.setClassName("com.mpaas.pushaar.demo.demo_pushaar.AlipayPushSerice");
            initService(serviceDescription3);
        }
    }

    private void initPushServiceImpl(PushService pushService) {
        if (application == null) {
            InstrumentInjector.log_e(PushExtConstants.GLOBAL_TAG, "We must init global context first");
        } else if (this.pushService == null) {
            this.pushService = pushService;
        } else {
            InstrumentInjector.log_e(PushExtConstants.GLOBAL_TAG, "Now only support one push source");
        }
    }

    private void initService(ServiceDescription serviceDescription) {
        if (TextUtils.isEmpty(serviceDescription.getClassName()) || TextUtils.isEmpty(serviceDescription.getInterfaceClass())) {
            return;
        }
        try {
            Class<?> cls = Class.forName(serviceDescription.getClassName());
            if (cls != null) {
                PushService pushService = (PushService) cls.newInstance();
                this.pushService = pushService;
                pushService.init(context);
            }
        } catch (Exception e) {
            InstrumentInjector.log_d(PushExtConstants.GLOBAL_TAG, e.toString());
        }
    }
}
