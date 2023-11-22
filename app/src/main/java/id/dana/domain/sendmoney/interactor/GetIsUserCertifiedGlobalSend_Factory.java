package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetIsUserCertifiedGlobalSend_Factory implements Factory<GetIsUserCertifiedGlobalSend> {
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;

    public GetIsUserCertifiedGlobalSend_Factory(Provider<SendMoneyRepository> provider) {
        this.sendMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetIsUserCertifiedGlobalSend get() {
        return newInstance(this.sendMoneyRepositoryProvider.get());
    }

    public static GetIsUserCertifiedGlobalSend_Factory create(Provider<SendMoneyRepository> provider) {
        return new GetIsUserCertifiedGlobalSend_Factory(provider);
    }

    public static GetIsUserCertifiedGlobalSend newInstance(SendMoneyRepository sendMoneyRepository) {
        return new GetIsUserCertifiedGlobalSend(sendMoneyRepository);
    }
}
