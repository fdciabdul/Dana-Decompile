package id.dana.danapoly.data.config.repository;

import dagger.internal.Factory;
import id.dana.danapoly.data.config.repository.source.DanapolyConfigDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanapolyConfigEntityRepository_Factory implements Factory<DanapolyConfigEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<DanapolyConfigDataFactory> PlaceComponentResult;

    private DanapolyConfigEntityRepository_Factory(Provider<DanapolyConfigDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static DanapolyConfigEntityRepository_Factory BuiltInFictitiousFunctionClassFactory(Provider<DanapolyConfigDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        return new DanapolyConfigEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanapolyConfigEntityRepository(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
