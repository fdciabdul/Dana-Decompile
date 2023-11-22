package com.alibaba.exthub.base;

import android.content.Context;
import android.content.Intent;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;

/* loaded from: classes3.dex */
public class ExtHubAppContext implements AppContext {
    @Override // com.alibaba.ariver.app.api.AppContext
    public void createTabBar(Page page) {
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void destroy() {
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void exitPage(Page page, boolean z) {
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public Intent getActivityStartIntent() {
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

    @Override // com.alibaba.ariver.app.api.AppContext
    public boolean pushPage(Page page) {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void start(Page page) {
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public Context getContext() {
        if (RVProxy.get(RVEnvironmentService.class) == null || ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getTopActivity() == null) {
            return null;
        }
        return ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getTopActivity().get();
    }
}
