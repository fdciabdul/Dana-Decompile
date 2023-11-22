package id.dana.domain.wallet_v3.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J@\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0005R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001a\u0010\u0005"}, d2 = {"Lid/dana/domain/wallet_v3/model/WalletSearch;", "", "", "Lid/dana/domain/wallet_v3/model/SearchCategory;", "component1", "()Ljava/util/List;", "component2", "component3", "searchGeneral", "searchPayment", "searchFinancial", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lid/dana/domain/wallet_v3/model/WalletSearch;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getSearchFinancial", "getSearchGeneral", "getSearchPayment", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class WalletSearch {
    @SerializedName("search_financial")
    private final List<SearchCategory> searchFinancial;
    @SerializedName("search_general")
    private final List<SearchCategory> searchGeneral;
    @SerializedName("search_payment")
    private final List<SearchCategory> searchPayment;

    public WalletSearch() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WalletSearch copy$default(WalletSearch walletSearch, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = walletSearch.searchGeneral;
        }
        if ((i & 2) != 0) {
            list2 = walletSearch.searchPayment;
        }
        if ((i & 4) != 0) {
            list3 = walletSearch.searchFinancial;
        }
        return walletSearch.copy(list, list2, list3);
    }

    public final List<SearchCategory> component1() {
        return this.searchGeneral;
    }

    public final List<SearchCategory> component2() {
        return this.searchPayment;
    }

    public final List<SearchCategory> component3() {
        return this.searchFinancial;
    }

    public final WalletSearch copy(List<SearchCategory> searchGeneral, List<SearchCategory> searchPayment, List<SearchCategory> searchFinancial) {
        Intrinsics.checkNotNullParameter(searchGeneral, "");
        Intrinsics.checkNotNullParameter(searchPayment, "");
        Intrinsics.checkNotNullParameter(searchFinancial, "");
        return new WalletSearch(searchGeneral, searchPayment, searchFinancial);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof WalletSearch) {
            WalletSearch walletSearch = (WalletSearch) other;
            return Intrinsics.areEqual(this.searchGeneral, walletSearch.searchGeneral) && Intrinsics.areEqual(this.searchPayment, walletSearch.searchPayment) && Intrinsics.areEqual(this.searchFinancial, walletSearch.searchFinancial);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.searchGeneral.hashCode() * 31) + this.searchPayment.hashCode()) * 31) + this.searchFinancial.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WalletSearch(searchGeneral=");
        sb.append(this.searchGeneral);
        sb.append(", searchPayment=");
        sb.append(this.searchPayment);
        sb.append(", searchFinancial=");
        sb.append(this.searchFinancial);
        sb.append(')');
        return sb.toString();
    }

    public WalletSearch(List<SearchCategory> list, List<SearchCategory> list2, List<SearchCategory> list3) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(list3, "");
        this.searchGeneral = list;
        this.searchPayment = list2;
        this.searchFinancial = list3;
    }

    public /* synthetic */ WalletSearch(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3);
    }

    @JvmName(name = "getSearchGeneral")
    public final List<SearchCategory> getSearchGeneral() {
        return this.searchGeneral;
    }

    @JvmName(name = "getSearchPayment")
    public final List<SearchCategory> getSearchPayment() {
        return this.searchPayment;
    }

    @JvmName(name = "getSearchFinancial")
    public final List<SearchCategory> getSearchFinancial() {
        return this.searchFinancial;
    }
}
