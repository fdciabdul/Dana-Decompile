package id.dana.riskChallenges.data.passkey.source.network;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.network.base.BaseRpcResultAphome;
import id.dana.riskChallenges.ui.resetpin.model.VerificationMethodModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\u000e\b\u0003\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\t\u001a\u00020\u00022\u000e\b\u0003\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/riskChallenges/data/passkey/source/network/RemoveCredentialResponse;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Ljava/lang/String;", "", "Lid/dana/riskChallenges/ui/resetpin/model/VerificationMethodModel;", "component2", "()Ljava/util/List;", BioUtilityBridge.SECURITY_ID, "verificationMethods", "copy", "(Ljava/lang/String;Ljava/util/List;)Lid/dana/riskChallenges/data/passkey/source/network/RemoveCredentialResponse;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getSecurityId", "Ljava/util/List;", "getVerificationMethods", "setVerificationMethods", "(Ljava/util/List;)V", "<init>", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RemoveCredentialResponse extends BaseRpcResultAphome {
    @SerializedName(BioUtilityBridge.SECURITY_ID)
    private final String securityId;
    @SerializedName("verificationMethods")
    private List<VerificationMethodModel> verificationMethods;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RemoveCredentialResponse copy$default(RemoveCredentialResponse removeCredentialResponse, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = removeCredentialResponse.securityId;
        }
        if ((i & 2) != 0) {
            list = removeCredentialResponse.verificationMethods;
        }
        return removeCredentialResponse.copy(str, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    public final List<VerificationMethodModel> component2() {
        return this.verificationMethods;
    }

    public final RemoveCredentialResponse copy(@JSONField(name = "securityId") String securityId, @JSONField(name = "verificationMethods") List<VerificationMethodModel> verificationMethods) {
        Intrinsics.checkNotNullParameter(securityId, "");
        Intrinsics.checkNotNullParameter(verificationMethods, "");
        return new RemoveCredentialResponse(securityId, verificationMethods);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RemoveCredentialResponse) {
            RemoveCredentialResponse removeCredentialResponse = (RemoveCredentialResponse) other;
            return Intrinsics.areEqual(this.securityId, removeCredentialResponse.securityId) && Intrinsics.areEqual(this.verificationMethods, removeCredentialResponse.verificationMethods);
        }
        return false;
    }

    public final int hashCode() {
        return (this.securityId.hashCode() * 31) + this.verificationMethods.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RemoveCredentialResponse(securityId=");
        sb.append(this.securityId);
        sb.append(", verificationMethods=");
        sb.append(this.verificationMethods);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    public /* synthetic */ RemoveCredentialResponse(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getVerificationMethods")
    public final List<VerificationMethodModel> getVerificationMethods() {
        return this.verificationMethods;
    }

    @JvmName(name = "setVerificationMethods")
    public final void setVerificationMethods(List<VerificationMethodModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.verificationMethods = list;
    }

    public RemoveCredentialResponse(@JSONField(name = "securityId") String str, @JSONField(name = "verificationMethods") List<VerificationMethodModel> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.securityId = str;
        this.verificationMethods = list;
    }
}
