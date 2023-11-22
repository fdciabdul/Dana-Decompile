package com.alipay.imobile.network.quake;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.cache.Cache;
import com.alipay.imobile.network.quake.exception.ClientException;
import com.alipay.imobile.network.quake.exception.ReinitializationException;
import com.alipay.imobile.network.quake.protocol.Protocol;
import com.alipay.imobile.network.quake.request.RequestInterceptor;
import com.alipay.imobile.network.quake.transport.Transporter;
import com.alipay.imobile.network.quake.util.SignUtil;
import com.alipay.imobile.network.sslpinning.api.ISSLPinningManager;
import com.alipay.mobile.common.rpc.RpcException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class Quake implements IQuake {
    public static String TAG = "Quake";
    private static IQuake f;

    /* renamed from: a  reason: collision with root package name */
    private g f7027a;
    private f b;
    private Context c;
    private List<RequestInterceptor> d = new LinkedList();
    private ISSLPinningManager e;

    private Quake(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.c = applicationContext;
            LoggerWrapper.init(applicationContext);
            this.b = f.a(this.c);
            SignUtil.a();
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(this.c);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Context param must not be null.");
    }

    private void a() {
        if (this.f7027a == null) {
            f fVar = this.b;
            g gVar = new g(fVar, fVar.d().getConcurrentRequestNumber());
            this.f7027a = gVar;
            gVar.b();
        }
    }

    public static IQuake createInstance(Context context) {
        IQuake iQuake;
        synchronized (Quake.class) {
            if (f == null) {
                f = new Quake(context);
            }
            iQuake = f;
        }
        return iQuake;
    }

    public static IQuake instance() throws RpcException {
        IQuake iQuake;
        synchronized (Quake.class) {
            iQuake = f;
            if (iQuake == null) {
                throw new RpcException((Integer) 9, "IQuake has not been initialized by createInstance(Context).");
            }
        }
        return iQuake;
    }

    public static void setLogTag(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TAG = str;
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public Request addRequest(Request request) {
        synchronized (this) {
            if (request == null) {
                return null;
            }
            if (this.f7027a == null) {
                a();
            }
            Iterator<RequestInterceptor> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().beforeSendRequest(request);
            }
            this.f7027a.b(request);
            return request;
        }
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public void addRequestInterceptor(RequestInterceptor requestInterceptor) {
        if (requestInterceptor != null) {
            this.d.add(requestInterceptor);
        }
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public void cancelRequest(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            g gVar = this.f7027a;
            if (gVar == null) {
                return;
            }
            gVar.a(str);
        }
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public void config(QuakeConfig quakeConfig) throws ReinitializationException {
        synchronized (this) {
            this.b.a(quakeConfig);
        }
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public Cache getCache(String str) {
        Cache a2;
        synchronized (this) {
            try {
                a2 = this.b.a(str);
            } catch (ClientException unused) {
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("can not resolve the cache with the name=");
                sb.append(str);
                LoggerWrapper.d(str2, sb.toString());
                return null;
            }
        }
        return a2;
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public QuakeConfig getConfig() {
        QuakeConfig d;
        synchronized (this) {
            d = this.b.d();
        }
        return d;
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public Context getContext() {
        return this.c;
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public String getDefaultCacheName() {
        String f2;
        synchronized (this) {
            f2 = this.b.f();
        }
        return f2;
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public String getDefaultProtocolName() {
        String g;
        synchronized (this) {
            g = this.b.g();
        }
        return g;
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public String getDefaultTransportName() {
        String h;
        synchronized (this) {
            h = this.b.h();
        }
        return h;
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public Protocol getProtocol(String str) {
        Protocol b;
        synchronized (this) {
            try {
                b = this.b.b(str);
            } catch (ClientException unused) {
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("can not resolve the protocol with the name=");
                sb.append(str);
                LoggerWrapper.d(str2, sb.toString());
                return null;
            }
        }
        return b;
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public List<RequestInterceptor> getRequestInterceptors() {
        return this.d;
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public ISSLPinningManager getSSLPinningManager() {
        return this.e;
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public Transporter getTransport(String str) {
        Transporter c;
        synchronized (this) {
            try {
                c = this.b.c(str);
            } catch (ClientException unused) {
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("can not resolve the transport with the name=");
                sb.append(str);
                LoggerWrapper.d(str2, sb.toString());
                return null;
            }
        }
        return c;
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public void registerCache(String str, Cache cache) throws ReinitializationException {
        synchronized (this) {
            String str2 = TAG;
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = cache == null ? null : cache.getClass().getName();
            LoggerWrapper.d(str2, LoggerWrapper.buildMessage("register cache with the name=%s, and class=%s", objArr));
            this.b.a(str, cache);
        }
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public void registerProtocol(String str, Protocol<?> protocol) throws ReinitializationException {
        synchronized (this) {
            String str2 = TAG;
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = protocol == null ? null : protocol.getClass().getName();
            LoggerWrapper.d(str2, LoggerWrapper.buildMessage("register protocol with the name=%s, and class=%s", objArr));
            this.b.a(str, protocol);
        }
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public void registerTransport(String str, Transporter transporter) throws ReinitializationException {
        synchronized (this) {
            String str2 = TAG;
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = transporter == null ? null : transporter.getClass().getName();
            LoggerWrapper.d(str2, LoggerWrapper.buildMessage("register transporter with the name=%s, and class=%s", objArr));
            this.b.a(str, transporter);
        }
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public void release() {
        synchronized (this) {
            if (f == null) {
                return;
            }
            f = null;
            LoggerWrapper.d(TAG, "release Quake resource");
            this.c = null;
            g gVar = this.f7027a;
            if (gVar != null) {
                gVar.c();
                this.f7027a = null;
            }
            f fVar = this.b;
            if (fVar != null) {
                fVar.m();
                this.b = null;
            }
        }
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public void removeRequestInterceptor(RequestInterceptor requestInterceptor) {
        this.d.remove(requestInterceptor);
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public void setDefaultCacheName(String str) throws ReinitializationException {
        synchronized (this) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("specify the default cache name: ");
            sb.append(str);
            LoggerWrapper.d(str2, sb.toString());
            this.b.d(str);
        }
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public void setDefaultProtocolName(String str) throws ReinitializationException {
        synchronized (this) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("specify the default request protocol name: ");
            sb.append(str);
            LoggerWrapper.d(str2, sb.toString());
            this.b.e(str);
        }
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public void setDefaultTransportName(String str) throws ReinitializationException {
        synchronized (this) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("specify the default transport name: ");
            sb.append(str);
            LoggerWrapper.d(str2, sb.toString());
            this.b.f(str);
        }
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public void setDefaultUserAgent(String str) {
        synchronized (this) {
            com.alipay.imobile.network.quake.transport.strategy.a.c(str);
        }
    }

    @Override // com.alipay.imobile.network.quake.IQuake
    public void setSSLPinningManager(ISSLPinningManager iSSLPinningManager) {
        this.e = iSSLPinningManager;
    }
}
