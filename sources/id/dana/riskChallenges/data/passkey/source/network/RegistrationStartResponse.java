package id.dana.riskChallenges.data.passkey.source.network;

import com.alibaba.fastjson.JSONObject;
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

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0001\u0010\r\u001a\u00020\u0005\u0012\u0010\b\u0003\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b$\u0010%J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\r\u001a\u00020\u00052\u0010\b\u0003\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0007R$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\r\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010#"}, d2 = {"Lid/dana/riskChallenges/data/passkey/source/network/RegistrationStartResponse;", "Lid/dana/network/base/BaseRpcResultAphome;", "Lcom/alibaba/fastjson/JSONObject;", "component1", "()Lcom/alibaba/fastjson/JSONObject;", "", "component2", "()Ljava/lang/String;", "", "Lid/dana/riskChallenges/ui/resetpin/model/VerificationMethodModel;", "component3", "()Ljava/util/List;", "publicKeyCredentialCreationOptions", BioUtilityBridge.SECURITY_ID, "verificationMethods", "copy", "(Lcom/alibaba/fastjson/JSONObject;Ljava/lang/String;Ljava/util/List;)Lid/dana/riskChallenges/data/passkey/source/network/RegistrationStartResponse;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lcom/alibaba/fastjson/JSONObject;", "getPublicKeyCredentialCreationOptions", "setPublicKeyCredentialCreationOptions", "(Lcom/alibaba/fastjson/JSONObject;)V", "Ljava/lang/String;", "getSecurityId", "Ljava/util/List;", "getVerificationMethods", "setVerificationMethods", "(Ljava/util/List;)V", "<init>", "(Lcom/alibaba/fastjson/JSONObject;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RegistrationStartResponse extends BaseRpcResultAphome {
    @SerializedName("publicKeyCredentialCreationOptions")
    private JSONObject publicKeyCredentialCreationOptions;
    @SerializedName(BioUtilityBridge.SECURITY_ID)
    private final String securityId;
    @SerializedName("verificationMethods")
    private List<VerificationMethodModel> verificationMethods;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RegistrationStartResponse copy$default(RegistrationStartResponse registrationStartResponse, JSONObject jSONObject, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = registrationStartResponse.publicKeyCredentialCreationOptions;
        }
        if ((i & 2) != 0) {
            str = registrationStartResponse.securityId;
        }
        if ((i & 4) != 0) {
            list = registrationStartResponse.verificationMethods;
        }
        return registrationStartResponse.copy(jSONObject, str, list);
    }

    /* renamed from: component1  reason: from getter */
    public final JSONObject getPublicKeyCredentialCreationOptions() {
        return this.publicKeyCredentialCreationOptions;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    public final List<VerificationMethodModel> component3() {
        return this.verificationMethods;
    }

    public final RegistrationStartResponse copy(@JSONField(name = "publicKeyCredentialCreationOptions") JSONObject publicKeyCredentialCreationOptions, @JSONField(name = "securityId") String securityId, @JSONField(name = "verificationMethods") List<VerificationMethodModel> verificationMethods) {
        Intrinsics.checkNotNullParameter(securityId, "");
        return new RegistrationStartResponse(publicKeyCredentialCreationOptions, securityId, verificationMethods);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RegistrationStartResponse) {
            RegistrationStartResponse registrationStartResponse = (RegistrationStartResponse) other;
            return Intrinsics.areEqual(this.publicKeyCredentialCreationOptions, registrationStartResponse.publicKeyCredentialCreationOptions) && Intrinsics.areEqual(this.securityId, registrationStartResponse.securityId) && Intrinsics.areEqual(this.verificationMethods, registrationStartResponse.verificationMethods);
        }
        return false;
    }

    public final int hashCode() {
        JSONObject jSONObject = this.publicKeyCredentialCreationOptions;
        int hashCode = jSONObject == null ? 0 : jSONObject.hashCode();
        int hashCode2 = this.securityId.hashCode();
        List<VerificationMethodModel> list = this.verificationMethods;
        return (((hashCode * 31) + hashCode2) * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RegistrationStartResponse(publicKeyCredentialCreationOptions=");
        sb.append(this.publicKeyCredentialCreationOptions);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", verificationMethods=");
        sb.append(this.verificationMethods);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ RegistrationStartResponse(JSONObject jSONObject, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new JSONObject() : jSONObject, str, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getPublicKeyCredentialCreationOptions")
    public final JSONObject getPublicKeyCredentialCreationOptions() {
        return this.publicKeyCredentialCreationOptions;
    }

    @JvmName(name = "setPublicKeyCredentialCreationOptions")
    public final void setPublicKeyCredentialCreationOptions(JSONObject jSONObject) {
        this.publicKeyCredentialCreationOptions = jSONObject;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getVerificationMethods")
    public final List<VerificationMethodModel> getVerificationMethods() {
        return this.verificationMethods;
    }

    @JvmName(name = "setVerificationMethods")
    public final void setVerificationMethods(List<VerificationMethodModel> list) {
        this.verificationMethods = list;
    }

    public RegistrationStartResponse(@JSONField(name = "publicKeyCredentialCreationOptions") JSONObject jSONObject, @JSONField(name = "securityId") String str, @JSONField(name = "verificationMethods") List<VerificationMethodModel> list) {
        Intrinsics.checkNotNullParameter(str, "");
        this.publicKeyCredentialCreationOptions = jSONObject;
        this.securityId = str;
        this.verificationMethods = list;
    }
}
