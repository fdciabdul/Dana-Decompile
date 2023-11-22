package id.dana.data.wallet_v3.repository.source.network;

import dagger.internal.Factory;
import id.dana.data.wallet_v3.repository.source.local.LocalPersonalTabEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PersonalTabEntityDataFactory_Factory implements Factory<PersonalTabEntityDataFactory> {
    private final Provider<LocalPersonalTabEntityData> localPersonalTabEntityDataProvider;
    private final Provider<NetworkPersonalTabEntityData> networkPersonalTabEntityDataProvider;

    public PersonalTabEntityDataFactory_Factory(Provider<NetworkPersonalTabEntityData> provider, Provider<LocalPersonalTabEntityData> provider2) {
        this.networkPersonalTabEntityDataProvider = provider;
        this.localPersonalTabEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final PersonalTabEntityDataFactory get() {
        return newInstance(this.networkPersonalTabEntityDataProvider.get(), this.localPersonalTabEntityDataProvider.get());
    }

    public static PersonalTabEntityDataFactory_Factory create(Provider<NetworkPersonalTabEntityData> provider, Provider<LocalPersonalTabEntityData> provider2) {
        return new PersonalTabEntityDataFactory_Factory(provider, provider2);
    }

    public static PersonalTabEntityDataFactory newInstance(NetworkPersonalTabEntityData networkPersonalTabEntityData, LocalPersonalTabEntityData localPersonalTabEntityData) {
        return new PersonalTabEntityDataFactory(networkPersonalTabEntityData, localPersonalTabEntityData);
    }
}
