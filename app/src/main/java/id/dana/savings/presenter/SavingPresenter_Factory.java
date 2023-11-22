package id.dana.savings.presenter;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.CheckGoalsBalanceFeature;
import id.dana.domain.saving.interactor.GetSavingEmptyState;
import id.dana.domain.saving.interactor.GetSavingSummary;
import id.dana.domain.saving.interactor.InitSavingCreate;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.savings.contract.SavingContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SavingPresenter_Factory implements Factory<SavingPresenter> {
    private final Provider<InitSavingCreate> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetSavingSummary> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CheckGoalsBalanceFeature> MyBillsEntityDataFactory;
    private final Provider<SavingContract.View> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetSavingEmptyState> PlaceComponentResult;
    private final Provider<GetUserInfoWithKyc> getAuthRequestContext;

    private SavingPresenter_Factory(Provider<SavingContract.View> provider, Provider<GetSavingSummary> provider2, Provider<GetUserInfoWithKyc> provider3, Provider<InitSavingCreate> provider4, Provider<CheckGoalsBalanceFeature> provider5, Provider<GetSavingEmptyState> provider6) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.getAuthRequestContext = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.MyBillsEntityDataFactory = provider5;
        this.PlaceComponentResult = provider6;
    }

    public static SavingPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<SavingContract.View> provider, Provider<GetSavingSummary> provider2, Provider<GetUserInfoWithKyc> provider3, Provider<InitSavingCreate> provider4, Provider<CheckGoalsBalanceFeature> provider5, Provider<GetSavingEmptyState> provider6) {
        return new SavingPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SavingPresenter(this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
