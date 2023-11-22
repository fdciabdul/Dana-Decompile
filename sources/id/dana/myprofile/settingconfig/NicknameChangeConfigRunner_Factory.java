package id.dana.myprofile.settingconfig;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NicknameChangeConfigRunner_Factory implements Factory<NicknameChangeConfigRunner> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<UserRepository> PlaceComponentResult;
    private final Provider<FeatureConfigRepository> getAuthRequestContext;

    private NicknameChangeConfigRunner_Factory(Provider<Context> provider, Provider<UserRepository> provider2, Provider<FeatureConfigRepository> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static NicknameChangeConfigRunner_Factory getAuthRequestContext(Provider<Context> provider, Provider<UserRepository> provider2, Provider<FeatureConfigRepository> provider3) {
        return new NicknameChangeConfigRunner_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NicknameChangeConfigRunner(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.getAuthRequestContext.get());
    }
}
