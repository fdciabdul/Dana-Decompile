package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetEWalletPrefixByBankName_Factory implements Factory<GetEWalletPrefixByBankName> {
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;

    public GetEWalletPrefixByBankName_Factory(Provider<SendMoneyRepository> provider) {
        this.sendMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetEWalletPrefixByBankName get() {
        return newInstance(this.sendMoneyRepositoryProvider.get());
    }

    public static GetEWalletPrefixByBankName_Factory create(Provider<SendMoneyRepository> provider) {
        return new GetEWalletPrefixByBankName_Factory(provider);
    }

    public static GetEWalletPrefixByBankName newInstance(SendMoneyRepository sendMoneyRepository) {
        return new GetEWalletPrefixByBankName(sendMoneyRepository);
    }
}
