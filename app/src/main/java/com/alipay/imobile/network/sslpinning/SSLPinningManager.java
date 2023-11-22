package com.alipay.imobile.network.sslpinning;

import android.content.Context;
import android.net.http.X509TrustManagerExtensions;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.sslpinning.api.ISSLPinningManager;
import com.alipay.imobile.network.sslpinning.api.OnAddRemoteCertificatesListener;
import com.alipay.imobile.network.sslpinning.b.b;
import com.alipay.imobile.network.sslpinning.db.CertificateDatabase;
import com.alipay.imobile.network.sslpinning.db.c;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.iap.ac.android.common.utils.security.RSAHelper;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.text.Typography;
import o.getOnBoardingScenario;

/* loaded from: classes.dex */
public class SSLPinningManager implements ISSLPinningManager {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int PlaceComponentResult = 0;
    private static String g = "SSLPinning";
    private static int getAuthRequestContext = 1;

    /* renamed from: a */
    private int f7084a;
    private Context b;
    private X509TrustManagerExtensions c;
    private final CertificateDatabase d;
    private final Handler e = new Handler(Looper.getMainLooper());
    private List<Certificate> f = new ArrayList();
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = 3047832268210855685L;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {18, -87, -121, -123, 6, -24, 18, TarHeader.LF_NORMAL, -72, 11, -1, -21, 0, 6, -14, -8, 72, -56, -5, -16, -5, 67, -24, -37, -16, -5, 8, 0, -6, 3, -1, -22, 12, Ascii.FS, -30, -5, -20, 2, -6, -10, -1, -18, 40, -40, -8, -4, 16, -16, 8, -5};
    public static final int MyBillsEntityDataFactory = 10;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ OnAddRemoteCertificatesListener f7085a;
        final /* synthetic */ List b;

