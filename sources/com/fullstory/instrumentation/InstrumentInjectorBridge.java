package com.fullstory.instrumentation;

import android.app.Application;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EdgeEffect;
import com.fullstory.FS;
import com.fullstory.FSOnReadyListener;
import com.fullstory.FSPage;
import java.lang.Thread;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public interface InstrumentInjectorBridge {
    void __endPage(UUID uuid);

    void __pageView(UUID uuid, String str, Map map);

    void __sendInternalMessage(String str, Object obj);

    void __updatePageProperties(UUID uuid, Map map);

    void addClass(View view, String str);

    void addClasses(View view, Collection collection);

    void addPopupMenuClass(Object obj, String str);

    void anonymize();

    void associateDrawable(Drawable drawable, int i);

    void compose_click(Object obj);

    void compose_nodeChanged(Object obj);

    boolean compose_shouldDraw(Object obj, Object obj2, Canvas canvas);

    boolean compose_shouldDrawAndroidView(Object obj, View view, Canvas canvas);

    boolean compose_shouldDrawLayer(Object obj, Object obj2, Canvas canvas);

    boolean compose_shouldObserveReads(Canvas canvas);

    void consent(boolean z);

    void disableInjection(WebView webView);

    void event(String str, Map map);

    View.AccessibilityDelegate getAccessibilityDelegate(View view);

    String getCurrentSession();

    String getCurrentSessionURL(boolean z);

    Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler();

    WebViewClient getWebViewClient(WebView webView);

    void gotSession();

    void init(Application application, Context context);

    boolean isPreviewMode();

    boolean isRecordingDispatchDraw(Object obj, Canvas canvas);

    boolean isRecordingDraw(Object obj, Canvas canvas);

    boolean isRecordingDrawChild(Object obj, Canvas canvas, View view, long j);

    void log(FS.LogLevel logLevel, String str);

    void logcat(FS.LogLevel logLevel, String str, String str2, Throwable th);

    EdgeEffect maybeWrapEdgeEffect(EdgeEffect edgeEffect, Context context);

    EdgeEffect maybeWrapEdgeEffect(EdgeEffect edgeEffect, Context context, AttributeSet attributeSet);

    void okhttp_addInterceptors(Object obj);

    FSPage page(String str, Map map);

    void reactNative_exec_onFsPressForward(int i, boolean z, boolean z2, boolean z3);

    void reactNative_trackNativeViewHierarchyManager(Object obj);

    void removeAllClasses(View view);

    void removeAttribute(View view, String str);

    void removeClass(View view, String str);

    void removeClasses(View view, Collection collection);

    void removePopupMenuClass(Object obj, String str);

    void resetIdleTimer();

    void restart();

    void setAccessibilityDelegate(View view, View.AccessibilityDelegate accessibilityDelegate);

    void setAttribute(View view, String str, String str2);

    void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler);

    void setReadyListener(FSOnReadyListener fSOnReadyListener);

    void setTagName(View view, String str);

    void setWebViewClient(WebView webView, WebViewClient webViewClient);

    void shutdown();

    void trackWebView(WebView webView);

    void trackWindow(Window window);

    void typefaceCreateDerived(Typeface typeface, Typeface typeface2, int i);

    void typefaceCreateFromAsset(Typeface typeface, String str);

    void updateUser(String str, Map map);

    URLConnection urlconnection_wrapInstance(URLConnection uRLConnection);
}
