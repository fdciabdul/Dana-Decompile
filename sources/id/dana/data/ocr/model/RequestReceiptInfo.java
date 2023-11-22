package id.dana.data.ocr.model;

import android.graphics.Bitmap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ4\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004R\u0017\u0010\r\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\nR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004"}, d2 = {"Lid/dana/data/ocr/model/RequestReceiptInfo;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "Landroid/graphics/Bitmap;", "component3", "()Landroid/graphics/Bitmap;", "rules", "merchantNameAlias", "image", "copy", "(Ljava/lang/String;Ljava/util/List;Landroid/graphics/Bitmap;)Lid/dana/data/ocr/model/RequestReceiptInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Landroid/graphics/Bitmap;", "getImage", "Ljava/util/List;", "getMerchantNameAlias", "Ljava/lang/String;", "getRules", "<init>", "(Ljava/lang/String;Ljava/util/List;Landroid/graphics/Bitmap;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class RequestReceiptInfo {
    private final Bitmap image;
    private final List<String> merchantNameAlias;
    private final String rules;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RequestReceiptInfo copy$default(RequestReceiptInfo requestReceiptInfo, String str, List list, Bitmap bitmap, int i, Object obj) {
        if ((i & 1) != 0) {
            str = requestReceiptInfo.rules;
        }
        if ((i & 2) != 0) {
            list = requestReceiptInfo.merchantNameAlias;
        }
        if ((i & 4) != 0) {
            bitmap = requestReceiptInfo.image;
        }
        return requestReceiptInfo.copy(str, list, bitmap);
    }

    /* renamed from: component1  reason: from getter */
    public final String getRules() {
        return this.rules;
    }

    public final List<String> component2() {
        return this.merchantNameAlias;
    }

    /* renamed from: component3  reason: from getter */
    public final Bitmap getImage() {
        return this.image;
    }

    public final RequestReceiptInfo copy(String rules, List<String> merchantNameAlias, Bitmap image) {
        Intrinsics.checkNotNullParameter(rules, "");
        Intrinsics.checkNotNullParameter(merchantNameAlias, "");
        Intrinsics.checkNotNullParameter(image, "");
        return new RequestReceiptInfo(rules, merchantNameAlias, image);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RequestReceiptInfo) {
            RequestReceiptInfo requestReceiptInfo = (RequestReceiptInfo) other;
            return Intrinsics.areEqual(this.rules, requestReceiptInfo.rules) && Intrinsics.areEqual(this.merchantNameAlias, requestReceiptInfo.merchantNameAlias) && Intrinsics.areEqual(this.image, requestReceiptInfo.image);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.rules.hashCode() * 31) + this.merchantNameAlias.hashCode()) * 31) + this.image.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RequestReceiptInfo(rules=");
        sb.append(this.rules);
        sb.append(", merchantNameAlias=");
        sb.append(this.merchantNameAlias);
        sb.append(", image=");
        sb.append(this.image);
        sb.append(')');
        return sb.toString();
    }

    public RequestReceiptInfo(String str, List<String> list, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(bitmap, "");
        this.rules = str;
        this.merchantNameAlias = list;
        this.image = bitmap;
    }

    @JvmName(name = "getRules")
    public final String getRules() {
        return this.rules;
    }

    @JvmName(name = "getMerchantNameAlias")
    public final List<String> getMerchantNameAlias() {
        return this.merchantNameAlias;
    }

    @JvmName(name = "getImage")
    public final Bitmap getImage() {
        return this.image;
    }
}
