package fsimpl;

import android.webkit.WebViewClient;
import android.webkit.WebViewProvider;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
class dU extends dS {

    /* renamed from: a  reason: collision with root package name */
    private static Method f7926a;

    dU() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static dS b(WebViewProvider webViewProvider) {
        try {
            Method method = webViewProvider.getClass().getMethod("getWebViewClient", new Class[0]);
            f7926a = method;
            method.setAccessible(true);
            return new dU();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // fsimpl.dS
    public WebViewClient a(WebViewProvider webViewProvider) {
        return (WebViewClient) f7926a.invoke(webViewProvider, new Object[0]);
    }
}
