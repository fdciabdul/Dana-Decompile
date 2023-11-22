package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.userconfig.UserConfigContract;

/* loaded from: classes4.dex */
public final class UserConfigModule_ProvideViewFactory implements Factory<UserConfigContract.View> {
    private final UserConfigModule getAuthRequestContext;

    private UserConfigModule_ProvideViewFactory(UserConfigModule userConfigModule) {
        this.getAuthRequestContext = userConfigModule;
    }

    public static UserConfigModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(UserConfigModule userConfigModule) {
        return new UserConfigModule_ProvideViewFactory(userConfigModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserConfigContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult());
    }
}