        a(OnAddRemoteCertificatesListener onAddRemoteCertificatesListener, List list) {
            SSLPinningManager.this = r1;
            this.f7085a = onAddRemoteCertificatesListener;
            this.b = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = new b(this.f7085a, SSLPinningManager.a(SSLPinningManager.this).a());
            Executor executor = AsyncTask.SERIAL_EXECUTOR;
            List list = this.b;
            bVar.executeOnExecutor(executor, list.toArray(new String[list.size()]));
        }
    }

    static {
        int i = PlaceComponentResult + 43;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
    }

    public SSLPinningManager(Context context) {
        this.b = context;
        RoomDatabase.Builder KClassImpl$Data$declaredNonStaticMembers$22 = Room.KClassImpl$Data$declaredNonStaticMembers$2(context, CertificateDatabase.class, "database-cert");
        KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory = true;
        this.d = (CertificateDatabase) KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory();
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            X509TrustManager x509TrustManager = null;
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            int length = trustManagers.length;
            int i = 0;
            while (true) {
                if ((i < length ? Typography.greater : (char) 23) != '>') {
                    break;
                }
                int i2 = PlaceComponentResult + 63;
                getAuthRequestContext = i2 % 128;
                int i3 = i2 % 2;
                TrustManager trustManager = trustManagers[i];
                if (trustManager instanceof X509TrustManager) {
                    x509TrustManager = (X509TrustManager) trustManager;
                    break;
                }
                i++;
                int i4 = getAuthRequestContext + 73;
                PlaceComponentResult = i4 % 128;
                int i5 = i4 % 2;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                this.c = new X509TrustManagerExtensions(x509TrustManager);
            }
        } catch (KeyStoreException | NoSuchAlgorithmException unused) {
            LoggerWrapper.d(g, "Failed to construct X509TrustManagerExtensions");
        }
    }

    static /* synthetic */ CertificateDatabase a(SSLPinningManager sSLPinningManager) {
        CertificateDatabase certificateDatabase;
        int i = getAuthRequestContext + 75;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? (char) 1 : (char) 4) != 1) {
            try {
                certificateDatabase = sSLPinningManager.d;
            } catch (Exception e) {
                throw e;
            }
        } else {
            certificateDatabase = sSLPinningManager.d;
            int i2 = 44 / 0;
        }
        try {
            int i3 = getAuthRequestContext + 99;
            PlaceComponentResult = i3 % 128;
            if (!(i3 % 2 == 0)) {
                Object obj = null;
                obj.hashCode();
                return certificateDatabase;
            }
            return certificateDatabase;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x004c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x005c -> B:58:0x003c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void i(short r9, int r10, byte r11, java.lang.Object[] r12) {
        /*
            int r9 = r9 + 4
            int r11 = r11 * 3
            int r11 = r11 + 103
            byte[] r0 = com.alipay.imobile.network.sslpinning.SSLPinningManager.BuiltInFictitiousFunctionClassFactory
            int r10 = r10 * 26
            int r10 = r10 + 11
            byte[] r1 = new byte[r10]
            int r10 = r10 + (-1)
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L16
            r4 = 1
            goto L17
        L16:
            r4 = 0
        L17:
            if (r4 == 0) goto L3b
            int r4 = com.alipay.imobile.network.sslpinning.SSLPinningManager.PlaceComponentResult     // Catch: java.lang.Exception -> L39
            int r4 = r4 + 101
            int r5 = r4 % 128
            com.alipay.imobile.network.sslpinning.SSLPinningManager.getAuthRequestContext = r5     // Catch: java.lang.Exception -> L39
            int r4 = r4 % 2
            r5 = 49
            if (r4 != 0) goto L2a
            r4 = 51
            goto L2c
        L2a:
            r4 = 49
        L2c:
            if (r4 == r5) goto L34
            r4 = 44
            int r4 = r4 / r3
            goto L34
        L32:
            r9 = move-exception
            throw r9
        L34:
            r4 = r11
            r5 = 0
            r11 = r10
            r10 = r9
            goto L5c
        L39:
            r9 = move-exception
            throw r9
        L3b:
            r4 = 0
        L3c:
            int r9 = r9 + r2
            byte r5 = (byte) r11
            r1[r4] = r5
            int r5 = r4 + 1
            if (r4 != r10) goto L4c
            java.lang.String r9 = new java.lang.String
            r9.<init>(r1, r3)
            r12[r3] = r9
            return
        L4c:
            r4 = r0[r9]
            int r6 = com.alipay.imobile.network.sslpinning.SSLPinningManager.getAuthRequestContext
            int r6 = r6 + 53
            int r7 = r6 % 128
            com.alipay.imobile.network.sslpinning.SSLPinningManager.PlaceComponentResult = r7
            int r6 = r6 % 2
            r8 = r10
            r10 = r9
            r9 = r11
            r11 = r8
        L5c:
            int r4 = -r4
            int r9 = r9 + r4
            int r9 = r9 + (-3)
            r4 = r5
            r8 = r11
            r11 = r9
            r9 = r10
            r10 = r8
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.sslpinning.SSLPinningManager.i(short, int, byte, java.lang.Object[]):void");
    }

    @Override // com.alipay.imobile.network.sslpinning.api.ISSLPinningManager
    public void addAndPersistRemoteCertificates(List<String> list, OnAddRemoteCertificatesListener onAddRemoteCertificatesListener) {
        this.e.post(new a(onAddRemoteCertificatesListener, list));
        int i = getAuthRequestContext + 7;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    @Override // com.alipay.imobile.network.sslpinning.api.ISSLPinningManager
    public List<Certificate> getCertificates() {
        List<c> arrayList = new ArrayList<>();
        try {
            arrayList = this.d.a().a();
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("getCertificates error: ");
            sb.append(th.getMessage());
            InstrumentInjector.log_e("SSLPinningManager", sb.toString());
        }
        Object obj = null;
        if (arrayList.size() <= 0) {
            try {
                List<Certificate> list = this.f;
                int i = PlaceComponentResult + 29;
                getAuthRequestContext = i % 128;
                if ((i % 2 == 0 ? '=' : 'M') != '=') {
                    return list;
                }
                obj.hashCode();
                return list;
            } catch (Exception e) {
                throw e;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.f);
        int i2 = 0;
        while (true) {
            if ((i2 < arrayList.size() ? 'W' : (char) 6) != 'W') {
                break;
            }
            try {
                arrayList2.add(arrayList.get(i2).b);
                i2++;
                int i3 = getAuthRequestContext + 47;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i5 = getAuthRequestContext + 103;
        PlaceComponentResult = i5 % 128;
        if (i5 % 2 != 0) {
            obj.hashCode();
            return arrayList2;
        }
        return arrayList2;
    }

    @Override // com.alipay.imobile.network.sslpinning.api.ISSLPinningManager
    public void setPinningMode(int i) {
        String str;
        try {
            this.f7084a = i;
            try {
                String str2 = g;
                StringBuilder sb = new StringBuilder();
                sb.append("Set Pinning mode to ");
                if (!(i == 0)) {
                    str = "CERTIFICATE";
                } else {
                    int i2 = PlaceComponentResult + 29;
                    getAuthRequestContext = i2 % 128;
                    int i3 = i2 % 2;
                    str = "NONE";
                }
                sb.append(str);
                LoggerWrapper.d(str2, sb.toString());
                int i4 = getAuthRequestContext + 71;
                PlaceComponentResult = i4 % 128;
                if (!(i4 % 2 != 0)) {
                    return;
                }
                int i5 = 15 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x003e, code lost:
    
        if (r3.length > 0) goto L100;
     */
    @Override // com.alipay.imobile.network.sslpinning.api.ISSLPinningManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setPresetCertificateFolderPath(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.sslpinning.SSLPinningManager.setPresetCertificateFolderPath(java.lang.String):void");
    }

    @Override // com.alipay.imobile.network.sslpinning.api.ISSLPinningManager
    public void validateCertificates(HttpsURLConnection httpsURLConnection) throws SSLException {
        List<Certificate> certificates = getCertificates();
        boolean z = false;
        if (!(this.f7084a == 0)) {
            int i = getAuthRequestContext + 39;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            if (!certificates.isEmpty()) {
                String host = httpsURLConnection.getURL().getHost();
                for (int i3 = 0; i3 < certificates.size(); i3++) {
                    try {
                        Certificate certificate = certificates.get(i3);
                        if ((certificate instanceof X509Certificate ? 'I' : '5') != '5') {
                            try {
                                z = com.alipay.imobile.network.sslpinning.a.a.f7086a.a(host, (X509Certificate) certificate);
                                if (z) {
                                    break;
                                }
                            } catch (Exception e) {
                                throw e;
                            }
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
                if (!z) {
                    String str = g;
                    StringBuilder sb = new StringBuilder();
                    sb.append("No certificates pinned for ");
                    sb.append(host);
                    sb.append(", validation bypassed");
                    LoggerWrapper.d(str, sb.toString());
                    int i4 = getAuthRequestContext + 47;
                    PlaceComponentResult = i4 % 128;
                    int i5 = i4 % 2;
                    return;
                } else if (Build.VERSION.SDK_INT < 17) {
                    return;
                } else {
                    Iterator<X509Certificate> it = a(httpsURLConnection).iterator();
                    String str2 = "";
                    while (true) {
                        if ((it.hasNext() ? (char) 30 : ')') != ')') {
                            int i6 = getAuthRequestContext + 55;
                            PlaceComponentResult = i6 % 128;
                            int i7 = i6 % 2;
                            X509Certificate next = it.next();
                            if (certificates.contains(next)) {
                                String str3 = g;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Server certificates validation successful for ");
                                sb2.append(host);
                                LoggerWrapper.d(str3, sb2.toString());
                                return;
                            }
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(str2);
                            sb3.append("    ");
                            sb3.append(next.getSubjectDN().toString());
                            sb3.append("\n");
                            str2 = sb3.toString();
                        } else {
                            String str4 = g;
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("Server certificates validation failed for ");
                            sb4.append(host);
                            LoggerWrapper.d(str4, sb4.toString());
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("Certificate pinning failure\n  Peer certificate chain:\n");
                            sb5.append(str2);
                            throw new SSLPeerUnverifiedException(sb5.toString());
                        }
                    }
                }
            }
        }
        LoggerWrapper.d(g, "Pinning mode is NONE or local certificate list is empty, validation bypassed");
    }

    private List<X509Certificate> a(HttpsURLConnection httpsURLConnection) throws SSLException {
        int i = getAuthRequestContext + 15;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        if ((this.c != null ? '5' : 'N') != 'N') {
            int i3 = getAuthRequestContext + 57;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            Certificate[] serverCertificates = httpsURLConnection.getServerCertificates();
            try {
                List<X509Certificate> checkServerTrusted = this.c.checkServerTrusted((X509Certificate[]) Arrays.copyOf(serverCertificates, serverCertificates.length, X509Certificate[].class), RSAHelper.DEFAULT_ALGORITHM, httpsURLConnection.getURL().getHost());
                int i5 = getAuthRequestContext + 39;
                PlaceComponentResult = i5 % 128;
                if ((i5 % 2 != 0 ? (char) 7 : '4') != 7) {
                    return checkServerTrusted;
                }
                Object obj = null;
                obj.hashCode();
                return checkServerTrusted;
            } catch (CertificateException e) {
                throw new SSLException(e);
            }
        }
        try {
            throw new SSLException("X509TrustManagerExtensions is not available");
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.alipay.imobile.network.sslpinning.api.ISSLPinningManager
    public void addCertificates(List<String> list) throws CertificateException, IOException {
        int i = getAuthRequestContext + 21;
        PlaceComponentResult = i % 128;
        if (!(i % 2 == 0)) {
            int size = list.size();
            Object obj = null;
            obj.hashCode();
            if (size == 0) {
                return;
            }
        } else if (list.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            String str = list.get(i2);
            Object[] objArr = new Object[1];
            h((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 6708, new char[]{36371, 37927, 47722, 49396, 59050}, objArr);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(str.getBytes(Charset.forName(((String) objArr[0]).intern()))));
            this.f.add(certificateFactory.generateCertificate(bufferedInputStream));
            bufferedInputStream.close();
        }
        int i3 = getAuthRequestContext + 61;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
    }

    private static void h(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        int i2 = $10 + 109;
        $11 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if ((getonboardingscenario.getAuthRequestContext < cArr.length ? '+' : ':') == ':') {
                break;
            }
            try {
                int i4 = $10 + 117;
                $11 = i4 % 128;
                if (i4 % 2 != 0) {
                    jArr[getonboardingscenario.getAuthRequestContext] = (4796183387843776835L ^ KClassImpl$Data$declaredNonStaticMembers$2) ^ (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory));
                    getonboardingscenario.getAuthRequestContext++;
                } else {
                    try {
                        jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] % (getonboardingscenario.getAuthRequestContext % getonboardingscenario.MyBillsEntityDataFactory)) / (KClassImpl$Data$declaredNonStaticMembers$2 / 4796183387843776835L);
                        getonboardingscenario.getAuthRequestContext /= 1;
                    } catch (Exception e) {
                        throw e;
                    }
                }
            } catch (Exception e2) {
                throw e2;
            }
            throw e2;
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            if ((getonboardingscenario.getAuthRequestContext < cArr.length ? '\t' : 'F') != 'F') {
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                getonboardingscenario.getAuthRequestContext++;
            } else {
                objArr[0] = new String(cArr2);
                return;
            }
        }
    }
}
