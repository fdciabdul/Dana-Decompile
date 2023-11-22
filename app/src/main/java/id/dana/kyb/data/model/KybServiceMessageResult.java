package id.dana.kyb.data.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J4\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/kyb/data/model/KybServiceMessageResult;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "title", "message", "image", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/kyb/data/model/KybServiceMessageResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getImage", "getMessage", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybServiceMessageResult {
    private final String image;
    private final String message;
    private final String title;

    public KybServiceMessageResult() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ KybServiceMessageResult copy$default(KybServiceMessageResult kybServiceMessageResult, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = kybServiceMessageResult.title;
        }
        if ((i & 2) != 0) {
            str2 = kybServiceMessageResult.message;
        }
        if ((i & 4) != 0) {
            str3 = kybServiceMessageResult.image;
        }
        return kybServiceMessageResult.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3  reason: from getter */
    public final String getImage() {
        return this.image;
    }

    public final KybServiceMessageResult copy(String title, String message, String image) {
        return new KybServiceMessageResult(title, message, image);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KybServiceMessageResult) {
            KybServiceMessageResult kybServiceMessageResult = (KybServiceMessageResult) other;
            return Intrinsics.areEqual(this.title, kybServiceMessageResult.title) && Intrinsics.areEqual(this.message, kybServiceMessageResult.message) && Intrinsics.areEqual(this.image, kybServiceMessageResult.image);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.title;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.message;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.image;
        return (((hashCode * 31) + hashCode2) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybServiceMessageResult(title=");
        sb.append(this.title);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", image=");
        sb.append(this.image);
        sb.append(')');
        return sb.toString();
    }

    public KybServiceMessageResult(String str, String str2, String str3) {
        this.title = str;
        this.message = str2;
        this.image = str3;
    }

    public /* synthetic */ KybServiceMessageResult(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getMessage")
    public final String getMessage() {
        return this.message;
    }

    @JvmName(name = "getImage")
    public final String getImage() {
        return this.image;
    }
}
