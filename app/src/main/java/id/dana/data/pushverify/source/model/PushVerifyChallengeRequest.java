package id.dana.data.pushverify.source.model;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.constant.BranchLinkConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004"}, d2 = {"Lid/dana/data/pushverify/source/model/PushVerifyChallengeRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", BranchLinkConstant.PushVerifyParams.TRANSACTION_ID, "cacheKey", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/pushverify/source/model/PushVerifyChallengeRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCacheKey", "getTrxId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PushVerifyChallengeRequest extends BaseRpcRequest {
    private final String cacheKey;
    private final String trxId;

    public static /* synthetic */ PushVerifyChallengeRequest copy$default(PushVerifyChallengeRequest pushVerifyChallengeRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pushVerifyChallengeRequest.trxId;
        }
        if ((i & 2) != 0) {
            str2 = pushVerifyChallengeRequest.cacheKey;
        }
        return pushVerifyChallengeRequest.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTrxId() {
        return this.trxId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final PushVerifyChallengeRequest copy(String trxId, String cacheKey) {
        Intrinsics.checkNotNullParameter(trxId, "");
        Intrinsics.checkNotNullParameter(cacheKey, "");
        return new PushVerifyChallengeRequest(trxId, cacheKey);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PushVerifyChallengeRequest) {
            PushVerifyChallengeRequest pushVerifyChallengeRequest = (PushVerifyChallengeRequest) other;
            return Intrinsics.areEqual(this.trxId, pushVerifyChallengeRequest.trxId) && Intrinsics.areEqual(this.cacheKey, pushVerifyChallengeRequest.cacheKey);
        }
        return false;
    }

    public final int hashCode() {
        return (this.trxId.hashCode() * 31) + this.cacheKey.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PushVerifyChallengeRequest(trxId=");
        sb.append(this.trxId);
        sb.append(", cacheKey=");
        sb.append(this.cacheKey);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getTrxId")
    public final String getTrxId() {
        return this.trxId;
    }

    @JvmName(name = "getCacheKey")
    public final String getCacheKey() {
        return this.cacheKey;
    }

    public PushVerifyChallengeRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.trxId = str;
        this.cacheKey = str2;
    }
}
