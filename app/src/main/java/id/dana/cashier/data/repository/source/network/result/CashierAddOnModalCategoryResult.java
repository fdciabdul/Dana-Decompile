package id.dana.cashier.data.repository.source.network.result;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0005"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/CashierAddOnModalCategoryResult;", "", "", "", "component1", "()Ljava/util/List;", "category", "copy", "(Ljava/util/List;)Lid/dana/cashier/data/repository/source/network/result/CashierAddOnModalCategoryResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getCategory", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierAddOnModalCategoryResult {
    private final List<String> category;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CashierAddOnModalCategoryResult copy$default(CashierAddOnModalCategoryResult cashierAddOnModalCategoryResult, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = cashierAddOnModalCategoryResult.category;
        }
        return cashierAddOnModalCategoryResult.copy(list);
    }

    public final List<String> component1() {
        return this.category;
    }

    public final CashierAddOnModalCategoryResult copy(List<String> category) {
        Intrinsics.checkNotNullParameter(category, "");
        return new CashierAddOnModalCategoryResult(category);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CashierAddOnModalCategoryResult) && Intrinsics.areEqual(this.category, ((CashierAddOnModalCategoryResult) other).category);
    }

    public final int hashCode() {
        return this.category.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierAddOnModalCategoryResult(category=");
        sb.append(this.category);
        sb.append(')');
        return sb.toString();
    }

    public CashierAddOnModalCategoryResult(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.category = list;
    }

    @JvmName(name = "getCategory")
    public final List<String> getCategory() {
        return this.category;
    }
}
