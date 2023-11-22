package id.dana.data.home.mapper;

import id.dana.data.home.repository.source.presistence.entity.NewsWidgetActivityDaoEntity;
import id.dana.domain.feeds.model.ActivityData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0004"}, d2 = {"", "Lid/dana/data/home/repository/source/presistence/entity/NewsWidgetActivityDaoEntity;", "Lid/dana/domain/feeds/model/ActivityData;", "getAuthRequestContext", "(Ljava/util/List;)Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NewsWidgetActivityMapperKt {
    public static final List<ActivityData> getAuthRequestContext(List<NewsWidgetActivityDaoEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<NewsWidgetActivityDaoEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (NewsWidgetActivityDaoEntity newsWidgetActivityDaoEntity : list2) {
            Intrinsics.checkNotNullParameter(newsWidgetActivityDaoEntity, "");
            ActivityData activityData = new ActivityData();
            activityData.setActivityId(newsWidgetActivityDaoEntity.MyBillsEntityDataFactory);
            activityData.setActivityContent(newsWidgetActivityDaoEntity.BuiltInFictitiousFunctionClassFactory);
            activityData.setActivityTitle(newsWidgetActivityDaoEntity.PlaceComponentResult);
            activityData.setActorAvatar(newsWidgetActivityDaoEntity.getAuthRequestContext);
            activityData.setActorNickname(newsWidgetActivityDaoEntity.KClassImpl$Data$declaredNonStaticMembers$2);
            activityData.setBizType(newsWidgetActivityDaoEntity.scheduleImpl);
            activityData.setClickable(newsWidgetActivityDaoEntity.getGetErrorConfigVersion());
            activityData.setContent(newsWidgetActivityDaoEntity.NetworkUserEntityData$$ExternalSyntheticLambda0);
            Long l = newsWidgetActivityDaoEntity.moveToNextValue;
            activityData.setCreatedTime(l != null ? l.longValue() : 0L);
            activityData.setFeedType(newsWidgetActivityDaoEntity.lookAheadTest);
            activityData.setImageUrl(newsWidgetActivityDaoEntity.initRecordTimeStamp);
            activityData.setRedirectUrl(newsWidgetActivityDaoEntity.DatabaseTableConfigUtil);
            activityData.setTargetNickname(newsWidgetActivityDaoEntity.NetworkUserEntityData$$ExternalSyntheticLambda2);
            activityData.setVerb(newsWidgetActivityDaoEntity.NetworkUserEntityData$$ExternalSyntheticLambda1);
            arrayList.add(activityData);
        }
        return arrayList;
    }

    public static final List<NewsWidgetActivityDaoEntity> KClassImpl$Data$declaredNonStaticMembers$2(List<? extends ActivityData> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<? extends ActivityData> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ActivityData activityData : list2) {
            Intrinsics.checkNotNullParameter(activityData, "");
            String activityId = activityData.getActivityId();
            String str = activityId == null ? "" : activityId;
            arrayList.add(new NewsWidgetActivityDaoEntity(str, activityData.getActivityContent(), activityData.getActivityTitle(), activityData.getActorAvatar(), activityData.getActorNickname(), activityData.getBizType(), activityData.isClickable(), activityData.getContent(), Long.valueOf(activityData.getCreatedTime()), activityData.getFeedType(), activityData.getImageUrl(), activityData.getRedirectUrl(), activityData.getTargetNickname(), activityData.getVerb()));
        }
        return arrayList;
    }
}
