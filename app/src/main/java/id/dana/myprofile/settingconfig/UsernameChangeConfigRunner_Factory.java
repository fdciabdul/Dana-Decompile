package id.dana.myprofile.settingconfig;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class UsernameChangeConfigRunner_Factory implements Factory<UsernameChangeConfigRunner> {
    private final Provider<UserRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<FeatureConfigRepository> PlaceComponentResult;

    private UsernameChangeConfigRunner_Factory(Provider<Context> provider, Provider<UserRepository> provider2, Provider<FeatureConfigRepository> provider3) {
        this.MyBillsEntityDataFactory = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.PlaceComponentResult = provider3;
    }

    public static UsernameChangeConfigRunner_Factory MyBillsEntityDataFactory(Provider<Context> provider, Provider<UserRepository> provider2, Provider<FeatureConfigRepository> provider3) {
        return new UsernameChangeConfigRunner_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UsernameChangeConfigRunner(this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
