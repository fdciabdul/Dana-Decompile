package id.dana.electronicmoney.bank.mandiri.applet;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.electronicmoney.bank.mandiri.applet.CardApplet", f = "CardApplet.kt", i = {0}, l = {207, 208}, m = "doReversal", n = {"this"}, s = {"L$0"})
/* loaded from: classes8.dex */
public final class CardApplet$doReversal$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CardApplet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardApplet$doReversal$1(CardApplet cardApplet, Continuation<? super CardApplet$doReversal$1> continuation) {
        super(continuation);
        this.this$0 = cardApplet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object lookAheadTest;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        lookAheadTest = this.this$0.lookAheadTest(null, this);
        return lookAheadTest;
    }
}
