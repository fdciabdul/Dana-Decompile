package id.dana.domain.familyaccount.model;

import id.dana.domain.nearbyme.model.MoneyView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005"}, d2 = {"Lid/dana/domain/familyaccount/model/LimitInfoResult;", "", "", "", "component1", "()Ljava/util/List;", "Lid/dana/domain/nearbyme/model/MoneyView;", "component2", "()Lid/dana/domain/nearbyme/model/MoneyView;", "useCases", "amount", "copy", "(Ljava/util/List;Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/domain/familyaccount/model/LimitInfoResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Lid/dana/domain/nearbyme/model/MoneyView;", "getAmount", "Ljava/util/List;", "getUseCases", "<init>", "(Ljava/util/List;Lid/dana/domain/nearbyme/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LimitInfoResult {
    private final MoneyView amount;
    private final List<String> useCases;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, id.dana.domain.nearbyme.model.MoneyView, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LimitInfoResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.familyaccount.model.LimitInfoResult.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LimitInfoResult copy$default(LimitInfoResult limitInfoResult, List list, MoneyView moneyView, int i, Object obj) {
        if ((i & 1) != 0) {
            list = limitInfoResult.useCases;
        }
        if ((i & 2) != 0) {
            moneyView = limitInfoResult.amount;
        }
        return limitInfoResult.copy(list, moneyView);
    }

    public final List<String> component1() {
        return this.useCases;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyView getAmount() {
        return this.amount;
    }

    public final LimitInfoResult copy(List<String> useCases, MoneyView amount) {
        Intrinsics.checkNotNullParameter(useCases, "");
        Intrinsics.checkNotNullParameter(amount, "");
        return new LimitInfoResult(useCases, amount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LimitInfoResult) {
            LimitInfoResult limitInfoResult = (LimitInfoResult) other;
            return Intrinsics.areEqual(this.useCases, limitInfoResult.useCases) && Intrinsics.areEqual(this.amount, limitInfoResult.amount);
        }
        return false;
    }

    public final int hashCode() {
        return (this.useCases.hashCode() * 31) + this.amount.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LimitInfoResult(useCases=");
        sb.append(this.useCases);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(')');
        return sb.toString();
    }

    public LimitInfoResult(List<String> list, MoneyView moneyView) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(moneyView, "");
        this.useCases = list;
        this.amount = moneyView;
    }

    public /* synthetic */ LimitInfoResult(List list, MoneyView moneyView, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView);
    }

    @JvmName(name = "getUseCases")
    public final List<String> getUseCases() {
        return this.useCases;
    }

    @JvmName(name = "getAmount")
    public final MoneyView getAmount() {
        return this.amount;
    }
}
