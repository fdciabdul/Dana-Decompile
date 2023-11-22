package id.dana.danapoly.data.play.repository.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import id.dana.danapoly.data.play.model.request.GetLeaderboardRequest;
import id.dana.danapoly.data.play.model.request.PaginationRequest;
import id.dana.danapoly.data.play.model.request.RollDiceRequest;
import id.dana.danapoly.data.play.model.response.GetLeaderboardResponse;
import id.dana.danapoly.data.play.model.response.RollDiceResponse;
import id.dana.danapoly.data.play.repository.source.DanapolyPlayData;
import id.dana.danapoly.di.DanapolyScope;
import id.dana.network.base.SecureBaseNetworkFlow;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.foundation.facede.ApSecurity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@DanapolyScope
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B!\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0012\u0012\u0006\u0010\n\u001a\u00020\u0013\u0012\u0006\u0010\u000b\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\f2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u000f"}, d2 = {"Lid/dana/danapoly/data/play/repository/source/network/NetworkDanapolyPlayEntityData;", "Lid/dana/network/base/SecureBaseNetworkFlow;", "Lid/dana/danapoly/data/play/repository/source/network/DanapolyPlayFacade;", "Lid/dana/danapoly/data/play/repository/source/DanapolyPlayData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "p0", "", "p1", "p2", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/danapoly/data/play/model/response/GetLeaderboardResponse;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/danapoly/data/play/model/response/RollDiceResponse;", "PlaceComponentResult", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/foundation/facede/ApSecurity;", "Landroid/content/Context;", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/foundation/facede/ApSecurity;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NetworkDanapolyPlayEntityData extends SecureBaseNetworkFlow<DanapolyPlayFacade> implements DanapolyPlayData {
    @Override // id.dana.network.base.BaseNetworkFlow
    public final Class<DanapolyPlayFacade> getFacadeClass() {
        return DanapolyPlayFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkDanapolyPlayEntityData(RpcConnector rpcConnector, ApSecurity apSecurity, Context context) {
        super(apSecurity, context, rpcConnector);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(apSecurity, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.danapoly.data.play.repository.source.DanapolyPlayData
    public final Flow<RollDiceResponse> PlaceComponentResult(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<DanapolyPlayFacade, RollDiceResponse>() { // from class: id.dana.danapoly.data.play.repository.source.network.NetworkDanapolyPlayEntityData$rollDice$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final RollDiceResponse invoke(DanapolyPlayFacade danapolyPlayFacade) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(danapolyPlayFacade, "");
                RollDiceRequest rollDiceRequest = new RollDiceRequest(p0);
                generateMobileEnvInfo = this.generateMobileEnvInfo();
                rollDiceRequest.envInfo = generateMobileEnvInfo;
                return danapolyPlayFacade.rollDice(rollDiceRequest);
            }
        });
    }

    @Override // id.dana.danapoly.data.play.repository.source.DanapolyPlayData
    public final Flow<GetLeaderboardResponse> BuiltInFictitiousFunctionClassFactory(final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        final int i = 0;
        final int i2 = 10;
        return wrapper(new Function1<DanapolyPlayFacade, GetLeaderboardResponse>() { // from class: id.dana.danapoly.data.play.repository.source.network.NetworkDanapolyPlayEntityData$getLeaderboard$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final GetLeaderboardResponse invoke(DanapolyPlayFacade danapolyPlayFacade) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(danapolyPlayFacade, "");
                GetLeaderboardRequest getLeaderboardRequest = new GetLeaderboardRequest(str, new PaginationRequest(i, i2));
                generateMobileEnvInfo = this.generateMobileEnvInfo();
                getLeaderboardRequest.envInfo = generateMobileEnvInfo;
                return danapolyPlayFacade.getLeaderboard(getLeaderboardRequest);
            }
        });
    }
}
