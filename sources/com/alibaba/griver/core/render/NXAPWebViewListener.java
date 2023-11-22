package com.alibaba.griver.core.render;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.embedview.IEmbedViewManager;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.api.APWebViewListener;
import com.alibaba.griver.base.api.H5EmbededViewProvider;
import com.alibaba.griver.base.api.H5OverScrollListener;
import com.alibaba.griver.core.ui.GriverPage;
import java.util.Map;

/* loaded from: classes3.dex */
public class NXAPWebViewListener implements APWebViewListener {

    /* renamed from: a  reason: collision with root package name */
    private static String f6456a = "Griver:NXAPWebViewListener";
    private boolean b;
    private GriverPage c;
    private Page d;
    private H5OverScrollListener e;

    public NXAPWebViewListener(Page page, boolean z) {
        this.b = false;
        this.c = (GriverPage) page;
        this.d = page;
        this.b = z;
    }

    public void setH5OverScrollListener(H5OverScrollListener h5OverScrollListener) {
        this.e = h5OverScrollListener;
    }

    @Override // com.alibaba.griver.base.api.APWebViewListener
    public boolean overScrollBy(int i, int i2, int i3, int i4) {
        String str = f6456a;
        StringBuilder sb = new StringBuilder();
        sb.append("overScrollBy: ");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(i4);
        RVLogger.d(str, sb.toString());
        H5OverScrollListener h5OverScrollListener = this.e;
        if (h5OverScrollListener != null) {
            h5OverScrollListener.onOverScrolled(i, i2, i3, i4);
            return false;
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebViewListener
    public IEmbedViewManager getEmbedViewManager() {
        return this.d.getPageContext().getEmbedViewManager();
    }

    @Override // com.alibaba.griver.base.api.APWebViewListener
    public void onDetachedFromWindow() {
        GriverPage griverPage;
        if (!this.b || ((griverPage = this.c) != null && TextUtils.equals("H5Activity", BundleUtils.getString(griverPage.getStartParams(), "createPageSence")))) {
            RVLogger.d(f6456a, "onDetachedFromWindow in createPageSence");
            GriverPage griverPage2 = this.c;
            if (griverPage2 != null) {
                griverPage2.exit(false);
            }
        }
    }

    @Override // com.alibaba.griver.base.api.APWebViewListener
    public View getEmbedView(int i, int i2, String str, String str2, Map<String, String> map) {
        RVLogger.d(f6456a, "H5WebViewClient getEmbedView");
        GriverPage griverPage = this.c;
        if (griverPage != null) {
            griverPage.setContainsEmbedView(true);
            H5EmbededViewProvider embededViewProvider = this.c.getEmbededViewProvider();
            if (embededViewProvider != null) {
                View embedView = embededViewProvider.getEmbedView(i, i2, str, str2, map);
                if (embedView != null && embedView.getClass().getName().contains("AdapterTextureMapView")) {
                    this.c.setContainsEmbedSurfaceView(true);
                }
                return embedView;
            }
            return null;
        }
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebViewListener
    public void onEmbedViewAttachedToWebView(int i, int i2, String str, String str2, Map<String, String> map) {
        H5EmbededViewProvider embededViewProvider;
        RVLogger.d(f6456a, "H5WebViewClient onEmbedViewAttachedToWebView");
        GriverPage griverPage = this.c;
        if (griverPage == null || (embededViewProvider = griverPage.getEmbededViewProvider()) == null) {
            return;
        }
        embededViewProvider.onEmbedViewAttachedToWebView(i, i2, str, str2, map);
    }

    @Override // com.alibaba.griver.base.api.APWebViewListener
    public void onEmbedViewDetachedFromWebView(int i, int i2, String str, String str2, Map<String, String> map) {
        H5EmbededViewProvider embededViewProvider;
        RVLogger.d(f6456a, "H5WebViewClient onEmbedViewDetachedFromWebView");
        GriverPage griverPage = this.c;
        if (griverPage == null || (embededViewProvider = griverPage.getEmbededViewProvider()) == null) {
            return;
        }
        embededViewProvider.onEmbedViewDetachedFromWebView(i, i2, str, str2, map);
    }

    @Override // com.alibaba.griver.base.api.APWebViewListener
    public void onEmbedViewDestory(int i, int i2, String str, String str2, Map<String, String> map) {
        H5EmbededViewProvider embededViewProvider;
        RVLogger.d(f6456a, "H5WebViewClient onEmbedViewDestory");
        GriverPage griverPage = this.c;
        if (griverPage == null || (embededViewProvider = griverPage.getEmbededViewProvider()) == null) {
            return;
        }
        embededViewProvider.onEmbedViewDestory(i, i2, str, str2, map);
    }

    @Override // com.alibaba.griver.base.api.APWebViewListener
    public void onEmbedViewParamChanged(int i, int i2, String str, String str2, Map<String, String> map, String[] strArr, String[] strArr2) {
        H5EmbededViewProvider embededViewProvider;
        RVLogger.d(f6456a, "H5WebViewClient onEmbedViewParamChanged");
        GriverPage griverPage = this.c;
        if (griverPage == null || (embededViewProvider = griverPage.getEmbededViewProvider()) == null) {
            return;
        }
        embededViewProvider.onEmbedViewParamChanged(i, i2, str, str2, map, strArr, strArr2);
    }

    @Override // com.alibaba.griver.base.api.APWebViewListener
    public void onEmbedViewVisibilityChanged(int i, int i2, String str, String str2, Map<String, String> map, int i3) {
        H5EmbededViewProvider embededViewProvider;
        RVLogger.d(f6456a, "H5WebViewClient onEmbedViewVisibilityChanged");
        GriverPage griverPage = this.c;
        if (griverPage == null || (embededViewProvider = griverPage.getEmbededViewProvider()) == null) {
            return;
        }
        embededViewProvider.onEmbedViewVisibilityChanged(i, i2, str, str2, map, i3);
    }

    @Override // com.alibaba.griver.base.api.APWebViewListener
    public Bitmap getSnapshot(int i, int i2, String str, String str2, Map<String, String> map) {
        H5EmbededViewProvider embededViewProvider;
        RVLogger.d(f6456a, "H5WebViewClient getSnapshot");
        GriverPage griverPage = this.c;
        if (griverPage == null || (embededViewProvider = griverPage.getEmbededViewProvider()) == null) {
            return null;
        }
        return embededViewProvider.getSnapshot(i, i2, str, str2, map);
    }
}
