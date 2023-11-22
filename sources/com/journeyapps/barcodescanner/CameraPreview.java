package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.zxing.client.android.R;
import com.journeyapps.barcodescanner.camera.CameraInstance;
import com.journeyapps.barcodescanner.camera.CameraParametersCallback;
import com.journeyapps.barcodescanner.camera.CameraSettings;
import com.journeyapps.barcodescanner.camera.CameraSurface;
import com.journeyapps.barcodescanner.camera.CameraThread;
import com.journeyapps.barcodescanner.camera.CenterCropStrategy;
import com.journeyapps.barcodescanner.camera.DisplayConfiguration;
import com.journeyapps.barcodescanner.camera.FitCenterStrategy;
import com.journeyapps.barcodescanner.camera.FitXYStrategy;
import com.journeyapps.barcodescanner.camera.PreviewScalingStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class CameraPreview extends ViewGroup {
    private static final String BuiltInFictitiousFunctionClassFactory = "CameraPreview";
    private Size DatabaseTableConfigUtil;
    private final SurfaceHolder.Callback FragmentBottomSheetPaymentSettingBinding;
    private int GetContactSyncConfig;
    private Size KClassImpl$Data$declaredNonStaticMembers$2;
    private CameraInstance MyBillsEntityDataFactory;
    private Size NetworkUserEntityData$$ExternalSyntheticLambda0;
    private PreviewScalingStrategy NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private Rect NetworkUserEntityData$$ExternalSyntheticLambda3;
    private TextureView NetworkUserEntityData$$ExternalSyntheticLambda4;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5;
    private SurfaceView NetworkUserEntityData$$ExternalSyntheticLambda6;
    private Handler NetworkUserEntityData$$ExternalSyntheticLambda7;
    private List<StateListener> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private Size PlaceComponentResult;
    private RotationListener PrepareContext;
    private boolean SubSequence;
    private CameraSettings getAuthRequestContext;
    private double getErrorConfigVersion;
    private Rect initRecordTimeStamp;
    private RotationCallback isLayoutRequested;
    private Rect lookAheadTest;
    private DisplayConfiguration moveToNextValue;
    private final Handler.Callback newProxyInstance;
    private final StateListener scheduleImpl;
    private WindowManager whenAvailable;

    /* loaded from: classes3.dex */
    public interface StateListener {
        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void getAuthRequestContext();

        void getAuthRequestContext(Exception exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void previewStarted() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.journeyapps.barcodescanner.CameraPreview$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements TextureView.SurfaceTextureListener {
        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        AnonymousClass1() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            CameraPreview.this.KClassImpl$Data$declaredNonStaticMembers$2 = new Size(i, i2);
            CameraPreview.this.PlaceComponentResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.journeyapps.barcodescanner.CameraPreview$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass4 implements RotationCallback {
        AnonymousClass4() {
        }

        @Override // com.journeyapps.barcodescanner.RotationCallback
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            CameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda7.postDelayed(new Runnable() { // from class: com.journeyapps.barcodescanner.CameraPreview$4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CameraPreview.access$600(CameraPreview.this);
                }
            }, 250L);
        }
    }

    public CameraPreview(Context context) {
        super(context);
        this.SubSequence = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
        this.GetContactSyncConfig = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new ArrayList();
        this.getAuthRequestContext = new CameraSettings();
        this.lookAheadTest = null;
        this.initRecordTimeStamp = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        this.getErrorConfigVersion = 0.1d;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = false;
        this.FragmentBottomSheetPaymentSettingBinding = new SurfaceHolder.Callback() { // from class: com.journeyapps.barcodescanner.CameraPreview.2
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                CameraPreview.this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                if (surfaceHolder == null) {
                    InstrumentInjector.log_e(CameraPreview.BuiltInFictitiousFunctionClassFactory, "*** WARNING *** surfaceChanged() gave us a null surface!");
                    return;
                }
                CameraPreview.this.KClassImpl$Data$declaredNonStaticMembers$2 = new Size(i2, i3);
                CameraPreview.this.PlaceComponentResult();
            }
        };
        this.newProxyInstance = new Handler.Callback() { // from class: com.journeyapps.barcodescanner.CameraPreview.3
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == R.id.zxing_prewiew_size_ready) {
                    CameraPreview.access$300(CameraPreview.this, (Size) message.obj);
                    return true;
                } else if (message.what == R.id.zxing_camera_error) {
                    Exception exc = (Exception) message.obj;
                    if (CameraPreview.this.isActive()) {
                        CameraPreview.this.pause();
                        CameraPreview.this.scheduleImpl.getAuthRequestContext(exc);
                        return false;
                    }
                    return false;
                } else if (message.what == R.id.zxing_camera_closed) {
                    CameraPreview.this.scheduleImpl.MyBillsEntityDataFactory();
                    return false;
                } else {
                    return false;
                }
            }
        };
        this.isLayoutRequested = new AnonymousClass4();
        this.scheduleImpl = new StateListener() { // from class: com.journeyapps.barcodescanner.CameraPreview.5
            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                Iterator it = CameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.iterator();
                while (it.hasNext()) {
                    ((StateListener) it.next()).KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                Iterator it = CameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.iterator();
                while (it.hasNext()) {
                    ((StateListener) it.next()).BuiltInFictitiousFunctionClassFactory();
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void getAuthRequestContext() {
                Iterator it = CameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.iterator();
                while (it.hasNext()) {
                    ((StateListener) it.next()).getAuthRequestContext();
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void getAuthRequestContext(Exception exc) {
                Iterator it = CameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.iterator();
                while (it.hasNext()) {
                    ((StateListener) it.next()).getAuthRequestContext(exc);
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void MyBillsEntityDataFactory() {
                Iterator it = CameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.iterator();
                while (it.hasNext()) {
                    ((StateListener) it.next()).MyBillsEntityDataFactory();
                }
            }
        };
        BuiltInFictitiousFunctionClassFactory(context, null);
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.SubSequence = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
        this.GetContactSyncConfig = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new ArrayList();
        this.getAuthRequestContext = new CameraSettings();
        this.lookAheadTest = null;
        this.initRecordTimeStamp = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        this.getErrorConfigVersion = 0.1d;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = false;
        this.FragmentBottomSheetPaymentSettingBinding = new SurfaceHolder.Callback() { // from class: com.journeyapps.barcodescanner.CameraPreview.2
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                CameraPreview.this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                if (surfaceHolder == null) {
                    InstrumentInjector.log_e(CameraPreview.BuiltInFictitiousFunctionClassFactory, "*** WARNING *** surfaceChanged() gave us a null surface!");
                    return;
                }
                CameraPreview.this.KClassImpl$Data$declaredNonStaticMembers$2 = new Size(i2, i3);
                CameraPreview.this.PlaceComponentResult();
            }
        };
        this.newProxyInstance = new Handler.Callback() { // from class: com.journeyapps.barcodescanner.CameraPreview.3
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == R.id.zxing_prewiew_size_ready) {
                    CameraPreview.access$300(CameraPreview.this, (Size) message.obj);
                    return true;
                } else if (message.what == R.id.zxing_camera_error) {
                    Exception exc = (Exception) message.obj;
                    if (CameraPreview.this.isActive()) {
                        CameraPreview.this.pause();
                        CameraPreview.this.scheduleImpl.getAuthRequestContext(exc);
                        return false;
                    }
                    return false;
                } else if (message.what == R.id.zxing_camera_closed) {
                    CameraPreview.this.scheduleImpl.MyBillsEntityDataFactory();
                    return false;
                } else {
                    return false;
                }
            }
        };
        this.isLayoutRequested = new AnonymousClass4();
        this.scheduleImpl = new StateListener() { // from class: com.journeyapps.barcodescanner.CameraPreview.5
            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                Iterator it = CameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.iterator();
                while (it.hasNext()) {
                    ((StateListener) it.next()).KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                Iterator it = CameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.iterator();
                while (it.hasNext()) {
                    ((StateListener) it.next()).BuiltInFictitiousFunctionClassFactory();
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void getAuthRequestContext() {
                Iterator it = CameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.iterator();
                while (it.hasNext()) {
                    ((StateListener) it.next()).getAuthRequestContext();
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void getAuthRequestContext(Exception exc) {
                Iterator it = CameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.iterator();
                while (it.hasNext()) {
                    ((StateListener) it.next()).getAuthRequestContext(exc);
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void MyBillsEntityDataFactory() {
                Iterator it = CameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.iterator();
                while (it.hasNext()) {
                    ((StateListener) it.next()).MyBillsEntityDataFactory();
                }
            }
        };
        BuiltInFictitiousFunctionClassFactory(context, attributeSet);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.SubSequence = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
        this.GetContactSyncConfig = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new ArrayList();
        this.getAuthRequestContext = new CameraSettings();
        this.lookAheadTest = null;
        this.initRecordTimeStamp = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        this.getErrorConfigVersion = 0.1d;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = false;
        this.FragmentBottomSheetPaymentSettingBinding = new SurfaceHolder.Callback() { // from class: com.journeyapps.barcodescanner.CameraPreview.2
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                CameraPreview.this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i22, int i3) {
                if (surfaceHolder == null) {
                    InstrumentInjector.log_e(CameraPreview.BuiltInFictitiousFunctionClassFactory, "*** WARNING *** surfaceChanged() gave us a null surface!");
                    return;
                }
                CameraPreview.this.KClassImpl$Data$declaredNonStaticMembers$2 = new Size(i22, i3);
                CameraPreview.this.PlaceComponentResult();
            }
        };
        this.newProxyInstance = new Handler.Callback() { // from class: com.journeyapps.barcodescanner.CameraPreview.3
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == R.id.zxing_prewiew_size_ready) {
                    CameraPreview.access$300(CameraPreview.this, (Size) message.obj);
                    return true;
                } else if (message.what == R.id.zxing_camera_error) {
                    Exception exc = (Exception) message.obj;
                    if (CameraPreview.this.isActive()) {
                        CameraPreview.this.pause();
                        CameraPreview.this.scheduleImpl.getAuthRequestContext(exc);
                        return false;
                    }
                    return false;
                } else if (message.what == R.id.zxing_camera_closed) {
                    CameraPreview.this.scheduleImpl.MyBillsEntityDataFactory();
                    return false;
                } else {
                    return false;
                }
            }
        };
        this.isLayoutRequested = new AnonymousClass4();
        this.scheduleImpl = new StateListener() { // from class: com.journeyapps.barcodescanner.CameraPreview.5
            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                Iterator it = CameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.iterator();
                while (it.hasNext()) {
                    ((StateListener) it.next()).KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                Iterator it = CameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.iterator();
                while (it.hasNext()) {
                    ((StateListener) it.next()).BuiltInFictitiousFunctionClassFactory();
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void getAuthRequestContext() {
                Iterator it = CameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.iterator();
                while (it.hasNext()) {
                    ((StateListener) it.next()).getAuthRequestContext();
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void getAuthRequestContext(Exception exc) {
                Iterator it = CameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.iterator();
                while (it.hasNext()) {
                    ((StateListener) it.next()).getAuthRequestContext(exc);
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void MyBillsEntityDataFactory() {
                Iterator it = CameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.iterator();
                while (it.hasNext()) {
                    ((StateListener) it.next()).MyBillsEntityDataFactory();
                }
            }
        };
        BuiltInFictitiousFunctionClassFactory(context, attributeSet);
    }

    private void BuiltInFictitiousFunctionClassFactory(Context context, AttributeSet attributeSet) {
        if (getBackground() == null) {
            setBackgroundColor(-16777216);
        }
        initializeAttributes(attributeSet);
        this.whenAvailable = (WindowManager) context.getSystemService("window");
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new Handler(this.newProxyInstance);
        this.PrepareContext = new RotationListener();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.SubSequence) {
            TextureView textureView = new TextureView(getContext());
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = textureView;
            textureView.setSurfaceTextureListener(new AnonymousClass1());
            addView(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            return;
        }
        SurfaceView surfaceView = new SurfaceView(getContext());
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = surfaceView;
        surfaceView.getHolder().addCallback(this.FragmentBottomSheetPaymentSettingBinding);
        addView(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initializeAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_camera_preview);
        int dimension = (int) obtainStyledAttributes.getDimension(R.styleable.zxing_camera_preview_zxing_framing_rect_width, -1.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(R.styleable.zxing_camera_preview_zxing_framing_rect_height, -1.0f);
        if (dimension > 0 && dimension2 > 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new Size(dimension, dimension2);
        }
        this.SubSequence = obtainStyledAttributes.getBoolean(R.styleable.zxing_camera_preview_zxing_use_texture_view, true);
        int integer = obtainStyledAttributes.getInteger(R.styleable.zxing_camera_preview_zxing_preview_scaling_strategy, -1);
        if (integer == 1) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new CenterCropStrategy();
        } else if (integer == 2) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new FitCenterStrategy();
        } else if (integer == 3) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new FitXYStrategy();
        }
        obtainStyledAttributes.recycle();
    }

    public void addStateListener(StateListener stateListener) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.add(stateListener);
    }

    public void setTorch(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = z;
        CameraInstance cameraInstance = this.MyBillsEntityDataFactory;
        if (cameraInstance != null) {
            cameraInstance.BuiltInFictitiousFunctionClassFactory(z);
        }
    }

    public void changeCameraParameters(final CameraParametersCallback cameraParametersCallback) {
        final CameraInstance cameraInstance = this.MyBillsEntityDataFactory;
        if (cameraInstance != null) {
            Util.KClassImpl$Data$declaredNonStaticMembers$2();
            if (cameraInstance.moveToNextValue) {
                CameraThread cameraThread = cameraInstance.PlaceComponentResult;
                Runnable runnable = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        CameraInstance cameraInstance2 = CameraInstance.this;
                        CameraParametersCallback cameraParametersCallback2 = cameraParametersCallback;
                        Camera camera = cameraInstance2.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (camera != null) {
                            try {
                                camera.getParameters();
                                camera.setParameters(cameraParametersCallback2.getAuthRequestContext());
                            } catch (RuntimeException e) {
                                InstrumentInjector.log_e(CameraManager.getAuthRequestContext, "Failed to change camera parameters", e);
                            }
                        }
                    }
                };
                synchronized (cameraThread.getAuthRequestContext) {
                    cameraThread.KClassImpl$Data$declaredNonStaticMembers$2();
                    cameraThread.KClassImpl$Data$declaredNonStaticMembers$2.post(runnable);
                }
            }
        }
    }

    public void setPreviewScalingStrategy(PreviewScalingStrategy previewScalingStrategy) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = previewScalingStrategy;
    }

    public PreviewScalingStrategy getPreviewScalingStrategy() {
        PreviewScalingStrategy previewScalingStrategy = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (previewScalingStrategy != null) {
            return previewScalingStrategy;
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda4 != null) {
            return new CenterCropStrategy();
        }
        return new FitCenterStrategy();
    }

    protected Matrix calculateTextureTransform(Size size, Size size2) {
        float f;
        float f2 = size.MyBillsEntityDataFactory / size.KClassImpl$Data$declaredNonStaticMembers$2;
        float f3 = size2.MyBillsEntityDataFactory / size2.KClassImpl$Data$declaredNonStaticMembers$2;
        float f4 = 1.0f;
        if (f2 < f3) {
            f4 = f3 / f2;
            f = 1.0f;
        } else {
            f = f2 / f3;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f4, f);
        matrix.postTranslate((size.MyBillsEntityDataFactory - (size.MyBillsEntityDataFactory * f4)) / 2.0f, (size.KClassImpl$Data$declaredNonStaticMembers$2 - (size.KClassImpl$Data$declaredNonStaticMembers$2 * f)) / 2.0f);
        return matrix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PlaceComponentResult() {
        Rect rect;
        Size size = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (size == null || this.DatabaseTableConfigUtil == null || (rect = this.NetworkUserEntityData$$ExternalSyntheticLambda3) == null) {
            return;
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda6 != null && size.equals(new Size(rect.width(), this.NetworkUserEntityData$$ExternalSyntheticLambda3.height()))) {
            KClassImpl$Data$declaredNonStaticMembers$2(new CameraSurface(this.NetworkUserEntityData$$ExternalSyntheticLambda6.getHolder()));
            return;
        }
        TextureView textureView = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (textureView == null || textureView.getSurfaceTexture() == null) {
            return;
        }
        if (this.DatabaseTableConfigUtil != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.setTransform(calculateTextureTransform(new Size(this.NetworkUserEntityData$$ExternalSyntheticLambda4.getWidth(), this.NetworkUserEntityData$$ExternalSyntheticLambda4.getHeight()), this.DatabaseTableConfigUtil));
        }
        KClassImpl$Data$declaredNonStaticMembers$2(new CameraSurface(this.NetworkUserEntityData$$ExternalSyntheticLambda4.getSurfaceTexture()));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Size size = new Size(i3 - i, i4 - i2);
        this.PlaceComponentResult = size;
        CameraInstance cameraInstance = this.MyBillsEntityDataFactory;
        if (cameraInstance != null && cameraInstance.getErrorConfigVersion == null) {
            DisplayConfiguration displayConfiguration = new DisplayConfiguration(this.whenAvailable.getDefaultDisplay().getRotation(), size);
            this.moveToNextValue = displayConfiguration;
            displayConfiguration.MyBillsEntityDataFactory = getPreviewScalingStrategy();
            CameraInstance cameraInstance2 = this.MyBillsEntityDataFactory;
            DisplayConfiguration displayConfiguration2 = this.moveToNextValue;
            cameraInstance2.getErrorConfigVersion = displayConfiguration2;
            cameraInstance2.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = displayConfiguration2;
            CameraInstance cameraInstance3 = this.MyBillsEntityDataFactory;
            Util.KClassImpl$Data$declaredNonStaticMembers$2();
            if (cameraInstance3.moveToNextValue) {
                CameraThread cameraThread = cameraInstance3.PlaceComponentResult;
                Runnable runnable = cameraInstance3.scheduleImpl;
                synchronized (cameraThread.getAuthRequestContext) {
                    cameraThread.KClassImpl$Data$declaredNonStaticMembers$2();
                    cameraThread.KClassImpl$Data$declaredNonStaticMembers$2.post(runnable);
                }
                boolean z2 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                if (z2) {
                    this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(z2);
                }
            } else {
                throw new IllegalStateException("CameraInstance is not open");
            }
        }
        SurfaceView surfaceView = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (surfaceView != null) {
            Rect rect = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            if (rect == null) {
                surfaceView.layout(0, 0, getWidth(), getHeight());
                return;
            } else {
                surfaceView.layout(rect.left, this.NetworkUserEntityData$$ExternalSyntheticLambda3.top, this.NetworkUserEntityData$$ExternalSyntheticLambda3.right, this.NetworkUserEntityData$$ExternalSyntheticLambda3.bottom);
                return;
            }
        }
        TextureView textureView = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (textureView != null) {
            textureView.layout(0, 0, getWidth(), getHeight());
        }
    }

    public Rect getFramingRect() {
        return this.lookAheadTest;
    }

    public Rect getPreviewFramingRect() {
        return this.initRecordTimeStamp;
    }

    public Size getPreviewSize() {
        return this.DatabaseTableConfigUtil;
    }

    public CameraSettings getCameraSettings() {
        return this.getAuthRequestContext;
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        this.getAuthRequestContext = cameraSettings;
    }

    public void resume() {
        Util.KClassImpl$Data$declaredNonStaticMembers$2();
        InstrumentInjector.log_d(BuiltInFictitiousFunctionClassFactory, "resume()");
        if (this.MyBillsEntityDataFactory != null) {
            InstrumentInjector.log_w(BuiltInFictitiousFunctionClassFactory, "initCamera called twice");
        } else {
            CameraInstance createCameraInstance = createCameraInstance();
            this.MyBillsEntityDataFactory = createCameraInstance;
            createCameraInstance.DatabaseTableConfigUtil = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            CameraInstance cameraInstance = this.MyBillsEntityDataFactory;
            Util.KClassImpl$Data$declaredNonStaticMembers$2();
            cameraInstance.moveToNextValue = true;
            cameraInstance.MyBillsEntityDataFactory = false;
            CameraThread cameraThread = cameraInstance.PlaceComponentResult;
            Runnable runnable = cameraInstance.initRecordTimeStamp;
            synchronized (cameraThread.getAuthRequestContext) {
                cameraThread.PlaceComponentResult++;
                synchronized (cameraThread.getAuthRequestContext) {
                    cameraThread.KClassImpl$Data$declaredNonStaticMembers$2();
                    cameraThread.KClassImpl$Data$declaredNonStaticMembers$2.post(runnable);
                }
            }
            this.GetContactSyncConfig = this.whenAvailable.getDefaultDisplay().getRotation();
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            PlaceComponentResult();
        } else {
            SurfaceView surfaceView = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (surfaceView != null) {
                surfaceView.getHolder().addCallback(this.FragmentBottomSheetPaymentSettingBinding);
            } else {
                TextureView textureView = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
                if (textureView != null) {
                    if (textureView.isAvailable()) {
                        new AnonymousClass1().onSurfaceTextureAvailable(this.NetworkUserEntityData$$ExternalSyntheticLambda4.getSurfaceTexture(), this.NetworkUserEntityData$$ExternalSyntheticLambda4.getWidth(), this.NetworkUserEntityData$$ExternalSyntheticLambda4.getHeight());
                    } else {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda4.setSurfaceTextureListener(new AnonymousClass1());
                    }
                }
            }
        }
        requestLayout();
        final RotationListener rotationListener = this.PrepareContext;
        Context context = getContext();
        RotationCallback rotationCallback = this.isLayoutRequested;
        OrientationEventListener orientationEventListener = rotationListener.KClassImpl$Data$declaredNonStaticMembers$2;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        rotationListener.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        rotationListener.PlaceComponentResult = null;
        rotationListener.getAuthRequestContext = null;
        Context applicationContext = context.getApplicationContext();
        rotationListener.getAuthRequestContext = rotationCallback;
        rotationListener.PlaceComponentResult = (WindowManager) applicationContext.getSystemService("window");
        OrientationEventListener orientationEventListener2 = new OrientationEventListener(applicationContext) { // from class: com.journeyapps.barcodescanner.RotationListener.1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i) {
                int rotation;
                WindowManager windowManager = rotationListener.PlaceComponentResult;
                RotationCallback rotationCallback2 = rotationListener.getAuthRequestContext;
                if (rotationListener.PlaceComponentResult == null || rotationCallback2 == null || (rotation = windowManager.getDefaultDisplay().getRotation()) == rotationListener.BuiltInFictitiousFunctionClassFactory) {
                    return;
                }
                rotationListener.BuiltInFictitiousFunctionClassFactory = rotation;
                rotationCallback2.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        };
        rotationListener.KClassImpl$Data$declaredNonStaticMembers$2 = orientationEventListener2;
        orientationEventListener2.enable();
        rotationListener.BuiltInFictitiousFunctionClassFactory = rotationListener.PlaceComponentResult.getDefaultDisplay().getRotation();
    }

    public void pause() {
        TextureView textureView;
        SurfaceView surfaceView;
        Util.KClassImpl$Data$declaredNonStaticMembers$2();
        InstrumentInjector.log_d(BuiltInFictitiousFunctionClassFactory, "pause()");
        this.GetContactSyncConfig = -1;
        CameraInstance cameraInstance = this.MyBillsEntityDataFactory;
        if (cameraInstance == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda7.sendEmptyMessage(R.id.zxing_camera_closed);
        } else {
            Util.KClassImpl$Data$declaredNonStaticMembers$2();
            if (cameraInstance.moveToNextValue) {
                CameraThread cameraThread = cameraInstance.PlaceComponentResult;
                Runnable runnable = cameraInstance.lookAheadTest;
                synchronized (cameraThread.getAuthRequestContext) {
                    cameraThread.KClassImpl$Data$declaredNonStaticMembers$2();
                    cameraThread.KClassImpl$Data$declaredNonStaticMembers$2.post(runnable);
                }
            } else {
                cameraInstance.MyBillsEntityDataFactory = true;
            }
            cameraInstance.moveToNextValue = false;
            this.MyBillsEntityDataFactory = null;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null && (surfaceView = this.NetworkUserEntityData$$ExternalSyntheticLambda6) != null) {
            surfaceView.getHolder().removeCallback(this.FragmentBottomSheetPaymentSettingBinding);
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null && (textureView = this.NetworkUserEntityData$$ExternalSyntheticLambda4) != null) {
            textureView.setSurfaceTextureListener(null);
        }
        this.PlaceComponentResult = null;
        this.DatabaseTableConfigUtil = null;
        this.initRecordTimeStamp = null;
        RotationListener rotationListener = this.PrepareContext;
        OrientationEventListener orientationEventListener = rotationListener.KClassImpl$Data$declaredNonStaticMembers$2;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        rotationListener.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        rotationListener.PlaceComponentResult = null;
        rotationListener.getAuthRequestContext = null;
        this.scheduleImpl.getAuthRequestContext();
    }

    public void pauseAndWait() {
        CameraInstance cameraInstance = getCameraInstance();
        pause();
        long nanoTime = System.nanoTime();
        while (cameraInstance != null && !cameraInstance.KClassImpl$Data$declaredNonStaticMembers$2() && System.nanoTime() - nanoTime <= 2000000000) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public Size getFramingRectSize() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public void setFramingRectSize(Size size) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = size;
    }

    public double getMarginFraction() {
        return this.getErrorConfigVersion;
    }

    public void setMarginFraction(double d) {
        if (d >= 0.5d) {
            throw new IllegalArgumentException("The margin fraction must be less than 0.5");
        }
        this.getErrorConfigVersion = d;
    }

    public boolean isUseTextureView() {
        return this.SubSequence;
    }

    public void setUseTextureView(boolean z) {
        this.SubSequence = z;
    }

    protected boolean isActive() {
        return this.MyBillsEntityDataFactory != null;
    }

    protected CameraInstance createCameraInstance() {
        CameraInstance cameraInstance = new CameraInstance(getContext());
        CameraSettings cameraSettings = this.getAuthRequestContext;
        if (!cameraInstance.moveToNextValue) {
            cameraInstance.getAuthRequestContext = cameraSettings;
            cameraInstance.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 = cameraSettings;
        }
        return cameraInstance;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(CameraSurface cameraSurface) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 || this.MyBillsEntityDataFactory == null) {
            return;
        }
        InstrumentInjector.log_i(BuiltInFictitiousFunctionClassFactory, "Starting preview");
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = cameraSurface;
        CameraInstance cameraInstance = this.MyBillsEntityDataFactory;
        Util.KClassImpl$Data$declaredNonStaticMembers$2();
        if (cameraInstance.moveToNextValue) {
            CameraThread cameraThread = cameraInstance.PlaceComponentResult;
            Runnable runnable = cameraInstance.GetContactSyncConfig;
            synchronized (cameraThread.getAuthRequestContext) {
                cameraThread.KClassImpl$Data$declaredNonStaticMembers$2();
                cameraThread.KClassImpl$Data$declaredNonStaticMembers$2.post(runnable);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
            previewStarted();
            this.scheduleImpl.BuiltInFictitiousFunctionClassFactory();
            return;
        }
        throw new IllegalStateException("CameraInstance is not open");
    }

    public CameraInstance getCameraInstance() {
        return this.MyBillsEntityDataFactory;
    }

    public boolean isPreviewActive() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    protected Rect calculateFramingRect(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            rect3.inset(Math.max(0, (rect3.width() - this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory) / 2), Math.max(0, (rect3.height() - this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2) / 2));
            return rect3;
        }
        double width = rect3.width();
        double d = this.getErrorConfigVersion;
        double height = rect3.height();
        double d2 = this.getErrorConfigVersion;
        Double.isNaN(width);
        Double.isNaN(height);
        int min = (int) Math.min(width * d, height * d2);
        rect3.inset(min, min);
        if (rect3.height() > rect3.width()) {
            rect3.inset(0, (rect3.height() - rect3.width()) / 2);
        }
        return rect3;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", onSaveInstanceState);
        bundle.putBoolean("torch", this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        setTorch(bundle.getBoolean("torch"));
    }

    public boolean isCameraClosed() {
        CameraInstance cameraInstance = this.MyBillsEntityDataFactory;
        return cameraInstance == null || cameraInstance.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    static /* synthetic */ void access$300(CameraPreview cameraPreview, Size size) {
        cameraPreview.DatabaseTableConfigUtil = size;
        Size size2 = cameraPreview.PlaceComponentResult;
        if (size2 != null) {
            if (size2 == null || size == null || cameraPreview.moveToNextValue == null) {
                cameraPreview.initRecordTimeStamp = null;
                cameraPreview.lookAheadTest = null;
                cameraPreview.NetworkUserEntityData$$ExternalSyntheticLambda3 = null;
                throw new IllegalStateException("containerSize or previewSize is not set yet");
            }
            int i = size.MyBillsEntityDataFactory;
            int i2 = cameraPreview.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2;
            int i3 = cameraPreview.PlaceComponentResult.MyBillsEntityDataFactory;
            int i4 = cameraPreview.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
            DisplayConfiguration displayConfiguration = cameraPreview.moveToNextValue;
            Rect authRequestContext = displayConfiguration.MyBillsEntityDataFactory.getAuthRequestContext(cameraPreview.DatabaseTableConfigUtil, displayConfiguration.BuiltInFictitiousFunctionClassFactory);
            if (authRequestContext.width() > 0 && authRequestContext.height() > 0) {
                cameraPreview.NetworkUserEntityData$$ExternalSyntheticLambda3 = authRequestContext;
                cameraPreview.lookAheadTest = cameraPreview.calculateFramingRect(new Rect(0, 0, i3, i4), cameraPreview.NetworkUserEntityData$$ExternalSyntheticLambda3);
                Rect rect = new Rect(cameraPreview.lookAheadTest);
                rect.offset(-cameraPreview.NetworkUserEntityData$$ExternalSyntheticLambda3.left, -cameraPreview.NetworkUserEntityData$$ExternalSyntheticLambda3.top);
                Rect rect2 = new Rect((rect.left * i) / cameraPreview.NetworkUserEntityData$$ExternalSyntheticLambda3.width(), (rect.top * i2) / cameraPreview.NetworkUserEntityData$$ExternalSyntheticLambda3.height(), (rect.right * i) / cameraPreview.NetworkUserEntityData$$ExternalSyntheticLambda3.width(), (rect.bottom * i2) / cameraPreview.NetworkUserEntityData$$ExternalSyntheticLambda3.height());
                cameraPreview.initRecordTimeStamp = rect2;
                if (rect2.width() <= 0 || cameraPreview.initRecordTimeStamp.height() <= 0) {
                    cameraPreview.initRecordTimeStamp = null;
                    cameraPreview.lookAheadTest = null;
                    InstrumentInjector.log_w(BuiltInFictitiousFunctionClassFactory, "Preview frame is too small");
                } else {
                    cameraPreview.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }
            cameraPreview.requestLayout();
            cameraPreview.PlaceComponentResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void access$600(CameraPreview cameraPreview) {
        if (!cameraPreview.isActive() || cameraPreview.whenAvailable.getDefaultDisplay().getRotation() == cameraPreview.GetContactSyncConfig) {
            return;
        }
        cameraPreview.pause();
        cameraPreview.resume();
    }
}
