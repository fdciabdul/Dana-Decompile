package id.dana.domain.maintenance.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SaveLastDismissedBroadcast_Factory implements Factory<SaveLastDismissedBroadcast> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public SaveLastDismissedBroadcast_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveLastDismissedBroadcast get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static SaveLastDismissedBroadcast_Factory create(Provider<FeatureConfigRepository> provider) {
        return new SaveLastDismissedBroadcast_Factory(provider);
    }

    public static SaveLastDismissedBroadcast newInstance(FeatureConfigRepository featureConfigRepository) {
        return new SaveLastDismissedBroadcast(featureConfigRepository);
    }
}
