package com.alipay.zoloz.hardware.camera.impl;

import android.content.Context;
import android.view.SurfaceHolder;

/* loaded from: classes7.dex */
public class AndroidImpl extends AbsCameraImpl {
    private static AndroidImpl mCameraInterface;

    private AndroidImpl(Context context) {
        super(context);
    }

    public static AndroidImpl getInstance(Context context) {
        AndroidImpl androidImpl;
        synchronized (AndroidImpl.class) {
            if (mCameraInterface == null) {
                mCameraInterface = new AndroidImpl(context);
            }
            mCameraInterface.initContext(context);
            androidImpl = mCameraInterface;
        }
        return androidImpl;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void startPreview(SurfaceHolder surfaceHolder, float f, int i, int i2) {
        if (this.isPreviewing || this.mCamera == null) {
            return;
        }
        try {
            this.mCamera.setPreviewDisplay(surfaceHolder);
            this.mCamera.startPreview();
            this.isPreviewing = true;
        } catch (Exception unused) {
            if (this.mCameraCallback != null) {
                this.mCameraCallback.onError(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.zoloz.hardware.camera.impl.AbsCameraImpl
    public void adjustPreview() {
        super.adjustPreview();
        this.mCamera.setDisplayOrientation(this.mCameraViewRotationAngle);
    }

    @Override // com.alipay.zoloz.hardware.camera.impl.AbsCameraImpl, com.alipay.zoloz.hardware.camera.ICameraInterface
    public void releaseCamera() {
        super.releaseCamera();
        mCameraInterface = null;
    }
}
