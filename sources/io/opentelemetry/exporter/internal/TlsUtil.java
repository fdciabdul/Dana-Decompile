package io.opentelemetry.exporter.internal;

import com.iap.ac.android.common.utils.security.RSAHelper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes9.dex */
public final class TlsUtil {
    private static final String PEM_KEY_FOOTER = "-----END PRIVATE KEY-----";
    private static final String PEM_KEY_HEADER = "-----BEGIN PRIVATE KEY-----";

    private TlsUtil() {
    }

    public static SSLSocketFactory sslSocketFactory(@Nullable KeyManager keyManager, TrustManager trustManager) throws SSLException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            if (keyManager == null) {
                sSLContext.init(null, new TrustManager[]{trustManager}, null);
            } else {
                sSLContext.init(new KeyManager[]{keyManager}, new TrustManager[]{trustManager}, null);
            }
            return sSLContext.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            throw new SSLException("Could not set trusted certificates for TLS connection, are they valid X.509 in PEM format?", e);
        }
    }

    public static X509KeyManager keyManager(byte[] bArr, byte[] bArr2) throws SSLException {
        Objects.requireNonNull(bArr, "privateKeyPem");
        Objects.requireNonNull(bArr2, "certificatePem");
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            PrivateKey generatePrivate = KeyFactory.getInstance(RSAHelper.DEFAULT_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(decodePem(bArr)));
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            ArrayList arrayList = new ArrayList();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr2);
            while (byteArrayInputStream.available() > 0) {
                arrayList.add(certificateFactory.generateCertificate(byteArrayInputStream));
            }
            keyStore.setKeyEntry("trusted", generatePrivate, "".toCharArray(), (Certificate[]) arrayList.toArray(new Certificate[0]));
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, "".toCharArray());
            return (X509KeyManager) keyManagerFactory.getKeyManagers()[0];
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException | InvalidKeySpecException e) {
            throw new SSLException("Could not build KeyManagerFactory from clientKeysPem.", e);
        }
    }

    public static X509TrustManager trustManager(byte[] bArr) throws SSLException {
        Objects.requireNonNull(bArr, "trustedCertificatesPem");
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            int i = 0;
            while (byteArrayInputStream.available() > 0) {
                X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
                StringBuilder sb = new StringBuilder();
                sb.append("cert_");
                sb.append(i);
                keyStore.setCertificateEntry(sb.toString(), x509Certificate);
                i++;
            }
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            return (X509TrustManager) trustManagerFactory.getTrustManagers()[0];
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            throw new SSLException("Could not build TrustManagerFactory from trustedCertificatesPem.", e);
        }
    }

    private static byte[] decodePem(byte[] bArr) {
        String trim = new String(bArr, StandardCharsets.UTF_8).trim();
        if (trim.startsWith(PEM_KEY_HEADER) && trim.endsWith(PEM_KEY_FOOTER)) {
            try {
                return Base64.getDecoder().decode(trim.substring(27, trim.length() - 25).replaceAll("\\s", ""));
            } catch (LinkageError unused) {
                throw new IllegalArgumentException("PEM private keys are currently not supported on Android. You may try a key encoded as DER.");
            }
        }
        return bArr;
    }
}
