package id.dana.data.recurring.subscription;

import id.dana.data.recurring.subscription.source.RecurringSubscriptionEntityDataFactory;
import id.dana.domain.recurring.subscription.RecurringSubscriptionRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/data/recurring/subscription/RecurringSubscriptionEntityRepository;", "Lid/dana/domain/recurring/subscription/RecurringSubscriptionRepository;", "Lio/reactivex/Observable;", "", "getCountRecurringSubscription", "()Lio/reactivex/Observable;", "Lid/dana/data/recurring/subscription/source/RecurringSubscriptionEntityDataFactory;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/recurring/subscription/source/RecurringSubscriptionEntityDataFactory;", "p0", "<init>", "(Lid/dana/data/recurring/subscription/source/RecurringSubscriptionEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RecurringSubscriptionEntityRepository implements RecurringSubscriptionRepository {
    private final RecurringSubscriptionEntityDataFactory KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public RecurringSubscriptionEntityRepository(RecurringSubscriptionEntityDataFactory recurringSubscriptionEntityDataFactory) {
        Intrinsics.checkNotNullParameter(recurringSubscriptionEntityDataFactory, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recurringSubscriptionEntityDataFactory;
    }

    @Override // id.dana.domain.recurring.subscription.RecurringSubscriptionRepository
    public final Observable<Integer> getCountRecurringSubscription() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
    }
}
