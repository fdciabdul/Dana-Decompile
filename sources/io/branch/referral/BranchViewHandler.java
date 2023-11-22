package io.branch.referral;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.data.here.HereOauthManager;
import io.branch.referral.Defines;
import java.net.URI;
import java.net.URISyntaxException;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BranchViewHandler {
    private static BranchViewHandler PlaceComponentResult;
    String BuiltInFictitiousFunctionClassFactory;
    private Dialog KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    boolean getAuthRequestContext;
    private BranchView getErrorConfigVersion = null;
    private boolean lookAheadTest = false;

    /* loaded from: classes.dex */
    public interface IBranchViewEvents {
        void BuiltInFictitiousFunctionClassFactory(String str);

        void PlaceComponentResult(String str);

        void getAuthRequestContext(String str);
    }

    static /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(BranchViewHandler branchViewHandler) {
        branchViewHandler.lookAheadTest = false;
        return false;
    }

    static /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(BranchViewHandler branchViewHandler) {
        branchViewHandler.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        return true;
    }

    static /* synthetic */ Dialog PlaceComponentResult(BranchViewHandler branchViewHandler) {
        branchViewHandler.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        return null;
    }

    static /* synthetic */ boolean moveToNextValue(BranchViewHandler branchViewHandler) {
        branchViewHandler.getAuthRequestContext = false;
        return false;
    }

    private BranchViewHandler() {
    }

    public static BranchViewHandler getAuthRequestContext() {
        if (PlaceComponentResult == null) {
            PlaceComponentResult = new BranchViewHandler();
        }
        return PlaceComponentResult;
    }

    public final boolean getAuthRequestContext(Context context) {
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion, context, null);
        if (KClassImpl$Data$declaredNonStaticMembers$2) {
            this.getErrorConfigVersion = null;
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final boolean PlaceComponentResult(JSONObject jSONObject, String str, Context context, IBranchViewEvents iBranchViewEvents) {
        return KClassImpl$Data$declaredNonStaticMembers$2(new BranchView(this, jSONObject, str, (byte) 0), context, iBranchViewEvents);
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(BranchView branchView, Context context, IBranchViewEvents iBranchViewEvents) {
        if (this.getAuthRequestContext || this.lookAheadTest) {
            if (iBranchViewEvents != null) {
                iBranchViewEvents.getAuthRequestContext(branchView.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return false;
        }
        this.getAuthRequestContext = false;
        this.MyBillsEntityDataFactory = false;
        if (context != null && branchView != null) {
            if (branchView.getAuthRequestContext(context)) {
                if (!TextUtils.isEmpty(branchView.getAuthRequestContext)) {
                    BuiltInFictitiousFunctionClassFactory(branchView, context, iBranchViewEvents);
                } else {
                    this.lookAheadTest = true;
                    new loadBranchViewTask(branchView, context, iBranchViewEvents).execute(new Void[0]);
                }
                return true;
            } else if (iBranchViewEvents != null) {
                iBranchViewEvents.getAuthRequestContext(branchView.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BuiltInFictitiousFunctionClassFactory(final BranchView branchView, Context context, final IBranchViewEvents iBranchViewEvents) {
        if (context == null || branchView == null) {
            return;
        }
        final WebView webView = new WebView(context);
        webView.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 19) {
            webView.setLayerType(2, null);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        if (TextUtils.isEmpty(branchView.getAuthRequestContext)) {
            return;
        }
        String str = branchView.getAuthRequestContext;
        InstrumentInjector.trackWebView(webView);
        webView.loadDataWithBaseURL(null, str, "text/html", HereOauthManager.ENC, null);
        InstrumentInjector.setWebViewClient(webView, new WebViewClient() { // from class: io.branch.referral.BranchViewHandler.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str2) {
                boolean KClassImpl$Data$declaredNonStaticMembers$2 = BranchViewHandler.this.KClassImpl$Data$declaredNonStaticMembers$2(str2);
                if (KClassImpl$Data$declaredNonStaticMembers$2) {
                    if (BranchViewHandler.this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                        BranchViewHandler.this.KClassImpl$Data$declaredNonStaticMembers$2.dismiss();
                    }
                } else {
                    InstrumentInjector.trackWebView(webView2);
                    webView2.loadUrl(str2);
                }
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView2, String str2, Bitmap bitmap) {
                super.onPageStarted(webView2, str2, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, int i, String str2, String str3) {
                super.onReceivedError(webView2, i, str2, str3);
                BranchViewHandler.KClassImpl$Data$declaredNonStaticMembers$2(BranchViewHandler.this);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str2) {
                super.onPageFinished(webView2, str2);
                BranchViewHandler.PlaceComponentResult(BranchViewHandler.this, branchView, iBranchViewEvents, webView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0031 -> B:13:0x0032). Please submit an issue!!! */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        try {
            URI uri = new URI(str);
            if (uri.getScheme().equalsIgnoreCase("branch-cta")) {
                if (uri.getHost().equalsIgnoreCase("accept")) {
                    this.MyBillsEntityDataFactory = true;
                    return true;
                } else if (uri.getHost().equalsIgnoreCase("cancel")) {
                    this.MyBillsEntityDataFactory = false;
                    return true;
                }
            }
        } catch (URISyntaxException unused) {
        }
        return false;
    }

    private static void getAuthRequestContext(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setStartOffset(10L);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setFillAfter(true);
        view.setVisibility(0);
        view.startAnimation(alphaAnimation);
    }

    public final boolean MyBillsEntityDataFactory(JSONObject jSONObject, String str) {
        Activity activity;
        byte b = 0;
        BranchView branchView = new BranchView(this, jSONObject, str, b);
        if (Branch.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2 == null || (activity = Branch.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2.get()) == null || !branchView.getAuthRequestContext(activity)) {
            return false;
        }
        this.getErrorConfigVersion = new BranchView(this, jSONObject, str, b);
        return true;
    }

    public final boolean MyBillsEntityDataFactory(Context context) {
        BranchView branchView = this.getErrorConfigVersion;
        return branchView != null && branchView.getAuthRequestContext(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class loadBranchViewTask extends AsyncTask<Void, Void, Boolean> {
        private static int $10 = 0;
        private static int $11 = 1;
        private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
        private static int lookAheadTest = 1;
        private final BranchView KClassImpl$Data$declaredNonStaticMembers$2;
        private final Context PlaceComponentResult;
        private final IBranchViewEvents getAuthRequestContext;
        private static char[] MyBillsEntityDataFactory = {39542, 39545, 39431, 39454, 39445};
        private static boolean getErrorConfigVersion = true;
        private static boolean moveToNextValue = true;
        private static int scheduleImpl = 909155277;

        @Override // android.os.AsyncTask
        protected /* synthetic */ Boolean doInBackground(Void[] voidArr) {
            Boolean KClassImpl$Data$declaredNonStaticMembers$2;
            int i = lookAheadTest + 69;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if (!(i % 2 != 0)) {
                try {
                    Void[] voidArr2 = voidArr;
                    KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
                } catch (Exception e) {
                    throw e;
                }
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
                int i2 = 69 / 0;
            }
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 45;
            lookAheadTest = i3 % 128;
            if (!(i3 % 2 != 0)) {
                Object obj = null;
                obj.hashCode();
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // android.os.AsyncTask
        protected /* synthetic */ void onPostExecute(Boolean bool) {
            try {
                int i = lookAheadTest + 117;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                int i2 = i % 2;
                BuiltInFictitiousFunctionClassFactory(bool);
                int i3 = lookAheadTest + 47;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        }

        public loadBranchViewTask(BranchView branchView, Context context, IBranchViewEvents iBranchViewEvents) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = branchView;
            this.PlaceComponentResult = context;
            this.getAuthRequestContext = iBranchViewEvents;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00a7  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.Boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            /*
                r12 = this;
                r0 = 200(0xc8, float:2.8E-43)
                r1 = -1
                r2 = 2
                r3 = 1
                r4 = 0
                java.net.URL r5 = new java.net.URL     // Catch: java.lang.Exception -> L9a
                io.branch.referral.BranchViewHandler$BranchView r6 = r12.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L9a
                java.lang.String r6 = io.branch.referral.BranchViewHandler.BranchView.getAuthRequestContext(r6)     // Catch: java.lang.Exception -> L9a
                r5.<init>(r6)     // Catch: java.lang.Exception -> L9a
                java.net.URLConnection r5 = r5.openConnection()     // Catch: java.lang.Exception -> L9a
                java.net.URLConnection r5 = com.fullstory.instrumentation.InstrumentInjector.urlconnection_wrapInstance(r5)     // Catch: java.lang.Exception -> L9a
                java.lang.Object r5 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r5)     // Catch: java.lang.Exception -> L9a
                java.net.URLConnection r5 = (java.net.URLConnection) r5     // Catch: java.lang.Exception -> L9a
                java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch: java.lang.Exception -> L9a
                java.lang.String r6 = "GET"
                r5.setRequestMethod(r6)     // Catch: java.lang.Exception -> L9a
                r5.connect()     // Catch: java.lang.Exception -> L9a
                int r6 = r5.getResponseCode()     // Catch: java.lang.Exception -> L9a
                if (r6 != r0) goto La4
                java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Exception -> L99
                r7.<init>()     // Catch: java.lang.Exception -> L99
                java.io.InputStream r5 = r5.getInputStream()     // Catch: java.lang.Exception -> L99
                r8 = 1024(0x400, float:1.435E-42)
                byte[] r8 = new byte[r8]     // Catch: java.lang.Exception -> L99
            L3c:
                int r9 = r5.read(r8)     // Catch: java.lang.Exception -> L99
                if (r9 == r1) goto L44
                r10 = 1
                goto L45
            L44:
                r10 = 0
            L45:
                if (r10 == r3) goto L86
                io.branch.referral.BranchViewHandler$BranchView r1 = r12.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L99
                java.lang.String r8 = ""
                int r8 = android.text.TextUtils.getOffsetAfter(r8, r4)     // Catch: java.lang.Exception -> L99
                int r8 = r8 + 127
                r9 = 5
                byte[] r9 = new byte[r9]     // Catch: java.lang.Exception -> L99
                r10 = -123(0xffffffffffffff85, float:NaN)
                r9[r4] = r10     // Catch: java.lang.Exception -> L99
                r10 = -124(0xffffffffffffff84, float:NaN)
                r9[r3] = r10     // Catch: java.lang.Exception -> L99
                r10 = -125(0xffffffffffffff83, float:NaN)
                r9[r2] = r10     // Catch: java.lang.Exception -> L99
                r10 = 3
                r11 = -126(0xffffffffffffff82, float:NaN)
                r9[r10] = r11     // Catch: java.lang.Exception -> L99
                r10 = 4
                r11 = -127(0xffffffffffffff81, float:NaN)
                r9[r10] = r11     // Catch: java.lang.Exception -> L99
                java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L99
                r11 = 0
                a(r8, r9, r11, r11, r10)     // Catch: java.lang.Exception -> L99
                r8 = r10[r4]     // Catch: java.lang.Exception -> L99
                java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Exception -> L99
                java.lang.String r8 = r8.intern()     // Catch: java.lang.Exception -> L99
                java.lang.String r8 = r7.toString(r8)     // Catch: java.lang.Exception -> L99
                io.branch.referral.BranchViewHandler.BranchView.KClassImpl$Data$declaredNonStaticMembers$2(r1, r8)     // Catch: java.lang.Exception -> L99
                r7.close()     // Catch: java.lang.Exception -> L99
                r5.close()     // Catch: java.lang.Exception -> L99
                goto La4
            L86:
                int r10 = io.branch.referral.BranchViewHandler.loadBranchViewTask.NetworkUserEntityData$$ExternalSyntheticLambda0
                int r10 = r10 + 59
                int r11 = r10 % 128
                io.branch.referral.BranchViewHandler.loadBranchViewTask.lookAheadTest = r11
                int r10 = r10 % r2
                if (r10 != 0) goto L95
                r7.write(r8, r3, r9)     // Catch: java.lang.Exception -> L99
                goto L3c
            L95:
                r7.write(r8, r4, r9)     // Catch: java.lang.Exception -> L99
                goto L3c
            L99:
                r1 = r6
            L9a:
                int r5 = io.branch.referral.BranchViewHandler.loadBranchViewTask.NetworkUserEntityData$$ExternalSyntheticLambda0
                int r5 = r5 + 83
                int r6 = r5 % 128
                io.branch.referral.BranchViewHandler.loadBranchViewTask.lookAheadTest = r6
                int r5 = r5 % r2
                r6 = r1
            La4:
                if (r6 != r0) goto La7
                goto La8
            La7:
                r3 = 0
            La8:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.BranchViewHandler.loadBranchViewTask.KClassImpl$Data$declaredNonStaticMembers$2():java.lang.Boolean");
        }

        private void BuiltInFictitiousFunctionClassFactory(Boolean bool) {
            super.onPostExecute(bool);
            if (!(!bool.booleanValue())) {
                BranchViewHandler.this.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, this.getAuthRequestContext);
                int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 65;
                lookAheadTest = i % 128;
                int i2 = i % 2;
            } else {
                IBranchViewEvents iBranchViewEvents = this.getAuthRequestContext;
                if ((iBranchViewEvents != null ? '!' : 'K') != 'K') {
                    try {
                        int i3 = lookAheadTest + 115;
                        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                        int i4 = i3 % 2;
                        iBranchViewEvents.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2);
                        int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 89;
                        lookAheadTest = i5 % 128;
                        int i6 = i5 % 2;
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
            BranchViewHandler.BuiltInFictitiousFunctionClassFactory(BranchViewHandler.this);
        }

        private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
            int i2;
            BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
            try {
                char[] cArr2 = MyBillsEntityDataFactory;
                if (cArr2 != null) {
                    int length = cArr2.length;
                    char[] cArr3 = new char[length];
                    for (int i3 = 0; i3 < length; i3++) {
                        int i4 = $10 + 73;
                        $11 = i4 % 128;
                        int i5 = i4 % 2;
                        cArr3[i3] = (char) (cArr2[i3] ^ 4571606982258105150L);
                    }
                    cArr2 = cArr3;
                }
                int i6 = (int) (4571606982258105150L ^ scheduleImpl);
                if ((moveToNextValue ? 'M' : 'V') == 'M') {
                    int i7 = $10 + 59;
                    $11 = i7 % 128;
                    int i8 = i7 % 2;
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                    char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                    while (true) {
                        if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? (char) 19 : '\r') != 19) {
                            objArr[0] = new String(cArr4);
                            return;
                        }
                        int i9 = $11 + 27;
                        $10 = i9 % 128;
                        if (!(i9 % 2 != 0)) {
                            cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i6);
                            i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                        } else {
                            cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 0) / bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] >>> i] % i6);
                            i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >> 1;
                        }
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i2;
                    }
                } else if (getErrorConfigVersion) {
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                    char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                    while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                        cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i6);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    }
                    objArr[0] = new String(cArr5);
                } else {
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                    char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                    while (true) {
                        if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? (char) 29 : '\t') != 29) {
                            objArr[0] = new String(cArr6);
                            return;
                        }
                        int i10 = $11 + 19;
                        $10 = i10 % 128;
                        int i11 = i10 % 2;
                        cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i6);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class BranchView {
        private String BuiltInFictitiousFunctionClassFactory;
        private String KClassImpl$Data$declaredNonStaticMembers$2;
        private int PlaceComponentResult;
        private String getAuthRequestContext;
        private String getErrorConfigVersion;

        /* synthetic */ BranchView(BranchViewHandler branchViewHandler, JSONObject jSONObject, String str, byte b) {
            this(jSONObject, str);
        }

        private BranchView(JSONObject jSONObject, String str) {
            this.BuiltInFictitiousFunctionClassFactory = "";
            this.PlaceComponentResult = 1;
            this.getErrorConfigVersion = "";
            this.getAuthRequestContext = "";
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
                if (jSONObject.has(Defines.Jsonkey.BranchViewID.getKey())) {
                    this.BuiltInFictitiousFunctionClassFactory = jSONObject.getString(Defines.Jsonkey.BranchViewID.getKey());
                }
                if (jSONObject.has(Defines.Jsonkey.BranchViewNumOfUse.getKey())) {
                    this.PlaceComponentResult = jSONObject.getInt(Defines.Jsonkey.BranchViewNumOfUse.getKey());
                }
                if (jSONObject.has(Defines.Jsonkey.BranchViewUrl.getKey())) {
                    this.getErrorConfigVersion = jSONObject.getString(Defines.Jsonkey.BranchViewUrl.getKey());
                }
                if (jSONObject.has(Defines.Jsonkey.BranchViewHtml.getKey())) {
                    this.getAuthRequestContext = jSONObject.getString(Defines.Jsonkey.BranchViewHtml.getKey());
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean getAuthRequestContext(Context context) {
            PrefHelper.BuiltInFictitiousFunctionClassFactory(context);
            int BuiltInFictitiousFunctionClassFactory = PrefHelper.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
            int i = this.PlaceComponentResult;
            return i > BuiltInFictitiousFunctionClassFactory || i == -1;
        }

        public static void BuiltInFictitiousFunctionClassFactory(Context context, String str) {
            PrefHelper.BuiltInFictitiousFunctionClassFactory(context);
            StringBuilder sb = new StringBuilder();
            sb.append("bnc_branch_view_use_");
            sb.append(str);
            PrefHelper.PlaceComponentResult(sb.toString(), PrefHelper.BuiltInFictitiousFunctionClassFactory(str) + 1);
        }
    }

    static /* synthetic */ void PlaceComponentResult(BranchViewHandler branchViewHandler, final BranchView branchView, final IBranchViewEvents iBranchViewEvents, WebView webView) {
        if (!branchViewHandler.NetworkUserEntityData$$ExternalSyntheticLambda0 && Branch.BuiltInFictitiousFunctionClassFactory() != null && Branch.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            Activity activity = Branch.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2.get();
            if (activity != null) {
                BranchView.BuiltInFictitiousFunctionClassFactory(activity.getApplicationContext(), branchView.BuiltInFictitiousFunctionClassFactory);
                branchViewHandler.BuiltInFictitiousFunctionClassFactory = activity.getClass().getName();
                RelativeLayout relativeLayout = new RelativeLayout(activity);
                relativeLayout.setVisibility(8);
                relativeLayout.addView(webView, new RelativeLayout.LayoutParams(-1, -1));
                relativeLayout.setBackgroundColor(0);
                Dialog dialog = branchViewHandler.KClassImpl$Data$declaredNonStaticMembers$2;
                if (dialog != null && dialog.isShowing()) {
                    if (iBranchViewEvents != null) {
                        iBranchViewEvents.getAuthRequestContext(branchView.KClassImpl$Data$declaredNonStaticMembers$2);
                        return;
                    }
                    return;
                }
                Dialog dialog2 = new Dialog(activity, 16973834);
                branchViewHandler.KClassImpl$Data$declaredNonStaticMembers$2 = dialog2;
                dialog2.setContentView(relativeLayout);
                relativeLayout.setVisibility(0);
                webView.setVisibility(0);
                branchViewHandler.KClassImpl$Data$declaredNonStaticMembers$2.show();
                getAuthRequestContext(relativeLayout);
                getAuthRequestContext(webView);
                branchViewHandler.getAuthRequestContext = true;
                if (iBranchViewEvents != null) {
                    String unused = branchView.KClassImpl$Data$declaredNonStaticMembers$2;
                    String unused2 = branchView.BuiltInFictitiousFunctionClassFactory;
                }
                branchViewHandler.KClassImpl$Data$declaredNonStaticMembers$2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: io.branch.referral.BranchViewHandler.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        BranchViewHandler.moveToNextValue(BranchViewHandler.this);
                        BranchViewHandler.PlaceComponentResult(BranchViewHandler.this);
                        if (iBranchViewEvents != null) {
                            if (BranchViewHandler.this.MyBillsEntityDataFactory) {
                                IBranchViewEvents iBranchViewEvents2 = iBranchViewEvents;
                                String str = branchView.KClassImpl$Data$declaredNonStaticMembers$2;
                                String unused3 = branchView.BuiltInFictitiousFunctionClassFactory;
                                iBranchViewEvents2.BuiltInFictitiousFunctionClassFactory(str);
                                return;
                            }
                            IBranchViewEvents iBranchViewEvents3 = iBranchViewEvents;
                            String str2 = branchView.KClassImpl$Data$declaredNonStaticMembers$2;
                            String unused4 = branchView.BuiltInFictitiousFunctionClassFactory;
                            iBranchViewEvents3.PlaceComponentResult(str2);
                        }
                    }
                });
                return;
            }
            return;
        }
        branchViewHandler.getAuthRequestContext = false;
        if (iBranchViewEvents != null) {
            iBranchViewEvents.getAuthRequestContext(branchView.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }
}
