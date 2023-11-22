package id.dana.network.response.autoroute;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/network/response/autoroute/SecurityContextResult;", "", "", "component1", "()Ljava/lang/String;", RecordError.KEY_PUB_KEY, "copy", "(Ljava/lang/String;)Lid/dana/network/response/autoroute/SecurityContextResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getPubKey", "setPubKey", "(Ljava/lang/String;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SecurityContextResult {
    private String pubKey;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SecurityContextResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.network.response.autoroute.SecurityContextResult.<init>():void");
    }

    public static /* synthetic */ SecurityContextResult copy$default(SecurityContextResult securityContextResult, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = securityContextResult.pubKey;
        }
        return securityContextResult.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPubKey() {
        return this.pubKey;
    }

    public final SecurityContextResult copy(String pubKey) {
        return new SecurityContextResult(pubKey);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SecurityContextResult) && Intrinsics.areEqual(this.pubKey, ((SecurityContextResult) other).pubKey);
    }

    public final int hashCode() {
        String str = this.pubKey;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SecurityContextResult(pubKey=");
        sb.append(this.pubKey);
        sb.append(')');
        return sb.toString();
    }

    public SecurityContextResult(String str) {
        this.pubKey = str;
    }

    public /* synthetic */ SecurityContextResult(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    @JvmName(name = "getPubKey")
    public final String getPubKey() {
        return this.pubKey;
    }

    @JvmName(name = "setPubKey")
    public final void setPubKey(String str) {
        this.pubKey = str;
    }
}
