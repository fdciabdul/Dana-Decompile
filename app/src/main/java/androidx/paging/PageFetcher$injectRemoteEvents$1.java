package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0003H\u008a@"}, d2 = {"", "Key", "Value", "Landroidx/paging/SimpleProducerScope;", "Landroidx/paging/PageEvent;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.PageFetcher$injectRemoteEvents$1", f = "PageFetcher.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class PageFetcher$injectRemoteEvents$1<Value> extends SuspendLambda implements Function2<SimpleProducerScope<PageEvent<Value>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ RemoteMediatorAccessor<Key, Value> $accessor;
    final /* synthetic */ MutableLoadStateCollection $sourceStates;
    final /* synthetic */ PageFetcherSnapshot<Key, Value> $this_injectRemoteEvents;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcher$injectRemoteEvents$1(RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor, PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, MutableLoadStateCollection mutableLoadStateCollection, Continuation<? super PageFetcher$injectRemoteEvents$1> continuation) {
        super(2, continuation);
        this.$accessor = remoteMediatorAccessor;
        this.$this_injectRemoteEvents = pageFetcherSnapshot;
        this.$sourceStates = mutableLoadStateCollection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PageFetcher$injectRemoteEvents$1 pageFetcher$injectRemoteEvents$1 = new PageFetcher$injectRemoteEvents$1(this.$accessor, this.$this_injectRemoteEvents, this.$sourceStates, continuation);
        pageFetcher$injectRemoteEvents$1.L$0 = obj;
        return pageFetcher$injectRemoteEvents$1;
    }

    public final Object invoke(SimpleProducerScope<PageEvent<Value>> simpleProducerScope, Continuation<? super Unit> continuation) {
        return ((PageFetcher$injectRemoteEvents$1) create(simpleProducerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((SimpleProducerScope) ((SimpleProducerScope) obj), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.L$0;
            this.label = 1;
            if (SimpleChannelFlowKt.BuiltInFictitiousFunctionClassFactory(new PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1(this.$accessor.getAuthRequestContext(), this.$this_injectRemoteEvents.getErrorConfigVersion, null, this.$sourceStates)).collect(new FlowCollector<PageEvent<Value>>() { // from class: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(PageEvent<Value> pageEvent, Continuation<? super Unit> continuation) {
                    Object send = SimpleProducerScope.this.send(pageEvent, continuation);
                    return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
