package androidx.text.emoji.flatbuffer;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Comparator;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;
import o.whenAvailable;

/* loaded from: classes6.dex */
public class Table {
    protected ByteBuffer KClassImpl$Data$declaredNonStaticMembers$2;
    protected int PlaceComponentResult;
    private static final ThreadLocal<CharsetDecoder> MyBillsEntityDataFactory = new ThreadLocal<CharsetDecoder>() { // from class: androidx.text.emoji.flatbuffer.Table.1
        private static int $10 = 0;
        private static int $11 = 1;
        private static int BuiltInFictitiousFunctionClassFactory = 0;
        private static int[] MyBillsEntityDataFactory = {619244563, 26274061, -1892800717, 575442482, -9043856, 353179213, -774184881, 631730088, 38119999, 1874243183, 318542548, -1785037178, -1868110992, -1486122235, -842420518, 581144990, -951148624, -198247555};
        private static int getAuthRequestContext = 1;

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ CharsetDecoder initialValue() {
            int i = getAuthRequestContext + 71;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            CharsetDecoder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory();
            int i3 = BuiltInFictitiousFunctionClassFactory + 111;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return MyBillsEntityDataFactory2;
        }

        private static CharsetDecoder MyBillsEntityDataFactory() {
            int i = getAuthRequestContext + 47;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            Object[] objArr = new Object[1];
            a(5 - (KeyEvent.getMaxKeyCode() >> 16), new int[]{-754154130, -727869310, -1537387680, 1408747083}, objArr);
            CharsetDecoder newDecoder = Charset.forName(((String) objArr[0]).intern()).newDecoder();
            int i3 = BuiltInFictitiousFunctionClassFactory + 17;
            getAuthRequestContext = i3 % 128;
            if ((i3 % 2 == 0 ? 'F' : '#') != 'F') {
                return newDecoder;
            }
            Object obj = null;
            obj.hashCode();
            return newDecoder;
        }

        private static void a(int i, int[] iArr, Object[] objArr) {
            int i2;
            VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length * 2];
            try {
                int[] iArr2 = MyBillsEntityDataFactory;
                if (iArr2 != null) {
                    int length = iArr2.length;
                    int[] iArr3 = new int[length];
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr3[i3] = (int) (iArr2[i3] ^ (-3152031022165484798L));
                    }
                    try {
                        int i4 = $11 + 35;
                        $10 = i4 % 128;
                        int i5 = i4 % 2;
                        iArr2 = iArr3;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                int length2 = iArr2.length;
                int[] iArr4 = new int[length2];
                int[] iArr5 = MyBillsEntityDataFactory;
                if ((iArr5 != null ? '^' : (char) 28) != '^') {
                    i2 = length2;
                } else {
                    int i6 = $10 + 55;
                    $11 = i6 % 128;
                    int i7 = i6 % 2;
                    int length3 = iArr5.length;
                    int[] iArr6 = new int[length3];
                    int i8 = 0;
                    while (true) {
                        if ((i8 < length3 ? (char) 30 : 'R') == 'R') {
                            break;
                        }
                        iArr6[i8] = (int) (iArr5[i8] ^ (-3152031022165484798L));
                        i8++;
                        length2 = length2;
                    }
                    iArr5 = iArr6;
                    i2 = length2;
                }
                System.arraycopy(iArr5, 0, iArr4, 0, i2);
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
                    int i9 = $11 + 41;
                    $10 = i9 % 128;
                    int i10 = i9 % 2;
                    cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                    cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                    cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                    cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                    VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                    int i11 = 0;
                    while (true) {
                        if (i11 < 16) {
                            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i11];
                            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                            int i12 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i12;
                            i11++;
                        }
                    }
                    int i13 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i13;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                    int i14 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    int i15 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
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
                }
                objArr[0] = new String(cArr2, 0, i);
            } catch (Exception e2) {
                throw e2;
            }
        }
    };
    public static final ThreadLocal<Charset> getAuthRequestContext = new ThreadLocal<Charset>() { // from class: androidx.text.emoji.flatbuffer.Table.2
        private static int $10 = 0;
        private static int $11 = 1;
        private static int BuiltInFictitiousFunctionClassFactory = 0;
        private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
        private static char[] PlaceComponentResult = {47060, 43655, 36195, 57434, 49905};
        private static long MyBillsEntityDataFactory = 8130556105325997596L;

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ Charset initialValue() {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            Charset authRequestContext = getAuthRequestContext();
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 109;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return authRequestContext;
        }

        private static Charset getAuthRequestContext() {
            Object obj;
            try {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 105;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                if (i % 2 == 0) {
                    Object[] objArr = new Object[1];
                    a(View.MeasureSpec.makeMeasureSpec(0, 0), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 5, (char) (View.getDefaultSize(0, 0) + 17615), objArr);
                    obj = objArr[0];
                } else {
                    Object[] objArr2 = new Object[1];
                    a(View.MeasureSpec.makeMeasureSpec(0, 1), 3 << (ViewConfiguration.getScrollBarFadeDuration() + 27), (char) (20329 - View.getDefaultSize(1, 0)), objArr2);
                    obj = objArr2[0];
                }
                return Charset.forName(((String) obj).intern());
            } catch (Exception e) {
                throw e;
            }
        }

        private static void a(int i, int i2, char c, Object[] objArr) {
            whenAvailable whenavailable = new whenAvailable();
            long[] jArr = new long[i2];
            whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? '9' : 'P') != '9') {
                    break;
                }
                int i3 = $10 + 57;
                $11 = i3 % 128;
                int i4 = i3 % 2;
                jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (PlaceComponentResult[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ MyBillsEntityDataFactory))) ^ c;
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
            }
            char[] cArr = new char[i2];
            whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? '\f' : (char) 16) != '\f') {
                    objArr[0] = new String(cArr);
                    return;
                }
                try {
                    int i5 = $10 + 27;
                    $11 = i5 % 128;
                    int i6 = i5 % 2;
                    cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                    whenavailable.BuiltInFictitiousFunctionClassFactory++;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
    };
    private static final ThreadLocal<CharBuffer> BuiltInFictitiousFunctionClassFactory = new ThreadLocal<>();

    protected static int lookAheadTest() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int PlaceComponentResult(int i) {
        int i2 = this.PlaceComponentResult;
        int i3 = i2 - this.KClassImpl$Data$declaredNonStaticMembers$2.getInt(i2);
        if (i < this.KClassImpl$Data$declaredNonStaticMembers$2.getShort(i3)) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getShort(i3 + i);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return i + this.KClassImpl$Data$declaredNonStaticMembers$2.getInt(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int MyBillsEntityDataFactory(int i) {
        int i2 = i + this.PlaceComponentResult;
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getInt(i2 + this.KClassImpl$Data$declaredNonStaticMembers$2.getInt(i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getAuthRequestContext(int i) {
        int i2 = i + this.PlaceComponentResult;
        return i2 + this.KClassImpl$Data$declaredNonStaticMembers$2.getInt(i2) + 4;
    }

    /* renamed from: androidx.text.emoji.flatbuffer.Table$3  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass3 implements Comparator<Integer> {
        final /* synthetic */ Table BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ ByteBuffer PlaceComponentResult;

        @Override // java.util.Comparator
        public /* synthetic */ int compare(Integer num, Integer num2) {
            return Table.lookAheadTest();
        }
    }
}
