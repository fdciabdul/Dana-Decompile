package id.dana.cashier.data.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J@\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/request/TopUpConsultEntityRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "payMethodFilter", CashierKeyParams.CASHIER_ORDER_ID, "payMethod", "payOption", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/request/TopUpConsultEntityRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCashierOrderId", "getPayMethod", "getPayMethodFilter", "getPayOption", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TopUpConsultEntityRequest extends BaseRpcRequest {
    private final String cashierOrderId;
    private final String payMethod;
    @SerializedName("payMethodFilter")
    private final String payMethodFilter;
    private final String payOption;

    public static /* synthetic */ TopUpConsultEntityRequest copy$default(TopUpConsultEntityRequest topUpConsultEntityRequest, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = topUpConsultEntityRequest.payMethodFilter;
        }
        if ((i & 2) != 0) {
            str2 = topUpConsultEntityRequest.cashierOrderId;
        }
        if ((i & 4) != 0) {
            str3 = topUpConsultEntityRequest.payMethod;
        }
        if ((i & 8) != 0) {
            str4 = topUpConsultEntityRequest.payOption;
        }
        return topUpConsultEntityRequest.copy(str, str2, str3, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPayMethodFilter() {
        return this.payMethodFilter;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    /* renamed from: component4  reason: from getter */
    public final String getPayOption() {
        return this.payOption;
    }

    public final TopUpConsultEntityRequest copy(String payMethodFilter, String cashierOrderId, String payMethod, String payOption) {
        return new TopUpConsultEntityRequest(payMethodFilter, cashierOrderId, payMethod, payOption);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TopUpConsultEntityRequest) {
            TopUpConsultEntityRequest topUpConsultEntityRequest = (TopUpConsultEntityRequest) other;
            return Intrinsics.areEqual(this.payMethodFilter, topUpConsultEntityRequest.payMethodFilter) && Intrinsics.areEqual(this.cashierOrderId, topUpConsultEntityRequest.cashierOrderId) && Intrinsics.areEqual(this.payMethod, topUpConsultEntityRequest.payMethod) && Intrinsics.areEqual(this.payOption, topUpConsultEntityRequest.payOption);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.payMethodFilter;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.cashierOrderId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.payMethod;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.payOption;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopUpConsultEntityRequest(payMethodFilter=");
        sb.append(this.payMethodFilter);
        sb.append(", cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", payMethod=");
        sb.append(this.payMethod);
        sb.append(", payOption=");
        sb.append(this.payOption);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ TopUpConsultEntityRequest(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    @JvmName(name = "getPayMethodFilter")
    public final String getPayMethodFilter() {
        return this.payMethodFilter;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getPayOption")
    public final String getPayOption() {
        return this.payOption;
    }

    public TopUpConsultEntityRequest(String str, String str2, String str3, String str4) {
        this.payMethodFilter = str;
        this.cashierOrderId = str2;
        this.payMethod = str3;
        this.payOption = str4;
    }
}
