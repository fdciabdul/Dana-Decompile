package com.alibaba.griver.base.resource.extensions;

import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.content.AppxNgResourcePackage;
import com.alibaba.ariver.resource.parser.ParseContext;
import com.alibaba.ariver.resource.parser.ParseFailedException;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.ToastUtils;

/* loaded from: classes6.dex */
public class GriverAppXNgResourcePackage extends AppxNgResourcePackage {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6361a;
    private ResourceContext b;

    public GriverAppXNgResourcePackage(ResourceContext resourceContext) {
        super(resourceContext);
        this.f6361a = false;
        this.b = resourceContext;
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onVerifyError(ParseFailedException parseFailedException) {
        super.onVerifyError(parseFailedException);
        this.f6361a = true;
        GriverMonitor.error(GriverMonitorConstants.ERROR_VERIFY_APP_FAIL, "GriverAppContainer", new MonitorMap.Builder().appId(appId()).version(getAppModel()).exception(parseFailedException).message(GriverMonitorConstants.MESSAGE_VERIFY_APPX_ERROR).needAsynAppType(true).build());
        if (GriverEnv.isDebuggable()) {
            ToastUtils.showToast(GriverEnv.getApplicationContext(), "Mini program framework(APPX) verify error.", 0);
        }
    }

    public boolean verifyFailed() {
        return this.f6361a;
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onParseDone() {
        super.onParseDone();
        GriverMonitor.event(GriverMonitorConstants.EVENT_VERIFY_APP, "GriverAppContainer", new MonitorMap.Builder().appId(appId()).version(getAppModel()).needAsynAppType(true).build());
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void afterParsePackage(ParseContext parseContext) {
        super.afterParsePackage(parseContext);
        if (this.f6361a) {
            GriverLogger.w("GriverAppXResourcePackage", "verify failed, do not send load monitor");
        } else if (getAppModel() == null) {
            GriverLogger.w("GriverAppXResourcePackage", "can not find app model, do not sent load monitor");
        } else {
            GriverMonitor.event(GriverMonitorConstants.EVENT_LOAD_OFFLINE_PACKAGE, "GriverAppContainer", new MonitorMap.Builder().appId(getAppModel().getAppId()).version(getAppModel()).append(GriverMonitorConstants.KEY_PACKEGE_TYPE, "resource").needAsynAppType(true).build());
        }
    }
}
