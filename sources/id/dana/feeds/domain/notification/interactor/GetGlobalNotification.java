package id.dana.feeds.domain.notification.interactor;

import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0019\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/feeds/domain/notification/interactor/GetGlobalNotification;", "Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "Lid/dana/feeds/domain/notification/interactor/GetGlobalNotification$Params;", "", "getOperationType", "()Ljava/lang/String;", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "p0", "Lid/dana/domain/tracker/MixpanelRepository;", "p1", "<init>", "(Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;Lid/dana/domain/tracker/MixpanelRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetGlobalNotification extends BaseUseCaseWithAnalytics<SocialFeed, Params> {
    private final FeedsTimelineRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCaseWithAnalytics
    public final String getOperationType() {
        return "alipayplus.mobilewallet.user.notification.fetchInbox";
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable buildUseCase(Object obj) {
        Params params = (Params) obj;
        Intrinsics.checkNotNullParameter(params, "");
        return this.MyBillsEntityDataFactory.PlaceComponentResult(params.BuiltInFictitiousFunctionClassFactory, params.getAuthRequestContext, params.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetGlobalNotification(FeedsTimelineRepository feedsTimelineRepository, MixpanelRepository mixpanelRepository) {
        super(mixpanelRepository);
        Intrinsics.checkNotNullParameter(feedsTimelineRepository, "");
        Intrinsics.checkNotNullParameter(mixpanelRepository, "");
        this.MyBillsEntityDataFactory = feedsTimelineRepository;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/feeds/domain/notification/interactor/GetGlobalNotification$Params;", "", "", "PlaceComponentResult", "Ljava/lang/String;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "", "BuiltInFictitiousFunctionClassFactory", "I", "p0", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {
        final int BuiltInFictitiousFunctionClassFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        public Params(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.BuiltInFictitiousFunctionClassFactory = 10;
            this.getAuthRequestContext = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        }
    }
}
