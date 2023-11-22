package id.dana.domain.payasset.interactor;

import dagger.internal.Factory;
import id.dana.domain.payasset.repository.PayAssetRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class QueryPayMethod_Factory implements Factory<QueryPayMethod> {
    private final Provider<PayAssetRepository> payAssetRepositoryProvider;

    public QueryPayMethod_Factory(Provider<PayAssetRepository> provider) {
        this.payAssetRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final QueryPayMethod get() {
        return newInstance(this.payAssetRepositoryProvider.get());
    }

    public static QueryPayMethod_Factory create(Provider<PayAssetRepository> provider) {
        return new QueryPayMethod_Factory(provider);
    }

    public static QueryPayMethod newInstance(PayAssetRepository payAssetRepository) {
        return new QueryPayMethod(payAssetRepository);
    }
}
