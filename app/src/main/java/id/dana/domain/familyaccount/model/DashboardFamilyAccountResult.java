package id.dana.domain.familyaccount.model;

import id.dana.domain.nearbyme.model.MoneyView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004R\u0017\u0010\r\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004"}, d2 = {"Lid/dana/domain/familyaccount/model/DashboardFamilyAccountResult;", "", "", "component1", "()Ljava/lang/String;", "Lid/dana/domain/nearbyme/model/MoneyView;", "component2", "()Lid/dana/domain/nearbyme/model/MoneyView;", "", "Lid/dana/domain/familyaccount/model/FamilyAccountMemberInfoResult;", "component3", "()Ljava/util/List;", "status", "balance", "sharedAccountMemberInfoList", "copy", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/util/List;)Lid/dana/domain/familyaccount/model/DashboardFamilyAccountResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/domain/nearbyme/model/MoneyView;", "getBalance", "Ljava/util/List;", "getSharedAccountMemberInfoList", "Ljava/lang/String;", "getStatus", "<init>", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DashboardFamilyAccountResult {
    private final MoneyView balance;
    private final List<FamilyAccountMemberInfoResult> sharedAccountMemberInfoList;
    private final String status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DashboardFamilyAccountResult copy$default(DashboardFamilyAccountResult dashboardFamilyAccountResult, String str, MoneyView moneyView, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dashboardFamilyAccountResult.status;
        }
        if ((i & 2) != 0) {
            moneyView = dashboardFamilyAccountResult.balance;
        }
        if ((i & 4) != 0) {
            list = dashboardFamilyAccountResult.sharedAccountMemberInfoList;
        }
        return dashboardFamilyAccountResult.copy(str, moneyView, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyView getBalance() {
        return this.balance;
    }

    public final List<FamilyAccountMemberInfoResult> component3() {
        return this.sharedAccountMemberInfoList;
    }

    public final DashboardFamilyAccountResult copy(String status, MoneyView balance, List<FamilyAccountMemberInfoResult> sharedAccountMemberInfoList) {
        Intrinsics.checkNotNullParameter(status, "");
        Intrinsics.checkNotNullParameter(balance, "");
        Intrinsics.checkNotNullParameter(sharedAccountMemberInfoList, "");
        return new DashboardFamilyAccountResult(status, balance, sharedAccountMemberInfoList);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DashboardFamilyAccountResult) {
            DashboardFamilyAccountResult dashboardFamilyAccountResult = (DashboardFamilyAccountResult) other;
            return Intrinsics.areEqual(this.status, dashboardFamilyAccountResult.status) && Intrinsics.areEqual(this.balance, dashboardFamilyAccountResult.balance) && Intrinsics.areEqual(this.sharedAccountMemberInfoList, dashboardFamilyAccountResult.sharedAccountMemberInfoList);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.status.hashCode() * 31) + this.balance.hashCode()) * 31) + this.sharedAccountMemberInfoList.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DashboardFamilyAccountResult(status=");
        sb.append(this.status);
        sb.append(", balance=");
        sb.append(this.balance);
        sb.append(", sharedAccountMemberInfoList=");
        sb.append(this.sharedAccountMemberInfoList);
        sb.append(')');
        return sb.toString();
    }

    public DashboardFamilyAccountResult(String str, MoneyView moneyView, List<FamilyAccountMemberInfoResult> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.status = str;
        this.balance = moneyView;
        this.sharedAccountMemberInfoList = list;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getBalance")
    public final MoneyView getBalance() {
        return this.balance;
    }

    public /* synthetic */ DashboardFamilyAccountResult(String str, MoneyView moneyView, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, moneyView, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getSharedAccountMemberInfoList")
    public final List<FamilyAccountMemberInfoResult> getSharedAccountMemberInfoList() {
        return this.sharedAccountMemberInfoList;
    }
}
