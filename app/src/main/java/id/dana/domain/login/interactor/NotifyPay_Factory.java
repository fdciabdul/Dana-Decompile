package id.dana.domain.login.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.LiteAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NotifyPay_Factory implements Factory<NotifyPay> {
    private final Provider<LiteAccountRepository> liteAccountRepositoryProvider;

    public NotifyPay_Factory(Provider<LiteAccountRepository> provider) {
        this.liteAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final NotifyPay get() {
        return newInstance(this.liteAccountRepositoryProvider.get());
    }

    public static NotifyPay_Factory create(Provider<LiteAccountRepository> provider) {
        return new NotifyPay_Factory(provider);
    }

    public static NotifyPay newInstance(LiteAccountRepository liteAccountRepository) {
        return new NotifyPay(liteAccountRepository);
    }
}
