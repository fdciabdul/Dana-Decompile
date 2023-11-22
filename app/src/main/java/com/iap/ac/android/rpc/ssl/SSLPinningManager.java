package com.iap.ac.android.rpc.ssl;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.net.http.X509TrustManagerExtensions;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.google.common.base.Ascii;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.utils.security.RSAHelper;
import com.iap.ac.android.rpc.ssl.api.ISSLPinningManager;
import com.iap.ac.android.rpc.ssl.api.OnAddRemoteCertificatesListener;
import com.iap.ac.android.rpc.ssl.db.CertificateDatabase;
import com.iap.ac.android.rpc.ssl.db.CertificateEntity;
import com.iap.ac.android.rpc.ssl.okhttp.OkHostnameVerifier;
import com.iap.ac.android.rpc.ssl.task.RemoteCertificateDownloadTask;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
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
import kotlin.text.Typography;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;
import o.getCallingPid;

/* loaded from: classes3.dex */
public class SSLPinningManager implements ISSLPinningManager {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final int BuiltInFictitiousFunctionClassFactory;
    private static String DEBUG_TAG = "SSLPinning";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char MyBillsEntityDataFactory = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static char[] PlaceComponentResult;
    public static final byte[] getAuthRequestContext;
    private final CertificateDatabase certificateDatabase;
    private Context context;
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private List<Certificate> pinnedCertificateList = new ArrayList();
    private int pinningMode;
    private X509TrustManagerExtensions x509TrustManagerExtensions;

