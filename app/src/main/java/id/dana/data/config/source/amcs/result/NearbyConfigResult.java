package id.dana.data.config.source.amcs.result;

import id.dana.data.config.model.NearbyTrendingKeywordEntity;
import id.dana.data.nearbysearch.mapper.NearbyTrendingKeywordEntityMapperKt;
import id.dana.domain.nearbyme.model.NearbyConfig;
import id.dana.domain.nearbysearch.model.NearbyTrendingKeyword;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b)\u0010*J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJF\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0007¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010\u000bR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b(\u0010\u0005"}, d2 = {"Lid/dana/data/config/source/amcs/result/NearbyConfigResult;", "", "", "Lid/dana/data/config/model/NearbyTrendingKeywordEntity;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/Boolean;", "", "component3", "()Ljava/lang/Double;", "Lid/dana/data/config/source/amcs/result/NearbyMigrateApiResult;", "component4", "()Lid/dana/data/config/source/amcs/result/NearbyMigrateApiResult;", "trendingKeyword", "nearbyRevamp", "reviewCount", "migrateApi", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Double;Lid/dana/data/config/source/amcs/result/NearbyMigrateApiResult;)Lid/dana/data/config/source/amcs/result/NearbyConfigResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lid/dana/domain/nearbyme/model/NearbyConfig;", "toNearbyConfig", "()Lid/dana/domain/nearbyme/model/NearbyConfig;", "", "toString", "()Ljava/lang/String;", "Lid/dana/data/config/source/amcs/result/NearbyMigrateApiResult;", "getMigrateApi", "Ljava/lang/Boolean;", "getNearbyRevamp", "Ljava/lang/Double;", "getReviewCount", "Ljava/util/List;", "getTrendingKeyword", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Double;Lid/dana/data/config/source/amcs/result/NearbyMigrateApiResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class NearbyConfigResult {
    public NearbyMigrateApiResult migrateApi;
    public Boolean nearbyRevamp;
    public Double reviewCount;
    public List<NearbyTrendingKeywordEntity> trendingKeyword;

    public NearbyConfigResult() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NearbyConfigResult copy$default(NearbyConfigResult nearbyConfigResult, List list, Boolean bool, Double d, NearbyMigrateApiResult nearbyMigrateApiResult, int i, Object obj) {
        if ((i & 1) != 0) {
            list = nearbyConfigResult.trendingKeyword;
        }
        if ((i & 2) != 0) {
            bool = nearbyConfigResult.nearbyRevamp;
        }
        if ((i & 4) != 0) {
            d = nearbyConfigResult.reviewCount;
        }
        if ((i & 8) != 0) {
            nearbyMigrateApiResult = nearbyConfigResult.migrateApi;
        }
        return nearbyConfigResult.copy(list, bool, d, nearbyMigrateApiResult);
    }

    public final List<NearbyTrendingKeywordEntity> component1() {
        return this.trendingKeyword;
    }

    /* renamed from: component2  reason: from getter */
    public final Boolean getNearbyRevamp() {
        return this.nearbyRevamp;
    }

    /* renamed from: component3  reason: from getter */
    public final Double getReviewCount() {
        return this.reviewCount;
    }

    /* renamed from: component4  reason: from getter */
    public final NearbyMigrateApiResult getMigrateApi() {
        return this.migrateApi;
    }

    public final NearbyConfigResult copy(List<NearbyTrendingKeywordEntity> trendingKeyword, Boolean nearbyRevamp, Double reviewCount, NearbyMigrateApiResult migrateApi) {
        return new NearbyConfigResult(trendingKeyword, nearbyRevamp, reviewCount, migrateApi);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof NearbyConfigResult) {
            NearbyConfigResult nearbyConfigResult = (NearbyConfigResult) other;
            return Intrinsics.areEqual(this.trendingKeyword, nearbyConfigResult.trendingKeyword) && Intrinsics.areEqual(this.nearbyRevamp, nearbyConfigResult.nearbyRevamp) && Intrinsics.areEqual((Object) this.reviewCount, (Object) nearbyConfigResult.reviewCount) && Intrinsics.areEqual(this.migrateApi, nearbyConfigResult.migrateApi);
        }
        return false;
    }

    public final int hashCode() {
        List<NearbyTrendingKeywordEntity> list = this.trendingKeyword;
        int hashCode = list == null ? 0 : list.hashCode();
        Boolean bool = this.nearbyRevamp;
        int hashCode2 = bool == null ? 0 : bool.hashCode();
        Double d = this.reviewCount;
        int hashCode3 = d == null ? 0 : d.hashCode();
        NearbyMigrateApiResult nearbyMigrateApiResult = this.migrateApi;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (nearbyMigrateApiResult != null ? nearbyMigrateApiResult.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NearbyConfigResult(trendingKeyword=");
        sb.append(this.trendingKeyword);
        sb.append(", nearbyRevamp=");
        sb.append(this.nearbyRevamp);
        sb.append(", reviewCount=");
        sb.append(this.reviewCount);
        sb.append(", migrateApi=");
        sb.append(this.migrateApi);
        sb.append(')');
        return sb.toString();
    }

    public NearbyConfigResult(List<NearbyTrendingKeywordEntity> list, Boolean bool, Double d, NearbyMigrateApiResult nearbyMigrateApiResult) {
        this.trendingKeyword = list;
        this.nearbyRevamp = bool;
        this.reviewCount = d;
        this.migrateApi = nearbyMigrateApiResult;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r8v4, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ NearbyConfigResult(java.util.List r3, java.lang.Boolean r4, java.lang.Double r5, id.dana.data.config.source.amcs.result.NearbyMigrateApiResult r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r2 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L8
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
        L8:
            r8 = r7 & 2
            if (r8 == 0) goto Le
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
        Le:
            r8 = r7 & 4
            if (r8 == 0) goto L18
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.Double r5 = java.lang.Double.valueOf(r0)
        L18:
            r7 = r7 & 8
            if (r7 == 0) goto L23
            id.dana.data.config.source.amcs.result.NearbyMigrateApiResult r6 = new id.dana.data.config.source.amcs.result.NearbyMigrateApiResult
            r7 = 3
            r8 = 0
            r6.<init>(r8, r8, r7, r8)
        L23:
            r2.<init>(r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.config.source.amcs.result.NearbyConfigResult.<init>(java.util.List, java.lang.Boolean, java.lang.Double, id.dana.data.config.source.amcs.result.NearbyMigrateApiResult, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getTrendingKeyword")
    public final List<NearbyTrendingKeywordEntity> getTrendingKeyword() {
        return this.trendingKeyword;
    }

    @JvmName(name = "getNearbyRevamp")
    public final Boolean getNearbyRevamp() {
        return this.nearbyRevamp;
    }

    @JvmName(name = "getReviewCount")
    public final Double getReviewCount() {
        return this.reviewCount;
    }

    @JvmName(name = "getMigrateApi")
    public final NearbyMigrateApiResult getMigrateApi() {
        return this.migrateApi;
    }

    public final NearbyConfig toNearbyConfig() {
        Boolean queryRadius;
        Boolean queryList;
        List<NearbyTrendingKeywordEntity> list = this.trendingKeyword;
        List<NearbyTrendingKeyword> BuiltInFictitiousFunctionClassFactory = list != null ? NearbyTrendingKeywordEntityMapperKt.BuiltInFictitiousFunctionClassFactory(list) : null;
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = CollectionsKt.emptyList();
        }
        List<NearbyTrendingKeyword> list2 = BuiltInFictitiousFunctionClassFactory;
        Boolean bool = this.nearbyRevamp;
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        Double d = this.reviewCount;
        double doubleValue = d != null ? d.doubleValue() : 1.0d;
        NearbyMigrateApiResult nearbyMigrateApiResult = this.migrateApi;
        boolean booleanValue2 = (nearbyMigrateApiResult == null || (queryList = nearbyMigrateApiResult.getQueryList()) == null) ? false : queryList.booleanValue();
        NearbyMigrateApiResult nearbyMigrateApiResult2 = this.migrateApi;
        return new NearbyConfig(list2, booleanValue, doubleValue, booleanValue2, (nearbyMigrateApiResult2 == null || (queryRadius = nearbyMigrateApiResult2.getQueryRadius()) == null) ? false : queryRadius.booleanValue());
    }
}
