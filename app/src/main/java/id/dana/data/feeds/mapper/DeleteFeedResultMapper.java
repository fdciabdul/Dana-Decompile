package id.dana.data.feeds.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.feeds.repository.source.network.result.DeleteFeedResult;
import id.dana.domain.feeds.model.DeleteFeed;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class DeleteFeedResultMapper extends BaseMapper<DeleteFeedResult, DeleteFeed> {
    @Inject
    public DeleteFeedResultMapper() {
    }

    @Override // id.dana.data.base.BaseMapper
    public DeleteFeed apply(DeleteFeedResult deleteFeedResult) {
        return map(deleteFeedResult);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public DeleteFeed map(DeleteFeedResult deleteFeedResult) {
        if (deleteFeedResult != null) {
            DeleteFeed deleteFeed = new DeleteFeed();
            deleteFeed.setActivityId(deleteFeedResult.getActivityId());
            return deleteFeed;
        }
        return null;
    }
}
