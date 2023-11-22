package com.alibaba.griver.core.proxy;

import android.content.Context;
import android.view.ViewGroup;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.ErrorView;
import com.alibaba.ariver.app.api.ui.PageContainer;
import com.alibaba.ariver.app.api.ui.RVViewFactory;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.loading.LoadingView;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.griver.api.ui.GVViewFactory;

/* loaded from: classes6.dex */
public class GriverViewFactoryImpl implements RVViewFactory {
    @Override // com.alibaba.ariver.app.api.ui.RVViewFactory
    public ErrorView createErrorView(Context context) {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.ui.RVViewFactory
    public void preload(Context context) {
    }

    @Override // com.alibaba.ariver.app.api.ui.RVViewFactory
    public PageContainer createPageContainer(Context context, App app, ViewGroup viewGroup) {
        return ((GVViewFactory) RVProxy.get(GVViewFactory.class)).createPageContainer(context, app, viewGroup);
    }

    @Override // com.alibaba.ariver.app.api.ui.RVViewFactory
    public TabBar createTabBar(Context context, App app, IFragmentManager iFragmentManager, ViewGroup viewGroup) {
        return ((GVViewFactory) RVProxy.get(GVViewFactory.class)).createTabBar(context, app, iFragmentManager, viewGroup);
    }

    @Override // com.alibaba.ariver.app.api.ui.RVViewFactory
    public TitleBar createTitleBar(Context context, Page page, App app) {
        return ((GVViewFactory) RVProxy.get(GVViewFactory.class)).createTitleBar(context, app);
    }

    @Override // com.alibaba.ariver.app.api.ui.RVViewFactory
    public LoadingView createLoadingView(Context context, Page page) {
        return ((GVViewFactory) RVProxy.get(GVViewFactory.class)).createLoadingView(context, page);
    }
}
