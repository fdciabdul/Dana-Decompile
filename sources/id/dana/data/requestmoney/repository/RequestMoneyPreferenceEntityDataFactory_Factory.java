package id.dana.data.requestmoney.repository;

import dagger.internal.Factory;
import id.dana.data.requestmoney.repository.source.local.RequestMoneyPreference;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RequestMoneyPreferenceEntityDataFactory_Factory implements Factory<RequestMoneyPreferenceEntityDataFactory> {
    private final Provider<RequestMoneyPreference> requestMoneyPreferenceProvider;

    public RequestMoneyPreferenceEntityDataFactory_Factory(Provider<RequestMoneyPreference> provider) {
        this.requestMoneyPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RequestMoneyPreferenceEntityDataFactory get() {
        return newInstance(this.requestMoneyPreferenceProvider.get());
    }

    public static RequestMoneyPreferenceEntityDataFactory_Factory create(Provider<RequestMoneyPreference> provider) {
        return new RequestMoneyPreferenceEntityDataFactory_Factory(provider);
    }

    public static RequestMoneyPreferenceEntityDataFactory newInstance(RequestMoneyPreference requestMoneyPreference) {
        return new RequestMoneyPreferenceEntityDataFactory(requestMoneyPreference);
    }
}
