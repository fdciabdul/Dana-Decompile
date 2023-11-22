package id.dana.domain.statement.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckFeatureDownloadStatement_Factory implements Factory<CheckFeatureDownloadStatement> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckFeatureDownloadStatement_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckFeatureDownloadStatement get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckFeatureDownloadStatement_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckFeatureDownloadStatement_Factory(provider);
    }

    public static CheckFeatureDownloadStatement newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckFeatureDownloadStatement(featureConfigRepository);
    }
}
