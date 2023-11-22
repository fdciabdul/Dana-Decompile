package com.alibaba.exthub.base;

import android.app.Activity;
import android.view.ViewGroup;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.ui.ErrorView;
import com.alibaba.ariver.app.api.ui.PageContainer;
import com.alibaba.ariver.app.api.ui.loading.LoadingView;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.engine.api.embedview.IEmbedViewManager;

/* loaded from: classes6.dex */
public class ExtHubPageContext implements PageContext {

    /* renamed from: a  reason: collision with root package name */
    private Activity f6261a;

    @Override // com.alibaba.ariver.app.api.PageContext
    public void applyTransparentTitle(boolean z) {
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public void destroy() {
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public ViewGroup getContentView() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public IEmbedViewManager getEmbedViewManager() {
        return null;
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
        return null;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public TitleBar getTitleBar() {
        return null;
    }

    public ExtHubPageContext(Activity activity) {
        this.f6261a = activity;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public Activity getActivity() {
        return this.f6261a;
    }
}
