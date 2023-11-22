package com.huawei.secure.android.common.ssl;

import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes8.dex */
public class SecureSSLSocketFactoryNew extends SSLSocketFactory {
    private static final String getErrorConfigVersion = "SecureSSLSocketFactoryNew";
    protected SSLContext BuiltInFictitiousFunctionClassFactory;
    protected X509TrustManager KClassImpl$Data$declaredNonStaticMembers$2;
    protected String[] MyBillsEntityDataFactory;
    protected SSLSocket PlaceComponentResult = null;
    protected String[] getAuthRequestContext;
    protected String[] moveToNextValue;
    protected String[] scheduleImpl;

    private void KClassImpl$Data$declaredNonStaticMembers$2(Socket socket) {
        boolean z;
        boolean z2 = false;
        if (com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.scheduleImpl)) {
            z = false;
        } else {
            g.KClassImpl$Data$declaredNonStaticMembers$2(getErrorConfigVersion, "set protocols");
            SSLUtil.MyBillsEntityDataFactory((SSLSocket) socket, this.scheduleImpl);
            z = true;
        }
        if (!com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.moveToNextValue) || !com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.getAuthRequestContext)) {
            g.KClassImpl$Data$declaredNonStaticMembers$2(getErrorConfigVersion, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.MyBillsEntityDataFactory(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.moveToNextValue)) {
                SSLUtil.PlaceComponentResult(sSLSocket, this.moveToNextValue);
            } else {
                SSLUtil.KClassImpl$Data$declaredNonStaticMembers$2(sSLSocket, this.getAuthRequestContext);
            }
            z2 = true;
        }
        if (!z) {
            g.KClassImpl$Data$declaredNonStaticMembers$2(getErrorConfigVersion, "set default protocols");
            SSLUtil.MyBillsEntityDataFactory((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        g.KClassImpl$Data$declaredNonStaticMembers$2(getErrorConfigVersion, "set default cipher suites");
        SSLUtil.BuiltInFictitiousFunctionClassFactory((SSLSocket) socket);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        g.KClassImpl$Data$declaredNonStaticMembers$2(getErrorConfigVersion, "createSocket: host , port");
        Socket createSocket = this.BuiltInFictitiousFunctionClassFactory.getSocketFactory().createSocket(str, i);
        if (createSocket instanceof SSLSocket) {
            KClassImpl$Data$declaredNonStaticMembers$2(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.PlaceComponentResult = sSLSocket;
            this.MyBillsEntityDataFactory = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.MyBillsEntityDataFactory;
        return strArr != null ? strArr : new String[0];
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
        g.KClassImpl$Data$declaredNonStaticMembers$2(getErrorConfigVersion, "createSocket s host port autoClose");
        Socket createSocket = this.BuiltInFictitiousFunctionClassFactory.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket instanceof SSLSocket) {
            KClassImpl$Data$declaredNonStaticMembers$2(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.PlaceComponentResult = sSLSocket;
            this.MyBillsEntityDataFactory = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public SecureSSLSocketFactoryNew(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.BuiltInFictitiousFunctionClassFactory = null;
        SSLContext authRequestContext = SSLUtil.getAuthRequestContext();
        this.BuiltInFictitiousFunctionClassFactory = authRequestContext;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = x509TrustManager;
        authRequestContext.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }
}
