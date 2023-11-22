package id.dana.domain.nearbyme.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0003\u0010\f\u001a\u00020\u000b\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0003\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/domain/nearbyme/model/NearbyWidgetConfig;", "", "", "enable", "Z", "getEnable", "()Z", "kybKaFilter", "getKybKaFilter", "migrateApiHome", "getMigrateApiHome", "", "radius", "J", "getRadius", "()J", "<init>", "(ZJZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NearbyWidgetConfig {
    private final boolean enable;
    @SerializedName("kyb_ka_filter")
    private final boolean kybKaFilter;
    @SerializedName("migrate_api_home")
    private final boolean migrateApiHome;
    @SerializedName("radius_threshold")
    private final long radius;

    public NearbyWidgetConfig() {
        this(false, 0L, false, false, 15, null);
    }

    public NearbyWidgetConfig(boolean z, @JSONField(name = "radius_threshold") long j, @JSONField(name = "kyb_ka_filter") boolean z2, @JSONField(name = "migrate_api_home") boolean z3) {
        this.enable = z;
        this.radius = j;
        this.kybKaFilter = z2;
        this.migrateApiHome = z3;
    }

    public /* synthetic */ NearbyWidgetConfig(boolean z, long j, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3);
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getRadius")
    public final long getRadius() {
        return this.radius;
    }

    @JvmName(name = "getKybKaFilter")
    public final boolean getKybKaFilter() {
        return this.kybKaFilter;
    }

    @JvmName(name = "getMigrateApiHome")
    public final boolean getMigrateApiHome() {
        return this.migrateApiHome;
    }
}
