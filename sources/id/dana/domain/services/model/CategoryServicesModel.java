package id.dana.domain.services.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/domain/services/model/CategoryServicesModel;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "category", "en", "id", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/services/model/CategoryServicesModel;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCategory", "getEn", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CategoryServicesModel {
    private final String category;
    private final String en;
    private final String id;

    public static /* synthetic */ CategoryServicesModel copy$default(CategoryServicesModel categoryServicesModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = categoryServicesModel.category;
        }
        if ((i & 2) != 0) {
            str2 = categoryServicesModel.en;
        }
        if ((i & 4) != 0) {
            str3 = categoryServicesModel.id;
        }
        return categoryServicesModel.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component2  reason: from getter */
    public final String getEn() {
        return this.en;
    }

    /* renamed from: component3  reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final CategoryServicesModel copy(String category, String en, String id2) {
        Intrinsics.checkNotNullParameter(category, "");
        Intrinsics.checkNotNullParameter(en, "");
        Intrinsics.checkNotNullParameter(id2, "");
        return new CategoryServicesModel(category, en, id2);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CategoryServicesModel) {
            CategoryServicesModel categoryServicesModel = (CategoryServicesModel) other;
            return Intrinsics.areEqual(this.category, categoryServicesModel.category) && Intrinsics.areEqual(this.en, categoryServicesModel.en) && Intrinsics.areEqual(this.id, categoryServicesModel.id);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.category.hashCode() * 31) + this.en.hashCode()) * 31) + this.id.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CategoryServicesModel(category=");
        sb.append(this.category);
        sb.append(", en=");
        sb.append(this.en);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(')');
        return sb.toString();
    }

    public CategoryServicesModel(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.category = str;
        this.en = str2;
        this.id = str3;
    }

    @JvmName(name = "getCategory")
    public final String getCategory() {
        return this.category;
    }

    @JvmName(name = "getEn")
    public final String getEn() {
        return this.en;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }
}
