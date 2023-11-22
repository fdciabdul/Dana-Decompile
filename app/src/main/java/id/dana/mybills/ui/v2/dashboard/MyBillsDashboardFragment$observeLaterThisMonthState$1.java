package id.dana.mybills.ui.v2.dashboard;

import id.dana.mybills.ui.model.generalize.BillPaginationModel;
import id.dana.mybills.ui.v2.MyBillsUiState;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$observeLaterThisMonthState$1", f = "MyBillsDashboardFragment.kt", i = {}, l = {322}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class MyBillsDashboardFragment$observeLaterThisMonthState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MyBillsDashboardFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyBillsDashboardFragment$observeLaterThisMonthState$1(MyBillsDashboardFragment myBillsDashboardFragment, Continuation<? super MyBillsDashboardFragment$observeLaterThisMonthState$1> continuation) {
        super(2, continuation);
        this.this$0 = myBillsDashboardFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MyBillsDashboardFragment$observeLaterThisMonthState$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MyBillsDashboardFragment$observeLaterThisMonthState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow<MyBillsUiState> stateFlow = MyBillsDashboardFragment.GetContactSyncConfig(this.this$0).NetworkUserEntityData$$ExternalSyntheticLambda3;
            final MyBillsDashboardFragment myBillsDashboardFragment = this.this$0;
            this.label = 1;
            if (stateFlow.collect(new FlowCollector() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$observeLaterThisMonthState$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
                public final Object emit(MyBillsUiState myBillsUiState, Continuation<? super Unit> continuation) {
                    if (myBillsUiState instanceof MyBillsUiState.Loading) {
                        MyBillsDashboardFragment.FragmentBottomSheetPaymentSettingBinding(MyBillsDashboardFragment.this);
                    } else if (myBillsUiState instanceof MyBillsUiState.Success) {
                        MyBillsDashboardFragment.NetworkUserEntityData$$ExternalSyntheticLambda8(MyBillsDashboardFragment.this);
                        MyBillsUiState.Success success = (MyBillsUiState.Success) myBillsUiState;
                        if (success.getAuthRequestContext instanceof BillPaginationModel) {
                            MyBillsDashboardFragment.BuiltInFictitiousFunctionClassFactory(MyBillsDashboardFragment.this, (BillPaginationModel) success.getAuthRequestContext);
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }
}
