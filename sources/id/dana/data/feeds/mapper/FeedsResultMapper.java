package id.dana.data.feeds.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.feeds.model.ActivityEntity;
import id.dana.data.feeds.repository.source.network.result.FeedsResult;
import id.dana.domain.feeds.model.ActivityData;
import id.dana.domain.feeds.model.Feeds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class FeedsResultMapper extends BaseMapper<FeedsResult, Feeds> {
    @Inject
    public FeedsResultMapper() {
    }

    @Override // id.dana.data.base.BaseMapper
    public Feeds apply(FeedsResult feedsResult) {
        return map(feedsResult);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public Feeds map(FeedsResult feedsResult) {
        if (feedsResult != null) {
            Feeds feeds = new Feeds();
            feeds.setMaxId(feedsResult.getMaxId());
            feeds.setMinId(feedsResult.getMinId());
            feeds.setHasMore(feedsResult.isHasMore());
            if (feedsResult.getActivities() == null || feedsResult.getActivities().isEmpty()) {
                return feeds;
            }
            feeds.setActivities(transform(feedsResult.getActivities()));
            return feeds;
        }
        return null;
    }

    private List<ActivityData> transform(List<ActivityEntity> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ActivityEntity> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(transform(it.next()));
        }
        return arrayList;
    }

    private ActivityData transform(ActivityEntity activityEntity) {
        if (activityEntity != null) {
            ActivityData activityData = new ActivityData();
            activityData.setTargetNickname(activityEntity.getTargetNickname());
            activityData.setCreatedTime(activityEntity.getCreatedTime());
            activityData.setContent(activityEntity.getContent());
            activityData.setVerb(activityEntity.getVerb());
            activityData.setBizType(activityEntity.getBizType());
            activityData.setActorNickname(activityEntity.getActorNickname());
            activityData.setActivityId(activityEntity.getActivityId());
            activityData.setActorAvatar(activityEntity.getActorAvatar());
            activityData.setClickable(activityEntity.isClickable());
            activityData.setRedirectUrl(activityEntity.getRedirectUrl());
            activityData.setActivityTitle(activityEntity.getActivityTitle());
            activityData.setActivityContent(activityEntity.getActivityContent());
            activityData.setFeedType(activityEntity.getFeedType());
            activityData.setImageUrl(activityEntity.getImageUrl());
            return activityData;
        }
        return null;
    }
}
