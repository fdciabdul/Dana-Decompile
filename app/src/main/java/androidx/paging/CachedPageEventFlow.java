package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B#\u0012\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR(\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R(\u0010\u0005\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\r0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013"}, d2 = {"Landroidx/paging/CachedPageEventFlow;", "", "T", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PageEvent;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlinx/coroutines/flow/Flow;", "PlaceComponentResult", "Lkotlinx/coroutines/Job;", "getAuthRequestContext", "Lkotlinx/coroutines/Job;", "MyBillsEntityDataFactory", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlin/collections/IndexedValue;", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroidx/paging/FlattenedPageController;", "Landroidx/paging/FlattenedPageController;", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlinx/coroutines/flow/SharedFlow;", "p0", "Lkotlinx/coroutines/CoroutineScope;", "p1", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CachedPageEventFlow<T> {
    private final MutableSharedFlow<IndexedValue<PageEvent<T>>> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final Flow<PageEvent<T>> PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final SharedFlow<IndexedValue<PageEvent<T>>> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FlattenedPageController<T> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final Job MyBillsEntityDataFactory;

    public CachedPageEventFlow(Flow<? extends PageEvent<T>> flow, CoroutineScope coroutineScope) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(flow, "");
        Intrinsics.checkNotNullParameter(coroutineScope, "");
        this.getAuthRequestContext = new FlattenedPageController<>();
        MutableSharedFlow<IndexedValue<PageEvent<T>>> MutableSharedFlow = SharedFlowKt.MutableSharedFlow(1, Integer.MAX_VALUE, BufferOverflow.SUSPEND);
        this.BuiltInFictitiousFunctionClassFactory = MutableSharedFlow;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = FlowKt.onSubscription(MutableSharedFlow, new CachedPageEventFlow$sharedForDownstream$1(this, null));
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.LAZY, new CachedPageEventFlow$job$1(flow, this, null), 1, null);
        launch$default.invokeOnCompletion(new Function1<Throwable, Unit>(this) { // from class: androidx.paging.CachedPageEventFlow$job$2$1
            final /* synthetic */ CachedPageEventFlow<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableSharedFlow mutableSharedFlow;
                mutableSharedFlow = ((CachedPageEventFlow) this.this$0).BuiltInFictitiousFunctionClassFactory;
                mutableSharedFlow.tryEmit(null);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.MyBillsEntityDataFactory = launch$default;
        this.PlaceComponentResult = FlowKt.flow(new CachedPageEventFlow$downstreamFlow$1(this, null));
    }
}
