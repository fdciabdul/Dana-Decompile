package com.huawei.secure.android.common.ssl;

import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* loaded from: classes8.dex */
public class SASFCompatiableSystemCA extends SSLSocketFactory {
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = "SASFCompatiableSystemCA";
    private SSLContext BuiltInFictitiousFunctionClassFactory;
    private SSLSocket MyBillsEntityDataFactory;
    private String[] PlaceComponentResult;
    private String[] getAuthRequestContext;
    private String[] lookAheadTest;
    private String[] scheduleImpl;

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        g.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "createSocket: socket host port autoClose");
        Socket createSocket = this.BuiltInFictitiousFunctionClassFactory.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket instanceof SSLSocket) {
            MyBillsEntityDataFactory(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.MyBillsEntityDataFactory = sSLSocket;
            this.getAuthRequestContext = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        g.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "createSocket: ");
        Socket createSocket = this.BuiltInFictitiousFunctionClassFactory.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            MyBillsEntityDataFactory(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.MyBillsEntityDataFactory = sSLSocket;
            this.getAuthRequestContext = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    private void MyBillsEntityDataFactory(Socket socket) {
        boolean z;
        boolean z2 = false;
        if (com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.lookAheadTest)) {
            z = false;
        } else {
            g.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "set protocols");
            SSLUtil.MyBillsEntityDataFactory((SSLSocket) socket, this.lookAheadTest);
            z = true;
        }
        if (!com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.scheduleImpl) || !com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.PlaceComponentResult)) {
            g.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.MyBillsEntityDataFactory(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.MyBillsEntityDataFactory(this.scheduleImpl)) {
                SSLUtil.PlaceComponentResult(sSLSocket, this.scheduleImpl);
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
