package id.dana.electronicmoney.bank.mandiri.applet;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.electronicmoney.bank.mandiri.applet.CardApplet", f = "CardApplet.kt", i = {0, 0, 1}, l = {164, 167}, m = "writeToCardSuccess", n = {"this", "inquiry", "this"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes8.dex */
public final class CardApplet$writeToCardSuccess$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CardApplet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardApplet$writeToCardSuccess$1(CardApplet cardApplet, Continuation<? super CardApplet$writeToCardSuccess$1> continuation) {
        super(continuation);
        this.this$0 = cardApplet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object authRequestContext;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        authRequestContext = this.this$0.getAuthRequestContext(null, null, this);
        return authRequestContext;
    }
}
