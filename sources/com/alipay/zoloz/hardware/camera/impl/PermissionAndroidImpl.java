package com.alipay.zoloz.hardware.camera.impl;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alipay.android.phone.zoloz.camera.BuildConfig;
import com.alipay.mobile.security.bio.common.record.MetaRecord;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.ZimRecordService;
import com.alipay.mobile.security.bio.utils.DisplayUtil;
import com.alipay.mobile.security.faceauth.circle.protocol.DeviceSetting;
import com.alipay.zoloz.hardware.camera.CameraData;
import com.alipay.zoloz.hardware.camera.CameraParams;
import com.alipay.zoloz.hardware.camera.ICameraCallback;
import com.alipay.zoloz.hardware.camera.ICameraInterface;
import com.alipay.zoloz.hardware.camera.utils.AndroidCameraUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class PermissionAndroidImpl implements ICameraInterface, Camera.AutoFocusMoveCallback {
    private Camera mCamera;
    private ICameraCallback mCameraCallback;
    private int mCameraID;
    private Context mContext;
    private Camera.Parameters mParams;
    private Handler mWorkHandler;
    private HandlerThread mWorkHandlerThread;
    private final int AUTO_FOCUS_DELAY = 5000;
    private boolean isCameraInit = false;
    private DeviceSetting mDeviceSetting = null;
    private int mCameraViewRotationAngle = 90;
    private boolean isCameraStart = false;
    private int mWidth = 0;
    private int mHeight = 0;
    private int mPreviewWidth = 0;
    private int mPreviewHeight = 0;
    private final Object mLock = new Object();
    private boolean isPreviewing = false;
    private int mPreferPreviewWidth = 0;
    private int mPreferPreviewHeight = 0;
    private boolean mOneShotePreviewCallback = false;
    private boolean isFront = true;
    private boolean focusStatus = false;
    private Runnable mRestFocusRunnable = new Runnable() { // from class: com.alipay.zoloz.hardware.camera.impl.PermissionAndroidImpl.1
        @Override // java.lang.Runnable
        public void run() {
            if (PermissionAndroidImpl.this.mCamera != null) {
                try {
                    Camera.Parameters parameters = PermissionAndroidImpl.this.mCamera.getParameters();
                    int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                    int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                    if (maxNumFocusAreas > 0) {
                        parameters.setFocusAreas(null);
                    }
                    if (maxNumMeteringAreas > 0) {
                        parameters.setMeteringAreas(null);
                    }
                    PermissionAndroidImpl.this.adjustBestFocusMode(parameters);
                } catch (Exception unused) {
                }
            }
        }
    };

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void closeCamera() {
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public PointF colorToDepth(PointF pointF) {
        return null;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public PointF depthToColor(PointF pointF) {
        return null;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public CameraParams getCameraParams() {
        return null;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public String getCameraSN() {
        return null;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public int getColorMode() {
        return 0;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public int getDepthHeight() {
        return 0;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public int getDepthWidth() {
        return 0;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public String getFirmwareVersion() {
        return null;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public Rect getROI() {
        return null;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public Object getUVCCamera() {
        return null;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public boolean isMirror() {
        return false;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void openCamera(DeviceSetting deviceSetting) {
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void setFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustBestFocusMode(Camera.Parameters parameters) {
        String bestFocusMode = getBestFocusMode(parameters, this.isFront);
        if (!TextUtils.isEmpty(bestFocusMode)) {
            parameters.setFocusMode(bestFocusMode);
        }
        this.mCamera.setParameters(parameters);
        this.mCamera.setAutoFocusMoveCallback(this);
    }

    public PermissionAndroidImpl(Context context) {
        this.mContext = context;
        HandlerThread handlerThread = new HandlerThread("Camera-work");
        this.mWorkHandlerThread = handlerThread;
        handlerThread.start();
        this.mWorkHandler = new Handler(this.mWorkHandlerThread.getLooper());
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void initCamera(DeviceSetting deviceSetting) {
        if (this.isCameraInit) {
            return;
        }
        recordLog("ztech_enter");
        this.mDeviceSetting = deviceSetting;
        this.isCameraInit = true;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void initCamera(int i, int i2, boolean z) {
        this.mPreferPreviewWidth = i;
        this.mPreferPreviewHeight = i2;
        this.mOneShotePreviewCallback = z;
        this.mDeviceSetting = new DeviceSetting();
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void releaseCamera() {
        this.mWorkHandler.removeCallbacks(this.mRestFocusRunnable);
        this.mWorkHandlerThread.quitSafely();
        this.isCameraInit = false;
        this.mContext = null;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void startCamera() {
        if (this.isCameraStart) {
            return;
        }
        DeviceSetting deviceSetting = this.mDeviceSetting;
        if (realStartCamera(AndroidCameraUtil.adjustCameraId(this.mContext, (deviceSetting == null || deviceSetting.isCameraAuto()) ? 1 : this.mDeviceSetting.getCameraID(), Camera.getNumberOfCameras()))) {
            this.isCameraStart = true;
            ICameraCallback iCameraCallback = this.mCameraCallback;
            if (iCameraCallback != null) {
                iCameraCallback.onSuccess();
            }
        }
    }

    private boolean realStartCamera(int i) {
        Camera open = Camera.open(i);
        this.mCamera = open;
        if (open == null) {
            this.mCameraCallback.onError(1);
            return false;
        }
        this.mCameraID = i;
        if (open != null) {
            this.mParams = open.getParameters();
            adjustCameraParams();
            if (this.mOneShotePreviewCallback) {
                this.mCamera.setOneShotPreviewCallback(new Camera.PreviewCallback() { // from class: com.alipay.zoloz.hardware.camera.impl.PermissionAndroidImpl.2
                    @Override // android.hardware.Camera.PreviewCallback
                    public void onPreviewFrame(byte[] bArr, Camera camera) {
                    }
                });
            } else if (this.mCameraCallback != null) {
                this.mCamera.setPreviewCallback(new Camera.PreviewCallback() { // from class: com.alipay.zoloz.hardware.camera.impl.PermissionAndroidImpl.3
                    @Override // android.hardware.Camera.PreviewCallback
                    public void onPreviewFrame(byte[] bArr, Camera camera) {
                        if (bArr == null || PermissionAndroidImpl.this.mCameraCallback == null) {
                            return;
                        }
                        PermissionAndroidImpl.this.mCameraCallback.onPreviewFrame(new CameraData(ByteBuffer.wrap(bArr), PermissionAndroidImpl.this.mWidth, PermissionAndroidImpl.this.mHeight, 0, null, 0, 0, PermissionAndroidImpl.this.mPreviewWidth, PermissionAndroidImpl.this.mPreviewHeight));
                    }
                });
            }
            return true;
        }
        return false;
    }

    private void adjustCameraParams() {
        if (this.mParams != null) {
            if (this.mCameraID == AndroidCameraUtil.findBackCameraId()) {
                this.isFront = false;
                adjustBackCameraParams();
                return;
            }
            this.isFront = true;
            adjustFrontCameraParams();
        }
    }

    private void adjustFrontCameraParams() {
        Camera.Parameters parameters = this.mParams;
        if (parameters != null) {
            if (isSupported(parameters.getSupportedPreviewSizes(), this.mPreferPreviewWidth, this.mPreferPreviewHeight)) {
                this.mPreviewWidth = this.mPreferPreviewWidth;
                this.mPreviewHeight = this.mPreferPreviewHeight;
            } else {
                Camera.Size propPreviewSize = AndroidCameraUtil.getInstance().getPropPreviewSize(this.mParams.getSupportedPreviewSizes(), DisplayUtil.getScreenRate(this.mContext), 600);
                if (propPreviewSize != null) {
                    this.mPreviewWidth = propPreviewSize.width;
                    this.mPreviewHeight = propPreviewSize.height;
                }
            }
            int i = this.mPreviewWidth;
            this.mWidth = i;
            int i2 = this.mPreviewHeight;
            this.mHeight = i2;
            this.mParams.setPreviewSize(i, i2);
            DeviceSetting deviceSetting = this.mDeviceSetting;
            if (deviceSetting != null) {
                int cameraAutoAngle = getCameraAutoAngle(deviceSetting);
                this.mCameraViewRotationAngle = cameraAutoAngle;
                this.mCamera.setDisplayOrientation(cameraAutoAngle);
            }
            adjustBestFocusMode(this.mParams);
        }
    }

    private void adjustBackCameraParams() {
        if (this.mParams != null) {
            Camera.Size backCameraPreviewSize = AndroidCameraUtil.getInstance().getBackCameraPreviewSize(this.mParams.getSupportedPreviewSizes(), DisplayUtil.getScreenRate(this.mContext), 1024, 2500);
            if (backCameraPreviewSize != null) {
                this.mPreviewWidth = backCameraPreviewSize.width;
                int i = backCameraPreviewSize.height;
                this.mPreviewHeight = i;
                int i2 = this.mPreviewWidth;
                this.mWidth = i2;
                this.mHeight = i;
                this.mParams.setPreviewSize(i2, i);
            }
            DeviceSetting deviceSetting = this.mDeviceSetting;
            if (deviceSetting != null) {
                int cameraAutoAngle = getCameraAutoAngle(deviceSetting);
                this.mCameraViewRotationAngle = cameraAutoAngle;
                this.mCamera.setDisplayOrientation(cameraAutoAngle);
            }
            adjustBestFocusMode(this.mParams);
        }
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void autoFocus(List<Camera.Area> list, final Camera.AutoFocusCallback autoFocusCallback) {
        try {
            List<Camera.Area> subList = list.subList(0, 1);
            Camera.Parameters parameters = this.mCamera.getParameters();
            int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
            int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
            if (maxNumFocusAreas <= 0) {
                this.mWorkHandler.post(this.mRestFocusRunnable);
                autoFocusCallback.onAutoFocus(false, this.mCamera);
                return;
            }
            if (maxNumFocusAreas > 0) {
                parameters.setFocusAreas(maxNumFocusAreas > 1 ? list : subList);
            }
            if (maxNumMeteringAreas > 0) {
                if (maxNumMeteringAreas <= 1) {
                    list = subList;
                }
                parameters.setMeteringAreas(list);
            }
            parameters.setFocusMode("auto");
            this.mCamera.setParameters(parameters);
            try {
                this.focusStatus = false;
                this.mCamera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.alipay.zoloz.hardware.camera.impl.PermissionAndroidImpl.4
                    @Override // android.hardware.Camera.AutoFocusCallback
                    public void onAutoFocus(boolean z, Camera camera) {
                        PermissionAndroidImpl.this.focusStatus = true;
                        if (PermissionAndroidImpl.this.mWorkHandler != null) {
                            PermissionAndroidImpl.this.mWorkHandler.postDelayed(PermissionAndroidImpl.this.mRestFocusRunnable, RangedBeacon.DEFAULT_MAX_TRACKING_AGE);
                        }
                        autoFocusCallback.onAutoFocus(z, camera);
                    }
                });
            } catch (RuntimeException unused) {
            }
        } catch (Exception unused2) {
            this.mWorkHandler.post(this.mRestFocusRunnable);
            autoFocusCallback.onAutoFocus(false, this.mCamera);
        }
    }

    private int getCameraAutoAngle(DeviceSetting deviceSetting) {
        if (deviceSetting == null) {
            throw new IllegalArgumentException("deviceSetting can't be null");
        }
        if (deviceSetting.isDisplayAuto()) {
            return getCameraAutoAngle(this.mCameraID);
        }
        return deviceSetting.getDisplayAngle();
    }

    private int getCameraAutoAngle(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        int i2 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i2 = 90;
            } else if (rotation == 2) {
                i2 = 180;
            } else if (rotation == 3) {
                i2 = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            if (BuildConfig.OFFLINE.booleanValue()) {
                cameraInfo.orientation = 270;
            }
            return (360 - ((cameraInfo.orientation + i2) % AUScreenAdaptTool.WIDTH_BASE)) % AUScreenAdaptTool.WIDTH_BASE;
        }
        if (BuildConfig.OFFLINE.booleanValue()) {
            cameraInfo.orientation = 90;
        }
        return ((cameraInfo.orientation - i2) + AUScreenAdaptTool.WIDTH_BASE) % AUScreenAdaptTool.WIDTH_BASE;
    }

    private String getBestFocusMode(Camera.Parameters parameters, boolean z) {
        if (this.mCamera == null) {
            return null;
        }
        String str = z ? "continuous-video" : "continuous-picture";
        if (parameters.getSupportedFocusModes().contains(str)) {
            return str;
        }
        if (parameters.getSupportedFocusModes().contains("macro")) {
            return "macro";
        }
        if (parameters.getSupportedFocusModes().contains("fixed")) {
            return "fixed";
        }
        if (parameters.getSupportedFocusModes().size() == 1) {
            return parameters.getSupportedFocusModes().get(0);
        }
        return null;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void stopCamera() {
        stopPreview();
        if (this.isCameraStart) {
            if (this.mCamera != null) {
                synchronized (this.mLock) {
                    try {
                        this.mCamera.release();
                        this.mCamera = null;
                        this.isCameraStart = false;
                    } catch (Exception unused) {
                    }
                }
                return;
            }
            this.isCameraStart = false;
        }
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void startPreview(SurfaceHolder surfaceHolder, float f, int i, int i2) {
        if (this.isPreviewing) {
            return;
        }
        try {
            this.mCamera.setPreviewDisplay(surfaceHolder);
        } catch (IOException unused) {
        }
        this.mCamera.startPreview();
        this.isPreviewing = true;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void resumePreview() {
        if (this.isPreviewing) {
            return;
        }
        this.mCamera.startPreview();
        this.isPreviewing = true;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void stopPreview() {
        if (this.isPreviewing && this.mCamera != null) {
            synchronized (this.mLock) {
                try {
                    this.mCamera.setOneShotPreviewCallback(null);
                    this.mCamera.setPreviewCallback(null);
                    this.mCamera.stopPreview();
                } catch (Exception unused) {
                }
            }
            this.mCameraCallback = null;
            this.isPreviewing = false;
        }
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void setCallback(ICameraCallback iCameraCallback) {
        this.mCameraCallback = iCameraCallback;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public int getCameraViewRotation() {
        return this.mCameraViewRotationAngle;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public int getColorWidth() {
        return this.mWidth;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public int getColorHeight() {
        return this.mHeight;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public int getPreviewWidth() {
        return this.mPreviewWidth;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public int getPreviewHeight() {
        return this.mPreviewHeight;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void setOntShotPreviewCallback() {
        Camera camera = this.mCamera;
        if (camera == null || this.mCameraCallback == null) {
            return;
        }
        camera.setOneShotPreviewCallback(new Camera.PreviewCallback() { // from class: com.alipay.zoloz.hardware.camera.impl.PermissionAndroidImpl.5
            @Override // android.hardware.Camera.PreviewCallback
            public void onPreviewFrame(byte[] bArr, Camera camera2) {
                if (bArr == null || PermissionAndroidImpl.this.mCameraCallback == null) {
                    return;
                }
                PermissionAndroidImpl.this.mCameraCallback.onPreviewFrame(new CameraData(ByteBuffer.wrap(bArr), PermissionAndroidImpl.this.mWidth, PermissionAndroidImpl.this.mHeight, 0, null, 0, 0, PermissionAndroidImpl.this.mPreviewWidth, PermissionAndroidImpl.this.mPreviewHeight));
            }
        });
    }

    private void recordLog(String str) {
        ZimRecordService zimRecordService;
        try {
            if (BioServiceManager.getCurrentInstance() == null || (zimRecordService = (ZimRecordService) BioServiceManager.getCurrentInstance().getBioService(ZimRecordService.class)) == null) {
                return;
            }
            MetaRecord metaRecord = new MetaRecord("UC-YWRLSB-161114-21", "event", "20000189", str, 1);
            HashMap hashMap = new HashMap();
            hashMap.put("module", "hardware");
            zimRecordService.write(metaRecord, hashMap);
        } catch (Exception unused) {
        }
    }

    private boolean isSupported(List<Camera.Size> list, int i, int i2) {
        if (list == null) {
            return false;
        }
        for (Camera.Size size : list) {
            if (size.width == i && size.height == i2) {
                int i3 = size.width;
                int i4 = size.height;
                return true;
            }
        }
        return false;
    }

    @Override // android.hardware.Camera.AutoFocusMoveCallback
    public void onAutoFocusMoving(boolean z, Camera camera) {
        this.focusStatus = !z;
    }
}
