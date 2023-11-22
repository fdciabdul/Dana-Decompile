package id.dana.sync_engine.data.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.synccontact.repository.source.network.request.BizTransferSyncContactRequest;
import id.dana.data.synccontact.repository.source.network.result.BizTransferSyncContactResult;
import id.dana.feeds.data.synccontact.source.network.request.FeedsSyncRequest;
import id.dana.feeds.data.synccontact.source.network.response.FeedsSyncResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sync_engine/data/source/network/ContactSyncFacade;", "", "Lid/dana/data/synccontact/repository/source/network/request/BizTransferSyncContactRequest;", "danaUserCheckRequest", "Lid/dana/data/synccontact/repository/source/network/result/BizTransferSyncContactResult;", "checkDanaUser", "(Lid/dana/data/synccontact/repository/source/network/request/BizTransferSyncContactRequest;)Lid/dana/data/synccontact/repository/source/network/result/BizTransferSyncContactResult;", "Lid/dana/feeds/data/synccontact/source/network/request/FeedsSyncRequest;", "contactToSync", "Lid/dana/feeds/data/synccontact/source/network/response/FeedsSyncResponse;", "syncSocialContact", "(Lid/dana/feeds/data/synccontact/source/network/request/FeedsSyncRequest;)Lid/dana/feeds/data/synccontact/source/network/response/FeedsSyncResponse;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ContactSyncFacade {
    @OperationType("alipayplus.mobilewallet.biztransfer.contact.sync")
    @SignCheck
    BizTransferSyncContactResult checkDanaUser(BizTransferSyncContactRequest danaUserCheckRequest);

    @OperationType("alipayplus.mobilewallet.socialmedia.synccontact")
    @SignCheck
    FeedsSyncResponse syncSocialContact(FeedsSyncRequest contactToSync);
}
