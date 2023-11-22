package id.dana.sendmoney.summary.state;

import id.dana.R;
import id.dana.sendmoney.summary.state.confirmation.ConfirmationSummary;
import id.dana.sendmoney.summary.state.confirmation.ContactConfirmationSummary;
import id.dana.sendmoney.summary.state.lasttransfer.ContactLastTransferSummary;
import id.dana.sendmoney.summary.state.lasttransfer.LastTransferSummary;
import id.dana.sendmoney.summary.state.validation.ContactValidationSummary;
import id.dana.sendmoney.summary.state.validation.ValidationSummary;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u000f\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\f\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0014"}, d2 = {"Lid/dana/sendmoney/summary/state/ContactSendMoneySummary;", "Lid/dana/sendmoney/summary/state/SendMoneySummary;", "", "getAuthRequestContext", "()I", "Lid/dana/sendmoney/summary/state/confirmation/ConfirmationSummary;", "PlaceComponentResult", "()Lid/dana/sendmoney/summary/state/confirmation/ConfirmationSummary;", "Lid/dana/sendmoney/summary/state/lasttransfer/LastTransferSummary;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/sendmoney/summary/state/lasttransfer/LastTransferSummary;", "Lid/dana/sendmoney/summary/state/validation/ValidationSummary;", "MyBillsEntityDataFactory", "()Lid/dana/sendmoney/summary/state/validation/ValidationSummary;", "Lid/dana/sendmoney/summary/state/confirmation/ContactConfirmationSummary;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/summary/state/confirmation/ContactConfirmationSummary;", "Lid/dana/sendmoney/summary/state/lasttransfer/ContactLastTransferSummary;", "Lid/dana/sendmoney/summary/state/lasttransfer/ContactLastTransferSummary;", "Lid/dana/sendmoney/summary/state/validation/ContactValidationSummary;", "Lid/dana/sendmoney/summary/state/validation/ContactValidationSummary;", "p0", "p1", "p2", "<init>", "(Lid/dana/sendmoney/summary/state/validation/ContactValidationSummary;Lid/dana/sendmoney/summary/state/confirmation/ContactConfirmationSummary;Lid/dana/sendmoney/summary/state/lasttransfer/ContactLastTransferSummary;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactSendMoneySummary extends SendMoneySummary {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ContactConfirmationSummary PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ContactValidationSummary MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ContactLastTransferSummary BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.sendmoney.summary.state.SendMoneySummary
    public final int getAuthRequestContext() {
        return R.string.sendmoney_summary_x2p_toolbar_title;
    }

    @Inject
    public ContactSendMoneySummary(ContactValidationSummary contactValidationSummary, ContactConfirmationSummary contactConfirmationSummary, ContactLastTransferSummary contactLastTransferSummary) {
        Intrinsics.checkNotNullParameter(contactValidationSummary, "");
        Intrinsics.checkNotNullParameter(contactConfirmationSummary, "");
        Intrinsics.checkNotNullParameter(contactLastTransferSummary, "");
        this.MyBillsEntityDataFactory = contactValidationSummary;
        this.PlaceComponentResult = contactConfirmationSummary;
        this.BuiltInFictitiousFunctionClassFactory = contactLastTransferSummary;
    }

    @Override // id.dana.sendmoney.summary.state.SendMoneySummary
    protected final ValidationSummary MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // id.dana.sendmoney.summary.state.SendMoneySummary
    protected final ConfirmationSummary PlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // id.dana.sendmoney.summary.state.SendMoneySummary
    protected final LastTransferSummary KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
