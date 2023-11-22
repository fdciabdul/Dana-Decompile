package id.dana.danapoly.data.play.repository.source;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanapolyPlayDataFactory_Factory implements Factory<DanapolyPlayDataFactory> {
    private final Provider<DanapolyPlayData> KClassImpl$Data$declaredNonStaticMembers$2;

    private DanapolyPlayDataFactory_Factory(Provider<DanapolyPlayData> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static DanapolyPlayDataFactory_Factory BuiltInFictitiousFunctionClassFactory(Provider<DanapolyPlayData> provider) {
        return new DanapolyPlayDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanapolyPlayDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
