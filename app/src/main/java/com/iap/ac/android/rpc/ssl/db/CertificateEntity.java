package com.iap.ac.android.rpc.ssl.db;

import java.security.cert.Certificate;

/* loaded from: classes3.dex */
public class CertificateEntity {
    public Certificate certificateData;
    public String certificateUrl;

    public CertificateEntity(String str, Certificate certificate) {
        this.certificateUrl = str;
        this.certificateData = certificate;
    }
}
