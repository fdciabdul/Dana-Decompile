package id.dana.data.recurring.subscription.source.network;

import android.content.Context;
import id.dana.data.recurring.subscription.source.RecurringSubscriptionEntityData;
import id.dana.data.recurring.subscription.source.network.request.ConsultViewRequest;
import id.dana.data.recurring.subscription.source.network.response.ConsultViewResponse;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.foundation.facede.ApSecurity;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/data/recurring/subscription/source/network/NetworkRecurringSubscription;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/recurring/subscription/source/network/RecurringSubscriptionRpcFacade;", "Lid/dana/data/recurring/subscription/source/RecurringSubscriptionEntityData;", "Lio/reactivex/Observable;", "", "BuiltInFictitiousFunctionClassFactory", "()Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/network/rpc/RpcConnector;", "p0", "Lid/dana/utils/concurrent/ThreadExecutor;", "p1", "Lid/dana/utils/foundation/facede/ApSecurity;", "p2", "Landroid/content/Context;", "p3", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/utils/foundation/facede/ApSecurity;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkRecurringSubscription extends SecureBaseNetwork<RecurringSubscriptionRpcFacade> implements RecurringSubscriptionEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<RecurringSubscriptionRpcFacade> getFacadeClass() {
        return RecurringSubscriptionRpcFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkRecurringSubscription(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurity apSecurity, Context context) {
        super(rpcConnector, threadExecutor, apSecurity, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurity, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.recurring.subscription.source.RecurringSubscriptionEntityData
    public final Observable<Integer> BuiltInFictitiousFunctionClassFactory() {
        Observable<Integer> map = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.recurring.subscription.source.network.NetworkRecurringSubscription$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkRecurringSubscription.PlaceComponentResult(NetworkRecurringSubscription.this, (RecurringSubscriptionRpcFacade) obj);
            }
        }).map(new Function() { // from class: id.dana.data.recurring.subscription.source.network.NetworkRecurringSubscription$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkRecurringSubscription.getAuthRequestContext((ConsultViewResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public static /* synthetic */ ConsultViewResponse PlaceComponentResult(NetworkRecurringSubscription networkRecurringSubscription, RecurringSubscriptionRpcFacade recurringSubscriptionRpcFacade) {
        Intrinsics.checkNotNullParameter(networkRecurringSubscription, "");
        ConsultViewRequest consultViewRequest = new ConsultViewRequest(null, null, null, null, null, Boolean.TRUE, false, 31, null);
        consultViewRequest.envInfo = networkRecurringSubscription.generateMobileEnvInfo();
        return recurringSubscriptionRpcFacade.consult(consultViewRequest);
    }

    public static /* synthetic */ Integer getAuthRequestContext(ConsultViewResponse consultViewResponse) {
        Intrinsics.checkNotNullParameter(consultViewResponse, "");
        return Integer.valueOf(consultViewResponse.getTotalCount());
    }
}
