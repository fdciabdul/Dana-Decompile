package id.dana.familyaccount.contract;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.interactor.GetQuestionnaireData;
import id.dana.domain.familyaccount.interactor.InviteFamilyAccount;
import id.dana.domain.familyaccount.interactor.RecordAgreementFamilyAccount;
import id.dana.domain.useragreement.interactor.ConsultAgreement;
import id.dana.familyaccount.contract.FamilyInvitationContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FamilyInvitationPresenter_Factory implements Factory<FamilyInvitationPresenter> {
    private final Provider<GetQuestionnaireData> BuiltInFictitiousFunctionClassFactory;
    private final Provider<InviteFamilyAccount> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ConsultAgreement> MyBillsEntityDataFactory;
    private final Provider<FamilyInvitationContract.View> PlaceComponentResult;
    private final Provider<RecordAgreementFamilyAccount> getAuthRequestContext;

    private FamilyInvitationPresenter_Factory(Provider<FamilyInvitationContract.View> provider, Provider<InviteFamilyAccount> provider2, Provider<GetQuestionnaireData> provider3, Provider<ConsultAgreement> provider4, Provider<RecordAgreementFamilyAccount> provider5) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.getAuthRequestContext = provider5;
    }

    public static FamilyInvitationPresenter_Factory PlaceComponentResult(Provider<FamilyInvitationContract.View> provider, Provider<InviteFamilyAccount> provider2, Provider<GetQuestionnaireData> provider3, Provider<ConsultAgreement> provider4, Provider<RecordAgreementFamilyAccount> provider5) {
        return new FamilyInvitationPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FamilyInvitationPresenter(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}
