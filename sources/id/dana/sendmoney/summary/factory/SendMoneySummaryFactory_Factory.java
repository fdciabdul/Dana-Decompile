package id.dana.sendmoney.summary.factory;

import dagger.internal.Factory;
import id.dana.sendmoney.summary.state.BankSendMoneySummary;
import id.dana.sendmoney.summary.state.ContactSendMoneySummary;
import id.dana.sendmoney.summary.state.LinkSendMoneySummary;
import id.dana.sendmoney.summary.state.OtcSendMoneySummary;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class SendMoneySummaryFactory_Factory implements Factory<SendMoneySummaryFactory> {
    private final Provider<ContactSendMoneySummary> BuiltInFictitiousFunctionClassFactory;
    private final Provider<OtcSendMoneySummary> MyBillsEntityDataFactory;
    private final Provider<LinkSendMoneySummary> PlaceComponentResult;
    private final Provider<BankSendMoneySummary> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendMoneySummaryFactory(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
