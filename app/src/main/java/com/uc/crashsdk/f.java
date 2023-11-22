package com.uc.crashsdk;

import android.app.ActivityManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.os.StatFs;
import android.telephony.cdma.CdmaCellLocation;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.huawei.hms.utils.FileUtil;
import com.uc.crashsdk.export.CrashApi;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import kotlin.text.Typography;
import o.C;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

/* loaded from: classes8.dex */
public class f implements Thread.UncaughtExceptionHandler {
    private static int $10 = 0;
    private static int $11 = 1;
    private static boolean A = false;
    private static Runnable B = null;
    public static final byte[] BuiltInFictitiousFunctionClassFactory;
    private static Object C = null;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char MyBillsEntityDataFactory = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    public static final int PlaceComponentResult;

    /* renamed from: a  reason: collision with root package name */
    static String f7722a = null;
    static final /* synthetic */ boolean b = true;
    private static long c = 0;
    private static volatile boolean d = false;
    private static boolean e = false;
    private static boolean g = true;
    private static char getAuthRequestContext = 0;
    private static String h = null;
    private static int i = 8;
    private static int j = 128;
    private static boolean k;
    private static String l;
    private static int lookAheadTest;
    private static Object m;
    private static char moveToNextValue;
    private static Object n;

    /* renamed from: o  reason: collision with root package name */
    private static Object f7723o;
    private static Object p;
    private static ArrayList<String> q;
    private static int r;
    private static String s;
    private static boolean t;
    private static String u;
    private static String v;
    private static String w;
    private static Object x;
    private static Thread.UncaughtExceptionHandler y;
    private static Throwable z;
    private final List<FileInputStream> f = new ArrayList();

