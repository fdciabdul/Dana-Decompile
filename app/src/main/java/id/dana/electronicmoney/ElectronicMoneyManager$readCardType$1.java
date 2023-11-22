package id.dana.electronicmoney;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.electronicmoney.ElectronicMoneyManager$readCardType$1", f = "ElectronicMoneyManager.kt", i = {}, l = {49, 50}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class ElectronicMoneyManager$readCardType$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Intent $intent;
    final /* synthetic */ Function1<String, Unit> $onResult;
    Object L$0;
    int label;
    final /* synthetic */ ElectronicMoneyManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ElectronicMoneyManager$readCardType$1(Function1<? super String, Unit> function1, ElectronicMoneyManager electronicMoneyManager, Intent intent, Continuation<? super ElectronicMoneyManager$readCardType$1> continuation) {
        super(2, continuation);
        this.$onResult = function1;
        this.this$0 = electronicMoneyManager;
        this.$intent = intent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ElectronicMoneyManager$readCardType$1(this.$onResult, this.this$0, this.$intent, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ElectronicMoneyManager$readCardType$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0102  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.ElectronicMoneyManager$readCardType$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
