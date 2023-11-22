package id.dana.cashier.data.repository.source.network;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.cashier.data.repository.source.CashierBannerManagementEntityData;
import id.dana.cashier.data.repository.source.network.request.CashierBannerEntityRequest;
import id.dana.cashier.data.repository.source.network.result.CashierBannerEntityResponse;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/cashier/data/repository/source/network/NetworkCashierBannerManagementEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/cashier/data/repository/source/network/CashierBannerFacade;", "Lid/dana/cashier/data/repository/source/CashierBannerManagementEntityData;", "Lid/dana/cashier/data/repository/source/network/request/CashierBannerEntityRequest;", "request", "Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/result/CashierBannerEntityResponse;", "getCashierSuccessBanner", "(Lid/dana/cashier/data/repository/source/network/request/CashierBannerEntityRequest;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NetworkCashierBannerManagementEntityData extends SecureBaseNetwork<CashierBannerFacade> implements CashierBannerManagementEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<CashierBannerFacade> getFacadeClass() {
        return CashierBannerFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkCashierBannerManagementEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    @Override // id.dana.cashier.data.repository.source.CashierBannerManagementEntityData
    public final Observable<CashierBannerEntityResponse> getCashierSuccessBanner(final CashierBannerEntityRequest request) {
        Intrinsics.checkNotNullParameter(request, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierBannerManagementEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                CashierBannerEntityResponse m539getCashierSuccessBanner$lambda1;
                m539getCashierSuccessBanner$lambda1 = NetworkCashierBannerManagementEntityData.m539getCashierSuccessBanner$lambda1(CashierBannerEntityRequest.this, this, (CashierBannerFacade) obj);
                return m539getCashierSuccessBanner$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCashierSuccessBanner$lambda-1  reason: not valid java name */
    public static final CashierBannerEntityResponse m539getCashierSuccessBanner$lambda1(CashierBannerEntityRequest cashierBannerEntityRequest, NetworkCashierBannerManagementEntityData networkCashierBannerManagementEntityData, CashierBannerFacade cashierBannerFacade) {
        Intrinsics.checkNotNullParameter(cashierBannerEntityRequest, "");
        Intrinsics.checkNotNullParameter(networkCashierBannerManagementEntityData, "");
        cashierBannerEntityRequest.envInfo = networkCashierBannerManagementEntityData.generateMobileEnvInfo();
        return cashierBannerFacade.getCashierSuccessBanner(cashierBannerEntityRequest);
    }
}
