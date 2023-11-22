package id.dana.data.pushverify.source;

import dagger.internal.Factory;
import id.dana.data.pushverify.source.mock.MockPushVerifyEntityData;
import id.dana.data.pushverify.source.network.NetworkPushVerifyEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PushVerifyEntityDataFactory_Factory implements Factory<PushVerifyEntityDataFactory> {
    private final Provider<MockPushVerifyEntityData> mockPushVerifyEntityDataProvider;
    private final Provider<NetworkPushVerifyEntityData> networkPushVerifyEntityDataProvider;

    public PushVerifyEntityDataFactory_Factory(Provider<NetworkPushVerifyEntityData> provider, Provider<MockPushVerifyEntityData> provider2) {
        this.networkPushVerifyEntityDataProvider = provider;
        this.mockPushVerifyEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final PushVerifyEntityDataFactory get() {
        return newInstance(this.networkPushVerifyEntityDataProvider.get(), this.mockPushVerifyEntityDataProvider.get());
    }

    public static PushVerifyEntityDataFactory_Factory create(Provider<NetworkPushVerifyEntityData> provider, Provider<MockPushVerifyEntityData> provider2) {
        return new PushVerifyEntityDataFactory_Factory(provider, provider2);
    }

    public static PushVerifyEntityDataFactory newInstance(NetworkPushVerifyEntityData networkPushVerifyEntityData, MockPushVerifyEntityData mockPushVerifyEntityData) {
        return new PushVerifyEntityDataFactory(networkPushVerifyEntityData, mockPushVerifyEntityData);
    }
}
