package com.alibaba.griver.core.preload.impl.appx;

import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.preload.annotation.AppxJob;
import com.alibaba.griver.base.preload.core.IPreloadJob;
import com.alibaba.griver.base.preload.core.PreloadScheduler;
import com.alibaba.griver.base.resource.extensions.AppXResourcePackageWithoutVerify;
import com.alibaba.griver.base.resource.extensions.GriverAppXResourcePackage;
import java.util.Map;

/* loaded from: classes3.dex */
public class AppxPackagePreloadJob implements IPreloadJob<GriverAppXResourcePackage> {
    @Override // com.alibaba.griver.base.preload.core.IPreloadJob
    public String getJobName() {
        return "AppxPackagePreloadJob";
    }

    @Override // com.alibaba.griver.base.preload.core.IPreloadJob
    @AppxJob(true)
    public /* bridge */ /* synthetic */ GriverAppXResourcePackage preLoad(Map map, PreloadScheduler.PointType pointType) {
        return preLoad((Map<String, Object>) map, pointType);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alibaba.griver.base.preload.core.IPreloadJob
    @AppxJob(true)
    public GriverAppXResourcePackage preLoad(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        if (GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_TOGGLE_PRELOAD_APPX_PACKAGE, true)) {
            GriverLogger.d(PreloadScheduler.TAG, "AppxPackagePreloadJob#preLoad, start appx package preload.");
            ResourcePackage resourcePackage = GlobalPackagePool.getInstance().getPackage("66666692");
            if (resourcePackage instanceof GriverAppXResourcePackage) {
                return (GriverAppXResourcePackage) resourcePackage;
            }
            AppXResourcePackageWithoutVerify appXResourcePackageWithoutVerify = new AppXResourcePackageWithoutVerify(new ResourceContext());
            GlobalPackagePool.getInstance().add(appXResourcePackageWithoutVerify);
            GriverLogger.d(PreloadScheduler.TAG, "AppxPackagePreloadJob#preLoad, end appx package preload.");
            return appXResourcePackageWithoutVerify;
        }
        return null;
    }

    @Override // com.alibaba.griver.base.preload.core.IPreloadJob
    public Class<GriverAppXResourcePackage> getResultClazz() {
        return GriverAppXResourcePackage.class;
    }
}