    static {
        getAuthRequestContext();
        getAuthRequestContext = new byte[]{104, -1, -63, 36, 6, -24, 18, TarHeader.LF_NORMAL, -72, 11, -1, -21, 0, 6, -14, -8, 72, -56, -5, -16, -5, 67, -24, -37, -16, -5, 8, 0, -6, 3, -1, -22, 12, Ascii.FS, -30, -5, -20, 2, -6, -10, -1, -18, 40, -40, -8, -4, 16, -16, 8, -5};
        BuiltInFictitiousFunctionClassFactory = 120;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0054 -> B:25:0x005e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r8, byte r9, byte r10, java.lang.Object[] r11) {
        /*
            byte[] r0 = com.iap.ac.android.rpc.ssl.SSLPinningManager.getAuthRequestContext
            int r10 = r10 * 26
            int r10 = r10 + 11
            int r8 = r8 * 3
            int r8 = 106 - r8
            int r9 = r9 * 36
            int r9 = 40 - r9
            byte[] r1 = new byte[r10]
            r2 = 32
            if (r0 != 0) goto L17
            r3 = 97
            goto L19
        L17:
            r3 = 32
        L19:
            r4 = 1
            r5 = 0
            if (r3 == r2) goto L3a
            int r2 = com.iap.ac.android.rpc.ssl.SSLPinningManager.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r2 = r2 + 25
            int r3 = r2 % 128
            com.iap.ac.android.rpc.ssl.SSLPinningManager.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r2 = r2 % 2
            if (r2 == 0) goto L2b
            r2 = 1
            goto L2c
        L2b:
            r2 = 0
        L2c:
            if (r2 == 0) goto L33
            r2 = 0
            int r2 = r2.length     // Catch: java.lang.Throwable -> L31
            goto L33
        L31:
            r8 = move-exception
            throw r8
        L33:
            r2 = r1
            r6 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            r10 = r9
            goto L5e
        L3a:
            r2 = 0
        L3b:
            byte r3 = (byte) r8
            int r6 = r2 + 1
            r1[r2] = r3
            if (r6 != r10) goto L54
            java.lang.String r8 = new java.lang.String
            r8.<init>(r1, r5)
            int r9 = com.iap.ac.android.rpc.ssl.SSLPinningManager.KClassImpl$Data$declaredNonStaticMembers$2
            int r9 = r9 + 123
            int r10 = r9 % 128
            com.iap.ac.android.rpc.ssl.SSLPinningManager.NetworkUserEntityData$$ExternalSyntheticLambda0 = r10
            int r9 = r9 % 2
            r11[r5] = r8
            return
        L54:
            r2 = r0[r9]
            r7 = r9
            r9 = r8
            r8 = r2
            r2 = r1
            r1 = r0
            r0 = r11
            r11 = r10
            r10 = r7
        L5e:
            int r8 = -r8
            int r9 = r9 + r8
            int r8 = r9 + (-3)
            int r9 = r10 + 1
            r10 = r11
            r11 = r0
            r0 = r1
            r1 = r2
            r2 = r6
            goto L3b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.rpc.ssl.SSLPinningManager.b(int, byte, byte, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        MyBillsEntityDataFactory = (char) 42070;
        PlaceComponentResult = new char[]{42071, 37346, 37367, 42065, 37257, 37275, 42068, 37274, 42070};
    }

    static /* synthetic */ CertificateDatabase access$000(SSLPinningManager sSLPinningManager) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 103;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            return sSLPinningManager.certificateDatabase;
        }
        CertificateDatabase certificateDatabase = sSLPinningManager.certificateDatabase;
        Object[] objArr = null;
        int length = objArr.length;
        return certificateDatabase;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SSLPinningManager(android.content.Context r9) {
        /*
            r8 = this;
            r8.<init>()
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            r0.<init>(r1)
            r8.mainThreadHandler = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r8.pinnedCertificateList = r0
            r8.context = r9
            java.lang.Class<com.iap.ac.android.rpc.ssl.db.CertificateDatabase> r0 = com.iap.ac.android.rpc.ssl.db.CertificateDatabase.class
            java.lang.String r1 = "database-cert"
            androidx.room.RoomDatabase$Builder r9 = androidx.room.Room.KClassImpl$Data$declaredNonStaticMembers$2(r9, r0, r1)
            r0 = 1
            r9.BuiltInFictitiousFunctionClassFactory = r0
            androidx.room.RoomDatabase r9 = r9.BuiltInFictitiousFunctionClassFactory()
            com.iap.ac.android.rpc.ssl.db.CertificateDatabase r9 = (com.iap.ac.android.rpc.ssl.db.CertificateDatabase) r9
            r8.certificateDatabase = r9
            r9 = 0
            java.lang.String r1 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm()     // Catch: java.lang.Throwable -> L94
            javax.net.ssl.TrustManagerFactory r1 = javax.net.ssl.TrustManagerFactory.getInstance(r1)     // Catch: java.lang.Throwable -> L94
            r1.init(r9)     // Catch: java.lang.Throwable -> L94
            javax.net.ssl.TrustManager[] r1 = r1.getTrustManagers()     // Catch: java.lang.Throwable -> L94
            int r2 = r1.length     // Catch: java.lang.Throwable -> L94
            r3 = 0
            r4 = 0
        L3d:
            r5 = 40
            if (r4 >= r2) goto L44
            r6 = 88
            goto L46
        L44:
            r6 = 40
        L46:
            if (r6 == r5) goto L85
            int r5 = com.iap.ac.android.rpc.ssl.SSLPinningManager.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L83
            int r5 = r5 + 43
            int r6 = r5 % 128
            com.iap.ac.android.rpc.ssl.SSLPinningManager.NetworkUserEntityData$$ExternalSyntheticLambda0 = r6     // Catch: java.lang.Exception -> L83
            int r5 = r5 % 2
            if (r5 != 0) goto L56
            r5 = 0
            goto L57
        L56:
            r5 = 1
        L57:
            if (r5 == 0) goto L62
            r5 = r1[r4]     // Catch: java.lang.Throwable -> L94
            boolean r6 = r5 instanceof javax.net.ssl.X509TrustManager     // Catch: java.lang.Exception -> L60
            if (r6 == 0) goto L70
            goto L73
        L60:
            r9 = move-exception
            goto L80
        L62:
            r5 = r1[r4]     // Catch: java.lang.Throwable -> L94
            boolean r6 = r5 instanceof javax.net.ssl.X509TrustManager
            r7 = 75
            int r7 = r7 / r3
            if (r6 == 0) goto L6d
            r6 = 1
            goto L6e
        L6d:
            r6 = 0
        L6e:
            if (r6 == r0) goto L73
        L70:
            int r4 = r4 + 1
            goto L3d
        L73:
            javax.net.ssl.X509TrustManager r5 = (javax.net.ssl.X509TrustManager) r5     // Catch: java.lang.Throwable -> L94
            int r0 = com.iap.ac.android.rpc.ssl.SSLPinningManager.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L60
            int r0 = r0 + 75
            int r1 = r0 % 128
            com.iap.ac.android.rpc.ssl.SSLPinningManager.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1     // Catch: java.lang.Exception -> L60
            int r0 = r0 % 2
            goto L86
        L80:
            throw r9
        L81:
            r9 = move-exception
            throw r9
        L83:
            r9 = move-exception
            throw r9
        L85:
            r5 = r9
        L86:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L94
            r1 = 17
            if (r0 < r1) goto L9b
            android.net.http.X509TrustManagerExtensions r0 = new android.net.http.X509TrustManagerExtensions     // Catch: java.lang.Throwable -> L94
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L94
            r8.x509TrustManagerExtensions = r0     // Catch: java.lang.Throwable -> L94
            return
        L94:
            java.lang.String r0 = com.iap.ac.android.rpc.ssl.SSLPinningManager.DEBUG_TAG
            java.lang.String r1 = "Failed to construct X509TrustManagerExtensions"
            com.iap.ac.android.common.log.ACLog.d(r0, r1)
        L9b:
            int r0 = com.iap.ac.android.rpc.ssl.SSLPinningManager.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 111
            int r1 = r0 % 128
            com.iap.ac.android.rpc.ssl.SSLPinningManager.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 24
            if (r0 == 0) goto Lac
            r0 = 24
            goto Lae
        Lac:
            r0 = 97
        Lae:
            if (r0 == r1) goto Lb1
            return
        Lb1:
            int r9 = r9.length     // Catch: java.lang.Throwable -> Lb3
            return
        Lb3:
            r9 = move-exception
            goto Lb6
        Lb5:
            throw r9
        Lb6:
            goto Lb5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.rpc.ssl.SSLPinningManager.<init>(android.content.Context):void");
    }

    @Override // com.iap.ac.android.rpc.ssl.api.ISSLPinningManager
    public void setPresetCertificateFolderPath(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            String[] list = this.context.getAssets().list(str);
            if (list != null) {
                if ((list.length > 0 ? 'R' : Typography.greater) == 'R') {
                    for (String str2 : list) {
                        AssetManager assets = this.context.getAssets();
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append("/");
                        sb.append(str2);
                        try {
                            Object[] objArr = {assets, sb.toString()};
                            Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                            if (obj == null) {
                                obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (View.getDefaultSize(0, 0) + 58133), KeyEvent.getMaxKeyCode() >> 16, Color.argb(0, 0, 0, 0) + 49)).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                                NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                            }
                            InputStream inputStream = (InputStream) ((Method) obj).invoke(null, objArr);
                            try {
                                byte b = getAuthRequestContext[12];
                                byte b2 = (byte) (-getAuthRequestContext[1]);
                                Object[] objArr2 = new Object[1];
                                b(b, b2, b2, objArr2);
                                Class<?> cls = Class.forName((String) objArr2[0]);
                                byte b3 = (byte) (-getAuthRequestContext[1]);
                                byte b4 = getAuthRequestContext[12];
                                Object[] objArr3 = new Object[1];
                                b(b3, b4, b4, objArr3);
                                Object invoke = cls.getMethod((String) objArr3[0], String.class).invoke(null, "X.509");
                                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 91;
                                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                                int i2 = i % 2;
                                try {
                                    Object[] objArr4 = {inputStream};
                                    byte b5 = getAuthRequestContext[12];
                                    byte b6 = (byte) (-getAuthRequestContext[1]);
                                    Object[] objArr5 = new Object[1];
                                    b(b5, b6, b6, objArr5);
                                    arrayList.add(Class.forName((String) objArr5[0]).getMethod("generateCertificate", InputStream.class).invoke(invoke, objArr4));
                                    inputStream.close();
                                } catch (Throwable th) {
                                    Throwable cause = th.getCause();
                                    if (cause == null) {
                                        throw th;
                                    }
                                    throw cause;
                                }
                            } catch (Throwable th2) {
                                Throwable cause2 = th2.getCause();
                                if (cause2 == null) {
                                    throw th2;
                                }
                                throw cause2;
                            }
                        } catch (Throwable th3) {
                            Throwable cause3 = th3.getCause();
                            if (cause3 == null) {
                                throw th3;
                            }
                            throw cause3;
                        }
                    }
                }
            }
            this.pinnedCertificateList.addAll(arrayList);
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 105;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = 64 / 0;
            }
        } catch (IOException | CertificateException unused) {
            ACLog.d(DEBUG_TAG, "Error in getting the certificate from assets folder");
        }
    }

    @Override // com.iap.ac.android.rpc.ssl.api.ISSLPinningManager
    public void addCertificates(List<String> list) throws CertificateException, IOException {
        if (list.size() == 0) {
            return;
        }
        int i = 0;
        while (i < list.size()) {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            String str = list.get(i);
            Object[] objArr = new Object[1];
            a(new char[]{'\b', 4, 7, 4, 13815}, (byte) (84 - TextUtils.indexOf((CharSequence) "", '0')), 5 - View.resolveSize(0, 0), objArr);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(str.getBytes(Charset.forName(((String) objArr[0]).intern()))));
            this.pinnedCertificateList.add(certificateFactory.generateCertificate(bufferedInputStream));
            bufferedInputStream.close();
            i++;
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 13;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
            int i3 = i2 % 2;
        }
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 105;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
        int i5 = i4 % 2;
    }

    @Override // com.iap.ac.android.rpc.ssl.api.ISSLPinningManager
    public void addAndPersistRemoteCertificates(final List<String> list, final OnAddRemoteCertificatesListener onAddRemoteCertificatesListener) {
        this.mainThreadHandler.post(new Runnable() { // from class: com.iap.ac.android.rpc.ssl.SSLPinningManager.1
            @Override // java.lang.Runnable
            public void run() {
                RemoteCertificateDownloadTask remoteCertificateDownloadTask = new RemoteCertificateDownloadTask(onAddRemoteCertificatesListener, SSLPinningManager.access$000(SSLPinningManager.this).certificateDao());
                Executor executor = AsyncTask.SERIAL_EXECUTOR;
                List list2 = list;
                remoteCertificateDownloadTask.executeOnExecutor(executor, list2.toArray(new String[list2.size()]));
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 93;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 == 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    @Override // com.iap.ac.android.rpc.ssl.api.ISSLPinningManager
    public void setPinningMode(int i) {
        String str;
        this.pinningMode = i;
        String str2 = DEBUG_TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Set Pinning mode to ");
        if (i != 0) {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 117;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            str = "CERTIFICATE";
        } else {
            try {
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 117;
                KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                int i5 = i4 % 2;
                str = "NONE";
                int i6 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 81;
                KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                int i7 = i6 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        sb.append(str);
        try {
            ACLog.d(str2, sb.toString());
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.iap.ac.android.rpc.ssl.api.ISSLPinningManager
    public void validateCertificates(HttpsURLConnection httpsURLConnection) throws SSLException {
        String host;
        try {
            List<Certificate> certificates = getCertificates();
            if (this.pinningMode != 0) {
                if (!certificates.isEmpty()) {
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                    if (i % 2 == 0) {
                        host = httpsURLConnection.getURL().getHost();
                    } else {
                        try {
                            host = httpsURLConnection.getURL().getHost();
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    boolean z = false;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= certificates.size()) {
                            break;
                        }
                        Certificate certificate = certificates.get(i2);
                        if (certificate instanceof X509Certificate) {
                            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 1;
                            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                            int i4 = i3 % 2;
                            z = OkHostnameVerifier.INSTANCE.verify(host, (X509Certificate) certificate);
                            if (z) {
                                int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
                                NetworkUserEntityData$$ExternalSyntheticLambda0 = i5 % 128;
                                int i6 = i5 % 2;
                                break;
                            }
                        }
                        i2++;
                    }
                    if (!z) {
                        String str = DEBUG_TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("No certificates pinned for ");
                        sb.append(host);
                        sb.append(", validation bypassed");
                        ACLog.d(str, sb.toString());
                        return;
                    } else if (Build.VERSION.SDK_INT < 17) {
                        int i7 = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
                        NetworkUserEntityData$$ExternalSyntheticLambda0 = i7 % 128;
                        int i8 = i7 % 2;
                        return;
                    } else {
                        Iterator<X509Certificate> it = trustedChain(httpsURLConnection).iterator();
                        String str2 = "";
                        while (true) {
                            if (!(it.hasNext())) {
                                String str3 = DEBUG_TAG;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Server certificates validation failed for ");
                                sb2.append(host);
                                ACLog.d(str3, sb2.toString());
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Certificate pinning failure\n  Peer certificate chain:\n");
                                sb3.append(str2);
                                throw new SSLPeerUnverifiedException(sb3.toString());
                            }
                            X509Certificate next = it.next();
                            if (certificates.contains(next)) {
                                String str4 = DEBUG_TAG;
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("Server certificates validation successful for ");
                                sb4.append(host);
                                ACLog.d(str4, sb4.toString());
                                return;
                            }
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(str2);
                            sb5.append("    ");
                            sb5.append(next.getSubjectDN().toString());
                            sb5.append("\n");
                            str2 = sb5.toString();
                        }
                    }
                }
            }
            ACLog.d(DEBUG_TAG, "Pinning mode is NONE or local certificate list is empty, validation bypassed");
            int i9 = KClassImpl$Data$declaredNonStaticMembers$2 + 83;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i9 % 128;
            int i10 = i9 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.iap.ac.android.rpc.ssl.api.ISSLPinningManager
    public List<Certificate> getCertificates() {
        List<CertificateEntity> loadAllCertificates = this.certificateDatabase.certificateDao().loadAllCertificates();
        try {
            if (loadAllCertificates.size() <= 0) {
                return this.pinnedCertificateList;
            }
            ArrayList arrayList = new ArrayList(this.pinnedCertificateList);
            int i = 0;
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 75;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            while (true) {
                if ((i < loadAllCertificates.size() ? 'L' : (char) 1) == 1) {
                    return arrayList;
                }
                try {
                    int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 31;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                    int i5 = i4 % 2;
                    arrayList.add(loadAllCertificates.get(i).certificateData);
                    i++;
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private List<X509Certificate> trustedChain(HttpsURLConnection httpsURLConnection) throws SSLException {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 83;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            if ((this.x509TrustManagerExtensions != null ? ')' : 'A') == 'A') {
                throw new SSLException("X509TrustManagerExtensions is not available");
            }
            Certificate[] serverCertificates = httpsURLConnection.getServerCertificates();
            try {
                List<X509Certificate> checkServerTrusted = this.x509TrustManagerExtensions.checkServerTrusted((X509Certificate[]) Arrays.copyOf(serverCertificates, serverCertificates.length, X509Certificate[].class), RSAHelper.DEFAULT_ALGORITHM, httpsURLConnection.getURL().getHost());
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 51;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if ((i3 % 2 != 0 ? '9' : Typography.quote) != '\"') {
                    int i4 = 57 / 0;
                    return checkServerTrusted;
                }
                return checkServerTrusted;
            } catch (CertificateException e) {
                throw new SSLException(e);
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = PlaceComponentResult;
        if (!(cArr2 == null)) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = $11 + 11;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ MyBillsEntityDataFactory);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if ((i2 > 1 ? '*' : ',') != ',') {
            int i6 = $10 + 7;
            $11 = i6 % 128;
            if (!(i6 % 2 != 0)) {
                getcallingpid.getAuthRequestContext = 1;
            } else {
                getcallingpid.getAuthRequestContext = 0;
            }
            while (true) {
                if (!(getcallingpid.getAuthRequestContext < i2)) {
                    break;
                }
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if ((getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult ? JSONLexer.EOI : 'U') != 26) {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                        try {
                            getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                            getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                            int i7 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i8 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i7];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i8];
                        } catch (Exception e) {
                            throw e;
                        }
                    } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                        getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                        getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                        int i9 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i10 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i9];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i10];
                    } else {
                        int i11 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                        int i12 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i11];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i12];
                    }
                } else {
                    int i13 = $11 + 95;
                    $10 = i13 % 128;
                    if (i13 % 2 != 0) {
                        cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory * b);
                        cArr4[getcallingpid.getAuthRequestContext << 0] = (char) (getcallingpid.PlaceComponentResult / b);
                    } else {
                        cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                        cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        int i14 = 0;
        while (i14 < i) {
            int i15 = $10 + 7;
            $11 = i15 % 128;
            if (i15 % 2 == 0) {
                cArr4[i14] = (char) (cArr4[i14] & 404);
                i14 += 83;
            } else {
                cArr4[i14] = (char) (cArr4[i14] ^ 13722);
                i14++;
            }
        }
        objArr[0] = new String(cArr4);
    }
}
