package id.dana.domain.nearbyme.model;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.domain.nearbysearch.model.NearbyTrendingKeyword;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b&\u0010'J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\r\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\r\u0010\bJH\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000f\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\bR\u001a\u0010\u0010\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\u000bR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010\u0005R\u001a\u0010\u0011\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b$\u0010\bR\u001a\u0010\u0012\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b%\u0010\b"}, d2 = {"Lid/dana/domain/nearbyme/model/NearbyConfig;", "", "", "Lid/dana/domain/nearbysearch/model/NearbyTrendingKeyword;", "component1", "()Ljava/util/List;", "", "component2", "()Z", "", "component3", "()D", "component4", "component5", "trendingKeyword", "nearbyRevamp", "reviewCount", "useQueryListDiscoveryApi", "useQueryRadiusDiscoveryApi", "copy", "(Ljava/util/List;ZDZZ)Lid/dana/domain/nearbyme/model/NearbyConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getNearbyRevamp", SummaryActivity.DAYS, "getReviewCount", "Ljava/util/List;", "getTrendingKeyword", "getUseQueryListDiscoveryApi", "getUseQueryRadiusDiscoveryApi", "<init>", "(Ljava/util/List;ZDZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class NearbyConfig {
    private final boolean nearbyRevamp;
    private final double reviewCount;
    private final List<NearbyTrendingKeyword> trendingKeyword;
    private final boolean useQueryListDiscoveryApi;
    private final boolean useQueryRadiusDiscoveryApi;

    public NearbyConfig() {
        this(null, false, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, false, 31, null);
    }

    public static /* synthetic */ NearbyConfig copy$default(NearbyConfig nearbyConfig, List list, boolean z, double d, boolean z2, boolean z3, int i, Object obj) {
        List<NearbyTrendingKeyword> list2 = list;
        if ((i & 1) != 0) {
            list2 = nearbyConfig.trendingKeyword;
        }
        if ((i & 2) != 0) {
            z = nearbyConfig.nearbyRevamp;
        }
        boolean z4 = z;
        if ((i & 4) != 0) {
            d = nearbyConfig.reviewCount;
        }
        double d2 = d;
        if ((i & 8) != 0) {
            z2 = nearbyConfig.useQueryListDiscoveryApi;
        }
        boolean z5 = z2;
        if ((i & 16) != 0) {
            z3 = nearbyConfig.useQueryRadiusDiscoveryApi;
        }
        return nearbyConfig.copy(list2, z4, d2, z5, z3);
    }

    public final List<NearbyTrendingKeyword> component1() {
        return this.trendingKeyword;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getNearbyRevamp() {
        return this.nearbyRevamp;
    }

    /* renamed from: component3  reason: from getter */
    public final double getReviewCount() {
        return this.reviewCount;
    }

    /* renamed from: component4  reason: from getter */
    public final boolean getUseQueryListDiscoveryApi() {
        return this.useQueryListDiscoveryApi;
    }

    /* renamed from: component5  reason: from getter */
    public final boolean getUseQueryRadiusDiscoveryApi() {
        return this.useQueryRadiusDiscoveryApi;
    }

    public final NearbyConfig copy(List<NearbyTrendingKeyword> trendingKeyword, boolean nearbyRevamp, double reviewCount, boolean useQueryListDiscoveryApi, boolean useQueryRadiusDiscoveryApi) {
        Intrinsics.checkNotNullParameter(trendingKeyword, "");
        return new NearbyConfig(trendingKeyword, nearbyRevamp, reviewCount, useQueryListDiscoveryApi, useQueryRadiusDiscoveryApi);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof NearbyConfig) {
            NearbyConfig nearbyConfig = (NearbyConfig) other;
            return Intrinsics.areEqual(this.trendingKeyword, nearbyConfig.trendingKeyword) && this.nearbyRevamp == nearbyConfig.nearbyRevamp && Intrinsics.areEqual((Object) Double.valueOf(this.reviewCount), (Object) Double.valueOf(nearbyConfig.reviewCount)) && this.useQueryListDiscoveryApi == nearbyConfig.useQueryListDiscoveryApi && this.useQueryRadiusDiscoveryApi == nearbyConfig.useQueryRadiusDiscoveryApi;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.trendingKeyword.hashCode();
        boolean z = this.nearbyRevamp;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int KClassImpl$Data$declaredNonStaticMembers$2 = BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.reviewCount);
        boolean z2 = this.useQueryListDiscoveryApi;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        boolean z3 = this.useQueryRadiusDiscoveryApi;
        return (((((((hashCode * 31) + i) * 31) + KClassImpl$Data$declaredNonStaticMembers$2) * 31) + i2) * 31) + (z3 ? 1 : z3 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NearbyConfig(trendingKeyword=");
        sb.append(this.trendingKeyword);
        sb.append(", nearbyRevamp=");
        sb.append(this.nearbyRevamp);
        sb.append(", reviewCount=");
        sb.append(this.reviewCount);
        sb.append(", useQueryListDiscoveryApi=");
        sb.append(this.useQueryListDiscoveryApi);
        sb.append(", useQueryRadiusDiscoveryApi=");
        sb.append(this.useQueryRadiusDiscoveryApi);
        sb.append(')');
        return sb.toString();
    }

    public NearbyConfig(List<NearbyTrendingKeyword> list, boolean z, double d, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(list, "");
        this.trendingKeyword = list;
        this.nearbyRevamp = z;
        this.reviewCount = d;
        this.useQueryListDiscoveryApi = z2;
        this.useQueryRadiusDiscoveryApi = z3;
    }

    public /* synthetic */ NearbyConfig(List list, boolean z, double d, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? false : z, (i & 4) != 0 ? 1.0d : d, (i & 8) != 0 ? false : z2, (i & 16) == 0 ? z3 : false);
    }

    @JvmName(name = "getTrendingKeyword")
    public final List<NearbyTrendingKeyword> getTrendingKeyword() {
        return this.trendingKeyword;
    }

    @JvmName(name = "getNearbyRevamp")
    public final boolean getNearbyRevamp() {
        return this.nearbyRevamp;
    }

    @JvmName(name = "getReviewCount")
    public final double getReviewCount() {
        return this.reviewCount;
    }

    @JvmName(name = "getUseQueryListDiscoveryApi")
    public final boolean getUseQueryListDiscoveryApi() {
        return this.useQueryListDiscoveryApi;
    }

    @JvmName(name = "getUseQueryRadiusDiscoveryApi")
    public final boolean getUseQueryRadiusDiscoveryApi() {
        return this.useQueryRadiusDiscoveryApi;
    }
}
