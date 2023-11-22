package com.alipay.zoloz.hardware.camera.widget.gl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.alipay.mobile.security.faceauth.circle.protocol.DeviceSetting;
import com.alipay.zoloz.hardware.camera.ICameraCallback;
import com.alipay.zoloz.hardware.camera.ICameraInterface;
import com.alipay.zoloz.hardware.camera.impl.AndroidGlImpl;
import com.alipay.zoloz.hardware.camera.utils.DeviceSettingUtil;
import com.alipay.zoloz.hardware.camera.widget.AbsSurfaceView;

/* loaded from: classes7.dex */
public class CameraGLSurfaceView extends GLSurfaceView implements AbsSurfaceView {
    private ICameraCallback mCameraCallback;
    private AndroidGlImpl mCameraInterface;
    private GLCameraSurfaceViewRenderer mRenderer;
    private SurfaceTexture mSurfaceTexture;
    private int mTextureId;

    public CameraGLSurfaceView(Context context) {
        super(context);
        initialize(context, null);
    }

    public CameraGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context, attributeSet);
    }

    private void initialize(Context context, AttributeSet attributeSet) {
        getCameraInterface();
        setEGLContextClientVersion(2);
        this.mRenderer = new GLCameraSurfaceViewRenderer(this);
        setZOrderOnTop(false);
        setEGLConfigChooser(8, 8, 8, 8, 0, 0);
        getHolder().setFormat(1);
        setRenderer(this.mRenderer);
        setRenderMode(0);
    }

    public void setCornerSize(float f) {
        this.mRenderer.setCornerSize(f);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
        getCameraInterface();
        this.mRenderer.setCameraInterface(this.mCameraInterface);
        this.mCameraInterface.setCallback(this.mCameraCallback);
        this.mCameraInterface.startCamera();
        ICameraCallback iCameraCallback = this.mCameraCallback;
        if (iCameraCallback != null) {
            iCameraCallback.onSurfaceCreated();
        }
        AndroidGlImpl androidGlImpl = this.mCameraInterface;
        if (androidGlImpl == null || !androidGlImpl.isCameraStart) {
            return;
        }
        createTexture();
        this.mRenderer.setSurfaceTexture(this.mTextureId, this.mSurfaceTexture);
        queueEvent(new Runnable() { // from class: com.alipay.zoloz.hardware.camera.widget.gl.CameraGLSurfaceView.1
            @Override // java.lang.Runnable
            public void run() {
                if (CameraGLSurfaceView.this.mCameraInterface != null) {
                    CameraGLSurfaceView.this.mCameraInterface.startPreview(CameraGLSurfaceView.this.mSurfaceTexture);
                }
            }
        });
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        AndroidGlImpl androidGlImpl;
        GLES20.glViewport(0, 0, i2, i3);
        super.surfaceChanged(surfaceHolder, i, i2, i3);
        if (this.mCameraCallback == null || (androidGlImpl = this.mCameraInterface) == null) {
            return;
        }
        int cameraViewRotation = androidGlImpl.getCameraViewRotation();
        int previewWidth = this.mCameraInterface.getPreviewWidth();
        int previewHeight = this.mCameraInterface.getPreviewHeight();
        if (cameraViewRotation % 180 == 90) {
            previewHeight = this.mCameraInterface.getPreviewWidth();
            previewWidth = this.mCameraInterface.getPreviewHeight();
        }
        this.mCameraCallback.onSurfaceChanged(previewWidth, previewHeight);
    }

    private void createTexture() {
        synchronized (this) {
            if (this.mSurfaceTexture == null) {
                this.mTextureId = createTextureID();
                SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureId);
                this.mSurfaceTexture = surfaceTexture;
                surfaceTexture.setOnFrameAvailableListener(this.mRenderer);
            }
        }
    }

    protected int createTextureID() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        return iArr[0];
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.mCameraInterface.stopCamera();
        this.mCameraInterface.setCallback(null);
        this.mCameraInterface = null;
        super.surfaceDestroyed(surfaceHolder);
        ICameraCallback iCameraCallback = this.mCameraCallback;
        if (iCameraCallback != null) {
            iCameraCallback.onSurfaceDestroyed();
        }
    }

    @Override // com.alipay.zoloz.hardware.camera.widget.AbsSurfaceView
    public ICameraInterface getCameraInterface() {
        if (this.mCameraInterface == null) {
            this.mCameraInterface = AndroidGlImpl.getInstance(getContext());
        }
        return this.mCameraInterface;
    }

    @Override // com.alipay.zoloz.hardware.camera.widget.AbsSurfaceView
    public void setCameraCallback(ICameraCallback iCameraCallback) {
        this.mCameraCallback = iCameraCallback;
    }

    @Override // com.alipay.zoloz.hardware.camera.widget.AbsSurfaceView
    public void init(DeviceSetting[] deviceSettingArr) {
        DeviceSetting propertyDeviceSetting = DeviceSettingUtil.getPropertyDeviceSetting(deviceSettingArr);
        AndroidGlImpl androidGlImpl = this.mCameraInterface;
        if (androidGlImpl != null) {
            androidGlImpl.initCamera(propertyDeviceSetting);
        }
    }
}
