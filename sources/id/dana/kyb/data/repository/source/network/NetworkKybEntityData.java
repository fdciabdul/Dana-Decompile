package id.dana.kyb.data.repository.source.network;

import android.content.Context;
import android.os.Build;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.kyb.data.KybEntityData;
import id.dana.kyb.data.error.KybMerchantInfoException;
import id.dana.kyb.data.model.ScannerInfoEntity;
import id.dana.kyb.data.repository.source.network.request.PaymentOrderCpmRequest;
import id.dana.kyb.data.repository.source.network.request.QueryLatestOrderRequest;
import id.dana.kyb.data.repository.source.network.request.TransactionListQueryRequest;
import id.dana.kyb.data.repository.source.network.result.KybMerchantInfoResult;
import id.dana.kyb.data.repository.source.network.result.KybRequestPaymentResult;
import id.dana.kyb.data.repository.source.network.result.PaymentOrderCpmResult;
import id.dana.kyb.data.repository.source.network.result.QueryLatestOrderResult;
import id.dana.kyb.data.repository.source.network.result.TransactionListQueryResult;
import id.dana.kyb.domain.model.KybMerchantInfo;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.exception.NetworkException;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.config.DeviceInformation;
import id.dana.utils.config.model.IP;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001#B1\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u001b\u0012\u0006\u0010\u0007\u001a\u00020\u001c\u0012\u0006\u0010\b\u001a\u00020\u001d\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010 \u001a\u00020\u0019¢\u0006\u0004\b!\u0010\"J-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0014J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0012J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0011\u001a\u00020\u0019X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u001a"}, d2 = {"Lid/dana/kyb/data/repository/source/network/NetworkKybEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/kyb/data/repository/source/network/KybFacade;", "Lid/dana/kyb/data/KybEntityData;", "Lid/dana/kyb/domain/model/KybMerchantInfo;", "p0", "", "p1", "p2", "Lio/reactivex/Observable;", "Lid/dana/kyb/data/repository/source/network/result/PaymentOrderCpmResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/kyb/domain/model/KybMerchantInfo;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/kyb/data/repository/source/network/result/KybMerchantInfoResult;", "MyBillsEntityDataFactory", "()Lio/reactivex/Observable;", "Lid/dana/kyb/data/repository/source/network/result/TransactionListQueryResult;", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/kyb/data/repository/source/network/result/KybRequestPaymentResult;", "getAuthRequestContext", "Lid/dana/kyb/data/repository/source/network/result/QueryLatestOrderResult;", "PlaceComponentResult", "Lid/dana/utils/config/DeviceInformation;", "Lid/dana/utils/config/DeviceInformation;", "Landroid/content/Context;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p3", "p4", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Lid/dana/utils/config/DeviceInformation;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkKybEntityData extends SecureBaseNetwork<KybFacade> implements KybEntityData {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final DeviceInformation MyBillsEntityDataFactory;

    @Override // id.dana.network.base.BaseNetwork
    public final Class<KybFacade> getFacadeClass() {
        return KybFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkKybEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, DeviceInformation deviceInformation) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(deviceInformation, "");
        this.MyBillsEntityDataFactory = deviceInformation;
    }

    @Override // id.dana.kyb.data.KybEntityData
    public final Observable<KybMerchantInfoResult> MyBillsEntityDataFactory() {
        final BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = generateMobileEnvInfo();
        Observable<KybMerchantInfoResult> onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.kyb.data.repository.source.network.NetworkKybEntityData$$ExternalSyntheticLambda4
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkKybEntityData.MyBillsEntityDataFactory(BaseRpcRequest.this, (KybFacade) obj);
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.kyb.data.repository.source.network.NetworkKybEntityData$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkKybEntityData.KClassImpl$Data$declaredNonStaticMembers$2((Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.kyb.data.KybEntityData
    public final Observable<QueryLatestOrderResult> PlaceComponentResult() {
        ?? r1 = 0;
        final QueryLatestOrderRequest queryLatestOrderRequest = new QueryLatestOrderRequest(r1, 1, r1);
        queryLatestOrderRequest.envInfo = generateMobileEnvInfo();
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.kyb.data.repository.source.network.NetworkKybEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkKybEntityData.BuiltInFictitiousFunctionClassFactory(QueryLatestOrderRequest.this, (KybFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.kyb.data.KybEntityData
    public final Observable<TransactionListQueryResult> MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final TransactionListQueryRequest transactionListQueryRequest = new TransactionListQueryRequest(0, p0, 1, null);
        transactionListQueryRequest.envInfo = generateMobileEnvInfo();
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.kyb.data.repository.source.network.NetworkKybEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkKybEntityData.KClassImpl$Data$declaredNonStaticMembers$2(TransactionListQueryRequest.this, (KybFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.kyb.data.KybEntityData
    public final Observable<KybRequestPaymentResult> getAuthRequestContext() {
        final BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = generateMobileEnvInfo();
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.kyb.data.repository.source.network.NetworkKybEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkKybEntityData.getAuthRequestContext(BaseRpcRequest.this, (KybFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.kyb.data.KybEntityData
    public final Observable<PaymentOrderCpmResult> KClassImpl$Data$declaredNonStaticMembers$2(KybMerchantInfo p0, String p1, String p2) {
        String str;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        final PaymentOrderCpmRequest paymentOrderCpmRequest = new PaymentOrderCpmRequest(null, null, null, null, null, 31, null);
        paymentOrderCpmRequest.envInfo = generateMobileEnvInfo();
        paymentOrderCpmRequest.setMerchantId(p0.getMerchantId());
        paymentOrderCpmRequest.setAmount(p1);
        paymentOrderCpmRequest.setAuthCode(p2);
        String merchantName = p0.getMerchantName();
        StringBuilder sb = new StringBuilder();
        sb.append("Pay to ");
        sb.append(merchantName);
        paymentOrderCpmRequest.setNote(sb.toString());
        String deviceUtdId = this.MyBillsEntityDataFactory.getDeviceUtdId();
        IP ip = this.MyBillsEntityDataFactory.getIP();
        if (ip == null || (str = ip.BuiltInFictitiousFunctionClassFactory) == null) {
            str = "0.0.0.0";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Build.MANUFACTURER);
        sb2.append(InputCardNumberView.DIVIDER);
        sb2.append(Build.MODEL);
        paymentOrderCpmRequest.setScannerInfo(new ScannerInfoEntity(deviceUtdId, str, sb2.toString(), Build.VERSION.RELEASE));
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.kyb.data.repository.source.network.NetworkKybEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkKybEntityData.getAuthRequestContext(PaymentOrderCpmRequest.this, (KybFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public static /* synthetic */ PaymentOrderCpmResult getAuthRequestContext(PaymentOrderCpmRequest paymentOrderCpmRequest, KybFacade kybFacade) {
        Intrinsics.checkNotNullParameter(paymentOrderCpmRequest, "");
        return kybFacade.createPaymentOrderCpm(paymentOrderCpmRequest);
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        if (th instanceof NetworkException) {
            KybMerchantInfoException.Companion companion = KybMerchantInfoException.INSTANCE;
            return Observable.error(KybMerchantInfoException.Companion.KClassImpl$Data$declaredNonStaticMembers$2((NetworkException) th));
        }
        return Observable.error(th);
    }

    public static /* synthetic */ QueryLatestOrderResult BuiltInFictitiousFunctionClassFactory(QueryLatestOrderRequest queryLatestOrderRequest, KybFacade kybFacade) {
        Intrinsics.checkNotNullParameter(queryLatestOrderRequest, "");
        return kybFacade.getQueryLatestOrder(queryLatestOrderRequest);
    }

    public static /* synthetic */ KybMerchantInfoResult MyBillsEntityDataFactory(BaseRpcRequest baseRpcRequest, KybFacade kybFacade) {
        Intrinsics.checkNotNullParameter(baseRpcRequest, "");
        return kybFacade.getKybMerchantInfo(baseRpcRequest);
    }

    public static /* synthetic */ KybRequestPaymentResult getAuthRequestContext(BaseRpcRequest baseRpcRequest, KybFacade kybFacade) {
        Intrinsics.checkNotNullParameter(baseRpcRequest, "");
        return kybFacade.getPaymentRequest(baseRpcRequest);
    }

    public static /* synthetic */ TransactionListQueryResult KClassImpl$Data$declaredNonStaticMembers$2(TransactionListQueryRequest transactionListQueryRequest, KybFacade kybFacade) {
        Intrinsics.checkNotNullParameter(transactionListQueryRequest, "");
        return kybFacade.getKybTransactionHistory(transactionListQueryRequest);
    }
}
