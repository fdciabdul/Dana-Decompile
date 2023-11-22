package id.dana.feeds.data.timeline.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.feeds.data.timeline.source.FeedsTimelineData;
import id.dana.feeds.data.timeline.source.FeedsTimelineFacade;
import id.dana.feeds.data.timeline.source.network.request.FetchFeedRequest;
import id.dana.feeds.data.timeline.source.network.request.GetMyFeedsRequest;
import id.dana.feeds.data.timeline.source.network.response.FeedResult;
import id.dana.feeds.data.timeline.source.network.response.MyFeedResult;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001&B+\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020 \u0012\b\b\u0001\u0010\r\u001a\u00020!\u0012\u0006\u0010\u000e\u001a\u00020\"\u0012\u0006\u0010\u000f\u001a\u00020#¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJY\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0016¢\u0006\u0004\b\u0007\u0010\u0016J-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00142\u0006\u0010\u0005\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019JA\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00142\u0006\u0010\u0005\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u0018\u0010\u001bJ1\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00170\u00142\u0006\u0010\u0005\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0019JY\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0016¢\u0006\u0004\b\u0007\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/feeds/data/timeline/source/network/NetworkFeedsTimelineData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/feeds/data/timeline/source/FeedsTimelineFacade;", "Lid/dana/feeds/data/timeline/source/FeedsTimelineData;", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "p1", "p2", "p3", "p4", "p5", "", "p6", "Lio/reactivex/Observable;", "Lid/dana/feeds/data/timeline/source/network/response/FeedResult;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)Lio/reactivex/Observable;", "Lid/dana/feeds/data/timeline/source/network/response/MyFeedResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(ILjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", "(ILjava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Observable;", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "(Ljava/lang/String;ILjava/util/List;)Lio/reactivex/Observable;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/domain/timeline/model/SocialFeed;)V", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "Landroid/content/Context;", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkFeedsTimelineData extends SecureBaseNetwork<FeedsTimelineFacade> implements FeedsTimelineData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<FeedsTimelineFacade> getFacadeClass() {
        return FeedsTimelineFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkFeedsTimelineData(RpcConnector rpcConnector, @Named("friendshipthreadexecutor") ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.feeds.data.timeline.source.FeedsTimelineData
    public final Observable<MyFeedResult> getAuthRequestContext(int p0, String p1, String p2) {
        return KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, p2, false);
    }

    private final Observable<MyFeedResult> KClassImpl$Data$declaredNonStaticMembers$2(int i, String str, String str2, boolean z) {
        final GetMyFeedsRequest getMyFeedsRequest = new GetMyFeedsRequest(i, str, str2, 2, z);
        getMyFeedsRequest.envInfo = generateMobileEnvInfo();
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.timeline.source.network.NetworkFeedsTimelineData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkFeedsTimelineData.KClassImpl$Data$declaredNonStaticMembers$2(GetMyFeedsRequest.this, (FeedsTimelineFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.feeds.data.timeline.source.FeedsTimelineData
    public final Observable<MyFeedResult> KClassImpl$Data$declaredNonStaticMembers$2(int p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        if (Intrinsics.areEqual(p1, "")) {
            p1 = null;
        }
        if (Intrinsics.areEqual(p2, "")) {
            p2 = null;
        }
        return KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, p2, true);
    }

    @Override // id.dana.feeds.data.timeline.source.FeedsTimelineData
    public final Observable<FeedResult> getAuthRequestContext(final String p0, final int p1, final String p2, final String p3, final String p4, final int p5, final List<String> p6) {
        Intrinsics.checkNotNullParameter(p4, "");
        Intrinsics.checkNotNullParameter(p6, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.timeline.source.network.NetworkFeedsTimelineData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkFeedsTimelineData.getAuthRequestContext(p0, p1, p3, p2, p4, p5, p6, this, (FeedsTimelineFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.feeds.data.timeline.source.FeedsTimelineData
    public final Observable<SocialFeed> getAuthRequestContext(String str, int i, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        ?? r2 = 0;
        throw new NotImplementedError(r2, 1, r2);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.feeds.data.timeline.source.FeedsTimelineData
    public final void BuiltInFictitiousFunctionClassFactory(SocialFeed p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.feeds.data.timeline.source.FeedsTimelineData
    public final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    public static /* synthetic */ FeedResult getAuthRequestContext(String str, int i, String str2, String str3, String str4, int i2, List list, NetworkFeedsTimelineData networkFeedsTimelineData, FeedsTimelineFacade feedsTimelineFacade) {
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(networkFeedsTimelineData, "");
        FetchFeedRequest fetchFeedRequest = new FetchFeedRequest(str, i, str2, str3, str4, i2, list);
        fetchFeedRequest.envInfo = networkFeedsTimelineData.generateMobileEnvInfo();
        return feedsTimelineFacade.fetchFeed(fetchFeedRequest);
    }

    public static /* synthetic */ MyFeedResult KClassImpl$Data$declaredNonStaticMembers$2(GetMyFeedsRequest getMyFeedsRequest, FeedsTimelineFacade feedsTimelineFacade) {
        Intrinsics.checkNotNullParameter(getMyFeedsRequest, "");
        return feedsTimelineFacade.getMyFeeds(getMyFeedsRequest);
    }
}
