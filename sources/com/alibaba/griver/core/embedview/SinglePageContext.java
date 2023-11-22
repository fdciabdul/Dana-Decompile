package com.alibaba.griver.core.embedview;

import android.app.Activity;
import android.view.ViewGroup;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.ui.ErrorView;
import com.alibaba.ariver.app.api.ui.PageContainer;
import com.alibaba.ariver.app.api.ui.loading.LoadingView;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.engine.api.embedview.IEmbedViewManager;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public class SinglePageContext implements PageContext {

    /* renamed from: a  reason: collision with root package name */
    private App f6404a;
    private Page b;

    @Override // com.alibaba.ariver.app.api.PageContext
    public void destroy() {
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public ViewGroup getContentView() {
        return null;
    }

    public SinglePageContext(App app, Page page) {
        RVLogger.d("Griver:SinglePageContext", "construct SinglePageContext");
        this.f6404a = app;
        this.b = page;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public Activity getActivity() {
        return (Activity) this.f6404a.getAppContext().getContext();
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public PageContainer getPageContainer() {
        return this.b.getPageContext().getPageContainer();
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public TitleBar getTitleBar() {
        return this.b.getPageContext().getTitleBar();
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public LoadingView getLoadingView() {
        return this.b.getPageContext().getLoadingView();
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public ErrorView getErrorView() {
        return this.b.getPageContext().getErrorView();
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public IEmbedViewManager getEmbedViewManager() {
        return this.b.getPageContext().getEmbedViewManager();
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public void applyTransparentTitle(boolean z) {
        this.b.getPageContext().applyTransparentTitle(z);
    }

    public App getmOuterApp() {
        return this.f6404a;
    }

    public Page getmOuterPage() {
        return this.b;
    }
}
