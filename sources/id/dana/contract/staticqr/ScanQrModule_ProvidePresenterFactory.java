package id.dana.contract.staticqr;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.staticqr.ScanQrContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ScanQrModule_ProvidePresenterFactory implements Factory<ScanQrContract.Presenter> {
    private final Provider<ScanQrPresenter> MyBillsEntityDataFactory;
    private final ScanQrModule getAuthRequestContext;

    private ScanQrModule_ProvidePresenterFactory(ScanQrModule scanQrModule, Provider<ScanQrPresenter> provider) {
        this.getAuthRequestContext = scanQrModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ScanQrModule_ProvidePresenterFactory MyBillsEntityDataFactory(ScanQrModule scanQrModule, Provider<ScanQrPresenter> provider) {
        return new ScanQrModule_ProvidePresenterFactory(scanQrModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ScanQrContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.MyBillsEntityDataFactory.get()));
    }
}
