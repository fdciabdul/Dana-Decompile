package com.alipay.imobile.network.tls;

import android.os.Build;
import com.alipay.iap.android.common.log.LoggerWrapper;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
public class TlsSupportSocketFactory extends SSLSocketFactory {
    private static final String[] PATCH_TLS_PROTOCOLS = {"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"};
    private static final String TAG = "Quake-TLS";
    private SSLSocketFactory mProxyFactory;

    public TlsSupportSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.mProxyFactory = sSLSocketFactory;
    }

    public static SSLSocketFactory createDefaultPatchSSLSocketFactory() {
        if (isNeedPatchTlsSupport()) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
                if (socketFactory != null) {
                    return new TlsSupportSocketFactory(socketFactory);
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("patchSSLSocketFactory error: ");
                sb.append(th);
                LoggerWrapper.w(TAG, sb.toString());
            }
        }
        return null;
    }

    public static boolean isNeedPatchTlsSupport() {
        if (Build.VERSION.SDK_INT < 16 || Build.VERSION.SDK_INT >= 21) {
            StringBuilder sb = new StringBuilder();
            sb.append("[enableTlsSupport] skip for osVersion = ");
            sb.append(Build.VERSION.SDK_INT);
            LoggerWrapper.d(TAG, sb.toString());
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[enableTlsSupport] patch for osVersion = ");
        sb2.append(Build.VERSION.SDK_INT);
        LoggerWrapper.d(TAG, sb2.toString());
        return true;
    }

    public static SSLSocketFactory patchSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (sSLSocketFactory == null) {
            return null;
        }
        return !isNeedPatchTlsSupport() ? sSLSocketFactory : new TlsSupportSocketFactory(sSLSocketFactory);
    }

    private Socket patchTlsSocket(Socket socket) {
        if (socket instanceof SSLSocket) {
            try {
                ((SSLSocket) socket).setEnabledProtocols(PATCH_TLS_PROTOCOLS);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("patchTlsSocket error: ");
                sb.append(th);
                LoggerWrapper.w(TAG, sb.toString());
            }
        }
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return patchTlsSocket(this.mProxyFactory.createSocket());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        return patchTlsSocket(this.mProxyFactory.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return patchTlsSocket(this.mProxyFactory.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return patchTlsSocket(this.mProxyFactory.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return patchTlsSocket(this.mProxyFactory.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return patchTlsSocket(this.mProxyFactory.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.mProxyFactory.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.mProxyFactory.getSupportedCipherSuites();
    }
}
