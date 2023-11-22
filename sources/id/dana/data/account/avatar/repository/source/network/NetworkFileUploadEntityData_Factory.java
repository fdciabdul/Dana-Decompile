package id.dana.data.account.avatar.repository.source.network;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class NetworkFileUploadEntityData_Factory implements Factory<NetworkFileUploadEntityData> {
    private final Provider<AvatarApi> avatarApiProvider;

    public NetworkFileUploadEntityData_Factory(Provider<AvatarApi> provider) {
        this.avatarApiProvider = provider;
    }

    @Override // javax.inject.Provider
    public final NetworkFileUploadEntityData get() {
        return newInstance(this.avatarApiProvider.get());
    }

    public static NetworkFileUploadEntityData_Factory create(Provider<AvatarApi> provider) {
        return new NetworkFileUploadEntityData_Factory(provider);
    }

    public static NetworkFileUploadEntityData newInstance(AvatarApi avatarApi) {
        return new NetworkFileUploadEntityData(avatarApi);
    }
}
