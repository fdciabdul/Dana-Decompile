package id.dana.familyaccount.view.memberlimit;

import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "amount", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.familyaccount.view.memberlimit.FamilySetMemberLimitInputAmountView$setupViews$1$2$1$1", f = "FamilySetMemberLimitInputAmountView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class FamilySetMemberLimitInputAmountView$setupViews$1$2$1$1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FamilySetMemberLimitInputAmountView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FamilySetMemberLimitInputAmountView$setupViews$1$2$1$1(FamilySetMemberLimitInputAmountView familySetMemberLimitInputAmountView, Continuation<? super FamilySetMemberLimitInputAmountView$setupViews$1$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = familySetMemberLimitInputAmountView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FamilySetMemberLimitInputAmountView$setupViews$1$2$1$1 familySetMemberLimitInputAmountView$setupViews$1$2$1$1 = new FamilySetMemberLimitInputAmountView$setupViews$1$2$1$1(this.this$0, continuation);
        familySetMemberLimitInputAmountView$setupViews$1$2$1$1.L$0 = obj;
        return familySetMemberLimitInputAmountView$setupViews$1$2$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((FamilySetMemberLimitInputAmountView$setupViews$1$2$1$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            FamilySetMemberLimitInputAmountView.access$setClearTextIcon(this.this$0, str);
            FamilySetMemberLimitInputAmountView.access$validateAmount(this.this$0, new MoneyViewModel(str, null, null, 6, null));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
