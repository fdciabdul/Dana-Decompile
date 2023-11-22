package com.alibaba.griver.base.resource.extensions;

import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.content.MainResourcePackage;
import com.alibaba.ariver.resource.parser.ParseContext;
import com.alibaba.ariver.resource.parser.ParseFailedException;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.resource.ResourceConstants;
import com.alibaba.griver.api.resource.extensions.GriverParseFailedPoint;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.resource.appcenter.GriverAppCenter;
import com.alibaba.griver.base.resource.point.BeforeGetMainPackageResourcePoint;

/* loaded from: classes6.dex */
public class GriverMainResourcePackage extends MainResourcePackage {

    /* renamed from: a  reason: collision with root package name */
    private ResourceContext f6363a;
    private boolean b;

    public GriverMainResourcePackage(ResourceContext resourceContext) {
        super(resourceContext);
        this.b = false;
        this.f6363a = resourceContext;
    }

    @Override // com.alibaba.ariver.resource.content.MainResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public Resource get(ResourceQuery resourceQuery) {
        if (BundleUtils.getBoolean(this.f6363a.getStartParams(), RVParams.isH5App, false)) {
            try {
                resourceQuery = ((BeforeGetMainPackageResourcePoint) ExtensionPoint.as(BeforeGetMainPackageResourcePoint.class).node(this.f6363a.getApp()).create()).beforeQuery(resourceQuery);
            } catch (Exception e) {
                GriverLogger.e("GriverMainResourcePackage", "map url failed", e);
            }
        }
        return super.get(resourceQuery);
    }

    @Override // com.alibaba.ariver.resource.content.MainResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onVerifyError(ParseFailedException parseFailedException) {
        super.onVerifyError(parseFailedException);
        this.b = true;
        BundleUtils.getBoolean(this.f6363a.getStartParams(), RVParams.isH5App, false);
        GriverMonitor.error(GriverMonitorConstants.ERROR_VERIFY_APP_FAIL, "GriverAppContainer", new MonitorMap.Builder().appId(appId()).version(getAppModel()).code(String.valueOf(parseFailedException.getCode())).exception(parseFailedException).message(GriverMonitorConstants.MESSAGE_VERIFY_MAIN_PACKAGE_ERROR).needAsynAppType(true).build());
        AppModel queryAppInfo = GriverAppCenter.queryAppInfo(appId(), version());
        if (queryAppInfo == null || AppInfoUtils.getAppType(queryAppInfo) != 2) {
            return;
        }
        ((GriverParseFailedPoint) ExtensionPoint.as(GriverParseFailedPoint.class).node(this.f6363a.getApp()).create()).parseFailed(parseFailedException);
    }

    @Override // com.alibaba.ariver.resource.content.MainResourcePackage, com.alibaba.ariver.resource.content.BaseResourcePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public boolean needWaitForSetup() {
        if (BundleUtils.getBoolean(this.f6363a.getStartParams(), RVParams.isH5App, false)) {
            return false;
        }
        return super.needWaitForSetup();
    }

    public boolean verifyFailed() {
        return this.b;
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onParseDone() {
        super.onParseDone();
        GriverMonitor.event(GriverMonitorConstants.EVENT_VERIFY_APP, "GriverAppContainer", new MonitorMap.Builder().appId(appId()).version(getAppModel()).needAsynAppType(true).build());
    }

    @Override // com.alibaba.ariver.resource.content.MainResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    public void afterParsePackage(ParseContext parseContext) {
        super.afterParsePackage(parseContext);
        if (this.b) {
            GriverLogger.w("GriverMainResourcePackage", "verify failed, do not send load monitor");
        } else if (getAppModel() == null) {
            GriverLogger.w("GriverMainResourcePackage", "can not find app model, do not sent load monitor");
        } else {
            GriverMonitor.event(GriverMonitorConstants.EVENT_LOAD_OFFLINE_PACKAGE, "GriverAppContainer", new MonitorMap.Builder().appId(getAppModel().getAppId()).version(getAppModel()).append(GriverMonitorConstants.KEY_PACKEGE_TYPE, "main").needAsynAppType(true).build());
        }
    }

    @Override // com.alibaba.ariver.resource.content.MainResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    public void beforeParsePackage(ParseContext parseContext) {
        super.beforeParsePackage(parseContext);
        if (AppInfoUtils.isEmbeddedApp(getAppModel())) {
            parseContext.appId = ResourceConstants.TINY_WEB_EMBEDDED_APPID;
        }
    }
}
