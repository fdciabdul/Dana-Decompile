package id.dana.danah5.splunk;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.griver.core.webview.AndroidWebViewDelegateView;
import com.alibaba.griver.ui.refresh.GriverSwipeRefreshLayout;
import id.dana.danah5.base.UrlTransportEventHandler;
import id.dana.rum.Rum;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/danah5/splunk/SplunkWebViewPageListener;", "Lid/dana/danah5/base/UrlTransportEventHandler;", "Lcom/alibaba/ariver/app/api/Page;", "page", "", "url", "", "interceptUrl", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SplunkWebViewPageListener extends UrlTransportEventHandler {
    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.griver.api.common.page.GriverInterceptUrlEvent
    public final boolean interceptUrl(Page page, String url) {
        PageContext pageContext;
        ViewGroup contentView = (page == null || (pageContext = page.getPageContext()) == null) ? null : pageContext.getContentView();
        GriverSwipeRefreshLayout griverSwipeRefreshLayout = (GriverSwipeRefreshLayout) (contentView != null ? contentView.getChildAt(0) : null);
        AndroidWebViewDelegateView androidWebViewDelegateView = (AndroidWebViewDelegateView) (griverSwipeRefreshLayout != null ? griverSwipeRefreshLayout.getChildAt(2) : null);
        WebView webView = (WebView) (androidWebViewDelegateView != null ? androidWebViewDelegateView.getChildAt(0) : null);
        if (webView != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            Rum.Companion companion = Rum.getAuthRequestContext;
            Rum.Companion.PlaceComponentResult(webView);
        }
        return false;
    }
}
