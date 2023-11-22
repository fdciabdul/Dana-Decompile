package id.dana.domain.paylater.interactor;

import dagger.internal.Factory;
import id.dana.domain.paylater.PaylaterRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPayLaterCacheLoanWhitelist_Factory implements Factory<GetPayLaterCacheLoanWhitelist> {
    private final Provider<PaylaterRepository> payLaterRepositoryProvider;

    public GetPayLaterCacheLoanWhitelist_Factory(Provider<PaylaterRepository> provider) {
        this.payLaterRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPayLaterCacheLoanWhitelist get() {
        return newInstance(this.payLaterRepositoryProvider.get());
    }

    public static GetPayLaterCacheLoanWhitelist_Factory create(Provider<PaylaterRepository> provider) {
        return new GetPayLaterCacheLoanWhitelist_Factory(provider);
    }

    public static GetPayLaterCacheLoanWhitelist newInstance(PaylaterRepository paylaterRepository) {
        return new GetPayLaterCacheLoanWhitelist(paylaterRepository);
    }
}
