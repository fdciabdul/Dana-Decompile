package com.alibaba.griver.core.preload;

import android.os.Build;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.griver.base.appxng.GriverAppxNgRuntimeChecker;
import com.alibaba.griver.base.preload.core.PreloadScheduler;
import com.alibaba.griver.base.preload.point.OnPreloadPoint;
import com.alibaba.griver.core.preload.impl.appx.AppxNgPackagePreloadJob;
import com.alibaba.griver.core.preload.impl.appx.AppxPackagePreloadJob;
import com.alibaba.griver.core.preload.impl.render.GriverRenderNgPreLoadJob;
import com.alibaba.griver.core.preload.impl.render.GriverRenderPreLoadJob;
import com.alibaba.griver.core.preload.impl.worker.WorkerPreloadJob;

/* loaded from: classes3.dex */
public class PreloadInitializer {

    /* renamed from: a */
    private static boolean f6441a;
    private static PreloadConfig b;

    public static void init() {
        b = new PreloadConfig();
        if (f6441a || Build.VERSION.SDK_INT < 21 || !b.isEnable()) {
            return;
        }
        PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.PROCESS_CREATE, AppxPackagePreloadJob.class);
        PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.PROCESS_CREATE, AppxNgPackagePreloadJob.class);
        PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.CREATE_APP, WorkerPreloadJob.class);
        if (b.isPrerenderEnable()) {
            PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.PROCESS_CREATE, GriverRenderPreLoadJob.class);
            PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.CLOSE_APP, GriverRenderPreLoadJob.class);
            PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.PROCESS_CREATE, GriverRenderNgPreLoadJob.class);
            PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.CLOSE_APP, GriverRenderNgPreLoadJob.class);
            if (b.isKeepPrerender()) {
                PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.CREATE_PAGE, GriverRenderPreLoadJob.class);
                PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.CREATE_PAGE, GriverRenderNgPreLoadJob.class);
            }
        }
        ((OnPreloadPoint) RVProxy.get(OnPreloadPoint.class)).init();
        ((OnPreloadPoint) RVProxy.get(OnPreloadPoint.class)).processCreatedPointPreload();
        f6441a = true;
    }

    public static boolean canPrerender(App app) {
        PreloadConfig preloadConfig = b;
        return preloadConfig != null && preloadConfig.canPrerender(app);
    }

    public static boolean canSnapshot(App app) {
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        return appModel != null && canPrerender(app) && GriverAppxNgRuntimeChecker.isUseAppxNg(appModel) && b.canSnapshotEnable(app);
    }
}
