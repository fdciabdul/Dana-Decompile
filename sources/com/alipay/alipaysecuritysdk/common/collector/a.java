package com.alipay.alipaysecuritysdk.common.collector;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.alipay.alipaysecuritysdk.common.e.e;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* loaded from: classes3.dex */
public final class a {
    private static byte[] b(Context context, String str) {
        if (e.c(str)) {
            return null;
        }
        try {
            for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(64)) {
                if (str.equals(packageInfo.packageName)) {
                    return packageInfo.signatures[0].toByteArray();
                }
            }
        } catch (Exception e) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", e);
        }
        return null;
    }

    public static byte[] a(Context context, String str) {
        try {
            byte[] b = b(context, str);
            if (b == null) {
                return null;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(b))).getPublicKey().getEncoded();
        } catch (Exception e) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", e);
            return null;
        }
    }

    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName;
        } catch (Exception e) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", e);
            return "0.0.0";
        }
    }
}
