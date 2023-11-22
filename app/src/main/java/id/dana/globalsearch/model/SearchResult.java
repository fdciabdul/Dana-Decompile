package id.dana.globalsearch.model;

import id.dana.explore.domain.globalsearch.model.Paginator;
import id.dana.explore.domain.globalsearch.model.PaySearchInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\u0012R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0007¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/globalsearch/model/SearchResult;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/explore/domain/globalsearch/model/Paginator;", "MyBillsEntityDataFactory", "Lid/dana/explore/domain/globalsearch/model/Paginator;", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "Z", "()Z", "BuiltInFictitiousFunctionClassFactory", "", "Lid/dana/explore/domain/globalsearch/model/PaySearchInfo;", "getAuthRequestContext", "Ljava/util/List;", "p1", "p2", "<init>", "(Ljava/util/List;Lid/dana/explore/domain/globalsearch/model/Paginator;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SearchResult {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Paginator KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final List<PaySearchInfo> PlaceComponentResult;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SearchResult) {
            SearchResult searchResult = (SearchResult) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, searchResult.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, searchResult.KClassImpl$Data$declaredNonStaticMembers$2) && this.BuiltInFictitiousFunctionClassFactory == searchResult.BuiltInFictitiousFunctionClassFactory;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        List<PaySearchInfo> list = this.PlaceComponentResult;
        int hashCode = list == null ? 0 : list.hashCode();
        Paginator paginator = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode2 = paginator != null ? paginator.hashCode() : 0;
        boolean z = this.BuiltInFictitiousFunctionClassFactory;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((hashCode * 31) + hashCode2) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SearchResult(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    public SearchResult(List<PaySearchInfo> list, Paginator paginator, boolean z) {
        this.PlaceComponentResult = list;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = paginator;
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
