package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.request.CashierAgreementEntityRequest;
import id.dana.cashier.domain.model.CashierAgreementRequest;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/data/mapper/CashierEKtpAgreementRequestMapper;", "", "Lid/dana/cashier/domain/model/CashierAgreementRequest;", "oldItem", "Lid/dana/cashier/data/repository/source/network/request/CashierAgreementEntityRequest;", "map", "(Lid/dana/cashier/domain/model/CashierAgreementRequest;)Lid/dana/cashier/data/repository/source/network/request/CashierAgreementEntityRequest;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierEKtpAgreementRequestMapper {
    @Inject
    public CashierEKtpAgreementRequestMapper() {
    }

    public final CashierAgreementEntityRequest map(CashierAgreementRequest oldItem) {
        Intrinsics.checkNotNullParameter(oldItem, "");
        return new CashierAgreementEntityRequest(oldItem.getSecurityId(), oldItem.getValidateData(), oldItem.getSendStrategy(), oldItem.getPhoneNumber(), oldItem.getCashierOrderId(), oldItem.getVerifyExtendData(), oldItem.getVerifyScene());
    }
}
