package com.alibaba.griver.ui;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.griver.api.ui.GVSplashView;
import com.alibaba.griver.api.ui.GVViewFactory;
import com.alibaba.griver.api.ui.errorview.GVErrorView;
import com.alibaba.griver.api.ui.loadingview.GVLoadingView;
import com.alibaba.griver.api.ui.pagecontainer.GVPageContainer;
import com.alibaba.griver.api.ui.tabbar.GVTabBar;
import com.alibaba.griver.api.ui.titlebar.GVTitleBar;
import com.alibaba.griver.ui.container.GriverPageContainer;
import com.alibaba.griver.ui.loading.NebulaLoadingView;
import com.alibaba.griver.ui.splash.BaseSplashView;
import com.alibaba.griver.ui.splash.GriverSplashView;
import com.alibaba.griver.ui.tabbar.GriverTabBar;
import com.alibaba.griver.ui.titlebar.GriverTitleBar;
import java.util.Map;

/* loaded from: classes6.dex */
public class GriverViewFactoryImpl implements GVViewFactory {
    @Override // com.alibaba.griver.api.ui.GVViewFactory
    public GVErrorView createErrorView(Context context) {
        return null;
    }

    @Override // com.alibaba.griver.api.ui.GVViewFactory
    public void preload(Context context) {
    }

    @Override // com.alibaba.griver.api.ui.GVViewFactory
    public GVPageContainer createPageContainer(Context context, App app, ViewGroup viewGroup) {
        return new GriverPageContainer(context, app);
    }

    @Override // com.alibaba.griver.api.ui.GVViewFactory
    public GVTabBar createTabBar(Context context, App app, IFragmentManager iFragmentManager, ViewGroup viewGroup) {
        return new GriverTabBar(app, (Activity) context, iFragmentManager, viewGroup);
    }

    @Override // com.alibaba.griver.api.ui.GVViewFactory
    public GVTitleBar createTitleBar(Context context, App app) {
        return new GriverTitleBar(context);
    }

    @Override // com.alibaba.griver.api.ui.GVViewFactory
    public GVLoadingView createLoadingView(Context context, Page page) {
        return new NebulaLoadingView(context, page);
    }

    @Override // com.alibaba.griver.api.ui.GVViewFactory
    public GVSplashView createSplashView(FragmentManager fragmentManager, App app, AppModel appModel) {
        return new GriverSplashView(fragmentManager, app, appModel);
    }

    @Override // com.alibaba.griver.api.ui.GVViewFactory
    public GVSplashView createSplashH5View(final FragmentManager fragmentManager, final App app, final AppModel appModel) {
        return new BaseSplashView(app) { // from class: com.alibaba.griver.ui.GriverViewFactoryImpl.1

            /* renamed from: a  reason: collision with root package name */
            private GriverSplashView f6652a;

            @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
            public void update(EntryInfo entryInfo) {
                GriverSplashView griverSplashView = this.f6652a;
                if (griverSplashView != null) {
                    griverSplashView.update(entryInfo);
                }
            }

            @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
            public void showError(String str, String str2, Map<String, String> map) {
                if (this.f6652a == null) {
                    GriverSplashView griverSplashView = new GriverSplashView(fragmentManager, app, appModel);
                    this.f6652a = griverSplashView;
                    griverSplashView.setReloadListener(this.listener);
                    this.f6652a.setOnExitListener(this.onExitListener);
                }
                this.f6652a.showError(str, str2, map);
            }

            @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
            public SplashView.Status getStatus() {
                GriverSplashView griverSplashView = this.f6652a;
                if (griverSplashView != null) {
                    return griverSplashView.getStatus();
                }
                return null;
            }

            @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
            public boolean backPressed() {
                GriverSplashView griverSplashView = this.f6652a;
                if (griverSplashView != null) {
                    return griverSplashView.backPressed();
                }
                return false;
            }
        };
    }
}
