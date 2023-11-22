package com.alibaba.griver.core.worker;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.WebResourceResponse;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.api.APHttpAuthHandler;
import com.alibaba.griver.base.api.APSslErrorHandler;
import com.alibaba.griver.base.api.APWebResourceRequest;
import com.alibaba.griver.base.api.APWebView;
import com.alibaba.griver.base.api.APWebViewClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o.E;

/* loaded from: classes6.dex */
public class WorkerWebViewClient implements APWebViewClient {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 13492;
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = 4360990799332652212L;
    private static int MyBillsEntityDataFactory = 933967771;
    private static int PlaceComponentResult = 0;
    private static int getAuthRequestContext = 1;

    /* renamed from: a */
    private String f6501a = "WorkerWebViewClient";
    private WebWorker b;

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void doUpdateVisitedHistory(APWebView aPWebView, String str, boolean z) {
        int i = PlaceComponentResult + 3;
        getAuthRequestContext = i % 128;
        if (i % 2 != 0) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public String getJSBridge() {
        try {
            int i = getAuthRequestContext + 115;
            PlaceComponentResult = i % 128;
            Object[] objArr = null;
            if ((i % 2 != 0 ? 'b' : (char) 23) != 23) {
                int length = objArr.length;
            }
            int i2 = getAuthRequestContext + 13;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public String getPageUrl() {
        int i = PlaceComponentResult + 71;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        int i3 = PlaceComponentResult + 67;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public Map getRequestMap() {
        int i = PlaceComponentResult + 119;
        getAuthRequestContext = i % 128;
        Object obj = null;
        if (!(i % 2 != 0)) {
            obj.hashCode();
        }
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onFirstVisuallyRender(APWebView aPWebView) {
        int i = PlaceComponentResult + 5;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onFormResubmission(APWebView aPWebView, Message message, Message message2) {
        int i = PlaceComponentResult + 39;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onLoadResource(APWebView aPWebView, String str) {
        int i = getAuthRequestContext + 21;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onPageFinished(APWebView aPWebView, String str, long j) {
        try {
            int i = getAuthRequestContext + 69;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onPageStarted(APWebView aPWebView, String str, Bitmap bitmap) {
        int i = PlaceComponentResult + 109;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onReceivedError(APWebView aPWebView, int i, String str, String str2) {
        int i2 = getAuthRequestContext + 115;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onReceivedHttpAuthRequest(APWebView aPWebView, APHttpAuthHandler aPHttpAuthHandler, String str, String str2) {
        try {
            int i = PlaceComponentResult + 7;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onReceivedHttpError(APWebView aPWebView, int i, String str) {
        int i2 = getAuthRequestContext + 25;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onReceivedLoginRequest(APWebView aPWebView, String str, String str2, String str3) {
        int i = getAuthRequestContext + 83;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onReceivedResponseHeader(Map<String, List<String>> map) {
        int i = getAuthRequestContext + 97;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onReceivedSslError(APWebView aPWebView, APSslErrorHandler aPSslErrorHandler, SslError sslError) {
        int i = PlaceComponentResult + 113;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onResourceFinishLoad(APWebView aPWebView, String str, long j) {
        int i = getAuthRequestContext + 47;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onResourceResponse(APWebView aPWebView, HashMap<String, String> hashMap) {
        int i = getAuthRequestContext + 99;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onScaleChanged(APWebView aPWebView, float f, float f2) {
        try {
            int i = PlaceComponentResult + 3;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onTooManyRedirects(APWebView aPWebView, Message message, Message message2) {
        int i = PlaceComponentResult + 15;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onUnhandledKeyEvent(APWebView aPWebView, KeyEvent keyEvent) {
        try {
            int i = getAuthRequestContext + 25;
            try {
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onWebViewEvent(APWebView aPWebView, int i, Object obj) {
        try {
            int i2 = getAuthRequestContext + 111;
            PlaceComponentResult = i2 % 128;
            if ((i2 % 2 != 0 ? '7' : 'M') != 'M') {
                Object obj2 = null;
                obj2.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public boolean shouldOverrideKeyEvent(APWebView aPWebView, KeyEvent keyEvent) {
        int i = getAuthRequestContext + 69;
        PlaceComponentResult = i % 128;
        boolean z = (i % 2 != 0 ? '5' : 'Z') == '5';
        int i2 = PlaceComponentResult + 11;
        getAuthRequestContext = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 4 : '\f') != '\f') {
            Object obj = null;
            obj.hashCode();
            return z;
        }
        return z;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public boolean shouldOverrideUrlLoading(APWebView aPWebView, String str) {
        int i = getAuthRequestContext + 59;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
        }
        int i2 = getAuthRequestContext + 95;
        PlaceComponentResult = i2 % 128;
        if ((i2 % 2 != 0 ? 'I' : 'U') != 'U') {
            int i3 = 57 / 0;
            return false;
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public boolean shouldOverrideUrlLoadingForUC(APWebView aPWebView, String str, int i) {
        int i2 = getAuthRequestContext + 63;
        PlaceComponentResult = i2 % 128;
        return i2 % 2 != 0;
    }

    public WorkerWebViewClient(WebWorker webWorker) {
        this.b = webWorker;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0082, code lost:
    
        if (r0 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0087, code lost:
    
        if (r0 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0089, code lost:
    
        r6 = new java.util.HashMap();
        r6.put(com.google.common.net.HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        r6.put("Cache-Control", io.split.android.client.network.SplitHttpHeadersBuilder.CACHE_CONTROL_NO_CACHE);
        r0.setResponseHeaders(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00a0, code lost:
    
        r1 = r5.f6501a;
        r2 = new java.lang.StringBuilder();
        r2.append("shouldInterceptRequest response is null! ");
        r2.append(r6);
        com.fullstory.instrumentation.InstrumentInjector.log_e(r1, r2.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.webkit.WebResourceResponse a(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "workerjs.js"
            boolean r0 = r6.endsWith(r0)
            r1 = 0
            if (r0 == 0) goto Lc
            r0 = 0
            goto Ld
        Lc:
            r0 = 1
        Ld:
            if (r0 == 0) goto L5a
            java.lang.String r0 = ".com/worker"
            boolean r0 = r6.endsWith(r0)
            if (r0 == 0) goto L45
            java.lang.String r0 = r5.f6501a
            java.lang.String r2 = "shouldInterceptRequest worker.html"
            com.fullstory.instrumentation.InstrumentInjector.log_e(r0, r2)
            java.lang.Class<com.alibaba.ariver.kernel.common.service.RVEnvironmentService> r0 = com.alibaba.ariver.kernel.common.service.RVEnvironmentService.class
            java.lang.Object r0 = com.alibaba.ariver.kernel.common.RVProxy.get(r0)
            com.alibaba.ariver.kernel.common.service.RVEnvironmentService r0 = (com.alibaba.ariver.kernel.common.service.RVEnvironmentService) r0
            r2 = 0
            android.content.res.Resources r0 = r0.getResources(r2)
            java.lang.String r2 = "worker.html"
            java.lang.String r0 = com.alibaba.ariver.kernel.common.utils.IOUtils.readAsset(r0, r2)
            java.lang.String r2 = "text/html"
            android.webkit.WebResourceResponse r0 = r5.a(r2, r0)
            int r2 = com.alibaba.griver.core.worker.WorkerWebViewClient.PlaceComponentResult
            int r2 = r2 + 69
            int r3 = r2 % 128
            com.alibaba.griver.core.worker.WorkerWebViewClient.getAuthRequestContext = r3
            int r2 = r2 % 2
            goto L64
        L45:
            com.alibaba.griver.core.worker.WebWorker r0 = r5.b
            com.alibaba.griver.core.worker.H5WorkerControllerProvider r0 = r0.getWorkerControllerProvider()
            android.webkit.WebResourceResponse r0 = r0.shouldInterceptRequest4Worker(r6)
            int r2 = com.alibaba.griver.core.worker.WorkerWebViewClient.getAuthRequestContext
            int r2 = r2 + 13
            int r3 = r2 % 128
            com.alibaba.griver.core.worker.WorkerWebViewClient.PlaceComponentResult = r3
            int r2 = r2 % 2
            goto L64
        L5a:
            java.lang.String r0 = r5.a()
            java.lang.String r2 = "application/javascript"
            android.webkit.WebResourceResponse r0 = r5.a(r2, r0)
        L64:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> Lb8
            r3 = 21
            r4 = 85
            if (r2 < r3) goto L6f
            r2 = 89
            goto L71
        L6f:
            r2 = 85
        L71:
            if (r2 == r4) goto Lb7
            int r2 = com.alibaba.griver.core.worker.WorkerWebViewClient.getAuthRequestContext
            int r2 = r2 + 109
            int r3 = r2 % 128
            com.alibaba.griver.core.worker.WorkerWebViewClient.PlaceComponentResult = r3
            int r2 = r2 % 2
            if (r2 == 0) goto L87
            r2 = 59
            int r2 = r2 / r1
            if (r0 == 0) goto La0
            goto L89
        L85:
            r6 = move-exception
            throw r6
        L87:
            if (r0 == 0) goto La0
        L89:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.lang.String r1 = "Access-Control-Allow-Origin"
            java.lang.String r2 = "*"
            r6.put(r1, r2)
            java.lang.String r1 = "Cache-Control"
            java.lang.String r2 = "no-cache"
            r6.put(r1, r2)
            r0.setResponseHeaders(r6)
            goto Lb7
        La0:
            java.lang.String r1 = r5.f6501a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "shouldInterceptRequest response is null! "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            com.fullstory.instrumentation.InstrumentInjector.log_e(r1, r6)
        Lb7:
            return r0
        Lb8:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.worker.WorkerWebViewClient.a(java.lang.String):android.webkit.WebResourceResponse");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0030, code lost:
    
        if ((r3 ? false : true) != true) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x004c, code lost:
    
        if ((android.text.TextUtils.isEmpty(r0)) != true) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x005b, code lost:
    
        return r0.replace("{bridge_token}", r5.b.getBridgeToken());
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x005c, code lost:
    
        r1 = com.alibaba.griver.core.worker.WorkerWebViewClient.PlaceComponentResult + 103;
        com.alibaba.griver.core.worker.WorkerWebViewClient.getAuthRequestContext = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0066, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a() {
        /*
            r5 = this;
            int r0 = com.alibaba.griver.core.worker.WorkerWebViewClient.PlaceComponentResult
            int r0 = r0 + 55
            int r1 = r0 % 128
            com.alibaba.griver.core.worker.WorkerWebViewClient.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            java.lang.String r3 = "workerjs.js"
            r4 = 0
            if (r0 == r2) goto L35
            java.lang.Class<com.alibaba.ariver.kernel.common.service.RVEnvironmentService> r0 = com.alibaba.ariver.kernel.common.service.RVEnvironmentService.class
            java.lang.Object r0 = com.alibaba.ariver.kernel.common.RVProxy.get(r0)
            com.alibaba.ariver.kernel.common.service.RVEnvironmentService r0 = (com.alibaba.ariver.kernel.common.service.RVEnvironmentService) r0
            android.content.res.Resources r0 = r0.getResources(r4)
            java.lang.String r0 = com.alibaba.ariver.kernel.common.utils.IOUtils.readAsset(r0, r3)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            int r4 = r4.length     // Catch: java.lang.Throwable -> L33
            if (r3 == 0) goto L2f
            goto L30
        L2f:
            r1 = 1
        L30:
            if (r1 == r2) goto L4e
            goto L5c
        L33:
            r0 = move-exception
            throw r0
        L35:
            java.lang.Class<com.alibaba.ariver.kernel.common.service.RVEnvironmentService> r0 = com.alibaba.ariver.kernel.common.service.RVEnvironmentService.class
            java.lang.Object r0 = com.alibaba.ariver.kernel.common.RVProxy.get(r0)
            com.alibaba.ariver.kernel.common.service.RVEnvironmentService r0 = (com.alibaba.ariver.kernel.common.service.RVEnvironmentService) r0
            android.content.res.Resources r0 = r0.getResources(r4)
            java.lang.String r0 = com.alibaba.ariver.kernel.common.utils.IOUtils.readAsset(r0, r3)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L4c
            r1 = 1
        L4c:
            if (r1 == r2) goto L5c
        L4e:
            com.alibaba.griver.core.worker.WebWorker r1 = r5.b
            java.lang.String r1 = r1.getBridgeToken()
            java.lang.String r2 = "{bridge_token}"
            java.lang.String r0 = r0.replace(r2, r1)
            return r0
        L5c:
            int r1 = com.alibaba.griver.core.worker.WorkerWebViewClient.PlaceComponentResult
            int r1 = r1 + 103
            int r2 = r1 % 128
            com.alibaba.griver.core.worker.WorkerWebViewClient.getAuthRequestContext = r2
            int r1 = r1 % 2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.worker.WorkerWebViewClient.a():java.lang.String");
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public WebResourceResponse shouldInterceptRequest(APWebView aPWebView, String str) {
        String str2 = this.f6501a;
        StringBuilder sb = new StringBuilder();
        sb.append("shouldInterceptRequest url: ");
        sb.append(str);
        RVLogger.d(str2, sb.toString());
        WebResourceResponse a2 = a(str);
        int i = getAuthRequestContext + 109;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return a2;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public WebResourceResponse shouldInterceptRequest(APWebView aPWebView, APWebResourceRequest aPWebResourceRequest) {
        String str = this.f6501a;
        StringBuilder sb = new StringBuilder();
        sb.append("shouldInterceptRequest request: ");
        sb.append(aPWebResourceRequest.getUrl());
        RVLogger.d(str, sb.toString());
        WebResourceResponse a2 = a(aPWebResourceRequest.getUrl().toString());
        int i = getAuthRequestContext + 89;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return a2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0022, code lost:
    
        if ((r13 == null ? 'F' : '#') != 'F') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x002c, code lost:
    
        if ((r13 == null) != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x002e, code lost:
    
        r13 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0030, code lost:
    
        r3 = r13.getBytes(id.dana.data.here.HereOauthManager.ENC);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0037, code lost:
    
        r13 = com.alibaba.griver.core.worker.WorkerWebViewClient.getAuthRequestContext + 37;
        com.alibaba.griver.core.worker.WorkerWebViewClient.PlaceComponentResult = r13 % 128;
        r13 = r13 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0042, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0043, code lost:
    
        com.alibaba.ariver.kernel.common.utils.RVLogger.e(r11.f6501a, "failed to get byte array", r13);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.webkit.WebResourceResponse a(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            int r0 = com.alibaba.griver.core.worker.WorkerWebViewClient.PlaceComponentResult
            int r0 = r0 + 97
            int r1 = r0 % 128
            com.alibaba.griver.core.worker.WorkerWebViewClient.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 49
            if (r0 != 0) goto L11
            r0 = 13
            goto L13
        L11:
            r0 = 49
        L13:
            r2 = 1
            r3 = 0
            r4 = 0
            if (r0 == r1) goto L27
            int r0 = r3.length     // Catch: java.lang.Throwable -> L25
            r0 = 70
            if (r13 != 0) goto L20
            r1 = 70
            goto L22
        L20:
            r1 = 35
        L22:
            if (r1 == r0) goto L2e
            goto L30
        L25:
            r12 = move-exception
            throw r12
        L27:
            if (r13 != 0) goto L2b
            r0 = 1
            goto L2c
        L2b:
            r0 = 0
        L2c:
            if (r0 == 0) goto L30
        L2e:
            java.lang.String r13 = ""
        L30:
            java.lang.String r0 = "utf-8"
            byte[] r3 = r13.getBytes(r0)     // Catch: java.lang.Exception -> L42
            int r13 = com.alibaba.griver.core.worker.WorkerWebViewClient.getAuthRequestContext
            int r13 = r13 + 37
            int r0 = r13 % 128
            com.alibaba.griver.core.worker.WorkerWebViewClient.PlaceComponentResult = r0
            int r13 = r13 % 2
            goto L4a
        L42:
            r13 = move-exception
            java.lang.String r0 = r11.f6501a
            java.lang.String r1 = "failed to get byte array"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r0, r1, r13)
        L4a:
            java.io.ByteArrayInputStream r13 = new java.io.ByteArrayInputStream
            r13.<init>(r3)
            android.webkit.WebResourceResponse r0 = new android.webkit.WebResourceResponse
            r1 = 5
            char[] r5 = new char[r1]
            r5 = {x0088: FILL_ARRAY_DATA , data: [24602, 20721, 15884, 17262, 16695} // fill-array
            r1 = 4
            char[] r6 = new char[r1]
            r6 = {x0092: FILL_ARRAY_DATA , data: [1669, -4229, -11504, 17436} // fill-array
            int r3 = android.view.View.MeasureSpec.getMode(r4)
            int r3 = 7379 - r3
            char r7 = (char) r3
            char[] r8 = new char[r1]
            r8 = {x009a: FILL_ARRAY_DATA , data: [0, 0, 0, 0} // fill-array
            r1 = 284130054(0x10ef7b06, float:9.4458426E-29)
            r3 = 0
            float r9 = android.graphics.PointF.length(r3, r3)
            int r3 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            int r9 = r3 + r1
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r10 = r1
            c(r5, r6, r7, r8, r9, r10)
            r1 = r1[r4]
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = r1.intern()
            r0.<init>(r12, r1, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.worker.WorkerWebViewClient.a(java.lang.String, java.lang.String):android.webkit.WebResourceResponse");
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public boolean shouldInterceptResponse(APWebView aPWebView, HashMap<String, String> hashMap) {
        String str = this.f6501a;
        StringBuilder sb = new StringBuilder();
        sb.append("shouldInterceptResponse url: ");
        sb.append(hashMap);
        RVLogger.d(str, sb.toString());
        int i = PlaceComponentResult + 121;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? (char) 6 : 'D') != 'D') {
            Object obj = null;
            obj.hashCode();
            return false;
        }
        return false;
    }

    private static void c(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        int i2 = $10 + 83;
        $11 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
                int i4 = $11 + 41;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                int i6 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i7 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i6]) % 65535);
                cArr5[i7] = (char) (((cArr4[i7] * 32718) + cArr5[i6]) / 65535);
                cArr4[i7] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i7] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L)) ^ ((int) (MyBillsEntityDataFactory ^ 4360990799332652212L))) ^ ((char) (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
            } else {
                objArr[0] = new String(cArr6);
                return;
            }
        }
    }
}
