package com.huawei.secure.android.common;

import com.huawei.secure.android.common.ssl.SSLUtil;
import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

@Deprecated
/* loaded from: classes8.dex */
public class SecureApacheSSLSocketFactory extends SSLSocketFactory {
    private SSLContext KClassImpl$Data$declaredNonStaticMembers$2;
    public static final X509HostnameVerifier MyBillsEntityDataFactory = new BrowserCompatHostnameVerifier();
    public static final X509HostnameVerifier PlaceComponentResult = new StrictHostnameVerifier();
    private static volatile SecureApacheSSLSocketFactory BuiltInFictitiousFunctionClassFactory = null;

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket createSocket = this.KClassImpl$Data$declaredNonStaticMembers$2.getSocketFactory().createSocket(socket, str, i, z);
        SSLSocket sSLSocket = (SSLSocket) createSocket;
        SSLUtil.MyBillsEntityDataFactory(sSLSocket);
        SSLUtil.BuiltInFictitiousFunctionClassFactory(sSLSocket);
        return createSocket;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        Socket createSocket = this.KClassImpl$Data$declaredNonStaticMembers$2.getSocketFactory().createSocket();
        SSLSocket sSLSocket = (SSLSocket) createSocket;
        SSLUtil.MyBillsEntityDataFactory(sSLSocket);
        SSLUtil.BuiltInFictitiousFunctionClassFactory(sSLSocket);
        return createSocket;
    }
}
