package com.mixpanel.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import o.A;

/* loaded from: classes.dex */
public class HttpService implements RemoteService {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 269894691;
    private static boolean PlaceComponentResult = false;
    private static int getAuthRequestContext = 1;

    static /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory() {
        boolean z;
        try {
            int i = getAuthRequestContext + 35;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (!(i % 2 != 0)) {
                z = PlaceComponentResult;
            } else {
                z = PlaceComponentResult;
                Object obj = null;
                obj.hashCode();
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 43;
            getAuthRequestContext = i2 % 128;
            int i3 = i2 % 2;
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ boolean getAuthRequestContext(boolean z) {
        int i = getAuthRequestContext + 81;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        Object[] objArr = null;
        if (i % 2 == 0) {
            PlaceComponentResult = z;
        } else {
            PlaceComponentResult = z;
            int length = objArr.length;
        }
        try {
            int i2 = getAuthRequestContext + 45;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            if (i2 % 2 == 0) {
                return z;
            }
            objArr.hashCode();
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.mixpanel.android.util.RemoteService
    public final void getAuthRequestContext() {
        new Thread(new Runnable() { // from class: com.mixpanel.android.util.HttpService.1
            /* JADX WARN: Removed duplicated region for block: B:15:0x0031 A[Catch: Exception -> 0x0038, TRY_LEAVE, TryCatch #0 {Exception -> 0x0038, blocks: (B:2:0x0000, B:4:0x0012, B:6:0x0018, B:8:0x001e, B:13:0x0028, B:15:0x0031), top: B:18:0x0000 }] */
            /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r3 = this;
                    java.lang.String r0 = "api.mixpanel.com"
                    java.net.InetAddress r0 = java.net.InetAddress.getByName(r0)     // Catch: java.lang.Exception -> L38
                    java.lang.String r1 = "decide.mixpanel.com"
                    java.net.InetAddress r1 = java.net.InetAddress.getByName(r1)     // Catch: java.lang.Exception -> L38
                    boolean r2 = r0.isLoopbackAddress()     // Catch: java.lang.Exception -> L38
                    if (r2 != 0) goto L27
                    boolean r0 = r0.isAnyLocalAddress()     // Catch: java.lang.Exception -> L38
                    if (r0 != 0) goto L27
                    boolean r0 = r1.isLoopbackAddress()     // Catch: java.lang.Exception -> L38
                    if (r0 != 0) goto L27
                    boolean r0 = r1.isAnyLocalAddress()     // Catch: java.lang.Exception -> L38
                    if (r0 == 0) goto L25
                    goto L27
                L25:
                    r0 = 0
                    goto L28
                L27:
                    r0 = 1
                L28:
                    com.mixpanel.android.util.HttpService.getAuthRequestContext(r0)     // Catch: java.lang.Exception -> L38
                    boolean r0 = com.mixpanel.android.util.HttpService.BuiltInFictitiousFunctionClassFactory()     // Catch: java.lang.Exception -> L38
                    if (r0 == 0) goto L38
                    java.lang.String r0 = "MixpanelAPI.Message"
                    java.lang.String r1 = "AdBlocker is enabled. Won't be able to use Mixpanel services."
                    com.mixpanel.android.util.MPLog.KClassImpl$Data$declaredNonStaticMembers$2(r0, r1)     // Catch: java.lang.Exception -> L38
                L38:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.util.HttpService.AnonymousClass1.run():void");
            }
        }).start();
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 1;
            getAuthRequestContext = i % 128;
            if ((i % 2 == 0 ? 'X' : 'c') != 'c') {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.mixpanel.android.util.RemoteService
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Context context, OfflineMode offlineMode) {
        try {
            if (PlaceComponentResult) {
                int i = getAuthRequestContext + 115;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                int i3 = BuiltInFictitiousFunctionClassFactory + 55;
                getAuthRequestContext = i3 % 128;
                if (i3 % 2 == 0) {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return false;
                }
                return false;
            }
            if (!(!MyBillsEntityDataFactory(offlineMode))) {
                try {
                    int i4 = BuiltInFictitiousFunctionClassFactory + 15;
                    getAuthRequestContext = i4 % 128;
                    if (i4 % 2 != 0) {
                    }
                    return false;
                } catch (Exception e) {
                    throw e;
                }
            }
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    int i5 = BuiltInFictitiousFunctionClassFactory + 27;
                    getAuthRequestContext = i5 % 128;
                    int i6 = i5 % 2;
                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.Message", "A default network has not been set so we cannot be certain whether we are offline");
                } else {
                    boolean isConnectedOrConnecting = activeNetworkInfo.isConnectedOrConnecting();
                    StringBuilder sb = new StringBuilder();
                    sb.append("ConnectivityManager says we ");
                    sb.append(isConnectedOrConnecting ? "are" : "are not");
                    sb.append(" online");
                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.Message", sb.toString());
                    r2 = isConnectedOrConnecting;
                }
            } catch (SecurityException unused) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.Message", "Don't have permission to check connectivity, will assume we are online");
            }
            return r2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static boolean MyBillsEntityDataFactory(OfflineMode offlineMode) {
        int i = BuiltInFictitiousFunctionClassFactory + 99;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        if (offlineMode != null) {
            try {
                if ((offlineMode.getAuthRequestContext() ? '.' : '5') != '5') {
                    try {
                        int i3 = BuiltInFictitiousFunctionClassFactory + 71;
                        try {
                            getAuthRequestContext = i3 % 128;
                            return (i3 % 2 == 0 ? '\f' : 'X') == 'X';
                        } catch (Exception e) {
                            throw e;
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
                return false;
            } catch (Exception e3) {
                MPLog.MyBillsEntityDataFactory("MixpanelAPI.Message", "Client State should not throw exception, will assume is not on offline mode", e3);
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0283 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x025c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006c A[Catch: all -> 0x0195, IOException -> 0x0197, EOFException -> 0x01d5, TryCatch #22 {EOFException -> 0x01d5, IOException -> 0x0197, all -> 0x0195, blocks: (B:21:0x0062, B:22:0x006c, B:23:0x0072, B:25:0x007e, B:26:0x008b, B:33:0x00a3, B:35:0x00bc, B:36:0x00d7, B:52:0x015e), top: B:229:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:243:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007e A[Catch: all -> 0x0195, IOException -> 0x0197, EOFException -> 0x01d5, TryCatch #22 {EOFException -> 0x01d5, IOException -> 0x0197, all -> 0x0195, blocks: (B:21:0x0062, B:22:0x006c, B:23:0x0072, B:25:0x007e, B:26:0x008b, B:33:0x00a3, B:35:0x00bc, B:36:0x00d7, B:52:0x015e), top: B:229:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b5 A[Catch: all -> 0x01cc, TryCatch #21 {all -> 0x01cc, blocks: (B:85:0x01ad, B:87:0x01b5, B:89:0x01bd, B:90:0x01ca, B:91:0x01cb), top: B:214:0x01ad }] */
    @Override // com.mixpanel.android.util.RemoteService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] BuiltInFictitiousFunctionClassFactory(java.lang.String r24, java.util.Map<java.lang.String, java.lang.Object> r25, javax.net.ssl.SSLSocketFactory r26) throws com.mixpanel.android.util.RemoteService.ServiceUnavailableException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 671
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.util.HttpService.BuiltInFictitiousFunctionClassFactory(java.lang.String, java.util.Map, javax.net.ssl.SSLSocketFactory):byte[]");
    }

    private static byte[] MyBillsEntityDataFactory(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (!(read != -1)) {
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                int i = getAuthRequestContext + 25;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                return byteArray;
            }
            int i3 = BuiltInFictitiousFunctionClassFactory + 37;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        int i4 = $11 + 21;
        $10 = i4 % 128;
        int i5 = i4 % 2;
        while (a2.MyBillsEntityDataFactory < i2) {
            try {
                int i6 = $11 + 13;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                int i8 = a2.MyBillsEntityDataFactory;
                cArr2[i8] = (char) (cArr2[i8] - ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
            } catch (Exception e) {
                throw e;
            }
        }
        if ((i3 > 0 ? 'L' : 'Y') != 'Y') {
            int i9 = $11 + 119;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            a2.BuiltInFictitiousFunctionClassFactory = i3;
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr2, 0, cArr3, 0, i2);
            System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if ((z ? '\\' : 'Q') == '\\') {
            try {
                int i11 = $11 + 7;
                $10 = i11 % 128;
                int i12 = i11 % 2;
                char[] cArr4 = new char[i2];
                a2.MyBillsEntityDataFactory = 0;
                int i13 = $11 + 125;
                $10 = i13 % 128;
                int i14 = i13 % 2;
                while (true) {
                    if (!(a2.MyBillsEntityDataFactory < i2)) {
                        break;
                    }
                    int i15 = $11 + 71;
                    $10 = i15 % 128;
                    int i16 = i15 % 2;
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    a2.MyBillsEntityDataFactory++;
                }
                cArr2 = cArr4;
            } catch (Exception e2) {
                throw e2;
            }
        }
        objArr[0] = new String(cArr2);
    }
}
