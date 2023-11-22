package com.alibaba.ariver.app.api.point.view;

import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes6.dex */
public interface TabBarInfoQueryPoint extends Extension {

    /* loaded from: classes6.dex */
    public interface OnTabBarInfoQueryListener {
        void onTabInfoGot(TabBarModel tabBarModel);
    }

    void queryTabBarInfo(OnTabBarInfoQueryListener onTabBarInfoQueryListener);
}
