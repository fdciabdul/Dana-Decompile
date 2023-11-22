package id.dana.domain.requestmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.requestmoney.RequestMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IsFreezeNameCheck_Factory implements Factory<IsFreezeNameCheck> {
    private final Provider<RequestMoneyRepository> requestMoneyRepositoryProvider;

    public IsFreezeNameCheck_Factory(Provider<RequestMoneyRepository> provider) {
        this.requestMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsFreezeNameCheck get() {
        return newInstance(this.requestMoneyRepositoryProvider.get());
    }

    public static IsFreezeNameCheck_Factory create(Provider<RequestMoneyRepository> provider) {
        return new IsFreezeNameCheck_Factory(provider);
    }

    public static IsFreezeNameCheck newInstance(RequestMoneyRepository requestMoneyRepository) {
        return new IsFreezeNameCheck(requestMoneyRepository);
    }
}
