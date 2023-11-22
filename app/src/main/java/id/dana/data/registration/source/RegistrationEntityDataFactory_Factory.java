package id.dana.data.registration.source;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RegistrationEntityDataFactory_Factory implements Factory<RegistrationEntityDataFactory> {
    private final Provider<RegistrationEntityData> localProvider;
    private final Provider<RegistrationEntityData> networkProvider;

    public RegistrationEntityDataFactory_Factory(Provider<RegistrationEntityData> provider, Provider<RegistrationEntityData> provider2) {
        this.networkProvider = provider;
        this.localProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final RegistrationEntityDataFactory get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.networkProvider), DoubleCheck.MyBillsEntityDataFactory(this.localProvider));
    }

    public static RegistrationEntityDataFactory_Factory create(Provider<RegistrationEntityData> provider, Provider<RegistrationEntityData> provider2) {
        return new RegistrationEntityDataFactory_Factory(provider, provider2);
    }

    public static RegistrationEntityDataFactory newInstance(Lazy<RegistrationEntityData> lazy, Lazy<RegistrationEntityData> lazy2) {
        return new RegistrationEntityDataFactory(lazy, lazy2);
    }
}
