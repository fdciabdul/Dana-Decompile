package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* loaded from: classes8.dex */
public class SecureApacheSSLSocketFactory extends SSLSocketFactory {
    Context MyBillsEntityDataFactory;
    private String[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    private String[] NetworkUserEntityData$$ExternalSyntheticLambda2;
    private SSLContext getErrorConfigVersion;
    private SSLSocket lookAheadTest;
    private String[] moveToNextValue;
    private String[] scheduleImpl;
    public static final X509HostnameVerifier KClassImpl$Data$declaredNonStaticMembers$2 = new BrowserCompatHostnameVerifier();
    public static final X509HostnameVerifier getAuthRequestContext = new StrictHostnameVerifier();
    private static final String PlaceComponentResult = "SecureApacheSSLSocketFactory";
    private static volatile SecureApacheSSLSocketFactory BuiltInFictitiousFunctionClassFactory = null;

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        g.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, "createSocket: socket host port autoClose");
        Socket createSocket = this.getErrorConfigVersion.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket instanceof SSLSocket) {
            BuiltInFictitiousFunctionClassFactory(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.lookAheadTest = sSLSocket;
            this.scheduleImpl = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        g.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, "createSocket: ");
        Socket createSocket = this.getErrorConfigVersion.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            BuiltInFictitiousFunctionClassFactory(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.lookAheadTest = sSLSocket;
            this.scheduleImpl = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    private void BuiltInFictitiousFunctionClassFactory(Socket socket) {
        boolean z;
        boolean z2 = false;
        if (com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
            z = false;
        } else {
            g.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, "set protocols");
            SSLUtil.MyBillsEntityDataFactory((SSLSocket) socket, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            z = true;
        }
        if (!com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0) || !com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.moveToNextValue)) {
            g.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.MyBillsEntityDataFactory(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                SSLUtil.PlaceComponentResult(sSLSocket, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            } else {
                SSLUtil.KClassImpl$Data$declaredNonStaticMembers$2(sSLSocket, this.moveToNextValue);
            }
            z2 = true;
        }
        if (!z) {
            g.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, "set default protocols");
            SSLUtil.MyBillsEntityDataFactory((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        g.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, "set default cipher suites");
        SSLUtil.BuiltInFictitiousFunctionClassFactory((SSLSocket) socket);
    }
}
