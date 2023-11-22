package id.dana.util;

import android.text.TextUtils;
import com.ut.device.UTDevice;
import id.dana.DanaApplication;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.constants.AnalyticEventConstant;
import id.dana.onboarding.unsafe.UnsafeDeviceActivity;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes3.dex */
public class RaspUtils {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final String KClassImpl$Data$declaredNonStaticMembers$2;
    private static int[] MyBillsEntityDataFactory = null;
    private static int PlaceComponentResult = 1;
    private static int getAuthRequestContext;

    /* loaded from: classes3.dex */
    public static class DexguardException extends Exception {
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        Object[] objArr = new Object[1];
        a(95 - TextUtils.indexOf("", "", 0, 0), new int[]{1092451981, -269802791, 845812823, 1847058827, -1717430094, 1897126502, 467317420, -203882294, -1297225037, 1705470504, -1133014945, 2143914811, -1109453163, 1759081538, -965534303, 1668618938, 705302112, -625958560, -196214737, 2096103073, -1752555877, 1750967565, 831413555, -819154259, 823916462, -425673395, -369311439, 1679991704, 739833778, -1286774578, 335666381, 1563086304, -2003084391, -1888482856, 1480043702, -1124981295, -1079647137, 146275530, -49423022, -67433515, -651073872, 651385130, 223486843, -1611435428, 903096948, -1798400518, 1785530624, 1890547876}, objArr);
        KClassImpl$Data$declaredNonStaticMembers$2 = ((String) objArr[0]).intern();
        int i = PlaceComponentResult + 13;
        getAuthRequestContext = i % 128;
        if (i % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        MyBillsEntityDataFactory = new int[]{-1581472029, -298735703, -190276947, -365134613, -262615487, -869960347, 1692556824, -446468709, 1362257674, 2047985551, -889183095, -1043739589, -914840415, -1666613209, 1743536514, -1947442611, -1677019518, -238821616};
    }

    public static void PlaceComponentResult(UnsafeDeviceActivity.UnsafeStatus unsafeStatus) {
        try {
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(DanaApplication.application);
            builder.MyBillsEntityDataFactory = TrackerKey.Event.UNSAFE_IDENTIFIED_DEVICE;
            EventTrackerModel.Builder MyBillsEntityDataFactory2 = builder.MyBillsEntityDataFactory("UTDID", UTDevice.getUtdid(DanaApplication.applicationContext())).MyBillsEntityDataFactory(AnalyticEventConstant.AE_AF_STATUS, unsafeStatus.getStatus());
            MyBillsEntityDataFactory2.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory2, (byte) 0));
            int i = getAuthRequestContext + 121;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int i2;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        int i3 = 2;
        char[] cArr2 = new char[iArr.length * 2];
        try {
            int[] iArr2 = MyBillsEntityDataFactory;
            if (iArr2 != null) {
                int i4 = $11 + 15;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                int length = iArr2.length;
                int[] iArr3 = new int[length];
                try {
                    int i6 = $10 + 99;
                    $11 = i6 % 128;
                    int i7 = i6 % 2;
                    int i8 = 0;
                    while (true) {
                        if (!(i8 < length)) {
                            break;
                        }
                        iArr3[i8] = (int) (iArr2[i8] ^ (-3152031022165484798L));
                        i8++;
                    }
                    iArr2 = iArr3;
                } catch (Exception e) {
                    throw e;
                }
            }
            int length2 = iArr2.length;
            int[] iArr4 = new int[length2];
            int[] iArr5 = MyBillsEntityDataFactory;
            if (iArr5 != null) {
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                int i9 = 0;
                while (true) {
                    if ((i9 < length3 ? '#' : ':') == ':') {
                        break;
                    }
                    int i10 = $11 + 69;
                    $10 = i10 % 128;
                    int i11 = i10 % i3;
                    iArr6[i9] = (int) (iArr5[i9] ^ (-3152031022165484798L));
                    i9++;
                    length2 = length2;
                    i3 = 2;
                }
                i2 = length2;
                iArr5 = iArr6;
            } else {
                i2 = length2;
            }
            System.arraycopy(iArr5, 0, iArr4, 0, i2);
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
                int i12 = $10 + 61;
                $11 = i12 % 128;
                int i13 = i12 % 2;
                cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                int i14 = 0;
                while (i14 < 16) {
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i14];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    int i15 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i15;
                    i14++;
                    int i16 = $10 + 29;
                    $11 = i16 % 128;
                    int i17 = i16 % 2;
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
            objArr[0] = new String(cArr2, 0, i);
        } catch (Exception e2) {
            throw e2;
        }
    }
}
