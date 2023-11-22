package id.dana.electronicmoney.bank.mandiri.applet;

import id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.electronicmoney.bank.mandiri.applet.OldApplet", f = "OldApplet.kt", i = {0, 1, 2, 3}, l = {126, 126, 126, 128}, m = "updateBalance", n = {"this", "this", "this", "this"}, s = {"L$0", "L$0", "L$0", "L$0"})
/* loaded from: classes8.dex */
final class OldApplet$updateBalance$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OldApplet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OldApplet$updateBalance$1(OldApplet oldApplet, Continuation<? super OldApplet$updateBalance$1> continuation) {
        super(continuation);
        this.this$0 = oldApplet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.KClassImpl$Data$declaredNonStaticMembers$2((EmoneyApiResult) null, this);
    }
}
