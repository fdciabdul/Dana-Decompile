package id.dana.domain.investment.interactor;

import dagger.internal.Factory;
import id.dana.domain.investment.InvestmentRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserInvestmentSummary_Factory implements Factory<GetUserInvestmentSummary> {
    private final Provider<InvestmentRepository> investmentRepositoryProvider;

    public GetUserInvestmentSummary_Factory(Provider<InvestmentRepository> provider) {
        this.investmentRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetUserInvestmentSummary get() {
        return newInstance(this.investmentRepositoryProvider.get());
    }

    public static GetUserInvestmentSummary_Factory create(Provider<InvestmentRepository> provider) {
        return new GetUserInvestmentSummary_Factory(provider);
    }

    public static GetUserInvestmentSummary newInstance(InvestmentRepository investmentRepository) {
        return new GetUserInvestmentSummary(investmentRepository);
    }
}
