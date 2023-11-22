package id.dana.domain.merchantmanagement.model;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004Jf\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004R\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004\"\u0004\b \u0010!R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\"\u0010\u0004\"\u0004\b#\u0010!R\"\u0010\u000e\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b$\u0010\u0004\"\u0004\b%\u0010!R\"\u0010\u0010\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b&\u0010\u0004\"\u0004\b'\u0010!R\"\u0010\r\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001e\u001a\u0004\b(\u0010\u0004\"\u0004\b)\u0010!R\"\u0010\u0011\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b*\u0010\u0004\"\u0004\b+\u0010!R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b,\u0010\u0004\"\u0004\b-\u0010!R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b.\u0010\u0004\"\u0004\b/\u0010!"}, d2 = {"Lid/dana/domain/merchantmanagement/model/UnbindMerchantParam;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "clientId", RecordError.KEY_PUB_KEY, "merchantId", "divisionId", "pin", BioUtilityBridge.SECURITY_ID, "unbindEligibilityCheckId", "userBoundId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/merchantmanagement/model/UnbindMerchantParam;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getClientId", "setClientId", "(Ljava/lang/String;)V", "getDivisionId", "setDivisionId", "getMerchantId", "setMerchantId", "getPin", "setPin", "getPubKey", "setPubKey", "getSecurityId", "setSecurityId", "getUnbindEligibilityCheckId", "setUnbindEligibilityCheckId", "getUserBoundId", "setUserBoundId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UnbindMerchantParam {
    private String clientId;
    private String divisionId;
    private String merchantId;
    private String pin;
    private String pubKey;
    private String securityId;
    private String unbindEligibilityCheckId;
    private String userBoundId;

    /* renamed from: component1  reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getPubKey() {
        return this.pubKey;
    }

    /* renamed from: component3  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getDivisionId() {
        return this.divisionId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getPin() {
        return this.pin;
    }

    /* renamed from: component6  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component7  reason: from getter */
    public final String getUnbindEligibilityCheckId() {
        return this.unbindEligibilityCheckId;
    }

    /* renamed from: component8  reason: from getter */
    public final String getUserBoundId() {
        return this.userBoundId;
    }

    public final UnbindMerchantParam copy(String clientId, String pubKey, String merchantId, String divisionId, String pin, String securityId, String unbindEligibilityCheckId, String userBoundId) {
        Intrinsics.checkNotNullParameter(clientId, "");
        Intrinsics.checkNotNullParameter(pubKey, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(pin, "");
        Intrinsics.checkNotNullParameter(securityId, "");
        return new UnbindMerchantParam(clientId, pubKey, merchantId, divisionId, pin, securityId, unbindEligibilityCheckId, userBoundId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UnbindMerchantParam) {
            UnbindMerchantParam unbindMerchantParam = (UnbindMerchantParam) other;
            return Intrinsics.areEqual(this.clientId, unbindMerchantParam.clientId) && Intrinsics.areEqual(this.pubKey, unbindMerchantParam.pubKey) && Intrinsics.areEqual(this.merchantId, unbindMerchantParam.merchantId) && Intrinsics.areEqual(this.divisionId, unbindMerchantParam.divisionId) && Intrinsics.areEqual(this.pin, unbindMerchantParam.pin) && Intrinsics.areEqual(this.securityId, unbindMerchantParam.securityId) && Intrinsics.areEqual(this.unbindEligibilityCheckId, unbindMerchantParam.unbindEligibilityCheckId) && Intrinsics.areEqual(this.userBoundId, unbindMerchantParam.userBoundId);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.clientId.hashCode();
        int hashCode2 = this.pubKey.hashCode();
        int hashCode3 = this.merchantId.hashCode();
        String str = this.divisionId;
        int hashCode4 = str == null ? 0 : str.hashCode();
        int hashCode5 = this.pin.hashCode();
        int hashCode6 = this.securityId.hashCode();
        String str2 = this.unbindEligibilityCheckId;
        int hashCode7 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.userBoundId;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UnbindMerchantParam(clientId=");
        sb.append(this.clientId);
        sb.append(", pubKey=");
        sb.append(this.pubKey);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", divisionId=");
        sb.append(this.divisionId);
        sb.append(", pin=");
        sb.append(this.pin);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", unbindEligibilityCheckId=");
        sb.append(this.unbindEligibilityCheckId);
        sb.append(", userBoundId=");
        sb.append(this.userBoundId);
        sb.append(')');
        return sb.toString();
    }

    public UnbindMerchantParam(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.clientId = str;
        this.pubKey = str2;
        this.merchantId = str3;
        this.divisionId = str4;
        this.pin = str5;
        this.securityId = str6;
        this.unbindEligibilityCheckId = str7;
        this.userBoundId = str8;
    }

    @JvmName(name = "getClientId")
    public final String getClientId() {
        return this.clientId;
    }

    @JvmName(name = "setClientId")
    public final void setClientId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.clientId = str;
    }

    @JvmName(name = "getPubKey")
    public final String getPubKey() {
        return this.pubKey;
    }

    @JvmName(name = "setPubKey")
    public final void setPubKey(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pubKey = str;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "setMerchantId")
    public final void setMerchantId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.merchantId = str;
    }

    @JvmName(name = "getDivisionId")
    public final String getDivisionId() {
        return this.divisionId;
    }

    @JvmName(name = "setDivisionId")
    public final void setDivisionId(String str) {
        this.divisionId = str;
    }

    @JvmName(name = "getPin")
    public final String getPin() {
        return this.pin;
    }

    @JvmName(name = "setPin")
    public final void setPin(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pin = str;
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

    @JvmName(name = "getUnbindEligibilityCheckId")
    public final String getUnbindEligibilityCheckId() {
        return this.unbindEligibilityCheckId;
    }

    @JvmName(name = "setUnbindEligibilityCheckId")
    public final void setUnbindEligibilityCheckId(String str) {
        this.unbindEligibilityCheckId = str;
    }

    @JvmName(name = "getUserBoundId")
    public final String getUserBoundId() {
        return this.userBoundId;
    }

    @JvmName(name = "setUserBoundId")
    public final void setUserBoundId(String str) {
        this.userBoundId = str;
    }
}
