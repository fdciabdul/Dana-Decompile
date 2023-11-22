package com.alibaba.griver.base.preload;

import com.alibaba.ariver.app.api.App;
import com.alibaba.griver.base.preload.core.PreloadScheduler;
import com.alibaba.griver.base.preload.point.OnPreloadPoint;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class GriverOnPreloadExtension implements OnPreloadPoint {
    public static final String PARAMS_APP = "app";

    /* renamed from: a  reason: collision with root package name */
    private boolean f6341a = false;

    @Override // com.alibaba.griver.base.preload.point.OnPreloadPoint
    public void init() {
        this.f6341a = true;
    }

    @Override // com.alibaba.griver.base.preload.point.OnPreloadPoint
    public void processCreatedPointPreload() {
        if (this.f6341a) {
            PreloadScheduler.getInstance().preLoad(PreloadScheduler.PointType.PROCESS_CREATE, null);
        }
    }

    @Override // com.alibaba.griver.base.preload.point.OnPreloadPoint
    public void createAppContext(App app) {
        if (this.f6341a) {
            HashMap hashMap = new HashMap();
            hashMap.put(PARAMS_APP, app);
            PreloadScheduler.getInstance().preLoad(PreloadScheduler.PointType.CREATE_APP, hashMap);
        }
    }

    @Override // com.alibaba.griver.base.preload.point.OnPreloadPoint
    public void closeAppPointPreload(App app) {
        if (this.f6341a) {
            HashMap hashMap = new HashMap();
            hashMap.put(PARAMS_APP, app);
            PreloadScheduler.getInstance().preLoad(PreloadScheduler.PointType.CLOSE_APP, hashMap);
        }
    }

    @Override // com.alibaba.griver.base.preload.point.OnPreloadPoint
    public void createPageContext(App app) {
        if (this.f6341a) {
            HashMap hashMap = new HashMap();
            hashMap.put(PARAMS_APP, app);
            PreloadScheduler.getInstance().preLoad(PreloadScheduler.PointType.CREATE_PAGE, hashMap);
        }
    }
}
