package com.alibaba.griver.core.preload.impl.appx;

import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.preload.annotation.AppxJob;
import com.alibaba.griver.base.preload.core.IPreloadJob;
import com.alibaba.griver.base.preload.core.PreloadScheduler;
import com.alibaba.griver.base.resource.extensions.AppXNgResourcePackageWithoutVerify;
import com.alibaba.griver.base.resource.extensions.GriverAppXNgResourcePackage;
import java.util.Map;

/* loaded from: classes3.dex */
public class AppxNgPackagePreloadJob implements IPreloadJob<GriverAppXNgResourcePackage> {
    @Override // com.alibaba.griver.base.preload.core.IPreloadJob
    public String getJobName() {
        return "AppxPackagePreloadJob";
    }

    @Override // com.alibaba.griver.base.preload.core.IPreloadJob
    @AppxJob(true)
    public /* bridge */ /* synthetic */ GriverAppXNgResourcePackage preLoad(Map map, PreloadScheduler.PointType pointType) {
        return preLoad((Map<String, Object>) map, pointType);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alibaba.griver.base.preload.core.IPreloadJob
    @AppxJob(true)
    public GriverAppXNgResourcePackage preLoad(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        GriverLogger.d(PreloadScheduler.TAG, "AppxPackagePreloadJob#preLoad, start appx package preload.");
        ResourcePackage resourcePackage = GlobalPackagePool.getInstance().getPackage("68687209");
        if (resourcePackage instanceof GriverAppXNgResourcePackage) {
            return (GriverAppXNgResourcePackage) resourcePackage;
        }
        AppXNgResourcePackageWithoutVerify appXNgResourcePackageWithoutVerify = new AppXNgResourcePackageWithoutVerify(new ResourceContext());
        GlobalPackagePool.getInstance().add(appXNgResourcePackageWithoutVerify);
        GriverLogger.d(PreloadScheduler.TAG, "AppxPackagePreloadJob#preLoad, end appx package preload.");
        return appXNgResourcePackageWithoutVerify;
    }

    @Override // com.alibaba.griver.base.preload.core.IPreloadJob
    public Class<GriverAppXNgResourcePackage> getResultClazz() {
        return GriverAppXNgResourcePackage.class;
    }
}
