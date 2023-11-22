package id.dana.feeds.domain.notification.interactor;

import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.notification.FeedsNotificationRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/feeds/domain/notification/interactor/FetchFeedNotificationCount;", "Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;", "", "Lid/dana/domain/core/usecase/NoParams;", "", "getOperationType", "()Ljava/lang/String;", "Lid/dana/domain/tracker/MixpanelRepository;", "MyBillsEntityDataFactory", "Lid/dana/domain/tracker/MixpanelRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/feeds/domain/notification/FeedsNotificationRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/notification/FeedsNotificationRepository;", "getAuthRequestContext", "p0", "p1", "<init>", "(Lid/dana/feeds/domain/notification/FeedsNotificationRepository;Lid/dana/domain/tracker/MixpanelRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FetchFeedNotificationCount extends BaseUseCaseWithAnalytics<Integer, NoParams> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final FeedsNotificationRepository getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final MixpanelRepository BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCaseWithAnalytics
    public final String getOperationType() {
        return "id.dana.feedengine.socialmedia.fetchFeedNotificationCount";
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable buildUseCase(Object obj) {
        Intrinsics.checkNotNullParameter((NoParams) obj, "");
        return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public FetchFeedNotificationCount(FeedsNotificationRepository feedsNotificationRepository, MixpanelRepository mixpanelRepository) {
        super(mixpanelRepository);
        Intrinsics.checkNotNullParameter(feedsNotificationRepository, "");
        Intrinsics.checkNotNullParameter(mixpanelRepository, "");
        this.getAuthRequestContext = feedsNotificationRepository;
        this.BuiltInFictitiousFunctionClassFactory = mixpanelRepository;
    }
}
