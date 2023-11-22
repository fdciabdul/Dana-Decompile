package id.dana.biometric.presentation;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class RiskTrackerImpl_Factory implements Factory<RiskTrackerImpl> {
    private final Provider<RiskClient> MyBillsEntityDataFactory;

    private RiskTrackerImpl_Factory(Provider<RiskClient> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static RiskTrackerImpl_Factory MyBillsEntityDataFactory(Provider<RiskClient> provider) {
        return new RiskTrackerImpl_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RiskTrackerImpl(DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
    }
}
