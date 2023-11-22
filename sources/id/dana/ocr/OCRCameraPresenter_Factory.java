package id.dana.ocr;

import dagger.internal.Factory;
import id.dana.ocr.OCRCameraContract;
import id.dana.ocr.model.OCRRequestModel;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class OCRCameraPresenter_Factory implements Factory<OCRCameraPresenter> {
    private final Provider<OCRCameraContract.View> MyBillsEntityDataFactory;
    private final Provider<OCRRequestModel> PlaceComponentResult;

    private OCRCameraPresenter_Factory(Provider<OCRCameraContract.View> provider, Provider<OCRRequestModel> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static OCRCameraPresenter_Factory MyBillsEntityDataFactory(Provider<OCRCameraContract.View> provider, Provider<OCRRequestModel> provider2) {
        return new OCRCameraPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OCRCameraPresenter(this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
