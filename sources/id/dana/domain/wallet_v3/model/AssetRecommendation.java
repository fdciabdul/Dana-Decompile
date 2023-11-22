package id.dana.domain.wallet_v3.model;

import com.alibaba.griver.core.GriverParams;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.utils.StringWrapper;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b*\b\u0086\b\u0018\u0000 B2\u00020\u0001:\u0001BBq\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b@\u0010AJ\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0011J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0016\u0010\tJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0017\u0010\tJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u008c\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010!\u001a\u00020\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010$\u001a\u00020\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b-\u0010\tR\u0017\u0010\u001f\u001a\u00020\u000f8\u0007¢\u0006\f\n\u0004\b\u001f\u0010.\u001a\u0004\b/\u0010\u0011R\u001c\u0010#\u001a\u0004\u0018\u00010\u00188\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u00100\u001a\u0004\b1\u0010\u001aR\u001c\u0010\"\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00102\u001a\u0004\b3\u0010\tR\u001a\u0010\u001e\u001a\u00020\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b4\u0010\u0011R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00102\u001a\u0004\b5\u0010\tR \u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00106\u001a\u0004\b7\u0010\u0015R\u001a\u0010!\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00102\u001a\u0004\b8\u0010\tR\u001a\u0010$\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u00102\u001a\u0004\b9\u0010\tR\u001a\u0010\u001b\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\b:\u0010\tR$\u0010%\u001a\u0004\u0018\u00010\u000b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010;\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010>R\u001a\u0010\u001d\u001a\u00020\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010.\u001a\u0004\b?\u0010\u0011"}, d2 = {"Lid/dana/domain/wallet_v3/model/AssetRecommendation;", "", "", "", "results", "", "checkRules", "(Ljava/util/List;)Z", "component1", "()Ljava/lang/String;", "component10", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "component11", "()Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "component2", "Lid/dana/utils/StringWrapper;", "component3", "()Lid/dana/utils/StringWrapper;", "component4", "component5", "component6", "()Ljava/util/List;", "component7", "component8", "", "component9", "()Ljava/lang/Integer;", "service", GriverParams.ShareParams.IMAGE_URL, "title", "desc", "btnTitle", "keywords", "rawSQL", "comparisonOperator", "comparator", "sectionType", "thirdPartyServiceResponse", "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/utils/StringWrapper;Lid/dana/utils/StringWrapper;Lid/dana/utils/StringWrapper;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;)Lid/dana/domain/wallet_v3/model/AssetRecommendation;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Lid/dana/utils/StringWrapper;", "getBtnTitle", "Ljava/lang/Integer;", "getComparator", "Ljava/lang/String;", "getComparisonOperator", "getDesc", "getImageUrl", "Ljava/util/List;", "getKeywords", "getRawSQL", "getSectionType", "getService", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "getThirdPartyServiceResponse", "setThirdPartyServiceResponse", "(Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;)V", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/utils/StringWrapper;Lid/dana/utils/StringWrapper;Lid/dana/utils/StringWrapper;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AssetRecommendation {
    private static final String EQUALS = "==";
    private static final String LOWER_THAN = "<";
    private static final String LOWER_THAN_EQUALS = "<=";
    private static final String MORE_THAN = ">";
    private static final String MORE_THAN_EQUALS = ">=";
    private static final String NOT_EQUALS = "!=";
    private final StringWrapper btnTitle;
    private final Integer comparator;
    private final String comparisonOperator;
    private final StringWrapper desc;
    private final String imageUrl;
    private final List<String> keywords;
    private final String rawSQL;
    private final String sectionType;
    private final String service;
    private ThirdPartyServiceResponse thirdPartyServiceResponse;
    private final StringWrapper title;

    /* renamed from: component1  reason: from getter */
    public final String getService() {
        return this.service;
    }

    /* renamed from: component10  reason: from getter */
    public final String getSectionType() {
        return this.sectionType;
    }

    /* renamed from: component11  reason: from getter */
    public final ThirdPartyServiceResponse getThirdPartyServiceResponse() {
        return this.thirdPartyServiceResponse;
    }

    /* renamed from: component2  reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: component3  reason: from getter */
    public final StringWrapper getTitle() {
        return this.title;
    }

    /* renamed from: component4  reason: from getter */
    public final StringWrapper getDesc() {
        return this.desc;
    }

    /* renamed from: component5  reason: from getter */
    public final StringWrapper getBtnTitle() {
        return this.btnTitle;
    }

    public final List<String> component6() {
        return this.keywords;
    }

    /* renamed from: component7  reason: from getter */
    public final String getRawSQL() {
        return this.rawSQL;
    }

    /* renamed from: component8  reason: from getter */
    public final String getComparisonOperator() {
        return this.comparisonOperator;
    }

    /* renamed from: component9  reason: from getter */
    public final Integer getComparator() {
        return this.comparator;
    }

    public final AssetRecommendation copy(String service, String imageUrl, StringWrapper title, StringWrapper desc, StringWrapper btnTitle, List<String> keywords, String rawSQL, String comparisonOperator, Integer comparator, String sectionType, ThirdPartyServiceResponse thirdPartyServiceResponse) {
        Intrinsics.checkNotNullParameter(service, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(desc, "");
        Intrinsics.checkNotNullParameter(btnTitle, "");
        Intrinsics.checkNotNullParameter(keywords, "");
        Intrinsics.checkNotNullParameter(rawSQL, "");
        Intrinsics.checkNotNullParameter(sectionType, "");
        return new AssetRecommendation(service, imageUrl, title, desc, btnTitle, keywords, rawSQL, comparisonOperator, comparator, sectionType, thirdPartyServiceResponse);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AssetRecommendation) {
            AssetRecommendation assetRecommendation = (AssetRecommendation) other;
            return Intrinsics.areEqual(this.service, assetRecommendation.service) && Intrinsics.areEqual(this.imageUrl, assetRecommendation.imageUrl) && Intrinsics.areEqual(this.title, assetRecommendation.title) && Intrinsics.areEqual(this.desc, assetRecommendation.desc) && Intrinsics.areEqual(this.btnTitle, assetRecommendation.btnTitle) && Intrinsics.areEqual(this.keywords, assetRecommendation.keywords) && Intrinsics.areEqual(this.rawSQL, assetRecommendation.rawSQL) && Intrinsics.areEqual(this.comparisonOperator, assetRecommendation.comparisonOperator) && Intrinsics.areEqual(this.comparator, assetRecommendation.comparator) && Intrinsics.areEqual(this.sectionType, assetRecommendation.sectionType) && Intrinsics.areEqual(this.thirdPartyServiceResponse, assetRecommendation.thirdPartyServiceResponse);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.service.hashCode();
        String str = this.imageUrl;
        int hashCode2 = str == null ? 0 : str.hashCode();
        int hashCode3 = this.title.hashCode();
        int hashCode4 = this.desc.hashCode();
        int hashCode5 = this.btnTitle.hashCode();
        int hashCode6 = this.keywords.hashCode();
        int hashCode7 = this.rawSQL.hashCode();
        String str2 = this.comparisonOperator;
        int hashCode8 = str2 == null ? 0 : str2.hashCode();
        Integer num = this.comparator;
        int hashCode9 = num == null ? 0 : num.hashCode();
        int hashCode10 = this.sectionType.hashCode();
        ThirdPartyServiceResponse thirdPartyServiceResponse = this.thirdPartyServiceResponse;
        return (((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + (thirdPartyServiceResponse != null ? thirdPartyServiceResponse.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AssetRecommendation(service=");
        sb.append(this.service);
        sb.append(", imageUrl=");
        sb.append(this.imageUrl);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", desc=");
        sb.append(this.desc);
        sb.append(", btnTitle=");
        sb.append(this.btnTitle);
        sb.append(", keywords=");
        sb.append(this.keywords);
        sb.append(", rawSQL=");
        sb.append(this.rawSQL);
        sb.append(", comparisonOperator=");
        sb.append(this.comparisonOperator);
        sb.append(", comparator=");
        sb.append(this.comparator);
        sb.append(", sectionType=");
        sb.append(this.sectionType);
        sb.append(", thirdPartyServiceResponse=");
        sb.append(this.thirdPartyServiceResponse);
        sb.append(')');
        return sb.toString();
    }

    public AssetRecommendation(String str, String str2, StringWrapper stringWrapper, StringWrapper stringWrapper2, StringWrapper stringWrapper3, List<String> list, String str3, String str4, Integer num, String str5, ThirdPartyServiceResponse thirdPartyServiceResponse) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(stringWrapper, "");
        Intrinsics.checkNotNullParameter(stringWrapper2, "");
        Intrinsics.checkNotNullParameter(stringWrapper3, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.service = str;
        this.imageUrl = str2;
        this.title = stringWrapper;
        this.desc = stringWrapper2;
        this.btnTitle = stringWrapper3;
        this.keywords = list;
        this.rawSQL = str3;
        this.comparisonOperator = str4;
        this.comparator = num;
        this.sectionType = str5;
        this.thirdPartyServiceResponse = thirdPartyServiceResponse;
    }

    @JvmName(name = "getService")
    public final String getService() {
        return this.service;
    }

    @JvmName(name = "getImageUrl")
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @JvmName(name = "getTitle")
    public final StringWrapper getTitle() {
        return this.title;
    }

    @JvmName(name = "getDesc")
    public final StringWrapper getDesc() {
        return this.desc;
    }

    @JvmName(name = "getBtnTitle")
    public final StringWrapper getBtnTitle() {
        return this.btnTitle;
    }

    public /* synthetic */ AssetRecommendation(String str, String str2, StringWrapper stringWrapper, StringWrapper stringWrapper2, StringWrapper stringWrapper3, List list, String str3, String str4, Integer num, String str5, ThirdPartyServiceResponse thirdPartyServiceResponse, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, stringWrapper, stringWrapper2, stringWrapper3, (i & 32) != 0 ? CollectionsKt.emptyList() : list, str3, str4, num, str5, (i & 1024) != 0 ? null : thirdPartyServiceResponse);
    }

    @JvmName(name = "getKeywords")
    public final List<String> getKeywords() {
        return this.keywords;
    }

    @JvmName(name = "getRawSQL")
    public final String getRawSQL() {
        return this.rawSQL;
    }

    @JvmName(name = "getComparisonOperator")
    public final String getComparisonOperator() {
        return this.comparisonOperator;
    }

    @JvmName(name = "getComparator")
    public final Integer getComparator() {
        return this.comparator;
    }

    @JvmName(name = "getSectionType")
    public final String getSectionType() {
        return this.sectionType;
    }

    @JvmName(name = "getThirdPartyServiceResponse")
    public final ThirdPartyServiceResponse getThirdPartyServiceResponse() {
        return this.thirdPartyServiceResponse;
    }

    @JvmName(name = "setThirdPartyServiceResponse")
    public final void setThirdPartyServiceResponse(ThirdPartyServiceResponse thirdPartyServiceResponse) {
        this.thirdPartyServiceResponse = thirdPartyServiceResponse;
    }

    public final boolean checkRules(List<String> results) {
        Intrinsics.checkNotNullParameter(results, "");
        Integer num = this.comparator;
        if (num != null) {
            int intValue = num.intValue();
            String str = this.comparisonOperator;
            String str2 = str != null ? str : "";
            int hashCode = str2.hashCode();
            if (hashCode != 60) {
                if (hashCode != 62) {
                    if (hashCode != 1084) {
                        if (hashCode != 1921) {
                            if (hashCode != 1952) {
                                if (hashCode != 1983 || !str2.equals(">=") || results.size() < intValue) {
                                    return false;
                                }
                            } else if (!str2.equals(EQUALS) || results.size() != intValue) {
                                return false;
                            }
                        } else if (!str2.equals("<=") || results.size() > intValue) {
                            return false;
                        }
                    } else if (!str2.equals(NOT_EQUALS) || results.size() == intValue) {
                        return false;
                    }
                } else if (!str2.equals(">") || results.size() <= intValue) {
                    return false;
                }
            } else if (!str2.equals("<") || results.size() >= intValue) {
                return false;
            }
            return true;
        }
        return false;
    }
}
