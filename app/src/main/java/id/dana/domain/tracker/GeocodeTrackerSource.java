package id.dana.domain.tracker;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u000b\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/domain/tracker/GeocodeTrackerSource;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "source", "error", "isThereAnyDataEmpty", "copy", "(Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/domain/tracker/GeocodeTrackerSource;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getError", "Z", "getSource", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GeocodeTrackerSource {
    private final String error;
    private final boolean isThereAnyDataEmpty;
    private final String source;

    public static /* synthetic */ GeocodeTrackerSource copy$default(GeocodeTrackerSource geocodeTrackerSource, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = geocodeTrackerSource.source;
        }
        if ((i & 2) != 0) {
            str2 = geocodeTrackerSource.error;
        }
        if ((i & 4) != 0) {
            z = geocodeTrackerSource.isThereAnyDataEmpty;
        }
        return geocodeTrackerSource.copy(str, str2, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getSource() {
        return this.source;
    }

    /* renamed from: component2  reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getIsThereAnyDataEmpty() {
        return this.isThereAnyDataEmpty;
    }

    public final GeocodeTrackerSource copy(String source, String error, boolean isThereAnyDataEmpty) {
        Intrinsics.checkNotNullParameter(source, "");
        Intrinsics.checkNotNullParameter(error, "");
        return new GeocodeTrackerSource(source, error, isThereAnyDataEmpty);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GeocodeTrackerSource) {
            GeocodeTrackerSource geocodeTrackerSource = (GeocodeTrackerSource) other;
            return Intrinsics.areEqual(this.source, geocodeTrackerSource.source) && Intrinsics.areEqual(this.error, geocodeTrackerSource.error) && this.isThereAnyDataEmpty == geocodeTrackerSource.isThereAnyDataEmpty;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.source.hashCode();
        int hashCode2 = this.error.hashCode();
        boolean z = this.isThereAnyDataEmpty;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((hashCode * 31) + hashCode2) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GeocodeTrackerSource(source=");
        sb.append(this.source);
        sb.append(", error=");
        sb.append(this.error);
        sb.append(", isThereAnyDataEmpty=");
        sb.append(this.isThereAnyDataEmpty);
        sb.append(')');
        return sb.toString();
    }

    public GeocodeTrackerSource(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.source = str;
        this.error = str2;
        this.isThereAnyDataEmpty = z;
    }

    public /* synthetic */ GeocodeTrackerSource(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z);
    }

    @JvmName(name = "getSource")
    public final String getSource() {
        return this.source;
    }

    @JvmName(name = "getError")
    public final String getError() {
        return this.error;
    }

    @JvmName(name = "isThereAnyDataEmpty")
    public final boolean isThereAnyDataEmpty() {
        return this.isThereAnyDataEmpty;
    }
}
