package id.dana.data.nearbyme.model;

import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.domain.nearbyme.model.MerchantReview;
import id.dana.domain.nearbyme.model.Tag;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b)\b\u0086\b\u0018\u00002\u00020\u0001Bå\u0001\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0005\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001c\u0012\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b_\u0010`J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0018J\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\bJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJî\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00052\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001c2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b0\u00101J\u001a\u00103\u001a\u00020\u001c2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b5\u00106J\r\u00108\u001a\u000207¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b:\u0010\u0004R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010;\u001a\u0004\b<\u0010\u0004\"\u0004\b=\u0010>R$\u0010%\u001a\u0004\u0018\u00010\u00168\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010?\u001a\u0004\b@\u0010\u0018\"\u0004\bA\u0010BR$\u0010'\u001a\u0004\u0018\u00010\u001c8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010C\u001a\u0004\bD\u0010\u001e\"\u0004\bE\u0010FR*\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010G\u001a\u0004\bH\u0010\b\"\u0004\bI\u0010JR\u001c\u0010.\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010;\u001a\u0004\bK\u0010\u0004R\u001c\u0010,\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010;\u001a\u0004\bL\u0010\u0004R\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010;\u001a\u0004\bM\u0010\u0004R\u001c\u0010-\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010;\u001a\u0004\bN\u0010\u0004R$\u0010$\u001a\u0004\u0018\u00010\u00168\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010?\u001a\u0004\bO\u0010\u0018\"\u0004\bP\u0010BR\"\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010G\u001a\u0004\bQ\u0010\bR\"\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010G\u001a\u0004\bR\u0010\bR$\u0010#\u001a\u0004\u0018\u00010\u00138\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010S\u001a\u0004\bT\u0010\u0015\"\u0004\bU\u0010VR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010;\u001a\u0004\bW\u0010\u0004\"\u0004\bX\u0010>R\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010;\u001a\u0004\bY\u0010\u0004R\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010;\u001a\u0004\bZ\u0010\u0004R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010;\u001a\u0004\b[\u0010\u0004\"\u0004\b\\\u0010>R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010;\u001a\u0004\b]\u0010\u0004\"\u0004\b^\u0010>"}, d2 = {"Lid/dana/data/nearbyme/model/MerchantReviewEntity;", "", "", "component1", "()Ljava/lang/String;", "", "Lid/dana/data/nearbyme/model/TagEntity;", "component10", "()Ljava/util/List;", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "", "component5", "()Ljava/lang/Integer;", "", "component6", "()Ljava/lang/Long;", "component7", "Lid/dana/data/nearbyme/model/MerchantImageEntity;", "component8", "", "component9", "()Ljava/lang/Boolean;", "userId", "userName", "avatar", "review", "rating", "modifyDate", "createdDate", "images", "editable", "positiveTags", "negativeTags", "merchantId", FeatureParams.SHOP_ID, "mainName", "merchantName", DecodedScanBizInfoKey.LOGO_URL, "reviewId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/nearbyme/model/MerchantReviewEntity;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Lid/dana/domain/nearbyme/model/MerchantReview;", "toMerchantReview", "()Lid/dana/domain/nearbyme/model/MerchantReview;", "toString", "Ljava/lang/String;", "getAvatar", "setAvatar", "(Ljava/lang/String;)V", "Ljava/lang/Long;", "getCreatedDate", "setCreatedDate", "(Ljava/lang/Long;)V", "Ljava/lang/Boolean;", "getEditable", "setEditable", "(Ljava/lang/Boolean;)V", "Ljava/util/List;", "getImages", "setImages", "(Ljava/util/List;)V", "getLogoUrl", "getMainName", "getMerchantId", "getMerchantName", "getModifyDate", "setModifyDate", "getNegativeTags", "getPositiveTags", "Ljava/lang/Integer;", "getRating", "setRating", "(Ljava/lang/Integer;)V", "getReview", "setReview", "getReviewId", "getShopId", "getUserId", "setUserId", "getUserName", "setUserName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MerchantReviewEntity {
    private String avatar;
    private Long createdDate;
    private Boolean editable;
    private List<MerchantImageEntity> images;
    private final String logoUrl;
    private final String mainName;
    private final String merchantId;
    private final String merchantName;
    private Long modifyDate;
    private final List<TagEntity> negativeTags;
    private final List<TagEntity> positiveTags;
    private Integer rating;
    private String review;
    private final String reviewId;
    private final String shopId;
    private String userId;
    private String userName;

    public MerchantReviewEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public final List<TagEntity> component10() {
        return this.positiveTags;
    }

    public final List<TagEntity> component11() {
        return this.negativeTags;
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
    public final Integer getRating() {
        return this.rating;
    }

    /* renamed from: component6  reason: from getter */
    public final Long getModifyDate() {
        return this.modifyDate;
    }

    /* renamed from: component7  reason: from getter */
    public final Long getCreatedDate() {
        return this.createdDate;
    }

    public final List<MerchantImageEntity> component8() {
        return this.images;
    }

    /* renamed from: component9  reason: from getter */
    public final Boolean getEditable() {
        return this.editable;
    }

    public final MerchantReviewEntity copy(String userId, String userName, String avatar, String review, Integer rating, Long modifyDate, Long createdDate, List<MerchantImageEntity> images, Boolean editable, List<TagEntity> positiveTags, List<TagEntity> negativeTags, String merchantId, String shopId, String mainName, String merchantName, String logoUrl, String reviewId) {
        return new MerchantReviewEntity(userId, userName, avatar, review, rating, modifyDate, createdDate, images, editable, positiveTags, negativeTags, merchantId, shopId, mainName, merchantName, logoUrl, reviewId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MerchantReviewEntity) {
            MerchantReviewEntity merchantReviewEntity = (MerchantReviewEntity) other;
            return Intrinsics.areEqual(this.userId, merchantReviewEntity.userId) && Intrinsics.areEqual(this.userName, merchantReviewEntity.userName) && Intrinsics.areEqual(this.avatar, merchantReviewEntity.avatar) && Intrinsics.areEqual(this.review, merchantReviewEntity.review) && Intrinsics.areEqual(this.rating, merchantReviewEntity.rating) && Intrinsics.areEqual(this.modifyDate, merchantReviewEntity.modifyDate) && Intrinsics.areEqual(this.createdDate, merchantReviewEntity.createdDate) && Intrinsics.areEqual(this.images, merchantReviewEntity.images) && Intrinsics.areEqual(this.editable, merchantReviewEntity.editable) && Intrinsics.areEqual(this.positiveTags, merchantReviewEntity.positiveTags) && Intrinsics.areEqual(this.negativeTags, merchantReviewEntity.negativeTags) && Intrinsics.areEqual(this.merchantId, merchantReviewEntity.merchantId) && Intrinsics.areEqual(this.shopId, merchantReviewEntity.shopId) && Intrinsics.areEqual(this.mainName, merchantReviewEntity.mainName) && Intrinsics.areEqual(this.merchantName, merchantReviewEntity.merchantName) && Intrinsics.areEqual(this.logoUrl, merchantReviewEntity.logoUrl) && Intrinsics.areEqual(this.reviewId, merchantReviewEntity.reviewId);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.userId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.userName;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.avatar;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.review;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        Integer num = this.rating;
        int hashCode5 = num == null ? 0 : num.hashCode();
        Long l = this.modifyDate;
        int hashCode6 = l == null ? 0 : l.hashCode();
        Long l2 = this.createdDate;
        int hashCode7 = l2 == null ? 0 : l2.hashCode();
        List<MerchantImageEntity> list = this.images;
        int hashCode8 = list == null ? 0 : list.hashCode();
        Boolean bool = this.editable;
        int hashCode9 = bool == null ? 0 : bool.hashCode();
        List<TagEntity> list2 = this.positiveTags;
        int hashCode10 = list2 == null ? 0 : list2.hashCode();
        List<TagEntity> list3 = this.negativeTags;
        int hashCode11 = list3 == null ? 0 : list3.hashCode();
        String str5 = this.merchantId;
        int hashCode12 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.shopId;
        int hashCode13 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.mainName;
        int hashCode14 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.merchantName;
        int hashCode15 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.logoUrl;
        int hashCode16 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.reviewId;
        return (((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + (str10 != null ? str10.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantReviewEntity(userId=");
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
        sb.append(", negativeTags=");
        sb.append(this.negativeTags);
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

    public MerchantReviewEntity(String str, String str2, String str3, String str4, Integer num, Long l, Long l2, List<MerchantImageEntity> list, Boolean bool, List<TagEntity> list2, List<TagEntity> list3, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.userId = str;
        this.userName = str2;
        this.avatar = str3;
        this.review = str4;
        this.rating = num;
        this.modifyDate = l;
        this.createdDate = l2;
        this.images = list;
        this.editable = bool;
        this.positiveTags = list2;
        this.negativeTags = list3;
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

    @JvmName(name = "setUserId")
    public final void setUserId(String str) {
        this.userId = str;
    }

    @JvmName(name = "getUserName")
    public final String getUserName() {
        return this.userName;
    }

    @JvmName(name = "setUserName")
    public final void setUserName(String str) {
        this.userName = str;
    }

    @JvmName(name = "getAvatar")
    public final String getAvatar() {
        return this.avatar;
    }

    @JvmName(name = "setAvatar")
    public final void setAvatar(String str) {
        this.avatar = str;
    }

    @JvmName(name = "getReview")
    public final String getReview() {
        return this.review;
    }

    @JvmName(name = "setReview")
    public final void setReview(String str) {
        this.review = str;
    }

    public /* synthetic */ MerchantReviewEntity(String str, String str2, String str3, String str4, Integer num, Long l, Long l2, List list, Boolean bool, List list2, List list3, String str5, String str6, String str7, String str8, String str9, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? 0 : num, (i & 32) != 0 ? 0L : l, (i & 64) != 0 ? 0L : l2, (i & 128) != 0 ? CollectionsKt.emptyList() : list, (i & 256) != 0 ? Boolean.FALSE : bool, (i & 512) != 0 ? CollectionsKt.emptyList() : list2, (i & 1024) != 0 ? CollectionsKt.emptyList() : list3, (i & 2048) != 0 ? "" : str5, (i & 4096) != 0 ? "" : str6, (i & 8192) != 0 ? "" : str7, (i & 16384) != 0 ? "" : str8, (i & 32768) != 0 ? "" : str9, (i & 65536) != 0 ? "" : str10);
    }

    @JvmName(name = "getRating")
    public final Integer getRating() {
        return this.rating;
    }

    @JvmName(name = "setRating")
    public final void setRating(Integer num) {
        this.rating = num;
    }

    @JvmName(name = "getModifyDate")
    public final Long getModifyDate() {
        return this.modifyDate;
    }

    @JvmName(name = "setModifyDate")
    public final void setModifyDate(Long l) {
        this.modifyDate = l;
    }

    @JvmName(name = "getCreatedDate")
    public final Long getCreatedDate() {
        return this.createdDate;
    }

    @JvmName(name = "setCreatedDate")
    public final void setCreatedDate(Long l) {
        this.createdDate = l;
    }

    @JvmName(name = "getImages")
    public final List<MerchantImageEntity> getImages() {
        return this.images;
    }

    @JvmName(name = "setImages")
    public final void setImages(List<MerchantImageEntity> list) {
        this.images = list;
    }

    @JvmName(name = "getEditable")
    public final Boolean getEditable() {
        return this.editable;
    }

    @JvmName(name = "setEditable")
    public final void setEditable(Boolean bool) {
        this.editable = bool;
    }

    @JvmName(name = "getPositiveTags")
    public final List<TagEntity> getPositiveTags() {
        return this.positiveTags;
    }

    @JvmName(name = "getNegativeTags")
    public final List<TagEntity> getNegativeTags() {
        return this.negativeTags;
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

    public final MerchantReview toMerchantReview() {
        String str = this.userId;
        String str2 = str == null ? "" : str;
        String str3 = this.userName;
        String str4 = str3 == null ? "" : str3;
        String str5 = this.avatar;
        String str6 = str5 == null ? "" : str5;
        String str7 = this.review;
        String str8 = str7 == null ? "" : str7;
        Integer num = this.rating;
        int intValue = num != null ? num.intValue() : 0;
        Long l = this.modifyDate;
        long longValue = l != null ? l.longValue() : 0L;
        Long l2 = this.createdDate;
        long longValue2 = l2 != null ? l2.longValue() : 0L;
        List<MerchantImageEntity> list = this.images;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<MerchantImageEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((MerchantImageEntity) it.next()).toMerchantImage());
        }
        ArrayList arrayList2 = arrayList;
        Boolean bool = this.editable;
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        List<Tag> tag = TagEntityKt.toTag(this.positiveTags);
        List<Tag> tag2 = TagEntityKt.toTag(this.negativeTags);
        String str9 = this.merchantId;
        String str10 = str9 == null ? "" : str9;
        String str11 = this.shopId;
        String str12 = str11 == null ? "" : str11;
        String str13 = this.mainName;
        String str14 = str13 == null ? "" : str13;
        String str15 = this.merchantName;
        String str16 = str15 == null ? "" : str15;
        String str17 = this.logoUrl;
        String str18 = str17 == null ? "" : str17;
        String str19 = this.reviewId;
        return new MerchantReview(str2, str4, str6, str8, intValue, longValue, longValue2, arrayList2, booleanValue, tag, tag2, str10, str12, str14, str16, str18, str19 != null ? str19 : "");
    }
}
