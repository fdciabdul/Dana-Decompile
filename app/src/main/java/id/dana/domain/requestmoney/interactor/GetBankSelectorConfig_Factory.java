package id.dana.domain.requestmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.requestmoney.RequestMoneyRepository;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetBankSelectorConfig_Factory implements Factory<GetBankSelectorConfig> {
    private final Provider<RequestMoneyRepository> requestMoneyRepositoryProvider;
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;

    public GetBankSelectorConfig_Factory(Provider<RequestMoneyRepository> provider, Provider<SendMoneyRepository> provider2) {
        this.requestMoneyRepositoryProvider = provider;
        this.sendMoneyRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetBankSelectorConfig get() {
        return newInstance(this.requestMoneyRepositoryProvider.get(), this.sendMoneyRepositoryProvider.get());
    }

    public static GetBankSelectorConfig_Factory create(Provider<RequestMoneyRepository> provider, Provider<SendMoneyRepository> provider2) {
        return new GetBankSelectorConfig_Factory(provider, provider2);
    }

    public static GetBankSelectorConfig newInstance(RequestMoneyRepository requestMoneyRepository, SendMoneyRepository sendMoneyRepository) {
        return new GetBankSelectorConfig(requestMoneyRepository, sendMoneyRepository);
    }
}
