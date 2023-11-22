package com.huawei.secure.android.common;

import com.huawei.secure.android.common.ssl.SSLUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

@Deprecated
/* loaded from: classes8.dex */
public class SecureSSLSocketFactory extends SSLSocketFactory {
    public static final X509HostnameVerifier BuiltInFictitiousFunctionClassFactory = new BrowserCompatHostnameVerifier();
    public static final X509HostnameVerifier MyBillsEntityDataFactory = new StrictHostnameVerifier();
    private static volatile SecureSSLSocketFactory getAuthRequestContext = null;
    private SSLContext PlaceComponentResult;

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        Socket createSocket = this.PlaceComponentResult.getSocketFactory().createSocket(str, i);
        if (createSocket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            SSLUtil.MyBillsEntityDataFactory(sSLSocket);
            SSLUtil.BuiltInFictitiousFunctionClassFactory(sSLSocket);
        }
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return createSocket(str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket createSocket = this.PlaceComponentResult.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            SSLUtil.MyBillsEntityDataFactory(sSLSocket);
            SSLUtil.BuiltInFictitiousFunctionClassFactory(sSLSocket);
        }
        return createSocket;
    }
}
