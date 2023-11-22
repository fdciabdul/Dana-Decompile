package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.familyaccount.contract.FamilyJoinInvitationContract;

/* loaded from: classes4.dex */
public final class FamilyAccountJoinInvitationModule_ProvideFamilyAccountJoinInvitationViewFactory implements Factory<FamilyJoinInvitationContract.View> {
    private final FamilyAccountJoinInvitationModule getAuthRequestContext;

    private FamilyAccountJoinInvitationModule_ProvideFamilyAccountJoinInvitationViewFactory(FamilyAccountJoinInvitationModule familyAccountJoinInvitationModule) {
        this.getAuthRequestContext = familyAccountJoinInvitationModule;
    }

    public static FamilyAccountJoinInvitationModule_ProvideFamilyAccountJoinInvitationViewFactory BuiltInFictitiousFunctionClassFactory(FamilyAccountJoinInvitationModule familyAccountJoinInvitationModule) {
        return new FamilyAccountJoinInvitationModule_ProvideFamilyAccountJoinInvitationViewFactory(familyAccountJoinInvitationModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FamilyJoinInvitationContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
