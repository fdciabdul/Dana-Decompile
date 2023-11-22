package id.dana.data.useremailaddress.repository.source.network;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkUserEmailAddressEntityData_Factory implements Factory<NetworkUserEmailAddressEntityData> {
    private final Provider<UserEmailAddressApi> userEmailAddressApiProvider;

    public NetworkUserEmailAddressEntityData_Factory(Provider<UserEmailAddressApi> provider) {
        this.userEmailAddressApiProvider = provider;
    }

    @Override // javax.inject.Provider
    public final NetworkUserEmailAddressEntityData get() {
        return newInstance(this.userEmailAddressApiProvider.get());
    }

    public static NetworkUserEmailAddressEntityData_Factory create(Provider<UserEmailAddressApi> provider) {
        return new NetworkUserEmailAddressEntityData_Factory(provider);
    }

    public static NetworkUserEmailAddressEntityData newInstance(UserEmailAddressApi userEmailAddressApi) {
        return new NetworkUserEmailAddressEntityData(userEmailAddressApi);
    }
}
