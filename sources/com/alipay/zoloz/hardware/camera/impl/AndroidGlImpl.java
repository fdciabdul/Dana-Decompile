package com.alipay.zoloz.hardware.camera.impl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import java.io.IOException;

/* loaded from: classes7.dex */
public class AndroidGlImpl extends AbsCameraImpl {
    private static AndroidGlImpl mCameraInterface;

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void startPreview(SurfaceHolder surfaceHolder, float f, int i, int i2) {
    }

    private AndroidGlImpl(Context context) {
        super(context);
    }

    public static AndroidGlImpl getInstance(Context context) {
        AndroidGlImpl androidGlImpl;
        synchronized (AndroidGlImpl.class) {
            if (mCameraInterface == null) {
                mCameraInterface = new AndroidGlImpl(context);
            }
            mCameraInterface.initContext(context);
            androidGlImpl = mCameraInterface;
        }
        return androidGlImpl;
    }

    public void startPreview(SurfaceTexture surfaceTexture) {
        if (this.isPreviewing || this.mCamera == null) {
            return;
        }
        try {
            this.mCamera.setPreviewTexture(surfaceTexture);
            this.mCamera.startPreview();
        } catch (IOException unused) {
        }
        this.isPreviewing = true;
    }

    @Override // com.alipay.zoloz.hardware.camera.impl.AbsCameraImpl, com.alipay.zoloz.hardware.camera.ICameraInterface
    public void releaseCamera() {
        super.releaseCamera();
        mCameraInterface = null;
    }
}
