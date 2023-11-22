package id.dana.explore.domain.globalsearch.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b \u0010!J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005R\u001a\u0010\u000e\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u000b"}, d2 = {"Lid/dana/explore/domain/globalsearch/model/AutoCompleteResult;", "", "", "Lid/dana/explore/domain/globalsearch/model/PaySearchInfo;", "component1", "()Ljava/util/List;", "Lid/dana/explore/domain/globalsearch/model/Paginator;", "component2", "()Lid/dana/explore/domain/globalsearch/model/Paginator;", "", "component3", "()Z", "searchResultList", "paginator", "success", "copy", "(Ljava/util/List;Lid/dana/explore/domain/globalsearch/model/Paginator;Z)Lid/dana/explore/domain/globalsearch/model/AutoCompleteResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/explore/domain/globalsearch/model/Paginator;", "getPaginator", "Ljava/util/List;", "getSearchResultList", "Z", "getSuccess", "<init>", "(Ljava/util/List;Lid/dana/explore/domain/globalsearch/model/Paginator;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AutoCompleteResult {
    private final Paginator paginator;
    private final List<PaySearchInfo> searchResultList;
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutoCompleteResult copy$default(AutoCompleteResult autoCompleteResult, List list, Paginator paginator, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = autoCompleteResult.searchResultList;
        }
        if ((i & 2) != 0) {
            paginator = autoCompleteResult.paginator;
        }
        if ((i & 4) != 0) {
            z = autoCompleteResult.success;
        }
        return autoCompleteResult.copy(list, paginator, z);
    }

    public final List<PaySearchInfo> component1() {
        return this.searchResultList;
    }

    /* renamed from: component2  reason: from getter */
    public final Paginator getPaginator() {
        return this.paginator;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final AutoCompleteResult copy(List<PaySearchInfo> searchResultList, Paginator paginator, boolean success) {
        Intrinsics.checkNotNullParameter(searchResultList, "");
        return new AutoCompleteResult(searchResultList, paginator, success);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AutoCompleteResult) {
            AutoCompleteResult autoCompleteResult = (AutoCompleteResult) other;
            return Intrinsics.areEqual(this.searchResultList, autoCompleteResult.searchResultList) && Intrinsics.areEqual(this.paginator, autoCompleteResult.paginator) && this.success == autoCompleteResult.success;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.searchResultList.hashCode();
        Paginator paginator = this.paginator;
        int hashCode2 = paginator == null ? 0 : paginator.hashCode();
        boolean z = this.success;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((hashCode * 31) + hashCode2) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AutoCompleteResult(searchResultList=");
        sb.append(this.searchResultList);
        sb.append(", paginator=");
        sb.append(this.paginator);
        sb.append(", success=");
        sb.append(this.success);
        sb.append(')');
        return sb.toString();
    }

    public AutoCompleteResult(List<PaySearchInfo> list, Paginator paginator, boolean z) {
        Intrinsics.checkNotNullParameter(list, "");
        this.searchResultList = list;
        this.paginator = paginator;
        this.success = z;
    }

    @JvmName(name = "getSearchResultList")
    public final List<PaySearchInfo> getSearchResultList() {
        return this.searchResultList;
    }

    @JvmName(name = "getPaginator")
    public final Paginator getPaginator() {
        return this.paginator;
    }

    @JvmName(name = "getSuccess")
    public final boolean getSuccess() {
        return this.success;
    }
}
