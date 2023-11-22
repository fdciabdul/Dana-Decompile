package id.dana.domain.user;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0007\u001a\u00020\u00002\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0005"}, d2 = {"Lid/dana/domain/user/MiniProgramUserInfoResponse;", "", "", "", "component1", "()Ljava/util/Map;", "userInfo", "copy", "(Ljava/util/Map;)Lid/dana/domain/user/MiniProgramUserInfoResponse;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/Map;", "getUserInfo", "<init>", "(Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MiniProgramUserInfoResponse {
    private final Map<String, String> userInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MiniProgramUserInfoResponse copy$default(MiniProgramUserInfoResponse miniProgramUserInfoResponse, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = miniProgramUserInfoResponse.userInfo;
        }
        return miniProgramUserInfoResponse.copy(map);
    }

    public final Map<String, String> component1() {
        return this.userInfo;
    }

    public final MiniProgramUserInfoResponse copy(Map<String, String> userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "");
        return new MiniProgramUserInfoResponse(userInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MiniProgramUserInfoResponse) && Intrinsics.areEqual(this.userInfo, ((MiniProgramUserInfoResponse) other).userInfo);
    }

    public final int hashCode() {
        return this.userInfo.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MiniProgramUserInfoResponse(userInfo=");
        sb.append(this.userInfo);
        sb.append(')');
        return sb.toString();
    }

    public MiniProgramUserInfoResponse(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.userInfo = map;
    }

    @JvmName(name = "getUserInfo")
    public final Map<String, String> getUserInfo() {
        return this.userInfo;
    }
}
