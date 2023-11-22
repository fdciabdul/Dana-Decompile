package com.alipay.mobile.map.style;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.kernel.common.io.PoolingByteArrayOutputStream;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.ap.zoloz.hummer.biz.HummerZCodeConstant;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes6.dex */
public class CustomMapStyle {
    public static final CustomMapStyle INSTANCE = new CustomMapStyle();
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int PlaceComponentResult = 0;
    public static final String STYLE_ANT_SPORTS01 = "antsports01";
    public static final String STYLE_DEFAULT = "default";
    public static final String STYLE_LIGHT = "light";

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f7204a;
    private volatile boolean b;
    private Map<String, String> c = new ConcurrentHashMap();

    private CustomMapStyle() {
    }

    public String getStylePath(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str3 = this.c.get(str);
        if (str3 != null) {
            return str3;
        }
        if ("light".equals(str)) {
            String a2 = a(b());
            if (TextUtils.isEmpty(a2)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append("/");
            sb.append("GriverMap/style_light.data");
            str2 = sb.toString();
        } else if (STYLE_ANT_SPORTS01.equals(str)) {
            String a3 = a(b());
            if (TextUtils.isEmpty(a3)) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a3);
            sb2.append("/");
            sb2.append("GriverMap/style_antsports01.data");
            str2 = sb2.toString();
        }
        this.c.put(str, str2);
        return str2;
    }

    private String a(Context context) {
        if (context == null) {
            return "";
        }
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            RVLogger.e("CustomMapStyle", "Context#getFilesDir is null");
            return "";
        }
        return filesDir.getAbsolutePath();
    }

    public boolean isResourcesReady() {
        return this.b;
    }

    public void prepareResources() {
        if (this.f7204a) {
            return;
        }
        synchronized (CustomMapStyle.class) {
            if (this.f7204a) {
                return;
            }
            this.f7204a = true;
            ExecutorUtils.runNotOnMain(ExecutorType.NORMAL, new Runnable() { // from class: com.alipay.mobile.map.style.CustomMapStyle.1
                @Override // java.lang.Runnable
                public void run() {
                    CustomMapStyle.this.a();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Context b = b();
        if (b == null) {
            RVLogger.e("CustomMapStyle", HummerZCodeConstant.CONTEXT_ERROR_MSG);
            return;
        }
        String a2 = a(b);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        String[] strArr = {"light", STYLE_ANT_SPORTS01};
        String[] strArr2 = {"GriverMap/style_light.data", "GriverMap/style_antsports01.data"};
        String[] strArr3 = {"cb7898c1a0840e97b942d8fe2419a073", "3a22402773ad81b80f970383fe7808e0"};
        for (int i = 0; i < 2; i++) {
            String str = strArr2[i];
            String str2 = strArr3[i];
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append("/");
            sb.append(str);
            a(b, str2, str, sb.toString());
        }
        for (int i2 = 0; i2 < 2; i2++) {
            Map<String, String> map = this.c;
            String str3 = strArr[i2];
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a2);
            sb2.append("/");
            sb2.append(strArr2[i2]);
            map.put(str3, sb2.toString());
        }
        RVLogger.d("CustomMapStyle", "resources prepare done");
        this.b = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0042, code lost:
    
        if (r4 != null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
    
        r4.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
    
        r8 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        if (r4 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0072, code lost:
    
        r4.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0076, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
    
        if (r4 != null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a8, code lost:
    
        if (r4 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ab, code lost:
    
        com.alibaba.ariver.kernel.common.utils.RVLogger.e("CustomMapStyle", r8);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(android.content.Context r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.map.style.CustomMapStyle.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v5 */
    private byte[] a(Context context, String str) {
        Exception e;
        InputStream inputStream;
        int i = PlaceComponentResult + 23;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        ?? r0 = 0;
        try {
            try {
                try {
                    Object[] objArr = {context.getAssets(), str};
                    Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                    if (obj == null) {
                        obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (58133 - ExpandableListView.getPackedPositionGroup(0L)), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1, 49 - (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                        NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                    }
                    inputStream = (InputStream) ((Method) obj).invoke(null, objArr);
                    try {
                        byte[] inputToByte = inputToByte(inputStream);
                        IOUtils.closeQuietly(inputStream);
                        return inputToByte;
                    } catch (Exception e2) {
                        e = e2;
                        RVLogger.e("CustomMapStyle", e);
                        IOUtils.closeQuietly(inputStream);
                        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
                        PlaceComponentResult = i3 % 128;
                        int i4 = i3 % 2;
                        return null;
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                try {
                    IOUtils.closeQuietly(r0);
                    throw th;
                } catch (Exception e4) {
                    throw e4;
                }
            }
        } catch (Throwable th3) {
            r0 = context;
            th = th3;
            IOUtils.closeQuietly(r0);
            throw th;
        }
    }

    private Context b() {
        return GriverEnv.getApplicationContext();
    }

    public static byte[] inputToByte(InputStream inputStream) {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream;
        byte[] bArr;
        byte[] bArr2 = null;
        if (inputStream == null) {
            IOUtils.returnBuf(null);
            IOUtils.closeQuietly(null);
            return null;
        }
        try {
            bArr = IOUtils.getBuf(2048);
            try {
                poolingByteArrayOutputStream = new PoolingByteArrayOutputStream();
                while (true) {
                    try {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
                                IOUtils.returnBuf(bArr);
                                IOUtils.closeQuietly(poolingByteArrayOutputStream);
                                return byteArray;
                            }
                            poolingByteArrayOutputStream.write(bArr, 0, read);
                        } catch (Throwable th) {
                            th = th;
                            bArr2 = bArr;
                            IOUtils.returnBuf(bArr2);
                            IOUtils.closeQuietly(poolingByteArrayOutputStream);
                            throw th;
                        }
                    } catch (Exception e) {
                        e = e;
                        RVLogger.e("H5IOUtils", e);
                        IOUtils.returnBuf(bArr);
                        IOUtils.closeQuietly(poolingByteArrayOutputStream);
                        return null;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                poolingByteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                poolingByteArrayOutputStream = null;
                bArr2 = bArr;
                IOUtils.returnBuf(bArr2);
                IOUtils.closeQuietly(poolingByteArrayOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bArr = null;
            poolingByteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            poolingByteArrayOutputStream = null;
            IOUtils.returnBuf(bArr2);
            IOUtils.closeQuietly(poolingByteArrayOutputStream);
            throw th;
        }
    }
}
