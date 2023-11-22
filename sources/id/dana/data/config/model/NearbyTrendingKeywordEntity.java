package id.dana.data.config.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004"}, d2 = {"Lid/dana/data/config/model/NearbyTrendingKeywordEntity;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component2", "name", "tag", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/config/model/NearbyTrendingKeywordEntity;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getName", "getTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class NearbyTrendingKeywordEntity implements Serializable {
    private static final String DEFAULT_TAG = "Merchant";
    public static final String LOCATION_TAG = "Location";
    public String name;
    public String tag;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NearbyTrendingKeywordEntity() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.config.model.NearbyTrendingKeywordEntity.<init>():void");
    }

    public static /* synthetic */ NearbyTrendingKeywordEntity copy$default(NearbyTrendingKeywordEntity nearbyTrendingKeywordEntity, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = nearbyTrendingKeywordEntity.name;
        }
        if ((i & 2) != 0) {
            str2 = nearbyTrendingKeywordEntity.tag;
        }
        return nearbyTrendingKeywordEntity.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2  reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    public final NearbyTrendingKeywordEntity copy(String name, String tag) {
        return new NearbyTrendingKeywordEntity(name, tag);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof NearbyTrendingKeywordEntity) {
            NearbyTrendingKeywordEntity nearbyTrendingKeywordEntity = (NearbyTrendingKeywordEntity) other;
            return Intrinsics.areEqual(this.name, nearbyTrendingKeywordEntity.name) && Intrinsics.areEqual(this.tag, nearbyTrendingKeywordEntity.tag);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.name;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.tag;
        return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NearbyTrendingKeywordEntity(name=");
        sb.append(this.name);
        sb.append(", tag=");
        sb.append(this.tag);
        sb.append(')');
        return sb.toString();
    }

    public NearbyTrendingKeywordEntity(String str, String str2) {
        this.name = str;
        this.tag = str2;
    }

    public /* synthetic */ NearbyTrendingKeywordEntity(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? DEFAULT_TAG : str2);
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "getTag")
    public final String getTag() {
        return this.tag;
    }
}
