package id.dana.data.nearbyme.repository.source.network.result.merchantdetail;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.data.nearbyme.model.MerchantReviewEntity;
import id.dana.domain.nearbyme.model.MerchantReviewSummary;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\f\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\n"}, d2 = {"Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantReviewSummaryResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()F", "", "component2", "()I", "Lid/dana/data/nearbyme/model/MerchantReviewEntity;", "component3", "()Lid/dana/data/nearbyme/model/MerchantReviewEntity;", "rating", "numberOfReviews", "userReview", "copy", "(FILid/dana/data/nearbyme/model/MerchantReviewEntity;)Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantReviewSummaryResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "Lid/dana/domain/nearbyme/model/MerchantReviewSummary;", "toMerchantReviewSummary", "()Lid/dana/domain/nearbyme/model/MerchantReviewSummary;", "", "toString", "()Ljava/lang/String;", "I", "getNumberOfReviews", LogConstants.RESULT_FALSE, "getRating", "Lid/dana/data/nearbyme/model/MerchantReviewEntity;", "getUserReview", "<init>", "(FILid/dana/data/nearbyme/model/MerchantReviewEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MerchantReviewSummaryResult extends BaseRpcResult {
    private final int numberOfReviews;
    private final float rating;
    private final MerchantReviewEntity userReview;

    public static /* synthetic */ MerchantReviewSummaryResult copy$default(MerchantReviewSummaryResult merchantReviewSummaryResult, float f, int i, MerchantReviewEntity merchantReviewEntity, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = merchantReviewSummaryResult.rating;
        }
        if ((i2 & 2) != 0) {
            i = merchantReviewSummaryResult.numberOfReviews;
        }
        if ((i2 & 4) != 0) {
            merchantReviewEntity = merchantReviewSummaryResult.userReview;
        }
        return merchantReviewSummaryResult.copy(f, i, merchantReviewEntity);
    }

    /* renamed from: component1  reason: from getter */
    public final float getRating() {
        return this.rating;
    }

    /* renamed from: component2  reason: from getter */
    public final int getNumberOfReviews() {
        return this.numberOfReviews;
    }

    /* renamed from: component3  reason: from getter */
    public final MerchantReviewEntity getUserReview() {
        return this.userReview;
    }

    public final MerchantReviewSummaryResult copy(float rating, int numberOfReviews, MerchantReviewEntity userReview) {
        return new MerchantReviewSummaryResult(rating, numberOfReviews, userReview);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MerchantReviewSummaryResult) {
            MerchantReviewSummaryResult merchantReviewSummaryResult = (MerchantReviewSummaryResult) other;
            return Intrinsics.areEqual((Object) Float.valueOf(this.rating), (Object) Float.valueOf(merchantReviewSummaryResult.rating)) && this.numberOfReviews == merchantReviewSummaryResult.numberOfReviews && Intrinsics.areEqual(this.userReview, merchantReviewSummaryResult.userReview);
        }
        return false;
    }

    public final int hashCode() {
        int floatToIntBits = Float.floatToIntBits(this.rating);
        int i = this.numberOfReviews;
        MerchantReviewEntity merchantReviewEntity = this.userReview;
        return (((floatToIntBits * 31) + i) * 31) + (merchantReviewEntity == null ? 0 : merchantReviewEntity.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantReviewSummaryResult(rating=");
        sb.append(this.rating);
        sb.append(", numberOfReviews=");
        sb.append(this.numberOfReviews);
        sb.append(", userReview=");
        sb.append(this.userReview);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getRating")
    public final float getRating() {
        return this.rating;
    }

    @JvmName(name = "getNumberOfReviews")
    public final int getNumberOfReviews() {
        return this.numberOfReviews;
    }

    @JvmName(name = "getUserReview")
    public final MerchantReviewEntity getUserReview() {
        return this.userReview;
    }

    public MerchantReviewSummaryResult(float f, int i, MerchantReviewEntity merchantReviewEntity) {
        this.rating = f;
        this.numberOfReviews = i;
        this.userReview = merchantReviewEntity;
    }

    public final MerchantReviewSummary toMerchantReviewSummary() {
        float f = this.rating;
        int i = this.numberOfReviews;
        MerchantReviewEntity merchantReviewEntity = this.userReview;
        return new MerchantReviewSummary(f, i, merchantReviewEntity != null ? merchantReviewEntity.toMerchantReview() : null);
    }
}
