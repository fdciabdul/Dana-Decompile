package id.dana.data.auth.face.repository.source.network;

import dagger.internal.Factory;
import id.dana.data.auth.face.repository.source.local.MockFaceAuthenticationEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FaceAuthenticationEntityDataFactory_Factory implements Factory<FaceAuthenticationEntityDataFactory> {
    private final Provider<MockFaceAuthenticationEntityData> mockFaceAuthenticationEntityDataProvider;
    private final Provider<NetworkFaceAuthenticationEntityData> networkFaceAuthenticationEntityDataProvider;

    public FaceAuthenticationEntityDataFactory_Factory(Provider<NetworkFaceAuthenticationEntityData> provider, Provider<MockFaceAuthenticationEntityData> provider2) {
        this.networkFaceAuthenticationEntityDataProvider = provider;
        this.mockFaceAuthenticationEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final FaceAuthenticationEntityDataFactory get() {
        return newInstance(this.networkFaceAuthenticationEntityDataProvider.get(), this.mockFaceAuthenticationEntityDataProvider.get());
    }

    public static FaceAuthenticationEntityDataFactory_Factory create(Provider<NetworkFaceAuthenticationEntityData> provider, Provider<MockFaceAuthenticationEntityData> provider2) {
        return new FaceAuthenticationEntityDataFactory_Factory(provider, provider2);
    }

    public static FaceAuthenticationEntityDataFactory newInstance(NetworkFaceAuthenticationEntityData networkFaceAuthenticationEntityData, MockFaceAuthenticationEntityData mockFaceAuthenticationEntityData) {
        return new FaceAuthenticationEntityDataFactory(networkFaceAuthenticationEntityData, mockFaceAuthenticationEntityData);
    }
}
