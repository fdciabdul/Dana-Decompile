package com.fullstory.instrumentation;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
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
import android.widget.ImageView;
import com.fullstory.FS;
import com.fullstory.FSOnReadyListener;
import com.fullstory.FSPage;
import com.fullstory.util.Log;
import fsstub.a;
import fsstub.b;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public class InstrumentInjector {

    /* renamed from: a  reason: collision with root package name */
    private static final InstrumentInjectorBridge f7425a;
    private static final Field b;
    private static final boolean c;

    static {
        c = Build.VERSION.SDK_INT >= 18;
        f7425a = b.a();
        Field field = null;
        if (!c) {
            try {
                field = View.class.getDeclaredField("mAccessibilityDelegate");
                field.setAccessible(true);
            } catch (Throwable unused) {
            }
        }
        b = field;
    }

    public static Drawable Resources_getDrawable(Context context, int i) {
        Drawable drawable = context.getDrawable(i);
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.associateDrawable(drawable, i);
        }
        return drawable;
    }

    public static Drawable Resources_getDrawable(Resources resources, int i) {
        Drawable drawable = resources.getDrawable(i);
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.associateDrawable(drawable, i);
        }
        return drawable;
    }

    public static Drawable Resources_getDrawable(Resources resources, int i, Resources.Theme theme) {
        Drawable drawable = resources.getDrawable(i, theme);
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.associateDrawable(drawable, i);
        }
        return drawable;
    }

    public static Drawable Resources_getDrawableForDensity(Resources resources, int i, int i2) {
        Drawable drawableForDensity = resources.getDrawableForDensity(i, i2);
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.associateDrawable(drawableForDensity, i);
        }
        return drawableForDensity;
    }

    public static Drawable Resources_getDrawableForDensity(Resources resources, int i, int i2, Resources.Theme theme) {
        Drawable drawableForDensity = resources.getDrawableForDensity(i, i2, theme);
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.associateDrawable(drawableForDensity, i);
        }
        return drawableForDensity;
    }

    public static void Resources_setImageResource(ImageView imageView, int i) {
        imageView.setImageResource(i);
        if (f7425a != null) {
            f7425a.associateDrawable(imageView.getDrawable(), i);
        }
    }

    public static void __endPage(UUID uuid) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.__endPage(uuid);
        }
    }

    public static void __pageView(UUID uuid, String str, Map map) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.__pageView(uuid, str, map);
        }
    }

    public static void __sendInternalMessage(String str, Object obj) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.__sendInternalMessage(str, obj);
        }
    }

    public static void __updatePageProperties(UUID uuid, Map map) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.__updatePageProperties(uuid, map);
        }
    }

    private static int a(int i, FS.LogLevel logLevel, String str, String str2, Throwable th) {
        InstrumentInjectorBridge instrumentInjectorBridge;
        if (i > 0 && (instrumentInjectorBridge = f7425a) != null) {
            instrumentInjectorBridge.logcat(logLevel, str, str2, th);
        }
        return i;
    }

    private static View.AccessibilityDelegate a(View view) {
        if (c) {
            return view.getAccessibilityDelegate();
        }
        Field field = b;
        if (field != null) {
            try {
                Object obj = field.get(view);
                if (obj instanceof View.AccessibilityDelegate) {
                    return (View.AccessibilityDelegate) obj;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static void addClass(View view, String str) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.addClass(view, str);
        }
    }

    public static void addClasses(View view, Collection collection) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.addClasses(view, collection);
        }
    }

    public static void addPopupMenuClass(Object obj, String str) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.addPopupMenuClass(obj, str);
        }
    }

    public static void anonymize() {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.anonymize();
        }
    }

    public static void compose_click(Object obj) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.compose_click(obj);
        }
    }

    public static void compose_nodeChanged(Object obj) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.compose_nodeChanged(obj);
        }
    }

    public static boolean compose_shouldDraw(Object obj, Object obj2, Canvas canvas) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            return instrumentInjectorBridge.compose_shouldDraw(obj, obj2, canvas);
        }
        return true;
    }

    public static boolean compose_shouldDrawAndroidView(Object obj, View view, Canvas canvas) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            return instrumentInjectorBridge.compose_shouldDrawAndroidView(obj, view, canvas);
        }
        return true;
    }

    public static boolean compose_shouldDrawLayer(Object obj, Object obj2, Canvas canvas) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            return instrumentInjectorBridge.compose_shouldDrawLayer(obj, obj2, canvas);
        }
        return true;
    }

    public static boolean compose_shouldObserveReads(Canvas canvas) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            return instrumentInjectorBridge.compose_shouldObserveReads(canvas);
        }
        return true;
    }

    public static void consent(boolean z) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.consent(z);
        }
    }

    public static void disableInjection(WebView webView) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.disableInjection(webView);
        }
    }

    public static void event(String str, Map map) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.event(str, map);
        }
    }

    public static View.AccessibilityDelegate getAccessibilityDelegate(Object obj) {
        if (obj == null) {
            return a((View) obj);
        }
        if (obj instanceof View) {
            View view = (View) obj;
            InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
            return instrumentInjectorBridge != null ? instrumentInjectorBridge.getAccessibilityDelegate(view) : a(view);
        }
        Class<?> cls = obj.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append("Calling non-View getAccessibilityDelegate method via reflection on ");
        sb.append(cls.getName());
        Log.i(sb.toString());
        try {
            Method method = cls.getMethod("getAccessibilityDelegate", new Class[0]);
            method.setAccessible(true);
            return (View.AccessibilityDelegate) method.invoke(obj, new Object[0]);
        } catch (Throwable th) {
            Log.e("Unable to invoke getAccessibilityDelegate via reflection", th);
            return null;
        }
    }

    public static String getCurrentSession() {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            return instrumentInjectorBridge.getCurrentSession();
        }
        return null;
    }

    public static String getCurrentSessionURL(boolean z) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            return instrumentInjectorBridge.getCurrentSessionURL(z);
        }
        return null;
    }

    public static Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        return instrumentInjectorBridge != null ? instrumentInjectorBridge.getDefaultUncaughtExceptionHandler() : Thread.getDefaultUncaughtExceptionHandler();
    }

    public static WebViewClient getWebViewClient(WebView webView) {
        InstrumentInjectorBridge instrumentInjectorBridge;
        if (Build.VERSION.SDK_INT >= 26 && (instrumentInjectorBridge = f7425a) != null) {
            return instrumentInjectorBridge.getWebViewClient(webView);
        }
        return webView.getWebViewClient();
    }

    public static void gotSession() {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.gotSession();
        }
    }

    public static void init(Application application, Context context) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.init(application, context);
        }
    }

    public static boolean isPreviewMode() {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            return instrumentInjectorBridge.isPreviewMode();
        }
        return false;
    }

    public static boolean isRecordingDispatchDraw(Object obj, Canvas canvas) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            return instrumentInjectorBridge.isRecordingDispatchDraw(obj, canvas);
        }
        return false;
    }

    public static boolean isRecordingDraw(Object obj, Canvas canvas) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            return instrumentInjectorBridge.isRecordingDraw(obj, canvas);
        }
        return false;
    }

    public static boolean isRecordingDrawChild(Object obj, Canvas canvas, View view, long j) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            return instrumentInjectorBridge.isRecordingDrawChild(obj, canvas, view, j);
        }
        return false;
    }

    public static void log(FS.LogLevel logLevel, String str) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.log(logLevel, str);
        }
    }

    public static int log_d(String str, String str2) {
        return a(android.util.Log.d(str, str2), FS.LogLevel.DEBUG, str, str2, null);
    }

    public static int log_d(String str, String str2, Throwable th) {
        return a(android.util.Log.d(str, str2, th), FS.LogLevel.DEBUG, str, str2, th);
    }

    public static int log_e(String str, String str2) {
        return a(android.util.Log.e(str, str2), FS.LogLevel.ERROR, str, str2, null);
    }

    public static int log_e(String str, String str2, Throwable th) {
        return a(android.util.Log.e(str, str2, th), FS.LogLevel.ERROR, str, str2, th);
    }

    public static int log_i(String str, String str2) {
        return a(android.util.Log.i(str, str2), FS.LogLevel.INFO, str, str2, null);
    }

    public static int log_i(String str, String str2, Throwable th) {
        return a(android.util.Log.i(str, str2, th), FS.LogLevel.INFO, str, str2, th);
    }

    public static int log_v(String str, String str2) {
        return a(android.util.Log.v(str, str2), FS.LogLevel.LOG, str, str2, null);
    }

    public static int log_v(String str, String str2, Throwable th) {
        return a(android.util.Log.v(str, str2, th), FS.LogLevel.LOG, str, str2, th);
    }

    public static int log_w(String str, String str2) {
        return a(android.util.Log.w(str, str2), FS.LogLevel.WARN, str, str2, null);
    }

    public static int log_w(String str, String str2, Throwable th) {
        return a(android.util.Log.w(str, str2, th), FS.LogLevel.WARN, str, str2, th);
    }

    public static int log_w(String str, Throwable th) {
        return a(android.util.Log.w(str, null, th), FS.LogLevel.WARN, str, null, th);
    }

    public static EdgeEffect maybeWrapEdgeEffect(EdgeEffect edgeEffect, Context context) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        return instrumentInjectorBridge != null ? instrumentInjectorBridge.maybeWrapEdgeEffect(edgeEffect, context) : edgeEffect;
    }

    public static EdgeEffect maybeWrapEdgeEffect(EdgeEffect edgeEffect, Context context, AttributeSet attributeSet) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        return instrumentInjectorBridge != null ? instrumentInjectorBridge.maybeWrapEdgeEffect(edgeEffect, context, attributeSet) : edgeEffect;
    }

    public static void okhttp_addInterceptors(Object obj) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.okhttp_addInterceptors(obj);
        }
    }

    public static FSPage page(String str, Map map) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        return instrumentInjectorBridge != null ? instrumentInjectorBridge.page(str, map) : new a();
    }

    public static void reactNative_exec_onFsPressForward(int i, boolean z, boolean z2, boolean z3) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.reactNative_exec_onFsPressForward(i, z, z2, z3);
        }
    }

    public static void reactNative_trackNativeViewHierarchyManager(Object obj) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.reactNative_trackNativeViewHierarchyManager(obj);
        }
    }

    public static void removeAllClasses(View view) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.removeAllClasses(view);
        }
    }

    public static void removeAttribute(View view, String str) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.removeAttribute(view, str);
        }
    }

    public static void removeClass(View view, String str) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.removeClass(view, str);
        }
    }

    public static void removeClasses(View view, Collection collection) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.removeClasses(view, collection);
        }
    }

    public static void removePopupMenuClass(Object obj, String str) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.removePopupMenuClass(obj, str);
        }
    }

    public static void resetIdleTimer() {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.resetIdleTimer();
        }
    }

    public static void restart() {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.restart();
        }
    }

    public static void setAccessibilityDelegate(Object obj, View.AccessibilityDelegate accessibilityDelegate) {
        if (obj == null) {
            ((View) obj).setAccessibilityDelegate(accessibilityDelegate);
        } else if (obj instanceof View) {
            View view = (View) obj;
            InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
            if (instrumentInjectorBridge != null) {
                instrumentInjectorBridge.setAccessibilityDelegate(view, accessibilityDelegate);
            } else {
                view.setAccessibilityDelegate(accessibilityDelegate);
            }
        } else {
            Class<?> cls = obj.getClass();
            StringBuilder sb = new StringBuilder();
            sb.append("Calling non-View setAccessibilityDelegate method via reflection on ");
            sb.append(cls.getName());
            Log.i(sb.toString());
            try {
                Method method = cls.getMethod("setAccessibilityDelegate", View.AccessibilityDelegate.class);
                method.setAccessible(true);
                method.invoke(obj, accessibilityDelegate);
            } catch (Throwable th) {
                Log.e("Unable to invoke setAccessibilityDelegate via reflection", th);
            }
        }
    }

    public static void setAttribute(View view, String str, String str2) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.setAttribute(view, str, str2);
        }
    }

    public static void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        } else {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    }

    public static void setReadyListener(FSOnReadyListener fSOnReadyListener) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.setReadyListener(fSOnReadyListener);
        }
    }

    public static void setTagName(View view, String str) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.setTagName(view, str);
        }
    }

    public static void setWebViewClient(WebView webView, WebViewClient webViewClient) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.setWebViewClient(webView, webViewClient);
        } else {
            webView.setWebViewClient(webViewClient);
        }
    }

    public static void shutdown() {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.shutdown();
        }
    }

    public static void trackWebView(WebView webView) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.trackWebView(webView);
        }
    }

    public static void trackWindow(Window window) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.trackWindow(window);
        }
    }

    public static Typeface typefaceCreateDerived(Typeface typeface, int i) {
        Typeface create = Typeface.create(typeface, i);
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.typefaceCreateDerived(typeface, create, i);
        }
        return create;
    }

    public static Typeface typefaceCreateFromAsset(AssetManager assetManager, String str) {
        Typeface createFromAsset = Typeface.createFromAsset(assetManager, str);
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.typefaceCreateFromAsset(createFromAsset, str);
        }
        return createFromAsset;
    }

    public static void updateUser(String str, Map map) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        if (instrumentInjectorBridge != null) {
            instrumentInjectorBridge.updateUser(str, map);
        }
    }

    public static URLConnection urlconnection_wrapInstance(URLConnection uRLConnection) {
        InstrumentInjectorBridge instrumentInjectorBridge = f7425a;
        return instrumentInjectorBridge != null ? instrumentInjectorBridge.urlconnection_wrapInstance(uRLConnection) : uRLConnection;
    }
}
