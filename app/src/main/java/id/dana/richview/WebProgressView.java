package id.dana.richview;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;
import butterknife.BindView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRichView;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes3.dex */
public class WebProgressView extends BaseRichView {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int[] PlaceComponentResult = {-1198901079, -699499223, -1170461239, 1203370926, -1152891336, 359681085, 1448699989, -1946654207, 830042240, -1406374, 3181377, 1025724779, 830506353, -1006086842, 1855371870, 1317998008, 277116051, -830133604};
    private static int getErrorConfigVersion = 1;
    private static int lookAheadTest;
    private final String BuiltInFictitiousFunctionClassFactory;
    private WebProgressViewListener KClassImpl$Data$declaredNonStaticMembers$2;
    private final String MyBillsEntityDataFactory;
    private SavedUrl getAuthRequestContext;
    @BindView(R.id.pb_webview)
    ProgressBar pbWebView;
    @BindView(R.id.webview)
    WebView webView;

    /* loaded from: classes5.dex */
    public interface WebProgressViewListener {
        void PlaceComponentResult(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError);

        void PlaceComponentResult(WebView webView, String str);
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        int i = lookAheadTest + 97;
        getErrorConfigVersion = i % 128;
        if (i % 2 != 0) {
            return R.layout.view_web_progress;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return R.layout.view_web_progress;
    }

    static /* synthetic */ WebProgressViewListener access$000(WebProgressView webProgressView) {
        int i = getErrorConfigVersion + 83;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        WebProgressViewListener webProgressViewListener = webProgressView.KClassImpl$Data$declaredNonStaticMembers$2;
        int i3 = getErrorConfigVersion + 39;
        lookAheadTest = i3 % 128;
        if (i3 % 2 != 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return webProgressViewListener;
        }
        return webProgressViewListener;
    }

    public WebProgressView(Context context) {
        super(context);
        this.MyBillsEntityDataFactory = "text/html";
        Object[] objArr = new Object[1];
        a(View.MeasureSpec.makeMeasureSpec(0, 0) + 5, new int[]{-1110476439, 2095393180, 18606913, -779646541}, objArr);
        this.BuiltInFictitiousFunctionClassFactory = ((String) objArr[0]).intern();
    }

    public WebProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MyBillsEntityDataFactory = "text/html";
        Object[] objArr = new Object[1];
        a(5 - TextUtils.indexOf("", "", 0, 0), new int[]{-1110476439, 2095393180, 18606913, -779646541}, objArr);
        this.BuiltInFictitiousFunctionClassFactory = ((String) objArr[0]).intern();
    }

