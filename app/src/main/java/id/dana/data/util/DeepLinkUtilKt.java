package id.dana.data.util;

import android.view.ViewConfiguration;
import java.net.URLDecoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "toScopes", "(Ljava/lang/String;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DeepLinkUtilKt {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int[] PlaceComponentResult = {1325705130, 512489126, -343811468, 1821148274, -560575222, 1935153479, 1671803705, 120791008, -96208736, 910088321, -1301526351, -928573500, -2068191532, 743457669, 1069886624, -872193628, -1450280385, -355371676};
    private static int getAuthRequestContext;

    public static final List<String> toScopes(String str) {
        int i = getAuthRequestContext + 17;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(str, "");
        Object[] objArr = new Object[1];
        a(6 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new int[]{1980588905, 593922628, -167598227, -200626417}, objArr);
        String decode = URLDecoder.decode(str, ((String) objArr[0]).intern());
        Intrinsics.checkNotNullExpressionValue(decode, "");
        List<String> split$default = StringsKt.split$default((CharSequence) StringsKt.replace$default(decode, "[\\[\\]\"]", "", false, 4, (Object) null), new String[]{","}, false, 0, 6, (Object) null);
        int i3 = getAuthRequestContext + 47;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 7 : '_') != '_') {
            Object obj = null;
            obj.hashCode();
            return split$default;
        }
        return split$default;
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int i2;
        int i3;
        int length;
        int[] iArr2;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr3 = PlaceComponentResult;
        if (iArr3 != null) {
            int length2 = iArr3.length;
            int[] iArr4 = new int[length2];
            try {
                int i4 = $10 + 67;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                int i6 = 0;
                while (i6 < length2) {
                    int i7 = $11 + 1;
                    $10 = i7 % 128;
                    if (i7 % 2 != 0) {
                        iArr4[i6] = (int) (iArr3[i6] % (-3152031022165484798L));
                        i6 <<= 1;
                    } else {
                        iArr4[i6] = (int) (iArr3[i6] ^ (-3152031022165484798L));
                        i6++;
                    }
                }
                iArr3 = iArr4;
            } catch (Exception e) {
                throw e;
            }
        }
        int length3 = iArr3.length;
        int[] iArr5 = new int[length3];
        int[] iArr6 = PlaceComponentResult;
        if (iArr6 != null) {
            int i8 = $10 + 11;
            $11 = i8 % 128;
            if ((i8 % 2 == 0 ? 'G' : (char) 31) != 'G') {
                length = iArr6.length;
                iArr2 = new int[length];
            } else {
                length = iArr6.length;
                iArr2 = new int[length];
            }
            int i9 = 0;
            while (true) {
                if ((i9 < length ? '6' : '*') == '*') {
                    break;
                }
                iArr2[i9] = (int) (iArr6[i9] ^ (-3152031022165484798L));
                i9++;
            }
            iArr6 = iArr2;
        }
        int i10 = 0;
        System.arraycopy(iArr6, 0, iArr5, 0, length3);
        while (true) {
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = i10;
            if (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
                i2 = 1;
                i3 = 0;
            } else {
                i2 = 1;
                i3 = 1;
            }
            if (i3 == i2) {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[i2] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + i2] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + i2];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[i2];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr5);
            for (int i11 = 0; i11 < 16; i11++) {
                try {
                    int i12 = $10 + 75;
                    $11 = i12 % 128;
                    int i13 = i12 % 2;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr5[i11];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    int i14 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i14;
                } catch (Exception e2) {
                    throw e2;
                }
            }
            int i15 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i15;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr5[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr5[17];
            int i16 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i17 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr5);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            i10 = verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 2;
        }
    }
}
