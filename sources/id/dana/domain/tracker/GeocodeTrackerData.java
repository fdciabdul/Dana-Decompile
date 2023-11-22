package id.dana.domain.tracker;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B-\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ:\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R$\u0010\r\u001a\u0004\u0018\u00010\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u001eR\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001f\u0010\u0004\"\u0004\b \u0010!"}, d2 = {"Lid/dana/domain/tracker/GeocodeTrackerData;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lid/dana/domain/tracker/GeocodeTrackerSource;", "component4", "()Lid/dana/domain/tracker/GeocodeTrackerSource;", "appLayerCaller", "UUID", "domainLayerCaller", "dataSource", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/tracker/GeocodeTrackerSource;)Lid/dana/domain/tracker/GeocodeTrackerData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getUUID", "getAppLayerCaller", "Lid/dana/domain/tracker/GeocodeTrackerSource;", "getDataSource", "setDataSource", "(Lid/dana/domain/tracker/GeocodeTrackerSource;)V", "getDomainLayerCaller", "setDomainLayerCaller", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/tracker/GeocodeTrackerSource;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GeocodeTrackerData {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String UUID;
    private final String appLayerCaller;
    private GeocodeTrackerSource dataSource;
    private String domainLayerCaller;

    public static /* synthetic */ GeocodeTrackerData copy$default(GeocodeTrackerData geocodeTrackerData, String str, String str2, String str3, GeocodeTrackerSource geocodeTrackerSource, int i, Object obj) {
        if ((i & 1) != 0) {
            str = geocodeTrackerData.appLayerCaller;
        }
        if ((i & 2) != 0) {
            str2 = geocodeTrackerData.UUID;
        }
        if ((i & 4) != 0) {
            str3 = geocodeTrackerData.domainLayerCaller;
        }
        if ((i & 8) != 0) {
            geocodeTrackerSource = geocodeTrackerData.dataSource;
        }
        return geocodeTrackerData.copy(str, str2, str3, geocodeTrackerSource);
    }

    @JvmStatic
    public static final GeocodeTrackerData fromAppLayerCaller(String str) {
        return INSTANCE.fromAppLayerCaller(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAppLayerCaller() {
        return this.appLayerCaller;
    }

    /* renamed from: component2  reason: from getter */
    public final String getUUID() {
        return this.UUID;
    }

    /* renamed from: component3  reason: from getter */
    public final String getDomainLayerCaller() {
        return this.domainLayerCaller;
    }

    /* renamed from: component4  reason: from getter */
    public final GeocodeTrackerSource getDataSource() {
        return this.dataSource;
    }

    public final GeocodeTrackerData copy(String appLayerCaller, String UUID, String domainLayerCaller, GeocodeTrackerSource dataSource) {
        Intrinsics.checkNotNullParameter(appLayerCaller, "");
        Intrinsics.checkNotNullParameter(UUID, "");
        Intrinsics.checkNotNullParameter(domainLayerCaller, "");
        return new GeocodeTrackerData(appLayerCaller, UUID, domainLayerCaller, dataSource);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GeocodeTrackerData) {
            GeocodeTrackerData geocodeTrackerData = (GeocodeTrackerData) other;
            return Intrinsics.areEqual(this.appLayerCaller, geocodeTrackerData.appLayerCaller) && Intrinsics.areEqual(this.UUID, geocodeTrackerData.UUID) && Intrinsics.areEqual(this.domainLayerCaller, geocodeTrackerData.domainLayerCaller) && Intrinsics.areEqual(this.dataSource, geocodeTrackerData.dataSource);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.appLayerCaller.hashCode();
        int hashCode2 = this.UUID.hashCode();
        int hashCode3 = this.domainLayerCaller.hashCode();
        GeocodeTrackerSource geocodeTrackerSource = this.dataSource;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (geocodeTrackerSource == null ? 0 : geocodeTrackerSource.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GeocodeTrackerData(appLayerCaller=");
        sb.append(this.appLayerCaller);
        sb.append(", UUID=");
        sb.append(this.UUID);
        sb.append(", domainLayerCaller=");
        sb.append(this.domainLayerCaller);
        sb.append(", dataSource=");
        sb.append(this.dataSource);
        sb.append(')');
        return sb.toString();
    }

    public GeocodeTrackerData(String str, String str2, String str3, GeocodeTrackerSource geocodeTrackerSource) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.appLayerCaller = str;
        this.UUID = str2;
        this.domainLayerCaller = str3;
        this.dataSource = geocodeTrackerSource;
    }

    public /* synthetic */ GeocodeTrackerData(String str, String str2, String str3, GeocodeTrackerSource geocodeTrackerSource, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? null : geocodeTrackerSource);
    }

    @JvmName(name = "getAppLayerCaller")
    public final String getAppLayerCaller() {
        return this.appLayerCaller;
    }

    @JvmName(name = "getUUID")
    public final String getUUID() {
        return this.UUID;
    }

    @JvmName(name = "getDomainLayerCaller")
    public final String getDomainLayerCaller() {
        return this.domainLayerCaller;
    }

    @JvmName(name = "setDomainLayerCaller")
    public final void setDomainLayerCaller(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.domainLayerCaller = str;
    }

    @JvmName(name = "getDataSource")
    public final GeocodeTrackerSource getDataSource() {
        return this.dataSource;
    }

    @JvmName(name = "setDataSource")
    public final void setDataSource(GeocodeTrackerSource geocodeTrackerSource) {
        this.dataSource = geocodeTrackerSource;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/tracker/GeocodeTrackerData$Companion;", "", "", "appLayerCaller", "Lid/dana/domain/tracker/GeocodeTrackerData;", "fromAppLayerCaller", "(Ljava/lang/String;)Lid/dana/domain/tracker/GeocodeTrackerData;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GeocodeTrackerData fromAppLayerCaller(String appLayerCaller) {
            Intrinsics.checkNotNullParameter(appLayerCaller, "");
            String obj = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            return new GeocodeTrackerData(appLayerCaller, obj, null, null, 12, null);
        }
    }
}
