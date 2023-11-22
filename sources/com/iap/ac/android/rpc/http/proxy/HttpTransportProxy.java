package com.iap.ac.android.rpc.http.proxy;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.http.HttpTransportFactory;
import com.iap.ac.android.common.rpc.interfaces.AbstractHttpTransport;
import com.iap.ac.android.common.rpc.model.HttpMethod;
import com.iap.ac.android.common.rpc.model.HttpRequest;
import com.iap.ac.android.common.rpc.model.HttpResponse;
import com.iap.ac.android.rpc.http.error.HttpError;
import com.iap.ac.android.rpc.http.utils.HttpTransportUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class HttpTransportProxy {
    public static final String TAG = HttpTransportUtils.logTag("HttpTransportProxy");
    public static AbstractHttpTransport mDefaultHttpTransport;

    /* loaded from: classes8.dex */
    public interface Delegate {
        void fillCustomizedHeaders(Map<String, String> map);

        String transformUrl(String str);
    }

    /* loaded from: classes8.dex */
    public static class DelegateAdapter implements Delegate {
        @Override // com.iap.ac.android.rpc.http.proxy.HttpTransportProxy.Delegate
        public void fillCustomizedHeaders(Map<String, String> map) {
        }

        @Override // com.iap.ac.android.rpc.http.proxy.HttpTransportProxy.Delegate
        public String transformUrl(String str) {
            return str;
        }
    }

    /* loaded from: classes8.dex */
    public static class ProxyInvocationHandler<T> implements InvocationHandler {
        public static final byte[] BuiltInFictitiousFunctionClassFactory = {1, 78, 11, -6, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        public static final int PlaceComponentResult = 144;
        public Delegate mDelegate;
        public Class<T> mFacadeClass;
        public AbstractHttpTransport mHttpTransport;

        public ProxyInvocationHandler(Class<T> cls, AbstractHttpTransport abstractHttpTransport, Delegate delegate) {
            this.mFacadeClass = cls;
            this.mHttpTransport = abstractHttpTransport;
            this.mDelegate = delegate;
        }

        private static void a(byte b, byte b2, byte b3, Object[] objArr) {
            int i = b2 + 4;
            int i2 = (b3 * 3) + 13;
            int i3 = 106 - (b * 7);
            byte[] bArr = BuiltInFictitiousFunctionClassFactory;
            byte[] bArr2 = new byte[i2];
            int i4 = -1;
            int i5 = i2 - 1;
            if (bArr == null) {
                i3 = i3 + (-i) + 2;
                i = i;
                i5 = i5;
                objArr = objArr;
                bArr = bArr;
                bArr2 = bArr2;
                i4 = -1;
            }
            while (true) {
                int i6 = i4 + 1;
                bArr2[i6] = (byte) i3;
                int i7 = i + 1;
                if (i6 == i5) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                i3 = i3 + (-bArr[i7]) + 2;
                i = i7;
                i5 = i5;
                objArr = objArr;
                bArr = bArr;
                bArr2 = bArr2;
                i4 = i6;
            }
        }

        private Object performRequestInternal(Method method, HttpRequest httpRequest) throws Exception {
            String name = method.getName();
            ACLog.i(HttpTransportProxy.TAG, String.format("[%s] Request: %s", name, httpRequest.data));
            HttpResponse performRequest = this.mHttpTransport.performRequest(httpRequest);
            if (performRequest != null) {
                if (performRequest.statusCode == 200) {
                    Class<?> returnType = method.getReturnType();
                    if (returnType == Void.class || returnType == Void.TYPE) {
                        return null;
                    }
                    byte[] bArr = performRequest.data;
                    if (bArr != null && bArr.length > 0) {
                        String str = new String(bArr);
                        ACLog.i(HttpTransportProxy.TAG, String.format("[%s] Response: %s", name, str));
                        if (returnType == String.class) {
                            return str;
                        }
                        try {
                            return JsonUtils.fromJson(str, (Class) returnType);
                        } catch (Exception e) {
                            String str2 = HttpTransportProxy.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Parse response JSON failed, error = ");
                            sb.append(e.getMessage());
                            ACLog.e(str2, sb.toString());
                            throw HttpTransportUtils.createException(HttpError.ParseResponseJsonFailed, e.getMessage());
                        }
                    }
                    ACLog.e(HttpTransportProxy.TAG, String.format("Cannot parse response. url = %s, methodName  = %s, statusCode = %s, statusMessage = %s", httpRequest.url, name, String.valueOf(performRequest.statusCode), performRequest.statusMessage));
                    throw HttpTransportUtils.createException(HttpError.ParseResponseFailed, String.format("statusCode = %s, statusMessage = %s", Integer.valueOf(performRequest.statusCode), performRequest.statusMessage));
                }
                ACLog.e(HttpTransportProxy.TAG, String.format("Response error. url = %s, methodName = %s, statusCode = %s, statusMessage = %s", httpRequest.url, name, String.valueOf(performRequest.statusCode), performRequest.statusMessage));
                throw HttpTransportUtils.createException(String.valueOf(performRequest.statusCode), performRequest.statusMessage);
            }
            HttpError httpError = HttpError.ResponseIsNull;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Network response is null! methodName = ");
            sb2.append(name);
            throw HttpTransportUtils.createException(httpError, sb2.toString());
        }

        public static HttpMethod retrieveRequestMethod(Method method) {
            HttpReqMethod httpReqMethod = (HttpReqMethod) method.getAnnotation(HttpReqMethod.class);
            if (httpReqMethod != null) {
                return httpReqMethod.value();
            }
            return HttpMethod.GET;
        }

        private String retrieveRequestUrl(Method method) throws Exception {
            String value = ((HttpReqUrl) method.getAnnotation(HttpReqUrl.class)).value();
            Delegate delegate = this.mDelegate;
            if (delegate != null) {
                value = delegate.transformUrl(value);
            }
            if (TextUtils.isEmpty(value)) {
                throw HttpTransportUtils.createException(HttpError.UrlIsEmpty, "Facade HttpReqUrl can not be empty!");
            }
            return value;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            HashMap hashMap;
            Object obj2;
            String name = method.getName();
            if ("toString".equals(name)) {
                return String.format("%s-ProxyInstance", this.mFacadeClass.getSimpleName());
            }
            if ("hashCode".equals(name)) {
                return Integer.valueOf(this.mFacadeClass.getName().hashCode());
            }
            try {
                Object[] objArr2 = new Object[1];
                a((byte) (BuiltInFictitiousFunctionClassFactory[0] - 1), BuiltInFictitiousFunctionClassFactory[2], BuiltInFictitiousFunctionClassFactory[0], objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b = BuiltInFictitiousFunctionClassFactory[0];
                byte b2 = BuiltInFictitiousFunctionClassFactory[15];
                Object[] objArr3 = new Object[1];
                a(b, b2, (byte) (b2 + 1), objArr3);
                String str = null;
                Thread thread = (Thread) cls.getMethod((String) objArr3[0], null).invoke(null, null);
                ACLog.v(HttpTransportProxy.TAG, String.format("[%s : %s] Call Http transport proxy: %s.%s", thread.getName(), String.valueOf(thread.getId()), this.mFacadeClass.getSimpleName(), name));
                if (method.isAnnotationPresent(HttpReqUrl.class)) {
                    String retrieveRequestUrl = retrieveRequestUrl(method);
                    ACLog.d(HttpTransportProxy.TAG, String.format("[%s] Request Url: %s", name, retrieveRequestUrl));
                    HttpMethod retrieveRequestMethod = retrieveRequestMethod(method);
                    ACLog.d(HttpTransportProxy.TAG, String.format("[%s] Request Method: %s", name, retrieveRequestMethod.method));
                    if (this.mDelegate != null) {
                        hashMap = new HashMap();
                        this.mDelegate.fillCustomizedHeaders(hashMap);
                    } else {
                        hashMap = null;
                    }
                    if (objArr != null && objArr.length > 0 && (obj2 = objArr[0]) != null) {
                        str = JsonUtils.toJson(obj2);
                    }
                    return performRequestInternal(method, new HttpRequest(retrieveRequestUrl, retrieveRequestMethod, hashMap, str));
                }
                HttpError httpError = HttpError.NoHttpReqUrlAnnotation;
                StringBuilder sb = new StringBuilder();
                sb.append("Facade need HttpReqUrl annotation! methodName = ");
                sb.append(name);
                throw HttpTransportUtils.createException(httpError, sb.toString());
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
    }

    public HttpTransportProxy(Context context) {
        try {
            mDefaultHttpTransport = HttpTransportFactory.createHttpTransport(context);
        } catch (Exception e) {
            ACLog.e(TAG, "", e);
        }
    }

    public static <T> T getInterfaceProxy(Class<T> cls) {
        return (T) getInterfaceProxy(cls, mDefaultHttpTransport);
    }

    public static <T> T getInterfaceProxy(Class<T> cls, AbstractHttpTransport abstractHttpTransport) {
        return (T) getInterfaceProxy(cls, abstractHttpTransport, null);
    }

    public static <T> T getInterfaceProxy(Class<T> cls, AbstractHttpTransport abstractHttpTransport, Delegate delegate) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new ProxyInvocationHandler(cls, abstractHttpTransport, delegate));
    }

    public static <T> T getInterfaceProxy(Class<T> cls, Delegate delegate) {
        return (T) getInterfaceProxy(cls, mDefaultHttpTransport, delegate);
    }
}
