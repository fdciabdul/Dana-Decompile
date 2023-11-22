package id.dana.cashier.view;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.cashier.model.RepaymentPlanModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cashier/model/RepaymentPlanModel;", "<anonymous parameter 0>", "", BridgeDSL.INVOKE, "(Lid/dana/cashier/model/RepaymentPlanModel;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
final class PaylaterInstallmentView$onInstallmentOptionClicked$1 extends Lambda implements Function1<RepaymentPlanModel, Unit> {
    public static final PaylaterInstallmentView$onInstallmentOptionClicked$1 INSTANCE = new PaylaterInstallmentView$onInstallmentOptionClicked$1();

    PaylaterInstallmentView$onInstallmentOptionClicked$1() {
        super(1);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(RepaymentPlanModel repaymentPlanModel) {
        Intrinsics.checkNotNullParameter(repaymentPlanModel, "");
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(RepaymentPlanModel repaymentPlanModel) {
        invoke2(repaymentPlanModel);
        return Unit.INSTANCE;
    }
}
