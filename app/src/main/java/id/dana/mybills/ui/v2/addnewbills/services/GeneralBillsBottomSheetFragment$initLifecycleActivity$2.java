package id.dana.mybills.ui.v2.addnewbills.services;

import id.dana.mybills.ui.v2.addnewbills.AddToMyBillsState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddToMyBillsState;", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$initLifecycleActivity$2", f = "GeneralBillsBottomSheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes9.dex */
final class GeneralBillsBottomSheetFragment$initLifecycleActivity$2 extends SuspendLambda implements Function2<AddToMyBillsState, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GeneralBillsBottomSheetFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeneralBillsBottomSheetFragment$initLifecycleActivity$2(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment, Continuation<? super GeneralBillsBottomSheetFragment$initLifecycleActivity$2> continuation) {
        super(2, continuation);
        this.this$0 = generalBillsBottomSheetFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GeneralBillsBottomSheetFragment$initLifecycleActivity$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AddToMyBillsState addToMyBillsState, Continuation<? super Unit> continuation) {
        return ((GeneralBillsBottomSheetFragment$initLifecycleActivity$2) create(addToMyBillsState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            GeneralBillsBottomSheetFragment.BuiltInFictitiousFunctionClassFactory(this.this$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
