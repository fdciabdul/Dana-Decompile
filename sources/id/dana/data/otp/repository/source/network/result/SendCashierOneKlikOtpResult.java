package id.dana.data.otp.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J4\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0007R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001b\u0010\u0007"}, d2 = {"Lid/dana/data/otp/repository/source/network/result/SendCashierOneKlikOtpResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "Lid/dana/data/otp/repository/source/network/result/AttributeOneKlikOtpResult;", "component1", "()Lid/dana/data/otp/repository/source/network/result/AttributeOneKlikOtpResult;", "", "component2", "()Ljava/lang/String;", "component3", "attributes", CashierKeyParams.CASHIER_ORDER_ID, "location", "copy", "(Lid/dana/data/otp/repository/source/network/result/AttributeOneKlikOtpResult;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/otp/repository/source/network/result/SendCashierOneKlikOtpResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/data/otp/repository/source/network/result/AttributeOneKlikOtpResult;", "getAttributes", "Ljava/lang/String;", "getCashierOrderId", "getLocation", "<init>", "(Lid/dana/data/otp/repository/source/network/result/AttributeOneKlikOtpResult;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SendCashierOneKlikOtpResult extends BaseRpcResultAphome {
    private final AttributeOneKlikOtpResult attributes;
    @SerializedName(CashierKeyParams.CASHIER_ORDER_ID)
    private final String cashierOrderId;
    private final String location;

    public static /* synthetic */ SendCashierOneKlikOtpResult copy$default(SendCashierOneKlikOtpResult sendCashierOneKlikOtpResult, AttributeOneKlikOtpResult attributeOneKlikOtpResult, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            attributeOneKlikOtpResult = sendCashierOneKlikOtpResult.attributes;
        }
        if ((i & 2) != 0) {
            str = sendCashierOneKlikOtpResult.cashierOrderId;
        }
        if ((i & 4) != 0) {
            str2 = sendCashierOneKlikOtpResult.location;
        }
        return sendCashierOneKlikOtpResult.copy(attributeOneKlikOtpResult, str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final AttributeOneKlikOtpResult getAttributes() {
        return this.attributes;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    public final SendCashierOneKlikOtpResult copy(AttributeOneKlikOtpResult attributes, String cashierOrderId, String location) {
        return new SendCashierOneKlikOtpResult(attributes, cashierOrderId, location);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SendCashierOneKlikOtpResult) {
            SendCashierOneKlikOtpResult sendCashierOneKlikOtpResult = (SendCashierOneKlikOtpResult) other;
            return Intrinsics.areEqual(this.attributes, sendCashierOneKlikOtpResult.attributes) && Intrinsics.areEqual(this.cashierOrderId, sendCashierOneKlikOtpResult.cashierOrderId) && Intrinsics.areEqual(this.location, sendCashierOneKlikOtpResult.location);
        }
        return false;
    }

    public final int hashCode() {
        AttributeOneKlikOtpResult attributeOneKlikOtpResult = this.attributes;
        int hashCode = attributeOneKlikOtpResult == null ? 0 : attributeOneKlikOtpResult.hashCode();
        String str = this.cashierOrderId;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.location;
        return (((hashCode * 31) + hashCode2) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SendCashierOneKlikOtpResult(attributes=");
        sb.append(this.attributes);
        sb.append(", cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", location=");
        sb.append(this.location);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getAttributes")
    public final AttributeOneKlikOtpResult getAttributes() {
        return this.attributes;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getLocation")
    public final String getLocation() {
        return this.location;
    }

    public SendCashierOneKlikOtpResult(AttributeOneKlikOtpResult attributeOneKlikOtpResult, String str, String str2) {
        this.attributes = attributeOneKlikOtpResult;
        this.cashierOrderId = str;
        this.location = str2;
    }
}
