package id.dana.transferaccount.transferaccountstatus;

import dagger.internal.Factory;
import id.dana.domain.transferaccount.interactor.GetTransferAccountStatus;
import id.dana.transferaccount.tracker.TransferAccountTrackerImpl;
import id.dana.transferaccount.transferaccountstatus.TransferAccountContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class TransferAccountPresenter_Factory implements Factory<TransferAccountPresenter> {
    private final Provider<GetTransferAccountStatus> BuiltInFictitiousFunctionClassFactory;
    private final Provider<TransferAccountContract.View> MyBillsEntityDataFactory;
    private final Provider<TransferAccountTrackerImpl> PlaceComponentResult;

    private TransferAccountPresenter_Factory(Provider<GetTransferAccountStatus> provider, Provider<TransferAccountTrackerImpl> provider2, Provider<TransferAccountContract.View> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static TransferAccountPresenter_Factory getAuthRequestContext(Provider<GetTransferAccountStatus> provider, Provider<TransferAccountTrackerImpl> provider2, Provider<TransferAccountContract.View> provider3) {
        return new TransferAccountPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TransferAccountPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
