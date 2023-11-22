package id.dana.domain.danaprotection.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/domain/danaprotection/model/DanaProtectionRecommendationModel;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "name", "enable", "value", "copy", "(Ljava/lang/String;ZLjava/lang/String;)Lid/dana/domain/danaprotection/model/DanaProtectionRecommendationModel;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getEnable", "Ljava/lang/String;", "getName", "getValue", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DanaProtectionRecommendationModel {
    private final boolean enable;
    private final String name;
    private final String value;

    public static /* synthetic */ DanaProtectionRecommendationModel copy$default(DanaProtectionRecommendationModel danaProtectionRecommendationModel, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = danaProtectionRecommendationModel.name;
        }
        if ((i & 2) != 0) {
            z = danaProtectionRecommendationModel.enable;
        }
        if ((i & 4) != 0) {
            str2 = danaProtectionRecommendationModel.value;
        }
        return danaProtectionRecommendationModel.copy(str, z, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component3  reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final DanaProtectionRecommendationModel copy(String name, boolean enable, String value) {
        Intrinsics.checkNotNullParameter(name, "");
        return new DanaProtectionRecommendationModel(name, enable, value);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DanaProtectionRecommendationModel) {
            DanaProtectionRecommendationModel danaProtectionRecommendationModel = (DanaProtectionRecommendationModel) other;
            return Intrinsics.areEqual(this.name, danaProtectionRecommendationModel.name) && this.enable == danaProtectionRecommendationModel.enable && Intrinsics.areEqual(this.value, danaProtectionRecommendationModel.value);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.name.hashCode();
        boolean z = this.enable;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str = this.value;
        return (((hashCode * 31) + i) * 31) + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DanaProtectionRecommendationModel(name=");
        sb.append(this.name);
        sb.append(", enable=");
        sb.append(this.enable);
        sb.append(", value=");
        sb.append(this.value);
        sb.append(')');
        return sb.toString();
    }

    public DanaProtectionRecommendationModel(String str, boolean z, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        this.name = str;
        this.enable = z;
        this.value = str2;
    }

    public /* synthetic */ DanaProtectionRecommendationModel(String str, boolean z, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i & 4) != 0 ? null : str2);
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getValue")
    public final String getValue() {
        return this.value;
    }
}
