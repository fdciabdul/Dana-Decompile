package id.dana.cashier.domain.model.paylater;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010 \u001a\u0004\u0018\u00010\f¢\u0006\u0004\bB\u0010CJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000eJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0007J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u000eJ\u0082\u0001\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010$\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b)\u0010\u0007R$\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010*\u001a\u0004\b+\u0010\u0011\"\u0004\b,\u0010-R$\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010.\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u00101R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00102\u001a\u0004\b3\u0010\u0004R$\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u00104\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u00107R$\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u00108\u001a\u0004\b9\u0010\u000e\"\u0004\b:\u0010;R$\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u00108\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b<\u0010;R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00104\u001a\u0004\b=\u0010\u0007R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010>\u001a\u0004\b?\u0010\u000bR$\u0010 \u001a\u0004\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u00108\u001a\u0004\b@\u0010\u000e\"\u0004\bA\u0010;"}, d2 = {"Lid/dana/cashier/domain/model/paylater/QueryInstallment;", "", "Lid/dana/cashier/domain/model/paylater/DanaCredit;", "component1", "()Lid/dana/cashier/domain/model/paylater/DanaCredit;", "", "component2", "()Ljava/lang/String;", "", "Lid/dana/cashier/domain/model/paylater/RepaymentPlan;", "component3", "()Ljava/util/List;", "", "component4", "()Ljava/lang/Boolean;", "Lid/dana/domain/useragreement/model/ConsultAgreementResponse;", "component5", "()Lid/dana/domain/useragreement/model/ConsultAgreementResponse;", "", "component6", "()Ljava/lang/Throwable;", "component7", "component8", "component9", "danaCredit", CashierKeyParams.LOAN_AGREEMENT_URL, "repaymentPlans", "isPaylaterAgreementEnable", "consultAgreement", "consultAgreementError", "enableStatus", "disableReason", "success", "copy", "(Lid/dana/cashier/domain/model/paylater/DanaCredit;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Lid/dana/domain/useragreement/model/ConsultAgreementResponse;Ljava/lang/Throwable;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)Lid/dana/cashier/domain/model/paylater/QueryInstallment;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/domain/useragreement/model/ConsultAgreementResponse;", "getConsultAgreement", "setConsultAgreement", "(Lid/dana/domain/useragreement/model/ConsultAgreementResponse;)V", "Ljava/lang/Throwable;", "getConsultAgreementError", "setConsultAgreementError", "(Ljava/lang/Throwable;)V", "Lid/dana/cashier/domain/model/paylater/DanaCredit;", "getDanaCredit", "Ljava/lang/String;", "getDisableReason", "setDisableReason", "(Ljava/lang/String;)V", "Ljava/lang/Boolean;", "getEnableStatus", "setEnableStatus", "(Ljava/lang/Boolean;)V", "setPaylaterAgreementEnable", "getLoanAgreementUrl", "Ljava/util/List;", "getRepaymentPlans", "getSuccess", "setSuccess", "<init>", "(Lid/dana/cashier/domain/model/paylater/DanaCredit;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Lid/dana/domain/useragreement/model/ConsultAgreementResponse;Ljava/lang/Throwable;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QueryInstallment {
    private ConsultAgreementResponse consultAgreement;
    private Throwable consultAgreementError;
    private final DanaCredit danaCredit;
    private String disableReason;
    private Boolean enableStatus;
    private Boolean isPaylaterAgreementEnable;
    private final String loanAgreementUrl;
    private final List<RepaymentPlan> repaymentPlans;
    private Boolean success;

    /* renamed from: component1  reason: from getter */
    public final DanaCredit getDanaCredit() {
        return this.danaCredit;
    }

    /* renamed from: component2  reason: from getter */
    public final String getLoanAgreementUrl() {
        return this.loanAgreementUrl;
    }

    public final List<RepaymentPlan> component3() {
        return this.repaymentPlans;
    }

    /* renamed from: component4  reason: from getter */
    public final Boolean getIsPaylaterAgreementEnable() {
        return this.isPaylaterAgreementEnable;
    }

    /* renamed from: component5  reason: from getter */
    public final ConsultAgreementResponse getConsultAgreement() {
        return this.consultAgreement;
    }

    /* renamed from: component6  reason: from getter */
    public final Throwable getConsultAgreementError() {
        return this.consultAgreementError;
    }

    /* renamed from: component7  reason: from getter */
    public final Boolean getEnableStatus() {
        return this.enableStatus;
    }

    /* renamed from: component8  reason: from getter */
    public final String getDisableReason() {
        return this.disableReason;
    }

    /* renamed from: component9  reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    public final QueryInstallment copy(DanaCredit danaCredit, String loanAgreementUrl, List<RepaymentPlan> repaymentPlans, Boolean isPaylaterAgreementEnable, ConsultAgreementResponse consultAgreement, Throwable consultAgreementError, Boolean enableStatus, String disableReason, Boolean success) {
        return new QueryInstallment(danaCredit, loanAgreementUrl, repaymentPlans, isPaylaterAgreementEnable, consultAgreement, consultAgreementError, enableStatus, disableReason, success);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryInstallment) {
            QueryInstallment queryInstallment = (QueryInstallment) other;
            return Intrinsics.areEqual(this.danaCredit, queryInstallment.danaCredit) && Intrinsics.areEqual(this.loanAgreementUrl, queryInstallment.loanAgreementUrl) && Intrinsics.areEqual(this.repaymentPlans, queryInstallment.repaymentPlans) && Intrinsics.areEqual(this.isPaylaterAgreementEnable, queryInstallment.isPaylaterAgreementEnable) && Intrinsics.areEqual(this.consultAgreement, queryInstallment.consultAgreement) && Intrinsics.areEqual(this.consultAgreementError, queryInstallment.consultAgreementError) && Intrinsics.areEqual(this.enableStatus, queryInstallment.enableStatus) && Intrinsics.areEqual(this.disableReason, queryInstallment.disableReason) && Intrinsics.areEqual(this.success, queryInstallment.success);
        }
        return false;
    }

    public final int hashCode() {
        DanaCredit danaCredit = this.danaCredit;
        int hashCode = danaCredit == null ? 0 : danaCredit.hashCode();
        String str = this.loanAgreementUrl;
        int hashCode2 = str == null ? 0 : str.hashCode();
        List<RepaymentPlan> list = this.repaymentPlans;
        int hashCode3 = list == null ? 0 : list.hashCode();
        Boolean bool = this.isPaylaterAgreementEnable;
        int hashCode4 = bool == null ? 0 : bool.hashCode();
        ConsultAgreementResponse consultAgreementResponse = this.consultAgreement;
        int hashCode5 = consultAgreementResponse == null ? 0 : consultAgreementResponse.hashCode();
        Throwable th = this.consultAgreementError;
        int hashCode6 = th == null ? 0 : th.hashCode();
        Boolean bool2 = this.enableStatus;
        int hashCode7 = bool2 == null ? 0 : bool2.hashCode();
        String str2 = this.disableReason;
        int hashCode8 = str2 == null ? 0 : str2.hashCode();
        Boolean bool3 = this.success;
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + (bool3 != null ? bool3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryInstallment(danaCredit=");
        sb.append(this.danaCredit);
        sb.append(", loanAgreementUrl=");
        sb.append(this.loanAgreementUrl);
        sb.append(", repaymentPlans=");
        sb.append(this.repaymentPlans);
        sb.append(", isPaylaterAgreementEnable=");
        sb.append(this.isPaylaterAgreementEnable);
        sb.append(", consultAgreement=");
        sb.append(this.consultAgreement);
        sb.append(", consultAgreementError=");
        sb.append(this.consultAgreementError);
        sb.append(", enableStatus=");
        sb.append(this.enableStatus);
        sb.append(", disableReason=");
        sb.append(this.disableReason);
        sb.append(", success=");
        sb.append(this.success);
        sb.append(')');
        return sb.toString();
    }

    public QueryInstallment(DanaCredit danaCredit, String str, List<RepaymentPlan> list, Boolean bool, ConsultAgreementResponse consultAgreementResponse, Throwable th, Boolean bool2, String str2, Boolean bool3) {
        this.danaCredit = danaCredit;
        this.loanAgreementUrl = str;
        this.repaymentPlans = list;
        this.isPaylaterAgreementEnable = bool;
        this.consultAgreement = consultAgreementResponse;
        this.consultAgreementError = th;
        this.enableStatus = bool2;
        this.disableReason = str2;
        this.success = bool3;
    }

    @JvmName(name = "getDanaCredit")
    public final DanaCredit getDanaCredit() {
        return this.danaCredit;
    }

    @JvmName(name = "getLoanAgreementUrl")
    public final String getLoanAgreementUrl() {
        return this.loanAgreementUrl;
    }

    @JvmName(name = "getRepaymentPlans")
    public final List<RepaymentPlan> getRepaymentPlans() {
        return this.repaymentPlans;
    }

    public /* synthetic */ QueryInstallment(DanaCredit danaCredit, String str, List list, Boolean bool, ConsultAgreementResponse consultAgreementResponse, Throwable th, Boolean bool2, String str2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(danaCredit, str, list, (i & 8) != 0 ? Boolean.FALSE : bool, (i & 16) != 0 ? null : consultAgreementResponse, (i & 32) != 0 ? null : th, bool2, str2, bool3);
    }

    @JvmName(name = "isPaylaterAgreementEnable")
    public final Boolean isPaylaterAgreementEnable() {
        return this.isPaylaterAgreementEnable;
    }

    @JvmName(name = "setPaylaterAgreementEnable")
    public final void setPaylaterAgreementEnable(Boolean bool) {
        this.isPaylaterAgreementEnable = bool;
    }

    @JvmName(name = "getConsultAgreement")
    public final ConsultAgreementResponse getConsultAgreement() {
        return this.consultAgreement;
    }

    @JvmName(name = "setConsultAgreement")
    public final void setConsultAgreement(ConsultAgreementResponse consultAgreementResponse) {
        this.consultAgreement = consultAgreementResponse;
    }

    @JvmName(name = "getConsultAgreementError")
    public final Throwable getConsultAgreementError() {
        return this.consultAgreementError;
    }

    @JvmName(name = "setConsultAgreementError")
    public final void setConsultAgreementError(Throwable th) {
        this.consultAgreementError = th;
    }

    @JvmName(name = "getEnableStatus")
    public final Boolean getEnableStatus() {
        return this.enableStatus;
    }

    @JvmName(name = "setEnableStatus")
    public final void setEnableStatus(Boolean bool) {
        this.enableStatus = bool;
    }

    @JvmName(name = "getDisableReason")
    public final String getDisableReason() {
        return this.disableReason;
    }

    @JvmName(name = "setDisableReason")
    public final void setDisableReason(String str) {
        this.disableReason = str;
    }

    @JvmName(name = "getSuccess")
    public final Boolean getSuccess() {
        return this.success;
    }

    @JvmName(name = "setSuccess")
    public final void setSuccess(Boolean bool) {
        this.success = bool;
    }
}
