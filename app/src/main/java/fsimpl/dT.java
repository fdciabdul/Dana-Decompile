package fsimpl;

import android.webkit.WebViewClient;
import android.webkit.WebViewProvider;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
class dT extends dS {

    /* renamed from: a  reason: collision with root package name */
    private static Field f7925a;
    private static Field b;

    dT() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static dS b(WebViewProvider webViewProvider) {
        try {
            Field declaredField = webViewProvider.getClass().getDeclaredField("mContentsClientAdapter");
            f7925a = declaredField;
            declaredField.setAccessible(true);
            Object obj = f7925a.get(webViewProvider);
            if (obj != null) {
                Field declaredField2 = obj.getClass().getDeclaredField("mWebViewClient");
                b = declaredField2;
                declaredField2.setAccessible(true);
                return new dT();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // fsimpl.dS
    public WebViewClient a(WebViewProvider webViewProvider) {
        Object obj = f7925a.get(webViewProvider);
        if (obj != null) {
            Object obj2 = b.get(obj);
            if (obj2 instanceof WebViewClient) {
                return (WebViewClient) obj2;
            }
            return null;
        }
        return null;
    }
}
