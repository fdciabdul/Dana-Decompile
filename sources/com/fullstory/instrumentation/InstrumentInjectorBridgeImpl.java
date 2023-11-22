package com.fullstory.instrumentation;

import android.app.Application;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EdgeEffect;
import com.fullstory.FS;
import com.fullstory.FSOnReadyListener;
import com.fullstory.FSPage;
import com.fullstory.FSSessionData;
import com.fullstory.instrumentation.frameworks.compose.FSComposeRenderNodeLayer;
import com.fullstory.util.Log;
import fsimpl.C0223aa;
import fsimpl.C0238ap;
import fsimpl.C0256bg;
import fsimpl.F;
import fsimpl.G;
import fsimpl.K;
import java.lang.Thread;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public class InstrumentInjectorBridgeImpl implements InstrumentInjectorBridge {

    /* renamed from: a  reason: collision with root package name */
    private static FSOnReadyListener f7426a;

    private void a() {
        final FSOnReadyListener fSOnReadyListener;
        String str;
        K impl = Bootstrap.impl();
        if (impl == null) {
            str = "Not invoking FSOnReadyListener#onReady due to null InstrumentInjectorImpl";
        } else {
            final String currentSessionURL = InstrumentInjector.getCurrentSessionURL(false);
            if (a(currentSessionURL)) {
                synchronized (InstrumentInjector.class) {
                    fSOnReadyListener = f7426a;
                }
                if (fSOnReadyListener != null) {
                    impl.runOnUiThread(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$kYmj2qlVPSaH0WyJRyrO71Ieix4
                        @Override // java.lang.Runnable
                        public final void run() {
                            InstrumentInjectorBridgeImpl.a(FSOnReadyListener.this, currentSessionURL);
                        }
                    });
                    return;
                } else {
                    Log.d("Not invoking FSOnReadyListener#onReady due to null listener");
                    return;
                }
            }
            str = "Not invoking FSOnReadyListener#onReady due to disabled or null session";
        }
        Log.d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i, boolean z, boolean z2, boolean z3) {
        Bootstrap.impl().reactNative_exec_onFsPressForward(i, z, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Typeface typeface, Typeface typeface2, int i) {
        Bootstrap.impl().typefaceCreateDerived(typeface, typeface2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Typeface typeface, String str) {
        Bootstrap.impl().typefaceCreateFromAsset(typeface, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Drawable drawable, int i) {
        Bootstrap.impl().associateDrawable(drawable, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(View view) {
        Bootstrap.impl().removeAllClasses(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(View view, String str) {
        Bootstrap.impl().removeClass(view, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(View view, String str, String str2) {
        Bootstrap.impl().setAttribute(view, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(View view, Collection collection) {
        Bootstrap.impl().removeClasses(view, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Window window) {
        Bootstrap.impl().trackWindow(window);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(FS.LogLevel logLevel, String str) {
        Bootstrap.impl().log(logLevel, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(FS.LogLevel logLevel, String str, String str2, Throwable th) {
        Bootstrap.impl().logcat(logLevel, str, str2, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(FSOnReadyListener fSOnReadyListener, String str) {
        try {
            Log.d("Invoking FSOnReadyListener#onReady");
            fSOnReadyListener.onReady(new FSSessionData(str));
        } catch (Throwable th) {
            Log.e("Uncaught error when executing FSOnReadyListener.onReady callback", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Object obj, String str) {
        Bootstrap.impl().removePopupMenuClass(obj, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, Object obj) {
        Bootstrap.impl().__sendInternalMessage(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, Map map) {
        Bootstrap.impl().event(str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(UUID uuid) {
        Bootstrap.impl().endPage(uuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(UUID uuid, String str, Map map) {
        Bootstrap.impl().pageView(uuid, str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(UUID uuid, Map map) {
        Bootstrap.impl().updatePageProperties(uuid, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z) {
        Bootstrap.impl().consent(z);
    }

    private static boolean a(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(View view, String str) {
        Bootstrap.impl().addClass(view, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(View view, Collection collection) {
        Bootstrap.impl().addClasses(view, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(Object obj, String str) {
        Bootstrap.impl().addPopupMenuClass(obj, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str, Map map) {
        Bootstrap.impl().updateUser(str, map);
    }

    private static boolean b() {
        return Build.VERSION.SDK_INT >= 31;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c() {
        Bootstrap.impl().resetIdleTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(View view, String str) {
        Bootstrap.impl().removeAttribute(view, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d() {
        Bootstrap.impl().restart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(View view, String str) {
        Bootstrap.impl().setTagName(view, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e() {
        Bootstrap.impl().shutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f() {
        Bootstrap.impl().anonymize();
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void __endPage(final UUID uuid) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$qtUhcZWSFLh2RPUXIxXESOn09go
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.a(uuid);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void __pageView(final UUID uuid, final String str, final Map map) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$bJMbNPnAc0exh0UVOpZvwcgfM18
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.a(uuid, str, map);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void __sendInternalMessage(final String str, final Object obj) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$ooSnLy_mENFJ32Pls2bij7g1xEU
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.a(str, obj);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void __updatePageProperties(final UUID uuid, final Map map) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$1AGxXG6qibPNwgYwBaKjspJionk
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.a(uuid, map);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void addClass(final View view, final String str) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$WmnhGwgEhNVKhHSpxTdMvKIcAro
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.b(view, str);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void addClasses(final View view, final Collection collection) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$lpQnJxJ7qALiCBWTugaIGX5JldA
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.b(view, collection);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void addPopupMenuClass(final Object obj, final String str) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$4QnS86sWTgrQ_dSEHYbM07Nrok4
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.b(obj, str);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void anonymize() {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$Gf0xd4Rft6z_cDKbfjvH9keJ8M8
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.f();
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void associateDrawable(final Drawable drawable, final int i) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$evfE5JPOrVYV7xwzNTlPmCHnbpg
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.a(drawable, i);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void compose_click(Object obj) {
        K impl = Bootstrap.impl();
        if (impl != null) {
            impl.compose_click(obj);
        }
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void compose_nodeChanged(Object obj) {
        K impl = Bootstrap.impl();
        if (impl != null) {
            impl.compose_nodeChanged(obj);
        }
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public boolean compose_shouldDraw(Object obj, Object obj2, Canvas canvas) {
        if (canvas instanceof C0223aa) {
            return C0238ap.a(obj, (C0223aa) canvas);
        }
        return true;
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public boolean compose_shouldDrawAndroidView(Object obj, View view, Canvas canvas) {
        if (canvas instanceof C0223aa) {
            C0238ap.a(obj, view, (C0223aa) canvas);
            return false;
        }
        return true;
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public boolean compose_shouldDrawLayer(Object obj, Object obj2, Canvas canvas) {
        if (canvas instanceof C0223aa) {
            if (obj instanceof FSComposeRenderNodeLayer) {
                C0238ap.a((FSComposeRenderNodeLayer) obj, obj2);
                return false;
            }
            return false;
        }
        return true;
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public boolean compose_shouldObserveReads(Canvas canvas) {
        return !(canvas instanceof C0223aa);
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void consent(final boolean z) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$4y44l6XwnsU3IhShlvmPGH_ohTM
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.a(z);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void disableInjection(WebView webView) {
        K impl = Bootstrap.impl();
        if (impl != null) {
            impl.disableInjection(webView);
        }
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void event(final String str, final Map map) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$3XOGT1BX6eOT_XBGxtWdeGufovo
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.a(str, map);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public View.AccessibilityDelegate getAccessibilityDelegate(View view) {
        K impl = Bootstrap.impl();
        return impl != null ? impl.getAccessibilityDelegate(view) : view.getAccessibilityDelegate();
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public String getCurrentSession() {
        K impl = Bootstrap.impl();
        if (impl != null) {
            return impl.getCurrentSession();
        }
        return null;
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public String getCurrentSessionURL(boolean z) {
        K impl = Bootstrap.impl();
        if (impl != null) {
            return impl.getCurrentSessionURL(z);
        }
        return null;
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
        K impl = Bootstrap.impl();
        return impl != null ? impl.getDefaultUncaughtExceptionHandler() : Thread.getDefaultUncaughtExceptionHandler();
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public WebViewClient getWebViewClient(WebView webView) {
        K impl = Bootstrap.impl();
        return impl != null ? impl.getWebViewClient(webView) : webView.getWebViewClient();
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void gotSession() {
        a();
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void init(Application application, Context context) {
        CurrentPlatform.init(context);
        Bootstrap.a(application, context);
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public boolean isPreviewMode() {
        K impl = Bootstrap.impl();
        if (impl == null) {
            return false;
        }
        return impl.isPreviewMode();
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public boolean isRecordingDispatchDraw(Object obj, Canvas canvas) {
        K impl = Bootstrap.impl();
        if (impl != null) {
            return impl.isRecordingDispatchDraw(obj, canvas);
        }
        return false;
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public boolean isRecordingDraw(Object obj, Canvas canvas) {
        K impl = Bootstrap.impl();
        if (impl != null) {
            return impl.isRecordingDraw(obj, canvas);
        }
        return false;
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public boolean isRecordingDrawChild(Object obj, Canvas canvas, View view, long j) {
        K impl = Bootstrap.impl();
        if (impl != null) {
            return impl.isRecordingDrawChild(obj, canvas, view, j);
        }
        return false;
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void log(final FS.LogLevel logLevel, final String str) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$mA3515zaPMbmaS995R8OdI9zzrs
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.a(FS.LogLevel.this, str);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void logcat(final FS.LogLevel logLevel, final String str, final String str2, final Throwable th) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$IH4JJa1Jf3HPjP4uNQ7vgdxHWIU
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.a(FS.LogLevel.this, str, str2, th);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public EdgeEffect maybeWrapEdgeEffect(EdgeEffect edgeEffect, Context context) {
        return b() ? new F(context) : edgeEffect;
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public EdgeEffect maybeWrapEdgeEffect(EdgeEffect edgeEffect, Context context, AttributeSet attributeSet) {
        return b() ? new F(context, attributeSet) : edgeEffect;
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void okhttp_addInterceptors(Object obj) {
        K impl = Bootstrap.impl();
        if (impl != null) {
            impl.okhttp_addInterceptors(obj);
        }
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public FSPage page(String str, Map map) {
        return new G(str, map);
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void reactNative_exec_onFsPressForward(final int i, final boolean z, final boolean z2, final boolean z3) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$vLoaoqFtFiomtVJ4Z5-kzYltoOI
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.a(i, z, z2, z3);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void reactNative_trackNativeViewHierarchyManager(Object obj) {
        C0256bg.a(obj);
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void removeAllClasses(final View view) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$9LE4-BP6XRl_PrKvSlrwPoVA-R0
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.a(view);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void removeAttribute(final View view, final String str) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$mtPMS0Iryn4bEXcXdUfYW3MFF7w
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.c(view, str);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void removeClass(final View view, final String str) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$Ob61YVU0SsfP8nwhozMiB-ThTbs
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.a(view, str);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void removeClasses(final View view, final Collection collection) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$L41xiOLdpDTScYLp8zDLWMwpQ7g
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.a(view, collection);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void removePopupMenuClass(final Object obj, final String str) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$2P6E9O8d4wMWIkiexuY7bsbzKXM
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.a(obj, str);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void resetIdleTimer() {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$g6-toNWqvbn3yEpOygWzuQJTAPU
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.c();
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void restart() {
        Bootstrap.a(true, (Runnable) new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$AwCgbYvtSNWn_wXnJg56SOnsFMs
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.d();
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void setAccessibilityDelegate(View view, View.AccessibilityDelegate accessibilityDelegate) {
        K impl = Bootstrap.impl();
        if (impl != null) {
            impl.setAccessibilityDelegate(view, accessibilityDelegate);
        } else {
            view.setAccessibilityDelegate(accessibilityDelegate);
        }
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void setAttribute(final View view, final String str, final String str2) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$kL-2kAkxw5_67g6EBQ1KejivrFI
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.a(view, str, str2);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        K impl = Bootstrap.impl();
        if (impl != null) {
            impl.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        } else {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void setReadyListener(FSOnReadyListener fSOnReadyListener) {
        synchronized (InstrumentInjector.class) {
            f7426a = fSOnReadyListener;
        }
        a();
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void setTagName(final View view, final String str) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$FuRoTIrbprYyogfbd_D-uIA-IZ4
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.d(view, str);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void setWebViewClient(WebView webView, WebViewClient webViewClient) {
        K impl = Bootstrap.impl();
        if (impl != null) {
            impl.setWebViewClient(webView, webViewClient);
        } else {
            webView.setWebViewClient(webViewClient);
        }
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void shutdown() {
        Bootstrap.a(false, (Runnable) new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$liZijIIc0mG5DcSEBWfDhO_z3As
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.e();
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void trackWebView(WebView webView) {
        K impl = Bootstrap.impl();
        if (impl != null) {
            impl.trackWebView(webView);
        }
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void trackWindow(final Window window) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$TjZWmAkZFhVqaWMhk3B2b-diNxg
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.a(window);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void typefaceCreateDerived(final Typeface typeface, final Typeface typeface2, final int i) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$dDubNz1WiLIMCZ3V9sL3EqZD62o
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.a(typeface, typeface2, i);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void typefaceCreateFromAsset(final Typeface typeface, final String str) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$oJNR44t4QTUWEwQmUBIT0C9q__c
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.a(typeface, str);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public void updateUser(final String str, final Map map) {
        Bootstrap.a(new Runnable() { // from class: com.fullstory.instrumentation.-$$Lambda$InstrumentInjectorBridgeImpl$6dZGK-cwKoAH2aICZbtYQUV6zyU
            @Override // java.lang.Runnable
            public final void run() {
                InstrumentInjectorBridgeImpl.b(str, map);
            }
        });
    }

    @Override // com.fullstory.instrumentation.InstrumentInjectorBridge
    public URLConnection urlconnection_wrapInstance(URLConnection uRLConnection) {
        K impl = Bootstrap.impl();
        return impl == null ? uRLConnection : impl.urlconnection_wrapInstance(uRLConnection);
    }
}
