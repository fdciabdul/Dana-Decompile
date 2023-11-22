package fsimpl;

import android.webkit.WebView;
import com.fullstory.instrumentation.webview.WebViewTracker;

/* loaded from: classes.dex */
public class dO implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebView f7921a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ WebViewTracker d;

    public dO(WebViewTracker webViewTracker, WebView webView, String str, String str2) {
        this.d = webViewTracker;
        this.f7921a = webView;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7921a.evaluateJavascript(this.b, new WebViewTracker.TrackerValueCallback(this.c, null));
    }
}
