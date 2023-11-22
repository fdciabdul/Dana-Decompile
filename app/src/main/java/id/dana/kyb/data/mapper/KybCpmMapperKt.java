package id.dana.kyb.data.mapper;

import id.dana.kyb.data.repository.source.network.result.PaymentOrderCpmResult;
import id.dana.kyb.domain.model.PaymentOrderCpm;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/kyb/data/repository/source/network/result/PaymentOrderCpmResult;", "Lid/dana/kyb/domain/model/PaymentOrderCpm;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/kyb/data/repository/source/network/result/PaymentOrderCpmResult;)Lid/dana/kyb/domain/model/PaymentOrderCpm;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybCpmMapperKt {
    public static final PaymentOrderCpm BuiltInFictitiousFunctionClassFactory(PaymentOrderCpmResult paymentOrderCpmResult) {
        Intrinsics.checkNotNullParameter(paymentOrderCpmResult, "");
        String merchantTransId = paymentOrderCpmResult.getMerchantTransId();
        if (merchantTransId == null) {
            merchantTransId = "";
        }
        String acquirementId = paymentOrderCpmResult.getAcquirementId();
        if (acquirementId == null) {
            acquirementId = "";
        }
        String orderAmount = paymentOrderCpmResult.getOrderAmount();
        if (orderAmount == null) {
            orderAmount = "";
        }
        String closeReason = paymentOrderCpmResult.getCloseReason();
        return new PaymentOrderCpm(merchantTransId, acquirementId, orderAmount, closeReason != null ? closeReason : "");
    }
}
