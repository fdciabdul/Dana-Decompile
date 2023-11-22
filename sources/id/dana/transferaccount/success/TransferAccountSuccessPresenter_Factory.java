package id.dana.transferaccount.success;

import dagger.internal.Factory;
import id.dana.domain.transferaccount.interactor.ClearTransferAccountCache;
import id.dana.transferaccount.success.TransferAccountSuccessContract;
import id.dana.utils.session.SessionManager;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class TransferAccountSuccessPresenter_Factory implements Factory<TransferAccountSuccessPresenter> {
    private final Provider<ClearTransferAccountCache> BuiltInFictitiousFunctionClassFactory;
    private final Provider<TransferAccountSuccessContract.View> MyBillsEntityDataFactory;
    private final Provider<SessionManager> getAuthRequestContext;

    private TransferAccountSuccessPresenter_Factory(Provider<ClearTransferAccountCache> provider, Provider<SessionManager> provider2, Provider<TransferAccountSuccessContract.View> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.getAuthRequestContext = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static TransferAccountSuccessPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<ClearTransferAccountCache> provider, Provider<SessionManager> provider2, Provider<TransferAccountSuccessContract.View> provider3) {
        return new TransferAccountSuccessPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TransferAccountSuccessPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
