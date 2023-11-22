package id.dana.explore.data.globalsearch.source.network.result;

import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.data.constant.BranchLinkConstant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b<\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0019\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001e\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010\u0012\u0016\b\u0002\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bY\u0010ZJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u001e\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0016J\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u001c\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0012J\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0004J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0004J¨\u0002\u00107\u001a\u00020\u00002\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00192\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001e2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00102\u0016\b\u0002\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00102\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0004\b7\u00108J\u001a\u0010:\u001a\u00020\u00142\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b:\u0010;J\u0010\u0010<\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b<\u0010=J\u0010\u0010>\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b>\u0010\u0004R\u0019\u0010.\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b.\u0010?\u001a\u0004\b@\u0010\u0004R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010?\u001a\u0004\bA\u0010\u0004R\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010?\u001a\u0004\bB\u0010\u0004R\u001c\u00101\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010?\u001a\u0004\bC\u0010\u0004R\u001c\u00102\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010?\u001a\u0004\bD\u0010\u0004R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010?\u001a\u0004\bE\u0010\u0004R(\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010F\u001a\u0004\bG\u0010\u0012R\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010?\u001a\u0004\bH\u0010\u0004R(\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010F\u001a\u0004\bI\u0010\u0012R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010?\u001a\u0004\bJ\u0010\u0004R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00198\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010K\u001a\u0004\bL\u0010\u001bR\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010?\u001a\u0004\bM\u0010\u0004R\u001c\u00106\u001a\u0004\u0018\u00010\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010N\u001a\u0004\bO\u0010\u0016R\u001c\u0010-\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010P\u001a\u0004\bQ\u0010\nR\u001c\u0010,\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010R\u001a\u0004\bS\u0010\u0007R\u001c\u00100\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010?\u001a\u0004\bT\u0010\u0004R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010?\u001a\u0004\bU\u0010\u0004R\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010?\u001a\u0004\bV\u0010\u0004R\u001c\u00105\u001a\u0004\u0018\u00010\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010N\u001a\u0004\bW\u0010\u0016R&\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010F\u001a\u0004\bX\u0010\u0012"}, d2 = {"Lid/dana/explore/data/globalsearch/source/network/result/PaySearchInfoEntity;", "", "", "component1", "()Ljava/lang/String;", "", "component10", "()Ljava/lang/Integer;", "", "component11", "()Ljava/lang/Double;", "component12", "component13", "component14", "component15", "component16", "", "component17", "()Ljava/util/Map;", "component18", "", "component19", "()Ljava/lang/Boolean;", "component2", "component20", "", "component3", "()Ljava/util/List;", "component4", "component5", "", "component6", "component7", "component8", "component9", "id", "name", BranchLinkConstant.OauthParams.MCC, "category", "subCategory", "url", "logo", "tag", "description", FirebaseAnalytics.Param.SCORE, "rating", "address", "infoType", "searchId", "gmtCreate", "gmtModified", "info", "location", "trendingFlag", "newFlag", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lid/dana/explore/data/globalsearch/source/network/result/PaySearchInfoEntity;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAddress", "getCategory", "getDescription", "getGmtCreate", "getGmtModified", "getId", "Ljava/util/Map;", "getInfo", "getInfoType", "getLocation", "getLogo", "Ljava/util/List;", "getMcc", "getName", "Ljava/lang/Boolean;", "getNewFlag", "Ljava/lang/Double;", "getRating", "Ljava/lang/Integer;", "getScore", "getSearchId", "getSubCategory", "getTag", "getTrendingFlag", "getUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaySearchInfoEntity {
    private final String address;
    private final String category;
    private final String description;
    private final String gmtCreate;
    private final String gmtModified;
    private final String id;
    private final Map<String, String> info;
    private final String infoType;
    private final Map<String, String> location;
    private final String logo;
    private final List<String> mcc;
    private final String name;
    private final Boolean newFlag;
    private final Double rating;
    private final Integer score;
    private final String searchId;
    private final String subCategory;
    private final String tag;
    private final Boolean trendingFlag;
    private final Map<String, String> url;

    public PaySearchInfoEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10  reason: from getter */
    public final Integer getScore() {
        return this.score;
    }

    /* renamed from: component11  reason: from getter */
    public final Double getRating() {
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
    public final String getSearchId() {
        return this.searchId;
    }

    /* renamed from: component15  reason: from getter */
    public final String getGmtCreate() {
        return this.gmtCreate;
    }

    /* renamed from: component16  reason: from getter */
    public final String getGmtModified() {
        return this.gmtModified;
    }

    public final Map<String, String> component17() {
        return this.info;
    }

    public final Map<String, String> component18() {
        return this.location;
    }

    /* renamed from: component19  reason: from getter */
    public final Boolean getTrendingFlag() {
        return this.trendingFlag;
    }

    /* renamed from: component2  reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component20  reason: from getter */
    public final Boolean getNewFlag() {
        return this.newFlag;
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
        return this.url;
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

    public final PaySearchInfoEntity copy(String id2, String name, List<String> mcc, String category, String subCategory, Map<String, String> url, String logo, String tag, String description, Integer score, Double rating, String address, String infoType, String searchId, String gmtCreate, String gmtModified, Map<String, String> info, Map<String, String> location, Boolean trendingFlag, Boolean newFlag) {
        Intrinsics.checkNotNullParameter(url, "");
        return new PaySearchInfoEntity(id2, name, mcc, category, subCategory, url, logo, tag, description, score, rating, address, infoType, searchId, gmtCreate, gmtModified, info, location, trendingFlag, newFlag);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PaySearchInfoEntity) {
            PaySearchInfoEntity paySearchInfoEntity = (PaySearchInfoEntity) other;
            return Intrinsics.areEqual(this.id, paySearchInfoEntity.id) && Intrinsics.areEqual(this.name, paySearchInfoEntity.name) && Intrinsics.areEqual(this.mcc, paySearchInfoEntity.mcc) && Intrinsics.areEqual(this.category, paySearchInfoEntity.category) && Intrinsics.areEqual(this.subCategory, paySearchInfoEntity.subCategory) && Intrinsics.areEqual(this.url, paySearchInfoEntity.url) && Intrinsics.areEqual(this.logo, paySearchInfoEntity.logo) && Intrinsics.areEqual(this.tag, paySearchInfoEntity.tag) && Intrinsics.areEqual(this.description, paySearchInfoEntity.description) && Intrinsics.areEqual(this.score, paySearchInfoEntity.score) && Intrinsics.areEqual((Object) this.rating, (Object) paySearchInfoEntity.rating) && Intrinsics.areEqual(this.address, paySearchInfoEntity.address) && Intrinsics.areEqual(this.infoType, paySearchInfoEntity.infoType) && Intrinsics.areEqual(this.searchId, paySearchInfoEntity.searchId) && Intrinsics.areEqual(this.gmtCreate, paySearchInfoEntity.gmtCreate) && Intrinsics.areEqual(this.gmtModified, paySearchInfoEntity.gmtModified) && Intrinsics.areEqual(this.info, paySearchInfoEntity.info) && Intrinsics.areEqual(this.location, paySearchInfoEntity.location) && Intrinsics.areEqual(this.trendingFlag, paySearchInfoEntity.trendingFlag) && Intrinsics.areEqual(this.newFlag, paySearchInfoEntity.newFlag);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.id;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.name;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        List<String> list = this.mcc;
        int hashCode3 = list == null ? 0 : list.hashCode();
        String str3 = this.category;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.subCategory;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        int hashCode6 = this.url.hashCode();
        String str5 = this.logo;
        int hashCode7 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.tag;
        int hashCode8 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.description;
        int hashCode9 = str7 == null ? 0 : str7.hashCode();
        Integer num = this.score;
        int hashCode10 = num == null ? 0 : num.hashCode();
        Double d = this.rating;
        int hashCode11 = d == null ? 0 : d.hashCode();
        String str8 = this.address;
        int hashCode12 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.infoType;
        int hashCode13 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.searchId;
        int hashCode14 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.gmtCreate;
        int hashCode15 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.gmtModified;
        int hashCode16 = str12 == null ? 0 : str12.hashCode();
        Map<String, String> map = this.info;
        int hashCode17 = map == null ? 0 : map.hashCode();
        Map<String, String> map2 = this.location;
        int hashCode18 = map2 == null ? 0 : map2.hashCode();
        Boolean bool = this.trendingFlag;
        int hashCode19 = bool == null ? 0 : bool.hashCode();
        Boolean bool2 = this.newFlag;
        return (((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaySearchInfoEntity(id=");
        sb.append(this.id);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", mcc=");
        sb.append(this.mcc);
        sb.append(", category=");
        sb.append(this.category);
        sb.append(", subCategory=");
        sb.append(this.subCategory);
        sb.append(", url=");
        sb.append(this.url);
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
        sb.append(", searchId=");
        sb.append(this.searchId);
        sb.append(", gmtCreate=");
        sb.append(this.gmtCreate);
        sb.append(", gmtModified=");
        sb.append(this.gmtModified);
        sb.append(", info=");
        sb.append(this.info);
        sb.append(", location=");
        sb.append(this.location);
        sb.append(", trendingFlag=");
        sb.append(this.trendingFlag);
        sb.append(", newFlag=");
        sb.append(this.newFlag);
        sb.append(')');
        return sb.toString();
    }

    public PaySearchInfoEntity(String str, String str2, List<String> list, String str3, String str4, Map<String, String> map, String str5, String str6, String str7, Integer num, Double d, String str8, String str9, String str10, String str11, String str12, Map<String, String> map2, Map<String, String> map3, Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(map, "");
        this.id = str;
        this.name = str2;
        this.mcc = list;
        this.category = str3;
        this.subCategory = str4;
        this.url = map;
        this.logo = str5;
        this.tag = str6;
        this.description = str7;
        this.score = num;
        this.rating = d;
        this.address = str8;
        this.infoType = str9;
        this.searchId = str10;
        this.gmtCreate = str11;
        this.gmtModified = str12;
        this.info = map2;
        this.location = map3;
        this.trendingFlag = bool;
        this.newFlag = bool2;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "getMcc")
    public final List<String> getMcc() {
        return this.mcc;
    }

    @JvmName(name = "getCategory")
    public final String getCategory() {
        return this.category;
    }

    @JvmName(name = "getSubCategory")
    public final String getSubCategory() {
        return this.subCategory;
    }

    public /* synthetic */ PaySearchInfoEntity(String str, String str2, List list, String str3, String str4, Map map, String str5, String str6, String str7, Integer num, Double d, String str8, String str9, String str10, String str11, String str12, Map map2, Map map3, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? new LinkedHashMap() : map, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? 0 : num, (i & 1024) != 0 ? Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) : d, (i & 2048) != 0 ? null : str8, (i & 4096) != 0 ? null : str9, (i & 8192) != 0 ? null : str10, (i & 16384) != 0 ? null : str11, (i & 32768) != 0 ? null : str12, (i & 65536) != 0 ? null : map2, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : map3, (i & 262144) != 0 ? Boolean.FALSE : bool, (i & 524288) != 0 ? Boolean.FALSE : bool2);
    }

    @JvmName(name = "getUrl")
    public final Map<String, String> getUrl() {
        return this.url;
    }

    @JvmName(name = "getLogo")
    public final String getLogo() {
        return this.logo;
    }

    @JvmName(name = "getTag")
    public final String getTag() {
        return this.tag;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "getScore")
    public final Integer getScore() {
        return this.score;
    }

    @JvmName(name = "getRating")
    public final Double getRating() {
        return this.rating;
    }

    @JvmName(name = "getAddress")
    public final String getAddress() {
        return this.address;
    }

    @JvmName(name = "getInfoType")
    public final String getInfoType() {
        return this.infoType;
    }

    @JvmName(name = "getSearchId")
    public final String getSearchId() {
        return this.searchId;
    }

    @JvmName(name = "getGmtCreate")
    public final String getGmtCreate() {
        return this.gmtCreate;
    }

    @JvmName(name = "getGmtModified")
    public final String getGmtModified() {
        return this.gmtModified;
    }

    @JvmName(name = "getInfo")
    public final Map<String, String> getInfo() {
        return this.info;
    }

    @JvmName(name = "getLocation")
    public final Map<String, String> getLocation() {
        return this.location;
    }

    @JvmName(name = "getTrendingFlag")
    public final Boolean getTrendingFlag() {
        return this.trendingFlag;
    }

    @JvmName(name = "getNewFlag")
    public final Boolean getNewFlag() {
        return this.newFlag;
    }
}
