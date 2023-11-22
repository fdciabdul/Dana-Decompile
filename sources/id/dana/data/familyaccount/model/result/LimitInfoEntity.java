package id.dana.data.familyaccount.model.result;

import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005"}, d2 = {"Lid/dana/data/familyaccount/model/result/LimitInfoEntity;", "", "", "", "component1", "()Ljava/util/List;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component2", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "useCases", "amount", "copy", "(Ljava/util/List;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)Lid/dana/data/familyaccount/model/result/LimitInfoEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getAmount", "Ljava/util/List;", "getUseCases", "<init>", "(Ljava/util/List;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LimitInfoEntity {
    private final MoneyViewEntity amount;
    private final List<String> useCases;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LimitInfoEntity copy$default(LimitInfoEntity limitInfoEntity, List list, MoneyViewEntity moneyViewEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            list = limitInfoEntity.useCases;
        }
        if ((i & 2) != 0) {
            moneyViewEntity = limitInfoEntity.amount;
        }
        return limitInfoEntity.copy(list, moneyViewEntity);
    }

    public final List<String> component1() {
        return this.useCases;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyViewEntity getAmount() {
        return this.amount;
    }

    public final LimitInfoEntity copy(List<String> useCases, MoneyViewEntity amount) {
        Intrinsics.checkNotNullParameter(amount, "");
        return new LimitInfoEntity(useCases, amount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LimitInfoEntity) {
            LimitInfoEntity limitInfoEntity = (LimitInfoEntity) other;
            return Intrinsics.areEqual(this.useCases, limitInfoEntity.useCases) && Intrinsics.areEqual(this.amount, limitInfoEntity.amount);
        }
        return false;
    }

    public final int hashCode() {
        List<String> list = this.useCases;
        return ((list == null ? 0 : list.hashCode()) * 31) + this.amount.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LimitInfoEntity(useCases=");
        sb.append(this.useCases);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(')');
        return sb.toString();
    }

    public LimitInfoEntity(List<String> list, MoneyViewEntity moneyViewEntity) {
        Intrinsics.checkNotNullParameter(moneyViewEntity, "");
        this.useCases = list;
        this.amount = moneyViewEntity;
    }

    public /* synthetic */ LimitInfoEntity(List list, MoneyViewEntity moneyViewEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, moneyViewEntity);
    }

    @JvmName(name = "getUseCases")
    public final List<String> getUseCases() {
        return this.useCases;
    }

    @JvmName(name = "getAmount")
    public final MoneyViewEntity getAmount() {
        return this.amount;
    }
}
