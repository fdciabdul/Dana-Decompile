package id.dana.cashier.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b(\u0010)J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004Jp\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b!\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b'\u0010\u0004"}, d2 = {"Lid/dana/cashier/domain/model/CouponInfo;", "", "", "component1", "()Ljava/lang/Boolean;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "canFundbackBack", "canLuckMoneyPayment", "canPartUse", "canRefundBack", "canRegularPayment", "canSuperpose", "canTransfer", "canWithDraw", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lid/dana/cashier/domain/model/CouponInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Boolean;", "getCanFundbackBack", "getCanLuckMoneyPayment", "getCanPartUse", "getCanRefundBack", "getCanRegularPayment", "getCanSuperpose", "getCanTransfer", "getCanWithDraw", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CouponInfo {
    private final Boolean canFundbackBack;
    private final Boolean canLuckMoneyPayment;
    private final Boolean canPartUse;
    private final Boolean canRefundBack;
    private final Boolean canRegularPayment;
    private final Boolean canSuperpose;
    private final Boolean canTransfer;
    private final Boolean canWithDraw;

    /* renamed from: component1  reason: from getter */
    public final Boolean getCanFundbackBack() {
        return this.canFundbackBack;
    }

    /* renamed from: component2  reason: from getter */
    public final Boolean getCanLuckMoneyPayment() {
        return this.canLuckMoneyPayment;
    }

    /* renamed from: component3  reason: from getter */
    public final Boolean getCanPartUse() {
        return this.canPartUse;
    }

    /* renamed from: component4  reason: from getter */
    public final Boolean getCanRefundBack() {
        return this.canRefundBack;
    }

    /* renamed from: component5  reason: from getter */
    public final Boolean getCanRegularPayment() {
        return this.canRegularPayment;
    }

    /* renamed from: component6  reason: from getter */
    public final Boolean getCanSuperpose() {
        return this.canSuperpose;
    }

    /* renamed from: component7  reason: from getter */
    public final Boolean getCanTransfer() {
        return this.canTransfer;
    }

    /* renamed from: component8  reason: from getter */
    public final Boolean getCanWithDraw() {
        return this.canWithDraw;
    }

    public final CouponInfo copy(Boolean canFundbackBack, Boolean canLuckMoneyPayment, Boolean canPartUse, Boolean canRefundBack, Boolean canRegularPayment, Boolean canSuperpose, Boolean canTransfer, Boolean canWithDraw) {
        return new CouponInfo(canFundbackBack, canLuckMoneyPayment, canPartUse, canRefundBack, canRegularPayment, canSuperpose, canTransfer, canWithDraw);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CouponInfo) {
            CouponInfo couponInfo = (CouponInfo) other;
            return Intrinsics.areEqual(this.canFundbackBack, couponInfo.canFundbackBack) && Intrinsics.areEqual(this.canLuckMoneyPayment, couponInfo.canLuckMoneyPayment) && Intrinsics.areEqual(this.canPartUse, couponInfo.canPartUse) && Intrinsics.areEqual(this.canRefundBack, couponInfo.canRefundBack) && Intrinsics.areEqual(this.canRegularPayment, couponInfo.canRegularPayment) && Intrinsics.areEqual(this.canSuperpose, couponInfo.canSuperpose) && Intrinsics.areEqual(this.canTransfer, couponInfo.canTransfer) && Intrinsics.areEqual(this.canWithDraw, couponInfo.canWithDraw);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.canFundbackBack;
        int hashCode = bool == null ? 0 : bool.hashCode();
        Boolean bool2 = this.canLuckMoneyPayment;
        int hashCode2 = bool2 == null ? 0 : bool2.hashCode();
        Boolean bool3 = this.canPartUse;
        int hashCode3 = bool3 == null ? 0 : bool3.hashCode();
        Boolean bool4 = this.canRefundBack;
        int hashCode4 = bool4 == null ? 0 : bool4.hashCode();
        Boolean bool5 = this.canRegularPayment;
        int hashCode5 = bool5 == null ? 0 : bool5.hashCode();
        Boolean bool6 = this.canSuperpose;
        int hashCode6 = bool6 == null ? 0 : bool6.hashCode();
        Boolean bool7 = this.canTransfer;
        int hashCode7 = bool7 == null ? 0 : bool7.hashCode();
        Boolean bool8 = this.canWithDraw;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + (bool8 != null ? bool8.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CouponInfo(canFundbackBack=");
        sb.append(this.canFundbackBack);
        sb.append(", canLuckMoneyPayment=");
        sb.append(this.canLuckMoneyPayment);
        sb.append(", canPartUse=");
        sb.append(this.canPartUse);
        sb.append(", canRefundBack=");
        sb.append(this.canRefundBack);
        sb.append(", canRegularPayment=");
        sb.append(this.canRegularPayment);
        sb.append(", canSuperpose=");
        sb.append(this.canSuperpose);
        sb.append(", canTransfer=");
        sb.append(this.canTransfer);
        sb.append(", canWithDraw=");
        sb.append(this.canWithDraw);
        sb.append(')');
        return sb.toString();
    }

    public CouponInfo(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8) {
        this.canFundbackBack = bool;
        this.canLuckMoneyPayment = bool2;
        this.canPartUse = bool3;
        this.canRefundBack = bool4;
        this.canRegularPayment = bool5;
        this.canSuperpose = bool6;
        this.canTransfer = bool7;
        this.canWithDraw = bool8;
    }

    @JvmName(name = "getCanFundbackBack")
    public final Boolean getCanFundbackBack() {
        return this.canFundbackBack;
    }

    @JvmName(name = "getCanLuckMoneyPayment")
    public final Boolean getCanLuckMoneyPayment() {
        return this.canLuckMoneyPayment;
    }

    @JvmName(name = "getCanPartUse")
    public final Boolean getCanPartUse() {
        return this.canPartUse;
    }

    @JvmName(name = "getCanRefundBack")
    public final Boolean getCanRefundBack() {
        return this.canRefundBack;
    }

    @JvmName(name = "getCanRegularPayment")
    public final Boolean getCanRegularPayment() {
        return this.canRegularPayment;
    }

    @JvmName(name = "getCanSuperpose")
    public final Boolean getCanSuperpose() {
        return this.canSuperpose;
    }

    @JvmName(name = "getCanTransfer")
    public final Boolean getCanTransfer() {
        return this.canTransfer;
    }

    @JvmName(name = "getCanWithDraw")
    public final Boolean getCanWithDraw() {
        return this.canWithDraw;
    }
}
