package id.dana.domain.familyaccount.model;

import id.dana.domain.nearbyme.model.MoneyView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001f\u0010\u0007R\u001a\u0010\f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b \u0010\u0007"}, d2 = {"Lid/dana/domain/familyaccount/model/ConsultFamilyAccountResult;", "", "Lid/dana/domain/nearbyme/model/MoneyView;", "component1", "()Lid/dana/domain/nearbyme/model/MoneyView;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "balance", "status", "role", "organizerName", "remainingAmount", "copy", "(Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/domain/familyaccount/model/ConsultFamilyAccountResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/domain/nearbyme/model/MoneyView;", "getBalance", "Ljava/lang/String;", "getOrganizerName", "getRemainingAmount", "getRole", "getStatus", "<init>", "(Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ConsultFamilyAccountResult {
    private final MoneyView balance;
    private final String organizerName;
    private final MoneyView remainingAmount;
    private final String role;
    private final String status;

    public static /* synthetic */ ConsultFamilyAccountResult copy$default(ConsultFamilyAccountResult consultFamilyAccountResult, MoneyView moneyView, String str, String str2, String str3, MoneyView moneyView2, int i, Object obj) {
        if ((i & 1) != 0) {
            moneyView = consultFamilyAccountResult.balance;
        }
        if ((i & 2) != 0) {
            str = consultFamilyAccountResult.status;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = consultFamilyAccountResult.role;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = consultFamilyAccountResult.organizerName;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            moneyView2 = consultFamilyAccountResult.remainingAmount;
        }
        return consultFamilyAccountResult.copy(moneyView, str4, str5, str6, moneyView2);
    }

    /* renamed from: component1  reason: from getter */
    public final MoneyView getBalance() {
        return this.balance;
    }

    /* renamed from: component2  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component3  reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: component4  reason: from getter */
    public final String getOrganizerName() {
        return this.organizerName;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyView getRemainingAmount() {
        return this.remainingAmount;
    }

    public final ConsultFamilyAccountResult copy(MoneyView balance, String status, String role, String organizerName, MoneyView remainingAmount) {
        Intrinsics.checkNotNullParameter(balance, "");
        Intrinsics.checkNotNullParameter(status, "");
        Intrinsics.checkNotNullParameter(role, "");
        Intrinsics.checkNotNullParameter(organizerName, "");
        Intrinsics.checkNotNullParameter(remainingAmount, "");
        return new ConsultFamilyAccountResult(balance, status, role, organizerName, remainingAmount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ConsultFamilyAccountResult) {
            ConsultFamilyAccountResult consultFamilyAccountResult = (ConsultFamilyAccountResult) other;
            return Intrinsics.areEqual(this.balance, consultFamilyAccountResult.balance) && Intrinsics.areEqual(this.status, consultFamilyAccountResult.status) && Intrinsics.areEqual(this.role, consultFamilyAccountResult.role) && Intrinsics.areEqual(this.organizerName, consultFamilyAccountResult.organizerName) && Intrinsics.areEqual(this.remainingAmount, consultFamilyAccountResult.remainingAmount);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((this.balance.hashCode() * 31) + this.status.hashCode()) * 31) + this.role.hashCode()) * 31) + this.organizerName.hashCode()) * 31) + this.remainingAmount.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConsultFamilyAccountResult(balance=");
        sb.append(this.balance);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", role=");
        sb.append(this.role);
        sb.append(", organizerName=");
        sb.append(this.organizerName);
        sb.append(", remainingAmount=");
        sb.append(this.remainingAmount);
        sb.append(')');
        return sb.toString();
    }

    public ConsultFamilyAccountResult(MoneyView moneyView, String str, String str2, String str3, MoneyView moneyView2) {
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(moneyView2, "");
        this.balance = moneyView;
        this.status = str;
        this.role = str2;
        this.organizerName = str3;
        this.remainingAmount = moneyView2;
    }

    @JvmName(name = "getBalance")
    public final MoneyView getBalance() {
        return this.balance;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getRole")
    public final String getRole() {
        return this.role;
    }

    @JvmName(name = "getOrganizerName")
    public final String getOrganizerName() {
        return this.organizerName;
    }

    @JvmName(name = "getRemainingAmount")
    public final MoneyView getRemainingAmount() {
        return this.remainingAmount;
    }
}
