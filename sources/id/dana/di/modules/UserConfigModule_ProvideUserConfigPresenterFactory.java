package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.userconfig.UserConfigContract;
import id.dana.userconfig.UserConfigPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class UserConfigModule_ProvideUserConfigPresenterFactory implements Factory<UserConfigContract.Presenter> {
    private final Provider<UserConfigPresenter> MyBillsEntityDataFactory;
    private final UserConfigModule PlaceComponentResult;

    private UserConfigModule_ProvideUserConfigPresenterFactory(UserConfigModule userConfigModule, Provider<UserConfigPresenter> provider) {
        this.PlaceComponentResult = userConfigModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static UserConfigModule_ProvideUserConfigPresenterFactory BuiltInFictitiousFunctionClassFactory(UserConfigModule userConfigModule, Provider<UserConfigPresenter> provider) {
        return new UserConfigModule_ProvideUserConfigPresenterFactory(userConfigModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserConfigContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
