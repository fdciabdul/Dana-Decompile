package id.dana.kyb.data.repository.source.network.result;

import id.dana.kyb.data.model.KybTransactionDTO;
import id.dana.network.base.BaseRpcResultAphome;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\b"}, d2 = {"Lid/dana/kyb/data/repository/source/network/result/TransactionListQueryResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Ljava/lang/Boolean;", "", "Lid/dana/kyb/data/model/KybTransactionDTO;", "component2", "()Ljava/util/List;", "hasMore", "transactionListItemDTOs", "copy", "(Ljava/lang/Boolean;Ljava/util/List;)Lid/dana/kyb/data/repository/source/network/result/TransactionListQueryResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Boolean;", "getHasMore", "Ljava/util/List;", "getTransactionListItemDTOs", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TransactionListQueryResult extends BaseRpcResultAphome {
    private final Boolean hasMore;
    private final List<KybTransactionDTO> transactionListItemDTOs;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TransactionListQueryResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.data.repository.source.network.result.TransactionListQueryResult.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TransactionListQueryResult copy$default(TransactionListQueryResult transactionListQueryResult, Boolean bool, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = transactionListQueryResult.hasMore;
        }
        if ((i & 2) != 0) {
            list = transactionListQueryResult.transactionListItemDTOs;
        }
        return transactionListQueryResult.copy(bool, list);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final List<KybTransactionDTO> component2() {
        return this.transactionListItemDTOs;
    }

    public final TransactionListQueryResult copy(Boolean hasMore, List<KybTransactionDTO> transactionListItemDTOs) {
        return new TransactionListQueryResult(hasMore, transactionListItemDTOs);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TransactionListQueryResult) {
            TransactionListQueryResult transactionListQueryResult = (TransactionListQueryResult) other;
            return Intrinsics.areEqual(this.hasMore, transactionListQueryResult.hasMore) && Intrinsics.areEqual(this.transactionListItemDTOs, transactionListQueryResult.transactionListItemDTOs);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.hasMore;
        int hashCode = bool == null ? 0 : bool.hashCode();
        List<KybTransactionDTO> list = this.transactionListItemDTOs;
        return (hashCode * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransactionListQueryResult(hasMore=");
        sb.append(this.hasMore);
        sb.append(", transactionListItemDTOs=");
        sb.append(this.transactionListItemDTOs);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ TransactionListQueryResult(Boolean bool, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Boolean.FALSE : bool, (i & 2) != 0 ? null : list);
    }

    @JvmName(name = "getHasMore")
    public final Boolean getHasMore() {
        return this.hasMore;
    }

    @JvmName(name = "getTransactionListItemDTOs")
    public final List<KybTransactionDTO> getTransactionListItemDTOs() {
        return this.transactionListItemDTOs;
    }

    public TransactionListQueryResult(Boolean bool, List<KybTransactionDTO> list) {
        this.hasMore = bool;
        this.transactionListItemDTOs = list;
    }
}
