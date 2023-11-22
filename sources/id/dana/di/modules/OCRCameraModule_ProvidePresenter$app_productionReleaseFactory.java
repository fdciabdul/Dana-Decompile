package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.ocr.OCRCameraContract;
import id.dana.ocr.OCRCameraPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class OCRCameraModule_ProvidePresenter$app_productionReleaseFactory implements Factory<OCRCameraContract.Presenter> {
    private final Provider<OCRCameraPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final OCRCameraModule PlaceComponentResult;

    private OCRCameraModule_ProvidePresenter$app_productionReleaseFactory(OCRCameraModule oCRCameraModule, Provider<OCRCameraPresenter> provider) {
        this.PlaceComponentResult = oCRCameraModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static OCRCameraModule_ProvidePresenter$app_productionReleaseFactory KClassImpl$Data$declaredNonStaticMembers$2(OCRCameraModule oCRCameraModule, Provider<OCRCameraPresenter> provider) {
        return new OCRCameraModule_ProvidePresenter$app_productionReleaseFactory(oCRCameraModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OCRCameraContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
