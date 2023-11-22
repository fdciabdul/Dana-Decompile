package id.dana.explore.domain.globalsearch.model;

import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.domain.globalsearch.model.LatLng;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010%\n\u0002\bP\b\u0086\b\u0018\u00002\u00020\u0001BÛ\u0001\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001e\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0005\u0012\b\b\u0002\u0010-\u001a\u00020\b\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\b\b\u0002\u0010/\u001a\u00020\u0002\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u00101\u001a\u00020\r\u0012\u0014\b\u0002\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011\u0012\b\b\u0002\u00103\u001a\u00020\u0014\u0012\b\b\u0002\u00104\u001a\u00020\u0014¢\u0006\u0004\bm\u0010nJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u001c\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0013J\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0004J\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0004Jä\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00022\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u00022\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001e2\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u00022\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\b2\b\b\u0002\u0010.\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\u00022\n\b\u0002\u00100\u001a\u0004\u0018\u00010\r2\b\b\u0002\u00101\u001a\u00020\r2\u0014\b\u0002\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00112\b\b\u0002\u00103\u001a\u00020\u00142\b\b\u0002\u00104\u001a\u00020\u0014HÆ\u0001¢\u0006\u0004\b5\u00106J\u001a\u00108\u001a\u00020\u00142\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b:\u0010\u0007J\u0010\u0010;\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b;\u0010\u0004R\"\u0010.\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010<\u001a\u0004\b=\u0010\u0004\"\u0004\b>\u0010?R\"\u0010&\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010<\u001a\u0004\b@\u0010\u0004\"\u0004\bA\u0010?R\"\u0010+\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010<\u001a\u0004\bB\u0010\u0004\"\u0004\bC\u0010?R\"\u0010#\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010<\u001a\u0004\bD\u0010\u0004\"\u0004\bE\u0010?R.\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010F\u001a\u0004\bG\u0010\u0013\"\u0004\bH\u0010IR\"\u0010/\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010<\u001a\u0004\bJ\u0010\u0004\"\u0004\bK\u0010?R$\u00100\u001a\u0004\u0018\u00010\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010L\u001a\u0004\bM\u0010\u000f\"\u0004\bN\u0010OR\"\u0010)\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010<\u001a\u0004\bP\u0010\u0004\"\u0004\bQ\u0010?R(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u00198\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010R\u001a\u0004\bS\u0010\u001b\"\u0004\bT\u0010UR\"\u0010$\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010<\u001a\u0004\bV\u0010\u0004\"\u0004\bW\u0010?R\u001a\u00104\u001a\u00020\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010X\u001a\u0004\bY\u0010\u0016R\"\u0010-\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010Z\u001a\u0004\b[\u0010\n\"\u0004\b\\\u0010]R\"\u0010,\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010^\u001a\u0004\b_\u0010\u0007\"\u0004\b`\u0010aR\"\u0010'\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010<\u001a\u0004\bb\u0010\u0004\"\u0004\bc\u0010?R\"\u0010*\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010<\u001a\u0004\bd\u0010\u0004\"\u0004\be\u0010?R\"\u00103\u001a\u00020\u00148\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010X\u001a\u0004\bf\u0010\u0016\"\u0004\bg\u0010hR.\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010F\u001a\u0004\bi\u0010\u0013\"\u0004\bj\u0010IR\"\u00101\u001a\u00020\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010L\u001a\u0004\bk\u0010\u000f\"\u0004\bl\u0010O"}, d2 = {"Lid/dana/explore/domain/globalsearch/model/PaySearchInfo;", "", "", "component1", "()Ljava/lang/String;", "", "component10", "()I", "", "component11", "()D", "component12", "component13", "Lid/dana/domain/globalsearch/model/LatLng;", "component14", "()Lid/dana/domain/globalsearch/model/LatLng;", "component15", "", "component16", "()Ljava/util/Map;", "", "component17", "()Z", "component18", "component2", "", "component3", "()Ljava/util/List;", "component4", "component5", "", "component6", "component7", "component8", "component9", "id", "name", BranchLinkConstant.OauthParams.MCC, "category", "subCategory", "urlMap", "logo", "tag", "description", FirebaseAnalytics.Param.SCORE, "rating", "address", "infoType", "location", "userLocation", "info", "trendingFlag", "newFlag", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDLjava/lang/String;Ljava/lang/String;Lid/dana/domain/globalsearch/model/LatLng;Lid/dana/domain/globalsearch/model/LatLng;Ljava/util/Map;ZZ)Lid/dana/explore/domain/globalsearch/model/PaySearchInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getAddress", "setAddress", "(Ljava/lang/String;)V", "getCategory", "setCategory", "getDescription", "setDescription", "getId", "setId", "Ljava/util/Map;", "getInfo", "setInfo", "(Ljava/util/Map;)V", "getInfoType", "setInfoType", "Lid/dana/domain/globalsearch/model/LatLng;", "getLocation", "setLocation", "(Lid/dana/domain/globalsearch/model/LatLng;)V", "getLogo", "setLogo", "Ljava/util/List;", "getMcc", "setMcc", "(Ljava/util/List;)V", "getName", "setName", "Z", "getNewFlag", SummaryActivity.DAYS, "getRating", "setRating", "(D)V", "I", "getScore", "setScore", "(I)V", "getSubCategory", "setSubCategory", "getTag", "setTag", "getTrendingFlag", "setTrendingFlag", "(Z)V", "getUrlMap", "setUrlMap", "getUserLocation", "setUserLocation", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDLjava/lang/String;Ljava/lang/String;Lid/dana/domain/globalsearch/model/LatLng;Lid/dana/domain/globalsearch/model/LatLng;Ljava/util/Map;ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaySearchInfo {
    private String address;
    private String category;
    private String description;
    private String id;
    private Map<String, String> info;
    private String infoType;
    private LatLng location;
    private String logo;
    private List<String> mcc;
    private String name;
    private final boolean newFlag;
    private double rating;
    private int score;
    private String subCategory;
    private String tag;
    private boolean trendingFlag;
    private Map<String, String> urlMap;
    private LatLng userLocation;

    public PaySearchInfo() {
        this(null, null, null, null, null, null, null, null, null, 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, false, false, 262143, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10  reason: from getter */
    public final int getScore() {
        return this.score;
    }

    /* renamed from: component11  reason: from getter */
    public final double getRating() {
        return this.rating;
    }

    /* renamed from: component12  reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component13  reason: from getter */
    public final String getInfoType() {
        return this.infoType;
    }

    /* renamed from: component14  reason: from getter */
    public final LatLng getLocation() {
        return this.location;
    }

    /* renamed from: component15  reason: from getter */
    public final LatLng getUserLocation() {
        return this.userLocation;
    }

    public final Map<String, String> component16() {
        return this.info;
    }

    /* renamed from: component17  reason: from getter */
    public final boolean getTrendingFlag() {
        return this.trendingFlag;
    }

    /* renamed from: component18  reason: from getter */
    public final boolean getNewFlag() {
        return this.newFlag;
    }

    /* renamed from: component2  reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<String> component3() {
        return this.mcc;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component5  reason: from getter */
    public final String getSubCategory() {
        return this.subCategory;
    }

    public final Map<String, String> component6() {
        return this.urlMap;
    }

    /* renamed from: component7  reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    /* renamed from: component8  reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* renamed from: component9  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final PaySearchInfo copy(String id2, String name, List<String> mcc, String category, String subCategory, Map<String, String> urlMap, String logo, String tag, String description, int score, double rating, String address, String infoType, LatLng location, LatLng userLocation, Map<String, String> info, boolean trendingFlag, boolean newFlag) {
        Intrinsics.checkNotNullParameter(id2, "");
        Intrinsics.checkNotNullParameter(name, "");
        Intrinsics.checkNotNullParameter(mcc, "");
        Intrinsics.checkNotNullParameter(category, "");
        Intrinsics.checkNotNullParameter(subCategory, "");
        Intrinsics.checkNotNullParameter(urlMap, "");
        Intrinsics.checkNotNullParameter(logo, "");
        Intrinsics.checkNotNullParameter(tag, "");
        Intrinsics.checkNotNullParameter(description, "");
        Intrinsics.checkNotNullParameter(address, "");
        Intrinsics.checkNotNullParameter(infoType, "");
        Intrinsics.checkNotNullParameter(userLocation, "");
        Intrinsics.checkNotNullParameter(info, "");
        return new PaySearchInfo(id2, name, mcc, category, subCategory, urlMap, logo, tag, description, score, rating, address, infoType, location, userLocation, info, trendingFlag, newFlag);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PaySearchInfo) {
            PaySearchInfo paySearchInfo = (PaySearchInfo) other;
            return Intrinsics.areEqual(this.id, paySearchInfo.id) && Intrinsics.areEqual(this.name, paySearchInfo.name) && Intrinsics.areEqual(this.mcc, paySearchInfo.mcc) && Intrinsics.areEqual(this.category, paySearchInfo.category) && Intrinsics.areEqual(this.subCategory, paySearchInfo.subCategory) && Intrinsics.areEqual(this.urlMap, paySearchInfo.urlMap) && Intrinsics.areEqual(this.logo, paySearchInfo.logo) && Intrinsics.areEqual(this.tag, paySearchInfo.tag) && Intrinsics.areEqual(this.description, paySearchInfo.description) && this.score == paySearchInfo.score && Intrinsics.areEqual((Object) Double.valueOf(this.rating), (Object) Double.valueOf(paySearchInfo.rating)) && Intrinsics.areEqual(this.address, paySearchInfo.address) && Intrinsics.areEqual(this.infoType, paySearchInfo.infoType) && Intrinsics.areEqual(this.location, paySearchInfo.location) && Intrinsics.areEqual(this.userLocation, paySearchInfo.userLocation) && Intrinsics.areEqual(this.info, paySearchInfo.info) && this.trendingFlag == paySearchInfo.trendingFlag && this.newFlag == paySearchInfo.newFlag;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.id.hashCode();
        int hashCode2 = this.name.hashCode();
        int hashCode3 = this.mcc.hashCode();
        int hashCode4 = this.category.hashCode();
        int hashCode5 = this.subCategory.hashCode();
        int hashCode6 = this.urlMap.hashCode();
        int hashCode7 = this.logo.hashCode();
        int hashCode8 = this.tag.hashCode();
        int hashCode9 = this.description.hashCode();
        int i = this.score;
        int KClassImpl$Data$declaredNonStaticMembers$2 = BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.rating);
        int hashCode10 = this.address.hashCode();
        int hashCode11 = this.infoType.hashCode();
        LatLng latLng = this.location;
        int hashCode12 = latLng == null ? 0 : latLng.hashCode();
        int hashCode13 = this.userLocation.hashCode();
        int hashCode14 = this.info.hashCode();
        boolean z = this.trendingFlag;
        int i2 = z ? 1 : z ? 1 : 0;
        boolean z2 = this.newFlag;
        return (((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + i) * 31) + KClassImpl$Data$declaredNonStaticMembers$2) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + i2) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaySearchInfo(id=");
        sb.append(this.id);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", mcc=");
        sb.append(this.mcc);
        sb.append(", category=");
        sb.append(this.category);
        sb.append(", subCategory=");
        sb.append(this.subCategory);
        sb.append(", urlMap=");
        sb.append(this.urlMap);
        sb.append(", logo=");
        sb.append(this.logo);
        sb.append(", tag=");
        sb.append(this.tag);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", score=");
        sb.append(this.score);
        sb.append(", rating=");
        sb.append(this.rating);
        sb.append(", address=");
        sb.append(this.address);
        sb.append(", infoType=");
        sb.append(this.infoType);
        sb.append(", location=");
        sb.append(this.location);
        sb.append(", userLocation=");
        sb.append(this.userLocation);
        sb.append(", info=");
        sb.append(this.info);
        sb.append(", trendingFlag=");
        sb.append(this.trendingFlag);
        sb.append(", newFlag=");
        sb.append(this.newFlag);
        sb.append(')');
        return sb.toString();
    }

    public PaySearchInfo(String str, String str2, List<String> list, String str3, String str4, Map<String, String> map, String str5, String str6, String str7, int i, double d, String str8, String str9, LatLng latLng, LatLng latLng2, Map<String, String> map2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(latLng2, "");
        Intrinsics.checkNotNullParameter(map2, "");
        this.id = str;
        this.name = str2;
        this.mcc = list;
        this.category = str3;
        this.subCategory = str4;
        this.urlMap = map;
        this.logo = str5;
        this.tag = str6;
        this.description = str7;
        this.score = i;
        this.rating = d;
        this.address = str8;
        this.infoType = str9;
        this.location = latLng;
        this.userLocation = latLng2;
        this.info = map2;
        this.trendingFlag = z;
        this.newFlag = z2;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "setId")
    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.id = str;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "setName")
    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.name = str;
    }

    public /* synthetic */ PaySearchInfo(String str, String str2, List list, String str3, String str4, Map map, String str5, String str6, String str7, int i, double d, String str8, String str9, LatLng latLng, LatLng latLng2, Map map2, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? new ArrayList() : list, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? new LinkedHashMap() : map, (i2 & 64) != 0 ? "" : str5, (i2 & 128) != 0 ? "" : str6, (i2 & 256) != 0 ? "" : str7, (i2 & 512) != 0 ? 0 : i, (i2 & 1024) != 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : d, (i2 & 2048) != 0 ? "" : str8, (i2 & 4096) == 0 ? str9 : "", (i2 & 8192) != 0 ? null : latLng, (i2 & 16384) != 0 ? new LatLng(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 3, null) : latLng2, (i2 & 32768) != 0 ? new LinkedHashMap() : map2, (i2 & 65536) != 0 ? false : z, (i2 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? false : z2);
    }

    @JvmName(name = "getMcc")
    public final List<String> getMcc() {
        return this.mcc;
    }

    @JvmName(name = "setMcc")
    public final void setMcc(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.mcc = list;
    }

    @JvmName(name = "getCategory")
    public final String getCategory() {
        return this.category;
    }

    @JvmName(name = "setCategory")
    public final void setCategory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.category = str;
    }

    @JvmName(name = "getSubCategory")
    public final String getSubCategory() {
        return this.subCategory;
    }

    @JvmName(name = "setSubCategory")
    public final void setSubCategory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.subCategory = str;
    }

    @JvmName(name = "getUrlMap")
    public final Map<String, String> getUrlMap() {
        return this.urlMap;
    }

    @JvmName(name = "setUrlMap")
    public final void setUrlMap(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.urlMap = map;
    }

    @JvmName(name = "getLogo")
    public final String getLogo() {
        return this.logo;
    }

    @JvmName(name = "setLogo")
    public final void setLogo(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.logo = str;
    }

    @JvmName(name = "getTag")
    public final String getTag() {
        return this.tag;
    }

    @JvmName(name = "setTag")
    public final void setTag(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.tag = str;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "setDescription")
    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.description = str;
    }

    @JvmName(name = "getScore")
    public final int getScore() {
        return this.score;
    }

    @JvmName(name = "setScore")
    public final void setScore(int i) {
        this.score = i;
    }

    @JvmName(name = "getRating")
    public final double getRating() {
        return this.rating;
    }

    @JvmName(name = "setRating")
    public final void setRating(double d) {
        this.rating = d;
    }

    @JvmName(name = "getAddress")
    public final String getAddress() {
        return this.address;
    }

    @JvmName(name = "setAddress")
    public final void setAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.address = str;
    }

    @JvmName(name = "getInfoType")
    public final String getInfoType() {
        return this.infoType;
    }

    @JvmName(name = "setInfoType")
    public final void setInfoType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.infoType = str;
    }

    @JvmName(name = "getLocation")
    public final LatLng getLocation() {
        return this.location;
    }

    @JvmName(name = "setLocation")
    public final void setLocation(LatLng latLng) {
        this.location = latLng;
    }

    @JvmName(name = "getUserLocation")
    public final LatLng getUserLocation() {
        return this.userLocation;
    }

    @JvmName(name = "setUserLocation")
    public final void setUserLocation(LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "");
        this.userLocation = latLng;
    }

    @JvmName(name = "getInfo")
    public final Map<String, String> getInfo() {
        return this.info;
    }

    @JvmName(name = "setInfo")
    public final void setInfo(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.info = map;
    }

    @JvmName(name = "getTrendingFlag")
    public final boolean getTrendingFlag() {
        return this.trendingFlag;
    }

    @JvmName(name = "setTrendingFlag")
    public final void setTrendingFlag(boolean z) {
        this.trendingFlag = z;
    }

    @JvmName(name = "getNewFlag")
    public final boolean getNewFlag() {
        return this.newFlag;
    }
}
