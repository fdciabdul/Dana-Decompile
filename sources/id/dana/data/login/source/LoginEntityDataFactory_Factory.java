package id.dana.data.login.source;

import dagger.internal.Factory;
import id.dana.data.login.source.network.NetworkLoginEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LoginEntityDataFactory_Factory implements Factory<LoginEntityDataFactory> {
    private final Provider<NetworkLoginEntityData> networkLoginEntityDataProvider;

    public LoginEntityDataFactory_Factory(Provider<NetworkLoginEntityData> provider) {
        this.networkLoginEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LoginEntityDataFactory get() {
        return newInstance(this.networkLoginEntityDataProvider.get());
    }

    public static LoginEntityDataFactory_Factory create(Provider<NetworkLoginEntityData> provider) {
        return new LoginEntityDataFactory_Factory(provider);
    }

    public static LoginEntityDataFactory newInstance(NetworkLoginEntityData networkLoginEntityData) {
        return new LoginEntityDataFactory(networkLoginEntityData);
    }
}
