package id.dana.electronicmoney.bank.mandiri;

import id.dana.electronicmoney.BalanceResult;
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
@DebugMetadata(c = "id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager$updateAndReadBalance$lambda-3$$inlined$postToUi$1", f = "MandiriEmoneyManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager$updateAndReadBalance$lambda-3$$inlined$postToUi$1  reason: invalid class name */
/* loaded from: classes2.dex */
public final class MandiriEmoneyManager$updateAndReadBalance$lambda3$$inlined$postToUi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ElectronicMoneyCallback $callback$inlined;
    final /* synthetic */ BalanceResult $result$inlined;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MandiriEmoneyManager$updateAndReadBalance$lambda3$$inlined$postToUi$1(Continuation continuation, ElectronicMoneyCallback electronicMoneyCallback, BalanceResult balanceResult) {
        super(2, continuation);
        this.$callback$inlined = electronicMoneyCallback;
        this.$result$inlined = balanceResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MandiriEmoneyManager$updateAndReadBalance$lambda3$$inlined$postToUi$1(continuation, this.$callback$inlined, this.$result$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MandiriEmoneyManager$updateAndReadBalance$lambda3$$inlined$postToUi$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$callback$inlined.MyBillsEntityDataFactory(this.$result$inlined);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
