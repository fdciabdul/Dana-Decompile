package id.dana.cardbinding.data.repository.source.local;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "", "", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.cardbinding.data.repository.source.local.MLKitCardBindingEntityData$getOCRResult$1", f = "MLKitCardBindingEntityData.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class MLKitCardBindingEntityData$getOCRResult$1 extends SuspendLambda implements Function2<ProducerScope<? super List<? extends String>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public MLKitCardBindingEntityData$getOCRResult$1(Continuation<? super MLKitCardBindingEntityData$getOCRResult$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MLKitCardBindingEntityData$getOCRResult$1 mLKitCardBindingEntityData$getOCRResult$1 = new MLKitCardBindingEntityData$getOCRResult$1(continuation);
        mLKitCardBindingEntityData$getOCRResult$1.L$0 = obj;
        return mLKitCardBindingEntityData$getOCRResult$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super List<? extends String>> producerScope, Continuation<? super Unit> continuation) {
        return invoke2((ProducerScope<? super List<String>>) producerScope, continuation);
    }

    /* renamed from: invoke */
    public final Object invoke2(ProducerScope<? super List<String>> producerScope, Continuation<? super Unit> continuation) {
        return ((MLKitCardBindingEntityData$getOCRResult$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() { // from class: id.dana.cardbinding.data.repository.source.local.MLKitCardBindingEntityData$getOCRResult$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke */
                public final void invoke2() {
                    CoroutineScopeKt.cancel$default(producerScope, null, 1, null);
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
