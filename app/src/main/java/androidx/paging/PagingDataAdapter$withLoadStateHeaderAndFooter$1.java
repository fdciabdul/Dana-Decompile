package androidx.paging;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/paging/CombinedLoadStates;", "loadStates", "", BridgeDSL.INVOKE, "(Landroidx/paging/CombinedLoadStates;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
final class PagingDataAdapter$withLoadStateHeaderAndFooter$1 extends Lambda implements Function1<CombinedLoadStates, Unit> {
    final /* synthetic */ LoadStateAdapter<?> $$footer;
    final /* synthetic */ LoadStateAdapter<?> $$header;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagingDataAdapter$withLoadStateHeaderAndFooter$1(LoadStateAdapter<?> loadStateAdapter, LoadStateAdapter<?> loadStateAdapter2) {
        super(1);
        this.$$header = loadStateAdapter;
        this.$$footer = loadStateAdapter2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(CombinedLoadStates combinedLoadStates) {
        invoke2(combinedLoadStates);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(CombinedLoadStates combinedLoadStates) {
        Intrinsics.checkNotNullParameter(combinedLoadStates, "");
        this.$$header.MyBillsEntityDataFactory(combinedLoadStates.PlaceComponentResult);
        this.$$footer.MyBillsEntityDataFactory(combinedLoadStates.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
