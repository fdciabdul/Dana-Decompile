package com.alibaba.ariver.integration.singlepage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppUIContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.FontBar;
import com.alibaba.ariver.app.api.ui.ViewSpecProvider;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;

/* loaded from: classes6.dex */
public class SinglePageAppContext implements AppUIContext {
    private Activity mActivity;
    private App mApp;

    @Override // com.alibaba.ariver.app.api.AppContext
    public void createTabBar(Page page) {
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void destroy() {
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void exitPage(Page page, boolean z) {
    }

    @Override // com.alibaba.ariver.app.api.AppUIContext
    public FontBar getFontBar() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.AppUIContext
    public SplashView getSplashView() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.AppUIContext
    public TabBar getTabBar() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.AppUIContext
    public ViewSpecProvider getViewSpecProvider() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public boolean isTaskRoot() {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public boolean moveToBackground() {
        return false;
    }

    public SinglePageAppContext(App app, Activity activity) {
        this.mActivity = activity;
        this.mApp = app;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public Context getContext() {
        return this.mActivity;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public Intent getActivityStartIntent() {
        return this.mActivity.getIntent();
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void start(Page page) {
        if (page.getPageContext() == null) {
            page.bindContext(new SinglePageContext(this.mApp, page, this.mActivity));
        }
        page.enter();
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public boolean pushPage(Page page) {
        RVMain.startApp(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), page.getApp().getAppId(), page.getStartParams(), page.getSceneParams());
        page.exit(true);
        return true;
    }
}
