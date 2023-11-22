package com.alibaba.griver.ui.splash;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.griver.api.ui.GVSplashView;

/* loaded from: classes3.dex */
public abstract class BaseSplashView implements GVSplashView {

    /* renamed from: a  reason: collision with root package name */
    private App f6752a;
    protected GVSplashView.OnReloadListener listener;
    protected GVSplashView.OnExitListener onExitListener;

    public BaseSplashView(App app) {
        this.f6752a = app;
    }

    @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
    public void showLoading(EntryInfo entryInfo) {
        if (getStatus() != SplashView.Status.LOADING) {
            ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.f6752a, TrackId.Stub_LoadingStart);
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
    public void exit(SplashView.ExitListener exitListener) {
        if (getStatus() == SplashView.Status.LOADING) {
            ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.f6752a, TrackId.Stub_LoadingEnd);
        }
        GVSplashView.OnExitListener onExitListener = this.onExitListener;
        if (onExitListener != null) {
            onExitListener.onExit();
        }
    }

    @Override // com.alibaba.griver.api.ui.GVSplashView
    public void reload() {
        GVSplashView.OnReloadListener onReloadListener = this.listener;
        if (onReloadListener != null) {
            onReloadListener.onReload();
        }
    }

    @Override // com.alibaba.griver.api.ui.GVSplashView
    public void setReloadListener(GVSplashView.OnReloadListener onReloadListener) {
        this.listener = onReloadListener;
    }

    @Override // com.alibaba.griver.api.ui.GVSplashView
    public void setOnExitListener(GVSplashView.OnExitListener onExitListener) {
        this.onExitListener = onExitListener;
    }
}
