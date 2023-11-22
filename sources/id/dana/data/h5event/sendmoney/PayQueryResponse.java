package id.dana.data.h5event.sendmoney;

import com.alibaba.fastjson.annotation.JSONCreator;
import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B]\b\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b)\u0010*J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004Jd\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0007¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b \u0010\fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b(\u0010\u0007"}, d2 = {"Lid/dana/data/h5event/sendmoney/PayQueryResponse;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Boolean;", "component3", "component4", "Lid/dana/data/h5event/sendmoney/Attributes;", "component5", "()Lid/dana/data/h5event/sendmoney/Attributes;", "component6", "component7", "redirectUrl", "success", "oauthRedirectUrl", "errorCode", "attributes", CashierKeyParams.CASHIER_ORDER_ID, "errorMsg", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/h5event/sendmoney/Attributes;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/h5event/sendmoney/PayQueryResponse;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/data/h5event/sendmoney/Attributes;", "getAttributes", "Ljava/lang/String;", "getCashierOrderId", "getErrorCode", "getErrorMsg", "getOauthRedirectUrl", "getRedirectUrl", "Ljava/lang/Boolean;", "getSuccess", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/h5event/sendmoney/Attributes;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PayQueryResponse {
    public Attributes attributes;
    public String cashierOrderId;
    public String errorCode;
    public String errorMsg;
    public String oauthRedirectUrl;
    public String redirectUrl;
    public Boolean success;

    @JSONCreator
    public PayQueryResponse() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ PayQueryResponse copy$default(PayQueryResponse payQueryResponse, String str, Boolean bool, String str2, String str3, Attributes attributes, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payQueryResponse.redirectUrl;
        }
        if ((i & 2) != 0) {
            bool = payQueryResponse.success;
        }
        Boolean bool2 = bool;
        if ((i & 4) != 0) {
            str2 = payQueryResponse.oauthRedirectUrl;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = payQueryResponse.errorCode;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            attributes = payQueryResponse.attributes;
        }
        Attributes attributes2 = attributes;
        if ((i & 32) != 0) {
            str4 = payQueryResponse.cashierOrderId;
        }
        String str8 = str4;
        if ((i & 64) != 0) {
            str5 = payQueryResponse.errorMsg;
        }
        return payQueryResponse.copy(str, bool2, str6, str7, attributes2, str8, str5);
    }

    /* renamed from: component1  reason: from getter */
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    /* renamed from: component2  reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component3  reason: from getter */
    public final String getOauthRedirectUrl() {
        return this.oauthRedirectUrl;
    }

    /* renamed from: component4  reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component5  reason: from getter */
    public final Attributes getAttributes() {
        return this.attributes;
    }

    /* renamed from: component6  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component7  reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final PayQueryResponse copy(String redirectUrl, Boolean success, String oauthRedirectUrl, String errorCode, Attributes attributes, String cashierOrderId, String errorMsg) {
        return new PayQueryResponse(redirectUrl, success, oauthRedirectUrl, errorCode, attributes, cashierOrderId, errorMsg);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PayQueryResponse) {
            PayQueryResponse payQueryResponse = (PayQueryResponse) other;
            return Intrinsics.areEqual(this.redirectUrl, payQueryResponse.redirectUrl) && Intrinsics.areEqual(this.success, payQueryResponse.success) && Intrinsics.areEqual(this.oauthRedirectUrl, payQueryResponse.oauthRedirectUrl) && Intrinsics.areEqual(this.errorCode, payQueryResponse.errorCode) && Intrinsics.areEqual(this.attributes, payQueryResponse.attributes) && Intrinsics.areEqual(this.cashierOrderId, payQueryResponse.cashierOrderId) && Intrinsics.areEqual(this.errorMsg, payQueryResponse.errorMsg);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.redirectUrl;
        int hashCode = str == null ? 0 : str.hashCode();
        Boolean bool = this.success;
        int hashCode2 = bool == null ? 0 : bool.hashCode();
        String str2 = this.oauthRedirectUrl;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.errorCode;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        Attributes attributes = this.attributes;
        int hashCode5 = attributes == null ? 0 : attributes.hashCode();
        String str4 = this.cashierOrderId;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.errorMsg;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PayQueryResponse(redirectUrl=");
        sb.append(this.redirectUrl);
        sb.append(", success=");
        sb.append(this.success);
        sb.append(", oauthRedirectUrl=");
        sb.append(this.oauthRedirectUrl);
        sb.append(", errorCode=");
        sb.append(this.errorCode);
        sb.append(", attributes=");
        sb.append(this.attributes);
        sb.append(", cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", errorMsg=");
        sb.append(this.errorMsg);
        sb.append(')');
        return sb.toString();
    }

    @JSONCreator
    public PayQueryResponse(String str, Boolean bool, String str2, String str3, Attributes attributes, String str4, String str5) {
        this.redirectUrl = str;
        this.success = bool;
        this.oauthRedirectUrl = str2;
        this.errorCode = str3;
        this.attributes = attributes;
        this.cashierOrderId = str4;
        this.errorMsg = str5;
    }

    public /* synthetic */ PayQueryResponse(String str, Boolean bool, String str2, String str3, Attributes attributes, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : attributes, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5);
    }

    @JvmName(name = "getRedirectUrl")
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @JvmName(name = "getSuccess")
    public final Boolean getSuccess() {
        return this.success;
    }

    @JvmName(name = "getOauthRedirectUrl")
    public final String getOauthRedirectUrl() {
        return this.oauthRedirectUrl;
    }

    @JvmName(name = "getErrorCode")
    public final String getErrorCode() {
        return this.errorCode;
    }

    @JvmName(name = "getAttributes")
    public final Attributes getAttributes() {
        return this.attributes;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getErrorMsg")
    public final String getErrorMsg() {
        return this.errorMsg;
    }
}
