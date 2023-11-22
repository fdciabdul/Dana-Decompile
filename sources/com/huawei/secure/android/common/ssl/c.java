package com.huawei.secure.android.common.ssl;

import com.huawei.secure.android.common.ssl.util.g;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes8.dex */
public class c implements X509TrustManager {
    private List<X509TrustManager> BuiltInFictitiousFunctionClassFactory;
    private X509Certificate getAuthRequestContext;

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g.KClassImpl$Data$declaredNonStaticMembers$2("WebViewX509TrustManger", "checkClientTrusted");
        if (!this.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
            this.BuiltInFictitiousFunctionClassFactory.get(0).checkClientTrusted(x509CertificateArr, str);
            return;
        }
        throw new CertificateException("checkClientTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g.KClassImpl$Data$declaredNonStaticMembers$2("WebViewX509TrustManger", "checkServerTrusted");
        boolean z = false;
        for (X509Certificate x509Certificate : x509CertificateArr) {
            x509Certificate.getIssuerDN().getName();
            g.PlaceComponentResult();
        }
        X509Certificate[] x509CertificateArr2 = new X509Certificate[x509CertificateArr.length];
        for (int i = 0; i < x509CertificateArr.length; i++) {
            x509CertificateArr2[i] = x509CertificateArr[(x509CertificateArr.length - 1) - i];
        }
        CertificateException e = new CertificateException("CBG root CA CertificateException");
        try {
            z = com.huawei.secure.android.common.ssl.util.b.PlaceComponentResult(this.getAuthRequestContext, x509CertificateArr2);
        } catch (InvalidKeyException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("checkServerTrusted InvalidKeyException: ");
            sb.append(e2.getMessage());
            g.getAuthRequestContext("WebViewX509TrustManger", sb.toString());
        } catch (NoSuchAlgorithmException e3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("checkServerTrusted NoSuchAlgorithmException: ");
            sb2.append(e3.getMessage());
            g.getAuthRequestContext("WebViewX509TrustManger", sb2.toString());
        } catch (NoSuchProviderException e4) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("checkServerTrusted NoSuchProviderException: ");
            sb3.append(e4.getMessage());
            g.getAuthRequestContext("WebViewX509TrustManger", sb3.toString());
        } catch (SignatureException e5) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("checkServerTrusted SignatureException: ");
            sb4.append(e5.getMessage());
            g.getAuthRequestContext("WebViewX509TrustManger", sb4.toString());
        } catch (CertificateException e6) {
            e = e6;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("checkServerTrusted CertificateException: ");
            sb5.append(e.getMessage());
            g.getAuthRequestContext("WebViewX509TrustManger", sb5.toString());
        }
        if (!z) {
            throw e;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getAcceptedIssuers exception : ");
            sb.append(e.getMessage());
            g.getAuthRequestContext("WebViewX509TrustManger", sb.toString());
            return new X509Certificate[0];
        }
    }
}
