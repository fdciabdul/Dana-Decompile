package id.dana.di.component;

import dagger.Component;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.staticqr.DecodeQrImageModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.GlobalNetworkModule;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.di.modules.ScanQrAnalyticModule;
import id.dana.scanner.ScannerFragment;

@Component(dependencies = {ApplicationComponent.class}, modules = {ScanQrModule.class, DecodeQrImageModule.class, DeepLinkModule.class, PlayStoreReviewModules.class, CheckoutH5EventModule.class, BottomSheetOnBoardingModule.class, GlobalNetworkModule.class, ScanQrAnalyticModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface ScannerComponent {
    void MyBillsEntityDataFactory(ScannerFragment scannerFragment);
}
