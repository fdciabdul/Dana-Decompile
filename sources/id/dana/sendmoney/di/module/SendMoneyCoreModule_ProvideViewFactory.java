package id.dana.sendmoney.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract;

/* loaded from: classes5.dex */
public final class SendMoneyCoreModule_ProvideViewFactory implements Factory<SendMoneyCoreContract.View> {
    private final SendMoneyCoreModule PlaceComponentResult;

    public static SendMoneyCoreContract.View BuiltInFictitiousFunctionClassFactory(SendMoneyCoreModule sendMoneyCoreModule) {
        return (SendMoneyCoreContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(sendMoneyCoreModule.getBuiltInFictitiousFunctionClassFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneyCoreContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getBuiltInFictitiousFunctionClassFactory());
    }
}
