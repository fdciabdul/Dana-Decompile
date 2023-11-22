package com.alipay.imobile.network.sslpinning.db;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* loaded from: classes6.dex */
public class d {
    public static byte[] a(Certificate certificate) {
        try {
            return certificate.getEncoded();
        } catch (CertificateEncodingException unused) {
            return null;
        }
    }

    public static Certificate a(byte[] bArr) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
            byteArrayInputStream.close();
            return generateCertificate;
        } catch (IOException | CertificateException unused) {
            return null;
        }
    }
}
