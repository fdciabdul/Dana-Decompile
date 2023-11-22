package id.dana.data.recurring.subscription.di;

import dagger.Binds;
import dagger.Module;
import id.dana.data.recurring.subscription.RecurringSubscriptionEntityRepository;
import id.dana.data.recurring.subscription.source.RecurringSubscriptionEntityData;
import id.dana.data.recurring.subscription.source.network.NetworkRecurringSubscription;
import id.dana.domain.recurring.subscription.RecurringSubscriptionRepository;
import javax.inject.Singleton;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/recurring/subscription/di/RecurringSubscriptionModule;", "", "<init>", "()V", "Declarations"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {Declarations.class})
/* loaded from: classes2.dex */
public final class RecurringSubscriptionModule {
    public static final RecurringSubscriptionModule INSTANCE = new RecurringSubscriptionModule();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/recurring/subscription/di/RecurringSubscriptionModule$Declarations;", "", "Lid/dana/data/recurring/subscription/source/network/NetworkRecurringSubscription;", "p0", "Lid/dana/data/recurring/subscription/source/RecurringSubscriptionEntityData;", "getAuthRequestContext", "(Lid/dana/data/recurring/subscription/source/network/NetworkRecurringSubscription;)Lid/dana/data/recurring/subscription/source/RecurringSubscriptionEntityData;", "Lid/dana/data/recurring/subscription/RecurringSubscriptionEntityRepository;", "Lid/dana/domain/recurring/subscription/RecurringSubscriptionRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/data/recurring/subscription/RecurringSubscriptionEntityRepository;)Lid/dana/domain/recurring/subscription/RecurringSubscriptionRepository;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Module
    /* loaded from: classes8.dex */
    public interface Declarations {
        @Singleton
        @Binds
        RecurringSubscriptionRepository KClassImpl$Data$declaredNonStaticMembers$2(RecurringSubscriptionEntityRepository p0);

        @Singleton
        @Binds
        RecurringSubscriptionEntityData getAuthRequestContext(NetworkRecurringSubscription p0);
    }

    private RecurringSubscriptionModule() {
    }
}
