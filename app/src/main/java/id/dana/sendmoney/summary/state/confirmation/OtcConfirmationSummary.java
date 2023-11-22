package id.dana.sendmoney.summary.state.confirmation;

import id.dana.sendmoney.confirmation.SendMoneyConfirmationContract;
import id.dana.sendmoney.model.ConfirmationModel;
import id.dana.sendmoney.summary.state.model.SummaryConfirmationModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/sendmoney/summary/state/confirmation/OtcConfirmationSummary;", "Lid/dana/sendmoney/summary/state/confirmation/ConfirmationSummary;", "Lid/dana/sendmoney/summary/state/model/SummaryConfirmationModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/sendmoney/summary/state/model/SummaryConfirmationModel;)V", "Lid/dana/sendmoney/confirmation/SendMoneyConfirmationContract$Presenter;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/confirmation/SendMoneyConfirmationContract$Presenter;", "<init>", "(Lid/dana/sendmoney/confirmation/SendMoneyConfirmationContract$Presenter;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OtcConfirmationSummary implements ConfirmationSummary {
    private final SendMoneyConfirmationContract.Presenter MyBillsEntityDataFactory;

    @Inject
    public OtcConfirmationSummary(SendMoneyConfirmationContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.MyBillsEntityDataFactory = presenter;
    }

    @Override // id.dana.sendmoney.summary.state.confirmation.ConfirmationSummary
    public final void getAuthRequestContext(SummaryConfirmationModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ConfirmationModel confirmationModel = p0.BuiltInFictitiousFunctionClassFactory;
        SendMoneyConfirmationContract.Presenter presenter = this.MyBillsEntityDataFactory;
        confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda6();
        presenter.PlaceComponentResult(confirmationModel, confirmationModel.PlaceComponentResult());
    }
}
