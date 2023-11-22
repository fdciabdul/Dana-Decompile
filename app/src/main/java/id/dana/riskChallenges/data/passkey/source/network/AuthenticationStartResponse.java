package id.dana.riskChallenges.data.passkey.source.network;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/riskChallenges/data/passkey/source/network/AuthenticationStartResponse;", "Lid/dana/network/base/BaseRpcResultAphome;", "Lcom/alibaba/fastjson/JSONObject;", "component1", "()Lcom/alibaba/fastjson/JSONObject;", "publicKeyCredentialRequestOptions", "copy", "(Lcom/alibaba/fastjson/JSONObject;)Lid/dana/riskChallenges/data/passkey/source/network/AuthenticationStartResponse;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/alibaba/fastjson/JSONObject;", "getPublicKeyCredentialRequestOptions", "<init>", "(Lcom/alibaba/fastjson/JSONObject;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AuthenticationStartResponse extends BaseRpcResultAphome {
    @SerializedName("publicKeyCredentialRequestOptions")
    private final JSONObject publicKeyCredentialRequestOptions;

    public static /* synthetic */ AuthenticationStartResponse copy$default(AuthenticationStartResponse authenticationStartResponse, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = authenticationStartResponse.publicKeyCredentialRequestOptions;
        }
        return authenticationStartResponse.copy(jSONObject);
    }

    /* renamed from: component1  reason: from getter */
    public final JSONObject getPublicKeyCredentialRequestOptions() {
        return this.publicKeyCredentialRequestOptions;
    }

    public final AuthenticationStartResponse copy(@JSONField(name = "publicKeyCredentialRequestOptions") JSONObject publicKeyCredentialRequestOptions) {
        Intrinsics.checkNotNullParameter(publicKeyCredentialRequestOptions, "");
        return new AuthenticationStartResponse(publicKeyCredentialRequestOptions);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AuthenticationStartResponse) && Intrinsics.areEqual(this.publicKeyCredentialRequestOptions, ((AuthenticationStartResponse) other).publicKeyCredentialRequestOptions);
    }

    public final int hashCode() {
        return this.publicKeyCredentialRequestOptions.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AuthenticationStartResponse(publicKeyCredentialRequestOptions=");
        sb.append(this.publicKeyCredentialRequestOptions);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getPublicKeyCredentialRequestOptions")
    public final JSONObject getPublicKeyCredentialRequestOptions() {
        return this.publicKeyCredentialRequestOptions;
    }

    public AuthenticationStartResponse(@JSONField(name = "publicKeyCredentialRequestOptions") JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "");
        this.publicKeyCredentialRequestOptions = jSONObject;
    }
}
