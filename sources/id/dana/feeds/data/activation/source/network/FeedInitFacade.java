package id.dana.feeds.data.activation.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.synccontact.repository.source.network.request.BizTransferSyncContactRequest;
import id.dana.data.synccontact.repository.source.network.result.BizTransferSyncContactResult;
import id.dana.feeds.data.activation.source.network.request.InitFeedRequest;
import id.dana.feeds.data.activation.source.network.response.InitFeedResponse;
import id.dana.feeds.data.synccontact.source.network.request.FeedsSyncRequest;
import id.dana.feeds.data.synccontact.source.network.response.FeedsSyncResponse;
import id.dana.feeds.ui.tracker.FeedsDisplayedErrorOperationType;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/data/activation/source/network/FeedInitFacade;", "", "Lid/dana/data/synccontact/repository/source/network/request/BizTransferSyncContactRequest;", "danaUserCheckRequest", "Lid/dana/data/synccontact/repository/source/network/result/BizTransferSyncContactResult;", "checkDanaUser", "(Lid/dana/data/synccontact/repository/source/network/request/BizTransferSyncContactRequest;)Lid/dana/data/synccontact/repository/source/network/result/BizTransferSyncContactResult;", "Lid/dana/feeds/data/activation/source/network/request/InitFeedRequest;", "initFeedRequest", "Lid/dana/feeds/data/activation/source/network/response/InitFeedResponse;", "initFeed", "(Lid/dana/feeds/data/activation/source/network/request/InitFeedRequest;)Lid/dana/feeds/data/activation/source/network/response/InitFeedResponse;", "Lid/dana/feeds/data/synccontact/source/network/request/FeedsSyncRequest;", "contactToSync", "Lid/dana/feeds/data/synccontact/source/network/response/FeedsSyncResponse;", "syncSocialContact", "(Lid/dana/feeds/data/synccontact/source/network/request/FeedsSyncRequest;)Lid/dana/feeds/data/synccontact/source/network/response/FeedsSyncResponse;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FeedInitFacade {
    @OperationType("alipayplus.mobilewallet.biztransfer.contact.sync")
    @SignCheck
    BizTransferSyncContactResult checkDanaUser(BizTransferSyncContactRequest danaUserCheckRequest);

    @OperationType(FeedsDisplayedErrorOperationType.INIT_FEED)
    @SignCheck
    InitFeedResponse initFeed(InitFeedRequest initFeedRequest);

    @OperationType("alipayplus.mobilewallet.socialmedia.synccontact")
    @SignCheck
    FeedsSyncResponse syncSocialContact(FeedsSyncRequest contactToSync);
}
