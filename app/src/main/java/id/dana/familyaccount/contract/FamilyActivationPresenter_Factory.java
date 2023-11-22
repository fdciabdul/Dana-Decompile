package id.dana.familyaccount.contract;

import dagger.internal.Factory;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.familyaccount.interactor.ActivateFamilyAccount;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.familyaccount.contract.FamilyActivationContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FamilyActivationPresenter_Factory implements Factory<FamilyActivationPresenter> {
    private final Provider<GetPhoneNumber> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetUserInfo> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ActivateFamilyAccount> PlaceComponentResult;
    private final Provider<FamilyActivationContract.View> getAuthRequestContext;

    private FamilyActivationPresenter_Factory(Provider<FamilyActivationContract.View> provider, Provider<GetUserInfo> provider2, Provider<GetPhoneNumber> provider3, Provider<ActivateFamilyAccount> provider4) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.PlaceComponentResult = provider4;
    }

    public static FamilyActivationPresenter_Factory getAuthRequestContext(Provider<FamilyActivationContract.View> provider, Provider<GetUserInfo> provider2, Provider<GetPhoneNumber> provider3, Provider<ActivateFamilyAccount> provider4) {
        return new FamilyActivationPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FamilyActivationPresenter(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
