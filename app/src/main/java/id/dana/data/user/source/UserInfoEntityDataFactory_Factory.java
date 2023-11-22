package id.dana.data.user.source;

import dagger.internal.Factory;
import id.dana.data.user.source.network.NetworkUserEntityData;
import id.dana.data.user.source.persistence.LocalUserInfoData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserInfoEntityDataFactory_Factory implements Factory<UserInfoEntityDataFactory> {
    private final Provider<LocalUserInfoData> localUserInfoDataProvider;
    private final Provider<NetworkUserEntityData> networkUserEntityDataProvider;

    public UserInfoEntityDataFactory_Factory(Provider<NetworkUserEntityData> provider, Provider<LocalUserInfoData> provider2) {
        this.networkUserEntityDataProvider = provider;
        this.localUserInfoDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final UserInfoEntityDataFactory get() {
        return newInstance(this.networkUserEntityDataProvider.get(), this.localUserInfoDataProvider.get());
    }

    public static UserInfoEntityDataFactory_Factory create(Provider<NetworkUserEntityData> provider, Provider<LocalUserInfoData> provider2) {
        return new UserInfoEntityDataFactory_Factory(provider, provider2);
    }

    public static UserInfoEntityDataFactory newInstance(NetworkUserEntityData networkUserEntityData, LocalUserInfoData localUserInfoData) {
        return new UserInfoEntityDataFactory(networkUserEntityData, localUserInfoData);
    }
}
