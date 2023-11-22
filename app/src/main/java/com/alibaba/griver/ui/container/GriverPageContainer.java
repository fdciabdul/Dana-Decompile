package com.alibaba.griver.ui.container;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.page.PageStartedPoint;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.h5.point.GriverH5LoadProgressPoint;
import com.alibaba.griver.api.ui.pagecontainer.GVPageContainer;
import com.alibaba.griver.api.webview.PageFinishedPoint;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.progress.GriverProgressBar;
import com.alibaba.griver.ui.refresh.GriverRefreshHeader;
import com.alibaba.griver.ui.refresh.GriverSwipeRefreshLayout;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class GriverPageContainer implements PageStartedPoint, GriverH5LoadProgressPoint, GVPageContainer, PageFinishedPoint {

    /* renamed from: a  reason: collision with root package name */
    private Context f6708a;
    private GriverRootView b;
    private boolean c;
    private boolean d;
    private GriverSwipeRefreshLayout e;
    private GriverProgressBar f;
    private boolean g;
    private App h;
    private Page i;
    private H5CloseHandler j;
    private boolean l;
    private View m;
    private AtomicBoolean k = new AtomicBoolean(false);
    GriverSwipeRefreshLayout.OnReachDistanceRefreshListener reachDistanceRefreshListener = new GriverSwipeRefreshLayout.OnReachDistanceRefreshListener() { // from class: com.alibaba.griver.ui.container.GriverPageContainer.1
        @Override // com.alibaba.griver.ui.refresh.GriverSwipeRefreshLayout.OnReachDistanceRefreshListener
        public void onMotionEventUp() {
        }

        @Override // com.alibaba.griver.ui.refresh.GriverSwipeRefreshLayout.OnReachDistanceRefreshListener
        public boolean onReachPullRefreshDistance() {
            return false;
        }

        @Override // com.alibaba.griver.ui.refresh.GriverSwipeRefreshLayout.OnReachDistanceRefreshListener
        public void onRefresh() {
            try {
                if (GriverPageContainer.this.l) {
                    EngineUtils.sendToRender(GriverPageContainer.this.h.getActivePage().getRender(), EngineUtils.getWorker(GriverPageContainer.this.h.getEngineProxy()), RVEvents.FIRE_PULL_TO_REFRESH, null, new PullFreshCallback());
                    GriverPageContainer.this.l = false;
                    return;
                }
                GriverLogger.w("GriverPageContainer", "date not return, not sendToWeb FIRE_PULL_TO_REFRESH");
            } catch (Exception unused) {
            }
        }
    };

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    public GriverPageContainer(Context context, App app) {
        this.h = app;
        this.f6708a = context;
        GriverRootView griverRootView = (GriverRootView) LayoutInflater.from(context).inflate(R.layout.griver_ui_container_root_view, (ViewGroup) null);
        this.b = griverRootView;
        this.l = true;
        this.e = (GriverSwipeRefreshLayout) griverRootView.findViewById(R.id.griver_layout_refresh);
        GriverProgressBar griverProgressBar = (GriverProgressBar) this.b.findViewById(R.id.griver_h5_prgress);
        this.f = griverProgressBar;
        griverProgressBar.setNotifier(new GriverProgressBar.ProgressNotifier() { // from class: com.alibaba.griver.ui.container.GriverPageContainer.2
            @Override // com.alibaba.griver.ui.progress.GriverProgressBar.ProgressNotifier
            public void onProgressBegin() {
                StringBuilder sb = new StringBuilder();
                sb.append("isShowProgress:");
                sb.append(GriverPageContainer.this.k);
                sb.append(" visible:");
                sb.append(GriverPageContainer.this.f.getVisibility());
                GriverLogger.d("GriverPageContainer", sb.toString());
                GriverPageContainer.this.k.set(true);
            }

            @Override // com.alibaba.griver.ui.progress.GriverProgressBar.ProgressNotifier
            public void onProgressEnd() {
                StringBuilder sb = new StringBuilder();
                sb.append("isShowProgress:");
                sb.append(GriverPageContainer.this.k);
                sb.append(" visible:");
                sb.append(GriverPageContainer.this.f.getVisibility());
                GriverLogger.d("GriverPageContainer", sb.toString());
                if (GriverPageContainer.this.k.compareAndSet(true, false) && GriverPageContainer.this.f.getVisibility() == 0) {
                    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
                    translateAnimation.setDuration(300L);
                    GriverPageContainer.this.f.startAnimation(translateAnimation);
                    GriverPageContainer.this.f.setVisibility(8);
                }
            }
        });
        boolean z = BundleUtils.getBoolean(app.getStartParams(), "showProgress", false);
        this.g = z;
        if (z) {
            this.f.setVisibility(0);
            int i = BundleUtils.getInt(app.getStartParams(), "progressBarColor", 0);
            if (i != 0) {
                try {
                    this.f.setProgressDrawable(InstrumentInjector.Resources_getDrawable(this.f6708a.getResources(), i));
                } catch (Exception unused) {
                }
            }
        } else {
            this.f.setVisibility(8);
        }
        this.j = new H5CloseHandler();
    }

    @Override // com.alibaba.ariver.app.api.ui.PageContainer
    public void attachPage(Page page) {
        this.i = page;
        a(page);
    }

    @Override // com.alibaba.ariver.app.api.ui.PageContainer
    public ViewGroup getView() {
        return this.b;
    }

    @Override // com.alibaba.ariver.app.api.ui.PageContainer
    public void addRenderView(View view) {
        this.m = view;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.e.addView(view, new ViewGroup.LayoutParams(-1, -1));
    }

    public View getRenderView() {
        return this.m;
    }

    private void a(Page page) {
        this.d = false;
        this.c = false;
        if (page.getStartParams() != null && page.getStartParams().get("pullRefresh") != null) {
            this.c = ((Boolean) page.getStartParams().get("pullRefresh")).booleanValue();
        }
        if (page.getStartParams() != null && page.getStartParams().get("canPullDown") != null) {
            this.d = ((Boolean) page.getStartParams().get("canPullDown")).booleanValue();
        }
        boolean z = this.c;
        if (z && this.d) {
            c();
        } else if (z) {
            a();
        } else {
            b();
        }
    }

    private void a() {
        this.e.enablePullRefresh(true);
        this.e.enableLoadMore(false);
        this.e.enableSecondFloor(false);
        this.e.setPullRefreshDistance(30);
        this.e.setDistanceToRefresh(48);
        if (this.e.isRefreshing()) {
            return;
        }
        this.e.setHeaderView(new GriverRefreshHeader(this.f6708a));
    }

    private void b() {
        this.e.enablePullRefresh(false);
        this.e.enableLoadMore(false);
        this.e.enableSecondFloor(false);
        this.e.setPullRefreshDistance(0);
        this.e.setDistanceToRefresh(0);
        if (this.e.isRefreshing()) {
            return;
        }
        this.e.setHeaderView(new GriverRefreshHeader(this.f6708a));
    }

    private void c() {
        this.e.enablePullRefresh(true);
        this.e.enableLoadMore(false);
        this.e.enableSecondFloor(false);
        this.e.setPullRefreshDistance(30);
        if (!this.e.isRefreshing()) {
            this.e.setHeaderView(new GriverRefreshHeader(this.f6708a));
        }
        this.e.setReachDistanceRefreshListener(this.reachDistanceRefreshListener);
    }

    public void startPullDownRefresh() {
        this.e.setRefreshingWithNotify(true, true);
    }

    public void restorePullToRefresh() {
        this.e.setRefreshing(false);
        this.l = true;
    }

    public void setCanPullDown(boolean z) {
        if (z) {
            this.d = true;
            if (this.c) {
                c();
                return;
            } else {
                a();
                return;
            }
        }
        this.d = false;
        if (this.c) {
            restorePullToRefresh();
        }
        b();
    }

    public GriverProgressBar getProgressBar() {
        return this.f;
    }

    @Override // com.alibaba.griver.api.h5.point.GriverH5LoadProgressPoint
    public void onProgressChanged(int i) {
        GriverProgressBar griverProgressBar = this.f;
        if (griverProgressBar == null || !this.g) {
            return;
        }
        griverProgressBar.setProgress(i);
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageStartedPoint
    public void onStarted(String str) {
        if (this.f == null || !BundleUtils.getBoolean(this.i.getStartParams(), "showProgress", false)) {
            return;
        }
        this.f.setVisibility(0);
    }

    @Override // com.alibaba.griver.api.webview.PageFinishedPoint
    public void onPageFinished(String str) {
        GriverProgressBar griverProgressBar = this.f;
        if (griverProgressBar != null) {
            griverProgressBar.setVisibility(8);
        }
        restorePullToRefresh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class H5CloseHandler implements SendToRenderCallback {
        public boolean waiting = false;
        public long lastClose = 0;

        public H5CloseHandler() {
        }

        @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
        public void onCallBack(JSONObject jSONObject) {
            this.waiting = false;
            boolean z = JSONUtils.getBoolean(jSONObject, "prevent", false);
            StringBuilder sb = new StringBuilder();
            sb.append("close event prevent ");
            sb.append(z);
            RVLogger.d("GriverPageContainer", sb.toString());
            if (z) {
                return;
            }
            GriverPageContainer.this.e();
        }
    }

    private void d() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.j.lastClose < 500) {
            RVLogger.d("GriverPageContainer", "ignore bridge, perform close!");
            e();
            return;
        }
        RVLogger.d("GriverPageContainer", "send close event to bridge!");
        this.j.waiting = true;
        this.j.lastClose = currentTimeMillis;
        EngineUtils.sendToRender(this.i.getRender(), "closeWindow", null, this.j);
    }

    public void handleCloseEvent() {
        if (!BundleUtils.getBoolean(this.i.getStartParams(), RVParams.isH5App, false)) {
            StringBuilder sb = new StringBuilder();
            sb.append(GriverFullLinkStageMonitor.MONITOR_TOKEN);
            sb.append(this.h.getAppId());
            sb.append(this.h.getStartToken());
            GriverStageMonitor stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(sb.toString());
            if (stageMonitor != null) {
                stageMonitor.addParam(GriverMonitorConstants.MINI_PROGRAM_APP_CLOSE_TYPE, GriverMonitorConstants.MINI_PROGRAM_APP_CLOSE_BY_CLOSE_BUTTON);
            }
            AppContext appContext = this.h.getAppContext();
            if (appContext == null || appContext.moveToBackground()) {
                return;
            }
            this.h.exit();
            return;
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.i.exit(true);
    }

    /* loaded from: classes6.dex */
    class PullFreshCallback implements SendToRenderCallback {
        public PullFreshCallback() {
        }

        @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
        public void onCallBack(JSONObject jSONObject) {
            boolean z = JSONUtils.getBoolean(jSONObject, "prevent", false);
            StringBuilder sb = new StringBuilder();
            sb.append("FIRE_PULL_TO_REFRESH event prevent: ");
            sb.append(z);
            GriverLogger.d("GriverPageContainer", sb.toString());
            if (z) {
                GriverLogger.d("GriverPageContainer", "set e.preventDefault(),not send H5_PAGE_RELOAD");
                return;
            }
            GriverLogger.d("GriverPageContainer", "not set e.preventDefault(),sendEvent H5_PAGE_RELOAD");
            try {
                GriverPageContainer.this.h.getActivePage().getRender().reload();
            } catch (Exception e) {
                GriverLogger.e("GriverPageContainer", "reload exception", e);
            }
            GriverPageContainer.this.l = true;
        }
    }
}
