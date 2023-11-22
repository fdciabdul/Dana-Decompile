package id.dana.mybills.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005"}, d2 = {"Lid/dana/mybills/domain/model/ConfigInfoRangeDate;", "", "", "Lid/dana/mybills/domain/model/RangeDateConfig;", "component1", "()Ljava/util/List;", "listRangeDateConfig", "copy", "(Ljava/util/List;)Lid/dana/mybills/domain/model/ConfigInfoRangeDate;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getListRangeDateConfig", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConfigInfoRangeDate {
    private final List<RangeDateConfig> listRangeDateConfig;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConfigInfoRangeDate copy$default(ConfigInfoRangeDate configInfoRangeDate, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = configInfoRangeDate.listRangeDateConfig;
        }
        return configInfoRangeDate.copy(list);
    }

    public final List<RangeDateConfig> component1() {
        return this.listRangeDateConfig;
    }

    public final ConfigInfoRangeDate copy(List<RangeDateConfig> listRangeDateConfig) {
        Intrinsics.checkNotNullParameter(listRangeDateConfig, "");
        return new ConfigInfoRangeDate(listRangeDateConfig);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ConfigInfoRangeDate) && Intrinsics.areEqual(this.listRangeDateConfig, ((ConfigInfoRangeDate) other).listRangeDateConfig);
    }

    public final int hashCode() {
        return this.listRangeDateConfig.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConfigInfoRangeDate(listRangeDateConfig=");
        sb.append(this.listRangeDateConfig);
        sb.append(')');
        return sb.toString();
    }

    public ConfigInfoRangeDate(List<RangeDateConfig> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.listRangeDateConfig = list;
    }

    @JvmName(name = "getListRangeDateConfig")
    public final List<RangeDateConfig> getListRangeDateConfig() {
        return this.listRangeDateConfig;
    }
}
