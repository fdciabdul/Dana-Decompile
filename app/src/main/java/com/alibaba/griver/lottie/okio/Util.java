package com.alibaba.griver.lottie.okio;

import android.os.SystemClock;
import id.dana.cashier.view.InputCardNumberView;
import java.nio.charset.Charset;
import kotlin.UShort;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

/* loaded from: classes6.dex */
final class Util {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static boolean MyBillsEntityDataFactory = false;
    private static char[] PlaceComponentResult = null;
    public static final Charset UTF_8;
    private static boolean getAuthRequestContext = false;
    private static int lookAheadTest = 1;

    static void MyBillsEntityDataFactory() {
        PlaceComponentResult = new char[]{39513, 39512, 39526, 39425, 39540};
        getAuthRequestContext = true;
        MyBillsEntityDataFactory = true;
        KClassImpl$Data$declaredNonStaticMembers$2 = 909154860;
    }

    public static int reverseBytesInt(int i) {
        int i2 = lookAheadTest + 15;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2 != 0 ? (((i ^ 65280) << 60) | (((16711680 ^ i) % 63) ^ (((-16777216) & i) - 69))) ^ ((i | 23929) + 66) : ((i & 65280) << 8) | ((16711680 & i) >>> 8) | (((-16777216) & i) >>> 24) | ((i & 255) << 24);
        int i4 = BuiltInFictitiousFunctionClassFactory + 17;
        lookAheadTest = i4 % 128;
        int i5 = i4 % 2;
        return i3;
    }

