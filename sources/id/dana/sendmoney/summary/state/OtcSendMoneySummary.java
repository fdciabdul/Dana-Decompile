package id.dana.sendmoney.summary.state;

import id.dana.R;
import id.dana.sendmoney.summary.state.confirmation.ConfirmationSummary;
import id.dana.sendmoney.summary.state.confirmation.OtcConfirmationSummary;
import id.dana.sendmoney.summary.state.lasttransfer.LastTransferSummary;
import id.dana.sendmoney.summary.state.validation.OtcValidationSummary;
import id.dana.sendmoney.summary.state.validation.ValidationSummary;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0014\u0010\f\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/sendmoney/summary/state/OtcSendMoneySummary;", "Lid/dana/sendmoney/summary/state/SendMoneySummary;", "", "getAuthRequestContext", "()I", "Lid/dana/sendmoney/summary/state/confirmation/ConfirmationSummary;", "PlaceComponentResult", "()Lid/dana/sendmoney/summary/state/confirmation/ConfirmationSummary;", "Lid/dana/sendmoney/summary/state/lasttransfer/LastTransferSummary;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/sendmoney/summary/state/lasttransfer/LastTransferSummary;", "Lid/dana/sendmoney/summary/state/validation/ValidationSummary;", "MyBillsEntityDataFactory", "()Lid/dana/sendmoney/summary/state/validation/ValidationSummary;", "Lid/dana/sendmoney/summary/state/confirmation/OtcConfirmationSummary;", "Lid/dana/sendmoney/summary/state/confirmation/OtcConfirmationSummary;", "Lid/dana/sendmoney/summary/state/validation/OtcValidationSummary;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/summary/state/validation/OtcValidationSummary;", "p0", "p1", "<init>", "(Lid/dana/sendmoney/summary/state/validation/OtcValidationSummary;Lid/dana/sendmoney/summary/state/confirmation/OtcConfirmationSummary;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OtcSendMoneySummary extends SendMoneySummary {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final OtcValidationSummary MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final OtcConfirmationSummary PlaceComponentResult;

    @Override // id.dana.sendmoney.summary.state.SendMoneySummary
    protected final LastTransferSummary KClassImpl$Data$declaredNonStaticMembers$2() {
        return null;
    }

    @Override // id.dana.sendmoney.summary.state.SendMoneySummary
    public final int getAuthRequestContext() {
        return R.string.sendmoney_summary_x2c_toolbar_title;
    }

    @Inject
    public OtcSendMoneySummary(OtcValidationSummary otcValidationSummary, OtcConfirmationSummary otcConfirmationSummary) {
        Intrinsics.checkNotNullParameter(otcValidationSummary, "");
        Intrinsics.checkNotNullParameter(otcConfirmationSummary, "");
        this.MyBillsEntityDataFactory = otcValidationSummary;
        this.PlaceComponentResult = otcConfirmationSummary;
    }

    @Override // id.dana.sendmoney.summary.state.SendMoneySummary
    protected final ValidationSummary MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // id.dana.sendmoney.summary.state.SendMoneySummary
    protected final ConfirmationSummary PlaceComponentResult() {
        return this.PlaceComponentResult;
    }
}
