package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\t\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\t\u001a\u00020\u000e8\u0017X\u0096D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u000f\u001a\u00020\u000e8\u0017X\u0097D¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00018WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0015R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0017"}, d2 = {"Landroidx/paging/SnapshotPagedList;", "", "T", "Landroidx/paging/PagedList;", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "", "p0", "PlaceComponentResult", "(Lkotlin/jvm/functions/Function2;)V", "", "MyBillsEntityDataFactory", "(I)V", "", "BuiltInFictitiousFunctionClassFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "lookAheadTest", "moveToNextValue", "()Ljava/lang/Object;", "getAuthRequestContext", "Landroidx/paging/PagedList;", "<init>", "(Landroidx/paging/PagedList;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class SnapshotPagedList<T> extends PagedList<T> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final PagedList<T> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.paging.PagedList
    public final void MyBillsEntityDataFactory(int p0) {
    }

    @Override // androidx.paging.PagedList
    public final void PlaceComponentResult(Function2<? super LoadType, ? super LoadState, Unit> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotPagedList(PagedList<T> pagedList) {
        super(pagedList.MyBillsEntityDataFactory(), pagedList.getKClassImpl$Data$declaredNonStaticMembers$2(), pagedList.getNetworkUserEntityData$$ExternalSyntheticLambda0(), new PagedStorage(pagedList.NetworkUserEntityData$$ExternalSyntheticLambda2), pagedList.getBuiltInFictitiousFunctionClassFactory());
        Intrinsics.checkNotNullParameter(pagedList, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = pagedList;
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.PlaceComponentResult = true;
    }

    @Override // androidx.paging.PagedList
    @JvmName(name = "moveToNextValue")
    /* renamed from: moveToNextValue  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.paging.PagedList
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final Object BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // androidx.paging.PagedList
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }
}
