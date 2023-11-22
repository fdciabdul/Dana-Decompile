package id.dana.cashier.data.repository.source.network.result;

import id.dana.cashier.data.mapper.DanaCreditResultMapperKt;
import id.dana.cashier.data.mapper.RepaymentPlanResultMapperKt;
import id.dana.cashier.domain.model.paylater.DanaCredit;
import id.dana.cashier.domain.model.paylater.QueryInstallment;
import id.dana.data.paylater.repository.source.network.result.DanaCreditResult;
import id.dana.data.paylater.repository.source.network.result.RepaymentPlanResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/QueryInstallmentResult;", "Lid/dana/cashier/domain/model/paylater/QueryInstallment;", "toQueryInstallment", "(Lid/dana/cashier/data/repository/source/network/result/QueryInstallmentResult;)Lid/dana/cashier/domain/model/paylater/QueryInstallment;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QueryInstallmentResultKt {
    public static final QueryInstallment toQueryInstallment(QueryInstallmentResult queryInstallmentResult) {
        Intrinsics.checkNotNullParameter(queryInstallmentResult, "");
        DanaCreditResult danaCredit = queryInstallmentResult.getDanaCredit();
        DanaCredit danaCredit2 = danaCredit != null ? DanaCreditResultMapperKt.toDanaCredit(danaCredit) : null;
        String loanAgreementUrl = queryInstallmentResult.getLoanAgreementUrl();
        List<RepaymentPlanResult> repaymentPlans = queryInstallmentResult.getRepaymentPlans();
        return new QueryInstallment(danaCredit2, loanAgreementUrl, repaymentPlans != null ? RepaymentPlanResultMapperKt.toRepaymentPlans(repaymentPlans) : null, null, null, null, queryInstallmentResult.getEnableStatus(), queryInstallmentResult.getDisableReason(), Boolean.valueOf(queryInstallmentResult.success), 56, null);
    }
}
