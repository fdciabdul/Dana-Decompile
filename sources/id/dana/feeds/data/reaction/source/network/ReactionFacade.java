package id.dana.feeds.data.reaction.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.feeds.data.reaction.source.network.request.ActivityReactionsRequest;
import id.dana.feeds.data.reaction.source.network.request.AddActivityReactionRequest;
import id.dana.feeds.data.reaction.source.network.request.DeleteActivityReactionRequest;
import id.dana.feeds.data.reaction.source.network.response.ActivityReactionsResult;
import id.dana.feeds.data.reaction.source.network.response.AddActivityReactionResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/data/reaction/source/network/ReactionFacade;", "", "Lid/dana/feeds/data/reaction/source/network/request/AddActivityReactionRequest;", "request", "Lid/dana/feeds/data/reaction/source/network/response/AddActivityReactionResult;", "addActivityReaction", "(Lid/dana/feeds/data/reaction/source/network/request/AddActivityReactionRequest;)Lid/dana/feeds/data/reaction/source/network/response/AddActivityReactionResult;", "Lid/dana/feeds/data/reaction/source/network/request/DeleteActivityReactionRequest;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "deleteActivityReaction", "(Lid/dana/feeds/data/reaction/source/network/request/DeleteActivityReactionRequest;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/feeds/data/reaction/source/network/request/ActivityReactionsRequest;", "Lid/dana/feeds/data/reaction/source/network/response/ActivityReactionsResult;", "getActivityReactions", "(Lid/dana/feeds/data/reaction/source/network/request/ActivityReactionsRequest;)Lid/dana/feeds/data/reaction/source/network/response/ActivityReactionsResult;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ReactionFacade {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.PlaceComponentResult;

    @OperationType("alipayplus.mobilewallet.socialmedia.addActivityReaction")
    AddActivityReactionResult addActivityReaction(AddActivityReactionRequest request);

    @OperationType("alipayplus.mobilewallet.socialmedia.deleteActivityReaction")
    BaseRpcResult deleteActivityReaction(DeleteActivityReactionRequest request);

    @OperationType("alipayplus.mobilewallet.socialmedia.viewActivityReactions")
    @SignCheck
    ActivityReactionsResult getActivityReactions(ActivityReactionsRequest request);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/feeds/data/reaction/source/network/ReactionFacade$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion PlaceComponentResult = new Companion();

        private Companion() {
        }
    }
}
