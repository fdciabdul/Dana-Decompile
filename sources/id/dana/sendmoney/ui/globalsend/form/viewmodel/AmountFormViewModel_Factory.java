package id.dana.sendmoney.ui.globalsend.form.viewmodel;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.globalsend.interactor.InitGlobalTransfer;
import id.dana.sendmoney.domain.globalsend.interactor.TransferSubmit;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AmountFormViewModel_Factory implements Factory<AmountFormViewModel> {
    private final Provider<InitGlobalTransfer> BuiltInFictitiousFunctionClassFactory;
    private final Provider<TransferSubmit> KClassImpl$Data$declaredNonStaticMembers$2;

    private AmountFormViewModel_Factory(Provider<InitGlobalTransfer> provider, Provider<TransferSubmit> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static AmountFormViewModel_Factory getAuthRequestContext(Provider<InitGlobalTransfer> provider, Provider<TransferSubmit> provider2) {
        return new AmountFormViewModel_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new AmountFormViewModel(this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
