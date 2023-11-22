package id.dana.riskChallenges.data.passkey.source.network;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import id.dana.network.base.BaseRpcResultAphome;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005"}, d2 = {"Lid/dana/riskChallenges/data/passkey/source/network/QueryUserCredentialsResponse;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "Lcom/alibaba/fastjson/JSONObject;", "component1", "()Ljava/util/List;", "credentials", "copy", "(Ljava/util/List;)Lid/dana/riskChallenges/data/passkey/source/network/QueryUserCredentialsResponse;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getCredentials", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class QueryUserCredentialsResponse extends BaseRpcResultAphome {
    @SerializedName("credentials")
    private final List<JSONObject> credentials;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QueryUserCredentialsResponse copy$default(QueryUserCredentialsResponse queryUserCredentialsResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = queryUserCredentialsResponse.credentials;
        }
        return queryUserCredentialsResponse.copy(list);
    }

    public final List<JSONObject> component1() {
        return this.credentials;
    }

    public final QueryUserCredentialsResponse copy(@JSONField(name = "credentials") List<? extends JSONObject> credentials) {
        Intrinsics.checkNotNullParameter(credentials, "");
        return new QueryUserCredentialsResponse(credentials);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof QueryUserCredentialsResponse) && Intrinsics.areEqual(this.credentials, ((QueryUserCredentialsResponse) other).credentials);
    }

    public final int hashCode() {
        return this.credentials.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryUserCredentialsResponse(credentials=");
        sb.append(this.credentials);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getCredentials")
    public final List<JSONObject> getCredentials() {
        return this.credentials;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QueryUserCredentialsResponse(@JSONField(name = "credentials") List<? extends JSONObject> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.credentials = list;
    }
}
