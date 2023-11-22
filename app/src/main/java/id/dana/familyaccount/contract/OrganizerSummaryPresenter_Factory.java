package id.dana.familyaccount.contract;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.interactor.ApproveSendMoneyFamilyAccount;
import id.dana.domain.familyaccount.interactor.GetOrganizerSummary;
import id.dana.domain.familyaccount.interactor.RejectSendMoneyFamilyAccount;
import id.dana.domain.featureconfig.interactor.CheckCashierFeature;
import id.dana.domain.sendmoney.interactor.GetBankFreeTransferCheck;
import id.dana.familyaccount.contract.OrganizerSummaryContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class OrganizerSummaryPresenter_Factory implements Factory<OrganizerSummaryPresenter> {
    private final Provider<CheckCashierFeature> BuiltInFictitiousFunctionClassFactory;
    private final Provider<RejectSendMoneyFamilyAccount> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ApproveSendMoneyFamilyAccount> MyBillsEntityDataFactory;
    private final Provider<OrganizerSummaryContract.View> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetBankFreeTransferCheck> PlaceComponentResult;
    private final Provider<GetOrganizerSummary> getAuthRequestContext;

    private OrganizerSummaryPresenter_Factory(Provider<OrganizerSummaryContract.View> provider, Provider<CheckCashierFeature> provider2, Provider<GetOrganizerSummary> provider3, Provider<GetBankFreeTransferCheck> provider4, Provider<RejectSendMoneyFamilyAccount> provider5, Provider<ApproveSendMoneyFamilyAccount> provider6) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.getAuthRequestContext = provider3;
        this.PlaceComponentResult = provider4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider5;
        this.MyBillsEntityDataFactory = provider6;
    }

    public static OrganizerSummaryPresenter_Factory MyBillsEntityDataFactory(Provider<OrganizerSummaryContract.View> provider, Provider<CheckCashierFeature> provider2, Provider<GetOrganizerSummary> provider3, Provider<GetBankFreeTransferCheck> provider4, Provider<RejectSendMoneyFamilyAccount> provider5, Provider<ApproveSendMoneyFamilyAccount> provider6) {
        return new OrganizerSummaryPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OrganizerSummaryPresenter(this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
