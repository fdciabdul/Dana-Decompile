package id.dana.data.sendmoney.repository.source;

import dagger.internal.Factory;
import id.dana.data.sendmoney.repository.source.local.DefaultDigitalMoneyEntityData;
import id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DigitalMoneyEntityDataFactory_Factory implements Factory<DigitalMoneyEntityDataFactory> {
    private final Provider<DefaultDigitalMoneyEntityData> defaultDigitalMoneyEntityDataProvider;
    private final Provider<SplitDigitalMoneyEntityData> splitDigitalMoneyEntityDataProvider;

    public DigitalMoneyEntityDataFactory_Factory(Provider<DefaultDigitalMoneyEntityData> provider, Provider<SplitDigitalMoneyEntityData> provider2) {
        this.defaultDigitalMoneyEntityDataProvider = provider;
        this.splitDigitalMoneyEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final DigitalMoneyEntityDataFactory get() {
        return newInstance(this.defaultDigitalMoneyEntityDataProvider.get(), this.splitDigitalMoneyEntityDataProvider.get());
    }

    public static DigitalMoneyEntityDataFactory_Factory create(Provider<DefaultDigitalMoneyEntityData> provider, Provider<SplitDigitalMoneyEntityData> provider2) {
        return new DigitalMoneyEntityDataFactory_Factory(provider, provider2);
    }

    public static DigitalMoneyEntityDataFactory newInstance(DefaultDigitalMoneyEntityData defaultDigitalMoneyEntityData, SplitDigitalMoneyEntityData splitDigitalMoneyEntityData) {
        return new DigitalMoneyEntityDataFactory(defaultDigitalMoneyEntityData, splitDigitalMoneyEntityData);
    }
}
