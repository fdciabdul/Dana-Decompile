package id.dana.data.useremailaddress.repository.source;

import dagger.internal.Factory;
import id.dana.data.useremailaddress.repository.source.network.NetworkUserEmailAddressEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserEmailAddressEntityDataFactory_Factory implements Factory<UserEmailAddressEntityDataFactory> {
    private final Provider<NetworkUserEmailAddressEntityData> networkUserEmailAddressEntityDataProvider;

    public UserEmailAddressEntityDataFactory_Factory(Provider<NetworkUserEmailAddressEntityData> provider) {
        this.networkUserEmailAddressEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final UserEmailAddressEntityDataFactory get() {
        return newInstance(this.networkUserEmailAddressEntityDataProvider.get());
    }

    public static UserEmailAddressEntityDataFactory_Factory create(Provider<NetworkUserEmailAddressEntityData> provider) {
        return new UserEmailAddressEntityDataFactory_Factory(provider);
    }

    public static UserEmailAddressEntityDataFactory newInstance(NetworkUserEmailAddressEntityData networkUserEmailAddressEntityData) {
        return new UserEmailAddressEntityDataFactory(networkUserEmailAddressEntityData);
    }
}
