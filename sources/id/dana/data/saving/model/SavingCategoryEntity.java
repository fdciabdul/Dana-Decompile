package id.dana.data.saving.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b,\u0010-J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004Jl\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u0004\"\u0004\b\"\u0010#R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b$\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b%\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b&\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b(\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b)\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b*\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b+\u0010\u0004"}, d2 = {"Lid/dana/data/saving/model/SavingCategoryEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "categoryCode", "name", "iconUrlDefault", "iconUrlSelected", "iconUrlLevel1", "iconUrlLevel2", "iconUrlLevel3", "iconUrlLevel4", "iconUrlLevel5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/saving/model/SavingCategoryEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCategoryCode", "setCategoryCode", "(Ljava/lang/String;)V", "getIconUrlDefault", "getIconUrlLevel1", "getIconUrlLevel2", "getIconUrlLevel3", "getIconUrlLevel4", "getIconUrlLevel5", "getIconUrlSelected", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SavingCategoryEntity {
    private String categoryCode;
    @SerializedName("icon_url_default")
    private final String iconUrlDefault;
    @SerializedName("icon_url_level1")
    private final String iconUrlLevel1;
    @SerializedName("icon_url_level2")
    private final String iconUrlLevel2;
    @SerializedName("icon_url_level3")
    private final String iconUrlLevel3;
    @SerializedName("icon_url_level4")
    private final String iconUrlLevel4;
    @SerializedName("icon_url_level5")
    private final String iconUrlLevel5;
    @SerializedName("icon_url_selected")
    private final String iconUrlSelected;
    @SerializedName("name")
    private final String name;

    /* renamed from: component1  reason: from getter */
    public final String getCategoryCode() {
        return this.categoryCode;
    }

    /* renamed from: component2  reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3  reason: from getter */
    public final String getIconUrlDefault() {
        return this.iconUrlDefault;
    }

    /* renamed from: component4  reason: from getter */
    public final String getIconUrlSelected() {
        return this.iconUrlSelected;
    }

    /* renamed from: component5  reason: from getter */
    public final String getIconUrlLevel1() {
        return this.iconUrlLevel1;
    }

    /* renamed from: component6  reason: from getter */
    public final String getIconUrlLevel2() {
        return this.iconUrlLevel2;
    }

    /* renamed from: component7  reason: from getter */
    public final String getIconUrlLevel3() {
        return this.iconUrlLevel3;
    }

    /* renamed from: component8  reason: from getter */
    public final String getIconUrlLevel4() {
        return this.iconUrlLevel4;
    }

    /* renamed from: component9  reason: from getter */
    public final String getIconUrlLevel5() {
        return this.iconUrlLevel5;
    }

    public final SavingCategoryEntity copy(String categoryCode, String name, String iconUrlDefault, String iconUrlSelected, String iconUrlLevel1, String iconUrlLevel2, String iconUrlLevel3, String iconUrlLevel4, String iconUrlLevel5) {
        Intrinsics.checkNotNullParameter(name, "");
        Intrinsics.checkNotNullParameter(iconUrlDefault, "");
        Intrinsics.checkNotNullParameter(iconUrlSelected, "");
        Intrinsics.checkNotNullParameter(iconUrlLevel1, "");
        Intrinsics.checkNotNullParameter(iconUrlLevel2, "");
        Intrinsics.checkNotNullParameter(iconUrlLevel3, "");
        Intrinsics.checkNotNullParameter(iconUrlLevel4, "");
        Intrinsics.checkNotNullParameter(iconUrlLevel5, "");
        return new SavingCategoryEntity(categoryCode, name, iconUrlDefault, iconUrlSelected, iconUrlLevel1, iconUrlLevel2, iconUrlLevel3, iconUrlLevel4, iconUrlLevel5);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SavingCategoryEntity) {
            SavingCategoryEntity savingCategoryEntity = (SavingCategoryEntity) other;
            return Intrinsics.areEqual(this.categoryCode, savingCategoryEntity.categoryCode) && Intrinsics.areEqual(this.name, savingCategoryEntity.name) && Intrinsics.areEqual(this.iconUrlDefault, savingCategoryEntity.iconUrlDefault) && Intrinsics.areEqual(this.iconUrlSelected, savingCategoryEntity.iconUrlSelected) && Intrinsics.areEqual(this.iconUrlLevel1, savingCategoryEntity.iconUrlLevel1) && Intrinsics.areEqual(this.iconUrlLevel2, savingCategoryEntity.iconUrlLevel2) && Intrinsics.areEqual(this.iconUrlLevel3, savingCategoryEntity.iconUrlLevel3) && Intrinsics.areEqual(this.iconUrlLevel4, savingCategoryEntity.iconUrlLevel4) && Intrinsics.areEqual(this.iconUrlLevel5, savingCategoryEntity.iconUrlLevel5);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.categoryCode;
        return ((((((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.name.hashCode()) * 31) + this.iconUrlDefault.hashCode()) * 31) + this.iconUrlSelected.hashCode()) * 31) + this.iconUrlLevel1.hashCode()) * 31) + this.iconUrlLevel2.hashCode()) * 31) + this.iconUrlLevel3.hashCode()) * 31) + this.iconUrlLevel4.hashCode()) * 31) + this.iconUrlLevel5.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingCategoryEntity(categoryCode=");
        sb.append(this.categoryCode);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", iconUrlDefault=");
        sb.append(this.iconUrlDefault);
        sb.append(", iconUrlSelected=");
        sb.append(this.iconUrlSelected);
        sb.append(", iconUrlLevel1=");
        sb.append(this.iconUrlLevel1);
        sb.append(", iconUrlLevel2=");
        sb.append(this.iconUrlLevel2);
        sb.append(", iconUrlLevel3=");
        sb.append(this.iconUrlLevel3);
        sb.append(", iconUrlLevel4=");
        sb.append(this.iconUrlLevel4);
        sb.append(", iconUrlLevel5=");
        sb.append(this.iconUrlLevel5);
        sb.append(')');
        return sb.toString();
    }

    public SavingCategoryEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        this.categoryCode = str;
        this.name = str2;
        this.iconUrlDefault = str3;
        this.iconUrlSelected = str4;
        this.iconUrlLevel1 = str5;
        this.iconUrlLevel2 = str6;
        this.iconUrlLevel3 = str7;
        this.iconUrlLevel4 = str8;
        this.iconUrlLevel5 = str9;
    }

    @JvmName(name = "getCategoryCode")
    public final String getCategoryCode() {
        return this.categoryCode;
    }

    @JvmName(name = "setCategoryCode")
    public final void setCategoryCode(String str) {
        this.categoryCode = str;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "getIconUrlDefault")
    public final String getIconUrlDefault() {
        return this.iconUrlDefault;
    }

    @JvmName(name = "getIconUrlSelected")
    public final String getIconUrlSelected() {
        return this.iconUrlSelected;
    }

    @JvmName(name = "getIconUrlLevel1")
    public final String getIconUrlLevel1() {
        return this.iconUrlLevel1;
    }

    @JvmName(name = "getIconUrlLevel2")
    public final String getIconUrlLevel2() {
        return this.iconUrlLevel2;
    }

    @JvmName(name = "getIconUrlLevel3")
    public final String getIconUrlLevel3() {
        return this.iconUrlLevel3;
    }

    @JvmName(name = "getIconUrlLevel4")
    public final String getIconUrlLevel4() {
        return this.iconUrlLevel4;
    }

    @JvmName(name = "getIconUrlLevel5")
    public final String getIconUrlLevel5() {
        return this.iconUrlLevel5;
    }
}
