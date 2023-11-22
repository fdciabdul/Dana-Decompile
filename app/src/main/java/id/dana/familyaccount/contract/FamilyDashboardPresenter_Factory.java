package id.dana.familyaccount.contract;

import dagger.internal.Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.familyaccount.interactor.CreateOrderTopUpFamilyBalance;
import id.dana.domain.familyaccount.interactor.DashboardFamilyAccount;
import id.dana.domain.familyaccount.interactor.GetFamilyAccountMaxMember;
import id.dana.domain.familyaccount.interactor.GetFamilyAvailableServices;
import id.dana.domain.familyaccount.interactor.GetMaxMemberLimit;
import id.dana.domain.familyaccount.interactor.GetTopUpUserConsult;
import id.dana.domain.familyaccount.interactor.InviteFamilyAccount;
import id.dana.domain.familyaccount.interactor.RemoveFamilyMember;
import id.dana.familyaccount.contract.FamilyDashboardContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FamilyDashboardPresenter_Factory implements Factory<FamilyDashboardPresenter> {
    private final Provider<GetFamilyAccountMaxMember> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CreateOrderTopUpFamilyBalance> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<DashboardFamilyAccount> MyBillsEntityDataFactory;
    private final Provider<GetUserId> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<FamilyDashboardContract.View> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<DeviceInformationProvider> PlaceComponentResult;
    private final Provider<GetFamilyAvailableServices> getAuthRequestContext;
    private final Provider<GetTopUpUserConsult> getErrorConfigVersion;
    private final Provider<InviteFamilyAccount> lookAheadTest;
    private final Provider<GetMaxMemberLimit> moveToNextValue;
    private final Provider<RemoveFamilyMember> scheduleImpl;

    private FamilyDashboardPresenter_Factory(Provider<FamilyDashboardContract.View> provider, Provider<DashboardFamilyAccount> provider2, Provider<GetFamilyAvailableServices> provider3, Provider<GetUserId> provider4, Provider<GetTopUpUserConsult> provider5, Provider<RemoveFamilyMember> provider6, Provider<GetMaxMemberLimit> provider7, Provider<GetFamilyAccountMaxMember> provider8, Provider<InviteFamilyAccount> provider9, Provider<CreateOrderTopUpFamilyBalance> provider10, Provider<DeviceInformationProvider> provider11) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.getAuthRequestContext = provider3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider4;
        this.getErrorConfigVersion = provider5;
        this.scheduleImpl = provider6;
        this.moveToNextValue = provider7;
        this.BuiltInFictitiousFunctionClassFactory = provider8;
        this.lookAheadTest = provider9;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider10;
        this.PlaceComponentResult = provider11;
    }

    public static FamilyDashboardPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<FamilyDashboardContract.View> provider, Provider<DashboardFamilyAccount> provider2, Provider<GetFamilyAvailableServices> provider3, Provider<GetUserId> provider4, Provider<GetTopUpUserConsult> provider5, Provider<RemoveFamilyMember> provider6, Provider<GetMaxMemberLimit> provider7, Provider<GetFamilyAccountMaxMember> provider8, Provider<InviteFamilyAccount> provider9, Provider<CreateOrderTopUpFamilyBalance> provider10, Provider<DeviceInformationProvider> provider11) {
        return new FamilyDashboardPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FamilyDashboardPresenter(this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.getErrorConfigVersion.get(), this.scheduleImpl.get(), this.moveToNextValue.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.lookAheadTest.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get());
    }
}
