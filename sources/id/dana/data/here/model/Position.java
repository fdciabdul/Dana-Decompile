package id.dana.data.here.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004"}, d2 = {"Lid/dana/data/here/model/Position;", "", "", "component1", "()Ljava/lang/Double;", "component2", "lat", "lng", "copy", "(Ljava/lang/Double;Ljava/lang/Double;)Lid/dana/data/here/model/Position;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Double;", "getLat", "getLng", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Position {
    @SerializedName("lat")
    private final Double lat;
    @SerializedName("lng")
    private final Double lng;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Double, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Position() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.here.model.Position.<init>():void");
    }

    public static /* synthetic */ Position copy$default(Position position, Double d, Double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = position.lat;
        }
        if ((i & 2) != 0) {
            d2 = position.lng;
        }
        return position.copy(d, d2);
    }

    /* renamed from: component1  reason: from getter */
    public final Double getLat() {
        return this.lat;
    }

    /* renamed from: component2  reason: from getter */
    public final Double getLng() {
        return this.lng;
    }

    public final Position copy(Double lat, Double lng) {
        return new Position(lat, lng);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Position) {
            Position position = (Position) other;
            return Intrinsics.areEqual((Object) this.lat, (Object) position.lat) && Intrinsics.areEqual((Object) this.lng, (Object) position.lng);
        }
        return false;
    }

    public final int hashCode() {
        Double d = this.lat;
        int hashCode = d == null ? 0 : d.hashCode();
        Double d2 = this.lng;
        return (hashCode * 31) + (d2 != null ? d2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Position(lat=");
        sb.append(this.lat);
        sb.append(", lng=");
        sb.append(this.lng);
        sb.append(')');
        return sb.toString();
    }

    public Position(Double d, Double d2) {
        this.lat = d;
        this.lng = d2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ Position(java.lang.Double r3, java.lang.Double r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r2 = this;
            r0 = 0
            java.lang.Double r6 = java.lang.Double.valueOf(r0)
            r0 = r5 & 1
            if (r0 == 0) goto Lb
            r3 = r6
        Lb:
            r5 = r5 & 2
            if (r5 == 0) goto L10
            r4 = r6
        L10:
            r2.<init>(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.here.model.Position.<init>(java.lang.Double, java.lang.Double, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getLat")
    public final Double getLat() {
        return this.lat;
    }

    @JvmName(name = "getLng")
    public final Double getLng() {
        return this.lng;
    }
}
