package com.alipay.mobile.embedview.mapbiz.core;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.io.PoolingByteArrayOutputStream;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.griver.api.common.network.HttpRequest;
import com.alibaba.griver.base.common.network.GriverTransport;
import com.alibaba.griver.base.common.utils.H5FileUtil;
import com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil;
import com.alibaba.griver.base.common.utils.H5UrlHelper;
import com.alibaba.griver.base.common.utils.TinyUtils;
import com.alibaba.griver.h5.permission.GriverJSAPIPermission;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import com.alipay.mobile.zebra.ZebraLoader;
import com.google.common.net.HttpHeaders;
import id.dana.cashier.view.InputCardNumberView;
import java.io.InputStream;
import java.util.HashMap;
import kotlin.text.Typography;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.getOnBoardingScenario;

/* loaded from: classes6.dex */
public class H5ResourceLoader extends ZebraLoader {
    private static int $10 = 0;
    private static int $11 = 1;
    private static boolean BuiltInFictitiousFunctionClassFactory = false;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static boolean MyBillsEntityDataFactory = false;
    private static int PlaceComponentResult = 0;
    protected static String TAG = "H5ResourceLoader";
    private static int getAuthRequestContext = 0;
    private static int lookAheadTest = 1;

    /* renamed from: a */
    private H5MapContainer f7145a;

    static {
        getAuthRequestContext();
        int i = PlaceComponentResult + 75;
        lookAheadTest = i % 128;
        int i2 = i % 2;
    }

    static void getAuthRequestContext() {
        KClassImpl$Data$declaredNonStaticMembers$2 = new char[]{39529, 39528, 39542, 39441, 39428};
        BuiltInFictitiousFunctionClassFactory = true;
        MyBillsEntityDataFactory = true;
        getAuthRequestContext = 909154876;
    }

    static /* synthetic */ H5MapContainer access$000(H5ResourceLoader h5ResourceLoader) {
        H5MapContainer h5MapContainer;
        int i = PlaceComponentResult + 71;
        lookAheadTest = i % 128;
        if ((i % 2 == 0 ? '-' : '[') != '[') {
            h5MapContainer = h5ResourceLoader.f7145a;
            Object obj = null;
            obj.hashCode();
        } else {
            try {
                h5MapContainer = h5ResourceLoader.f7145a;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = lookAheadTest + 27;
        PlaceComponentResult = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 18 : '3') != '3') {
            int i3 = 64 / 0;
            return h5MapContainer;
        }
        return h5MapContainer;
    }

