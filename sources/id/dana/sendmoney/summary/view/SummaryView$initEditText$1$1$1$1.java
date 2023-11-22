package id.dana.sendmoney.summary.view;

import id.dana.contract.sendmoney.SendMoneyContract;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.domain.sendmoney.model.SmartFrictionConfig;
import id.dana.sendmoney.summary.view.SummaryView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "amount", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.summary.view.SummaryView$initEditText$1$1$1$1", f = "SummaryView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class SummaryView$initEditText$1$1$1$1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ CurrencyEditText $this_run;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SummaryView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SummaryView$initEditText$1$1$1$1(SummaryView summaryView, CurrencyEditText currencyEditText, Continuation<? super SummaryView$initEditText$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = summaryView;
        this.$this_run = currencyEditText;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SummaryView$initEditText$1$1$1$1 summaryView$initEditText$1$1$1$1 = new SummaryView$initEditText$1$1$1$1(this.this$0, this.$this_run, continuation);
        summaryView$initEditText$1$1$1$1.L$0 = obj;
        return summaryView$initEditText$1$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((SummaryView$initEditText$1$1$1$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SummaryView.SummaryListener summaryListener;
        SmartFrictionConfig smartFrictionConfig;
        String str;
        SmartFrictionConfig smartFrictionConfig2;
        String str2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str3 = (String) this.L$0;
            if (str3.length() == 0) {
                str3 = "Rp0";
            }
            String str4 = str3;
            this.this$0.MyBillsEntityDataFactory = StringsKt.replace$default(StringsKt.replace$default(str4, this.$this_run.getPrefix(), "", false, 4, (Object) null), ".", "", false, 4, (Object) null);
            summaryListener = this.this$0.KClassImpl$Data$declaredNonStaticMembers$2;
            if (summaryListener != null) {
                str2 = this.this$0.MyBillsEntityDataFactory;
                summaryListener.BuiltInFictitiousFunctionClassFactory(str4, str2);
            }
            if (this.this$0.presenter != null) {
                smartFrictionConfig = this.this$0.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (smartFrictionConfig != null) {
                    SendMoneyContract.Presenter presenter = this.this$0.getPresenter();
                    str = this.this$0.MyBillsEntityDataFactory;
                    smartFrictionConfig2 = this.this$0.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (smartFrictionConfig2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        smartFrictionConfig2 = null;
                    }
                    presenter.MyBillsEntityDataFactory(str, smartFrictionConfig2.getReachLimit());
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
