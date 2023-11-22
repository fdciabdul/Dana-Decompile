package id.dana.data.autoroute.model;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b$\u0010%J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J@\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007R$\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\u001bR$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004\"\u0004\b\u001e\u0010\u001fR$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\u001bR$\u0010\r\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0018\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\u001b"}, d2 = {"Lid/dana/data/autoroute/model/UserAutoRouteConfigStoreRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/Boolean;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "autoroute", "authenticationType", BioUtilityBridge.SECURITY_ID, "validateData", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/autoroute/model/UserAutoRouteConfigStoreRequest;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAuthenticationType", "setAuthenticationType", "(Ljava/lang/String;)V", "Ljava/lang/Boolean;", "getAutoroute", "setAutoroute", "(Ljava/lang/Boolean;)V", "getSecurityId", "setSecurityId", "getValidateData", "setValidateData", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserAutoRouteConfigStoreRequest extends BaseRpcRequest {
    private String authenticationType;
    private Boolean autoroute;
    private String securityId;
    private String validateData;

    public UserAutoRouteConfigStoreRequest() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ UserAutoRouteConfigStoreRequest copy$default(UserAutoRouteConfigStoreRequest userAutoRouteConfigStoreRequest, Boolean bool, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = userAutoRouteConfigStoreRequest.autoroute;
        }
        if ((i & 2) != 0) {
            str = userAutoRouteConfigStoreRequest.authenticationType;
        }
        if ((i & 4) != 0) {
            str2 = userAutoRouteConfigStoreRequest.securityId;
        }
        if ((i & 8) != 0) {
            str3 = userAutoRouteConfigStoreRequest.validateData;
        }
        return userAutoRouteConfigStoreRequest.copy(bool, str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getAutoroute() {
        return this.autoroute;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAuthenticationType() {
        return this.authenticationType;
    }

    /* renamed from: component3  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getValidateData() {
        return this.validateData;
    }

    public final UserAutoRouteConfigStoreRequest copy(Boolean autoroute, String authenticationType, String securityId, String validateData) {
        return new UserAutoRouteConfigStoreRequest(autoroute, authenticationType, securityId, validateData);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserAutoRouteConfigStoreRequest) {
            UserAutoRouteConfigStoreRequest userAutoRouteConfigStoreRequest = (UserAutoRouteConfigStoreRequest) other;
            return Intrinsics.areEqual(this.autoroute, userAutoRouteConfigStoreRequest.autoroute) && Intrinsics.areEqual(this.authenticationType, userAutoRouteConfigStoreRequest.authenticationType) && Intrinsics.areEqual(this.securityId, userAutoRouteConfigStoreRequest.securityId) && Intrinsics.areEqual(this.validateData, userAutoRouteConfigStoreRequest.validateData);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.autoroute;
        int hashCode = bool == null ? 0 : bool.hashCode();
        String str = this.authenticationType;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.securityId;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.validateData;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserAutoRouteConfigStoreRequest(autoroute=");
        sb.append(this.autoroute);
        sb.append(", authenticationType=");
        sb.append(this.authenticationType);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", validateData=");
        sb.append(this.validateData);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ UserAutoRouteConfigStoreRequest(Boolean bool, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Boolean.FALSE : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }

    @JvmName(name = "getAutoroute")
    public final Boolean getAutoroute() {
        return this.autoroute;
    }

    @JvmName(name = "setAutoroute")
    public final void setAutoroute(Boolean bool) {
        this.autoroute = bool;
    }

    @JvmName(name = "getAuthenticationType")
    public final String getAuthenticationType() {
        return this.authenticationType;
    }

    @JvmName(name = "setAuthenticationType")
    public final void setAuthenticationType(String str) {
        this.authenticationType = str;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "setSecurityId")
    public final void setSecurityId(String str) {
        this.securityId = str;
    }

    @JvmName(name = "getValidateData")
    public final String getValidateData() {
        return this.validateData;
    }

    @JvmName(name = "setValidateData")
    public final void setValidateData(String str) {
        this.validateData = str;
    }

    public UserAutoRouteConfigStoreRequest(Boolean bool, String str, String str2, String str3) {
        this.autoroute = bool;
        this.authenticationType = str;
        this.securityId = str2;
        this.validateData = str3;
    }
}
