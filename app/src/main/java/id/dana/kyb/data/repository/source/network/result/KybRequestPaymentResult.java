package id.dana.kyb.data.repository.source.network.result;

import id.dana.network.base.BaseRpcResultAphome;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007"}, d2 = {"Lid/dana/kyb/data/repository/source/network/result/KybRequestPaymentResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Z", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component2", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "vaEnableStatus", "vaMinAmount", "copy", "(ZLid/dana/network/response/expresspurchase/MoneyViewEntity;)Lid/dana/kyb/data/repository/source/network/result/KybRequestPaymentResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getVaEnableStatus", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getVaMinAmount", "<init>", "(ZLid/dana/network/response/expresspurchase/MoneyViewEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybRequestPaymentResult extends BaseRpcResultAphome {
    private final boolean vaEnableStatus;
    private final MoneyViewEntity vaMinAmount;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.network.response.expresspurchase.MoneyViewEntity] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public KybRequestPaymentResult() {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            r2 = 3
            r3.<init>(r1, r0, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.data.repository.source.network.result.KybRequestPaymentResult.<init>():void");
    }

    public static /* synthetic */ KybRequestPaymentResult copy$default(KybRequestPaymentResult kybRequestPaymentResult, boolean z, MoneyViewEntity moneyViewEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            z = kybRequestPaymentResult.vaEnableStatus;
        }
        if ((i & 2) != 0) {
            moneyViewEntity = kybRequestPaymentResult.vaMinAmount;
        }
        return kybRequestPaymentResult.copy(z, moneyViewEntity);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getVaEnableStatus() {
        return this.vaEnableStatus;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyViewEntity getVaMinAmount() {
        return this.vaMinAmount;
    }

    public final KybRequestPaymentResult copy(boolean vaEnableStatus, MoneyViewEntity vaMinAmount) {
        Intrinsics.checkNotNullParameter(vaMinAmount, "");
        return new KybRequestPaymentResult(vaEnableStatus, vaMinAmount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KybRequestPaymentResult) {
            KybRequestPaymentResult kybRequestPaymentResult = (KybRequestPaymentResult) other;
            return this.vaEnableStatus == kybRequestPaymentResult.vaEnableStatus && Intrinsics.areEqual(this.vaMinAmount, kybRequestPaymentResult.vaMinAmount);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.vaEnableStatus;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.vaMinAmount.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybRequestPaymentResult(vaEnableStatus=");
        sb.append(this.vaEnableStatus);
        sb.append(", vaMinAmount=");
        sb.append(this.vaMinAmount);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getVaEnableStatus")
    public final boolean getVaEnableStatus() {
        return this.vaEnableStatus;
    }

    public /* synthetic */ KybRequestPaymentResult(boolean z, MoneyViewEntity moneyViewEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? new MoneyViewEntity(null, null, null, 7, null) : moneyViewEntity);
    }

    @JvmName(name = "getVaMinAmount")
    public final MoneyViewEntity getVaMinAmount() {
        return this.vaMinAmount;
    }

    public KybRequestPaymentResult(boolean z, MoneyViewEntity moneyViewEntity) {
        Intrinsics.checkNotNullParameter(moneyViewEntity, "");
        this.vaEnableStatus = z;
        this.vaMinAmount = moneyViewEntity;
    }
}
