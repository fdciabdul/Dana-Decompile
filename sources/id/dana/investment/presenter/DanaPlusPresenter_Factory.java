package id.dana.investment.presenter;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary;
import id.dana.investment.contract.DanaPlusContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DanaPlusPresenter_Factory implements Factory<DanaPlusPresenter> {
    private final Provider<DanaPlusContract.View> MyBillsEntityDataFactory;
    private final Provider<GetUserInvestmentSummary> PlaceComponentResult;

    private DanaPlusPresenter_Factory(Provider<DanaPlusContract.View> provider, Provider<GetUserInvestmentSummary> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static DanaPlusPresenter_Factory MyBillsEntityDataFactory(Provider<DanaPlusContract.View> provider, Provider<GetUserInvestmentSummary> provider2) {
        return new DanaPlusPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaPlusPresenter(DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
    }
}
