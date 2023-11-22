package id.dana.data.kycrenewal.repository.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.kycrenewal.repository.source.KycRenewalEntityData;
import id.dana.data.kycrenewal.repository.source.network.result.QueryKYCRenewalStatusResult;
import id.dana.data.kycrenewal.repository.source.network.result.QueryKYCUserDataResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0016¢\u0006\u0004\b\f\u0010\n"}, d2 = {"Lid/dana/data/kycrenewal/repository/source/network/NetworkKycRenewalEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/kycrenewal/repository/source/network/UserKYCFacade;", "Lid/dana/data/kycrenewal/repository/source/KycRenewalEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lio/reactivex/Observable;", "Lid/dana/data/kycrenewal/repository/source/network/result/QueryKYCRenewalStatusResult;", "getAuthRequestContext", "()Lio/reactivex/Observable;", "Lid/dana/data/kycrenewal/repository/source/network/result/QueryKYCUserDataResult;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/network/rpc/RpcConnector;", "p0", "Lid/dana/utils/concurrent/ThreadExecutor;", "p1", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p2", "Landroid/content/Context;", "p3", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkKycRenewalEntityData extends SecureBaseNetwork<UserKYCFacade> implements KycRenewalEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<UserKYCFacade> getFacadeClass() {
        return UserKYCFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkKycRenewalEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.kycrenewal.repository.source.KycRenewalEntityData
    public final Observable<QueryKYCRenewalStatusResult> getAuthRequestContext() {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.kycrenewal.repository.source.network.NetworkKycRenewalEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkKycRenewalEntityData.BuiltInFictitiousFunctionClassFactory(NetworkKycRenewalEntityData.this, (UserKYCFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.data.kycrenewal.repository.source.KycRenewalEntityData
    public final Observable<QueryKYCUserDataResult> BuiltInFictitiousFunctionClassFactory() {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.kycrenewal.repository.source.network.NetworkKycRenewalEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkKycRenewalEntityData.PlaceComponentResult(NetworkKycRenewalEntityData.this, (UserKYCFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public static /* synthetic */ QueryKYCUserDataResult PlaceComponentResult(NetworkKycRenewalEntityData networkKycRenewalEntityData, UserKYCFacade userKYCFacade) {
        Intrinsics.checkNotNullParameter(networkKycRenewalEntityData, "");
        BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = networkKycRenewalEntityData.generateMobileEnvInfo();
        return userKYCFacade.queryKYCUserData(baseRpcRequest);
    }

    public static /* synthetic */ QueryKYCRenewalStatusResult BuiltInFictitiousFunctionClassFactory(NetworkKycRenewalEntityData networkKycRenewalEntityData, UserKYCFacade userKYCFacade) {
        Intrinsics.checkNotNullParameter(networkKycRenewalEntityData, "");
        BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = networkKycRenewalEntityData.generateMobileEnvInfo();
        return userKYCFacade.queryKYCRenewalStatus(baseRpcRequest);
    }
}
