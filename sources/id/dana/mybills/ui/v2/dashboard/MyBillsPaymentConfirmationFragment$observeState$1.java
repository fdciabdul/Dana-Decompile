package id.dana.mybills.ui.v2.dashboard;

import androidx.fragment.app.FragmentActivity;
import id.dana.analytics.executiontime.TrackerExecutionCounter;
import id.dana.core.ui.util.DANAToast;
import id.dana.mybills.R;
import id.dana.mybills.ui.v2.MyBillsHomeActivity;
import id.dana.mybills.ui.v2.MyBillsUiState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment$observeState$1", f = "MyBillsPaymentConfirmationFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes9.dex */
final class MyBillsPaymentConfirmationFragment$observeState$1 extends SuspendLambda implements Function2<MyBillsUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MyBillsPaymentConfirmationFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyBillsPaymentConfirmationFragment$observeState$1(MyBillsPaymentConfirmationFragment myBillsPaymentConfirmationFragment, Continuation<? super MyBillsPaymentConfirmationFragment$observeState$1> continuation) {
        super(2, continuation);
        this.this$0 = myBillsPaymentConfirmationFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MyBillsPaymentConfirmationFragment$observeState$1 myBillsPaymentConfirmationFragment$observeState$1 = new MyBillsPaymentConfirmationFragment$observeState$1(this.this$0, continuation);
        myBillsPaymentConfirmationFragment$observeState$1.L$0 = obj;
        return myBillsPaymentConfirmationFragment$observeState$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MyBillsUiState myBillsUiState, Continuation<? super Unit> continuation) {
        return ((MyBillsPaymentConfirmationFragment$observeState$1) create(myBillsUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TrackerExecutionCounter trackerExecutionCounter;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MyBillsUiState myBillsUiState = (MyBillsUiState) this.L$0;
            ((MyBillsHomeActivity) this.this$0.requireActivity()).hideBlockerLoading();
            if (myBillsUiState instanceof MyBillsUiState.OnResultBulkPayAction) {
                MyBillsPaymentConfirmationFragment.getAuthRequestContext(this.this$0, (MyBillsUiState.OnResultBulkPayAction) myBillsUiState);
            } else if (myBillsUiState instanceof MyBillsUiState.OnErrorGetPayTransaction) {
                trackerExecutionCounter = this.this$0.scheduleImpl;
                trackerExecutionCounter.initiateEndTime();
                DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
                FragmentActivity requireActivity = this.this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "");
                String string = this.this$0.getString(R.string.mybills_failed_pay_transaction);
                Intrinsics.checkNotNullExpressionValue(string, "");
                DANAToast.MyBillsEntityDataFactory(requireActivity, string, "");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
