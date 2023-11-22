package id.dana.data.promocode.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/data/promocode/repository/source/network/request/PromoCodeRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "promoCode", "copy", "(Ljava/lang/String;)Lid/dana/data/promocode/repository/source/network/request/PromoCodeRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getPromoCode", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PromoCodeRequest extends BaseRpcRequest {
    private final String promoCode;

    public static /* synthetic */ PromoCodeRequest copy$default(PromoCodeRequest promoCodeRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = promoCodeRequest.promoCode;
        }
        return promoCodeRequest.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPromoCode() {
        return this.promoCode;
    }

    public final PromoCodeRequest copy(String promoCode) {
        Intrinsics.checkNotNullParameter(promoCode, "");
        return new PromoCodeRequest(promoCode);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PromoCodeRequest) && Intrinsics.areEqual(this.promoCode, ((PromoCodeRequest) other).promoCode);
    }

    public final int hashCode() {
        return this.promoCode.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PromoCodeRequest(promoCode=");
        sb.append(this.promoCode);
        sb.append(')');
        return sb.toString();
    }

    public PromoCodeRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.promoCode = str;
    }

    @JvmName(name = "getPromoCode")
    public final String getPromoCode() {
        return this.promoCode;
    }
}
