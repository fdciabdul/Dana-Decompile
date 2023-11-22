package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetContactInjectionConfig_Factory implements Factory<GetContactInjectionConfig> {
    private final Provider<FeatureConfigRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private GetContactInjectionConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static GetContactInjectionConfig_Factory BuiltInFictitiousFunctionClassFactory(Provider<FeatureConfigRepository> provider) {
        return new GetContactInjectionConfig_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetContactInjectionConfig(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
