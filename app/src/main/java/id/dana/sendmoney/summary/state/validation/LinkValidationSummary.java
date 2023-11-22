package id.dana.sendmoney.summary.state.validation;

import id.dana.contract.sendmoney.ExpiryContract;
import id.dana.sendmoney.summary.state.model.SummaryValidateModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/sendmoney/summary/state/validation/LinkValidationSummary;", "Lid/dana/sendmoney/summary/state/validation/ValidationSummary;", "Lid/dana/sendmoney/summary/state/model/SummaryValidateModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/sendmoney/summary/state/model/SummaryValidateModel;)V", "Lid/dana/contract/sendmoney/ExpiryContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/contract/sendmoney/ExpiryContract$Presenter;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/contract/sendmoney/ExpiryContract$Presenter;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LinkValidationSummary implements ValidationSummary {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ExpiryContract.Presenter MyBillsEntityDataFactory;

    @Inject
    public LinkValidationSummary(ExpiryContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.MyBillsEntityDataFactory = presenter;
    }

    @Override // id.dana.sendmoney.summary.state.validation.ValidationSummary
    public final void getAuthRequestContext(SummaryValidateModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
