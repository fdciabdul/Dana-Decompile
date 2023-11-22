package id.dana.animation;

import dagger.internal.Factory;
import id.dana.animation.ScanQrLoyaltyContract;
import id.dana.domain.qrbarcode.interactor.GetNativelyDecodedQr;
import id.dana.scanner.gallery.RxQRDecode;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class ScanQrLoyaltyPresenter_Factory implements Factory<ScanQrLoyaltyPresenter> {
    private final Provider<GetNativelyDecodedQr> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ScanQrLoyaltyContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<RxQRDecode> getAuthRequestContext;

    private ScanQrLoyaltyPresenter_Factory(Provider<ScanQrLoyaltyContract.View> provider, Provider<RxQRDecode> provider2, Provider<GetNativelyDecodedQr> provider3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static ScanQrLoyaltyPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<ScanQrLoyaltyContract.View> provider, Provider<RxQRDecode> provider2, Provider<GetNativelyDecodedQr> provider3) {
        return new ScanQrLoyaltyPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ScanQrLoyaltyPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
