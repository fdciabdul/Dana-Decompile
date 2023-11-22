package id.dana.contract.user;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.user.GetBalanceContract;
import id.dana.domain.account.interactor.GetAllBalanceVisibility;
import id.dana.domain.account.interactor.GetBalanceVisibility;
import id.dana.domain.account.interactor.SetBalanceVisibility;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary;
import id.dana.domain.user.interactor.GetBalance;
import id.dana.domain.user.interactor.GetDanaHomeBalanceConfig;
import id.dana.domain.user.interactor.GetSingleBalance;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetBalancePresenter_Factory implements Factory<GetBalancePresenter> {
    private final Provider<GetBalance> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetDanaHomeBalanceConfig> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetBalanceVisibility> MyBillsEntityDataFactory;
    private final Provider<SetBalanceVisibility> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<CurrencyAmountModelMapper> PlaceComponentResult;
    private final Provider<GetAllBalanceVisibility> getAuthRequestContext;
    private final Provider<GetSingleBalance> getErrorConfigVersion;
    private final Provider<GetUserInvestmentSummary> lookAheadTest;
    private final Provider<GetBalanceContract.View> moveToNextValue;

    private GetBalancePresenter_Factory(Provider<GetBalanceContract.View> provider, Provider<GetBalance> provider2, Provider<GetSingleBalance> provider3, Provider<CurrencyAmountModelMapper> provider4, Provider<GetBalanceVisibility> provider5, Provider<SetBalanceVisibility> provider6, Provider<GetAllBalanceVisibility> provider7, Provider<GetDanaHomeBalanceConfig> provider8, Provider<GetUserInvestmentSummary> provider9) {
        this.moveToNextValue = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.getErrorConfigVersion = provider3;
        this.PlaceComponentResult = provider4;
        this.MyBillsEntityDataFactory = provider5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider6;
        this.getAuthRequestContext = provider7;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider8;
        this.lookAheadTest = provider9;
    }

    public static GetBalancePresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<GetBalanceContract.View> provider, Provider<GetBalance> provider2, Provider<GetSingleBalance> provider3, Provider<CurrencyAmountModelMapper> provider4, Provider<GetBalanceVisibility> provider5, Provider<SetBalanceVisibility> provider6, Provider<GetAllBalanceVisibility> provider7, Provider<GetDanaHomeBalanceConfig> provider8, Provider<GetUserInvestmentSummary> provider9) {
        return new GetBalancePresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetBalancePresenter(DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest));
    }
}
