package com.alibaba.griver.base.api;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes6.dex */
public interface RenderLoadingStatusChangePoint extends Extension {

    /* loaded from: classes6.dex */
    public interface LoadingStatusChangeListener {
        void onChange(Page page, int i);
    }

    int getRenderLoadStatusCode();

    void onLoadingStatusChanged(Page page, int i, Object obj);

    void registerStatusListener(LoadingStatusChangeListener loadingStatusChangeListener);

    void unRegisterStatusListener(LoadingStatusChangeListener loadingStatusChangeListener);
}
