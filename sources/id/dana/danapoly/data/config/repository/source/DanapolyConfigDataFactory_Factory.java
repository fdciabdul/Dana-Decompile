package id.dana.danapoly.data.config.repository.source;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanapolyConfigDataFactory_Factory implements Factory<DanapolyConfigDataFactory> {
    private final Provider<DanapolyConfigData> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DanapolyConfigData> KClassImpl$Data$declaredNonStaticMembers$2;

    private DanapolyConfigDataFactory_Factory(Provider<DanapolyConfigData> provider, Provider<DanapolyConfigData> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static DanapolyConfigDataFactory_Factory BuiltInFictitiousFunctionClassFactory(Provider<DanapolyConfigData> provider, Provider<DanapolyConfigData> provider2) {
        return new DanapolyConfigDataFactory_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanapolyConfigDataFactory(this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
