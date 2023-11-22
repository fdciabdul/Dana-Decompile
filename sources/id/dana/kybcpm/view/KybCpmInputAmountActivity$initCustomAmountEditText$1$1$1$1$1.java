package id.dana.kybcpm.view;

import id.dana.core.ui.richview.CurrencyEditText;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "amount", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.kybcpm.view.KybCpmInputAmountActivity$initCustomAmountEditText$1$1$1$1$1", f = "KybCpmInputAmountActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class KybCpmInputAmountActivity$initCustomAmountEditText$1$1$1$1$1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ CurrencyEditText $this_run;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KybCpmInputAmountActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KybCpmInputAmountActivity$initCustomAmountEditText$1$1$1$1$1(KybCpmInputAmountActivity kybCpmInputAmountActivity, CurrencyEditText currencyEditText, Continuation<? super KybCpmInputAmountActivity$initCustomAmountEditText$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = kybCpmInputAmountActivity;
        this.$this_run = currencyEditText;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        KybCpmInputAmountActivity$initCustomAmountEditText$1$1$1$1$1 kybCpmInputAmountActivity$initCustomAmountEditText$1$1$1$1$1 = new KybCpmInputAmountActivity$initCustomAmountEditText$1$1$1$1$1(this.this$0, this.$this_run, continuation);
        kybCpmInputAmountActivity$initCustomAmountEditText$1$1$1$1$1.L$0 = obj;
        return kybCpmInputAmountActivity$initCustomAmountEditText$1$1$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((KybCpmInputAmountActivity$initCustomAmountEditText$1$1$1$1$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            if (str.length() == 0) {
                str = "Rp0";
            }
            this.this$0.KClassImpl$Data$declaredNonStaticMembers$2 = StringsKt.replace$default(StringsKt.replace$default(str, this.$this_run.getPrefix(), "", false, 4, (Object) null), ".", "", false, 4, (Object) null);
            z = this.this$0.BuiltInFictitiousFunctionClassFactory;
            if (!z) {
                KybCpmInputAmountActivity.access$checkAmountValidation(this.this$0);
            }
            this.this$0.BuiltInFictitiousFunctionClassFactory = false;
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
