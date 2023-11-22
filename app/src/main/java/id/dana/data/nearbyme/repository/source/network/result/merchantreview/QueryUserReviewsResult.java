package id.dana.data.nearbyme.repository.source.network.result.merchantreview;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.nearbyme.model.MerchantReviewEntity;
import id.dana.domain.nearbyme.model.QueryUserReviews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005"}, d2 = {"Lid/dana/data/nearbyme/repository/source/network/result/merchantreview/QueryUserReviewsResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/data/nearbyme/model/MerchantReviewEntity;", "component1", "()Ljava/util/List;", "", "component2", "()Z", "reviews", "hasMore", "copy", "(Ljava/util/List;Z)Lid/dana/data/nearbyme/repository/source/network/result/merchantreview/QueryUserReviewsResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lid/dana/domain/nearbyme/model/QueryUserReviews;", "toQueryUserReviews", "()Lid/dana/domain/nearbyme/model/QueryUserReviews;", "", "toString", "()Ljava/lang/String;", "Z", "getHasMore", "Ljava/util/List;", "getReviews", "<init>", "(Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QueryUserReviewsResult extends BaseRpcResult {
    private final boolean hasMore;
    private final List<MerchantReviewEntity> reviews;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public QueryUserReviewsResult() {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            r2 = 3
            r3.<init>(r0, r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.nearbyme.repository.source.network.result.merchantreview.QueryUserReviewsResult.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QueryUserReviewsResult copy$default(QueryUserReviewsResult queryUserReviewsResult, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = queryUserReviewsResult.reviews;
        }
        if ((i & 2) != 0) {
            z = queryUserReviewsResult.hasMore;
        }
        return queryUserReviewsResult.copy(list, z);
    }

    public final List<MerchantReviewEntity> component1() {
        return this.reviews;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final QueryUserReviewsResult copy(List<MerchantReviewEntity> reviews, boolean hasMore) {
        Intrinsics.checkNotNullParameter(reviews, "");
        return new QueryUserReviewsResult(reviews, hasMore);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryUserReviewsResult) {
            QueryUserReviewsResult queryUserReviewsResult = (QueryUserReviewsResult) other;
            return Intrinsics.areEqual(this.reviews, queryUserReviewsResult.reviews) && this.hasMore == queryUserReviewsResult.hasMore;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.reviews.hashCode();
        boolean z = this.hasMore;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (hashCode * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryUserReviewsResult(reviews=");
        sb.append(this.reviews);
        sb.append(", hasMore=");
        sb.append(this.hasMore);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ QueryUserReviewsResult(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? false : z);
    }

    @JvmName(name = "getReviews")
    public final List<MerchantReviewEntity> getReviews() {
        return this.reviews;
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public QueryUserReviewsResult(List<MerchantReviewEntity> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "");
        this.reviews = list;
        this.hasMore = z;
    }

    public final QueryUserReviews toQueryUserReviews() {
        List<MerchantReviewEntity> list = this.reviews;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((MerchantReviewEntity) it.next()).toMerchantReview());
        }
        return new QueryUserReviews(arrayList, this.hasMore);
    }
}
