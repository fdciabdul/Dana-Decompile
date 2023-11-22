package id.dana.contract.payqr;

import android.text.TextUtils;
import com.iap.ac.config.lite.ConfigCenter;
import dagger.Lazy;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.contract.payqr.OfflinePayContract;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import javax.inject.Inject;
import o.getOnBoardingScenario;

/* loaded from: classes4.dex */
public class OfflinePayPresenter implements OfflinePayContract.Presenter {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = -1708928008143610526L;
    private static int getAuthRequestContext = 0;
    private static int scheduleImpl = 1;
    private final Lazy<IsOfflineF2FPay> KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory = false;
    private final OfflinePayContract.View PlaceComponentResult;

    @Inject
    public OfflinePayPresenter(Lazy<IsOfflineF2FPay> lazy, OfflinePayContract.View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy;
        this.PlaceComponentResult = view;
    }

    @Override // id.dana.contract.payqr.OfflinePayContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        ConfigCenter configCenter;
        Object obj;
        int i = scheduleImpl + 89;
        getAuthRequestContext = i % 128;
        if (!(i % 2 != 0)) {
            configCenter = ConfigCenter.getInstance();
            Object[] objArr = new Object[1];
            a(53819 - TextUtils.getTrimmedLength(""), new char[]{35911, 24191, 10294, 64228, 50360, 38772, 24870, 13283, 7583, 59392, 47625, 34008, 22148, 8359, 62276, 56578, 44963}, objArr);
            obj = objArr[0];
        } else {
            configCenter = ConfigCenter.getInstance();
            Object[] objArr2 = new Object[1];
            a(53819 / TextUtils.getTrimmedLength(""), new char[]{35911, 24191, 10294, 64228, 50360, 38772, 24870, 13283, 7583, 59392, 47625, 34008, 22148, 8359, 62276, 56578, 44963}, objArr2);
            obj = objArr2[0];
        }
        boolean boolConfig = configCenter.getBoolConfig(((String) obj).intern(), false);
        this.MyBillsEntityDataFactory = boolConfig;
        this.PlaceComponentResult.MyBillsEntityDataFactory(Boolean.valueOf(boolConfig));
    }

    @Override // id.dana.contract.payqr.OfflinePayContract.Presenter
    public final Boolean MyBillsEntityDataFactory() {
        Boolean valueOf;
        try {
            int i = getAuthRequestContext + 107;
            scheduleImpl = i % 128;
            Object[] objArr = null;
            if (i % 2 != 0) {
                valueOf = Boolean.valueOf(this.MyBillsEntityDataFactory);
            } else {
                valueOf = Boolean.valueOf(this.MyBillsEntityDataFactory);
                objArr.hashCode();
            }
            int i2 = getAuthRequestContext + 67;
            scheduleImpl = i2 % 128;
            if (i2 % 2 == 0) {
                int length = objArr.length;
                return valueOf;
            }
            return valueOf;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        try {
            int i = scheduleImpl + 115;
            try {
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
                int i3 = getAuthRequestContext + 39;
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        int i2;
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        int i3 = $11 + 37;
        $10 = i3 % 128;
        int i4 = i3 % 2;
        while (true) {
            if ((getonboardingscenario.getAuthRequestContext < cArr.length ? InputCardNumberView.DIVIDER : (char) 2) == 2) {
                break;
            }
            int i5 = $10 + 19;
            $11 = i5 % 128;
            if (i5 % 2 != 0) {
                jArr[getonboardingscenario.getAuthRequestContext] = (4796183387843776835L ^ BuiltInFictitiousFunctionClassFactory) ^ (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory));
                i2 = getonboardingscenario.getAuthRequestContext + 1;
            } else {
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] * (getonboardingscenario.getAuthRequestContext ^ getonboardingscenario.MyBillsEntityDataFactory)) - (BuiltInFictitiousFunctionClassFactory % 4796183387843776835L);
                i2 = getonboardingscenario.getAuthRequestContext % 1;
            }
            getonboardingscenario.getAuthRequestContext = i2;
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            try {
                if (!(getonboardingscenario.getAuthRequestContext < cArr.length)) {
                    String str = new String(cArr2);
                    int i6 = $10 + 15;
                    $11 = i6 % 128;
                    int i7 = i6 % 2;
                    objArr[0] = str;
                    return;
                }
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                getonboardingscenario.getAuthRequestContext++;
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
