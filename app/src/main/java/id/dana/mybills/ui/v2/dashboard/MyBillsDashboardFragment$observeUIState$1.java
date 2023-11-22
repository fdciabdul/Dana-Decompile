package id.dana.mybills.ui.v2.dashboard;

import androidx.view.Lifecycle;
import androidx.view.LifecycleDestroyedException;
import androidx.view.WithLifecycleStateKt;
import com.alibaba.wireless.security.SecExceptionCode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$observeUIState$1", f = "MyBillsDashboardFragment.kt", i = {}, l = {SecExceptionCode.SEC_ERROE_OPENSDK_INVALID_PARAM}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class MyBillsDashboardFragment$observeUIState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MyBillsDashboardFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyBillsDashboardFragment$observeUIState$1(MyBillsDashboardFragment myBillsDashboardFragment, Continuation<? super MyBillsDashboardFragment$observeUIState$1> continuation) {
        super(2, continuation);
        this.this$0 = myBillsDashboardFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MyBillsDashboardFragment$observeUIState$1 myBillsDashboardFragment$observeUIState$1 = new MyBillsDashboardFragment$observeUIState$1(this.this$0, continuation);
        myBillsDashboardFragment$observeUIState$1.L$0 = obj;
        return myBillsDashboardFragment$observeUIState$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MyBillsDashboardFragment$observeUIState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final MyBillsDashboardFragment myBillsDashboardFragment = this.this$0;
            Lifecycle lifecycle = myBillsDashboardFragment.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "");
            Lifecycle.State state = Lifecycle.State.STARTED;
            MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
            boolean isDispatchNeeded = immediate.isDispatchNeeded(getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.PlaceComponentResult() == Lifecycle.State.DESTROYED) {
                    throw new LifecycleDestroyedException();
                }
                if (lifecycle.PlaceComponentResult().compareTo(state) >= 0) {
                    BuildersKt.launch$default(coroutineScope, null, null, new MyBillsDashboardFragment$observeHeaderState$1(myBillsDashboardFragment, null), 3, null);
                    BuildersKt.launch$default(coroutineScope, null, null, new MyBillsDashboardFragment$observeDueSoonState$1(myBillsDashboardFragment, null), 3, null);
                    BuildersKt.launch$default(coroutineScope, null, null, new MyBillsDashboardFragment$observeLaterThisMonthState$1(myBillsDashboardFragment, null), 3, null);
                    BuildersKt.launch$default(coroutineScope, null, null, new MyBillsDashboardFragment$observeNextMonthState$1(myBillsDashboardFragment, null), 3, null);
                    BuildersKt.launch$default(coroutineScope, null, null, new MyBillsDashboardFragment$observePastDueState$1(myBillsDashboardFragment, null), 3, null);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MyBillsDashboardFragment$observeUIState$1$1$1(myBillsDashboardFragment, null), 3, null);
                    Unit unit = Unit.INSTANCE;
                }
            }
            this.label = 1;
            if (WithLifecycleStateKt.getAuthRequestContext(lifecycle, state, isDispatchNeeded, immediate, new Function0<Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$observeUIState$1$invokeSuspend$$inlined$withStarted$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    BuildersKt.launch$default(coroutineScope, null, null, new MyBillsDashboardFragment$observeHeaderState$1(MyBillsDashboardFragment.this, null), 3, null);
                    BuildersKt.launch$default(coroutineScope, null, null, new MyBillsDashboardFragment$observeDueSoonState$1(MyBillsDashboardFragment.this, null), 3, null);
                    BuildersKt.launch$default(coroutineScope, null, null, new MyBillsDashboardFragment$observeLaterThisMonthState$1(MyBillsDashboardFragment.this, null), 3, null);
                    BuildersKt.launch$default(coroutineScope, null, null, new MyBillsDashboardFragment$observeNextMonthState$1(MyBillsDashboardFragment.this, null), 3, null);
                    BuildersKt.launch$default(coroutineScope, null, null, new MyBillsDashboardFragment$observePastDueState$1(MyBillsDashboardFragment.this, null), 3, null);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MyBillsDashboardFragment$observeUIState$1$1$1(MyBillsDashboardFragment.this, null), 3, null);
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
