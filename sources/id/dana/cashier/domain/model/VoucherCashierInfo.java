package id.dana.cashier.domain.model;

import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.sendmoney.model.CouponPayMethodInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0010\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010%\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010*\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bM\u0010NJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000f\u0010\fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0013\u0010\bJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0014\u0010\bJ\u0018\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004JÊ\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b-\u0010.J\u001a\u00100\u001a\u00020\u001a2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b0\u00101J\u0010\u00103\u001a\u000202HÖ\u0001¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b5\u0010\bR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u001e\u00106\u001a\u0004\b7\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00108\u001a\u0004\b9\u0010\fR\u001c\u0010 \u001a\u0004\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010:\u001a\u0004\b;\u0010\u0012R\u001c\u0010!\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010<\u001a\u0004\b=\u0010\bR\u001c\u0010\"\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010<\u001a\u0004\b>\u0010\bR\"\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010?\u001a\u0004\b@\u0010\u0018R\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u00106\u001a\u0004\bA\u0010\u0004R$\u0010+\u001a\u0004\u0018\u00010\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010<\u001a\u0004\bB\u0010\b\"\u0004\bC\u0010DR\u001c\u0010%\u001a\u0004\u0018\u00010\u001a8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010E\u001a\u0004\bF\u0010\u001cR\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u00106\u001a\u0004\bG\u0010\u0004R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u00106\u001a\u0004\bH\u0010\u0004R\u001c\u0010(\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010<\u001a\u0004\bI\u0010\bR\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u00106\u001a\u0004\bJ\u0010\u0004R\u001c\u0010,\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010<\u001a\u0004\bK\u0010\bR\u001c\u0010*\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u00108\u001a\u0004\bL\u0010\f"}, d2 = {"Lid/dana/cashier/domain/model/VoucherCashierInfo;", "", "", "component1", "()Ljava/lang/Long;", "component10", "", "component11", "()Ljava/lang/String;", "component12", "Lid/dana/domain/nearbyme/model/MoneyView;", "component13", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component14", "component15", "component2", "Lid/dana/cashier/domain/model/CouponInfo;", "component3", "()Lid/dana/cashier/domain/model/CouponInfo;", "component4", "component5", "", "Lid/dana/domain/sendmoney/model/CouponPayMethodInfo;", "component6", "()Ljava/util/List;", "component7", "", "component8", "()Ljava/lang/Boolean;", "component9", "activeTime", "availableAmount", "couponAbility", "couponId", "couponName", "couponPayMethodInfos", "createdTime", "directDiscountType", "expiryTime", "extendTime", "iconUrl", "modifiedTime", "totalAmount", "description", "tnc", "copy", "(Ljava/lang/Long;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/cashier/domain/model/CouponInfo;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/domain/model/VoucherCashierInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/Long;", "getActiveTime", "Lid/dana/domain/nearbyme/model/MoneyView;", "getAvailableAmount", "Lid/dana/cashier/domain/model/CouponInfo;", "getCouponAbility", "Ljava/lang/String;", "getCouponId", "getCouponName", "Ljava/util/List;", "getCouponPayMethodInfos", "getCreatedTime", "getDescription", "setDescription", "(Ljava/lang/String;)V", "Ljava/lang/Boolean;", "getDirectDiscountType", "getExpiryTime", "getExtendTime", "getIconUrl", "getModifiedTime", "getTnc", "getTotalAmount", "<init>", "(Ljava/lang/Long;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/cashier/domain/model/CouponInfo;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VoucherCashierInfo {
    private final Long activeTime;
    private final MoneyView availableAmount;
    private final CouponInfo couponAbility;
    private final String couponId;
    private final String couponName;
    private final List<CouponPayMethodInfo> couponPayMethodInfos;
    private final Long createdTime;
    private String description;
    private final Boolean directDiscountType;
    private final Long expiryTime;
    private final Long extendTime;
    private final String iconUrl;
    private final Long modifiedTime;
    private final String tnc;
    private final MoneyView totalAmount;

    /* renamed from: component1  reason: from getter */
    public final Long getActiveTime() {
        return this.activeTime;
    }

    /* renamed from: component10  reason: from getter */
    public final Long getExtendTime() {
        return this.extendTime;
    }

    /* renamed from: component11  reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component12  reason: from getter */
    public final Long getModifiedTime() {
        return this.modifiedTime;
    }

    /* renamed from: component13  reason: from getter */
    public final MoneyView getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component14  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component15  reason: from getter */
    public final String getTnc() {
        return this.tnc;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyView getAvailableAmount() {
        return this.availableAmount;
    }

    /* renamed from: component3  reason: from getter */
    public final CouponInfo getCouponAbility() {
        return this.couponAbility;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCouponId() {
        return this.couponId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getCouponName() {
        return this.couponName;
    }

    public final List<CouponPayMethodInfo> component6() {
        return this.couponPayMethodInfos;
    }

    /* renamed from: component7  reason: from getter */
    public final Long getCreatedTime() {
        return this.createdTime;
    }

    /* renamed from: component8  reason: from getter */
    public final Boolean getDirectDiscountType() {
        return this.directDiscountType;
    }

    /* renamed from: component9  reason: from getter */
    public final Long getExpiryTime() {
        return this.expiryTime;
    }

    public final VoucherCashierInfo copy(Long activeTime, MoneyView availableAmount, CouponInfo couponAbility, String couponId, String couponName, List<? extends CouponPayMethodInfo> couponPayMethodInfos, Long createdTime, Boolean directDiscountType, Long expiryTime, Long extendTime, String iconUrl, Long modifiedTime, MoneyView totalAmount, String description, String tnc) {
        return new VoucherCashierInfo(activeTime, availableAmount, couponAbility, couponId, couponName, couponPayMethodInfos, createdTime, directDiscountType, expiryTime, extendTime, iconUrl, modifiedTime, totalAmount, description, tnc);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VoucherCashierInfo) {
            VoucherCashierInfo voucherCashierInfo = (VoucherCashierInfo) other;
            return Intrinsics.areEqual(this.activeTime, voucherCashierInfo.activeTime) && Intrinsics.areEqual(this.availableAmount, voucherCashierInfo.availableAmount) && Intrinsics.areEqual(this.couponAbility, voucherCashierInfo.couponAbility) && Intrinsics.areEqual(this.couponId, voucherCashierInfo.couponId) && Intrinsics.areEqual(this.couponName, voucherCashierInfo.couponName) && Intrinsics.areEqual(this.couponPayMethodInfos, voucherCashierInfo.couponPayMethodInfos) && Intrinsics.areEqual(this.createdTime, voucherCashierInfo.createdTime) && Intrinsics.areEqual(this.directDiscountType, voucherCashierInfo.directDiscountType) && Intrinsics.areEqual(this.expiryTime, voucherCashierInfo.expiryTime) && Intrinsics.areEqual(this.extendTime, voucherCashierInfo.extendTime) && Intrinsics.areEqual(this.iconUrl, voucherCashierInfo.iconUrl) && Intrinsics.areEqual(this.modifiedTime, voucherCashierInfo.modifiedTime) && Intrinsics.areEqual(this.totalAmount, voucherCashierInfo.totalAmount) && Intrinsics.areEqual(this.description, voucherCashierInfo.description) && Intrinsics.areEqual(this.tnc, voucherCashierInfo.tnc);
        }
        return false;
    }

    public final int hashCode() {
        Long l = this.activeTime;
        int hashCode = l == null ? 0 : l.hashCode();
        MoneyView moneyView = this.availableAmount;
        int hashCode2 = moneyView == null ? 0 : moneyView.hashCode();
        CouponInfo couponInfo = this.couponAbility;
        int hashCode3 = couponInfo == null ? 0 : couponInfo.hashCode();
        String str = this.couponId;
        int hashCode4 = str == null ? 0 : str.hashCode();
        String str2 = this.couponName;
        int hashCode5 = str2 == null ? 0 : str2.hashCode();
        List<CouponPayMethodInfo> list = this.couponPayMethodInfos;
        int hashCode6 = list == null ? 0 : list.hashCode();
        Long l2 = this.createdTime;
        int hashCode7 = l2 == null ? 0 : l2.hashCode();
        Boolean bool = this.directDiscountType;
        int hashCode8 = bool == null ? 0 : bool.hashCode();
        Long l3 = this.expiryTime;
        int hashCode9 = l3 == null ? 0 : l3.hashCode();
        Long l4 = this.extendTime;
        int hashCode10 = l4 == null ? 0 : l4.hashCode();
        String str3 = this.iconUrl;
        int hashCode11 = str3 == null ? 0 : str3.hashCode();
        Long l5 = this.modifiedTime;
        int hashCode12 = l5 == null ? 0 : l5.hashCode();
        MoneyView moneyView2 = this.totalAmount;
        int hashCode13 = moneyView2 == null ? 0 : moneyView2.hashCode();
        String str4 = this.description;
        int hashCode14 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.tnc;
        return (((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VoucherCashierInfo(activeTime=");
        sb.append(this.activeTime);
        sb.append(", availableAmount=");
        sb.append(this.availableAmount);
        sb.append(", couponAbility=");
        sb.append(this.couponAbility);
        sb.append(", couponId=");
        sb.append(this.couponId);
        sb.append(", couponName=");
        sb.append(this.couponName);
        sb.append(", couponPayMethodInfos=");
        sb.append(this.couponPayMethodInfos);
        sb.append(", createdTime=");
        sb.append(this.createdTime);
        sb.append(", directDiscountType=");
        sb.append(this.directDiscountType);
        sb.append(", expiryTime=");
        sb.append(this.expiryTime);
        sb.append(", extendTime=");
        sb.append(this.extendTime);
        sb.append(", iconUrl=");
        sb.append(this.iconUrl);
        sb.append(", modifiedTime=");
        sb.append(this.modifiedTime);
        sb.append(", totalAmount=");
        sb.append(this.totalAmount);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", tnc=");
        sb.append(this.tnc);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VoucherCashierInfo(Long l, MoneyView moneyView, CouponInfo couponInfo, String str, String str2, List<? extends CouponPayMethodInfo> list, Long l2, Boolean bool, Long l3, Long l4, String str3, Long l5, MoneyView moneyView2, String str4, String str5) {
        this.activeTime = l;
        this.availableAmount = moneyView;
        this.couponAbility = couponInfo;
        this.couponId = str;
        this.couponName = str2;
        this.couponPayMethodInfos = list;
        this.createdTime = l2;
        this.directDiscountType = bool;
        this.expiryTime = l3;
        this.extendTime = l4;
        this.iconUrl = str3;
        this.modifiedTime = l5;
        this.totalAmount = moneyView2;
        this.description = str4;
        this.tnc = str5;
    }

    public /* synthetic */ VoucherCashierInfo(Long l, MoneyView moneyView, CouponInfo couponInfo, String str, String str2, List list, Long l2, Boolean bool, Long l3, Long l4, String str3, Long l5, MoneyView moneyView2, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, moneyView, couponInfo, str, str2, list, l2, bool, l3, l4, str3, l5, moneyView2, (i & 8192) != 0 ? "" : str4, str5);
    }

    @JvmName(name = "getActiveTime")
    public final Long getActiveTime() {
        return this.activeTime;
    }

    @JvmName(name = "getAvailableAmount")
    public final MoneyView getAvailableAmount() {
        return this.availableAmount;
    }

    @JvmName(name = "getCouponAbility")
    public final CouponInfo getCouponAbility() {
        return this.couponAbility;
    }

    @JvmName(name = "getCouponId")
    public final String getCouponId() {
        return this.couponId;
    }

    @JvmName(name = "getCouponName")
    public final String getCouponName() {
        return this.couponName;
    }

    @JvmName(name = "getCouponPayMethodInfos")
    public final List<CouponPayMethodInfo> getCouponPayMethodInfos() {
        return this.couponPayMethodInfos;
    }

    @JvmName(name = "getCreatedTime")
    public final Long getCreatedTime() {
        return this.createdTime;
    }

    @JvmName(name = "getDirectDiscountType")
    public final Boolean getDirectDiscountType() {
        return this.directDiscountType;
    }

    @JvmName(name = "getExpiryTime")
    public final Long getExpiryTime() {
        return this.expiryTime;
    }

    @JvmName(name = "getExtendTime")
    public final Long getExtendTime() {
        return this.extendTime;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "getModifiedTime")
    public final Long getModifiedTime() {
        return this.modifiedTime;
    }

    @JvmName(name = "getTotalAmount")
    public final MoneyView getTotalAmount() {
        return this.totalAmount;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "setDescription")
    public final void setDescription(String str) {
        this.description = str;
    }

    @JvmName(name = "getTnc")
    public final String getTnc() {
        return this.tnc;
    }
}
