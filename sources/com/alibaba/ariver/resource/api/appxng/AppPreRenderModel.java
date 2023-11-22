package com.alibaba.ariver.resource.api.appxng;

import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class AppPreRenderModel {
    public boolean isPreLoad = false;
    public String pagePath;
    public WeakReference<View> preRenderWebView;
    public Status status;

    /* loaded from: classes6.dex */
    public enum Status {
        prepare,
        rendering,
        rendering_updateHistroy,
        rendering_pageFinish,
        done
    }
}
