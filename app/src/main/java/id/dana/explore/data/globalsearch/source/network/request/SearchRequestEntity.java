package id.dana.explore.data.globalsearch.source.network.request;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b1\u00102J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJR\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\"R*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\u0005\"\u0004\b%\u0010&R$\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010\"R$\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010\f\"\u0004\b+\u0010,R$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010-\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u00100"}, d2 = {"Lid/dana/explore/data/globalsearch/source/network/request/SearchRequestEntity;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "Lid/dana/explore/data/globalsearch/source/network/request/SearchConditionEntity;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/Integer;", "component3", "Lid/dana/explore/data/globalsearch/source/network/request/SortEntity;", "component4", "()Lid/dana/explore/data/globalsearch/source/network/request/SortEntity;", "", "component5", "()Ljava/lang/String;", "searchConditionList", "page", GriverMonitorConstants.KEY_SIZE, "sort", "userId", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Lid/dana/explore/data/globalsearch/source/network/request/SortEntity;Ljava/lang/String;)Lid/dana/explore/data/globalsearch/source/network/request/SearchRequestEntity;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/Integer;", "getPage", "setPage", "(Ljava/lang/Integer;)V", "Ljava/util/List;", "getSearchConditionList", "setSearchConditionList", "(Ljava/util/List;)V", "getSize", "setSize", "Lid/dana/explore/data/globalsearch/source/network/request/SortEntity;", "getSort", "setSort", "(Lid/dana/explore/data/globalsearch/source/network/request/SortEntity;)V", "Ljava/lang/String;", "getUserId", "setUserId", "(Ljava/lang/String;)V", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Lid/dana/explore/data/globalsearch/source/network/request/SortEntity;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SearchRequestEntity extends BaseRpcRequest {
    private Integer page;
    private List<SearchConditionEntity> searchConditionList;
    private Integer size;
    private SortEntity sort;
    private String userId;

    public SearchRequestEntity() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SearchRequestEntity copy$default(SearchRequestEntity searchRequestEntity, List list, Integer num, Integer num2, SortEntity sortEntity, String str, int i, Object obj) {
        List<SearchConditionEntity> list2 = list;
        if ((i & 1) != 0) {
            list2 = searchRequestEntity.searchConditionList;
        }
        if ((i & 2) != 0) {
            num = searchRequestEntity.page;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            num2 = searchRequestEntity.size;
        }
        Integer num4 = num2;
        if ((i & 8) != 0) {
            sortEntity = searchRequestEntity.sort;
        }
        SortEntity sortEntity2 = sortEntity;
        if ((i & 16) != 0) {
            str = searchRequestEntity.userId;
        }
        return searchRequestEntity.copy(list2, num3, num4, sortEntity2, str);
    }

    public final List<SearchConditionEntity> component1() {
        return this.searchConditionList;
    }

    /* renamed from: component2  reason: from getter */
    public final Integer getPage() {
        return this.page;
    }

    /* renamed from: component3  reason: from getter */
    public final Integer getSize() {
        return this.size;
    }

    /* renamed from: component4  reason: from getter */
    public final SortEntity getSort() {
        return this.sort;
    }

    /* renamed from: component5  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public final SearchRequestEntity copy(List<SearchConditionEntity> searchConditionList, Integer page, Integer size, SortEntity sort, String userId) {
        return new SearchRequestEntity(searchConditionList, page, size, sort, userId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SearchRequestEntity) {
            SearchRequestEntity searchRequestEntity = (SearchRequestEntity) other;
            return Intrinsics.areEqual(this.searchConditionList, searchRequestEntity.searchConditionList) && Intrinsics.areEqual(this.page, searchRequestEntity.page) && Intrinsics.areEqual(this.size, searchRequestEntity.size) && Intrinsics.areEqual(this.sort, searchRequestEntity.sort) && Intrinsics.areEqual(this.userId, searchRequestEntity.userId);
        }
        return false;
    }

    public final int hashCode() {
        List<SearchConditionEntity> list = this.searchConditionList;
        int hashCode = list == null ? 0 : list.hashCode();
        Integer num = this.page;
        int hashCode2 = num == null ? 0 : num.hashCode();
        Integer num2 = this.size;
        int hashCode3 = num2 == null ? 0 : num2.hashCode();
        SortEntity sortEntity = this.sort;
        int hashCode4 = sortEntity == null ? 0 : sortEntity.hashCode();
        String str = this.userId;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SearchRequestEntity(searchConditionList=");
        sb.append(this.searchConditionList);
        sb.append(", page=");
        sb.append(this.page);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(", sort=");
        sb.append(this.sort);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getSearchConditionList")
    public final List<SearchConditionEntity> getSearchConditionList() {
        return this.searchConditionList;
    }

    @JvmName(name = "setSearchConditionList")
    public final void setSearchConditionList(List<SearchConditionEntity> list) {
        this.searchConditionList = list;
    }

    public /* synthetic */ SearchRequestEntity(List list, Integer num, Integer num2, SortEntity sortEntity, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? 0 : num2, (i & 8) != 0 ? null : sortEntity, (i & 16) != 0 ? null : str);
    }

    @JvmName(name = "getPage")
    public final Integer getPage() {
        return this.page;
    }

    @JvmName(name = "setPage")
    public final void setPage(Integer num) {
        this.page = num;
    }

    @JvmName(name = "getSize")
    public final Integer getSize() {
        return this.size;
    }

    @JvmName(name = "setSize")
    public final void setSize(Integer num) {
        this.size = num;
    }

    @JvmName(name = "getSort")
    public final SortEntity getSort() {
        return this.sort;
    }

    @JvmName(name = "setSort")
    public final void setSort(SortEntity sortEntity) {
        this.sort = sortEntity;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "setUserId")
    public final void setUserId(String str) {
        this.userId = str;
    }

    public SearchRequestEntity(List<SearchConditionEntity> list, Integer num, Integer num2, SortEntity sortEntity, String str) {
        this.searchConditionList = list;
        this.page = num;
        this.size = num2;
        this.sort = sortEntity;
        this.userId = str;
    }
}
