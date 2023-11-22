package id.dana.data.requestmoney;

import dagger.internal.Factory;
import id.dana.data.requestmoney.repository.RequestMoneyEntityDataFactory;
import id.dana.data.requestmoney.repository.RequestMoneyPreferenceEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RequestMoneyEntityRepository_Factory implements Factory<RequestMoneyEntityRepository> {
    private final Provider<RequestMoneyEntityDataFactory> requestMoneyEntityDataFactoryProvider;
    private final Provider<RequestMoneyPreferenceEntityDataFactory> requestMoneyPreferenceEntityDataFactoryProvider;

    public RequestMoneyEntityRepository_Factory(Provider<RequestMoneyEntityDataFactory> provider, Provider<RequestMoneyPreferenceEntityDataFactory> provider2) {
        this.requestMoneyEntityDataFactoryProvider = provider;
        this.requestMoneyPreferenceEntityDataFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final RequestMoneyEntityRepository get() {
        return newInstance(this.requestMoneyEntityDataFactoryProvider.get(), this.requestMoneyPreferenceEntityDataFactoryProvider.get());
    }

    public static RequestMoneyEntityRepository_Factory create(Provider<RequestMoneyEntityDataFactory> provider, Provider<RequestMoneyPreferenceEntityDataFactory> provider2) {
        return new RequestMoneyEntityRepository_Factory(provider, provider2);
    }

    public static RequestMoneyEntityRepository newInstance(RequestMoneyEntityDataFactory requestMoneyEntityDataFactory, RequestMoneyPreferenceEntityDataFactory requestMoneyPreferenceEntityDataFactory) {
        return new RequestMoneyEntityRepository(requestMoneyEntityDataFactory, requestMoneyPreferenceEntityDataFactory);
    }
}
