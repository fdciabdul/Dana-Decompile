package id.dana.kyb.data.repository.source.network.result;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b%\u0010&J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004Jd\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b \u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b!\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b$\u0010\u0004"}, d2 = {"Lid/dana/kyb/data/repository/source/network/result/PaymentOrderCpmResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "merchantTransId", "acquirementId", CashierKeyParams.TOTAL_AMOUNT, "createdTime", "closeReason", "virtualAccountInfo", "paidTime", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/kyb/data/repository/source/network/result/PaymentOrderCpmResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAcquirementId", "getCloseReason", "getCreatedTime", "getMerchantTransId", "getOrderAmount", "getPaidTime", "getVirtualAccountInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentOrderCpmResult extends BaseRpcResultAphome {
    private final String acquirementId;
    private final String closeReason;
    private final String createdTime;
    private final String merchantTransId;
    private final String orderAmount;
    private final String paidTime;
    private final String virtualAccountInfo;

    public PaymentOrderCpmResult() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ PaymentOrderCpmResult copy$default(PaymentOrderCpmResult paymentOrderCpmResult, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paymentOrderCpmResult.merchantTransId;
        }
        if ((i & 2) != 0) {
            str2 = paymentOrderCpmResult.acquirementId;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = paymentOrderCpmResult.orderAmount;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = paymentOrderCpmResult.createdTime;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = paymentOrderCpmResult.closeReason;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = paymentOrderCpmResult.virtualAccountInfo;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = paymentOrderCpmResult.paidTime;
        }
        return paymentOrderCpmResult.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMerchantTransId() {
        return this.merchantTransId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAcquirementId() {
        return this.acquirementId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getOrderAmount() {
        return this.orderAmount;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCreatedTime() {
        return this.createdTime;
    }

    /* renamed from: component5  reason: from getter */
    public final String getCloseReason() {
        return this.closeReason;
    }

    /* renamed from: component6  reason: from getter */
    public final String getVirtualAccountInfo() {
        return this.virtualAccountInfo;
    }

    /* renamed from: component7  reason: from getter */
    public final String getPaidTime() {
        return this.paidTime;
    }

    public final PaymentOrderCpmResult copy(String merchantTransId, String acquirementId, String orderAmount, String createdTime, String closeReason, String virtualAccountInfo, String paidTime) {
        return new PaymentOrderCpmResult(merchantTransId, acquirementId, orderAmount, createdTime, closeReason, virtualAccountInfo, paidTime);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PaymentOrderCpmResult) {
            PaymentOrderCpmResult paymentOrderCpmResult = (PaymentOrderCpmResult) other;
            return Intrinsics.areEqual(this.merchantTransId, paymentOrderCpmResult.merchantTransId) && Intrinsics.areEqual(this.acquirementId, paymentOrderCpmResult.acquirementId) && Intrinsics.areEqual(this.orderAmount, paymentOrderCpmResult.orderAmount) && Intrinsics.areEqual(this.createdTime, paymentOrderCpmResult.createdTime) && Intrinsics.areEqual(this.closeReason, paymentOrderCpmResult.closeReason) && Intrinsics.areEqual(this.virtualAccountInfo, paymentOrderCpmResult.virtualAccountInfo) && Intrinsics.areEqual(this.paidTime, paymentOrderCpmResult.paidTime);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.merchantTransId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.acquirementId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.orderAmount;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.createdTime;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.closeReason;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.virtualAccountInfo;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.paidTime;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (str7 != null ? str7.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaymentOrderCpmResult(merchantTransId=");
        sb.append(this.merchantTransId);
        sb.append(", acquirementId=");
        sb.append(this.acquirementId);
        sb.append(", orderAmount=");
        sb.append(this.orderAmount);
        sb.append(", createdTime=");
        sb.append(this.createdTime);
        sb.append(", closeReason=");
        sb.append(this.closeReason);
        sb.append(", virtualAccountInfo=");
        sb.append(this.virtualAccountInfo);
        sb.append(", paidTime=");
        sb.append(this.paidTime);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ PaymentOrderCpmResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7);
    }

    @JvmName(name = "getMerchantTransId")
    public final String getMerchantTransId() {
        return this.merchantTransId;
    }

    @JvmName(name = "getAcquirementId")
    public final String getAcquirementId() {
        return this.acquirementId;
    }

    @JvmName(name = "getOrderAmount")
    public final String getOrderAmount() {
        return this.orderAmount;
    }

    @JvmName(name = "getCreatedTime")
    public final String getCreatedTime() {
        return this.createdTime;
    }

    @JvmName(name = "getCloseReason")
    public final String getCloseReason() {
        return this.closeReason;
    }

    @JvmName(name = "getVirtualAccountInfo")
    public final String getVirtualAccountInfo() {
        return this.virtualAccountInfo;
    }

    @JvmName(name = "getPaidTime")
    public final String getPaidTime() {
        return this.paidTime;
    }

    public PaymentOrderCpmResult(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.merchantTransId = str;
        this.acquirementId = str2;
        this.orderAmount = str3;
        this.createdTime = str4;
        this.closeReason = str5;
        this.virtualAccountInfo = str6;
        this.paidTime = str7;
    }
}
