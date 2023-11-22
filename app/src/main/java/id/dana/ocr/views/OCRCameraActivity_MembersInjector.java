package id.dana.ocr.views;

import dagger.MembersInjector;
import id.dana.ocr.OCRCameraContract;
import id.dana.usereducation.BottomSheetOnBoardingContract;

/* loaded from: classes9.dex */
public final class OCRCameraActivity_MembersInjector implements MembersInjector<OCRCameraActivity> {
    public static void MyBillsEntityDataFactory(OCRCameraActivity oCRCameraActivity, OCRCameraContract.Presenter presenter) {
        oCRCameraActivity.ocrCameraPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(OCRCameraActivity oCRCameraActivity, BottomSheetOnBoardingContract.Presenter presenter) {
        oCRCameraActivity.onBoardingPresenter = presenter;
    }
}
