package id.dana.domain.requestmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.requestmoney.RequestMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetNameCheckCount_Factory implements Factory<GetNameCheckCount> {
    private final Provider<RequestMoneyRepository> requestMoneyRepositoryProvider;

    public GetNameCheckCount_Factory(Provider<RequestMoneyRepository> provider) {
        this.requestMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetNameCheckCount get() {
        return newInstance(this.requestMoneyRepositoryProvider.get());
    }

    public static GetNameCheckCount_Factory create(Provider<RequestMoneyRepository> provider) {
        return new GetNameCheckCount_Factory(provider);
    }

    public static GetNameCheckCount newInstance(RequestMoneyRepository requestMoneyRepository) {
        return new GetNameCheckCount(requestMoneyRepository);
    }
}
