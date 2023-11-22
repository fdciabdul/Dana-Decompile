package id.dana.data.config.source.amcs.result;

import com.alibaba.griver.core.GriverParams;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004JB\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001e\u0010\u0004"}, d2 = {"Lid/dana/data/config/source/amcs/result/QrisCrossBorderContentResult;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "title", "subtitle", "buttonTitle", GriverParams.ShareParams.IMAGE_URL, "description", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/config/source/amcs/result/QrisCrossBorderContentResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getButtonTitle", "getDescription", "getImageUrl", "getSubtitle", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class QrisCrossBorderContentResult implements Serializable {
    private final String buttonTitle;
    private final String description;
    private final String imageUrl;
    private final String subtitle;
    private final String title;

    public QrisCrossBorderContentResult() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ QrisCrossBorderContentResult copy$default(QrisCrossBorderContentResult qrisCrossBorderContentResult, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = qrisCrossBorderContentResult.title;
        }
        if ((i & 2) != 0) {
            str2 = qrisCrossBorderContentResult.subtitle;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = qrisCrossBorderContentResult.buttonTitle;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = qrisCrossBorderContentResult.imageUrl;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = qrisCrossBorderContentResult.description;
        }
        return qrisCrossBorderContentResult.copy(str, str6, str7, str8, str5);
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

    /* renamed from: component5  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final QrisCrossBorderContentResult copy(String title, String subtitle, String buttonTitle, String imageUrl, String description) {
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(subtitle, "");
        Intrinsics.checkNotNullParameter(buttonTitle, "");
        Intrinsics.checkNotNullParameter(imageUrl, "");
        Intrinsics.checkNotNullParameter(description, "");
        return new QrisCrossBorderContentResult(title, subtitle, buttonTitle, imageUrl, description);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QrisCrossBorderContentResult) {
            QrisCrossBorderContentResult qrisCrossBorderContentResult = (QrisCrossBorderContentResult) other;
            return Intrinsics.areEqual(this.title, qrisCrossBorderContentResult.title) && Intrinsics.areEqual(this.subtitle, qrisCrossBorderContentResult.subtitle) && Intrinsics.areEqual(this.buttonTitle, qrisCrossBorderContentResult.buttonTitle) && Intrinsics.areEqual(this.imageUrl, qrisCrossBorderContentResult.imageUrl) && Intrinsics.areEqual(this.description, qrisCrossBorderContentResult.description);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31) + this.buttonTitle.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.description.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QrisCrossBorderContentResult(title=");
        sb.append(this.title);
        sb.append(", subtitle=");
        sb.append(this.subtitle);
        sb.append(", buttonTitle=");
        sb.append(this.buttonTitle);
        sb.append(", imageUrl=");
        sb.append(this.imageUrl);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(')');
        return sb.toString();
    }

    public QrisCrossBorderContentResult(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.title = str;
        this.subtitle = str2;
        this.buttonTitle = str3;
        this.imageUrl = str4;
        this.description = str5;
    }

    public /* synthetic */ QrisCrossBorderContentResult(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5);
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

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }
}
