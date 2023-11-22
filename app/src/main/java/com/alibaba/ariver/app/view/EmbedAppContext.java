package com.alibaba.ariver.app.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppUIContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.FontBar;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.fragment.RVFragment;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;
import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.app.ipc.IpcClientUtils;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;

/* loaded from: classes6.dex */
public abstract class EmbedAppContext implements AppUIContext {

    /* renamed from: a  reason: collision with root package name */
    private FragmentActivity f5989a;
    private App b;
    private IFragmentManager c;
    private boolean d = false;

    protected abstract IFragmentManager createFragmentManager();

    protected abstract EmbedPageContext createPageContext();

    @Override // com.alibaba.ariver.app.api.AppContext
    public void createTabBar(Page page) {
    }

    @Override // com.alibaba.ariver.app.api.AppUIContext
    public FontBar getFontBar() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.AppUIContext
    public TabBar getTabBar() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public boolean moveToBackground() {
        return false;
    }

    public EmbedAppContext(App app, FragmentActivity fragmentActivity) {
        this.f5989a = fragmentActivity;
        this.b = app;
        Bundle bundle = new Bundle();
        bundle.putString("appId", app.getAppId());
        bundle.putString(RVConstants.EXTRA_ACTIVITY_CLZ, this.f5989a.getClass().getName());
        bundle.putBundle("startParams", app.getStartParams());
        IpcClientUtils.sendMsgToServerByApp(app, 1, bundle);
    }

    protected FragmentActivity getActivity() {
        return this.f5989a;
    }

    protected App getApp() {
        return this.b;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public Context getContext() {
        return this.f5989a;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public Intent getActivityStartIntent() {
        return this.f5989a.getIntent();
    }

    public IFragmentManager getFragmentManager() {
        if (this.c == null) {
            this.c = createFragmentManager();
        }
        return this.c;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void start(Page page) {
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
        if (page.isExited()) {
            return;
        }
        createPageContext().renderPage(page);
        Bundle bundle2 = new Bundle();
        bundle2.putLong(IpcMessageConstants.EXTRA_NODE_ID, page.getNodeId());
        IpcClientUtils.sendMsgToServerByApp(getApp(), 4, bundle2);
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public boolean pushPage(Page page) {
        if (!ExecutorUtils.isMainThread()) {
            throw new IllegalStateException("pushPage can only invoked in main thread!");
        }
        if (page.isExited()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("pushPage with page: ");
        sb.append(page);
        sb.append(" with stack: ");
        sb.append(Log.getStackTraceString(new Throwable("Just Print")));
        RVLogger.d("AriverInt:BaseAppContext", sb.toString());
        RVFragment readyFragment = getFragmentManager().getReadyFragment();
        if (!readyFragment.isAdded()) {
            Bundle bundle = new Bundle();
            bundle.putLong(RVConstants.EXTRA_APP_INSTANCE_ID, this.b.getNodeId());
            bundle.putLong(RVConstants.EXTRA_PAGE_INSTANCE_ID, page.getNodeId());
            readyFragment.setArguments(bundle);
        } else {
            readyFragment.setPage(page);
        }
        Bundle startParams = page.getStartParams();
        boolean equals = RVStartParams.FROM_TYPE_PUSH_WINDOW.equals(BundleUtils.getString(startParams, RVStartParams.KEY_FROM_TYPE, ""));
        boolean z = BundleUtils.getBoolean(startParams, RVParams.LONG_PUSHWINDOW_WITH_TRANS_ANIM, true);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("pushPage useTranslateAnim : ");
        sb2.append(z);
        sb2.append(" fromPushWindow: ");
        sb2.append(equals);
        RVLogger.d("AriverInt:BaseAppContext", sb2.toString());
        if (z && equals) {
            getFragmentManager().pushPage(page, readyFragment, true);
        } else {
            getFragmentManager().pushPage(page, readyFragment, false);
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
        if (getFragmentManager() == null) {
            RVLogger.d("AriverInt:BaseAppContext", "exitPage but already exited");
            return;
        }
        if (getFragmentManager().findFragmentForPage(page) != null) {
            getFragmentManager().exitPage(page, !this.b.isExited(), false);
        } else {
            RVLogger.d("AriverInt:BaseAppContext", "exitPage but fragment already exited!");
            if (this.b.getAlivePageCount() == 0) {
                page.exit(z);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putLong(IpcMessageConstants.EXTRA_NODE_ID, page.getNodeId());
        IpcClientUtils.sendMsgToServerByApp(getApp(), 5, bundle);
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void destroy() {
        synchronized (this) {
            if (this.d) {
                return;
            }
            this.d = true;
            onDestroy();
        }
    }

    protected void onDestroy() {
        Bundle bundle = new Bundle();
        bundle.putString("appId", getApp().getAppId());
        bundle.putLong(IpcMessageConstants.EXTRA_NODE_ID, getApp().getNodeId());
        IpcClientUtils.sendMsgToServerByApp(getApp(), 2, bundle);
        this.f5989a = null;
        ClientMsgReceiver.getInstance().unRegisterAppHandler(this.b.getStartToken());
        this.b = null;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public boolean isTaskRoot() {
        return this.f5989a.isTaskRoot();
    }
}
