package id.dana.domain.nearbyme.model;

import com.iap.ac.android.biz.common.utils.log.LogConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\f\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\n"}, d2 = {"Lid/dana/domain/nearbyme/model/MerchantReviewSummary;", "", "", "component1", "()F", "", "component2", "()I", "Lid/dana/domain/nearbyme/model/MerchantReview;", "component3", "()Lid/dana/domain/nearbyme/model/MerchantReview;", "rating", "numberOfReviews", "userReview", "copy", "(FILid/dana/domain/nearbyme/model/MerchantReview;)Lid/dana/domain/nearbyme/model/MerchantReviewSummary;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getNumberOfReviews", LogConstants.RESULT_FALSE, "getRating", "Lid/dana/domain/nearbyme/model/MerchantReview;", "getUserReview", "<init>", "(FILid/dana/domain/nearbyme/model/MerchantReview;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MerchantReviewSummary {
    private final int numberOfReviews;
    private final float rating;
    private final MerchantReview userReview;

    public static /* synthetic */ MerchantReviewSummary copy$default(MerchantReviewSummary merchantReviewSummary, float f, int i, MerchantReview merchantReview, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = merchantReviewSummary.rating;
        }
        if ((i2 & 2) != 0) {
            i = merchantReviewSummary.numberOfReviews;
        }
        if ((i2 & 4) != 0) {
            merchantReview = merchantReviewSummary.userReview;
        }
        return merchantReviewSummary.copy(f, i, merchantReview);
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
    public final MerchantReview getUserReview() {
        return this.userReview;
    }

    public final MerchantReviewSummary copy(float rating, int numberOfReviews, MerchantReview userReview) {
        return new MerchantReviewSummary(rating, numberOfReviews, userReview);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MerchantReviewSummary) {
            MerchantReviewSummary merchantReviewSummary = (MerchantReviewSummary) other;
            return Intrinsics.areEqual((Object) Float.valueOf(this.rating), (Object) Float.valueOf(merchantReviewSummary.rating)) && this.numberOfReviews == merchantReviewSummary.numberOfReviews && Intrinsics.areEqual(this.userReview, merchantReviewSummary.userReview);
        }
        return false;
    }

    public final int hashCode() {
        int floatToIntBits = Float.floatToIntBits(this.rating);
        int i = this.numberOfReviews;
        MerchantReview merchantReview = this.userReview;
        return (((floatToIntBits * 31) + i) * 31) + (merchantReview == null ? 0 : merchantReview.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantReviewSummary(rating=");
        sb.append(this.rating);
        sb.append(", numberOfReviews=");
        sb.append(this.numberOfReviews);
        sb.append(", userReview=");
        sb.append(this.userReview);
        sb.append(')');
        return sb.toString();
    }

    public MerchantReviewSummary(float f, int i, MerchantReview merchantReview) {
        this.rating = f;
        this.numberOfReviews = i;
        this.userReview = merchantReview;
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
    public final MerchantReview getUserReview() {
        return this.userReview;
    }
}
