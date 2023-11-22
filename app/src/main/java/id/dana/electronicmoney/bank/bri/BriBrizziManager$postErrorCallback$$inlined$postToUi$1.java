package id.dana.electronicmoney.bank.bri;

import id.co.bri.brizzi.exception.BrizziException;
import id.dana.electronicmoney.ElectronicMoneyCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u008a@¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "com/anggrayudi/storage/extension/CoroutineExtKt$postToUi$1", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.electronicmoney.bank.bri.BriBrizziManager$postErrorCallback$$inlined$postToUi$1", f = "BriBrizziManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class BriBrizziManager$postErrorCallback$$inlined$postToUi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ElectronicMoneyCallback $callback$inlined;
    final /* synthetic */ BrizziException $ex$inlined;
    int label;
    final /* synthetic */ BriBrizziManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BriBrizziManager$postErrorCallback$$inlined$postToUi$1(Continuation continuation, ElectronicMoneyCallback electronicMoneyCallback, BrizziException brizziException, BriBrizziManager briBrizziManager) {
        super(2, continuation);
        this.$callback$inlined = electronicMoneyCallback;
        this.$ex$inlined = brizziException;
        this.this$0 = briBrizziManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BriBrizziManager$postErrorCallback$$inlined$postToUi$1(continuation, this.$callback$inlined, this.$ex$inlined, this.this$0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BriBrizziManager$postErrorCallback$$inlined$postToUi$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ElectronicMoneyCallback electronicMoneyCallback = this.$callback$inlined;
            BrizziException brizziException = this.$ex$inlined;
            electronicMoneyCallback.BuiltInFictitiousFunctionClassFactory(brizziException != null ? BriBrizziManager.PlaceComponentResult(brizziException) : null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
