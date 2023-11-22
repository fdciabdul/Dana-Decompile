package id.dana.domain.familyaccount.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004"}, d2 = {"Lid/dana/domain/familyaccount/model/CreateOrderTopupResult;", "", "", "component1", "()Ljava/lang/String;", "checkoutUrl", "copy", "(Ljava/lang/String;)Lid/dana/domain/familyaccount/model/CreateOrderTopupResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCheckoutUrl", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CreateOrderTopupResult {
    private final String checkoutUrl;

    public static /* synthetic */ CreateOrderTopupResult copy$default(CreateOrderTopupResult createOrderTopupResult, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createOrderTopupResult.checkoutUrl;
        }
        return createOrderTopupResult.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    public final CreateOrderTopupResult copy(String checkoutUrl) {
        Intrinsics.checkNotNullParameter(checkoutUrl, "");
        return new CreateOrderTopupResult(checkoutUrl);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CreateOrderTopupResult) && Intrinsics.areEqual(this.checkoutUrl, ((CreateOrderTopupResult) other).checkoutUrl);
    }

    public final int hashCode() {
        return this.checkoutUrl.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateOrderTopupResult(checkoutUrl=");
        sb.append(this.checkoutUrl);
        sb.append(')');
        return sb.toString();
    }

    public CreateOrderTopupResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.checkoutUrl = str;
    }

    @JvmName(name = "getCheckoutUrl")
    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }
}
