package kotlin.text;

import android.view.ViewConfiguration;
import com.alibaba.fastjson.parser.JSONLexer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0011\u0010\b\u001a\u00020\u00028\u0006¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0011\u0010\u000b\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\r\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0011\u0010\u000f\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004"}, d2 = {"Lkotlin/text/Charsets;", "", "Ljava/nio/charset/Charset;", "ISO_8859_1", "Ljava/nio/charset/Charset;", "US_ASCII", "UTF_16", "UTF_16BE", "UTF_16LE", "UTF32", "()Ljava/nio/charset/Charset;", "UTF_32", "UTF32_BE", "UTF_32BE", "UTF32_LE", "UTF_32LE", "UTF_8", "utf_32", "utf_32be", "utf_32le", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Charsets {
    private static int $10 = 0;
    private static int $11 = 1;
    private static boolean BuiltInFictitiousFunctionClassFactory = false;
    public static final Charsets INSTANCE;
    public static final Charset ISO_8859_1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char[] MyBillsEntityDataFactory = null;
    private static boolean PlaceComponentResult = false;
    public static final Charset US_ASCII;
    public static final Charset UTF_16;
    public static final Charset UTF_16BE;
    public static final Charset UTF_16LE;
    public static final Charset UTF_8;
    private static int getAuthRequestContext = 0;
    private static int scheduleImpl = 1;
    private static Charset utf_32;
    private static Charset utf_32be;
    private static Charset utf_32le;

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        MyBillsEntityDataFactory = new char[]{39867, 39866, 39752, 39779, 39766};
        BuiltInFictitiousFunctionClassFactory = true;
        PlaceComponentResult = true;
        getAuthRequestContext = 909155086;
    }

    private Charsets() {
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Charsets();
        Object[] objArr = new Object[1];
        a((ViewConfiguration.getTouchSlop() >> 8) + 127, new byte[]{-123, -124, -125, -126, -127}, null, null, objArr);
        Charset forName = Charset.forName(((String) objArr[0]).intern());
        Intrinsics.checkNotNullExpressionValue(forName, "");
        UTF_8 = forName;
        Charset forName2 = Charset.forName("UTF-16");
        Intrinsics.checkNotNullExpressionValue(forName2, "");
        UTF_16 = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        Intrinsics.checkNotNullExpressionValue(forName3, "");
        UTF_16BE = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        Intrinsics.checkNotNullExpressionValue(forName4, "");
        UTF_16LE = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        Intrinsics.checkNotNullExpressionValue(forName5, "");
        US_ASCII = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        Intrinsics.checkNotNullExpressionValue(forName6, "");
        ISO_8859_1 = forName6;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
        scheduleImpl = i % 128;
        if ((i % 2 == 0 ? 'K' : '?') != '?') {
            int i2 = 4 / 0;
        }
    }

    @JvmName(name = "UTF32")
    public final Charset UTF32() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        Charset charset = utf_32;
        if ((charset == null ? ',' : 'V') != ',') {
            return charset;
        }
        int i3 = scheduleImpl + 37;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        try {
            Charsets charsets = this;
            try {
                Charset forName = Charset.forName("UTF-32");
                Intrinsics.checkNotNullExpressionValue(forName, "");
                utf_32 = forName;
                return forName;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        if ((r0 == null ? 'Y' : ':') != 'Y') goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0028, code lost:
    
        r0 = r4;
        r0 = java.nio.charset.Charset.forName("UTF-32LE");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "");
        kotlin.text.Charsets.utf_32le = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
    
        if (r0 == null) goto L38;
     */
    @kotlin.jvm.JvmName(name = "UTF32_LE")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.nio.charset.Charset UTF32_LE() {
        /*
            r4 = this;
            int r0 = kotlin.text.Charsets.scheduleImpl
            int r0 = r0 + 75
            int r1 = r0 % 128
            kotlin.text.Charsets.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto Lf
            r0 = 0
            goto L10
        Lf:
            r0 = 1
        L10:
            if (r0 == 0) goto L17
            java.nio.charset.Charset r0 = kotlin.text.Charsets.utf_32le
            if (r0 != 0) goto L38
            goto L28
        L17:
            java.nio.charset.Charset r0 = kotlin.text.Charsets.utf_32le
            r2 = 25
            int r2 = r2 / r1
            r2 = 89
            if (r0 != 0) goto L23
            r3 = 89
            goto L25
        L23:
            r3 = 58
        L25:
            if (r3 == r2) goto L28
            goto L38
        L28:
            r0 = r4
            kotlin.text.Charsets r0 = (kotlin.text.Charsets) r0     // Catch: java.lang.Exception -> L54
            java.lang.String r0 = "UTF-32LE"
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)     // Catch: java.lang.Exception -> L54
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch: java.lang.Exception -> L54
            kotlin.text.Charsets.utf_32le = r0     // Catch: java.lang.Exception -> L54
        L38:
            int r2 = kotlin.text.Charsets.scheduleImpl
            int r2 = r2 + 27
            int r3 = r2 % 128
            kotlin.text.Charsets.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r2 = r2 % 2
            r3 = 78
            if (r2 == 0) goto L49
            r2 = 78
            goto L4b
        L49:
            r2 = 86
        L4b:
            if (r2 == r3) goto L4e
            return r0
        L4e:
            r2 = 65
            int r2 = r2 / r1
            return r0
        L52:
            r0 = move-exception
            throw r0
        L54:
            r0 = move-exception
            throw r0
        L56:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Charsets.UTF32_LE():java.nio.charset.Charset");
    }

    @JvmName(name = "UTF32_BE")
    public final Charset UTF32_BE() {
        Charset forName;
        Charset charset = utf_32be;
        if (!(charset != null)) {
            int i = scheduleImpl + 93;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if (i % 2 == 0) {
                forName = Charset.forName("UTF-32BE");
                Intrinsics.checkNotNullExpressionValue(forName, "");
                utf_32be = forName;
            } else {
                try {
                    Charsets charsets = this;
                    forName = Charset.forName("UTF-32BE");
                    Intrinsics.checkNotNullExpressionValue(forName, "");
                    utf_32be = forName;
                    int i2 = 92 / 0;
                } catch (Exception e) {
                    throw e;
                }
            }
            charset = forName;
            try {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e2) {
                throw e2;
            }
        }
        return charset;
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        char[] cArr2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr3 = MyBillsEntityDataFactory;
        if ((cArr3 != null ? 'Y' : ',') != ',') {
            int i2 = $10 + 3;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            int length = cArr3.length;
            char[] cArr4 = new char[length];
            for (int i4 = 0; i4 < length; i4++) {
                cArr4[i4] = (char) (cArr3[i4] ^ 4571606982258105150L);
            }
            cArr3 = cArr4;
        }
        int i5 = (int) (getAuthRequestContext ^ 4571606982258105150L);
        if (PlaceComponentResult) {
            int i6 = $10 + 7;
            $11 = i6 % 128;
            if ((i6 % 2 == 0 ? JSONLexer.EOI : '`') != 26) {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                cArr2 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            } else {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                cArr2 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 1;
            }
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr2[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i5);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr2);
        } else if (!BuiltInFictitiousFunctionClassFactory) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i5);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr5);
        } else {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (true) {
                if (!(bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult)) {
                    objArr[0] = new String(cArr6);
                    return;
                }
                try {
                    try {
                        cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i5);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                        int i7 = $11 + 121;
                        $10 = i7 % 128;
                        int i8 = i7 % 2;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
    }
}
