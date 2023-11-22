package com.alibaba.ariver.v8worker;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.webkit.WebResourceResponse;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.jsi.standard.JSContext;
import com.alibaba.jsi.standard.js.JSCallback;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import o.whenAvailable;

/* loaded from: classes6.dex */
public class ImportScriptsCallback extends JSCallback {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    public static final String KYLIN_BRIDGE = "https://alipay.kylinBridge";
    private static int PlaceComponentResult = 0;
    private static final String TAG = "ImportScriptsCallback";
    private App mApp;
    private V8Worker mWorker;
    private static char[] MyBillsEntityDataFactory = {62235, 6205, 9542, 12822, 24554};
    private static long BuiltInFictitiousFunctionClassFactory = 4179899254950533225L;

    public ImportScriptsCallback(App app, V8Worker v8Worker) {
        this.mWorker = v8Worker;
        this.mApp = app;
    }

    public ImportScriptsCallback(V8Worker v8Worker) {
        this.mWorker = v8Worker;
    }

    public void setApp(App app) {
        try {
            if ((this.mApp == null ? (char) 5 : 'L') == 5) {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
                PlaceComponentResult = i % 128;
                if ((i % 2 != 0 ? '\t' : 'K') != 'K') {
                    this.mApp = app;
                    Object obj = null;
                    obj.hashCode();
                } else {
                    this.mApp = app;
                }
            }
            int i2 = PlaceComponentResult + 61;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0084, code lost:
    
        if (r9.mWorker.isAppxLoaded() != false) goto L103;
     */
    @Override // com.alibaba.jsi.standard.js.JSCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alibaba.jsi.standard.js.JSValue onCallFunction(com.alibaba.jsi.standard.js.Arguments r10) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.v8worker.ImportScriptsCallback.onCallFunction(com.alibaba.jsi.standard.js.Arguments):com.alibaba.jsi.standard.js.JSValue");
    }

    public void handleResourceRequest(String str, JSContext jSContext) {
        try {
            int i = PlaceComponentResult + 83;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String loadResource = loadResource(str);
            if (TextUtils.isEmpty(loadResource)) {
                StringBuilder sb = new StringBuilder();
                sb.append(" >>> load js failed :");
                sb.append(str);
                RVLogger.d(TAG, sb.toString());
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" >>> js loaded ");
            sb2.append(str);
            sb2.append(", ");
            sb2.append(loadResource.length());
            sb2.append(" bytes");
            RVLogger.d(TAG, sb2.toString());
            this.mWorker.executeScript(loadResource, str, jSContext);
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            if (!this.mWorker.mAppxLoaded) {
                if ((V8Utils.startsWithIgnoreCase(str, this.mWorker.getAppxWorkerJsUrl()) ? (char) 4 : 'C') != 'C') {
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 3;
                    PlaceComponentResult = i3 % 128;
                    if (i3 % 2 != 0) {
                        this.mWorker.mAppxLoaded = true;
                        this.mWorker.mAppxWorkerJsCost = elapsedRealtime ^ elapsedRealtime2;
                    } else {
                        this.mWorker.mAppxLoaded = true;
                        this.mWorker.mAppxWorkerJsCost = elapsedRealtime - elapsedRealtime2;
                    }
                }
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(" >>> js executed ");
            sb3.append(str);
            sb3.append(", cost=");
            sb3.append(elapsedRealtime2 - elapsedRealtime);
            RVLogger.d(TAG, sb3.toString());
            int i4 = PlaceComponentResult + 55;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public String loadResource(String str) {
        String str2 = null;
        if (this.mApp == null) {
            int i = PlaceComponentResult + 109;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if (i % 2 == 0) {
                str2.hashCode();
                return null;
            }
            return null;
        }
        if ((str.startsWith("/") ? 'L' : '/') == 'L' && this.mWorker.getWorkerId() != null) {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
            PlaceComponentResult = i2 % 128;
            if ((i2 % 2 != 0 ? 'J' : (char) 27) != 'J') {
                str = this.mWorker.getWorkerId().replace("/index.worker.js", str);
            } else {
                str = this.mWorker.getWorkerId().replace("/index.worker.js", str);
                int i3 = 32 / 0;
            }
        }
        Resource load = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(this.mApp).create()).load(ResourceLoadContext.newBuilder().canUseFallback(true).originUrl(str).build());
        if ((load != null ? '!' : '7') != '7') {
            byte[] bytes = load.getBytes();
            if (bytes != null && bytes.length != 0) {
                return new String(bytes);
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("shouldInterceptRequest got resource: ");
                sb.append(load);
                RVLogger.d(TAG, sb.toString());
                WebResourceResponse webResourceResponse = new WebResourceResponse(load.getMimeType(), load.getEncoding(), load.getStream());
                if (Build.VERSION.SDK_INT >= 21) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, UrlUtils.getCORSUrl(this.mWorker.getWorkerId()));
                    webResourceResponse.setResponseHeaders(hashMap);
                }
                str2 = webResourceResponseToStr(webResourceResponse);
            } catch (Exception e) {
                throw e;
            }
        }
        if (str2 == null) {
            RVLogger.e(TAG, "loadResource h5ContentProvider.getContent return null");
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 95;
            PlaceComponentResult = i4 % 128;
            int i5 = i4 % 2;
        }
        if (TextUtils.isEmpty(str2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("*** Failed to load: ");
            sb2.append(str);
            RVLogger.e(TAG, sb2.toString());
            int i6 = PlaceComponentResult + 31;
            KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
            int i7 = i6 % 2;
        }
        return str2;
    }

    public static String webResourceResponseToStr(WebResourceResponse webResourceResponse) {
        try {
            InputStream data = webResourceResponse.getData();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = data.read(bArr);
                if (!(read == -1)) {
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 123;
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                    byteArrayOutputStream.write(bArr, 0, read);
                    try {
                        int i3 = PlaceComponentResult + 17;
                        try {
                            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                            int i4 = i3 % 2;
                        } catch (Exception e) {
                            throw e;
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                } else {
                    data.close();
                    Object[] objArr = new Object[1];
                    a(KeyEvent.normalizeMetaState(0), 5 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) ((Process.getThreadPriority(0) + 20) >> 6), objArr);
                    return byteArrayOutputStream.toString(((String) objArr[0]).intern());
                }
            }
        } catch (IOException e3) {
            RVLogger.e(TAG, "webResourceResponseToStr close stream error", e3);
            return null;
        }
    }

    public void destroy() {
        try {
            int i = PlaceComponentResult + 55;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            this.mApp = null;
            int i3 = PlaceComponentResult + 113;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if (whenavailable.BuiltInFictitiousFunctionClassFactory >= i2) {
                break;
            }
            int i3 = $10 + 37;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (MyBillsEntityDataFactory[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ BuiltInFictitiousFunctionClassFactory))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? ',' : '\b') != ',') {
                String str = new String(cArr);
                int i5 = $11 + 55;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                objArr[0] = str;
                return;
            }
            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
            int i7 = $10 + 75;
            $11 = i7 % 128;
            int i8 = i7 % 2;
        }
    }
}
