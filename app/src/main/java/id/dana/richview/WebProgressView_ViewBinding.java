package id.dana.richview;

import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class WebProgressView_ViewBinding implements Unbinder {
    private WebProgressView MyBillsEntityDataFactory;

    public WebProgressView_ViewBinding(WebProgressView webProgressView, View view) {
        this.MyBillsEntityDataFactory = webProgressView;
        webProgressView.webView = (WebView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.webview, "field 'webView'", WebView.class);
        webProgressView.pbWebView = (ProgressBar) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.pb_webview, "field 'pbWebView'", ProgressBar.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        WebProgressView webProgressView = this.MyBillsEntityDataFactory;
        if (webProgressView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        webProgressView.webView = null;
        webProgressView.pbWebView = null;
    }
}
