package id.dana.contract.deeplink.path;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b7\u00108J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004Jj\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u001a¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004R\"\u0010\u000e\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010\u0004\"\u0004\b%\u0010&R\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010#\u001a\u0004\b'\u0010\u0004\"\u0004\b(\u0010&R\"\u0010\u0012\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010#\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010&R\"\u0010\u0011\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010#\u001a\u0004\b+\u0010\u0004\"\u0004\b,\u0010&R\"\u0010\u0010\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010#\u001a\u0004\b-\u0010\u0004\"\u0004\b.\u0010&R\"\u0010\r\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010#\u001a\u0004\b/\u0010\u0004\"\u0004\b0\u0010&R\"\u0010\u0013\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010#\u001a\u0004\b1\u0010\u0004\"\u0004\b2\u0010&R\"\u0010\u0014\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010#\u001a\u0004\b3\u0010\u0004\"\u0004\b4\u0010&R\"\u0010\u0015\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010#\u001a\u0004\b5\u0010\u0004\"\u0004\b6\u0010&"}, d2 = {"Lid/dana/contract/deeplink/path/IpgRegistrationPayload;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "params", "action", "bizType", "logo", "idTitle", "enTitle", "tncUrl", "userConsentConfigKey", "userConsentSyncKey", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/contract/deeplink/path/IpgRegistrationPayload;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "isValid", "()Z", "toString", "Ljava/lang/String;", "getAction", "setAction", "(Ljava/lang/String;)V", "getBizType", "setBizType", "getEnTitle", "setEnTitle", "getIdTitle", "setIdTitle", "getLogo", "setLogo", "getParams", "setParams", "getTncUrl", "setTncUrl", "getUserConsentConfigKey", "setUserConsentConfigKey", "getUserConsentSyncKey", "setUserConsentSyncKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class IpgRegistrationPayload implements Serializable {
    @SerializedName("action")
    private String action;
    @SerializedName("bizType")
    private String bizType;
    @SerializedName("enTitle")
    private String enTitle;
    @SerializedName("idTitle")
    private String idTitle;
    @SerializedName("logo")
    private String logo;
    @SerializedName("path")
    private String params;
    @SerializedName("tnc")
    private String tncUrl;
    @SerializedName("userConsentConfigKey")
    private String userConsentConfigKey;
    @SerializedName("userConsentSyncKey")
    private String userConsentSyncKey;

    /* renamed from: component1  reason: from getter */
    public final String getParams() {
        return this.params;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component3  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component4  reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    /* renamed from: component5  reason: from getter */
    public final String getIdTitle() {
        return this.idTitle;
    }

    /* renamed from: component6  reason: from getter */
    public final String getEnTitle() {
        return this.enTitle;
    }

    /* renamed from: component7  reason: from getter */
    public final String getTncUrl() {
        return this.tncUrl;
    }

    /* renamed from: component8  reason: from getter */
    public final String getUserConsentConfigKey() {
        return this.userConsentConfigKey;
    }

    /* renamed from: component9  reason: from getter */
    public final String getUserConsentSyncKey() {
        return this.userConsentSyncKey;
    }

    public final IpgRegistrationPayload copy(String params, String action, String bizType, String logo, String idTitle, String enTitle, String tncUrl, String userConsentConfigKey, String userConsentSyncKey) {
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(action, "");
        Intrinsics.checkNotNullParameter(bizType, "");
        Intrinsics.checkNotNullParameter(logo, "");
        Intrinsics.checkNotNullParameter(idTitle, "");
        Intrinsics.checkNotNullParameter(enTitle, "");
        Intrinsics.checkNotNullParameter(tncUrl, "");
        Intrinsics.checkNotNullParameter(userConsentConfigKey, "");
        Intrinsics.checkNotNullParameter(userConsentSyncKey, "");
        return new IpgRegistrationPayload(params, action, bizType, logo, idTitle, enTitle, tncUrl, userConsentConfigKey, userConsentSyncKey);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof IpgRegistrationPayload) {
            IpgRegistrationPayload ipgRegistrationPayload = (IpgRegistrationPayload) other;
            return Intrinsics.areEqual(this.params, ipgRegistrationPayload.params) && Intrinsics.areEqual(this.action, ipgRegistrationPayload.action) && Intrinsics.areEqual(this.bizType, ipgRegistrationPayload.bizType) && Intrinsics.areEqual(this.logo, ipgRegistrationPayload.logo) && Intrinsics.areEqual(this.idTitle, ipgRegistrationPayload.idTitle) && Intrinsics.areEqual(this.enTitle, ipgRegistrationPayload.enTitle) && Intrinsics.areEqual(this.tncUrl, ipgRegistrationPayload.tncUrl) && Intrinsics.areEqual(this.userConsentConfigKey, ipgRegistrationPayload.userConsentConfigKey) && Intrinsics.areEqual(this.userConsentSyncKey, ipgRegistrationPayload.userConsentSyncKey);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((this.params.hashCode() * 31) + this.action.hashCode()) * 31) + this.bizType.hashCode()) * 31) + this.logo.hashCode()) * 31) + this.idTitle.hashCode()) * 31) + this.enTitle.hashCode()) * 31) + this.tncUrl.hashCode()) * 31) + this.userConsentConfigKey.hashCode()) * 31) + this.userConsentSyncKey.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IpgRegistrationPayload(params=");
        sb.append(this.params);
        sb.append(", action=");
        sb.append(this.action);
        sb.append(", bizType=");
        sb.append(this.bizType);
        sb.append(", logo=");
        sb.append(this.logo);
        sb.append(", idTitle=");
        sb.append(this.idTitle);
        sb.append(", enTitle=");
        sb.append(this.enTitle);
        sb.append(", tncUrl=");
        sb.append(this.tncUrl);
        sb.append(", userConsentConfigKey=");
        sb.append(this.userConsentConfigKey);
        sb.append(", userConsentSyncKey=");
        sb.append(this.userConsentSyncKey);
        sb.append(')');
        return sb.toString();
    }

    public IpgRegistrationPayload(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        this.params = str;
        this.action = str2;
        this.bizType = str3;
        this.logo = str4;
        this.idTitle = str5;
        this.enTitle = str6;
        this.tncUrl = str7;
        this.userConsentConfigKey = str8;
        this.userConsentSyncKey = str9;
    }

    @JvmName(name = "getParams")
    public final String getParams() {
        return this.params;
    }

    @JvmName(name = "setParams")
    public final void setParams(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.params = str;
    }

    @JvmName(name = "getAction")
    public final String getAction() {
        return this.action;
    }

    @JvmName(name = "setAction")
    public final void setAction(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.action = str;
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "setBizType")
    public final void setBizType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.bizType = str;
    }

    @JvmName(name = "getLogo")
    public final String getLogo() {
        return this.logo;
    }

    @JvmName(name = "setLogo")
    public final void setLogo(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.logo = str;
    }

    @JvmName(name = "getIdTitle")
    public final String getIdTitle() {
        return this.idTitle;
    }

    @JvmName(name = "setIdTitle")
    public final void setIdTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.idTitle = str;
    }

    @JvmName(name = "getEnTitle")
    public final String getEnTitle() {
        return this.enTitle;
    }

    @JvmName(name = "setEnTitle")
    public final void setEnTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.enTitle = str;
    }

    @JvmName(name = "getTncUrl")
    public final String getTncUrl() {
        return this.tncUrl;
    }

    @JvmName(name = "setTncUrl")
    public final void setTncUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.tncUrl = str;
    }

    @JvmName(name = "getUserConsentConfigKey")
    public final String getUserConsentConfigKey() {
        return this.userConsentConfigKey;
    }

    @JvmName(name = "setUserConsentConfigKey")
    public final void setUserConsentConfigKey(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.userConsentConfigKey = str;
    }

    @JvmName(name = "getUserConsentSyncKey")
    public final String getUserConsentSyncKey() {
        return this.userConsentSyncKey;
    }

    @JvmName(name = "setUserConsentSyncKey")
    public final void setUserConsentSyncKey(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.userConsentSyncKey = str;
    }

    public final boolean isValid() {
        if (this.bizType.length() > 0) {
            if (this.userConsentConfigKey.length() > 0) {
                return this.userConsentConfigKey.length() > 0;
            }
            return false;
        }
        return false;
    }
}
