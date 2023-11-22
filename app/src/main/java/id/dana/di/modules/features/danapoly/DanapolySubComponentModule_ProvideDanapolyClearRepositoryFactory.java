package id.dana.di.modules.features.danapoly;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.danapoly.data.clear.repository.DanapolyClearEntityRepository;
import id.dana.danapoly.domain.clear.DanapolyClearRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DanapolySubComponentModule_ProvideDanapolyClearRepositoryFactory implements Factory<DanapolyClearRepository> {
    private final Provider<DanapolyClearEntityRepository> PlaceComponentResult;
    private final DanapolySubComponentModule getAuthRequestContext;

    private DanapolySubComponentModule_ProvideDanapolyClearRepositoryFactory(DanapolySubComponentModule danapolySubComponentModule, Provider<DanapolyClearEntityRepository> provider) {
        this.getAuthRequestContext = danapolySubComponentModule;
        this.PlaceComponentResult = provider;
    }

    public static DanapolySubComponentModule_ProvideDanapolyClearRepositoryFactory BuiltInFictitiousFunctionClassFactory(DanapolySubComponentModule danapolySubComponentModule, Provider<DanapolyClearEntityRepository> provider) {
        return new DanapolySubComponentModule_ProvideDanapolyClearRepositoryFactory(danapolySubComponentModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DanapolyClearRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}
