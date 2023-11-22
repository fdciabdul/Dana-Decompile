package id.dana.feeds.data.timeline.source;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.feeds.data.timeline.source.network.request.FetchFeedRequest;
import id.dana.feeds.data.timeline.source.network.request.GetMyFeedsRequest;
import id.dana.feeds.data.timeline.source.network.response.FeedResult;
import id.dana.feeds.data.timeline.source.network.response.MyFeedResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/data/timeline/source/FeedsTimelineFacade;", "", "Lid/dana/feeds/data/timeline/source/network/request/FetchFeedRequest;", "request", "Lid/dana/feeds/data/timeline/source/network/response/FeedResult;", "fetchFeed", "(Lid/dana/feeds/data/timeline/source/network/request/FetchFeedRequest;)Lid/dana/feeds/data/timeline/source/network/response/FeedResult;", "Lid/dana/feeds/data/timeline/source/network/request/GetMyFeedsRequest;", "Lid/dana/feeds/data/timeline/source/network/response/MyFeedResult;", "getMyFeeds", "(Lid/dana/feeds/data/timeline/source/network/request/GetMyFeedsRequest;)Lid/dana/feeds/data/timeline/source/network/response/MyFeedResult;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FeedsTimelineFacade {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.getAuthRequestContext;

    @OperationType("id.dana.feedengine.socialmedia.fetchFeed")
    @SignCheck
    FeedResult fetchFeed(FetchFeedRequest request);

    @OperationType("alipayplus.mobilewallet.user.notification.fetchInbox")
    @SignCheck
    MyFeedResult getMyFeeds(GetMyFeedsRequest request);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/feeds/data/timeline/source/FeedsTimelineFacade$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion getAuthRequestContext = new Companion();

        private Companion() {
        }
    }
}
