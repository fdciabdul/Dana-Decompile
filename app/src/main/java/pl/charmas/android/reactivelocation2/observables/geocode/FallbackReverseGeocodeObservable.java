package pl.charmas.android.reactivelocation2.observables.geocode;

import android.location.Address;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import java.util.Locale;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes9.dex */
class FallbackReverseGeocodeObservable implements ObservableOnSubscribe<List<Address>> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int[] MyBillsEntityDataFactory = {1244729629, -1723920359, -1522200160, 1977920104, -705321042, 1247051619, -757982323, -1612782494, -1145304545, -1484483110, -1444390983, -1811284138, -1561225277, 1594130082, -699100933, -872851775, -916156437, 1629761059};
    private static int lookAheadTest = 0;
    private static int scheduleImpl = 1;
    private final int BuiltInFictitiousFunctionClassFactory;
    private final double KClassImpl$Data$declaredNonStaticMembers$2;
    private final double PlaceComponentResult;
    private final Locale getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FallbackReverseGeocodeObservable(Locale locale, double d, double d2, int i) {
        this.getAuthRequestContext = locale;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = d;
        this.PlaceComponentResult = d2;
        this.BuiltInFictitiousFunctionClassFactory = i;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public void subscribe(ObservableEmitter<List<Address>> observableEmitter) throws Exception {
        try {
            List<Address> MyBillsEntityDataFactory2 = MyBillsEntityDataFactory();
            if (observableEmitter.isDisposed()) {
                return;
            }
            int i = scheduleImpl + 55;
            lookAheadTest = i % 128;
            if (i % 2 != 0) {
                observableEmitter.onNext(MyBillsEntityDataFactory2);
                observableEmitter.onComplete();
                Object obj = null;
                obj.hashCode();
                return;
            }
            observableEmitter.onNext(MyBillsEntityDataFactory2);
            observableEmitter.onComplete();
        } catch (Exception e) {
            if (observableEmitter.isDisposed()) {
                return;
            }
            observableEmitter.onError(e);
            int i2 = scheduleImpl + 97;
            lookAheadTest = i2 % 128;
            int i3 = i2 % 2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x017a, code lost:
    
        if (android.text.TextUtils.isEmpty(r11) != false) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<android.location.Address> MyBillsEntityDataFactory() throws java.io.IOException, org.json.JSONException {
        /*
            Method dump skipped, instructions count: 649
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.charmas.android.reactivelocation2.observables.geocode.FallbackReverseGeocodeObservable.MyBillsEntityDataFactory():java.util.List");
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = MyBillsEntityDataFactory;
        if (iArr2 != null) {
            int i2 = $10 + 27;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i4 = 0;
            while (i4 < length) {
                int i5 = $10 + 123;
                $11 = i5 % 128;
                int i6 = i5 % 2;
                iArr3[i4] = (int) (iArr2[i4] ^ (-3152031022165484798L));
                i4++;
                try {
                    int i7 = $11 + 71;
                    $10 = i7 % 128;
                    int i8 = i7 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
            int i9 = $10 + 93;
            $11 = i9 % 128;
            int i10 = i9 % 2;
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        try {
            int[] iArr5 = MyBillsEntityDataFactory;
            if (!(iArr5 == null)) {
                int i11 = $10 + 89;
                $11 = i11 % 128;
                int i12 = i11 % 2;
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                int i13 = 0;
                while (i13 < length3) {
                    iArr6[i13] = (int) (iArr5[i13] ^ (-3152031022165484798L));
                    i13++;
                    int i14 = $10 + 37;
                    $11 = i14 % 128;
                    int i15 = i14 % 2;
                    length3 = length3;
                }
                iArr5 = iArr6;
            }
            System.arraycopy(iArr5, 0, iArr4, 0, length2);
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                if ((verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length ? '/' : ')') != '/') {
                    objArr[0] = new String(cArr2, 0, i);
                    return;
                }
                cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                for (int i16 = 0; i16 < 16; i16++) {
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i16];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    int i17 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i17;
                }
                int i18 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i18;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                int i19 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i20 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
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
        } catch (Exception e2) {
            throw e2;
        }
    }
}
