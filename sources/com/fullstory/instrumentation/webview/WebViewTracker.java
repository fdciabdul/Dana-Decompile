package com.fullstory.instrumentation.webview;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.rust.RustInterface;
import com.fullstory.util.Log;
import com.google.common.base.Ascii;
import fsimpl.dM;
import fsimpl.dN;
import fsimpl.dO;
import fsimpl.dP;
import fsimpl.dQ;
import fsimpl.dR;
import fsimpl.fb;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.net.URL;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class WebViewTracker {
    private final RustInterface c;
    private final boolean d;
    private final SparseArray e = new SparseArray();
    private final ReferenceQueue f = new ReferenceQueue();
    private final String g;
    private final String h;
    private boolean i;
    private final int j;
    public static final byte[] getAuthRequestContext = {8, 17, -121, -18, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int PlaceComponentResult = 63;

    /* renamed from: a  reason: collision with root package name */
    private static final Set f7428a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private static final String b = null;

    /* loaded from: classes3.dex */
    public class TrackerValueCallback implements ValueCallback {
        private String title;

        private TrackerValueCallback(String str) {
            this.title = str;
        }

        public /* synthetic */ TrackerValueCallback(String str, dO dOVar) {
            this(str);
        }

        @Override // android.webkit.ValueCallback
        public void onReceiveValue(String str) {
            WebViewTracker.b("WebViewTracker actuallyEvaluateJs=%s result=%s", this.title, str);
        }
    }

    public WebViewTracker(RustInterface rustInterface, boolean z) {
        this.c = rustInterface;
        this.d = z;
        this.g = rustInterface.a("function f(a,b,c){if(window._fs_app_transport_native){window._fs_app_transport_native.send(a,b,c)}else{console.log('missing _fs_app_transport_native')}}");
        this.h = this.c.f();
        b("WebViewTracker: snippet: %s", this.g);
        this.j = this.c.g();
    }

    private dM a(WebViewClient webViewClient) {
        b("WebViewTracker: createInitialWebViewClientDelegate", new Object[0]);
        dM dMVar = new dM(this);
        dMVar.b(webViewClient);
        dMVar.a(webViewClient);
        return dMVar;
    }

    private static void a(int i, String str, Object... objArr) {
    }

    private static void a(WebView webView, dM dMVar) {
        webView.getWebViewProvider().setWebViewClient(dMVar);
    }

    private void a(WebView webView, dP dPVar) {
        a(webView, "evaluateSnippet time=%s", dPVar);
        c(webView);
        a(webView, "snippet", this.g);
    }

    private void a(WebView webView, String str, String str2) {
        dO dOVar = new dO(this, webView, str2, str);
        if (Build.VERSION.SDK_INT >= 28) {
            new Handler(webView.getWebViewLooper()).post(dOVar);
        } else {
            fb.a(dOVar);
        }
    }

    private static void a(WebView webView, String str, Object... objArr) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, Object... objArr) {
    }

    private void c() {
        synchronized (this.e) {
            while (true) {
                dQ dQVar = (dQ) this.f.poll();
                if (dQVar != null) {
                    a(dQVar.f7923a, "lost", new Object[0]);
                    this.c.b(dQVar.f7923a);
                    this.e.remove(dQVar.f7923a);
                }
            }
        }
    }

    public static void d(WebView webView) {
        a(webView, "disableInjection webView=%s", webView);
        f7428a.add(webView);
    }

    private void f(WebView webView) {
        WebViewClient g = g(webView);
        if (g instanceof dM) {
            return;
        }
        a(webView, a(g));
    }

    private static WebViewClient g(WebView webView) {
        return Build.VERSION.SDK_INT < 26 ? dR.b(webView) : webView.getWebViewClient();
    }

    private boolean h(WebView webView) {
        if (Build.VERSION.SDK_INT < 26) {
            return dR.a(webView);
        }
        return true;
    }

    private boolean i(WebView webView) {
        return this.d && !f7428a.contains(webView);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void k(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = 106 - r6
            byte[] r0 = com.fullstory.instrumentation.webview.WebViewTracker.getAuthRequestContext
            int r7 = r7 * 3
            int r7 = 16 - r7
            int r8 = r8 * 3
            int r8 = 45 - r8
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            int r8 = r8 + 1
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r3 = r0[r8]
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fullstory.instrumentation.webview.WebViewTracker.k(int, short, short, java.lang.Object[]):void");
    }

    public int a(WebView webView) {
        synchronized (this.e) {
            SparseArray sparseArray = this.e;
            try {
                Object[] objArr = {webView};
                byte b2 = (byte) (getAuthRequestContext[17] - 1);
                Object[] objArr2 = new Object[1];
                k(b2, b2, getAuthRequestContext[5], objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = getAuthRequestContext[17];
                byte b4 = (byte) (b3 - 1);
                Object[] objArr3 = new Object[1];
                k(b3, b4, (byte) (b4 | 10), objArr3);
                dQ dQVar = (dQ) sparseArray.get(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue());
                if (dQVar != null) {
                    return dQVar.b;
                }
                return 0;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
    }

    public WebResourceResponse a(WebView webView, String str) {
        if (b == null || !str.endsWith("fs.js")) {
            return null;
        }
        a(webView, "*** fs.js redirected from %s to %s", str, b);
        try {
            return new WebResourceResponse("application/js", "", new URL(b).openConnection().getInputStream());
        } catch (IOException e) {
            Log.e("Failed to redirect fs.js", e);
            return null;
        }
    }

    public void a() {
        a(-1L, "shutdown", this.h);
    }

    public void a(int i, int i2, int i3, String str) {
        if (i3 == this.j) {
            a(i, "WebView API: command=%s", str);
            this.c.b(str);
            return;
        }
        synchronized (this.e) {
            a(i, "WebView message: epoch=%d type=%d msg=%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            dQ dQVar = (dQ) this.e.get(i);
            if (dQVar != null) {
                dQVar.b = i2;
            }
            this.c.a(i, i2, (byte) i3, str);
        }
    }

    public void a(WebView webView, int i, String str, String str2) {
        a(webView, "onReceivedError: %d %s %s", Integer.valueOf(i), str2, str);
        if (str2 == null || !str2.endsWith("/s/fs.js")) {
            return;
        }
        Log.e(String.format("FullStory web script failed to load: %d %s %s", Integer.valueOf(i), str2, str));
    }

    public void a(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (webResourceRequest != null && webResourceError != null) {
            a(webView, "onReceivedError: %d %s %s", Integer.valueOf(webResourceError.getErrorCode()), webResourceRequest.getUrl(), webResourceError.getDescription());
        }
        if (webResourceRequest == null || webResourceRequest.getUrl() == null || !webResourceRequest.getUrl().toString().endsWith("/s/fs.js")) {
            return;
        }
        Log.e(String.format("FullStory web script failed to load: %d %s %s", Integer.valueOf(webResourceError.getErrorCode()), webResourceRequest.getUrl(), webResourceError.getDescription()));
    }

    public void a(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        if (webResourceRequest != null && webResourceResponse != null) {
            a(webView, "onReceivedHttpError: %d %s %s", Integer.valueOf(webResourceResponse.getStatusCode()), webResourceRequest.getUrl(), webResourceResponse.getReasonPhrase());
        }
        if (webResourceRequest == null || webResourceRequest.getUrl() == null || !webResourceRequest.getUrl().toString().endsWith("/s/fs.js")) {
            return;
        }
        Log.e(String.format("FullStory web script failed to load: %d %s %s", Integer.valueOf(webResourceResponse.getStatusCode()), webResourceRequest.getUrl(), webResourceResponse.getReasonPhrase()));
    }

    public void a(WebView webView, WebViewClient webViewClient) {
        a(webView, "setWebViewClient client=%s", webViewClient);
        if (!i(webView)) {
            a(webView, "setWebViewClient returning early, disabled webview is %s", webView);
            webView.setWebViewClient(webViewClient);
        } else if (!h(webView)) {
            a(webView, "setWebViewClient uhoh: !canAccessWebViewClient", new Object[0]);
            webView.setWebViewClient(webViewClient);
        } else {
            WebViewClient g = g(webView);
            dM a2 = !(g instanceof dM) ? a(g) : (dM) g;
            webView.setWebViewClient(webViewClient);
            if (webViewClient == null) {
                a2.a(e(webView));
            }
            a2.b(webViewClient);
            a(webView, a2);
        }
    }

    public boolean a(long j, String str, String str2) {
        WebView webView;
        WebView webView2;
        b("WebViewTracker: Evaluating Javascript=%s id=%d js=%s", str, Long.valueOf(j), str2);
        c();
        synchronized (this.e) {
            try {
                if (j == -1) {
                    for (int i = 0; i < this.e.size(); i++) {
                        dQ dQVar = (dQ) this.e.valueAt(i);
                        if (dQVar != null && (webView2 = (WebView) dQVar.get()) != null) {
                            a(webView2, str, str2);
                        }
                    }
                } else {
                    int i2 = (int) j;
                    dQ dQVar2 = (dQ) this.e.get(i2);
                    if (dQVar2 == null || (webView = (WebView) dQVar2.get()) == null) {
                        b("WebViewTracker: Lost web view with id=%d", Long.valueOf(j));
                        this.c.b(i2);
                        return false;
                    }
                    a(webView, str, str2);
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        synchronized (this.e) {
            c();
        }
    }

    public void b(WebView webView, String str) {
        a(webView, "onPageHistoryUpdate: %s", str);
        a(webView, dP.ON_PAGE_HISTORY_UPDATE);
    }

    public boolean b(WebView webView) {
        return a(webView) != 0;
    }

    public void c(WebView webView) {
        try {
            byte b2 = (byte) (getAuthRequestContext[17] - 1);
            byte b3 = b2;
            Object[] objArr = new Object[1];
            k(b2, b3, b3, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            k(getAuthRequestContext[16], getAuthRequestContext[17], (byte) (PlaceComponentResult & 14), objArr2);
            if (cls.getMethod((String) objArr2[0], null).invoke(null, null) != Looper.getMainLooper().getThread()) {
                Object[] objArr3 = new Object[2];
                objArr3[0] = Looper.getMainLooper().getThread().getName();
                try {
                    byte b4 = (byte) (getAuthRequestContext[17] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    k(b4, b5, b5, objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    k(getAuthRequestContext[16], getAuthRequestContext[17], (byte) (PlaceComponentResult & 14), objArr5);
                    objArr3[1] = ((Thread) cls2.getMethod((String) objArr5[0], null).invoke(null, null)).getName();
                    Log.w(String.format("Track called for WebView on incorrect thread (should be %s be but was %s). Skipping.", objArr3));
                    return;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            try {
                byte b6 = (byte) (getAuthRequestContext[17] - 1);
                Object[] objArr6 = new Object[1];
                k(b6, b6, getAuthRequestContext[5], objArr6);
                Class<?> cls3 = Class.forName((String) objArr6[0]);
                byte b7 = getAuthRequestContext[17];
                byte b8 = (byte) (b7 - 1);
                Object[] objArr7 = new Object[1];
                k(b7, b8, (byte) (b8 | 10), objArr7);
                int intValue = ((Integer) cls3.getMethod((String) objArr7[0], Object.class).invoke(null, webView)).intValue();
                if (!i(webView)) {
                    a(webView, "track returning early, disabled webview is %s", webView);
                    this.c.a(intValue, 0, (short) 1);
                    return;
                }
                synchronized (this.e) {
                    c();
                    if (this.e.indexOfKey(intValue) < 0) {
                        a(webView, "track: now tracking", new Object[0]);
                        this.e.put(intValue, new dQ(intValue, webView, this.f));
                        if (h(webView)) {
                            dN dNVar = new dN(this, intValue);
                            f(webView);
                            webView.addJavascriptInterface(dNVar, "_fs_app_transport_native");
                        } else {
                            Log.w("WebViewTracker: Couldn't access the webview's client");
                        }
                        WebSettings settings = webView.getSettings();
                        if (settings != null) {
                            boolean javaScriptEnabled = settings.getJavaScriptEnabled();
                            a(webView, "JavaScript enabled=%s", Boolean.valueOf(javaScriptEnabled));
                            if (!javaScriptEnabled) {
                                if (!this.i) {
                                    this.i = true;
                                    Log.logAlways("FullStory unable to instrument WebViews with setJavaScriptEnabled(false)");
                                }
                                this.c.a(intValue, 0, (short) 2);
                            }
                        } else {
                            a(webView, "Unable to retrieve WebView settings", new Object[0]);
                        }
                        this.c.a(intValue);
                    } else {
                        a(webView, "track: already tracking", new Object[0]);
                    }
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        } catch (Throwable th3) {
            Throwable cause3 = th3.getCause();
            if (cause3 == null) {
                throw th3;
            }
            throw cause3;
        }
    }

    public void c(WebView webView, String str) {
        a(webView, "onPageCommitVisible: %s", str);
        a(webView, dP.ON_PAGE_COMMIT_VISIBLE);
    }

    public void d(WebView webView, String str) {
        a(webView, "onPageFinished: %s", str);
        a(webView, dP.ON_PAGE_FINISHED);
    }

    public WebViewClient e(WebView webView) {
        WebViewClient g = g(webView);
        return g instanceof dM ? ((dM) g).a() : g;
    }

    public void e(WebView webView, String str) {
        a(webView, "onPageStarted: ", str);
        a(webView, dP.ON_PAGE_STARTED);
    }
}
