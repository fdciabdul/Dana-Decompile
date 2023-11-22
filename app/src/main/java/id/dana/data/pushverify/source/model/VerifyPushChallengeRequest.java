package id.dana.data.pushverify.source.model;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.constant.BranchLinkConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JJ\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004R\u0017\u0010\r\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b \u0010\u0004"}, d2 = {"Lid/dana/data/pushverify/source/model/VerifyPushChallengeRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "component4", "component5", "tokenId", "tokenPair", "approveVerify", BranchLinkConstant.PushVerifyParams.TRANSACTION_ID, "cacheKey", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)Lid/dana/data/pushverify/source/model/VerifyPushChallengeRequest;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getApproveVerify", "Ljava/lang/String;", "getCacheKey", "getTokenId", "getTokenPair", "getTrxId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VerifyPushChallengeRequest extends BaseRpcRequest {
    private final boolean approveVerify;
    private final String cacheKey;
    private final String tokenId;
    private final String tokenPair;
    private final String trxId;

    public static /* synthetic */ VerifyPushChallengeRequest copy$default(VerifyPushChallengeRequest verifyPushChallengeRequest, String str, String str2, boolean z, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = verifyPushChallengeRequest.tokenId;
        }
        if ((i & 2) != 0) {
            str2 = verifyPushChallengeRequest.tokenPair;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            z = verifyPushChallengeRequest.approveVerify;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            str3 = verifyPushChallengeRequest.trxId;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = verifyPushChallengeRequest.cacheKey;
        }
        return verifyPushChallengeRequest.copy(str, str5, z2, str6, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTokenId() {
        return this.tokenId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getTokenPair() {
        return this.tokenPair;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getApproveVerify() {
        return this.approveVerify;
    }

    /* renamed from: component4  reason: from getter */
    public final String getTrxId() {
        return this.trxId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final VerifyPushChallengeRequest copy(String tokenId, String tokenPair, boolean approveVerify, String trxId, String cacheKey) {
        return new VerifyPushChallengeRequest(tokenId, tokenPair, approveVerify, trxId, cacheKey);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VerifyPushChallengeRequest) {
            VerifyPushChallengeRequest verifyPushChallengeRequest = (VerifyPushChallengeRequest) other;
            return Intrinsics.areEqual(this.tokenId, verifyPushChallengeRequest.tokenId) && Intrinsics.areEqual(this.tokenPair, verifyPushChallengeRequest.tokenPair) && this.approveVerify == verifyPushChallengeRequest.approveVerify && Intrinsics.areEqual(this.trxId, verifyPushChallengeRequest.trxId) && Intrinsics.areEqual(this.cacheKey, verifyPushChallengeRequest.cacheKey);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.tokenId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.tokenPair;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        boolean z = this.approveVerify;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str3 = this.trxId;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.cacheKey;
        return (((((((hashCode * 31) + hashCode2) * 31) + i) * 31) + hashCode3) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerifyPushChallengeRequest(tokenId=");
        sb.append(this.tokenId);
        sb.append(", tokenPair=");
        sb.append(this.tokenPair);
        sb.append(", approveVerify=");
        sb.append(this.approveVerify);
        sb.append(", trxId=");
        sb.append(this.trxId);
        sb.append(", cacheKey=");
        sb.append(this.cacheKey);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ VerifyPushChallengeRequest(String str, String str2, boolean z, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, z, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
    }

    @JvmName(name = "getTokenId")
    public final String getTokenId() {
        return this.tokenId;
    }

    @JvmName(name = "getTokenPair")
    public final String getTokenPair() {
        return this.tokenPair;
    }

    @JvmName(name = "getApproveVerify")
    public final boolean getApproveVerify() {
        return this.approveVerify;
    }

    @JvmName(name = "getTrxId")
    public final String getTrxId() {
        return this.trxId;
    }

    @JvmName(name = "getCacheKey")
    public final String getCacheKey() {
        return this.cacheKey;
    }

    public VerifyPushChallengeRequest(String str, String str2, boolean z, String str3, String str4) {
        this.tokenId = str;
        this.tokenPair = str2;
        this.approveVerify = z;
        this.trxId = str3;
        this.cacheKey = str4;
    }
}
