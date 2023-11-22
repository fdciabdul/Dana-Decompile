package com.alibaba.griver.image.framework.utils;

import android.graphics.Bitmap;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.image.framework.meta.StaticOptions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes6.dex */
public class FalconFacade {
    public static final int QUA_HIGH = 2;
    public static final int QUA_LOCAL_ORIGINAL = 3;
    public static final int QUA_LOW = 0;
    public static final int QUA_MIDDLE = 1;
    public static final int QUA_WEBP = 4;

    /* renamed from: a  reason: collision with root package name */
    private static FalconFacade f6588a = new FalconFacade();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface FalconInterface {
        Bitmap cutImage_keepRatio(InputStream inputStream, int i, int i2) throws Exception;

        FalconDecoderBridge getFalconImgCut();

        boolean isUseAshmem();
    }

    public static FalconFacade get() {
        return f6588a;
    }

    private FalconFacade() {
        try {
            StaticOptions.jniDebug = GriverEnv.isDebuggable() && new File("/sdcard/debugJni.t").exists();
        } catch (Throwable unused) {
            RVLogger.w("ignore init error");
        }
    }

    private FalconInterface a() {
        FalconInterfaceImpl falconInterfaceImpl = new FalconInterfaceImpl();
        return (FalconInterface) Proxy.newProxyInstance(falconInterfaceImpl.getClass().getClassLoader(), falconInterfaceImpl.getClass().getInterfaces(), new FalconImageCutProxy(falconInterfaceImpl));
    }

    public Bitmap cutImageKeepRatio(InputStream inputStream, int i, int i2) throws Exception {
        return a().cutImage_keepRatio(inputStream, i, i2);
    }

    public Bitmap cutImageKeepRatio(byte[] bArr, int i, int i2) throws Exception {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        Bitmap cutImageKeepRatio = cutImageKeepRatio(byteArrayInputStream, i, i2);
        IOUtils.closeQuietly(byteArrayInputStream);
        return cutImageKeepRatio;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class FalconInterfaceImpl implements FalconInterface {

        /* renamed from: a  reason: collision with root package name */
        private FalconDecoderBridge f6590a;
        private boolean b = ImageUtils.isSdkMatch();

        public FalconInterfaceImpl() {
            FalconDecoderBridge falconDecoderBridge = new FalconDecoderBridge();
            this.f6590a = falconDecoderBridge;
            falconDecoderBridge.setIsUseNewMethod(this.b);
        }

        @Override // com.alibaba.griver.image.framework.utils.FalconFacade.FalconInterface
        public FalconDecoderBridge getFalconImgCut() {
            return this.f6590a;
        }

        @Override // com.alibaba.griver.image.framework.utils.FalconFacade.FalconInterface
        public boolean isUseAshmem() {
            return this.b;
        }

        @Override // com.alibaba.griver.image.framework.utils.FalconFacade.FalconInterface
        public Bitmap cutImage_keepRatio(InputStream inputStream, int i, int i2) throws Exception {
            return this.f6590a.cutImage_keepRatio(inputStream, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class FalconImageCutProxy implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private FalconInterface f6589a;

        public FalconImageCutProxy(FalconInterface falconInterface) {
            this.f6589a = falconInterface;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (ByteArrayOutputStream.class.equals(method.getReturnType())) {
                return method.invoke(this.f6589a, objArr);
            }
            return a(method, objArr);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.Object a(java.lang.reflect.Method r8, java.lang.Object[] r9) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.String r0 = "FalconImageCutProxy decode by ashmem error"
                java.lang.String r1 = "FalconFacade"
                com.alibaba.griver.image.framework.utils.FalconFacade$FalconInterface r2 = r7.f6589a
                com.alibaba.griver.image.framework.utils.FalconDecoderBridge r2 = r2.getFalconImgCut()
                com.alibaba.griver.image.framework.utils.FalconFacade$FalconInterface r3 = r7.f6589a
                boolean r3 = r3.isUseAshmem()
                r4 = 1
                r5 = 0
                r6 = 0
                if (r3 == 0) goto L38
                com.alibaba.griver.image.framework.utils.FalconFacade$FalconInterface r3 = r7.f6589a     // Catch: java.lang.Throwable -> L22 java.lang.reflect.InvocationTargetException -> L27
                java.lang.Object r0 = r8.invoke(r3, r9)     // Catch: java.lang.Throwable -> L22 java.lang.reflect.InvocationTargetException -> L27
                if (r0 == 0) goto L1f
                r1 = 1
                goto L20
            L1f:
                r1 = 0
            L20:
                r5 = r0
                goto L30
            L22:
                r3 = move-exception
                com.alibaba.ariver.kernel.common.utils.RVLogger.e(r1, r0, r3)
                goto L2f
            L27:
                r3 = move-exception
                java.lang.Throwable r3 = r3.getCause()
                com.alibaba.ariver.kernel.common.utils.RVLogger.e(r1, r0, r3)
            L2f:
                r1 = 0
            L30:
                if (r1 != 0) goto L39
                java.lang.String r0 = "FalconImageCutProxy decode by ashmem result: false"
                com.alibaba.ariver.kernel.common.utils.RVLogger.d(r0)
                goto L39
            L38:
                r1 = 0
            L39:
                if (r1 != 0) goto L44
                r2.setIsUseNewMethod(r6)
                com.alibaba.griver.image.framework.utils.FalconFacade$FalconInterface r0 = r7.f6589a
                java.lang.Object r5 = r8.invoke(r0, r9)
            L44:
                boolean r8 = r5 instanceof android.graphics.Bitmap
                if (r8 == 0) goto L4e
                r8 = r5
                android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
                r8.setHasAlpha(r4)
            L4e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.framework.utils.FalconFacade.FalconImageCutProxy.a(java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
        }
    }
}
