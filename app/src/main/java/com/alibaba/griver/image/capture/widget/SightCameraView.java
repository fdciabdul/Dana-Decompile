package com.alibaba.griver.image.capture.widget;

import android.content.Context;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.alibaba.griver.image.capture.meta.APTakePicRsp;
import com.alibaba.griver.image.capture.meta.APTakePictureOption;
import com.alibaba.griver.image.capture.meta.APVideoRecordRsp;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes6.dex */
public class SightCameraView extends FrameLayout {
    public static final int BUFFER_TYPE_AAC = 2;
    public static final int BUFFER_TYPE_PCM = 1;
    public static final int FRAME_TYPE_TEXTUREID = 1;
    public static final int FRAME_TYPE_YUV = 2;
    public static final int MODE_PHOTO = 1;
    public static final int MODE_VIDEO = 0;

    /* loaded from: classes6.dex */
    public interface APTakePictureListener extends TakePictureListener {
        void onPictureProcessFinish(APTakePicRsp aPTakePicRsp);
    }

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes3.dex */
    public @interface BufferType {
    }

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes3.dex */
    public @interface FrameType {
    }

    /* loaded from: classes6.dex */
    public interface ICameraFrameListener {
        void onFrameData(Object obj, int i, Bundle bundle);
    }

    /* loaded from: classes6.dex */
    public interface OnRecordListener {
        void onCancel();

        void onError(APVideoRecordRsp aPVideoRecordRsp);

        void onFinish(APVideoRecordRsp aPVideoRecordRsp);

        void onInfo(int i, Bundle bundle);

        void onPrepared(APVideoRecordRsp aPVideoRecordRsp);

        void onStart();
    }

    /* loaded from: classes6.dex */
    public interface OnScrollListener {
        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);
    }

    /* loaded from: classes6.dex */
    public interface TakePictureListener {
        public static final int ERROR_DECODE_TAKEN_PICTURE = 2;
        public static final int ERROR_RENDER_NOT_EXISTS = 101;
        public static final int ERROR_RENDER_PROCESS = 102;
        public static final int ERROR_SAVE_PROCESS_PICTURE = 103;
        public static final int ERROR_TAKEN_PICTURE = 1;

        void onPictureProcessError(int i, byte[] bArr);

        void onPictureProcessFinish(String str, int i, int i2, int i3);

        void onPictureProcessStart();

        void onPictureTaken(byte[] bArr, Camera camera);

        void onPictureTakenError(int i, Camera camera);
    }

    /* loaded from: classes6.dex */
    public interface TakePictureMPListener extends TakePictureListener {
        void onPictureProcessFinish(String str, int i, int i2, int i3, Bundle bundle);
    }

    public Camera getCamera() {
        return null;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void releaseCamera() {
    }

    public Camera switchCamera() {
        return null;
    }

    public void takePicture(TakePictureListener takePictureListener, Looper looper, APTakePictureOption aPTakePictureOption) {
    }

    public SightCameraView(Context context) {
        super(context);
    }

    public void setOnRecordListener(OnRecordListener onRecordListener) {
        InstrumentInjector.log_d("ylf", "shell setOnRecordListener");
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        InstrumentInjector.log_d("ylf", "shell setOnScrollListener");
    }
}
