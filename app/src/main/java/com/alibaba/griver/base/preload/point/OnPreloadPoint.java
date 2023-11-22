package com.alibaba.griver.base.preload.point;

import com.alibaba.ariver.app.api.App;
import com.alibaba.griver.api.common.GriverExtension;

/* loaded from: classes3.dex */
public interface OnPreloadPoint extends GriverExtension {
    void closeAppPointPreload(App app);

    void createAppContext(App app);

    void createPageContext(App app);

    void init();

    void processCreatedPointPreload();
}
