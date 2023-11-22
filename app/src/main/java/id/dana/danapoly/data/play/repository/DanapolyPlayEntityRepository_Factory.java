package id.dana.danapoly.data.play.repository;

import dagger.internal.Factory;
import id.dana.danapoly.data.play.repository.source.DanapolyPlayDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanapolyPlayEntityRepository_Factory implements Factory<DanapolyPlayEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DanapolyPlayDataFactory> MyBillsEntityDataFactory;

    private DanapolyPlayEntityRepository_Factory(Provider<DanapolyPlayDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static DanapolyPlayEntityRepository_Factory MyBillsEntityDataFactory(Provider<DanapolyPlayDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        return new DanapolyPlayEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanapolyPlayEntityRepository(this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
