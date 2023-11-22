package id.dana.domain.profilecompletion.model;

import id.dana.danah5.constant.BridgeName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000bJ\u0080\u0001\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\u0004R\"\u0010\u0013\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\u0004\"\u0004\b'\u0010(R\"\u0010\u0017\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010)\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b*\u0010+R\"\u0010\u0019\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010)\u001a\u0004\b,\u0010\u000b\"\u0004\b-\u0010+R\"\u0010\u0012\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010%\u001a\u0004\b.\u0010\u0004\"\u0004\b/\u0010(R\"\u0010\u0011\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010%\u001a\u0004\b0\u0010\u0004\"\u0004\b1\u0010(R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010%\u001a\u0004\b2\u0010\u0004\"\u0004\b3\u0010(R\"\u0010\u0018\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010%\u001a\u0004\b4\u0010\u0004\"\u0004\b5\u0010(R\"\u0010\u0014\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010)\u001a\u0004\b6\u0010\u000b\"\u0004\b7\u0010+R\"\u0010\u0015\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010)\u001a\u0004\b8\u0010\u000b\"\u0004\b9\u0010+R\"\u0010\u0016\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010)\u001a\u0004\b:\u0010\u000b\"\u0004\b;\u0010+R\"\u0010\u001b\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010%\u001a\u0004\b<\u0010\u0004\"\u0004\b=\u0010("}, d2 = {"Lid/dana/domain/profilecompletion/model/ProfileCompletionData;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component2", "component3", "", "component4", "()Z", "component5", "component6", "component7", "component8", "component9", "phoneNumber", "nickName", "email", "securityQuestionAvailable", "shouldShowFaceAuth", "shouldShowTrustedDevice", "isTrustedDeviceRegistered", "securityIdForTrustedDevice", "kycAccepted", "redirect", "username", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;)Lid/dana/domain/profilecompletion/model/ProfileCompletionData;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getEmail", "setEmail", "(Ljava/lang/String;)V", "Z", "setTrustedDeviceRegistered", "(Z)V", "getKycAccepted", "setKycAccepted", "getNickName", "setNickName", "getPhoneNumber", "setPhoneNumber", "getRedirect", "setRedirect", "getSecurityIdForTrustedDevice", "setSecurityIdForTrustedDevice", "getSecurityQuestionAvailable", "setSecurityQuestionAvailable", "getShouldShowFaceAuth", "setShouldShowFaceAuth", "getShouldShowTrustedDevice", "setShouldShowTrustedDevice", BridgeName.GET_USERNAME, "setUsername", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ProfileCompletionData {
    private String email;
    private boolean isTrustedDeviceRegistered;
    private boolean kycAccepted;
    private String nickName;
    private String phoneNumber;
    private String redirect;
    private String securityIdForTrustedDevice;
    private boolean securityQuestionAvailable;
    private boolean shouldShowFaceAuth;
    private boolean shouldShowTrustedDevice;
    private String username;

    public ProfileCompletionData() {
        this(null, null, null, false, false, false, false, null, false, null, null, 2047, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component10  reason: from getter */
    public final String getRedirect() {
        return this.redirect;
    }

    /* renamed from: component11  reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* renamed from: component2  reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* renamed from: component3  reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component4  reason: from getter */
    public final boolean getSecurityQuestionAvailable() {
        return this.securityQuestionAvailable;
    }

    /* renamed from: component5  reason: from getter */
    public final boolean getShouldShowFaceAuth() {
        return this.shouldShowFaceAuth;
    }

    /* renamed from: component6  reason: from getter */
    public final boolean getShouldShowTrustedDevice() {
        return this.shouldShowTrustedDevice;
    }

    /* renamed from: component7  reason: from getter */
    public final boolean getIsTrustedDeviceRegistered() {
        return this.isTrustedDeviceRegistered;
    }

    /* renamed from: component8  reason: from getter */
    public final String getSecurityIdForTrustedDevice() {
        return this.securityIdForTrustedDevice;
    }

    /* renamed from: component9  reason: from getter */
    public final boolean getKycAccepted() {
        return this.kycAccepted;
    }

    public final ProfileCompletionData copy(String phoneNumber, String nickName, String email, boolean securityQuestionAvailable, boolean shouldShowFaceAuth, boolean shouldShowTrustedDevice, boolean isTrustedDeviceRegistered, String securityIdForTrustedDevice, boolean kycAccepted, String redirect, String username) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(nickName, "");
        Intrinsics.checkNotNullParameter(email, "");
        Intrinsics.checkNotNullParameter(securityIdForTrustedDevice, "");
        Intrinsics.checkNotNullParameter(username, "");
        return new ProfileCompletionData(phoneNumber, nickName, email, securityQuestionAvailable, shouldShowFaceAuth, shouldShowTrustedDevice, isTrustedDeviceRegistered, securityIdForTrustedDevice, kycAccepted, redirect, username);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ProfileCompletionData) {
            ProfileCompletionData profileCompletionData = (ProfileCompletionData) other;
            return Intrinsics.areEqual(this.phoneNumber, profileCompletionData.phoneNumber) && Intrinsics.areEqual(this.nickName, profileCompletionData.nickName) && Intrinsics.areEqual(this.email, profileCompletionData.email) && this.securityQuestionAvailable == profileCompletionData.securityQuestionAvailable && this.shouldShowFaceAuth == profileCompletionData.shouldShowFaceAuth && this.shouldShowTrustedDevice == profileCompletionData.shouldShowTrustedDevice && this.isTrustedDeviceRegistered == profileCompletionData.isTrustedDeviceRegistered && Intrinsics.areEqual(this.securityIdForTrustedDevice, profileCompletionData.securityIdForTrustedDevice) && this.kycAccepted == profileCompletionData.kycAccepted && Intrinsics.areEqual(this.redirect, profileCompletionData.redirect) && Intrinsics.areEqual(this.username, profileCompletionData.username);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.phoneNumber.hashCode();
        int hashCode2 = this.nickName.hashCode();
        int hashCode3 = this.email.hashCode();
        boolean z = this.securityQuestionAvailable;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        boolean z2 = this.shouldShowFaceAuth;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        boolean z3 = this.shouldShowTrustedDevice;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        boolean z4 = this.isTrustedDeviceRegistered;
        int i4 = z4;
        if (z4 != 0) {
            i4 = 1;
        }
        int hashCode4 = this.securityIdForTrustedDevice.hashCode();
        boolean z5 = this.kycAccepted;
        int i5 = z5 ? 1 : z5 ? 1 : 0;
        String str = this.redirect;
        return (((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + hashCode4) * 31) + i5) * 31) + (str == null ? 0 : str.hashCode())) * 31) + this.username.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProfileCompletionData(phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(", nickName=");
        sb.append(this.nickName);
        sb.append(", email=");
        sb.append(this.email);
        sb.append(", securityQuestionAvailable=");
        sb.append(this.securityQuestionAvailable);
        sb.append(", shouldShowFaceAuth=");
        sb.append(this.shouldShowFaceAuth);
        sb.append(", shouldShowTrustedDevice=");
        sb.append(this.shouldShowTrustedDevice);
        sb.append(", isTrustedDeviceRegistered=");
        sb.append(this.isTrustedDeviceRegistered);
        sb.append(", securityIdForTrustedDevice=");
        sb.append(this.securityIdForTrustedDevice);
        sb.append(", kycAccepted=");
        sb.append(this.kycAccepted);
        sb.append(", redirect=");
        sb.append(this.redirect);
        sb.append(", username=");
        sb.append(this.username);
        sb.append(')');
        return sb.toString();
    }

    public ProfileCompletionData(String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, String str4, boolean z5, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.phoneNumber = str;
        this.nickName = str2;
        this.email = str3;
        this.securityQuestionAvailable = z;
        this.shouldShowFaceAuth = z2;
        this.shouldShowTrustedDevice = z3;
        this.isTrustedDeviceRegistered = z4;
        this.securityIdForTrustedDevice = str4;
        this.kycAccepted = z5;
        this.redirect = str5;
        this.username = str6;
    }

    public /* synthetic */ ProfileCompletionData(String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, String str4, boolean z5, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? false : z4, (i & 128) != 0 ? "" : str4, (i & 256) == 0 ? z5 : false, (i & 512) != 0 ? null : str5, (i & 1024) == 0 ? str6 : "");
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

    @JvmName(name = "getNickName")
    public final String getNickName() {
        return this.nickName;
    }

    @JvmName(name = "setNickName")
    public final void setNickName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.nickName = str;
    }

    @JvmName(name = "getEmail")
    public final String getEmail() {
        return this.email;
    }

    @JvmName(name = "setEmail")
    public final void setEmail(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.email = str;
    }

    @JvmName(name = "getSecurityQuestionAvailable")
    public final boolean getSecurityQuestionAvailable() {
        return this.securityQuestionAvailable;
    }

    @JvmName(name = "setSecurityQuestionAvailable")
    public final void setSecurityQuestionAvailable(boolean z) {
        this.securityQuestionAvailable = z;
    }

    @JvmName(name = "getShouldShowFaceAuth")
    public final boolean getShouldShowFaceAuth() {
        return this.shouldShowFaceAuth;
    }

    @JvmName(name = "setShouldShowFaceAuth")
    public final void setShouldShowFaceAuth(boolean z) {
        this.shouldShowFaceAuth = z;
    }

    @JvmName(name = "getShouldShowTrustedDevice")
    public final boolean getShouldShowTrustedDevice() {
        return this.shouldShowTrustedDevice;
    }

    @JvmName(name = "setShouldShowTrustedDevice")
    public final void setShouldShowTrustedDevice(boolean z) {
        this.shouldShowTrustedDevice = z;
    }

    @JvmName(name = "isTrustedDeviceRegistered")
    public final boolean isTrustedDeviceRegistered() {
        return this.isTrustedDeviceRegistered;
    }

    @JvmName(name = "setTrustedDeviceRegistered")
    public final void setTrustedDeviceRegistered(boolean z) {
        this.isTrustedDeviceRegistered = z;
    }

    @JvmName(name = "getSecurityIdForTrustedDevice")
    public final String getSecurityIdForTrustedDevice() {
        return this.securityIdForTrustedDevice;
    }

    @JvmName(name = "setSecurityIdForTrustedDevice")
    public final void setSecurityIdForTrustedDevice(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.securityIdForTrustedDevice = str;
    }

    @JvmName(name = "getKycAccepted")
    public final boolean getKycAccepted() {
        return this.kycAccepted;
    }

    @JvmName(name = "setKycAccepted")
    public final void setKycAccepted(boolean z) {
        this.kycAccepted = z;
    }

    @JvmName(name = "getRedirect")
    public final String getRedirect() {
        return this.redirect;
    }

    @JvmName(name = "setRedirect")
    public final void setRedirect(String str) {
        this.redirect = str;
    }

    @JvmName(name = BridgeName.GET_USERNAME)
    public final String getUsername() {
        return this.username;
    }

    @JvmName(name = "setUsername")
    public final void setUsername(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.username = str;
    }
}
