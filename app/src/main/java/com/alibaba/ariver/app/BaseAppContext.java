package com.alibaba.ariver.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.api.AppUIContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.page.prerender.PagePreRenderInitPoint;
import com.alibaba.ariver.app.api.point.view.TabBarInfoQueryPoint;
import com.alibaba.ariver.app.api.ui.FontBar;
import com.alibaba.ariver.app.api.ui.RVViewFactory;
import com.alibaba.ariver.app.api.ui.ViewSpecProvider;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.fragment.RVFragment;
import com.alibaba.ariver.app.api.ui.loading.SplashUtils;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;
import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.app.ipc.IpcClientUtils;
import com.alibaba.ariver.app.ui.DefaultViewSpecProvider;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.resource.content.ResourceUtils;
import com.alibaba.griver.core.GriverParam;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes3.dex */
public abstract class BaseAppContext implements AppUIContext {

    /* renamed from: a */
    private FragmentActivity f5959a;
    private TabBar b;
    private ViewSpecProvider c;
    private int d;
    private int e;
    private boolean f;
    private boolean g = false;
    public App mApp;
    protected IFragmentManager mFragmentManager;

    protected abstract IFragmentManager createFragmentManager(int i);

    @Override // com.alibaba.ariver.app.api.AppUIContext
    public FontBar getFontBar() {
        return null;
    }

    protected abstract ViewGroup getTabBarContainer(int i);

    @Override // com.alibaba.ariver.app.api.AppContext
    public boolean moveToBackground() {
        return false;
    }

