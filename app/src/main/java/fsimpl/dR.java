package fsimpl;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewProvider;
import com.fullstory.util.Log;

/* loaded from: classes.dex */
public class dR {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f7924a;
    private static dS b;

    private static dS a(WebViewProvider webViewProvider) {
        dS b2 = dU.b(webViewProvider);
        return b2 != null ? b2 : dT.b(webViewProvider);
    }

    public static boolean a(WebView webView) {
        if (f7924a == null) {
            c(webView);
        }
        Boolean bool = f7924a;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static WebViewClient b(WebView webView) {
        if (f7924a == null) {
            c(webView);
        }
        Boolean bool = f7924a;
        if (bool == null || !bool.booleanValue()) {
            return null;
        }
        try {
            WebViewProvider webViewProvider = webView.getWebViewProvider();
            if (webViewProvider != null) {
                return b.a(webViewProvider);
            }
            return null;
        } catch (Throwable th) {
            Log.e("Exception trying to retrieve the current WebViewClient instance", th);
            return null;
        }
    }

    private static void c(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            WebViewProvider webViewProvider = webView.getWebViewProvider();
            if (webViewProvider != null) {
                dS a2 = a(webViewProvider);
                b = a2;
                if (a2 != null) {
                    f7924a = Boolean.TRUE;
                    return;
                }
                f7924a = Boolean.FALSE;
                Log.e("Unable to find underlying WebViewClient fields");
            }
        } catch (Throwable th) {
            f7924a = Boolean.FALSE;
            Log.e("Exception trying to find WebViewClient fields", th);
        }
    }
}
