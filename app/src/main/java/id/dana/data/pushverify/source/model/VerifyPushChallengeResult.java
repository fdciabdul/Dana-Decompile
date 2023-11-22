package id.dana.data.pushverify.source.model;

import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/data/pushverify/source/model/VerifyPushChallengeResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Z", "verified", "copy", "(Z)Lid/dana/data/pushverify/source/model/VerifyPushChallengeResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getVerified", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VerifyPushChallengeResult extends BaseRpcResultAphome {
    private final boolean verified;

    public VerifyPushChallengeResult() {
        this(false, 1, null);
    }

    public static /* synthetic */ VerifyPushChallengeResult copy$default(VerifyPushChallengeResult verifyPushChallengeResult, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = verifyPushChallengeResult.verified;
        }
        return verifyPushChallengeResult.copy(z);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getVerified() {
        return this.verified;
    }

    public final VerifyPushChallengeResult copy(boolean verified) {
        return new VerifyPushChallengeResult(verified);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof VerifyPushChallengeResult) && this.verified == ((VerifyPushChallengeResult) other).verified;
    }

    public final int hashCode() {
        boolean z = this.verified;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerifyPushChallengeResult(verified=");
        sb.append(this.verified);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ VerifyPushChallengeResult(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    @JvmName(name = "getVerified")
    public final boolean getVerified() {
        return this.verified;
    }

    public VerifyPushChallengeResult(boolean z) {
        this.verified = z;
    }
}
