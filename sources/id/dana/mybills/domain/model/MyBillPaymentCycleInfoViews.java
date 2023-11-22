package id.dana.mybills.domain.model;

import id.dana.domain.nearbyme.model.MoneyView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b)\u0010*J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJV\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0007R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010\u0007R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b#\u0010\u0007R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b&\u0010\u0007R\u001a\u0010\u0015\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b(\u0010\u000f"}, d2 = {"Lid/dana/mybills/domain/model/MyBillPaymentCycleInfoViews;", "", "", "component1", "()Ljava/lang/Boolean;", "", "component2", "()Ljava/lang/String;", "component3", "", "component4", "()Ljava/lang/Long;", "component5", "Lid/dana/domain/nearbyme/model/MoneyView;", "component6", "()Lid/dana/domain/nearbyme/model/MoneyView;", "canBePaid", "lastExtTrxId", "lastPayStatus", "lastPaymentDate", "lastTrxId", "paidAmount", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/mybills/domain/model/MyBillPaymentCycleInfoViews;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/Boolean;", "getCanBePaid", "Ljava/lang/String;", "getLastExtTrxId", "getLastPayStatus", "Ljava/lang/Long;", "getLastPaymentDate", "getLastTrxId", "Lid/dana/domain/nearbyme/model/MoneyView;", "getPaidAmount", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MyBillPaymentCycleInfoViews {
    private final Boolean canBePaid;
    private final String lastExtTrxId;
    private final String lastPayStatus;
    private final Long lastPaymentDate;
    private final String lastTrxId;
    private final MoneyView paidAmount;

    public static /* synthetic */ MyBillPaymentCycleInfoViews copy$default(MyBillPaymentCycleInfoViews myBillPaymentCycleInfoViews, Boolean bool, String str, String str2, Long l, String str3, MoneyView moneyView, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = myBillPaymentCycleInfoViews.canBePaid;
        }
        if ((i & 2) != 0) {
            str = myBillPaymentCycleInfoViews.lastExtTrxId;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = myBillPaymentCycleInfoViews.lastPayStatus;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            l = myBillPaymentCycleInfoViews.lastPaymentDate;
        }
        Long l2 = l;
        if ((i & 16) != 0) {
            str3 = myBillPaymentCycleInfoViews.lastTrxId;
        }
        String str6 = str3;
        if ((i & 32) != 0) {
            moneyView = myBillPaymentCycleInfoViews.paidAmount;
        }
        return myBillPaymentCycleInfoViews.copy(bool, str4, str5, l2, str6, moneyView);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getCanBePaid() {
        return this.canBePaid;
    }

    /* renamed from: component2  reason: from getter */
    public final String getLastExtTrxId() {
        return this.lastExtTrxId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getLastPayStatus() {
        return this.lastPayStatus;
    }

    /* renamed from: component4  reason: from getter */
    public final Long getLastPaymentDate() {
        return this.lastPaymentDate;
    }

    /* renamed from: component5  reason: from getter */
    public final String getLastTrxId() {
        return this.lastTrxId;
    }

    /* renamed from: component6  reason: from getter */
    public final MoneyView getPaidAmount() {
        return this.paidAmount;
    }

    public final MyBillPaymentCycleInfoViews copy(Boolean canBePaid, String lastExtTrxId, String lastPayStatus, Long lastPaymentDate, String lastTrxId, MoneyView paidAmount) {
        Intrinsics.checkNotNullParameter(paidAmount, "");
        return new MyBillPaymentCycleInfoViews(canBePaid, lastExtTrxId, lastPayStatus, lastPaymentDate, lastTrxId, paidAmount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MyBillPaymentCycleInfoViews) {
            MyBillPaymentCycleInfoViews myBillPaymentCycleInfoViews = (MyBillPaymentCycleInfoViews) other;
            return Intrinsics.areEqual(this.canBePaid, myBillPaymentCycleInfoViews.canBePaid) && Intrinsics.areEqual(this.lastExtTrxId, myBillPaymentCycleInfoViews.lastExtTrxId) && Intrinsics.areEqual(this.lastPayStatus, myBillPaymentCycleInfoViews.lastPayStatus) && Intrinsics.areEqual(this.lastPaymentDate, myBillPaymentCycleInfoViews.lastPaymentDate) && Intrinsics.areEqual(this.lastTrxId, myBillPaymentCycleInfoViews.lastTrxId) && Intrinsics.areEqual(this.paidAmount, myBillPaymentCycleInfoViews.paidAmount);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.canBePaid;
        int hashCode = bool == null ? 0 : bool.hashCode();
        String str = this.lastExtTrxId;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.lastPayStatus;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        Long l = this.lastPaymentDate;
        int hashCode4 = l == null ? 0 : l.hashCode();
        String str3 = this.lastTrxId;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str3 != null ? str3.hashCode() : 0)) * 31) + this.paidAmount.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyBillPaymentCycleInfoViews(canBePaid=");
        sb.append(this.canBePaid);
        sb.append(", lastExtTrxId=");
        sb.append(this.lastExtTrxId);
        sb.append(", lastPayStatus=");
        sb.append(this.lastPayStatus);
        sb.append(", lastPaymentDate=");
        sb.append(this.lastPaymentDate);
        sb.append(", lastTrxId=");
        sb.append(this.lastTrxId);
        sb.append(", paidAmount=");
        sb.append(this.paidAmount);
        sb.append(')');
        return sb.toString();
    }

    public MyBillPaymentCycleInfoViews(Boolean bool, String str, String str2, Long l, String str3, MoneyView moneyView) {
        Intrinsics.checkNotNullParameter(moneyView, "");
        this.canBePaid = bool;
        this.lastExtTrxId = str;
        this.lastPayStatus = str2;
        this.lastPaymentDate = l;
        this.lastTrxId = str3;
        this.paidAmount = moneyView;
    }

    public /* synthetic */ MyBillPaymentCycleInfoViews(Boolean bool, String str, String str2, Long l, String str3, MoneyView moneyView, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Boolean.TRUE : bool, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? 0L : l, (i & 16) != 0 ? "" : str3, moneyView);
    }

    @JvmName(name = "getCanBePaid")
    public final Boolean getCanBePaid() {
        return this.canBePaid;
    }

    @JvmName(name = "getLastExtTrxId")
    public final String getLastExtTrxId() {
        return this.lastExtTrxId;
    }

    @JvmName(name = "getLastPayStatus")
    public final String getLastPayStatus() {
        return this.lastPayStatus;
    }

    @JvmName(name = "getLastPaymentDate")
    public final Long getLastPaymentDate() {
        return this.lastPaymentDate;
    }

    @JvmName(name = "getLastTrxId")
    public final String getLastTrxId() {
        return this.lastTrxId;
    }

    @JvmName(name = "getPaidAmount")
    public final MoneyView getPaidAmount() {
        return this.paidAmount;
    }
}
