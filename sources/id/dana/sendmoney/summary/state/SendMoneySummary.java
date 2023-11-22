package id.dana.sendmoney.summary.state;

import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.summary.state.confirmation.ConfirmationSummary;
import id.dana.sendmoney.summary.state.lasttransfer.LastTransferSummary;
import id.dana.sendmoney.summary.state.model.SummaryConfirmationModel;
import id.dana.sendmoney.summary.state.model.SummaryValidateModel;
import id.dana.sendmoney.summary.state.validation.ValidationSummary;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH$¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000eJ\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u000fH$¢\u0006\u0004\b\u0005\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H$¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0014¢\u0006\u0004\b\b\u0010\u0015"}, d2 = {"Lid/dana/sendmoney/summary/state/SendMoneySummary;", "", "Lid/dana/sendmoney/summary/state/model/SummaryConfirmationModel;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/summary/state/model/SummaryConfirmationModel;)V", "", "getAuthRequestContext", "()I", "Lid/dana/sendmoney/summary/state/confirmation/ConfirmationSummary;", "PlaceComponentResult", "()Lid/dana/sendmoney/summary/state/confirmation/ConfirmationSummary;", "Lid/dana/sendmoney/model/RecipientModel;", "(Lid/dana/sendmoney/model/RecipientModel;)V", "Lid/dana/sendmoney/summary/state/lasttransfer/LastTransferSummary;", "()Lid/dana/sendmoney/summary/state/lasttransfer/LastTransferSummary;", "Lid/dana/sendmoney/summary/state/validation/ValidationSummary;", "MyBillsEntityDataFactory", "()Lid/dana/sendmoney/summary/state/validation/ValidationSummary;", "Lid/dana/sendmoney/summary/state/model/SummaryValidateModel;", "(Lid/dana/sendmoney/summary/state/model/SummaryValidateModel;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class SendMoneySummary {
    protected abstract LastTransferSummary KClassImpl$Data$declaredNonStaticMembers$2();

    protected abstract ValidationSummary MyBillsEntityDataFactory();

    protected abstract ConfirmationSummary PlaceComponentResult();

    public abstract int getAuthRequestContext();

    public final void PlaceComponentResult(RecipientModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        LastTransferSummary KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(p0);
        }
    }

    public final void getAuthRequestContext(SummaryValidateModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MyBillsEntityDataFactory().getAuthRequestContext(p0);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(SummaryConfirmationModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult().getAuthRequestContext(p0);
    }
}
