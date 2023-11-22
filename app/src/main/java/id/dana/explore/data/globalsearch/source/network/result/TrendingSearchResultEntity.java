package id.dana.explore.data.globalsearch.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/explore/data/globalsearch/source/network/result/TrendingSearchResultEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/explore/data/globalsearch/source/network/result/PaginatorEntity;", "paginator", "Lid/dana/explore/data/globalsearch/source/network/result/PaginatorEntity;", "getPaginator", "()Lid/dana/explore/data/globalsearch/source/network/result/PaginatorEntity;", "", "Lid/dana/explore/data/globalsearch/source/network/result/TrendingSearchInfoEntity;", "searchResultList", "Ljava/util/List;", "getSearchResultList", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Lid/dana/explore/data/globalsearch/source/network/result/PaginatorEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TrendingSearchResultEntity extends BaseRpcResult {
    @SerializedName("paginator")
    private final PaginatorEntity paginator;
    @SerializedName("searchResultList")
    private final List<TrendingSearchInfoEntity> searchResultList;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.explore.data.globalsearch.source.network.result.PaginatorEntity, java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TrendingSearchResultEntity() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.data.globalsearch.source.network.result.TrendingSearchResultEntity.<init>():void");
    }

    public /* synthetic */ TrendingSearchResultEntity(List list, PaginatorEntity paginatorEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : paginatorEntity);
    }

    @JvmName(name = "getSearchResultList")
    public final List<TrendingSearchInfoEntity> getSearchResultList() {
        return this.searchResultList;
    }

    @JvmName(name = "getPaginator")
    public final PaginatorEntity getPaginator() {
        return this.paginator;
    }

    public TrendingSearchResultEntity(List<TrendingSearchInfoEntity> list, PaginatorEntity paginatorEntity) {
        this.searchResultList = list;
        this.paginator = paginatorEntity;
    }
}
