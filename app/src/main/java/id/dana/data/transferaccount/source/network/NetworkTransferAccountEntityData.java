package id.dana.data.transferaccount.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.transferaccount.TransferAccountEntityData;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0012\u0012\u0006\u0010\u000e\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/data/transferaccount/source/network/NetworkTransferAccountEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/transferaccount/source/network/TransferAccountFacade;", "Lid/dana/data/transferaccount/TransferAccountEntityData;", "", "p0", "Lio/reactivex/Observable;", "Lid/dana/data/transferaccount/source/network/DeletionChangeNumberResult;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/data/transferaccount/source/network/TransferAccountQueryType;", "p1", "Lid/dana/data/transferaccount/source/network/TransferAccountStatusResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Lid/dana/data/transferaccount/source/network/TransferAccountQueryType;)Lio/reactivex/Observable;", "Landroid/content/Context;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "p2", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p3", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkTransferAccountEntityData extends SecureBaseNetwork<TransferAccountFacade> implements TransferAccountEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<TransferAccountFacade> getFacadeClass() {
        return TransferAccountFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkTransferAccountEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    @Override // id.dana.data.transferaccount.TransferAccountEntityData
    public final Observable<TransferAccountStatusResult> KClassImpl$Data$declaredNonStaticMembers$2(final String p0, final TransferAccountQueryType p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.transferaccount.source.network.NetworkTransferAccountEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkTransferAccountEntityData.MyBillsEntityDataFactory(p0, p1, this, (TransferAccountFacade) obj);
            }
        }, TransferAccountStatusResult.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.data.transferaccount.TransferAccountEntityData
    public final Observable<DeletionChangeNumberResult> BuiltInFictitiousFunctionClassFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.transferaccount.source.network.NetworkTransferAccountEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkTransferAccountEntityData.KClassImpl$Data$declaredNonStaticMembers$2(p0, this, (TransferAccountFacade) obj);
            }
        }, DeletionChangeNumberResult.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public static /* synthetic */ DeletionChangeNumberResult KClassImpl$Data$declaredNonStaticMembers$2(String str, NetworkTransferAccountEntityData networkTransferAccountEntityData, TransferAccountFacade transferAccountFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(networkTransferAccountEntityData, "");
        DeletionChangeNumberRequest deletionChangeNumberRequest = new DeletionChangeNumberRequest(str);
        deletionChangeNumberRequest.envInfo = networkTransferAccountEntityData.generateMobileEnvInfo();
        return transferAccountFacade.deletionChangeNumber(deletionChangeNumberRequest);
    }

    public static /* synthetic */ TransferAccountStatusResult MyBillsEntityDataFactory(String str, TransferAccountQueryType transferAccountQueryType, NetworkTransferAccountEntityData networkTransferAccountEntityData, TransferAccountFacade transferAccountFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(transferAccountQueryType, "");
        Intrinsics.checkNotNullParameter(networkTransferAccountEntityData, "");
        TransferAccountStatusRequest transferAccountStatusRequest = new TransferAccountStatusRequest(str, transferAccountQueryType.getType());
        transferAccountStatusRequest.envInfo = networkTransferAccountEntityData.generateMobileEnvInfo();
        return transferAccountFacade.queryTransferAccountStatus(transferAccountStatusRequest);
    }
}
