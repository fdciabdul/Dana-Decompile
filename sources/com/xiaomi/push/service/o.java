package com.xiaomi.push.service;

import android.os.SystemClock;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* loaded from: classes8.dex */
public class o {
    private static long MyBillsEntityDataFactory;
    private static long getErrorConfigVersion;
    private static long scheduleImpl;
    final a BuiltInFictitiousFunctionClassFactory;
    final c getAuthRequestContext;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {SignedBytes.MAX_POWER_OF_TWO, 34, -50, 73, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int PlaceComponentResult = 42;

    /* loaded from: classes8.dex */
    static final class a {
        private final c KClassImpl$Data$declaredNonStaticMembers$2;

        a(c cVar) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = cVar;
        }

        protected final void finalize() {
            try {
                synchronized (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    c.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    this.KClassImpl$Data$declaredNonStaticMembers$2.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class b implements Runnable {
        protected int lookAheadTest;

        public b(int i) {
            this.lookAheadTest = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class d {
        boolean BuiltInFictitiousFunctionClassFactory;
        long KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        final Object PlaceComponentResult = new Object();
        b getAuthRequestContext;
        long getErrorConfigVersion;

        d() {
        }

        public final boolean getAuthRequestContext() {
            boolean z;
            synchronized (this.PlaceComponentResult) {
                z = !this.BuiltInFictitiousFunctionClassFactory && this.KClassImpl$Data$declaredNonStaticMembers$2 > 0;
                this.BuiltInFictitiousFunctionClassFactory = true;
            }
            return z;
        }
    }

    static {
        long elapsedRealtime = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        MyBillsEntityDataFactory = elapsedRealtime;
        getErrorConfigVersion = elapsedRealtime;
    }

    public o() {
        this((byte) 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private o(byte r3) {
        /*
            r2 = this;
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Timer-"
            r3.append(r0)
            long r0 = getAuthRequestContext()
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            r0 = 0
            r2.<init>(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.o.<init>(byte):void");
    }

    public o(String str) {
        this(str, (byte) 0);
    }

    private o(String str, byte b2) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        c cVar = new c(str, false);
        this.getAuthRequestContext = cVar;
        this.BuiltInFictitiousFunctionClassFactory = new a(cVar);
    }

    static long KClassImpl$Data$declaredNonStaticMembers$2() {
        long j;
        synchronized (o.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = getErrorConfigVersion;
            if (elapsedRealtime > j2) {
                MyBillsEntityDataFactory += elapsedRealtime - j2;
            }
            getErrorConfigVersion = elapsedRealtime;
            j = MyBillsEntityDataFactory;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 13
            int r7 = r7 * 7
            int r7 = r7 + 99
            int r8 = r8 * 12
            int r8 = 16 - r8
            byte[] r0 = com.xiaomi.push.service.o.KClassImpl$Data$declaredNonStaticMembers$2
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r7
            r4 = 0
            r7 = r6
            goto L2e
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r5
        L2e:
            int r8 = r8 + 1
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + 2
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.o.a(short, int, byte, java.lang.Object[]):void");
    }

    private static long getAuthRequestContext() {
        long j;
        synchronized (o.class) {
            j = scheduleImpl;
            scheduleImpl = 1 + j;
        }
        return j;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        boolean MyBillsEntityDataFactory2;
        synchronized (this.getAuthRequestContext) {
            MyBillsEntityDataFactory2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(i);
        }
        return MyBillsEntityDataFactory2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void PlaceComponentResult(b bVar, long j) {
        synchronized (this.getAuthRequestContext) {
            if (this.getAuthRequestContext.getAuthRequestContext) {
                throw new IllegalStateException("Timer was canceled");
            }
            long KClassImpl$Data$declaredNonStaticMembers$22 = j + KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$22 < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Illegal delay to start the TimerTask: ");
                sb.append(KClassImpl$Data$declaredNonStaticMembers$22);
                throw new IllegalArgumentException(sb.toString());
            }
            d dVar = new d();
            dVar.MyBillsEntityDataFactory = bVar.lookAheadTest;
            dVar.getAuthRequestContext = bVar;
            dVar.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$22;
            c.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, dVar);
        }
    }

    public final boolean PlaceComponentResult() {
        return this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory();
    }

    /* loaded from: classes8.dex */
    static final class c extends Thread {
        boolean getAuthRequestContext;
        private boolean moveToNextValue;
        private volatile long MyBillsEntityDataFactory = 0;
        private volatile boolean PlaceComponentResult = false;
        private long BuiltInFictitiousFunctionClassFactory = 50;
        a KClassImpl$Data$declaredNonStaticMembers$2 = new a(0);

        c(String str, boolean z) {
            setName(str);
            setDaemon(false);
            start();
        }

        static /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(c cVar) {
            cVar.moveToNextValue = true;
            return true;
        }

        public final boolean BuiltInFictitiousFunctionClassFactory() {
            return this.PlaceComponentResult && SystemClock.uptimeMillis() - this.MyBillsEntityDataFactory > 600000;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class a {
            d[] KClassImpl$Data$declaredNonStaticMembers$2;
            int MyBillsEntityDataFactory;
            int PlaceComponentResult;
            private int getAuthRequestContext;

            private a() {
                this.PlaceComponentResult = 256;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new d[256];
                this.MyBillsEntityDataFactory = 0;
                this.getAuthRequestContext = 0;
            }

            /* synthetic */ a(byte b) {
                this();
            }

            private void getAuthRequestContext(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.MyBillsEntityDataFactory;
                    if (i2 >= i3 || i3 <= 0) {
                        return;
                    }
                    int i4 = i2 + 1;
                    if (i4 < i3 && this.KClassImpl$Data$declaredNonStaticMembers$2[i4].KClassImpl$Data$declaredNonStaticMembers$2 < this.KClassImpl$Data$declaredNonStaticMembers$2[i2].KClassImpl$Data$declaredNonStaticMembers$2) {
                        i2 = i4;
                    }
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2[i].KClassImpl$Data$declaredNonStaticMembers$2 < this.KClassImpl$Data$declaredNonStaticMembers$2[i2].KClassImpl$Data$declaredNonStaticMembers$2) {
                        return;
                    }
                    d[] dVarArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    d dVar = dVarArr[i];
                    dVarArr[i] = dVarArr[i2];
                    dVarArr[i2] = dVar;
                    int i5 = i2;
                    i2 = (i2 * 2) + 1;
                    i = i5;
                }
            }

            public final boolean BuiltInFictitiousFunctionClassFactory() {
                return this.MyBillsEntityDataFactory == 0;
            }

            public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
                int i2;
                if (i < 0 || i >= (i2 = this.MyBillsEntityDataFactory)) {
                    return;
                }
                d[] dVarArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int i3 = i2 - 1;
                this.MyBillsEntityDataFactory = i3;
                dVarArr[i] = dVarArr[i3];
                dVarArr[i3] = null;
                getAuthRequestContext(i);
            }

            public final void MyBillsEntityDataFactory() {
                int i = 0;
                while (i < this.MyBillsEntityDataFactory) {
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2[i].BuiltInFictitiousFunctionClassFactory) {
                        this.getAuthRequestContext++;
                        KClassImpl$Data$declaredNonStaticMembers$2(i);
                        i--;
                    }
                    i++;
                }
            }

            public final boolean MyBillsEntityDataFactory(int i) {
                for (int i2 = 0; i2 < this.MyBillsEntityDataFactory; i2++) {
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2[i2].MyBillsEntityDataFactory == i) {
                        return true;
                    }
                }
                return false;
            }

            public final void PlaceComponentResult(int i) {
                for (int i2 = 0; i2 < this.MyBillsEntityDataFactory; i2++) {
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2[i2].MyBillsEntityDataFactory == i) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2[i2].getAuthRequestContext();
                    }
                }
                MyBillsEntityDataFactory();
            }

            static /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2(a aVar, d dVar) {
                int i = 0;
                while (true) {
                    d[] dVarArr = aVar.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (i >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i] == dVar) {
                        return i;
                    }
                    i++;
                }
            }
        }

        static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(c cVar, d dVar) {
            a aVar = cVar.KClassImpl$Data$declaredNonStaticMembers$2;
            d[] dVarArr = aVar.KClassImpl$Data$declaredNonStaticMembers$2;
            int length = dVarArr.length;
            int i = aVar.MyBillsEntityDataFactory;
            if (length == i) {
                d[] dVarArr2 = new d[i * 2];
                System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                aVar.KClassImpl$Data$declaredNonStaticMembers$2 = dVarArr2;
            }
            d[] dVarArr3 = aVar.KClassImpl$Data$declaredNonStaticMembers$2;
            int i2 = aVar.MyBillsEntityDataFactory;
            aVar.MyBillsEntityDataFactory = i2 + 1;
            dVarArr3[i2] = dVar;
            int i3 = aVar.MyBillsEntityDataFactory - 1;
            int i4 = (i3 - 1) / 2;
            while (aVar.KClassImpl$Data$declaredNonStaticMembers$2[i3].KClassImpl$Data$declaredNonStaticMembers$2 < aVar.KClassImpl$Data$declaredNonStaticMembers$2[i4].KClassImpl$Data$declaredNonStaticMembers$2) {
                d[] dVarArr4 = aVar.KClassImpl$Data$declaredNonStaticMembers$2;
                d dVar2 = dVarArr4[i3];
                dVarArr4[i3] = dVarArr4[i4];
                dVarArr4[i4] = dVar2;
                int i5 = i4;
                i4 = (i4 - 1) / 2;
                i3 = i5;
            }
            cVar.notify();
        }

        /* JADX WARN: Code restructure failed: missing block: B:54:0x0091, code lost:
        
            r11.MyBillsEntityDataFactory = android.os.SystemClock.uptimeMillis();
            r11.PlaceComponentResult = true;
            r2.getAuthRequestContext.run();
            r11.PlaceComponentResult = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a2, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00a3, code lost:
        
            monitor-enter(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00a4, code lost:
        
            r11.getAuthRequestContext = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00a7, code lost:
        
            throw r1;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 185
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.o.c.run():void");
        }
    }
}
