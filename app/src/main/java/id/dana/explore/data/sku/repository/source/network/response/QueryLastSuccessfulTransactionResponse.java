package id.dana.explore.data.sku.repository.source.network.response;

import com.google.gson.annotations.SerializedName;
import id.dana.explore.data.sku.repository.source.network.request.BizIds;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\u00020\u00002\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005"}, d2 = {"Lid/dana/explore/data/sku/repository/source/network/response/QueryLastSuccessfulTransactionResponse;", "", "", "Lid/dana/explore/data/sku/repository/source/network/request/BizIds;", "component1", "()Ljava/util/List;", "bizIds", "copy", "(Ljava/util/List;)Lid/dana/explore/data/sku/repository/source/network/response/QueryLastSuccessfulTransactionResponse;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "isInvalid", "()Z", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getBizIds", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class QueryLastSuccessfulTransactionResponse {
    @SerializedName("bizIds")
    private final List<BizIds> bizIds;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public QueryLastSuccessfulTransactionResponse() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.data.sku.repository.source.network.response.QueryLastSuccessfulTransactionResponse.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QueryLastSuccessfulTransactionResponse copy$default(QueryLastSuccessfulTransactionResponse queryLastSuccessfulTransactionResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = queryLastSuccessfulTransactionResponse.bizIds;
        }
        return queryLastSuccessfulTransactionResponse.copy(list);
    }

    public final List<BizIds> component1() {
        return this.bizIds;
    }

    public final QueryLastSuccessfulTransactionResponse copy(List<BizIds> bizIds) {
        return new QueryLastSuccessfulTransactionResponse(bizIds);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof QueryLastSuccessfulTransactionResponse) && Intrinsics.areEqual(this.bizIds, ((QueryLastSuccessfulTransactionResponse) other).bizIds);
    }

    public final int hashCode() {
        List<BizIds> list = this.bizIds;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryLastSuccessfulTransactionResponse(bizIds=");
        sb.append(this.bizIds);
        sb.append(')');
        return sb.toString();
    }

    public QueryLastSuccessfulTransactionResponse(List<BizIds> list) {
        this.bizIds = list;
    }

    public /* synthetic */ QueryLastSuccessfulTransactionResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    @JvmName(name = "getBizIds")
    public final List<BizIds> getBizIds() {
        return this.bizIds;
    }

    public final boolean isInvalid() {
        List<BizIds> list = this.bizIds;
        if (list == null || list.isEmpty()) {
            return true;
        }
        BizIds bizIds = (BizIds) CollectionsKt.firstOrNull((List) this.bizIds);
        String goodsId = bizIds != null ? bizIds.getGoodsId() : null;
        if (goodsId == null || goodsId.length() == 0) {
            return true;
        }
        BizIds bizIds2 = (BizIds) CollectionsKt.firstOrNull((List) this.bizIds);
        String bizId = bizIds2 != null ? bizIds2.getBizId() : null;
        return bizId == null || bizId.length() == 0;
    }
}
