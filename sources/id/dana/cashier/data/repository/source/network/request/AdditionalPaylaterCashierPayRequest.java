package id.dana.cashier.data.repository.source.network.request;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.domain.useragreement.model.AgreementInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b"}, d2 = {"Lid/dana/cashier/data/repository/source/network/request/AdditionalPaylaterCashierPayRequest;", "", "Lid/dana/domain/useragreement/model/AgreementInfo;", CashierKeyParams.AGREEMENT_INFO, "Lid/dana/domain/useragreement/model/AgreementInfo;", "getAgreementInfo", "()Lid/dana/domain/useragreement/model/AgreementInfo;", "", CashierKeyParams.INSTALLMENT_PLAN_ID, "Ljava/lang/String;", "getInstallmentPlanId", "()Ljava/lang/String;", CashierKeyParams.LOAN_AGREEMENT_URL, "getLoanAgreementUrl", "<init>", "(Lid/dana/domain/useragreement/model/AgreementInfo;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AdditionalPaylaterCashierPayRequest {
    private final AgreementInfo agreementInfo;
    private final String installmentPlanId;
    private final String loanAgreementUrl;

    public AdditionalPaylaterCashierPayRequest() {
        this(null, null, null, 7, null);
    }

    public AdditionalPaylaterCashierPayRequest(AgreementInfo agreementInfo, String str, String str2) {
        this.agreementInfo = agreementInfo;
        this.installmentPlanId = str;
        this.loanAgreementUrl = str2;
    }

    public /* synthetic */ AdditionalPaylaterCashierPayRequest(AgreementInfo agreementInfo, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : agreementInfo, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    @JvmName(name = "getAgreementInfo")
    public final AgreementInfo getAgreementInfo() {
        return this.agreementInfo;
    }

    @JvmName(name = "getInstallmentPlanId")
    public final String getInstallmentPlanId() {
        return this.installmentPlanId;
    }

    @JvmName(name = "getLoanAgreementUrl")
    public final String getLoanAgreementUrl() {
        return this.loanAgreementUrl;
    }
}