    public BaseAppContext(App app, FragmentActivity fragmentActivity, int i, int i2) {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppContext_constructor);
        this.d = i;
        this.e = i2;
        this.mApp = app;
        this.f5959a = fragmentActivity;
        this.mFragmentManager = createFragmentManager(i);
        this.c = new DefaultViewSpecProvider(fragmentActivity);
        Bundle bundle = new Bundle();
        bundle.putString("appId", app.getAppId());
        bundle.putString(RVConstants.EXTRA_ACTIVITY_CLZ, fragmentActivity.getClass().getName());
        bundle.putBundle("startParams", app.getStartParams());
        IpcClientUtils.sendMsgToServerByApp(app, 1, bundle);
        RVTraceUtils.traceEndSection(RVTraceKey.RV_AppContext_constructor);
    }

    public IFragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public FragmentActivity getActivity() {
        return this.f5959a;
    }

    public App getApp() {
        return this.mApp;
    }

    public void a(final Page page, final TabBarModel tabBarModel) {
        if (this.f5959a.isFinishing() || this.f) {
            return;
        }
        this.f = true;
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.BaseAppContext.1
            {
                BaseAppContext.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseAppContext baseAppContext = BaseAppContext.this;
                baseAppContext.getTabBarContainer(baseAppContext.e).setVisibility(0);
                BaseAppContext.this.b.init(tabBarModel);
                if (!BaseAppContext.this.b.isTabPage(page)) {
                    BaseAppContext.this.b.hide(null);
                    StringBuilder sb = new StringBuilder();
                    sb.append("init with ");
                    sb.append(page);
                    sb.append(" not tabPage!");
                    RVLogger.d("AriverInt:BaseAppContext", sb.toString());
                    return;
                }
                page.getStartParams().putString(RVStartParams.KEY_FRAGMENT_TYPE, RVStartParams.FRAGMENT_TYPE_SUB_TAB);
                BaseAppContext.this.b.create(page);
                BaseAppContext.this.b.show(page, null);
            }
        });
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public Context getContext() {
        return this.f5959a;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public Intent getActivityStartIntent() {
        return this.f5959a.getIntent();
    }

    @Override // com.alibaba.ariver.app.api.AppUIContext
    public ViewSpecProvider getViewSpecProvider() {
        return this.c;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void start(Page page) {
        try {
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppContext_start);
            if (!ExecutorUtils.isMainThread()) {
                throw new IllegalStateException("pushPage can only invoked in main thread!");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("startPage with page: ");
            sb.append(page);
            RVLogger.d("AriverInt:BaseAppContext", sb.toString());
            Bundle bundle = new Bundle();
            bundle.putLong(IpcMessageConstants.EXTRA_NODE_ID, getApp().getNodeId());
            IpcClientUtils.sendMsgToServerByApp(getApp(), 3, bundle);
            a(page);
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppContext_pushPage);
            pushPage(page);
            RVTraceUtils.traceEndSection(RVTraceKey.RV_AppContext_pushPage);
            ExecutorUtils.postMain(new Runnable() { // from class: com.alibaba.ariver.app.BaseAppContext.2
                {
                    BaseAppContext.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (BaseAppContext.this.mApp == null || BaseAppContext.this.mApp.isExited() || BaseAppContext.this.mApp.isDestroyed()) {
                        RVLogger.d("AriverInt:BaseAppContext", "when splashView exit,mapp has destroy");
                        return;
                    }
                    boolean useSuperSplash = SplashUtils.useSuperSplash(BaseAppContext.this.mApp.getStartParams());
                    SplashView splashView = BaseAppContext.this.mApp.getAppContext() == null ? null : ((AppUIContext) BaseAppContext.this.mApp.getAppContext()).getSplashView();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("splashView exit. delaySplashHide= ");
                    sb2.append(useSuperSplash);
                    sb2.append(", splashView_is_null=");
                    sb2.append(splashView == null);
                    RVLogger.d("AriverInt:BaseAppContext", sb2.toString());
                    if (useSuperSplash || splashView == null) {
                        return;
                    }
                    splashView.exit(null);
                }
            });
        } finally {
            RVTraceUtils.traceEndSection(RVTraceKey.RV_AppContext_start);
        }
    }

    private void a(Page page) {
        if (TextUtils.equals("YES", BundleUtils.getString(this.mApp.getStartParams(), "enableTabBar")) || ResourceUtils.enableTabBarByAppId(this.mApp.getAppId())) {
            createTabBar(page);
        }
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void createTabBar(Page page) {
        this.b = ((RVViewFactory) RVProxy.get(RVViewFactory.class)).createTabBar(this.f5959a, this.mApp, this.mFragmentManager, getTabBarContainer(this.e));
        ((TabBarInfoQueryPoint) ExtensionPoint.as(TabBarInfoQueryPoint.class).node(this.mApp).create()).queryTabBarInfo(new InitTabBarListener(page));
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public boolean pushPage(Page page) {
        PagePreRenderInitPoint.PagePreRenderHolder readyPreRenderHolderWithReset;
        if (!ExecutorUtils.isMainThread()) {
            throw new IllegalStateException("pushPage can only invoked in main thread!");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("pushPage with page: ");
        sb.append(page);
        sb.append(" with stack: ");
        sb.append(Log.getStackTraceString(new Throwable("Just Print")));
        RVLogger.d("AriverInt:BaseAppContext", sb.toString());
        if (this.mFragmentManager == null || page.isExited()) {
            RVLogger.w("AriverInt:BaseAppContext", "pushPage but is exited!");
            return false;
        }
        RVFragment rVFragment = null;
        if (page.getBooleanValue(RVParams.IS_PAGE_PRERENDER) && (readyPreRenderHolderWithReset = ((PagePreRenderInitPoint) ExtensionPoint.as(PagePreRenderInitPoint.class).node(page.getApp()).create()).getReadyPreRenderHolderWithReset(page.getApp(), page.getStartParams(), page.getSceneParams(), page.getPageURI(), true)) != null) {
            rVFragment = readyPreRenderHolderWithReset.preRenderFragment;
            RVLogger.d("AriverInt:BaseAppContext", "PagePreRender use precreate Fragment ");
        }
        if (rVFragment == null) {
            rVFragment = this.mFragmentManager.getReadyFragment();
        }
        if (!rVFragment.isAdded()) {
            Bundle bundle = new Bundle();
            bundle.putLong(RVConstants.EXTRA_APP_INSTANCE_ID, this.mApp.getNodeId());
            bundle.putLong(RVConstants.EXTRA_PAGE_INSTANCE_ID, page.getNodeId());
            rVFragment.setArguments(bundle);
        } else if (rVFragment.getPage() != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("isPagePreRender:");
            sb2.append(rVFragment.getPage().getBooleanValue(GriverParam.LONG_ISPRERENDER));
            RVLogger.d("AriverInt:BaseAppContext", sb2.toString());
        } else {
            rVFragment.setPage(page);
        }
        Bundle startParams = page.getStartParams();
        boolean equals = RVStartParams.FROM_TYPE_PUSH_WINDOW.equals(BundleUtils.getString(startParams, RVStartParams.KEY_FROM_TYPE, ""));
        boolean z = BundleUtils.getBoolean(startParams, RVStartParams.KEY_FROM_RELAUNCH, false);
        boolean z2 = BundleUtils.getBoolean(startParams, RVParams.LONG_PUSHWINDOW_WITH_TRANS_ANIM, true);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("pushPage useTranslateAnim : ");
        sb3.append(z2);
        sb3.append(" fromRelaunch: ");
        sb3.append(z);
        sb3.append(" fromPushWindow: ");
        sb3.append(equals);
        RVLogger.d("AriverInt:BaseAppContext", sb3.toString());
        if (!z && z2 && equals && !((Page.AnimStore) page.getData(Page.AnimStore.class, true)).disableEnter) {
            this.mFragmentManager.pushPage(page, rVFragment, true);
        } else {
            this.mFragmentManager.pushPage(page, rVFragment, false);
        }
        TabBar tabBar = this.b;
        if (tabBar != null && !tabBar.isCreated() && this.b.isTabPage(page)) {
            this.b.create(page);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(IpcMessageConstants.EXTRA_NODE_ID, page.getNodeId());
        IpcClientUtils.sendMsgToServerByApp(getApp(), 4, bundle2);
        return true;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void exitPage(Page page, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("exitPage ");
        sb.append(page);
        RVLogger.d("AriverInt:BaseAppContext", sb.toString());
        IFragmentManager iFragmentManager = this.mFragmentManager;
        if (iFragmentManager == null) {
            RVLogger.d("AriverInt:BaseAppContext", "exitPage but already exited");
            return;
        }
        if (iFragmentManager.findFragmentForPage(page) != null) {
            this.mFragmentManager.exitPage(page, (!BundleUtils.getBoolean(page.getStartParams(), RVParams.LONG_PUSHWINDOW_WITH_TRANS_ANIM, true) || this.mApp.isExited() || ((Page.AnimStore) page.getData(Page.AnimStore.class, true)).disableExit) ? false : true, z);
        } else {
            RVLogger.d("AriverInt:BaseAppContext", "exitPage but fragment already exited!");
        }
        Bundle bundle = new Bundle();
        bundle.putLong(IpcMessageConstants.EXTRA_NODE_ID, page.getNodeId());
        IpcClientUtils.sendMsgToServerByApp(getApp(), 5, bundle);
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void destroy() {
        synchronized (this) {
            if (this.g) {
                return;
            }
            this.g = true;
            onDestroy();
        }
    }

    private boolean a(Activity activity) {
        ActivityManager activityManager = (ActivityManager) ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
        if (activityManager == null) {
            return true;
        }
        Iterator<ActivityManager.RunningTaskInfo> it = activityManager.getRunningTasks(Integer.MAX_VALUE).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningTaskInfo next = it.next();
            if (next.baseActivity != null && TextUtils.equals(activity.getClass().getName(), next.baseActivity.getClassName())) {
                StringBuilder sb = new StringBuilder();
                sb.append("canRemoveTask found RunningTaskInfo: ");
                sb.append(next);
                RVLogger.d("AriverInt:BaseAppContext", sb.toString());
                if (next.numActivities > 1) {
                    RVLogger.d("AriverInt:BaseAppContext", "canRemoveTask remove task because have another activity!");
                    return false;
                }
            }
        }
        return true;
    }

    private boolean a() {
        Stack<App> appStack = ((AppManager) RVProxy.get(AppManager.class)).getAppStack();
        if (appStack == null || appStack.size() == 0) {
            RVLogger.d("AriverInt:BaseAppContext", "onlyOneAppInTask return true because stack empty!");
            return true;
        } else if (appStack.size() == 1 && appStack.peek() == this.mApp) {
            StringBuilder sb = new StringBuilder();
            sb.append("onlyOneAppInTask return true because stack contain self: ");
            sb.append(this.mApp);
            RVLogger.d("AriverInt:BaseAppContext", sb.toString());
            return true;
        } else {
            return false;
        }
    }

    public void onDestroy() {
        FragmentActivity fragmentActivity = this.f5959a;
        if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
            RVLogger.w("AriverInt:BaseAppContext", "NebulaActivity finish by AppContext.destroy()");
            if (this.f5959a.isTaskRoot()) {
                if (Build.VERSION.SDK_INT >= 21 && a(this.f5959a) && a()) {
                    RVLogger.w("AriverInt:BaseAppContext", "NebulaActivity finishAndRemoveTask by Activity API");
                    this.f5959a.finishAndRemoveTask();
                    this.f5959a = null;
                } else {
                    RVLogger.w("AriverInt:BaseAppContext", "NebulaActivity finish by Activity API");
                }
            }
            this.f5959a.finish();
            this.f5959a = null;
        }
        IFragmentManager iFragmentManager = this.mFragmentManager;
        if (iFragmentManager != null) {
            iFragmentManager.release();
            this.mFragmentManager = null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("appId", getApp().getAppId());
        bundle.putLong(IpcMessageConstants.EXTRA_NODE_ID, getApp().getNodeId());
        IpcClientUtils.sendMsgToServerByApp(getApp(), 2, bundle);
        ClientMsgReceiver.getInstance().unRegisterAppHandler(this.mApp.getStartToken());
        this.mApp = null;
    }

    @Override // com.alibaba.ariver.app.api.AppUIContext
    public TabBar getTabBar() {
        return this.b;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public boolean isTaskRoot() {
        return this.f5959a.isTaskRoot();
    }

    /* loaded from: classes6.dex */
    public class InitTabBarListener implements TabBarInfoQueryPoint.OnTabBarInfoQueryListener {

        /* renamed from: a */
        private Page f5960a;

        private InitTabBarListener(Page page) {
            BaseAppContext.this = r1;
            this.f5960a = page;
        }

        @Override // com.alibaba.ariver.app.api.point.view.TabBarInfoQueryPoint.OnTabBarInfoQueryListener
        public void onTabInfoGot(TabBarModel tabBarModel) {
            StringBuilder sb = new StringBuilder();
            sb.append("onTabInfoGot data ");
            sb.append(tabBarModel);
            RVLogger.d("AriverInt:BaseAppContext", sb.toString());
            BaseAppContext.this.a(this.f5960a, tabBarModel);
        }
    }
}
