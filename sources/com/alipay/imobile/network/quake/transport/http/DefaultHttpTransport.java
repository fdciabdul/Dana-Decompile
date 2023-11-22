package com.alipay.imobile.network.quake.transport.http;

import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.Quake;
import com.alipay.imobile.network.quake.Request;
import com.alipay.imobile.network.quake.ext.proxy.OkHttpProxy;
import com.alipay.imobile.network.quake.transport.TransporterCallBack;
import com.alipay.imobile.network.tls.TlsSupportSocketFactory;
import com.alipay.mobile.common.rpc.RpcException;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes3.dex */
public class DefaultHttpTransport extends AbstractHttpTransport {
    private AbstractHttpTransport g;

    public DefaultHttpTransport() {
        try {
            this.g = new OkHttpProxy(true);
            LoggerWrapper.d(Quake.TAG, "use okhttp proxy");
        } catch (ClassNotFoundException unused) {
            this.g = new UrlTransport(null, TlsSupportSocketFactory.createDefaultPatchSSLSocketFactory());
            LoggerWrapper.d(Quake.TAG, "use UrlTransport");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.imobile.network.quake.transport.http.AbstractHttpTransport
    public HttpResponse performRequest(Request request, Map<String, String> map) throws IOException, RpcException {
        return this.g.performRequest(request, map);
    }

    @Override // com.alipay.imobile.network.quake.transport.http.AbstractHttpTransport
    public void setUserAgent(String str) {
        this.g.setUserAgent(str);
    }

    @Override // com.alipay.imobile.network.quake.transport.http.AbstractHttpTransport, com.alipay.imobile.network.quake.transport.Transporter
    public void submitRequest(Request request, TransporterCallBack transporterCallBack) {
        this.g.submitRequest(request, transporterCallBack);
    }
}
