package id.dana.data.ott.repository.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.ott.OttVerifyEntity;
import id.dana.data.ott.OttVerifyRequest;
import id.dana.data.ott.repository.source.OttEntityData;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B'\u0012\u0006\u0010\b\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/ott/repository/source/network/NetworkOttEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/ott/repository/source/network/OttManageRpcFacade;", "Lid/dana/data/ott/repository/source/OttEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "p0", "Lio/reactivex/Observable;", "Lid/dana/data/ott/OttVerifyEntity;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Landroid/content/Context;", "Lid/dana/network/rpc/RpcConnector;", "p1", "Lid/dana/utils/concurrent/ThreadExecutor;", "p2", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p3", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NetworkOttEntityData extends SecureBaseNetwork<OttManageRpcFacade> implements OttEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<OttManageRpcFacade> getFacadeClass() {
        return OttManageRpcFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkOttEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    @Override // id.dana.data.ott.repository.source.OttEntityData
    public final Observable<OttVerifyEntity> KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final OttVerifyRequest ottVerifyRequest = new OttVerifyRequest(p0);
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.ott.repository.source.network.NetworkOttEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkOttEntityData.MyBillsEntityDataFactory(OttVerifyRequest.this, (OttManageRpcFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public static /* synthetic */ OttVerifyEntity MyBillsEntityDataFactory(OttVerifyRequest ottVerifyRequest, OttManageRpcFacade ottManageRpcFacade) {
        Intrinsics.checkNotNullParameter(ottVerifyRequest, "");
        return ottManageRpcFacade.ottVerify(ottVerifyRequest);
    }
}
