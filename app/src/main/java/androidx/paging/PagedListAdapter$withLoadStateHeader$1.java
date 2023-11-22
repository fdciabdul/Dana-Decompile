package androidx.paging;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/paging/LoadType;", GriverMonitorConstants.KEY_LOAD_TYPE, "Landroidx/paging/LoadState;", "loadState", "", BridgeDSL.INVOKE, "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class PagedListAdapter$withLoadStateHeader$1 extends Lambda implements Function2<LoadType, LoadState, Unit> {
    final /* synthetic */ LoadStateAdapter<?> $$header;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagedListAdapter$withLoadStateHeader$1(LoadStateAdapter<?> loadStateAdapter) {
        super(2);
        this.$$header = loadStateAdapter;
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
        if (loadType == LoadType.PREPEND) {
            this.$$header.MyBillsEntityDataFactory(loadState);
        }
    }
}
