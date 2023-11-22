package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.familyaccount.contract.FamilyInvitationContract;

/* loaded from: classes4.dex */
public final class FamilyAccountInvitationModule_ProvideFamilyAccountViewFactory implements Factory<FamilyInvitationContract.View> {
    private final FamilyAccountInvitationModule getAuthRequestContext;

    private FamilyAccountInvitationModule_ProvideFamilyAccountViewFactory(FamilyAccountInvitationModule familyAccountInvitationModule) {
        this.getAuthRequestContext = familyAccountInvitationModule;
    }

    public static FamilyAccountInvitationModule_ProvideFamilyAccountViewFactory BuiltInFictitiousFunctionClassFactory(FamilyAccountInvitationModule familyAccountInvitationModule) {
        return new FamilyAccountInvitationModule_ProvideFamilyAccountViewFactory(familyAccountInvitationModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FamilyInvitationContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getPlaceComponentResult());
    }
}
