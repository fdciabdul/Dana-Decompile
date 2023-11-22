package com.huawei.secure.android.common.ssl.hostname;

import com.huawei.secure.android.common.ssl.util.g;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* loaded from: classes8.dex */
public class StrictHostnameVerifier implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
            x509Certificate.getSubjectDN().getName();
            g.PlaceComponentResult();
            b.getAuthRequestContext(str, x509Certificate, true);
            return true;
        } catch (SSLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("SSLException : ");
            sb.append(e.getMessage());
            g.getAuthRequestContext("", sb.toString());
            return false;
        }
    }
}
