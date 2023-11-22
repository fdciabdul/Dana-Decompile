package id.dana.feeds.data.reaction.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.feeds.data.reaction.source.FeedsReactionData;
import id.dana.feeds.data.reaction.source.network.request.ActivityReactionsRequest;
import id.dana.feeds.data.reaction.source.network.request.AddActivityReactionRequest;
import id.dana.feeds.data.reaction.source.network.request.DeleteActivityReactionRequest;
import id.dana.feeds.data.reaction.source.network.response.ActivityReactionsResult;
import id.dana.feeds.data.reaction.source.network.response.AddActivityReactionResult;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B+\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0013\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0014\u0012\u0006\u0010\u0007\u001a\u00020\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/feeds/data/reaction/source/network/NetworkReactionEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/feeds/data/reaction/source/network/ReactionFacade;", "Lid/dana/feeds/data/reaction/source/FeedsReactionData;", "", "p0", "p1", "p2", "Lio/reactivex/Observable;", "Lid/dana/feeds/data/reaction/source/network/response/AddActivityReactionResult;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/feeds/data/reaction/source/network/response/ActivityReactionsResult;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "Landroid/content/Context;", "p3", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NetworkReactionEntityData extends SecureBaseNetwork<ReactionFacade> implements FeedsReactionData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<ReactionFacade> getFacadeClass() {
        return ReactionFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkReactionEntityData(RpcConnector rpcConnector, @Named("friendshipthreadexecutor") ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.feeds.data.reaction.source.FeedsReactionData
    public final Observable<AddActivityReactionResult> BuiltInFictitiousFunctionClassFactory(final String p0, final String p1, final String p2) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.reaction.source.network.NetworkReactionEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkReactionEntityData.PlaceComponentResult(p0, p1, p2, this, (ReactionFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.feeds.data.reaction.source.FeedsReactionData
    public final Observable<BaseRpcResult> PlaceComponentResult(final String p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.reaction.source.network.NetworkReactionEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkReactionEntityData.MyBillsEntityDataFactory(p0, p1, this, (ReactionFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.feeds.data.reaction.source.FeedsReactionData
    public final Observable<ActivityReactionsResult> PlaceComponentResult(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        final ActivityReactionsRequest activityReactionsRequest = new ActivityReactionsRequest(p0, p1, p2);
        activityReactionsRequest.envInfo = generateMobileEnvInfo();
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.reaction.source.network.NetworkReactionEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkReactionEntityData.BuiltInFictitiousFunctionClassFactory(ActivityReactionsRequest.this, (ReactionFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public static /* synthetic */ AddActivityReactionResult PlaceComponentResult(String str, String str2, String str3, NetworkReactionEntityData networkReactionEntityData, ReactionFacade reactionFacade) {
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(networkReactionEntityData, "");
        if (str == null) {
            str = "";
        }
        AddActivityReactionRequest addActivityReactionRequest = new AddActivityReactionRequest(str, str2, str3);
        addActivityReactionRequest.envInfo = networkReactionEntityData.generateMobileEnvInfo();
        return reactionFacade.addActivityReaction(addActivityReactionRequest);
    }

    public static /* synthetic */ BaseRpcResult MyBillsEntityDataFactory(String str, String str2, NetworkReactionEntityData networkReactionEntityData, ReactionFacade reactionFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(networkReactionEntityData, "");
        DeleteActivityReactionRequest deleteActivityReactionRequest = new DeleteActivityReactionRequest(str, str2);
        deleteActivityReactionRequest.envInfo = networkReactionEntityData.generateMobileEnvInfo();
        return reactionFacade.deleteActivityReaction(deleteActivityReactionRequest);
    }

    public static /* synthetic */ ActivityReactionsResult BuiltInFictitiousFunctionClassFactory(ActivityReactionsRequest activityReactionsRequest, ReactionFacade reactionFacade) {
        Intrinsics.checkNotNullParameter(activityReactionsRequest, "");
        return reactionFacade.getActivityReactions(activityReactionsRequest);
    }
}
