package androidx.paging.multicast;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.channels.Channel;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.paging.multicast.StoreRealActor", f = "StoreRealActor.kt", i = {0}, l = {74, 76}, m = "close", n = {"this"}, s = {"L$0"})
/* loaded from: classes6.dex */
final class StoreRealActor$close$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StoreRealActor<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoreRealActor$close$1(StoreRealActor<T> storeRealActor, Continuation<? super StoreRealActor$close$1> continuation) {
        super(continuation);
        this.this$0 = storeRealActor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        StoreRealActor storeRealActor = this.this$0;
        StoreRealActor$close$1 storeRealActor$close$1 = this;
        StoreRealActor$close$1 storeRealActor$close$12 = storeRealActor$close$1;
        int i = storeRealActor$close$12.label;
        if ((i & Integer.MIN_VALUE) != 0) {
            storeRealActor$close$12.label = i - 2147483648;
        } else {
            storeRealActor$close$12 = new StoreRealActor$close$1(storeRealActor, storeRealActor$close$1);
        }
        Object obj2 = storeRealActor$close$12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = storeRealActor$close$12.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            Channel<Object> channel = storeRealActor.BuiltInFictitiousFunctionClassFactory;
            Object obj3 = StoreRealActor.KClassImpl$Data$declaredNonStaticMembers$2;
            storeRealActor$close$12.L$0 = storeRealActor;
            storeRealActor$close$12.label = 1;
            if (channel.send(obj3, storeRealActor$close$12) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(obj2);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            storeRealActor = (StoreRealActor) storeRealActor$close$12.L$0;
            ResultKt.throwOnFailure(obj2);
        }
        CompletableDeferred<Unit> completableDeferred = storeRealActor.getAuthRequestContext;
        storeRealActor$close$12.L$0 = null;
        storeRealActor$close$12.label = 2;
        if (completableDeferred.await(storeRealActor$close$12) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
