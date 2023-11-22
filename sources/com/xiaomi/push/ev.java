package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.el;
import java.io.UnsupportedEncodingException;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

/* loaded from: classes8.dex */
public class ev extends el {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 104857600;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
    private static int PrepareContext = 1;
    private static int getErrorConfigVersion = 10485760;
    private static int lookAheadTest = 10000;
    private static int moveToNextValue = 10000;
    private static int scheduleImpl = 10000;
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda2 = {39890, 39893, 39907, 39930, 39921};
    private static boolean initRecordTimeStamp = true;
    private static boolean GetContactSyncConfig = true;
    private static int DatabaseTableConfigUtil = 909155241;

    /* loaded from: classes8.dex */
    public static class a extends el.a {
        public a() {
            super(false, true);
        }

        public a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }

        @Override // com.xiaomi.push.el.a, com.xiaomi.push.er
        public ep a(ey eyVar) {
            ev evVar = new ev(eyVar, this.f391a, this.b);
            if (this.f7787a != 0) {
                evVar.PlaceComponentResult(this.f7787a);
            }
            return evVar;
        }
    }

    public ev(ey eyVar, boolean z, boolean z2) {
        super(eyVar, z, z2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        if (r1 <= com.xiaomi.push.ev.moveToNextValue) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        r2 = new com.xiaomi.push.en(r0, r1);
        r0 = com.xiaomi.push.ev.NetworkUserEntityData$$ExternalSyntheticLambda1 + 51;
        com.xiaomi.push.ev.PrepareContext = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append("Thrift list size ");
        r0.append(r1);
        r0.append(" out of range!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0060, code lost:
    
        throw new com.xiaomi.push.eq(3, r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
    
        if (r1 <= r2) goto L15;
     */
    @Override // com.xiaomi.push.el, com.xiaomi.push.ep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.xiaomi.push.en NetworkUserEntityData$$ExternalSyntheticLambda0() {
        /*
            r4 = this;
            int r0 = com.xiaomi.push.ev.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 41
            int r1 = r0 % 128
            com.xiaomi.push.ev.PrepareContext = r1
            int r0 = r0 % 2
            r1 = 40
            if (r0 != 0) goto L11
            r0 = 47
            goto L13
        L11:
            r0 = 40
        L13:
            if (r0 == r1) goto L28
            byte r0 = r4.BuiltInFictitiousFunctionClassFactory()
            int r1 = r4.getAuthRequestContext()
            int r2 = com.xiaomi.push.ev.moveToNextValue
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L26
            if (r1 > r2) goto L44
            goto L34
        L26:
            r0 = move-exception
            throw r0
        L28:
            byte r0 = r4.BuiltInFictitiousFunctionClassFactory()
            int r1 = r4.getAuthRequestContext()
            int r2 = com.xiaomi.push.ev.moveToNextValue
            if (r1 > r2) goto L44
        L34:
            com.xiaomi.push.en r2 = new com.xiaomi.push.en
            r2.<init>(r0, r1)
            int r0 = com.xiaomi.push.ev.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 51
            int r1 = r0 % 128
            com.xiaomi.push.ev.PrepareContext = r1
            int r0 = r0 % 2
            return r2
        L44:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Thrift list size "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = " out of range!"
            r0.append(r1)
            com.xiaomi.push.eq r1 = new com.xiaomi.push.eq
            r2 = 3
            java.lang.String r0 = r0.toString()
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ev.NetworkUserEntityData$$ExternalSyntheticLambda0():com.xiaomi.push.en");
    }

    @Override // com.xiaomi.push.el, com.xiaomi.push.ep
    public final String getErrorConfigVersion() {
        int authRequestContext = getAuthRequestContext();
        if ((authRequestContext <= getErrorConfigVersion ? 'C' : ':') == ':') {
            StringBuilder sb = new StringBuilder();
            sb.append("Thrift string size ");
            sb.append(authRequestContext);
            sb.append(" out of range!");
            throw new eq(3, sb.toString());
        }
        int i = PrepareContext + 125;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        Object obj = null;
        if (this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() < authRequestContext) {
            String KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
            int i3 = PrepareContext + 57;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 30 : 'Y') != 30) {
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }
            obj.hashCode();
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }
        try {
            byte[] authRequestContext2 = this.PlaceComponentResult.getAuthRequestContext();
            int PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult();
            Object[] objArr = new Object[1];
            b(new byte[]{-123, -124, -125, -126, -127}, TextUtils.lastIndexOf("", '0') + 128, null, null, objArr);
            String str = new String(authRequestContext2, PlaceComponentResult, authRequestContext, ((String) objArr[0]).intern());
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new ej("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if ((r1 >= r0) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        if ((r6.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() >= r0 ? '\n' : 'U') != '\n') goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        r1 = new byte[r0];
        r6.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(r1, r0);
        r0 = java.nio.ByteBuffer.wrap(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        r1 = com.xiaomi.push.ev.PrepareContext + 3;
        com.xiaomi.push.ev.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0057, code lost:
    
        if ((r1 % 2) == 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        r1 = 92 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0060, code lost:
    
        r1 = java.nio.ByteBuffer.wrap(r6.PlaceComponentResult.getAuthRequestContext(), r6.PlaceComponentResult.PlaceComponentResult(), r0);
        r6.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0075, code lost:
    
        return r1;
     */
    @Override // com.xiaomi.push.el, com.xiaomi.push.ep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.nio.ByteBuffer lookAheadTest() {
        /*
            r6 = this;
            int r0 = r6.getAuthRequestContext()
            int r1 = com.xiaomi.push.ev.NetworkUserEntityData$$ExternalSyntheticLambda0
            r2 = 3
            if (r0 > r1) goto L76
            int r1 = com.xiaomi.push.ev.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r1 = r1 + 11
            int r3 = r1 % 128
            com.xiaomi.push.ev.PrepareContext = r3
            int r1 = r1 % 2
            r3 = 1
            r4 = 0
            if (r1 != 0) goto L19
            r1 = 1
            goto L1a
        L19:
            r1 = 0
        L1a:
            r6.getAuthRequestContext(r0)
            if (r1 == 0) goto L32
            com.xiaomi.push.ey r1 = r6.PlaceComponentResult
            int r1 = r1.BuiltInFictitiousFunctionClassFactory()
            r5 = 0
            r5.hashCode()     // Catch: java.lang.Throwable -> L30
            if (r1 < r0) goto L2c
            goto L2d
        L2c:
            r3 = 0
        L2d:
            if (r3 == 0) goto L43
            goto L60
        L30:
            r0 = move-exception
            throw r0
        L32:
            com.xiaomi.push.ey r1 = r6.PlaceComponentResult
            int r1 = r1.BuiltInFictitiousFunctionClassFactory()
            r3 = 10
            if (r1 < r0) goto L3f
            r1 = 10
            goto L41
        L3f:
            r1 = 85
        L41:
            if (r1 == r3) goto L60
        L43:
            byte[] r1 = new byte[r0]
            com.xiaomi.push.ey r3 = r6.PlaceComponentResult
            r3.BuiltInFictitiousFunctionClassFactory(r1, r0)
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r1)
            int r1 = com.xiaomi.push.ev.PrepareContext     // Catch: java.lang.Exception -> L92
            int r1 = r1 + r2
            int r2 = r1 % 128
            com.xiaomi.push.ev.NetworkUserEntityData$$ExternalSyntheticLambda1 = r2     // Catch: java.lang.Exception -> L92
            int r1 = r1 % 2
            if (r1 == 0) goto L5f
            r1 = 92
            int r1 = r1 / r4
            return r0
        L5d:
            r0 = move-exception
            throw r0
        L5f:
            return r0
        L60:
            com.xiaomi.push.ey r1 = r6.PlaceComponentResult
            byte[] r1 = r1.getAuthRequestContext()
            com.xiaomi.push.ey r2 = r6.PlaceComponentResult
            int r2 = r2.PlaceComponentResult()
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.wrap(r1, r2, r0)
            com.xiaomi.push.ey r2 = r6.PlaceComponentResult
            r2.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            return r1
        L76:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Thrift binary size "
            r1.append(r3)     // Catch: java.lang.Exception -> L92
            r1.append(r0)     // Catch: java.lang.Exception -> L92
            java.lang.String r0 = " out of range!"
            r1.append(r0)     // Catch: java.lang.Exception -> L92
            com.xiaomi.push.eq r0 = new com.xiaomi.push.eq     // Catch: java.lang.Exception -> L92
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L92
            r0.<init>(r2, r1)     // Catch: java.lang.Exception -> L92
            throw r0     // Catch: java.lang.Exception -> L92
        L92:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ev.lookAheadTest():java.nio.ByteBuffer");
    }

    @Override // com.xiaomi.push.el, com.xiaomi.push.ep
    public final eo moveToNextValue() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 71;
        PrepareContext = i % 128;
        int i2 = i % 2;
        try {
            byte BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
            byte BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory();
            int authRequestContext = getAuthRequestContext();
            if (authRequestContext > scheduleImpl) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thrift map size ");
                sb.append(authRequestContext);
                sb.append(" out of range!");
                throw new eq(3, sb.toString());
            }
            eo eoVar = new eo(BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2, authRequestContext);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 33;
            PrepareContext = i3 % 128;
            if (i3 % 2 != 0) {
                return eoVar;
            }
            Object obj = null;
            obj.hashCode();
            return eoVar;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
    
        if (r1 <= com.xiaomi.push.ev.lookAheadTest) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        r2 = new com.xiaomi.push.et(r0, r1);
        r0 = com.xiaomi.push.ev.PrepareContext + 107;
        com.xiaomi.push.ev.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
    
        if ((r0 % 2) == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
    
        r0 = 'F';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        r0 = 'G';
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        if (r0 == 'F') goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        r0 = r0.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append("Thrift set size ");
        r0.append(r1);
        r0.append(" out of range!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
    
        throw new com.xiaomi.push.eq(3, r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
    
        if (r1 <= com.xiaomi.push.ev.lookAheadTest) goto L16;
     */
    @Override // com.xiaomi.push.el, com.xiaomi.push.ep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.xiaomi.push.et scheduleImpl() {
        /*
            r4 = this;
            int r0 = com.xiaomi.push.ev.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L73
            int r0 = r0 + 13
            int r1 = r0 % 128
            com.xiaomi.push.ev.PrepareContext = r1     // Catch: java.lang.Exception -> L73
            int r0 = r0 % 2
            r1 = 53
            if (r0 != 0) goto L11
            r0 = 53
            goto L13
        L11:
            r0 = 96
        L13:
            if (r0 == r1) goto L24
            byte r0 = r4.BuiltInFictitiousFunctionClassFactory()     // Catch: java.lang.Exception -> L22
            int r1 = r4.getAuthRequestContext()     // Catch: java.lang.Exception -> L22
            int r2 = com.xiaomi.push.ev.lookAheadTest     // Catch: java.lang.Exception -> L22
            if (r1 > r2) goto L54
            goto L34
        L22:
            r0 = move-exception
            throw r0
        L24:
            byte r0 = r4.BuiltInFictitiousFunctionClassFactory()
            int r1 = r4.getAuthRequestContext()
            int r2 = com.xiaomi.push.ev.lookAheadTest
            r3 = 20
            int r3 = r3 / 0
            if (r1 > r2) goto L54
        L34:
            com.xiaomi.push.et r2 = new com.xiaomi.push.et
            r2.<init>(r0, r1)
            int r0 = com.xiaomi.push.ev.PrepareContext
            int r0 = r0 + 107
            int r1 = r0 % 128
            com.xiaomi.push.ev.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 70
            if (r0 == 0) goto L4a
            r0 = 70
            goto L4c
        L4a:
            r0 = 71
        L4c:
            if (r0 == r1) goto L4f
            return r2
        L4f:
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L52
            return r2
        L52:
            r0 = move-exception
            throw r0
        L54:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Thrift set size "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = " out of range!"
            r0.append(r1)
            com.xiaomi.push.eq r1 = new com.xiaomi.push.eq
            r2 = 3
            java.lang.String r0 = r0.toString()
            r1.<init>(r2, r0)
            throw r1
        L71:
            r0 = move-exception
            throw r0
        L73:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ev.scheduleImpl():com.xiaomi.push.et");
    }

    private static void b(byte[] bArr, int i, char[] cArr, int[] iArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ DatabaseTableConfigUtil);
        if ((GetContactSyncConfig ? (char) 21 : '\\') == 21) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            String str = new String(cArr4);
            int i4 = $10 + 81;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            objArr[0] = str;
            return;
        }
        if (!(initRecordTimeStamp)) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                try {
                    try {
                        cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            String str2 = new String(cArr5);
            int i6 = $11 + 79;
            $10 = i6 % 128;
            if (i6 % 2 == 0) {
                objArr[0] = str2;
                return;
            }
            int i7 = 29 / 0;
            objArr[0] = str2;
            return;
        }
        int i8 = $11 + 55;
        $10 = i8 % 128;
        int i9 = i8 % 2;
        bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
        char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
        while (true) {
            if (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >= bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                objArr[0] = new String(cArr6);
                return;
            }
            int i10 = $10 + 71;
            $11 = i10 % 128;
            int i11 = i10 % 2;
            cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
        }
    }
}
