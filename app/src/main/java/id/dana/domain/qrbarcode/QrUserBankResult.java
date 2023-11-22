package id.dana.domain.qrbarcode;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/domain/qrbarcode/QrUserBankResult;", "Lid/dana/domain/qrbarcode/QrUserResult;", "", "component1", "()J", "component2", "expireTimeInSecond", "expireDateTimestamp", "copy", "(JJ)Lid/dana/domain/qrbarcode/QrUserBankResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "J", "getExpireDateTimestamp", "getExpireTimeInSecond", "<init>", "(JJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QrUserBankResult extends QrUserResult {
    private final long expireDateTimestamp;
    private final long expireTimeInSecond;

    public static /* synthetic */ QrUserBankResult copy$default(QrUserBankResult qrUserBankResult, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = qrUserBankResult.expireTimeInSecond;
        }
        if ((i & 2) != 0) {
            j2 = qrUserBankResult.expireDateTimestamp;
        }
        return qrUserBankResult.copy(j, j2);
    }

    /* renamed from: component1  reason: from getter */
    public final long getExpireTimeInSecond() {
        return this.expireTimeInSecond;
    }

    /* renamed from: component2  reason: from getter */
    public final long getExpireDateTimestamp() {
        return this.expireDateTimestamp;
    }

    public final QrUserBankResult copy(long expireTimeInSecond, long expireDateTimestamp) {
        return new QrUserBankResult(expireTimeInSecond, expireDateTimestamp);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QrUserBankResult) {
            QrUserBankResult qrUserBankResult = (QrUserBankResult) other;
            return this.expireTimeInSecond == qrUserBankResult.expireTimeInSecond && this.expireDateTimestamp == qrUserBankResult.expireDateTimestamp;
        }
        return false;
    }

    public final int hashCode() {
        return (Cbor$Arg$$ExternalSyntheticBackport0.m(this.expireTimeInSecond) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.expireDateTimestamp);
    }

    @Override // id.dana.utils.rpc.response.BaseRpcResponse
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QrUserBankResult(expireTimeInSecond=");
        sb.append(this.expireTimeInSecond);
        sb.append(", expireDateTimestamp=");
        sb.append(this.expireDateTimestamp);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getExpireTimeInSecond")
    public final long getExpireTimeInSecond() {
        return this.expireTimeInSecond;
    }

    @JvmName(name = "getExpireDateTimestamp")
    public final long getExpireDateTimestamp() {
        return this.expireDateTimestamp;
    }

    public QrUserBankResult(long j, long j2) {
        this.expireTimeInSecond = j;
        this.expireDateTimestamp = j2;
    }
}
