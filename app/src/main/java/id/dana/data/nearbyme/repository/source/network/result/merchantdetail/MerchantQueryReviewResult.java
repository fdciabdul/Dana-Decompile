package id.dana.data.nearbyme.repository.source.network.result.merchantdetail;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.nearbyme.model.MerchantReviewEntity;
import id.dana.domain.nearbyme.model.MerchantReviews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001d\u0010\b"}, d2 = {"Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantQueryReviewResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Z", "", "Lid/dana/data/nearbyme/model/MerchantReviewEntity;", "component2", "()Ljava/util/List;", "hasMore", "reviews", "copy", "(ZLjava/util/List;)Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantQueryReviewResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lid/dana/domain/nearbyme/model/MerchantReviews;", "toMerchantReviews", "()Lid/dana/domain/nearbyme/model/MerchantReviews;", "", "toString", "()Ljava/lang/String;", "Z", "getHasMore", "Ljava/util/List;", "getReviews", "<init>", "(ZLjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MerchantQueryReviewResult extends BaseRpcResult {
    private final boolean hasMore;
    private final List<MerchantReviewEntity> reviews;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MerchantQueryReviewResult copy$default(MerchantQueryReviewResult merchantQueryReviewResult, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = merchantQueryReviewResult.hasMore;
        }
        if ((i & 2) != 0) {
            list = merchantQueryReviewResult.reviews;
        }
        return merchantQueryReviewResult.copy(z, list);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<MerchantReviewEntity> component2() {
        return this.reviews;
    }

    public final MerchantQueryReviewResult copy(boolean hasMore, List<MerchantReviewEntity> reviews) {
        Intrinsics.checkNotNullParameter(reviews, "");
        return new MerchantQueryReviewResult(hasMore, reviews);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MerchantQueryReviewResult) {
            MerchantQueryReviewResult merchantQueryReviewResult = (MerchantQueryReviewResult) other;
            return this.hasMore == merchantQueryReviewResult.hasMore && Intrinsics.areEqual(this.reviews, merchantQueryReviewResult.reviews);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.hasMore;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.reviews.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantQueryReviewResult(hasMore=");
        sb.append(this.hasMore);
        sb.append(", reviews=");
        sb.append(this.reviews);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    @JvmName(name = "getReviews")
    public final List<MerchantReviewEntity> getReviews() {
        return this.reviews;
    }

    public MerchantQueryReviewResult(boolean z, List<MerchantReviewEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.hasMore = z;
        this.reviews = list;
    }

    public final MerchantReviews toMerchantReviews() {
        boolean z = this.hasMore;
        List<MerchantReviewEntity> list = this.reviews;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((MerchantReviewEntity) it.next()).toMerchantReview());
        }
        return new MerchantReviews(z, arrayList);
    }
}
