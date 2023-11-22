package id.dana.cashier.data.mapper;

import id.dana.cashier.domain.model.paylater.DanaCredit;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.data.paylater.repository.source.network.result.DanaCreditResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/paylater/repository/source/network/result/DanaCreditResult;", "Lid/dana/cashier/domain/model/paylater/DanaCredit;", "toDanaCredit", "(Lid/dana/data/paylater/repository/source/network/result/DanaCreditResult;)Lid/dana/cashier/domain/model/paylater/DanaCredit;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaCreditResultMapperKt {
    public static final DanaCredit toDanaCredit(DanaCreditResult danaCreditResult) {
        Intrinsics.checkNotNullParameter(danaCreditResult, "");
        return new DanaCredit(MoneyViewEntityMapperKt.toMoneyView(danaCreditResult.getAvailableQuota()), MoneyViewEntityMapperKt.toMoneyView(danaCreditResult.getInitCreditQuota()), danaCreditResult.getInstallmentPlanId(), MoneyViewEntityMapperKt.toMoneyView(danaCreditResult.getTotalAmount()));
    }
}
