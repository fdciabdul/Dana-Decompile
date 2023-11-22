package id.dana.data.nearbyme.repository;

import dagger.internal.Factory;
import id.dana.data.account.avatar.repository.source.network.NetworkFileUploadEntityData;
import id.dana.data.account.repository.source.preference.PreferenceAccountEntityData;
import id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class MerchantReviewEntityRepository_Factory implements Factory<MerchantReviewEntityRepository> {
    private final Provider<NetworkFileUploadEntityData> networkFileUploadEntityDataProvider;
    private final Provider<NetworkMerchantInfoEntityData> networkMerchantInfoEntityDataProvider;
    private final Provider<PreferenceAccountEntityData> preferenceAccountEntityDataProvider;

    public MerchantReviewEntityRepository_Factory(Provider<NetworkMerchantInfoEntityData> provider, Provider<PreferenceAccountEntityData> provider2, Provider<NetworkFileUploadEntityData> provider3) {
        this.networkMerchantInfoEntityDataProvider = provider;
        this.preferenceAccountEntityDataProvider = provider2;
        this.networkFileUploadEntityDataProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final MerchantReviewEntityRepository get() {
        return newInstance(this.networkMerchantInfoEntityDataProvider.get(), this.preferenceAccountEntityDataProvider.get(), this.networkFileUploadEntityDataProvider.get());
    }

    public static MerchantReviewEntityRepository_Factory create(Provider<NetworkMerchantInfoEntityData> provider, Provider<PreferenceAccountEntityData> provider2, Provider<NetworkFileUploadEntityData> provider3) {
        return new MerchantReviewEntityRepository_Factory(provider, provider2, provider3);
    }

    public static MerchantReviewEntityRepository newInstance(NetworkMerchantInfoEntityData networkMerchantInfoEntityData, PreferenceAccountEntityData preferenceAccountEntityData, NetworkFileUploadEntityData networkFileUploadEntityData) {
        return new MerchantReviewEntityRepository(networkMerchantInfoEntityData, preferenceAccountEntityData, networkFileUploadEntityData);
    }
}
