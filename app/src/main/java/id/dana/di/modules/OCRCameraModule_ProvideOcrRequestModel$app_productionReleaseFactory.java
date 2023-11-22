package id.dana.di.modules;

import dagger.internal.Factory;
import id.dana.ocr.model.OCRRequestModel;

/* loaded from: classes8.dex */
public final class OCRCameraModule_ProvideOcrRequestModel$app_productionReleaseFactory implements Factory<OCRRequestModel> {
    private final OCRCameraModule MyBillsEntityDataFactory;

    private OCRCameraModule_ProvideOcrRequestModel$app_productionReleaseFactory(OCRCameraModule oCRCameraModule) {
        this.MyBillsEntityDataFactory = oCRCameraModule;
    }

    public static OCRCameraModule_ProvideOcrRequestModel$app_productionReleaseFactory BuiltInFictitiousFunctionClassFactory(OCRCameraModule oCRCameraModule) {
        return new OCRCameraModule_ProvideOcrRequestModel$app_productionReleaseFactory(oCRCameraModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return this.MyBillsEntityDataFactory.getMyBillsEntityDataFactory();
    }
}
