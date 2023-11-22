package id.dana.kyb.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ>\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\r\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001e\u0010\u000bR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\b"}, d2 = {"Lid/dana/kyb/domain/model/TransactionListQueryInfo;", "", "", "component1", "()Z", "", "Lid/dana/kyb/domain/model/KybTransactionOrderInfo;", "component2", "()Ljava/util/List;", "", "component3", "()I", "component4", "hasMore", "transactionItems", "numberOfNewTransaction", "total", "copy", "(ZLjava/util/List;II)Lid/dana/kyb/domain/model/TransactionListQueryInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Z", "getHasMore", "I", "getNumberOfNewTransaction", "getTotal", "Ljava/util/List;", "getTransactionItems", "<init>", "(ZLjava/util/List;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TransactionListQueryInfo {
    private final boolean hasMore;
    private final int numberOfNewTransaction;
    private final int total;
    private final List<KybTransactionOrderInfo> transactionItems;

    public TransactionListQueryInfo() {
        this(false, null, 0, 0, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TransactionListQueryInfo copy$default(TransactionListQueryInfo transactionListQueryInfo, boolean z, List list, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = transactionListQueryInfo.hasMore;
        }
        if ((i3 & 2) != 0) {
            list = transactionListQueryInfo.transactionItems;
        }
        if ((i3 & 4) != 0) {
            i = transactionListQueryInfo.numberOfNewTransaction;
        }
        if ((i3 & 8) != 0) {
            i2 = transactionListQueryInfo.total;
        }
        return transactionListQueryInfo.copy(z, list, i, i2);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<KybTransactionOrderInfo> component2() {
        return this.transactionItems;
    }

    /* renamed from: component3  reason: from getter */
    public final int getNumberOfNewTransaction() {
        return this.numberOfNewTransaction;
    }

    /* renamed from: component4  reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public final TransactionListQueryInfo copy(boolean hasMore, List<KybTransactionOrderInfo> transactionItems, int numberOfNewTransaction, int total) {
        Intrinsics.checkNotNullParameter(transactionItems, "");
        return new TransactionListQueryInfo(hasMore, transactionItems, numberOfNewTransaction, total);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TransactionListQueryInfo) {
            TransactionListQueryInfo transactionListQueryInfo = (TransactionListQueryInfo) other;
            return this.hasMore == transactionListQueryInfo.hasMore && Intrinsics.areEqual(this.transactionItems, transactionListQueryInfo.transactionItems) && this.numberOfNewTransaction == transactionListQueryInfo.numberOfNewTransaction && this.total == transactionListQueryInfo.total;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean z = this.hasMore;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((r0 * 31) + this.transactionItems.hashCode()) * 31) + this.numberOfNewTransaction) * 31) + this.total;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransactionListQueryInfo(hasMore=");
        sb.append(this.hasMore);
        sb.append(", transactionItems=");
        sb.append(this.transactionItems);
        sb.append(", numberOfNewTransaction=");
        sb.append(this.numberOfNewTransaction);
        sb.append(", total=");
        sb.append(this.total);
        sb.append(')');
        return sb.toString();
    }

    public TransactionListQueryInfo(boolean z, List<KybTransactionOrderInfo> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "");
        this.hasMore = z;
        this.transactionItems = list;
        this.numberOfNewTransaction = i;
        this.total = i2;
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public /* synthetic */ TransactionListQueryInfo(boolean z, List list, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @JvmName(name = "getTransactionItems")
    public final List<KybTransactionOrderInfo> getTransactionItems() {
        return this.transactionItems;
    }

    @JvmName(name = "getNumberOfNewTransaction")
    public final int getNumberOfNewTransaction() {
        return this.numberOfNewTransaction;
    }

    @JvmName(name = "getTotal")
    public final int getTotal() {
        return this.total;
    }
}
