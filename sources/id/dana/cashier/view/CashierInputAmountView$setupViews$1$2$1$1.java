package id.dana.cashier.view;

import id.dana.cashier.view.CashierInputAmountView;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "amount", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.cashier.view.CashierInputAmountView$setupViews$1$2$1$1", f = "CashierInputAmountView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class CashierInputAmountView$setupViews$1$2$1$1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ CurrencyEditText $this_apply;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CashierInputAmountView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashierInputAmountView$setupViews$1$2$1$1(CashierInputAmountView cashierInputAmountView, CurrencyEditText currencyEditText, Continuation<? super CashierInputAmountView$setupViews$1$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = cashierInputAmountView;
        this.$this_apply = currencyEditText;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CashierInputAmountView$setupViews$1$2$1$1 cashierInputAmountView$setupViews$1$2$1$1 = new CashierInputAmountView$setupViews$1$2$1$1(this.this$0, this.$this_apply, continuation);
        cashierInputAmountView$setupViews$1$2$1$1.L$0 = obj;
        return cashierInputAmountView$setupViews$1$2$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((CashierInputAmountView$setupViews$1$2$1$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CashierInputAmountView.OnAmountChangeListener onAmountChangeListener;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            CashierInputAmountView cashierInputAmountView = this.this$0;
            CurrencyEditText currencyEditText = this.$this_apply;
            Intrinsics.checkNotNullExpressionValue(currencyEditText, "");
            CashierInputAmountView.access$setClearTextIcon(cashierInputAmountView, currencyEditText, str);
            if (!(str.length() > 0)) {
                onAmountChangeListener = this.this$0.MyBillsEntityDataFactory;
                if (onAmountChangeListener != null) {
                    onAmountChangeListener.getAuthRequestContext();
                }
                CashierInputAmountView.showHelperMessage$default(this.this$0, null, 1, null);
                this.this$0.KClassImpl$Data$declaredNonStaticMembers$2 = false;
            } else {
                CashierInputAmountView.access$validateAmount(this.this$0, new MoneyViewModel(str, null, null, 6, null));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
