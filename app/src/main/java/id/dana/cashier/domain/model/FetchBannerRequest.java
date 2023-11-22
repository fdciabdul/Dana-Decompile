package id.dana.cashier.domain.model;

import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b*\u0010+J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004Jv\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b$\u0010\u0004R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b(\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b)\u0010\u0004"}, d2 = {"Lid/dana/cashier/domain/model/FetchBannerRequest;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "", "component7", "()Ljava/util/List;", "component8", CashierKeyParams.CASHIER_ORDER_ID, "transactionScenario", "bizType", TinyAppLogUtil.TINY_APP_STANDARD_EXTRA_PLATFORM, CashierKeyParams.TOTAL_AMOUNT, "merchantId", InvoiceConstant.PAYMENT_METHOD, "transType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lid/dana/cashier/domain/model/FetchBannerRequest;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizType", "getCashierOrderId", "getMerchantId", "getOrderAmount", "Ljava/util/List;", "getPaymentMethod", "getPlatform", "getTransType", "getTransactionScenario", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FetchBannerRequest {
    private final String bizType;
    private final String cashierOrderId;
    private final String merchantId;
    private final String orderAmount;
    private final List<String> paymentMethod;
    private final String platform;
    private final String transType;
    private final String transactionScenario;

    /* renamed from: component1  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getTransactionScenario() {
        return this.transactionScenario;
    }

    /* renamed from: component3  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component4  reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* renamed from: component5  reason: from getter */
    public final String getOrderAmount() {
        return this.orderAmount;
    }

    /* renamed from: component6  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    public final List<String> component7() {
        return this.paymentMethod;
    }

    /* renamed from: component8  reason: from getter */
    public final String getTransType() {
        return this.transType;
    }

    public final FetchBannerRequest copy(String cashierOrderId, String transactionScenario, String bizType, String platform, String orderAmount, String merchantId, List<String> paymentMethod, String transType) {
        return new FetchBannerRequest(cashierOrderId, transactionScenario, bizType, platform, orderAmount, merchantId, paymentMethod, transType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FetchBannerRequest) {
            FetchBannerRequest fetchBannerRequest = (FetchBannerRequest) other;
            return Intrinsics.areEqual(this.cashierOrderId, fetchBannerRequest.cashierOrderId) && Intrinsics.areEqual(this.transactionScenario, fetchBannerRequest.transactionScenario) && Intrinsics.areEqual(this.bizType, fetchBannerRequest.bizType) && Intrinsics.areEqual(this.platform, fetchBannerRequest.platform) && Intrinsics.areEqual(this.orderAmount, fetchBannerRequest.orderAmount) && Intrinsics.areEqual(this.merchantId, fetchBannerRequest.merchantId) && Intrinsics.areEqual(this.paymentMethod, fetchBannerRequest.paymentMethod) && Intrinsics.areEqual(this.transType, fetchBannerRequest.transType);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.cashierOrderId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.transactionScenario;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.bizType;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.platform;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.orderAmount;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.merchantId;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        List<String> list = this.paymentMethod;
        int hashCode7 = list == null ? 0 : list.hashCode();
        String str7 = this.transType;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + (str7 != null ? str7.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FetchBannerRequest(cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", transactionScenario=");
        sb.append(this.transactionScenario);
        sb.append(", bizType=");
        sb.append(this.bizType);
        sb.append(", platform=");
        sb.append(this.platform);
        sb.append(", orderAmount=");
        sb.append(this.orderAmount);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", paymentMethod=");
        sb.append(this.paymentMethod);
        sb.append(", transType=");
        sb.append(this.transType);
        sb.append(')');
        return sb.toString();
    }

    public FetchBannerRequest(String str, String str2, String str3, String str4, String str5, String str6, List<String> list, String str7) {
        this.cashierOrderId = str;
        this.transactionScenario = str2;
        this.bizType = str3;
        this.platform = str4;
        this.orderAmount = str5;
        this.merchantId = str6;
        this.paymentMethod = list;
        this.transType = str7;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getTransactionScenario")
    public final String getTransactionScenario() {
        return this.transactionScenario;
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "getPlatform")
    public final String getPlatform() {
        return this.platform;
    }

    @JvmName(name = "getOrderAmount")
    public final String getOrderAmount() {
        return this.orderAmount;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    public /* synthetic */ FetchBannerRequest(String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? CollectionsKt.emptyList() : list, (i & 128) == 0 ? str7 : "");
    }

    @JvmName(name = "getPaymentMethod")
    public final List<String> getPaymentMethod() {
        return this.paymentMethod;
    }

    @JvmName(name = "getTransType")
    public final String getTransType() {
        return this.transType;
    }
}
