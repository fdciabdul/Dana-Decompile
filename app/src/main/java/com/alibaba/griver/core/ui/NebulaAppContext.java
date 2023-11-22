package com.alibaba.griver.core.ui;

import android.os.Message;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.app.BaseAppContext;
import com.alibaba.ariver.app.activity.DefaultFragmentManager;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.ViewSpecProvider;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.common.page.GriverStartPageFailedExtension;
import com.alibaba.griver.api.ui.GVSplashView;
import com.alibaba.griver.api.ui.GVViewFactory;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.resource.GriverPrepareController;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverKeepAliveFullLinkStageMonitor;
import com.alibaba.griver.base.t2.T2Utils;
import com.alibaba.griver.core.keepalive.ActivityBackAdvice;
import com.alibaba.griver.core.keepalive.AliveActivityInfo;
import com.alibaba.griver.core.keepalive.KeepAliveAppManager;
import com.alibaba.griver.ui.splash.SplashViewSpecProvider;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class NebulaAppContext extends BaseAppContext {

    /* renamed from: a */
    private WeakReference<GVSplashView> f6463a;
    private ViewGroup b;
    private ViewSpecProvider c;

    @Override // com.alibaba.ariver.app.BaseAppContext, com.alibaba.ariver.app.api.AppContext
    public boolean isTaskRoot() {
        return true;
    }

    public NebulaAppContext(AppNode appNode, FragmentActivity fragmentActivity, int i, int i2) {
        super(appNode, fragmentActivity, i, i2);
        GVSplashView createSplashH5View;
        this.c = new SplashViewSpecProvider(fragmentActivity);
        AppModel appModel = (AppModel) BundleUtils.getParcelable(appNode.getSceneParams(), "appInfo");
        if (appNode.isTinyApp()) {
            createSplashH5View = ((GVViewFactory) RVProxy.get(GVViewFactory.class)).createSplashView(getFragmentManager().getInnerManager(), appNode, appModel);
        } else {
            createSplashH5View = ((GVViewFactory) RVProxy.get(GVViewFactory.class)).createSplashH5View(getFragmentManager().getInnerManager(), appNode, appModel);
        }
        if (createSplashH5View != null) {
            createSplashH5View.setReloadListener(new GVSplashView.OnReloadListener() { // from class: com.alibaba.griver.core.ui.NebulaAppContext.1
                {
                    NebulaAppContext.this = this;
                }

                @Override // com.alibaba.griver.api.ui.GVSplashView.OnReloadListener
                public void onReload() {
                    if (NebulaAppContext.this.mApp != null) {
                        IpcMessage ipcMessage = new IpcMessage();
                        StringBuilder sb = new StringBuilder();
                        sb.append(NebulaAppContext.this.mApp.getStartToken());
                        sb.append(GriverPrepareController.BIZ_APP_CONTROLLER);
                        ipcMessage.biz = sb.toString();
                        Message obtain = Message.obtain();
                        obtain.what = 0;
                        ipcMessage.bizMsg = obtain;
                        ClientMsgReceiver.getInstance().handleMessage(ipcMessage);
                    }
                }
            });
            createSplashH5View.setOnExitListener(new GVSplashView.OnExitListener() { // from class: com.alibaba.griver.core.ui.NebulaAppContext.2
                {
                    NebulaAppContext.this = this;
                }

                @Override // com.alibaba.griver.api.ui.GVSplashView.OnExitListener
                public void onExit() {
                    if (NebulaAppContext.this.mApp != null) {
                        IpcMessage ipcMessage = new IpcMessage();
                        StringBuilder sb = new StringBuilder();
                        sb.append(NebulaAppContext.this.getApp().getStartToken());
                        sb.append(GriverPrepareController.BIZ_APP_CONTROLLER);
                        ipcMessage.biz = sb.toString();
                        Message obtain = Message.obtain();
                        obtain.what = 1;
                        ipcMessage.bizMsg = obtain;
                        ClientMsgReceiver.getInstance().handleMessage(ipcMessage);
                    }
                }
            });
            this.f6463a = new WeakReference<>(createSplashH5View);
        }
    }

    @Override // com.alibaba.ariver.app.api.AppUIContext
    public SplashView getSplashView() {
        WeakReference<GVSplashView> weakReference = this.f6463a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.alibaba.ariver.app.BaseAppContext
    public ViewGroup getTabBarContainer(int i) {
        if (this.b == null) {
            this.b = (ViewGroup) getActivity().findViewById(i);
        }
        return this.b;
    }

    @Override // com.alibaba.ariver.app.BaseAppContext, com.alibaba.ariver.app.api.AppContext
    public void start(Page page) {
        try {
            super.start(page);
        } catch (Throwable th) {
            GriverLogger.e("NebulaAppContext", "push page failed", th);
            MonitorMap.Builder builder = new MonitorMap.Builder();
            builder.appId(getApp().getAppId());
            builder.version(getApp());
            builder.url(getApp().getStartUrl());
            builder.exception(th);
            builder.message("Start page failed");
            GriverMonitor.error(GriverMonitorConstants.ERROR_START_PAGE, "GriverAppContainer", builder.build());
            ((GriverStartPageFailedExtension) RVProxy.get(GriverStartPageFailedExtension.class)).startFailed(th, GriverEnv.getApplicationContext());
            if (page != null) {
                page.exit(true);
            } else {
                getApp().exit();
            }
        }
    }

    @Override // com.alibaba.ariver.app.BaseAppContext
    public IFragmentManager createFragmentManager(int i) {
        return new DefaultFragmentManager(getApp(), i, getActivity());
    }

    @Override // com.alibaba.ariver.app.BaseAppContext, com.alibaba.ariver.app.api.AppUIContext
    public ViewSpecProvider getViewSpecProvider() {
        return this.c;
    }

    @Override // com.alibaba.ariver.app.BaseAppContext
    public void onDestroy() {
        App app = getApp();
        if (app != null) {
            IpcMessage ipcMessage = new IpcMessage();
            StringBuilder sb = new StringBuilder();
            sb.append(app.getStartToken());
            sb.append(GriverPrepareController.BIZ_APP_CONTROLLER);
            ipcMessage.biz = sb.toString();
            Message obtain = Message.obtain();
            obtain.what = 1;
            ipcMessage.bizMsg = obtain;
            ClientMsgReceiver.getInstance().handleMessage(ipcMessage);
        }
        WeakReference<GVSplashView> weakReference = this.f6463a;
        if (weakReference != null) {
            GVSplashView gVSplashView = weakReference.get();
            if (gVSplashView != null) {
                gVSplashView.setReloadListener(null);
            }
            this.f6463a.clear();
        }
        super.onDestroy();
    }

    @Override // com.alibaba.ariver.app.BaseAppContext, com.alibaba.ariver.app.api.AppContext
    public boolean moveToBackground() {
        App app = getApp();
        boolean z = false;
        if (app == null) {
            return false;
        }
        if (KeepAliveAppManager.getInstance().needSupportKeepAlive(app.getAppId(), app.getStartParams()) && "YES".equalsIgnoreCase(BundleUtils.getString(app.getStartParams(), RVStartParams.KEY_ENABLE_KEEP_ALIVE, "YES"))) {
            z = a(app);
            KeepAliveAppManager.getInstance().moveBackTaskAliveActivityByAppId(app.getAppId(), app.getStartToken(), z);
        }
        GriverKeepAliveFullLinkStageMonitor griverKeepAliveFullLinkStageMonitor = (GriverKeepAliveFullLinkStageMonitor) GriverStageMonitorManager.getInstance().getStageMonitor(GriverKeepAliveFullLinkStageMonitor.getMonitorToken(app));
        if (griverKeepAliveFullLinkStageMonitor != null) {
            griverKeepAliveFullLinkStageMonitor.upload(app);
            GriverStageMonitorManager.getInstance().unRegisterStageMonitor(GriverKeepAliveFullLinkStageMonitor.getMonitorToken(app.getAppId(), String.valueOf(app.getStartToken())));
        }
        T2Utils.performanceJST2(app);
        return z;
    }

    private boolean a(App app) {
        AliveActivityInfo findAliveActivityByAppId = KeepAliveAppManager.getInstance().findAliveActivityByAppId(app.getAppId());
        if (findAliveActivityByAppId == null) {
            return false;
        }
        return ActivityBackAdvice.moveTaskToBack(getActivity(), findAliveActivityByAppId.getFromTaskId(), true);
    }
}
