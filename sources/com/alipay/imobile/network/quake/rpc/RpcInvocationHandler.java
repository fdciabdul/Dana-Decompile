package com.alipay.imobile.network.quake.rpc;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.IQuake;
import com.alipay.imobile.network.quake.Quake;
import com.alipay.imobile.network.quake.QuakeConfig;
import com.alipay.imobile.network.quake.Request;
import com.alipay.imobile.network.quake.exception.ClientException;
import com.alipay.imobile.network.quake.exception.ServerException;
import com.alipay.imobile.network.quake.transport.strategy.RetryPolicy;
import com.alipay.imobile.network.quake.util.SignUtil;
import com.alipay.mobile.common.rpc.RpcException;
import com.alipay.mobile.framework.service.annotation.CheckLogin;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.google.common.base.Ascii;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes3.dex */
public class RpcInvocationHandler implements InvocationHandler {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {10, Byte.MIN_VALUE, TarHeader.LF_LINK, 76, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 34, -37, 9, -6, 10, -7, -4, 4, -13, TarHeader.LF_CHR, -39, 13, -16, 2, 39, -17, -10, 10};
    public static final int MyBillsEntityDataFactory = 213;
    private static final ThreadLocal<Object> f = new ThreadLocal<>();
    private static final ThreadLocal<Map<String, Object>> g = new ThreadLocal<>();
    private static Request.CheckLoginListener h = new a();

    /* renamed from: a  reason: collision with root package name */
    private Class f7056a;
    private IQuakeRpc b;
    private IQuake c;
    private QuakeConfig d;
    private QuakeConfig e;

    /* loaded from: classes3.dex */
    class a implements Request.CheckLoginListener {
        a() {
        }

