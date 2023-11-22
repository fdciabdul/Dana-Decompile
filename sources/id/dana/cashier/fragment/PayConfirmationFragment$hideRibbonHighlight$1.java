package id.dana.cashier.fragment;

import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.R;
import id.dana.core.ui.extension.ViewExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayConfirmationFragment$hideRibbonHighlight$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PayConfirmationFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayConfirmationFragment$hideRibbonHighlight$1(PayConfirmationFragment payConfirmationFragment) {
        super(0);
        this.this$0 = payConfirmationFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke */
    public final void invoke2() {
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) this.this$0.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a0e01_getmicroseconds_uwyo8pc);
        if (linearLayoutCompat != null) {
            ViewExtKt.BuiltInFictitiousFunctionClassFactory((View) linearLayoutCompat, false);
        }
    }
}
