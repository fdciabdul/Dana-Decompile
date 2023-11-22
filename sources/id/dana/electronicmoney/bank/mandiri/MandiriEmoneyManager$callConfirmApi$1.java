package id.dana.electronicmoney.bank.mandiri;

import id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager", f = "MandiriEmoneyManager.kt", i = {0, 0, 1, 1}, l = {314, 374}, m = "callConfirmApi", n = {"this", "card", "this", "card"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes2.dex */
public final class MandiriEmoneyManager$callConfirmApi$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MandiriEmoneyManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MandiriEmoneyManager$callConfirmApi$1(MandiriEmoneyManager mandiriEmoneyManager, Continuation<? super MandiriEmoneyManager$callConfirmApi$1> continuation) {
        super(continuation);
        this.this$0 = mandiriEmoneyManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.BuiltInFictitiousFunctionClassFactory((EmoneyCardAttribute) null, this);
    }
}
