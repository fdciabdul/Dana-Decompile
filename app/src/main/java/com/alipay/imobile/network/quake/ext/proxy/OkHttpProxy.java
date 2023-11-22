package com.alipay.imobile.network.quake.ext.proxy;

import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.Quake;
import com.alipay.imobile.network.quake.Request;
import com.alipay.imobile.network.quake.f;
import com.alipay.imobile.network.quake.transport.Transporter;
import com.alipay.imobile.network.quake.transport.TransporterCallBack;
import com.alipay.imobile.network.quake.transport.http.AbstractHttpTransport;
import com.alipay.imobile.network.quake.transport.http.CookieJar;
import com.alipay.imobile.network.quake.transport.http.HttpResponse;
import com.alipay.mobile.common.rpc.RpcException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* loaded from: classes3.dex */
public class OkHttpProxy extends AbstractHttpTransport {
    private static Class<?> h;
    private static Class<?> i;
    private static Class<?> j;
    private static Class<?> k;
    private Transporter g;

    static {
        try {
            h = com.alipay.imobile.network.quake.util.a.a("okhttp3.internal.huc.HttpURLConnectionImpl");
            i = com.alipay.imobile.network.quake.util.a.a("okhttp3.OkHttpClient");
            j = com.alipay.imobile.network.quake.util.a.a("okio.Source");
            k = com.alipay.imobile.network.quake.util.a.a("com.alipay.imobile.network.quake.ext.okhttp.OkhttpBridge");
        } catch (Exception e) {
            LoggerWrapper.e(Quake.TAG, "could not find okhttp dependence", e);
        }
    }

    public OkHttpProxy(boolean z) throws ClassNotFoundException {
        this(f.o().d().getCookieJar(), z, 5);
    }

    @Override // com.alipay.imobile.network.quake.transport.http.AbstractHttpTransport
    public HttpResponse performRequest(Request request, Map<String, String> map) throws IOException, RpcException {
        return null;
    }

    @Override // com.alipay.imobile.network.quake.transport.http.AbstractHttpTransport, com.alipay.imobile.network.quake.transport.Transporter
    public void submitRequest(Request request, TransporterCallBack transporterCallBack) {
        Transporter transporter = this.g;
        if (transporter != null) {
            transporter.submitRequest(request, transporterCallBack);
        }
    }

    public OkHttpProxy(boolean z, int i2) throws ClassNotFoundException {
        this(f.o().d().getCookieJar(), z, i2);
    }

    public OkHttpProxy(CookieJar cookieJar, boolean z) throws ClassNotFoundException {
        this(cookieJar, z, 5);
    }

    public OkHttpProxy(CookieJar cookieJar, boolean z, int i2) throws ClassNotFoundException {
        if (h != null) {
            if (i != null) {
                if (j != null) {
                    Class<?> cls = k;
                    if (cls != null) {
                        try {
                            this.g = (AbstractHttpTransport) cls.getConstructor(CookieJar.class, Boolean.TYPE).newInstance(cookieJar, Boolean.valueOf(z));
                            return;
                        } catch (IllegalAccessException e) {
                            LoggerWrapper.e(Quake.TAG, "", e);
                            throw new ClassNotFoundException("could not find dependence of quake-okhttp");
                        } catch (InstantiationException e2) {
                            LoggerWrapper.e(Quake.TAG, "", e2);
                            throw new ClassNotFoundException("could not find dependence of quake-okhttp");
                        } catch (NoSuchMethodException e3) {
                            LoggerWrapper.e(Quake.TAG, "", e3);
                            throw new ClassNotFoundException("could not find dependence of quake-okhttp");
                        } catch (InvocationTargetException e4) {
                            LoggerWrapper.e(Quake.TAG, "", e4);
                            throw new ClassNotFoundException("could not find dependence of quake-okhttp");
                        }
                    }
                    throw new ClassNotFoundException("could not find dependence of quake-okhttp");
                }
                throw new ClassNotFoundException("could not find dependence of okio v1.6.0+");
            }
            throw new ClassNotFoundException("could not find dependence of okhttp v3.2.0+");
        }
        throw new ClassNotFoundException("could not find dependence of okhttp urlconnection v3.2.0+");
    }
}
