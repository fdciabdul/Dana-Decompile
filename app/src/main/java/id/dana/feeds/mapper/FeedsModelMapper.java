package id.dana.feeds.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.feeds.model.ActivityData;
import id.dana.domain.feeds.model.Feeds;
import id.dana.feeds.model.ActivityModel;
import id.dana.feeds.model.FeedsModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class FeedsModelMapper extends BaseMapper<Feeds, FeedsModel> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ FeedsModel apply(Feeds feeds) {
        return PlaceComponentResult(feeds);
    }

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ FeedsModel map(Feeds feeds) {
        return PlaceComponentResult(feeds);
    }

    @Inject
    public FeedsModelMapper() {
    }

    public static FeedsModel PlaceComponentResult(Feeds feeds) {
        if (feeds != null) {
            FeedsModel feedsModel = new FeedsModel();
            feedsModel.getAuthRequestContext = feeds.isHasMore();
            feedsModel.BuiltInFictitiousFunctionClassFactory = feeds.getMaxId();
            feedsModel.MyBillsEntityDataFactory = feeds.isFirstPage();
            if (feeds.getActivities() == null || feeds.getActivities().isEmpty()) {
                return feedsModel;
            }
            feedsModel.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory(feeds.getActivities());
            return feedsModel;
        }
        return null;
    }

    private static List<ActivityModel> BuiltInFictitiousFunctionClassFactory(List<ActivityData> list) {
        ActivityModel activityModel;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ActivityData activityData : list) {
            if (activityData != null) {
                activityModel = new ActivityModel();
                activityModel.lookAheadTest = activityData.getActorAvatar();
                activityModel.initRecordTimeStamp = activityData.getCreatedTime();
                activityModel.KClassImpl$Data$declaredNonStaticMembers$2 = activityData.getActorNickname();
                activityModel.scheduleImpl = activityData.getContent();
                activityModel.DatabaseTableConfigUtil = activityData.getVerb();
                activityModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = activityData.getTargetNickname();
                activityModel.moveToNextValue = 1;
                activityModel.PlaceComponentResult = activityData.getActivityId();
                activityModel.BuiltInFictitiousFunctionClassFactory = activityData.isClickable();
                activityModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = activityData.getRedirectUrl();
                activityModel.MyBillsEntityDataFactory = activityData.getActivityTitle();
                activityModel.getAuthRequestContext = activityData.getActivityContent();
                activityModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = activityData.getFeedType();
                activityModel.getErrorConfigVersion = activityData.getImageUrl();
            } else {
                activityModel = null;
            }
            arrayList.add(activityModel);
        }
        return arrayList;
    }
}
