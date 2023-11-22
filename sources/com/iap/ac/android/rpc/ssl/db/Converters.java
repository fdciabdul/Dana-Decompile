package com.iap.ac.android.rpc.ssl.db;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* loaded from: classes8.dex */
public class Converters {
    public static byte[] certificateToByteArray(Certificate certificate) {
        try {
            return certificate.getEncoded();
        } catch (CertificateEncodingException unused) {
            return null;
        }
    }

    public static Certificate fromByteArray(byte[] bArr) {
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
