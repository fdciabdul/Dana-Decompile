package id.dana.data.otp.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J4\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/data/otp/repository/source/network/request/SendCashierOneKlikOtpRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", CashierKeyParams.CASHIER_ORDER_ID, "validateData", "deviceId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/otp/repository/source/network/request/SendCashierOneKlikOtpRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCashierOrderId", "getDeviceId", "getValidateData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SendCashierOneKlikOtpRequest extends BaseRpcRequest {
    @SerializedName(CashierKeyParams.CASHIER_ORDER_ID)
    private final String cashierOrderId;
    private final String deviceId;
    private final String validateData;

    public static /* synthetic */ SendCashierOneKlikOtpRequest copy$default(SendCashierOneKlikOtpRequest sendCashierOneKlikOtpRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sendCashierOneKlikOtpRequest.cashierOrderId;
        }
        if ((i & 2) != 0) {
            str2 = sendCashierOneKlikOtpRequest.validateData;
        }
        if ((i & 4) != 0) {
            str3 = sendCashierOneKlikOtpRequest.deviceId;
        }
        return sendCashierOneKlikOtpRequest.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getValidateData() {
        return this.validateData;
    }

    /* renamed from: component3  reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    public final SendCashierOneKlikOtpRequest copy(String cashierOrderId, String validateData, String deviceId) {
        return new SendCashierOneKlikOtpRequest(cashierOrderId, validateData, deviceId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SendCashierOneKlikOtpRequest) {
            SendCashierOneKlikOtpRequest sendCashierOneKlikOtpRequest = (SendCashierOneKlikOtpRequest) other;
            return Intrinsics.areEqual(this.cashierOrderId, sendCashierOneKlikOtpRequest.cashierOrderId) && Intrinsics.areEqual(this.validateData, sendCashierOneKlikOtpRequest.validateData) && Intrinsics.areEqual(this.deviceId, sendCashierOneKlikOtpRequest.deviceId);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.cashierOrderId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.validateData;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.deviceId;
        return (((hashCode * 31) + hashCode2) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SendCashierOneKlikOtpRequest(cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", validateData=");
        sb.append(this.validateData);
        sb.append(", deviceId=");
        sb.append(this.deviceId);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getValidateData")
    public final String getValidateData() {
        return this.validateData;
    }

    @JvmName(name = "getDeviceId")
    public final String getDeviceId() {
        return this.deviceId;
    }

    public SendCashierOneKlikOtpRequest(String str, String str2, String str3) {
        this.cashierOrderId = str;
        this.validateData = str2;
        this.deviceId = str3;
    }
}
