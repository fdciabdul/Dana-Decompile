package id.dana.explore.domain.globalsearch.model;

import com.alibaba.fastjson.annotation.JSONCreator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ6\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u001aR\"\u0010\f\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\u001eR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\""}, d2 = {"Lid/dana/explore/domain/globalsearch/model/GlobalSearchCategory;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "", "component3", "()Ljava/util/List;", "enable", "name", "permission", "copy", "(ZLjava/lang/String;Ljava/util/List;)Lid/dana/explore/domain/globalsearch/model/GlobalSearchCategory;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getEnable", "setEnable", "(Z)V", "Ljava/lang/String;", "getName", "setName", "(Ljava/lang/String;)V", "Ljava/util/List;", "getPermission", "setPermission", "(Ljava/util/List;)V", "<init>", "(ZLjava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GlobalSearchCategory {
    private boolean enable;
    private String name;
    private List<String> permission;

    @JSONCreator
    public GlobalSearchCategory() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GlobalSearchCategory copy$default(GlobalSearchCategory globalSearchCategory, boolean z, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = globalSearchCategory.enable;
        }
        if ((i & 2) != 0) {
            str = globalSearchCategory.name;
        }
        if ((i & 4) != 0) {
            list = globalSearchCategory.permission;
        }
        return globalSearchCategory.copy(z, str, list);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2  reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<String> component3() {
        return this.permission;
    }

    public final GlobalSearchCategory copy(boolean enable, String name, List<String> permission) {
        Intrinsics.checkNotNullParameter(name, "");
        return new GlobalSearchCategory(enable, name, permission);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GlobalSearchCategory) {
            GlobalSearchCategory globalSearchCategory = (GlobalSearchCategory) other;
            return this.enable == globalSearchCategory.enable && Intrinsics.areEqual(this.name, globalSearchCategory.name) && Intrinsics.areEqual(this.permission, globalSearchCategory.permission);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = this.name.hashCode();
        List<String> list = this.permission;
        return (((r0 * 31) + hashCode) * 31) + (list == null ? 0 : list.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GlobalSearchCategory(enable=");
        sb.append(this.enable);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", permission=");
        sb.append(this.permission);
        sb.append(')');
        return sb.toString();
    }

    @JSONCreator
    public GlobalSearchCategory(boolean z, String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "");
        this.enable = z;
        this.name = str;
        this.permission = list;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "setEnable")
    public final void setEnable(boolean z) {
        this.enable = z;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "setName")
    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.name = str;
    }

    public /* synthetic */ GlobalSearchCategory(boolean z, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getPermission")
    public final List<String> getPermission() {
        return this.permission;
    }

    @JvmName(name = "setPermission")
    public final void setPermission(List<String> list) {
        this.permission = list;
    }
}
