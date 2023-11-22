package id.dana.explore.domain.sku.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJH\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u001cR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001d\u0010\u0004\"\u0004\b\u001e\u0010\u001cR\"\u0010\u000f\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b\u000f\u0010\n\"\u0004\b \u0010!R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\"\u0010\u0004R$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0019\u001a\u0004\b#\u0010\u0004\"\u0004\b$\u0010\u001c"}, d2 = {"Lid/dana/explore/domain/sku/model/ExploreServiceModel;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()Z", "key", "name", "description", "iconUrl", "isEnable", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/explore/domain/sku/model/ExploreServiceModel;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getDescription", "setDescription", "(Ljava/lang/String;)V", "getIconUrl", "setIconUrl", "Z", "setEnable", "(Z)V", "getKey", "getName", "setName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ExploreServiceModel {
    private String description;
    private String iconUrl;
    private boolean isEnable;
    private final String key;
    private String name;

    public ExploreServiceModel() {
        this(null, null, null, null, false, 31, null);
    }

    public static /* synthetic */ ExploreServiceModel copy$default(ExploreServiceModel exploreServiceModel, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = exploreServiceModel.key;
        }
        if ((i & 2) != 0) {
            str2 = exploreServiceModel.name;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = exploreServiceModel.description;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = exploreServiceModel.iconUrl;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            z = exploreServiceModel.isEnable;
        }
        return exploreServiceModel.copy(str, str5, str6, str7, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component2  reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4  reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component5  reason: from getter */
    public final boolean getIsEnable() {
        return this.isEnable;
    }

    public final ExploreServiceModel copy(String key, String name, String description, String iconUrl, boolean isEnable) {
        Intrinsics.checkNotNullParameter(key, "");
        return new ExploreServiceModel(key, name, description, iconUrl, isEnable);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ExploreServiceModel) {
            ExploreServiceModel exploreServiceModel = (ExploreServiceModel) other;
            return Intrinsics.areEqual(this.key, exploreServiceModel.key) && Intrinsics.areEqual(this.name, exploreServiceModel.name) && Intrinsics.areEqual(this.description, exploreServiceModel.description) && Intrinsics.areEqual(this.iconUrl, exploreServiceModel.iconUrl) && this.isEnable == exploreServiceModel.isEnable;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.key.hashCode();
        String str = this.name;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.description;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.iconUrl;
        int hashCode4 = str3 != null ? str3.hashCode() : 0;
        boolean z = this.isEnable;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExploreServiceModel(key=");
        sb.append(this.key);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", iconUrl=");
        sb.append(this.iconUrl);
        sb.append(", isEnable=");
        sb.append(this.isEnable);
        sb.append(')');
        return sb.toString();
    }

    public ExploreServiceModel(String str, String str2, String str3, String str4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        this.key = str;
        this.name = str2;
        this.description = str3;
        this.iconUrl = str4;
        this.isEnable = z;
    }

    public /* synthetic */ ExploreServiceModel(String str, String str2, String str3, String str4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) == 0 ? str4 : null, (i & 16) != 0 ? true : z);
    }

    @JvmName(name = "getKey")
    public final String getKey() {
        return this.key;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "setName")
    public final void setName(String str) {
        this.name = str;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "setDescription")
    public final void setDescription(String str) {
        this.description = str;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "setIconUrl")
    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    @JvmName(name = "isEnable")
    public final boolean isEnable() {
        return this.isEnable;
    }

    @JvmName(name = "setEnable")
    public final void setEnable(boolean z) {
        this.isEnable = z;
    }
}
