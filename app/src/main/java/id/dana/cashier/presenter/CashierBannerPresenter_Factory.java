package id.dana.cashier.presenter;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.cashier.CashierBannerContract;
import id.dana.cashier.domain.interactor.FetchCashierBanner;
import id.dana.cashier.domain.interactor.FetchNpsSurvey;
import id.dana.cashier.domain.interactor.SubmitNpsSurvey;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierBannerPresenter_Factory implements Factory<CashierBannerPresenter> {
    private final Provider<FetchNpsSurvey> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SubmitNpsSurvey> MyBillsEntityDataFactory;
    private final Provider<CashierBannerContract.View> PlaceComponentResult;
    private final Provider<FetchCashierBanner> getAuthRequestContext;

    private CashierBannerPresenter_Factory(Provider<CashierBannerContract.View> provider, Provider<FetchCashierBanner> provider2, Provider<FetchNpsSurvey> provider3, Provider<SubmitNpsSurvey> provider4) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.MyBillsEntityDataFactory = provider4;
    }

    public static CashierBannerPresenter_Factory MyBillsEntityDataFactory(Provider<CashierBannerContract.View> provider, Provider<FetchCashierBanner> provider2, Provider<FetchNpsSurvey> provider3, Provider<SubmitNpsSurvey> provider4) {
        return new CashierBannerPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CashierBannerPresenter(DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
    }
}
