package id.dana.cashier.domain.model;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b/\u00100J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J|\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\"\u0010\u0007R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\u0007R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b'\u0010\u0007R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b(\u0010\u0007R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b)\u0010\u0007R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b*\u0010\u0007R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b+\u0010\u0007R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b-\u0010\u0010R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b.\u0010\u0007"}, d2 = {"Lid/dana/cashier/domain/model/TopUpPay;", "", "Lid/dana/cashier/domain/model/Attribute;", "component1", "()Lid/dana/cashier/domain/model/Attribute;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "component7", "component8", "", "component9", "()Ljava/lang/Boolean;", "attributes", CashierKeyParams.CASHIER_ORDER_ID, "cashierRequestId", BioUtilityBridge.SECURITY_ID, "innerCardIndexNo", CashierKeyParams.TOP_UP_ORDER_ID, "errorCode", "errorMessage", "success", "copy", "(Lid/dana/cashier/domain/model/Attribute;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lid/dana/cashier/domain/model/TopUpPay;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/cashier/domain/model/Attribute;", "getAttributes", "Ljava/lang/String;", "getCashierOrderId", "getCashierRequestId", "getErrorCode", "getErrorMessage", "getInnerCardIndexNo", "getSecurityId", "Ljava/lang/Boolean;", "getSuccess", "getTopUpOrderId", "<init>", "(Lid/dana/cashier/domain/model/Attribute;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TopUpPay {
    private final Attribute attributes;
    private final String cashierOrderId;
    private final String cashierRequestId;
    private final String errorCode;
    private final String errorMessage;
    private final String innerCardIndexNo;
    private final String securityId;
    private final Boolean success;
    private final String topUpOrderId;

    /* renamed from: component1  reason: from getter */
    public final Attribute getAttributes() {
        return this.attributes;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCashierRequestId() {
        return this.cashierRequestId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getInnerCardIndexNo() {
        return this.innerCardIndexNo;
    }

    /* renamed from: component6  reason: from getter */
    public final String getTopUpOrderId() {
        return this.topUpOrderId;
    }

    /* renamed from: component7  reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component8  reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: component9  reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    public final TopUpPay copy(Attribute attributes, String cashierOrderId, String cashierRequestId, String securityId, String innerCardIndexNo, String topUpOrderId, String errorCode, String errorMessage, Boolean success) {
        return new TopUpPay(attributes, cashierOrderId, cashierRequestId, securityId, innerCardIndexNo, topUpOrderId, errorCode, errorMessage, success);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TopUpPay) {
            TopUpPay topUpPay = (TopUpPay) other;
            return Intrinsics.areEqual(this.attributes, topUpPay.attributes) && Intrinsics.areEqual(this.cashierOrderId, topUpPay.cashierOrderId) && Intrinsics.areEqual(this.cashierRequestId, topUpPay.cashierRequestId) && Intrinsics.areEqual(this.securityId, topUpPay.securityId) && Intrinsics.areEqual(this.innerCardIndexNo, topUpPay.innerCardIndexNo) && Intrinsics.areEqual(this.topUpOrderId, topUpPay.topUpOrderId) && Intrinsics.areEqual(this.errorCode, topUpPay.errorCode) && Intrinsics.areEqual(this.errorMessage, topUpPay.errorMessage) && Intrinsics.areEqual(this.success, topUpPay.success);
        }
        return false;
    }

    public final int hashCode() {
        Attribute attribute = this.attributes;
        int hashCode = attribute == null ? 0 : attribute.hashCode();
        String str = this.cashierOrderId;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.cashierRequestId;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.securityId;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.innerCardIndexNo;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.topUpOrderId;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.errorCode;
        int hashCode7 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.errorMessage;
        int hashCode8 = str7 == null ? 0 : str7.hashCode();
        Boolean bool = this.success;
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopUpPay(attributes=");
        sb.append(this.attributes);
        sb.append(", cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", cashierRequestId=");
        sb.append(this.cashierRequestId);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", innerCardIndexNo=");
        sb.append(this.innerCardIndexNo);
        sb.append(", topUpOrderId=");
        sb.append(this.topUpOrderId);
        sb.append(", errorCode=");
        sb.append(this.errorCode);
        sb.append(", errorMessage=");
        sb.append(this.errorMessage);
        sb.append(", success=");
        sb.append(this.success);
        sb.append(')');
        return sb.toString();
    }

    public TopUpPay(Attribute attribute, String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool) {
        this.attributes = attribute;
        this.cashierOrderId = str;
        this.cashierRequestId = str2;
        this.securityId = str3;
        this.innerCardIndexNo = str4;
        this.topUpOrderId = str5;
        this.errorCode = str6;
        this.errorMessage = str7;
        this.success = bool;
    }

    public /* synthetic */ TopUpPay(Attribute attribute, String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(attribute, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, bool);
    }

    @JvmName(name = "getAttributes")
    public final Attribute getAttributes() {
        return this.attributes;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getCashierRequestId")
    public final String getCashierRequestId() {
        return this.cashierRequestId;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getInnerCardIndexNo")
    public final String getInnerCardIndexNo() {
        return this.innerCardIndexNo;
    }

    @JvmName(name = "getTopUpOrderId")
    public final String getTopUpOrderId() {
        return this.topUpOrderId;
    }

    @JvmName(name = "getErrorCode")
    public final String getErrorCode() {
        return this.errorCode;
    }

    @JvmName(name = "getErrorMessage")
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @JvmName(name = "getSuccess")
    public final Boolean getSuccess() {
        return this.success;
    }
}
