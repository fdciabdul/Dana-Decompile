package com.alibaba.griver.core.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class AndroidWebViewDelegateView extends FrameLayout {
    public static final String KEY_EMBEDVIEW_SCROLL_WAY = "embedview_scroll_way";
    public static final boolean SCROLL_ENABLE_NEW_WAY = true;

    /* renamed from: a  reason: collision with root package name */
    private Pair<Boolean, Boolean> f6491a;
    private Map<String, View> b;
    private int c;
    private int d;

    public boolean getScrollWay() {
        if (!((Boolean) this.f6491a.first).booleanValue()) {
            this.f6491a = new Pair<>(Boolean.TRUE, Boolean.valueOf(GriverInnerConfig.getConfigBoolean(KEY_EMBEDVIEW_SCROLL_WAY, true)));
        }
        return ((Boolean) this.f6491a.second).booleanValue();
    }

    public AndroidWebViewDelegateView(Context context) {
        super(context);
        this.f6491a = new Pair<>(Boolean.FALSE, Boolean.TRUE);
        this.b = new HashMap();
    }

    public AndroidWebViewDelegateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6491a = new Pair<>(Boolean.FALSE, Boolean.TRUE);
        this.b = new HashMap();
    }

    public AndroidWebViewDelegateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6491a = new Pair<>(Boolean.FALSE, Boolean.TRUE);
        this.b = new HashMap();
    }

    public void setAndroidWebView(WebView webView) {
        addViewInLayout(webView, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    public void removeEmbedView(String str) {
        View remove = this.b.remove(str);
        if (remove == null) {
            return;
        }
        removeView(remove);
    }

    public void addEmbedView(String str, View view, int i, int i2, int i3, int i4) {
        if (this.b.containsKey(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("addEmbedView just modify view param!, topoffsetX=");
            sb.append(this.c);
            sb.append("offsetYoffsetY");
            RVLogger.w("AndroidWebViewDelegateView", sb.toString());
            View view2 = this.b.get(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
            layoutParams.width = i;
            layoutParams.height = i2;
            layoutParams.topMargin = i3 - this.d;
            layoutParams.leftMargin = i4 - this.c;
            view2.setLayoutParams(layoutParams);
        } else if (str == null || view == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("addEmbedView param error! id: ");
            sb2.append(str);
            sb2.append(" embedView: ");
            sb2.append(view);
            RVLogger.w("AndroidWebViewDelegateView", sb2.toString());
        } else {
            EmbedViewContainerView embedViewContainerView = new EmbedViewContainerView(getContext());
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i2);
            layoutParams2.topMargin = i3;
            layoutParams2.leftMargin = i4;
            embedViewContainerView.addView(view, layoutParams2);
            this.b.put(str, view);
            addView(embedViewContainerView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
        int i5 = i - i3;
        int i6 = i2 - i4;
        this.c = i;
        this.d = i2;
        for (View view : this.b.values()) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (getScrollWay() && layoutParams != null && (layoutParams instanceof FrameLayout.LayoutParams)) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin += -i6;
                layoutParams2.leftMargin += -i5;
                view.setLayoutParams(layoutParams);
            } else {
                view.offsetTopAndBottom(-i6);
                view.offsetLeftAndRight(-i5);
            }
        }
    }

    /* loaded from: classes6.dex */
    static class EmbedViewContainerView extends FrameLayout {
        public EmbedViewContainerView(Context context) {
            super(context);
        }

        public EmbedViewContainerView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public EmbedViewContainerView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }
}
