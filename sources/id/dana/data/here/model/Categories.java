package id.dana.data.here.model;

import com.google.gson.annotations.SerializedName;
import id.dana.promocenter.model.PromoActionType;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ4\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\b"}, d2 = {"Lid/dana/data/here/model/Categories;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Boolean;", "id", "name", PromoActionType.PRIMARY, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lid/dana/data/here/model/Categories;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getId", "getName", "Ljava/lang/Boolean;", "getPrimary", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Categories {
    @SerializedName("id")
    private final String id;
    @SerializedName("name")
    private final String name;
    @SerializedName(PromoActionType.PRIMARY)
    private final Boolean primary;

    public Categories() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ Categories copy$default(Categories categories, String str, String str2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = categories.id;
        }
        if ((i & 2) != 0) {
            str2 = categories.name;
        }
        if ((i & 4) != 0) {
            bool = categories.primary;
        }
        return categories.copy(str, str2, bool);
    }

    /* renamed from: component1  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2  reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3  reason: from getter */
    public final Boolean getPrimary() {
        return this.primary;
    }

    public final Categories copy(String id2, String name, Boolean primary) {
        return new Categories(id2, name, primary);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Categories) {
            Categories categories = (Categories) other;
            return Intrinsics.areEqual(this.id, categories.id) && Intrinsics.areEqual(this.name, categories.name) && Intrinsics.areEqual(this.primary, categories.primary);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.id;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.name;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        Boolean bool = this.primary;
        return (((hashCode * 31) + hashCode2) * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Categories(id=");
        sb.append(this.id);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", primary=");
        sb.append(this.primary);
        sb.append(')');
        return sb.toString();
    }

    public Categories(String str, String str2, Boolean bool) {
        this.id = str;
        this.name = str2;
        this.primary = bool;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    public /* synthetic */ Categories(String str, String str2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? Boolean.TRUE : bool);
    }

    @JvmName(name = "getPrimary")
    public final Boolean getPrimary() {
        return this.primary;
    }
}
