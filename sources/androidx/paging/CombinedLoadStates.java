package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000f\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0011\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0011\u0010\r\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0014\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012"}, d2 = {"Landroidx/paging/CombinedLoadStates;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroidx/paging/LoadState;", "getAuthRequestContext", "Landroidx/paging/LoadState;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/paging/LoadStates;", "PlaceComponentResult", "Landroidx/paging/LoadStates;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "p1", "p2", "p3", "p4", "<init>", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CombinedLoadStates {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final LoadState getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final LoadState PlaceComponentResult;
    final LoadStates MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final LoadStates BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final LoadState KClassImpl$Data$declaredNonStaticMembers$2;

    public CombinedLoadStates(LoadState loadState, LoadState loadState2, LoadState loadState3, LoadStates loadStates, LoadStates loadStates2) {
        Intrinsics.checkNotNullParameter(loadState, "");
        Intrinsics.checkNotNullParameter(loadState2, "");
        Intrinsics.checkNotNullParameter(loadState3, "");
        Intrinsics.checkNotNullParameter(loadStates, "");
        this.getAuthRequestContext = loadState;
        this.PlaceComponentResult = loadState2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = loadState3;
        this.MyBillsEntityDataFactory = loadStates;
        this.BuiltInFictitiousFunctionClassFactory = loadStates2;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (Intrinsics.areEqual(getClass(), p0 == null ? null : p0.getClass())) {
            if (p0 != null) {
                CombinedLoadStates combinedLoadStates = (CombinedLoadStates) p0;
                return Intrinsics.areEqual(this.getAuthRequestContext, combinedLoadStates.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, combinedLoadStates.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, combinedLoadStates.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, combinedLoadStates.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, combinedLoadStates.BuiltInFictitiousFunctionClassFactory);
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.paging.CombinedLoadStates");
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.getAuthRequestContext.hashCode();
        int hashCode2 = this.PlaceComponentResult.hashCode();
        int hashCode3 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        int hashCode4 = this.MyBillsEntityDataFactory.hashCode();
        LoadStates loadStates = this.BuiltInFictitiousFunctionClassFactory;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (loadStates == null ? 0 : loadStates.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CombinedLoadStates(refresh=");
        sb.append(this.getAuthRequestContext);
        sb.append(", prepend=");
        sb.append(this.PlaceComponentResult);
        sb.append(", append=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", source=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", mediator=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }
}
