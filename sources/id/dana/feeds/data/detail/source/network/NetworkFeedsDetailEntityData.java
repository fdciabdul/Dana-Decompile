package id.dana.feeds.data.detail.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.feeds.data.detail.source.FeedsDetailData;
import id.dana.feeds.data.detail.source.network.request.AddActivityCommentRequest;
import id.dana.feeds.data.detail.source.network.request.DeleteCommentRequest;
import id.dana.feeds.data.detail.source.network.request.FetchCommentRequest;
import id.dana.feeds.data.detail.source.network.request.ReportFeedCommentRequest;
import id.dana.feeds.data.detail.source.network.response.AddActivityCommentResponse;
import id.dana.feeds.data.detail.source.network.response.FetchActivityCommentsResponse;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B+\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0019\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u001a\u0012\u0006\u0010\u0007\u001a\u00020\u001b\u0012\u0006\u0010\b\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ7\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/feeds/data/detail/source/network/NetworkFeedsDetailEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/feeds/data/detail/source/network/FeedsDetailFacade;", "Lid/dana/feeds/data/detail/source/FeedsDetailData;", "", "p0", "p1", "p2", "p3", "Lio/reactivex/Observable;", "Lid/dana/feeds/data/detail/source/network/response/AddActivityCommentResponse;", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "Lid/dana/feeds/data/detail/source/network/response/FetchActivityCommentsResponse;", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Observable;", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "Landroid/content/Context;", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NetworkFeedsDetailEntityData extends SecureBaseNetwork<FeedsDetailFacade> implements FeedsDetailData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<FeedsDetailFacade> getFacadeClass() {
        return FeedsDetailFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkFeedsDetailEntityData(RpcConnector rpcConnector, @Named("friendshipthreadexecutor") ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.feeds.data.detail.source.FeedsDetailData
    public final Observable<AddActivityCommentResponse> MyBillsEntityDataFactory(final String p0, final String p1, final String p2, final String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.detail.source.network.NetworkFeedsDetailEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkFeedsDetailEntityData.MyBillsEntityDataFactory(p0, p1, p2, p3, this, (FeedsDetailFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.feeds.data.detail.source.FeedsDetailData
    public final Observable<FetchActivityCommentsResponse> getAuthRequestContext(final String p0, final String p1, final String p2, final Integer p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.detail.source.network.NetworkFeedsDetailEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkFeedsDetailEntityData.KClassImpl$Data$declaredNonStaticMembers$2(p1, p2, p0, p3, this, (FeedsDetailFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.feeds.data.detail.source.FeedsDetailData
    public final Observable<BaseRpcResult> PlaceComponentResult(final String p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.detail.source.network.NetworkFeedsDetailEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkFeedsDetailEntityData.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, this, (FeedsDetailFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.feeds.data.detail.source.FeedsDetailData
    public final Observable<BaseRpcResult> KClassImpl$Data$declaredNonStaticMembers$2(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.detail.source.network.NetworkFeedsDetailEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkFeedsDetailEntityData.getAuthRequestContext(p0, this, (FeedsDetailFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public static /* synthetic */ BaseRpcResult getAuthRequestContext(String str, NetworkFeedsDetailEntityData networkFeedsDetailEntityData, FeedsDetailFacade feedsDetailFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(networkFeedsDetailEntityData, "");
        DeleteCommentRequest deleteCommentRequest = new DeleteCommentRequest(str);
        deleteCommentRequest.envInfo = networkFeedsDetailEntityData.generateMobileEnvInfo();
        return feedsDetailFacade.deleteComment(deleteCommentRequest);
    }

    public static /* synthetic */ AddActivityCommentResponse MyBillsEntityDataFactory(String str, String str2, String str3, String str4, NetworkFeedsDetailEntityData networkFeedsDetailEntityData, FeedsDetailFacade feedsDetailFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(networkFeedsDetailEntityData, "");
        AddActivityCommentRequest addActivityCommentRequest = new AddActivityCommentRequest(str, str2, str3, str4);
        addActivityCommentRequest.envInfo = networkFeedsDetailEntityData.generateMobileEnvInfo();
        return feedsDetailFacade.addComment(addActivityCommentRequest);
    }

    public static /* synthetic */ FetchActivityCommentsResponse KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3, Integer num, NetworkFeedsDetailEntityData networkFeedsDetailEntityData, FeedsDetailFacade feedsDetailFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(networkFeedsDetailEntityData, "");
        if (!(str.length() > 0)) {
            str = null;
        }
        if (!(str2.length() > 0)) {
            str2 = null;
        }
        FetchCommentRequest fetchCommentRequest = new FetchCommentRequest(str3, str2, str, num);
        fetchCommentRequest.envInfo = networkFeedsDetailEntityData.generateMobileEnvInfo();
        return feedsDetailFacade.fetchComments(fetchCommentRequest);
    }

    public static /* synthetic */ BaseRpcResult KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, NetworkFeedsDetailEntityData networkFeedsDetailEntityData, FeedsDetailFacade feedsDetailFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(networkFeedsDetailEntityData, "");
        ReportFeedCommentRequest reportFeedCommentRequest = new ReportFeedCommentRequest(str, str2);
        reportFeedCommentRequest.envInfo = networkFeedsDetailEntityData.generateMobileEnvInfo();
        return feedsDetailFacade.reportComment(reportFeedCommentRequest);
    }
}
