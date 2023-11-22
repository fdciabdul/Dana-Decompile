package id.dana.domain.payasset.interactor;

import dagger.internal.Factory;
import id.dana.domain.payasset.repository.PayAssetRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ChangePayMethod_Factory implements Factory<ChangePayMethod> {
    private final Provider<PayAssetRepository> payAssetRepositoryProvider;

    public ChangePayMethod_Factory(Provider<PayAssetRepository> provider) {
        this.payAssetRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ChangePayMethod get() {
        return newInstance(this.payAssetRepositoryProvider.get());
    }

    public static ChangePayMethod_Factory create(Provider<PayAssetRepository> provider) {
        return new ChangePayMethod_Factory(provider);
    }

    public static ChangePayMethod newInstance(PayAssetRepository payAssetRepository) {
        return new ChangePayMethod(payAssetRepository);
    }
}
