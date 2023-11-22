package id.dana.data.recurring.subscription.source;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RecurringSubscriptionEntityDataFactory_Factory implements Factory<RecurringSubscriptionEntityDataFactory> {
    private final Provider<RecurringSubscriptionEntityData> getAuthRequestContext;

    private RecurringSubscriptionEntityDataFactory_Factory(Provider<RecurringSubscriptionEntityData> provider) {
        this.getAuthRequestContext = provider;
    }

    public static RecurringSubscriptionEntityDataFactory_Factory BuiltInFictitiousFunctionClassFactory(Provider<RecurringSubscriptionEntityData> provider) {
        return new RecurringSubscriptionEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RecurringSubscriptionEntityDataFactory(this.getAuthRequestContext.get());
    }
}
