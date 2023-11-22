package id.dana.domain.senddigitalmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.senddigitalmoney.SendDigitalMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class QueryCardWithoutPrefix_Factory implements Factory<QueryCardWithoutPrefix> {
    private final Provider<SendDigitalMoneyRepository> sendDigitalMoneyRepositoryProvider;

    public QueryCardWithoutPrefix_Factory(Provider<SendDigitalMoneyRepository> provider) {
        this.sendDigitalMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final QueryCardWithoutPrefix get() {
        return newInstance(this.sendDigitalMoneyRepositoryProvider.get());
    }

    public static QueryCardWithoutPrefix_Factory create(Provider<SendDigitalMoneyRepository> provider) {
        return new QueryCardWithoutPrefix_Factory(provider);
    }

    public static QueryCardWithoutPrefix newInstance(SendDigitalMoneyRepository sendDigitalMoneyRepository) {
        return new QueryCardWithoutPrefix(sendDigitalMoneyRepository);
    }
}
