package id.dana.data.ott.repository;

import dagger.internal.Factory;
import id.dana.data.ott.repository.source.OttEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class OttEntityRepository_Factory implements Factory<OttEntityRepository> {
    private final Provider<OttEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;

    private OttEntityRepository_Factory(Provider<OttEntityDataFactory> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static OttEntityRepository_Factory BuiltInFictitiousFunctionClassFactory(Provider<OttEntityDataFactory> provider) {
        return new OttEntityRepository_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OttEntityRepository(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
