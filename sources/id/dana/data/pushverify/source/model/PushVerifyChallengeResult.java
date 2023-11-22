package id.dana.data.pushverify.source.model;

import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007"}, d2 = {"Lid/dana/data/pushverify/source/model/PushVerifyChallengeResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Ljava/lang/String;", "Lid/dana/data/pushverify/source/model/PushVerificationDetailResult;", "component2", "()Lid/dana/data/pushverify/source/model/PushVerificationDetailResult;", "tokenPair", "verificationDetail", "copy", "(Ljava/lang/String;Lid/dana/data/pushverify/source/model/PushVerificationDetailResult;)Lid/dana/data/pushverify/source/model/PushVerifyChallengeResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getTokenPair", "Lid/dana/data/pushverify/source/model/PushVerificationDetailResult;", "getVerificationDetail", "<init>", "(Ljava/lang/String;Lid/dana/data/pushverify/source/model/PushVerificationDetailResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PushVerifyChallengeResult extends BaseRpcResultAphome {
    private final String tokenPair;
    private final PushVerificationDetailResult verificationDetail;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.data.pushverify.source.model.PushVerificationDetailResult, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PushVerifyChallengeResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.pushverify.source.model.PushVerifyChallengeResult.<init>():void");
    }

    public static /* synthetic */ PushVerifyChallengeResult copy$default(PushVerifyChallengeResult pushVerifyChallengeResult, String str, PushVerificationDetailResult pushVerificationDetailResult, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pushVerifyChallengeResult.tokenPair;
        }
        if ((i & 2) != 0) {
            pushVerificationDetailResult = pushVerifyChallengeResult.verificationDetail;
        }
        return pushVerifyChallengeResult.copy(str, pushVerificationDetailResult);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTokenPair() {
        return this.tokenPair;
    }

    /* renamed from: component2  reason: from getter */
    public final PushVerificationDetailResult getVerificationDetail() {
        return this.verificationDetail;
    }

    public final PushVerifyChallengeResult copy(String tokenPair, PushVerificationDetailResult verificationDetail) {
        return new PushVerifyChallengeResult(tokenPair, verificationDetail);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PushVerifyChallengeResult) {
            PushVerifyChallengeResult pushVerifyChallengeResult = (PushVerifyChallengeResult) other;
            return Intrinsics.areEqual(this.tokenPair, pushVerifyChallengeResult.tokenPair) && Intrinsics.areEqual(this.verificationDetail, pushVerifyChallengeResult.verificationDetail);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.tokenPair;
        int hashCode = str == null ? 0 : str.hashCode();
        PushVerificationDetailResult pushVerificationDetailResult = this.verificationDetail;
        return (hashCode * 31) + (pushVerificationDetailResult != null ? pushVerificationDetailResult.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PushVerifyChallengeResult(tokenPair=");
        sb.append(this.tokenPair);
        sb.append(", verificationDetail=");
        sb.append(this.verificationDetail);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ PushVerifyChallengeResult(String str, PushVerificationDetailResult pushVerificationDetailResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : pushVerificationDetailResult);
    }

    @JvmName(name = "getTokenPair")
    public final String getTokenPair() {
        return this.tokenPair;
    }

    @JvmName(name = "getVerificationDetail")
    public final PushVerificationDetailResult getVerificationDetail() {
        return this.verificationDetail;
    }

    public PushVerifyChallengeResult(String str, PushVerificationDetailResult pushVerificationDetailResult) {
        this.tokenPair = str;
        this.verificationDetail = pushVerificationDetailResult;
    }
}
