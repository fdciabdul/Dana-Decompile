package id.dana.data.investment.repository.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.investment.repository.source.InvestmentEntityData;
import id.dana.data.investment.repository.source.network.request.AccountInvestmentRequest;
import id.dana.data.investment.repository.source.network.response.AccountInvestmentResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u000e\u0012\u0006\u0010\t\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/data/investment/repository/source/network/NetworkInvestmentEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/investment/repository/source/network/InvestmentFacade;", "Lid/dana/data/investment/repository/source/InvestmentEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "p0", "p1", "Lio/reactivex/Observable;", "Lid/dana/data/investment/repository/source/network/response/AccountInvestmentResult;", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p2", "Landroid/content/Context;", "p3", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkInvestmentEntityData extends SecureBaseNetwork<InvestmentFacade> implements InvestmentEntityData {
    @Override // id.dana.data.investment.repository.source.InvestmentEntityData
    public final /* synthetic */ Observable KClassImpl$Data$declaredNonStaticMembers$2() {
        return InvestmentEntityData.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.network.base.BaseNetwork
    public final Class<InvestmentFacade> getFacadeClass() {
        return InvestmentFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkInvestmentEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.investment.repository.source.InvestmentEntityData
    public final Observable<AccountInvestmentResult> MyBillsEntityDataFactory(final String p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.investment.repository.source.network.NetworkInvestmentEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkInvestmentEntityData.getAuthRequestContext(NetworkInvestmentEntityData.this, p0, p1, (InvestmentFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public static /* synthetic */ AccountInvestmentResult getAuthRequestContext(NetworkInvestmentEntityData networkInvestmentEntityData, String str, String str2, InvestmentFacade investmentFacade) {
        Intrinsics.checkNotNullParameter(networkInvestmentEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        AccountInvestmentRequest accountInvestmentRequest = new AccountInvestmentRequest(str, str2);
        accountInvestmentRequest.envInfo = networkInvestmentEntityData.generateMobileEnvInfo();
        return investmentFacade.queryAccountInvestment(accountInvestmentRequest);
    }
}
