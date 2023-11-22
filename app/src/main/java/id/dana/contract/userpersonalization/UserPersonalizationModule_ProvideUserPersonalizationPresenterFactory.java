package id.dana.contract.userpersonalization;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.userpersonalization.UserPersonalizationContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class UserPersonalizationModule_ProvideUserPersonalizationPresenterFactory implements Factory<UserPersonalizationContract.Presenter> {
    private final UserPersonalizationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<UserPersonalizationPresenter> PlaceComponentResult;

    private UserPersonalizationModule_ProvideUserPersonalizationPresenterFactory(UserPersonalizationModule userPersonalizationModule, Provider<UserPersonalizationPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = userPersonalizationModule;
        this.PlaceComponentResult = provider;
    }

    public static UserPersonalizationModule_ProvideUserPersonalizationPresenterFactory BuiltInFictitiousFunctionClassFactory(UserPersonalizationModule userPersonalizationModule, Provider<UserPersonalizationPresenter> provider) {
        return new UserPersonalizationModule_ProvideUserPersonalizationPresenterFactory(userPersonalizationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserPersonalizationContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
