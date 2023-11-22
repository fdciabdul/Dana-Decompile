package id.dana.sendmoney_v2.landing;

import id.dana.model.SendMoneyScenarioModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class SendMoneyActivity$setupRecipientSelectorView$1 extends FunctionReferenceImpl implements Function1<SendMoneyScenarioModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SendMoneyActivity$setupRecipientSelectorView$1(Object obj) {
        super(1, obj, SendMoneyActivity.class, "onMenuSelected", "onMenuSelected(Lid/dana/model/SendMoneyScenarioModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(SendMoneyScenarioModel sendMoneyScenarioModel) {
        invoke2(sendMoneyScenarioModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SendMoneyScenarioModel sendMoneyScenarioModel) {
        Intrinsics.checkNotNullParameter(sendMoneyScenarioModel, "");
        SendMoneyActivity.access$onMenuSelected((SendMoneyActivity) this.receiver, sendMoneyScenarioModel);
    }
}
