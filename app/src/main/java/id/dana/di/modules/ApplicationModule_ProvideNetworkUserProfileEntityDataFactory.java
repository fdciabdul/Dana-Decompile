package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.data.username.source.UserProfileEntityData;
import id.dana.feeds.data.username.source.network.NetworkUserProfileEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideNetworkUserProfileEntityDataFactory implements Factory<UserProfileEntityData> {
    private final Provider<NetworkUserProfileEntityData> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideNetworkUserProfileEntityDataFactory(ApplicationModule applicationModule, Provider<NetworkUserProfileEntityData> provider) {
        this.PlaceComponentResult = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideNetworkUserProfileEntityDataFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<NetworkUserProfileEntityData> provider) {
        return new ApplicationModule_ProvideNetworkUserProfileEntityDataFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserProfileEntityData) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
