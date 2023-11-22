package id.dana.explore.domain.globalsearch.interactor;

import dagger.internal.Factory;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class IsFeatureGlobalSearchEnabled_Factory implements Factory<IsFeatureGlobalSearchEnabled> {
    private final Provider<GlobalSearchRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private IsFeatureGlobalSearchEnabled_Factory(Provider<GlobalSearchRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static IsFeatureGlobalSearchEnabled_Factory BuiltInFictitiousFunctionClassFactory(Provider<GlobalSearchRepository> provider) {
        return new IsFeatureGlobalSearchEnabled_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new IsFeatureGlobalSearchEnabled(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
