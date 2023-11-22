package id.dana.feeds.domain.timeline.interactor;

import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/feeds/domain/timeline/interactor/GetCachedTimeline;", "Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "Lid/dana/feeds/domain/timeline/interactor/GetCachedTimeline$Params;", "", "getOperationType", "()Ljava/lang/String;", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "Lid/dana/domain/tracker/MixpanelRepository;", "PlaceComponentResult", "Lid/dana/domain/tracker/MixpanelRepository;", "getAuthRequestContext", "p0", "p1", "<init>", "(Lid/dana/domain/tracker/MixpanelRepository;Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetCachedTimeline extends BaseUseCaseWithAnalytics<SocialFeed, Params> {
    private final FeedsTimelineRepository MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final MixpanelRepository getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.BaseUseCaseWithAnalytics
    public final String getOperationType() {
        return "id.dana.feedengine.socialmedia.fetchFeed";
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable buildUseCase(Object obj) {
        Params params = (Params) obj;
        Intrinsics.checkNotNullParameter(params, "");
        return this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(params.lookAheadTest, params.PlaceComponentResult, params.getAuthRequestContext, params.BuiltInFictitiousFunctionClassFactory, CollectionsKt.emptyList(), params.MyBillsEntityDataFactory, params.getKClassImpl$Data$declaredNonStaticMembers$2());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetCachedTimeline(MixpanelRepository mixpanelRepository, FeedsTimelineRepository feedsTimelineRepository) {
        super(mixpanelRepository);
        Intrinsics.checkNotNullParameter(mixpanelRepository, "");
        Intrinsics.checkNotNullParameter(feedsTimelineRepository, "");
        this.getAuthRequestContext = mixpanelRepository;
        this.MyBillsEntityDataFactory = feedsTimelineRepository;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0017\u0010\r\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0005\u0010\fR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0007¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0002X\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0011\u0010\u000f\u001a\u00020\u0006X\u0007¢\u0006\u0006\n\u0004\b\r\u0010\b"}, d2 = {"Lid/dana/feeds/domain/timeline/interactor/GetCachedTimeline$Params;", "", "", "PlaceComponentResult", "Ljava/lang/String;", "MyBillsEntityDataFactory", "", "BuiltInFictitiousFunctionClassFactory", "I", "", "getErrorConfigVersion", "Z", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "lookAheadTest", "p0", "p1", "p2", "p3", "p4", "p5", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {
        final int BuiltInFictitiousFunctionClassFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final int lookAheadTest;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final String getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String PlaceComponentResult;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

        private Params(int i, String str, String str2, String str3, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(str3, "");
            this.lookAheadTest = i;
            this.PlaceComponentResult = str;
            this.getAuthRequestContext = str2;
            this.MyBillsEntityDataFactory = str3;
            this.BuiltInFictitiousFunctionClassFactory = i2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        }

        public /* synthetic */ Params(int i, String str, String str2, String str3, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, str2, (i3 & 8) != 0 ? "timelineFeed" : str3, (i3 & 16) != 0 ? 2 : i2, (i3 & 32) != 0 ? false : z);
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }
}
