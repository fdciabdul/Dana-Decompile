package id.dana.data.promocode.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\b"}, d2 = {"Lid/dana/data/promocode/repository/source/network/result/PromoCodeResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Z", "", "Lid/dana/data/promocode/repository/source/network/result/PrizeAwardVOResult;", "component2", "()Ljava/util/List;", "needRetry", "prizeAward", "copy", "(ZLjava/util/List;)Lid/dana/data/promocode/repository/source/network/result/PromoCodeResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getNeedRetry", "Ljava/util/List;", "getPrizeAward", "<init>", "(ZLjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PromoCodeResult extends BaseRpcResult {
    private final boolean needRetry;
    private final List<PrizeAwardVOResult> prizeAward;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromoCodeResult copy$default(PromoCodeResult promoCodeResult, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = promoCodeResult.needRetry;
        }
        if ((i & 2) != 0) {
            list = promoCodeResult.prizeAward;
        }
        return promoCodeResult.copy(z, list);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getNeedRetry() {
        return this.needRetry;
    }

    public final List<PrizeAwardVOResult> component2() {
        return this.prizeAward;
    }

    public final PromoCodeResult copy(boolean needRetry, List<PrizeAwardVOResult> prizeAward) {
        return new PromoCodeResult(needRetry, prizeAward);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PromoCodeResult) {
            PromoCodeResult promoCodeResult = (PromoCodeResult) other;
            return this.needRetry == promoCodeResult.needRetry && Intrinsics.areEqual(this.prizeAward, promoCodeResult.prizeAward);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.needRetry;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        List<PrizeAwardVOResult> list = this.prizeAward;
        return (r0 * 31) + (list == null ? 0 : list.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PromoCodeResult(needRetry=");
        sb.append(this.needRetry);
        sb.append(", prizeAward=");
        sb.append(this.prizeAward);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getNeedRetry")
    public final boolean getNeedRetry() {
        return this.needRetry;
    }

    @JvmName(name = "getPrizeAward")
    public final List<PrizeAwardVOResult> getPrizeAward() {
        return this.prizeAward;
    }

    public PromoCodeResult(boolean z, List<PrizeAwardVOResult> list) {
        this.needRetry = z;
        this.prizeAward = list;
    }
}
