package id.dana.sendmoney_v2.landing.view;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.model.SendMoneyScenarioModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/model/SendMoneyScenarioModel;", "it", "", BridgeDSL.INVOKE, "(Lid/dana/model/SendMoneyScenarioModel;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final class SendMoneyScenariosView$onMenuSelected$1 extends Lambda implements Function1<SendMoneyScenarioModel, Unit> {
    public static final SendMoneyScenariosView$onMenuSelected$1 INSTANCE = new SendMoneyScenariosView$onMenuSelected$1();

    SendMoneyScenariosView$onMenuSelected$1() {
        super(1);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SendMoneyScenarioModel sendMoneyScenarioModel) {
        Intrinsics.checkNotNullParameter(sendMoneyScenarioModel, "");
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(SendMoneyScenarioModel sendMoneyScenarioModel) {
        invoke2(sendMoneyScenarioModel);
        return Unit.INSTANCE;
    }
}
