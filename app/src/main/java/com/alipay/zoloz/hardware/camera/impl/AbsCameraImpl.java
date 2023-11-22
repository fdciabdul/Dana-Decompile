package com.alipay.zoloz.hardware.camera.impl;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
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
import com.alipay.zoloz.hardware.camera.widget.CameraSurfaceView;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class AbsCameraImpl implements ICameraInterface, Camera.AutoFocusMoveCallback {
    private boolean isCameraInit;
    private boolean isCameraOpen;
    public boolean isCameraStart;
    protected boolean isPreviewing;
    protected Camera mCamera;
    protected ICameraCallback mCameraCallback;
    private int mCameraID;
    private int mCameraNumber;
    private Context mContext;
    private Camera.Parameters mParams;
    private Handler mWorkHandler;
    private HandlerThread mWorkHandlerThread;
    private final int AUTO_FOCUS_DELAY = 5000;
    protected int mCameraViewRotationAngle = 90;
    private DeviceSetting mDeviceSetting = new DeviceSetting();
    private final Object mLock = new Object();
    private int mWidth = 0;
    private int mHeight = 0;
    private int mPreviewWidth = 0;
    private int mPreviewHeight = 0;
    private boolean isFront = true;
    private boolean focusStatus = false;
    private Runnable mRestFocusRunnable = new Runnable() { // from class: com.alipay.zoloz.hardware.camera.impl.AbsCameraImpl.1
        @Override // java.lang.Runnable
        public void run() {
            if (AbsCameraImpl.this.mCamera != null) {
                Camera.Parameters parameters = AbsCameraImpl.this.mCamera.getParameters();
                int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                if (maxNumFocusAreas > 0) {
                    parameters.setFocusAreas(null);
                }
                if (maxNumMeteringAreas > 0) {
                    parameters.setMeteringAreas(null);
                }
                AbsCameraImpl.this.adjustBestFocusMode(parameters);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public void adjustPreview() {
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
    public void initCamera(int i, int i2, boolean z) {
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public boolean isMirror() {
        return false;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void resumePreview() {
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void setFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void setOntShotPreviewCallback() {
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

    public AbsCameraImpl(Context context) {
        this.isCameraInit = false;
        this.isCameraOpen = false;
        this.isCameraStart = false;
        this.isPreviewing = false;
        if (context == null) {
            throw new IllegalArgumentException("Context can't be null");
        }
        this.mContext = context;
        this.isCameraInit = false;
        this.isCameraOpen = false;
        this.isCameraStart = false;
        this.isPreviewing = false;
        HandlerThread handlerThread = new HandlerThread("Camera-work");
        this.mWorkHandlerThread = handlerThread;
        handlerThread.start();
        this.mWorkHandler = new Handler(this.mWorkHandlerThread.getLooper());
    }

    public Camera getCamera() {
        return this.mCamera;
    }

    public Camera.Parameters getParams() {
        return this.mParams;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void initCamera(DeviceSetting deviceSetting) {
        if (this.isCameraInit) {
            return;
        }
        recordLog("ztech_enter");
        if (deviceSetting != null) {
            this.mDeviceSetting = deviceSetting;
        }
        this.isCameraInit = true;
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void releaseCamera() {
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mRestFocusRunnable);
            this.mWorkHandlerThread.quitSafely();
        }
        stopCamera();
        if (this.isCameraInit) {
            this.isCameraInit = false;
            this.mContext = null;
            CameraSurfaceView.release();
        }
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void openCamera(DeviceSetting deviceSetting) {
        if (this.isCameraOpen) {
            return;
        }
        if (deviceSetting != null) {
            this.mDeviceSetting = deviceSetting;
        }
        this.isCameraOpen = true;
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

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void closeCamera() {
        if (this.isCameraOpen) {
            this.isCameraOpen = false;
        }
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void startCamera() {
        if (this.isCameraStart) {
            return;
        }
        DeviceSetting deviceSetting = this.mDeviceSetting;
        int cameraID = (deviceSetting == null || deviceSetting.isCameraAuto()) ? 1 : this.mDeviceSetting.getCameraID();
        int numberOfCameras = Camera.getNumberOfCameras();
        this.mCameraNumber = numberOfCameras;
        if (realStartCamera(AndroidCameraUtil.adjustCameraId(this.mContext, cameraID, numberOfCameras))) {
            this.isCameraStart = true;
        }
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void stopCamera() {
        stopPreview();
        if (this.isCameraStart) {
            Handler handler = this.mWorkHandler;
            if (handler != null) {
                handler.removeCallbacks(this.mRestFocusRunnable);
            }
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void initContext(Context context) {
        this.mContext = context;
    }

    private boolean realStartCamera(int i) {
        Camera open;
        try {
            open = Camera.open(i);
            this.mCamera = open;
        } catch (Exception unused) {
            ICameraCallback iCameraCallback = this.mCameraCallback;
            if (iCameraCallback != null) {
                iCameraCallback.onError(-1);
            }
        } catch (Throwable unused2) {
            ICameraCallback iCameraCallback2 = this.mCameraCallback;
            if (iCameraCallback2 != null) {
                iCameraCallback2.onError(-1);
            }
        }
        if (open == null) {
            ICameraCallback iCameraCallback3 = this.mCameraCallback;
            if (iCameraCallback3 != null) {
                iCameraCallback3.onError(-1);
            }
            return false;
        }
        this.mCameraID = i;
        if (open != null) {
            this.mParams = open.getParameters();
            adjustCameraParams();
            if (this.mCameraCallback != null) {
                if (TestUtil.isRunTest() && TestUtil.isDebug(this.mContext) && TestUtil.isCaptureMode()) {
                    TestUtil.reset();
                }
                this.mCamera.setPreviewCallback(new Camera.PreviewCallback() { // from class: com.alipay.zoloz.hardware.camera.impl.AbsCameraImpl.2
                    @Override // android.hardware.Camera.PreviewCallback
                    public void onPreviewFrame(byte[] bArr, Camera camera) {
                        byte[] readFrame;
                        if (bArr == null || AbsCameraImpl.this.mCameraCallback == null) {
                            return;
                        }
                        if (TestUtil.isRunTest() && TestUtil.isDebug(AbsCameraImpl.this.mContext)) {
                            if (TestUtil.isCaptureMode()) {
                                TestUtil.saveFrame(bArr);
                                CameraData cameraData = new CameraData(ByteBuffer.wrap(bArr), AbsCameraImpl.this.mWidth, AbsCameraImpl.this.mHeight, 0, null, 0, 0, AbsCameraImpl.this.mPreviewWidth, AbsCameraImpl.this.mPreviewHeight);
                                cameraData.setFocusStatus(AbsCameraImpl.this.focusStatus);
                                AbsCameraImpl.this.mCameraCallback.onPreviewFrame(cameraData);
                                return;
                            } else if (!TestUtil.isMockMode() || (readFrame = TestUtil.readFrame()) == null) {
                                return;
                            } else {
                                CameraData cameraData2 = new CameraData(ByteBuffer.wrap(readFrame), AbsCameraImpl.this.mWidth, AbsCameraImpl.this.mHeight, 0, null, 0, 0, AbsCameraImpl.this.mPreviewWidth, AbsCameraImpl.this.mPreviewHeight);
                                cameraData2.setFocusStatus(AbsCameraImpl.this.focusStatus);
                                AbsCameraImpl.this.mCameraCallback.onPreviewFrame(cameraData2);
                                return;
                            }
                        }
                        CameraData cameraData3 = new CameraData(ByteBuffer.wrap(bArr), AbsCameraImpl.this.mWidth, AbsCameraImpl.this.mHeight, 0, null, 0, 0, AbsCameraImpl.this.mPreviewWidth, AbsCameraImpl.this.mPreviewHeight);
                        cameraData3.setFocusStatus(AbsCameraImpl.this.focusStatus);
                        AbsCameraImpl.this.mCameraCallback.onPreviewFrame(cameraData3);
                    }
                });
                return true;
            }
            return true;
        }
        return false;
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

    private void adjustCameraParams() {
        if (this.mParams != null) {
            if (this.mCameraID == AndroidCameraUtil.findBackCameraId()) {
                this.isFront = false;
                adjustBackCameraParams();
            } else {
                this.isFront = true;
                adjustFrontCameraParams();
            }
        }
        adjustPreview();
    }

    private void adjustFrontCameraParams() {
        if (this.mParams != null) {
            Camera.Size propPreviewSize = AndroidCameraUtil.getInstance().getPropPreviewSize(this.mParams.getSupportedPreviewSizes(), DisplayUtil.getScreenRate(this.mContext), 600);
            if (propPreviewSize != null) {
                if (TestUtil.isRunTest()) {
                    this.mPreviewWidth = TestUtil.getWidth();
                    int height = TestUtil.getHeight();
                    this.mPreviewHeight = height;
                    this.mWidth = this.mPreviewWidth;
                    this.mHeight = height;
                } else {
                    this.mPreviewWidth = propPreviewSize.width;
                    int i = propPreviewSize.height;
                    this.mPreviewHeight = i;
                    this.mWidth = this.mPreviewWidth;
                    this.mHeight = i;
                }
                this.mParams.setPreviewSize(this.mPreviewWidth, this.mPreviewHeight);
            }
            DeviceSetting deviceSetting = this.mDeviceSetting;
            if (deviceSetting != null) {
                this.mCameraViewRotationAngle = getCameraAutoAngle(deviceSetting);
            }
            adjustBestFocusMode(this.mParams);
        }
    }

    private void adjustBackCameraParams() {
        if (this.mParams != null) {
            Camera.Size backCameraPreviewSize = AndroidCameraUtil.getInstance().getBackCameraPreviewSize(this.mParams.getSupportedPreviewSizes(), DisplayUtil.getScreenRate(this.mContext), this.mDeviceSetting.getCameraPreviewMinSize(), this.mDeviceSetting.getCameraPreviewMaxSize());
            if (backCameraPreviewSize != null) {
                if (TestUtil.isRunTest()) {
                    this.mPreviewWidth = TestUtil.getWidth();
                    int height = TestUtil.getHeight();
                    this.mPreviewHeight = height;
                    this.mWidth = this.mPreviewWidth;
                    this.mHeight = height;
                } else {
                    this.mPreviewWidth = backCameraPreviewSize.width;
                    int i = backCameraPreviewSize.height;
                    this.mPreviewHeight = i;
                    this.mWidth = this.mPreviewWidth;
                    this.mHeight = i;
                }
                this.mParams.setPreviewSize(this.mPreviewWidth, this.mPreviewHeight);
            }
            DeviceSetting deviceSetting = this.mDeviceSetting;
            if (deviceSetting != null) {
                this.mCameraViewRotationAngle = getCameraAutoAngle(deviceSetting);
            }
            adjustBestFocusMode(this.mParams);
        }
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraInterface
    public void autoFocus(List<Camera.Area> list, final Camera.AutoFocusCallback autoFocusCallback) {
        List<Camera.Area> subList = list.subList(0, 1);
        Camera.Parameters parameters = this.mCamera.getParameters();
        int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
        int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
        if (maxNumFocusAreas <= 0) {
            Handler handler = this.mWorkHandler;
            if (handler != null) {
                handler.post(this.mRestFocusRunnable);
            }
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
        try {
            this.mCamera.setParameters(parameters);
            try {
                this.focusStatus = false;
                this.mCamera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.alipay.zoloz.hardware.camera.impl.AbsCameraImpl.3
                    @Override // android.hardware.Camera.AutoFocusCallback
                    public void onAutoFocus(boolean z, Camera camera) {
                        AbsCameraImpl.this.focusStatus = true;
                        if (AbsCameraImpl.this.mWorkHandler != null) {
                            AbsCameraImpl.this.mWorkHandler.postDelayed(AbsCameraImpl.this.mRestFocusRunnable, RangedBeacon.DEFAULT_MAX_TRACKING_AGE);
                        }
                        autoFocusCallback.onAutoFocus(z, camera);
                    }
                });
            } catch (RuntimeException unused) {
            }
        } catch (Exception unused2) {
            Handler handler2 = this.mWorkHandler;
            if (handler2 != null) {
                handler2.post(this.mRestFocusRunnable);
            }
            autoFocusCallback.onAutoFocus(false, this.mCamera);
        }
    }

    private String getBestFocusMode(Camera.Parameters parameters, boolean z) {
        if (this.mCamera == null) {
            return null;
        }
        String str = z ? "continuous-video" : "continuous-picture";
        if (parameters.getSupportedFocusModes().contains(str)) {
            return str;
        }
        if (parameters.getSupportedFocusModes().contains("auto")) {
            return "auto";
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

    @Override // android.hardware.Camera.AutoFocusMoveCallback
    public void onAutoFocusMoving(boolean z, Camera camera) {
        this.focusStatus = !z;
    }
}
