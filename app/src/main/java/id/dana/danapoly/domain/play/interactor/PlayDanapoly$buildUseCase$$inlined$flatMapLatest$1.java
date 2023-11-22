package id.dana.danapoly.domain.play.interactor;

import id.dana.danapoly.domain.play.DanapolyPlayRepository;
import id.dana.danapoly.domain.play.model.RollDice;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@¨\u0006\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.danapoly.domain.play.interactor.PlayDanapoly$buildUseCase$$inlined$flatMapLatest$1", f = "PlayDanapoly.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class PlayDanapoly$buildUseCase$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super RollDice>, String, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ PlayDanapoly this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayDanapoly$buildUseCase$$inlined$flatMapLatest$1(Continuation continuation, PlayDanapoly playDanapoly) {
        super(3, continuation);
        this.this$0 = playDanapoly;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super RollDice> flowCollector, String str, Continuation<? super Unit> continuation) {
        PlayDanapoly$buildUseCase$$inlined$flatMapLatest$1 playDanapoly$buildUseCase$$inlined$flatMapLatest$1 = new PlayDanapoly$buildUseCase$$inlined$flatMapLatest$1(continuation, this.this$0);
        playDanapoly$buildUseCase$$inlined$flatMapLatest$1.L$0 = flowCollector;
        playDanapoly$buildUseCase$$inlined$flatMapLatest$1.L$1 = str;
        return playDanapoly$buildUseCase$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DanapolyPlayRepository danapolyPlayRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            String str = (String) this.L$1;
            danapolyPlayRepository = this.this$0.MyBillsEntityDataFactory;
            Flow<RollDice> authRequestContext = danapolyPlayRepository.getAuthRequestContext(str);
            this.label = 1;
            if (FlowKt.emitAll(flowCollector, authRequestContext, this) == coroutine_suspended) {
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
