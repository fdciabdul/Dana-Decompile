package id.dana.data.creditscore.repository.source.network;

import android.content.Context;
import id.dana.data.creditscore.repository.CreditScoreEntityData;
import id.dana.data.creditscore.repository.source.network.request.InsertDeviceScoringDataRequest;
import id.dana.data.creditscore.repository.source.network.response.InsertDeviceScoringDataResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\b\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/creditscore/repository/source/network/NetworkCreditScoreEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/creditscore/repository/source/network/CreditScoreFacade;", "Lid/dana/data/creditscore/repository/CreditScoreEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/data/creditscore/repository/source/network/request/InsertDeviceScoringDataRequest;", "p0", "Lio/reactivex/Observable;", "Lid/dana/data/creditscore/repository/source/network/response/InsertDeviceScoringDataResult;", "getAuthRequestContext", "(Lid/dana/data/creditscore/repository/source/network/request/InsertDeviceScoringDataRequest;)Lio/reactivex/Observable;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "p1", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p2", "Landroid/content/Context;", "p3", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkCreditScoreEntityData extends SecureBaseNetwork<CreditScoreFacade> implements CreditScoreEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<CreditScoreFacade> getFacadeClass() {
        return CreditScoreFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkCreditScoreEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.creditscore.repository.CreditScoreEntityData
    public final Observable<InsertDeviceScoringDataResult> getAuthRequestContext(final InsertDeviceScoringDataRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.creditscore.repository.source.network.NetworkCreditScoreEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkCreditScoreEntityData.BuiltInFictitiousFunctionClassFactory(InsertDeviceScoringDataRequest.this, (CreditScoreFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public static /* synthetic */ InsertDeviceScoringDataResult BuiltInFictitiousFunctionClassFactory(InsertDeviceScoringDataRequest insertDeviceScoringDataRequest, CreditScoreFacade creditScoreFacade) {
        Intrinsics.checkNotNullParameter(insertDeviceScoringDataRequest, "");
        return creditScoreFacade.insertDeviceScoringData(insertDeviceScoringDataRequest);
    }
}
