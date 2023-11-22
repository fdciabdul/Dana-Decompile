package id.dana.data.twilio.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J<\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001a\u0010\u0007R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u001b\u0010\u0007R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004"}, d2 = {"Lid/dana/data/twilio/repository/source/network/result/VerifyPushEnrollResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "component4", "succes", "accessToken", "identity", "serviceSid", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/twilio/repository/source/network/result/VerifyPushEnrollResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAccessToken", "getIdentity", "getServiceSid", "Z", "getSucces", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VerifyPushEnrollResult extends BaseRpcResult {
    private final String accessToken;
    private final String identity;
    private final String serviceSid;
    private final boolean succes;

    public VerifyPushEnrollResult() {
        this(false, null, null, null, 15, null);
    }

    public static /* synthetic */ VerifyPushEnrollResult copy$default(VerifyPushEnrollResult verifyPushEnrollResult, boolean z, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = verifyPushEnrollResult.succes;
        }
        if ((i & 2) != 0) {
            str = verifyPushEnrollResult.accessToken;
        }
        if ((i & 4) != 0) {
            str2 = verifyPushEnrollResult.identity;
        }
        if ((i & 8) != 0) {
            str3 = verifyPushEnrollResult.serviceSid;
        }
        return verifyPushEnrollResult.copy(z, str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getSucces() {
        return this.succes;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* renamed from: component3  reason: from getter */
    public final String getIdentity() {
        return this.identity;
    }

    /* renamed from: component4  reason: from getter */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    public final VerifyPushEnrollResult copy(boolean succes, String accessToken, String identity, String serviceSid) {
        Intrinsics.checkNotNullParameter(accessToken, "");
        return new VerifyPushEnrollResult(succes, accessToken, identity, serviceSid);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VerifyPushEnrollResult) {
            VerifyPushEnrollResult verifyPushEnrollResult = (VerifyPushEnrollResult) other;
            return this.succes == verifyPushEnrollResult.succes && Intrinsics.areEqual(this.accessToken, verifyPushEnrollResult.accessToken) && Intrinsics.areEqual(this.identity, verifyPushEnrollResult.identity) && Intrinsics.areEqual(this.serviceSid, verifyPushEnrollResult.serviceSid);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean z = this.succes;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = this.accessToken.hashCode();
        String str = this.identity;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.serviceSid;
        return (((((r0 * 31) + hashCode) * 31) + hashCode2) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerifyPushEnrollResult(succes=");
        sb.append(this.succes);
        sb.append(", accessToken=");
        sb.append(this.accessToken);
        sb.append(", identity=");
        sb.append(this.identity);
        sb.append(", serviceSid=");
        sb.append(this.serviceSid);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ VerifyPushEnrollResult(boolean z, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3);
    }

    @JvmName(name = "getSucces")
    public final boolean getSucces() {
        return this.succes;
    }

    @JvmName(name = "getAccessToken")
    public final String getAccessToken() {
        return this.accessToken;
    }

    @JvmName(name = "getIdentity")
    public final String getIdentity() {
        return this.identity;
    }

    @JvmName(name = "getServiceSid")
    public final String getServiceSid() {
        return this.serviceSid;
    }

    public VerifyPushEnrollResult(boolean z, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        this.succes = z;
        this.accessToken = str;
        this.identity = str2;
        this.serviceSid = str3;
    }
}
