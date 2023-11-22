package id.dana.domain.twilio.model;

import id.dana.danah5.bioutility.BioUtilityBridge;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b#\u0010$J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ8\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u001aR\"\u0010\r\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\n\"\u0004\b\u001d\u0010\u001eR*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\""}, d2 = {"Lid/dana/domain/twilio/model/DerollInfo;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "", "component3", "()Z", BioUtilityBridge.SECURITY_ID, "verificationMethodInfos", "success", "copy", "(Ljava/lang/String;Ljava/util/List;Z)Lid/dana/domain/twilio/model/DerollInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getSecurityId", "setSecurityId", "(Ljava/lang/String;)V", "Z", "getSuccess", "setSuccess", "(Z)V", "Ljava/util/List;", "getVerificationMethodInfos", "setVerificationMethodInfos", "(Ljava/util/List;)V", "<init>", "(Ljava/lang/String;Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DerollInfo {
    private String securityId;
    private boolean success;
    private List<String> verificationMethodInfos;

    public DerollInfo() {
        this(null, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DerollInfo copy$default(DerollInfo derollInfo, String str, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = derollInfo.securityId;
        }
        if ((i & 2) != 0) {
            list = derollInfo.verificationMethodInfos;
        }
        if ((i & 4) != 0) {
            z = derollInfo.success;
        }
        return derollInfo.copy(str, list, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    public final List<String> component2() {
        return this.verificationMethodInfos;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final DerollInfo copy(String securityId, List<String> verificationMethodInfos, boolean success) {
        return new DerollInfo(securityId, verificationMethodInfos, success);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DerollInfo) {
            DerollInfo derollInfo = (DerollInfo) other;
            return Intrinsics.areEqual(this.securityId, derollInfo.securityId) && Intrinsics.areEqual(this.verificationMethodInfos, derollInfo.verificationMethodInfos) && this.success == derollInfo.success;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.securityId;
        int hashCode = str == null ? 0 : str.hashCode();
        List<String> list = this.verificationMethodInfos;
        int hashCode2 = list != null ? list.hashCode() : 0;
        boolean z = this.success;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((hashCode * 31) + hashCode2) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DerollInfo(securityId=");
        sb.append(this.securityId);
        sb.append(", verificationMethodInfos=");
        sb.append(this.verificationMethodInfos);
        sb.append(", success=");
        sb.append(this.success);
        sb.append(')');
        return sb.toString();
    }

    public DerollInfo(String str, List<String> list, boolean z) {
        this.securityId = str;
        this.verificationMethodInfos = list;
        this.success = z;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "setSecurityId")
    public final void setSecurityId(String str) {
        this.securityId = str;
    }

    public /* synthetic */ DerollInfo(String str, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? false : z);
    }

    @JvmName(name = "getVerificationMethodInfos")
    public final List<String> getVerificationMethodInfos() {
        return this.verificationMethodInfos;
    }

    @JvmName(name = "setVerificationMethodInfos")
    public final void setVerificationMethodInfos(List<String> list) {
        this.verificationMethodInfos = list;
    }

    @JvmName(name = "getSuccess")
    public final boolean getSuccess() {
        return this.success;
    }

    @JvmName(name = "setSuccess")
    public final void setSuccess(boolean z) {
        this.success = z;
    }
}
