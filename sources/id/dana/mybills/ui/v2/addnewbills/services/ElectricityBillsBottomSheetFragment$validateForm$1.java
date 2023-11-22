package id.dana.mybills.ui.v2.addnewbills.services;

import com.alibaba.wireless.security.SecExceptionCode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$validateForm$1", f = "ElectricityBillsBottomSheetFragment.kt", i = {}, l = {SecExceptionCode.SEC_ERROR_SIGNATRUE_INVALID_INPUT}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes9.dex */
public final class ElectricityBillsBottomSheetFragment$validateForm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ElectricityBillsBottomSheetFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ElectricityBillsBottomSheetFragment$validateForm$1(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment, Continuation<? super ElectricityBillsBottomSheetFragment$validateForm$1> continuation) {
        super(2, continuation);
        this.this$0 = electricityBillsBottomSheetFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ElectricityBillsBottomSheetFragment$validateForm$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ElectricityBillsBottomSheetFragment$validateForm$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(250L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        z = this.this$0.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (z) {
            ElectricityBillsBottomSheetFragment.DatabaseTableConfigUtil(this.this$0).BuiltInFictitiousFunctionClassFactory(ElectricityBillsBottomSheetFragment.BuiltInFictitiousFunctionClassFactory(this.this$0));
        } else {
            ElectricityBillsBottomSheetFragment.DatabaseTableConfigUtil(this.this$0).BuiltInFictitiousFunctionClassFactory(ElectricityBillsBottomSheetFragment.getAuthRequestContext(this.this$0));
        }
        return Unit.INSTANCE;
    }
}
