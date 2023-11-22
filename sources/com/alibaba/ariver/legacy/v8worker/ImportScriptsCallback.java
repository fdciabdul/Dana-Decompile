package com.alibaba.ariver.legacy.v8worker;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.webkit.WebResourceResponse;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.engine.common.worker.WorkerUtils;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alipay.mobile.jsengine.v8.JavaVoidCallback;
import com.alipay.mobile.jsengine.v8.V8Array;
import com.alipay.mobile.jsengine.v8.V8Object;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import o.E;

/* loaded from: classes6.dex */
public class ImportScriptsCallback implements JavaVoidCallback {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = -956812108;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    public static final String KYLIN_BRIDGE = "https://alipay.kylinBridge";
    private static long MyBillsEntityDataFactory = 4360990799332652212L;
    private static char PlaceComponentResult = 27706;
    private static final String TAG = "ImportScriptsCallback";
    private static int getAuthRequestContext;
    private App mApp;
    private V8Worker mWorker;

    public ImportScriptsCallback(App app, V8Worker v8Worker) {
        this.mWorker = v8Worker;
        this.mApp = app;
    }

    @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
    public void invoke(V8Object v8Object, V8Array v8Array) {
        String str;
        for (int i = 0; i < v8Array.length(); i++) {
            try {
                String str2 = (String) v8Array.get(i);
                if (str2 != null) {
                    String trim = str2.trim();
                    if (!(!this.mWorker.isAppxLoaded())) {
                        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
                        getAuthRequestContext = i2 % 128;
                        if ((i2 % 2 != 0 ? '7' : 'N') != 'N') {
                            int i3 = 57 / 0;
                            if (WorkerUtils.startsWithIgnoreCase(trim, "https://appx/af-appx.worker.min.js")) {
                            }
                        } else if (WorkerUtils.startsWithIgnoreCase(trim, "https://appx/af-appx.worker.min.js")) {
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("importScripts ");
                    if (trim.length() > 200) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(trim.substring(0, 200));
                        sb2.append("..");
                        str = sb2.toString();
                    } else {
                        str = trim;
                    }
                    sb.append(str);
                    sb.append(" ? ");
                    sb.append("https://appx/af-appx.worker.min.js".equals(trim));
                    RVLogger.d(TAG, sb.toString());
                    if (WorkerUtils.startsWithIgnoreCase(trim, "https://alipay.kylinBridge")) {
                        int i4 = getAuthRequestContext + 21;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                        if ((i4 % 2 == 0 ? 'Y' : (char) 19) != 19) {
                            this.mWorker.getJsApiHandler().handleSyncJsapiRequest(trim);
                            Object obj = null;
                            obj.hashCode();
                        } else {
                            this.mWorker.getJsApiHandler().handleSyncJsapiRequest(trim);
                        }
                    } else {
                        handleResourceRequest(trim);
                    }
                }
            } catch (Throwable th) {
                RVLogger.e(TAG, "work load url form mainPageResourceResponse error! ", th);
                return;
            }
        }
    }

    public void handleResourceRequest(String str) {
        int i = getAuthRequestContext + 93;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            String loadResource = loadResource(str);
            try {
                if (!TextUtils.isEmpty(loadResource)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" >>> js loaded ");
                    sb.append(str);
                    sb.append(", ");
                    sb.append(loadResource.length());
                    sb.append(" bytes");
                    RVLogger.d(TAG, sb.toString());
                    this.mWorker.executeScript(loadResource, str, 0);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(" >>> js executed ");
                    sb2.append(str);
                    RVLogger.d(TAG, sb2.toString());
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
                    getAuthRequestContext = i3 % 128;
                    int i4 = i3 % 2;
                    return;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" >>> load js failed :");
                sb3.append(str);
                RVLogger.d(TAG, sb3.toString());
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String loadResource(String str) {
        String str2;
        if (str.startsWith("/")) {
            if ((this.mWorker.getWorkerId() != null ? '1' : '2') == '1') {
                str = this.mWorker.getWorkerId().replace("/index.worker.js", str);
                int i = getAuthRequestContext + 23;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
            }
        }
        Resource load = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(this.mApp).create()).load(ResourceLoadContext.newBuilder().canUseFallback(true).originUrl(str).build());
        Object[] objArr = null;
        if (load != null) {
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
        } else {
            str2 = null;
        }
        if (!(str2 != null)) {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
            getAuthRequestContext = i3 % 128;
            if (i3 % 2 != 0) {
                RVLogger.e(TAG, "loadResource h5ContentProvider.getContent return null");
                int length = objArr.length;
            } else {
                RVLogger.e(TAG, "loadResource h5ContentProvider.getContent return null");
            }
        }
        if (TextUtils.isEmpty(str2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("*** Failed to load: ");
            sb2.append(str);
            RVLogger.e(TAG, sb2.toString());
        }
        return str2;
    }

    public static String webResourceResponseToStr(WebResourceResponse webResourceResponse) {
        try {
            InputStream data = webResourceResponse.getData();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            int i = getAuthRequestContext + 53;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            while (true) {
                int read = data.read(bArr);
                if (!(read == -1)) {
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
                    getAuthRequestContext = i3 % 128;
                    int i4 = i3 % 2;
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    data.close();
                    Object[] objArr = new Object[1];
                    a(new char[]{33335, 6285, 37472, 28790, 17152}, new char[]{15404, 64419, 6451, 53608}, (char) (26649 - (ViewConfiguration.getTouchSlop() >> 8)), new char[]{0, 0, 0, 0}, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 872129339, objArr);
                    return byteArrayOutputStream.toString(((String) objArr[0]).intern());
                }
            }
        } catch (IOException e) {
            RVLogger.e(TAG, "webResourceResponseToStr close stream error", e);
            return null;
        }
    }

    private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
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
        int i2 = $10 + 37;
        $11 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
                int i4 = $10 + 85;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                int i6 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i7 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i6]) % 65535);
                cArr5[i7] = (char) (((cArr4[i7] * 32718) + cArr5[i6]) / 65535);
                cArr4[i7] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i7] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (MyBillsEntityDataFactory ^ 4360990799332652212L)) ^ ((int) (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L))) ^ ((char) (PlaceComponentResult ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
            } else {
                objArr[0] = new String(cArr6);
                return;
            }
        }
    }
}
