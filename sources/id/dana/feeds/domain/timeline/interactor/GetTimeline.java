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

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/feeds/domain/timeline/interactor/GetTimeline;", "Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "Lid/dana/feeds/domain/timeline/interactor/GetTimeline$Params;", "", "getOperationType", "()Ljava/lang/String;", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "PlaceComponentResult", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/tracker/MixpanelRepository;", "getAuthRequestContext", "Lid/dana/domain/tracker/MixpanelRepository;", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "<init>", "(Lid/dana/domain/tracker/MixpanelRepository;Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetTimeline extends BaseUseCaseWithAnalytics<SocialFeed, Params> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FeedsTimelineRepository KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final MixpanelRepository BuiltInFictitiousFunctionClassFactory;

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
            MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        }
        Observable<R> flatMap = MyBillsEntityDataFactory.flatMap(new Function() { // from class: id.dana.feeds.domain.timeline.interactor.GetTimeline$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj2) {
                return GetTimeline.getAuthRequestContext(GetTimeline.this, params, (Integer) obj2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetTimeline(MixpanelRepository mixpanelRepository, FeedsTimelineRepository feedsTimelineRepository) {
        super(mixpanelRepository);
        Intrinsics.checkNotNullParameter(mixpanelRepository, "");
        Intrinsics.checkNotNullParameter(feedsTimelineRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = mixpanelRepository;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = feedsTimelineRepository;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\r"}, d2 = {"Lid/dana/feeds/domain/timeline/interactor/GetTimeline$Params;", "", "", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "PlaceComponentResult", "Ljava/lang/Integer;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "I", "p0", "p1", "p2", "p3", "p4", "<init>", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final List<String> KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final String PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final int BuiltInFictitiousFunctionClassFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final Integer MyBillsEntityDataFactory;
        final String getAuthRequestContext;

        public Params(int i, String str, Integer num, List<String> list) {
            Intrinsics.checkNotNullParameter(list, "");
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.PlaceComponentResult = str;
            this.getAuthRequestContext = null;
            this.MyBillsEntityDataFactory = num;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        }
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(GetTimeline getTimeline, Params params, Integer num) {
        Observable MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(getTimeline, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(num, "");
        MyBillsEntityDataFactory = getTimeline.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(null, params.BuiltInFictitiousFunctionClassFactory, params.PlaceComponentResult, params.getAuthRequestContext, "timelineFeed", num.intValue(), params.KClassImpl$Data$declaredNonStaticMembers$2, false, false);
        return MyBillsEntityDataFactory;
    }
}
