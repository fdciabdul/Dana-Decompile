package com.alibaba.griver.image.capture.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.alibaba.griver.image.capture.listener.IRecordListener;
import com.alibaba.griver.image.capture.meta.APVideoRecordRsp;
import com.alibaba.griver.image.capture.meta.CameraParams;
import com.alibaba.griver.image.capture.utils.OrientationDetector;
import com.alibaba.griver.image.capture.utils.VideoUtils;
import com.alibaba.griver.image.capture.widget.SightCameraView;
import com.alibaba.griver.image.framework.utils.PermissionHelper;
import com.alibaba.griver.image.framework.utils.StringUtils;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import id.dana.util.permission.ManifestPermission;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public abstract class CameraView extends TextureView implements Camera.AutoFocusCallback, TextureView.SurfaceTextureListener {
    protected static final int CAMERA_INIT_FAILED = 1;
    protected static final int CAMERA_INIT_SUCCESS = 2;
    protected static final int CAMERA_NOT_INIT = 0;
    public static final String TAG = "CameraView";

    /* renamed from: a  reason: collision with root package name */
    private final Object f6570a;
    protected WeakReference<Object> activityOrFragment;
    protected long audioCurTimeStamp;
    protected boolean audioPermissionDelay;
    private int b;
    private int c;
    protected CameraParams cameraParams;
    protected Camera.CameraInfo curCameraInfo;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private float h;
    private int i;
    protected boolean initCameraError;
    protected boolean isSwitching;
    private int j;
    private APVideoRecordRsp.RecordPhase k;
    private boolean l;
    protected String lastChannelId;
    protected String lastPublishUrl;
    protected volatile int loseCount;
    private Handler m;
    protected volatile int mBeautyValue;
    protected Camera mCamera;
    protected int mCameraFacing;
    protected Object mCameraInitLock;
    protected int mCameraStatus;
    protected Context mContext;
    protected boolean mHasReqPermissionTime;
    protected boolean mInitCameraAsync;
    protected boolean mIsOpened;
    protected WrapperListener mListener;
    protected Camera.Size mPreviewSize;
    protected int mRotation;
    protected int mScreenRotation;
    protected SurfaceTexture mSurfaceTexture;
    protected boolean mUseEventbus;
    protected boolean mUseFrameData;
    protected boolean permissionAftsReopen;
    protected long videoCurTimeStamp;
    protected static final AtomicBoolean sRequirePermissions = new AtomicBoolean(false);
    public static int mMode = 1;
    public static long sCreateTime = 0;

    private int a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    private static boolean a(Context context) {
        return false;
    }

    protected static int mapScreenDegree(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return i != 3 ? 0 : 270;
                }
                return 180;
            }
            return 90;
        }
        return 0;
    }

    protected abstract void afterReopen();

    protected abstract void handleOnSurfaceTextureAvailable(SurfaceTexture surfaceTexture);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Camera reopenCamera(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Camera switchCamera();

    public CameraView(Context context) {
        super(context);
        this.f6570a = new Object();
        this.mCameraFacing = 0;
        this.mListener = new WrapperListener();
        this.mIsOpened = false;
        this.initCameraError = false;
        this.mRotation = 90;
        this.isSwitching = false;
        this.audioCurTimeStamp = 0L;
        this.videoCurTimeStamp = 0L;
        this.mBeautyValue = -1;
        this.loseCount = 0;
        this.mScreenRotation = -1;
        this.mCameraInitLock = new Object();
        this.mCameraStatus = 0;
        this.mInitCameraAsync = false;
        this.mHasReqPermissionTime = false;
        this.curCameraInfo = null;
        this.permissionAftsReopen = false;
        this.mUseEventbus = false;
        this.mUseFrameData = false;
        this.audioPermissionDelay = false;
        this.b = 90;
        this.c = -1;
        this.f = false;
        this.g = 0;
        this.h = 0.08f;
        this.i = 0;
        this.j = 0;
        this.k = APVideoRecordRsp.RecordPhase.INIT;
        this.l = true;
        this.m = new Handler() { // from class: com.alibaba.griver.image.capture.widget.CameraView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    CameraView.this.notifyOpenCameraError();
                } else if (i == 2) {
                    CameraView.this.f = false;
                }
            }
        };
        sCreateTime = System.currentTimeMillis();
        this.mContext = context;
        setSurfaceTextureListener(this);
        RVLogger.d("CameraView construct!");
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6570a = new Object();
        this.mCameraFacing = 0;
        this.mListener = new WrapperListener();
        this.mIsOpened = false;
        this.initCameraError = false;
        this.mRotation = 90;
        this.isSwitching = false;
        this.audioCurTimeStamp = 0L;
        this.videoCurTimeStamp = 0L;
        this.mBeautyValue = -1;
        this.loseCount = 0;
        this.mScreenRotation = -1;
        this.mCameraInitLock = new Object();
        this.mCameraStatus = 0;
        this.mInitCameraAsync = false;
        this.mHasReqPermissionTime = false;
        this.curCameraInfo = null;
        this.permissionAftsReopen = false;
        this.mUseEventbus = false;
        this.mUseFrameData = false;
        this.audioPermissionDelay = false;
        this.b = 90;
        this.c = -1;
        this.f = false;
        this.g = 0;
        this.h = 0.08f;
        this.i = 0;
        this.j = 0;
        this.k = APVideoRecordRsp.RecordPhase.INIT;
        this.l = true;
        this.m = new Handler() { // from class: com.alibaba.griver.image.capture.widget.CameraView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    CameraView.this.notifyOpenCameraError();
                } else if (i == 2) {
                    CameraView.this.f = false;
                }
            }
        };
        sCreateTime = System.currentTimeMillis();
        this.mContext = context;
        setSurfaceTextureListener(this);
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6570a = new Object();
        this.mCameraFacing = 0;
        this.mListener = new WrapperListener();
        this.mIsOpened = false;
        this.initCameraError = false;
        this.mRotation = 90;
        this.isSwitching = false;
        this.audioCurTimeStamp = 0L;
        this.videoCurTimeStamp = 0L;
        this.mBeautyValue = -1;
        this.loseCount = 0;
        this.mScreenRotation = -1;
        this.mCameraInitLock = new Object();
        this.mCameraStatus = 0;
        this.mInitCameraAsync = false;
        this.mHasReqPermissionTime = false;
        this.curCameraInfo = null;
        this.permissionAftsReopen = false;
        this.mUseEventbus = false;
        this.mUseFrameData = false;
        this.audioPermissionDelay = false;
        this.b = 90;
        this.c = -1;
        this.f = false;
        this.g = 0;
        this.h = 0.08f;
        this.i = 0;
        this.j = 0;
        this.k = APVideoRecordRsp.RecordPhase.INIT;
        this.l = true;
        this.m = new Handler() { // from class: com.alibaba.griver.image.capture.widget.CameraView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 1) {
                    CameraView.this.notifyOpenCameraError();
                } else if (i2 == 2) {
                    CameraView.this.f = false;
                }
            }
        };
        sCreateTime = System.currentTimeMillis();
        this.mContext = context;
        setSurfaceTextureListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnRecordListener(SightCameraView.OnRecordListener onRecordListener) {
        this.mListener.setVideoRecordListener(onRecordListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setActivityOrFragment(WeakReference<Object> weakReference) {
        this.activityOrFragment = weakReference;
    }

    public void setRecordPhase(APVideoRecordRsp.RecordPhase recordPhase) {
        this.k = recordPhase;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        WeakReference<Object> weakReference;
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append("###onSurfaceTextureAvailable w:");
        sb.append(i);
        sb.append(", h:");
        sb.append(i2);
        RVLogger.d(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onSurfaceTextureAvailable activityOrFragment: ");
        WeakReference<Object> weakReference2 = this.activityOrFragment;
        sb2.append(weakReference2 != null ? weakReference2.get() : null);
        RVLogger.d(sb2.toString());
        this.mSurfaceTexture = surfaceTexture;
        if (PermissionHelper.checkVideoPermission(mMode, this.audioPermissionDelay) || (weakReference = this.activityOrFragment) == null || weakReference.get() == null) {
            handleOnSurfaceTextureAvailable(this.mSurfaceTexture);
        } else if (this.audioPermissionDelay) {
            RVLogger.d("onSurfaceTextureAvailable requireCameraPermission");
            this.mHasReqPermissionTime = true;
            PermissionHelper.requireVideoPermission(this.activityOrFragment.get(), 1, 2);
        } else {
            RVLogger.d("onSurfaceTextureAvailable requireVideoPermission");
            this.mHasReqPermissionTime = true;
            PermissionHelper.requireVideoPermission(this.activityOrFragment.get(), mMode, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean z = true;
        int i2 = 0;
        while (true) {
            if (i2 >= iArr.length) {
                break;
            }
            boolean z2 = iArr[i2] == 0;
            z &= z2;
            if (!z2) {
                if ("android.permission.CAMERA".equals(strArr[i2])) {
                    notifyOpenCameraError();
                    break;
                } else if (ManifestPermission.RECORD_AUDIO.equals(strArr[i2])) {
                    notifyMicError();
                    break;
                }
            }
            i2++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onRequestPermissionsResult granted:");
        sb.append(z);
        sb.append(", requestCode:");
        sb.append(i);
        RVLogger.d(sb.toString());
        if (z) {
            if (i == 4) {
                this.permissionAftsReopen = true;
                if (!this.audioPermissionDelay) {
                    afterReopen();
                }
                this.permissionAftsReopen = false;
                return;
            }
            handleOnSurfaceTextureAvailable(this.mSurfaceTexture);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCameraParams(CameraParams cameraParams) {
        this.cameraParams = cameraParams;
        if (cameraParams != null) {
            this.mCameraFacing = cameraParams.isDefaultCameraFront() ? 1 : 0;
            StringBuilder sb = new StringBuilder();
            sb.append("setCameraParams mCameraFacing:");
            sb.append(this.mCameraFacing);
            sb.append(";flashmode=");
            sb.append(cameraParams.getFlashMode());
            RVLogger.d(sb.toString());
            this.audioPermissionDelay = cameraParams.audioPermissionDelay;
        }
    }

    private boolean a() {
        CameraParams cameraParams = this.cameraParams;
        return (cameraParams == null || StringUtils.isEmptyOrNullStr(cameraParams.getFlashMode())) ? false : true;
    }

    protected int getRecordType() {
        CameraParams cameraParams = this.cameraParams;
        if (cameraParams == null) {
            return 0;
        }
        return cameraParams.recordType;
    }

    public boolean isLive() {
        return getRecordType() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initCamera(boolean z) {
        boolean z2;
        int i;
        StringBuilder sb = new StringBuilder();
        sb.append("initCamera start mCameraFacing=");
        sb.append(this.mCameraFacing);
        RVLogger.d(sb.toString());
        if (!Environment.getExternalStorageState().equals("mounted")) {
            notifySdcardError();
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            this.c = i2;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" initCamera > facing=");
            sb2.append(cameraInfo.facing);
            sb2.append(" mCameraFacing=");
            sb2.append(this.mCameraFacing);
            sb2.append(" i= ");
            sb2.append(i2);
            sb2.append(" total=");
            sb2.append(numberOfCameras);
            RVLogger.d(sb2.toString());
            if (cameraInfo.facing == this.mCameraFacing || numberOfCameras == 1) {
                a(cameraInfo, i2);
                z2 = true;
                break;
            }
        }
        z2 = false;
        if (!z2 && numberOfCameras > 0) {
            RVLogger.d("> not exist needed camera,default to open first camera");
            Camera.getCameraInfo(0, cameraInfo);
            this.c = 0;
            a(cameraInfo, 0);
        }
        Camera camera = this.mCamera;
        if (camera == null) {
            RVLogger.d("open camera error 2");
            throw new RuntimeException("open camera error");
        }
        Camera.Parameters parameters = camera.getParameters();
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes != null && supportedFlashModes.contains("off") && !a()) {
            RVLogger.d("setFlashMode off");
            parameters.setFlashMode("off");
        } else if (a() && supportedFlashModes != null && supportedFlashModes.contains(this.cameraParams.getFlashMode())) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("setFlashMode mode=");
            sb3.append(this.cameraParams.getFlashMode());
            RVLogger.d(sb3.toString());
            parameters.setFlashMode(this.cameraParams.getFlashMode());
        }
        if (parameters.getMaxNumFocusAreas() > 0) {
            this.d = true;
        }
        if (parameters.getMaxNumMeteringAreas() > 0) {
            this.e = true;
        }
        a(parameters);
        parameters.setPreviewFormat(17);
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (this.l) {
            if (supportedFocusModes.contains("auto") && getRecordType() == 3 && mMode == 0) {
                parameters.setFocusMode("auto");
            } else if (supportedFocusModes.contains("continuous-video") && mMode == 0) {
                parameters.setFocusMode("continuous-video");
            } else if (supportedFocusModes.contains("continuous-picture")) {
                parameters.setFocusMode("continuous-picture");
            }
        }
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        Collections.sort(supportedPreviewFpsRange, new Comparator<int[]>() { // from class: com.alibaba.griver.image.capture.widget.CameraView.2
            @Override // java.util.Comparator
            public int compare(int[] iArr, int[] iArr2) {
                return iArr2[0] - iArr[0];
            }
        });
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < supportedPreviewFpsRange.size()) {
            int[] iArr = supportedPreviewFpsRange.get(i3);
            int i6 = iArr[0];
            int i7 = iArr[1];
            StringBuilder sb4 = new StringBuilder();
            sb4.append("camera fpsRange minfps=");
            sb4.append(i6);
            sb4.append(";maxfps=");
            sb4.append(i7);
            RVLogger.d(sb4.toString());
            if (iArr[1] <= 30000 && (i3 >= supportedPreviewFpsRange.size() - 1 || iArr[0] < iArr[1] || supportedPreviewFpsRange.get(i3 + 1)[1] < 20000)) {
                if (iArr[1] >= 18000 || i3 - 1 < 0) {
                    i4 = i6;
                    i5 = i7;
                } else {
                    i4 = supportedPreviewFpsRange.get(i)[0];
                    i5 = supportedPreviewFpsRange.get(i)[1];
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("camera fpsRange minfps=");
                    sb5.append(i4);
                    sb5.append(";maxfps=");
                    sb5.append(i5);
                    RVLogger.d(sb5.toString());
                }
                parameters.setPreviewFpsRange(i4, i5);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("camera current scene mode : ");
                sb6.append(parameters.getSceneMode());
                sb6.append("; min fps:");
                sb6.append(i4);
                sb6.append(", max fps");
                sb6.append(i5);
                RVLogger.d(sb6.toString());
                int a2 = a((Activity) this.mContext, cameraInfo.facing, this.curCameraInfo);
                this.mRotation = a2;
                parameters.setRotation(a2);
                this.mCamera.setParameters(parameters);
                if (z && (getParent() instanceof SightCameraViewImpl)) {
                    post(new Runnable() { // from class: com.alibaba.griver.image.capture.widget.CameraView.3
                        @Override // java.lang.Runnable
                        public void run() {
                            CameraView.this.reLayout();
                        }
                    });
                }
                this.f = false;
                notifyCameraOpen();
            }
            i3++;
            i4 = i6;
            i5 = i7;
        }
        parameters.setPreviewFpsRange(i4, i5);
        StringBuilder sb62 = new StringBuilder();
        sb62.append("camera current scene mode : ");
        sb62.append(parameters.getSceneMode());
        sb62.append("; min fps:");
        sb62.append(i4);
        sb62.append(", max fps");
        sb62.append(i5);
        RVLogger.d(sb62.toString());
        int a22 = a((Activity) this.mContext, cameraInfo.facing, this.curCameraInfo);
        this.mRotation = a22;
        parameters.setRotation(a22);
        this.mCamera.setParameters(parameters);
        if (z) {
            post(new Runnable() { // from class: com.alibaba.griver.image.capture.widget.CameraView.3
                @Override // java.lang.Runnable
                public void run() {
                    CameraView.this.reLayout();
                }
            });
        }
        this.f = false;
        notifyCameraOpen();
    }

    private void a(Camera.CameraInfo cameraInfo, int i) {
        try {
            this.mCamera = Camera.open(i);
        } catch (RuntimeException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("open camera error exp=");
            sb.append(e.getMessage());
            RVLogger.d(sb.toString());
            this.mCamera = Camera.open(i);
        }
        if (this.mCamera == null) {
            RVLogger.d("open camera error 1");
            throw new RuntimeException("open camera error");
        }
        this.mCameraFacing = cameraInfo.facing;
        this.curCameraInfo = cameraInfo;
    }

    public void startPreview() {
        this.mCamera.startPreview();
        this.mIsOpened = true;
    }

    private int a(Activity activity, int i, Camera.CameraInfo cameraInfo) {
        int i2;
        int i3;
        if (cameraInfo == null) {
            try {
                Camera.getCameraInfo(i, cameraInfo);
            } catch (Exception unused) {
            }
        }
        updateScreenRotation(activity);
        StringBuilder sb = new StringBuilder();
        sb.append("getDefaultDisplay().getRotation(): ");
        sb.append(this.mScreenRotation);
        RVLogger.d(sb.toString());
        int mapScreenDegree = mapScreenDegree(this.mScreenRotation);
        if (cameraInfo.facing == 1) {
            i2 = (360 - ((cameraInfo.orientation + mapScreenDegree) % AUScreenAdaptTool.WIDTH_BASE)) % AUScreenAdaptTool.WIDTH_BASE;
            i3 = 270;
        } else {
            i2 = ((cameraInfo.orientation - mapScreenDegree) + AUScreenAdaptTool.WIDTH_BASE) % AUScreenAdaptTool.WIDTH_BASE;
            i3 = 90;
        }
        this.mCamera.setDisplayOrientation(i2);
        this.b = i2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("############ mCamera.setDisplayOrientation:");
        sb2.append(i2);
        sb2.append(", cur camera orientation=");
        sb2.append(cameraInfo.orientation);
        RVLogger.d(sb2.toString());
        return (cameraInfo.orientation > 270 || cameraInfo.orientation <= 0) ? i3 : cameraInfo.orientation;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void releaseCamera() {
        this.mIsOpened = false;
        StringBuilder sb = new StringBuilder();
        sb.append("releaseCamera -- enter initCameraError=");
        sb.append(this.initCameraError);
        sb.append(">>>mCamera==null?");
        sb.append(this.mCamera == null);
        RVLogger.d(sb.toString());
        try {
            synchronized (this.f6570a) {
                Camera camera = this.mCamera;
                if (camera != null && !this.initCameraError) {
                    camera.stopPreview();
                    this.mCamera.release();
                    this.mCamera = null;
                    RVLogger.d("releaseCamera -- done");
                }
            }
        } catch (Exception e) {
            RVLogger.e(TAG, "releaseCamera error", e);
        }
    }

    public void reLayout() {
        if (a(getContext())) {
            RVLogger.d(" screen is off");
            return;
        }
        boolean z = false;
        int i = VideoUtils.getScreenSize(getContext()).x;
        int i2 = VideoUtils.getScreenSize(getContext()).y;
        if (Math.abs(i - this.i) > 200 || Math.abs(i2 - this.j) > 200) {
            StringBuilder sb = new StringBuilder();
            sb.append("reLayout x=");
            sb.append(i);
            sb.append(" ;y=");
            sb.append(i2);
            sb.append("; mScreenWidth=");
            sb.append(this.i);
            sb.append(" ;mScreenHeight=");
            sb.append(this.j);
            RVLogger.d(sb.toString());
            this.i = i;
            this.j = i2;
            z = true;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.i + 1, this.j);
        if (mMode != 1 && this.mPreviewSize != null) {
            try {
                b();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("reLayout display w:");
                sb2.append(this.i);
                sb2.append(",h:");
                sb2.append(this.j);
                RVLogger.d(sb2.toString());
                int i3 = (this.j * this.mPreviewSize.height) / this.mPreviewSize.width;
                boolean isActivityLandscape = VideoUtils.isActivityLandscape((Activity) getContext());
                if (isActivityLandscape) {
                    RVLogger.d("isActivityLandscape");
                    i3 = (this.j * this.mPreviewSize.width) / this.mPreviewSize.height;
                }
                int i4 = this.i;
                if (i3 < i4 && i4 - i3 <= ((int) (i4 * this.h))) {
                    i3 = i4;
                }
                ((ViewGroup.LayoutParams) layoutParams).width = i3 + 1;
                ((ViewGroup.LayoutParams) layoutParams).height = this.j;
                if (z) {
                    int i5 = this.mPreviewSize.width;
                    int i6 = this.mPreviewSize.height;
                    if (i5 > i6) {
                        i5 = this.mPreviewSize.height;
                        i6 = this.mPreviewSize.width;
                    }
                    float f = i5 / i6;
                    int i7 = this.i;
                    int i8 = this.j;
                    if (isActivityLandscape) {
                        i8 = i7;
                        i7 = i8;
                    }
                    float f2 = i7 / i8;
                    if (this.h + f < f2) {
                        ((ViewGroup.LayoutParams) layoutParams).width = i7;
                        ((ViewGroup.LayoutParams) layoutParams).height = (i7 * i6) / i5;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("reLayout isFold preRation=");
                    sb3.append(f);
                    sb3.append(";screenRation=");
                    sb3.append(f2);
                    sb3.append(";width=");
                    sb3.append(((ViewGroup.LayoutParams) layoutParams).width);
                    sb3.append(";height=");
                    sb3.append(((ViewGroup.LayoutParams) layoutParams).height);
                    sb3.append(";preW=");
                    sb3.append(i5);
                    sb3.append(";preH=");
                    sb3.append(i6);
                    RVLogger.d(sb3.toString());
                }
            } catch (Exception unused) {
                ((ViewGroup.LayoutParams) layoutParams).width = this.i;
                ((ViewGroup.LayoutParams) layoutParams).height = this.j;
                RVLogger.e(TAG, "reLayout exp");
            }
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("reLayout final w:");
        sb4.append(((ViewGroup.LayoutParams) layoutParams).width);
        sb4.append(",h:");
        sb4.append(((ViewGroup.LayoutParams) layoutParams).height);
        RVLogger.d(sb4.toString());
        setLayoutParams(layoutParams);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void focusOnTouch(MotionEvent motionEvent) {
        List<String> supportedFocusModes;
        Camera camera = this.mCamera;
        if (camera == null || !this.mIsOpened || this.f) {
            return;
        }
        try {
            camera.cancelAutoFocus();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("focusOnTouch cancelAutoFocus error, e: ");
            sb.append(e);
            RVLogger.w(sb.toString());
        }
        Rect a2 = a(motionEvent.getX(), motionEvent.getY(), 1.0f);
        Rect a3 = a(motionEvent.getX(), motionEvent.getY(), 1.5f);
        Camera.Parameters parameters = null;
        try {
            parameters = this.mCamera.getParameters();
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("focusOnTouch getParameters exp");
            sb2.append(e2.getMessage());
            RVLogger.e(TAG, sb2.toString(), e2);
        }
        if (parameters == null || (supportedFocusModes = parameters.getSupportedFocusModes()) == null || !supportedFocusModes.contains("auto")) {
            return;
        }
        parameters.setFocusMode("auto");
        if (this.d) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(new Camera.Area(a2, 1000));
            parameters.setFocusAreas(arrayList);
        }
        if (this.e) {
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(new Camera.Area(a3, 1000));
            parameters.setMeteringAreas(arrayList2);
        }
        try {
            this.mCamera.setParameters(parameters);
            this.mCamera.autoFocus(this);
            this.f = true;
            this.m.sendEmptyMessageDelayed(2, RangedBeacon.DEFAULT_MAX_TRACKING_AGE);
        } catch (Exception e3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("setParameters exp:");
            sb3.append(e3.getMessage());
            RVLogger.e(TAG, sb3.toString(), e3);
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append("\tonAttachedToWindow 1");
        RVLogger.e(sb.toString());
        a(mMode);
        super.onAttachedToWindow();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this);
        sb2.append("\tonAttachedToWindow 2");
        RVLogger.e(sb2.toString());
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setScaleX(1.00001f);
        setScaleY(1.00001f);
        OrientationDetector.getInstance(getContext()).register();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RVLogger.d("onDetachedFromWindow");
        OrientationDetector.getInstance(getContext()).unregister();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        RVLogger.d("onFinishInflate");
    }

    private Rect a(float f, float f2, float f3) {
        int width = (int) (((f / getWidth()) * 2000.0f) - 1000.0f);
        int height = (int) (((f2 / getHeight()) * 2000.0f) - 1000.0f);
        int intValue = Float.valueOf(((int) ((getContext().getResources().getDisplayMetrics().density * 72.0f) + 0.5f)) * f3).intValue() / 2;
        return new Rect(a(width - intValue, -1000, 1000), a(height - intValue, -1000, 1000), a(width + intValue, -1000, 1000), a(height + intValue, -1000, 1000));
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z, Camera camera) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAutoFocus result: ");
        sb.append(z);
        RVLogger.d(sb.toString());
        this.m.removeMessages(2);
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zoom() {
        if (this.mCamera == null || !this.mIsOpened) {
            return;
        }
        CameraParams cameraParams = this.cameraParams;
        if (cameraParams == null || cameraParams.bZoomEnable) {
            Camera.Parameters parameters = null;
            try {
                parameters = this.mCamera.getParameters();
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("zoom getParameters exp:");
                sb.append(e.getMessage());
                RVLogger.e(TAG, sb.toString(), e);
            }
            if (parameters != null && parameters.isZoomSupported()) {
                int maxZoom = parameters.getMaxZoom();
                int zoom = parameters.getZoom();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("curr: ");
                sb2.append(zoom);
                RVLogger.d(sb2.toString());
                if (zoom == 0) {
                    parameters.setZoom(maxZoom / 2);
                } else {
                    parameters.setZoom(0);
                }
                try {
                    this.mCamera.setParameters(parameters);
                } catch (Exception e2) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("zoom setParameters exp:");
                    sb3.append(e2.getMessage());
                    RVLogger.e(TAG, sb3.toString(), e2);
                }
            }
        }
    }

    private void a(Camera.Parameters parameters) {
        b();
        Point findBestPreviewSizeValue = VideoUtils.findBestPreviewSizeValue(parameters, new Point(this.i, this.j));
        parameters.setPreviewSize(findBestPreviewSizeValue.x, findBestPreviewSizeValue.y);
        this.mPreviewSize = parameters.getPreviewSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getCameraId() {
        return this.c;
    }

    public void notifyOpenCameraError() {
        this.initCameraError = true;
        APVideoRecordRsp aPVideoRecordRsp = new APVideoRecordRsp();
        aPVideoRecordRsp.mRspCode = 100;
        notifyError(aPVideoRecordRsp);
        RVLogger.e(TAG, "take it easy, only use to fix camera on dev", new IllegalStateException("notifyOpenCameraError"));
    }

    protected void notifySdcardError() {
        APVideoRecordRsp aPVideoRecordRsp = new APVideoRecordRsp();
        aPVideoRecordRsp.mRspCode = 200;
        notifyError(aPVideoRecordRsp);
        RVLogger.e(TAG, "take it easy, only use to fix sdcard on dev", new IllegalStateException("notifySdcardError"));
    }

    protected void notifyCameraOpen() {
        notifyInfo(APVideoRecordRsp.CODE_INFO_CAMERA_OPEN, null);
    }

    protected void notifyInfo(int i, Bundle bundle) {
        WrapperListener wrapperListener = this.mListener;
        if (wrapperListener != null) {
            wrapperListener.onInfo(i, bundle);
        }
    }

    protected void notifyError(APVideoRecordRsp aPVideoRecordRsp) {
        StringBuilder sb = new StringBuilder();
        sb.append("notifyError, rsp: ");
        sb.append(aPVideoRecordRsp);
        RVLogger.e(sb.toString());
        if (this.mListener != null) {
            aPVideoRecordRsp.recordPhase = this.k;
            this.mListener.onError(aPVideoRecordRsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyPrepared() {
        RVLogger.d("notifyPrepared");
        if (this.mListener != null) {
            APVideoRecordRsp aPVideoRecordRsp = new APVideoRecordRsp();
            aPVideoRecordRsp.mCamera = this.mCamera;
            aPVideoRecordRsp.mPreviewH = this.mPreviewSize.height;
            aPVideoRecordRsp.mPreviewW = this.mPreviewSize.width;
            aPVideoRecordRsp.mDisplayOrientation = this.b;
            this.mListener.onPrepared(aPVideoRecordRsp);
        }
    }

    protected void notifyMicError() {
        RVLogger.d("notifyMicError permission denied");
        RVLogger.e(TAG, "take it easy, only use to fix mic on dev", new IllegalStateException("notifyMicError"));
        APVideoRecordRsp aPVideoRecordRsp = new APVideoRecordRsp();
        aPVideoRecordRsp.mRspCode = 2;
        notifyError(aPVideoRecordRsp);
    }

    public void setVideoCurTimeStamp(long j) {
        this.videoCurTimeStamp = j;
    }

    private void a(int i) {
        if (i == 1 || this.audioPermissionDelay) {
            RVLogger.d("acquire audio permission but mode being photo or using mic hardware encoding, just skip.");
            return;
        }
        AtomicBoolean atomicBoolean = sRequirePermissions;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (atomicBoolean) {
            if (!atomicBoolean.get()) {
                PermissionHelper.acquirePermissions(1);
                atomicBoolean.set(true);
            }
        }
    }

    private void b() {
        if (isLive()) {
            if (this.j > 0 && this.i > 0) {
                return;
            }
            this.j = VideoUtils.getScreenSize(getContext()).y;
            this.i = VideoUtils.getScreenSize(getContext()).x;
        } else if (this.j <= 0 || this.i <= 0 || (hasWindowFocus() && isShown())) {
            this.j = VideoUtils.getScreenSize(getContext()).y;
            this.i = VideoUtils.getScreenSize(getContext()).x;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("screen property updateScreenSize.mScreenWidth=");
        sb.append(this.i);
        sb.append(",mScreenHeight=");
        sb.append(this.j);
        RVLogger.d(sb.toString());
    }

    protected void updateScreenRotation(Activity activity) {
        if (isLive()) {
            if (this.mScreenRotation > 0) {
                return;
            }
            this.mScreenRotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        } else if (this.mScreenRotation < 0 || (hasWindowFocus() && isShown())) {
            this.mScreenRotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("screen property updateScreenRotation.mScreenRotation=");
        sb.append(this.mScreenRotation);
        RVLogger.d(sb.toString());
    }

    public Camera getCamera() {
        return this.mCamera;
    }

    public void enableEventbus(boolean z) {
        this.mUseEventbus = z;
    }

    public boolean isEnableFrameData() {
        return this.mUseFrameData;
    }

    public boolean isEnableEventbus() {
        return this.mUseEventbus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes6.dex */
    public class WrapperListener implements IRecordListener, SightCameraView.ICameraFrameListener {

        /* renamed from: a  reason: collision with root package name */
        private SightCameraView.ICameraFrameListener f6571a;
        private SightCameraView.OnRecordListener b;

        protected WrapperListener() {
        }

        public void setVideoRecordListener(SightCameraView.OnRecordListener onRecordListener) {
            this.b = onRecordListener;
        }

        public void setCameraFrameListener(SightCameraView.ICameraFrameListener iCameraFrameListener) {
            this.f6571a = iCameraFrameListener;
        }

        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.ICameraFrameListener
        public void onFrameData(Object obj, int i, Bundle bundle) {
            SightCameraView.ICameraFrameListener iCameraFrameListener = this.f6571a;
            if (iCameraFrameListener != null) {
                iCameraFrameListener.onFrameData(obj, i, bundle);
            }
        }

        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.OnRecordListener
        public void onStart() {
            SightCameraView.OnRecordListener onRecordListener = this.b;
            if (onRecordListener != null) {
                onRecordListener.onStart();
            }
        }

        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.OnRecordListener
        public void onError(APVideoRecordRsp aPVideoRecordRsp) {
            SightCameraView.OnRecordListener onRecordListener = this.b;
            if (onRecordListener != null) {
                onRecordListener.onError(aPVideoRecordRsp);
            }
        }

        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.OnRecordListener
        public void onFinish(APVideoRecordRsp aPVideoRecordRsp) {
            SightCameraView.OnRecordListener onRecordListener = this.b;
            if (onRecordListener != null) {
                onRecordListener.onFinish(aPVideoRecordRsp);
            }
        }

        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.OnRecordListener
        public void onCancel() {
            SightCameraView.OnRecordListener onRecordListener = this.b;
            if (onRecordListener != null) {
                onRecordListener.onCancel();
            }
        }

        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.OnRecordListener
        public void onInfo(int i, Bundle bundle) {
            SightCameraView.OnRecordListener onRecordListener = this.b;
            if (onRecordListener != null) {
                onRecordListener.onInfo(i, bundle);
            }
        }

        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.OnRecordListener
        public void onPrepared(APVideoRecordRsp aPVideoRecordRsp) {
            SightCameraView.OnRecordListener onRecordListener = this.b;
            if (onRecordListener != null) {
                onRecordListener.onPrepared(aPVideoRecordRsp);
            }
        }
    }
}
