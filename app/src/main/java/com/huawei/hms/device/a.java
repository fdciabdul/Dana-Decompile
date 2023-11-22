package com.huawei.hms.device;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import com.huawei.hms.utils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes7.dex */
public class a {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int[] PlaceComponentResult = {-659212128, 430799709, -1642341580, 2013104246, 828547045, 1448818055, 1797984339, 1971383133, 21278873, -1163994082, 1797963451, 1357371905, -1853826745, 670737862, 435797062, 174004613, -1270280576, -2097821565};
    private static int getAuthRequestContext = 1;

    public static boolean a(X509Certificate x509Certificate, List<X509Certificate> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    if (x509Certificate == null) {
                        HMSLog.e("X509CertUtil", "rootCert is null,verify failed ");
                        return false;
                    }
                    PublicKey publicKey = x509Certificate.getPublicKey();
                    for (X509Certificate x509Certificate2 : list) {
                        int i = getAuthRequestContext + 125;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                        int i2 = i % 2;
                        if (x509Certificate2 != null) {
                            try {
                                x509Certificate2.checkValidity();
                                x509Certificate2.verify(publicKey);
                                publicKey = x509Certificate2.getPublicKey();
                            } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException e) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("verify failed ");
                                sb.append(e.getMessage());
                                HMSLog.e("X509CertUtil", sb.toString());
                            }
                        }
                        int i3 = getAuthRequestContext + 83;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                        if (i3 % 2 != 0) {
                            Object[] objArr = null;
                            int length = objArr.length;
                            return false;
                        }
                        return false;
                    }
                    return a(list);
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return false;
    }

    public static List<X509Certificate> b(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 65;
        getAuthRequestContext = i % 128;
        while (true) {
            int i2 = i % 2;
            if ((it.hasNext() ? '_' : (char) 21) == 21) {
                return arrayList;
            }
            try {
                arrayList.add(a(it.next()));
                i = KClassImpl$Data$declaredNonStaticMembers$2 + 91;
                getAuthRequestContext = i % 128;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    public static List<String> c(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 1) {
                ArrayList arrayList = new ArrayList(jSONArray.length());
                int i = 0;
                while (true) {
                    if (!(i < jSONArray.length())) {
                        return arrayList;
                    }
                    try {
                        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
                        getAuthRequestContext = i2 % 128;
                        int i3 = i2 % 2;
                        arrayList.add(jSONArray.getString(i));
                        i++;
                    } catch (Exception e) {
                        throw e;
                    }
                }
            } else {
                int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
                getAuthRequestContext = i4 % 128;
                int i5 = i4 % 2;
                List<String> emptyList = Collections.emptyList();
                int i6 = KClassImpl$Data$declaredNonStaticMembers$2 + 37;
                getAuthRequestContext = i6 % 128;
                if ((i6 % 2 == 0 ? '=' : 'B') != 'B') {
                    Object obj = null;
                    obj.hashCode();
                    return emptyList;
                }
                return emptyList;
            }
        } catch (JSONException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to getCertChain: ");
            sb.append(e2.getMessage());
            HMSLog.e("X509CertUtil", sb.toString());
            return Collections.emptyList();
        }
    }

    public static List<X509Certificate> b(String str) {
        try {
            int i = getAuthRequestContext + 69;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            List<X509Certificate> b = b(c(str));
            int i3 = getAuthRequestContext + 57;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return b;
        } catch (Exception e) {
            throw e;
        }
    }

    public static boolean b(X509Certificate x509Certificate, String str, String str2) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
        getAuthRequestContext = i % 128;
        if (i % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            if (x509Certificate == null) {
                return false;
            }
        } else {
            if ((x509Certificate != null ? (char) 23 : 'Z') == 'Z') {
                return false;
            }
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        if ((!TextUtils.isEmpty(str) ? Typography.amp : 'X') == '&' && !TextUtils.isEmpty(str2)) {
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 19;
            getAuthRequestContext = i4 % 128;
            int i5 = i4 % 2;
            try {
                boolean equals = str2.equals(a(x509Certificate.getSubjectDN().getName(), str));
                try {
                    int i6 = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
                    getAuthRequestContext = i6 % 128;
                    int i7 = i6 % 2;
                    return equals;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return false;
    }

    public static boolean b(X509Certificate x509Certificate, String str) {
        boolean b;
        int i = getAuthRequestContext + 7;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 == 0) {
            b = b(x509Certificate, "OU", str);
        } else {
            try {
                b = b(x509Certificate, "OU", str);
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = getAuthRequestContext + 59;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if ((i2 % 2 != 0 ? '9' : (char) 2) != '9') {
            return b;
        }
        int i3 = 36 / 0;
        return b;
    }

    public static X509Certificate a(String str) {
        Object[] objArr = null;
        if (!(TextUtils.isEmpty(str))) {
            try {
                X509Certificate a2 = a(Base64.decode(str));
                int i = getAuthRequestContext + 125;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if ((i % 2 != 0 ? (char) 11 : 'N') != 11) {
                    return a2;
                }
                int length = objArr.length;
                return a2;
            } catch (IllegalArgumentException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("getCert failed : ");
                sb.append(e.getMessage());
                HMSLog.e("X509CertUtil", sb.toString());
                return null;
            }
        }
        try {
            int i2 = getAuthRequestContext + 25;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            return null;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static X509Certificate a(byte[] bArr) {
        try {
            X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
            try {
                int i = getAuthRequestContext + 83;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                return x509Certificate;
            } catch (Exception e) {
                throw e;
            }
        } catch (CertificateException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to get cert: ");
            sb.append(e2.getMessage());
            HMSLog.e("X509CertUtil", sb.toString());
            return null;
        }
    }

    public static String a(String str, String str2) {
        String upperCase = str.toUpperCase(Locale.getDefault());
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("=");
        int indexOf = upperCase.indexOf(sb.toString());
        if (!(indexOf == -1)) {
            int indexOf2 = str.indexOf(",", indexOf);
            if ((indexOf2 != -1 ? (char) 3 : (char) 15) != 15) {
                String substring = str.substring(indexOf + str2.length() + 1, indexOf2);
                int i = getAuthRequestContext + 99;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if (i % 2 != 0) {
                    int i2 = 76 / 0;
                    return substring;
                }
                return substring;
            }
            String substring2 = str.substring(indexOf + str2.length() + 1);
            int i3 = getAuthRequestContext + 83;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return substring2;
        }
        try {
            int i5 = getAuthRequestContext + 37;
            KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
            int i6 = i5 % 2;
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    public static boolean a(X509Certificate x509Certificate) {
        if ((x509Certificate == null ? 'I' : 'a') == 'I') {
            int i = getAuthRequestContext + 71;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            return false;
        }
        if (!(x509Certificate.getBasicConstraints() == -1)) {
            try {
                boolean[] keyUsage = x509Certificate.getKeyUsage();
                if (5 >= keyUsage.length) {
                    int i3 = getAuthRequestContext + 103;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    int i4 = i3 % 2;
                    return false;
                }
                try {
                    int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 113;
                    getAuthRequestContext = i5 % 128;
                    return i5 % 2 == 0 ? keyUsage[3] : keyUsage[5];
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return false;
    }

    public static boolean a(List<X509Certificate> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int i2 = getAuthRequestContext + 17;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            if ((i2 % 2 != 0 ? (char) 14 : (char) 18) != 14) {
                if (!a(list.get(i))) {
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
                    getAuthRequestContext = i3 % 128;
                    int i4 = i3 % 2;
                    return false;
                }
            } else {
                try {
                    boolean a2 = a(list.get(i));
                    Object obj = null;
                    obj.hashCode();
                    if (!a2) {
                        int i32 = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
                        getAuthRequestContext = i32 % 128;
                        int i42 = i32 % 2;
                        return false;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            throw e;
        }
        return true;
    }

    public static boolean a(X509Certificate x509Certificate, String str) {
        boolean b;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? 'C' : 'A') != 'A') {
            try {
                b = b(x509Certificate, "CN", str);
                int i2 = 86 / 0;
            } catch (Exception e) {
                throw e;
            }
        } else {
            try {
                b = b(x509Certificate, "CN", str);
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i3 = getAuthRequestContext + 93;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 98 / 0;
            return b;
        }
        return b;
    }

    public static boolean a(X509Certificate x509Certificate, String str, String str2) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            Object[] objArr = new Object[1];
            d((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 5, new int[]{-1765258647, 1598176673, -777996100, -1683148284}, objArr);
            return a(x509Certificate, str.getBytes(((String) objArr[0]).intern()), Base64.decode(str2));
        } catch (UnsupportedEncodingException | IllegalArgumentException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(" plainText exception: ");
            sb.append(e.getMessage());
            HMSLog.e("X509CertUtil", sb.toString());
            int i3 = getAuthRequestContext + 3;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (i3 % 2 != 0) {
                Object[] objArr2 = null;
                int length = objArr2.length;
                return false;
            }
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.security.cert.X509Certificate r4, byte[] r5, byte[] r6) {
        /*
            int r0 = com.huawei.hms.device.a.getAuthRequestContext     // Catch: java.lang.Exception -> L83
            int r0 = r0 + 115
            int r1 = r0 % 128
            com.huawei.hms.device.a.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L83
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            r3 = 0
            if (r0 == r1) goto L31
            java.lang.String r0 = r4.getSigAlgName()     // Catch: java.security.InvalidKeyException -> L2b java.security.SignatureException -> L2d java.security.NoSuchAlgorithmException -> L2f
            java.security.Signature r0 = java.security.Signature.getInstance(r0)     // Catch: java.security.InvalidKeyException -> L2b java.security.SignatureException -> L2d java.security.NoSuchAlgorithmException -> L2f
            java.security.PublicKey r4 = r4.getPublicKey()     // Catch: java.security.InvalidKeyException -> L2b java.security.SignatureException -> L2d java.security.NoSuchAlgorithmException -> L2f
            r0.initVerify(r4)     // Catch: java.security.InvalidKeyException -> L2b java.security.SignatureException -> L2d java.security.NoSuchAlgorithmException -> L2f
            r0.update(r5)     // Catch: java.security.InvalidKeyException -> L2b java.security.SignatureException -> L2d java.security.NoSuchAlgorithmException -> L2f
            boolean r4 = r0.verify(r6)     // Catch: java.security.InvalidKeyException -> L2b java.security.SignatureException -> L2d java.security.NoSuchAlgorithmException -> L2f
            return r4
        L2b:
            r4 = move-exception
            goto L4b
        L2d:
            r4 = move-exception
            goto L4b
        L2f:
            r4 = move-exception
            goto L4b
        L31:
            java.lang.String r0 = r4.getSigAlgName()     // Catch: java.security.InvalidKeyException -> L2b java.security.SignatureException -> L2d java.security.NoSuchAlgorithmException -> L2f
            java.security.Signature r0 = java.security.Signature.getInstance(r0)     // Catch: java.security.InvalidKeyException -> L2b java.security.SignatureException -> L2d java.security.NoSuchAlgorithmException -> L2f
            java.security.PublicKey r4 = r4.getPublicKey()     // Catch: java.security.InvalidKeyException -> L2b java.security.SignatureException -> L2d java.security.NoSuchAlgorithmException -> L2f
            r0.initVerify(r4)     // Catch: java.security.InvalidKeyException -> L2b java.security.SignatureException -> L2d java.security.NoSuchAlgorithmException -> L2f
            r0.update(r5)     // Catch: java.security.InvalidKeyException -> L2b java.security.SignatureException -> L2d java.security.NoSuchAlgorithmException -> L2f
            boolean r4 = r0.verify(r6)     // Catch: java.security.InvalidKeyException -> L2b java.security.SignatureException -> L2d java.security.NoSuchAlgorithmException -> L2f
            int r5 = r3.length     // Catch: java.lang.Throwable -> L49
            return r4
        L49:
            r4 = move-exception
            throw r4
        L4b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "failed checkSignature : "
            r5.append(r6)
            java.lang.String r4 = r4.getMessage()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "X509CertUtil"
            com.huawei.hms.support.log.HMSLog.e(r5, r4)
            int r4 = com.huawei.hms.device.a.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L81
            int r4 = r4 + 69
            int r5 = r4 % 128
            com.huawei.hms.device.a.getAuthRequestContext = r5     // Catch: java.lang.Exception -> L81
            int r4 = r4 % 2
            r5 = 61
            if (r4 != 0) goto L76
            r4 = 61
            goto L78
        L76:
            r4 = 92
        L78:
            if (r4 == r5) goto L7b
            return r2
        L7b:
            r3.hashCode()     // Catch: java.lang.Throwable -> L7f
            return r2
        L7f:
            r4 = move-exception
            throw r4
        L81:
            r4 = move-exception
            throw r4
        L83:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.device.a.a(java.security.cert.X509Certificate, byte[], byte[]):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.InputStream] */
    public static X509Certificate a(Context context, String str) {
        Throwable th;
        Throwable e;
        InputStream inputStream;
        KeyStore keyStore;
        ?? r3 = 0;
        if ((context != null ? '\'' : 'D') == '\'') {
            try {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            keyStore = KeyStore.getInstance("bks");
                            inputStream = context.getAssets().open("hmsrootcas.bks");
                        } catch (IOException e2) {
                            e = e2;
                            e = e;
                            int i = getAuthRequestContext + 43;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                            int i2 = i % 2;
                            inputStream = null;
                            StringBuilder sb = new StringBuilder();
                            sb.append("exception:");
                            sb.append(e.getMessage());
                            HMSLog.e("X509CertUtil", sb.toString());
                            IOUtils.closeQuietly(inputStream);
                            return null;
                        } catch (KeyStoreException e3) {
                            e = e3;
                            e = e;
                            int i3 = getAuthRequestContext + 43;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                            int i22 = i3 % 2;
                            inputStream = null;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("exception:");
                            sb2.append(e.getMessage());
                            HMSLog.e("X509CertUtil", sb2.toString());
                            IOUtils.closeQuietly(inputStream);
                            return null;
                        } catch (NoSuchAlgorithmException e4) {
                            e = e4;
                            e = e;
                            int i32 = getAuthRequestContext + 43;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i32 % 128;
                            int i222 = i32 % 2;
                            inputStream = null;
                            StringBuilder sb22 = new StringBuilder();
                            sb22.append("exception:");
                            sb22.append(e.getMessage());
                            HMSLog.e("X509CertUtil", sb22.toString());
                            IOUtils.closeQuietly(inputStream);
                            return null;
                        } catch (CertificateException e5) {
                            e = e5;
                            e = e;
                            int i322 = getAuthRequestContext + 43;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i322 % 128;
                            int i2222 = i322 % 2;
                            inputStream = null;
                            StringBuilder sb222 = new StringBuilder();
                            sb222.append("exception:");
                            sb222.append(e.getMessage());
                            HMSLog.e("X509CertUtil", sb222.toString());
                            IOUtils.closeQuietly(inputStream);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            IOUtils.closeQuietly((InputStream) r3);
                            throw th;
                        }
                        try {
                            keyStore.load(inputStream, "".toCharArray());
                        } catch (IOException e6) {
                            e = e6;
                            StringBuilder sb2222 = new StringBuilder();
                            sb2222.append("exception:");
                            sb2222.append(e.getMessage());
                            HMSLog.e("X509CertUtil", sb2222.toString());
                            IOUtils.closeQuietly(inputStream);
                            return null;
                        } catch (KeyStoreException e7) {
                            e = e7;
                            StringBuilder sb22222 = new StringBuilder();
                            sb22222.append("exception:");
                            sb22222.append(e.getMessage());
                            HMSLog.e("X509CertUtil", sb22222.toString());
                            IOUtils.closeQuietly(inputStream);
                            return null;
                        } catch (NoSuchAlgorithmException e8) {
                            e = e8;
                            StringBuilder sb222222 = new StringBuilder();
                            sb222222.append("exception:");
                            sb222222.append(e.getMessage());
                            HMSLog.e("X509CertUtil", sb222222.toString());
                            IOUtils.closeQuietly(inputStream);
                            return null;
                        } catch (CertificateException e9) {
                            e = e9;
                            StringBuilder sb2222222 = new StringBuilder();
                            sb2222222.append("exception:");
                            sb2222222.append(e.getMessage());
                            HMSLog.e("X509CertUtil", sb2222222.toString());
                            IOUtils.closeQuietly(inputStream);
                            return null;
                        }
                        if (!keyStore.containsAlias(str)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Not include alias ");
                            sb3.append(str);
                            HMSLog.e("X509CertUtil", sb3.toString());
                            IOUtils.closeQuietly(inputStream);
                            return null;
                        }
                        Certificate certificate = keyStore.getCertificate(str);
                        if (!(certificate instanceof X509Certificate)) {
                            IOUtils.closeQuietly(inputStream);
                            return null;
                        }
                        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
                        getAuthRequestContext = i4 % 128;
                        int i5 = i4 % 2;
                        X509Certificate x509Certificate = (X509Certificate) certificate;
                        x509Certificate.checkValidity();
                        IOUtils.closeQuietly(inputStream);
                        return x509Certificate;
                    }
                } catch (Throwable th3) {
                    r3 = context;
                    th = th3;
                }
            } catch (Exception e10) {
                throw e10;
            }
        }
        HMSLog.e("X509CertUtil", "args are error");
        return null;
    }

    public static X509Certificate a(Context context) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
            getAuthRequestContext = i % 128;
            boolean z = i % 2 == 0;
            Object obj = null;
            X509Certificate a2 = a(context, "052root");
            if (z) {
                obj.hashCode();
            }
            int i2 = getAuthRequestContext + 25;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            if (!(i2 % 2 != 0)) {
                return a2;
            }
            obj.hashCode();
            return a2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void d(int i, int[] iArr, Object[] objArr) {
        int i2;
        int length;
        int[] iArr2;
        int i3;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr3 = PlaceComponentResult;
        if (iArr3 != null) {
            int i4 = $10 + 65;
            $11 = i4 % 128;
            if ((i4 % 2 == 0 ? ',' : Typography.greater) != '>') {
                length = iArr3.length;
                iArr2 = new int[length];
                i3 = 1;
            } else {
                length = iArr3.length;
                iArr2 = new int[length];
                i3 = 0;
            }
            while (true) {
                if (!(i3 < length)) {
                    break;
                }
                iArr2[i3] = (int) (iArr3[i3] ^ (-3152031022165484798L));
                i3++;
            }
            iArr3 = iArr2;
        }
        int length2 = iArr3.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = PlaceComponentResult;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i5 = 0;
            while (true) {
                if ((i5 < length3 ? (char) 25 : 'Q') != 25) {
                    break;
                }
                iArr6[i5] = (int) (iArr5[i5] ^ (-3152031022165484798L));
                i5++;
                length2 = length2;
            }
            i2 = length2;
            iArr5 = iArr6;
        } else {
            i2 = length2;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, i2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if (!(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory >= iArr.length)) {
                int i6 = $10 + 5;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                try {
                    cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                    cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                    cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                    cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                    VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                    for (int i8 = 0; i8 < 16; i8++) {
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i8];
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        int i9 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i9;
                    }
                    int i10 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i10;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                    int i11 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    int i12 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                    cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                    cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                    cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                    cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                    cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                    cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                    verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
        }
    }
}
