package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.ocr.OCRPreviewImageContract;

/* loaded from: classes8.dex */
public final class OCRPreviewImageModule_ProvideView$app_productionReleaseFactory implements Factory<OCRPreviewImageContract.View> {
    private final OCRPreviewImageModule PlaceComponentResult;

    private OCRPreviewImageModule_ProvideView$app_productionReleaseFactory(OCRPreviewImageModule oCRPreviewImageModule) {
        this.PlaceComponentResult = oCRPreviewImageModule;
    }

    public static OCRPreviewImageModule_ProvideView$app_productionReleaseFactory PlaceComponentResult(OCRPreviewImageModule oCRPreviewImageModule) {
        return new OCRPreviewImageModule_ProvideView$app_productionReleaseFactory(oCRPreviewImageModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OCRPreviewImageContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getMyBillsEntityDataFactory());
    }
}
