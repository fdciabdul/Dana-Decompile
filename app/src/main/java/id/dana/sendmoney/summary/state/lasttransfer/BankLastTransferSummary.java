package id.dana.sendmoney.summary.state.lasttransfer;

import id.dana.sendmoney.confirmation.SendMoneyConfirmationContract;
import id.dana.sendmoney.model.RecipientModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/sendmoney/summary/state/lasttransfer/BankLastTransferSummary;", "Lid/dana/sendmoney/summary/state/lasttransfer/LastTransferSummary;", "Lid/dana/sendmoney/model/RecipientModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/sendmoney/model/RecipientModel;)V", "Lid/dana/sendmoney/confirmation/SendMoneyConfirmationContract$Presenter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/confirmation/SendMoneyConfirmationContract$Presenter;", "<init>", "(Lid/dana/sendmoney/confirmation/SendMoneyConfirmationContract$Presenter;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BankLastTransferSummary implements LastTransferSummary {
    private final SendMoneyConfirmationContract.Presenter BuiltInFictitiousFunctionClassFactory;

    @Inject
    public BankLastTransferSummary(SendMoneyConfirmationContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.BuiltInFictitiousFunctionClassFactory = presenter;
    }

    @Override // id.dana.sendmoney.summary.state.lasttransfer.LastTransferSummary
    public final void getAuthRequestContext(RecipientModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        SendMoneyConfirmationContract.Presenter presenter = this.BuiltInFictitiousFunctionClassFactory;
        String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda8;
        presenter.MyBillsEntityDataFactory(str != null ? str : "", p0.readMicros);
    }
}
