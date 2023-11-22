package id.dana.danapoly.domain.clear.interactor;

import dagger.internal.Factory;
import id.dana.danapoly.domain.clear.DanapolyClearRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ClearAllDanapolyData_Factory implements Factory<ClearAllDanapolyData> {
    private final Provider<DanapolyClearRepository> MyBillsEntityDataFactory;

    private ClearAllDanapolyData_Factory(Provider<DanapolyClearRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static ClearAllDanapolyData_Factory MyBillsEntityDataFactory(Provider<DanapolyClearRepository> provider) {
        return new ClearAllDanapolyData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ClearAllDanapolyData(this.MyBillsEntityDataFactory.get());
    }
}
