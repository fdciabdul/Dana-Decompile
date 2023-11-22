package id.dana.domain.nearbyme.model;

import id.dana.contract.deeplink.path.FeatureParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J|\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00052\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b!\u0010\u0007J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0007¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b$\u0010\nR\u001a\u0010\u001a\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010%\u001a\u0004\b\u001a\u0010\u0010R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b&\u0010\nR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b'\u0010\nR\u001a\u0010\u0014\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\u0007R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b+\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010*\u001a\u0004\b,\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010%\u001a\u0004\b-\u0010\u0010R\u001a\u0010\u0018\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b.\u0010\u0004"}, d2 = {"Lid/dana/domain/nearbyme/model/MerchantCreateReview;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "", "component3", "()Ljava/util/List;", "component4", "component5", "component6", "", "component7", "()Z", "component8", "component9", "review", "rating", "positiveTags", "negativeTags", "images", FeatureParams.SHOP_ID, "shareToFeed", "isUpdateReview", "reviewId", "copy", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ZZLjava/lang/String;)Lid/dana/domain/nearbyme/model/MerchantCreateReview;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/util/List;", "getImages", "Z", "getNegativeTags", "getPositiveTags", "I", "getRating", "Ljava/lang/String;", "getReview", "getReviewId", "getShareToFeed", "getShopId", "<init>", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ZZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MerchantCreateReview {
    private final List<String> images;
    private final boolean isUpdateReview;
    private final List<String> negativeTags;
    private final List<String> positiveTags;
    private final int rating;
    private final String review;
    private final String reviewId;
    private final boolean shareToFeed;
    private final String shopId;

    /* renamed from: component1  reason: from getter */
    public final String getReview() {
        return this.review;
    }

    /* renamed from: component2  reason: from getter */
    public final int getRating() {
        return this.rating;
    }

    public final List<String> component3() {
        return this.positiveTags;
    }

    public final List<String> component4() {
        return this.negativeTags;
    }

    public final List<String> component5() {
        return this.images;
    }

    /* renamed from: component6  reason: from getter */
    public final String getShopId() {
        return this.shopId;
    }

    /* renamed from: component7  reason: from getter */
    public final boolean getShareToFeed() {
        return this.shareToFeed;
    }

    /* renamed from: component8  reason: from getter */
    public final boolean getIsUpdateReview() {
        return this.isUpdateReview;
    }

    /* renamed from: component9  reason: from getter */
    public final String getReviewId() {
        return this.reviewId;
    }

    public final MerchantCreateReview copy(String review, int rating, List<String> positiveTags, List<String> negativeTags, List<String> images, String shopId, boolean shareToFeed, boolean isUpdateReview, String reviewId) {
        Intrinsics.checkNotNullParameter(review, "");
        Intrinsics.checkNotNullParameter(positiveTags, "");
        Intrinsics.checkNotNullParameter(negativeTags, "");
        Intrinsics.checkNotNullParameter(images, "");
        Intrinsics.checkNotNullParameter(shopId, "");
        Intrinsics.checkNotNullParameter(reviewId, "");
        return new MerchantCreateReview(review, rating, positiveTags, negativeTags, images, shopId, shareToFeed, isUpdateReview, reviewId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MerchantCreateReview) {
            MerchantCreateReview merchantCreateReview = (MerchantCreateReview) other;
            return Intrinsics.areEqual(this.review, merchantCreateReview.review) && this.rating == merchantCreateReview.rating && Intrinsics.areEqual(this.positiveTags, merchantCreateReview.positiveTags) && Intrinsics.areEqual(this.negativeTags, merchantCreateReview.negativeTags) && Intrinsics.areEqual(this.images, merchantCreateReview.images) && Intrinsics.areEqual(this.shopId, merchantCreateReview.shopId) && this.shareToFeed == merchantCreateReview.shareToFeed && this.isUpdateReview == merchantCreateReview.isUpdateReview && Intrinsics.areEqual(this.reviewId, merchantCreateReview.reviewId);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.review.hashCode();
        int i = this.rating;
        int hashCode2 = this.positiveTags.hashCode();
        int hashCode3 = this.negativeTags.hashCode();
        int hashCode4 = this.images.hashCode();
        int hashCode5 = this.shopId.hashCode();
        boolean z = this.shareToFeed;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        boolean z2 = this.isUpdateReview;
        return (((((((((((((((hashCode * 31) + i) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i2) * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.reviewId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantCreateReview(review=");
        sb.append(this.review);
        sb.append(", rating=");
        sb.append(this.rating);
        sb.append(", positiveTags=");
        sb.append(this.positiveTags);
        sb.append(", negativeTags=");
        sb.append(this.negativeTags);
        sb.append(", images=");
        sb.append(this.images);
        sb.append(", shopId=");
        sb.append(this.shopId);
        sb.append(", shareToFeed=");
        sb.append(this.shareToFeed);
        sb.append(", isUpdateReview=");
        sb.append(this.isUpdateReview);
        sb.append(", reviewId=");
        sb.append(this.reviewId);
        sb.append(')');
        return sb.toString();
    }

    public MerchantCreateReview(String str, int i, List<String> list, List<String> list2, List<String> list3, String str2, boolean z, boolean z2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(list3, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.review = str;
        this.rating = i;
        this.positiveTags = list;
        this.negativeTags = list2;
        this.images = list3;
        this.shopId = str2;
        this.shareToFeed = z;
        this.isUpdateReview = z2;
        this.reviewId = str3;
    }

    public /* synthetic */ MerchantCreateReview(String str, int i, List list, List list2, List list3, String str2, boolean z, boolean z2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, list, list2, list3, str2, z, (i2 & 128) != 0 ? false : z2, (i2 & 256) != 0 ? "" : str3);
    }

    @JvmName(name = "getReview")
    public final String getReview() {
        return this.review;
    }

    @JvmName(name = "getRating")
    public final int getRating() {
        return this.rating;
    }

    @JvmName(name = "getPositiveTags")
    public final List<String> getPositiveTags() {
        return this.positiveTags;
    }

    @JvmName(name = "getNegativeTags")
    public final List<String> getNegativeTags() {
        return this.negativeTags;
    }

    @JvmName(name = "getImages")
    public final List<String> getImages() {
        return this.images;
    }

    @JvmName(name = "getShopId")
    public final String getShopId() {
        return this.shopId;
    }

    @JvmName(name = "getShareToFeed")
    public final boolean getShareToFeed() {
        return this.shareToFeed;
    }

    @JvmName(name = "isUpdateReview")
    public final boolean isUpdateReview() {
        return this.isUpdateReview;
    }

    @JvmName(name = "getReviewId")
    public final String getReviewId() {
        return this.reviewId;
    }
}
