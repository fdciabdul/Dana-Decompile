package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class InitWithdraw_Factory implements Factory<InitWithdraw> {
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;

    public InitWithdraw_Factory(Provider<SendMoneyRepository> provider) {
        this.sendMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final InitWithdraw get() {
        return newInstance(this.sendMoneyRepositoryProvider.get());
    }

    public static InitWithdraw_Factory create(Provider<SendMoneyRepository> provider) {
        return new InitWithdraw_Factory(provider);
    }

    public static InitWithdraw newInstance(SendMoneyRepository sendMoneyRepository) {
        return new InitWithdraw(sendMoneyRepository);
    }
}
