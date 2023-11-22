package id.dana.data.carrieridentification.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.login.source.network.result.NetworkUrlRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0003\u0010\r\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004Jj\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\r\u001a\u00020\u00022\b\b\u0003\u0010\u000e\u001a\u00020\u00022\b\b\u0003\u0010\u000f\u001a\u00020\u00022\b\b\u0003\u0010\u0010\u001a\u00020\u00022\b\b\u0003\u0010\u0011\u001a\u00020\u00022\b\b\u0003\u0010\u0012\u001a\u00020\u00022\b\b\u0003\u0010\u0013\u001a\u00020\u00022\b\b\u0003\u0010\u0014\u001a\u00020\u00022\b\b\u0003\u0010\u0015\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004R\"\u0010\u0014\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\u0004\"\u0004\b#\u0010$R\"\u0010\u0015\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010!\u001a\u0004\b%\u0010\u0004\"\u0004\b&\u0010$R\"\u0010\u000e\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010!\u001a\u0004\b'\u0010\u0004\"\u0004\b(\u0010$R\"\u0010\u0012\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010!\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010$R\"\u0010\u0011\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010!\u001a\u0004\b+\u0010\u0004\"\u0004\b,\u0010$R\"\u0010\r\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010!\u001a\u0004\b-\u0010\u0004\"\u0004\b.\u0010$R\"\u0010\u0013\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010!\u001a\u0004\b/\u0010\u0004\"\u0004\b0\u0010$R\"\u0010\u0010\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010!\u001a\u0004\b1\u0010\u0004\"\u0004\b2\u0010$R\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010!\u001a\u0004\b3\u0010\u0004\"\u0004\b4\u0010$"}, d2 = {"Lid/dana/data/carrieridentification/model/VerifySecurityProductRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "token", BioUtilityBridge.SECURITY_ID, CashierKeyParams.VERIFICATION_METHOD, "validateData", "sendStrategy", "sendOtpStrategy", "userIdType", NetworkUrlRpcResult.ParamsName.CORRELATION_ID, "phoneNumber", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/carrieridentification/model/VerifySecurityProductRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCorrelationId", "setCorrelationId", "(Ljava/lang/String;)V", "getPhoneNumber", "setPhoneNumber", "getSecurityId", "setSecurityId", "getSendOtpStrategy", "setSendOtpStrategy", "getSendStrategy", "setSendStrategy", "getToken", "setToken", "getUserIdType", "setUserIdType", "getValidateData", "setValidateData", "getVerificationMethod", "setVerificationMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class VerifySecurityProductRequest extends BaseRpcRequest {
    @SerializedName(NetworkUrlRpcResult.ParamsName.CORRELATION_ID)
    private String correlationId;
    @SerializedName("phoneNumber")
    private String phoneNumber;
    @SerializedName(BioUtilityBridge.SECURITY_ID)
    private String securityId;
    @SerializedName("sendOtpStrategy")
    private String sendOtpStrategy;
    @SerializedName("sendStrategy")
    private String sendStrategy;
    @SerializedName("token")
    private String token;
    @SerializedName("userIdType")
    private String userIdType;
    @SerializedName("validateData")
    private String validateData;
    @SerializedName(CashierKeyParams.VERIFICATION_METHOD)
    private String verificationMethod;

    public VerifySecurityProductRequest() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    /* renamed from: component4  reason: from getter */
    public final String getValidateData() {
        return this.validateData;
    }

    /* renamed from: component5  reason: from getter */
    public final String getSendStrategy() {
        return this.sendStrategy;
    }

    /* renamed from: component6  reason: from getter */
    public final String getSendOtpStrategy() {
        return this.sendOtpStrategy;
    }

    /* renamed from: component7  reason: from getter */
    public final String getUserIdType() {
        return this.userIdType;
    }

    /* renamed from: component8  reason: from getter */
    public final String getCorrelationId() {
        return this.correlationId;
    }

    /* renamed from: component9  reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final VerifySecurityProductRequest copy(@JSONField(name = "token") String token, @JSONField(name = "securityId") String securityId, @JSONField(name = "verificationMethod") String verificationMethod, @JSONField(name = "validateData") String validateData, @JSONField(name = "sendStrategy") String sendStrategy, @JSONField(name = "sendOtpStrategy") String sendOtpStrategy, @JSONField(name = "userIdType") String userIdType, @JSONField(name = "correlationId") String correlationId, @JSONField(name = "phoneNumber") String phoneNumber) {
        Intrinsics.checkNotNullParameter(token, "");
        Intrinsics.checkNotNullParameter(securityId, "");
        Intrinsics.checkNotNullParameter(verificationMethod, "");
        Intrinsics.checkNotNullParameter(validateData, "");
        Intrinsics.checkNotNullParameter(sendStrategy, "");
        Intrinsics.checkNotNullParameter(sendOtpStrategy, "");
        Intrinsics.checkNotNullParameter(userIdType, "");
        Intrinsics.checkNotNullParameter(correlationId, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        return new VerifySecurityProductRequest(token, securityId, verificationMethod, validateData, sendStrategy, sendOtpStrategy, userIdType, correlationId, phoneNumber);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VerifySecurityProductRequest) {
            VerifySecurityProductRequest verifySecurityProductRequest = (VerifySecurityProductRequest) other;
            return Intrinsics.areEqual(this.token, verifySecurityProductRequest.token) && Intrinsics.areEqual(this.securityId, verifySecurityProductRequest.securityId) && Intrinsics.areEqual(this.verificationMethod, verifySecurityProductRequest.verificationMethod) && Intrinsics.areEqual(this.validateData, verifySecurityProductRequest.validateData) && Intrinsics.areEqual(this.sendStrategy, verifySecurityProductRequest.sendStrategy) && Intrinsics.areEqual(this.sendOtpStrategy, verifySecurityProductRequest.sendOtpStrategy) && Intrinsics.areEqual(this.userIdType, verifySecurityProductRequest.userIdType) && Intrinsics.areEqual(this.correlationId, verifySecurityProductRequest.correlationId) && Intrinsics.areEqual(this.phoneNumber, verifySecurityProductRequest.phoneNumber);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((this.token.hashCode() * 31) + this.securityId.hashCode()) * 31) + this.verificationMethod.hashCode()) * 31) + this.validateData.hashCode()) * 31) + this.sendStrategy.hashCode()) * 31) + this.sendOtpStrategy.hashCode()) * 31) + this.userIdType.hashCode()) * 31) + this.correlationId.hashCode()) * 31) + this.phoneNumber.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerifySecurityProductRequest(token=");
        sb.append(this.token);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", verificationMethod=");
        sb.append(this.verificationMethod);
        sb.append(", validateData=");
        sb.append(this.validateData);
        sb.append(", sendStrategy=");
        sb.append(this.sendStrategy);
        sb.append(", sendOtpStrategy=");
        sb.append(this.sendOtpStrategy);
        sb.append(", userIdType=");
        sb.append(this.userIdType);
        sb.append(", correlationId=");
        sb.append(this.correlationId);
        sb.append(", phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ VerifySecurityProductRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) == 0 ? str9 : "");
    }

    @JvmName(name = "getToken")
    public final String getToken() {
        return this.token;
    }

    @JvmName(name = "setToken")
    public final void setToken(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.token = str;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "setSecurityId")
    public final void setSecurityId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.securityId = str;
    }

    @JvmName(name = "getVerificationMethod")
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    @JvmName(name = "setVerificationMethod")
    public final void setVerificationMethod(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.verificationMethod = str;
    }

    @JvmName(name = "getValidateData")
    public final String getValidateData() {
        return this.validateData;
    }

    @JvmName(name = "setValidateData")
    public final void setValidateData(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.validateData = str;
    }

    @JvmName(name = "getSendStrategy")
    public final String getSendStrategy() {
        return this.sendStrategy;
    }

    @JvmName(name = "setSendStrategy")
    public final void setSendStrategy(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.sendStrategy = str;
    }

    @JvmName(name = "getSendOtpStrategy")
    public final String getSendOtpStrategy() {
        return this.sendOtpStrategy;
    }

    @JvmName(name = "setSendOtpStrategy")
    public final void setSendOtpStrategy(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.sendOtpStrategy = str;
    }

    @JvmName(name = "getUserIdType")
    public final String getUserIdType() {
        return this.userIdType;
    }

    @JvmName(name = "setUserIdType")
    public final void setUserIdType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.userIdType = str;
    }

    @JvmName(name = "getCorrelationId")
    public final String getCorrelationId() {
        return this.correlationId;
    }

    @JvmName(name = "setCorrelationId")
    public final void setCorrelationId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.correlationId = str;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "setPhoneNumber")
    public final void setPhoneNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.phoneNumber = str;
    }

    public VerifySecurityProductRequest(@JSONField(name = "token") String str, @JSONField(name = "securityId") String str2, @JSONField(name = "verificationMethod") String str3, @JSONField(name = "validateData") String str4, @JSONField(name = "sendStrategy") String str5, @JSONField(name = "sendOtpStrategy") String str6, @JSONField(name = "userIdType") String str7, @JSONField(name = "correlationId") String str8, @JSONField(name = "phoneNumber") String str9) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        this.token = str;
        this.securityId = str2;
        this.verificationMethod = str3;
        this.validateData = str4;
        this.sendStrategy = str5;
        this.sendOtpStrategy = str6;
        this.userIdType = str7;
        this.correlationId = str8;
        this.phoneNumber = str9;
    }
}
