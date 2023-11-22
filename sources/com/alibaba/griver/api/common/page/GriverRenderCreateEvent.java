package com.alibaba.griver.api.common.page;

import android.webkit.WebView;
import com.alibaba.griver.api.common.GriverEvent;

/* loaded from: classes6.dex */
public interface GriverRenderCreateEvent extends GriverEvent {
    void renderCreate(WebView webView, GriverRenderType griverRenderType);
}
