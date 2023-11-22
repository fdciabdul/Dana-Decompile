package com.huawei.secure.android.common.ssl;

import com.huawei.secure.android.common.ssl.util.f;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes8.dex */
public class SecureX509TrustManager implements X509TrustManager {
    private static final String MyBillsEntityDataFactory = "SecureX509TrustManager";
    private X509Certificate[] PlaceComponentResult;
    protected List<X509TrustManager> getAuthRequestContext = new ArrayList();

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, "checkClientTrusted: ");
        Iterator<X509TrustManager> it = this.getAuthRequestContext.iterator();
        while (it.hasNext()) {
            try {
                it.next().checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e) {
                String str2 = MyBillsEntityDataFactory;
                StringBuilder sb = new StringBuilder();
                sb.append("checkServerTrusted CertificateException");
                sb.append(e.getMessage());
                g.getAuthRequestContext(str2, sb.toString());
            }
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.getAuthRequestContext.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e) {
            String str = MyBillsEntityDataFactory;
            StringBuilder sb = new StringBuilder();
            sb.append("getAcceptedIssuers exception : ");
            sb.append(e.getMessage());
            g.getAuthRequestContext(str, sb.toString());
            return new X509Certificate[0];
        }
    }

    public SecureX509TrustManager(InputStream inputStream, String str) throws IllegalArgumentException {
        try {
            if (inputStream != null) {
                try {
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
                    KeyStore keyStore = KeyStore.getInstance("bks");
                    keyStore.load(inputStream, str.toCharArray());
                    trustManagerFactory.init(keyStore);
                    TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                    for (TrustManager trustManager : trustManagers) {
                        if (trustManager instanceof X509TrustManager) {
                            this.getAuthRequestContext.add((X509TrustManager) trustManager);
                        }
                    }
                    f.BuiltInFictitiousFunctionClassFactory(inputStream);
                } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
                    String str2 = MyBillsEntityDataFactory;
                    StringBuilder sb = new StringBuilder();
                    sb.append("loadInputStream: exception : ");
                    sb.append(e.getMessage());
                    g.getAuthRequestContext(str2, sb.toString());
                }
                g.PlaceComponentResult();
                return;
            }
            throw new IllegalArgumentException("inputstream or trustPwd is null");
        } finally {
            f.BuiltInFictitiousFunctionClassFactory(inputStream);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.PlaceComponentResult = x509CertificateArr;
        String str2 = MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append("checkServerTrusted begin ,server ca chain size is : ");
        sb.append(x509CertificateArr.length);
        sb.append(" ,auth type is : ");
        sb.append(str);
        g.KClassImpl$Data$declaredNonStaticMembers$2(str2, sb.toString());
        for (X509Certificate x509Certificate : x509CertificateArr) {
            x509Certificate.getSubjectDN();
            g.PlaceComponentResult();
            x509Certificate.getIssuerDN();
            g.PlaceComponentResult();
            x509Certificate.getSerialNumber();
            g.PlaceComponentResult();
        }
        int size = this.getAuthRequestContext.size();
        for (int i = 0; i < size; i++) {
            try {
                String str3 = MyBillsEntityDataFactory;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("check server i : ");
                sb2.append(i);
                g.KClassImpl$Data$declaredNonStaticMembers$2(str3, sb2.toString());
                X509TrustManager x509TrustManager = this.getAuthRequestContext.get(i);
                X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("client root ca size is : ");
                    sb3.append(acceptedIssuers.length);
                    g.KClassImpl$Data$declaredNonStaticMembers$2(str3, sb3.toString());
                    for (X509Certificate x509Certificate2 : acceptedIssuers) {
                        x509Certificate2.getIssuerDN();
                        g.PlaceComponentResult();
                    }
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                String str4 = MyBillsEntityDataFactory;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("checkServerTrusted succeed ,root ca issuer is : ");
                sb4.append(x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                g.KClassImpl$Data$declaredNonStaticMembers$2(str4, sb4.toString());
                return;
            } catch (CertificateException e) {
                String str5 = MyBillsEntityDataFactory;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("checkServerTrusted error :");
                sb5.append(e.getMessage());
                sb5.append(" , time : ");
                sb5.append(i);
                g.getAuthRequestContext(str5, sb5.toString());
                if (i == size - 1) {
                    if (x509CertificateArr != null && x509CertificateArr.length > 0) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("root ca issuer : ");
                        sb6.append(x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                        g.getAuthRequestContext(str5, sb6.toString());
                    }
                    throw e;
                }
            }
        }
        g.PlaceComponentResult();
    }
}
