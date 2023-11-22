package id.dana.data.recurring.subscription.source;

import id.dana.data.AbstractEntityDataFactory;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/recurring/subscription/source/RecurringSubscriptionEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/recurring/subscription/source/RecurringSubscriptionEntityData;", "PlaceComponentResult", "Lid/dana/data/recurring/subscription/source/RecurringSubscriptionEntityData;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/data/recurring/subscription/source/RecurringSubscriptionEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RecurringSubscriptionEntityDataFactory extends AbstractEntityDataFactory<RecurringSubscriptionEntityData> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final RecurringSubscriptionEntityData BuiltInFictitiousFunctionClassFactory;

    @Inject
    public RecurringSubscriptionEntityDataFactory(RecurringSubscriptionEntityData recurringSubscriptionEntityData) {
        Intrinsics.checkNotNullParameter(recurringSubscriptionEntityData, "");
        this.BuiltInFictitiousFunctionClassFactory = recurringSubscriptionEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    public final /* bridge */ /* synthetic */ RecurringSubscriptionEntityData createData(String str) {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
