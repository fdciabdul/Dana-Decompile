package id.dana.domain.twilio.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J<\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u001a\u0010\u0007R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004"}, d2 = {"Lid/dana/domain/twilio/model/EnrollInfo;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "component4", "succes", "accessToken", "identity", "serviceSid", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/twilio/model/EnrollInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAccessToken", "getIdentity", "getServiceSid", "Z", "getSucces", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EnrollInfo {
    private final String accessToken;
    private final String identity;
    private final String serviceSid;
    private final boolean succes;

    public static /* synthetic */ EnrollInfo copy$default(EnrollInfo enrollInfo, boolean z, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = enrollInfo.succes;
        }
        if ((i & 2) != 0) {
            str = enrollInfo.accessToken;
        }
        if ((i & 4) != 0) {
            str2 = enrollInfo.identity;
        }
        if ((i & 8) != 0) {
            str3 = enrollInfo.serviceSid;
        }
        return enrollInfo.copy(z, str, str2, str3);
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

    public final EnrollInfo copy(boolean succes, String accessToken, String identity, String serviceSid) {
        Intrinsics.checkNotNullParameter(accessToken, "");
        return new EnrollInfo(succes, accessToken, identity, serviceSid);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof EnrollInfo) {
            EnrollInfo enrollInfo = (EnrollInfo) other;
            return this.succes == enrollInfo.succes && Intrinsics.areEqual(this.accessToken, enrollInfo.accessToken) && Intrinsics.areEqual(this.identity, enrollInfo.identity) && Intrinsics.areEqual(this.serviceSid, enrollInfo.serviceSid);
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
        sb.append("EnrollInfo(succes=");
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

    public EnrollInfo(boolean z, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        this.succes = z;
        this.accessToken = str;
        this.identity = str2;
        this.serviceSid = str3;
    }

    public /* synthetic */ EnrollInfo(boolean z, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3);
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
}
