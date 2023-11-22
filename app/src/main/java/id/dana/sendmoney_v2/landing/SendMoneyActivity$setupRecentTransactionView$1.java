package id.dana.sendmoney_v2.landing;

import id.dana.sendmoney.model.RecipientModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class SendMoneyActivity$setupRecentTransactionView$1 extends FunctionReferenceImpl implements Function1<RecipientModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SendMoneyActivity$setupRecentTransactionView$1(Object obj) {
        super(1, obj, SendMoneyActivity.class, "onRecipientSelected", "onRecipientSelected(Lid/dana/sendmoney/model/RecipientModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(RecipientModel recipientModel) {
        invoke2(recipientModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(recipientModel, "");
        SendMoneyActivity.access$onRecipientSelected((SendMoneyActivity) this.receiver, recipientModel);
    }
}
