package id.dana.kyb.data.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007"}, d2 = {"Lid/dana/kyb/data/repository/source/network/request/TransactionListQueryRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "pageNum", "transactionQueryType", "copy", "(ILjava/lang/String;)Lid/dana/kyb/data/repository/source/network/request/TransactionListQueryRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "I", "getPageNum", "Ljava/lang/String;", "getTransactionQueryType", "<init>", "(ILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TransactionListQueryRequest extends BaseRpcRequest {
    private final int pageNum;
    private final String transactionQueryType;

    public static /* synthetic */ TransactionListQueryRequest copy$default(TransactionListQueryRequest transactionListQueryRequest, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = transactionListQueryRequest.pageNum;
        }
        if ((i2 & 2) != 0) {
            str = transactionListQueryRequest.transactionQueryType;
        }
        return transactionListQueryRequest.copy(i, str);
    }

    /* renamed from: component1  reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    /* renamed from: component2  reason: from getter */
    public final String getTransactionQueryType() {
        return this.transactionQueryType;
    }

    public final TransactionListQueryRequest copy(int pageNum, String transactionQueryType) {
        Intrinsics.checkNotNullParameter(transactionQueryType, "");
        return new TransactionListQueryRequest(pageNum, transactionQueryType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TransactionListQueryRequest) {
            TransactionListQueryRequest transactionListQueryRequest = (TransactionListQueryRequest) other;
            return this.pageNum == transactionListQueryRequest.pageNum && Intrinsics.areEqual(this.transactionQueryType, transactionListQueryRequest.transactionQueryType);
        }
        return false;
    }

    public final int hashCode() {
        return (this.pageNum * 31) + this.transactionQueryType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransactionListQueryRequest(pageNum=");
        sb.append(this.pageNum);
        sb.append(", transactionQueryType=");
        sb.append(this.transactionQueryType);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ TransactionListQueryRequest(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, str);
    }

    @JvmName(name = "getPageNum")
    public final int getPageNum() {
        return this.pageNum;
    }

    @JvmName(name = "getTransactionQueryType")
    public final String getTransactionQueryType() {
        return this.transactionQueryType;
    }

    public TransactionListQueryRequest(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pageNum = i;
        this.transactionQueryType = str;
    }
}
