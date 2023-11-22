package id.dana.nearbyme.model;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import id.dana.domain.nearbyme.model.NearbyAutoSearchConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0007"}, d2 = {"Lid/dana/nearbyme/model/SearchConfigModel;", "", "", "component1", "()Z", "", "component2", "()I", "component3", "enabled", "interval", GriverMonitorConstants.KEY_THRESHOLD, "copy", "(ZII)Lid/dana/nearbyme/model/SearchConfigModel;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Z", "getEnabled", "I", "getInterval", "getThreshold", "<init>", "(ZII)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SearchConfigModel {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEFAULT_INTERVAL = 500;
    public static final int DEFAULT_THRESHOLD = 500;
    private final boolean enabled;
    private final int interval;
    private final int threshold;

    public SearchConfigModel() {
        this(false, 0, 0, 7, null);
    }

    public static /* synthetic */ SearchConfigModel copy$default(SearchConfigModel searchConfigModel, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = searchConfigModel.enabled;
        }
        if ((i3 & 2) != 0) {
            i = searchConfigModel.interval;
        }
        if ((i3 & 4) != 0) {
            i2 = searchConfigModel.threshold;
        }
        return searchConfigModel.copy(z, i, i2);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component2  reason: from getter */
    public final int getInterval() {
        return this.interval;
    }

    /* renamed from: component3  reason: from getter */
    public final int getThreshold() {
        return this.threshold;
    }

    public final SearchConfigModel copy(boolean enabled, int interval, int threshold) {
        return new SearchConfigModel(enabled, interval, threshold);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SearchConfigModel) {
            SearchConfigModel searchConfigModel = (SearchConfigModel) other;
            return this.enabled == searchConfigModel.enabled && this.interval == searchConfigModel.interval && this.threshold == searchConfigModel.threshold;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.enabled;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.interval) * 31) + this.threshold;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SearchConfigModel(enabled=");
        sb.append(this.enabled);
        sb.append(", interval=");
        sb.append(this.interval);
        sb.append(", threshold=");
        sb.append(this.threshold);
        sb.append(')');
        return sb.toString();
    }

    public SearchConfigModel(boolean z, int i, int i2) {
        this.enabled = z;
        this.interval = i;
        this.threshold = i2;
    }

    public /* synthetic */ SearchConfigModel(boolean z, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z, (i3 & 2) != 0 ? 500 : i, (i3 & 4) != 0 ? 500 : i2);
    }

    @JvmName(name = "getEnabled")
    public final boolean getEnabled() {
        return this.enabled;
    }

    @JvmName(name = "getInterval")
    public final int getInterval() {
        return this.interval;
    }

    @JvmName(name = "getThreshold")
    public final int getThreshold() {
        return this.threshold;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\t"}, d2 = {"Lid/dana/nearbyme/model/SearchConfigModel$Companion;", "", "Lid/dana/domain/nearbyme/model/NearbyAutoSearchConfig;", "p0", "Lid/dana/nearbyme/model/SearchConfigModel;", "PlaceComponentResult", "(Lid/dana/domain/nearbyme/model/NearbyAutoSearchConfig;)Lid/dana/nearbyme/model/SearchConfigModel;", "", "DEFAULT_INTERVAL", "I", "DEFAULT_THRESHOLD", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static SearchConfigModel PlaceComponentResult(NearbyAutoSearchConfig p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new SearchConfigModel(p0.getEnabled(), p0.getInterval(), p0.getThreshold());
        }
    }
}
