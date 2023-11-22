package com.alibaba.ariver.integration.singlepage;

import android.app.Activity;
import android.view.ViewGroup;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.ui.ErrorView;
import com.alibaba.ariver.app.api.ui.PageContainer;
import com.alibaba.ariver.app.api.ui.fragment.DefaultEmbedViewManager;
import com.alibaba.ariver.app.api.ui.loading.LoadingView;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.engine.api.embedview.IEmbedViewManager;

/* loaded from: classes6.dex */
public class SinglePageContext implements PageContext {
    private Activity mActivity;
    private IEmbedViewManager mEmbedViewManager;
    private Page mPage;

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

    public SinglePageContext(App app, Page page, Activity activity) {
        this.mActivity = activity;
        this.mPage = page;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public Activity getActivity() {
        return this.mActivity;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public IEmbedViewManager getEmbedViewManager() {
        IEmbedViewManager iEmbedViewManager;
        Page page;
        synchronized (this) {
            if (this.mEmbedViewManager == null && (page = this.mPage) != null) {
                this.mEmbedViewManager = new DefaultEmbedViewManager(page);
            }
            iEmbedViewManager = this.mEmbedViewManager;
        }
        return iEmbedViewManager;
    }
}
