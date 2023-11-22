package com.alibaba.griver.image.capture.widget;

import android.content.Context;
import android.hardware.Camera;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.view.GestureDetectorCompat;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.image.capture.TakePictureProcessor;
import com.alibaba.griver.image.capture.meta.APTakePictureOption;
import com.alibaba.griver.image.capture.meta.APVideoRecordRsp;
import com.alibaba.griver.image.capture.meta.CameraParams;
import com.alibaba.griver.image.capture.widget.SightCameraView;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class SightCameraViewImpl extends SightCameraView {

    /* renamed from: a  reason: collision with root package name */
    private CameraView f6573a;
    private CameraFrontSightView b;
    private GestureDetectorCompat c;
    protected CameraParams cameraParams;
    private int d;
    private int e;
    private SightCameraView.OnRecordListener f;
    private SightCameraView.OnScrollListener g;
    private WeakReference<Object> h;
    private int i;
    private int j;
    private int k;

    public SightCameraViewImpl(Context context) {
        super(context);
        this.cameraParams = new CameraParams();
        this.d = 0;
        this.e = 0;
        this.i = -1;
        this.j = 0;
        this.k = 0;
        a();
    }

    public SightCameraViewImpl(Context context, CameraParams cameraParams) {
        super(context);
        new CameraParams();
        this.d = 0;
        this.e = 0;
        this.i = -1;
        this.j = 0;
        this.k = 0;
        this.cameraParams = cameraParams;
        this.h = new WeakReference<>(context);
        a();
    }

    private void a() {
        StringBuilder sb = new StringBuilder();
        sb.append("camera view init~~~ ");
        sb.append(this.cameraParams);
        RVLogger.d(sb.toString());
        b();
        this.f6573a.setCameraParams(this.cameraParams);
        this.f6573a.setActivityOrFragment(this.h);
        if (this.cameraParams != null && !this.f6573a.isEnableEventbus()) {
            this.f6573a.enableEventbus(this.cameraParams.isEnableEventBus());
        }
        addView(this.f6573a, 0);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.alibaba.griver.image.capture.widget.SightCameraViewImpl.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if ((SightCameraViewImpl.this.j != 0 && Math.abs(SightCameraViewImpl.this.j - SightCameraViewImpl.this.getWidth()) > 200) || (SightCameraViewImpl.this.k != 0 && Math.abs(SightCameraViewImpl.this.k - SightCameraViewImpl.this.getHeight()) > 200)) {
                    SightCameraViewImpl.this.f6573a.reLayout();
                    SightCameraViewImpl sightCameraViewImpl = SightCameraViewImpl.this;
                    sightCameraViewImpl.j = sightCameraViewImpl.getWidth();
                    SightCameraViewImpl sightCameraViewImpl2 = SightCameraViewImpl.this;
                    sightCameraViewImpl2.k = sightCameraViewImpl2.getHeight();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("reLayout offset_x: ");
                    sb2.append(SightCameraViewImpl.this.d);
                    sb2.append(";mOffsety=");
                    sb2.append(SightCameraViewImpl.this.e);
                    RVLogger.d(sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("reLayout mCameraView:");
                    sb3.append(SightCameraViewImpl.this.f6573a.getWidth());
                    sb3.append(",");
                    sb3.append(SightCameraViewImpl.this.f6573a.getHeight());
                    RVLogger.d(sb3.toString());
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("reLayout sightcameraview:");
                    sb4.append(SightCameraViewImpl.this.getWidth());
                    sb4.append(",");
                    sb4.append(SightCameraViewImpl.this.getHeight());
                    RVLogger.d(sb4.toString());
                    return;
                }
                SightCameraViewImpl sightCameraViewImpl3 = SightCameraViewImpl.this;
                sightCameraViewImpl3.d = (sightCameraViewImpl3.f6573a.getWidth() - SightCameraViewImpl.this.getWidth()) / 2;
                SightCameraViewImpl sightCameraViewImpl4 = SightCameraViewImpl.this;
                sightCameraViewImpl4.e = (sightCameraViewImpl4.f6573a.getHeight() - SightCameraViewImpl.this.getHeight()) / 2;
                SightCameraViewImpl sightCameraViewImpl5 = SightCameraViewImpl.this;
                sightCameraViewImpl5.scrollTo(sightCameraViewImpl5.d, SightCameraViewImpl.this.e);
                SightCameraViewImpl sightCameraViewImpl6 = SightCameraViewImpl.this;
                sightCameraViewImpl6.j = sightCameraViewImpl6.getWidth();
                SightCameraViewImpl sightCameraViewImpl7 = SightCameraViewImpl.this;
                sightCameraViewImpl7.k = sightCameraViewImpl7.getHeight();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("offset_x: ");
                sb5.append(SightCameraViewImpl.this.d);
                sb5.append(";mOffsety=");
                sb5.append(SightCameraViewImpl.this.e);
                RVLogger.d(sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append("mCameraView:");
                sb6.append(SightCameraViewImpl.this.f6573a.getWidth());
                sb6.append(",");
                sb6.append(SightCameraViewImpl.this.f6573a.getHeight());
                RVLogger.d(sb6.toString());
                StringBuilder sb7 = new StringBuilder();
                sb7.append("sightcameraview:");
                sb7.append(SightCameraViewImpl.this.getWidth());
                sb7.append(",");
                sb7.append(SightCameraViewImpl.this.getHeight());
                RVLogger.d(sb7.toString());
            }
        });
        this.c = new GestureDetectorCompat(getContext(), new GestureListener());
        CameraFrontSightView cameraFrontSightView = new CameraFrontSightView(getContext());
        this.b = cameraFrontSightView;
        addView(cameraFrontSightView, 1);
        this.b.init(120, 120);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    private void b() {
        if (this.f6573a == null) {
            this.f6573a = new SightCameraTextureView(getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, float f2) {
        CameraFrontSightView cameraFrontSightView = this.b;
        if (cameraFrontSightView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) cameraFrontSightView.getLayoutParams();
        layoutParams.leftMargin = ((int) f) - (this.b.mWidth / 2);
        layoutParams.topMargin = ((int) f2) - (this.b.mHeight / 2);
        this.b.setLayoutParams(layoutParams);
        this.b.startDraw();
        this.b.requestLayout();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.c.MyBillsEntityDataFactory(motionEvent);
    }

    @Override // com.alibaba.griver.image.capture.widget.SightCameraView
    public void setOnRecordListener(SightCameraView.OnRecordListener onRecordListener) {
        this.f = onRecordListener;
        CameraView cameraView = this.f6573a;
        if (cameraView != null) {
            cameraView.setOnRecordListener(onRecordListener);
        }
    }

    @Override // com.alibaba.griver.image.capture.widget.SightCameraView
    public Camera switchCamera() {
        this.f6573a.setRecordPhase(APVideoRecordRsp.RecordPhase.SWITCHCAMERA);
        return this.f6573a.switchCamera();
    }

    public Camera reopenCamera(int i) {
        this.f6573a.setRecordPhase(APVideoRecordRsp.RecordPhase.REOPENCAMERA);
        return this.f6573a.reopenCamera(i);
    }

    @Override // com.alibaba.griver.image.capture.widget.SightCameraView
    public void setOnScrollListener(SightCameraView.OnScrollListener onScrollListener) {
        this.g = onScrollListener;
    }

    @Override // com.alibaba.griver.image.capture.widget.SightCameraView
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        CameraView cameraView = this.f6573a;
        if (cameraView != null) {
            cameraView.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.alibaba.griver.image.capture.widget.SightCameraView
    public void takePicture(final SightCameraView.TakePictureListener takePictureListener, final Looper looper, final APTakePictureOption aPTakePictureOption) {
        CameraView cameraView = this.f6573a;
        if (cameraView != null) {
            cameraView.setRecordPhase(APVideoRecordRsp.RecordPhase.SNAPSHOTING);
        }
        if (this.f6573a != null) {
            if (ExecutorUtils.isMainThread()) {
                GriverExecutors.getExecutor(ExecutorType.IO).execute(new Runnable() { // from class: com.alibaba.griver.image.capture.widget.SightCameraViewImpl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new TakePictureProcessor().takePicture(SightCameraViewImpl.this.f6573a.getCamera(), SightCameraViewImpl.this.f6573a.getCameraId(), takePictureListener, looper, SightCameraViewImpl.this.f6573a.cameraParams, aPTakePictureOption);
                        } catch (Throwable th) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("takePicture error! listener: ");
                            sb.append(takePictureListener);
                            sb.append(", looper: ");
                            sb.append(looper);
                            sb.append(", params: ");
                            sb.append(SightCameraViewImpl.this.f6573a.cameraParams);
                            RVLogger.e("SightCameraViewImpl", sb.toString(), th);
                            SightCameraView.TakePictureListener takePictureListener2 = takePictureListener;
                            if (takePictureListener2 != null) {
                                takePictureListener2.onPictureProcessError(1, null);
                            }
                        }
                    }
                });
                return;
            }
            try {
                new TakePictureProcessor().takePicture(this.f6573a.getCamera(), this.f6573a.getCameraId(), takePictureListener, looper, this.f6573a.cameraParams, aPTakePictureOption);
                return;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("takePicture error! listener: ");
                sb.append(takePictureListener);
                sb.append(", looper: ");
                sb.append(looper);
                sb.append(", params: ");
                sb.append(this.f6573a.cameraParams);
                RVLogger.e("SightCameraViewImpl", sb.toString(), th);
                if (takePictureListener != null) {
                    takePictureListener.onPictureProcessError(1, null);
                    return;
                }
                return;
            }
        }
        throw new IllegalStateException("Sorry, please check camera view init!!!");
    }

    @Override // com.alibaba.griver.image.capture.widget.SightCameraView
    public void releaseCamera() {
        CameraView cameraView = this.f6573a;
        if (cameraView != null) {
            cameraView.setRecordPhase(APVideoRecordRsp.RecordPhase.RELEASECAMERA);
            this.f6573a.releaseCamera();
        }
    }

    @Override // com.alibaba.griver.image.capture.widget.SightCameraView
    public Camera getCamera() {
        CameraView cameraView = this.f6573a;
        if (cameraView != null) {
            return cameraView.getCamera();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            RVLogger.d("onDown");
            motionEvent.offsetLocation(SightCameraViewImpl.this.d, SightCameraViewImpl.this.e);
            SightCameraViewImpl.this.a(motionEvent.getX(), motionEvent.getY());
            SightCameraViewImpl.this.f6573a.focusOnTouch(motionEvent);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            RVLogger.d("onDoubleTap");
            SightCameraViewImpl.this.f6573a.zoom();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (SightCameraViewImpl.this.g != null) {
                SightCameraViewImpl.this.g.onScroll(motionEvent, motionEvent2, f, f2);
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (SightCameraViewImpl.this.g != null) {
                SightCameraViewImpl.this.g.onFling(motionEvent, motionEvent2, f, f2);
                return false;
            }
            return false;
        }
    }
}
