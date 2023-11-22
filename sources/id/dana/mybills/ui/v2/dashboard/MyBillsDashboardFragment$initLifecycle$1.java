package id.dana.mybills.ui.v2.dashboard;

import androidx.core.widget.NestedScrollView;
import id.dana.mybills.databinding.FragmentMyBillsDashboardBinding;
import id.dana.mybills.ui.v2.MyBillsUiState;
import id.dana.utils.foundation.logger.log.DanaLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$initLifecycle$1", f = "MyBillsDashboardFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class MyBillsDashboardFragment$initLifecycle$1 extends SuspendLambda implements Function2<MyBillsUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MyBillsDashboardFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyBillsDashboardFragment$initLifecycle$1(MyBillsDashboardFragment myBillsDashboardFragment, Continuation<? super MyBillsDashboardFragment$initLifecycle$1> continuation) {
        super(2, continuation);
        this.this$0 = myBillsDashboardFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MyBillsDashboardFragment$initLifecycle$1 myBillsDashboardFragment$initLifecycle$1 = new MyBillsDashboardFragment$initLifecycle$1(this.this$0, continuation);
        myBillsDashboardFragment$initLifecycle$1.L$0 = obj;
        return myBillsDashboardFragment$initLifecycle$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MyBillsUiState myBillsUiState, Continuation<? super Unit> continuation) {
        return ((MyBillsDashboardFragment$initLifecycle$1) create(myBillsUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MyBillsUiState myBillsUiState = (MyBillsUiState) this.L$0;
            if (myBillsUiState instanceof MyBillsUiState.OnSuccessGetCurrentBalance) {
                MyBillsDashboardFragment.getAuthRequestContext(this.this$0, (MyBillsUiState.OnSuccessGetCurrentBalance) myBillsUiState);
            } else if (myBillsUiState instanceof MyBillsUiState.OnSuccessGetDanaCicilLink) {
                this.this$0.getAuthRequestContext = ((MyBillsUiState.OnSuccessGetDanaCicilLink) myBillsUiState).KClassImpl$Data$declaredNonStaticMembers$2;
                MyBillsDashboardFragment myBillsDashboardFragment = this.this$0;
                str = myBillsDashboardFragment.getAuthRequestContext;
                MyBillsDashboardFragment.PlaceComponentResult(myBillsDashboardFragment, str);
            } else if (myBillsUiState instanceof MyBillsUiState.OnFailedGetConsultView) {
                try {
                    VB vb = this.this$0.PlaceComponentResult;
                    if (vb != 0) {
                        NestedScrollView nestedScrollView = ((FragmentMyBillsDashboardBinding) vb).PrepareContext;
                        VB vb2 = this.this$0.PlaceComponentResult;
                        if (vb2 != 0) {
                            nestedScrollView.smoothScrollTo(0, ((FragmentMyBillsDashboardBinding) vb2).GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2.getBottom() / 2);
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } catch (Exception e) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory(this.this$0.getClass().getSimpleName(), e.getMessage());
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
