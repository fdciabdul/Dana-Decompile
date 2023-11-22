package id.dana.domain.nearbyme.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J0\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0019\u0010\u0006"}, d2 = {"Lid/dana/domain/nearbyme/model/NearbyRankingConfig;", "", "", "component1", "()Ljava/lang/Integer;", "component2", "()I", "component3", "radius", "rating", "review", "copy", "(Ljava/lang/Integer;II)Lid/dana/domain/nearbyme/model/NearbyRankingConfig;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getRadius", "I", "getRating", "getReview", "<init>", "(Ljava/lang/Integer;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class NearbyRankingConfig {
    private final Integer radius;
    private final int rating;
    private final int review;

    public NearbyRankingConfig() {
        this(null, 0, 0, 7, null);
    }

    public static /* synthetic */ NearbyRankingConfig copy$default(NearbyRankingConfig nearbyRankingConfig, Integer num, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = nearbyRankingConfig.radius;
        }
        if ((i3 & 2) != 0) {
            i = nearbyRankingConfig.rating;
        }
        if ((i3 & 4) != 0) {
            i2 = nearbyRankingConfig.review;
        }
        return nearbyRankingConfig.copy(num, i, i2);
    }

    /* renamed from: component1  reason: from getter */
    public final Integer getRadius() {
        return this.radius;
    }

    /* renamed from: component2  reason: from getter */
    public final int getRating() {
        return this.rating;
    }

    /* renamed from: component3  reason: from getter */
    public final int getReview() {
        return this.review;
    }

    public final NearbyRankingConfig copy(Integer radius, int rating, int review) {
        return new NearbyRankingConfig(radius, rating, review);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof NearbyRankingConfig) {
            NearbyRankingConfig nearbyRankingConfig = (NearbyRankingConfig) other;
            return Intrinsics.areEqual(this.radius, nearbyRankingConfig.radius) && this.rating == nearbyRankingConfig.rating && this.review == nearbyRankingConfig.review;
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.radius;
        return ((((num == null ? 0 : num.hashCode()) * 31) + this.rating) * 31) + this.review;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NearbyRankingConfig(radius=");
        sb.append(this.radius);
        sb.append(", rating=");
        sb.append(this.rating);
        sb.append(", review=");
        sb.append(this.review);
        sb.append(')');
        return sb.toString();
    }

    public NearbyRankingConfig(Integer num, int i, int i2) {
        this.radius = num;
        this.rating = i;
        this.review = i2;
    }

    public /* synthetic */ NearbyRankingConfig(Integer num, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 10 : num, (i3 & 2) != 0 ? 60 : i, (i3 & 4) != 0 ? 30 : i2);
    }

    @JvmName(name = "getRadius")
    public final Integer getRadius() {
        return this.radius;
    }

    @JvmName(name = "getRating")
    public final int getRating() {
        return this.rating;
    }

    @JvmName(name = "getReview")
    public final int getReview() {
        return this.review;
    }
}
