package id.dana.electronicmoney.bank.mandiri;

import id.dana.electronicmoney.activity.ElectronicMoneyActivity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager", f = "MandiriEmoneyManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2}, l = {136, 136, 142}, m = "updateCard", n = {"this", "command", "card", ElectronicMoneyActivity.EXTRA_SOURCE_CLICK, "this", "command", "card", ElectronicMoneyActivity.EXTRA_SOURCE_CLICK, "this"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0"})
/* loaded from: classes2.dex */
public final class MandiriEmoneyManager$updateCard$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MandiriEmoneyManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MandiriEmoneyManager$updateCard$1(MandiriEmoneyManager mandiriEmoneyManager, Continuation<? super MandiriEmoneyManager$updateCard$1> continuation) {
        super(continuation);
        this.this$0 = mandiriEmoneyManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object PlaceComponentResult;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        PlaceComponentResult = this.this$0.PlaceComponentResult(null, null, null, this);
        return PlaceComponentResult;
    }
}
