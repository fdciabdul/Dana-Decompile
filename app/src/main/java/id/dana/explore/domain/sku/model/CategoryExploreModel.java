package id.dana.explore.domain.sku.model;

import id.dana.danah5.DanaH5;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004"}, d2 = {"Lid/dana/explore/domain/sku/model/CategoryExploreModel;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", DanaH5.SERVICE_KEY, "highlight", "copy", "(Ljava/lang/String;Z)Lid/dana/explore/domain/sku/model/CategoryExploreModel;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getHighlight", "Ljava/lang/String;", "getServiceKey", "<init>", "(Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CategoryExploreModel {
    private final boolean highlight;
    private final String serviceKey;

    public static /* synthetic */ CategoryExploreModel copy$default(CategoryExploreModel categoryExploreModel, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = categoryExploreModel.serviceKey;
        }
        if ((i & 2) != 0) {
            z = categoryExploreModel.highlight;
        }
        return categoryExploreModel.copy(str, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getServiceKey() {
        return this.serviceKey;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getHighlight() {
        return this.highlight;
    }

    public final CategoryExploreModel copy(String serviceKey, boolean highlight) {
        Intrinsics.checkNotNullParameter(serviceKey, "");
        return new CategoryExploreModel(serviceKey, highlight);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CategoryExploreModel) {
            CategoryExploreModel categoryExploreModel = (CategoryExploreModel) other;
            return Intrinsics.areEqual(this.serviceKey, categoryExploreModel.serviceKey) && this.highlight == categoryExploreModel.highlight;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.serviceKey.hashCode();
        boolean z = this.highlight;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (hashCode * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CategoryExploreModel(serviceKey=");
        sb.append(this.serviceKey);
        sb.append(", highlight=");
        sb.append(this.highlight);
        sb.append(')');
        return sb.toString();
    }

    public CategoryExploreModel(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        this.serviceKey = str;
        this.highlight = z;
    }

    public /* synthetic */ CategoryExploreModel(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z);
    }

    @JvmName(name = "getServiceKey")
    public final String getServiceKey() {
        return this.serviceKey;
    }

    @JvmName(name = "getHighlight")
    public final boolean getHighlight() {
        return this.highlight;
    }
}
