package id.dana.domain.userprofileinfo.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CheckSkipButtonMerchantList_Factory implements Factory<CheckSkipButtonMerchantList> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckSkipButtonMerchantList_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckSkipButtonMerchantList get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckSkipButtonMerchantList_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckSkipButtonMerchantList_Factory(provider);
    }

    public static CheckSkipButtonMerchantList newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckSkipButtonMerchantList(featureConfigRepository);
    }
}
