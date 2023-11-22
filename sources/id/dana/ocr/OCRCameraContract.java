package id.dana.ocr;

import com.otaliastudios.cameraview.PictureResult;
import id.dana.base.AbstractContract;
import id.dana.ocr.model.OCRRequestModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/ocr/OCRCameraContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public interface OCRCameraContract {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/ocr/OCRCameraContract$Presenter;", "Lid/dana/base/AbstractContract$AbstractPresenter;", "", "PlaceComponentResult", "()V", "Lcom/otaliastudios/cameraview/PictureResult;", "p0", "MyBillsEntityDataFactory", "(Lcom/otaliastudios/cameraview/PictureResult;)V", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void MyBillsEntityDataFactory(PictureResult p0);

        void PlaceComponentResult();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/ocr/OCRCameraContract$View;", "Lid/dana/base/AbstractContract$AbstractView;", "", "capturePicture", "()V", "", "errorCode", "onFailure", "(Ljava/lang/String;)V", "Lcom/otaliastudios/cameraview/PictureResult;", "pictureResult", "Lid/dana/ocr/model/OCRRequestModel;", "ocrRequestModel", "openPreviewPage", "(Lcom/otaliastudios/cameraview/PictureResult;Lid/dana/ocr/model/OCRRequestModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface View extends AbstractContract.AbstractView {
        void capturePicture();

        void onFailure(String errorCode);

        void openPreviewPage(PictureResult pictureResult, OCRRequestModel ocrRequestModel);
    }
}
