package id.dana.cashier.data.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.paylater.repository.source.network.result.DanaCreditResult;
import id.dana.data.paylater.repository.source.network.result.RepaymentPlanResult;
import id.dana.network.base.BaseRpcResultAphome;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b(\u0010)J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007JR\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0007R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\u0007R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b%\u0010\u0007R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010\u000b"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/QueryInstallmentResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "Lid/dana/data/paylater/repository/source/network/result/DanaCreditResult;", "component1", "()Lid/dana/data/paylater/repository/source/network/result/DanaCreditResult;", "", "component2", "()Ljava/lang/String;", "", "Lid/dana/data/paylater/repository/source/network/result/RepaymentPlanResult;", "component3", "()Ljava/util/List;", "", "component4", "()Ljava/lang/Boolean;", "component5", "danaCredit", CashierKeyParams.LOAN_AGREEMENT_URL, "repaymentPlans", "enableStatus", "disableReason", "copy", "(Lid/dana/data/paylater/repository/source/network/result/DanaCreditResult;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/result/QueryInstallmentResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/data/paylater/repository/source/network/result/DanaCreditResult;", "getDanaCredit", "Ljava/lang/String;", "getDisableReason", "Ljava/lang/Boolean;", "getEnableStatus", "getLoanAgreementUrl", "Ljava/util/List;", "getRepaymentPlans", "<init>", "(Lid/dana/data/paylater/repository/source/network/result/DanaCreditResult;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QueryInstallmentResult extends BaseRpcResultAphome {
    @SerializedName("danaCredit")
    private final DanaCreditResult danaCredit;
    private final String disableReason;
    private final Boolean enableStatus;
    private final String loanAgreementUrl;
    private final List<RepaymentPlanResult> repaymentPlans;

    public static /* synthetic */ QueryInstallmentResult copy$default(QueryInstallmentResult queryInstallmentResult, DanaCreditResult danaCreditResult, String str, List list, Boolean bool, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            danaCreditResult = queryInstallmentResult.danaCredit;
        }
        if ((i & 2) != 0) {
            str = queryInstallmentResult.loanAgreementUrl;
        }
        String str3 = str;
        List<RepaymentPlanResult> list2 = list;
        if ((i & 4) != 0) {
            list2 = queryInstallmentResult.repaymentPlans;
        }
        List list3 = list2;
        if ((i & 8) != 0) {
            bool = queryInstallmentResult.enableStatus;
        }
        Boolean bool2 = bool;
        if ((i & 16) != 0) {
            str2 = queryInstallmentResult.disableReason;
        }
        return queryInstallmentResult.copy(danaCreditResult, str3, list3, bool2, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final DanaCreditResult getDanaCredit() {
        return this.danaCredit;
    }

    /* renamed from: component2  reason: from getter */
    public final String getLoanAgreementUrl() {
        return this.loanAgreementUrl;
    }

    public final List<RepaymentPlanResult> component3() {
        return this.repaymentPlans;
    }

    /* renamed from: component4  reason: from getter */
    public final Boolean getEnableStatus() {
        return this.enableStatus;
    }

    /* renamed from: component5  reason: from getter */
    public final String getDisableReason() {
        return this.disableReason;
    }

    public final QueryInstallmentResult copy(DanaCreditResult danaCredit, String loanAgreementUrl, List<RepaymentPlanResult> repaymentPlans, Boolean enableStatus, String disableReason) {
        return new QueryInstallmentResult(danaCredit, loanAgreementUrl, repaymentPlans, enableStatus, disableReason);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryInstallmentResult) {
            QueryInstallmentResult queryInstallmentResult = (QueryInstallmentResult) other;
            return Intrinsics.areEqual(this.danaCredit, queryInstallmentResult.danaCredit) && Intrinsics.areEqual(this.loanAgreementUrl, queryInstallmentResult.loanAgreementUrl) && Intrinsics.areEqual(this.repaymentPlans, queryInstallmentResult.repaymentPlans) && Intrinsics.areEqual(this.enableStatus, queryInstallmentResult.enableStatus) && Intrinsics.areEqual(this.disableReason, queryInstallmentResult.disableReason);
        }
        return false;
    }

    public final int hashCode() {
        DanaCreditResult danaCreditResult = this.danaCredit;
        int hashCode = danaCreditResult == null ? 0 : danaCreditResult.hashCode();
        String str = this.loanAgreementUrl;
        int hashCode2 = str == null ? 0 : str.hashCode();
        List<RepaymentPlanResult> list = this.repaymentPlans;
        int hashCode3 = list == null ? 0 : list.hashCode();
        Boolean bool = this.enableStatus;
        int hashCode4 = bool == null ? 0 : bool.hashCode();
        String str2 = this.disableReason;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryInstallmentResult(danaCredit=");
        sb.append(this.danaCredit);
        sb.append(", loanAgreementUrl=");
        sb.append(this.loanAgreementUrl);
        sb.append(", repaymentPlans=");
        sb.append(this.repaymentPlans);
        sb.append(", enableStatus=");
        sb.append(this.enableStatus);
        sb.append(", disableReason=");
        sb.append(this.disableReason);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getDanaCredit")
    public final DanaCreditResult getDanaCredit() {
        return this.danaCredit;
    }

    @JvmName(name = "getLoanAgreementUrl")
    public final String getLoanAgreementUrl() {
        return this.loanAgreementUrl;
    }

    @JvmName(name = "getRepaymentPlans")
    public final List<RepaymentPlanResult> getRepaymentPlans() {
        return this.repaymentPlans;
    }

    @JvmName(name = "getEnableStatus")
    public final Boolean getEnableStatus() {
        return this.enableStatus;
    }

    @JvmName(name = "getDisableReason")
    public final String getDisableReason() {
        return this.disableReason;
    }

    public QueryInstallmentResult(DanaCreditResult danaCreditResult, String str, List<RepaymentPlanResult> list, Boolean bool, String str2) {
        this.danaCredit = danaCreditResult;
        this.loanAgreementUrl = str;
        this.repaymentPlans = list;
        this.enableStatus = bool;
        this.disableReason = str2;
    }
}
