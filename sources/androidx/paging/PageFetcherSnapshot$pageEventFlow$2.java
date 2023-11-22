package androidx.paging;

import androidx.paging.PageEvent;
import androidx.paging.PageFetcherSnapshotState;
import com.alibaba.wireless.security.SecExceptionCode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [Value] */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0003H\u008a@"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/paging/PageEvent;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$2", f = "PageFetcherSnapshot.kt", i = {0, 0}, l = {SecExceptionCode.SEC_ERROR_SIGNATURE_NO_DATA_FILE, 174}, m = "invokeSuspend", n = {"this_$iv", "$this$withLock_u24default$iv$iv"}, s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
public final class PageFetcherSnapshot$pageEventFlow$2<Value> extends SuspendLambda implements Function2<FlowCollector<? super PageEvent<Value>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$pageEventFlow$2(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Continuation<? super PageFetcherSnapshot$pageEventFlow$2> continuation) {
        super(2, continuation);
        this.this$0 = pageFetcherSnapshot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PageFetcherSnapshot$pageEventFlow$2 pageFetcherSnapshot$pageEventFlow$2 = new PageFetcherSnapshot$pageEventFlow$2(this.this$0, continuation);
        pageFetcherSnapshot$pageEventFlow$2.L$0 = obj;
        return pageFetcherSnapshot$pageEventFlow$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((FlowCollector) ((FlowCollector) obj), continuation);
    }

    public final Object invoke(FlowCollector<? super PageEvent<Value>> flowCollector, Continuation<? super Unit> continuation) {
        return ((PageFetcherSnapshot$pageEventFlow$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, androidx.paging.LoadStates] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        PageFetcherSnapshotState.Holder holder;
        Mutex mutex;
        Mutex mutex2;
        PageFetcherSnapshotState pageFetcherSnapshotState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 2;
        ?? r4 = 0;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                holder = ((PageFetcherSnapshot) this.this$0).NetworkUserEntityData$$ExternalSyntheticLambda1;
                mutex = holder.MyBillsEntityDataFactory;
                this.L$0 = holder;
                this.L$1 = mutex;
                this.L$2 = flowCollector;
                this.label = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex2 = mutex;
            } else if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                flowCollector = (FlowCollector) this.L$2;
                mutex2 = (Mutex) this.L$1;
                holder = (PageFetcherSnapshotState.Holder) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pageFetcherSnapshotState = holder.PlaceComponentResult;
            MutableLoadStateCollection mutableLoadStateCollection = pageFetcherSnapshotState.GetContactSyncConfig;
            LoadStates loadStates = new LoadStates(mutableLoadStateCollection.PlaceComponentResult, mutableLoadStateCollection.MyBillsEntityDataFactory, mutableLoadStateCollection.BuiltInFictitiousFunctionClassFactory);
            mutex2.unlock(null);
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (flowCollector.emit(new PageEvent.LoadStateUpdate(loadStates, r4, i2, r4), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex2.unlock(null);
            throw th;
        }
    }
}
