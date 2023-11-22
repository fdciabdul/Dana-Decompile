package androidx.paging;

import androidx.paging.PagedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
final /* synthetic */ class AsyncPagedListDiffer$loadStateListener$1 extends FunctionReferenceImpl implements Function2<LoadType, LoadState, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncPagedListDiffer$loadStateListener$1(Object obj) {
        super(2, obj, PagedList.LoadStateManager.class, "KClassImpl$Data$declaredNonStaticMembers$2", "KClassImpl$Data$declaredNonStaticMembers$2(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Unit invoke(LoadType loadType, LoadState loadState) {
        invoke2(loadType, loadState);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(LoadType loadType, LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "");
        Intrinsics.checkNotNullParameter(loadState, "");
        ((PagedList.LoadStateManager) this.receiver).KClassImpl$Data$declaredNonStaticMembers$2(loadType, loadState);
    }
}
