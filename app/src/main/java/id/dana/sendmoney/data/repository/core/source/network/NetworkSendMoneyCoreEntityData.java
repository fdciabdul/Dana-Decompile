package id.dana.sendmoney.data.repository.core.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.network.base.SecureBaseNetworkFlow;
import id.dana.network.rpc.RpcConnector;
import id.dana.sendmoney.data.api.core.model.request.TransferInitRequestEntity;
import id.dana.sendmoney.data.api.core.model.response.TransferInitResultEntity;
import id.dana.sendmoney.data.repository.core.source.SendMoneyCoreEntityData;
import id.dana.utils.foundation.facede.ApSecurity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B!\b\u0007\u0012\u0006\u0010\b\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/sendmoney/data/repository/core/source/network/NetworkSendMoneyCoreEntityData;", "Lid/dana/network/base/SecureBaseNetworkFlow;", "Lid/dana/sendmoney/data/repository/core/source/network/SendMoneyCoreFacade;", "Lid/dana/sendmoney/data/repository/core/source/SendMoneyCoreEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/sendmoney/data/api/core/model/request/TransferInitRequestEntity;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/data/api/core/model/response/TransferInitResultEntity;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/data/api/core/model/request/TransferInitRequestEntity;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/foundation/facede/ApSecurity;", "p1", "Landroid/content/Context;", "p2", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/foundation/facede/ApSecurity;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkSendMoneyCoreEntityData extends SecureBaseNetworkFlow<SendMoneyCoreFacade> implements SendMoneyCoreEntityData {
    @Override // id.dana.network.base.BaseNetworkFlow
    public final Class<SendMoneyCoreFacade> getFacadeClass() {
        return SendMoneyCoreFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkSendMoneyCoreEntityData(RpcConnector rpcConnector, ApSecurity apSecurity, Context context) {
        super(apSecurity, context, rpcConnector);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(apSecurity, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.sendmoney.data.repository.core.source.SendMoneyCoreEntityData
    public final Flow<TransferInitResultEntity> BuiltInFictitiousFunctionClassFactory(final TransferInitRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<SendMoneyCoreFacade, TransferInitResultEntity>() { // from class: id.dana.sendmoney.data.repository.core.source.network.NetworkSendMoneyCoreEntityData$getTransferBalanceInit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TransferInitResultEntity invoke(SendMoneyCoreFacade sendMoneyCoreFacade) {
                Intrinsics.checkNotNullParameter(sendMoneyCoreFacade, "");
                return sendMoneyCoreFacade.getTransferBalanceInit((TransferInitRequestEntity) NetworkSendMoneyCoreEntityData.PlaceComponentResult(NetworkSendMoneyCoreEntityData.this, p0));
            }
        });
    }

    public static final /* synthetic */ BaseRpcRequest PlaceComponentResult(NetworkSendMoneyCoreEntityData networkSendMoneyCoreEntityData, BaseRpcRequest baseRpcRequest) {
        baseRpcRequest.envInfo = networkSendMoneyCoreEntityData.generateMobileEnvInfo();
        return baseRpcRequest;
    }
}
