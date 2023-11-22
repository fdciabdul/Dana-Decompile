package id.dana.domain.paylater.interactor;

import dagger.internal.Factory;
import id.dana.domain.paylater.PaylaterRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPayLaterLoanStatusWhitelist_Factory implements Factory<GetPayLaterLoanStatusWhitelist> {
    private final Provider<PaylaterRepository> payLaterRepositoryProvider;

    public GetPayLaterLoanStatusWhitelist_Factory(Provider<PaylaterRepository> provider) {
        this.payLaterRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPayLaterLoanStatusWhitelist get() {
        return newInstance(this.payLaterRepositoryProvider.get());
    }

    public static GetPayLaterLoanStatusWhitelist_Factory create(Provider<PaylaterRepository> provider) {
        return new GetPayLaterLoanStatusWhitelist_Factory(provider);
    }

    public static GetPayLaterLoanStatusWhitelist newInstance(PaylaterRepository paylaterRepository) {
        return new GetPayLaterLoanStatusWhitelist(paylaterRepository);
    }
}
