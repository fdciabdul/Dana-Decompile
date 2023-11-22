package com.alipay.plus.android.transport.proxy;

import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.JSON;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.transport.sdk.AbstractHttpTransport;
import com.alipay.plus.android.transport.sdk.HttpError;
import com.alipay.plus.android.transport.sdk.HttpMethod;
import com.alipay.plus.android.transport.sdk.HttpRequest;
import com.alipay.plus.android.transport.sdk.HttpResponse;
import com.alipay.plus.android.transport.sdk.HttpTransportFactory;
import com.google.common.base.Ascii;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class HttpTransportProxy {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7395a = com.alipay.plus.android.transport.b.a.a("HttpTransportProxy");
    private static final AbstractHttpTransport b = HttpTransportFactory.createHttpTransport();

    /* loaded from: classes7.dex */
    public interface Delegate {
        void fillCustomizedHeaders(Map<String, String> map);

        String transformUrl(String str);
    }

    /* loaded from: classes7.dex */
    public static class DelegateAdapter implements Delegate {
        @Override // com.alipay.plus.android.transport.proxy.HttpTransportProxy.Delegate
        public void fillCustomizedHeaders(Map<String, String> map) {
        }

        @Override // com.alipay.plus.android.transport.proxy.HttpTransportProxy.Delegate
        public String transformUrl(String str) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a<T> implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private Class<T> f7396a;
        private Delegate b;
        private AbstractHttpTransport c;
        public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {77, -56, -115, -110, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        public static final int BuiltInFictitiousFunctionClassFactory = 179;

        public a(Class<T> cls, AbstractHttpTransport abstractHttpTransport, Delegate delegate) {
            this.f7396a = cls;
            this.c = abstractHttpTransport;
            this.b = delegate;
        }

        private Object a(Method method, HttpRequest httpRequest) throws Exception {
            String name = method.getName();
            LoggerWrapper.i(HttpTransportProxy.f7395a, String.format("[%s] Request: %s", name, httpRequest.data));
            HttpResponse performRequest = this.c.performRequest(httpRequest);
            if (performRequest == null) {
                HttpError httpError = HttpError.ResponseIsNull;
                StringBuilder sb = new StringBuilder();
                sb.append("Network response is null! methodName = ");
                sb.append(name);
                throw com.alipay.plus.android.transport.b.a.a(httpError, sb.toString());
            } else if (performRequest.statusCode != 200) {
                LoggerWrapper.e(HttpTransportProxy.f7395a, String.format("Response error. url = %s, methodName = %s, statusCode = %s, statusMessage = %s", httpRequest.url, name, String.valueOf(performRequest.statusCode), performRequest.statusMessage));
                throw com.alipay.plus.android.transport.b.a.a(HttpError.StatusCodeNot200, String.format("statusCode = %s, statusMessage = %s", Integer.valueOf(performRequest.statusCode), performRequest.statusMessage));
            } else {
                Class<?> returnType = method.getReturnType();
                if (returnType == Void.class || returnType == Void.TYPE) {
                    return null;
                }
                if (performRequest.data == null || performRequest.data.length <= 0) {
                    LoggerWrapper.e(HttpTransportProxy.f7395a, String.format("Cannot parse response. url = %s, methodName  = %s, statusCode = %s, statusMessage = %s", httpRequest.url, name, String.valueOf(performRequest.statusCode), performRequest.statusMessage));
                    throw com.alipay.plus.android.transport.b.a.a(HttpError.ParseResponseFailed, String.format("statusCode = %s, statusMessage = %s", Integer.valueOf(performRequest.statusCode), performRequest.statusMessage));
                }
                String str = new String(performRequest.data);
                LoggerWrapper.i(HttpTransportProxy.f7395a, String.format("[%s] Response: %s", name, str));
                if (returnType == String.class) {
                    return str;
                }
                try {
                    return JSON.parseObject(str, returnType);
                } catch (Exception e) {
                    String str2 = HttpTransportProxy.f7395a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Parse response JSON failed, error = ");
                    sb2.append(e.getMessage());
                    LoggerWrapper.e(str2, sb2.toString());
                    throw com.alipay.plus.android.transport.b.a.a(HttpError.ParseResponseJsonFailed, e.getMessage());
                }
            }
        }

        private String a(Method method) throws Exception {
            String value = ((HttpReqUrl) method.getAnnotation(HttpReqUrl.class)).value();
            Delegate delegate = this.b;
            if (delegate != null) {
                value = delegate.transformUrl(value);
            }
            if (TextUtils.isEmpty(value)) {
                throw com.alipay.plus.android.transport.b.a.a(HttpError.UrlIsEmpty, "Facade HttpReqUrl can not be empty!");
            }
            return value;
        }

        private static HttpMethod b(Method method) {
            HttpReqMethod httpReqMethod = (HttpReqMethod) method.getAnnotation(HttpReqMethod.class);
            return httpReqMethod != null ? httpReqMethod.value() : HttpMethod.GET;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0038). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void d(short r7, int r8, short r9, java.lang.Object[] r10) {
            /*
                int r8 = r8 * 12
                int r8 = 16 - r8
                int r7 = r7 * 3
                int r7 = 16 - r7
                int r9 = r9 * 7
                int r9 = 106 - r9
                byte[] r0 = com.alipay.plus.android.transport.proxy.HttpTransportProxy.a.KClassImpl$Data$declaredNonStaticMembers$2
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L1b
                r9 = r8
                r3 = r1
                r5 = 0
                r8 = r7
                r1 = r0
                r0 = r10
                r10 = r9
                goto L38
            L1b:
                r3 = 0
                r6 = r9
                r9 = r8
                r8 = r6
            L1f:
                byte r4 = (byte) r8
                int r5 = r3 + 1
                r1[r3] = r4
                if (r5 != r7) goto L2e
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L2e:
                r3 = r0[r9]
                r6 = r8
                r8 = r7
                r7 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r6
            L38:
                int r7 = -r7
                int r9 = r9 + r7
                int r7 = r9 + 2
                int r9 = r10 + 1
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r5
                r6 = r8
                r8 = r7
                r7 = r6
                goto L1f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.plus.android.transport.proxy.HttpTransportProxy.a.d(short, int, short, java.lang.Object[]):void");
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            HashMap hashMap;
            Object obj2;
            String name = method.getName();
            if ("toString".equals(name)) {
                return String.format("%s-ProxyInstance", this.f7396a.getSimpleName());
            }
            if ("hashCode".equals(name)) {
                return Integer.valueOf(this.f7396a.getName().hashCode());
            }
            try {
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                byte b2 = b;
                Object[] objArr2 = new Object[1];
                d(b, b2, b2, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                byte b4 = b3;
                Object[] objArr3 = new Object[1];
                d(b3, b4, b4, objArr3);
                String str = null;
                Thread thread = (Thread) cls.getMethod((String) objArr3[0], null).invoke(null, null);
                LoggerWrapper.v(HttpTransportProxy.f7395a, String.format("[%s : %s] Call Http transport proxy: %s.%s", thread.getName(), String.valueOf(thread.getId()), this.f7396a.getSimpleName(), name));
                if (!method.isAnnotationPresent(HttpReqUrl.class)) {
                    HttpError httpError = HttpError.NoHttpReqUrlAnnotation;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Facade need HttpReqUrl annotation! methodName = ");
                    sb.append(name);
                    throw com.alipay.plus.android.transport.b.a.a(httpError, sb.toString());
                }
                String a2 = a(method);
                LoggerWrapper.d(HttpTransportProxy.f7395a, String.format("[%s] Request Url: %s", name, a2));
                HttpMethod b5 = b(method);
                LoggerWrapper.d(HttpTransportProxy.f7395a, String.format("[%s] Request Method: %s", name, b5.method));
                if (this.b != null) {
                    hashMap = new HashMap();
                    this.b.fillCustomizedHeaders(hashMap);
                } else {
                    hashMap = null;
                }
                if (objArr != null && objArr.length > 0 && (obj2 = objArr[0]) != null) {
                    str = JSON.toJSONString(obj2);
                }
                return a(method, new HttpRequest(a2, b5, hashMap, str));
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
    }

    public static <T> T getInterfaceProxy(Class<T> cls) {
        return (T) getInterfaceProxy(cls, b);
    }

    public static <T> T getInterfaceProxy(Class<T> cls, Delegate delegate) {
        return (T) getInterfaceProxy(cls, b, delegate);
    }

    public static <T> T getInterfaceProxy(Class<T> cls, AbstractHttpTransport abstractHttpTransport) {
        return (T) getInterfaceProxy(cls, abstractHttpTransport, null);
    }

    public static <T> T getInterfaceProxy(Class<T> cls, AbstractHttpTransport abstractHttpTransport, Delegate delegate) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls, abstractHttpTransport, delegate));
    }
}