    static void BuiltInFictitiousFunctionClassFactory() {
        getAuthRequestContext = (char) 14254;
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 42237;
        moveToNextValue = (char) 33696;
        MyBillsEntityDataFactory = (char) 51651;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        if (r0 == null) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0068 -> B:26:0x0071). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void E(int r8, byte r9, int r10, java.lang.Object[] r11) {
        /*
            int r0 = com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 33
            int r1 = r0 % 128
            com.uc.crashsdk.f.lookAheadTest = r1
            int r0 = r0 % 2
            r1 = 79
            if (r0 == 0) goto L11
            r0 = 64
            goto L13
        L11:
            r0 = 79
        L13:
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 == r1) goto L38
            byte[] r0 = com.uc.crashsdk.f.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L36
            int r8 = r2 >> r8
            int r8 = r8 + 99
            int r9 = r9 + 87
            r1 = 65
            int r1 = r1 / r10
            byte[] r10 = new byte[r8]     // Catch: java.lang.Exception -> L36
            int r8 = r8 + 77
            r2 = 97
            if (r0 != 0) goto L2e
            r5 = 26
            goto L30
        L2e:
            r5 = 97
        L30:
            if (r5 == r2) goto L34
            r2 = 1
            goto L48
        L34:
            r2 = 1
            goto L59
        L36:
            r8 = move-exception
            goto L7c
        L38:
            byte[] r0 = com.uc.crashsdk.f.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L36
            int r8 = r8 * 3
            int r8 = r8 + 13
            int r9 = r9 + r2
            int r1 = 106 - r10
            byte[] r10 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L59
        L48:
            int r5 = com.uc.crashsdk.f.lookAheadTest
            int r5 = r5 + 73
            int r6 = r5 % 128
            com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0 = r6
            int r5 = r5 % 2
            r5 = r2
            r2 = r1
            r1 = r0
            r0 = r11
            r11 = r10
            r10 = r9
            goto L71
        L59:
            byte r5 = (byte) r1
            r10[r2] = r5
            int r5 = r2 + 1
            if (r2 != r8) goto L68
            java.lang.String r8 = new java.lang.String
            r8.<init>(r10, r3)
            r11[r3] = r8
            return
        L68:
            int r9 = r9 + r4
            r2 = r0[r9]
            r7 = r10
            r10 = r9
            r9 = r1
            r1 = r0
            r0 = r11
            r11 = r7
        L71:
            int r9 = r9 + r2
            int r9 = r9 + 2
            r2 = r5
            r7 = r1
            r1 = r9
            r9 = r10
            r10 = r11
            r11 = r0
            r0 = r7
            goto L59
        L7c:
            goto L7e
        L7d:
            throw r8
        L7e:
            goto L7d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.E(int, byte, int, java.lang.Object[]):void");
    }

    static /* synthetic */ void a(Throwable th) {
        int i2 = lookAheadTest + 61;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        com.uc.crashsdk.a.a.a(th, false);
        int i4 = lookAheadTest + 21;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
        int i5 = i4 % 2;
    }

    static /* synthetic */ void e(String str) {
        File file = new File(com.uc.crashsdk.b.e());
        Object[] objArr = null;
        if (!k) {
            k = true;
            JNIBridge.nativeSyncInfo("mLogTypeSuffix", !(!file.exists()) ? a(com.uc.crashsdk.a.b.a(file, j, true)) : null, 1L, 0L);
        }
        if ((com.uc.crashsdk.a.h.a(str) ? 'X' : '4') == '4') {
            com.uc.crashsdk.a.b.a(file, str.getBytes());
            return;
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 63;
        lookAheadTest = i2 % 128;
        int i3 = i2 % 2;
        com.uc.crashsdk.a.b.a(file);
        int i4 = lookAheadTest + 67;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
        if (i4 % 2 == 0) {
            int length = objArr.length;
        }
    }

    static /* synthetic */ boolean q() {
        int i2 = lookAheadTest + 35;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        try {
            boolean z2 = g;
            int i4 = lookAheadTest + 5;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
            int i5 = i4 % 2;
            return z2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ void r() {
        boolean z2 = true;
        if (CrashApi.getInstance().getLastExitType() != 5) {
            z2 = false;
        } else {
            int i2 = lookAheadTest + 99;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
            int i3 = i2 % 2;
        }
        JNIBridge.nativePrepareUnexpInfos(z2);
        com.uc.crashsdk.a.a(false);
        int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 29;
        lookAheadTest = i4 % 128;
        int i5 = i4 % 2;
    }

    static /* synthetic */ void s() {
        int i2;
        synchronized (C) {
            if (B == null) {
                return;
            }
            A = true;
            int nativeGenerateUnexpLog = JNIBridge.nativeGenerateUnexpLog(p.o());
            if (nativeGenerateUnexpLog != 0) {
                k.a(11);
                if (nativeGenerateUnexpLog == 2) {
                    i2 = 10;
                } else if (nativeGenerateUnexpLog == 3) {
                    i2 = 29;
                } else if (nativeGenerateUnexpLog == 4) {
                    i2 = 30;
                } else {
                    if (nativeGenerateUnexpLog == 5) {
                        i2 = 31;
                    }
                    c(true);
                }
                k.a(i2);
                c(true);
            }
            synchronized (C) {
                B = null;
            }
        }
    }

    static /* synthetic */ void t() {
        try {
            int i2 = lookAheadTest + 121;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
                int i3 = i2 % 2;
                B();
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 13;
                lookAheadTest = i4 % 128;
                if (i4 % 2 == 0) {
                    return;
                }
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    static /* synthetic */ Object u() {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 51;
        lookAheadTest = i2 % 128;
        if (i2 % 2 != 0) {
            Object obj = m;
            Object obj2 = null;
            obj2.hashCode();
            return obj;
        }
        try {
            return m;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public f() {
        try {
            v();
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
        }
    }

    private void v() {
        int D;
        int i2 = lookAheadTest + 37;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = 1;
        if (i2 % 2 != 0) {
            try {
                D = p.D();
                i3 = 0;
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            D = p.D();
        }
        while (i3 < D) {
            try {
                this.f.add(new FileInputStream("/dev/null"));
                i3++;
            } catch (Exception e3) {
                com.uc.crashsdk.a.a.a(e3, false);
            }
        }
        try {
            int i4 = lookAheadTest + 125;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e4) {
            throw e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static final class b extends OutputStream {
        private static int $10 = 0;
        private static int $11 = 1;
        private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
        private static char[] MyBillsEntityDataFactory = {35444, 35393, 35430, 35736, 35737};
        private static int getAuthRequestContext;

        /* renamed from: a  reason: collision with root package name */
        private final OutputStream f7725a;
        private int b = 0;
        private int c = 0;
        private boolean d = false;

        public b(OutputStream outputStream) {
            this.f7725a = outputStream;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
        
            if (((r1 >>> r9) > r0 ? 19 : 'U') != 19) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
        
            if ((r1 + r9) > r0) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
        
            r2 = com.uc.crashsdk.f.b.KClassImpl$Data$declaredNonStaticMembers$2 + 103;
            com.uc.crashsdk.f.b.getAuthRequestContext = r2 % 128;
            r2 = r2 % 2;
            r0 = r0 - r1;
         */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int a(byte[] r7, int r8, int r9) {
            /*
                r6 = this;
                int r0 = r6.c
                int r0 = r0 + r9
                r6.c = r0
                boolean r0 = r6.d
                r1 = 21
                r2 = 81
                if (r0 == 0) goto L10
                r0 = 21
                goto L12
            L10:
                r0 = 81
            L12:
                r3 = 0
                r4 = 1
                if (r0 == r1) goto L60
                int r0 = com.uc.crashsdk.p.w()
                if (r0 <= 0) goto L4a
                int r1 = com.uc.crashsdk.f.b.KClassImpl$Data$declaredNonStaticMembers$2
                int r1 = r1 + 117
                int r2 = r1 % 128
                com.uc.crashsdk.f.b.getAuthRequestContext = r2
                int r1 = r1 % 2
                if (r1 == 0) goto L38
                int r1 = r6.b
                int r2 = r1 >>> r9
                r5 = 19
                if (r2 <= r0) goto L33
                r2 = 19
                goto L35
            L33:
                r2 = 85
            L35:
                if (r2 == r5) goto L3e
                goto L4a
            L38:
                int r1 = r6.b
                int r2 = r1 + r9
                if (r2 <= r0) goto L4a
            L3e:
                int r2 = com.uc.crashsdk.f.b.KClassImpl$Data$declaredNonStaticMembers$2
                int r2 = r2 + 103
                int r5 = r2 % 128
                com.uc.crashsdk.f.b.getAuthRequestContext = r5
                int r2 = r2 % 2
                int r0 = r0 - r1
                goto L4b
            L4a:
                r0 = r9
            L4b:
                int r1 = r6.b     // Catch: java.lang.Exception -> L5e
                int r1 = r1 + r0
                r6.b = r1     // Catch: java.lang.Exception -> L5e
                java.io.OutputStream r1 = r6.f7725a     // Catch: java.lang.Exception -> L5e
                r1.write(r7, r8, r0)     // Catch: java.lang.Exception -> L5e
                if (r0 >= r9) goto L58
                r3 = 1
            L58:
                if (r3 == r4) goto L5b
                goto L5d
            L5b:
                r6.d = r4
            L5d:
                return r0
            L5e:
                r7 = move-exception
                throw r7
            L60:
                int r7 = com.uc.crashsdk.f.b.getAuthRequestContext
                int r7 = r7 + r2
                int r8 = r7 % 128
                com.uc.crashsdk.f.b.KClassImpl$Data$declaredNonStaticMembers$2 = r8
                int r7 = r7 % 2
                if (r7 != 0) goto L6c
                return r4
            L6c:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.b.a(byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        
            if ((r12.c - r12.b) > 0) goto L19;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a() {
            /*
                Method dump skipped, instructions count: 231
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.b.a():void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
        
            if (com.uc.crashsdk.p.G() != false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
        
            if (com.uc.crashsdk.p.G() != false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
        
            com.uc.crashsdk.a.c.a("DEBUG", new java.lang.String(r3));
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(byte[] r3) {
            /*
                r2 = this;
                int r0 = com.uc.crashsdk.f.b.getAuthRequestContext     // Catch: java.lang.Exception -> L5d
                int r0 = r0 + 117
                int r1 = r0 % 128
                com.uc.crashsdk.f.b.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L5d
                int r0 = r0 % 2
                boolean r0 = com.uc.crashsdk.f.q()     // Catch: java.lang.Exception -> L5b
                r1 = 25
                if (r0 == 0) goto L15
                r0 = 83
                goto L17
            L15:
                r0 = 25
            L17:
                if (r0 == r1) goto L4b
                int r0 = com.uc.crashsdk.f.b.KClassImpl$Data$declaredNonStaticMembers$2
                int r0 = r0 + 77
                int r1 = r0 % 128
                com.uc.crashsdk.f.b.getAuthRequestContext = r1
                int r0 = r0 % 2
                r1 = 8
                if (r0 == 0) goto L2a
                r0 = 20
                goto L2c
            L2a:
                r0 = 8
            L2c:
                if (r0 == r1) goto L3b
                boolean r0 = com.uc.crashsdk.p.G()
                r1 = 85
                int r1 = r1 / 0
                if (r0 == 0) goto L4b
                goto L41
            L39:
                r3 = move-exception
                throw r3
            L3b:
                boolean r0 = com.uc.crashsdk.p.G()
                if (r0 == 0) goto L4b
            L41:
                java.lang.String r0 = "DEBUG"
                java.lang.String r1 = new java.lang.String
                r1.<init>(r3)
                com.uc.crashsdk.a.c.a(r0, r1)     // Catch: java.lang.Exception -> L5d
            L4b:
                java.io.OutputStream r0 = r2.f7725a
                r0.write(r3)
                int r3 = com.uc.crashsdk.f.b.KClassImpl$Data$declaredNonStaticMembers$2
                int r3 = r3 + 115
                int r0 = r3 % 128
                com.uc.crashsdk.f.b.getAuthRequestContext = r0
                int r3 = r3 % 2
                return
            L5b:
                r3 = move-exception
                throw r3
            L5d:
                r3 = move-exception
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.b.a(byte[]):void");
        }

        @Override // java.io.OutputStream
        public final void write(int i) {
            if (!(!f.q()) && p.G()) {
                int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 123;
                getAuthRequestContext = i2 % 128;
                if ((i2 % 2 != 0 ? 'M' : (char) 4) != 'M') {
                    try {
                        com.uc.crashsdk.a.c.a("DEBUG", String.format("%c", Integer.valueOf(i)));
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    Object[] objArr = new Object[0];
                    objArr[1] = Integer.valueOf(i);
                    com.uc.crashsdk.a.c.a("DEBUG", String.format("%c", objArr));
                }
            }
            this.f7725a.write(i);
            this.b++;
            this.c++;
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        
            if ((r0 ? 11 : 'X') != 'X') goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
        
            if ((com.uc.crashsdk.f.q() ? '=' : 'L') != '=') goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
        
            if (com.uc.crashsdk.p.G() == false) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
        
            r0 = new byte[r6];
            java.lang.System.arraycopy(r4, r5, r0, 0, r6);
            com.uc.crashsdk.a.c.a("DEBUG", new java.lang.String(r0));
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
        
            r0 = com.uc.crashsdk.f.b.KClassImpl$Data$declaredNonStaticMembers$2 + 103;
            com.uc.crashsdk.f.b.getAuthRequestContext = r0 % 128;
            r0 = r0 % 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
        
            r4 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
        
            throw r4;
         */
        @Override // java.io.OutputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void write(byte[] r4, int r5, int r6) {
            /*
                r3 = this;
                int r0 = com.uc.crashsdk.f.b.KClassImpl$Data$declaredNonStaticMembers$2
                int r0 = r0 + 15
                int r1 = r0 % 128
                com.uc.crashsdk.f.b.getAuthRequestContext = r1
                int r0 = r0 % 2
                r1 = 0
                if (r0 == 0) goto Lf
                r0 = 1
                goto L10
            Lf:
                r0 = 0
            L10:
                if (r0 == 0) goto L28
                boolean r0 = com.uc.crashsdk.f.q()
                r2 = 0
                r2.hashCode()     // Catch: java.lang.Throwable -> L26
                r2 = 88
                if (r0 == 0) goto L21
                r0 = 11
                goto L23
            L21:
                r0 = 88
            L23:
                if (r0 == r2) goto L5a
                goto L38
            L26:
                r4 = move-exception
                throw r4
            L28:
                boolean r0 = com.uc.crashsdk.f.q()
                r2 = 61
                if (r0 == 0) goto L33
                r0 = 61
                goto L35
            L33:
                r0 = 76
            L35:
                if (r0 == r2) goto L38
                goto L5a
            L38:
                boolean r0 = com.uc.crashsdk.p.G()
                if (r0 == 0) goto L5a
                byte[] r0 = new byte[r6]
                java.lang.System.arraycopy(r4, r5, r0, r1, r6)
                java.lang.String r1 = new java.lang.String
                r1.<init>(r0)
                java.lang.String r0 = "DEBUG"
                com.uc.crashsdk.a.c.a(r0, r1)
                int r0 = com.uc.crashsdk.f.b.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L58
                int r0 = r0 + 103
                int r1 = r0 % 128
                com.uc.crashsdk.f.b.getAuthRequestContext = r1     // Catch: java.lang.Exception -> L58
                int r0 = r0 % 2
                goto L5a
            L58:
                r4 = move-exception
                throw r4
            L5a:
                r3.a(r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.b.write(byte[], int, int):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
        
            if ((!com.uc.crashsdk.p.G()) != false) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0037, code lost:
        
            if (r0 != false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
        
            if (r5.length != 1) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
        
            r0 = 30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
        
            r0 = '\t';
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
        
            if (r0 == '\t') goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0049, code lost:
        
            if (r5[0] == 10) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x004b, code lost:
        
            com.uc.crashsdk.a.c.a("DEBUG", new java.lang.String(r5));
            r0 = com.uc.crashsdk.f.b.KClassImpl$Data$declaredNonStaticMembers$2 + 35;
            com.uc.crashsdk.f.b.getAuthRequestContext = r0 % 128;
            r0 = r0 % 2;
         */
        @Override // java.io.OutputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void write(byte[] r5) {
            /*
                r4 = this;
                boolean r0 = com.uc.crashsdk.f.q()
                r1 = 89
                if (r0 == 0) goto Lb
                r0 = 89
                goto Ld
            Lb:
                r0 = 55
            Ld:
                r2 = 0
                if (r0 == r1) goto L11
                goto L5f
            L11:
                int r0 = com.uc.crashsdk.f.b.KClassImpl$Data$declaredNonStaticMembers$2
                int r0 = r0 + 117
                int r1 = r0 % 128
                com.uc.crashsdk.f.b.getAuthRequestContext = r1
                int r0 = r0 % 2
                r1 = 1
                if (r0 == 0) goto L20
                r0 = 1
                goto L21
            L20:
                r0 = 0
            L21:
                if (r0 == r1) goto L2f
                boolean r0 = com.uc.crashsdk.p.G()
                if (r0 == 0) goto L2b
                r0 = 0
                goto L2c
            L2b:
                r0 = 1
            L2c:
                if (r0 == 0) goto L39
                goto L5f
            L2f:
                boolean r0 = com.uc.crashsdk.p.G()
                r3 = 0
                r3.hashCode()     // Catch: java.lang.Throwable -> L64
                if (r0 == 0) goto L5f
            L39:
                int r0 = r5.length
                r3 = 9
                if (r0 != r1) goto L41
                r0 = 30
                goto L43
            L41:
                r0 = 9
            L43:
                if (r0 == r3) goto L4b
                r0 = r5[r2]
                r1 = 10
                if (r0 == r1) goto L5f
            L4b:
                java.lang.String r0 = new java.lang.String
                r0.<init>(r5)
                java.lang.String r1 = "DEBUG"
                com.uc.crashsdk.a.c.a(r1, r0)
                int r0 = com.uc.crashsdk.f.b.KClassImpl$Data$declaredNonStaticMembers$2
                int r0 = r0 + 35
                int r1 = r0 % 128
                com.uc.crashsdk.f.b.getAuthRequestContext = r1
                int r0 = r0 % 2
            L5f:
                int r0 = r5.length
                r4.a(r5, r2, r0)
                return
            L64:
                r5 = move-exception
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.b.write(byte[]):void");
        }

        private static void e(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
            VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
            int i = iArr[0];
            int i2 = iArr[1];
            int i3 = iArr[2];
            int i4 = iArr[3];
            char[] cArr = MyBillsEntityDataFactory;
            if (cArr != null) {
                int length = cArr.length;
                char[] cArr2 = new char[length];
                int i5 = 0;
                while (i5 < length) {
                    try {
                        cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
                        i5++;
                        int i6 = $10 + 59;
                        $11 = i6 % 128;
                        int i7 = i6 % 2;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                cArr = cArr2;
            }
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr, i, cArr3, 0, i2);
            if (bArr != null) {
                int i8 = $10 + 51;
                $11 = i8 % 128;
                int i9 = i8 % 2;
                char[] cArr4 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                char c = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    if ((bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1 ? 'N' : 'X') == 'N') {
                        int i10 = $10 + 119;
                        $11 = i10 % 128;
                        if (i10 % 2 == 0) {
                            cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] >> 2) % 0) % c);
                        } else {
                            cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                        }
                    } else {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    }
                    c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr4;
            }
            if (i4 > 0) {
                char[] cArr5 = new char[i2];
                try {
                    System.arraycopy(cArr3, 0, cArr5, 0, i2);
                    int i11 = i2 - i4;
                    System.arraycopy(cArr5, 0, cArr3, i11, i4);
                    System.arraycopy(cArr5, i4, cArr3, 0, i11);
                } catch (Exception e2) {
                    throw e2;
                }
            }
            if (z) {
                char[] cArr6 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (true) {
                    if (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory >= i2) {
                        break;
                    }
                    cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr6;
            }
            if (!(i3 <= 0)) {
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    int i12 = $11 + 93;
                    $10 = i12 % 128;
                    int i13 = i12 % 2;
                    cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
            }
            objArr[0] = new String(cArr3);
        }
    }

    private static String f(String str) {
        String replaceAll;
        int i2 = lookAheadTest + 101;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        try {
            if ((i2 % 2 == 0 ? (char) 25 : Typography.quote) != 25) {
                replaceAll = str.replaceAll("[^0-9a-zA-Z-.]", "-");
            } else {
                replaceAll = str.replaceAll("[^0-9a-zA-Z-.]", "-");
                int i3 = 4 / 0;
            }
            return replaceAll;
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static String w() {
        StringBuilder sb = new StringBuilder();
        sb.append(p.e());
        sb.append("_");
        String obj = sb.toString();
        int i2 = lookAheadTest + 111;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        return obj;
    }

    public static void a() {
        int i2 = lookAheadTest + 93;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        h = null;
        try {
            int i4 = lookAheadTest + 105;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0027, code lost:
    
        if ((r0 != null ? kotlin.text.Typography.quote : 'C') != 'C') goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0029, code lost:
    
        r2 = com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0 + 71;
        com.uc.crashsdk.f.lookAheadTest = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:
    
        if ((r2 % 2) == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0037, code lost:
    
        r2 = 19 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003b, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003c, code lost:
    
        r0 = g((java.lang.String) null);
        com.uc.crashsdk.f.h = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0043, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
    
        if (r0 != null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b() {
        /*
            int r0 = com.uc.crashsdk.f.lookAheadTest     // Catch: java.lang.Exception -> L46
            int r0 = r0 + 91
            int r1 = r0 % 128
            com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1     // Catch: java.lang.Exception -> L46
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto Lf
            r0 = 0
            goto L10
        Lf:
            r0 = 1
        L10:
            if (r0 == 0) goto L19
            java.lang.String r0 = com.uc.crashsdk.f.h     // Catch: java.lang.Exception -> L17
            if (r0 == 0) goto L3c
            goto L29
        L17:
            r0 = move-exception
            throw r0
        L19:
            java.lang.String r0 = com.uc.crashsdk.f.h
            r2 = 85
            int r2 = r2 / r1
            r2 = 67
            if (r0 == 0) goto L25
            r3 = 34
            goto L27
        L25:
            r3 = 67
        L27:
            if (r3 == r2) goto L3c
        L29:
            int r2 = com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r2 = r2 + 71
            int r3 = r2 % 128
            com.uc.crashsdk.f.lookAheadTest = r3
            int r2 = r2 % 2
            if (r2 == 0) goto L3b
            r2 = 19
            int r2 = r2 / r1
            goto L3b
        L39:
            r0 = move-exception
            throw r0
        L3b:
            return r0
        L3c:
            r0 = 0
            java.lang.String r0 = g(r0)
            com.uc.crashsdk.f.h = r0
            return r0
        L44:
            r0 = move-exception
            throw r0
        L46:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.b():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        if ((r6 == null ? 'T' : kotlin.text.Typography.dollar) != '$') goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0023, code lost:
    
        if ((r6 == null) != true) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0026, code lost:
    
        r6 = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String g(java.lang.String r6) {
        /*
            int r0 = com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L6a
            int r0 = r0 + 11
            int r1 = r0 % 128
            com.uc.crashsdk.f.lookAheadTest = r1     // Catch: java.lang.Exception -> L6a
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L1e
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L1c
            r0 = 36
            if (r6 != 0) goto L17
            r4 = 84
            goto L19
        L17:
            r4 = 36
        L19:
            if (r4 == r0) goto L2e
            goto L26
        L1c:
            r6 = move-exception
            throw r6
        L1e:
            if (r6 != 0) goto L22
            r0 = 1
            goto L23
        L22:
            r0 = 0
        L23:
            if (r0 == r3) goto L26
            goto L2e
        L26:
            long r4 = java.lang.System.currentTimeMillis()
            java.lang.String r6 = java.lang.String.valueOf(r4)
        L2e:
            java.util.Locale r0 = java.util.Locale.US
            r4 = 6
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = w()
            r4[r2] = r5
            java.lang.String r2 = com.uc.crashsdk.p.K()
            r4[r3] = r2
            java.lang.String r2 = com.uc.crashsdk.p.M()
            r4[r1] = r2
            r2 = 3
            java.lang.String r3 = android.os.Build.MODEL
            java.lang.String r3 = f(r3)
            r4[r2] = r3
            r2 = 4
            java.lang.String r3 = android.os.Build.VERSION.RELEASE
            java.lang.String r3 = f(r3)
            r4[r2] = r3
            r2 = 5
            r4[r2] = r6
            java.lang.String r6 = "%s%s_%s_%s_%s_%s_"
            java.lang.String r6 = java.lang.String.format(r0, r6, r4)
            int r0 = com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 43
            int r2 = r0 % 128
            com.uc.crashsdk.f.lookAheadTest = r2
            int r0 = r0 % r1
            return r6
        L6a:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.g(java.lang.String):java.lang.String");
    }

    private static String x() {
        if (!(!com.uc.crashsdk.b.o())) {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 69;
            lookAheadTest = i2 % 128;
            boolean z2 = i2 % 2 == 0;
            Object[] objArr = null;
            if (!z2) {
                int length = objArr.length;
            }
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 95;
            lookAheadTest = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 17 : (char) 4) != 4) {
                objArr.hashCode();
                return "fg";
            }
            return "fg";
        }
        return "bg";
    }

    private static byte[] y() {
        int i2 = 1024;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 13;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
        Object[] objArr = null;
        byte[] bArr = null;
        while (bArr == null) {
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 3;
            lookAheadTest = i5 % 128;
            if ((i5 % 2 != 0 ? '9' : '#') == '#') {
                if ((i2 > 0 ? (char) 4 : (char) 7) == 7) {
                    break;
                }
            } else {
                int length = objArr.length;
                if (i2 <= 0) {
                    break;
                }
            }
            try {
                bArr = new byte[i2];
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 16) {
                    break;
                }
            }
        }
        return bArr;
    }

    private static String h(String str) {
        int i2 = lookAheadTest + 87;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        if (!(i2 % 2 != 0)) {
            try {
                Locale locale = Locale.US;
                Object[] objArr = new Object[3];
                objArr[1] = b();
                objArr[0] = g();
                objArr[4] = x();
                objArr[4] = str;
                objArr[4] = a(p.H());
                return String.format(locale, "%s%s_%s_%s%s.log", objArr);
            } catch (Exception e2) {
                throw e2;
            }
        }
        return String.format(Locale.US, "%s%s_%s_%s%s.log", b(), g(), x(), str, a(p.H()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        if ((com.uc.crashsdk.a.h.a(str) ? 'V' : (char) 16) != 16) {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 9;
            lookAheadTest = i2 % 128;
            int i3 = i2 % 2;
            return "";
        }
        int length = str.length();
        int i4 = j;
        if ((length > i4 ? 'H' : '1') != '1') {
            str = str.substring(0, i4);
        }
        String f = f(str);
        if (f.startsWith(".")) {
            return f;
        }
        StringBuilder sb = new StringBuilder(".");
        sb.append(f);
        String obj = sb.toString();
        int i5 = lookAheadTest + 17;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i5 % 128;
        int i6 = i5 % 2;
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str) {
        com.uc.crashsdk.a.i.a(0, new d(str));
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 123;
        lookAheadTest = i2 % 128;
        if ((i2 % 2 != 0 ? 'Z' : (char) 7) != 'Z') {
            return;
        }
        int i3 = 25 / 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f7726a = true;
        private int b;
        private String c;

        d(int i) {
            this.c = null;
            this.b = i;
        }

        d(String str) {
            this.b = 4;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.b;
            if (i == 1) {
                f.r();
            } else if (i == 2) {
                f.s();
            } else if (i == 3) {
                f.t();
            } else if (i == 4) {
                f.e(this.c);
            } else if (!f7726a) {
                throw new AssertionError();
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:15:0x0027
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private static java.lang.String z() {
        /*
            int r0 = com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 59
            int r1 = r0 % 128
            com.uc.crashsdk.f.lookAheadTest = r1
            int r0 = r0 % 2
            boolean r0 = com.uc.crashsdk.b.s()
            r1 = 1
            if (r0 == 0) goto L13
            r0 = 1
            goto L14
        L13:
            r0 = 0
        L14:
            if (r0 == r1) goto L17
            goto L24
        L17:
            boolean r0 = com.uc.crashsdk.f.e
            r1 = 55
            if (r0 != 0) goto L20
            r0 = 55
            goto L22
        L20:
            r0 = 71
        L22:
            if (r0 == r1) goto L29
        L24:
            java.lang.String r0 = "java"
            return r0
        L27:
            r0 = move-exception
            throw r0
        L29:
            java.lang.String r0 = "ucebujava"
            int r1 = com.uc.crashsdk.f.lookAheadTest
            int r1 = r1 + 45
            int r2 = r1 % 128
            com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2
            int r1 = r1 % 2
            if (r1 != 0) goto L3c
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L3a
            return r0
        L3a:
            r0 = move-exception
            throw r0
        L3c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.z():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0117 A[Catch: all -> 0x0128, TryCatch #0 {all -> 0x0128, blocks: (B:3:0x0001, B:7:0x0012, B:10:0x0022, B:13:0x0032, B:15:0x0038, B:51:0x008e, B:52:0x0099, B:55:0x00a6, B:58:0x00b0, B:71:0x0101, B:63:0x00d9, B:72:0x0104, B:83:0x0122, B:78:0x0117), top: B:88:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0122 A[Catch: all -> 0x0128, TRY_LEAVE, TryCatch #0 {all -> 0x0128, blocks: (B:3:0x0001, B:7:0x0012, B:10:0x0022, B:13:0x0032, B:15:0x0038, B:51:0x008e, B:52:0x0099, B:55:0x00a6, B:58:0x00b0, B:71:0x0101, B:63:0x00d9, B:72:0x0104, B:83:0x0122, B:78:0x0117), top: B:88:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(boolean r10) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.c(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static final class c implements Comparator<File> {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            File file3 = file;
            File file4 = file2;
            if (file3.lastModified() > file4.lastModified()) {
                return 1;
            }
            return file3.lastModified() < file4.lastModified() ? -1 : 0;
        }
    }

    private static void a(OutputStream outputStream, String str, String str2) {
        String str3;
        Object[] objArr = new Object[1];
        D(5 - View.MeasureSpec.getMode(0), new char[]{33361, 59791, 4982, 25795, 22814, 45725}, objArr);
        String intern = ((String) objArr[0]).intern();
        try {
            outputStream.write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n".getBytes(intern));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            str3 = Build.HARDWARE;
        } catch (Throwable th2) {
            com.uc.crashsdk.a.a.a(th2, false);
            str3 = "-";
        }
        try {
            outputStream.write(String.format(Locale.US, "Basic Information: 'pid: %d/tid: %d/logver: 2/time: %s/cpu: %s/cpu hardware: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), g(), Build.CPU_ABI, str3).getBytes(intern));
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Mobile Information: 'model: %s/version: %s/sdk: %d'\n", Build.MODEL, Build.VERSION.RELEASE, Integer.valueOf(Build.VERSION.SDK_INT)).getBytes(intern));
            StringBuilder sb = new StringBuilder("Build fingerprint: '");
            sb.append(Build.FINGERPRINT);
            sb.append("'\n");
            outputStream.write(sb.toString().getBytes(intern));
            outputStream.write(String.format("Runtime Information: 'start: %s/maxheap: %s'\n", a(new Date(c)), Long.valueOf(Runtime.getRuntime().maxMemory())).getBytes(intern));
        } catch (Throwable th4) {
            a(th4, outputStream);
        }
        try {
            outputStream.write(String.format("Application Information: 'version: %s/subversion: %s/buildseq: %s'\n", p.K(), p.L(), p.M()).getBytes(intern));
            outputStream.write(String.format("CrashSDK Information: 'version: %s/nativeseq: %s/javaseq: %s/target: %s'\n", "2.0.0.4", (com.uc.crashsdk.b.d ? '-' : '\r') != '-' ? "0" : JNIBridge.nativeGetNativeBuildseq(), "170706161743", "release").getBytes(intern));
            if (str == null) {
                int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 77;
                lookAheadTest = i2 % 128;
                int i3 = i2 % 2;
                str = "";
            }
            int lastIndexOf = str.lastIndexOf(47);
            StringBuilder sb2 = new StringBuilder("Report Name: ");
            sb2.append(str.substring(lastIndexOf + 1));
            sb2.append("\n");
            outputStream.write(sb2.toString().getBytes(intern));
        } catch (Throwable th5) {
            a(th5, outputStream);
        }
        try {
            StringBuilder sb3 = new StringBuilder("UUID: ");
            sb3.append(f7722a);
            sb3.append("\n");
            outputStream.write(sb3.toString().getBytes(intern));
            StringBuilder sb4 = new StringBuilder("Log Type: ");
            sb4.append(str2);
            sb4.append("\n");
            outputStream.write(sb4.toString().getBytes(intern));
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 47;
            lookAheadTest = i4 % 128;
            int i5 = i4 % 2;
        } catch (Throwable th6) {
            a(th6, outputStream);
        }
        a(outputStream);
        try {
            com.uc.crashsdk.a.a(outputStream, intern);
        } catch (Throwable th7) {
            a(th7, outputStream);
        }
        a(outputStream);
    }

    public static String c() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("JavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / ConvertUtils.KB);
            sb.append(" kB\n");
            sb.append("JavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / ConvertUtils.KB);
            sb.append(" kB\n");
            sb.append("JavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / ConvertUtils.KB);
            sb.append(" kB\n");
            sb.append("NativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / ConvertUtils.KB);
            sb.append(" kB\n");
            sb.append("NativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / ConvertUtils.KB);
            sb.append(" kB\n");
            sb.append("NativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / ConvertUtils.KB);
            sb.append(" kB\n");
            try {
                ActivityManager activityManager = (ActivityManager) com.uc.crashsdk.e.a().getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
                if (activityManager != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    sb.append("\n");
                    sb.append("availMem:   ");
                    sb.append(memoryInfo.availMem / ConvertUtils.KB);
                    sb.append(" kB\n");
                    sb.append("threshold:  ");
                    sb.append(memoryInfo.threshold / ConvertUtils.KB);
                    sb.append(" kB\n");
                    sb.append("lowMemory:  ");
                    sb.append(memoryInfo.lowMemory);
                    sb.append("\n");
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.a.a(th, false);
            }
            String obj = sb.toString();
            try {
                int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 1;
                lookAheadTest = i2 % 128;
                int i3 = i2 % 2;
                return obj;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.a.a(th2, false);
            return "exception exists.";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0081, code lost:
    
        if ((r10 % 2) == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a5, code lost:
    
        if (r5.indexOf(46) <= 0) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x002a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.a(java.lang.String, java.lang.String):java.lang.String");
    }

    private static BufferedReader a(InputStreamReader inputStreamReader) {
        try {
            int i2 = lookAheadTest + 69;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
            int i3 = i2 % 2;
            BufferedReader bufferedReader = null;
            int i4 = 8192;
            while (true) {
                if ((bufferedReader == null ? (char) 19 : (char) 29) == 29) {
                    break;
                }
                int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 3;
                lookAheadTest = i5 % 128;
                int i6 = i5 % 2;
                if (i4 <= 0) {
                    break;
                }
                try {
                    bufferedReader = new BufferedReader(inputStreamReader, i4);
                } catch (Throwable unused) {
                    i4 /= 2;
                    if (i4 < 512) {
                        break;
                    }
                }
            }
            int i7 = lookAheadTest + 3;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i7 % 128;
            if ((i7 % 2 == 0 ? Typography.quote : '[') != '\"') {
                return bufferedReader;
            }
            int i8 = 75 / 0;
            return bufferedReader;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(OutputStream outputStream) {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 25;
        lookAheadTest = i2 % 128;
        int i3 = i2 % 2;
        try {
            Object[] objArr = new Object[1];
            D(5 - (ViewConfiguration.getScrollDefaultDelay() >> 16), new char[]{33361, 59791, 4982, 25795, 22814, 45725}, objArr);
            outputStream.write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes(((String) objArr[0]).intern()));
            int i4 = lookAheadTest + 65;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
            int i5 = i4 % 2;
        } catch (Throwable th) {
            a(th, outputStream);
        }
    }

    private static void b(OutputStream outputStream) {
        Object[] objArr = new Object[1];
        D(5 - Color.alpha(0), new char[]{33361, 59791, 4982, 25795, 22814, 45725}, objArr);
        String intern = ((String) objArr[0]).intern();
        BufferedReader bufferedReader = null;
        try {
            try {
                outputStream.write("logcat: \n".getBytes(intern));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        if (p.n() <= 0) {
            try {
                outputStream.write("[DEBUG] custom java logcat lines count is 0!\n".getBytes(intern));
            } catch (Throwable th3) {
                a(th3, outputStream);
            }
            a(outputStream);
            return;
        }
        int n2 = p.n();
        BufferedReader a2 = a(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-b", "events", "-b", "main", "-v", "threadtime", "-t", String.valueOf(n2)}).getInputStream()));
        try {
        } catch (Throwable th4) {
            bufferedReader = a2;
            th = th4;
        }
        try {
            if (a2 == null) {
                try {
                    outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes(intern));
                } catch (Throwable th5) {
                    a(th5, outputStream);
                }
                a(outputStream);
                if ((a2 != null ? 'C' : '!') != '!') {
                    try {
                        a2.close();
                        return;
                    } catch (Throwable th6) {
                        a(th6, outputStream);
                        return;
                    }
                }
                return;
            }
            g = false;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                String readLine = a2.readLine();
                if (readLine == null) {
                    try {
                        break;
                    } catch (Throwable th7) {
                        a(th7, outputStream);
                    }
                } else {
                    i2++;
                    if ((i3 < n2 ? 'I' : (char) 28) == 'I') {
                        int i4 = lookAheadTest + 39;
                        NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
                        if (i4 % 2 == 0) {
                            outputStream.write(readLine.getBytes(intern));
                            outputStream.write("\n".getBytes(intern));
                            i3 += 8;
                        } else {
                            outputStream.write(readLine.getBytes(intern));
                            outputStream.write("\n".getBytes(intern));
                            i3++;
                        }
                    }
                }
            }
            outputStream.write(String.format(Locale.US, "[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)).getBytes(intern));
            g = true;
            if (!(a2 == null)) {
                int i5 = lookAheadTest + 51;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i5 % 128;
                if (!(i5 % 2 == 0)) {
                    a2.close();
                } else {
                    a2.close();
                    bufferedReader.hashCode();
                }
            }
            a(outputStream);
            return;
            g = true;
            a(th, outputStream);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            a(outputStream);
            return;
        } catch (Throwable th8) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable th9) {
                    a(th9, outputStream);
                }
            }
            throw th8;
        }
        bufferedReader = a2;
        th = th4;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0098 A[Catch: all -> 0x00c1, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00c1, blocks: (B:15:0x0067, B:21:0x0085, B:23:0x008b, B:26:0x0098, B:33:0x00ae), top: B:40:0x0067 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(java.io.OutputStream r11) {
        /*
            r0 = 5
            r1 = 2
            r2 = 1
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L47
            java.lang.String r5 = "disk info:\n"
            java.lang.String r4 = java.lang.String.format(r5, r4)     // Catch: java.lang.Throwable -> L47
            int r5 = android.view.View.combineMeasuredStates(r3, r3)     // Catch: java.lang.Throwable -> L47
            int r5 = 5 - r5
            r6 = 6
            char[] r6 = new char[r6]     // Catch: java.lang.Throwable -> L47
            r7 = 33361(0x8251, float:4.6749E-41)
            r6[r3] = r7     // Catch: java.lang.Throwable -> L47
            r7 = 59791(0xe98f, float:8.3785E-41)
            r6[r2] = r7     // Catch: java.lang.Throwable -> L47
            r7 = 4982(0x1376, float:6.981E-42)
            r6[r1] = r7     // Catch: java.lang.Throwable -> L47
            r7 = 3
            r8 = 25795(0x64c3, float:3.6146E-41)
            r6[r7] = r8     // Catch: java.lang.Throwable -> L47
            r7 = 4
            r8 = 22814(0x591e, float:3.1969E-41)
            r6[r7] = r8     // Catch: java.lang.Throwable -> L47
            r7 = 45725(0xb29d, float:6.4074E-41)
            r6[r0] = r7     // Catch: java.lang.Throwable -> L47
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L47
            D(r5, r6, r7)     // Catch: java.lang.Throwable -> L47
            r5 = r7[r3]     // Catch: java.lang.Throwable -> L47
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L47
            java.lang.String r5 = r5.intern()     // Catch: java.lang.Throwable -> L47
            byte[] r4 = r4.getBytes(r5)     // Catch: java.lang.Throwable -> L47
            r11.write(r4)     // Catch: java.lang.Throwable -> L47
            goto L4b
        L47:
            r4 = move-exception
            a(r4, r11)
        L4b:
            java.util.HashSet r4 = new java.util.HashSet     // Catch: java.lang.Throwable -> L61
            r4.<init>()     // Catch: java.lang.Throwable -> L61
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L5f
            java.lang.String r6 = com.uc.crashsdk.e.f7720a     // Catch: java.lang.Throwable -> L5f
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r5 = a(r5)     // Catch: java.lang.Throwable -> L5f
            a(r11, r5, r4)     // Catch: java.lang.Throwable -> L5f
            goto L67
        L5f:
            r5 = move-exception
            goto L64
        L61:
            r4 = move-exception
            r5 = r4
            r4 = 0
        L64:
            a(r5, r11)
        L67:
            java.io.File r5 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> Lc1
            java.lang.String r5 = a(r5)     // Catch: java.lang.Throwable -> Lc1
            a(r11, r5, r4)     // Catch: java.lang.Throwable -> Lc1
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> Lc1
            java.lang.String r6 = "/storage"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> Lc1
            boolean r6 = r5.exists()     // Catch: java.lang.Throwable -> Lc1
            if (r6 == 0) goto L81
            r6 = 0
            goto L82
        L81:
            r6 = 1
        L82:
            if (r6 == 0) goto L85
            goto Lc5
        L85:
            java.io.File[] r5 = r5.listFiles()     // Catch: java.lang.Throwable -> Lc1
            if (r5 == 0) goto Lc5
            int r6 = r5.length     // Catch: java.lang.Throwable -> Lc1
            int r7 = com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r7 = r7 + 81
            int r8 = r7 % 128
            com.uc.crashsdk.f.lookAheadTest = r8
            int r7 = r7 % r1
            r7 = 0
        L96:
            if (r7 >= r6) goto Lc5
            r8 = r5[r7]     // Catch: java.lang.Throwable -> Lc1
            boolean r9 = r8.isDirectory()     // Catch: java.lang.Throwable -> Lc1
            if (r9 == 0) goto La2
            r9 = 1
            goto La3
        La2:
            r9 = 0
        La3:
            if (r9 == r2) goto La6
            goto Lbe
        La6:
            int r9 = com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r9 = r9 + r0
            int r10 = r9 % 128
            com.uc.crashsdk.f.lookAheadTest = r10
            int r9 = r9 % r1
            java.lang.String r8 = a(r8)     // Catch: java.lang.Throwable -> Lc1
            a(r11, r8, r4)     // Catch: java.lang.Throwable -> Lc1
            int r8 = com.uc.crashsdk.f.lookAheadTest
            int r8 = r8 + 107
            int r9 = r8 % 128
            com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0 = r9
            int r8 = r8 % r1
        Lbe:
            int r7 = r7 + 1
            goto L96
        Lc1:
            r0 = move-exception
            a(r0, r11)
        Lc5:
            a(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.c(java.io.OutputStream):void");
    }

    private static String a(File file) {
        String str;
        int i2 = lookAheadTest + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        try {
            if ((i2 % 2 == 0 ? (char) 30 : (char) 6) != 6) {
                str = file.getCanonicalPath();
                int i3 = 66 / 0;
            } else {
                str = file.getCanonicalPath();
            }
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 79;
            lookAheadTest = i4 % 128;
            int i5 = i4 % 2;
        } catch (Throwable unused) {
            str = null;
        }
        try {
            if (com.uc.crashsdk.a.h.a(str)) {
                str = file.getPath();
            }
            int i6 = lookAheadTest + 105;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i6 % 128;
            int i7 = i6 % 2;
            return str;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(OutputStream outputStream, String str, Set<String> set) {
        int i2 = lookAheadTest + 69;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        Object[] objArr = new Object[1];
        D(5 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new char[]{33361, 59791, 4982, 25795, 22814, 45725}, objArr);
        String intern = ((String) objArr[0]).intern();
        if ((!com.uc.crashsdk.a.h.a(str) ? 'O' : ':') != ':') {
            int i4 = lookAheadTest + 17;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
            if (i4 % 2 == 0) {
                int i5 = 64 / 0;
                if (set.contains(str)) {
                    return;
                }
            } else if (set.contains(str)) {
                return;
            }
            if (str.equals("/storage/emulated")) {
                return;
            }
            set.add(str);
            try {
                StatFs statFs = new StatFs(str);
                long a2 = a(statFs, "getBlockCountLong", "getBlockCount");
                long a3 = a(statFs, "getBlockSizeLong", "getBlockSize");
                if ((a2 / ConvertUtils.KB) * a3 < FileUtil.LOCAL_REPORT_FILE_MAX_SIZE) {
                    int i6 = lookAheadTest + 41;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i6 % 128;
                    if (i6 % 2 != 0) {
                        return;
                    }
                    Object[] objArr2 = null;
                    int length = objArr2.length;
                    return;
                }
                long a4 = a(statFs, "getAvailableBlocksLong", "getAvailableBlocks");
                long a5 = a(statFs, "getFreeBlocksLong", "getFreeBlocks");
                try {
                    outputStream.write(String.format("%s:\n", str).getBytes(intern));
                    Object[] objArr3 = new Object[1];
                    double d2 = a2;
                    double d3 = a3;
                    Double.isNaN(d2);
                    Double.isNaN(d3);
                    objArr3[0] = Long.valueOf((long) (((d2 * 1.0d) * d3) / 1024.0d));
                    outputStream.write(String.format("  total:      %d kB\n", objArr3).getBytes(intern));
                    Object[] objArr4 = new Object[1];
                    double d4 = a4;
                    Double.isNaN(d4);
                    Double.isNaN(d3);
                    objArr4[0] = Long.valueOf((long) (((d4 * 1.0d) * d3) / 1024.0d));
                    outputStream.write(String.format("  available:  %d kB\n", objArr4).getBytes(intern));
                    Object[] objArr5 = new Object[1];
                    double d5 = a5;
                    Double.isNaN(d5);
                    Double.isNaN(d3);
                    objArr5[0] = Long.valueOf((long) (((d5 * 1.0d) * d3) / 1024.0d));
                    outputStream.write(String.format("  free:       %d kB\n", objArr5).getBytes(intern));
                    outputStream.write(String.format("  block size: %d B\n\n", Long.valueOf(a3)).getBytes(intern));
                } catch (Throwable th) {
                    a(th, outputStream);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if ((r5 instanceof java.lang.Long) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        if ((!(r5 instanceof java.lang.Long)) != true) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long a(android.os.StatFs r4, java.lang.String r5, java.lang.String r6) {
        /*
            r0 = 1
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L4e
            r3 = 18
            if (r2 < r3) goto La
            r2 = 1
            goto Lb
        La:
            r2 = 0
        Lb:
            if (r2 == r0) goto Le
            goto L4e
        Le:
            java.lang.Class<android.os.StatFs> r2 = android.os.StatFs.class
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L4e
            java.lang.reflect.Method r5 = r2.getDeclaredMethod(r5, r3)     // Catch: java.lang.Throwable -> L4e
            r5.setAccessible(r0)     // Catch: java.lang.Throwable -> L4e
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L4e
            java.lang.Object r5 = r5.invoke(r4, r2)     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L23
            r2 = 1
            goto L24
        L23:
            r2 = 0
        L24:
            if (r2 == 0) goto L4e
            int r2 = com.uc.crashsdk.f.lookAheadTest
            int r2 = r2 + 89
            int r3 = r2 % 128
            com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0 = r3
            int r2 = r2 % 2
            if (r2 != 0) goto L3c
            boolean r2 = r5 instanceof java.lang.Long     // Catch: java.lang.Exception -> L77
            r3 = 78
            int r3 = r3 / r1
            if (r2 == 0) goto L4e
            goto L45
        L3a:
            r4 = move-exception
            throw r4
        L3c:
            boolean r2 = r5 instanceof java.lang.Long     // Catch: java.lang.Exception -> L4c
            if (r2 == 0) goto L42
            r2 = 0
            goto L43
        L42:
            r2 = 1
        L43:
            if (r2 == r0) goto L4e
        L45:
            java.lang.Long r5 = (java.lang.Long) r5     // Catch: java.lang.Throwable -> L4e
            long r4 = r5.longValue()     // Catch: java.lang.Throwable -> L4e
            return r4
        L4c:
            r4 = move-exception
            throw r4
        L4e:
            java.lang.Class<android.os.StatFs> r5 = android.os.StatFs.class
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L79
            java.lang.reflect.Method r5 = r5.getDeclaredMethod(r6, r2)     // Catch: java.lang.Throwable -> L79
            r5.setAccessible(r0)     // Catch: java.lang.Throwable -> L79
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L79
            java.lang.Object r4 = r5.invoke(r4, r6)     // Catch: java.lang.Throwable -> L79
            if (r4 == 0) goto L7d
            boolean r5 = r4 instanceof java.lang.Integer     // Catch: java.lang.Exception -> L77
            if (r5 == 0) goto L7d
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> L79
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L79
            long r4 = (long) r4
            int r6 = com.uc.crashsdk.f.lookAheadTest     // Catch: java.lang.Exception -> L77
            int r6 = r6 + 125
            int r0 = r6 % 128
            com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0     // Catch: java.lang.Exception -> L77
            int r6 = r6 % 2
            return r4
        L77:
            r4 = move-exception
            throw r4
        L79:
            r4 = move-exception
            com.uc.crashsdk.a.a.a(r4, r1)
        L7d:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.a(android.os.StatFs, java.lang.String, java.lang.String):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d6, code lost:
    
        if (r11.length >= r0) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(java.io.OutputStream r19) {
        /*
            Method dump skipped, instructions count: 427
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.d(java.io.OutputStream):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0025 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(java.io.OutputStream r22) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.e(java.io.OutputStream):void");
    }

    private static void a(b bVar) {
        int i2 = lookAheadTest + 25;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        try {
            String format = String.format("log end: %s\n", g());
            Object[] objArr = new Object[1];
            D(5 - ExpandableListView.getPackedPositionGroup(0L), new char[]{33361, 59791, 4982, 25795, 22814, 45725}, objArr);
            bVar.a(format.getBytes(((String) objArr[0]).intern()));
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 69;
            lookAheadTest = i4 % 128;
            int i5 = i4 % 2;
        } catch (Throwable th) {
            a(th, bVar);
        }
    }

    public static void a(OutputStream outputStream, String str) {
        if (str == null) {
            int i2 = lookAheadTest + 45;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
            int i3 = i2 % 2;
            a(outputStream);
            return;
        }
        try {
            String a2 = com.uc.crashsdk.a.d.a(str);
            if (a2 == null) {
                StringBuilder sb = new StringBuilder("file: '");
                sb.append(str);
                sb.append("' not found or decode failed!");
                a2 = sb.toString();
            }
            Object[] objArr = new Object[1];
            D(5 - Color.alpha(0), new char[]{33361, 59791, 4982, 25795, 22814, 45725}, objArr);
            outputStream.write(a2.getBytes(((String) objArr[0]).intern()));
            Object[] objArr2 = new Object[1];
            D((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 5, new char[]{33361, 59791, 4982, 25795, 22814, 45725}, objArr2);
            outputStream.write("\n".getBytes(((String) objArr2[0]).intern()));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        a(outputStream);
        int i4 = lookAheadTest + 1;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
        if (i4 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0115, code lost:
    
        if ((r8 != null) != false) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(java.io.OutputStream r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.b(java.io.OutputStream, java.lang.String):void");
    }

    private static void f(OutputStream outputStream) {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 91;
        lookAheadTest = i2 % 128;
        int i3 = i2 % 2;
        try {
            Object[] objArr = new Object[1];
            D(5 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new char[]{33361, 59791, 4982, 25795, 22814, 45725}, objArr);
            outputStream.write("meminfo:\n".getBytes(((String) objArr[0]).intern()));
            b(outputStream, "/proc/meminfo");
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 113;
            lookAheadTest = i4 % 128;
            int i5 = i4 % 2;
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            String format = String.format(Locale.US, "/proc/%d/status", Integer.valueOf(Process.myPid()));
            Object[] objArr2 = new Object[1];
            D(5 - (Process.myTid() >> 22), new char[]{33361, 59791, 4982, 25795, 22814, 45725}, objArr2);
            outputStream.write("status:\n".getBytes(((String) objArr2[0]).intern()));
            b(outputStream, format);
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            StringBuilder sb = new StringBuilder("Dalvik:\nMaxMemory: ");
            sb.append(Runtime.getRuntime().maxMemory());
            sb.append(" TotalMemory: ");
            sb.append(Runtime.getRuntime().totalMemory());
            sb.append(" FreeMemory: ");
            sb.append(Runtime.getRuntime().freeMemory());
            sb.append("\n");
            String obj = sb.toString();
            Object[] objArr3 = new Object[1];
            D(Color.rgb(0, 0, 0) + 16777221, new char[]{33361, 59791, 4982, 25795, 22814, 45725}, objArr3);
            outputStream.write(obj.getBytes(((String) objArr3[0]).intern()));
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    public static String a(int i2) {
        String i3;
        try {
            String a2 = com.uc.crashsdk.a.b.a(new File(String.format(Locale.US, "/proc/%d/cmdline", Integer.valueOf(i2))), 128, true);
            if ((com.uc.crashsdk.a.h.b(a2) ? '`' : '?') != '?') {
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 47;
                lookAheadTest = i4 % 128;
                if ((i4 % 2 != 0 ? '6' : 'H') != '6') {
                    i3 = i(a2);
                } else {
                    i3 = i(a2);
                    Object obj = null;
                    obj.hashCode();
                }
                try {
                    int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 57;
                    lookAheadTest = i5 % 128;
                    int i6 = i5 % 2;
                    return i3;
                } catch (Exception e2) {
                    throw e2;
                }
            }
            return "unknown";
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
            return "unknown";
        }
    }

    private static String i(String str) {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 43;
        lookAheadTest = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 91 / 0;
            if ((com.uc.crashsdk.a.h.b(str) ? (char) 28 : '[') != 28) {
                return str;
            }
        } else {
            if (!com.uc.crashsdk.a.h.b(str)) {
                return str;
            }
        }
        int i4 = lookAheadTest + 9;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
        int i5 = i4 % 2;
        try {
            int indexOf = str.indexOf(0);
            if (indexOf >= 0) {
                int i6 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 57;
                lookAheadTest = i6 % 128;
                if (!(i6 % 2 == 0)) {
                    str = str.substring(0, indexOf);
                } else {
                    try {
                        str = str.substring(0, indexOf);
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
            }
            return str.trim();
        } catch (Exception e3) {
            throw e3;
        }
    }

    public static String d() {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 85;
        lookAheadTest = i2 % 128;
        int i3 = i2 % 2;
        String str = l;
        if (str == null) {
            String a2 = a(Process.myPid());
            l = a2;
            return a2;
        }
        int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 21;
        lookAheadTest = i4 % 128;
        int i5 = i4 % 2;
        return str;
    }

    private static boolean a(String str, String str2, int i2) {
        try {
            if (!com.uc.crashsdk.b.d) {
                int i3 = lookAheadTest + 99;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                int i4 = i3 % 2;
                return false;
            }
            int i5 = lookAheadTest + 73;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i5 % 128;
            char c2 = i5 % 2 == 0 ? 'N' : '*';
            boolean nativeSyncStatus = JNIBridge.nativeSyncStatus(str, str2, i2);
            if (c2 != '*') {
                Object obj = null;
                obj.hashCode();
                return nativeSyncStatus;
            }
            return nativeSyncStatus;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:1|2|(2:3|4)|(48:(4:6|7|(1:9)(1:186)|(62:11|12|13|14|15|16|(1:18)(1:161)|(1:20)(1:159)|21|22|(1:24)(1:158)|25|(3:27|28|29)|34|35|36|37|38|39|40|41|42|(1:44)|46|(1:48)|(1:144)|51|52|54|55|56|57|58|60|61|62|(1:64)(1:129)|(2:123|124)|66|67|68|70|71|72|73|74|75|76|77|79|80|81|82|83|84|85|86|87|88|89|90|91))|36|37|38|39|40|41|42|(0)|46|(0)|(1:50)(2:142|144)|51|52|54|55|56|57|58|60|61|62|(0)(0)|(0)|66|67|68|70|71|72|73|74|75|76|77|79|80|81|82|83|84|85|86|87|88|89|90|91)|187|12|13|14|15|16|(0)(0)|(0)(0)|21|22|(0)(0)|25|(0)|34|35|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(21:1|2|3|4|(48:(4:6|7|(1:9)(1:186)|(62:11|12|13|14|15|16|(1:18)(1:161)|(1:20)(1:159)|21|22|(1:24)(1:158)|25|(3:27|28|29)|34|35|36|37|38|39|40|41|42|(1:44)|46|(1:48)|(1:144)|51|52|54|55|56|57|58|60|61|62|(1:64)(1:129)|(2:123|124)|66|67|68|70|71|72|73|74|75|76|77|79|80|81|82|83|84|85|86|87|88|89|90|91))|36|37|38|39|40|41|42|(0)|46|(0)|(1:50)(2:142|144)|51|52|54|55|56|57|58|60|61|62|(0)(0)|(0)|66|67|68|70|71|72|73|74|75|76|77|79|80|81|82|83|84|85|86|87|88|89|90|91)|187|12|13|14|15|16|(0)(0)|(0)(0)|21|22|(0)(0)|25|(0)|34|35|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(48:(4:6|7|(1:9)(1:186)|(62:11|12|13|14|15|16|(1:18)(1:161)|(1:20)(1:159)|21|22|(1:24)(1:158)|25|(3:27|28|29)|34|35|36|37|38|39|40|41|42|(1:44)|46|(1:48)|(1:144)|51|52|54|55|56|57|58|60|61|62|(1:64)(1:129)|(2:123|124)|66|67|68|70|71|72|73|74|75|76|77|79|80|81|82|83|84|85|86|87|88|89|90|91))|36|37|38|39|40|41|42|(0)|46|(0)|(1:50)(2:142|144)|51|52|54|55|56|57|58|60|61|62|(0)(0)|(0)|66|67|68|70|71|72|73|74|75|76|77|79|80|81|82|83|84|85|86|87|88|89|90|91) */
    /* JADX WARN: Can't wrap try/catch for region: R(68:1|2|3|4|(4:6|7|(1:9)(1:186)|(62:11|12|13|14|15|16|(1:18)(1:161)|(1:20)(1:159)|21|22|(1:24)(1:158)|25|(3:27|28|29)|34|35|36|37|38|39|40|41|42|(1:44)|46|(1:48)|(1:144)|51|52|54|55|56|57|58|60|61|62|(1:64)(1:129)|(2:123|124)|66|67|68|70|71|72|73|74|75|76|77|79|80|81|82|83|84|85|86|87|88|89|90|91))|187|12|13|14|15|16|(0)(0)|(0)(0)|21|22|(0)(0)|25|(0)|34|35|36|37|38|39|40|41|42|(0)|46|(0)|(1:50)(2:142|144)|51|52|54|55|56|57|58|60|61|62|(0)(0)|(0)|66|67|68|70|71|72|73|74|75|76|77|79|80|81|82|83|84|85|86|87|88|89|90|91|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01eb, code lost:
    
        a(r0, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01f2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01f4, code lost:
    
        com.uc.crashsdk.a.a.a(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01fe, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0200, code lost:
    
        com.uc.crashsdk.a.a.a(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0210, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0212, code lost:
    
        a(r0, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0219, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x021b, code lost:
    
        com.uc.crashsdk.a.a.a(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0222, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0224, code lost:
    
        a(r0, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0231, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0233, code lost:
    
        com.uc.crashsdk.a.a.a(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x023a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x023b, code lost:
    
        r7 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x023d, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0241, code lost:
    
        a(r0, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0244, code lost:
    
        if (r7 != null) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0246, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x025b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x025c, code lost:
    
        com.uc.crashsdk.a.a.a(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0260, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0262, code lost:
    
        if (r7 != null) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0264, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0267, code lost:
    
        r0 = com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0 + 101;
        com.uc.crashsdk.f.lookAheadTest = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0272, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0273, code lost:
    
        com.uc.crashsdk.a.a.a(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0277, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:?, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:?, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0086, code lost:
    
        com.uc.crashsdk.a.a.a(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0138, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0139, code lost:
    
        com.uc.crashsdk.a.a.a(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0164, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0165, code lost:
    
        com.uc.crashsdk.a.a.a(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0197, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0198, code lost:
    
        com.uc.crashsdk.a.a.a(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01a4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01a5, code lost:
    
        com.uc.crashsdk.a.a.a(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01b2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01b3, code lost:
    
        com.uc.crashsdk.a.a.a(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01bd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01bf, code lost:
    
        com.uc.crashsdk.a.a.a(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01c6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01c8, code lost:
    
        com.uc.crashsdk.a.a.a(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01e9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x01d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #17 {all -> 0x0085, blocks: (B:15:0x0075, B:21:0x007f), top: B:186:0x0075, outer: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0156 A[Catch: all -> 0x0164, TRY_LEAVE, TryCatch #3 {all -> 0x0164, blocks: (B:50:0x0145, B:52:0x0156), top: B:169:0x0145, outer: #21 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01d2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:148:0x024b -> B:198:0x024e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.Throwable r16, boolean r17) {
        /*
            Method dump skipped, instructions count: 642
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.a(java.lang.Throwable, boolean):java.lang.String");
    }

    private static void g(OutputStream outputStream) {
        Object[] objArr = new Object[1];
        D(((byte) KeyEvent.getModifierMetaStateMask()) + 6, new char[]{33361, 59791, 4982, 25795, 22814, 45725}, objArr);
        String intern = ((String) objArr[0]).intern();
        try {
            outputStream.write("Recent Status:\n".getBytes(intern));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            outputStream.write(String.format("last version: '%s'\n", com.uc.crashsdk.a.g()).getBytes(intern));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            synchronized (q) {
                String str = s;
                if (str != null) {
                    outputStream.write(String.format("generating log: %s\n", str.toString()).getBytes(intern));
                }
                if (r > 0 || q.size() > 0) {
                    outputStream.write(String.format(Locale.US, "generated %d logs, recent are:\n", Integer.valueOf(r)).getBytes(intern));
                    Iterator<String> it = q.iterator();
                    while (it.hasNext()) {
                        outputStream.write(String.format("* %s\n", it.next()).getBytes(intern));
                    }
                }
            }
            outputStream.write(String.format("dumping all threads: %s\n", Boolean.valueOf(t)).getBytes(intern));
            String str2 = u;
            if (str2 != null) {
                outputStream.write(String.format("dumping threads: %s\n", str2).getBytes(intern));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    private static String j(String str) {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 77;
        lookAheadTest = i2 % 128;
        int i3 = i2 % 2;
        String a2 = com.uc.crashsdk.a.d.a(str, p.v(), p.u());
        if (!str.equals(a2)) {
            File file = new File(str);
            try {
                if ((file.exists() ? '[' : (char) 7) == '[') {
                    file.delete();
                    try {
                        int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 125;
                        lookAheadTest = i4 % 128;
                        int i5 = i4 % 2;
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
            } catch (Exception e3) {
                throw e3;
            }
        }
        return a2;
    }

    public static void a(Throwable th, OutputStream outputStream) {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 35;
        lookAheadTest = i2 % 128;
        int i3 = i2 % 2;
        if (outputStream != null) {
            try {
                Object[] objArr = new Object[1];
                D(Drawable.resolveOpacity(0, 0) + 5, new char[]{33361, 59791, 4982, 25795, 22814, 45725}, objArr);
                outputStream.write("[DEBUG] CrashHandler occurred new exception:\n".getBytes(((String) objArr[0]).intern()));
                th.printStackTrace(new PrintStream(outputStream));
                Object[] objArr2 = new Object[1];
                D((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 5, new char[]{33361, 59791, 4982, 25795, 22814, 45725}, objArr2);
                outputStream.write("\n\n".getBytes(((String) objArr2[0]).intern()));
                int i4 = lookAheadTest + 45;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
                int i5 = i4 % 2;
            } catch (Throwable th2) {
                com.uc.crashsdk.a.a.a(th2, false);
            }
        }
        com.uc.crashsdk.a.a.a(th, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final String f7724a;
        private boolean b;
        private boolean c;

        /* synthetic */ a(String str, boolean z, boolean z2, byte b) {
            this(str, z, z2);
        }

        private a(String str, boolean z, boolean z2) {
            this.f7724a = str;
            this.b = z;
            this.c = z2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        
            if (r4.c != false) goto L10;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                r4 = this;
                java.lang.String r0 = "CrashHandler uploading logs"
                com.uc.crashsdk.a.c.b(r0)
                java.lang.Object r0 = com.uc.crashsdk.f.u()
                monitor-enter(r0)
                java.lang.String r1 = r4.f7724a     // Catch: java.lang.Throwable -> L29
                boolean r1 = com.uc.crashsdk.a.h.b(r1)     // Catch: java.lang.Throwable -> L29
                if (r1 == 0) goto L1b
                java.lang.String r1 = r4.f7724a     // Catch: java.lang.Throwable -> L29
                boolean r2 = r4.b     // Catch: java.lang.Throwable -> L29
                r3 = 0
                com.uc.crashsdk.f.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L29
                goto L20
            L1b:
                java.lang.String r1 = "CrashHandler url is empty!"
                com.uc.crashsdk.a.c.b(r1)     // Catch: java.lang.Throwable -> L29
            L20:
                boolean r1 = r4.c     // Catch: java.lang.Throwable -> L37
                if (r1 == 0) goto L35
            L24:
                java.lang.Object r1 = com.uc.crashsdk.f.u()     // Catch: java.lang.Throwable -> L37
                goto L32
            L29:
                r1 = move-exception
                com.uc.crashsdk.f.a(r1)     // Catch: java.lang.Throwable -> L39
                boolean r1 = r4.c     // Catch: java.lang.Throwable -> L37
                if (r1 == 0) goto L35
                goto L24
            L32:
                r1.notify()     // Catch: java.lang.Throwable -> L37
            L35:
                monitor-exit(r0)
                return
            L37:
                r1 = move-exception
                goto L46
            L39:
                r1 = move-exception
                boolean r2 = r4.c     // Catch: java.lang.Throwable -> L37
                if (r2 == 0) goto L45
                java.lang.Object r2 = com.uc.crashsdk.f.u()     // Catch: java.lang.Throwable -> L37
                r2.notify()     // Catch: java.lang.Throwable -> L37
            L45:
                throw r1     // Catch: java.lang.Throwable -> L37
            L46:
                monitor-exit(r0)
                goto L49
            L48:
                throw r1
            L49:
                goto L48
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.a.run():void");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:204:0x0425, code lost:
    
        if (r11 != false) goto L205;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r25, boolean r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 1096
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.a(java.lang.String, boolean, boolean):void");
    }

    public static boolean e() {
        boolean z2;
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 47;
        lookAheadTest = i2 % 128;
        if ((i2 % 2 != 0 ? '.' : (char) 5) != '.') {
            z2 = e;
        } else {
            z2 = e;
            int i3 = 29 / 0;
        }
        int i4 = lookAheadTest + 109;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
        int i5 = i4 % 2;
        return z2;
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory = new byte[]{56, -119, 46, TarHeader.LF_CONTIG, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -4, 13, -35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
        PlaceComponentResult = 9;
        m = new Object();
        n = new Object();
        f7723o = new Object();
        p = new Object();
        q = new ArrayList<>();
        r = 0;
        Object obj = null;
        s = null;
        t = false;
        u = null;
        v = null;
        w = null;
        x = new Object();
        f7722a = null;
        y = null;
        z = null;
        A = false;
        B = null;
        C = new Object();
        int i2 = lookAheadTest + 79;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        if (i2 % 2 != 0) {
            return;
        }
        obj.hashCode();
    }

    public static boolean a(boolean z2) {
        if (z2) {
            e = true;
            if (com.uc.crashsdk.b.d) {
                JNIBridge.nativeSetCrashLogFilesUploaded();
            }
        }
        byte b2 = 0;
        try {
            String f = f();
            if (com.uc.crashsdk.a.h.a(f)) {
                com.uc.crashsdk.a.c.b("CrashHandler url is empty!");
                return false;
            }
            synchronized (m) {
                boolean z3 = !z2 ? 1 : 0;
                if (com.uc.crashsdk.a.i.a(!z2 ? 1 : 0, new a(f, z2, z3, b2)) && z3) {
                    try {
                        m.wait();
                    } catch (InterruptedException e2) {
                        com.uc.crashsdk.a.a.a(e2, false);
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
    
        if (r3 != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
    
        if ((r3 ? 'J' : '#') != '#') goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0050, code lost:
    
        r3 = f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0058, code lost:
    
        if (com.uc.crashsdk.a.h.a(r3) != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005a, code lost:
    
        android.os.StrictMode.setThreadPolicy(new android.os.StrictMode.ThreadPolicy.Builder(android.os.StrictMode.getThreadPolicy()).permitNetwork().build());
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006f, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0070, code lost:
    
        com.uc.crashsdk.a.a.a(r1, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007c, code lost:
    
        a(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(boolean r3) {
        /*
            r0 = 0
            boolean r1 = com.uc.crashsdk.p.r()     // Catch: java.lang.Throwable -> L83
            if (r1 != 0) goto L8
            return
        L8:
            java.lang.String r1 = com.uc.crashsdk.a.f7699a     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = d()     // Catch: java.lang.Throwable -> L83
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto L82
            int r1 = com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r1 = r1 + 121
            int r2 = r1 % 128
            com.uc.crashsdk.f.lookAheadTest = r2
            int r1 = r1 % 2
            boolean r1 = com.uc.crashsdk.b.s()     // Catch: java.lang.Throwable -> L83
            if (r1 != 0) goto L82
            boolean r1 = com.uc.crashsdk.f.e     // Catch: java.lang.Throwable -> L83
            r2 = 39
            if (r1 != 0) goto L2d
            r1 = 39
            goto L2f
        L2d:
            r1 = 99
        L2f:
            if (r1 == r2) goto L32
            goto L82
        L32:
            int r1 = com.uc.crashsdk.f.lookAheadTest     // Catch: java.lang.Exception -> L80
            int r1 = r1 + 7
            int r2 = r1 % 128
            com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2     // Catch: java.lang.Exception -> L80
            int r1 = r1 % 2
            if (r1 != 0) goto L45
            r1 = 6
            int r1 = r1 / r0
            if (r3 == 0) goto L7c
            goto L50
        L43:
            r3 = move-exception
            throw r3
        L45:
            r1 = 35
            if (r3 == 0) goto L4c
            r3 = 74
            goto L4e
        L4c:
            r3 = 35
        L4e:
            if (r3 == r1) goto L7c
        L50:
            java.lang.String r3 = f()     // Catch: java.lang.Throwable -> L83
            boolean r1 = com.uc.crashsdk.a.h.a(r3)     // Catch: java.lang.Throwable -> L83
            if (r1 != 0) goto L7b
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.getThreadPolicy()     // Catch: java.lang.Throwable -> L6f
            android.os.StrictMode$ThreadPolicy$Builder r2 = new android.os.StrictMode$ThreadPolicy$Builder     // Catch: java.lang.Throwable -> L6f
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L6f
            android.os.StrictMode$ThreadPolicy$Builder r1 = r2.permitNetwork()     // Catch: java.lang.Throwable -> L6f
            android.os.StrictMode$ThreadPolicy r1 = r1.build()     // Catch: java.lang.Throwable -> L6f
            android.os.StrictMode.setThreadPolicy(r1)     // Catch: java.lang.Throwable -> L6f
            goto L73
        L6f:
            r1 = move-exception
            com.uc.crashsdk.a.a.a(r1, r0)     // Catch: java.lang.Throwable -> L83
        L73:
            com.uc.crashsdk.f$a r1 = new com.uc.crashsdk.f$a     // Catch: java.lang.Throwable -> L83
            r1.<init>(r3, r0, r0, r0)     // Catch: java.lang.Throwable -> L83
            r1.run()     // Catch: java.lang.Throwable -> L83
        L7b:
            return
        L7c:
            a(r0)     // Catch: java.lang.Throwable -> L83
            goto L82
        L80:
            r3 = move-exception
            throw r3
        L82:
            return
        L83:
            r3 = move-exception
            com.uc.crashsdk.a.a.a(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.b(boolean):void");
    }

    private static String A() {
        StringBuilder sb = new StringBuilder();
        sb.append(p.N());
        sb.append("bytes");
        String obj = sb.toString();
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 85;
        lookAheadTest = i2 % 128;
        if ((i2 % 2 != 0 ? 'T' : (char) 29) != 29) {
            int i3 = 63 / 0;
            return obj;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.uc.crashsdk.f$f  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static abstract class AbstractC0155f {
        protected String b;
        protected e c;

        public abstract boolean a();

        public AbstractC0155f(String str, e eVar) {
            this.b = str;
            this.c = eVar;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0049, code lost:
    
        if (r1 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004b, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x004f, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0068, code lost:
    
        if (r1 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x006b, code lost:
    
        com.uc.crashsdk.a.a.a(r5, false);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r5, com.uc.crashsdk.f.AbstractC0155f r6) {
        /*
            java.lang.Object r0 = com.uc.crashsdk.f.n
            monitor-enter(r0)
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L7d
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L7d
            boolean r5 = r1.exists()     // Catch: java.lang.Throwable -> L7d
            r2 = 0
            if (r5 != 0) goto L17
            r1.createNewFile()     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L7d
            goto L17
        L13:
            r5 = move-exception
            com.uc.crashsdk.a.a.a(r5, r2)     // Catch: java.lang.Throwable -> L7d
        L17:
            r5 = 0
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            java.lang.String r4 = "rw"
            r3.<init>(r1, r4)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            java.nio.channels.FileChannel r1 = r3.getChannel()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            goto L2b
        L24:
            r6 = move-exception
            goto L72
        L26:
            r1 = move-exception
            com.uc.crashsdk.a.a.a(r1, r2)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L61
            r1 = r5
        L2b:
            if (r1 == 0) goto L38
            java.nio.channels.FileLock r5 = r1.lock()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            goto L38
        L32:
            r5 = move-exception
            goto L70
        L34:
            r3 = move-exception
            com.uc.crashsdk.a.a.a(r3, r2)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L5d
        L38:
            boolean r6 = r6.a()     // Catch: java.lang.Throwable -> L51
            if (r5 == 0) goto L49
            r5.release()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L42
            goto L49
        L42:
            r5 = move-exception
            com.uc.crashsdk.a.a.a(r5, r2)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L47
            goto L49
        L47:
            r5 = move-exception
            goto L65
        L49:
            if (r1 == 0) goto L6e
        L4b:
            r1.close()     // Catch: java.lang.Exception -> L4f java.lang.Throwable -> L7d
            goto L6e
        L4f:
            r5 = move-exception
            goto L6b
        L51:
            r6 = move-exception
            if (r5 == 0) goto L5c
            r5.release()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L58
            goto L5c
        L58:
            r5 = move-exception
            com.uc.crashsdk.a.a.a(r5, r2)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L5d
        L5c:
            throw r6     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L5d
        L5d:
            r5 = move-exception
            r6 = r5
            r5 = r1
            goto L62
        L61:
            r6 = move-exception
        L62:
            r1 = r5
            r5 = r6
            r6 = 0
        L65:
            com.uc.crashsdk.a.a.a(r5, r2)     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L6e
            goto L4b
        L6b:
            com.uc.crashsdk.a.a.a(r5, r2)     // Catch: java.lang.Throwable -> L7d
        L6e:
            monitor-exit(r0)
            return r6
        L70:
            r6 = r5
            r5 = r1
        L72:
            if (r5 == 0) goto L7c
            r5.close()     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> L7d
            goto L7c
        L78:
            r5 = move-exception
            com.uc.crashsdk.a.a.a(r5, r2)     // Catch: java.lang.Throwable -> L7d
        L7c:
            throw r6     // Catch: java.lang.Throwable -> L7d
        L7d:
            r5 = move-exception
            monitor-exit(r0)
            goto L81
        L80:
            throw r5
        L81:
            goto L80
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.a(java.lang.String, com.uc.crashsdk.f$f):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        long f7727a = 0;
        long b = 0;
        int c = 0;
        int d = 0;
        boolean e = false;
        boolean f = false;
        boolean g = false;

        e() {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0069, code lost:
    
        if (r0 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0077, code lost:
    
        if ((com.uc.crashsdk.export.LogType.NATIVE_TYPE.equals(r6)) != true) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0079, code lost:
    
        r0 = com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0 + 113;
        com.uc.crashsdk.f.lookAheadTest = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
    
        if ((r0 % 2) == 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0085, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0087, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008a, code lost:
    
        if (r0 == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0090, code lost:
    
        if ("ucebujni".equals(r6) != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0092, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0094, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0095, code lost:
    
        if (r0 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0098, code lost:
    
        r0 = "ucebujni".equals(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009c, code lost:
    
        r1.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009f, code lost:
    
        if (r0 != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a1, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a3, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a4, code lost:
    
        if (r0 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ac, code lost:
    
        if (com.uc.crashsdk.export.LogType.UNEXP_TYPE.equals(r6) != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ae, code lost:
    
        r6 = com.uc.crashsdk.f.lookAheadTest + 41;
        com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0 = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b8, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean b(java.io.File r6) {
        /*
            Method dump skipped, instructions count: 192
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.b(java.io.File):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b6, code lost:
    
        if (r4 > 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00bb, code lost:
    
        if (r4 > 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c3, code lost:
    
        throw new java.lang.AssertionError();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String k(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.k(java.lang.String):java.lang.String");
    }

    public static boolean a(StringBuffer stringBuffer, String str, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str2) {
        String a2;
        if (d) {
            StringBuilder sb = new StringBuilder("Processing java crash, skip generate custom log: ");
            sb.append(str);
            com.uc.crashsdk.a.c.c(sb.toString());
            return false;
        } else if (!com.uc.crashsdk.a.f.d()) {
            com.uc.crashsdk.a.c.b("DEBUG", com.uc.crashsdk.a.f.b());
            return false;
        } else if (com.uc.crashsdk.b.d && JNIBridge.nativeIsCrashing()) {
            StringBuilder sb2 = new StringBuilder("Processing native crash, skip generate custom log: ");
            sb2.append(str);
            com.uc.crashsdk.a.c.c(sb2.toString());
            return false;
        } else if (stringBuffer == null || str == null) {
            return false;
        } else {
            if (l(str)) {
                com.uc.crashsdk.a.c.c(String.format("Custom log '%s' has reach max count!", str));
                return false;
            }
            c(false);
            synchronized (f7723o) {
                a2 = a(stringBuffer, str, z2, z3, z4, z5, arrayList, arrayList2, arrayList3, str2);
            }
            if (a2 == null || a2.length() == 0) {
                return false;
            }
            m(a2);
            b(j(a2), str);
            if (z6) {
                try {
                    a(false);
                } catch (Throwable th) {
                    com.uc.crashsdk.a.a.a(th, false);
                }
            }
            return true;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:3|4|(8:(3:6|(3:9|(1:11)(19:12|13|14|(15:64|65|18|(1:63)(1:21)|22|(1:24)|25|26|27|28|30|31|32|33|34)(1:16)|17|18|(0)|63|22|(0)|25|26|27|28|30|31|32|33|34)|7)|69)|27|28|30|31|32|33|34)|70|(0)|25|26) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:(3:6|(3:9|(1:11)(19:12|13|14|(15:64|65|18|(1:63)(1:21)|22|(1:24)|25|26|27|28|30|31|32|33|34)(1:16)|17|18|(0)|63|22|(0)|25|26|27|28|30|31|32|33|34)|7)|69)|27|28|30|31|32|33|34) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00db, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00dd, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00de, code lost:
    
        r1 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e2, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e3, code lost:
    
        com.uc.crashsdk.a.a.a(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e6, code lost:
    
        if (r1 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e8, code lost:
    
        r1.close();
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ec, code lost:
    
        com.uc.crashsdk.a.a.a(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f2, code lost:
    
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f3, code lost:
    
        if (r4 != null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f5, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00fb, code lost:
    
        com.uc.crashsdk.a.a.a(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00fe, code lost:
    
        throw r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
    
        throw r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
    
        throw r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ae A[Catch: all -> 0x00ff, TRY_LEAVE, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x0033, B:7:0x0041, B:9:0x0047, B:11:0x0051, B:12:0x0056, B:15:0x0068, B:21:0x0078, B:26:0x0083, B:29:0x00ae, B:33:0x00d5, B:48:0x00ec, B:54:0x00f5, B:59:0x00fe, B:58:0x00fb, B:46:0x00e8, B:18:0x0072), top: B:75:0x0005, inners: #2, #3, #6 }] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean l(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.l(java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0057, code lost:
    
        if (r6 != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0061, code lost:
    
        if (r0.startsWith("/") != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0069, code lost:
    
        if (r0.indexOf(10) >= 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0074, code lost:
    
        if (new java.io.File(r0).exists() != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0076, code lost:
    
        r3 = new java.lang.StringBuilder("Can not found ");
        r3.append(r0);
        r3 = r3.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
    
        r17 = r3;
        r3 = r0;
        r0 = r17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.uc.crashsdk.f.b r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.a(com.uc.crashsdk.f$b, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.StringBuffer r12, java.lang.String r13, boolean r14, boolean r15, boolean r16, boolean r17, java.util.ArrayList<java.lang.String> r18, java.util.ArrayList<java.lang.String> r19, java.util.ArrayList<java.lang.String> r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.a(java.lang.StringBuffer, java.lang.String, boolean, boolean, boolean, boolean, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.lang.String):java.lang.String");
    }

    public static String f() {
        String str = v;
        if (str != null && str.length() > 0) {
            return v;
        }
        synchronized (x) {
            String str2 = null;
            if (new File(com.uc.crashsdk.b.f()).exists()) {
                String a2 = com.uc.crashsdk.a.d.a(com.uc.crashsdk.b.f());
                if (a2 != null) {
                    a2 = a2.trim();
                    if (a2.length() != 0) {
                        if (!a2.toLowerCase().startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
                            return null;
                        }
                    }
                }
                str2 = a2;
            }
            if (str2 == null) {
                str2 = w;
            }
            v = str2;
            return str2;
        }
    }

    public static void a(String str, boolean z2) {
        if (z2) {
            w = str;
            return;
        }
        v = str;
        synchronized (x) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("\n");
            com.uc.crashsdk.a.d.a(com.uc.crashsdk.b.f(), sb.toString());
        }
    }

    public static String g() {
        try {
            String a2 = a(new Date());
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 73;
            lookAheadTest = i2 % 128;
            if (i2 % 2 == 0) {
                return a2;
            }
            int i3 = 26 / 0;
            return a2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static String a(Date date) {
        int i2 = lookAheadTest + 7;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        try {
            String format = String.format(Locale.US, "%d%02d%02d%02d%02d%02d", Integer.valueOf(date.getYear() + SecExceptionCode.SEC_ERROR_AVMP), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()), Integer.valueOf(date.getSeconds()));
            int i4 = lookAheadTest + 45;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
            int i5 = i4 % 2;
            return format;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void h() {
        try {
            int i2 = lookAheadTest + 113;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
            if ((i2 % 2 == 0 ? 'O' : 'G') != 'G') {
                c = System.currentTimeMillis();
                Object obj = null;
                obj.hashCode();
                return;
            }
            c = System.currentTimeMillis();
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void m(String str) {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 87;
        lookAheadTest = i2 % 128;
        if (i2 % 2 != 0) {
            boolean p2 = p.p();
            Object[] objArr = null;
            int length = objArr.length;
            if (!p2) {
                return;
            }
        } else if (!p.p()) {
            return;
        }
        try {
            B();
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
        }
        if ((str != null ? (char) 14 : '\r') == 14 && !"".equals(str)) {
            try {
                File file = new File(p.P());
                if ((!file.exists() ? '_' : '#') != '#') {
                    int i3 = lookAheadTest + 5;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                    int i4 = i3 % 2;
                    file.mkdirs();
                }
                StringBuilder sb = new StringBuilder("copy log to: ");
                sb.append(file);
                com.uc.crashsdk.a.c.b(sb.toString());
                com.uc.crashsdk.a.b.a(new File(str), file, new byte[CrashCombineUtils.DEFAULT_MAX_INFO_LEN]);
                return;
            } catch (Throwable th2) {
                com.uc.crashsdk.a.a.a(th2, false);
            }
        }
        int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 13;
        lookAheadTest = i5 % 128;
        int i6 = i5 % 2;
    }

    private static void b(String str, String str2) {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 55;
        lookAheadTest = i2 % 128;
        try {
            if ((i2 % 2 != 0 ? '9' : ']') != '9') {
                com.uc.crashsdk.d.a(str, str2);
            } else {
                com.uc.crashsdk.d.a(str, str2);
                Object obj = null;
                obj.hashCode();
            }
            try {
                int i3 = lookAheadTest + 89;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
        }
    }

    public static void i() {
        Throwable th;
        String str;
        if (com.uc.crashsdk.a.h.a(f7722a)) {
            String str2 = null;
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(p.N());
                sb.append("unique");
                File file = new File(sb.toString());
                if (file.exists()) {
                    str = com.uc.crashsdk.a.b.a(file, 48, true);
                    try {
                        if (str != null) {
                            try {
                                if (!(str.length() != 36)) {
                                    str2 = str.replaceAll("[^0-9a-zA-Z-]", "-");
                                    int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 69;
                                    lookAheadTest = i2 % 128;
                                    int i3 = i2 % 2;
                                } else {
                                    try {
                                        int i4 = lookAheadTest + 73;
                                        try {
                                            NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
                                            int i5 = i4 % 2;
                                        } catch (Exception e2) {
                                            throw e2;
                                        }
                                    } catch (Exception e3) {
                                        throw e3;
                                    }
                                }
                            } catch (Exception e4) {
                                com.uc.crashsdk.a.a.a(e4, false);
                            }
                        }
                        str2 = str;
                    } catch (Throwable th2) {
                        th = th2;
                        com.uc.crashsdk.a.a.a(th, false);
                        str2 = str;
                        f7722a = str2;
                    }
                }
                if ((com.uc.crashsdk.a.h.a(str2) ? (char) 25 : (char) 17) != 17) {
                    str2 = UUID.randomUUID().toString();
                    if (!com.uc.crashsdk.a.h.a(str2)) {
                        com.uc.crashsdk.a.b.a(file, str2.getBytes());
                    }
                }
            } catch (Throwable th3) {
                String str3 = str2;
                th = th3;
                str = str3;
            }
            f7722a = str2;
        }
    }

    public static String j() {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 83;
        lookAheadTest = i2 % 128;
        int i3 = i2 % 2;
        String str = f7722a;
        int i4 = lookAheadTest + 97;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
        int i5 = i4 % 2;
        return str;
    }

    public static void k() {
        try {
            y = InstrumentInjector.getDefaultUncaughtExceptionHandler();
            InstrumentInjector.setDefaultUncaughtExceptionHandler(new f());
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 123;
            lookAheadTest = i2 % 128;
            if ((i2 % 2 != 0 ? 'G' : (char) 28) != 'G') {
                return;
            }
            int i3 = 0 / 0;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void l() {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 33;
        lookAheadTest = i2 % 128;
        if ((i2 % 2 != 0 ? 'W' : '\t') != '\t') {
            InstrumentInjector.setDefaultUncaughtExceptionHandler(y);
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            InstrumentInjector.setDefaultUncaughtExceptionHandler(y);
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 3;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            int i2 = lookAheadTest + 75;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
            if (i2 % 2 == 0) {
            }
            a(thread, th, false);
            int i3 = lookAheadTest + 103;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:297|(3:327|328|(13:330|331|332|300|301|(1:303)(1:324)|304|(3:306|307|(2:309|(1:311)(1:312)))|313|(1:315)|(1:318)|319|(2:321|322)(1:323)))|299|300|301|(0)(0)|304|(0)|313|(0)|(0)|319|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(13:57|(3:85|86|(13:88|89|90|60|61|(1:63)|64|(3:66|(1:68)(1:71)|(1:70))|72|(1:74)|(1:77)|78|(2:80|81)(1:82)))|59|60|61|(0)|64|(0)|72|(0)|(0)|78|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(13:8|(5:36|37|38|(1:40)(1:50)|(14:42|43|44|45|11|12|(1:14)(1:33)|15|(1:19)|20|(2:22|23)|(1:26)|27|(2:29|30)(1:32)))|10|11|12|(0)(0)|15|(2:17|19)|20|(0)|(0)|27|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:131|132|(4:163|164|(1:166)(1:175)|(14:168|169|170|135|136|(1:138)|139|(3:141|(1:143)(1:147)|(1:145)(1:146))|148|(1:150)|(1:153)|(1:155)|156|(2:158|159)(1:160)))|134|135|136|(0)|139|(0)|148|(0)|(0)|(0)|156|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:252|253|(3:283|284|(14:286|287|288|256|257|(1:259)(1:280)|260|(1:264)|265|(1:267)(1:279)|(1:269)(1:277)|(1:271)|272|(2:274|275)(1:276)))|255|256|257|(0)(0)|260|(2:262|264)|265|(0)(0)|(0)(0)|(0)|272|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(17:179|180|(7:184|(1:186)|187|188|189|190|191)|(3:224|225|(15:227|228|229|197|198|(1:200)(1:221)|201|(1:205)|206|(1:208)|210|(1:212)(1:220)|(1:214)|215|(2:217|218)(1:219)))|196|197|198|(0)(0)|201|(2:203|205)|206|(0)|210|(0)(0)|(0)|215|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x01e5, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x01e6, code lost:
    
        com.uc.crashsdk.a.a.a(r11, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x02c4, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x02c5, code lost:
    
        com.uc.crashsdk.a.a.a(r11, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x034d, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x034e, code lost:
    
        com.uc.crashsdk.a.a.a(r11, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0079, code lost:
    
        com.uc.crashsdk.a.a.a(r11, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00ef, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00f0, code lost:
    
        com.uc.crashsdk.a.a.a(r11, false);
     */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c6 A[Catch: all -> 0x01e5, TryCatch #1 {all -> 0x01e5, blocks: (B:145:0x01a1, B:148:0x01b5, B:150:0x01c6, B:156:0x01d4, B:157:0x01d7, B:159:0x01dd), top: B:304:0x01a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01dd A[Catch: all -> 0x01e5, TRY_LEAVE, TryCatch #1 {all -> 0x01e5, blocks: (B:145:0x01a1, B:148:0x01b5, B:150:0x01c6, B:156:0x01d4, B:157:0x01d7, B:159:0x01dd), top: B:304:0x01a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02af A[Catch: all -> 0x02c4, TryCatch #17 {all -> 0x02c4, blocks: (B:197:0x0292, B:201:0x029e, B:203:0x02af, B:205:0x02b3, B:206:0x02b6, B:208:0x02bc), top: B:334:0x0292 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02bc A[Catch: all -> 0x02c4, TRY_LEAVE, TryCatch #17 {all -> 0x02c4, blocks: (B:197:0x0292, B:201:0x029e, B:203:0x02af, B:205:0x02b3, B:206:0x02b6, B:208:0x02bc), top: B:334:0x0292 }] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x032e A[Catch: all -> 0x034d, TryCatch #22 {all -> 0x034d, blocks: (B:235:0x0308, B:239:0x031d, B:241:0x032e, B:243:0x0332, B:244:0x0335, B:250:0x0345), top: B:342:0x0308 }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0345 A[Catch: all -> 0x034d, TRY_LEAVE, TryCatch #22 {all -> 0x034d, blocks: (B:235:0x0308, B:239:0x031d, B:241:0x032e, B:243:0x0332, B:244:0x0335, B:250:0x0345), top: B:342:0x0308 }] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0353 A[Catch: Exception -> 0x0357, TRY_ENTER, TRY_LEAVE, TryCatch #19 {Exception -> 0x0357, blocks: (B:89:0x0117, B:255:0x0353, B:3:0x0005, B:5:0x0009, B:7:0x000f, B:47:0x008f, B:50:0x009b, B:85:0x0106, B:121:0x016a, B:127:0x017e, B:173:0x0202, B:175:0x020d, B:177:0x0213, B:179:0x022b, B:180:0x022e, B:185:0x0260, B:184:0x025d, B:120:0x0167, B:106:0x0139, B:117:0x0159, B:116:0x0156, B:107:0x013c, B:112:0x014b, B:113:0x0150, B:86:0x010b, B:91:0x011a, B:97:0x0126, B:98:0x012c, B:101:0x0131, B:181:0x024f), top: B:311:0x0005, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0389 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x038a A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x039c A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03c5 A[Catch: all -> 0x03cd, DONT_GENERATE, FINALLY_INSNS, TRY_LEAVE, TryCatch #21 {all -> 0x03cd, blocks: (B:275:0x037f, B:279:0x038b, B:282:0x03a5, B:286:0x03b4, B:287:0x03bc, B:288:0x03bf, B:290:0x03c5), top: B:340:0x037f }] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x03d3 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x03dc A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005a A[Catch: all -> 0x0078, TryCatch #14 {all -> 0x0078, blocks: (B:25:0x003d, B:29:0x0049, B:31:0x005a, B:33:0x005e, B:34:0x0061, B:37:0x0070), top: B:328:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:354:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:355:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:356:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:357:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:358:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:359:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d5 A[Catch: all -> 0x00ef, TryCatch #6 {all -> 0x00ef, blocks: (B:62:0x00b9, B:65:0x00c4, B:67:0x00d5, B:72:0x00de, B:73:0x00e1, B:75:0x00e7), top: B:312:0x00b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e7 A[Catch: all -> 0x00ef, TRY_LEAVE, TryCatch #6 {all -> 0x00ef, blocks: (B:62:0x00b9, B:65:0x00c4, B:67:0x00d5, B:72:0x00de, B:73:0x00e1, B:75:0x00e7), top: B:312:0x00b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.Thread r11, java.lang.Throwable r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 998
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.a(java.lang.Thread, java.lang.Throwable, boolean):void");
    }

    public static Throwable m() {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 47;
        lookAheadTest = i2 % 128;
        int i3 = i2 % 2;
        Throwable th = z;
        int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 37;
        lookAheadTest = i4 % 128;
        int i5 = i4 % 2;
        return th;
    }

    public static void n() {
        boolean z2;
        try {
            long o2 = p.o();
            if (o2 >= 0) {
                if (com.uc.crashsdk.b.q()) {
                    if (CrashApi.getInstance().getLastExitType() != 5) {
                        int i2 = lookAheadTest + 57;
                        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
                        int i3 = i2 % 2;
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    com.uc.crashsdk.a.i.a(0, new d(1));
                    if (z2) {
                        d dVar = new d(2);
                        B = dVar;
                        com.uc.crashsdk.a.i.a(0, dVar, o2);
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 47;
                lookAheadTest = i4 % 128;
                if ((i4 % 2 == 0 ? '=' : (char) 5) != '=') {
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    public static boolean o() {
        synchronized (C) {
            Runnable runnable = B;
            if (runnable == null || A) {
                return false;
            }
            com.uc.crashsdk.a.i.a(runnable);
            B = null;
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006a, code lost:
    
        if (r0.endsWith(".so") != false) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(java.lang.String r5) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            r5 = 1
            r1 = 43
            r2 = 0
            boolean r3 = r0.exists()     // Catch: java.lang.Exception -> L34
            if (r3 == 0) goto L12
            r3 = 43
            goto L14
        L12:
            r3 = 9
        L14:
            if (r3 == r1) goto L17
            goto L38
        L17:
            int r3 = com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r3 = r3 + 73
            int r4 = r3 % 128
            com.uc.crashsdk.f.lookAheadTest = r4
            int r3 = r3 % 2
            java.lang.String r3 = r0.getAbsolutePath()     // Catch: java.lang.Exception -> L34
            java.lang.System.load(r3)     // Catch: java.lang.Exception -> L34
            int r3 = com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r3 = r3 + 123
            int r4 = r3 % 128
            com.uc.crashsdk.f.lookAheadTest = r4
            int r3 = r3 % 2
            r3 = 1
            goto L39
        L34:
            r3 = move-exception
            com.uc.crashsdk.a.a.a(r3, r2)
        L38:
            r3 = 0
        L39:
            if (r3 != 0) goto L3e
            r4 = 43
            goto L40
        L3e:
            r4 = 40
        L40:
            if (r4 == r1) goto L43
            goto L91
        L43:
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Exception -> L8d
            boolean r1 = com.uc.crashsdk.a.h.b(r0)     // Catch: java.lang.Exception -> L8d
            if (r1 == 0) goto L91
            java.lang.String r1 = "lib"
            boolean r1 = r0.startsWith(r1)     // Catch: java.lang.Exception -> L8d
            if (r1 == 0) goto L91
            int r1 = com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r1 = r1 + 61
            int r4 = r1 % 128
            com.uc.crashsdk.f.lookAheadTest = r4
            int r1 = r1 % 2
            java.lang.String r4 = ".so"
            if (r1 == 0) goto L6f
            boolean r1 = r0.endsWith(r4)     // Catch: java.lang.Exception -> L8d
            r4 = 42
            int r4 = r4 / r2
            if (r1 == 0) goto L91
            goto L7f
        L6d:
            r5 = move-exception
            throw r5
        L6f:
            boolean r1 = r0.endsWith(r4)     // Catch: java.lang.Exception -> L8d
            r4 = 54
            if (r1 == 0) goto L7a
            r1 = 54
            goto L7c
        L7a:
            r1 = 63
        L7c:
            if (r1 == r4) goto L7f
            goto L91
        L7f:
            int r1 = r0.length()     // Catch: java.lang.Exception -> L8d
            r4 = 3
            int r1 = r1 - r4
            java.lang.String r0 = r0.substring(r4, r1)     // Catch: java.lang.Exception -> L8d
            java.lang.System.loadLibrary(r0)     // Catch: java.lang.Exception -> L8d
            goto L92
        L8d:
            r5 = move-exception
            com.uc.crashsdk.a.a.a(r5, r2)
        L91:
            r5 = r3
        L92:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.c(java.lang.String):boolean");
    }

    private static void B() {
        int i2;
        boolean z2;
        String P = p.P();
        File file = new File(P);
        if (file.isDirectory()) {
            byte b2 = 0;
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 150) {
                    Arrays.sort(listFiles, new c(b2));
                    int length = listFiles.length - 150;
                    if (length < 0) {
                        int i3 = lookAheadTest + 81;
                        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                        int i4 = i3 % 2;
                        i2 = 0;
                    } else {
                        i2 = length;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    int i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    while (true) {
                        if ((i6 < listFiles.length ? '6' : '\b') == '\b') {
                            break;
                        }
                        File file2 = listFiles[i6];
                        if (!(i6 < i2)) {
                            z2 = false;
                        } else {
                            int i8 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 73;
                            lookAheadTest = i8 % 128;
                            int i9 = i8 % 2;
                            z2 = true;
                        }
                        if (!z2 && currentTimeMillis - file2.lastModified() >= 432000000) {
                            z2 = true;
                        }
                        if (!z2) {
                            break;
                        }
                        int i10 = lookAheadTest + 113;
                        NetworkUserEntityData$$ExternalSyntheticLambda0 = i10 % 128;
                        if ((i10 % 2 == 0 ? 'E' : 'K') != 'E') {
                            try {
                                file2.delete();
                                i5++;
                                i7 = 0;
                            } catch (Exception e2) {
                                i7++;
                                com.uc.crashsdk.a.a.a(e2, false);
                            }
                        } else {
                            file2.delete();
                            i5 += 16;
                            i7 = 1;
                        }
                        if (i7 >= 3) {
                            break;
                        }
                        i6++;
                        try {
                            int i11 = lookAheadTest + 77;
                            try {
                                NetworkUserEntityData$$ExternalSyntheticLambda0 = i11 % 128;
                                int i12 = i11 % 2;
                            } catch (Exception e3) {
                                throw e3;
                            }
                        } catch (Exception e4) {
                            throw e4;
                        }
                    }
                    StringBuilder sb = new StringBuilder("Removed ");
                    sb.append(i5);
                    sb.append(" logs in ");
                    sb.append(P);
                    com.uc.crashsdk.a.c.a(sb.toString());
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.a.a(th, false);
            }
        }
    }

    public static void p() {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 29;
        lookAheadTest = i2 % 128;
        int i3 = i2 % 2;
        try {
            if (p.p()) {
                try {
                    com.uc.crashsdk.a.i.a(0, new d(3), 10000L);
                    return;
                } catch (Exception e2) {
                    throw e2;
                }
            }
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 45;
            lookAheadTest = i4 % 128;
            if (!(i4 % 2 == 0)) {
                int i5 = 84 / 0;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0073 A[EDGE_INSN: B:48:0x0073->B:36:0x0073 BREAK  A[LOOP:0: B:25:0x0035->B:35:0x0070], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.StringBuilder a(java.lang.StackTraceElement[] r9, java.lang.String r10) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 1
            r2 = 0
            if (r9 == 0) goto Lb
            r3 = 0
            goto Lc
        Lb:
            r3 = 1
        Lc:
            if (r3 == r1) goto L79
            int r3 = r9.length
            if (r3 <= 0) goto L13
            r3 = 1
            goto L14
        L13:
            r3 = 0
        L14:
            if (r3 == 0) goto L79
            int r3 = com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L77
            int r3 = r3 + 11
            int r4 = r3 % 128
            com.uc.crashsdk.f.lookAheadTest = r4     // Catch: java.lang.Exception -> L75
            int r3 = r3 % 2
            if (r10 != 0) goto L31
            int r3 = com.uc.crashsdk.f.lookAheadTest     // Catch: java.lang.Exception -> L77
            int r3 = r3 + 47
            int r4 = r3 % 128
            com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0 = r4     // Catch: java.lang.Exception -> L77
            int r3 = r3 % 2
            if (r3 != 0) goto L2f
            goto L31
        L2f:
            r3 = 1
            goto L32
        L31:
            r3 = 0
        L32:
            int r4 = r9.length
            r5 = 0
            r6 = 0
        L35:
            if (r5 >= r4) goto L39
            r7 = 1
            goto L3a
        L39:
            r7 = 0
        L3a:
            if (r7 == 0) goto L73
            r7 = r9[r5]
            int r6 = r6 + 1
            java.lang.String r8 = "  at "
            r0.append(r8)     // Catch: java.lang.Exception -> L75
            java.lang.String r8 = r7.toString()     // Catch: java.lang.Exception -> L75
            r0.append(r8)     // Catch: java.lang.Exception -> L75
            java.lang.String r8 = "\n"
            r0.append(r8)     // Catch: java.lang.Exception -> L75
            if (r3 != 0) goto L70
            java.lang.String r7 = r7.getMethodName()
            int r7 = r7.indexOf(r10)
            if (r7 < 0) goto L70
            int r3 = com.uc.crashsdk.f.lookAheadTest
            int r3 = r3 + 113
            int r6 = r3 % 128
            com.uc.crashsdk.f.NetworkUserEntityData$$ExternalSyntheticLambda0 = r6
            int r3 = r3 % 2
            int r3 = r0.length()
            r0.delete(r2, r3)
            r3 = 1
            r6 = 0
        L70:
            int r5 = r5 + 1
            goto L35
        L73:
            r2 = r6
            goto L79
        L75:
            r9 = move-exception
            throw r9
        L77:
            r9 = move-exception
            throw r9
        L79:
            if (r2 != 0) goto L80
            java.lang.String r9 = "  (no java stack)\n"
            r0.append(r9)
        L80:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.a(java.lang.StackTraceElement[], java.lang.String):java.lang.StringBuilder");
    }

    public static StringBuilder d(String str) {
        try {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 1;
            try {
                lookAheadTest = i2 % 128;
                int i3 = i2 % 2;
                int i4 = lookAheadTest + 55;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
                int i5 = i4 % 2;
                try {
                    Object[] objArr = new Object[1];
                    E(BuiltInFictitiousFunctionClassFactory[15], (byte) (-BuiltInFictitiousFunctionClassFactory[30]), BuiltInFictitiousFunctionClassFactory[21], objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    Object[] objArr2 = new Object[1];
                    E(BuiltInFictitiousFunctionClassFactory[21], (byte) (-BuiltInFictitiousFunctionClassFactory[15]), BuiltInFictitiousFunctionClassFactory[8], objArr2);
                    Object invoke = cls.getMethod((String) objArr2[0], null).invoke(null, null);
                    int i6 = lookAheadTest + 125;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i6 % 128;
                    int i7 = i6 % 2;
                    try {
                        Object[] objArr3 = new Object[1];
                        E(BuiltInFictitiousFunctionClassFactory[15], (byte) (-BuiltInFictitiousFunctionClassFactory[30]), BuiltInFictitiousFunctionClassFactory[21], objArr3);
                        Class<?> cls2 = Class.forName((String) objArr3[0]);
                        byte b2 = BuiltInFictitiousFunctionClassFactory[21];
                        byte b3 = BuiltInFictitiousFunctionClassFactory[34];
                        Object[] objArr4 = new Object[1];
                        E(b2, b3, (byte) (b3 & 7), objArr4);
                        return a((StackTraceElement[]) cls2.getMethod((String) objArr4[0], null).invoke(invoke, null), str);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    private static void D(int i2, char[] cArr, Object[] objArr) {
        C c2 = new C();
        char[] cArr2 = new char[cArr.length];
        c2.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (true) {
            if ((c2.BuiltInFictitiousFunctionClassFactory < cArr.length ? ';' : '_') != '_') {
                cArr3[0] = cArr[c2.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c2.BuiltInFictitiousFunctionClassFactory + 1];
                int i3 = 58224;
                int i4 = $10 + 125;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                int i6 = 0;
                while (true) {
                    if (!(i6 < 16)) {
                        break;
                    }
                    int i7 = $11 + 69;
                    $10 = i7 % 128;
                    int i8 = i7 % 2;
                    cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i3) ^ ((cArr3[0] << 4) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (moveToNextValue ^ 6353485791441662354L)))));
                    cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i3) ^ ((cArr3[1] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))));
                    i3 -= 40503;
                    i6++;
                }
                cArr2[c2.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c2.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c2.BuiltInFictitiousFunctionClassFactory += 2;
            } else {
                objArr[0] = new String(cArr2, 0, i2);
                return;
            }
        }
    }
}
