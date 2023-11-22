package id.dana.cashier.data.repository.source.network.request;

import id.dana.cashier.domain.model.paylater.QueryInstallmentRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/domain/model/paylater/QueryInstallmentRequest;", "Lid/dana/cashier/data/repository/source/network/request/QueryInstallmentEntityRequest;", "toQueryInstallmentEntityRequest", "(Lid/dana/cashier/domain/model/paylater/QueryInstallmentRequest;)Lid/dana/cashier/data/repository/source/network/request/QueryInstallmentEntityRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QueryInstallmentEntityRequestKt {
    public static final QueryInstallmentEntityRequest toQueryInstallmentEntityRequest(QueryInstallmentRequest queryInstallmentRequest) {
        Intrinsics.checkNotNullParameter(queryInstallmentRequest, "");
        return new QueryInstallmentEntityRequest(queryInstallmentRequest.getMethod(), queryInstallmentRequest.getExternalInfo(), queryInstallmentRequest.getCashierOrderId(), queryInstallmentRequest.getChannelIndex(), queryInstallmentRequest.getReloadRequest(), queryInstallmentRequest.getTransType(), queryInstallmentRequest.getCouponIds(), queryInstallmentRequest.getSelectedAddons(), queryInstallmentRequest.getPayMethod(), queryInstallmentRequest.getMixPaymentRequest(), queryInstallmentRequest.getMixPayMethod() != null ? new MixPayMethodRequest(queryInstallmentRequest.getMixPayMethod().getPayMethod(), queryInstallmentRequest.getMixPayMethod().getChannelIndex(), null, null, null, null, queryInstallmentRequest.getMixPayMethod().getDeviceId(), null, null, null, queryInstallmentRequest.getMixPayMethod().getInstCode(), null) : null);
    }
}
