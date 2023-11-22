package id.dana.familyaccount.contract;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.interactor.AcceptFamilyInvitation;
import id.dana.domain.familyaccount.interactor.RejectFamilyInvitation;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.familyaccount.contract.FamilyJoinInvitationContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FamilyJoinInvitationPresenter_Factory implements Factory<FamilyJoinInvitationPresenter> {
    private final Provider<AcceptFamilyInvitation> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<RejectFamilyInvitation> MyBillsEntityDataFactory;
    private final Provider<GetUserInfoWithKyc> PlaceComponentResult;
    private final Provider<FamilyJoinInvitationContract.View> getAuthRequestContext;

    private FamilyJoinInvitationPresenter_Factory(Provider<FamilyJoinInvitationContract.View> provider, Provider<GetUserInfoWithKyc> provider2, Provider<AcceptFamilyInvitation> provider3, Provider<RejectFamilyInvitation> provider4) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.MyBillsEntityDataFactory = provider4;
    }

    public static FamilyJoinInvitationPresenter_Factory MyBillsEntityDataFactory(Provider<FamilyJoinInvitationContract.View> provider, Provider<GetUserInfoWithKyc> provider2, Provider<AcceptFamilyInvitation> provider3, Provider<RejectFamilyInvitation> provider4) {
        return new FamilyJoinInvitationPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FamilyJoinInvitationPresenter(this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
