package id.dana.domain.recurring.subscription.interactor;

import dagger.internal.Factory;
import id.dana.domain.recurring.subscription.RecurringSubscriptionRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetCountRecurringSubscription_Factory implements Factory<GetCountRecurringSubscription> {
    private final Provider<RecurringSubscriptionRepository> repositoryProvider;

    public GetCountRecurringSubscription_Factory(Provider<RecurringSubscriptionRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetCountRecurringSubscription get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetCountRecurringSubscription_Factory create(Provider<RecurringSubscriptionRepository> provider) {
        return new GetCountRecurringSubscription_Factory(provider);
    }

    public static GetCountRecurringSubscription newInstance(RecurringSubscriptionRepository recurringSubscriptionRepository) {
        return new GetCountRecurringSubscription(recurringSubscriptionRepository);
    }
}
