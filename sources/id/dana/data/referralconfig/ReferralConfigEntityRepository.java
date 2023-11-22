package id.dana.data.referralconfig;

import android.os.Process;
import android.text.TextUtils;
import id.dana.data.referralconfig.mapper.ReferralConfigEntityMapper;
import id.dana.data.referralconfig.model.ReferralConfigEntity;
import id.dana.data.referralconfig.repository.source.ReferralConfigEntityData;
import id.dana.data.referralconfig.repository.source.ReferralConfigEntityDataFactory;
import id.dana.data.util.ConfigUtil;
import id.dana.domain.referralconfig.ReferralConfigRepository;
import id.dana.domain.referralconfig.model.ReferralConfig;
import io.reactivex.Observable;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.functions.Function1;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

@Singleton
/* loaded from: classes2.dex */
public class ReferralConfigEntityRepository implements ReferralConfigRepository {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int PlaceComponentResult = 0;
    private static int scheduleImpl = 1;
    private final ReferralConfigEntityDataFactory referralConfigEntityDataFactory;
    private final ReferralConfigEntityMapper referralConfigEntityMapper;
    private static char[] BuiltInFictitiousFunctionClassFactory = {39506, 39509, 39513, 39492, 39493, 39494, 39515, 39500, 39504, 39499, 39501, 39496, 39430};
    private static boolean MyBillsEntityDataFactory = true;
    private static boolean getAuthRequestContext = true;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 909154872;

    @Inject
    public ReferralConfigEntityRepository(ReferralConfigEntityDataFactory referralConfigEntityDataFactory, ReferralConfigEntityMapper referralConfigEntityMapper) {
        this.referralConfigEntityDataFactory = referralConfigEntityDataFactory;
        this.referralConfigEntityMapper = referralConfigEntityMapper;
    }

