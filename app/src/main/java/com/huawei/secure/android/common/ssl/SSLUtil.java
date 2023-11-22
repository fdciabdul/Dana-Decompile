package com.huawei.secure.android.common.ssl;

import android.os.Build;
import com.alibaba.griver.base.common.utils.MD5Util;
import com.huawei.secure.android.common.ssl.util.g;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

/* loaded from: classes8.dex */
public abstract class SSLUtil {
    private static final String[] PlaceComponentResult = {"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};
    private static final String[] getAuthRequestContext = {"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"};
    private static final String[] KClassImpl$Data$declaredNonStaticMembers$2 = {"TLS_RSA", "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", MD5Util.ALGORIGTHM_MD5, "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};

    public static void BuiltInFictitiousFunctionClassFactory(SSLSocket sSLSocket) {
        if (sSLSocket == null || PlaceComponentResult(sSLSocket)) {
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2(sSLSocket);
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return KClassImpl$Data$declaredNonStaticMembers$2(sSLSocket, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public static void MyBillsEntityDataFactory(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            sSLSocket.setEnabledProtocols(new String[]{"TLSv1.3", "TLSv1.2"});
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 16 && i < 29) {
            sSLSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
        } else if (Build.VERSION.SDK_INT < 16) {
            sSLSocket.setEnabledProtocols(new String[]{"TLSv1"});
        }
    }

    private static boolean PlaceComponentResult(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT > 19) {
            return PlaceComponentResult(sSLSocket, getAuthRequestContext);
        }
        return PlaceComponentResult(sSLSocket, PlaceComponentResult);
    }

    public static SSLContext getAuthRequestContext() throws NoSuchAlgorithmException {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            return SSLContext.getInstance("TLSv1.3");
        }
        if (i >= 16) {
            return SSLContext.getInstance("TLSv1.2");
        }
        return SSLContext.getInstance("TLS");
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        int length = enabledCipherSuites.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            String str = enabledCipherSuites[i];
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length2 = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    z = false;
                    break;
                } else if (upperCase.contains(strArr[i2].toUpperCase(Locale.ENGLISH))) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                arrayList.add(str);
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean PlaceComponentResult(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        List asList = Arrays.asList(strArr);
        for (String str : enabledCipherSuites) {
            if (asList.contains(str.toUpperCase(Locale.ENGLISH))) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean MyBillsEntityDataFactory(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null || strArr == null) {
            return false;
        }
        try {
            sSLSocket.setEnabledProtocols(strArr);
            return true;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("setEnabledProtocols: exception : ");
            sb.append(e.getMessage());
            g.getAuthRequestContext("SSLUtil", sb.toString());
            return false;
        }
    }
}
