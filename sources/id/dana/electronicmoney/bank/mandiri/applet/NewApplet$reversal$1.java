package id.dana.electronicmoney.bank.mandiri.applet;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.electronicmoney.bank.mandiri.applet.NewApplet", f = "NewApplet.kt", i = {0, 1}, l = {44, 42, 46}, m = "reversal", n = {"this", "this"}, s = {"L$0", "L$0"})
/* loaded from: classes8.dex */
final class NewApplet$reversal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NewApplet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewApplet$reversal$1(NewApplet newApplet, Continuation<? super NewApplet$reversal$1> continuation) {
        super(continuation);
        this.this$0 = newApplet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.BuiltInFictitiousFunctionClassFactory((String) null, this);
    }
}
