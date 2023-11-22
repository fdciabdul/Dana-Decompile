package id.dana.sendmoney.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCorePresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SendMoneyCoreModule_ProvidePresenterFactory implements Factory<SendMoneyCoreContract.Presenter> {
    private final SendMoneyCoreModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SendMoneyCorePresenter> MyBillsEntityDataFactory;

    public static SendMoneyCoreContract.Presenter PlaceComponentResult(SendMoneyCoreModule sendMoneyCoreModule, SendMoneyCorePresenter sendMoneyCorePresenter) {
        return (SendMoneyCoreContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(sendMoneyCoreModule.BuiltInFictitiousFunctionClassFactory(sendMoneyCorePresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneyCoreContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}
