package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.namecheck.SendMoneySummaryContract;
import id.dana.sendmoney.namecheck.SendMoneySummaryPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SendMoneySummaryModule_ProvidePresenterFactory implements Factory<SendMoneySummaryContract.Presenter> {
    private final SendMoneySummaryModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<SendMoneySummaryPresenter> MyBillsEntityDataFactory;

    private SendMoneySummaryModule_ProvidePresenterFactory(SendMoneySummaryModule sendMoneySummaryModule, Provider<SendMoneySummaryPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = sendMoneySummaryModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static SendMoneySummaryModule_ProvidePresenterFactory BuiltInFictitiousFunctionClassFactory(SendMoneySummaryModule sendMoneySummaryModule, Provider<SendMoneySummaryPresenter> provider) {
        return new SendMoneySummaryModule_ProvidePresenterFactory(sendMoneySummaryModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneySummaryContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.MyBillsEntityDataFactory.get()));
    }
}
