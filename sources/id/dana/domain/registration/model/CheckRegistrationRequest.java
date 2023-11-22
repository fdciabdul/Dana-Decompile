package id.dana.domain.registration.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b3\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJb\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004R\"\u0010\u0011\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010 \u001a\u0004\b!\u0010\u0004\"\u0004\b\"\u0010#R$\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010$\u001a\u0004\b\u0015\u0010\r\"\u0004\b%\u0010&R\"\u0010\u0016\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010'\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b(\u0010)R\"\u0010\u0014\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010'\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b*\u0010)R\"\u0010\u0012\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010 \u001a\u0004\b+\u0010\u0004\"\u0004\b,\u0010#R\"\u0010\u0013\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010 \u001a\u0004\b-\u0010\u0004\"\u0004\b.\u0010#R\"\u0010\u0010\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010 \u001a\u0004\b/\u0010\u0004\"\u0004\b0\u0010#R\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010 \u001a\u0004\b1\u0010\u0004\"\u0004\b2\u0010#"}, d2 = {"Lid/dana/domain/registration/model/CheckRegistrationRequest;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()Z", "component7", "()Ljava/lang/Boolean;", "component8", "phoneNumber", "otpChannel", "clientId", "merchantId", "merchantName", "isWhatsAppInstalled", "isNetworkEligible", "isPasskeySupported", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Z)Lid/dana/domain/registration/model/CheckRegistrationRequest;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getClientId", "setClientId", "(Ljava/lang/String;)V", "Ljava/lang/Boolean;", "setNetworkEligible", "(Ljava/lang/Boolean;)V", "Z", "setPasskeySupported", "(Z)V", "setWhatsAppInstalled", "getMerchantId", "setMerchantId", "getMerchantName", "setMerchantName", "getOtpChannel", "setOtpChannel", "getPhoneNumber", "setPhoneNumber", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CheckRegistrationRequest {
    private String clientId;
    private Boolean isNetworkEligible;
    private boolean isPasskeySupported;
    private boolean isWhatsAppInstalled;
    private String merchantId;
    private String merchantName;
    private String otpChannel;
    private String phoneNumber;

    /* renamed from: component1  reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component2  reason: from getter */
    public final String getOtpChannel() {
        return this.otpChannel;
    }

    /* renamed from: component3  reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getMerchantName() {
        return this.merchantName;
    }

    /* renamed from: component6  reason: from getter */
    public final boolean getIsWhatsAppInstalled() {
        return this.isWhatsAppInstalled;
    }

    /* renamed from: component7  reason: from getter */
    public final Boolean getIsNetworkEligible() {
        return this.isNetworkEligible;
    }

    /* renamed from: component8  reason: from getter */
    public final boolean getIsPasskeySupported() {
        return this.isPasskeySupported;
    }

    public final CheckRegistrationRequest copy(String phoneNumber, String otpChannel, String clientId, String merchantId, String merchantName, boolean isWhatsAppInstalled, Boolean isNetworkEligible, boolean isPasskeySupported) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(otpChannel, "");
        Intrinsics.checkNotNullParameter(clientId, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(merchantName, "");
        return new CheckRegistrationRequest(phoneNumber, otpChannel, clientId, merchantId, merchantName, isWhatsAppInstalled, isNetworkEligible, isPasskeySupported);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CheckRegistrationRequest) {
            CheckRegistrationRequest checkRegistrationRequest = (CheckRegistrationRequest) other;
            return Intrinsics.areEqual(this.phoneNumber, checkRegistrationRequest.phoneNumber) && Intrinsics.areEqual(this.otpChannel, checkRegistrationRequest.otpChannel) && Intrinsics.areEqual(this.clientId, checkRegistrationRequest.clientId) && Intrinsics.areEqual(this.merchantId, checkRegistrationRequest.merchantId) && Intrinsics.areEqual(this.merchantName, checkRegistrationRequest.merchantName) && this.isWhatsAppInstalled == checkRegistrationRequest.isWhatsAppInstalled && Intrinsics.areEqual(this.isNetworkEligible, checkRegistrationRequest.isNetworkEligible) && this.isPasskeySupported == checkRegistrationRequest.isPasskeySupported;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.phoneNumber.hashCode();
        int hashCode2 = this.otpChannel.hashCode();
        int hashCode3 = this.clientId.hashCode();
        int hashCode4 = this.merchantId.hashCode();
        int hashCode5 = this.merchantName.hashCode();
        boolean z = this.isWhatsAppInstalled;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        Boolean bool = this.isNetworkEligible;
        int hashCode6 = bool == null ? 0 : bool.hashCode();
        boolean z2 = this.isPasskeySupported;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i) * 31) + hashCode6) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CheckRegistrationRequest(phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(", otpChannel=");
        sb.append(this.otpChannel);
        sb.append(", clientId=");
        sb.append(this.clientId);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", merchantName=");
        sb.append(this.merchantName);
        sb.append(", isWhatsAppInstalled=");
        sb.append(this.isWhatsAppInstalled);
        sb.append(", isNetworkEligible=");
        sb.append(this.isNetworkEligible);
        sb.append(", isPasskeySupported=");
        sb.append(this.isPasskeySupported);
        sb.append(')');
        return sb.toString();
    }

    public CheckRegistrationRequest(String str, String str2, String str3, String str4, String str5, boolean z, Boolean bool, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.phoneNumber = str;
        this.otpChannel = str2;
        this.clientId = str3;
        this.merchantId = str4;
        this.merchantName = str5;
        this.isWhatsAppInstalled = z;
        this.isNetworkEligible = bool;
        this.isPasskeySupported = z2;
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

    @JvmName(name = "getOtpChannel")
    public final String getOtpChannel() {
        return this.otpChannel;
    }

    @JvmName(name = "setOtpChannel")
    public final void setOtpChannel(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.otpChannel = str;
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

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "setMerchantId")
    public final void setMerchantId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.merchantId = str;
    }

    @JvmName(name = "getMerchantName")
    public final String getMerchantName() {
        return this.merchantName;
    }

    @JvmName(name = "setMerchantName")
    public final void setMerchantName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.merchantName = str;
    }

    @JvmName(name = "isWhatsAppInstalled")
    public final boolean isWhatsAppInstalled() {
        return this.isWhatsAppInstalled;
    }

    @JvmName(name = "setWhatsAppInstalled")
    public final void setWhatsAppInstalled(boolean z) {
        this.isWhatsAppInstalled = z;
    }

    public /* synthetic */ CheckRegistrationRequest(String str, String str2, String str3, String str4, String str5, boolean z, Boolean bool, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, str3, str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? false : z, (i & 64) != 0 ? Boolean.FALSE : bool, (i & 128) != 0 ? false : z2);
    }

    @JvmName(name = "isNetworkEligible")
    public final Boolean isNetworkEligible() {
        return this.isNetworkEligible;
    }

    @JvmName(name = "setNetworkEligible")
    public final void setNetworkEligible(Boolean bool) {
        this.isNetworkEligible = bool;
    }

    @JvmName(name = "isPasskeySupported")
    public final boolean isPasskeySupported() {
        return this.isPasskeySupported;
    }

    @JvmName(name = "setPasskeySupported")
    public final void setPasskeySupported(boolean z) {
        this.isPasskeySupported = z;
    }
}
