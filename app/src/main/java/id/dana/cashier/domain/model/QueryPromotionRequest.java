package id.dana.cashier.domain.model;

import id.dana.cashier.utils.CashierKeyParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b¢\u0006\u0004\b*\u0010+J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJv\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b#\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b$\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b'\u0010\u0004R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010\r"}, d2 = {"Lid/dana/cashier/domain/model/QueryPromotionRequest;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "", "component8", "()Ljava/util/List;", CashierKeyParams.CASHIER_ORDER_ID, "cardBin", "cardType", "instId", "cardScheme", "payOption", "payMethod", "selectedAddOns", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lid/dana/cashier/domain/model/QueryPromotionRequest;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCardBin", "getCardScheme", "getCardType", "getCashierOrderId", "getInstId", "getPayMethod", "getPayOption", "Ljava/util/List;", "getSelectedAddOns", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QueryPromotionRequest {
    private final String cardBin;
    private final String cardScheme;
    private final String cardType;
    private final String cashierOrderId;
    private final String instId;
    private final String payMethod;
    private final String payOption;
    private final List<String> selectedAddOns;

    /* renamed from: component1  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCardBin() {
        return this.cardBin;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCardType() {
        return this.cardType;
    }

    /* renamed from: component4  reason: from getter */
    public final String getInstId() {
        return this.instId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getCardScheme() {
        return this.cardScheme;
    }

    /* renamed from: component6  reason: from getter */
    public final String getPayOption() {
        return this.payOption;
    }

    /* renamed from: component7  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    public final List<String> component8() {
        return this.selectedAddOns;
    }

    public final QueryPromotionRequest copy(String cashierOrderId, String cardBin, String cardType, String instId, String cardScheme, String payOption, String payMethod, List<String> selectedAddOns) {
        return new QueryPromotionRequest(cashierOrderId, cardBin, cardType, instId, cardScheme, payOption, payMethod, selectedAddOns);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryPromotionRequest) {
            QueryPromotionRequest queryPromotionRequest = (QueryPromotionRequest) other;
            return Intrinsics.areEqual(this.cashierOrderId, queryPromotionRequest.cashierOrderId) && Intrinsics.areEqual(this.cardBin, queryPromotionRequest.cardBin) && Intrinsics.areEqual(this.cardType, queryPromotionRequest.cardType) && Intrinsics.areEqual(this.instId, queryPromotionRequest.instId) && Intrinsics.areEqual(this.cardScheme, queryPromotionRequest.cardScheme) && Intrinsics.areEqual(this.payOption, queryPromotionRequest.payOption) && Intrinsics.areEqual(this.payMethod, queryPromotionRequest.payMethod) && Intrinsics.areEqual(this.selectedAddOns, queryPromotionRequest.selectedAddOns);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.cashierOrderId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.cardBin;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.cardType;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.instId;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.cardScheme;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.payOption;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.payMethod;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        List<String> list = this.selectedAddOns;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryPromotionRequest(cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", cardBin=");
        sb.append(this.cardBin);
        sb.append(", cardType=");
        sb.append(this.cardType);
        sb.append(", instId=");
        sb.append(this.instId);
        sb.append(", cardScheme=");
        sb.append(this.cardScheme);
        sb.append(", payOption=");
        sb.append(this.payOption);
        sb.append(", payMethod=");
        sb.append(this.payMethod);
        sb.append(", selectedAddOns=");
        sb.append(this.selectedAddOns);
        sb.append(')');
        return sb.toString();
    }

    public QueryPromotionRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, List<String> list) {
        this.cashierOrderId = str;
        this.cardBin = str2;
        this.cardType = str3;
        this.instId = str4;
        this.cardScheme = str5;
        this.payOption = str6;
        this.payMethod = str7;
        this.selectedAddOns = list;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getCardBin")
    public final String getCardBin() {
        return this.cardBin;
    }

    @JvmName(name = "getCardType")
    public final String getCardType() {
        return this.cardType;
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "getCardScheme")
    public final String getCardScheme() {
        return this.cardScheme;
    }

    @JvmName(name = "getPayOption")
    public final String getPayOption() {
        return this.payOption;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getSelectedAddOns")
    public final List<String> getSelectedAddOns() {
        return this.selectedAddOns;
    }
}
