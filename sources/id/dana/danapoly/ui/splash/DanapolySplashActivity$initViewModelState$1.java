package id.dana.danapoly.ui.splash;

import id.dana.danapoly.ui.splash.viewmodel.DanapolyConfigUiState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigUiState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.danapoly.ui.splash.DanapolySplashActivity$initViewModelState$1", f = "DanapolySplashActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class DanapolySplashActivity$initViewModelState$1 extends SuspendLambda implements Function2<DanapolyConfigUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DanapolySplashActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanapolySplashActivity$initViewModelState$1(DanapolySplashActivity danapolySplashActivity, Continuation<? super DanapolySplashActivity$initViewModelState$1> continuation) {
        super(2, continuation);
        this.this$0 = danapolySplashActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DanapolySplashActivity$initViewModelState$1 danapolySplashActivity$initViewModelState$1 = new DanapolySplashActivity$initViewModelState$1(this.this$0, continuation);
        danapolySplashActivity$initViewModelState$1.L$0 = obj;
        return danapolySplashActivity$initViewModelState$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DanapolyConfigUiState danapolyConfigUiState, Continuation<? super Unit> continuation) {
        return ((DanapolySplashActivity$initViewModelState$1) create(danapolyConfigUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DanapolyConfigUiState danapolyConfigUiState = (DanapolyConfigUiState) this.L$0;
            if (danapolyConfigUiState instanceof DanapolyConfigUiState.OnSuccessLoadConfiguration) {
                DanapolySplashActivity.access$goToDanapolyBoard(this.this$0, ((DanapolyConfigUiState.OnSuccessLoadConfiguration) danapolyConfigUiState).PlaceComponentResult);
            } else if (danapolyConfigUiState instanceof DanapolyConfigUiState.OnErrorLoadConfiguration) {
                DanapolySplashActivity.goToDanapolyBoard$default(this.this$0, null, 1, null);
            } else if (danapolyConfigUiState instanceof DanapolyConfigUiState.OnEventNotExist) {
                DanapolySplashActivity.access$goToNoEventActivity(this.this$0, ((DanapolyConfigUiState.OnEventNotExist) danapolyConfigUiState).getAuthRequestContext);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
