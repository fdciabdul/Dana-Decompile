package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.transferaccount.success.TransferAccountSuccessContract;
import id.dana.transferaccount.success.TransferAccountSuccessPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class TransferAccountSuccessModule_ProvidePresenterFactory implements Factory<TransferAccountSuccessContract.Presenter> {
    private final TransferAccountSuccessModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<TransferAccountSuccessPresenter> MyBillsEntityDataFactory;

    private TransferAccountSuccessModule_ProvidePresenterFactory(TransferAccountSuccessModule transferAccountSuccessModule, Provider<TransferAccountSuccessPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = transferAccountSuccessModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static TransferAccountSuccessModule_ProvidePresenterFactory MyBillsEntityDataFactory(TransferAccountSuccessModule transferAccountSuccessModule, Provider<TransferAccountSuccessPresenter> provider) {
        return new TransferAccountSuccessModule_ProvidePresenterFactory(transferAccountSuccessModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TransferAccountSuccessContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.MyBillsEntityDataFactory.get()));
    }
}
