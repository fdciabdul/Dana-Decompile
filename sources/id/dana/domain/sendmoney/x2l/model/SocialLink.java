package id.dana.domain.sendmoney.x2l.model;

import com.alibaba.ariver.kernel.RVParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/domain/sendmoney/x2l/model/SocialLink;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "title", RVParams.LONG_SUB_TITLE, "action", "icon", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/sendmoney/x2l/model/SocialLink;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAction", "getIcon", "getSubTitle", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SocialLink {
    private final String action;
    private final String icon;
    private final String subTitle;
    private final String title;

    public static /* synthetic */ SocialLink copy$default(SocialLink socialLink, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = socialLink.title;
        }
        if ((i & 2) != 0) {
            str2 = socialLink.subTitle;
        }
        if ((i & 4) != 0) {
            str3 = socialLink.action;
        }
        if ((i & 8) != 0) {
            str4 = socialLink.icon;
        }
        return socialLink.copy(str, str2, str3, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSubTitle() {
        return this.subTitle;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component4  reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    public final SocialLink copy(String title, String subTitle, String action, String icon) {
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(subTitle, "");
        Intrinsics.checkNotNullParameter(action, "");
        Intrinsics.checkNotNullParameter(icon, "");
        return new SocialLink(title, subTitle, action, icon);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SocialLink) {
            SocialLink socialLink = (SocialLink) other;
            return Intrinsics.areEqual(this.title, socialLink.title) && Intrinsics.areEqual(this.subTitle, socialLink.subTitle) && Intrinsics.areEqual(this.action, socialLink.action) && Intrinsics.areEqual(this.icon, socialLink.icon);
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.title.hashCode() * 31) + this.subTitle.hashCode()) * 31) + this.action.hashCode()) * 31) + this.icon.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SocialLink(title=");
        sb.append(this.title);
        sb.append(", subTitle=");
        sb.append(this.subTitle);
        sb.append(", action=");
        sb.append(this.action);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(')');
        return sb.toString();
    }

    public SocialLink(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.title = str;
        this.subTitle = str2;
        this.action = str3;
        this.icon = str4;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getSubTitle")
    public final String getSubTitle() {
        return this.subTitle;
    }

    @JvmName(name = "getAction")
    public final String getAction() {
        return this.action;
    }

    @JvmName(name = "getIcon")
    public final String getIcon() {
        return this.icon;
    }
}
