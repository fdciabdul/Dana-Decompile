package id.dana.mybills.ui.v2.addnewbills.services;

import id.dana.mybills.ui.v2.addnewbills.AddNewBillsUiState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$initLifecycleActivity$1", f = "ElectricityBillsBottomSheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes9.dex */
final class ElectricityBillsBottomSheetFragment$initLifecycleActivity$1 extends SuspendLambda implements Function2<AddNewBillsUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ElectricityBillsBottomSheetFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ElectricityBillsBottomSheetFragment$initLifecycleActivity$1(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment, Continuation<? super ElectricityBillsBottomSheetFragment$initLifecycleActivity$1> continuation) {
        super(2, continuation);
        this.this$0 = electricityBillsBottomSheetFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ElectricityBillsBottomSheetFragment$initLifecycleActivity$1 electricityBillsBottomSheetFragment$initLifecycleActivity$1 = new ElectricityBillsBottomSheetFragment$initLifecycleActivity$1(this.this$0, continuation);
        electricityBillsBottomSheetFragment$initLifecycleActivity$1.L$0 = obj;
        return electricityBillsBottomSheetFragment$initLifecycleActivity$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AddNewBillsUiState addNewBillsUiState, Continuation<? super Unit> continuation) {
        return ((ElectricityBillsBottomSheetFragment$initLifecycleActivity$1) create(addNewBillsUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x0219, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r8, "ELECTRICITY") != false) goto L96;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x021f  */
    /* JADX WARN: Type inference failed for: r28v0, types: [id.dana.domain.nearbyme.model.MoneyView, java.lang.String] */
    /* JADX WARN: Type inference failed for: r29v0, types: [id.dana.domain.nearbyme.model.MoneyView, id.dana.mybills.data.model.response.ExtInfo] */
    /* JADX WARN: Type inference failed for: r30v0, types: [id.dana.domain.nearbyme.model.MoneyView, java.lang.String] */
    /* JADX WARN: Type inference failed for: r35v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r84) {
        /*
            Method dump skipped, instructions count: 1065
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$initLifecycleActivity$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
