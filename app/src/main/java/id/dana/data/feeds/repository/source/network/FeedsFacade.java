package id.dana.data.feeds.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.cache.CacheKey;
import id.dana.data.feeds.repository.source.network.request.DeleteFeedsEntityRequest;
import id.dana.data.feeds.repository.source.network.request.FeedsEntityRequest;
import id.dana.data.feeds.repository.source.network.result.DeleteFeedResult;
import id.dana.data.feeds.repository.source.network.result.FeedsResult;

/* loaded from: classes4.dex */
public interface FeedsFacade {
    @OperationType("alipayplus.mobilewallet.feeds.deleteActivity")
    @SignCheck
    DeleteFeedResult deleteActivity(DeleteFeedsEntityRequest deleteFeedsEntityRequest);

    @OperationType(CacheKey.HOME.FEEDS)
    @SignCheck
    FeedsResult fetchActivity(FeedsEntityRequest feedsEntityRequest);
}
