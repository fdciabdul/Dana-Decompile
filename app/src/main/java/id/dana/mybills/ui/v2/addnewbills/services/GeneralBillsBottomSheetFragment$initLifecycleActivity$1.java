package id.dana.mybills.ui.v2.addnewbills.services;

import id.dana.mybills.ui.v2.addnewbills.AddNewBillsUiState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$initLifecycleActivity$1", f = "GeneralBillsBottomSheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes9.dex */
final class GeneralBillsBottomSheetFragment$initLifecycleActivity$1 extends SuspendLambda implements Function2<AddNewBillsUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GeneralBillsBottomSheetFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeneralBillsBottomSheetFragment$initLifecycleActivity$1(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment, Continuation<? super GeneralBillsBottomSheetFragment$initLifecycleActivity$1> continuation) {
        super(2, continuation);
        this.this$0 = generalBillsBottomSheetFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GeneralBillsBottomSheetFragment$initLifecycleActivity$1 generalBillsBottomSheetFragment$initLifecycleActivity$1 = new GeneralBillsBottomSheetFragment$initLifecycleActivity$1(this.this$0, continuation);
        generalBillsBottomSheetFragment$initLifecycleActivity$1.L$0 = obj;
        return generalBillsBottomSheetFragment$initLifecycleActivity$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AddNewBillsUiState addNewBillsUiState, Continuation<? super Unit> continuation) {
        return ((GeneralBillsBottomSheetFragment$initLifecycleActivity$1) create(addNewBillsUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x021d, code lost:
    
        if (r1 != false) goto L98;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0219  */
    /* JADX WARN: Type inference failed for: r27v0, types: [id.dana.domain.nearbyme.model.MoneyView, java.lang.String] */
    /* JADX WARN: Type inference failed for: r28v0, types: [id.dana.domain.nearbyme.model.MoneyView, id.dana.mybills.data.model.response.ExtInfo] */
    /* JADX WARN: Type inference failed for: r29v0, types: [id.dana.domain.nearbyme.model.MoneyView, java.lang.String] */
    /* JADX WARN: Type inference failed for: r34v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r83) {
        /*
            Method dump skipped, instructions count: 996
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$initLifecycleActivity$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
