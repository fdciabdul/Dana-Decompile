package id.dana.danapoly.data.rewards.repository.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import id.dana.danapoly.data.rewards.model.request.GetRewardsRequest;
import id.dana.danapoly.data.rewards.model.response.GetRewardsResponse;
import id.dana.danapoly.data.rewards.repository.source.DanapolyRewardsData;
import id.dana.danapoly.di.DanapolyScope;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.base.SecureBaseNetworkFlow;
import id.dana.network.rpc.RpcConnector;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@DanapolyScope
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B!\b\u0007\u0012\u0006\u0010\b\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/danapoly/data/rewards/repository/source/network/NetworkDanapolyRewardsData;", "Lid/dana/network/base/SecureBaseNetworkFlow;", "Lid/dana/danapoly/data/rewards/repository/source/network/DanapolyCardsFacade;", "Lid/dana/danapoly/data/rewards/repository/source/DanapolyRewardsData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/danapoly/data/rewards/model/request/GetRewardsRequest;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/danapoly/data/rewards/model/response/GetRewardsResponse;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/danapoly/data/rewards/model/request/GetRewardsRequest;)Lkotlinx/coroutines/flow/Flow;", "Landroid/content/Context;", "Lid/dana/network/rpc/RpcConnector;", "p1", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p2", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NetworkDanapolyRewardsData extends SecureBaseNetworkFlow<DanapolyCardsFacade> implements DanapolyRewardsData {
    @Override // id.dana.network.base.BaseNetworkFlow
    public final Class<DanapolyCardsFacade> getFacadeClass() {
        return DanapolyCardsFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkDanapolyRewardsData(Context context, RpcConnector rpcConnector, ApSecurityFacade apSecurityFacade) {
        super(apSecurityFacade, context, rpcConnector);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    @Override // id.dana.danapoly.data.rewards.repository.source.DanapolyRewardsData
    public final Flow<GetRewardsResponse> BuiltInFictitiousFunctionClassFactory(final GetRewardsRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<DanapolyCardsFacade, GetRewardsResponse>() { // from class: id.dana.danapoly.data.rewards.repository.source.network.NetworkDanapolyRewardsData$getRewards$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final GetRewardsResponse invoke(DanapolyCardsFacade danapolyCardsFacade) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(danapolyCardsFacade, "");
                GetRewardsRequest getRewardsRequest = GetRewardsRequest.this;
                generateMobileEnvInfo = this.generateMobileEnvInfo();
                getRewardsRequest.envInfo = generateMobileEnvInfo;
                return danapolyCardsFacade.getRewards(getRewardsRequest);
            }
        });
    }
}
