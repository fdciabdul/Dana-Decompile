package id.dana.bank.contract;

import dagger.internal.Factory;
import id.dana.bank.contract.BankListContract;
import id.dana.domain.requestmoney.interactor.GetTopFeaturedBanks;
import id.dana.domain.withdraw.interactor.GetAvailableBanks;
import id.dana.sendmoney.mapper.BankModelMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class BankListPresenter_Factory implements Factory<BankListPresenter> {
    private final Provider<GetTopFeaturedBanks> BuiltInFictitiousFunctionClassFactory;
    private final Provider<BankListContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<BankModelMapper> PlaceComponentResult;
    private final Provider<GetAvailableBanks> getAuthRequestContext;

    private BankListPresenter_Factory(Provider<BankListContract.View> provider, Provider<GetTopFeaturedBanks> provider2, Provider<GetAvailableBanks> provider3, Provider<BankModelMapper> provider4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.getAuthRequestContext = provider3;
        this.PlaceComponentResult = provider4;
    }

    public static BankListPresenter_Factory MyBillsEntityDataFactory(Provider<BankListContract.View> provider, Provider<GetTopFeaturedBanks> provider2, Provider<GetAvailableBanks> provider3, Provider<BankModelMapper> provider4) {
        return new BankListPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new BankListPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}
