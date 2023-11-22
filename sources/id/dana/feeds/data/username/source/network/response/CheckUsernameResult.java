package id.dana.feeds.data.username.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/username/source/network/response/CheckUsernameResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/Boolean;", "exists", "copy", "(Ljava/lang/Boolean;)Lid/dana/feeds/data/username/source/network/response/CheckUsernameResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/feeds/domain/username/model/UserProfileResponse;", "toUserProfileResponse", "()Lid/dana/feeds/domain/username/model/UserProfileResponse;", "Ljava/lang/Boolean;", "getExists", "<init>", "(Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CheckUsernameResult extends BaseRpcResult {
    private final Boolean exists;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CheckUsernameResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.username.source.network.response.CheckUsernameResult.<init>():void");
    }

    public static /* synthetic */ CheckUsernameResult copy$default(CheckUsernameResult checkUsernameResult, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = checkUsernameResult.exists;
        }
        return checkUsernameResult.copy(bool);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getExists() {
        return this.exists;
    }

    public final CheckUsernameResult copy(Boolean exists) {
        return new CheckUsernameResult(exists);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CheckUsernameResult) && Intrinsics.areEqual(this.exists, ((CheckUsernameResult) other).exists);
    }

    public final int hashCode() {
        Boolean bool = this.exists;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CheckUsernameResult(exists=");
        sb.append(this.exists);
        sb.append(')');
        return sb.toString();
    }

    public CheckUsernameResult(Boolean bool) {
        this.exists = bool;
    }

    public /* synthetic */ CheckUsernameResult(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Boolean.FALSE : bool);
    }

    @JvmName(name = "getExists")
    public final Boolean getExists() {
        return this.exists;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.feeds.domain.username.model.UserProfileResponse toUserProfileResponse() {
        /*
            r4 = this;
            boolean r0 = r4.success
            java.lang.Boolean r1 = r4.exists
            java.lang.String r2 = ""
            if (r1 == 0) goto L14
            boolean r3 = r1.booleanValue()
            if (r3 != 0) goto Lf
            r1 = 0
        Lf:
            if (r1 == 0) goto L14
            java.lang.String r1 = "AE15112158172914"
            goto L19
        L14:
            java.lang.String r1 = r4.errorCode
            if (r1 != 0) goto L19
            r1 = r2
        L19:
            java.lang.String r3 = r4.errorMessage
            if (r3 == 0) goto L1e
            r2 = r3
        L1e:
            id.dana.feeds.domain.username.model.UserProfileResponse r3 = new id.dana.feeds.domain.username.model.UserProfileResponse
            r3.<init>(r0, r1, r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.username.source.network.response.CheckUsernameResult.toUserProfileResponse():id.dana.feeds.domain.username.model.UserProfileResponse");
    }
}
