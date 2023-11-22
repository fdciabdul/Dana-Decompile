package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.ocr.OCRCameraContract;

/* loaded from: classes8.dex */
public final class OCRCameraModule_ProvideView$app_productionReleaseFactory implements Factory<OCRCameraContract.View> {
    private final OCRCameraModule KClassImpl$Data$declaredNonStaticMembers$2;

    private OCRCameraModule_ProvideView$app_productionReleaseFactory(OCRCameraModule oCRCameraModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = oCRCameraModule;
    }

    public static OCRCameraModule_ProvideView$app_productionReleaseFactory BuiltInFictitiousFunctionClassFactory(OCRCameraModule oCRCameraModule) {
        return new OCRCameraModule_ProvideView$app_productionReleaseFactory(oCRCameraModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OCRCameraContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
