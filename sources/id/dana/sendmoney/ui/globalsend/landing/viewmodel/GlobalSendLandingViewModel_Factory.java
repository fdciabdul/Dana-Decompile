package id.dana.sendmoney.ui.globalsend.landing.viewmodel;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.globalsend.interactor.DeleteBeneficiaryList;
import id.dana.sendmoney.domain.globalsend.interactor.GetMaxBeneficiaryPageSize;
import id.dana.sendmoney.domain.globalsend.interactor.GetQueryBeneficiaryList;
import id.dana.sendmoney.domain.globalsend.interactor.GetSortBeneficiaryList;
import id.dana.sendmoney.domain.globalsend.interactor.SaveSortBeneficiaryList;
import id.dana.sendmoney.domain.globalsend.interactor.ValidateRecurringTransaction;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GlobalSendLandingViewModel_Factory implements Factory<GlobalSendLandingViewModel> {
    private final Provider<SaveSortBeneficiaryList> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DeleteBeneficiaryList> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetMaxBeneficiaryPageSize> MyBillsEntityDataFactory;
    private final Provider<GetSortBeneficiaryList> PlaceComponentResult;
    private final Provider<GetQueryBeneficiaryList> getAuthRequestContext;
    private final Provider<ValidateRecurringTransaction> getErrorConfigVersion;

    private GlobalSendLandingViewModel_Factory(Provider<GetMaxBeneficiaryPageSize> provider, Provider<GetQueryBeneficiaryList> provider2, Provider<ValidateRecurringTransaction> provider3, Provider<DeleteBeneficiaryList> provider4, Provider<SaveSortBeneficiaryList> provider5, Provider<GetSortBeneficiaryList> provider6) {
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
        this.getErrorConfigVersion = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.BuiltInFictitiousFunctionClassFactory = provider5;
        this.PlaceComponentResult = provider6;
    }

    public static GlobalSendLandingViewModel_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<GetMaxBeneficiaryPageSize> provider, Provider<GetQueryBeneficiaryList> provider2, Provider<ValidateRecurringTransaction> provider3, Provider<DeleteBeneficiaryList> provider4, Provider<SaveSortBeneficiaryList> provider5, Provider<GetSortBeneficiaryList> provider6) {
        return new GlobalSendLandingViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GlobalSendLandingViewModel(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.getErrorConfigVersion.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
