package id.dana.feeds.domain.timeline.interactor;

import id.dana.domain.account.AccountRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.domain.timeline.model.GroupedActivity;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import id.dana.feeds.domain.timeline.model.SocialFeedWithTopFriends;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000f\u0010B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\t"}, d2 = {"Lid/dana/feeds/domain/timeline/interactor/GetTimelineWithTopFriends;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/feeds/domain/timeline/model/SocialFeedWithTopFriends;", "Lid/dana/feeds/domain/timeline/interactor/GetTimelineWithTopFriends$Params;", "Lid/dana/domain/account/AccountRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/account/AccountRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;Lid/dana/domain/account/AccountRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetTimelineWithTopFriends extends BaseUseCase<SocialFeedWithTopFriends, Params> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final FeedsTimelineRepository MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final AccountRepository BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<SocialFeedWithTopFriends> buildUseCase(Params params) {
        final Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        Observable<R> zipWith = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory().zipWith(this.MyBillsEntityDataFactory.getAuthRequestContext(), new BiFunction() { // from class: id.dana.feeds.domain.timeline.interactor.GetTimelineWithTopFriends$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return GetTimelineWithTopFriends.PlaceComponentResult((Integer) obj, (Integer) obj2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(zipWith, "");
        Observable<SocialFeedWithTopFriends> flatMap = zipWith.flatMap(new Function() { // from class: id.dana.feeds.domain.timeline.interactor.GetTimelineWithTopFriends$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetTimelineWithTopFriends.PlaceComponentResult(GetTimelineWithTopFriends.this, params2, (Pair) obj);
            }
        }).flatMap(new Function() { // from class: id.dana.feeds.domain.timeline.interactor.GetTimelineWithTopFriends$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetTimelineWithTopFriends.PlaceComponentResult(GetTimelineWithTopFriends.this, (SocialFeed) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Inject
    public GetTimelineWithTopFriends(FeedsTimelineRepository feedsTimelineRepository, AccountRepository accountRepository) {
        Intrinsics.checkNotNullParameter(feedsTimelineRepository, "");
        Intrinsics.checkNotNullParameter(accountRepository, "");
        this.MyBillsEntityDataFactory = feedsTimelineRepository;
        this.BuiltInFictitiousFunctionClassFactory = accountRepository;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\n\u001a\u00020\u0007X\u0007¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/feeds/domain/timeline/interactor/GetTimelineWithTopFriends$Params;", "", "", "getAuthRequestContext", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "", "MyBillsEntityDataFactory", "I", "PlaceComponentResult", "p0", "p1", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final int PlaceComponentResult = 50;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final boolean BuiltInFictitiousFunctionClassFactory;

        public Params(boolean z) {
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }

    public static /* synthetic */ SocialFeedWithTopFriends getAuthRequestContext(SocialFeed socialFeed, String str) {
        ArrayList activities;
        Intrinsics.checkNotNullParameter(socialFeed, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (socialFeed.isFeedNotVersionTwo()) {
            List<GroupedActivity> groupedActivities = socialFeed.getGroupedActivities();
            activities = new ArrayList();
            Iterator<T> it = groupedActivities.iterator();
            while (it.hasNext()) {
                activities.addAll(((GroupedActivity) it.next()).getActivities());
            }
        } else {
            activities = socialFeed.getActivities();
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : activities) {
            if (hashSet.add(((ActivityResponse) obj).getUserId())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!Intrinsics.areEqual(((ActivityResponse) obj2).getUserId(), str)) {
                arrayList2.add(obj2);
            }
        }
        return new SocialFeedWithTopFriends(socialFeed, CollectionsKt.take(arrayList2, 10), str);
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(GetTimelineWithTopFriends getTimelineWithTopFriends, Params params, Pair pair) {
        Intrinsics.checkNotNullParameter(getTimelineWithTopFriends, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(pair, "");
        return getTimelineWithTopFriends.MyBillsEntityDataFactory.MyBillsEntityDataFactory(null, params.PlaceComponentResult, null, null, "timelineFeed", ((Number) pair.getFirst()).intValue(), CollectionsKt.emptyList(), true, !params.getBuiltInFictitiousFunctionClassFactory() && ((Number) pair.getFirst()).intValue() == ((Number) pair.getSecond()).intValue());
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(GetTimelineWithTopFriends getTimelineWithTopFriends, final SocialFeed socialFeed) {
        Intrinsics.checkNotNullParameter(getTimelineWithTopFriends, "");
        Intrinsics.checkNotNullParameter(socialFeed, "");
        return getTimelineWithTopFriends.BuiltInFictitiousFunctionClassFactory.getUserId().map(new Function() { // from class: id.dana.feeds.domain.timeline.interactor.GetTimelineWithTopFriends$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetTimelineWithTopFriends.getAuthRequestContext(SocialFeed.this, (String) obj);
            }
        });
    }

    public static /* synthetic */ Pair PlaceComponentResult(Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(num, "");
        Intrinsics.checkNotNullParameter(num2, "");
        return new Pair(num, num2);
    }
}
