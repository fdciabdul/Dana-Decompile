package id.dana.domain.nearbyme.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b2\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0013\u0012\b\b\u0002\u0010$\u001a\u00020\u0016\u0012\b\b\u0002\u0010%\u001a\u00020\u0016\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0005\u0012\b\b\u0002\u0010'\u001a\u00020\u001c\u0012\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010-\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\b\b\u0002\u0010/\u001a\u00020\u0002¢\u0006\u0004\bM\u0010NJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0018J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\bJ\u0010\u0010\u001d\u001a\u00020\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJÐ\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010$\u001a\u00020\u00162\b\b\u0002\u0010%\u001a\u00020\u00162\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00052\b\b\u0002\u0010'\u001a\u00020\u001c2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010*\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u00022\b\b\u0002\u0010,\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b0\u00101J\u001a\u00103\u001a\u00020\u001c2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b5\u0010\u0015J\u0010\u00106\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b6\u0010\u0004R\u0017\u0010!\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b!\u00107\u001a\u0004\b8\u0010\u0004R\u001a\u0010%\u001a\u00020\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u00109\u001a\u0004\b:\u0010\u0018R\u001a\u0010'\u001a\u00020\u001c8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010;\u001a\u0004\b<\u0010\u001eR \u0010&\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010=\u001a\u0004\b>\u0010\bR\u001a\u0010.\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u00107\u001a\u0004\b?\u0010\u0004R\u001a\u0010,\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u00107\u001a\u0004\b@\u0010\u0004R\u001a\u0010*\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u00107\u001a\u0004\bA\u0010\u0004R\u001a\u0010-\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u00107\u001a\u0004\bB\u0010\u0004R\u001a\u0010$\u001a\u00020\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u00109\u001a\u0004\bC\u0010\u0018R\"\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010=\u001a\u0004\bD\u0010\bR\"\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010=\u001a\u0004\bE\u0010\bR\u001a\u0010#\u001a\u00020\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010F\u001a\u0004\bG\u0010\u0015R\u001a\u0010\"\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00107\u001a\u0004\bH\u0010\u0004R\u001a\u0010/\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u00107\u001a\u0004\bI\u0010\u0004R\u001a\u0010+\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u00107\u001a\u0004\bJ\u0010\u0004R\u001a\u0010\u001f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\bK\u0010\u0004R\u001a\u0010 \u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00107\u001a\u0004\bL\u0010\u0004"}, d2 = {"Lid/dana/domain/nearbyme/model/MerchantReview;", "", "", "component1", "()Ljava/lang/String;", "", "Lid/dana/domain/nearbyme/model/Tag;", "component10", "()Ljava/util/List;", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "", "component5", "()I", "", "component6", "()J", "component7", "Lid/dana/domain/nearbyme/model/MerchantImage;", "component8", "", "component9", "()Z", "userId", "userName", "avatar", "review", "rating", "modifyDate", "createdDate", "images", "editable", "positiveTags", "negativeSentiments", "merchantId", FeatureParams.SHOP_ID, "mainName", "merchantName", DecodedScanBizInfoKey.LOGO_URL, "reviewId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJLjava/util/List;ZLjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/nearbyme/model/MerchantReview;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getAvatar", "J", "getCreatedDate", "Z", "getEditable", "Ljava/util/List;", "getImages", "getLogoUrl", "getMainName", "getMerchantId", "getMerchantName", "getModifyDate", "getNegativeSentiments", "getPositiveTags", "I", "getRating", "getReview", "getReviewId", "getShopId", "getUserId", "getUserName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJLjava/util/List;ZLjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MerchantReview {
    private final String avatar;
    private final long createdDate;
    private final boolean editable;
    private final List<MerchantImage> images;
    private final String logoUrl;
    private final String mainName;
    private final String merchantId;
    private final String merchantName;
    private final long modifyDate;
    private final List<Tag> negativeSentiments;
    private final List<Tag> positiveTags;
    private final int rating;
    private final String review;
    private final String reviewId;
    private final String shopId;
    private final String userId;
    private final String userName;

    public MerchantReview() {
        this(null, null, null, null, 0, 0L, 0L, null, false, null, null, null, null, null, null, null, null, 131071, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public final List<Tag> component10() {
        return this.positiveTags;
    }

    public final List<Tag> component11() {
        return this.negativeSentiments;
    }

    /* renamed from: component12  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component13  reason: from getter */
    public final String getShopId() {
        return this.shopId;
    }

    /* renamed from: component14  reason: from getter */
    public final String getMainName() {
        return this.mainName;
    }

    /* renamed from: component15  reason: from getter */
    public final String getMerchantName() {
        return this.merchantName;
    }

    /* renamed from: component16  reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    /* renamed from: component17  reason: from getter */
    public final String getReviewId() {
        return this.reviewId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component4  reason: from getter */
    public final String getReview() {
        return this.review;
    }

    /* renamed from: component5  reason: from getter */
    public final int getRating() {
        return this.rating;
    }

    /* renamed from: component6  reason: from getter */
    public final long getModifyDate() {
        return this.modifyDate;
    }

    /* renamed from: component7  reason: from getter */
    public final long getCreatedDate() {
        return this.createdDate;
    }

    public final List<MerchantImage> component8() {
        return this.images;
    }

    /* renamed from: component9  reason: from getter */
    public final boolean getEditable() {
        return this.editable;
    }

    public final MerchantReview copy(String userId, String userName, String avatar, String review, int rating, long modifyDate, long createdDate, List<MerchantImage> images, boolean editable, List<Tag> positiveTags, List<Tag> negativeSentiments, String merchantId, String shopId, String mainName, String merchantName, String logoUrl, String reviewId) {
        Intrinsics.checkNotNullParameter(userId, "");
        Intrinsics.checkNotNullParameter(userName, "");
        Intrinsics.checkNotNullParameter(avatar, "");
        Intrinsics.checkNotNullParameter(review, "");
        Intrinsics.checkNotNullParameter(images, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(shopId, "");
        Intrinsics.checkNotNullParameter(mainName, "");
        Intrinsics.checkNotNullParameter(merchantName, "");
        Intrinsics.checkNotNullParameter(logoUrl, "");
        Intrinsics.checkNotNullParameter(reviewId, "");
        return new MerchantReview(userId, userName, avatar, review, rating, modifyDate, createdDate, images, editable, positiveTags, negativeSentiments, merchantId, shopId, mainName, merchantName, logoUrl, reviewId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MerchantReview) {
            MerchantReview merchantReview = (MerchantReview) other;
            return Intrinsics.areEqual(this.userId, merchantReview.userId) && Intrinsics.areEqual(this.userName, merchantReview.userName) && Intrinsics.areEqual(this.avatar, merchantReview.avatar) && Intrinsics.areEqual(this.review, merchantReview.review) && this.rating == merchantReview.rating && this.modifyDate == merchantReview.modifyDate && this.createdDate == merchantReview.createdDate && Intrinsics.areEqual(this.images, merchantReview.images) && this.editable == merchantReview.editable && Intrinsics.areEqual(this.positiveTags, merchantReview.positiveTags) && Intrinsics.areEqual(this.negativeSentiments, merchantReview.negativeSentiments) && Intrinsics.areEqual(this.merchantId, merchantReview.merchantId) && Intrinsics.areEqual(this.shopId, merchantReview.shopId) && Intrinsics.areEqual(this.mainName, merchantReview.mainName) && Intrinsics.areEqual(this.merchantName, merchantReview.merchantName) && Intrinsics.areEqual(this.logoUrl, merchantReview.logoUrl) && Intrinsics.areEqual(this.reviewId, merchantReview.reviewId);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.userId.hashCode();
        int hashCode2 = this.userName.hashCode();
        int hashCode3 = this.avatar.hashCode();
        int hashCode4 = this.review.hashCode();
        int i = this.rating;
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.modifyDate);
        int m2 = Cbor$Arg$$ExternalSyntheticBackport0.m(this.createdDate);
        int hashCode5 = this.images.hashCode();
        boolean z = this.editable;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        List<Tag> list = this.positiveTags;
        int hashCode6 = list == null ? 0 : list.hashCode();
        List<Tag> list2 = this.negativeSentiments;
        return (((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i) * 31) + m) * 31) + m2) * 31) + hashCode5) * 31) + i2) * 31) + hashCode6) * 31) + (list2 != null ? list2.hashCode() : 0)) * 31) + this.merchantId.hashCode()) * 31) + this.shopId.hashCode()) * 31) + this.mainName.hashCode()) * 31) + this.merchantName.hashCode()) * 31) + this.logoUrl.hashCode()) * 31) + this.reviewId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantReview(userId=");
        sb.append(this.userId);
        sb.append(", userName=");
        sb.append(this.userName);
        sb.append(", avatar=");
        sb.append(this.avatar);
        sb.append(", review=");
        sb.append(this.review);
        sb.append(", rating=");
        sb.append(this.rating);
        sb.append(", modifyDate=");
        sb.append(this.modifyDate);
        sb.append(", createdDate=");
        sb.append(this.createdDate);
        sb.append(", images=");
        sb.append(this.images);
        sb.append(", editable=");
        sb.append(this.editable);
        sb.append(", positiveTags=");
        sb.append(this.positiveTags);
        sb.append(", negativeSentiments=");
        sb.append(this.negativeSentiments);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", shopId=");
        sb.append(this.shopId);
        sb.append(", mainName=");
        sb.append(this.mainName);
        sb.append(", merchantName=");
        sb.append(this.merchantName);
        sb.append(", logoUrl=");
        sb.append(this.logoUrl);
        sb.append(", reviewId=");
        sb.append(this.reviewId);
        sb.append(')');
        return sb.toString();
    }

    public MerchantReview(String str, String str2, String str3, String str4, int i, long j, long j2, List<MerchantImage> list, boolean z, List<Tag> list2, List<Tag> list3, String str5, String str6, String str7, String str8, String str9, String str10) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(str10, "");
        this.userId = str;
        this.userName = str2;
        this.avatar = str3;
        this.review = str4;
        this.rating = i;
        this.modifyDate = j;
        this.createdDate = j2;
        this.images = list;
        this.editable = z;
        this.positiveTags = list2;
        this.negativeSentiments = list3;
        this.merchantId = str5;
        this.shopId = str6;
        this.mainName = str7;
        this.merchantName = str8;
        this.logoUrl = str9;
        this.reviewId = str10;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "getUserName")
    public final String getUserName() {
        return this.userName;
    }

    @JvmName(name = "getAvatar")
    public final String getAvatar() {
        return this.avatar;
    }

    @JvmName(name = "getReview")
    public final String getReview() {
        return this.review;
    }

    @JvmName(name = "getRating")
    public final int getRating() {
        return this.rating;
    }

    @JvmName(name = "getModifyDate")
    public final long getModifyDate() {
        return this.modifyDate;
    }

    @JvmName(name = "getCreatedDate")
    public final long getCreatedDate() {
        return this.createdDate;
    }

    public /* synthetic */ MerchantReview(String str, String str2, String str3, String str4, int i, long j, long j2, List list, boolean z, List list2, List list3, String str5, String str6, String str7, String str8, String str9, String str10, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? 0L : j, (i2 & 64) == 0 ? j2 : 0L, (i2 & 128) != 0 ? CollectionsKt.emptyList() : list, (i2 & 256) == 0 ? z : false, (i2 & 512) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 1024) != 0 ? CollectionsKt.emptyList() : list3, (i2 & 2048) != 0 ? "" : str5, (i2 & 4096) != 0 ? "" : str6, (i2 & 8192) != 0 ? "" : str7, (i2 & 16384) != 0 ? "" : str8, (i2 & 32768) != 0 ? "" : str9, (i2 & 65536) != 0 ? "" : str10);
    }

    @JvmName(name = "getImages")
    public final List<MerchantImage> getImages() {
        return this.images;
    }

    @JvmName(name = "getEditable")
    public final boolean getEditable() {
        return this.editable;
    }

    @JvmName(name = "getPositiveTags")
    public final List<Tag> getPositiveTags() {
        return this.positiveTags;
    }

    @JvmName(name = "getNegativeSentiments")
    public final List<Tag> getNegativeSentiments() {
        return this.negativeSentiments;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "getShopId")
    public final String getShopId() {
        return this.shopId;
    }

    @JvmName(name = "getMainName")
    public final String getMainName() {
        return this.mainName;
    }

    @JvmName(name = "getMerchantName")
    public final String getMerchantName() {
        return this.merchantName;
    }

    @JvmName(name = "getLogoUrl")
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @JvmName(name = "getReviewId")
    public final String getReviewId() {
        return this.reviewId;
    }
}
