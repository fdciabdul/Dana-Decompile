package id.dana.domain.statement.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetStatementDisableDetail_Factory implements Factory<GetStatementDisableDetail> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetStatementDisableDetail_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetStatementDisableDetail get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetStatementDisableDetail_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetStatementDisableDetail_Factory(provider);
    }

    public static GetStatementDisableDetail newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetStatementDisableDetail(featureConfigRepository);
    }
}
