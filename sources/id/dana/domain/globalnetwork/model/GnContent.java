package id.dana.domain.globalnetwork.model;

import com.alibaba.griver.core.GriverParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/domain/globalnetwork/model/GnContent;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "title", "subtitle", "buttonTitle", GriverParams.ShareParams.IMAGE_URL, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/globalnetwork/model/GnContent;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getButtonTitle", "getImageUrl", "getSubtitle", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class GnContent {
    private final String buttonTitle;
    private final String imageUrl;
    private final String subtitle;
    private final String title;

    public GnContent() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ GnContent copy$default(GnContent gnContent, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gnContent.title;
        }
        if ((i & 2) != 0) {
            str2 = gnContent.subtitle;
        }
        if ((i & 4) != 0) {
            str3 = gnContent.buttonTitle;
        }
        if ((i & 8) != 0) {
            str4 = gnContent.imageUrl;
        }
        return gnContent.copy(str, str2, str3, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* renamed from: component3  reason: from getter */
    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    /* renamed from: component4  reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final GnContent copy(String title, String subtitle, String buttonTitle, String imageUrl) {
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(subtitle, "");
        Intrinsics.checkNotNullParameter(buttonTitle, "");
        Intrinsics.checkNotNullParameter(imageUrl, "");
        return new GnContent(title, subtitle, buttonTitle, imageUrl);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GnContent) {
            GnContent gnContent = (GnContent) other;
            return Intrinsics.areEqual(this.title, gnContent.title) && Intrinsics.areEqual(this.subtitle, gnContent.subtitle) && Intrinsics.areEqual(this.buttonTitle, gnContent.buttonTitle) && Intrinsics.areEqual(this.imageUrl, gnContent.imageUrl);
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31) + this.buttonTitle.hashCode()) * 31) + this.imageUrl.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GnContent(title=");
        sb.append(this.title);
        sb.append(", subtitle=");
        sb.append(this.subtitle);
        sb.append(", buttonTitle=");
        sb.append(this.buttonTitle);
        sb.append(", imageUrl=");
        sb.append(this.imageUrl);
        sb.append(')');
        return sb.toString();
    }

    public GnContent(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.title = str;
        this.subtitle = str2;
        this.buttonTitle = str3;
        this.imageUrl = str4;
    }

    public /* synthetic */ GnContent(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getSubtitle")
    public final String getSubtitle() {
        return this.subtitle;
    }

    @JvmName(name = "getButtonTitle")
    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    @JvmName(name = "getImageUrl")
    public final String getImageUrl() {
        return this.imageUrl;
    }
}
