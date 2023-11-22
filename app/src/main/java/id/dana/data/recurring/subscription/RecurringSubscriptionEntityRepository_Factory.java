package id.dana.data.recurring.subscription;

import dagger.internal.Factory;
import id.dana.data.recurring.subscription.source.RecurringSubscriptionEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RecurringSubscriptionEntityRepository_Factory implements Factory<RecurringSubscriptionEntityRepository> {
    private final Provider<RecurringSubscriptionEntityDataFactory> BuiltInFictitiousFunctionClassFactory;

    private RecurringSubscriptionEntityRepository_Factory(Provider<RecurringSubscriptionEntityDataFactory> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static RecurringSubscriptionEntityRepository_Factory PlaceComponentResult(Provider<RecurringSubscriptionEntityDataFactory> provider) {
        return new RecurringSubscriptionEntityRepository_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RecurringSubscriptionEntityRepository(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
