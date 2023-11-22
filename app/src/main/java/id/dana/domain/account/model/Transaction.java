package id.dana.domain.account.model;

import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/domain/account/model/Transaction;", "", "", "component1", "()Ljava/lang/String;", "component2", "type", MaintenanceBroadcastResult.KEY_DATE, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/account/model/Transaction;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getDate", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Transaction {
    private final String date;
    private final String type;

    public static /* synthetic */ Transaction copy$default(Transaction transaction, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = transaction.type;
        }
        if ((i & 2) != 0) {
            str2 = transaction.date;
        }
        return transaction.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2  reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final Transaction copy(String type, String date) {
        Intrinsics.checkNotNullParameter(type, "");
        Intrinsics.checkNotNullParameter(date, "");
        return new Transaction(type, date);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Transaction) {
            Transaction transaction = (Transaction) other;
            return Intrinsics.areEqual(this.type, transaction.type) && Intrinsics.areEqual(this.date, transaction.date);
        }
        return false;
    }

    public final int hashCode() {
        return (this.type.hashCode() * 31) + this.date.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction(type=");
        sb.append(this.type);
        sb.append(", date=");
        sb.append(this.date);
        sb.append(')');
        return sb.toString();
    }

    public Transaction(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.type = str;
        this.date = str2;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getDate")
    public final String getDate() {
        return this.date;
    }
}
