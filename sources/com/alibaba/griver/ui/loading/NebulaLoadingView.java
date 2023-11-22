package com.alibaba.griver.ui.loading;

import android.content.Context;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.ui.loadingview.GVLoadingView;
import com.alibaba.griver.api.ui.loadingview.GriverLoadingViewExtension;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverWhiteScreenStageMonitor;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class NebulaLoadingView implements GVLoadingView {

    /* renamed from: a  reason: collision with root package name */
    private Context f6721a;
    private Runnable b;
    private final Object c = new Object();
    private WeakReference d;

    public NebulaLoadingView(Context context, Page page) {
        this.f6721a = context;
        if (page != null) {
            this.d = new WeakReference(page);
        }
    }

    private void a(boolean z) {
        WeakReference weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        Page page = (Page) this.d.get();
        GriverStageMonitor stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(GriverWhiteScreenStageMonitor.getMonitorToken(page.getApp(), page.getPageURI()));
        if (stageMonitor != null) {
            stageMonitor.addParam(GriverMonitorConstants.KEY_IS_LOADING, Boolean.valueOf(z));
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.loading.LoadingView
    public void show(final String str, int i, final boolean z, boolean z2) {
        synchronized (this.c) {
            a(true);
            StringBuilder sb = new StringBuilder();
            sb.append("show loading: ");
            sb.append(str);
            GriverLogger.d("NebulaLoadingView", sb.toString());
            if (i > 0) {
                Runnable runnable = this.b;
                if (runnable != null) {
                    ExecutorUtils.removeOnMain(runnable);
                    this.b = null;
                }
                Runnable runnable2 = new Runnable() { // from class: com.alibaba.griver.ui.loading.NebulaLoadingView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((GriverLoadingViewExtension) RVProxy.get(GriverLoadingViewExtension.class)).show(NebulaLoadingView.this.f6721a, str, z);
                    }
                };
                this.b = runnable2;
                ExecutorUtils.runOnMain(runnable2, i);
                return;
            }
            ((GriverLoadingViewExtension) RVProxy.get(GriverLoadingViewExtension.class)).show(this.f6721a, str, z);
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.loading.LoadingView
    public void dismiss() {
        synchronized (this.c) {
            a(false);
            Runnable runnable = this.b;
            if (runnable != null) {
                ExecutorUtils.removeOnMain(runnable);
                this.b = null;
            }
            ((GriverLoadingViewExtension) RVProxy.get(GriverLoadingViewExtension.class)).dismiss();
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.loading.LoadingView
    public boolean backPressed() {
        boolean onBackPressed;
        synchronized (this.c) {
            a(false);
            Runnable runnable = this.b;
            if (runnable != null) {
                ExecutorUtils.removeOnMain(runnable);
                this.b = null;
            }
            onBackPressed = ((GriverLoadingViewExtension) RVProxy.get(GriverLoadingViewExtension.class)).onBackPressed();
        }
        return onBackPressed;
    }
}
