package id.dana.kyb.data.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.kyb.data.repository.source.network.request.PaymentOrderCpmRequest;
import id.dana.kyb.data.repository.source.network.request.QueryLatestOrderRequest;
import id.dana.kyb.data.repository.source.network.request.TransactionListQueryRequest;
import id.dana.kyb.data.repository.source.network.result.KybMerchantInfoResult;
import id.dana.kyb.data.repository.source.network.result.KybRequestPaymentResult;
import id.dana.kyb.data.repository.source.network.result.PaymentOrderCpmResult;
import id.dana.kyb.data.repository.source.network.result.QueryLatestOrderResult;
import id.dana.kyb.data.repository.source.network.result.TransactionListQueryResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0017\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/kyb/data/repository/source/network/KybFacade;", "", "Lid/dana/kyb/data/repository/source/network/request/PaymentOrderCpmRequest;", "paymentOrderCpmRequest", "Lid/dana/kyb/data/repository/source/network/result/PaymentOrderCpmResult;", "createPaymentOrderCpm", "(Lid/dana/kyb/data/repository/source/network/request/PaymentOrderCpmRequest;)Lid/dana/kyb/data/repository/source/network/result/PaymentOrderCpmResult;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "baseRpcRequest", "Lid/dana/kyb/data/repository/source/network/result/KybMerchantInfoResult;", "getKybMerchantInfo", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/kyb/data/repository/source/network/result/KybMerchantInfoResult;", "Lid/dana/kyb/data/repository/source/network/request/TransactionListQueryRequest;", "transactionListQueryRequest", "Lid/dana/kyb/data/repository/source/network/result/TransactionListQueryResult;", "getKybTransactionHistory", "(Lid/dana/kyb/data/repository/source/network/request/TransactionListQueryRequest;)Lid/dana/kyb/data/repository/source/network/result/TransactionListQueryResult;", "Lid/dana/kyb/data/repository/source/network/result/KybRequestPaymentResult;", "getPaymentRequest", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/kyb/data/repository/source/network/result/KybRequestPaymentResult;", "Lid/dana/kyb/data/repository/source/network/request/QueryLatestOrderRequest;", "queryLatestOrderRequest", "Lid/dana/kyb/data/repository/source/network/result/QueryLatestOrderResult;", "getQueryLatestOrder", "(Lid/dana/kyb/data/repository/source/network/request/QueryLatestOrderRequest;)Lid/dana/kyb/data/repository/source/network/result/QueryLatestOrderResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface KybFacade {
    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.CREATE_PAYMENT_ORDER_CPM)
    @SignCheck
    PaymentOrderCpmResult createPaymentOrderCpm(PaymentOrderCpmRequest paymentOrderCpmRequest);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.GET_MERCHANT_INFO)
    @SignCheck
    KybMerchantInfoResult getKybMerchantInfo(BaseRpcRequest baseRpcRequest);

    @OperationType("alipayplus.mobilewallet.merchant.transaction.list")
    @SignCheck
    TransactionListQueryResult getKybTransactionHistory(TransactionListQueryRequest transactionListQueryRequest);

    @OperationType("alipayplus.mobilewallet.merchant.paymentrequest.init")
    @SignCheck
    KybRequestPaymentResult getPaymentRequest(BaseRpcRequest baseRpcRequest);

    @OperationType("dana.kybprod.user.kyb.queryLatestOrder")
    @SignCheck
    QueryLatestOrderResult getQueryLatestOrder(QueryLatestOrderRequest queryLatestOrderRequest);
}
