package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

@Deprecated
/* loaded from: classes8.dex */
public class SecureSSLSocketFactory extends SSLSocketFactory {
    @Deprecated
    public static final X509HostnameVerifier BuiltInFictitiousFunctionClassFactory = new BrowserCompatHostnameVerifier();
    @Deprecated
    public static final X509HostnameVerifier KClassImpl$Data$declaredNonStaticMembers$2 = new StrictHostnameVerifier();
    private static final String MyBillsEntityDataFactory = "SecureSSLSocketFactory";
    private static volatile SecureSSLSocketFactory PlaceComponentResult = null;
    private String[] GetContactSyncConfig;
    private SSLSocket NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    private SSLContext getAuthRequestContext;
    private String[] getErrorConfigVersion;
    private String[] initRecordTimeStamp;
    private Context lookAheadTest;
    private String[] moveToNextValue;
    private X509TrustManager scheduleImpl;

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        g.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, "createSocket: host , port");
        Socket createSocket = this.getAuthRequestContext.getSocketFactory().createSocket(str, i);
        if (createSocket instanceof SSLSocket) {
            getAuthRequestContext(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = sSLSocket;
            this.moveToNextValue = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.moveToNextValue;
        return strArr != null ? strArr : new String[0];
    }

    public static SecureSSLSocketFactory PlaceComponentResult(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        com.huawei.secure.android.common.ssl.util.c.getAuthRequestContext(context);
        if (PlaceComponentResult == null) {
            synchronized (SecureSSLSocketFactory.class) {
                if (PlaceComponentResult == null) {
                    PlaceComponentResult = new SecureSSLSocketFactory(context);
                }
            }
        }
        if (PlaceComponentResult.lookAheadTest == null && context != null) {
            PlaceComponentResult.lookAheadTest = context.getApplicationContext();
        }
        g.PlaceComponentResult();
        return PlaceComponentResult;
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
        g.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, "createSocket s host port autoClose");
        Socket createSocket = this.getAuthRequestContext.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket instanceof SSLSocket) {
            getAuthRequestContext(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = sSLSocket;
            this.moveToNextValue = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    private void getAuthRequestContext(Socket socket) {
        boolean z;
        boolean z2 = false;
        if (com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.GetContactSyncConfig)) {
            z = false;
        } else {
            g.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, "set protocols");
            SSLUtil.MyBillsEntityDataFactory((SSLSocket) socket, this.GetContactSyncConfig);
            z = true;
        }
        if (!com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.initRecordTimeStamp) || !com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.getErrorConfigVersion)) {
            g.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.MyBillsEntityDataFactory(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.initRecordTimeStamp)) {
                SSLUtil.PlaceComponentResult(sSLSocket, this.initRecordTimeStamp);
            } else {
                SSLUtil.KClassImpl$Data$declaredNonStaticMembers$2(sSLSocket, this.getErrorConfigVersion);
            }
            z2 = true;
        }
        if (!z) {
            g.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, "set default protocols");
            SSLUtil.MyBillsEntityDataFactory((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        g.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, "set default cipher suites");
        SSLUtil.BuiltInFictitiousFunctionClassFactory((SSLSocket) socket);
    }

    private SecureSSLSocketFactory(Context context) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.getAuthRequestContext = null;
        if (context == null) {
            g.getAuthRequestContext(MyBillsEntityDataFactory, "SecureSSLSocketFactory: context is null");
            return;
        }
        this.lookAheadTest = context.getApplicationContext();
        this.getAuthRequestContext = SSLUtil.getAuthRequestContext();
        SecureX509TrustManager BuiltInFictitiousFunctionClassFactory2 = SecureX509SingleInstance.BuiltInFictitiousFunctionClassFactory(context);
        this.scheduleImpl = BuiltInFictitiousFunctionClassFactory2;
        this.getAuthRequestContext.init(null, new X509TrustManager[]{BuiltInFictitiousFunctionClassFactory2}, null);
    }
}
