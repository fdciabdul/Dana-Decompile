package id.dana.domain.payasset.interactor;

import dagger.internal.Factory;
import id.dana.domain.payasset.repository.PayAssetRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetEnableAddNewCard_Factory implements Factory<GetEnableAddNewCard> {
    private final Provider<PayAssetRepository> payAssetRepositoryProvider;

    public GetEnableAddNewCard_Factory(Provider<PayAssetRepository> provider) {
        this.payAssetRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetEnableAddNewCard get() {
        return newInstance(this.payAssetRepositoryProvider.get());
    }

    public static GetEnableAddNewCard_Factory create(Provider<PayAssetRepository> provider) {
        return new GetEnableAddNewCard_Factory(provider);
    }

    public static GetEnableAddNewCard newInstance(PayAssetRepository payAssetRepository) {
        return new GetEnableAddNewCard(payAssetRepository);
    }
}
