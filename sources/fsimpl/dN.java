package fsimpl;

import android.webkit.JavascriptInterface;
import com.fullstory.instrumentation.webview.WebViewTracker;

/* loaded from: classes.dex */
public class dN {

    /* renamed from: a  reason: collision with root package name */
    private final WebViewTracker f7920a;
    private final int b;

    public dN(WebViewTracker webViewTracker, int i) {
        this.f7920a = webViewTracker;
        this.b = i;
    }

    @JavascriptInterface
    public void send(int i, int i2, String str) {
        this.f7920a.a(this.b, i2, i, str);
    }
}
