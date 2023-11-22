package id.dana.cashier.data.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.constant.UrlParam;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b1\u00102J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0094\u0001\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\u0004R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b+\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010%\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b.\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b/\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b0\u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/request/TopUpVerifyEntityRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "method", "payMethod", "payOption", "cardCacheToken", CashierKeyParams.VERIFICATION_METHOD, "validateData", UrlParam.REQUEST_ID, CashierKeyParams.CASHIER_ORDER_ID, "innerCardIndexNo", CashierKeyParams.TOP_UP_ORDER_ID, BioUtilityBridge.SECURITY_ID, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/request/TopUpVerifyEntityRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCardCacheToken", "getCashierOrderId", "getInnerCardIndexNo", "getMethod", "getPayMethod", "getPayOption", "getRequestId", "getSecurityId", "getTopUpOrderId", "getValidateData", "getVerificationMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TopUpVerifyEntityRequest extends BaseRpcRequest {
    private final String cardCacheToken;
    private final String cashierOrderId;
    private final String innerCardIndexNo;
    @SerializedName("method")
    private final String method;
    private final String payMethod;
    private final String payOption;
    private final String requestId;
    private final String securityId;
    private final String topUpOrderId;
    private final String validateData;
    private final String verificationMethod;

    /* renamed from: component1  reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: component10  reason: from getter */
    public final String getTopUpOrderId() {
        return this.topUpOrderId;
    }

    /* renamed from: component11  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    /* renamed from: component3  reason: from getter */
    public final String getPayOption() {
        return this.payOption;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCardCacheToken() {
        return this.cardCacheToken;
    }

    /* renamed from: component5  reason: from getter */
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    /* renamed from: component6  reason: from getter */
    public final String getValidateData() {
        return this.validateData;
    }

    /* renamed from: component7  reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component8  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component9  reason: from getter */
    public final String getInnerCardIndexNo() {
        return this.innerCardIndexNo;
    }

    public final TopUpVerifyEntityRequest copy(String method, String payMethod, String payOption, String cardCacheToken, String verificationMethod, String validateData, String requestId, String cashierOrderId, String innerCardIndexNo, String topUpOrderId, String securityId) {
        return new TopUpVerifyEntityRequest(method, payMethod, payOption, cardCacheToken, verificationMethod, validateData, requestId, cashierOrderId, innerCardIndexNo, topUpOrderId, securityId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TopUpVerifyEntityRequest) {
            TopUpVerifyEntityRequest topUpVerifyEntityRequest = (TopUpVerifyEntityRequest) other;
            return Intrinsics.areEqual(this.method, topUpVerifyEntityRequest.method) && Intrinsics.areEqual(this.payMethod, topUpVerifyEntityRequest.payMethod) && Intrinsics.areEqual(this.payOption, topUpVerifyEntityRequest.payOption) && Intrinsics.areEqual(this.cardCacheToken, topUpVerifyEntityRequest.cardCacheToken) && Intrinsics.areEqual(this.verificationMethod, topUpVerifyEntityRequest.verificationMethod) && Intrinsics.areEqual(this.validateData, topUpVerifyEntityRequest.validateData) && Intrinsics.areEqual(this.requestId, topUpVerifyEntityRequest.requestId) && Intrinsics.areEqual(this.cashierOrderId, topUpVerifyEntityRequest.cashierOrderId) && Intrinsics.areEqual(this.innerCardIndexNo, topUpVerifyEntityRequest.innerCardIndexNo) && Intrinsics.areEqual(this.topUpOrderId, topUpVerifyEntityRequest.topUpOrderId) && Intrinsics.areEqual(this.securityId, topUpVerifyEntityRequest.securityId);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.method;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.payMethod;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.payOption;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.cardCacheToken;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.verificationMethod;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.validateData;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.requestId;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.cashierOrderId;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.innerCardIndexNo;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.topUpOrderId;
        int hashCode10 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.securityId;
        return (((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + (str11 != null ? str11.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopUpVerifyEntityRequest(method=");
        sb.append(this.method);
        sb.append(", payMethod=");
        sb.append(this.payMethod);
        sb.append(", payOption=");
        sb.append(this.payOption);
        sb.append(", cardCacheToken=");
        sb.append(this.cardCacheToken);
        sb.append(", verificationMethod=");
        sb.append(this.verificationMethod);
        sb.append(", validateData=");
        sb.append(this.validateData);
        sb.append(", requestId=");
        sb.append(this.requestId);
        sb.append(", cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", innerCardIndexNo=");
        sb.append(this.innerCardIndexNo);
        sb.append(", topUpOrderId=");
        sb.append(this.topUpOrderId);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ TopUpVerifyEntityRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "topUpVerify" : str, str2, str3, str4, str5, str6, str7, str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11);
    }

    @JvmName(name = "getMethod")
    public final String getMethod() {
        return this.method;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getPayOption")
    public final String getPayOption() {
        return this.payOption;
    }

    @JvmName(name = "getCardCacheToken")
    public final String getCardCacheToken() {
        return this.cardCacheToken;
    }

    @JvmName(name = "getVerificationMethod")
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    @JvmName(name = "getValidateData")
    public final String getValidateData() {
        return this.validateData;
    }

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getInnerCardIndexNo")
    public final String getInnerCardIndexNo() {
        return this.innerCardIndexNo;
    }

    @JvmName(name = "getTopUpOrderId")
    public final String getTopUpOrderId() {
        return this.topUpOrderId;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    public TopUpVerifyEntityRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.method = str;
        this.payMethod = str2;
        this.payOption = str3;
        this.cardCacheToken = str4;
        this.verificationMethod = str5;
        this.validateData = str6;
        this.requestId = str7;
        this.cashierOrderId = str8;
        this.innerCardIndexNo = str9;
        this.topUpOrderId = str10;
        this.securityId = str11;
    }
}
