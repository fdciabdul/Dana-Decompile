package id.dana.feeds.domain.notification.interactor;

import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.domain.social.model.FeedConfig;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B!\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000f"}, d2 = {"Lid/dana/feeds/domain/notification/interactor/GetFeedNotification;", "Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "Lid/dana/feeds/domain/notification/interactor/GetFeedNotification$Params;", "", "getOperationType", "()Ljava/lang/String;", "Lid/dana/feeds/domain/config/FeedsConfigRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/config/FeedsConfigRepository;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "PlaceComponentResult", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "Lid/dana/domain/tracker/MixpanelRepository;", "Lid/dana/domain/tracker/MixpanelRepository;", "getAuthRequestContext", "p0", "p1", "p2", "<init>", "(Lid/dana/feeds/domain/config/FeedsConfigRepository;Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;Lid/dana/domain/tracker/MixpanelRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetFeedNotification extends BaseUseCaseWithAnalytics<SocialFeed, Params> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final FeedsConfigRepository MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final MixpanelRepository getAuthRequestContext;
    private final FeedsTimelineRepository PlaceComponentResult;

    @Override // id.dana.domain.core.usecase.BaseUseCaseWithAnalytics
    public final String getOperationType() {
        return "id.dana.feedengine.socialmedia.fetchFeed";
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable buildUseCase(Object obj) {
        final Params params = (Params) obj;
        Intrinsics.checkNotNullParameter(params, "");
        Observable<R> flatMap = this.MyBillsEntityDataFactory.PlaceComponentResult().flatMap(new Function() { // from class: id.dana.feeds.domain.notification.interactor.GetFeedNotification$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj2) {
                return GetFeedNotification.MyBillsEntityDataFactory(GetFeedNotification.this, params, (FeedConfig) obj2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetFeedNotification(FeedsConfigRepository feedsConfigRepository, FeedsTimelineRepository feedsTimelineRepository, MixpanelRepository mixpanelRepository) {
        super(mixpanelRepository);
        Intrinsics.checkNotNullParameter(feedsConfigRepository, "");
        Intrinsics.checkNotNullParameter(feedsTimelineRepository, "");
        Intrinsics.checkNotNullParameter(mixpanelRepository, "");
        this.MyBillsEntityDataFactory = feedsConfigRepository;
        this.PlaceComponentResult = feedsTimelineRepository;
        this.getAuthRequestContext = mixpanelRepository;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011"}, d2 = {"Lid/dana/feeds/domain/notification/interactor/GetFeedNotification$Params;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "I", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Params {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final int getAuthRequestContext = 20;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String BuiltInFictitiousFunctionClassFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Params) {
                Params params = (Params) p0;
                return this.getAuthRequestContext == params.getAuthRequestContext && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, params.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, params.BuiltInFictitiousFunctionClassFactory);
            }
            return false;
        }

        public final int hashCode() {
            int i = this.getAuthRequestContext;
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.BuiltInFictitiousFunctionClassFactory;
            return (((i * 31) + hashCode) * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.BuiltInFictitiousFunctionClassFactory = str2;
        }
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(GetFeedNotification getFeedNotification, Params params, FeedConfig feedConfig) {
        Observable MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(getFeedNotification, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(feedConfig, "");
        MyBillsEntityDataFactory = getFeedNotification.PlaceComponentResult.MyBillsEntityDataFactory(null, params.getAuthRequestContext, params.KClassImpl$Data$declaredNonStaticMembers$2, params.BuiltInFictitiousFunctionClassFactory, "notificationFeed", feedConfig.getFeedVersion(), CollectionsKt.emptyList(), false, false);
        return MyBillsEntityDataFactory;
    }
}
