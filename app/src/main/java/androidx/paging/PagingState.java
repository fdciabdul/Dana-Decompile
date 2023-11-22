package androidx.paging;

import androidx.paging.PagingSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B;\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00170\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u001b\u001a\u00020\u0010\u0012\u0006\u0010\u001c\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R#\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00170\u0016X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Landroidx/paging/PagingState;", "", "Key", "Value", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/Integer;", "Landroidx/paging/PagingConfig;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/paging/PagingConfig;", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "I", "", "Landroidx/paging/PagingSource$LoadResult$Page;", "MyBillsEntityDataFactory", "Ljava/util/List;", "p1", "p2", "p3", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Landroidx/paging/PagingConfig;I)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PagingState<Key, Value> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final PagingConfig getAuthRequestContext;
    final List<PagingSource.LoadResult.Page<Key, Value>> MyBillsEntityDataFactory;
    public final Integer PlaceComponentResult;

    public PagingState(List<PagingSource.LoadResult.Page<Key, Value>> list, Integer num, PagingConfig pagingConfig, int i) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(pagingConfig, "");
        this.MyBillsEntityDataFactory = list;
        this.PlaceComponentResult = num;
        this.getAuthRequestContext = pagingConfig;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
    }

    public final boolean equals(Object p0) {
        if (p0 instanceof PagingState) {
            PagingState pagingState = (PagingState) p0;
            if (Intrinsics.areEqual(this.MyBillsEntityDataFactory, pagingState.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, pagingState.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, pagingState.getAuthRequestContext) && this.KClassImpl$Data$declaredNonStaticMembers$2 == pagingState.KClassImpl$Data$declaredNonStaticMembers$2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.MyBillsEntityDataFactory.hashCode();
        Integer num = this.PlaceComponentResult;
        return hashCode + (num != null ? num.hashCode() : 0) + this.getAuthRequestContext.hashCode() + this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PagingState(pages=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", anchorPosition=");
        sb.append(this.PlaceComponentResult);
        sb.append(", config=");
        sb.append(this.getAuthRequestContext);
        sb.append(", leadingPlaceholderCount=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }
}
