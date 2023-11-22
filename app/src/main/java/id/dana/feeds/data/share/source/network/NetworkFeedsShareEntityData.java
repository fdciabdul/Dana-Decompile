package id.dana.feeds.data.share.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.feeds.data.share.source.FeedsShareData;
import id.dana.feeds.data.share.source.network.request.CreateActivityRequest;
import id.dana.feeds.data.share.source.network.request.FetchShareableActivitiesRequest;
import id.dana.feeds.data.share.source.network.request.PreviewActivityRequest;
import id.dana.feeds.data.share.source.network.response.FetchShareableActivitiesResponse;
import id.dana.feeds.data.share.source.network.response.PreviewActivityResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B+\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u001d\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u001e\u0012\u0006\u0010\u0013\u001a\u00020\u001f\u0012\u0006\u0010\u0016\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\u0005\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010JS\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00062\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/feeds/data/share/source/network/NetworkFeedsShareEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/feeds/data/share/source/network/FeedsShareFacade;", "Lid/dana/feeds/data/share/source/FeedsShareData;", "Lid/dana/feeds/data/share/source/network/request/CreateActivityRequest;", "p0", "Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "PlaceComponentResult", "(Lid/dana/feeds/data/share/source/network/request/CreateActivityRequest;)Lio/reactivex/Observable;", "Lid/dana/feeds/data/share/source/network/request/FetchShareableActivitiesRequest;", "Lid/dana/feeds/data/share/source/network/response/FetchShareableActivitiesResponse;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/data/share/source/network/request/FetchShareableActivitiesRequest;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "p1", "p2", "", "", "p3", "", "p4", "p5", "Lid/dana/feeds/data/share/source/network/response/PreviewActivityResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "Landroid/content/Context;", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NetworkFeedsShareEntityData extends SecureBaseNetwork<FeedsShareFacade> implements FeedsShareData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<FeedsShareFacade> getFacadeClass() {
        return FeedsShareFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkFeedsShareEntityData(RpcConnector rpcConnector, @Named("friendshipthreadexecutor") ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.feeds.data.share.source.FeedsShareData
    public final Observable<BaseRpcResult> PlaceComponentResult(final CreateActivityRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.share.source.network.NetworkFeedsShareEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkFeedsShareEntityData.PlaceComponentResult(CreateActivityRequest.this, this, (FeedsShareFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.feeds.data.share.source.FeedsShareData
    public final Observable<PreviewActivityResult> KClassImpl$Data$declaredNonStaticMembers$2(final String p0, final String p1, final String p2, final Map<String, ? extends Object> p3, final int p4, final String p5) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.share.source.network.NetworkFeedsShareEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkFeedsShareEntityData.getAuthRequestContext(p0, p1, p2, p3, p4, p5, this, (FeedsShareFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.feeds.data.share.source.FeedsShareData
    public final Observable<FetchShareableActivitiesResponse> BuiltInFictitiousFunctionClassFactory(final FetchShareableActivitiesRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.share.source.network.NetworkFeedsShareEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkFeedsShareEntityData.BuiltInFictitiousFunctionClassFactory(FetchShareableActivitiesRequest.this, this, (FeedsShareFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public static /* synthetic */ BaseRpcResult PlaceComponentResult(CreateActivityRequest createActivityRequest, NetworkFeedsShareEntityData networkFeedsShareEntityData, FeedsShareFacade feedsShareFacade) {
        Intrinsics.checkNotNullParameter(createActivityRequest, "");
        Intrinsics.checkNotNullParameter(networkFeedsShareEntityData, "");
        createActivityRequest.envInfo = networkFeedsShareEntityData.generateMobileEnvInfo();
        return feedsShareFacade.createFeedActivity(createActivityRequest);
    }

    public static /* synthetic */ PreviewActivityResult getAuthRequestContext(String str, String str2, String str3, Map map, int i, String str4, NetworkFeedsShareEntityData networkFeedsShareEntityData, FeedsShareFacade feedsShareFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(networkFeedsShareEntityData, "");
        PreviewActivityRequest previewActivityRequest = new PreviewActivityRequest(str, str2, str3, map, i, str4);
        previewActivityRequest.envInfo = networkFeedsShareEntityData.generateMobileEnvInfo();
        return feedsShareFacade.previewActivity(previewActivityRequest);
    }

    public static /* synthetic */ FetchShareableActivitiesResponse BuiltInFictitiousFunctionClassFactory(FetchShareableActivitiesRequest fetchShareableActivitiesRequest, NetworkFeedsShareEntityData networkFeedsShareEntityData, FeedsShareFacade feedsShareFacade) {
        Intrinsics.checkNotNullParameter(fetchShareableActivitiesRequest, "");
        Intrinsics.checkNotNullParameter(networkFeedsShareEntityData, "");
        fetchShareableActivitiesRequest.envInfo = networkFeedsShareEntityData.generateMobileEnvInfo();
        return feedsShareFacade.fetchShareableActivities(fetchShareableActivitiesRequest);
    }
}
