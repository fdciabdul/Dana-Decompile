package id.dana.mybills.data.model.response;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010\u001d\u001a\u00020\u0012\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\r\u0012\u0006\u0010!\u001a\u00020\u0005\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\u0006\u0010#\u001a\u00020\t¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u000fJ\u0088\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010'\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b)\u0010\u000fJ\u0010\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010\u0004R\u0017\u0010\u0018\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b-\u0010\u0004R\u001a\u0010\u001a\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b/\u0010\u000fR\u001a\u0010\u001b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00100\u001a\u0004\b1\u0010\u0007R\u001a\u0010\u001c\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00100\u001a\u0004\b2\u0010\u0007R\u001a\u0010\u001d\u001a\u00020\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00103\u001a\u0004\b4\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00100\u001a\u0004\b5\u0010\u0007R\u001a\u0010\u001f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00100\u001a\u0004\b6\u0010\u0007R\u001a\u0010 \u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010.\u001a\u0004\b7\u0010\u000fR\u001a\u0010\"\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00100\u001a\u0004\b8\u0010\u0007R\u001a\u0010!\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00100\u001a\u0004\b9\u0010\u0007R\u001a\u0010#\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010:\u001a\u0004\b;\u0010\u000b"}, d2 = {"Lid/dana/mybills/data/model/response/CumulateDueDateDetail;", "", "", "component1", "()Ljava/lang/String;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component10", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component11", "", "component12", "()J", "component2", "", "component3", "()I", "component4", "component5", "", "component6", "()Z", "component7", "component8", "component9", "billType", "cumulateDueDateId", "dueDate", "interestFeeAmount", "lateFeeAmount", "overDue", "paidAmount", "principalAmount", "remainingDueDate", "totalAmount", "remainingTotalAmount", "transactionTime", "copy", "(Ljava/lang/String;Ljava/lang/String;ILid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;ZLid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;ILid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;J)Lid/dana/mybills/data/model/response/CumulateDueDateDetail;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getBillType", "getCumulateDueDateId", "I", "getDueDate", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getInterestFeeAmount", "getLateFeeAmount", "Z", "getOverDue", "getPaidAmount", "getPrincipalAmount", "getRemainingDueDate", "getRemainingTotalAmount", "getTotalAmount", "J", "getTransactionTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;ZLid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;ILid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CumulateDueDateDetail {
    private final String billType;
    private final String cumulateDueDateId;
    private final int dueDate;
    private final MoneyViewEntity interestFeeAmount;
    private final MoneyViewEntity lateFeeAmount;
    private final boolean overDue;
    private final MoneyViewEntity paidAmount;
    private final MoneyViewEntity principalAmount;
    private final int remainingDueDate;
    private final MoneyViewEntity remainingTotalAmount;
    private final MoneyViewEntity totalAmount;
    private final long transactionTime;

    /* renamed from: component1  reason: from getter */
    public final String getBillType() {
        return this.billType;
    }

    /* renamed from: component10  reason: from getter */
    public final MoneyViewEntity getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component11  reason: from getter */
    public final MoneyViewEntity getRemainingTotalAmount() {
        return this.remainingTotalAmount;
    }

    /* renamed from: component12  reason: from getter */
    public final long getTransactionTime() {
        return this.transactionTime;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCumulateDueDateId() {
        return this.cumulateDueDateId;
    }

    /* renamed from: component3  reason: from getter */
    public final int getDueDate() {
        return this.dueDate;
    }

    /* renamed from: component4  reason: from getter */
    public final MoneyViewEntity getInterestFeeAmount() {
        return this.interestFeeAmount;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyViewEntity getLateFeeAmount() {
        return this.lateFeeAmount;
    }

    /* renamed from: component6  reason: from getter */
    public final boolean getOverDue() {
        return this.overDue;
    }

    /* renamed from: component7  reason: from getter */
    public final MoneyViewEntity getPaidAmount() {
        return this.paidAmount;
    }

    /* renamed from: component8  reason: from getter */
    public final MoneyViewEntity getPrincipalAmount() {
        return this.principalAmount;
    }

    /* renamed from: component9  reason: from getter */
    public final int getRemainingDueDate() {
        return this.remainingDueDate;
    }

    public final CumulateDueDateDetail copy(String billType, String cumulateDueDateId, int dueDate, MoneyViewEntity interestFeeAmount, MoneyViewEntity lateFeeAmount, boolean overDue, MoneyViewEntity paidAmount, MoneyViewEntity principalAmount, int remainingDueDate, MoneyViewEntity totalAmount, MoneyViewEntity remainingTotalAmount, long transactionTime) {
        Intrinsics.checkNotNullParameter(billType, "");
        Intrinsics.checkNotNullParameter(cumulateDueDateId, "");
        Intrinsics.checkNotNullParameter(interestFeeAmount, "");
        Intrinsics.checkNotNullParameter(lateFeeAmount, "");
        Intrinsics.checkNotNullParameter(paidAmount, "");
        Intrinsics.checkNotNullParameter(principalAmount, "");
        Intrinsics.checkNotNullParameter(totalAmount, "");
        Intrinsics.checkNotNullParameter(remainingTotalAmount, "");
        return new CumulateDueDateDetail(billType, cumulateDueDateId, dueDate, interestFeeAmount, lateFeeAmount, overDue, paidAmount, principalAmount, remainingDueDate, totalAmount, remainingTotalAmount, transactionTime);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CumulateDueDateDetail) {
            CumulateDueDateDetail cumulateDueDateDetail = (CumulateDueDateDetail) other;
            return Intrinsics.areEqual(this.billType, cumulateDueDateDetail.billType) && Intrinsics.areEqual(this.cumulateDueDateId, cumulateDueDateDetail.cumulateDueDateId) && this.dueDate == cumulateDueDateDetail.dueDate && Intrinsics.areEqual(this.interestFeeAmount, cumulateDueDateDetail.interestFeeAmount) && Intrinsics.areEqual(this.lateFeeAmount, cumulateDueDateDetail.lateFeeAmount) && this.overDue == cumulateDueDateDetail.overDue && Intrinsics.areEqual(this.paidAmount, cumulateDueDateDetail.paidAmount) && Intrinsics.areEqual(this.principalAmount, cumulateDueDateDetail.principalAmount) && this.remainingDueDate == cumulateDueDateDetail.remainingDueDate && Intrinsics.areEqual(this.totalAmount, cumulateDueDateDetail.totalAmount) && Intrinsics.areEqual(this.remainingTotalAmount, cumulateDueDateDetail.remainingTotalAmount) && this.transactionTime == cumulateDueDateDetail.transactionTime;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.billType.hashCode();
        int hashCode2 = this.cumulateDueDateId.hashCode();
        int i = this.dueDate;
        int hashCode3 = this.interestFeeAmount.hashCode();
        int hashCode4 = this.lateFeeAmount.hashCode();
        boolean z = this.overDue;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + i) * 31) + hashCode3) * 31) + hashCode4) * 31) + i2) * 31) + this.paidAmount.hashCode()) * 31) + this.principalAmount.hashCode()) * 31) + this.remainingDueDate) * 31) + this.totalAmount.hashCode()) * 31) + this.remainingTotalAmount.hashCode()) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.transactionTime);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CumulateDueDateDetail(billType=");
        sb.append(this.billType);
        sb.append(", cumulateDueDateId=");
        sb.append(this.cumulateDueDateId);
        sb.append(", dueDate=");
        sb.append(this.dueDate);
        sb.append(", interestFeeAmount=");
        sb.append(this.interestFeeAmount);
        sb.append(", lateFeeAmount=");
        sb.append(this.lateFeeAmount);
        sb.append(", overDue=");
        sb.append(this.overDue);
        sb.append(", paidAmount=");
        sb.append(this.paidAmount);
        sb.append(", principalAmount=");
        sb.append(this.principalAmount);
        sb.append(", remainingDueDate=");
        sb.append(this.remainingDueDate);
        sb.append(", totalAmount=");
        sb.append(this.totalAmount);
        sb.append(", remainingTotalAmount=");
        sb.append(this.remainingTotalAmount);
        sb.append(", transactionTime=");
        sb.append(this.transactionTime);
        sb.append(')');
        return sb.toString();
    }

    public CumulateDueDateDetail(String str, String str2, int i, MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, boolean z, MoneyViewEntity moneyViewEntity3, MoneyViewEntity moneyViewEntity4, int i2, MoneyViewEntity moneyViewEntity5, MoneyViewEntity moneyViewEntity6, long j) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity2, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity3, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity4, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity5, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity6, "");
        this.billType = str;
        this.cumulateDueDateId = str2;
        this.dueDate = i;
        this.interestFeeAmount = moneyViewEntity;
        this.lateFeeAmount = moneyViewEntity2;
        this.overDue = z;
        this.paidAmount = moneyViewEntity3;
        this.principalAmount = moneyViewEntity4;
        this.remainingDueDate = i2;
        this.totalAmount = moneyViewEntity5;
        this.remainingTotalAmount = moneyViewEntity6;
        this.transactionTime = j;
    }

    @JvmName(name = "getBillType")
    public final String getBillType() {
        return this.billType;
    }

    @JvmName(name = "getCumulateDueDateId")
    public final String getCumulateDueDateId() {
        return this.cumulateDueDateId;
    }

    @JvmName(name = "getDueDate")
    public final int getDueDate() {
        return this.dueDate;
    }

    @JvmName(name = "getInterestFeeAmount")
    public final MoneyViewEntity getInterestFeeAmount() {
        return this.interestFeeAmount;
    }

    @JvmName(name = "getLateFeeAmount")
    public final MoneyViewEntity getLateFeeAmount() {
        return this.lateFeeAmount;
    }

    @JvmName(name = "getOverDue")
    public final boolean getOverDue() {
        return this.overDue;
    }

    @JvmName(name = "getPaidAmount")
    public final MoneyViewEntity getPaidAmount() {
        return this.paidAmount;
    }

    @JvmName(name = "getPrincipalAmount")
    public final MoneyViewEntity getPrincipalAmount() {
        return this.principalAmount;
    }

    @JvmName(name = "getRemainingDueDate")
    public final int getRemainingDueDate() {
        return this.remainingDueDate;
    }

    @JvmName(name = "getTotalAmount")
    public final MoneyViewEntity getTotalAmount() {
        return this.totalAmount;
    }

    @JvmName(name = "getRemainingTotalAmount")
    public final MoneyViewEntity getRemainingTotalAmount() {
        return this.remainingTotalAmount;
    }

    @JvmName(name = "getTransactionTime")
    public final long getTransactionTime() {
        return this.transactionTime;
    }
}
