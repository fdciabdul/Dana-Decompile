package id.dana.ocr;

import android.graphics.Bitmap;
import com.otaliastudios.cameraview.PictureResult;
import id.dana.base.AbstractContract;
import id.dana.lib.gcontainer.app.bridge.constant.BridgeKey;
import id.dana.ocr.model.OCRRequestModel;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/ocr/OCRPreviewImageContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public interface OCRPreviewImageContract {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH&¢\u0006\u0004\b\b\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/ocr/OCRPreviewImageContract$Presenter;", "Lid/dana/base/AbstractContract$AbstractPresenter;", "Lid/dana/ocr/model/OCRRequestModel;", "p0", "", "PlaceComponentResult", "(Lid/dana/ocr/model/OCRRequestModel;)V", "Lcom/otaliastudios/cameraview/PictureResult;", "BuiltInFictitiousFunctionClassFactory", "(Lcom/otaliastudios/cameraview/PictureResult;)V", "", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory(PictureResult p0);

        void BuiltInFictitiousFunctionClassFactory(String p0);

        void PlaceComponentResult(OCRRequestModel p0);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\tH&¢\u0006\u0004\b\u0014\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/ocr/OCRPreviewImageContract$View;", "Lid/dana/base/AbstractContract$AbstractView;", "", "closePage", "()V", "Ljava/io/File;", "getStorageDir", "()Ljava/io/File;", "onFilePathNull", "Landroid/graphics/Bitmap;", "bitmap", "onSuccessConvertImage", "(Landroid/graphics/Bitmap;)V", "Lid/dana/ocr/model/OCRRequestModel;", "ocrRequestModel", "", BridgeKey.FILE_PATH, "processImageOnBackground", "(Lid/dana/ocr/model/OCRRequestModel;Ljava/lang/String;)V", "imageOrigin", "processImageOnForeground"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface View extends AbstractContract.AbstractView {
        void closePage();

        File getStorageDir();

        void onFilePathNull();

        void onSuccessConvertImage(Bitmap bitmap);

        void processImageOnBackground(OCRRequestModel ocrRequestModel, String filePath);

        void processImageOnForeground(Bitmap imageOrigin);
    }
}
