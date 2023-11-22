package com.alipay.zoloz.hardware.camera.widget;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.android.phone.zoloz.camera.BuildConfig;
import com.alipay.mobile.security.bio.utils.DisplayUtil;
import com.alipay.mobile.security.faceauth.circle.protocol.DeviceSetting;
import com.alipay.zoloz.hardware.camera.ICameraCallback;
import com.alipay.zoloz.hardware.camera.ICameraInterface;
import com.alipay.zoloz.hardware.camera.utils.DeviceSettingUtil;
import com.alipay.zoloz.hardware.camera.widget.utils.FocusAreaUtils;
import com.google.common.base.Ascii;
import java.lang.reflect.Field;

/* loaded from: classes7.dex */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback, AbsSurfaceView {
    static ICameraInterface mCameraInterface;
    private final long CLICK_DISTANCE;
    private final long DELAY_TIME;
    ICameraCallback mCameraCallback;
    Context mContext;
    private DeviceSetting mDeviceSetting;
    private long mDownTime;
    private float mDownX;
    private float mDownY;
    private FocusView mFocusView;
    float mPreviewRate;
    SurfaceHolder mSurfaceHolder;
    private long mTouchTime;
    public static final byte[] getAuthRequestContext = {71, Ascii.US, 113, 39, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int BuiltInFictitiousFunctionClassFactory = 219;

    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DELAY_TIME = 200L;
        this.CLICK_DISTANCE = 10L;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mPreviewRate = DisplayUtil.getScreenRate(applicationContext);
        SurfaceHolder holder = getHolder();
        this.mSurfaceHolder = holder;
        holder.setFormat(-2);
        this.mSurfaceHolder.setType(3);
        this.mSurfaceHolder.addCallback(this);
        this.mFocusView = new FocusView(this.mContext);
    }

    @Override // com.alipay.zoloz.hardware.camera.widget.AbsSurfaceView
    public void init(DeviceSetting[] deviceSettingArr) {
        this.mDeviceSetting = DeviceSettingUtil.getPropertyDeviceSetting(deviceSettingArr);
        getCameraImpl(this.mContext);
        ICameraInterface iCameraInterface = mCameraInterface;
        if (iCameraInterface != null) {
            iCameraInterface.initCamera(this.mDeviceSetting);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        ICameraInterface iCameraInterface = mCameraInterface;
        if (iCameraInterface != null) {
            iCameraInterface.setCallback(this.mCameraCallback);
        }
        try {
            ICameraInterface iCameraInterface2 = mCameraInterface;
            if (iCameraInterface2 != null) {
                iCameraInterface2.startCamera();
            }
            ICameraCallback iCameraCallback = this.mCameraCallback;
            if (iCameraCallback != null) {
                iCameraCallback.onSurfaceCreated();
            }
        } catch (Exception unused) {
            ICameraCallback iCameraCallback2 = this.mCameraCallback;
            if (iCameraCallback2 != null) {
                iCameraCallback2.onError(-1);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        ICameraInterface iCameraInterface = mCameraInterface;
        if (iCameraInterface != null) {
            try {
                iCameraInterface.startPreview(this.mSurfaceHolder, this.mPreviewRate, i2, i3);
            } catch (Exception unused) {
            }
            if (this.mCameraCallback != null) {
                int cameraViewRotation = mCameraInterface.getCameraViewRotation();
                if (cameraViewRotation == 90 || cameraViewRotation == 270) {
                    i2 = mCameraInterface.getPreviewHeight();
                    i3 = mCameraInterface.getPreviewWidth();
                } else if (cameraViewRotation == 0 || cameraViewRotation == 180) {
                    i2 = mCameraInterface.getPreviewWidth();
                    i3 = mCameraInterface.getPreviewHeight();
                }
                this.mCameraCallback.onSurfaceChanged(i2, i3);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        ICameraInterface iCameraInterface = mCameraInterface;
        if (iCameraInterface != null) {
            iCameraInterface.stopCamera();
            mCameraInterface.setCallback(null);
        }
        ICameraCallback iCameraCallback = this.mCameraCallback;
        if (iCameraCallback != null) {
            iCameraCallback.onSurfaceDestroyed();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e A[Catch: ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b, TryCatch #0 {ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b, blocks: (B:4:0x0004, B:8:0x0026, B:10:0x002e, B:11:0x004d), top: B:17:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004d A[Catch: ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b, TRY_LEAVE, TryCatch #0 {ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b, blocks: (B:4:0x0004, B:8:0x0026, B:10:0x002e, B:11:0x004d), top: B:17:0x0004 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x004f -> B:13:0x0054). Please submit an issue!!! */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alipay.zoloz.hardware.camera.ICameraInterface getCameraImpl(android.content.Context r12) {
        /*
            com.alipay.zoloz.hardware.camera.ICameraInterface r0 = com.alipay.zoloz.hardware.camera.widget.CameraSurfaceView.mCameraInterface
            if (r0 != 0) goto L5b
            java.lang.String r0 = "com.alipay.zoloz.hardware.camera.impl.AndroidImpl"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L5b
            r1 = 1
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L5b
            byte[] r3 = com.alipay.zoloz.hardware.camera.widget.CameraSurfaceView.getAuthRequestContext     // Catch: java.lang.Throwable -> L5b
            r4 = 23
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L5b
            r5 = 3
            r6 = 97
            r7 = 0
            if (r3 != 0) goto L21
            r6 = r4
            r8 = 3
            r9 = 0
            r10 = 97
            r4 = r3
            r3 = r2
            goto L54
        L21:
            r5 = r4
            r8 = 3
            r9 = 0
            r4 = r3
            r3 = r2
        L26:
            byte r10 = (byte) r6     // Catch: java.lang.Throwable -> L5b
            int r8 = r8 + r1
            r5[r9] = r10     // Catch: java.lang.Throwable -> L5b
            r10 = 22
            if (r9 != r10) goto L4d
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L5b
            r4.<init>(r5, r7)     // Catch: java.lang.Throwable -> L5b
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Throwable -> L5b
            r2[r7] = r4     // Catch: java.lang.Throwable -> L5b
            java.lang.String r2 = "getInstance"
            java.lang.reflect.Method r0 = r0.getMethod(r2, r3)     // Catch: java.lang.Throwable -> L5b
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L5b
            r1[r7] = r12     // Catch: java.lang.Throwable -> L5b
            r12 = 0
            java.lang.Object r12 = r0.invoke(r12, r1)     // Catch: java.lang.Throwable -> L5b
            com.alipay.zoloz.hardware.camera.ICameraInterface r12 = (com.alipay.zoloz.hardware.camera.ICameraInterface) r12     // Catch: java.lang.Throwable -> L5b
            com.alipay.zoloz.hardware.camera.widget.CameraSurfaceView.mCameraInterface = r12     // Catch: java.lang.Throwable -> L5b
            goto L5b
        L4d:
            r10 = r4[r8]     // Catch: java.lang.Throwable -> L5b
            int r9 = r9 + 1
            r11 = r6
            r6 = r5
            r5 = r11
        L54:
            int r5 = r5 + r10
            int r5 = r5 + (-8)
            r11 = r6
            r6 = r5
            r5 = r11
            goto L26
        L5b:
            com.alipay.zoloz.hardware.camera.ICameraInterface r12 = com.alipay.zoloz.hardware.camera.widget.CameraSurfaceView.mCameraInterface
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.zoloz.hardware.camera.widget.CameraSurfaceView.getCameraImpl(android.content.Context):com.alipay.zoloz.hardware.camera.ICameraInterface");
    }

    @Override // com.alipay.zoloz.hardware.camera.widget.AbsSurfaceView
    public ICameraInterface getCameraInterface() {
        return getCameraImpl(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isClickable()) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDownTime = System.currentTimeMillis();
            this.mDownX = motionEvent.getX();
            this.mDownY = motionEvent.getY();
        } else if (action == 1 || action == 3) {
            this.mTouchTime = System.currentTimeMillis() - this.mDownTime;
            detectGesture(this.mDownX, motionEvent.getX(), this.mDownY, motionEvent.getY());
        }
        return true;
    }

    private void detectGesture(float f, float f2, float f3, float f4) {
        if (mCameraInterface != null && Math.abs(f2 - f) < 10.0f && Math.abs(f4 - f3) < 10.0f && this.mTouchTime < 200) {
            ViewParent parent = this.mFocusView.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.mFocusView);
            }
            ViewGroup viewGroup = (ViewGroup) getParent();
            viewGroup.addView(this.mFocusView, findIndex(viewGroup), new ViewGroup.LayoutParams(-2, -2));
            this.mFocusView.moveToPosition(f2, f4);
            this.mFocusView.startFocus();
            mCameraInterface.autoFocus(FocusAreaUtils.computeMeteringAreas(f2, f4, getWidth(), getHeight(), mCameraInterface.getCameraViewRotation()), new Camera.AutoFocusCallback() { // from class: com.alipay.zoloz.hardware.camera.widget.CameraSurfaceView.1
                @Override // android.hardware.Camera.AutoFocusCallback
                public void onAutoFocus(boolean z, Camera camera) {
                    CameraSurfaceView.this.mFocusView.hideFocusView();
                }
            });
        }
    }

    private int findIndex(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = viewGroup.getChildAt(i);
            i++;
            if (childAt == this) {
                return i;
            }
        }
        return childCount;
    }

    public static void release() {
        mCameraInterface = null;
    }

    public static String getCameraName() {
        try {
            Field field = BuildConfig.class.getField("CAMERA");
            field.setAccessible(true);
            return (String) field.get(BuildConfig.class);
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return "Android";
        }
    }

    public SurfaceHolder getSurfaceHolder() {
        return this.mSurfaceHolder;
    }

    @Override // com.alipay.zoloz.hardware.camera.widget.AbsSurfaceView
    public void setCameraCallback(ICameraCallback iCameraCallback) {
        this.mCameraCallback = iCameraCallback;
    }
}
