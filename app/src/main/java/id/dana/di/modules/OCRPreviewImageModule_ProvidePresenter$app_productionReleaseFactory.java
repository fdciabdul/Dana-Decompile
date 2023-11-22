package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.ocr.OCRPreviewImageContract;
import id.dana.ocr.OCRPreviewImagePresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class OCRPreviewImageModule_ProvidePresenter$app_productionReleaseFactory implements Factory<OCRPreviewImageContract.Presenter> {
    private final Provider<OCRPreviewImagePresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final OCRPreviewImageModule MyBillsEntityDataFactory;

    private OCRPreviewImageModule_ProvidePresenter$app_productionReleaseFactory(OCRPreviewImageModule oCRPreviewImageModule, Provider<OCRPreviewImagePresenter> provider) {
        this.MyBillsEntityDataFactory = oCRPreviewImageModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static OCRPreviewImageModule_ProvidePresenter$app_productionReleaseFactory PlaceComponentResult(OCRPreviewImageModule oCRPreviewImageModule, Provider<OCRPreviewImagePresenter> provider) {
        return new OCRPreviewImageModule_ProvidePresenter$app_productionReleaseFactory(oCRPreviewImageModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OCRPreviewImageContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
