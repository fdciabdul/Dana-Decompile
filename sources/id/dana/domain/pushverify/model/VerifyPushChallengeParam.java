package id.dana.domain.pushverify.model;

import id.dana.danah5.transactionstatus.TransactionStatusBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004R\u0017\u0010\r\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001f\u0010\u0004"}, d2 = {"Lid/dana/domain/pushverify/model/VerifyPushChallengeParam;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "component4", "component5", "token", "tokenPair", "approveVerify", TransactionStatusBridge.Companion.TransactionStatusParamKey.TRANSACTION_ID, "cacheKey", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)Lid/dana/domain/pushverify/model/VerifyPushChallengeParam;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getApproveVerify", "Ljava/lang/String;", "getCacheKey", "getToken", "getTokenPair", "getTransactionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VerifyPushChallengeParam {
    private final boolean approveVerify;
    private final String cacheKey;
    private final String token;
    private final String tokenPair;
    private final String transactionId;

    public static /* synthetic */ VerifyPushChallengeParam copy$default(VerifyPushChallengeParam verifyPushChallengeParam, String str, String str2, boolean z, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = verifyPushChallengeParam.token;
        }
        if ((i & 2) != 0) {
            str2 = verifyPushChallengeParam.tokenPair;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            z = verifyPushChallengeParam.approveVerify;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            str3 = verifyPushChallengeParam.transactionId;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = verifyPushChallengeParam.cacheKey;
        }
        return verifyPushChallengeParam.copy(str, str5, z2, str6, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getToken() {
        return this.token;
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
    public final String getTransactionId() {
        return this.transactionId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final VerifyPushChallengeParam copy(String token, String tokenPair, boolean approveVerify, String transactionId, String cacheKey) {
        Intrinsics.checkNotNullParameter(token, "");
        Intrinsics.checkNotNullParameter(tokenPair, "");
        Intrinsics.checkNotNullParameter(transactionId, "");
        Intrinsics.checkNotNullParameter(cacheKey, "");
        return new VerifyPushChallengeParam(token, tokenPair, approveVerify, transactionId, cacheKey);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VerifyPushChallengeParam) {
            VerifyPushChallengeParam verifyPushChallengeParam = (VerifyPushChallengeParam) other;
            return Intrinsics.areEqual(this.token, verifyPushChallengeParam.token) && Intrinsics.areEqual(this.tokenPair, verifyPushChallengeParam.tokenPair) && this.approveVerify == verifyPushChallengeParam.approveVerify && Intrinsics.areEqual(this.transactionId, verifyPushChallengeParam.transactionId) && Intrinsics.areEqual(this.cacheKey, verifyPushChallengeParam.cacheKey);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.token.hashCode();
        int hashCode2 = this.tokenPair.hashCode();
        boolean z = this.approveVerify;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((hashCode * 31) + hashCode2) * 31) + i) * 31) + this.transactionId.hashCode()) * 31) + this.cacheKey.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerifyPushChallengeParam(token=");
        sb.append(this.token);
        sb.append(", tokenPair=");
        sb.append(this.tokenPair);
        sb.append(", approveVerify=");
        sb.append(this.approveVerify);
        sb.append(", transactionId=");
        sb.append(this.transactionId);
        sb.append(", cacheKey=");
        sb.append(this.cacheKey);
        sb.append(')');
        return sb.toString();
    }

    public VerifyPushChallengeParam(String str, String str2, boolean z, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.token = str;
        this.tokenPair = str2;
        this.approveVerify = z;
        this.transactionId = str3;
        this.cacheKey = str4;
    }

    public /* synthetic */ VerifyPushChallengeParam(String str, String str2, boolean z, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z, str3, (i & 16) != 0 ? "" : str4);
    }

    @JvmName(name = "getToken")
    public final String getToken() {
        return this.token;
    }

    @JvmName(name = "getTokenPair")
    public final String getTokenPair() {
        return this.tokenPair;
    }

    @JvmName(name = "getApproveVerify")
    public final boolean getApproveVerify() {
        return this.approveVerify;
    }

    @JvmName(name = "getTransactionId")
    public final String getTransactionId() {
        return this.transactionId;
    }

    @JvmName(name = "getCacheKey")
    public final String getCacheKey() {
        return this.cacheKey;
    }
}
