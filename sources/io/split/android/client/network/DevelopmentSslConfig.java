package io.split.android.client.network;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes6.dex */
public class DevelopmentSslConfig {
    private final HostnameVerifier hostnameVerifier;
    private final SSLSocketFactory sslSocketFactory;
    private final X509TrustManager trustManager;

    public DevelopmentSslConfig(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager, HostnameVerifier hostnameVerifier) {
        this.sslSocketFactory = sSLSocketFactory;
        this.trustManager = x509TrustManager;
        this.hostnameVerifier = hostnameVerifier;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public X509TrustManager getTrustManager() {
        return this.trustManager;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }
}
