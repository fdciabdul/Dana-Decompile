package com.otaliastudios.cameraview;

import android.graphics.PointF;

/* loaded from: classes2.dex */
public abstract class CameraListener {
    public void onAutoFocusEnd(boolean z, PointF pointF) {
    }

    public void onAutoFocusStart(PointF pointF) {
    }

    public void onCameraClosed() {
    }

    public void onCameraError(CameraException cameraException) {
    }

    public void onCameraOpened(CameraOptions cameraOptions) {
    }

    public void onExposureCorrectionChanged(float f, float[] fArr, PointF[] pointFArr) {
    }

    public void onOrientationChanged(int i) {
    }

    public void onPictureTaken(PictureResult pictureResult) {
    }

    public void onVideoRecordingEnd() {
    }

    public void onVideoRecordingStart() {
    }

    public void onVideoTaken(VideoResult videoResult) {
    }

    public void onZoomChanged(float f, float[] fArr, PointF[] pointFArr) {
    }
}
