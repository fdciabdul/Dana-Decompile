package id.dana.sendmoney.summary.state.confirmation;

import id.dana.sendmoney.confirmation.SendMoneyConfirmationContract;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/sendmoney/summary/state/confirmation/ContactConfirmationSummary;", "Lid/dana/sendmoney/summary/state/confirmation/ConfirmationSummary;", "Lid/dana/sendmoney/summary/state/model/SummaryConfirmationModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/sendmoney/summary/state/model/SummaryConfirmationModel;)V", "Lid/dana/sendmoney/confirmation/SendMoneyConfirmationContract$Presenter;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/confirmation/SendMoneyConfirmationContract$Presenter;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lid/dana/sendmoney/confirmation/SendMoneyConfirmationContract$Presenter;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactConfirmationSummary implements ConfirmationSummary {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final SendMoneyConfirmationContract.Presenter BuiltInFictitiousFunctionClassFactory;

    @Inject
    public ContactConfirmationSummary(SendMoneyConfirmationContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.BuiltInFictitiousFunctionClassFactory = presenter;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x018e  */
    @Override // id.dana.sendmoney.summary.state.confirmation.ConfirmationSummary
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(id.dana.sendmoney.summary.state.model.SummaryConfirmationModel r15) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.state.confirmation.ContactConfirmationSummary.getAuthRequestContext(id.dana.sendmoney.summary.state.model.SummaryConfirmationModel):void");
    }
}
