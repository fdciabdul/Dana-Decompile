package id.dana.danapoly.data.dailycheck.repository.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.danapoly.data.dailycheck.model.request.CheckInRequest;
import id.dana.danapoly.data.dailycheck.model.response.CheckInInfoResponse;
import id.dana.danapoly.data.dailycheck.repository.source.DanapolyCheckInData;
import id.dana.network.base.SecureBaseNetworkFlow;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.foundation.facede.ApSecurity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0016¢\u0006\u0004\b\f\u0010\u0007"}, d2 = {"Lid/dana/danapoly/data/dailycheck/repository/source/network/NetworkDanapolyCheckInEntityData;", "Lid/dana/network/base/SecureBaseNetworkFlow;", "Lid/dana/danapoly/data/dailycheck/repository/source/network/DanapolyCheckInFacade;", "Lid/dana/danapoly/data/dailycheck/repository/source/DanapolyCheckInData;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lkotlinx/coroutines/flow/Flow;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/danapoly/data/dailycheck/model/response/CheckInInfoResponse;", "PlaceComponentResult", "Lid/dana/network/rpc/RpcConnector;", "p0", "Lid/dana/utils/foundation/facede/ApSecurity;", "p1", "Landroid/content/Context;", "p2", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/foundation/facede/ApSecurity;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NetworkDanapolyCheckInEntityData extends SecureBaseNetworkFlow<DanapolyCheckInFacade> implements DanapolyCheckInData {
    @Override // id.dana.network.base.BaseNetworkFlow
    public final Class<DanapolyCheckInFacade> getFacadeClass() {
        return DanapolyCheckInFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkDanapolyCheckInEntityData(RpcConnector rpcConnector, ApSecurity apSecurity, Context context) {
        super(apSecurity, context, rpcConnector);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(apSecurity, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.danapoly.data.dailycheck.repository.source.DanapolyCheckInData
    public final Flow<CheckInInfoResponse> PlaceComponentResult() {
        return wrapper(new Function1<DanapolyCheckInFacade, CheckInInfoResponse>() { // from class: id.dana.danapoly.data.dailycheck.repository.source.network.NetworkDanapolyCheckInEntityData$getUserCheckInInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CheckInInfoResponse invoke(DanapolyCheckInFacade danapolyCheckInFacade) {
                Intrinsics.checkNotNullParameter(danapolyCheckInFacade, "");
                return danapolyCheckInFacade.getUserCheckInInfo(NetworkDanapolyCheckInEntityData.BuiltInFictitiousFunctionClassFactory(NetworkDanapolyCheckInEntityData.this));
            }
        });
    }

    @Override // id.dana.danapoly.data.dailycheck.repository.source.DanapolyCheckInData
    public final Flow<BaseRpcResult> KClassImpl$Data$declaredNonStaticMembers$2() {
        return wrapper(new Function1<DanapolyCheckInFacade, BaseRpcResult>() { // from class: id.dana.danapoly.data.dailycheck.repository.source.network.NetworkDanapolyCheckInEntityData$doCheckIn$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BaseRpcResult invoke(DanapolyCheckInFacade danapolyCheckInFacade) {
                Intrinsics.checkNotNullParameter(danapolyCheckInFacade, "");
                return danapolyCheckInFacade.doCheckIn(NetworkDanapolyCheckInEntityData.BuiltInFictitiousFunctionClassFactory(NetworkDanapolyCheckInEntityData.this));
            }
        });
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public static final /* synthetic */ CheckInRequest BuiltInFictitiousFunctionClassFactory(NetworkDanapolyCheckInEntityData networkDanapolyCheckInEntityData) {
        ?? r1 = 0;
        CheckInRequest checkInRequest = new CheckInRequest(r1, 1, r1);
        checkInRequest.envInfo = networkDanapolyCheckInEntityData.generateMobileEnvInfo();
        return checkInRequest;
    }
}
