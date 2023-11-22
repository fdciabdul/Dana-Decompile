package id.dana.danapoly.ui.board;

import id.dana.danapoly.ui.board.viewmodel.DanapolyBoardUiState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardUiState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.danapoly.ui.board.DanapolyBoardTabActivity$initViewModel$1", f = "DanapolyBoardTabActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class DanapolyBoardTabActivity$initViewModel$1 extends SuspendLambda implements Function2<DanapolyBoardUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DanapolyBoardTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanapolyBoardTabActivity$initViewModel$1(DanapolyBoardTabActivity danapolyBoardTabActivity, Continuation<? super DanapolyBoardTabActivity$initViewModel$1> continuation) {
        super(2, continuation);
        this.this$0 = danapolyBoardTabActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DanapolyBoardTabActivity$initViewModel$1 danapolyBoardTabActivity$initViewModel$1 = new DanapolyBoardTabActivity$initViewModel$1(this.this$0, continuation);
        danapolyBoardTabActivity$initViewModel$1.L$0 = obj;
        return danapolyBoardTabActivity$initViewModel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DanapolyBoardUiState danapolyBoardUiState, Continuation<? super Unit> continuation) {
        return ((DanapolyBoardTabActivity$initViewModel$1) create(danapolyBoardUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DanapolyBoardUiState danapolyBoardUiState = (DanapolyBoardUiState) this.L$0;
            if (danapolyBoardUiState instanceof DanapolyBoardUiState.OnCheckShownTutorial) {
                if (!((DanapolyBoardUiState.OnCheckShownTutorial) danapolyBoardUiState).getBuiltInFictitiousFunctionClassFactory()) {
                    DanapolyBoardTabActivity.access$showFirstTimeTutorial(this.this$0);
                }
            } else if (danapolyBoardUiState instanceof DanapolyBoardUiState.OnConfigurationError) {
                this.this$0.BuiltInFictitiousFunctionClassFactory(false);
            } else if (danapolyBoardUiState instanceof DanapolyBoardUiState.OnConfigurationLoaded) {
                this.this$0.BuiltInFictitiousFunctionClassFactory(true);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
