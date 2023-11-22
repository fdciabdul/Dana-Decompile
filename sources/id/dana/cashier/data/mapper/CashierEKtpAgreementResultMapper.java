package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.result.CashierAgreementResult;
import id.dana.cashier.domain.model.CashierAgreementResponse;
import id.dana.data.base.BaseMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/data/mapper/CashierEKtpAgreementResultMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/cashier/data/repository/source/network/result/CashierAgreementResult;", "Lid/dana/cashier/domain/model/CashierAgreementResponse;", "oldItem", "map", "(Lid/dana/cashier/data/repository/source/network/result/CashierAgreementResult;)Lid/dana/cashier/domain/model/CashierAgreementResponse;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierEKtpAgreementResultMapper extends BaseMapper<CashierAgreementResult, CashierAgreementResponse> {
    @Inject
    public CashierEKtpAgreementResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public final CashierAgreementResponse map(CashierAgreementResult oldItem) {
        Intrinsics.checkNotNullParameter(oldItem, "");
        return new CashierAgreementResponse(oldItem.getBindingId(), oldItem.getCardIndexNo(), oldItem.getIdentifyFailedCount(), oldItem.getLockedExpireSeconds(), oldItem.getMaxFailed(), oldItem.getPayMethod(), oldItem.getPayOption(), Boolean.valueOf(oldItem.success));
    }
}
