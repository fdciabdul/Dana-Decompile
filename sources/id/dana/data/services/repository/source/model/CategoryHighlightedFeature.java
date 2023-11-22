package id.dana.data.services.repository.source.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b \u0010!J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ>\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0016\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001a\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\bR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0005R\u001a\u0010\u0010\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001f\u0010\b"}, d2 = {"Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;", "", "", "", "component1", "()Ljava/util/List;", "", "component2", "()I", "", "component3", "()Z", "component4", "featureHighlight", "expired", "enable", "resetCounter", "copy", "(Ljava/util/List;IZI)Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "()Ljava/lang/String;", "Z", "getEnable", "I", "getExpired", "Ljava/util/List;", "getFeatureHighlight", "getResetCounter", "<init>", "(Ljava/util/List;IZI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CategoryHighlightedFeature {
    public boolean enable;
    public int expired;
    public List<String> featureHighlight;
    public int resetCounter;

    public CategoryHighlightedFeature() {
        this(null, 0, false, 0, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CategoryHighlightedFeature copy$default(CategoryHighlightedFeature categoryHighlightedFeature, List list, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = categoryHighlightedFeature.featureHighlight;
        }
        if ((i3 & 2) != 0) {
            i = categoryHighlightedFeature.expired;
        }
        if ((i3 & 4) != 0) {
            z = categoryHighlightedFeature.enable;
        }
        if ((i3 & 8) != 0) {
            i2 = categoryHighlightedFeature.resetCounter;
        }
        return categoryHighlightedFeature.copy(list, i, z, i2);
    }

    public final List<String> component1() {
        return this.featureHighlight;
    }

    /* renamed from: component2  reason: from getter */
    public final int getExpired() {
        return this.expired;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component4  reason: from getter */
    public final int getResetCounter() {
        return this.resetCounter;
    }

    public final CategoryHighlightedFeature copy(List<String> featureHighlight, int expired, boolean enable, int resetCounter) {
        Intrinsics.checkNotNullParameter(featureHighlight, "");
        return new CategoryHighlightedFeature(featureHighlight, expired, enable, resetCounter);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CategoryHighlightedFeature) {
            CategoryHighlightedFeature categoryHighlightedFeature = (CategoryHighlightedFeature) other;
            return Intrinsics.areEqual(this.featureHighlight, categoryHighlightedFeature.featureHighlight) && this.expired == categoryHighlightedFeature.expired && this.enable == categoryHighlightedFeature.enable && this.resetCounter == categoryHighlightedFeature.resetCounter;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.featureHighlight.hashCode();
        int i = this.expired;
        boolean z = this.enable;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return (((((hashCode * 31) + i) * 31) + i2) * 31) + this.resetCounter;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CategoryHighlightedFeature(featureHighlight=");
        sb.append(this.featureHighlight);
        sb.append(", expired=");
        sb.append(this.expired);
        sb.append(", enable=");
        sb.append(this.enable);
        sb.append(", resetCounter=");
        sb.append(this.resetCounter);
        sb.append(')');
        return sb.toString();
    }

    public CategoryHighlightedFeature(List<String> list, int i, boolean z, int i2) {
        Intrinsics.checkNotNullParameter(list, "");
        this.featureHighlight = list;
        this.expired = i;
        this.enable = z;
        this.resetCounter = i2;
    }

    public /* synthetic */ CategoryHighlightedFeature(List list, int i, boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? 24 : i, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? 0 : i2);
    }

    @JvmName(name = "getFeatureHighlight")
    public final List<String> getFeatureHighlight() {
        return this.featureHighlight;
    }

    @JvmName(name = "getExpired")
    public final int getExpired() {
        return this.expired;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getResetCounter")
    public final int getResetCounter() {
        return this.resetCounter;
    }
}
