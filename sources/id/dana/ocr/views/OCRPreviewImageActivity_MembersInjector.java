package id.dana.ocr.views;

import dagger.MembersInjector;
import id.dana.ocr.OCRPreviewImageContract;
import id.dana.ocr.PreprocessingAndOcrContract;

/* loaded from: classes9.dex */
public final class OCRPreviewImageActivity_MembersInjector implements MembersInjector<OCRPreviewImageActivity> {
    public static void PlaceComponentResult(OCRPreviewImageActivity oCRPreviewImageActivity, OCRPreviewImageContract.Presenter presenter) {
        oCRPreviewImageActivity.ocrPreviewImagePresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(OCRPreviewImageActivity oCRPreviewImageActivity, PreprocessingAndOcrContract.Presenter presenter) {
        oCRPreviewImageActivity.preprocessingAndOcrPresenter = presenter;
    }
}
