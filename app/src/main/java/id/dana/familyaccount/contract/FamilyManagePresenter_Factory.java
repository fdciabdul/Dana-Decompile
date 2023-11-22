package id.dana.familyaccount.contract;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.interactor.RemoveFamilyAccount;
import id.dana.domain.familyaccount.interactor.RemoveFamilyMember;
import id.dana.domain.familyaccount.interactor.SetLimitAndServicesFamilyAccount;
import id.dana.familyaccount.contract.FamilyManageContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FamilyManagePresenter_Factory implements Factory<FamilyManagePresenter> {
    private final Provider<RemoveFamilyMember> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FamilyManageContract.View> MyBillsEntityDataFactory;
    private final Provider<RemoveFamilyAccount> PlaceComponentResult;
    private final Provider<SetLimitAndServicesFamilyAccount> getAuthRequestContext;

    private FamilyManagePresenter_Factory(Provider<FamilyManageContract.View> provider, Provider<SetLimitAndServicesFamilyAccount> provider2, Provider<RemoveFamilyAccount> provider3, Provider<RemoveFamilyMember> provider4) {
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
        this.PlaceComponentResult = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
    }

    public static FamilyManagePresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<FamilyManageContract.View> provider, Provider<SetLimitAndServicesFamilyAccount> provider2, Provider<RemoveFamilyAccount> provider3, Provider<RemoveFamilyMember> provider4) {
        return new FamilyManagePresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FamilyManagePresenter(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
