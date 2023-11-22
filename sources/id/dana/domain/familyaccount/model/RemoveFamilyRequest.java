package id.dana.domain.familyaccount.model;

import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004R\"\u0010\u0005\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/domain/familyaccount/model/RemoveFamilyRequest;", "", "", "component1", "()Ljava/lang/String;", BioUtilityBridge.SECURITY_ID, "copy", "(Ljava/lang/String;)Lid/dana/domain/familyaccount/model/RemoveFamilyRequest;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getSecurityId", "setSecurityId", "(Ljava/lang/String;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class RemoveFamilyRequest {
    private String securityId;

    public static /* synthetic */ RemoveFamilyRequest copy$default(RemoveFamilyRequest removeFamilyRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = removeFamilyRequest.securityId;
        }
        return removeFamilyRequest.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    public final RemoveFamilyRequest copy(String securityId) {
        Intrinsics.checkNotNullParameter(securityId, "");
        return new RemoveFamilyRequest(securityId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RemoveFamilyRequest) && Intrinsics.areEqual(this.securityId, ((RemoveFamilyRequest) other).securityId);
    }

    public final int hashCode() {
        return this.securityId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RemoveFamilyRequest(securityId=");
        sb.append(this.securityId);
        sb.append(')');
        return sb.toString();
    }

    public RemoveFamilyRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.securityId = str;
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
}
