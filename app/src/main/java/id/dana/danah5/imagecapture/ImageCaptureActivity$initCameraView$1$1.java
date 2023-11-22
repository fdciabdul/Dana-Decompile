package id.dana.danah5.imagecapture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.otaliastudios.cameraview.BitmapCallback;
import com.otaliastudios.cameraview.CameraListener;
import com.otaliastudios.cameraview.CameraUtils;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.controls.PictureFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/danah5/imagecapture/ImageCaptureActivity$initCameraView$1$1;", "Lcom/otaliastudios/cameraview/CameraListener;", "Lcom/otaliastudios/cameraview/PictureResult;", "result", "", "onPictureTaken", "(Lcom/otaliastudios/cameraview/PictureResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ImageCaptureActivity$initCameraView$1$1 extends CameraListener {
    final /* synthetic */ ImageCaptureActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageCaptureActivity$initCameraView$1$1(ImageCaptureActivity imageCaptureActivity) {
        this.this$0 = imageCaptureActivity;
    }

    @Override // com.otaliastudios.cameraview.CameraListener
    public final void onPictureTaken(PictureResult result) {
        Intrinsics.checkNotNullParameter(result, "");
        final ImageCaptureActivity imageCaptureActivity = this.this$0;
        BitmapCallback bitmapCallback = new BitmapCallback() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$initCameraView$1$1$$ExternalSyntheticLambda0
            @Override // com.otaliastudios.cameraview.BitmapCallback
            public final void onBitmapReady(Bitmap bitmap) {
                ImageCaptureActivity$initCameraView$1$1.m670onPictureTaken$lambda0(ImageCaptureActivity.this, bitmap);
            }
        };
        if (result.PlaceComponentResult == PictureFormat.JPEG) {
            CameraUtils.getAuthRequestContext(result.BuiltInFictitiousFunctionClassFactory(), new BitmapFactory.Options(), result.getAuthRequestContext, bitmapCallback);
        } else if (result.PlaceComponentResult == PictureFormat.DNG && Build.VERSION.SDK_INT >= 24) {
            CameraUtils.getAuthRequestContext(result.BuiltInFictitiousFunctionClassFactory(), new BitmapFactory.Options(), result.getAuthRequestContext, bitmapCallback);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("PictureResult.toBitmap() does not support this picture format: ");
            sb.append(result.PlaceComponentResult);
            throw new UnsupportedOperationException(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onPictureTaken$lambda-0  reason: not valid java name */
    public static final void m670onPictureTaken$lambda0(ImageCaptureActivity imageCaptureActivity, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(imageCaptureActivity, "");
        if (bitmap != null) {
            imageCaptureActivity.showChosenImage(bitmap);
        }
    }
}
