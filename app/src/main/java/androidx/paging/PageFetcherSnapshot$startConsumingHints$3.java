package androidx.paging;

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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$3", f = "PageFetcherSnapshot.kt", i = {0, 0}, l = {SecExceptionCode.SEC_ERROR_SIGNATURE_NO_DATA_FILE, 234}, m = "invokeSuspend", n = {"this_$iv", "$this$withLock_u24default$iv$iv"}, s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
public final class PageFetcherSnapshot$startConsumingHints$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$startConsumingHints$3(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Continuation<? super PageFetcherSnapshot$startConsumingHints$3> continuation) {
        super(2, continuation);
        this.this$0 = pageFetcherSnapshot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageFetcherSnapshot$startConsumingHints$3(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PageFetcherSnapshot$startConsumingHints$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PageFetcherSnapshot pageFetcherSnapshot;
        PageFetcherSnapshotState.Holder holder;
        Mutex mutex;
        Mutex mutex2;
        PageFetcherSnapshotState pageFetcherSnapshotState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                pageFetcherSnapshot = this.this$0;
                holder = pageFetcherSnapshot.NetworkUserEntityData$$ExternalSyntheticLambda1;
                mutex = holder.MyBillsEntityDataFactory;
                this.L$0 = holder;
                this.L$1 = mutex;
                this.L$2 = pageFetcherSnapshot;
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
                pageFetcherSnapshot = (PageFetcherSnapshot) this.L$2;
                mutex2 = (Mutex) this.L$1;
                holder = (PageFetcherSnapshotState.Holder) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pageFetcherSnapshotState = holder.PlaceComponentResult;
            Flow onStart = FlowKt.onStart(FlowKt.consumeAsFlow(pageFetcherSnapshotState.KClassImpl$Data$declaredNonStaticMembers$2), new PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1(pageFetcherSnapshotState, null));
            mutex2.unlock(null);
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (PageFetcherSnapshot.KClassImpl$Data$declaredNonStaticMembers$2(pageFetcherSnapshot, onStart, LoadType.APPEND, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex2.unlock(null);
            throw th;
        }
    }
}
