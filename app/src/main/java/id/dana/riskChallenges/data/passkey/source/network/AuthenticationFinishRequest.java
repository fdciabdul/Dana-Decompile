package id.dana.riskChallenges.data.passkey.source.network;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\b\u001a\u00020\u0002\u0012\b\b\u0001\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0003\u0010\b\u001a\u00020\u00022\b\b\u0003\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/riskChallenges/data/passkey/source/network/AuthenticationFinishRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "Lcom/alibaba/fastjson/JSONObject;", "component2", "()Lcom/alibaba/fastjson/JSONObject;", "userId", "credential", "copy", "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;)Lid/dana/riskChallenges/data/passkey/source/network/AuthenticationFinishRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lcom/alibaba/fastjson/JSONObject;", "getCredential", "Ljava/lang/String;", "getUserId", "<init>", "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AuthenticationFinishRequest extends BaseRpcRequest {
    @SerializedName("credential")
    private final JSONObject credential;
    @SerializedName("userId")
    private final String userId;

    public static /* synthetic */ AuthenticationFinishRequest copy$default(AuthenticationFinishRequest authenticationFinishRequest, String str, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authenticationFinishRequest.userId;
        }
        if ((i & 2) != 0) {
            jSONObject = authenticationFinishRequest.credential;
        }
        return authenticationFinishRequest.copy(str, jSONObject);
    }

    /* renamed from: component1  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component2  reason: from getter */
    public final JSONObject getCredential() {
        return this.credential;
    }

    public final AuthenticationFinishRequest copy(@JSONField(name = "userId") String userId, @JSONField(name = "credential") JSONObject credential) {
        Intrinsics.checkNotNullParameter(userId, "");
        Intrinsics.checkNotNullParameter(credential, "");
        return new AuthenticationFinishRequest(userId, credential);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AuthenticationFinishRequest) {
            AuthenticationFinishRequest authenticationFinishRequest = (AuthenticationFinishRequest) other;
            return Intrinsics.areEqual(this.userId, authenticationFinishRequest.userId) && Intrinsics.areEqual(this.credential, authenticationFinishRequest.credential);
        }
        return false;
    }

    public final int hashCode() {
        return (this.userId.hashCode() * 31) + this.credential.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AuthenticationFinishRequest(userId=");
        sb.append(this.userId);
        sb.append(", credential=");
        sb.append(this.credential);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "getCredential")
    public final JSONObject getCredential() {
        return this.credential;
    }

    public AuthenticationFinishRequest(@JSONField(name = "userId") String str, @JSONField(name = "credential") JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(jSONObject, "");
        this.userId = str;
        this.credential = jSONObject;
    }
}
