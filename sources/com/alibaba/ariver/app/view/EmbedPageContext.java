package com.alibaba.ariver.app.view;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.ui.ErrorView;
import com.alibaba.ariver.app.api.ui.PageContainer;
import com.alibaba.ariver.app.api.ui.fragment.DefaultEmbedViewManager;
import com.alibaba.ariver.app.api.ui.loading.LoadingView;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.engine.api.embedview.IEmbedViewManager;
import com.alibaba.ariver.kernel.RVParams;

/* loaded from: classes6.dex */
public abstract class EmbedPageContext implements PageContext, PageContainer {

    /* renamed from: a  reason: collision with root package name */
    private FragmentActivity f5990a;
    private IEmbedViewManager b;
    private Page c;

    @Override // com.alibaba.ariver.app.api.PageContext
    public void applyTransparentTitle(boolean z) {
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public ErrorView getErrorView() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public LoadingView getLoadingView() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public PageContainer getPageContainer() {
        return this;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public TitleBar getTitleBar() {
        return null;
    }

    public EmbedPageContext(FragmentActivity fragmentActivity) {
        this.f5990a = fragmentActivity;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public Activity getActivity() {
        return this.f5990a;
    }

    public void renderPage(Page page) {
        this.c = page;
        page.bindContext(this);
        attachPage(page);
        page.getStartParams().putBoolean(RVParams.isTinyApp, true);
        View view = page.getRender().getView();
        addRenderView(view);
        page.enter();
        view.setBackgroundColor(0);
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public IEmbedViewManager getEmbedViewManager() {
        if (this.b == null) {
            this.b = new DefaultEmbedViewManager(this.c);
        }
        return this.b;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public void destroy() {
        IEmbedViewManager embedViewManager = getEmbedViewManager();
        if (embedViewManager != null) {
            embedViewManager.releaseViews();
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.PageContainer
    public ViewGroup getView() {
        return getContentView();
    }
}
