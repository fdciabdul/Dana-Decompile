package com.alibaba.griver.api.ui;

import com.alibaba.ariver.app.api.ui.loading.SplashView;

/* loaded from: classes3.dex */
public interface GVSplashView extends SplashView {

    /* loaded from: classes3.dex */
    public interface OnExitListener {
        void onExit();
    }

    /* loaded from: classes3.dex */
    public interface OnReloadListener {
        void onReload();
    }

    void reload();

    void setOnExitListener(OnExitListener onExitListener);

    void setReloadListener(OnReloadListener onReloadListener);
}
