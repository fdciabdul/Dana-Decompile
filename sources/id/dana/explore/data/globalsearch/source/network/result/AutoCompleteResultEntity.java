package id.dana.explore.data.globalsearch.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005"}, d2 = {"Lid/dana/explore/data/globalsearch/source/network/result/AutoCompleteResultEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/explore/data/globalsearch/source/network/result/PaySearchInfoEntity;", "component1", "()Ljava/util/List;", "Lid/dana/explore/data/globalsearch/source/network/result/PaginatorEntity;", "component2", "()Lid/dana/explore/data/globalsearch/source/network/result/PaginatorEntity;", "searchResultList", "paginator", "copy", "(Ljava/util/List;Lid/dana/explore/data/globalsearch/source/network/result/PaginatorEntity;)Lid/dana/explore/data/globalsearch/source/network/result/AutoCompleteResultEntity;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/explore/data/globalsearch/source/network/result/PaginatorEntity;", "getPaginator", "Ljava/util/List;", "getSearchResultList", "<init>", "(Ljava/util/List;Lid/dana/explore/data/globalsearch/source/network/result/PaginatorEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AutoCompleteResultEntity extends BaseRpcResult {
    private final PaginatorEntity paginator;
    private final List<PaySearchInfoEntity> searchResultList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutoCompleteResultEntity copy$default(AutoCompleteResultEntity autoCompleteResultEntity, List list, PaginatorEntity paginatorEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            list = autoCompleteResultEntity.searchResultList;
        }
        if ((i & 2) != 0) {
            paginatorEntity = autoCompleteResultEntity.paginator;
        }
        return autoCompleteResultEntity.copy(list, paginatorEntity);
    }

    public final List<PaySearchInfoEntity> component1() {
        return this.searchResultList;
    }

    /* renamed from: component2  reason: from getter */
    public final PaginatorEntity getPaginator() {
        return this.paginator;
    }

    public final AutoCompleteResultEntity copy(List<PaySearchInfoEntity> searchResultList, PaginatorEntity paginator) {
        Intrinsics.checkNotNullParameter(searchResultList, "");
        return new AutoCompleteResultEntity(searchResultList, paginator);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AutoCompleteResultEntity) {
            AutoCompleteResultEntity autoCompleteResultEntity = (AutoCompleteResultEntity) other;
            return Intrinsics.areEqual(this.searchResultList, autoCompleteResultEntity.searchResultList) && Intrinsics.areEqual(this.paginator, autoCompleteResultEntity.paginator);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.searchResultList.hashCode();
        PaginatorEntity paginatorEntity = this.paginator;
        return (hashCode * 31) + (paginatorEntity == null ? 0 : paginatorEntity.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AutoCompleteResultEntity(searchResultList=");
        sb.append(this.searchResultList);
        sb.append(", paginator=");
        sb.append(this.paginator);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getSearchResultList")
    public final List<PaySearchInfoEntity> getSearchResultList() {
        return this.searchResultList;
    }

    @JvmName(name = "getPaginator")
    public final PaginatorEntity getPaginator() {
        return this.paginator;
    }

    public AutoCompleteResultEntity(List<PaySearchInfoEntity> list, PaginatorEntity paginatorEntity) {
        Intrinsics.checkNotNullParameter(list, "");
        this.searchResultList = list;
        this.paginator = paginatorEntity;
    }
}
