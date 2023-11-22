package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.transferaccount.transferaccountstatus.TransferAccountContract;
import id.dana.transferaccount.transferaccountstatus.TransferAccountPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class TransferAccountModule_ProvidePresenterFactory implements Factory<TransferAccountContract.Presenter> {
    private final Provider<TransferAccountPresenter> MyBillsEntityDataFactory;
    private final TransferAccountModule getAuthRequestContext;

    private TransferAccountModule_ProvidePresenterFactory(TransferAccountModule transferAccountModule, Provider<TransferAccountPresenter> provider) {
        this.getAuthRequestContext = transferAccountModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static TransferAccountModule_ProvidePresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(TransferAccountModule transferAccountModule, Provider<TransferAccountPresenter> provider) {
        return new TransferAccountModule_ProvidePresenterFactory(transferAccountModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TransferAccountContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}