    public static long reverseBytesLong(long j) {
        int i = lookAheadTest + 85;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        long j2 = ((j & 65280) << 40) | (((-72057594037927936L) & j) >>> 56) | ((71776119061217280L & j) >>> 40) | ((280375465082880L & j) >>> 24) | ((1095216660480L & j) >>> 8) | ((4278190080L & j) << 8) | ((16711680 & j) << 24) | ((255 & j) << 56);
        int i3 = BuiltInFictitiousFunctionClassFactory + 37;
        lookAheadTest = i3 % 128;
        if ((i3 % 2 == 0 ? '`' : 'K') != '`') {
            return j2;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return j2;
    }

    public static short reverseBytesShort(short s) {
        int i;
        int i2;
        int i3 = BuiltInFictitiousFunctionClassFactory + 113;
        lookAheadTest = i3 % 128;
        if ((i3 % 2 == 0 ? 'N' : 'K') != 'K') {
            int i4 = s | UShort.MAX_VALUE;
            i = (i4 ^ 10849) % 122;
            i2 = (i4 & 65280) % 23;
        } else {
            int i5 = s & UShort.MAX_VALUE;
            i = (i5 & 255) << 8;
            i2 = (i5 & 65280) >>> 8;
        }
        short s2 = (short) (i2 | i);
        int i6 = lookAheadTest + 79;
        BuiltInFictitiousFunctionClassFactory = i6 % 128;
        if ((i6 % 2 != 0 ? (char) 11 : '\n') != '\n') {
            int i7 = 4 / 0;
            return s2;
        }
        return s2;
    }

    static {
        MyBillsEntityDataFactory();
        Object[] objArr = null;
        Object[] objArr2 = new Object[1];
        a((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 126, new byte[]{-123, -124, -125, -126, -127}, null, null, objArr2);
        UTF_8 = Charset.forName(((String) objArr2[0]).intern());
        int i = lookAheadTest + 109;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (!(i % 2 != 0)) {
            return;
        }
        int length = objArr.length;
    }

    private Util() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        if ((r10 <= r8 ? 0 : 'N') != 'N') goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0037, code lost:
    
        if (r10 <= r8) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003d, code lost:
    
        if ((r8 - r10) < r12) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003f, code lost:
    
        r8 = com.alibaba.griver.lottie.okio.Util.lookAheadTest + 63;
        com.alibaba.griver.lottie.okio.Util.BuiltInFictitiousFunctionClassFactory = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        if ((r8 % 2) == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
    
        if (r5 == true) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
    
        r8 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0052, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void checkOffsetAndCount(long r8, long r10, long r12) {
        /*
            long r0 = r10 | r12
            r2 = 0
            r4 = 1
            r5 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 < 0) goto Lc
            r0 = 1
            goto Ld
        Lc:
            r0 = 0
        Ld:
            r1 = 2
            if (r0 == 0) goto L55
            int r0 = com.alibaba.griver.lottie.okio.Util.lookAheadTest
            int r0 = r0 + 111
            int r2 = r0 % 128
            com.alibaba.griver.lottie.okio.Util.BuiltInFictitiousFunctionClassFactory = r2
            int r0 = r0 % r1
            r2 = 83
            if (r0 == 0) goto L20
            r0 = 83
            goto L22
        L20:
            r0 = 94
        L22:
            r3 = 0
            if (r0 == r2) goto L32
            r0 = 78
            int r2 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r2 > 0) goto L2d
            r2 = 0
            goto L2f
        L2d:
            r2 = 78
        L2f:
            if (r2 == r0) goto L55
            goto L39
        L32:
            int r0 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            r3.hashCode()     // Catch: java.lang.Throwable -> L53
            if (r0 > 0) goto L55
        L39:
            long r6 = r8 - r10
            int r0 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r0 < 0) goto L55
            int r8 = com.alibaba.griver.lottie.okio.Util.lookAheadTest
            int r8 = r8 + 63
            int r9 = r8 % 128
            com.alibaba.griver.lottie.okio.Util.BuiltInFictitiousFunctionClassFactory = r9
            int r8 = r8 % r1
            if (r8 == 0) goto L4b
            goto L4c
        L4b:
            r5 = 1
        L4c:
            if (r5 == r4) goto L52
            int r8 = r3.length     // Catch: java.lang.Throwable -> L50
            return
        L50:
            r8 = move-exception
            throw r8
        L52:
            return
        L53:
            r8 = move-exception
            throw r8
        L55:
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.Long r8 = java.lang.Long.valueOf(r8)
            r0[r5] = r8
            java.lang.Long r8 = java.lang.Long.valueOf(r10)
            r0[r4] = r8
            java.lang.Long r8 = java.lang.Long.valueOf(r12)
            r0[r1] = r8
            java.lang.ArrayIndexOutOfBoundsException r8 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.String r9 = "size=%s offset=%s byteCount=%s"
            java.lang.String r9 = java.lang.String.format(r9, r0)
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.lottie.okio.Util.checkOffsetAndCount(long, long, long):void");
    }

    public static void sneakyRethrow(Throwable th) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 49;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            sneakyThrow2(th);
            int i3 = BuiltInFictitiousFunctionClassFactory + 99;
            lookAheadTest = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 22 : (char) 28) != 28) {
                int i4 = 93 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static <T extends Throwable> void sneakyThrow2(Throwable th) throws Throwable {
        int i = BuiltInFictitiousFunctionClassFactory + 39;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        throw th;
    }

    public static boolean arrayRangeEquals(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = lookAheadTest + 79;
        BuiltInFictitiousFunctionClassFactory = i4 % 128;
        int i5 = i4 % 2;
        int i6 = 0;
        while (true) {
            if (i6 >= i3) {
                return true;
            }
            int i7 = BuiltInFictitiousFunctionClassFactory + 61;
            lookAheadTest = i7 % 128;
            int i8 = i7 % 2;
            if (bArr[i6 + i] != bArr2[i6 + i2]) {
                int i9 = lookAheadTest + 49;
                BuiltInFictitiousFunctionClassFactory = i9 % 128;
                int i10 = i9 % 2;
                return false;
            }
            i6++;
        }
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        int length;
        char[] cArr2;
        int i2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr3 = PlaceComponentResult;
        if (cArr3 != null) {
            try {
                int i3 = $11 + 23;
                $10 = i3 % 128;
                if ((i3 % 2 != 0 ? '3' : (char) 6) != '3') {
                    length = cArr3.length;
                    cArr2 = new char[length];
                    i2 = 0;
                } else {
                    length = cArr3.length;
                    cArr2 = new char[length];
                    i2 = 1;
                }
                while (i2 < length) {
                    cArr2[i2] = (char) (cArr3[i2] ^ 4571606982258105150L);
                    i2++;
                }
                cArr3 = cArr2;
            } catch (Exception e) {
                throw e;
            }
        }
        int i4 = (int) (4571606982258105150L ^ KClassImpl$Data$declaredNonStaticMembers$2);
        if (!MyBillsEntityDataFactory) {
            if (getAuthRequestContext) {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i4);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr4);
                return;
            }
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                try {
                    cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i4);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                } catch (Exception e2) {
                    throw e2;
                }
            }
            objArr[0] = new String(cArr5);
            return;
        }
        int i5 = $10 + 113;
        $11 = i5 % 128;
        int i6 = i5 % 2;
        bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
        char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
        while (true) {
            if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? 'K' : InputCardNumberView.DIVIDER) == ' ') {
                objArr[0] = new String(cArr6);
                return;
            }
            cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i4);
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            int i7 = $11 + 67;
            $10 = i7 % 128;
            int i8 = i7 % 2;
        }
    }
}
