package id.dana.domain.carrieridentification.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0003\u0010\n\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0003\u0010\f\u001a\u00020\u0002\u0012\b\b\u0003\u0010\r\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004JL\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\n\u001a\u00020\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u00022\b\b\u0003\u0010\f\u001a\u00020\u00022\b\b\u0003\u0010\r\u001a\u00020\u00022\b\b\u0003\u0010\u000e\u001a\u00020\u00022\b\b\u0003\u0010\u000f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b \u0010\u0004"}, d2 = {"Lid/dana/domain/carrieridentification/model/VerifySecurityProduct;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "token", BioUtilityBridge.SECURITY_ID, CashierKeyParams.VERIFICATION_METHOD, "validateData", "sendOtpStrategy", "phoneNumber", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/carrieridentification/model/VerifySecurityProduct;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getPhoneNumber", "getSecurityId", "getSendOtpStrategy", "getToken", "getValidateData", "getVerificationMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class VerifySecurityProduct {
    @SerializedName("phoneNumber")
    private final String phoneNumber;
    @SerializedName(BioUtilityBridge.SECURITY_ID)
    private final String securityId;
    @SerializedName("sendOtpStrategy")
    private final String sendOtpStrategy;
    @SerializedName("token")
    private final String token;
    @SerializedName("validateData")
    private final String validateData;
    @SerializedName(CashierKeyParams.VERIFICATION_METHOD)
    private final String verificationMethod;

    public static /* synthetic */ VerifySecurityProduct copy$default(VerifySecurityProduct verifySecurityProduct, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = verifySecurityProduct.token;
        }
        if ((i & 2) != 0) {
            str2 = verifySecurityProduct.securityId;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = verifySecurityProduct.verificationMethod;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = verifySecurityProduct.validateData;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = verifySecurityProduct.sendOtpStrategy;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = verifySecurityProduct.phoneNumber;
        }
        return verifySecurityProduct.copy(str, str7, str8, str9, str10, str6);
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
    public final String getSendOtpStrategy() {
        return this.sendOtpStrategy;
    }

    /* renamed from: component6  reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final VerifySecurityProduct copy(@JSONField(name = "token") String token, @JSONField(name = "securityId") String securityId, @JSONField(name = "verificationMethod") String verificationMethod, @JSONField(name = "validateData") String validateData, @JSONField(name = "sendOtpStrategy") String sendOtpStrategy, @JSONField(name = "phoneNumber") String phoneNumber) {
        Intrinsics.checkNotNullParameter(token, "");
        Intrinsics.checkNotNullParameter(securityId, "");
        Intrinsics.checkNotNullParameter(verificationMethod, "");
        Intrinsics.checkNotNullParameter(validateData, "");
        Intrinsics.checkNotNullParameter(sendOtpStrategy, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        return new VerifySecurityProduct(token, securityId, verificationMethod, validateData, sendOtpStrategy, phoneNumber);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VerifySecurityProduct) {
            VerifySecurityProduct verifySecurityProduct = (VerifySecurityProduct) other;
            return Intrinsics.areEqual(this.token, verifySecurityProduct.token) && Intrinsics.areEqual(this.securityId, verifySecurityProduct.securityId) && Intrinsics.areEqual(this.verificationMethod, verifySecurityProduct.verificationMethod) && Intrinsics.areEqual(this.validateData, verifySecurityProduct.validateData) && Intrinsics.areEqual(this.sendOtpStrategy, verifySecurityProduct.sendOtpStrategy) && Intrinsics.areEqual(this.phoneNumber, verifySecurityProduct.phoneNumber);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((this.token.hashCode() * 31) + this.securityId.hashCode()) * 31) + this.verificationMethod.hashCode()) * 31) + this.validateData.hashCode()) * 31) + this.sendOtpStrategy.hashCode()) * 31) + this.phoneNumber.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerifySecurityProduct(token=");
        sb.append(this.token);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", verificationMethod=");
        sb.append(this.verificationMethod);
        sb.append(", validateData=");
        sb.append(this.validateData);
        sb.append(", sendOtpStrategy=");
        sb.append(this.sendOtpStrategy);
        sb.append(", phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(')');
        return sb.toString();
    }

    public VerifySecurityProduct(@JSONField(name = "token") String str, @JSONField(name = "securityId") String str2, @JSONField(name = "verificationMethod") String str3, @JSONField(name = "validateData") String str4, @JSONField(name = "sendOtpStrategy") String str5, @JSONField(name = "phoneNumber") String str6) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.token = str;
        this.securityId = str2;
        this.verificationMethod = str3;
        this.validateData = str4;
        this.sendOtpStrategy = str5;
        this.phoneNumber = str6;
    }

    public /* synthetic */ VerifySecurityProduct(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, str6);
    }

    @JvmName(name = "getToken")
    public final String getToken() {
        return this.token;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getVerificationMethod")
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    @JvmName(name = "getValidateData")
    public final String getValidateData() {
        return this.validateData;
    }

    @JvmName(name = "getSendOtpStrategy")
    public final String getSendOtpStrategy() {
        return this.sendOtpStrategy;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }
}
