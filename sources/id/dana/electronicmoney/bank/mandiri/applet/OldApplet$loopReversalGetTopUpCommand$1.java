package id.dana.electronicmoney.bank.mandiri.applet;

import id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.electronicmoney.bank.mandiri.applet.OldApplet", f = "OldApplet.kt", i = {0, 0, 0, 1, 2}, l = {169, 192, 219}, m = "loopReversalGetTopUpCommand", n = {"this", "result", "counter", "this", "this"}, s = {"L$0", "L$1", "I$0", "L$0", "L$0"})
/* loaded from: classes8.dex */
public final class OldApplet$loopReversalGetTopUpCommand$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OldApplet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OldApplet$loopReversalGetTopUpCommand$1(OldApplet oldApplet, Continuation<? super OldApplet$loopReversalGetTopUpCommand$1> continuation) {
        super(continuation);
        this.this$0 = oldApplet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object BuiltInFictitiousFunctionClassFactory;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        BuiltInFictitiousFunctionClassFactory = this.this$0.BuiltInFictitiousFunctionClassFactory(0, (EmoneyApiResult) null, this);
        return BuiltInFictitiousFunctionClassFactory;
    }
}
