package id.dana.domain.saving.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/domain/saving/model/MainEmptyState;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "icon", "title", "subtitle", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/saving/model/MainEmptyState;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getIcon", "getSubtitle", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MainEmptyState {
    private final String icon;
    private final String subtitle;
    private final String title;

    public static /* synthetic */ MainEmptyState copy$default(MainEmptyState mainEmptyState, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mainEmptyState.icon;
        }
        if ((i & 2) != 0) {
            str2 = mainEmptyState.title;
        }
        if ((i & 4) != 0) {
            str3 = mainEmptyState.subtitle;
        }
        return mainEmptyState.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component2  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3  reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    public final MainEmptyState copy(String icon, String title, String subtitle) {
        Intrinsics.checkNotNullParameter(icon, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(subtitle, "");
        return new MainEmptyState(icon, title, subtitle);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MainEmptyState) {
            MainEmptyState mainEmptyState = (MainEmptyState) other;
            return Intrinsics.areEqual(this.icon, mainEmptyState.icon) && Intrinsics.areEqual(this.title, mainEmptyState.title) && Intrinsics.areEqual(this.subtitle, mainEmptyState.subtitle);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.icon.hashCode() * 31) + this.title.hashCode()) * 31) + this.subtitle.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MainEmptyState(icon=");
        sb.append(this.icon);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", subtitle=");
        sb.append(this.subtitle);
        sb.append(')');
        return sb.toString();
    }

    public MainEmptyState(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.icon = str;
        this.title = str2;
        this.subtitle = str3;
    }

    @JvmName(name = "getIcon")
    public final String getIcon() {
        return this.icon;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getSubtitle")
    public final String getSubtitle() {
        return this.subtitle;
    }
}
