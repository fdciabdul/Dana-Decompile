package id.dana.kyb.domain.model;

import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.requestmoney.BundleKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007"}, d2 = {"Lid/dana/kyb/domain/model/KybRequestPayment;", "", "", "component1", "()Z", "Lid/dana/domain/nearbyme/model/MoneyView;", "component2", "()Lid/dana/domain/nearbyme/model/MoneyView;", "enableStatus", BundleKey.MINIMUM_AMOUNT, "copy", "(ZLid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/kyb/domain/model/KybRequestPayment;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getEnableStatus", "Lid/dana/domain/nearbyme/model/MoneyView;", "getMinAmount", "<init>", "(ZLid/dana/domain/nearbyme/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybRequestPayment {
    private final boolean enableStatus;
    private final MoneyView minAmount;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.domain.nearbyme.model.MoneyView, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public KybRequestPayment() {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            r2 = 3
            r3.<init>(r1, r0, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.domain.model.KybRequestPayment.<init>():void");
    }

    public static /* synthetic */ KybRequestPayment copy$default(KybRequestPayment kybRequestPayment, boolean z, MoneyView moneyView, int i, Object obj) {
        if ((i & 1) != 0) {
            z = kybRequestPayment.enableStatus;
        }
        if ((i & 2) != 0) {
            moneyView = kybRequestPayment.minAmount;
        }
        return kybRequestPayment.copy(z, moneyView);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnableStatus() {
        return this.enableStatus;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyView getMinAmount() {
        return this.minAmount;
    }

    public final KybRequestPayment copy(boolean enableStatus, MoneyView minAmount) {
        Intrinsics.checkNotNullParameter(minAmount, "");
        return new KybRequestPayment(enableStatus, minAmount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KybRequestPayment) {
            KybRequestPayment kybRequestPayment = (KybRequestPayment) other;
            return this.enableStatus == kybRequestPayment.enableStatus && Intrinsics.areEqual(this.minAmount, kybRequestPayment.minAmount);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.enableStatus;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.minAmount.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybRequestPayment(enableStatus=");
        sb.append(this.enableStatus);
        sb.append(", minAmount=");
        sb.append(this.minAmount);
        sb.append(')');
        return sb.toString();
    }

    public KybRequestPayment(boolean z, MoneyView moneyView) {
        Intrinsics.checkNotNullParameter(moneyView, "");
        this.enableStatus = z;
        this.minAmount = moneyView;
    }

    @JvmName(name = "getEnableStatus")
    public final boolean getEnableStatus() {
        return this.enableStatus;
    }

    public /* synthetic */ KybRequestPayment(boolean z, MoneyView moneyView, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView);
    }

    @JvmName(name = "getMinAmount")
    public final MoneyView getMinAmount() {
        return this.minAmount;
    }
}
