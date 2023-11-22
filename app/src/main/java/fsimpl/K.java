package fsimpl;

import android.app.Application;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.alipaysecuritysdk.rds.constant.DictionaryKeys;
import com.fullstory.FS;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.frameworks.compose.FSComposeLayoutNode;
import com.fullstory.instrumentation.frameworks.compose.FSComposeModifier;
import com.fullstory.instrumentation.webview.WebViewTracker;
import com.fullstory.rust.RustInterface;
import com.fullstory.util.Log;
import java.io.IOException;
import java.lang.Thread;
import java.net.URLConnection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class K {
    private C0232aj b;
    private C0360j c;
    private final Context d;
    private A f;
    private Runnable g;
    private final aA h;
    private final bN i;
    private WebViewTracker webViewTracker;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference f7806a = new AtomicReference();
    private boolean e = false;

    public K(Application application, Context context, bG bGVar, bH bHVar, boolean z) {
        this.d = context;
        aA aAVar = new aA(bGVar.B());
        this.h = aAVar;
        this.i = new bN(aAVar);
        try {
            a(application, context, bGVar, bHVar, z);
        } catch (Throwable th) {
            Log.logAlways("Unable to initialize FS, aborting");
            cS.a("Unable to initialize FS", th);
        }
    }

    private void a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof C0233ak) {
            return;
        }
        C0233ak c0233ak = new C0233ak(this);
        c0233ak.a(defaultUncaughtExceptionHandler);
        Thread.setDefaultUncaughtExceptionHandler(c0233ak);
    }

    private void a(Application application, Context context, bG bGVar, bH bHVar, boolean z) {
        a();
        P p = new P(context);
        C0229ag c0229ag = new C0229ag(bGVar);
        C0376z c0376z = new C0376z(context.getCacheDir());
        this.c = new C0360j(context);
        C0240ar c0240ar = new C0240ar();
        c0240ar.a(new L(this));
        this.b = new C0232aj(bGVar);
        new C0312di(c0376z).a();
        RustInterface rustInterface = new RustInterface();
        C0320dr c0320dr = new C0320dr(c0376z, 10, 7, 3, new C0314dk(rustInterface));
        c0320dr.a();
        this.f = new A(bGVar, rustInterface, this.h);
        N n = new N(context, rustInterface);
        WebViewTracker webViewTracker = new WebViewTracker(rustInterface, bGVar.I());
        this.webViewTracker = webViewTracker;
        final C0225ac c0225ac = new C0225ac(rustInterface, context, bGVar, c0229ag, new C0228af(context, bGVar, c0320dr, c0376z, c0240ar, this.c, rustInterface, this.b, n, webViewTracker, this.h, this.f, z), p, c0376z, this.webViewTracker, c0320dr, z);
        c0320dr.a(new dJ() { // from class: fsimpl.-$$Lambda$K$m9x5CGb9eAyCInF4J4FV-C8brsM
            @Override // fsimpl.dJ
            public final void notify(String str, IOException iOException, boolean z2) {
                K.this.a(c0225ac, str, iOException, z2);
            }
        });
        rustInterface.a(c0225ac);
        this.f7806a.set(rustInterface);
        this.g = new M(this, application, bHVar);
        if (bGVar.G()) {
            application.registerActivityLifecycleCallbacks(new Q());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(C0225ac c0225ac, String str, IOException iOException, boolean z) {
        if (this.e && c0225ac.f7844a && z) {
            Log.i("Graceful shutdown: submitted final bundle, shutting down.");
            this.f.a();
        }
    }

    private void a(short s, FS.LogLevel logLevel, String str) {
        RustInterface rustInterface = (RustInterface) this.f7806a.get();
        if (rustInterface != null) {
            rustInterface.a(s, logLevel.name().toLowerCase(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, boolean z2, C c, View view, boolean z3) {
        if (z) {
            if (z2) {
                c.c(view);
            } else {
                c.d(view);
            }
        } else if (z3) {
            c.a(view);
        } else {
            c.b(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        C0351ev.a(new Runnable() { // from class: fsimpl.-$$Lambda$K$ZXFiKr5OPr9BGKu0sdCF_kJLkGk
            @Override // java.lang.Runnable
            public final void run() {
                K.this.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        C0344eo.a(this.d);
    }

    public void __sendInternalMessage(String str, Object obj) {
        if (str.equals("is_web_view_initialized")) {
            WebViewTracker webViewTracker = this.webViewTracker;
            if (webViewTracker != null) {
                Object[] objArr = (Object[]) obj;
                boolean b = webViewTracker.b((WebView) objArr[0]);
                try {
                    Object obj2 = objArr[1];
                    obj2.getClass().getDeclaredMethod("setResult", Object.class).invoke(obj2, Boolean.valueOf(b));
                } catch (Exception e) {
                    Log.e("is_web_view_initialized failed", e);
                }
            }
        } else if (str.equals("graceful_shutdown")) {
            this.e = true;
        }
        RustInterface rustInterface = (RustInterface) this.f7806a.get();
        if (rustInterface != null) {
            rustInterface.d(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Thread thread, Throwable th) {
        eZ a2 = eW.a(th);
        if (a2 != null) {
            FS.log(FS.LogLevel.ERROR, a2.f7964a);
        }
        if (this.f != null) {
            this.f.a(a2 == null ? new String[0] : a2.b);
        }
    }

    public void addClass(View view, String str) {
        this.h.c(view, str);
    }

    public void addClasses(View view, Collection collection) {
        this.h.a(view, collection);
    }

    public void addPopupMenuClass(Object obj, String str) {
        this.i.a(obj, str);
    }

    public void anonymize() {
        RustInterface rustInterface = (RustInterface) this.f7806a.get();
        if (rustInterface != null) {
            rustInterface.a(new C0336eg());
        }
    }

    public void associateDrawable(Drawable drawable, int i) {
        if (drawable instanceof VectorDrawable) {
            aV.a(drawable, i);
        }
    }

    public void compose_click(Object obj) {
        C0360j c0360j;
        C a2;
        C0311dh a3;
        FSComposeLayoutNode a4;
        if (!(obj instanceof FSComposeModifier) || (c0360j = this.c) == null || (a2 = c0360j.a()) == null || (a3 = this.h.a()) == null || (a4 = a3.a((FSComposeModifier) obj)) == null) {
            return;
        }
        a2.a(a4);
    }

    public void compose_nodeChanged(Object obj) {
        aA aAVar;
        C0311dh a2;
        if (!(obj instanceof FSComposeLayoutNode) || (aAVar = this.h) == null || (a2 = aAVar.a()) == null) {
            return;
        }
        a2.a((FSComposeLayoutNode) obj);
    }

    public void consent(boolean z) {
        RustInterface rustInterface = (RustInterface) this.f7806a.get();
        if (rustInterface != null) {
            rustInterface.a(new C0337eh(z));
        }
    }

    public void disableInjection(WebView webView) {
        WebViewTracker.d(webView);
    }

    public void endPage(UUID uuid) {
        RustInterface rustInterface = (RustInterface) this.f7806a.get();
        if (rustInterface == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(DictionaryKeys.V2_PAGENAME, "");
        rustInterface.a(new C0341el(EnumC0343en.PAGE, hashMap, true, uuid));
    }

    public void event(String str, Map map) {
        RustInterface rustInterface = (RustInterface) this.f7806a.get();
        if (rustInterface != null) {
            rustInterface.a(new C0338ei(str, map));
        }
    }

    public void finishStartup() {
        Runnable runnable = this.g;
        if (runnable != null) {
            runnable.run();
            this.g = null;
        }
        runOnUiThread(new Runnable() { // from class: fsimpl.-$$Lambda$K$c_xZLliVRCqFQAmhyzMj2lpbKLo
            @Override // java.lang.Runnable
            public final void run() {
                K.this.b();
            }
        });
    }

    public View.AccessibilityDelegate getAccessibilityDelegate(View view) {
        C0360j c0360j = this.c;
        return c0360j == null ? view.getAccessibilityDelegate() : c0360j.c(view);
    }

    public String getCurrentSession() {
        RustInterface rustInterface = (RustInterface) this.f7806a.get();
        if (rustInterface != null) {
            return rustInterface.b();
        }
        return null;
    }

    public C0230ah getCurrentSessionKnobs() {
        RustInterface rustInterface = (RustInterface) this.f7806a.get();
        if (rustInterface == null) {
            return null;
        }
        return rustInterface.a();
    }

    public String getCurrentSessionURL(boolean z) {
        RustInterface rustInterface = (RustInterface) this.f7806a.get();
        if (rustInterface != null) {
            return rustInterface.a(z);
        }
        return null;
    }

    public Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        return defaultUncaughtExceptionHandler instanceof C0233ak ? ((C0233ak) defaultUncaughtExceptionHandler).a() : Thread.getDefaultUncaughtExceptionHandler();
    }

    public WebViewClient getWebViewClient(WebView webView) {
        WebViewTracker webViewTracker = this.webViewTracker;
        return webViewTracker == null ? webView.getWebViewClient() : webViewTracker.e(webView);
    }

    public boolean isPreviewMode() {
        return bG.a(this.d).G();
    }

    public boolean isRecordingDispatchDraw(Object obj, Canvas canvas) {
        if ((obj instanceof ViewGroup) && (canvas instanceof C0223aa)) {
            ((C0223aa) canvas).a((ViewGroup) obj);
            return true;
        }
        return false;
    }

    public boolean isRecordingDraw(Object obj, Canvas canvas) {
        if ((obj instanceof View) && (canvas instanceof C0223aa)) {
            View view = (View) obj;
            AbstractC0329e.a(view, canvas);
            if (obj instanceof FSDispatchDraw) {
                AbstractC0329e.b(view, canvas);
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean isRecordingDrawChild(Object obj, Canvas canvas, View view, long j) {
        if ((obj instanceof ViewGroup) && (canvas instanceof C0223aa)) {
            ((C0223aa) canvas).a(view);
            return true;
        }
        return false;
    }

    public void log(FS.LogLevel logLevel, String str) {
        if (Log.isLoggable(logLevel)) {
            a((short) 1, logLevel, str);
        }
    }

    public void logcat(FS.LogLevel logLevel, String str, String str2, Throwable th) {
        if (Log.isLogcatLoggable(logLevel)) {
            if (str2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(": ");
                sb.append(str2);
                str = sb.toString();
            }
            a((short) 2, logLevel, str);
        }
    }

    public void okhttp_addInterceptors(Object obj) {
        RustInterface rustInterface = (RustInterface) this.f7806a.get();
        if (rustInterface == null) {
            return;
        }
        C0272bw.a(rustInterface, obj);
    }

    public void pageView(UUID uuid, String str, Map map) {
        RustInterface rustInterface = (RustInterface) this.f7806a.get();
        if (rustInterface == null) {
            return;
        }
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put(DictionaryKeys.V2_PAGENAME, str);
        rustInterface.a(new C0341el(EnumC0343en.PAGE, hashMap, false, uuid));
    }

    public void reactNative_exec_onFsPressForward(int i, final boolean z, final boolean z2, final boolean z3) {
        final C a2;
        final View a3;
        C0360j c0360j = this.c;
        if (c0360j == null || (a2 = c0360j.a()) == null || (a3 = C0256bg.a(i)) == null) {
            return;
        }
        fb.a(new Runnable() { // from class: fsimpl.-$$Lambda$K$jlPNyoFA4Iu2zlUPx1TTNjtdHII
            @Override // java.lang.Runnable
            public final void run() {
                K.a(z, z3, a2, a3, z2);
            }
        });
    }

    public void removeAllClasses(View view) {
        this.h.a(view);
    }

    public void removeAttribute(View view, String str) {
        this.h.b(view, str);
    }

    public void removeClass(View view, String str) {
        this.h.d(view, str);
    }

    public void removeClasses(View view, Collection collection) {
        this.h.b(view, collection);
    }

    public void removePopupMenuClass(Object obj, String str) {
        this.i.b(obj, str);
    }

    public void resetIdleTimer() {
        RustInterface rustInterface = (RustInterface) this.f7806a.get();
        if (rustInterface != null) {
            rustInterface.i();
        }
    }

    public void restart() {
        RustInterface rustInterface = (RustInterface) this.f7806a.get();
        if (rustInterface != null) {
            rustInterface.e();
        }
    }

    public void runOnUiThread(Runnable runnable) {
        fb.a(runnable);
    }

    public void setAccessibilityDelegate(View view, View.AccessibilityDelegate accessibilityDelegate) {
        C0360j c0360j = this.c;
        if (c0360j == null) {
            view.setAccessibilityDelegate(accessibilityDelegate);
        } else {
            c0360j.a(view, accessibilityDelegate);
        }
    }

    public void setAttribute(View view, String str, String str2) {
        this.h.a(view, str, str2);
    }

    public void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof C0233ak) {
            ((C0233ak) defaultUncaughtExceptionHandler).a(uncaughtExceptionHandler);
        } else {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    }

    public void setTagName(View view, String str) {
        this.h.a(view, str);
    }

    public void setWebViewClient(WebView webView, WebViewClient webViewClient) {
        WebViewTracker webViewTracker = this.webViewTracker;
        if (webViewTracker == null) {
            webView.setWebViewClient(webViewClient);
        } else {
            webViewTracker.a(webView, webViewClient);
        }
    }

    public void shutdown() {
        RustInterface rustInterface = (RustInterface) this.f7806a.get();
        if (rustInterface != null) {
            rustInterface.d();
        }
    }

    public void trackWebView(WebView webView) {
        WebViewTracker webViewTracker = this.webViewTracker;
        if (webViewTracker == null) {
            return;
        }
        webViewTracker.c(webView);
    }

    public void trackWindow(Window window) {
        C0239aq.a(window);
    }

    public void typefaceCreateDerived(Typeface typeface, Typeface typeface2, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Derived typeface ");
        sb.append(typeface2);
        sb.append(" from ");
        sb.append(typeface2);
        sb.append("/style = ");
        sb.append(i);
        Log.i(sb.toString());
        this.b.a(typeface2, typeface);
    }

    public void typefaceCreateFromAsset(Typeface typeface, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Loaded typeface ");
        sb.append(typeface);
        sb.append(" from ");
        sb.append(str);
        Log.i(sb.toString());
        this.b.a(typeface, str);
    }

    public void updatePageProperties(UUID uuid, Map map) {
        RustInterface rustInterface = (RustInterface) this.f7806a.get();
        if (rustInterface == null) {
            return;
        }
        rustInterface.a(new C0341el(EnumC0343en.PAGE, map, false, uuid));
    }

    public void updateUser(String str, Map map) {
        RustInterface rustInterface = (RustInterface) this.f7806a.get();
        if (rustInterface != null) {
            String d = fa.d(str);
            HashMap hashMap = null;
            if (d != null) {
                hashMap = map == null ? new HashMap() : new HashMap(map);
                hashMap.put("uid", d);
            }
            EnumC0343en enumC0343en = EnumC0343en.USER;
            if (hashMap != null) {
                map = hashMap;
            }
            rustInterface.a(new C0341el(enumC0343en, map));
        }
    }

    public URLConnection urlconnection_wrapInstance(URLConnection uRLConnection) {
        RustInterface rustInterface = (RustInterface) this.f7806a.get();
        return rustInterface == null ? uRLConnection : C0271bv.a(rustInterface, uRLConnection);
    }
}