    public WebProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MyBillsEntityDataFactory = "text/html";
        Object[] objArr = new Object[1];
        a(5 - ExpandableListView.getPackedPositionGroup(0L), new int[]{-1110476439, 2095393180, 18606913, -779646541}, objArr);
        this.BuiltInFictitiousFunctionClassFactory = ((String) objArr[0]).intern();
    }

    public WebProgressView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.MyBillsEntityDataFactory = "text/html";
        Object[] objArr = new Object[1];
        a((ViewConfiguration.getEdgeSlop() >> 16) + 5, new int[]{-1110476439, 2095393180, 18606913, -779646541}, objArr);
        this.BuiltInFictitiousFunctionClassFactory = ((String) objArr[0]).intern();
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        InstrumentInjector.setWebViewClient(this.webView, new WebViewClient() { // from class: id.dana.richview.WebProgressView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (WebProgressView.access$000(WebProgressView.this) != null) {
                    WebProgressView.access$000(WebProgressView.this).PlaceComponentResult(webView, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (WebProgressView.access$000(WebProgressView.this) != null) {
                    WebProgressView.access$000(WebProgressView.this).PlaceComponentResult(webView, webResourceRequest, webResourceError);
                }
            }
        });
        this.webView.setWebChromeClient(new WebChromeClient() { // from class: id.dana.richview.WebProgressView.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (WebProgressView.this.pbWebView == null) {
                    return;
                }
                WebProgressView.this.pbWebView.setProgress(i);
                if (i == 0) {
                    WebProgressView.this.pbWebView.setVisibility(0);
                }
                if (100 == i) {
                    WebProgressView.this.pbWebView.setVisibility(8);
                }
            }
        });
        int[] BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
        this.webView.setInitialScale(BuiltInFictitiousFunctionClassFactory[0]);
        WebSettings settings = this.webView.getSettings();
        settings.setDefaultFontSize(BuiltInFictitiousFunctionClassFactory[1]);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        this.webView.setInitialScale(1);
        Integer.valueOf(settings.getDefaultFontSize());
        try {
            int i = getErrorConfigVersion + 91;
            lookAheadTest = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setWebProgressViewListener(WebProgressViewListener webProgressViewListener) {
        int i = getErrorConfigVersion + 119;
        lookAheadTest = i % 128;
        boolean z = i % 2 == 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = webProgressViewListener;
        if (!z) {
            Object obj = null;
            obj.hashCode();
        }
    }

    private int[] BuiltInFictitiousFunctionClassFactory() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        KClassImpl$Data$declaredNonStaticMembers$2(getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        int[] iArr = {400, 72};
        if (!(i2 >= 720)) {
            int i3 = lookAheadTest + 71;
            getErrorConfigVersion = i3 % 128;
            if (i3 % 2 == 0) {
                iArr[1] = 27484;
                iArr[1] = 58;
            } else {
                iArr[0] = 200;
                iArr[1] = 36;
            }
        } else {
            if ((i2 > 720 ? ']' : 'N') != 'N') {
                if ((i2 < 1080 ? '\\' : '!') != '!') {
                    iArr[0] = 300;
                    iArr[1] = 36;
                }
            }
            if (i2 >= 1080) {
                int i4 = lookAheadTest + 13;
                getErrorConfigVersion = i4 % 128;
                int i5 = i4 % 2;
                iArr[0] = 400;
                iArr[1] = 72;
                int i6 = getErrorConfigVersion + 91;
                lookAheadTest = i6 % 128;
                int i7 = i6 % 2;
            }
        }
        return iArr;
    }

    private static Activity KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        while (true) {
            try {
                if (context instanceof Activity) {
                    break;
                }
                int i = getErrorConfigVersion + 85;
                lookAheadTest = i % 128;
                int i2 = i % 2;
                if ((context instanceof ContextWrapper ? 'V' : (char) 29) == 29) {
                    break;
                }
                int i3 = lookAheadTest + 45;
                getErrorConfigVersion = i3 % 128;
                int i4 = i3 % 2;
                context = ((ContextWrapper) context).getBaseContext();
            } catch (Exception e) {
                throw e;
            }
        }
        return (Activity) context;
    }

    public WebView getWebView() {
        int i = lookAheadTest + 85;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        try {
            WebView webView = this.webView;
            int i3 = lookAheadTest + 37;
            getErrorConfigVersion = i3 % 128;
            if (!(i3 % 2 != 0)) {
                Object obj = null;
                obj.hashCode();
                return webView;
            }
            return webView;
        } catch (Exception e) {
            throw e;
        }
    }

    public void loadUrl(String str) {
        WebView webView = this.webView;
        InstrumentInjector.trackWebView(webView);
        webView.loadUrl(str);
        this.getAuthRequestContext = new SavedUrl(str);
        int i = lookAheadTest + 53;
        getErrorConfigVersion = i % 128;
        if (i % 2 == 0) {
            int i2 = 93 / 0;
        }
    }

    public void loadDataWithBaseUrl(String str, String str2) {
        int i = lookAheadTest + 69;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        if ((TextUtils.isEmpty(str) ? '\t' : '3') != '3') {
            str2 = getContext().getString(R.string.html_wrapper, str2.replace("\n", "<br>"));
            int i3 = lookAheadTest + 39;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
        }
        WebView webView = this.webView;
        InstrumentInjector.trackWebView(webView);
        Object[] objArr = new Object[1];
        a(5 - TextUtils.indexOf("", ""), new int[]{-1110476439, 2095393180, 18606913, -779646541}, objArr);
        webView.loadDataWithBaseURL(str, str2, "text/html", ((String) objArr[0]).intern(), null);
        this.getAuthRequestContext = new SavedUrl(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        if ((r0 != null ? 7 : '!') != '!') goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        if (android.text.TextUtils.isEmpty(r0.BuiltInFictitiousFunctionClassFactory) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
    
        r0 = id.dana.richview.WebProgressView.lookAheadTest + 109;
        id.dana.richview.WebProgressView.getErrorConfigVersion = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
    
        if ((r0 % 2) != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
    
        r0 = 'K';
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
    
        r0 = 'Q';
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
    
        if (r0 == 'K') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        loadUrl(r4.getAuthRequestContext.getAuthRequestContext);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        loadUrl(r4.getAuthRequestContext.getAuthRequestContext);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0059, code lost:
    
        r0 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005e, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005f, code lost:
    
        loadDataWithBaseUrl(r4.getAuthRequestContext.getAuthRequestContext, r4.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006e, code lost:
    
        r0 = id.dana.richview.WebProgressView.getErrorConfigVersion + 33;
        id.dana.richview.WebProgressView.lookAheadTest = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0078, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0079, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if (r0 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void reload() {
        /*
            r4 = this;
            int r0 = id.dana.richview.WebProgressView.lookAheadTest
            r1 = 33
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.richview.WebProgressView.getErrorConfigVersion = r2
            int r0 = r0 % 2
            r2 = 14
            if (r0 != 0) goto L12
            r0 = 14
            goto L14
        L12:
            r0 = 15
        L14:
            r3 = 0
            if (r0 == r2) goto L1c
            id.dana.richview.WebProgressView$SavedUrl r0 = r4.getAuthRequestContext
            if (r0 == 0) goto L7a
            goto L27
        L1c:
            id.dana.richview.WebProgressView$SavedUrl r0 = r4.getAuthRequestContext
            int r2 = r3.length     // Catch: java.lang.Throwable -> L85
            if (r0 == 0) goto L23
            r2 = 7
            goto L25
        L23:
            r2 = 33
        L25:
            if (r2 == r1) goto L7a
        L27:
            java.lang.String r0 = id.dana.richview.WebProgressView.SavedUrl.PlaceComponentResult(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L5f
            int r0 = id.dana.richview.WebProgressView.lookAheadTest
            int r0 = r0 + 109
            int r1 = r0 % 128
            id.dana.richview.WebProgressView.getErrorConfigVersion = r1
            int r0 = r0 % 2
            r1 = 75
            if (r0 != 0) goto L42
            r0 = 75
            goto L44
        L42:
            r0 = 81
        L44:
            if (r0 == r1) goto L50
            id.dana.richview.WebProgressView$SavedUrl r0 = r4.getAuthRequestContext
            java.lang.String r0 = id.dana.richview.WebProgressView.SavedUrl.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            r4.loadUrl(r0)
            return
        L50:
            id.dana.richview.WebProgressView$SavedUrl r0 = r4.getAuthRequestContext     // Catch: java.lang.Exception -> L5d
            java.lang.String r0 = id.dana.richview.WebProgressView.SavedUrl.KClassImpl$Data$declaredNonStaticMembers$2(r0)     // Catch: java.lang.Exception -> L5d
            r4.loadUrl(r0)     // Catch: java.lang.Exception -> L5d
            int r0 = r3.length     // Catch: java.lang.Throwable -> L5b
            return
        L5b:
            r0 = move-exception
            throw r0
        L5d:
            r0 = move-exception
            throw r0
        L5f:
            id.dana.richview.WebProgressView$SavedUrl r0 = r4.getAuthRequestContext
            java.lang.String r0 = id.dana.richview.WebProgressView.SavedUrl.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            id.dana.richview.WebProgressView$SavedUrl r2 = r4.getAuthRequestContext
            java.lang.String r2 = id.dana.richview.WebProgressView.SavedUrl.PlaceComponentResult(r2)
            r4.loadDataWithBaseUrl(r0, r2)
            int r0 = id.dana.richview.WebProgressView.getErrorConfigVersion     // Catch: java.lang.Exception -> L78
            int r0 = r0 + r1
            int r1 = r0 % 128
            id.dana.richview.WebProgressView.lookAheadTest = r1     // Catch: java.lang.Exception -> L78
            int r0 = r0 % 2
            goto L7a
        L78:
            r0 = move-exception
            throw r0
        L7a:
            int r0 = id.dana.richview.WebProgressView.lookAheadTest
            int r0 = r0 + 79
            int r1 = r0 % 128
            id.dana.richview.WebProgressView.getErrorConfigVersion = r1
            int r0 = r0 % 2
            return
        L85:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.WebProgressView.reload():void");
    }

    @Override // android.view.View
    public void setScrollbarFadingEnabled(boolean z) {
        int i = lookAheadTest + 121;
        getErrorConfigVersion = i % 128;
        try {
            if (!(i % 2 == 0)) {
                try {
                    this.webView.setScrollbarFadingEnabled(z);
                } catch (Exception e) {
                    throw e;
                }
            } else {
                this.webView.setScrollbarFadingEnabled(z);
                int i2 = 49 / 0;
            }
            int i3 = lookAheadTest + 35;
            getErrorConfigVersion = i3 % 128;
            if (i3 % 2 != 0) {
                return;
            }
            int i4 = 10 / 0;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void disableBuiltInZoom() {
        int i = getErrorConfigVersion + 3;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        try {
            this.webView.getSettings().setBuiltInZoomControls(true);
            this.webView.getSettings().setDisplayZoomControls(false);
            int i3 = getErrorConfigVersion + 125;
            lookAheadTest = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class SavedUrl {
        private String BuiltInFictitiousFunctionClassFactory;
        private String getAuthRequestContext;

        public SavedUrl(String str) {
            this.getAuthRequestContext = str;
        }

        public SavedUrl(String str, String str2) {
            this.getAuthRequestContext = str;
            this.BuiltInFictitiousFunctionClassFactory = str2;
        }
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = PlaceComponentResult;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr3[i2] = (int) (iArr2[i2] ^ (-3152031022165484798L));
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = PlaceComponentResult;
        if ((iArr5 != null ? (char) 5 : 'Q') != 'Q') {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i3 = 0;
            while (i3 < length3) {
                iArr6[i3] = (int) (iArr5[i3] ^ (-3152031022165484798L));
                i3++;
                int i4 = $10 + 103;
                $11 = i4 % 128;
                int i5 = i4 % 2;
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            try {
                int i6 = $10 + 27;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                int i8 = 0;
                while (true) {
                    if ((i8 < 16 ? ']' : (char) 28) != ']') {
                        break;
                    }
                    int i9 = $10 + 113;
                    $11 = i9 % 128;
                    int i10 = i9 % 2;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i8];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    int i11 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i11;
                    i8++;
                }
                int i12 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i12;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                int i13 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i14 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
                int i15 = $11 + 79;
                $10 = i15 % 128;
                int i16 = i15 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
