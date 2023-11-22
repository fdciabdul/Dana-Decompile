package id.dana.domain.ott;

import id.dana.utils.rpc.response.BaseRpcResponse;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b$\u0010%J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J@\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u001bR$\u0010\f\u001a\u0004\u0018\u00010\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\u001fR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0018\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\u001bR$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0018\u001a\u0004\b\"\u0010\u0004\"\u0004\b#\u0010\u001b"}, d2 = {"Lid/dana/domain/ott/OttVerifyResult;", "Lid/dana/utils/rpc/response/BaseRpcResponse;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Boolean;", "component4", "userId", "merchantId", "needLogout", "phoneNumber", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lid/dana/domain/ott/OttVerifyResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getMerchantId", "setMerchantId", "(Ljava/lang/String;)V", "Ljava/lang/Boolean;", "getNeedLogout", "setNeedLogout", "(Ljava/lang/Boolean;)V", "getPhoneNumber", "setPhoneNumber", "getUserId", "setUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class OttVerifyResult extends BaseRpcResponse {
    private String merchantId;
    private Boolean needLogout;
    private String phoneNumber;
    private String userId;

    public OttVerifyResult() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ OttVerifyResult copy$default(OttVerifyResult ottVerifyResult, String str, String str2, Boolean bool, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ottVerifyResult.userId;
        }
        if ((i & 2) != 0) {
            str2 = ottVerifyResult.merchantId;
        }
        if ((i & 4) != 0) {
            bool = ottVerifyResult.needLogout;
        }
        if ((i & 8) != 0) {
            str3 = ottVerifyResult.phoneNumber;
        }
        return ottVerifyResult.copy(str, str2, bool, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component3  reason: from getter */
    public final Boolean getNeedLogout() {
        return this.needLogout;
    }

    /* renamed from: component4  reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final OttVerifyResult copy(String userId, String merchantId, Boolean needLogout, String phoneNumber) {
        return new OttVerifyResult(userId, merchantId, needLogout, phoneNumber);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof OttVerifyResult) {
            OttVerifyResult ottVerifyResult = (OttVerifyResult) other;
            return Intrinsics.areEqual(this.userId, ottVerifyResult.userId) && Intrinsics.areEqual(this.merchantId, ottVerifyResult.merchantId) && Intrinsics.areEqual(this.needLogout, ottVerifyResult.needLogout) && Intrinsics.areEqual(this.phoneNumber, ottVerifyResult.phoneNumber);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.userId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.merchantId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        Boolean bool = this.needLogout;
        int hashCode3 = bool == null ? 0 : bool.hashCode();
        String str3 = this.phoneNumber;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // id.dana.utils.rpc.response.BaseRpcResponse
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OttVerifyResult(userId=");
        sb.append(this.userId);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", needLogout=");
        sb.append(this.needLogout);
        sb.append(", phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "setUserId")
    public final void setUserId(String str) {
        this.userId = str;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "setMerchantId")
    public final void setMerchantId(String str) {
        this.merchantId = str;
    }

    public /* synthetic */ OttVerifyResult(String str, String str2, Boolean bool, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? Boolean.FALSE : bool, (i & 8) != 0 ? "" : str3);
    }

    @JvmName(name = "getNeedLogout")
    public final Boolean getNeedLogout() {
        return this.needLogout;
    }

    @JvmName(name = "setNeedLogout")
    public final void setNeedLogout(Boolean bool) {
        this.needLogout = bool;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "setPhoneNumber")
    public final void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public OttVerifyResult(String str, String str2, Boolean bool, String str3) {
        this.userId = str;
        this.merchantId = str2;
        this.needLogout = bool;
        this.phoneNumber = str3;
    }
}