        @Override // com.alipay.imobile.network.quake.Request.CheckLoginListener
        public void checkLogin(Request request) throws RpcException {
            if (request instanceof RpcRequest) {
                RpcInvocationHandler.b((RpcRequest) request);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f7057a;
        final /* synthetic */ Class b;
        final /* synthetic */ Method c;
        final /* synthetic */ Object[] d;

        b(RpcInvocationHandler rpcInvocationHandler, Object obj, Class cls, Method method, Object[] objArr) {
            this.f7057a = obj;
            this.b = cls;
            this.c = method;
            this.d = objArr;
        }

        @Override // com.alipay.imobile.network.quake.rpc.RpcInvocationHandler.e
        public boolean a(RpcInterceptor rpcInterceptor, String str) throws RpcException {
            if (rpcInterceptor.preHandle(this.f7057a, RpcInvocationHandler.f, new byte[0], this.b, this.c, this.d, str, RpcInvocationHandler.g)) {
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(rpcInterceptor);
            sb.append("preHandle stop this call.");
            throw new ClientException((Integer) 9, sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f7058a;
        final /* synthetic */ byte[] b;
        final /* synthetic */ Class c;
        final /* synthetic */ Method d;
        final /* synthetic */ Object[] e;

        c(RpcInvocationHandler rpcInvocationHandler, Object obj, byte[] bArr, Class cls, Method method, Object[] objArr) {
            this.f7058a = obj;
            this.b = bArr;
            this.c = cls;
            this.d = method;
            this.e = objArr;
        }

        @Override // com.alipay.imobile.network.quake.rpc.RpcInvocationHandler.e
        public boolean a(RpcInterceptor rpcInterceptor, String str) throws RpcException {
            if (rpcInterceptor.postHandle(this.f7058a, RpcInvocationHandler.f, this.b, this.c, this.d, this.e, str)) {
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(rpcInterceptor);
            sb.append("postHandle stop this call.");
            throw new ClientException((Integer) 9, sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f7059a;
        final /* synthetic */ byte[] b;
        final /* synthetic */ Class c;
        final /* synthetic */ Method d;
        final /* synthetic */ Object[] e;
        final /* synthetic */ RpcException f;

        d(RpcInvocationHandler rpcInvocationHandler, Object obj, byte[] bArr, Class cls, Method method, Object[] objArr, RpcException rpcException) {
            this.f7059a = obj;
            this.b = bArr;
            this.c = cls;
            this.d = method;
            this.e = objArr;
            this.f = rpcException;
        }

        @Override // com.alipay.imobile.network.quake.rpc.RpcInvocationHandler.e
        public boolean a(RpcInterceptor rpcInterceptor, String str) throws RpcException {
            if (rpcInterceptor.exceptionHandle(this.f7059a, RpcInvocationHandler.f, this.b, this.c, this.d, this.e, this.f, str)) {
                LoggerWrapper.d(Quake.TAG, LoggerWrapper.buildMessage("%s need process", this.f.getMsg()), this.f);
                return true;
            }
            LoggerWrapper.d(Quake.TAG, LoggerWrapper.buildMessage("%s need process", this.f.getMsg()), this.f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface e {
        boolean a(RpcInterceptor rpcInterceptor, String str) throws RpcException;
    }

    public RpcInvocationHandler(IQuakeRpc iQuakeRpc, Class cls) {
        this.f7056a = cls;
        this.b = iQuakeRpc;
        IQuake quake = iQuakeRpc.getQuake();
        this.c = quake;
        this.d = quake.getConfig();
    }

    private Map<String, String> d() {
        QuakeConfig quakeConfig = this.e;
        if (quakeConfig == null || quakeConfig.getExternalInfo() == null) {
            return null;
        }
        return this.e.getExternalInfo();
    }

    private String e() {
        QuakeConfig quakeConfig = this.e;
        if (quakeConfig != null) {
            String gwUrl = quakeConfig.getGwUrl();
            if (!TextUtils.isEmpty(gwUrl)) {
                return gwUrl;
            }
        }
        return this.d.getGwUrl();
    }

    private RetryPolicy f() {
        QuakeConfig quakeConfig = this.e;
        if (quakeConfig != null) {
            return quakeConfig.getRetryPolicy();
        }
        return this.d.getRetryPolicy();
    }

    private SignUtil.SignInfo g() {
        QuakeConfig quakeConfig = this.e;
        if (quakeConfig == null) {
            return null;
        }
        String appKeyForSecurityGuard = quakeConfig.getAppKeyForSecurityGuard();
        if (TextUtils.isEmpty(appKeyForSecurityGuard)) {
            return null;
        }
        return new SignUtil.SignInfo(appKeyForSecurityGuard, this.e.getAuthCodeForSecurityGuard());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void i(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alipay.imobile.network.quake.rpc.RpcInvocationHandler.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 + 99
            int r7 = r7 + 12
            int r8 = 56 - r8
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L33
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            int r8 = r8 + 1
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L33:
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
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.rpc.RpcInvocationHandler.i(byte, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02ef A[Catch: all -> 0x035e, TryCatch #12 {, blocks: (B:5:0x004f, B:7:0x007f, B:9:0x008a, B:13:0x0099, B:15:0x00da, B:17:0x00e6, B:19:0x00f2, B:20:0x00f5, B:21:0x0107, B:23:0x0109, B:25:0x010f, B:26:0x0110, B:30:0x0115, B:32:0x011d, B:34:0x0121, B:35:0x012a, B:38:0x012e, B:39:0x014d, B:40:0x014f, B:41:0x015b, B:43:0x0178, B:45:0x0192, B:46:0x0195, B:48:0x019b, B:50:0x01a3, B:52:0x01ac, B:53:0x01b9, B:55:0x01f1, B:56:0x01ff, B:58:0x0207, B:98:0x02b0, B:100:0x02ef, B:101:0x02f3, B:103:0x02f9, B:104:0x0311, B:106:0x032d, B:107:0x0333, B:109:0x0340, B:110:0x0346, B:86:0x0244, B:90:0x024e, B:92:0x025b, B:91:0x0251, B:96:0x0283, B:54:0x01d5, B:113:0x034d, B:114:0x0354, B:116:0x0356, B:118:0x035c, B:119:0x035d, B:14:0x009b, B:4:0x0005), top: B:129:0x0005, inners: #0, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02f9 A[Catch: all -> 0x035e, TryCatch #12 {, blocks: (B:5:0x004f, B:7:0x007f, B:9:0x008a, B:13:0x0099, B:15:0x00da, B:17:0x00e6, B:19:0x00f2, B:20:0x00f5, B:21:0x0107, B:23:0x0109, B:25:0x010f, B:26:0x0110, B:30:0x0115, B:32:0x011d, B:34:0x0121, B:35:0x012a, B:38:0x012e, B:39:0x014d, B:40:0x014f, B:41:0x015b, B:43:0x0178, B:45:0x0192, B:46:0x0195, B:48:0x019b, B:50:0x01a3, B:52:0x01ac, B:53:0x01b9, B:55:0x01f1, B:56:0x01ff, B:58:0x0207, B:98:0x02b0, B:100:0x02ef, B:101:0x02f3, B:103:0x02f9, B:104:0x0311, B:106:0x032d, B:107:0x0333, B:109:0x0340, B:110:0x0346, B:86:0x0244, B:90:0x024e, B:92:0x025b, B:91:0x0251, B:96:0x0283, B:54:0x01d5, B:113:0x034d, B:114:0x0354, B:116:0x0356, B:118:0x035c, B:119:0x035d, B:14:0x009b, B:4:0x0005), top: B:129:0x0005, inners: #0, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x032d A[Catch: all -> 0x035e, TryCatch #12 {, blocks: (B:5:0x004f, B:7:0x007f, B:9:0x008a, B:13:0x0099, B:15:0x00da, B:17:0x00e6, B:19:0x00f2, B:20:0x00f5, B:21:0x0107, B:23:0x0109, B:25:0x010f, B:26:0x0110, B:30:0x0115, B:32:0x011d, B:34:0x0121, B:35:0x012a, B:38:0x012e, B:39:0x014d, B:40:0x014f, B:41:0x015b, B:43:0x0178, B:45:0x0192, B:46:0x0195, B:48:0x019b, B:50:0x01a3, B:52:0x01ac, B:53:0x01b9, B:55:0x01f1, B:56:0x01ff, B:58:0x0207, B:98:0x02b0, B:100:0x02ef, B:101:0x02f3, B:103:0x02f9, B:104:0x0311, B:106:0x032d, B:107:0x0333, B:109:0x0340, B:110:0x0346, B:86:0x0244, B:90:0x024e, B:92:0x025b, B:91:0x0251, B:96:0x0283, B:54:0x01d5, B:113:0x034d, B:114:0x0354, B:116:0x0356, B:118:0x035c, B:119:0x035d, B:14:0x009b, B:4:0x0005), top: B:129:0x0005, inners: #0, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0340 A[Catch: all -> 0x035e, TryCatch #12 {, blocks: (B:5:0x004f, B:7:0x007f, B:9:0x008a, B:13:0x0099, B:15:0x00da, B:17:0x00e6, B:19:0x00f2, B:20:0x00f5, B:21:0x0107, B:23:0x0109, B:25:0x010f, B:26:0x0110, B:30:0x0115, B:32:0x011d, B:34:0x0121, B:35:0x012a, B:38:0x012e, B:39:0x014d, B:40:0x014f, B:41:0x015b, B:43:0x0178, B:45:0x0192, B:46:0x0195, B:48:0x019b, B:50:0x01a3, B:52:0x01ac, B:53:0x01b9, B:55:0x01f1, B:56:0x01ff, B:58:0x0207, B:98:0x02b0, B:100:0x02ef, B:101:0x02f3, B:103:0x02f9, B:104:0x0311, B:106:0x032d, B:107:0x0333, B:109:0x0340, B:110:0x0346, B:86:0x0244, B:90:0x024e, B:92:0x025b, B:91:0x0251, B:96:0x0283, B:54:0x01d5, B:113:0x034d, B:114:0x0354, B:116:0x0356, B:118:0x035c, B:119:0x035d, B:14:0x009b, B:4:0x0005), top: B:129:0x0005, inners: #0, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0346 A[Catch: all -> 0x035e, TRY_LEAVE, TryCatch #12 {, blocks: (B:5:0x004f, B:7:0x007f, B:9:0x008a, B:13:0x0099, B:15:0x00da, B:17:0x00e6, B:19:0x00f2, B:20:0x00f5, B:21:0x0107, B:23:0x0109, B:25:0x010f, B:26:0x0110, B:30:0x0115, B:32:0x011d, B:34:0x0121, B:35:0x012a, B:38:0x012e, B:39:0x014d, B:40:0x014f, B:41:0x015b, B:43:0x0178, B:45:0x0192, B:46:0x0195, B:48:0x019b, B:50:0x01a3, B:52:0x01ac, B:53:0x01b9, B:55:0x01f1, B:56:0x01ff, B:58:0x0207, B:98:0x02b0, B:100:0x02ef, B:101:0x02f3, B:103:0x02f9, B:104:0x0311, B:106:0x032d, B:107:0x0333, B:109:0x0340, B:110:0x0346, B:86:0x0244, B:90:0x024e, B:92:0x025b, B:91:0x0251, B:96:0x0283, B:54:0x01d5, B:113:0x034d, B:114:0x0354, B:116:0x0356, B:118:0x035c, B:119:0x035d, B:14:0x009b, B:4:0x0005), top: B:129:0x0005, inners: #0, #6 }] */
    @Override // java.lang.reflect.InvocationHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object invoke(java.lang.Object r24, java.lang.reflect.Method r25, java.lang.Object[] r26) throws com.alipay.mobile.common.rpc.RpcException {
        /*
            Method dump skipped, instructions count: 867
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.rpc.RpcInvocationHandler.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(RpcRequest rpcRequest) throws RpcException {
        Method operationMethod;
        LoggerWrapper.d(Quake.TAG, "check login");
        if (rpcRequest == null || (operationMethod = rpcRequest.getOperationMethod()) == null) {
            return;
        }
        try {
            OperationType operationType = (OperationType) operationMethod.getAnnotation(OperationType.class);
            if (operationType == null) {
                return;
            }
            String url = rpcRequest.getUrl();
            if (com.alipay.imobile.network.quake.transport.strategy.a.b(url) && ((CheckLogin) operationMethod.getAnnotation(CheckLogin.class)) != null) {
                String cookie = CookieManager.getInstance().getCookie(url);
                if (!TextUtils.isEmpty(cookie)) {
                    if (cookie.contains("ALIPAYJSESSIONID")) {
                        return;
                    }
                    String str = Quake.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("CheckLogin_prejudge: cookie not contains ALIPAYJSESSIONID!  API=[");
                    sb.append(operationType.value());
                    sb.append("]");
                    LoggerWrapper.w(str, sb.toString());
                    throw new ServerException((Integer) 2000, "Session is timeout, please login again");
                }
                String str2 = Quake.TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CheckLogin_prejudge: cookie is empty  API=[");
                sb2.append(operationType.value());
                sb2.append("]");
                LoggerWrapper.w(str2, sb2.toString());
                throw new ServerException((Integer) 2000, "Session is timeout, please login again");
            }
        } catch (Exception e2) {
            LoggerWrapper.e(Quake.TAG, "", e2);
        }
    }

    public QuakeConfig a() {
        if (this.e == null) {
            this.e = new QuakeConfig(this.d);
        }
        return this.e;
    }

    private void a(Object obj, Class<?> cls, Method method, Object[] objArr, Annotation[] annotationArr) throws RpcException {
        a(annotationArr, new b(this, obj, cls, method, objArr));
    }

    private void a(Object obj, byte[] bArr, Class<?> cls, Method method, Object[] objArr, Annotation[] annotationArr) throws RpcException {
        a(annotationArr, new c(this, obj, bArr, cls, method, objArr));
    }

    private void a(Object obj, byte[] bArr, Class<?> cls, Method method, Object[] objArr, Annotation[] annotationArr, RpcException rpcException) throws RpcException {
        if (a(annotationArr, new d(this, obj, bArr, cls, method, objArr, rpcException))) {
            throw rpcException;
        }
    }

    private boolean a(Annotation[] annotationArr, e eVar) throws RpcException {
        RpcInterceptor rpcInterceptor;
        boolean z = true;
        for (Annotation annotation : annotationArr) {
            Class<? extends Annotation> annotationType = annotation.annotationType();
            if (annotationType != null && (rpcInterceptor = this.b.getRpcInterceptor(annotationType)) != null && !(z = eVar.a(rpcInterceptor, annotationType.toString()))) {
                break;
            }
        }
        return z;
    }
}
