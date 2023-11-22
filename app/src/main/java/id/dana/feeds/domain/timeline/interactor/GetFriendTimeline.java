package id.dana.feeds.domain.timeline.interactor;

import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0011\u0010\r\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/feeds/domain/timeline/interactor/GetFriendTimeline;", "Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "Lid/dana/feeds/domain/timeline/interactor/GetFriendTimeline$Params;", "", "getOperationType", "()Ljava/lang/String;", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "PlaceComponentResult", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "Lid/dana/domain/tracker/MixpanelRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/tracker/MixpanelRepository;", "getAuthRequestContext", "p0", "p1", "<init>", "(Lid/dana/domain/tracker/MixpanelRepository;Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetFriendTimeline extends BaseUseCaseWithAnalytics<SocialFeed, Params> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final MixpanelRepository getAuthRequestContext;
    private final FeedsTimelineRepository PlaceComponentResult;

    @Override // id.dana.domain.core.usecase.BaseUseCaseWithAnalytics
    public final String getOperationType() {
        return "id.dana.feedengine.socialmedia.fetchFeed";
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable buildUseCase(Object obj) {
        Observable<Integer> MyBillsEntityDataFactory;
        final Params params = (Params) obj;
        Intrinsics.checkNotNullParameter(params, "");
        Integer num = params.MyBillsEntityDataFactory;
        if (num == null || (MyBillsEntityDataFactory = Observable.just(Integer.valueOf(num.intValue()))) == null) {
            MyBillsEntityDataFactory = this.PlaceComponentResult.MyBillsEntityDataFactory();
        }
        Observable<R> flatMap = MyBillsEntityDataFactory.flatMap(new Function() { // from class: id.dana.feeds.domain.timeline.interactor.GetFriendTimeline$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj2) {
                return GetFriendTimeline.PlaceComponentResult(GetFriendTimeline.this, params, (Integer) obj2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetFriendTimeline(MixpanelRepository mixpanelRepository, FeedsTimelineRepository feedsTimelineRepository) {
        super(mixpanelRepository);
        Intrinsics.checkNotNullParameter(mixpanelRepository, "");
        Intrinsics.checkNotNullParameter(feedsTimelineRepository, "");
        this.getAuthRequestContext = mixpanelRepository;
        this.PlaceComponentResult = feedsTimelineRepository;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\rR\u0011\u0010\u000f\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000b"}, d2 = {"Lid/dana/feeds/domain/timeline/interactor/GetFriendTimeline$Params;", "", "", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "getAuthRequestContext", "", "Ljava/lang/Integer;", "MyBillsEntityDataFactory", "PlaceComponentResult", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "getErrorConfigVersion", "scheduleImpl", "p0", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final List<String> getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final int KClassImpl$Data$declaredNonStaticMembers$2;
        final String PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final Integer MyBillsEntityDataFactory;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        final String scheduleImpl;

        public Params(String str, String str2, String str3, List<String> list) {
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(list, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 50;
            this.PlaceComponentResult = str;
            this.BuiltInFictitiousFunctionClassFactory = str2;
            this.scheduleImpl = str3;
            this.MyBillsEntityDataFactory = null;
            this.getAuthRequestContext = list;
        }
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(GetFriendTimeline getFriendTimeline, Params params, Integer num) {
        Observable MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(getFriendTimeline, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(num, "");
        MyBillsEntityDataFactory = getFriendTimeline.PlaceComponentResult.MyBillsEntityDataFactory(params.scheduleImpl, params.KClassImpl$Data$declaredNonStaticMembers$2, params.PlaceComponentResult, params.BuiltInFictitiousFunctionClassFactory, "userFeed", num.intValue(), params.getAuthRequestContext, false, false);
        return MyBillsEntityDataFactory;
    }
}
