package com.huawei.secure.android.common.ssl.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;

/* loaded from: classes8.dex */
public class b {
    private static final String BuiltInFictitiousFunctionClassFactory = "b";

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(X509Certificate[] x509CertificateArr) {
        Date date = new Date();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            try {
                x509Certificate.checkValidity(date);
            } catch (CertificateExpiredException e) {
                e = e;
                String str = BuiltInFictitiousFunctionClassFactory;
                StringBuilder sb = new StringBuilder();
                sb.append("verifyCertificateDate: exception : ");
                sb.append(e.getMessage());
                g.getAuthRequestContext(str, sb.toString());
                return false;
            } catch (CertificateNotYetValidException e2) {
                e = e2;
                String str2 = BuiltInFictitiousFunctionClassFactory;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("verifyCertificateDate: exception : ");
                sb2.append(e.getMessage());
                g.getAuthRequestContext(str2, sb2.toString());
                return false;
            } catch (Exception e3) {
                String str3 = BuiltInFictitiousFunctionClassFactory;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("verifyCertificateDate : exception : ");
                sb3.append(e3.getMessage());
                g.getAuthRequestContext(str3, sb3.toString());
                return false;
            }
        }
        return true;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            if (KClassImpl$Data$declaredNonStaticMembers$2(new X509Certificate[]{x509Certificate, x509Certificate2})) {
                return true;
            }
            g.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory, "verify: date not right");
            return false;
        } catch (InvalidKeyException e) {
            String str = BuiltInFictitiousFunctionClassFactory;
            StringBuilder sb = new StringBuilder();
            sb.append("verify: publickey InvalidKeyException ");
            sb.append(e.getMessage());
            g.getAuthRequestContext(str, sb.toString());
            return false;
        } catch (NoSuchAlgorithmException e2) {
            String str2 = BuiltInFictitiousFunctionClassFactory;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("verify: publickey NoSuchAlgorithmException ");
            sb2.append(e2.getMessage());
            g.getAuthRequestContext(str2, sb2.toString());
            return false;
        } catch (NoSuchProviderException e3) {
            String str3 = BuiltInFictitiousFunctionClassFactory;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("verify: publickey NoSuchProviderException ");
            sb3.append(e3.getMessage());
            g.getAuthRequestContext(str3, sb3.toString());
            return false;
        } catch (SignatureException e4) {
            String str4 = BuiltInFictitiousFunctionClassFactory;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("verify: publickey SignatureException ");
            sb4.append(e4.getMessage());
            g.getAuthRequestContext(str4, sb4.toString());
            return false;
        } catch (CertificateException e5) {
            String str5 = BuiltInFictitiousFunctionClassFactory;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("verify: publickey CertificateException ");
            sb5.append(e5.getMessage());
            g.getAuthRequestContext(str5, sb5.toString());
            return false;
        } catch (Exception e6) {
            String str6 = BuiltInFictitiousFunctionClassFactory;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("verify: Exception ");
            sb6.append(e6.getMessage());
            g.getAuthRequestContext(str6, sb6.toString());
            return false;
        }
    }

    public static boolean PlaceComponentResult(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr) throws NoSuchProviderException, CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Principal principal = null;
        int i = 0;
        while (i < x509CertificateArr.length) {
            X509Certificate x509Certificate2 = x509CertificateArr[i];
            Principal issuerDN = x509Certificate2.getIssuerDN();
            Principal subjectDN = x509Certificate2.getSubjectDN();
            if (principal != null) {
                if (issuerDN.equals(principal)) {
                    x509CertificateArr[i].verify(x509CertificateArr[i - 1].getPublicKey());
                } else {
                    g.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory, "verify: principalIssuer not match");
                    return false;
                }
            }
            i++;
            principal = subjectDN;
        }
        return KClassImpl$Data$declaredNonStaticMembers$2(x509Certificate, x509CertificateArr[0]) && KClassImpl$Data$declaredNonStaticMembers$2(x509CertificateArr) && getAuthRequestContext(x509Certificate) && BuiltInFictitiousFunctionClassFactory(x509CertificateArr);
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(X509Certificate[] x509CertificateArr) {
        for (int i = 0; i < x509CertificateArr.length - 1; i++) {
            if (!getAuthRequestContext(x509CertificateArr[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean getAuthRequestContext(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }
}
