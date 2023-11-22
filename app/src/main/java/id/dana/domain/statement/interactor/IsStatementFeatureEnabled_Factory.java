package id.dana.domain.statement.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class IsStatementFeatureEnabled_Factory implements Factory<IsStatementFeatureEnabled> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public IsStatementFeatureEnabled_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsStatementFeatureEnabled get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static IsStatementFeatureEnabled_Factory create(Provider<FeatureConfigRepository> provider) {
        return new IsStatementFeatureEnabled_Factory(provider);
    }

    public static IsStatementFeatureEnabled newInstance(FeatureConfigRepository featureConfigRepository) {
        return new IsStatementFeatureEnabled(featureConfigRepository);
    }
}
