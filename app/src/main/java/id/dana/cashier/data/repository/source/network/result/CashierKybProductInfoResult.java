package id.dana.cashier.data.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\"\u0010#J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJL\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\n"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/CashierKybProductInfoResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "Lid/dana/cashier/data/repository/source/network/result/CashierKybOrderDetailResult;", "component5", "()Lid/dana/cashier/data/repository/source/network/result/CashierKybOrderDetailResult;", "bizType", DecodedScanBizInfoKey.LOGO_URL, "merchantAddress", "merchantName", InvoiceConstant.ORDER_DETAIL, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/cashier/data/repository/source/network/result/CashierKybOrderDetailResult;)Lid/dana/cashier/data/repository/source/network/result/CashierKybProductInfoResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizType", "getLogoUrl", "getMerchantAddress", "getMerchantName", "Lid/dana/cashier/data/repository/source/network/result/CashierKybOrderDetailResult;", "getOrderDetail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/cashier/data/repository/source/network/result/CashierKybOrderDetailResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierKybProductInfoResult extends BaseRpcResultAphome {
    @SerializedName("bizType")
    private final String bizType;
    private final String logoUrl;
    private final String merchantAddress;
    private final String merchantName;
    private final CashierKybOrderDetailResult orderDetail;

    public static /* synthetic */ CashierKybProductInfoResult copy$default(CashierKybProductInfoResult cashierKybProductInfoResult, String str, String str2, String str3, String str4, CashierKybOrderDetailResult cashierKybOrderDetailResult, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cashierKybProductInfoResult.bizType;
        }
        if ((i & 2) != 0) {
            str2 = cashierKybProductInfoResult.logoUrl;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = cashierKybProductInfoResult.merchantAddress;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = cashierKybProductInfoResult.merchantName;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            cashierKybOrderDetailResult = cashierKybProductInfoResult.orderDetail;
        }
        return cashierKybProductInfoResult.copy(str, str5, str6, str7, cashierKybOrderDetailResult);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component2  reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    /* renamed from: component3  reason: from getter */
    public final String getMerchantAddress() {
        return this.merchantAddress;
    }

    /* renamed from: component4  reason: from getter */
    public final String getMerchantName() {
        return this.merchantName;
    }

    /* renamed from: component5  reason: from getter */
    public final CashierKybOrderDetailResult getOrderDetail() {
        return this.orderDetail;
    }

    public final CashierKybProductInfoResult copy(String bizType, String logoUrl, String merchantAddress, String merchantName, CashierKybOrderDetailResult orderDetail) {
        return new CashierKybProductInfoResult(bizType, logoUrl, merchantAddress, merchantName, orderDetail);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierKybProductInfoResult) {
            CashierKybProductInfoResult cashierKybProductInfoResult = (CashierKybProductInfoResult) other;
            return Intrinsics.areEqual(this.bizType, cashierKybProductInfoResult.bizType) && Intrinsics.areEqual(this.logoUrl, cashierKybProductInfoResult.logoUrl) && Intrinsics.areEqual(this.merchantAddress, cashierKybProductInfoResult.merchantAddress) && Intrinsics.areEqual(this.merchantName, cashierKybProductInfoResult.merchantName) && Intrinsics.areEqual(this.orderDetail, cashierKybProductInfoResult.orderDetail);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.bizType;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.logoUrl;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.merchantAddress;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.merchantName;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        CashierKybOrderDetailResult cashierKybOrderDetailResult = this.orderDetail;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (cashierKybOrderDetailResult != null ? cashierKybOrderDetailResult.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierKybProductInfoResult(bizType=");
        sb.append(this.bizType);
        sb.append(", logoUrl=");
        sb.append(this.logoUrl);
        sb.append(", merchantAddress=");
        sb.append(this.merchantAddress);
        sb.append(", merchantName=");
        sb.append(this.merchantName);
        sb.append(", orderDetail=");
        sb.append(this.orderDetail);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "getLogoUrl")
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @JvmName(name = "getMerchantAddress")
    public final String getMerchantAddress() {
        return this.merchantAddress;
    }

    @JvmName(name = "getMerchantName")
    public final String getMerchantName() {
        return this.merchantName;
    }

    @JvmName(name = "getOrderDetail")
    public final CashierKybOrderDetailResult getOrderDetail() {
        return this.orderDetail;
    }

    public CashierKybProductInfoResult(String str, String str2, String str3, String str4, CashierKybOrderDetailResult cashierKybOrderDetailResult) {
        this.bizType = str;
        this.logoUrl = str2;
        this.merchantAddress = str3;
        this.merchantName = str4;
        this.orderDetail = cashierKybOrderDetailResult;
    }
}
