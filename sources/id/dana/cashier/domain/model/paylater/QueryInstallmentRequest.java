package id.dana.cashier.domain.model.paylater;

import id.dana.cashier.domain.model.CheckoutExternalInfo;
import id.dana.cashier.domain.model.MixPayMethod;
import id.dana.cashier.utils.CashierKeyParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012\u0012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b=\u0010>J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u009e\u0001\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00122\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00122\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010\u0004R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b-\u0010\u0004R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010.\u001a\u0004\b/\u0010\u0014R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00100\u001a\u0004\b1\u0010\rR\"\u0010\u0017\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010+\u001a\u0004\b2\u0010\u0004\"\u0004\b3\u00104R\u001c\u0010!\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00105\u001a\u0004\b6\u0010\nR\u001c\u0010 \u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00107\u001a\u0004\b8\u0010\u0007R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010+\u001a\u0004\b9\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00107\u001a\u0004\b:\u0010\u0007R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b;\u0010\u0014R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b<\u0010\u0004"}, d2 = {"Lid/dana/cashier/domain/model/paylater/QueryInstallmentRequest;", "", "", "component1", "()Ljava/lang/String;", "", "component10", "()Ljava/lang/Boolean;", "Lid/dana/cashier/domain/model/MixPayMethod;", "component11", "()Lid/dana/cashier/domain/model/MixPayMethod;", "Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "component2", "()Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "component3", "component4", "component5", "component6", "", "component7", "()Ljava/util/List;", "component8", "component9", "method", "externalInfo", CashierKeyParams.CASHIER_ORDER_ID, "channelIndex", "reloadRequest", "transType", "couponIds", "selectedAddons", "payMethod", "mixPaymentRequest", "mixPayMethod", "copy", "(Ljava/lang/String;Lid/dana/cashier/domain/model/CheckoutExternalInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/cashier/domain/model/MixPayMethod;)Lid/dana/cashier/domain/model/paylater/QueryInstallmentRequest;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCashierOrderId", "getChannelIndex", "Ljava/util/List;", "getCouponIds", "Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "getExternalInfo", "getMethod", "setMethod", "(Ljava/lang/String;)V", "Lid/dana/cashier/domain/model/MixPayMethod;", "getMixPayMethod", "Ljava/lang/Boolean;", "getMixPaymentRequest", "getPayMethod", "getReloadRequest", "getSelectedAddons", "getTransType", "<init>", "(Ljava/lang/String;Lid/dana/cashier/domain/model/CheckoutExternalInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/cashier/domain/model/MixPayMethod;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QueryInstallmentRequest {
    private final String cashierOrderId;
    private final String channelIndex;
    private final List<String> couponIds;
    private final CheckoutExternalInfo externalInfo;
    private String method;
    private final MixPayMethod mixPayMethod;
    private final Boolean mixPaymentRequest;
    private final String payMethod;
    private final Boolean reloadRequest;
    private final List<String> selectedAddons;
    private final String transType;

    /* renamed from: component1  reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: component10  reason: from getter */
    public final Boolean getMixPaymentRequest() {
        return this.mixPaymentRequest;
    }

    /* renamed from: component11  reason: from getter */
    public final MixPayMethod getMixPayMethod() {
        return this.mixPayMethod;
    }

    /* renamed from: component2  reason: from getter */
    public final CheckoutExternalInfo getExternalInfo() {
        return this.externalInfo;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getChannelIndex() {
        return this.channelIndex;
    }

    /* renamed from: component5  reason: from getter */
    public final Boolean getReloadRequest() {
        return this.reloadRequest;
    }

    /* renamed from: component6  reason: from getter */
    public final String getTransType() {
        return this.transType;
    }

    public final List<String> component7() {
        return this.couponIds;
    }

    public final List<String> component8() {
        return this.selectedAddons;
    }

    /* renamed from: component9  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    public final QueryInstallmentRequest copy(String method, CheckoutExternalInfo externalInfo, String cashierOrderId, String channelIndex, Boolean reloadRequest, String transType, List<String> couponIds, List<String> selectedAddons, String payMethod, Boolean mixPaymentRequest, MixPayMethod mixPayMethod) {
        Intrinsics.checkNotNullParameter(method, "");
        return new QueryInstallmentRequest(method, externalInfo, cashierOrderId, channelIndex, reloadRequest, transType, couponIds, selectedAddons, payMethod, mixPaymentRequest, mixPayMethod);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryInstallmentRequest) {
            QueryInstallmentRequest queryInstallmentRequest = (QueryInstallmentRequest) other;
            return Intrinsics.areEqual(this.method, queryInstallmentRequest.method) && Intrinsics.areEqual(this.externalInfo, queryInstallmentRequest.externalInfo) && Intrinsics.areEqual(this.cashierOrderId, queryInstallmentRequest.cashierOrderId) && Intrinsics.areEqual(this.channelIndex, queryInstallmentRequest.channelIndex) && Intrinsics.areEqual(this.reloadRequest, queryInstallmentRequest.reloadRequest) && Intrinsics.areEqual(this.transType, queryInstallmentRequest.transType) && Intrinsics.areEqual(this.couponIds, queryInstallmentRequest.couponIds) && Intrinsics.areEqual(this.selectedAddons, queryInstallmentRequest.selectedAddons) && Intrinsics.areEqual(this.payMethod, queryInstallmentRequest.payMethod) && Intrinsics.areEqual(this.mixPaymentRequest, queryInstallmentRequest.mixPaymentRequest) && Intrinsics.areEqual(this.mixPayMethod, queryInstallmentRequest.mixPayMethod);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.method.hashCode();
        CheckoutExternalInfo checkoutExternalInfo = this.externalInfo;
        int hashCode2 = checkoutExternalInfo == null ? 0 : checkoutExternalInfo.hashCode();
        String str = this.cashierOrderId;
        int hashCode3 = str == null ? 0 : str.hashCode();
        String str2 = this.channelIndex;
        int hashCode4 = str2 == null ? 0 : str2.hashCode();
        Boolean bool = this.reloadRequest;
        int hashCode5 = bool == null ? 0 : bool.hashCode();
        String str3 = this.transType;
        int hashCode6 = str3 == null ? 0 : str3.hashCode();
        List<String> list = this.couponIds;
        int hashCode7 = list == null ? 0 : list.hashCode();
        List<String> list2 = this.selectedAddons;
        int hashCode8 = list2 == null ? 0 : list2.hashCode();
        String str4 = this.payMethod;
        int hashCode9 = str4 == null ? 0 : str4.hashCode();
        Boolean bool2 = this.mixPaymentRequest;
        int hashCode10 = bool2 == null ? 0 : bool2.hashCode();
        MixPayMethod mixPayMethod = this.mixPayMethod;
        return (((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + (mixPayMethod != null ? mixPayMethod.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryInstallmentRequest(method=");
        sb.append(this.method);
        sb.append(", externalInfo=");
        sb.append(this.externalInfo);
        sb.append(", cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", channelIndex=");
        sb.append(this.channelIndex);
        sb.append(", reloadRequest=");
        sb.append(this.reloadRequest);
        sb.append(", transType=");
        sb.append(this.transType);
        sb.append(", couponIds=");
        sb.append(this.couponIds);
        sb.append(", selectedAddons=");
        sb.append(this.selectedAddons);
        sb.append(", payMethod=");
        sb.append(this.payMethod);
        sb.append(", mixPaymentRequest=");
        sb.append(this.mixPaymentRequest);
        sb.append(", mixPayMethod=");
        sb.append(this.mixPayMethod);
        sb.append(')');
        return sb.toString();
    }

    public QueryInstallmentRequest(String str, CheckoutExternalInfo checkoutExternalInfo, String str2, String str3, Boolean bool, String str4, List<String> list, List<String> list2, String str5, Boolean bool2, MixPayMethod mixPayMethod) {
        Intrinsics.checkNotNullParameter(str, "");
        this.method = str;
        this.externalInfo = checkoutExternalInfo;
        this.cashierOrderId = str2;
        this.channelIndex = str3;
        this.reloadRequest = bool;
        this.transType = str4;
        this.couponIds = list;
        this.selectedAddons = list2;
        this.payMethod = str5;
        this.mixPaymentRequest = bool2;
        this.mixPayMethod = mixPayMethod;
    }

    @JvmName(name = "getMethod")
    public final String getMethod() {
        return this.method;
    }

    @JvmName(name = "setMethod")
    public final void setMethod(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.method = str;
    }

    @JvmName(name = "getExternalInfo")
    public final CheckoutExternalInfo getExternalInfo() {
        return this.externalInfo;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getChannelIndex")
    public final String getChannelIndex() {
        return this.channelIndex;
    }

    public /* synthetic */ QueryInstallmentRequest(String str, CheckoutExternalInfo checkoutExternalInfo, String str2, String str3, Boolean bool, String str4, List list, List list2, String str5, Boolean bool2, MixPayMethod mixPayMethod, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : checkoutExternalInfo, str2, str3, (i & 16) != 0 ? Boolean.FALSE : bool, str4, list, list2, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : bool2, (i & 1024) != 0 ? null : mixPayMethod);
    }

    @JvmName(name = "getReloadRequest")
    public final Boolean getReloadRequest() {
        return this.reloadRequest;
    }

    @JvmName(name = "getTransType")
    public final String getTransType() {
        return this.transType;
    }

    @JvmName(name = "getCouponIds")
    public final List<String> getCouponIds() {
        return this.couponIds;
    }

    @JvmName(name = "getSelectedAddons")
    public final List<String> getSelectedAddons() {
        return this.selectedAddons;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getMixPaymentRequest")
    public final Boolean getMixPaymentRequest() {
        return this.mixPaymentRequest;
    }

    @JvmName(name = "getMixPayMethod")
    public final MixPayMethod getMixPayMethod() {
        return this.mixPayMethod;
    }
}
