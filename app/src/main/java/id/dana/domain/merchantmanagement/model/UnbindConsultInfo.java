package id.dana.domain.merchantmanagement.model;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007JV\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0007R$\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\u001eR$\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\u001eR$\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\u001eR$\u0010\r\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001b\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\u001eR$\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\u001eR\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010'\u001a\u0004\b(\u0010\u0004\"\u0004\b)\u0010*"}, d2 = {"Lid/dana/domain/merchantmanagement/model/UnbindConsultInfo;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "success", RecordError.KEY_PUB_KEY, BioUtilityBridge.SECURITY_ID, "clientId", "merchantId", "divisionId", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/merchantmanagement/model/UnbindConsultInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getClientId", "setClientId", "(Ljava/lang/String;)V", "getDivisionId", "setDivisionId", "getMerchantId", "setMerchantId", "getPubKey", "setPubKey", "getSecurityId", "setSecurityId", "Z", "getSuccess", "setSuccess", "(Z)V", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UnbindConsultInfo {
    private String clientId;
    private String divisionId;
    private String merchantId;
    private String pubKey;
    private String securityId;
    private boolean success;

    public UnbindConsultInfo() {
        this(false, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ UnbindConsultInfo copy$default(UnbindConsultInfo unbindConsultInfo, boolean z, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = unbindConsultInfo.success;
        }
        if ((i & 2) != 0) {
            str = unbindConsultInfo.pubKey;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = unbindConsultInfo.securityId;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = unbindConsultInfo.clientId;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = unbindConsultInfo.merchantId;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = unbindConsultInfo.divisionId;
        }
        return unbindConsultInfo.copy(z, str6, str7, str8, str9, str5);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2  reason: from getter */
    public final String getPubKey() {
        return this.pubKey;
    }

    /* renamed from: component3  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component6  reason: from getter */
    public final String getDivisionId() {
        return this.divisionId;
    }

    public final UnbindConsultInfo copy(boolean success, String pubKey, String securityId, String clientId, String merchantId, String divisionId) {
        return new UnbindConsultInfo(success, pubKey, securityId, clientId, merchantId, divisionId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UnbindConsultInfo) {
            UnbindConsultInfo unbindConsultInfo = (UnbindConsultInfo) other;
            return this.success == unbindConsultInfo.success && Intrinsics.areEqual(this.pubKey, unbindConsultInfo.pubKey) && Intrinsics.areEqual(this.securityId, unbindConsultInfo.securityId) && Intrinsics.areEqual(this.clientId, unbindConsultInfo.clientId) && Intrinsics.areEqual(this.merchantId, unbindConsultInfo.merchantId) && Intrinsics.areEqual(this.divisionId, unbindConsultInfo.divisionId);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public final int hashCode() {
        boolean z = this.success;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        String str = this.pubKey;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.securityId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.clientId;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.merchantId;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.divisionId;
        return (((((((((r0 * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UnbindConsultInfo(success=");
        sb.append(this.success);
        sb.append(", pubKey=");
        sb.append(this.pubKey);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", clientId=");
        sb.append(this.clientId);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", divisionId=");
        sb.append(this.divisionId);
        sb.append(')');
        return sb.toString();
    }

    public UnbindConsultInfo(boolean z, String str, String str2, String str3, String str4, String str5) {
        this.success = z;
        this.pubKey = str;
        this.securityId = str2;
        this.clientId = str3;
        this.merchantId = str4;
        this.divisionId = str5;
    }

    public /* synthetic */ UnbindConsultInfo(boolean z, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) == 0 ? str5 : null);
    }

    @JvmName(name = "getSuccess")
    public final boolean getSuccess() {
        return this.success;
    }

    @JvmName(name = "setSuccess")
    public final void setSuccess(boolean z) {
        this.success = z;
    }

    @JvmName(name = "getPubKey")
    public final String getPubKey() {
        return this.pubKey;
    }

    @JvmName(name = "setPubKey")
    public final void setPubKey(String str) {
        this.pubKey = str;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "setSecurityId")
    public final void setSecurityId(String str) {
        this.securityId = str;
    }

    @JvmName(name = "getClientId")
    public final String getClientId() {
        return this.clientId;
    }

    @JvmName(name = "setClientId")
    public final void setClientId(String str) {
        this.clientId = str;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "setMerchantId")
    public final void setMerchantId(String str) {
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
}
