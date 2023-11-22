package id.dana.sendmoney.summary.state;

import dagger.internal.Factory;
import id.dana.sendmoney.summary.state.confirmation.LinkConfirmationSummary;
import id.dana.sendmoney.summary.state.validation.LinkValidationSummary;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class LinkSendMoneySummary_Factory implements Factory<LinkSendMoneySummary> {
    private final Provider<LinkConfirmationSummary> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<LinkValidationSummary> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LinkSendMoneySummary(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
