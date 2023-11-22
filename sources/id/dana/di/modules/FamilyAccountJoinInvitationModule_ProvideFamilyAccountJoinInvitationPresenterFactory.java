package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.familyaccount.contract.FamilyJoinInvitationContract;
import id.dana.familyaccount.contract.FamilyJoinInvitationPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FamilyAccountJoinInvitationModule_ProvideFamilyAccountJoinInvitationPresenterFactory implements Factory<FamilyJoinInvitationContract.Presenter> {
    private final FamilyAccountJoinInvitationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<FamilyJoinInvitationPresenter> getAuthRequestContext;

    private FamilyAccountJoinInvitationModule_ProvideFamilyAccountJoinInvitationPresenterFactory(FamilyAccountJoinInvitationModule familyAccountJoinInvitationModule, Provider<FamilyJoinInvitationPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = familyAccountJoinInvitationModule;
        this.getAuthRequestContext = provider;
    }

    public static FamilyAccountJoinInvitationModule_ProvideFamilyAccountJoinInvitationPresenterFactory PlaceComponentResult(FamilyAccountJoinInvitationModule familyAccountJoinInvitationModule, Provider<FamilyJoinInvitationPresenter> provider) {
        return new FamilyAccountJoinInvitationModule_ProvideFamilyAccountJoinInvitationPresenterFactory(familyAccountJoinInvitationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FamilyJoinInvitationContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.getAuthRequestContext.get()));
    }
}
