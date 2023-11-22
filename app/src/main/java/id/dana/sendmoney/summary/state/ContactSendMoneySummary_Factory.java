package id.dana.sendmoney.summary.state;

import dagger.internal.Factory;
import id.dana.sendmoney.summary.state.confirmation.ContactConfirmationSummary;
import id.dana.sendmoney.summary.state.lasttransfer.ContactLastTransferSummary;
import id.dana.sendmoney.summary.state.validation.ContactValidationSummary;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class ContactSendMoneySummary_Factory implements Factory<ContactSendMoneySummary> {
    private final Provider<ContactValidationSummary> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ContactConfirmationSummary> PlaceComponentResult;
    private final Provider<ContactLastTransferSummary> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ContactSendMoneySummary(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.getAuthRequestContext.get());
    }
}
