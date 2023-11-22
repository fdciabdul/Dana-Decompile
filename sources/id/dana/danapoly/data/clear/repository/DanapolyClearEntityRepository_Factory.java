package id.dana.danapoly.data.clear.repository;

import dagger.internal.Factory;
import id.dana.danapoly.data.config.repository.source.local.DanapolyPreference;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DanapolyClearEntityRepository_Factory implements Factory<DanapolyClearEntityRepository> {
    private final Provider<DanapolyPreference> MyBillsEntityDataFactory;

    private DanapolyClearEntityRepository_Factory(Provider<DanapolyPreference> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static DanapolyClearEntityRepository_Factory MyBillsEntityDataFactory(Provider<DanapolyPreference> provider) {
        return new DanapolyClearEntityRepository_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanapolyClearEntityRepository(this.MyBillsEntityDataFactory.get());
    }
}
