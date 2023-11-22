package com.alibaba.ariver.resource.content;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;

/* loaded from: classes6.dex */
public class AppxResourcePackage extends NormalResourcePackage {
    public static final String APPX_RENDER_JS_URL = "https://appx/af-appx.min.js";
    public static final String APPX_WORKER_JS_URL = "https://appx/af-appx.worker.min.js";

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public boolean needWaitForSetup() {
        return true;
    }

    @Override // com.alibaba.ariver.resource.content.NormalResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    protected boolean needWaitSetupWhenGet() {
        return true;
    }

    public AppxResourcePackage(ResourceContext resourceContext) {
        super("66666692", resourceContext);
    }

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onPrepareDone(boolean z) {
        super.onPrepareDone(z);
        String string = (this.mResourceContext == null || this.mResourceContext.getStartParams() == null) ? "" : BundleUtils.getString(this.mResourceContext.getStartParams(), RVParams.START_APP_SESSION_ID);
        AppLog.Builder builder = new AppLog.Builder();
        StringBuilder sb = new StringBuilder();
        sb.append("load appx ");
        sb.append(z ? "success" : "fail");
        sb.append(" : ");
        sb.append(this.appId);
        sb.append("/");
        sb.append(version());
        AppLogger.log(builder.setState(sb.toString()).setAppId(this.appId).setParentId(string).build());
        Intent intent = new Intent(RVConstants.ACTION_APPX_PARSED);
        intent.putExtra("appxVersion", version());
        LocalBroadcastManager.getInstance(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()).sendBroadcast(intent);
    }

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage
    public void onPresetParseDone() {
        super.onPresetParseDone();
        Intent intent = new Intent(RVConstants.ACTION_PRESET_APPX_PARSED);
        intent.putExtra("appxVersion", version());
        LocalBroadcastManager.getInstance(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()).sendBroadcast(intent);
    }

    @Override // com.alibaba.ariver.resource.content.NormalResourcePackage, com.alibaba.ariver.resource.content.BaseResourcePackage
    protected boolean canHotUpdate(String str) {
        if (count() == 0 || this.mSetupLock.getCount() == 1) {
            RVLogger.d(getLogTag(), "canHotUpdate true because no content || mSetupLock.count() == 1");
            return true;
        }
        return false;
    }
}
