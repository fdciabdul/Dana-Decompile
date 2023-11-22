package id.dana.ocr.views;

import dagger.MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.ocr.PreprocessingAndOcrContract;
import id.dana.ocr.UploadSnapReceiptContract;

/* loaded from: classes9.dex */
public final class SnapReceiptService_MembersInjector implements MembersInjector<SnapReceiptService> {
    public static void BuiltInFictitiousFunctionClassFactory(SnapReceiptService snapReceiptService, PreprocessingAndOcrContract.Presenter presenter) {
        snapReceiptService.preprocessingAndOcrPresenter = presenter;
    }

    public static void getAuthRequestContext(SnapReceiptService snapReceiptService, UploadSnapReceiptContract.Presenter presenter) {
        snapReceiptService.uploadSnapReceiptPresenter = presenter;
    }

    public static void getAuthRequestContext(SnapReceiptService snapReceiptService, DynamicUrlWrapper dynamicUrlWrapper) {
        snapReceiptService.dynamicUrlWrapper = dynamicUrlWrapper;
    }
}
