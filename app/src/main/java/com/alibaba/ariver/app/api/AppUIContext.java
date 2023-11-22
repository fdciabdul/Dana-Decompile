package com.alibaba.ariver.app.api;

import com.alibaba.ariver.app.api.ui.FontBar;
import com.alibaba.ariver.app.api.ui.ViewSpecProvider;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;

/* loaded from: classes2.dex */
public interface AppUIContext extends AppContext {
    FontBar getFontBar();

    SplashView getSplashView();

    TabBar getTabBar();

    ViewSpecProvider getViewSpecProvider();
}
