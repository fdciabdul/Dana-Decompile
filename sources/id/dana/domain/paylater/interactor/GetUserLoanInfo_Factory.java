package id.dana.domain.paylater.interactor;

import dagger.internal.Factory;
import id.dana.domain.paylater.PaylaterRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserLoanInfo_Factory implements Factory<GetUserLoanInfo> {
    private final Provider<PaylaterRepository> payLaterRepositoryProvider;

    public GetUserLoanInfo_Factory(Provider<PaylaterRepository> provider) {
        this.payLaterRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetUserLoanInfo get() {
        return newInstance(this.payLaterRepositoryProvider.get());
    }

    public static GetUserLoanInfo_Factory create(Provider<PaylaterRepository> provider) {
        return new GetUserLoanInfo_Factory(provider);
    }

    public static GetUserLoanInfo newInstance(PaylaterRepository paylaterRepository) {
        return new GetUserLoanInfo(paylaterRepository);
    }
}
