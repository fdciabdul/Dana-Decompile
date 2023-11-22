package id.dana.data.account.avatar.repository.source;

import dagger.internal.Factory;
import id.dana.data.account.avatar.repository.source.network.NetworkFileUploadEntityData;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AvatarEntityDataFactory_Factory implements Factory<AvatarEntityDataFactory> {
    private final Provider<NetworkFileUploadEntityData> networkFileUploadEntityDataProvider;

    public AvatarEntityDataFactory_Factory(Provider<NetworkFileUploadEntityData> provider) {
        this.networkFileUploadEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final AvatarEntityDataFactory get() {
        return newInstance(this.networkFileUploadEntityDataProvider.get());
    }

    public static AvatarEntityDataFactory_Factory create(Provider<NetworkFileUploadEntityData> provider) {
        return new AvatarEntityDataFactory_Factory(provider);
    }

    public static AvatarEntityDataFactory newInstance(NetworkFileUploadEntityData networkFileUploadEntityData) {
        return new AvatarEntityDataFactory(networkFileUploadEntityData);
    }
}
