package id.dana.cashier.fragment;

import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.base.BaseActivity;
import id.dana.pay.PayActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", BridgeDSL.INVOKE, "(Landroid/view/View;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
final class BaseCashierFragment$showOtpLimitedDialog$1$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ BaseCashierFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseCashierFragment$showOtpLimitedDialog$1$1(BaseCashierFragment baseCashierFragment) {
        super(1);
        this.this$0 = baseCashierFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        BaseActivity baseActivity = this.this$0.getBaseActivity();
        if (baseActivity == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.pay.PayActivity");
        }
        ((PayActivity) baseActivity).needToBackHomeOnDestroy(true);
        this.this$0.getBaseActivity().finish();
    }
}
