package id.dana.cashier.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/cashier/domain/model/TransactionFeeView;", "", "", "component1", "()Ljava/lang/String;", "component2", "ratio", "amount", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/domain/model/TransactionFeeView;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAmount", "getRatio", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TransactionFeeView {
    private final String amount;
    private final String ratio;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TransactionFeeView() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.domain.model.TransactionFeeView.<init>():void");
    }

    public static /* synthetic */ TransactionFeeView copy$default(TransactionFeeView transactionFeeView, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = transactionFeeView.ratio;
        }
        if ((i & 2) != 0) {
            str2 = transactionFeeView.amount;
        }
        return transactionFeeView.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getRatio() {
        return this.ratio;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    public final TransactionFeeView copy(String ratio, String amount) {
        return new TransactionFeeView(ratio, amount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TransactionFeeView) {
            TransactionFeeView transactionFeeView = (TransactionFeeView) other;
            return Intrinsics.areEqual(this.ratio, transactionFeeView.ratio) && Intrinsics.areEqual(this.amount, transactionFeeView.amount);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.ratio;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.amount;
        return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransactionFeeView(ratio=");
        sb.append(this.ratio);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(')');
        return sb.toString();
    }

    public TransactionFeeView(String str, String str2) {
        this.ratio = str;
        this.amount = str2;
    }

    public /* synthetic */ TransactionFeeView(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    @JvmName(name = "getRatio")
    public final String getRatio() {
        return this.ratio;
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }
}
