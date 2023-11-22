package id.dana.contract.userpersonalization;

import dagger.internal.Factory;
import id.dana.contract.userpersonalization.UserPersonalizationContract;
import id.dana.explore.domain.userpersonalization.interactor.CheckShouldShowUserPersonalization;
import id.dana.explore.domain.userpersonalization.interactor.CreateUserPersonalization;
import id.dana.explore.domain.userpersonalization.interactor.GetPersonalizationOptions;
import id.dana.explore.domain.userpersonalization.interactor.SaveUserPersonalizationShown;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class UserPersonalizationPresenter_Factory implements Factory<UserPersonalizationPresenter> {
    private final Provider<SaveUserPersonalizationShown> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CreateUserPersonalization> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<UserPersonalizationContract.View> MyBillsEntityDataFactory;
    private final Provider<CheckShouldShowUserPersonalization> PlaceComponentResult;
    private final Provider<GetPersonalizationOptions> getAuthRequestContext;

    private UserPersonalizationPresenter_Factory(Provider<UserPersonalizationContract.View> provider, Provider<GetPersonalizationOptions> provider2, Provider<SaveUserPersonalizationShown> provider3, Provider<CreateUserPersonalization> provider4, Provider<CheckShouldShowUserPersonalization> provider5) {
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.PlaceComponentResult = provider5;
    }

    public static UserPersonalizationPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<UserPersonalizationContract.View> provider, Provider<GetPersonalizationOptions> provider2, Provider<SaveUserPersonalizationShown> provider3, Provider<CreateUserPersonalization> provider4, Provider<CheckShouldShowUserPersonalization> provider5) {
        return new UserPersonalizationPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserPersonalizationPresenter(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get());
    }
}
