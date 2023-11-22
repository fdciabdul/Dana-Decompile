package id.dana.sendmoney.ui.groupsend.summary.view;

import id.dana.core.ui.model.CurrencyAmountModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "value", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.ui.groupsend.summary.view.GroupSendInputAmountView$setup$1$1$1$1", f = "GroupSendInputAmountView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class GroupSendInputAmountView$setup$1$1$1$1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GroupSendInputAmountView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupSendInputAmountView$setup$1$1$1$1(GroupSendInputAmountView groupSendInputAmountView, Continuation<? super GroupSendInputAmountView$setup$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = groupSendInputAmountView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GroupSendInputAmountView$setup$1$1$1$1 groupSendInputAmountView$setup$1$1$1$1 = new GroupSendInputAmountView$setup$1$1$1$1(this.this$0, continuation);
        groupSendInputAmountView$setup$1$1$1$1.L$0 = obj;
        return groupSendInputAmountView$setup$1$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((GroupSendInputAmountView$setup$1$1$1$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            GroupSendInputAmountView groupSendInputAmountView = this.this$0;
            String str2 = str;
            StringBuilder sb = new StringBuilder();
            int length = str2.length();
            for (int i = 0; i < length; i++) {
                char charAt = str2.charAt(i);
                if (Character.isDigit(charAt)) {
                    sb.append(charAt);
                }
            }
            String obj2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(obj2, "");
            CurrencyAmountModel currencyAmountModel = new CurrencyAmountModel(obj2, "Rp", false, 4, null);
            z = this.this$0.PlaceComponentResult;
            groupSendInputAmountView.PlaceComponentResult(currencyAmountModel, z);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