    static /* synthetic */ void access$100(H5ResourceLoader h5ResourceLoader, String str, ZebraLoader.OnLoadResourceCallback onLoadResourceCallback) {
        try {
            int i = lookAheadTest + 113;
            PlaceComponentResult = i % 128;
            if (!(i % 2 != 0)) {
                h5ResourceLoader.a(str, onLoadResourceCallback);
            } else {
                h5ResourceLoader.a(str, onLoadResourceCallback);
                int i2 = 86 / 0;
            }
            int i3 = PlaceComponentResult + 39;
            lookAheadTest = i3 % 128;
            if ((i3 % 2 == 0 ? Typography.quote : '\'') != '\'') {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ String access$200(H5ResourceLoader h5ResourceLoader, InputStream inputStream, String str) {
        int i = PlaceComponentResult + 75;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        String a2 = h5ResourceLoader.a(inputStream, str);
        int i3 = lookAheadTest + 75;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 != 0 ? '.' : '`') != '.') {
            return a2;
        }
        int i4 = 97 / 0;
        return a2;
    }

    public H5ResourceLoader(H5MapContainer h5MapContainer) {
        this.f7145a = h5MapContainer;
    }

    @Override // com.alipay.mobile.zebra.ZebraLoader
    public void load(String str, String str2, ZebraLoader.OnLoadResourceCallback onLoadResourceCallback) {
        int i = PlaceComponentResult + 125;
        lookAheadTest = i % 128;
        char c = i % 2 == 0 ? (char) 29 : 'U';
        a(str, str2, onLoadResourceCallback);
        if (c != 29) {
            return;
        }
        int i2 = 69 / 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:178:0x00b9, code lost:
    
        if (r12.f7145a.debuggable != false) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x00c8, code lost:
    
        if ((!r12.f7145a.debuggable) != false) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x00ca, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x00ce, code lost:
    
        r4 = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Removed duplicated region for block: B:163:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(final java.lang.String r13, java.lang.String r14, final com.alipay.mobile.zebra.ZebraLoader.OnLoadResourceCallback r15) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader.a(java.lang.String, java.lang.String, com.alipay.mobile.zebra.ZebraLoader$OnLoadResourceCallback):void");
    }

    private void a(String str, ZebraLoader.OnLoadResourceCallback onLoadResourceCallback) {
        String absoluteUrlV2;
        int i = PlaceComponentResult + 113;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        Page h5Page = this.f7145a.getH5Page();
        String string = BundleUtils.getString(h5Page.getStartParams(), "url");
        if ((!TextUtils.isEmpty(string) ? (char) 29 : ',') == 29) {
            try {
                int i3 = PlaceComponentResult + 17;
                lookAheadTest = i3 % 128;
                if ((i3 % 2 == 0 ? '@' : 'N') != '@') {
                    try {
                        absoluteUrlV2 = TinyUtils.getAbsoluteUrlV2(string, str, null);
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    absoluteUrlV2 = TinyUtils.getAbsoluteUrlV2(string, str, null);
                    int i4 = 82 / 0;
                }
                string = absoluteUrlV2;
                int i5 = PlaceComponentResult + 109;
                lookAheadTest = i5 % 128;
                int i6 = i5 % 2;
            } catch (Exception e2) {
                throw e2;
            }
        }
        Resource load = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(h5Page).create()).load(ResourceLoadContext.newBuilder().originUrl(string).build());
        if (load != null) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("shouldInterceptRequest got resource: ");
            sb.append(load);
            RVLogger.d(str2, sb.toString());
            WebResourceResponse webResourceResponse = new WebResourceResponse(load.getMimeType(), load.getEncoding(), load.getStream());
            if (Build.VERSION.SDK_INT >= 21) {
                HashMap hashMap = new HashMap();
                hashMap.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, UrlUtils.getCORSUrl(h5Page.getPageURI()));
                webResourceResponse.setResponseHeaders(hashMap);
                int i7 = lookAheadTest + 31;
                PlaceComponentResult = i7 % 128;
                int i8 = i7 % 2;
            }
            onLoadResourceCallback.onComplete(webResourceResponse);
        }
    }

    private void b(final String str, String str2, final ZebraLoader.OnLoadResourceCallback onLoadResourceCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("loadDataFromWeb: ");
        sb.append(str2);
        sb.append(" -> ");
        sb.append(str);
        RVLogger.d(H5MapContainer.TAG, sb.toString());
        ExecutorUtils.runNotOnMain(ExecutorType.IO, new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader.3
            {
                H5ResourceLoader.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    HttpRequest httpRequest = new HttpRequest();
                    httpRequest.setMethod("GET");
                    httpRequest.setUrl(str);
                    final InputStream inputStream = GriverTransport.request(httpRequest).getInputStream();
                    ExecutorUtils.runOnMain(new Runnable(this) { // from class: com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader.3.1
                        private static int $10 = 0;
                        private static int $11 = 1;
                        private static int BuiltInFictitiousFunctionClassFactory = 1;
                        private static int MyBillsEntityDataFactory = 0;
                        private static long getAuthRequestContext = -8511135167686694146L;
                        final /* synthetic */ AnonymousClass3 this$1;

                        {
                            try {
                                this.this$1 = this;
                            } catch (Exception e) {
                                throw e;
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            int i = MyBillsEntityDataFactory + 49;
                            BuiltInFictitiousFunctionClassFactory = i % 128;
                            int i2 = i % 2;
                            if ((onLoadResourceCallback != null ? 'Z' : '=') == 'Z') {
                                if ((inputStream == null ? (char) 14 : 'D') != 'D') {
                                    int i3 = BuiltInFictitiousFunctionClassFactory + 117;
                                    MyBillsEntityDataFactory = i3 % 128;
                                    int i4 = i3 % 2;
                                    onLoadResourceCallback.onComplete(null);
                                    return;
                                }
                                ZebraLoader.OnLoadResourceCallback onLoadResourceCallback2 = onLoadResourceCallback;
                                String mimeType = H5FileUtil.getMimeType(H5UrlHelper.getPath(str));
                                Object[] objArr = new Object[1];
                                a(1597 - TextUtils.getTrimmedLength(""), new char[]{64488, 64980, 63361, 59687, 58225}, objArr);
                                onLoadResourceCallback2.onComplete(new WebResourceResponse(mimeType, ((String) objArr[0]).intern(), inputStream));
                            }
                            int i5 = MyBillsEntityDataFactory + 93;
                            BuiltInFictitiousFunctionClassFactory = i5 % 128;
                            int i6 = i5 % 2;
                        }

                        private static void a(int i, char[] cArr, Object[] objArr) {
                            int i2;
                            getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
                            try {
                                getonboardingscenario.MyBillsEntityDataFactory = i;
                                int length = cArr.length;
                                long[] jArr = new long[length];
                                getonboardingscenario.getAuthRequestContext = 0;
                                while (true) {
                                    if (!(getonboardingscenario.getAuthRequestContext < cArr.length)) {
                                        break;
                                    }
                                    jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (getAuthRequestContext ^ 4796183387843776835L);
                                    getonboardingscenario.getAuthRequestContext++;
                                }
                                char[] cArr2 = new char[length];
                                getonboardingscenario.getAuthRequestContext = 0;
                                int i3 = $10 + 47;
                                $11 = i3 % 128;
                                while (true) {
                                    int i4 = i3 % 2;
                                    try {
                                        if (getonboardingscenario.getAuthRequestContext >= cArr.length) {
                                            String str3 = new String(cArr2);
                                            int i5 = $10 + 81;
                                            $11 = i5 % 128;
                                            int i6 = i5 % 2;
                                            objArr[0] = str3;
                                            return;
                                        }
                                        int i7 = $11 + 67;
                                        $10 = i7 % 128;
                                        if ((i7 % 2 != 0 ? 'Q' : 'c') != 'Q') {
                                            cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                                            i2 = getonboardingscenario.getAuthRequestContext + 1;
                                        } else {
                                            cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                                            i2 = getonboardingscenario.getAuthRequestContext >>> 1;
                                        }
                                        getonboardingscenario.getAuthRequestContext = i2;
                                        i3 = $11 + 43;
                                        $10 = i3 % 128;
                                    } catch (Exception e) {
                                        throw e;
                                    }
                                }
                            } catch (Exception e2) {
                                throw e2;
                            }
                        }
                    });
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        });
        int i = lookAheadTest + 29;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    private void c(String str, String str2, ZebraLoader.OnLoadResourceCallback onLoadResourceCallback) {
        int i = PlaceComponentResult + 97;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        b(str, str2, onLoadResourceCallback);
        int i3 = PlaceComponentResult + 51;
        lookAheadTest = i3 % 128;
        if ((i3 % 2 == 0 ? InputCardNumberView.DIVIDER : '^') != ' ') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    @Override // com.alipay.mobile.zebra.ZebraLoader
    public void loadImage(String str, final ZebraLoader.OnLoadImageCallback onLoadImageCallback) {
        Object[] objArr = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.f7145a.configController.isMapWebCacheEnabled()) {
                    final Bitmap cacheOfWeb = BitmapCache.INSTANCE.getCacheOfWeb(str);
                    if (!(cacheOfWeb == null)) {
                        if (this.f7145a.debuggable) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("H5ResourceLoader#loadImage: hit cache -> ");
                            sb.append(str);
                            RVLogger.d(H5MapContainer.TAG, sb.toString());
                            int i = PlaceComponentResult + 109;
                            lookAheadTest = i % 128;
                            int i2 = i % 2;
                        }
                        if (onLoadImageCallback != null) {
                            if (!(!TinyUtils.isMain())) {
                                int i3 = PlaceComponentResult + 119;
                                lookAheadTest = i3 % 128;
                                if (i3 % 2 != 0) {
                                    onLoadImageCallback.onComplete(cacheOfWeb);
                                    return;
                                }
                                onLoadImageCallback.onComplete(cacheOfWeb);
                                int length = objArr.length;
                                return;
                            }
                            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader.5
                                {
                                    H5ResourceLoader.this = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    onLoadImageCallback.onComplete(cacheOfWeb);
                                }
                            });
                            return;
                        }
                        return;
                    }
                }
                loadImage(str, new AnonymousClass6(onLoadImageCallback, str));
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        if (onLoadImageCallback != null) {
            if (TinyUtils.isMain()) {
                onLoadImageCallback.onComplete(null);
                return;
            }
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader.4
                {
                    H5ResourceLoader.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    onLoadImageCallback.onComplete(null);
                }
            });
        }
        int i4 = PlaceComponentResult + 1;
        lookAheadTest = i4 % 128;
        int i5 = i4 % 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader$6 */
    /* loaded from: classes6.dex */
    public class AnonymousClass6 implements ZebraLoader.OnLoadResourceCallback {
        final /* synthetic */ ZebraLoader.OnLoadImageCallback val$callback;
        final /* synthetic */ String val$source;

        AnonymousClass6(ZebraLoader.OnLoadImageCallback onLoadImageCallback, String str) {
            H5ResourceLoader.this = r1;
            this.val$callback = onLoadImageCallback;
            this.val$source = str;
        }

        @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadResourceCallback
        public void onComplete(final WebResourceResponse webResourceResponse) {
            if (webResourceResponse == null) {
                ZebraLoader.OnLoadImageCallback onLoadImageCallback = this.val$callback;
                if (onLoadImageCallback != null) {
                    onLoadImageCallback.onComplete(null);
                    return;
                }
                return;
            }
            ExecutorUtils.runNotOnMain(ExecutorType.IO, new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader.6.1
                {
                    AnonymousClass6.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    final Bitmap decodeStream = H5MapUtils.decodeStream(webResourceResponse.getData());
                    if (decodeStream != null && H5ResourceLoader.access$000(H5ResourceLoader.this).configController.isMapWebCacheEnabled()) {
                        boolean z = true;
                        boolean z2 = AnonymousClass6.this.val$source.startsWith(GriverJSAPIPermission.PROTOCOL_HTTP) || AnonymousClass6.this.val$source.startsWith(GriverJSAPIPermission.PROTOCOL_HTTPS);
                        if (!AnonymousClass6.this.val$source.startsWith(H5ResourceHandlerUtil.RESOURCE) && !AnonymousClass6.this.val$source.startsWith("https://usr/")) {
                            z = false;
                        }
                        if (z2 && !z) {
                            BitmapCache.INSTANCE.putCacheOfWeb(AnonymousClass6.this.val$source, decodeStream);
                        }
                    }
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader.6.1.1
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (AnonymousClass6.this.val$callback != null) {
                                AnonymousClass6.this.val$callback.onComplete(decodeStream);
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader$7 */
    /* loaded from: classes6.dex */
    public class AnonymousClass7 implements ZebraLoader.OnLoadResourceCallback {
        final /* synthetic */ ZebraLoader.OnLoadTextCallback val$callback;
        final /* synthetic */ String val$charset;

        AnonymousClass7(ZebraLoader.OnLoadTextCallback onLoadTextCallback, String str) {
            H5ResourceLoader.this = r1;
            this.val$callback = onLoadTextCallback;
            this.val$charset = str;
        }

        @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadResourceCallback
        public void onComplete(final WebResourceResponse webResourceResponse) {
            if (webResourceResponse == null) {
                ZebraLoader.OnLoadTextCallback onLoadTextCallback = this.val$callback;
                if (onLoadTextCallback != null) {
                    onLoadTextCallback.onComplete(null);
                    return;
                }
                return;
            }
            ExecutorUtils.runNotOnMain(ExecutorType.IO, new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader.7.1
                {
                    AnonymousClass7.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    final String access$200 = H5ResourceLoader.access$200(H5ResourceLoader.this, webResourceResponse.getData(), AnonymousClass7.this.val$charset);
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader.7.1.1
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (AnonymousClass7.this.val$callback != null) {
                                AnonymousClass7.this.val$callback.onComplete(access$200);
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0014, code lost:
    
        if (r0 != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0022, code lost:
    
        if ((!android.text.TextUtils.isEmpty(r7)) != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0025, code lost:
    
        r7 = com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader.lookAheadTest + 35;
        com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader.PlaceComponentResult = r7 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0031, code lost:
    
        if ((r7 % 2) == 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0033, code lost:
    
        r7 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0035, code lost:
    
        r7 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0038, code lost:
    
        if (r7 == 26) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x003a, code lost:
    
        r1 = new java.lang.Object[1];
        d(56 % android.graphics.Color.blue(0), new byte[]{-123, -124, -125, -126, -127}, null, null, r1);
        r7 = ((java.lang.String) r1[0]).intern();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0054, code lost:
    
        r1 = new java.lang.Object[1];
        d(127 - android.graphics.Color.blue(0), new byte[]{-123, -124, -125, -126, -127}, null, null, r1);
        r7 = ((java.lang.String) r1[0]).intern();
     */
    @Override // com.alipay.mobile.zebra.ZebraLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadText(java.lang.String r6, java.lang.String r7, com.alipay.mobile.zebra.ZebraLoader.OnLoadTextCallback r8) {
        /*
            r5 = this;
            int r0 = com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader.lookAheadTest
            int r0 = r0 + 53
            int r1 = r0 % 128
            com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L19
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            int r4 = r3.length     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L6c
            goto L25
        L17:
            r6 = move-exception
            throw r6
        L19:
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L21
            r0 = 0
            goto L22
        L21:
            r0 = 1
        L22:
            if (r0 == 0) goto L25
            goto L6c
        L25:
            int r7 = com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader.lookAheadTest
            int r7 = r7 + 35
            int r0 = r7 % 128
            com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader.PlaceComponentResult = r0
            int r7 = r7 % 2
            r0 = 26
            if (r7 == 0) goto L35
            r7 = 3
            goto L37
        L35:
            r7 = 26
        L37:
            r4 = 5
            if (r7 == r0) goto L54
            r7 = 56
            int r0 = android.graphics.Color.blue(r2)
            int r7 = r7 % r0
            byte[] r0 = new byte[r4]
            r0 = {x0080: FILL_ARRAY_DATA , data: [-123, -124, -125, -126, -127} // fill-array
            java.lang.Object[] r1 = new java.lang.Object[r1]
            d(r7, r0, r3, r3, r1)
            r7 = r1[r2]
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r7 = r7.intern()
            goto L6c
        L54:
            int r7 = android.graphics.Color.blue(r2)
            int r7 = 127 - r7
            byte[] r0 = new byte[r4]
            r0 = {x0088: FILL_ARRAY_DATA , data: [-123, -124, -125, -126, -127} // fill-array
            java.lang.Object[] r1 = new java.lang.Object[r1]
            d(r7, r0, r3, r3, r1)
            r7 = r1[r2]
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r7 = r7.intern()
        L6c:
            com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader$7 r0 = new com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader$7
            r0.<init>(r8, r7)
            r5.loadText(r6, r0)
            int r6 = com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader.PlaceComponentResult
            int r6 = r6 + 79
            int r7 = r6 % 128
            com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader.lookAheadTest = r7
            int r6 = r6 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader.loadText(java.lang.String, java.lang.String, com.alipay.mobile.zebra.ZebraLoader$OnLoadTextCallback):void");
    }

    private String a(InputStream inputStream, String str) {
        Object obj = null;
        try {
            String str2 = new String(inputToByte(inputStream), str);
            int i = PlaceComponentResult + 37;
            lookAheadTest = i % 128;
            if (!(i % 2 != 0)) {
                obj.hashCode();
                return str2;
            }
            return str2;
        } catch (Exception e) {
            RVLogger.e(H5MapContainer.TAG, e);
            this.f7145a.reportController.reportException("H5ResourceLoader#streamToText", e.getMessage());
            return null;
        }
    }

    public static byte[] inputToByte(InputStream inputStream) {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream;
        byte[] bArr;
        byte[] bArr2 = null;
        if ((inputStream == null ? 'X' : '3') == 'X') {
            int i = PlaceComponentResult + 43;
            lookAheadTest = i % 128;
            if (i % 2 == 0) {
                IOUtils.returnBuf(null);
                IOUtils.closeQuietly(null);
                bArr2.hashCode();
            } else {
                IOUtils.returnBuf(null);
                IOUtils.closeQuietly(null);
            }
            return null;
        }
        try {
            bArr = IOUtils.getBuf(2048);
        } catch (Exception e) {
            e = e;
            bArr = null;
            poolingByteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            poolingByteArrayOutputStream = null;
            IOUtils.returnBuf(bArr2);
            IOUtils.closeQuietly(poolingByteArrayOutputStream);
            throw th;
        }
        try {
            poolingByteArrayOutputStream = new PoolingByteArrayOutputStream();
            while (true) {
                try {
                    try {
                        int read = inputStream.read(bArr);
                        if ((read != -1 ? '_' : '/') != '_') {
                            byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
                            try {
                                IOUtils.returnBuf(bArr);
                                IOUtils.closeQuietly(poolingByteArrayOutputStream);
                                return byteArray;
                            } catch (Exception e2) {
                                throw e2;
                            }
                        }
                        int i2 = PlaceComponentResult + 89;
                        lookAheadTest = i2 % 128;
                        if (!(i2 % 2 == 0)) {
                            poolingByteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            poolingByteArrayOutputStream.write(bArr, 1, read);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bArr2 = bArr;
                        IOUtils.returnBuf(bArr2);
                        IOUtils.closeQuietly(poolingByteArrayOutputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    RVLogger.e("H5IOUtils", e);
                    IOUtils.returnBuf(bArr);
                    IOUtils.closeQuietly(poolingByteArrayOutputStream);
                    return null;
                }
            }
        } catch (Exception e4) {
            e = e4;
            poolingByteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            poolingByteArrayOutputStream = null;
            bArr2 = bArr;
            IOUtils.returnBuf(bArr2);
            IOUtils.closeQuietly(poolingByteArrayOutputStream);
            throw th;
        }
    }

    private static void d(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i2 = 0;
            while (true) {
                if ((i2 < length ? '=' : 'B') == 'B') {
                    break;
                }
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
                i2++;
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ getAuthRequestContext);
        try {
            if (!(MyBillsEntityDataFactory)) {
                if (!(BuiltInFictitiousFunctionClassFactory)) {
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                    char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                    while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                        cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                        int i4 = $10 + 69;
                        $11 = i4 % 128;
                        int i5 = i4 % 2;
                    }
                    objArr[0] = new String(cArr4);
                    return;
                }
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? '_' : '9') != '_') {
                        objArr[0] = new String(cArr5);
                        return;
                    }
                    int i6 = $11 + 27;
                    $10 = i6 % 128;
                    int i7 = i6 % 2;
                    cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
            } else {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    if (!(bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult)) {
                        objArr[0] = new String(cArr6);
                        return;
                    }
                    cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    int i8 = $11 + 41;
                    $10 = i8 % 128;
                    int i9 = i8 % 2;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
