package com.alibaba.griver.image.capture.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.AttributeSet;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.image.capture.utils.VideoUtils;
import java.io.IOException;

/* loaded from: classes6.dex */
public class SightCameraTextureView extends CameraView {
    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setup() {
    }

    public SightCameraTextureView(Context context) {
        super(context);
    }

    public SightCameraTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SightCameraTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.alibaba.griver.image.capture.widget.CameraView
    protected void handleOnSurfaceTextureAvailable(SurfaceTexture surfaceTexture) {
        if (this.mInitCameraAsync) {
            if (this.mCameraStatus == 0) {
                synchronized (this.mCameraInitLock) {
                    if (this.mCameraStatus == 0) {
                        try {
                            this.mCameraInitLock.wait();
                        } catch (InterruptedException e) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("InterruptedException:");
                            sb.append(e.getMessage());
                            RVLogger.e(sb.toString());
                        }
                    }
                }
            }
            if (this.mCameraStatus == 1) {
                notifyOpenCameraError();
                return;
            } else if (getParent() instanceof SightCameraViewImpl) {
                post(new Runnable() { // from class: com.alibaba.griver.image.capture.widget.SightCameraTextureView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SightCameraTextureView.this.reLayout();
                    }
                });
            }
        } else {
            try {
                initCamera(true);
            } catch (Exception e2) {
                RVLogger.e(CameraView.TAG, "handleOnSurfaceTextureAvailable", e2);
                notifyOpenCameraError();
                return;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Camera Time get surfaceTexture and init camera cost=");
        sb2.append(System.currentTimeMillis() - sCreateTime);
        RVLogger.d(sb2.toString());
        if (VideoUtils.previewRunning(this.mCamera)) {
            RVLogger.d("preview is running, stop it.");
            this.mCamera.stopPreview();
        }
        try {
            this.mCamera.setPreviewTexture(this.mSurfaceTexture);
            startPreview();
            notifyPrepared();
        } catch (Exception e3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("onSurfaceTextureAvailable exp:");
            sb3.append(e3.getMessage());
            RVLogger.e(CameraView.TAG, sb3.toString(), e3);
            notifyOpenCameraError();
        }
    }

    @Override // com.alibaba.griver.image.capture.widget.CameraView
    public Camera switchCamera() {
        if (this.isSwitching) {
            StringBuilder sb = new StringBuilder();
            sb.append(this);
            sb.append(" switchCamera isSwitching return");
            RVLogger.d(sb.toString());
            return null;
        }
        this.isSwitching = true;
        releaseCamera();
        if (this.mCameraFacing == 0) {
            this.mCameraFacing = 1;
        } else {
            this.mCameraFacing = 0;
        }
        try {
            initCamera(true);
            try {
                this.mCamera.setPreviewTexture(this.mSurfaceTexture);
            } catch (IOException e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("setPreviewTexture: ");
                sb2.append(e);
                RVLogger.d(sb2.toString());
            }
            startPreview();
            setup();
            this.isSwitching = false;
            return this.mCamera;
        } catch (Exception e2) {
            RVLogger.e(CameraView.TAG, "switchCamera", e2);
            this.isSwitching = false;
            notifyOpenCameraError();
            return null;
        }
    }

    @Override // com.alibaba.griver.image.capture.widget.CameraView
    public Camera reopenCamera(int i) {
        releaseCamera();
        try {
            initCamera(true);
            try {
                this.mCamera.setPreviewTexture(this.mSurfaceTexture);
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("setPreviewTexture: ");
                sb.append(e);
                RVLogger.d(sb.toString());
            }
            startPreview();
            return this.mCamera;
        } catch (Exception e2) {
            RVLogger.e(CameraView.TAG, "reopenCamera", e2);
            notifyOpenCameraError();
            return null;
        }
    }

    @Override // com.alibaba.griver.image.capture.widget.CameraView
    protected void afterReopen() {
        setup();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append("###onSurfaceTextureSizeChanged w:");
        sb.append(i);
        sb.append(", h:");
        sb.append(i2);
        RVLogger.d(sb.toString());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append("###onSurfaceTextureDestroyed");
        RVLogger.d(sb.toString());
        return true;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        StringBuilder sb = new StringBuilder();
        sb.append("onWindowFocusChanged hasWindowFocus: ");
        sb.append(z);
        RVLogger.d(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.griver.image.capture.widget.CameraView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RVLogger.d("onDetachedFromWindow");
    }
}
