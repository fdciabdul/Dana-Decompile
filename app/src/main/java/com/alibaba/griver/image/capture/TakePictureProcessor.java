package com.alibaba.griver.image.capture;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.hardware.Camera;
import android.media.ExifInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.image.capture.meta.APTakePicRsp;
import com.alibaba.griver.image.capture.meta.APTakePictureOption;
import com.alibaba.griver.image.capture.meta.CameraParams;
import com.alibaba.griver.image.capture.utils.CameraUtils;
import com.alibaba.griver.image.capture.utils.OrientationDetector;
import com.alibaba.griver.image.capture.widget.SightCameraView;
import com.alibaba.griver.image.framework.encode.APEncodeOptions;
import com.alibaba.griver.image.framework.encode.APEncodeResult;
import com.alibaba.griver.image.framework.encode.ImageEncoder;
import com.alibaba.griver.image.framework.meta.APImageInfo;
import com.alibaba.griver.image.framework.utils.Exif;
import com.alibaba.griver.image.framework.utils.FalconFacade;
import com.alibaba.griver.image.framework.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class TakePictureProcessor {
    public static int DEFAULT_PICTURE_MIN_HEIGHT = 1280;
    protected static final String TAG = "TakePictureProcessor";

    /* renamed from: a */
    private int f6562a = DEFAULT_PICTURE_MIN_HEIGHT;
    protected int mCameraFacing;

    private void a(Bitmap bitmap, String str) {
    }

    static {
        if ("samsung".equalsIgnoreCase(Build.MANUFACTURER) && ("SM-G9500".equalsIgnoreCase(Build.MODEL) || "SM-G9550".equalsIgnoreCase(Build.MODEL) || "SM-G9508".equalsIgnoreCase(Build.MODEL))) {
            DEFAULT_PICTURE_MIN_HEIGHT = 1920;
        } else {
            DEFAULT_PICTURE_MIN_HEIGHT = APEncodeOptions.DEFAULT_MAX_LEN;
        }
    }

    public void takePicture(Camera camera, int i, final SightCameraView.TakePictureListener takePictureListener, Looper looper, CameraParams cameraParams, final APTakePictureOption aPTakePictureOption) {
        int i2;
        final CameraParams cameraParams2;
        Handler handler;
        StringBuilder sb = new StringBuilder();
        sb.append("takePicture start looper: ");
        sb.append(looper);
        sb.append(", params: ");
        sb.append(cameraParams);
        RVLogger.d(TAG, sb.toString());
        if (aPTakePictureOption != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("takePicture start looper, option: ");
            sb2.append(aPTakePictureOption);
            RVLogger.d(TAG, sb2.toString());
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final Handler handler2 = new Handler(selectLooper(looper));
        if (cameraParams == null) {
            cameraParams2 = new CameraParams();
            i2 = i;
        } else {
            i2 = i;
            cameraParams2 = cameraParams;
        }
        final Camera.Size size = setupPictureParams(camera, i2, cameraParams);
        final int devOrientation = OrientationDetector.getInstance(GriverEnv.getApplicationContext()).getDevOrientation();
        try {
            handler = handler2;
        } catch (Exception e) {
            e = e;
            handler = handler2;
        }
        try {
            camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.alibaba.griver.image.capture.TakePictureProcessor.1
                {
                    TakePictureProcessor.this = this;
                }

                @Override // android.hardware.Camera.PictureCallback
                public void onPictureTaken(byte[] bArr, Camera camera2) {
                    APTakePictureOption aPTakePictureOption2 = aPTakePictureOption;
                    if (aPTakePictureOption2 != null && aPTakePictureOption2.isKeepPreview() && camera2 != null) {
                        try {
                            camera2.startPreview();
                        } catch (Exception e2) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("startPreview exp=");
                            sb3.append(e2.toString());
                            RVLogger.e(TakePictureProcessor.TAG, sb3.toString());
                        }
                    }
                    if (bArr == null) {
                        RVLogger.e(TakePictureProcessor.TAG, "onPictureTaken data is empty!!!");
                        TakePictureProcessor.this.notifyTakenPictureError(camera2, handler2, takePictureListener);
                    } else {
                        APTakePictureOption aPTakePictureOption3 = aPTakePictureOption;
                        if (aPTakePictureOption3 != null && aPTakePictureOption3.getDataType() == 1) {
                            TakePictureProcessor.this.notifyTakenPictureData(bArr, camera2, handler2, takePictureListener);
                        } else {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("onPictureTaken start to doPictureProcess size=");
                            sb4.append(size);
                            RVLogger.d(TakePictureProcessor.TAG, sb4.toString());
                            TakePictureProcessor.this.doPictureProcess(camera2, handler2, takePictureListener, bArr, cameraParams2, size, devOrientation, aPTakePictureOption);
                        }
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onPictureTaken cost: ");
                    sb5.append(System.currentTimeMillis() - currentTimeMillis);
                    RVLogger.d(TakePictureProcessor.TAG, sb5.toString());
                }
            });
        } catch (Exception e2) {
            e = e2;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("takePicture exp: ");
            sb3.append(System.currentTimeMillis() - currentTimeMillis);
            RVLogger.e(TAG, sb3.toString(), e);
            notifyTakenPictureError(camera, handler, takePictureListener);
        }
    }

    protected Camera.Size setupPictureParams(Camera camera, int i, CameraParams cameraParams) {
        Camera.Size pictureSize;
        if (cameraParams.exif != null) {
            String str = cameraParams.exif.get("minPictureHeight");
            if (!TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("minPictureHeight set to ");
                sb.append(str);
                RVLogger.d(TAG, sb.toString());
                this.f6562a = Integer.valueOf(str).intValue();
            }
        }
        if (cameraParams.getPictureSize() == null) {
            pictureSize = CameraUtils.getSuggestPictureSize(camera, this.f6562a);
        } else {
            pictureSize = cameraParams.getPictureSize();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("takePicture pictureSize: [width:");
        sb2.append(pictureSize.width);
        sb2.append(",\theight:");
        sb2.append(pictureSize.height);
        sb2.append("]");
        RVLogger.d(TAG, sb2.toString());
        Camera.Parameters parameters = camera.getParameters();
        parameters.setPictureSize(pictureSize.width, pictureSize.height);
        camera.setParameters(parameters);
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        this.mCameraFacing = cameraInfo.facing;
        return pictureSize;
    }

    protected void doPictureProcess(Camera camera, Handler handler, SightCameraView.TakePictureListener takePictureListener, byte[] bArr, CameraParams cameraParams, Camera.Size size, int i, APTakePictureOption aPTakePictureOption) {
        if (cameraParams.isConvertPicture() && this.mCameraFacing == 1) {
            a(handler, takePictureListener, bArr, size, cameraParams, i, aPTakePictureOption);
            return;
        }
        saveCommonTakePicture(handler, takePictureListener, bArr, size, cameraParams, i, aPTakePictureOption);
    }

    protected File getSaveFile(APTakePictureOption aPTakePictureOption) {
        if (aPTakePictureOption == null || !aPTakePictureOption.saveToPrivateDir) {
            return FileUtils.makeTakenPicturePath();
        }
        return FileUtils.makeTakenPicturePrivatePath();
    }

    protected Bitmap convertPicture(Bitmap bitmap, byte[] bArr, Camera.Size size, CameraParams cameraParams) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int orientation = Exif.getOrientation(bArr);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            int[] iArr = {width, height};
            StringBuilder sb = new StringBuilder();
            sb.append("convertPicture w: ");
            sb.append(width);
            sb.append(", h: ");
            sb.append(height);
            sb.append(", picSize w: ");
            sb.append(size.width);
            sb.append(", h: ");
            sb.append(size.height);
            sb.append(", fixed w: ");
            sb.append(iArr[0]);
            sb.append(", h: ");
            sb.append(iArr[1]);
            sb.append(", rotation: ");
            sb.append(orientation);
            sb.append(", facing: ");
            sb.append(this.mCameraFacing);
            RVLogger.d(TAG, sb.toString());
            if (this.mCameraFacing == 1 && cameraParams.isConvertPicture()) {
                RVLogger.d(TAG, "convertPicture doMirror");
                matrix.postScale(-1.0f, 1.0f);
            }
            if (iArr[0] != size.height || iArr[1] != size.width) {
                float scale = ImageUtils.getScale(size.height, size.width, iArr[0], iArr[1]);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("convertPicture before  fixScale: ");
                sb2.append(scale);
                RVLogger.d(TAG, sb2.toString());
                float a2 = a(scale, size.height, size.width, iArr[0], iArr[1]);
                matrix.postScale(a2, a2);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("convertPicture doScale scale: ");
                sb3.append(a2);
                RVLogger.d(TAG, sb3.toString());
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("convert bitmap result:");
            sb4.append(createBitmap.getWidth());
            sb4.append("x");
            sb4.append(createBitmap.getHeight());
            sb4.append(", cost:");
            sb4.append(System.currentTimeMillis() - currentTimeMillis);
            RVLogger.d(TAG, sb4.toString());
            return createBitmap;
        } catch (Throwable th) {
            RVLogger.e(TAG, "convert bitmap error", th);
            return null;
        }
    }

    private float a(float f, int i, int i2, int i3, int i4) {
        float pow = (float) (1.0d / Math.pow(10.0d, (double) (String.valueOf(Math.min(i, i2)).length() - 1)));
        StringBuilder sb = new StringBuilder();
        sb.append("fixScale decScale: ");
        sb.append(pow);
        RVLogger.d(TAG, sb.toString());
        while (true) {
            if (a(f, i3) && a(f, i4)) {
                return f;
            }
            f -= pow;
        }
    }

    private boolean a(float f, int i) {
        return Math.round(f * ((float) i)) % 2 == 0;
    }

    protected String savePicture(byte[] bArr, Camera.Size size, CameraParams cameraParams, int i, APTakePictureOption aPTakePictureOption) {
        StringBuilder sb = new StringBuilder();
        sb.append("savePicture data: ");
        sb.append(bArr);
        sb.append(", picSize: ");
        sb.append(size);
        sb.append(", params: ");
        sb.append(cameraParams);
        sb.append(", orientation: ");
        sb.append(i);
        RVLogger.d(TAG, sb.toString());
        if (bArr != null) {
            try {
                return savePicture(FalconFacade.get().cutImageKeepRatio(bArr, size.height, size.width), i, (Point) null, cameraParams, aPTakePictureOption);
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("falcon decode bitmap error, ");
                sb2.append(th);
                sb2.append(", save normal");
                RVLogger.w(TAG, sb2.toString());
                File saveFile = getSaveFile(aPTakePictureOption);
                try {
                    if (FileUtils.safeCopyToFile(bArr, saveFile)) {
                        return saveFile.getAbsolutePath();
                    }
                    return null;
                } catch (IOException e) {
                    RVLogger.e(TAG, "savePicture error", e);
                    return null;
                }
            }
        }
        return null;
    }

    public static boolean compressJpg(Bitmap bitmap, String str, int i) {
        if (bitmap == null || TextUtils.isEmpty(str)) {
            return false;
        }
        APEncodeOptions aPEncodeOptions = new APEncodeOptions();
        aPEncodeOptions.outputFile = str;
        aPEncodeOptions.quality = 2;
        try {
            APEncodeResult compress = ImageEncoder.compress(bitmap, aPEncodeOptions);
            StringBuilder sb = new StringBuilder();
            sb.append("compressJpg bitmap: ");
            sb.append(bitmap);
            sb.append(", outPath: ");
            sb.append(str);
            sb.append(", result: ");
            sb.append(compress);
            RVLogger.d(TAG, sb.toString());
            return compress.isSuccess();
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("compressJpg native error, bitmap: ");
            sb2.append(bitmap);
            sb2.append(", outPath: ");
            sb2.append(str);
            RVLogger.e(TAG, sb2.toString(), th);
            return false;
        }
    }

    private void a(int i, CameraParams cameraParams) {
        if (i == 0 || cameraParams.autoRotateTakenPicture) {
            return;
        }
        if (cameraParams.exif == null) {
            cameraParams.exif = new HashMap();
        }
        if (i == 90) {
            cameraParams.exif.put("Orientation", "6");
        } else if (i == 180) {
            cameraParams.exif.put("Orientation", "3");
        } else if (i == 270) {
            cameraParams.exif.put("Orientation", "8");
        }
    }

    protected void notifyProcessPictureError(Handler handler, final SightCameraView.TakePictureListener takePictureListener, final int i, final byte[] bArr) {
        handler.post(new Runnable() { // from class: com.alibaba.griver.image.capture.TakePictureProcessor.2
            {
                TakePictureProcessor.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                takePictureListener.onPictureProcessError(i, bArr);
            }
        });
    }

    protected void notifyTakenPictureError(final Camera camera, Handler handler, final SightCameraView.TakePictureListener takePictureListener) {
        handler.post(new Runnable() { // from class: com.alibaba.griver.image.capture.TakePictureProcessor.3
            {
                TakePictureProcessor.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                takePictureListener.onPictureTakenError(1, camera);
            }
        });
    }

    protected void notifyTakenPictureData(final byte[] bArr, Camera camera, Handler handler, final SightCameraView.TakePictureListener takePictureListener) {
        handler.post(new Runnable() { // from class: com.alibaba.griver.image.capture.TakePictureProcessor.4
            {
                TakePictureProcessor.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (takePictureListener instanceof SightCameraView.APTakePictureListener) {
                    APTakePicRsp aPTakePicRsp = new APTakePicRsp();
                    aPTakePicRsp.data = bArr;
                    aPTakePicRsp.dataType = 1;
                    ((SightCameraView.APTakePictureListener) takePictureListener).onPictureProcessFinish(aPTakePicRsp);
                }
            }
        });
    }

    protected void notifyTakenPictureBitmap(final Bitmap bitmap, Handler handler, final SightCameraView.TakePictureListener takePictureListener, final int i, final byte[] bArr) {
        handler.post(new Runnable() { // from class: com.alibaba.griver.image.capture.TakePictureProcessor.5
            {
                TakePictureProcessor.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!ImageUtils.checkBitmap(bitmap)) {
                    takePictureListener.onPictureProcessError(2, bArr);
                } else if (takePictureListener instanceof SightCameraView.APTakePictureListener) {
                    APTakePicRsp aPTakePicRsp = new APTakePicRsp();
                    aPTakePicRsp.bitmap = bitmap;
                    aPTakePicRsp.orientation = i;
                    aPTakePicRsp.dataType = 2;
                    ((SightCameraView.APTakePictureListener) takePictureListener).onPictureProcessFinish(aPTakePicRsp);
                }
            }
        });
    }

    protected void notifyProcessFinished(final String str, final APImageInfo aPImageInfo, Handler handler, final SightCameraView.TakePictureListener takePictureListener) {
        if (aPImageInfo == null) {
            notifyProcessPictureError(handler, takePictureListener, 103, null);
            return;
        }
        long j = 0;
        if (takePictureListener instanceof SightCameraView.TakePictureMPListener) {
            try {
                j = new File(str).length();
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("notifyProcessFinished get file size error,  ");
                sb.append(th.toString());
                RVLogger.d(TAG, sb.toString());
            }
        }
        final long j2 = j;
        handler.post(new Runnable() { // from class: com.alibaba.griver.image.capture.TakePictureProcessor.6
            {
                TakePictureProcessor.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("notifyProcessFinished notify save process picture success, path: ");
                sb2.append(str);
                sb2.append(", info: ");
                sb2.append(aPImageInfo);
                RVLogger.d(TakePictureProcessor.TAG, sb2.toString());
                SightCameraView.TakePictureListener takePictureListener2 = takePictureListener;
                if (takePictureListener2 instanceof SightCameraView.TakePictureMPListener) {
                    Bundle bundle = new Bundle();
                    bundle.putLong("picSize", j2);
                    ((SightCameraView.TakePictureMPListener) takePictureListener).onPictureProcessFinish(str, aPImageInfo.width, aPImageInfo.height, aPImageInfo.orientation, bundle);
                } else if (takePictureListener2 instanceof SightCameraView.APTakePictureListener) {
                    APTakePicRsp aPTakePicRsp = new APTakePicRsp();
                    aPTakePicRsp.dataType = 0;
                    aPTakePicRsp.savePath = str;
                    aPTakePicRsp.width = aPImageInfo.width;
                    aPTakePicRsp.height = aPImageInfo.height;
                    aPTakePicRsp.orientation = aPImageInfo.orientation;
                    ((SightCameraView.APTakePictureListener) takePictureListener).onPictureProcessFinish(aPTakePicRsp);
                } else {
                    takePictureListener2.onPictureProcessFinish(str, aPImageInfo.width, aPImageInfo.height, aPImageInfo.orientation);
                }
            }
        });
    }

    protected Looper selectLooper(Looper looper) {
        return looper == null ? Looper.getMainLooper() : looper;
    }

    protected boolean saveCommonTakePicture(final Handler handler, final SightCameraView.TakePictureListener takePictureListener, final byte[] bArr, final Camera.Size size, final CameraParams cameraParams, final int i, final APTakePictureOption aPTakePictureOption) {
        RVLogger.d(TAG, "saveCommonTakePicture");
        GriverExecutors.getExecutor(ExecutorType.NORMAL).execute(new Runnable() { // from class: com.alibaba.griver.image.capture.TakePictureProcessor.7
            {
                TakePictureProcessor.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                APTakePictureOption aPTakePictureOption2 = aPTakePictureOption;
                if (aPTakePictureOption2 != null && aPTakePictureOption2.getDataType() == 2) {
                    Bitmap bitmap = null;
                    if (bArr != null) {
                        try {
                            bitmap = TakePictureProcessor.this.a(aPTakePictureOption, cameraParams, FalconFacade.get().cutImageKeepRatio(bArr, size.height, size.width), i);
                        } catch (Throwable th) {
                            RVLogger.e(TakePictureProcessor.TAG, "saveCommonTakePicture exp", th);
                        }
                    }
                    TakePictureProcessor.this.notifyTakenPictureBitmap(bitmap, handler, takePictureListener, i, bArr);
                    return;
                }
                String savePicture = TakePictureProcessor.this.savePicture(bArr, size, cameraParams, i, aPTakePictureOption);
                APImageInfo imageInfo = APImageInfo.getImageInfo(savePicture);
                if (!TextUtils.isEmpty(savePicture) && imageInfo != null) {
                    TakePictureProcessor.this.notifyProcessFinished(savePicture, imageInfo, handler, takePictureListener);
                } else {
                    TakePictureProcessor.this.notifyProcessPictureError(handler, takePictureListener, 103, bArr);
                }
            }
        });
        return true;
    }

    public Bitmap a(APTakePictureOption aPTakePictureOption, CameraParams cameraParams, Bitmap bitmap, int i) {
        boolean z = true;
        if (cameraParams.mActivityRotation >= 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(cameraParams.mActivityRotation);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } else if (i != 0 && cameraParams.autoRotateTakenPicture && ImageUtils.checkBitmap(bitmap)) {
            Matrix matrix2 = new Matrix();
            matrix2.postRotate(i);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true);
        } else {
            z = false;
        }
        if (!z) {
            i = 0;
        }
        return cropBitmap(aPTakePictureOption, bitmap, i);
    }

    private void a(Handler handler, SightCameraView.TakePictureListener takePictureListener, byte[] bArr, Camera.Size size, CameraParams cameraParams, int i, APTakePictureOption aPTakePictureOption) {
        String str;
        Bitmap convertPicture;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("falconFacade decode picture, pictureSize: [");
            sb.append(size.height);
            sb.append("x");
            sb.append(size.width);
            sb.append("]");
            RVLogger.d(TAG, sb.toString());
            convertPicture = convertPicture(FalconFacade.get().cutImageKeepRatio(bArr, size.height, size.width), bArr, size, cameraParams);
        } catch (Throwable th) {
            RVLogger.e(TAG, "process mirror error", th);
            str = null;
        }
        if (aPTakePictureOption != null && aPTakePictureOption.getDataType() == 2) {
            notifyTakenPictureBitmap(cropBitmap(aPTakePictureOption, convertPicture, i), handler, takePictureListener, i, bArr);
            return;
        }
        str = savePicture(convertPicture, i, (Point) null, cameraParams, aPTakePictureOption);
        if (str != null) {
            notifyProcessFinished(str, APImageInfo.getImageInfo(str), handler, takePictureListener);
        } else {
            notifyProcessPictureError(handler, takePictureListener, 103, bArr);
        }
    }

    private void a(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("addExif path: ");
        sb.append(str);
        sb.append(", exif: ");
        sb.append(map);
        RVLogger.d(TAG, sb.toString());
        if (map == null || map.isEmpty() || !FileUtils.checkFile(str)) {
            return;
        }
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                exifInterface.setAttribute(entry.getKey(), entry.getValue());
            }
            exifInterface.saveAttributes();
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("addExif error, path: ");
            sb2.append(str);
            sb2.append(", exif: ");
            sb2.append(map);
            RVLogger.e(TAG, sb2.toString(), e);
        }
    }

    protected Bitmap cropBitmap(APTakePictureOption aPTakePictureOption, Bitmap bitmap, int i) {
        int i2;
        int i3;
        if (aPTakePictureOption == null || aPTakePictureOption.getAspectRatio() <= 0.0f || !ImageUtils.checkBitmap(bitmap)) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = width;
        float f2 = height;
        float f3 = f / f2;
        try {
            float aspectRatio = aPTakePictureOption.getAspectRatio();
            if (i == 90 || i == 270) {
                aspectRatio = 1.0f / aPTakePictureOption.getAspectRatio();
            }
            if (f3 > aspectRatio) {
                i3 = (int) (f2 * aspectRatio);
                i2 = height;
            } else {
                i2 = (int) (f / aspectRatio);
                i3 = width;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("bitmap crop cropW:");
            sb.append(i3);
            sb.append("cropH:");
            sb.append(i2);
            RVLogger.d(TAG, sb.toString());
            return Bitmap.createBitmap(bitmap, (width - i3) / 2, (height - i2) / 2, i3, i2);
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("cropBitmap error: ");
            sb2.append(th.toString());
            RVLogger.e(TAG, sb2.toString(), th);
            return bitmap;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x009b A[Catch: all -> 0x01d2, TryCatch #0 {all -> 0x01d2, blocks: (B:51:0x0031, B:56:0x0061, B:58:0x0065, B:60:0x006c, B:62:0x007c, B:64:0x0097, B:66:0x009b, B:73:0x00e0, B:75:0x00e4, B:77:0x00e8, B:79:0x00ee, B:81:0x0171, B:85:0x0181, B:87:0x0187, B:89:0x01c5, B:84:0x017d, B:80:0x016d, B:68:0x00bb, B:70:0x00bf, B:72:0x00c5, B:61:0x0074), top: B:94:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x017d A[Catch: all -> 0x01d2, TryCatch #0 {all -> 0x01d2, blocks: (B:51:0x0031, B:56:0x0061, B:58:0x0065, B:60:0x006c, B:62:0x007c, B:64:0x0097, B:66:0x009b, B:73:0x00e0, B:75:0x00e4, B:77:0x00e8, B:79:0x00ee, B:81:0x0171, B:85:0x0181, B:87:0x0187, B:89:0x01c5, B:84:0x017d, B:80:0x016d, B:68:0x00bb, B:70:0x00bf, B:72:0x00c5, B:61:0x0074), top: B:94:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0187 A[Catch: all -> 0x01d2, TryCatch #0 {all -> 0x01d2, blocks: (B:51:0x0031, B:56:0x0061, B:58:0x0065, B:60:0x006c, B:62:0x007c, B:64:0x0097, B:66:0x009b, B:73:0x00e0, B:75:0x00e4, B:77:0x00e8, B:79:0x00ee, B:81:0x0171, B:85:0x0181, B:87:0x0187, B:89:0x01c5, B:84:0x017d, B:80:0x016d, B:68:0x00bb, B:70:0x00bf, B:72:0x00c5, B:61:0x0074), top: B:94:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01c5 A[Catch: all -> 0x01d2, TRY_LEAVE, TryCatch #0 {all -> 0x01d2, blocks: (B:51:0x0031, B:56:0x0061, B:58:0x0065, B:60:0x006c, B:62:0x007c, B:64:0x0097, B:66:0x009b, B:73:0x00e0, B:75:0x00e4, B:77:0x00e8, B:79:0x00ee, B:81:0x0171, B:85:0x0181, B:87:0x0187, B:89:0x01c5, B:84:0x017d, B:80:0x016d, B:68:0x00bb, B:70:0x00bf, B:72:0x00c5, B:61:0x0074), top: B:94:0x0031 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.String savePicture(android.graphics.Bitmap r20, int r21, android.graphics.Point r22, com.alibaba.griver.image.capture.meta.CameraParams r23, com.alibaba.griver.image.capture.meta.APTakePictureOption r24) {
        /*
            Method dump skipped, instructions count: 473
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.capture.TakePictureProcessor.savePicture(android.graphics.Bitmap, int, android.graphics.Point, com.alibaba.griver.image.capture.meta.CameraParams, com.alibaba.griver.image.capture.meta.APTakePictureOption):java.lang.String");
    }
}
