package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.animation.ScanQrLoyaltyContract;
import id.dana.animation.ScanQrLoyaltyPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ScanQrLoyaltyModule_ProvideScanQrLoyaltyPresenterFactory implements Factory<ScanQrLoyaltyContract.Presenter> {
    private final ScanQrLoyaltyModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ScanQrLoyaltyPresenter> MyBillsEntityDataFactory;

    private ScanQrLoyaltyModule_ProvideScanQrLoyaltyPresenterFactory(ScanQrLoyaltyModule scanQrLoyaltyModule, Provider<ScanQrLoyaltyPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = scanQrLoyaltyModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ScanQrLoyaltyModule_ProvideScanQrLoyaltyPresenterFactory PlaceComponentResult(ScanQrLoyaltyModule scanQrLoyaltyModule, Provider<ScanQrLoyaltyPresenter> provider) {
        return new ScanQrLoyaltyModule_ProvideScanQrLoyaltyPresenterFactory(scanQrLoyaltyModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ScanQrLoyaltyContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.MyBillsEntityDataFactory.get()));
    }
}
