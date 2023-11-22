package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveIsUserCertifiedGlobalSend_Factory implements Factory<SaveIsUserCertifiedGlobalSend> {
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;

    public SaveIsUserCertifiedGlobalSend_Factory(Provider<SendMoneyRepository> provider) {
        this.sendMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveIsUserCertifiedGlobalSend get() {
        return newInstance(this.sendMoneyRepositoryProvider.get());
    }

    public static SaveIsUserCertifiedGlobalSend_Factory create(Provider<SendMoneyRepository> provider) {
        return new SaveIsUserCertifiedGlobalSend_Factory(provider);
    }

    public static SaveIsUserCertifiedGlobalSend newInstance(SendMoneyRepository sendMoneyRepository) {
        return new SaveIsUserCertifiedGlobalSend(sendMoneyRepository);
    }
}
