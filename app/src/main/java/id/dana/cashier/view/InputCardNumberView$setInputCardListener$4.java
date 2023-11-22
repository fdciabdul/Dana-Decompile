package id.dana.cashier.view;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.cashier.view.InputCardNumberView$setInputCardListener$4", f = "InputCardNumberView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class InputCardNumberView$setInputCardListener$4 extends SuspendLambda implements Function2<CharSequence, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $inputCardChangedListener;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InputCardNumberView$setInputCardListener$4(Function1<? super String, Unit> function1, Continuation<? super InputCardNumberView$setInputCardListener$4> continuation) {
        super(2, continuation);
        this.$inputCardChangedListener = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InputCardNumberView$setInputCardListener$4 inputCardNumberView$setInputCardListener$4 = new InputCardNumberView$setInputCardListener$4(this.$inputCardChangedListener, continuation);
        inputCardNumberView$setInputCardListener$4.L$0 = obj;
        return inputCardNumberView$setInputCardListener$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CharSequence charSequence, Continuation<? super Unit> continuation) {
        return ((InputCardNumberView$setInputCardListener$4) create(charSequence, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CharSequence charSequence = (CharSequence) this.L$0;
            if (charSequence.length() >= 6) {
                this.$inputCardChangedListener.invoke(charSequence.toString());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
