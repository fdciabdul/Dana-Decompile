package id.dana.data.pocket.repository.source.network;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.pocket.model.LoyaltyTokenEntity;
import id.dana.data.pocket.model.LoyaltyTokenRequest;
import id.dana.data.pocket.repository.PocketEntityData;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B'\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/data/pocket/repository/source/network/NetworkPocketEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/pocket/repository/source/network/PocketFacade;", "Lid/dana/data/pocket/repository/PocketEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lio/reactivex/Observable;", "Lid/dana/data/pocket/model/LoyaltyTokenEntity;", "getLoyaltyToken", "()Lio/reactivex/Observable;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "executor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NetworkPocketEntityData extends SecureBaseNetwork<PocketFacade> implements PocketEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<PocketFacade> getFacadeClass() {
        return PocketFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkPocketEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.pocket.repository.PocketEntityData
    public final Observable<LoyaltyTokenEntity> getLoyaltyToken() {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.pocket.repository.source.network.NetworkPocketEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                LoyaltyTokenEntity m1586getLoyaltyToken$lambda1;
                m1586getLoyaltyToken$lambda1 = NetworkPocketEntityData.m1586getLoyaltyToken$lambda1(NetworkPocketEntityData.this, (PocketFacade) obj);
                return m1586getLoyaltyToken$lambda1;
            }
        }, LoyaltyTokenEntity.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* renamed from: getLoyaltyToken$lambda-1 */
    public static final LoyaltyTokenEntity m1586getLoyaltyToken$lambda1(NetworkPocketEntityData networkPocketEntityData, PocketFacade pocketFacade) {
        Intrinsics.checkNotNullParameter(networkPocketEntityData, "");
        LoyaltyTokenRequest loyaltyTokenRequest = new LoyaltyTokenRequest();
        loyaltyTokenRequest.envInfo = networkPocketEntityData.generateMobileEnvInfo();
        return pocketFacade.getLoyaltyToken(loyaltyTokenRequest);
    }
}
