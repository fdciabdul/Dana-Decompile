package id.dana.feeds.data.timeline.source.persistence;

import dagger.Lazy;
import id.dana.data.base.BasePersistence;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.social.repository.source.persistence.dao.ActivityDao;
import id.dana.data.social.repository.source.persistence.entity.ActivityItemEntity;
import id.dana.feeds.data.mapper.ActivityItemEntityMapper;
import id.dana.feeds.data.timeline.source.FeedsTimelineData;
import id.dana.feeds.data.timeline.source.network.response.FeedResult;
import id.dana.feeds.data.timeline.source.network.response.MyFeedResult;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.domain.timeline.model.GroupedActivity;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B%\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001a\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007JY\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0016¢\u0006\u0004\b\u0006\u0010\u0012J-\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00102\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00130\u00102\u0006\u0010\u0004\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0015JY\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00160\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0016¢\u0006\u0004\b\u0006\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001c"}, d2 = {"Lid/dana/feeds/data/timeline/source/persistence/PersistenceFeedsTimelineEntityData;", "Lid/dana/data/base/BasePersistence;", "Lid/dana/feeds/data/timeline/source/FeedsTimelineData;", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "", "p1", "p2", "p3", "p4", "p5", "", "p6", "Lio/reactivex/Observable;", "Lid/dana/feeds/data/timeline/source/network/response/FeedResult;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)Lio/reactivex/Observable;", "Lid/dana/feeds/data/timeline/source/network/response/MyFeedResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(ILjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "(Ljava/lang/String;ILjava/util/List;)Lio/reactivex/Observable;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/domain/timeline/model/SocialFeed;)V", "Ldagger/Lazy;", "Lid/dana/feeds/data/mapper/ActivityItemEntityMapper;", "Ldagger/Lazy;", "MyBillsEntityDataFactory", "Lid/dana/data/base/BasePersistenceDao;", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PersistenceFeedsTimelineEntityData extends BasePersistence implements FeedsTimelineData {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<ActivityItemEntityMapper> MyBillsEntityDataFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public PersistenceFeedsTimelineEntityData(Lazy<BasePersistenceDao> lazy, Lazy<ActivityItemEntityMapper> lazy2) {
        super(lazy);
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        this.MyBillsEntityDataFactory = lazy2;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.feeds.data.timeline.source.FeedsTimelineData
    public final Observable<MyFeedResult> getAuthRequestContext(int p0, String p1, String p2) {
        ?? r2 = 0;
        Observable<MyFeedResult> error = Observable.error(new NotImplementedError(r2, 1, r2));
        Intrinsics.checkNotNullExpressionValue(error, "");
        return error;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.feeds.data.timeline.source.FeedsTimelineData
    public final Observable<MyFeedResult> KClassImpl$Data$declaredNonStaticMembers$2(int p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        ?? r4 = 0;
        Observable<MyFeedResult> error = Observable.error(new NotImplementedError(r4, 1, r4));
        Intrinsics.checkNotNullExpressionValue(error, "");
        return error;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.feeds.data.timeline.source.FeedsTimelineData
    public final Observable<FeedResult> getAuthRequestContext(String p0, int p1, String p2, String p3, String p4, int p5, List<String> p6) {
        Intrinsics.checkNotNullParameter(p4, "");
        Intrinsics.checkNotNullParameter(p6, "");
        ?? r3 = 0;
        Observable<FeedResult> error = Observable.error(new NotImplementedError(r3, 1, r3));
        Intrinsics.checkNotNullExpressionValue(error, "");
        return error;
    }

    @Override // id.dana.feeds.data.timeline.source.FeedsTimelineData
    public final Observable<SocialFeed> getAuthRequestContext(String str, final int i, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        Observable<SocialFeed> map = Observable.fromCallable(new Callable() { // from class: id.dana.feeds.data.timeline.source.persistence.PersistenceFeedsTimelineEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PersistenceFeedsTimelineEntityData.MyBillsEntityDataFactory(PersistenceFeedsTimelineEntityData.this);
            }
        }).map(new Function() { // from class: id.dana.feeds.data.timeline.source.persistence.PersistenceFeedsTimelineEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PersistenceFeedsTimelineEntityData.getAuthRequestContext(i, this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.data.timeline.source.FeedsTimelineData
    public final void BuiltInFictitiousFunctionClassFactory(SocialFeed p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        getDb().activityDao().clearActivities();
        if (p0.getFeedVersion() < 3) {
            List<ActivityResponse> activities = p0.getActivities();
            ActivityDao activityDao = getDb().activityDao();
            ActivityItemEntityMapper activityItemEntityMapper = this.MyBillsEntityDataFactory.get();
            Intrinsics.checkNotNullParameter(activities, "");
            List<ActivityResponse> list = activities;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(activityItemEntityMapper.KClassImpl$Data$declaredNonStaticMembers$2((ActivityResponse) it.next(), "", "", 1));
            }
            activityDao.insertActivities(arrayList);
            return;
        }
        List<GroupedActivity> groupedActivities = p0.getGroupedActivities();
        ActivityDao activityDao2 = getDb().activityDao();
        ActivityItemEntityMapper activityItemEntityMapper2 = this.MyBillsEntityDataFactory.get();
        Intrinsics.checkNotNullParameter(groupedActivities, "");
        ArrayList arrayList2 = new ArrayList();
        for (GroupedActivity groupedActivity : groupedActivities) {
            List<ActivityResponse> activities2 = groupedActivity.getActivities();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(activities2, 10));
            Iterator<T> it2 = activities2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(Boolean.valueOf(arrayList2.add(activityItemEntityMapper2.KClassImpl$Data$declaredNonStaticMembers$2((ActivityResponse) it2.next(), groupedActivity.getGroup(), groupedActivity.getId(), groupedActivity.getActorCount()))));
            }
        }
        activityDao2.insertActivities(arrayList2);
    }

    @Override // id.dana.feeds.data.timeline.source.FeedsTimelineData
    public final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        getDb().activityDao().deleteActivity(p0);
    }

    public static /* synthetic */ List MyBillsEntityDataFactory(PersistenceFeedsTimelineEntityData persistenceFeedsTimelineEntityData) {
        Intrinsics.checkNotNullParameter(persistenceFeedsTimelineEntityData, "");
        return persistenceFeedsTimelineEntityData.getDb().activityDao().getActivities();
    }

    public static /* synthetic */ SocialFeed getAuthRequestContext(int i, PersistenceFeedsTimelineEntityData persistenceFeedsTimelineEntityData, List list) {
        SocialFeed socialFeed;
        String str = "";
        Intrinsics.checkNotNullParameter(persistenceFeedsTimelineEntityData, "");
        Intrinsics.checkNotNullParameter(list, "");
        if (list.isEmpty()) {
            return new SocialFeed(false, null, null, i, null, null, false, 119, null);
        }
        if (i < 3) {
            ActivityItemEntityMapper activityItemEntityMapper = persistenceFeedsTimelineEntityData.MyBillsEntityDataFactory.get();
            Intrinsics.checkNotNullParameter(list, "");
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(activityItemEntityMapper.KClassImpl$Data$declaredNonStaticMembers$2((ActivityItemEntity) it.next()));
            }
            socialFeed = new SocialFeed(false, null, arrayList, i, null, null, false, 115, null);
        } else {
            ActivityItemEntityMapper activityItemEntityMapper2 = persistenceFeedsTimelineEntityData.MyBillsEntityDataFactory.get();
            Intrinsics.checkNotNullParameter(list, "");
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ActivityItemEntity activityItemEntity = (ActivityItemEntity) it2.next();
                if (!Intrinsics.areEqual(activityItemEntity.getState(), FeedActivityState.SUCCESS.getValue())) {
                    arrayList2.add(new GroupedActivity("", "", 1, 1, CollectionsKt.listOf(activityItemEntityMapper2.KClassImpl$Data$declaredNonStaticMembers$2(activityItemEntity)), false, 32, null));
                } else if (activityItemEntity.getGroupId() != null) {
                    arrayList3.add(activityItemEntity);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : arrayList3) {
                String groupId = ((ActivityItemEntity) obj).getGroupId();
                Object obj2 = linkedHashMap.get(groupId);
                if (obj2 == null) {
                    obj2 = (List) new ArrayList();
                    linkedHashMap.put(groupId, obj2);
                }
                ((List) obj2).add(obj);
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = str2 == null ? "" : str2;
                String groupName = ((ActivityItemEntity) CollectionsKt.first((List) entry.getValue())).getGroupName();
                String str4 = groupName == null ? "" : groupName;
                int size = ((List) entry.getValue()).size();
                Integer groupActorCount = ((ActivityItemEntity) CollectionsKt.first((List) entry.getValue())).getGroupActorCount();
                int intValue = groupActorCount != null ? groupActorCount.intValue() : 1;
                Iterable iterable = (Iterable) entry.getValue();
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                Iterator it3 = iterable.iterator();
                while (it3.hasNext()) {
                    arrayList4.add(activityItemEntityMapper2.KClassImpl$Data$declaredNonStaticMembers$2((ActivityItemEntity) it3.next()));
                }
                arrayList2.add(new GroupedActivity(str3, str4, size, intValue, arrayList4, false, 32, null));
            }
            socialFeed = new SocialFeed(false, null, null, i, arrayList2, null, false, 103, null);
        }
        if (socialFeed.getFeedVersion() < 3) {
            String id2 = ((ActivityResponse) CollectionsKt.last((List) socialFeed.getActivities())).getId();
            if (id2 != null) {
                str = id2;
            }
        } else {
            str = ((GroupedActivity) CollectionsKt.last((List) socialFeed.getGroupedActivities())).getId();
        }
        socialFeed.setMaxId(str);
        socialFeed.setFromCache(true);
        return socialFeed;
    }
}
