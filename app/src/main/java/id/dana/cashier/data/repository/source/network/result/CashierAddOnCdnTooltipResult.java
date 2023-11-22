package id.dana.cashier.data.repository.source.network.result;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/CashierAddOnCdnTooltipResult;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "image", "title", "content", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/result/CashierAddOnCdnTooltipResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getContent", "getImage", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierAddOnCdnTooltipResult {
    private final String content;
    private final String image;
    private final String title;

    public static /* synthetic */ CashierAddOnCdnTooltipResult copy$default(CashierAddOnCdnTooltipResult cashierAddOnCdnTooltipResult, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cashierAddOnCdnTooltipResult.image;
        }
        if ((i & 2) != 0) {
            str2 = cashierAddOnCdnTooltipResult.title;
        }
        if ((i & 4) != 0) {
            str3 = cashierAddOnCdnTooltipResult.content;
        }
        return cashierAddOnCdnTooltipResult.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* renamed from: component2  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3  reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final CashierAddOnCdnTooltipResult copy(String image, String title, String content) {
        Intrinsics.checkNotNullParameter(image, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(content, "");
        return new CashierAddOnCdnTooltipResult(image, title, content);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierAddOnCdnTooltipResult) {
            CashierAddOnCdnTooltipResult cashierAddOnCdnTooltipResult = (CashierAddOnCdnTooltipResult) other;
            return Intrinsics.areEqual(this.image, cashierAddOnCdnTooltipResult.image) && Intrinsics.areEqual(this.title, cashierAddOnCdnTooltipResult.title) && Intrinsics.areEqual(this.content, cashierAddOnCdnTooltipResult.content);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.image.hashCode() * 31) + this.title.hashCode()) * 31) + this.content.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierAddOnCdnTooltipResult(image=");
        sb.append(this.image);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(')');
        return sb.toString();
    }

    public CashierAddOnCdnTooltipResult(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.image = str;
        this.title = str2;
        this.content = str3;
    }

    @JvmName(name = "getImage")
    public final String getImage() {
        return this.image;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getContent")
    public final String getContent() {
        return this.content;
    }
}
