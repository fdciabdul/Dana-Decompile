package id.dana.cashier.data.repository.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SplitCashierEntityData_Factory implements Factory<SplitCashierEntityData> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitCashierEntityData_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitCashierEntityData get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitCashierEntityData_Factory create(Provider<SplitFacade> provider) {
        return new SplitCashierEntityData_Factory(provider);
    }

    public static SplitCashierEntityData newInstance(SplitFacade splitFacade) {
        return new SplitCashierEntityData(splitFacade);
    }
}
