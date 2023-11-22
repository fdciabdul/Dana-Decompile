package id.dana.feeds.data.activation.source.network;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import id.dana.feeds.data.synccontact.source.network.request.FeedsSyncRequest;
import id.dana.feeds.data.synccontact.source.network.response.FeedsSyncResponse;
import id.dana.feeds.data.synccontact.source.network.response.FeedsUserContact;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/activation/source/network/FeedInitFacade;", "facade", "Lid/dana/feeds/data/synccontact/source/network/response/FeedsSyncResponse;", BridgeDSL.INVOKE, "(Lid/dana/feeds/data/activation/source/network/FeedInitFacade;)Lid/dana/feeds/data/synccontact/source/network/response/FeedsSyncResponse;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
final class NetworkFeedInitEntityData$syncContact$2 extends Lambda implements Function1<FeedInitFacade, FeedsSyncResponse> {
    final /* synthetic */ List<FeedsUserContact> $$userContacts;
    final /* synthetic */ NetworkFeedInitEntityData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NetworkFeedInitEntityData$syncContact$2(List<FeedsUserContact> list, NetworkFeedInitEntityData networkFeedInitEntityData) {
        super(1);
        this.$$userContacts = list;
        this.this$0 = networkFeedInitEntityData;
    }

    @Override // kotlin.jvm.functions.Function1
    public final FeedsSyncResponse invoke(FeedInitFacade feedInitFacade) {
        MobileEnvInfo generateMobileEnvInfo;
        Intrinsics.checkNotNullParameter(feedInitFacade, "");
        FeedsSyncRequest feedsSyncRequest = new FeedsSyncRequest(this.$$userContacts);
        generateMobileEnvInfo = this.this$0.generateMobileEnvInfo();
        feedsSyncRequest.envInfo = generateMobileEnvInfo;
        return feedInitFacade.syncSocialContact(feedsSyncRequest);
    }
}
