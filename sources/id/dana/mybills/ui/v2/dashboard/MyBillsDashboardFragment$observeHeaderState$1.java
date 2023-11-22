package id.dana.mybills.ui.v2.dashboard;

import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import id.dana.analytics.executiontime.TrackerExecutionCounter;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.mybills.databinding.FragmentMyBillsDashboardBinding;
import id.dana.mybills.domain.model.MonthlyAmountWithConsultView;
import id.dana.mybills.tracker.MyBillsAnalyticTracker;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$observeHeaderState$1", f = "MyBillsDashboardFragment.kt", i = {}, l = {248}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class MyBillsDashboardFragment$observeHeaderState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MyBillsDashboardFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyBillsDashboardFragment$observeHeaderState$1(MyBillsDashboardFragment myBillsDashboardFragment, Continuation<? super MyBillsDashboardFragment$observeHeaderState$1> continuation) {
        super(2, continuation);
        this.this$0 = myBillsDashboardFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MyBillsDashboardFragment$observeHeaderState$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MyBillsDashboardFragment$observeHeaderState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow<MyBillsUiState> stateFlow = MyBillsDashboardFragment.GetContactSyncConfig(this.this$0).FragmentBottomSheetPaymentSettingBinding;
            final MyBillsDashboardFragment myBillsDashboardFragment = this.this$0;
            this.label = 1;
            if (stateFlow.collect(new FlowCollector() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$observeHeaderState$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
                public final Object emit(MyBillsUiState myBillsUiState, Continuation<? super Unit> continuation) {
                    boolean z;
                    TrackerExecutionCounter trackerExecutionCounter;
                    TrackerExecutionCounter trackerExecutionCounter2;
                    if (myBillsUiState instanceof MyBillsUiState.Loading) {
                        MyBillsDashboardFragment.NetworkUserEntityData$$ExternalSyntheticLambda3(MyBillsDashboardFragment.this);
                    } else if (myBillsUiState instanceof MyBillsUiState.Success) {
                        MyBillsDashboardFragment.initRecordTimeStamp(MyBillsDashboardFragment.this);
                        MyBillsUiState.Success success = (MyBillsUiState.Success) myBillsUiState;
                        if (success.getAuthRequestContext instanceof MonthlyAmountWithConsultView) {
                            MyBillsDashboardFragment.MyBillsEntityDataFactory(MyBillsDashboardFragment.this, (MonthlyAmountWithConsultView) success.getAuthRequestContext);
                            VB vb = MyBillsDashboardFragment.this.PlaceComponentResult;
                            if (vb != 0) {
                                FragmentMyBillsDashboardBinding fragmentMyBillsDashboardBinding = (FragmentMyBillsDashboardBinding) vb;
                                LinearLayout linearLayout = fragmentMyBillsDashboardBinding.VerifyPinStateManager$executeRiskChallenge$2$1.MyBillsEntityDataFactory;
                                Intrinsics.checkNotNullExpressionValue(linearLayout, "");
                                linearLayout.setVisibility(8);
                                ConstraintLayout constraintLayout = fragmentMyBillsDashboardBinding.moveToNextValue;
                                Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                                constraintLayout.setVisibility(0);
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        }
                    } else if (myBillsUiState instanceof MyBillsUiState.Error) {
                        MyBillsDashboardFragment.initRecordTimeStamp(MyBillsDashboardFragment.this);
                        VB vb2 = MyBillsDashboardFragment.this.PlaceComponentResult;
                        if (vb2 != 0) {
                            FragmentMyBillsDashboardBinding fragmentMyBillsDashboardBinding2 = (FragmentMyBillsDashboardBinding) vb2;
                            LinearLayout linearLayout2 = fragmentMyBillsDashboardBinding2.VerifyPinStateManager$executeRiskChallenge$2$1.MyBillsEntityDataFactory;
                            Intrinsics.checkNotNullExpressionValue(linearLayout2, "");
                            linearLayout2.setVisibility(0);
                            ConstraintLayout constraintLayout2 = fragmentMyBillsDashboardBinding2.moveToNextValue;
                            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
                            constraintLayout2.setVisibility(8);
                            FirebasePerformanceMonitor MyBillsEntityDataFactory = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
                            Intrinsics.checkNotNullParameter("mybills_qos_performances_header", "");
                            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.remove("mybills_qos_performances_header");
                            z = MyBillsDashboardFragment.this.getErrorConfigVersion;
                            if (z) {
                                trackerExecutionCounter = MyBillsDashboardFragment.this.PrepareContext;
                                trackerExecutionCounter.initiateEndTime();
                                MyBillsAnalyticTracker myBillsAnalyticTracker = MyBillsDashboardFragment.this.myBillsAnalyticTracker;
                                if (myBillsAnalyticTracker == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                    myBillsAnalyticTracker = null;
                                }
                                MyBillsAnalyticTracker myBillsAnalyticTracker2 = myBillsAnalyticTracker;
                                String str = MyBillsDashboardFragment.this.initRecordTimeStamp;
                                trackerExecutionCounter2 = MyBillsDashboardFragment.this.PrepareContext;
                                myBillsAnalyticTracker2.MyBillsEntityDataFactory(str, "Failed", trackerExecutionCounter2.getExecutionTime(), 0);
                                MyBillsDashboardFragment.this.getErrorConfigVersion = false;
                            }
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
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
