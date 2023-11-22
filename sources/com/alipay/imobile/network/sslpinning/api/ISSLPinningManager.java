package com.alipay.imobile.network.sslpinning.api;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;

/* loaded from: classes.dex */
public interface ISSLPinningManager {
    public static final int PINNING_MODE_CERTIFICATE = 1;
    public static final int PINNING_MODE_NONE = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PinningMode {
    }

    void addAndPersistRemoteCertificates(List<String> list, OnAddRemoteCertificatesListener onAddRemoteCertificatesListener);

    void addCertificates(List<String> list) throws CertificateException, IOException;

    List<Certificate> getCertificates();

    void setPinningMode(int i);

    void setPresetCertificateFolderPath(String str);

    void validateCertificates(HttpsURLConnection httpsURLConnection) throws SSLException;
}
