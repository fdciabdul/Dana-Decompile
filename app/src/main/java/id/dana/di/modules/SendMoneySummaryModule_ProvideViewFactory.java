package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.namecheck.SendMoneySummaryContract;

/* loaded from: classes4.dex */
public final class SendMoneySummaryModule_ProvideViewFactory implements Factory<SendMoneySummaryContract.View> {
    private final SendMoneySummaryModule PlaceComponentResult;

    private SendMoneySummaryModule_ProvideViewFactory(SendMoneySummaryModule sendMoneySummaryModule) {
        this.PlaceComponentResult = sendMoneySummaryModule;
    }

    public static SendMoneySummaryModule_ProvideViewFactory MyBillsEntityDataFactory(SendMoneySummaryModule sendMoneySummaryModule) {
        return new SendMoneySummaryModule_ProvideViewFactory(sendMoneySummaryModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneySummaryContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory());
    }
}
