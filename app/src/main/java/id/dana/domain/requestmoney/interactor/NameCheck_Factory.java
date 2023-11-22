package id.dana.domain.requestmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.requestmoney.RequestMoneyRepository;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NameCheck_Factory implements Factory<NameCheck> {
    private final Provider<RequestMoneyRepository> requestMoneyRepositoryProvider;
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;

    public NameCheck_Factory(Provider<RequestMoneyRepository> provider, Provider<SendMoneyRepository> provider2) {
        this.requestMoneyRepositoryProvider = provider;
        this.sendMoneyRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final NameCheck get() {
        return newInstance(this.requestMoneyRepositoryProvider.get(), this.sendMoneyRepositoryProvider.get());
    }

    public static NameCheck_Factory create(Provider<RequestMoneyRepository> provider, Provider<SendMoneyRepository> provider2) {
        return new NameCheck_Factory(provider, provider2);
    }

    public static NameCheck newInstance(RequestMoneyRepository requestMoneyRepository, SendMoneyRepository sendMoneyRepository) {
        return new NameCheck(requestMoneyRepository, sendMoneyRepository);
    }
}
