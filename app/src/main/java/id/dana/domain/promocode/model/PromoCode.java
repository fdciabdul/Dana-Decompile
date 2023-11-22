package id.dana.domain.promocode.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\b"}, d2 = {"Lid/dana/domain/promocode/model/PromoCode;", "", "", "component1", "()Z", "", "Lid/dana/domain/promocode/model/PrizeAwardVO;", "component2", "()Ljava/util/List;", "needRetry", "prizeAwards", "copy", "(ZLjava/util/List;)Lid/dana/domain/promocode/model/PromoCode;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getNeedRetry", "Ljava/util/List;", "getPrizeAwards", "<init>", "(ZLjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PromoCode {
    private final boolean needRetry;
    private final List<PrizeAwardVO> prizeAwards;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromoCode copy$default(PromoCode promoCode, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = promoCode.needRetry;
        }
        if ((i & 2) != 0) {
            list = promoCode.prizeAwards;
        }
        return promoCode.copy(z, list);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getNeedRetry() {
        return this.needRetry;
    }

    public final List<PrizeAwardVO> component2() {
        return this.prizeAwards;
    }

    public final PromoCode copy(boolean needRetry, List<PrizeAwardVO> prizeAwards) {
        Intrinsics.checkNotNullParameter(prizeAwards, "");
        return new PromoCode(needRetry, prizeAwards);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PromoCode) {
            PromoCode promoCode = (PromoCode) other;
            return this.needRetry == promoCode.needRetry && Intrinsics.areEqual(this.prizeAwards, promoCode.prizeAwards);
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
        return (r0 * 31) + this.prizeAwards.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PromoCode(needRetry=");
        sb.append(this.needRetry);
        sb.append(", prizeAwards=");
        sb.append(this.prizeAwards);
        sb.append(')');
        return sb.toString();
    }

    public PromoCode(boolean z, List<PrizeAwardVO> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.needRetry = z;
        this.prizeAwards = list;
    }

    public /* synthetic */ PromoCode(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getNeedRetry")
    public final boolean getNeedRetry() {
        return this.needRetry;
    }

    @JvmName(name = "getPrizeAwards")
    public final List<PrizeAwardVO> getPrizeAwards() {
        return this.prizeAwards;
    }
}
