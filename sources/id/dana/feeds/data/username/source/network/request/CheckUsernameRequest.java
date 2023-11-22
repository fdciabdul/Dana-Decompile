package id.dana.feeds.data.username.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.danah5.constant.BridgeName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/username/source/network/request/CheckUsernameRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "username", "copy", "(Ljava/lang/String;)Lid/dana/feeds/data/username/source/network/request/CheckUsernameRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", BridgeName.GET_USERNAME, "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CheckUsernameRequest extends BaseRpcRequest {
    private final String username;

    public static /* synthetic */ CheckUsernameRequest copy$default(CheckUsernameRequest checkUsernameRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkUsernameRequest.username;
        }
        return checkUsernameRequest.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    public final CheckUsernameRequest copy(String username) {
        Intrinsics.checkNotNullParameter(username, "");
        return new CheckUsernameRequest(username);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CheckUsernameRequest) && Intrinsics.areEqual(this.username, ((CheckUsernameRequest) other).username);
    }

    public final int hashCode() {
        return this.username.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CheckUsernameRequest(username=");
        sb.append(this.username);
        sb.append(')');
        return sb.toString();
    }

    public CheckUsernameRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.username = str;
    }

    @JvmName(name = BridgeName.GET_USERNAME)
    public final String getUsername() {
        return this.username;
    }
}
