package id.dana.feeds.data.detail.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.feeds.data.detail.source.network.request.AddActivityCommentRequest;
import id.dana.feeds.data.detail.source.network.request.DeleteCommentRequest;
import id.dana.feeds.data.detail.source.network.request.FetchCommentRequest;
import id.dana.feeds.data.detail.source.network.request.ReportFeedCommentRequest;
import id.dana.feeds.data.detail.source.network.response.AddActivityCommentResponse;
import id.dana.feeds.data.detail.source.network.response.FetchActivityCommentsResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/data/detail/source/network/FeedsDetailFacade;", "", "Lid/dana/feeds/data/detail/source/network/request/AddActivityCommentRequest;", "request", "Lid/dana/feeds/data/detail/source/network/response/AddActivityCommentResponse;", "addComment", "(Lid/dana/feeds/data/detail/source/network/request/AddActivityCommentRequest;)Lid/dana/feeds/data/detail/source/network/response/AddActivityCommentResponse;", "Lid/dana/feeds/data/detail/source/network/request/DeleteCommentRequest;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "deleteComment", "(Lid/dana/feeds/data/detail/source/network/request/DeleteCommentRequest;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/feeds/data/detail/source/network/request/FetchCommentRequest;", "Lid/dana/feeds/data/detail/source/network/response/FetchActivityCommentsResponse;", "fetchComments", "(Lid/dana/feeds/data/detail/source/network/request/FetchCommentRequest;)Lid/dana/feeds/data/detail/source/network/response/FetchActivityCommentsResponse;", "Lid/dana/feeds/data/detail/source/network/request/ReportFeedCommentRequest;", "reportComment", "(Lid/dana/feeds/data/detail/source/network/request/ReportFeedCommentRequest;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FeedsDetailFacade {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.BuiltInFictitiousFunctionClassFactory;

    @OperationType("id.dana.feedengine.socialmedia.addActivityComment")
    @SignCheck
    AddActivityCommentResponse addComment(AddActivityCommentRequest request);

    @OperationType("id.dana.feedengine.socialmedia.deleteActivityComment")
    @SignCheck
    BaseRpcResult deleteComment(DeleteCommentRequest request);

    @OperationType("id.dana.feedengine.socialmedia.fetchActivityComments")
    @SignCheck
    FetchActivityCommentsResponse fetchComments(FetchCommentRequest request);

    @OperationType("id.dana.feedengine.socialmedia.reportActivityComment")
    @SignCheck
    BaseRpcResult reportComment(ReportFeedCommentRequest request);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/feeds/data/detail/source/network/FeedsDetailFacade$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion BuiltInFictitiousFunctionClassFactory = new Companion();

        private Companion() {
        }
    }
}