    @Override // id.dana.domain.referralconfig.ReferralConfigRepository
    public Observable<ReferralConfig> getReferralHomeConfig() {
        Observable configFallback = ConfigUtil.getConfigFallback(new ReferralConfigEntityData[]{createSplitReferralConfigEntityData(), createDefaultConfigEntityData()}, new Function1() { // from class: id.dana.data.referralconfig.ReferralConfigEntityRepository$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReferralConfigEntityRepository.lambda$getReferralHomeConfig$0((ReferralConfigEntityData) obj);
            }
        });
        ReferralConfigEntityMapper referralConfigEntityMapper = this.referralConfigEntityMapper;
        Objects.requireNonNull(referralConfigEntityMapper);
        Observable<ReferralConfig> map = configFallback.map(new ReferralConfigEntityRepository$$ExternalSyntheticLambda1(referralConfigEntityMapper));
        int i = PlaceComponentResult + 3;
        scheduleImpl = i % 128;
        if (i % 2 != 0) {
            return map;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Observable lambda$getReferralHomeConfig$0(ReferralConfigEntityData referralConfigEntityData) {
        Object obj;
        int i = scheduleImpl + 67;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? 'M' : (char) 7) != 'M') {
            Object[] objArr = new Object[1];
            a(126 - TextUtils.lastIndexOf("", '0', 0), new byte[]{-126, -117, -118, -119, -121, -120, -125, -122, -122, -126, -127, -126, -122, -121, -126, -122, -123, -124, -125, -126, -127}, null, null, objArr);
            obj = objArr[0];
        } else {
            Object[] objArr2 = new Object[1];
            a(50 - TextUtils.lastIndexOf("", '(', 1), new byte[]{-126, -117, -118, -119, -121, -120, -125, -122, -122, -126, -127, -126, -122, -121, -126, -122, -123, -124, -125, -126, -127}, null, null, objArr2);
            obj = objArr2[0];
        }
        Observable<ReferralConfigEntity> referralConfig = referralConfigEntityData.getReferralConfig(((String) obj).intern());
        int i2 = PlaceComponentResult + 101;
        scheduleImpl = i2 % 128;
        int i3 = i2 % 2;
        return referralConfig;
    }

    @Override // id.dana.domain.referralconfig.ReferralConfigRepository
    public Observable<ReferralConfig> getReferralSendMoneyConfig() {
        Observable configFallback = ConfigUtil.getConfigFallback(new ReferralConfigEntityData[]{createSplitReferralConfigEntityData(), createDefaultConfigEntityData()}, new Function1() { // from class: id.dana.data.referralconfig.ReferralConfigEntityRepository$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReferralConfigEntityRepository.lambda$getReferralSendMoneyConfig$1((ReferralConfigEntityData) obj);
            }
        });
        ReferralConfigEntityMapper referralConfigEntityMapper = this.referralConfigEntityMapper;
        Objects.requireNonNull(referralConfigEntityMapper);
        Observable<ReferralConfig> map = configFallback.map(new ReferralConfigEntityRepository$$ExternalSyntheticLambda1(referralConfigEntityMapper));
        int i = PlaceComponentResult + 45;
        scheduleImpl = i % 128;
        if ((i % 2 == 0 ? (char) 7 : (char) 30) != 7) {
            return map;
        }
        int i2 = 97 / 0;
        return map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Observable lambda$getReferralSendMoneyConfig$1(ReferralConfigEntityData referralConfigEntityData) {
        int i = scheduleImpl + 107;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Object[] objArr = new Object[1];
        a(Process.getGidForName("") + 128, new byte[]{-116, -115, -116, -121, -120, -125, -122, -122, -126, -127, -126, -122, -121, -126, -122, -123, -124, -125, -126, -127}, null, null, objArr);
        Observable<ReferralConfigEntity> referralConfig = referralConfigEntityData.getReferralConfig(((String) objArr[0]).intern());
        int i3 = PlaceComponentResult + 81;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
        return referralConfig;
    }

    private ReferralConfigEntityData createSplitReferralConfigEntityData() {
        ReferralConfigEntityData createData2;
        int i = scheduleImpl + 119;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? ')' : (char) 29) != 29) {
            createData2 = this.referralConfigEntityDataFactory.createData2("split");
            Object obj = null;
            obj.hashCode();
        } else {
            createData2 = this.referralConfigEntityDataFactory.createData2("split");
        }
        int i2 = scheduleImpl + 57;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        return createData2;
    }

    private ReferralConfigEntityData createDefaultConfigEntityData() {
        int i = PlaceComponentResult + 63;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        ReferralConfigEntityData createData2 = this.referralConfigEntityDataFactory.createData2("local");
        try {
            int i3 = PlaceComponentResult + 29;
            try {
                scheduleImpl = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return createData2;
                }
                return createData2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = BuiltInFictitiousFunctionClassFactory;
        if ((cArr2 != null ? 'C' : 'J') != 'J') {
            int i2 = $11 + 95;
            $10 = i2 % 128;
            int i3 = i2 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i4 = 0;
            while (i4 < length) {
                int i5 = $11 + 111;
                $10 = i5 % 128;
                if ((i5 % 2 != 0 ? (char) 27 : 'D') != 27) {
                    cArr3[i4] = (char) (cArr2[i4] ^ 4571606982258105150L);
                    i4++;
                } else {
                    cArr3[i4] = (char) (cArr2[i4] % 4571606982258105150L);
                    i4 /= 0;
                }
            }
            cArr2 = cArr3;
        }
        int i6 = (int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4571606982258105150L);
        if (!getAuthRequestContext) {
            if (!MyBillsEntityDataFactory) {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i6);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr4);
                return;
            }
            int i7 = $10 + 21;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                try {
                    cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i6);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                } catch (Exception e) {
                    throw e;
                }
            }
            objArr[0] = new String(cArr5);
            return;
        }
        bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
        char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
        while (true) {
            if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? 'U' : 'M') == 'M') {
                objArr[0] = new String(cArr6);
                return;
            } else {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i6);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
        }
    }
}
