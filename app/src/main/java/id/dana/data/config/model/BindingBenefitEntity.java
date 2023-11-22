package id.dana.data.config.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/data/config/model/BindingBenefitEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "icon", "name", "name_id", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/config/model/BindingBenefitEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getIcon", "getName", "getName_id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BindingBenefitEntity {
    private final String icon;
    private final String name;
    private final String name_id;

    public static /* synthetic */ BindingBenefitEntity copy$default(BindingBenefitEntity bindingBenefitEntity, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bindingBenefitEntity.icon;
        }
        if ((i & 2) != 0) {
            str2 = bindingBenefitEntity.name;
        }
        if ((i & 4) != 0) {
            str3 = bindingBenefitEntity.name_id;
        }
        return bindingBenefitEntity.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component2  reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3  reason: from getter */
    public final String getName_id() {
        return this.name_id;
    }

    public final BindingBenefitEntity copy(String icon, String name, String name_id) {
        Intrinsics.checkNotNullParameter(icon, "");
        Intrinsics.checkNotNullParameter(name, "");
        Intrinsics.checkNotNullParameter(name_id, "");
        return new BindingBenefitEntity(icon, name, name_id);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BindingBenefitEntity) {
            BindingBenefitEntity bindingBenefitEntity = (BindingBenefitEntity) other;
            return Intrinsics.areEqual(this.icon, bindingBenefitEntity.icon) && Intrinsics.areEqual(this.name, bindingBenefitEntity.name) && Intrinsics.areEqual(this.name_id, bindingBenefitEntity.name_id);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.icon.hashCode() * 31) + this.name.hashCode()) * 31) + this.name_id.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BindingBenefitEntity(icon=");
        sb.append(this.icon);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", name_id=");
        sb.append(this.name_id);
        sb.append(')');
        return sb.toString();
    }

    public BindingBenefitEntity(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.icon = str;
        this.name = str2;
        this.name_id = str3;
    }

    @JvmName(name = "getIcon")
    public final String getIcon() {
        return this.icon;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "getName_id")
    public final String getName_id() {
        return this.name_id;
    }
}
