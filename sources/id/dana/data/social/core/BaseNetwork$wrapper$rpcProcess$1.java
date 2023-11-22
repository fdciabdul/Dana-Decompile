package id.dana.data.social.core;

import id.dana.domain.extension.CoroutinesExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002H\u008a@"}, d2 = {"Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "S", "T", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.data.social.core.BaseNetwork$wrapper$rpcProcess$1", f = "BaseNetwork.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class BaseNetwork$wrapper$rpcProcess$1<S> extends SuspendLambda implements Function1<Continuation<? super S>, Object> {
    final /* synthetic */ Function1<T, S> $processFacade;
    int label;
    final /* synthetic */ BaseNetwork<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseNetwork$wrapper$rpcProcess$1(Function1<? super T, ? extends S> function1, BaseNetwork<T> baseNetwork, Continuation<? super BaseNetwork$wrapper$rpcProcess$1> continuation) {
        super(1, continuation);
        this.$processFacade = function1;
        this.this$0 = baseNetwork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new BaseNetwork$wrapper$rpcProcess$1(this.$processFacade, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((Continuation) ((Continuation) obj));
    }

    public final Object invoke(Continuation<? super S> continuation) {
        return ((BaseNetwork$wrapper$rpcProcess$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = CoroutinesExtKt.await(this.$processFacade.invoke(this.this$0.getCastedFacade()), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
