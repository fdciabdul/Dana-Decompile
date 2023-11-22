package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.familyaccount.contract.FamilyInvitationContract;
import id.dana.familyaccount.contract.FamilyInvitationPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FamilyAccountInvitationModule_ProvideFamilyAccountPresenterFactory implements Factory<FamilyInvitationContract.Presenter> {
    private final FamilyAccountInvitationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FamilyInvitationPresenter> getAuthRequestContext;

    private FamilyAccountInvitationModule_ProvideFamilyAccountPresenterFactory(FamilyAccountInvitationModule familyAccountInvitationModule, Provider<FamilyInvitationPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = familyAccountInvitationModule;
        this.getAuthRequestContext = provider;
    }

    public static FamilyAccountInvitationModule_ProvideFamilyAccountPresenterFactory getAuthRequestContext(FamilyAccountInvitationModule familyAccountInvitationModule, Provider<FamilyInvitationPresenter> provider) {
        return new FamilyAccountInvitationModule_ProvideFamilyAccountPresenterFactory(familyAccountInvitationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FamilyInvitationContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.getAuthRequestContext.get()));
    }
}
