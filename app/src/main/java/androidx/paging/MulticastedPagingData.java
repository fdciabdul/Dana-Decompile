package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B)\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0011\u0010\u0004\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Landroidx/paging/MulticastedPagingData;", "", "T", "Landroidx/paging/CachedPageEventFlow;", "getAuthRequestContext", "Landroidx/paging/CachedPageEventFlow;", "MyBillsEntityDataFactory", "Landroidx/paging/PagingData;", "Landroidx/paging/PagingData;", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/paging/ActiveFlowTracker;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/paging/ActiveFlowTracker;", "PlaceComponentResult", "p0", "p1", "p2", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/paging/PagingData;Landroidx/paging/ActiveFlowTracker;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class MulticastedPagingData<T> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final CoroutineScope getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final ActiveFlowTracker PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final PagingData<T> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final CachedPageEventFlow<T> MyBillsEntityDataFactory;

    private MulticastedPagingData(CoroutineScope coroutineScope, PagingData<T> pagingData, ActiveFlowTracker activeFlowTracker) {
        Intrinsics.checkNotNullParameter(coroutineScope, "");
        Intrinsics.checkNotNullParameter(pagingData, "");
        this.getAuthRequestContext = coroutineScope;
        this.BuiltInFictitiousFunctionClassFactory = pagingData;
        this.PlaceComponentResult = activeFlowTracker;
        this.MyBillsEntityDataFactory = new CachedPageEventFlow<>(FlowKt.onCompletion(FlowKt.onStart(pagingData.KClassImpl$Data$declaredNonStaticMembers$2, new MulticastedPagingData$accumulated$1(this, null)), new MulticastedPagingData$accumulated$2(this, null)), coroutineScope);
    }

    public /* synthetic */ MulticastedPagingData(CoroutineScope coroutineScope, PagingData pagingData, ActiveFlowTracker activeFlowTracker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, pagingData, (i & 4) != 0 ? null : activeFlowTracker);
    }
}
