package com.huawei.secure.android.common.ssl;

import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes8.dex */
public class SSFCompatiableSystemCA extends SSLSocketFactory {
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = "SSFCompatiableSystemCA";
    private String[] BuiltInFictitiousFunctionClassFactory;
    private SSLSocket MyBillsEntityDataFactory;
    private String[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    private String[] PlaceComponentResult;
    private SSLContext getAuthRequestContext;
    private String[] moveToNextValue;

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        g.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "createSocket: host , port");
        Socket createSocket = this.getAuthRequestContext.getSocketFactory().createSocket(str, i);
        if (createSocket instanceof SSLSocket) {
            PlaceComponentResult(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.MyBillsEntityDataFactory = sSLSocket;
            this.BuiltInFictitiousFunctionClassFactory = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.BuiltInFictitiousFunctionClassFactory;
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
        g.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "createSocket: s , host , port , autoClose");
        Socket createSocket = this.getAuthRequestContext.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket instanceof SSLSocket) {
            PlaceComponentResult(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.MyBillsEntityDataFactory = sSLSocket;
            this.BuiltInFictitiousFunctionClassFactory = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    private void PlaceComponentResult(Socket socket) {
        boolean z;
        boolean z2 = false;
        if (com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.moveToNextValue)) {
            z = false;
        } else {
            g.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "set protocols");
            SSLUtil.MyBillsEntityDataFactory((SSLSocket) socket, this.moveToNextValue);
            z = true;
        }
        if (!com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0) || !com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.PlaceComponentResult)) {
            g.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.MyBillsEntityDataFactory(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                SSLUtil.PlaceComponentResult(sSLSocket, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            } else {
                SSLUtil.KClassImpl$Data$declaredNonStaticMembers$2(sSLSocket, this.PlaceComponentResult);
            }
            z2 = true;
        }
        if (!z) {
            g.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "set default protocols");
            SSLUtil.MyBillsEntityDataFactory((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        g.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "set default cipher suites");
        SSLUtil.BuiltInFictitiousFunctionClassFactory((SSLSocket) socket);
    }
}
