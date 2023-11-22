package id.dana.data.kycamledd.repository.source;

import dagger.internal.Factory;
import id.dana.data.kycamledd.repository.source.network.NetworkKycAmlEddEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class KycAmlEddEntityDataFactory_Factory implements Factory<KycAmlEddEntityDataFactory> {
    private final Provider<NetworkKycAmlEddEntityData> networkKycAmlEddEntityDataProvider;

    public KycAmlEddEntityDataFactory_Factory(Provider<NetworkKycAmlEddEntityData> provider) {
        this.networkKycAmlEddEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final KycAmlEddEntityDataFactory get() {
        return newInstance(this.networkKycAmlEddEntityDataProvider.get());
    }

    public static KycAmlEddEntityDataFactory_Factory create(Provider<NetworkKycAmlEddEntityData> provider) {
        return new KycAmlEddEntityDataFactory_Factory(provider);
    }

    public static KycAmlEddEntityDataFactory newInstance(NetworkKycAmlEddEntityData networkKycAmlEddEntityData) {
        return new KycAmlEddEntityDataFactory(networkKycAmlEddEntityData);
    }
}
