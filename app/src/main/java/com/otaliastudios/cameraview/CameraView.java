package com.otaliastudios.cameraview;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.display.DisplayManager;
import android.location.Location;
import android.media.MediaActionSound;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.view.Lifecycle;
import androidx.view.LifecycleObserver;
import androidx.view.LifecycleOwner;
import androidx.view.OnLifecycleEvent;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.VideoResult;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.Control;
import com.otaliastudios.cameraview.controls.ControlParser;
import com.otaliastudios.cameraview.controls.Engine;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Grid;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.Preview;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.Camera1Engine;
import com.otaliastudios.cameraview.engine.Camera2Engine;
import com.otaliastudios.cameraview.engine.CameraEngine;
import com.otaliastudios.cameraview.engine.offset.Angles;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.filter.FilterParser;
import com.otaliastudios.cameraview.filter.NoFilter;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import com.otaliastudios.cameraview.filter.TwoParameterFilter;
import com.otaliastudios.cameraview.frame.Frame;
import com.otaliastudios.cameraview.frame.FrameProcessor;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.gesture.GestureAction;
import com.otaliastudios.cameraview.gesture.GestureFinder;
import com.otaliastudios.cameraview.gesture.GestureParser;
import com.otaliastudios.cameraview.gesture.PinchGestureFinder;
import com.otaliastudios.cameraview.gesture.ScrollGestureFinder;
import com.otaliastudios.cameraview.gesture.TapGestureFinder;
import com.otaliastudios.cameraview.internal.GridLinesLayout;
import com.otaliastudios.cameraview.internal.utils.CropHelper;
import com.otaliastudios.cameraview.internal.utils.OrientationHelper;
import com.otaliastudios.cameraview.markers.AutoFocusMarker;
import com.otaliastudios.cameraview.markers.AutoFocusTrigger;
import com.otaliastudios.cameraview.markers.MarkerLayout;
import com.otaliastudios.cameraview.markers.MarkerParser;
import com.otaliastudios.cameraview.metering.MeteringRegions;
import com.otaliastudios.cameraview.overlay.OverlayLayout;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.preview.FilterCameraPreview;
import com.otaliastudios.cameraview.preview.GlCameraPreview;
import com.otaliastudios.cameraview.preview.SurfaceCameraPreview;
import com.otaliastudios.cameraview.preview.TextureCameraPreview;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;
import com.otaliastudios.cameraview.size.SizeSelector;
import com.otaliastudios.cameraview.size.SizeSelectorParser;
import id.dana.util.permission.ManifestPermission;
import java.io.File;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class CameraView extends FrameLayout implements LifecycleObserver {
    static final long DEFAULT_AUTOFOCUS_RESET_DELAY_MILLIS = 3000;
    static final int DEFAULT_FRAME_PROCESSING_EXECUTORS = 1;
    static final int DEFAULT_FRAME_PROCESSING_POOL_SIZE = 2;
    static final boolean DEFAULT_PICTURE_METERING = true;
    static final boolean DEFAULT_PICTURE_SNAPSHOT_METERING = false;
    static final boolean DEFAULT_PLAY_SOUNDS = true;
    static final boolean DEFAULT_REQUEST_PERMISSIONS = true;
    static final boolean DEFAULT_USE_DEVICE_ORIENTATION = true;
    private static final CameraLogger KClassImpl$Data$declaredNonStaticMembers$2 = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(com.alibaba.griver.image.capture.widget.CameraView.TAG);
    public static final int PERMISSION_REQUEST_CODE = 16;
    private CameraPreview BuiltInFictitiousFunctionClassFactory;
    private boolean DatabaseTableConfigUtil;
    private OrientationHelper GetContactSyncConfig;
    private Engine MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Lifecycle NetworkUserEntityData$$ExternalSyntheticLambda1;
    private Size NetworkUserEntityData$$ExternalSyntheticLambda2;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda6;
    private MediaActionSound NetworkUserEntityData$$ExternalSyntheticLambda7;
    private Preview NetworkUserEntityData$$ExternalSyntheticLambda8;
    private AutoFocusMarker PlaceComponentResult;
    private boolean PrepareContext;
    private CameraEngine getAuthRequestContext;
    private Executor getErrorConfigVersion;
    private Filter initRecordTimeStamp;
    private Handler isLayoutRequested;
    private boolean lookAheadTest;
    CameraCallbacks mCameraCallbacks;
    List<FrameProcessor> mFrameProcessors;
    GridLinesLayout mGridLinesLayout;
    List<CameraListener> mListeners;
    MarkerLayout mMarkerLayout;
    OverlayLayout mOverlayLayout;
    PinchGestureFinder mPinchGestureFinder;
    ScrollGestureFinder mScrollGestureFinder;
    TapGestureFinder mTapGestureFinder;
    private int moveToNextValue;
    private boolean newProxyInstance;
    private HashMap<Gesture, GestureAction> scheduleImpl;

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateLayoutParams(attributeSet);
    }

    public CameraView(Context context) {
        super(context, null);
        this.scheduleImpl = new HashMap<>(4);
        this.mListeners = new CopyOnWriteArrayList();
        this.mFrameProcessors = new CopyOnWriteArrayList();
        BuiltInFictitiousFunctionClassFactory(context, (AttributeSet) null);
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scheduleImpl = new HashMap<>(4);
        this.mListeners = new CopyOnWriteArrayList();
        this.mFrameProcessors = new CopyOnWriteArrayList();
        BuiltInFictitiousFunctionClassFactory(context, attributeSet);
    }

    private void BuiltInFictitiousFunctionClassFactory(Context context, AttributeSet attributeSet) {
        boolean isInEditMode = isInEditMode();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = isInEditMode;
        if (isInEditMode) {
            return;
        }
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.BuiltInFictitiousFunctionClassFactory, 0, 0);
        ControlParser controlParser = new ControlParser(context, obtainStyledAttributes);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.AppCompatEmojiTextHelper, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.K, true);
        this.lookAheadTest = obtainStyledAttributes.getBoolean(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda1, false);
        this.newProxyInstance = obtainStyledAttributes.getBoolean(R.styleable.I, true);
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = Preview.fromValue(controlParser.scheduleImpl);
        this.MyBillsEntityDataFactory = Engine.fromValue(controlParser.KClassImpl$Data$declaredNonStaticMembers$2);
        int color = obtainStyledAttributes.getColor(R.styleable.whenAvailable, GridLinesLayout.DEFAULT_COLOR);
        long j = obtainStyledAttributes.getFloat(R.styleable.O, 0.0f);
        int integer = obtainStyledAttributes.getInteger(R.styleable.L, 0);
        int integer2 = obtainStyledAttributes.getInteger(R.styleable.M, 0);
        int integer3 = obtainStyledAttributes.getInteger(R.styleable.scheduleImpl, 0);
        float f = obtainStyledAttributes.getFloat(R.styleable.F, 0.0f);
        long integer4 = obtainStyledAttributes.getInteger(R.styleable.lookAheadTest, 3000);
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.readMicros, true);
        boolean z4 = obtainStyledAttributes.getBoolean(R.styleable.getOnBoardingScenario, false);
        int integer5 = obtainStyledAttributes.getInteger(R.styleable.J, 0);
        int integer6 = obtainStyledAttributes.getInteger(R.styleable.G, 0);
        int integer7 = obtainStyledAttributes.getInteger(R.styleable.isLayoutRequested, 0);
        int integer8 = obtainStyledAttributes.getInteger(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda8, 0);
        int integer9 = obtainStyledAttributes.getInteger(R.styleable.newProxyInstance, 0);
        int integer10 = obtainStyledAttributes.getInteger(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda7, 2);
        int integer11 = obtainStyledAttributes.getInteger(R.styleable.DatabaseTableConfigUtil, 1);
        SizeSelectorParser sizeSelectorParser = new SizeSelectorParser(obtainStyledAttributes);
        GestureParser gestureParser = new GestureParser(obtainStyledAttributes);
        MarkerParser markerParser = new MarkerParser(obtainStyledAttributes);
        FilterParser filterParser = new FilterParser(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        this.mCameraCallbacks = new CameraCallbacks();
        this.isLayoutRequested = new Handler(Looper.getMainLooper());
        this.mPinchGestureFinder = new PinchGestureFinder(this.mCameraCallbacks);
        this.mTapGestureFinder = new TapGestureFinder(this.mCameraCallbacks);
        this.mScrollGestureFinder = new ScrollGestureFinder(this.mCameraCallbacks);
        this.mGridLinesLayout = new GridLinesLayout(context);
        this.mOverlayLayout = new OverlayLayout(context);
        this.mMarkerLayout = new MarkerLayout(context);
        addView(this.mGridLinesLayout);
        addView(this.mMarkerLayout);
        addView(this.mOverlayLayout);
        getAuthRequestContext();
        setPlaySounds(z);
        setUseDeviceOrientation(z2);
        setGrid(Grid.fromValue(controlParser.PlaceComponentResult));
        setGridColor(color);
        setFacing(Facing.fromValue(controlParser.getAuthRequestContext));
        setFlash(Flash.fromValue(controlParser.BuiltInFictitiousFunctionClassFactory));
        setMode(Mode.fromValue(controlParser.lookAheadTest));
        setWhiteBalance(WhiteBalance.fromValue(controlParser.NetworkUserEntityData$$ExternalSyntheticLambda1));
        setHdr(Hdr.fromValue(controlParser.NetworkUserEntityData$$ExternalSyntheticLambda0));
        setAudio(Audio.fromValue(controlParser.MyBillsEntityDataFactory));
        setAudioBitRate(integer3);
        setPictureSize(sizeSelectorParser.MyBillsEntityDataFactory);
        setPictureMetering(z3);
        setPictureSnapshotMetering(z4);
        setPictureFormat(PictureFormat.fromValue(controlParser.moveToNextValue));
        setVideoSize(sizeSelectorParser.PlaceComponentResult);
        setVideoCodec(VideoCodec.fromValue(controlParser.getErrorConfigVersion));
        setVideoMaxSize(j);
        setVideoMaxDuration(integer);
        setVideoBitRate(integer2);
        setAutoFocusResetDelay(integer4);
        setPreviewFrameRate(f);
        setSnapshotMaxWidth(integer5);
        setSnapshotMaxHeight(integer6);
        setFrameProcessingMaxWidth(integer7);
        setFrameProcessingMaxHeight(integer8);
        setFrameProcessingFormat(integer9);
        setFrameProcessingPoolSize(integer10);
        setFrameProcessingExecutors(integer11);
        mapGesture(Gesture.TAP, GestureParser.PlaceComponentResult(gestureParser.PlaceComponentResult));
        mapGesture(Gesture.LONG_TAP, GestureParser.PlaceComponentResult(gestureParser.KClassImpl$Data$declaredNonStaticMembers$2));
        mapGesture(Gesture.PINCH, GestureParser.PlaceComponentResult(gestureParser.MyBillsEntityDataFactory));
        mapGesture(Gesture.SCROLL_HORIZONTAL, GestureParser.PlaceComponentResult(gestureParser.BuiltInFictitiousFunctionClassFactory));
        mapGesture(Gesture.SCROLL_VERTICAL, GestureParser.PlaceComponentResult(gestureParser.getAuthRequestContext));
        setAutoFocusMarker(markerParser.MyBillsEntityDataFactory);
        setFilter(filterParser.getAuthRequestContext);
        this.GetContactSyncConfig = new OrientationHelper(context, this.mCameraCallbacks);
    }

    private void getAuthRequestContext() {
        CameraLogger cameraLogger = KClassImpl$Data$declaredNonStaticMembers$2;
        cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(2, "doInstantiateEngine:", "instantiating. engine:", this.MyBillsEntityDataFactory);
        CameraEngine instantiateCameraEngine = instantiateCameraEngine(this.MyBillsEntityDataFactory, this.mCameraCallbacks);
        this.getAuthRequestContext = instantiateCameraEngine;
        cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(2, "doInstantiateEngine:", "instantiated. engine:", instantiateCameraEngine.getClass().getSimpleName());
        this.getAuthRequestContext.getAuthRequestContext(this.mOverlayLayout);
    }

    void doInstantiatePreview() {
        CameraLogger cameraLogger = KClassImpl$Data$declaredNonStaticMembers$2;
        cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(2, "doInstantiateEngine:", "instantiating. preview:", this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        CameraPreview instantiatePreview = instantiatePreview(this.NetworkUserEntityData$$ExternalSyntheticLambda8, getContext(), this);
        this.BuiltInFictitiousFunctionClassFactory = instantiatePreview;
        cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(2, "doInstantiateEngine:", "instantiated. preview:", instantiatePreview.getClass().getSimpleName());
        this.getAuthRequestContext.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory);
        Filter filter = this.initRecordTimeStamp;
        if (filter != null) {
            setFilter(filter);
            this.initRecordTimeStamp = null;
        }
    }

    protected CameraEngine instantiateCameraEngine(Engine engine, CameraEngine.Callback callback) {
        if (this.lookAheadTest && engine == Engine.CAMERA2 && Build.VERSION.SDK_INT >= 21) {
            return new Camera2Engine(callback);
        }
        this.MyBillsEntityDataFactory = Engine.CAMERA1;
        return new Camera1Engine(callback);
    }

    protected CameraPreview instantiatePreview(Preview preview, Context context, ViewGroup viewGroup) {
        int i = AnonymousClass7.MyBillsEntityDataFactory[preview.ordinal()];
        if (i == 1) {
            return new SurfaceCameraPreview(context, viewGroup);
        }
        if (i == 2 && isHardwareAccelerated()) {
            return new TextureCameraPreview(context, viewGroup);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = Preview.GL_SURFACE;
        return new GlCameraPreview(context, viewGroup);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return;
        }
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            doInstantiatePreview();
        }
        this.GetContactSyncConfig.MyBillsEntityDataFactory();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            OrientationHelper orientationHelper = this.GetContactSyncConfig;
            orientationHelper.PlaceComponentResult.disable();
            if (Build.VERSION.SDK_INT >= 17) {
                ((DisplayManager) orientationHelper.BuiltInFictitiousFunctionClassFactory.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)).unregisterDisplayListener(orientationHelper.getAuthRequestContext);
            }
            orientationHelper.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            orientationHelper.MyBillsEntityDataFactory = -1;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824));
            return;
        }
        Size BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(Reference.VIEW);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = BuiltInFictitiousFunctionClassFactory;
        if (BuiltInFictitiousFunctionClassFactory != null) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            float f = this.NetworkUserEntityData$$ExternalSyntheticLambda2.BuiltInFictitiousFunctionClassFactory;
            float f2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext;
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (this.BuiltInFictitiousFunctionClassFactory.scheduleImpl()) {
                if (mode == Integer.MIN_VALUE && layoutParams.width == -1) {
                    mode = 1073741824;
                }
                if (mode2 == Integer.MIN_VALUE && layoutParams.height == -1) {
                    mode2 = 1073741824;
                }
            } else {
                if (mode == 1073741824) {
                    mode = Integer.MIN_VALUE;
                }
                if (mode2 == 1073741824) {
                    mode2 = Integer.MIN_VALUE;
                }
            }
            CameraLogger cameraLogger = KClassImpl$Data$declaredNonStaticMembers$2;
            Object[] objArr = new Object[2];
            objArr[0] = "onMeasure:";
            StringBuilder sb = new StringBuilder();
            sb.append("requested dimensions are (");
            sb.append(size);
            sb.append("[");
            sb.append(mode != Integer.MIN_VALUE ? mode != 0 ? mode != 1073741824 ? null : "EXACTLY" : "UNSPECIFIED" : "AT_MOST");
            sb.append("]x");
            sb.append(size2);
            sb.append("[");
            sb.append(mode2 != Integer.MIN_VALUE ? mode2 != 0 ? mode2 != 1073741824 ? null : "EXACTLY" : "UNSPECIFIED" : "AT_MOST");
            sb.append("])");
            objArr[1] = sb.toString();
            cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, objArr);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("(");
            sb2.append(f);
            sb2.append("x");
            sb2.append(f2);
            sb2.append(")");
            cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "onMeasure:", "previewSize is", sb2.toString());
            if (mode == 1073741824 && mode2 == 1073741824) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("(");
                sb3.append(size);
                sb3.append("x");
                sb3.append(size2);
                sb3.append(")");
                cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "onMeasure:", "both are MATCH_PARENT or fixed value. We adapt.", "This means CROP_CENTER.", sb3.toString());
                super.onMeasure(i, i2);
                return;
            } else if (mode == 0 && mode2 == 0) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("(");
                sb4.append(f);
                sb4.append("x");
                sb4.append(f2);
                sb4.append(")");
                cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "onMeasure:", "both are completely free.", "We respect that and extend to the whole preview size.", sb4.toString());
                super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) f, 1073741824), View.MeasureSpec.makeMeasureSpec((int) f2, 1073741824));
                return;
            } else {
                float f3 = f2 / f;
                if (mode == 0 || mode2 == 0) {
                    if (mode == 0) {
                        size = Math.round(size2 / f3);
                    } else {
                        size2 = Math.round(size * f3);
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("(");
                    sb5.append(size);
                    sb5.append("x");
                    sb5.append(size2);
                    sb5.append(")");
                    cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "onMeasure:", "one dimension was free, we adapted it to fit the ratio.", sb5.toString());
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
                    return;
                } else if (mode == 1073741824 || mode2 == 1073741824) {
                    if (mode == Integer.MIN_VALUE) {
                        size = Math.min(Math.round(size2 / f3), size);
                    } else {
                        size2 = Math.min(Math.round(size * f3), size2);
                    }
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("(");
                    sb6.append(size);
                    sb6.append("x");
                    sb6.append(size2);
                    sb6.append(")");
                    cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "onMeasure:", "one dimension was EXACTLY, another AT_MOST.", "We have TRIED to fit the aspect ratio, but it's not guaranteed.", sb6.toString());
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
                    return;
                } else {
                    float f4 = size2;
                    float f5 = size;
                    if (f4 / f5 >= f3) {
                        size2 = Math.round(f5 * f3);
                    } else {
                        size = Math.round(f4 / f3);
                    }
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("(");
                    sb7.append(size);
                    sb7.append("x");
                    sb7.append(size2);
                    sb7.append(")");
                    cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "onMeasure:", "both dimension were AT_MOST.", "We fit the preview aspect ratio.", sb7.toString());
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
                    return;
                }
            }
        }
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(2, "onMeasure:", "surface is not ready. Calling default behavior.");
        super.onMeasure(i, i2);
    }

    public boolean mapGesture(Gesture gesture, GestureAction gestureAction) {
        GestureAction gestureAction2 = GestureAction.NONE;
        if (gesture.isAssignableTo(gestureAction)) {
            this.scheduleImpl.put(gesture, gestureAction);
            int i = AnonymousClass7.KClassImpl$Data$declaredNonStaticMembers$2[gesture.ordinal()];
            if (i == 1) {
                this.mPinchGestureFinder.BuiltInFictitiousFunctionClassFactory = this.scheduleImpl.get(Gesture.PINCH) != gestureAction2;
            } else if (i == 2 || i == 3) {
                this.mTapGestureFinder.BuiltInFictitiousFunctionClassFactory = (this.scheduleImpl.get(Gesture.TAP) == gestureAction2 && this.scheduleImpl.get(Gesture.LONG_TAP) == gestureAction2) ? false : true;
            } else if (i == 4 || i == 5) {
                this.mScrollGestureFinder.BuiltInFictitiousFunctionClassFactory = (this.scheduleImpl.get(Gesture.SCROLL_HORIZONTAL) == gestureAction2 && this.scheduleImpl.get(Gesture.SCROLL_VERTICAL) == gestureAction2) ? false : true;
            }
            return true;
        }
        mapGesture(gesture, gestureAction2);
        return false;
    }

    public void clearGesture(Gesture gesture) {
        mapGesture(gesture, GestureAction.NONE);
    }

    public GestureAction getGestureAction(Gesture gesture) {
        return this.scheduleImpl.get(gesture);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isOpened()) {
            CameraOptions NetworkUserEntityData$$ExternalSyntheticLambda4 = this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda4();
            if (NetworkUserEntityData$$ExternalSyntheticLambda4 == null) {
                throw new IllegalStateException("Options should not be null here.");
            }
            if (!this.mPinchGestureFinder.BuiltInFictitiousFunctionClassFactory(motionEvent)) {
                if (!this.mScrollGestureFinder.BuiltInFictitiousFunctionClassFactory(motionEvent)) {
                    if (this.mTapGestureFinder.BuiltInFictitiousFunctionClassFactory(motionEvent)) {
                        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "onTouchEvent", "tap!");
                        KClassImpl$Data$declaredNonStaticMembers$2(this.mTapGestureFinder, NetworkUserEntityData$$ExternalSyntheticLambda4);
                    }
                } else {
                    KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "onTouchEvent", "scroll!");
                    KClassImpl$Data$declaredNonStaticMembers$2(this.mScrollGestureFinder, NetworkUserEntityData$$ExternalSyntheticLambda4);
                }
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "onTouchEvent", "pinch!");
                KClassImpl$Data$declaredNonStaticMembers$2(this.mPinchGestureFinder, NetworkUserEntityData$$ExternalSyntheticLambda4);
            }
            return true;
        }
        return true;
    }

    public boolean isOpened() {
        return this.getAuthRequestContext.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory.isAtLeast(CameraState.ENGINE) && this.getAuthRequestContext.getValueOfTouchPositionAbsolute.getErrorConfigVersion.isAtLeast(CameraState.ENGINE);
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory == CameraState.OFF && !this.getAuthRequestContext.R();
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (lifecycle != null) {
            lifecycle.KClassImpl$Data$declaredNonStaticMembers$2(this);
        }
        Lifecycle lifecycle2 = lifecycleOwner.getLifecycle();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = lifecycle2;
        lifecycle2.BuiltInFictitiousFunctionClassFactory(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void open() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return;
        }
        CameraPreview cameraPreview = this.BuiltInFictitiousFunctionClassFactory;
        if (cameraPreview != null) {
            cameraPreview.NetworkUserEntityData$$ExternalSyntheticLambda0();
        }
        if (checkPermissions(getAudio())) {
            this.GetContactSyncConfig.MyBillsEntityDataFactory();
            Angles PrepareContext = this.getAuthRequestContext.PrepareContext();
            int i = this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2;
            Angles.getAuthRequestContext(i);
            PrepareContext.getAuthRequestContext = i;
            PrepareContext.PlaceComponentResult();
            this.getAuthRequestContext.U();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void close() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return;
        }
        this.getAuthRequestContext.lookAheadTest(false);
        CameraPreview cameraPreview = this.BuiltInFictitiousFunctionClassFactory;
        if (cameraPreview != null) {
            cameraPreview.lookAheadTest();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void destroy() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return;
        }
        clearCameraListeners();
        clearFrameProcessors();
        this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0(true);
        CameraPreview cameraPreview = this.BuiltInFictitiousFunctionClassFactory;
        if (cameraPreview != null) {
            cameraPreview.moveToNextValue();
        }
    }

    public void setExperimental(boolean z) {
        this.lookAheadTest = z;
    }

    public void set(Control control) {
        if (control instanceof Audio) {
            setAudio((Audio) control);
        } else if (control instanceof Facing) {
            setFacing((Facing) control);
        } else if (control instanceof Flash) {
            setFlash((Flash) control);
        } else if (control instanceof Grid) {
            setGrid((Grid) control);
        } else if (control instanceof Hdr) {
            setHdr((Hdr) control);
        } else if (control instanceof Mode) {
            setMode((Mode) control);
        } else if (control instanceof WhiteBalance) {
            setWhiteBalance((WhiteBalance) control);
        } else if (control instanceof VideoCodec) {
            setVideoCodec((VideoCodec) control);
        } else if (control instanceof Preview) {
            setPreview((Preview) control);
        } else if (control instanceof Engine) {
            setEngine((Engine) control);
        } else if (control instanceof PictureFormat) {
            setPictureFormat((PictureFormat) control);
        }
    }

    public <T extends Control> T get(Class<T> cls) {
        if (cls == Audio.class) {
            return getAudio();
        }
        if (cls == Facing.class) {
            return getFacing();
        }
        if (cls == Flash.class) {
            return getFlash();
        }
        if (cls == Grid.class) {
            return getGrid();
        }
        if (cls == Hdr.class) {
            return getHdr();
        }
        if (cls == Mode.class) {
            return getMode();
        }
        if (cls == WhiteBalance.class) {
            return getWhiteBalance();
        }
        if (cls == VideoCodec.class) {
            return getVideoCodec();
        }
        if (cls == Preview.class) {
            return getPreview();
        }
        if (cls == Engine.class) {
            return getEngine();
        }
        if (cls == PictureFormat.class) {
            return getPictureFormat();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown control class: ");
        sb.append(cls);
        throw new IllegalArgumentException(sb.toString());
    }

    public void setPreview(Preview preview) {
        CameraPreview cameraPreview;
        if (preview != this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = preview;
            if ((getWindowToken() != null) || (cameraPreview = this.BuiltInFictitiousFunctionClassFactory) == null) {
                return;
            }
            cameraPreview.moveToNextValue();
            this.BuiltInFictitiousFunctionClassFactory = null;
        }
    }

    public Preview getPreview() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    public void setEngine(Engine engine) {
        if (BuiltInFictitiousFunctionClassFactory()) {
            this.MyBillsEntityDataFactory = engine;
            CameraEngine cameraEngine = this.getAuthRequestContext;
            getAuthRequestContext();
            CameraPreview cameraPreview = this.BuiltInFictitiousFunctionClassFactory;
            if (cameraPreview != null) {
                this.getAuthRequestContext.getAuthRequestContext(cameraPreview);
            }
            setFacing(cameraEngine.readMicros());
            setFlash(cameraEngine.whenAvailable());
            setMode(cameraEngine.VerifyPinStateManager$executeRiskChallenge$2$1());
            setWhiteBalance(cameraEngine.M());
            setHdr(cameraEngine.BottomSheetCardBindingView$watcherCardNumberView$1());
            setAudio(cameraEngine.NetworkUserEntityData$$ExternalSyntheticLambda3());
            setAudioBitRate(cameraEngine.FragmentBottomSheetPaymentSettingBinding());
            setPictureSize(cameraEngine.VerifyPinStateManager$executeRiskChallenge$2$2());
            setPictureFormat(cameraEngine.E());
            setVideoSize(cameraEngine.getNameOrBuilderList());
            setVideoCodec(cameraEngine.AppCompatEmojiTextHelper());
            setVideoMaxSize(cameraEngine.K());
            setVideoMaxDuration(cameraEngine.J());
            setVideoBitRate(cameraEngine.G());
            setAutoFocusResetDelay(cameraEngine.NetworkUserEntityData$$ExternalSyntheticLambda5());
            setPreviewFrameRate(cameraEngine.F());
            setSnapshotMaxWidth(cameraEngine.I());
            setSnapshotMaxHeight(cameraEngine.H());
            setFrameProcessingMaxWidth(cameraEngine.getCallingPid());
            setFrameProcessingMaxHeight(cameraEngine.SubSequence());
            setFrameProcessingFormat(0);
            setFrameProcessingPoolSize(cameraEngine.C());
            this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(!this.mFrameProcessors.isEmpty());
        }
    }

    public Engine getEngine() {
        return this.MyBillsEntityDataFactory;
    }

    public CameraOptions getCameraOptions() {
        return this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda4();
    }

    public void setExposureCorrection(float f) {
        CameraOptions cameraOptions = getCameraOptions();
        if (cameraOptions != null) {
            float authRequestContext = cameraOptions.getAuthRequestContext();
            float KClassImpl$Data$declaredNonStaticMembers$22 = cameraOptions.KClassImpl$Data$declaredNonStaticMembers$2();
            if (f < authRequestContext) {
                f = authRequestContext;
            }
            if (f > KClassImpl$Data$declaredNonStaticMembers$22) {
                f = KClassImpl$Data$declaredNonStaticMembers$22;
            }
            this.getAuthRequestContext.getAuthRequestContext(f, new float[]{authRequestContext, KClassImpl$Data$declaredNonStaticMembers$22}, null, false);
        }
    }

    public float getExposureCorrection() {
        return this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda6();
    }

    public void setZoom(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.getAuthRequestContext.PlaceComponentResult(f, (PointF[]) null, false);
    }

    public float getZoom() {
        return this.getAuthRequestContext.L();
    }

    public void setGrid(Grid grid) {
        this.mGridLinesLayout.setGridMode(grid);
    }

    public Grid getGrid() {
        return this.mGridLinesLayout.getGridMode();
    }

    public void setGridColor(int i) {
        this.mGridLinesLayout.setGridColor(i);
    }

    public int getGridColor() {
        return this.mGridLinesLayout.getGridColor();
    }

    public void setHdr(Hdr hdr) {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(hdr);
    }

    public Hdr getHdr() {
        return this.getAuthRequestContext.BottomSheetCardBindingView$watcherCardNumberView$1();
    }

    public void setLocation(double d, double d2) {
        Location location = new Location("Unknown");
        location.setTime(System.currentTimeMillis());
        location.setAltitude(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        location.setLatitude(d);
        location.setLongitude(d2);
        this.getAuthRequestContext.getAuthRequestContext(location);
    }

    public void setLocation(Location location) {
        this.getAuthRequestContext.getAuthRequestContext(location);
    }

    public Location getLocation() {
        return this.getAuthRequestContext.A();
    }

    public void setWhiteBalance(WhiteBalance whiteBalance) {
        this.getAuthRequestContext.PlaceComponentResult(whiteBalance);
    }

    public WhiteBalance getWhiteBalance() {
        return this.getAuthRequestContext.M();
    }

    public void setFacing(Facing facing) {
        this.getAuthRequestContext.MyBillsEntityDataFactory(facing);
    }

    public Facing getFacing() {
        return this.getAuthRequestContext.readMicros();
    }

    /* renamed from: com.otaliastudios.cameraview.CameraView$7 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;
        static final /* synthetic */ int[] MyBillsEntityDataFactory;
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[Facing.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[Facing.BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[Facing.FRONT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[GestureAction.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr2;
            try {
                iArr2[GestureAction.TAKE_PICTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[GestureAction.AUTO_FOCUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[GestureAction.ZOOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[GestureAction.EXPOSURE_CORRECTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[GestureAction.FILTER_CONTROL_1.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[GestureAction.FILTER_CONTROL_2.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[Gesture.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr3;
            try {
                iArr3[Gesture.PINCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Gesture.TAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Gesture.LONG_TAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Gesture.SCROLL_HORIZONTAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Gesture.SCROLL_VERTICAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            int[] iArr4 = new int[Preview.values().length];
            MyBillsEntityDataFactory = iArr4;
            try {
                iArr4[Preview.SURFACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                MyBillsEntityDataFactory[Preview.TEXTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                MyBillsEntityDataFactory[Preview.GL_SURFACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public Facing toggleFacing() {
        int i = AnonymousClass7.PlaceComponentResult[this.getAuthRequestContext.readMicros().ordinal()];
        if (i == 1) {
            setFacing(Facing.FRONT);
        } else if (i == 2) {
            setFacing(Facing.BACK);
        }
        return this.getAuthRequestContext.readMicros();
    }

    public void setFlash(Flash flash) {
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(flash);
    }

    public Flash getFlash() {
        return this.getAuthRequestContext.whenAvailable();
    }

    public void setAudio(Audio audio) {
        if (audio == getAudio() || BuiltInFictitiousFunctionClassFactory() || checkPermissions(audio)) {
            this.getAuthRequestContext.PlaceComponentResult(audio);
        } else {
            close();
        }
    }

    public Audio getAudio() {
        return this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda3();
    }

    public void setAutoFocusMarker(AutoFocusMarker autoFocusMarker) {
        this.PlaceComponentResult = autoFocusMarker;
        this.mMarkerLayout.onMarker(1, autoFocusMarker);
    }

    public void setAutoFocusResetDelay(long j) {
        this.getAuthRequestContext.getAuthRequestContext(j);
    }

    public long getAutoFocusResetDelay() {
        return this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda5();
    }

    public void startAutoFocus(float f, float f2) {
        if (f < 0.0f || f > getWidth()) {
            throw new IllegalArgumentException("x should be >= 0 and <= getWidth()");
        }
        if (f2 < 0.0f || f2 > getHeight()) {
            throw new IllegalArgumentException("y should be >= 0 and <= getHeight()");
        }
        Size size = new Size(getWidth(), getHeight());
        PointF pointF = new PointF(f, f2);
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(null, MeteringRegions.MyBillsEntityDataFactory(size, pointF), pointF);
    }

    public void startAutoFocus(RectF rectF) {
        MeteringRegions MyBillsEntityDataFactory;
        if (new RectF(0.0f, 0.0f, getWidth(), getHeight()).contains(rectF)) {
            MyBillsEntityDataFactory = MeteringRegions.MyBillsEntityDataFactory(new Size(getWidth(), getHeight()), rectF, false);
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(null, MyBillsEntityDataFactory, new PointF(rectF.centerX(), rectF.centerY()));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Region is out of view bounds! ");
        sb.append(rectF);
        throw new IllegalArgumentException(sb.toString());
    }

    public void setPreviewStreamSize(SizeSelector sizeSelector) {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(sizeSelector);
    }

    public void setMode(Mode mode) {
        this.getAuthRequestContext.getAuthRequestContext(mode);
    }

    public Mode getMode() {
        return this.getAuthRequestContext.VerifyPinStateManager$executeRiskChallenge$2$1();
    }

    public void setPictureSize(SizeSelector sizeSelector) {
        this.getAuthRequestContext.MyBillsEntityDataFactory(sizeSelector);
    }

    public void setPictureMetering(boolean z) {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(z);
    }

    public boolean getPictureMetering() {
        return this.getAuthRequestContext.D();
    }

    public void setPictureSnapshotMetering(boolean z) {
        this.getAuthRequestContext.getAuthRequestContext(z);
    }

    public boolean getPictureSnapshotMetering() {
        return this.getAuthRequestContext.getValueOfTouchPositionAbsolute();
    }

    public void setPictureFormat(PictureFormat pictureFormat) {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(pictureFormat);
    }

    public PictureFormat getPictureFormat() {
        return this.getAuthRequestContext.E();
    }

    public void setVideoSize(SizeSelector sizeSelector) {
        this.getAuthRequestContext.PlaceComponentResult(sizeSelector);
    }

    public void setVideoBitRate(int i) {
        this.getAuthRequestContext.lookAheadTest(i);
    }

    public int getVideoBitRate() {
        return this.getAuthRequestContext.G();
    }

    public void setPreviewFrameRate(float f) {
        this.getAuthRequestContext.PlaceComponentResult(f);
    }

    public float getPreviewFrameRate() {
        return this.getAuthRequestContext.F();
    }

    public void setAudioBitRate(int i) {
        this.getAuthRequestContext.PlaceComponentResult(i);
    }

    public int getAudioBitRate() {
        return this.getAuthRequestContext.FragmentBottomSheetPaymentSettingBinding();
    }

    public void addCameraListener(CameraListener cameraListener) {
        this.mListeners.add(cameraListener);
    }

    public void removeCameraListener(CameraListener cameraListener) {
        this.mListeners.remove(cameraListener);
    }

    public void clearCameraListeners() {
        this.mListeners.clear();
    }

    public void takePicture() {
        this.getAuthRequestContext.PlaceComponentResult(new PictureResult.Stub());
    }

    public void takePictureSnapshot() {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new PictureResult.Stub());
    }

    public void takeVideo(File file) {
        BuiltInFictitiousFunctionClassFactory(file, (FileDescriptor) null);
    }

    public void takeVideo(FileDescriptor fileDescriptor) {
        BuiltInFictitiousFunctionClassFactory((File) null, fileDescriptor);
    }

    private void BuiltInFictitiousFunctionClassFactory(File file, FileDescriptor fileDescriptor) {
        VideoResult.Stub stub = new VideoResult.Stub();
        if (file != null) {
            this.getAuthRequestContext.PlaceComponentResult(stub, file, (FileDescriptor) null);
        } else if (fileDescriptor != null) {
            this.getAuthRequestContext.PlaceComponentResult(stub, (File) null, fileDescriptor);
        } else {
            throw new IllegalStateException("file and fileDescriptor are both null.");
        }
        this.isLayoutRequested.post(new Runnable() { // from class: com.otaliastudios.cameraview.CameraView.1
            {
                CameraView.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraView cameraView = CameraView.this;
                cameraView.DatabaseTableConfigUtil = cameraView.getKeepScreenOn();
                if (CameraView.this.DatabaseTableConfigUtil) {
                    return;
                }
                CameraView.this.setKeepScreenOn(true);
            }
        });
    }

    public void takeVideoSnapshot(File file) {
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(new VideoResult.Stub(), file);
        this.isLayoutRequested.post(new Runnable() { // from class: com.otaliastudios.cameraview.CameraView.2
            {
                CameraView.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraView cameraView = CameraView.this;
                cameraView.DatabaseTableConfigUtil = cameraView.getKeepScreenOn();
                if (CameraView.this.DatabaseTableConfigUtil) {
                    return;
                }
                CameraView.this.setKeepScreenOn(true);
            }
        });
    }

    /* renamed from: com.otaliastudios.cameraview.CameraView$3 */
    /* loaded from: classes2.dex */
    class AnonymousClass3 extends CameraListener {
        final /* synthetic */ int MyBillsEntityDataFactory;

        AnonymousClass3(int i) {
            CameraView.this = r1;
            this.MyBillsEntityDataFactory = i;
        }

        @Override // com.otaliastudios.cameraview.CameraListener
        public void onVideoTaken(VideoResult videoResult) {
            CameraView.this.setVideoMaxDuration(this.MyBillsEntityDataFactory);
            CameraView.this.removeCameraListener(this);
        }

        @Override // com.otaliastudios.cameraview.CameraListener
        public void onCameraError(CameraException cameraException) {
            super.onCameraError(cameraException);
            if (cameraException.getReason() == 5) {
                CameraView.this.setVideoMaxDuration(this.MyBillsEntityDataFactory);
                CameraView.this.removeCameraListener(this);
            }
        }
    }

    public void takeVideoSnapshot(File file, int i) {
        final int videoMaxDuration = getVideoMaxDuration();
        addCameraListener(new CameraListener() { // from class: com.otaliastudios.cameraview.CameraView.4
            {
                CameraView.this = this;
            }

            @Override // com.otaliastudios.cameraview.CameraListener
            public void onVideoTaken(VideoResult videoResult) {
                CameraView.this.setVideoMaxDuration(videoMaxDuration);
                CameraView.this.removeCameraListener(this);
            }

            @Override // com.otaliastudios.cameraview.CameraListener
            public void onCameraError(CameraException cameraException) {
                super.onCameraError(cameraException);
                if (cameraException.getReason() == 5) {
                    CameraView.this.setVideoMaxDuration(videoMaxDuration);
                    CameraView.this.removeCameraListener(this);
                }
            }
        });
        setVideoMaxDuration(i);
        takeVideoSnapshot(file);
    }

    public void stopVideo() {
        this.getAuthRequestContext.isAuth();
        this.isLayoutRequested.post(new Runnable() { // from class: com.otaliastudios.cameraview.CameraView.5
            {
                CameraView.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (CameraView.this.getKeepScreenOn() != CameraView.this.DatabaseTableConfigUtil) {
                    CameraView cameraView = CameraView.this;
                    cameraView.setKeepScreenOn(cameraView.DatabaseTableConfigUtil);
                }
            }
        });
    }

    public void setSnapshotMaxWidth(int i) {
        this.getAuthRequestContext.getErrorConfigVersion(i);
    }

    public void setSnapshotMaxHeight(int i) {
        this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0(i);
    }

    public int getSnapshotMaxWidth() {
        return this.getAuthRequestContext.I();
    }

    public int getSnapshotMaxHeight() {
        return this.getAuthRequestContext.H();
    }

    public Size getSnapshotSize() {
        Size size = null;
        if (getWidth() != 0 && getHeight() != 0) {
            Size authRequestContext = this.getAuthRequestContext.getAuthRequestContext(Reference.VIEW);
            if (authRequestContext == null) {
                return null;
            }
            Rect BuiltInFictitiousFunctionClassFactory = CropHelper.BuiltInFictitiousFunctionClassFactory(authRequestContext, AspectRatio.BuiltInFictitiousFunctionClassFactory(getWidth(), getHeight()));
            size = new Size(BuiltInFictitiousFunctionClassFactory.width(), BuiltInFictitiousFunctionClassFactory.height());
            if (this.getAuthRequestContext.PrepareContext().PlaceComponentResult(Reference.VIEW, Reference.OUTPUT)) {
                return new Size(size.getAuthRequestContext, size.BuiltInFictitiousFunctionClassFactory);
            }
        }
        return size;
    }

    public Size getPictureSize() {
        return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(Reference.OUTPUT);
    }

    public Size getVideoSize() {
        return this.getAuthRequestContext.PlaceComponentResult(Reference.OUTPUT);
    }

    public void setPlaySounds(boolean z) {
        this.PrepareContext = z && Build.VERSION.SDK_INT >= 16;
        this.getAuthRequestContext.MyBillsEntityDataFactory(z);
    }

    public boolean getPlaySounds() {
        return this.PrepareContext;
    }

    public void setUseDeviceOrientation(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = z;
    }

    public boolean getUseDeviceOrientation() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda6;
    }

    public void setVideoCodec(VideoCodec videoCodec) {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(videoCodec);
    }

    public VideoCodec getVideoCodec() {
        return this.getAuthRequestContext.AppCompatEmojiTextHelper();
    }

    public void setVideoMaxSize(long j) {
        this.getAuthRequestContext.PlaceComponentResult(j);
    }

    public long getVideoMaxSize() {
        return this.getAuthRequestContext.K();
    }

    public void setVideoMaxDuration(int i) {
        this.getAuthRequestContext.initRecordTimeStamp(i);
    }

    public int getVideoMaxDuration() {
        return this.getAuthRequestContext.J();
    }

    public boolean isTakingVideo() {
        return this.getAuthRequestContext.SummaryVoucherView$$ExternalSyntheticLambda0();
    }

    public boolean isTakingPicture() {
        return this.getAuthRequestContext.P();
    }

    /* loaded from: classes2.dex */
    public class CameraCallbacks implements CameraEngine.Callback, OrientationHelper.Callback, GestureFinder.Controller {
        private final CameraLogger KClassImpl$Data$declaredNonStaticMembers$2;
        private final String MyBillsEntityDataFactory;

        CameraCallbacks() {
            CameraView.this = r1;
            String simpleName = CameraCallbacks.class.getSimpleName();
            this.MyBillsEntityDataFactory = simpleName;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(simpleName);
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback, com.otaliastudios.cameraview.gesture.GestureFinder.Controller
        public final Context MyBillsEntityDataFactory() {
            return CameraView.this.getContext();
        }

        @Override // com.otaliastudios.cameraview.gesture.GestureFinder.Controller
        public final int getErrorConfigVersion() {
            return CameraView.this.getWidth();
        }

        @Override // com.otaliastudios.cameraview.gesture.GestureFinder.Controller
        public final int getAuthRequestContext() {
            return CameraView.this.getHeight();
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public final void MyBillsEntityDataFactory(final CameraOptions cameraOptions) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "dispatchOnCameraOpened", cameraOptions);
            CameraView.this.isLayoutRequested.post(new Runnable() { // from class: com.otaliastudios.cameraview.CameraView.CameraCallbacks.1
                {
                    CameraCallbacks.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Iterator<CameraListener> it = CameraView.this.mListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onCameraOpened(cameraOptions);
                    }
                }
            });
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "dispatchOnCameraClosed");
            CameraView.this.isLayoutRequested.post(new Runnable() { // from class: com.otaliastudios.cameraview.CameraView.CameraCallbacks.2
                {
                    CameraCallbacks.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Iterator<CameraListener> it = CameraView.this.mListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onCameraClosed();
                    }
                }
            });
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public final void lookAheadTest() {
            Size BuiltInFictitiousFunctionClassFactory = CameraView.this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(Reference.VIEW);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                if (BuiltInFictitiousFunctionClassFactory.equals(CameraView.this.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "onCameraPreviewStreamSizeChanged:", "swallowing because the preview size has not changed.", BuiltInFictitiousFunctionClassFactory);
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "onCameraPreviewStreamSizeChanged: posting a requestLayout call.", "Preview stream size:", BuiltInFictitiousFunctionClassFactory);
                CameraView.this.isLayoutRequested.post(new Runnable() { // from class: com.otaliastudios.cameraview.CameraView.CameraCallbacks.3
                    {
                        CameraCallbacks.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        CameraView.this.requestLayout();
                    }
                });
                return;
            }
            throw new RuntimeException("Preview stream size should not be null here.");
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public final void getAuthRequestContext(boolean z) {
            if (z && CameraView.this.PrepareContext) {
                CameraView.access$500(CameraView.this, 0);
            }
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public final void getAuthRequestContext(final PictureResult.Stub stub) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "dispatchOnPictureTaken", stub);
            CameraView.this.isLayoutRequested.post(new Runnable() { // from class: com.otaliastudios.cameraview.CameraView.CameraCallbacks.4
                {
                    CameraCallbacks.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    PictureResult pictureResult = new PictureResult(stub);
                    Iterator<CameraListener> it = CameraView.this.mListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onPictureTaken(pictureResult);
                    }
                }
            });
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public final void KClassImpl$Data$declaredNonStaticMembers$2(final VideoResult.Stub stub) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "dispatchOnVideoTaken", stub);
            CameraView.this.isLayoutRequested.post(new Runnable() { // from class: com.otaliastudios.cameraview.CameraView.CameraCallbacks.5
                {
                    CameraCallbacks.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    VideoResult videoResult = new VideoResult(stub);
                    Iterator<CameraListener> it = CameraView.this.mListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onVideoTaken(videoResult);
                    }
                }
            });
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public final void KClassImpl$Data$declaredNonStaticMembers$2(final Gesture gesture, final PointF pointF) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "dispatchOnFocusStart", gesture, pointF);
            CameraView.this.isLayoutRequested.post(new Runnable() { // from class: com.otaliastudios.cameraview.CameraView.CameraCallbacks.6
                {
                    CameraCallbacks.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    CameraView.this.mMarkerLayout.onEvent(1, new PointF[]{pointF});
                    if (CameraView.this.PlaceComponentResult != null) {
                        CameraView.this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(gesture != null ? AutoFocusTrigger.GESTURE : AutoFocusTrigger.METHOD);
                    }
                    Iterator<CameraListener> it = CameraView.this.mListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onAutoFocusStart(pointF);
                    }
                }
            });
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public final void KClassImpl$Data$declaredNonStaticMembers$2(final Gesture gesture, final boolean z, final PointF pointF) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "dispatchOnFocusEnd", gesture, Boolean.valueOf(z), pointF);
            CameraView.this.isLayoutRequested.post(new Runnable() { // from class: com.otaliastudios.cameraview.CameraView.CameraCallbacks.7
                {
                    CameraCallbacks.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (z && CameraView.this.PrepareContext) {
                        CameraView.access$500(CameraView.this, 1);
                    }
                    if (CameraView.this.PlaceComponentResult != null) {
                        CameraView.this.PlaceComponentResult.PlaceComponentResult(gesture != null ? AutoFocusTrigger.GESTURE : AutoFocusTrigger.METHOD, z);
                    }
                    Iterator<CameraListener> it = CameraView.this.mListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onAutoFocusEnd(z, pointF);
                    }
                }
            });
        }

        @Override // com.otaliastudios.cameraview.internal.utils.OrientationHelper.Callback
        public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "onDeviceOrientationChanged", Integer.valueOf(i));
            int i2 = CameraView.this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2;
            if (!CameraView.this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
                Angles PrepareContext = CameraView.this.getAuthRequestContext.PrepareContext();
                int i3 = (360 - i2) % AUScreenAdaptTool.WIDTH_BASE;
                Angles.getAuthRequestContext(i3);
                PrepareContext.PlaceComponentResult = i3;
                PrepareContext.PlaceComponentResult();
            } else {
                Angles PrepareContext2 = CameraView.this.getAuthRequestContext.PrepareContext();
                Angles.getAuthRequestContext(i);
                PrepareContext2.PlaceComponentResult = i;
                PrepareContext2.PlaceComponentResult();
            }
            Handler handler = CameraView.this.isLayoutRequested;
            final int i4 = (i + i2) % AUScreenAdaptTool.WIDTH_BASE;
            handler.post(new Runnable() { // from class: com.otaliastudios.cameraview.CameraView.CameraCallbacks.8
                {
                    CameraCallbacks.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Iterator<CameraListener> it = CameraView.this.mListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onOrientationChanged(i4);
                    }
                }
            });
        }

        @Override // com.otaliastudios.cameraview.internal.utils.OrientationHelper.Callback
        public final void MyBillsEntityDataFactory(int i, boolean z) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "onDisplayOffsetChanged", Integer.valueOf(i), "recreate:", Boolean.valueOf(z));
            if (!CameraView.this.isOpened() || z) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(2, "onDisplayOffsetChanged", "restarting the camera.");
            CameraView.this.close();
            CameraView.this.open();
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public final void PlaceComponentResult(final float f, final PointF[] pointFArr) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "dispatchOnZoomChanged", Float.valueOf(f));
            CameraView.this.isLayoutRequested.post(new Runnable() { // from class: com.otaliastudios.cameraview.CameraView.CameraCallbacks.9
                {
                    CameraCallbacks.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Iterator<CameraListener> it = CameraView.this.mListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onZoomChanged(f, new float[]{0.0f, 1.0f}, pointFArr);
                    }
                }
            });
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public final void MyBillsEntityDataFactory(final float f, final float[] fArr, final PointF[] pointFArr) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "dispatchOnExposureCorrectionChanged", Float.valueOf(f));
            CameraView.this.isLayoutRequested.post(new Runnable() { // from class: com.otaliastudios.cameraview.CameraView.CameraCallbacks.10
                {
                    CameraCallbacks.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Iterator<CameraListener> it = CameraView.this.mListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onExposureCorrectionChanged(f, fArr, pointFArr);
                    }
                }
            });
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public final void PlaceComponentResult(final Frame frame) {
            CameraLogger cameraLogger = this.KClassImpl$Data$declaredNonStaticMembers$2;
            frame.getAuthRequestContext();
            cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(0, "dispatchFrame:", Long.valueOf(frame.moveToNextValue), "processors:", Integer.valueOf(CameraView.this.mFrameProcessors.size()));
            if (!CameraView.this.mFrameProcessors.isEmpty()) {
                CameraView.this.getErrorConfigVersion.execute(new Runnable() { // from class: com.otaliastudios.cameraview.CameraView.CameraCallbacks.11
                    {
                        CameraCallbacks.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        CameraLogger cameraLogger2 = CameraCallbacks.this.KClassImpl$Data$declaredNonStaticMembers$2;
                        Frame frame2 = frame;
                        frame2.getAuthRequestContext();
                        cameraLogger2.KClassImpl$Data$declaredNonStaticMembers$2(0, "dispatchFrame: executing. Passing", Long.valueOf(frame2.moveToNextValue), "to processors.");
                        Iterator<FrameProcessor> it = CameraView.this.mFrameProcessors.iterator();
                        while (it.hasNext()) {
                            try {
                                it.next().getAuthRequestContext(frame);
                            } catch (Exception e) {
                                CameraCallbacks.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(2, "Frame processor crashed:", e);
                            }
                        }
                        frame.PlaceComponentResult();
                    }
                });
            } else {
                frame.PlaceComponentResult();
            }
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public final void BuiltInFictitiousFunctionClassFactory(final CameraException cameraException) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "dispatchError", cameraException);
            CameraView.this.isLayoutRequested.post(new Runnable() { // from class: com.otaliastudios.cameraview.CameraView.CameraCallbacks.12
                {
                    CameraCallbacks.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Iterator<CameraListener> it = CameraView.this.mListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onCameraError(cameraException);
                    }
                }
            });
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public final void BuiltInFictitiousFunctionClassFactory() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "dispatchOnVideoRecordingStart");
            CameraView.this.isLayoutRequested.post(new Runnable() { // from class: com.otaliastudios.cameraview.CameraView.CameraCallbacks.13
                {
                    CameraCallbacks.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Iterator<CameraListener> it = CameraView.this.mListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onVideoRecordingStart();
                    }
                }
            });
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public final void PlaceComponentResult() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "dispatchOnVideoRecordingEnd");
            CameraView.this.isLayoutRequested.post(new Runnable() { // from class: com.otaliastudios.cameraview.CameraView.CameraCallbacks.14
                {
                    CameraCallbacks.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Iterator<CameraListener> it = CameraView.this.mListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onVideoRecordingEnd();
                    }
                }
            });
        }
    }

    public void addFrameProcessor(FrameProcessor frameProcessor) {
        if (frameProcessor != null) {
            this.mFrameProcessors.add(frameProcessor);
            if (this.mFrameProcessors.size() == 1) {
                this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(true);
            }
        }
    }

    public void removeFrameProcessor(FrameProcessor frameProcessor) {
        if (frameProcessor != null) {
            this.mFrameProcessors.remove(frameProcessor);
            if (this.mFrameProcessors.size() == 0) {
                this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(false);
            }
        }
    }

    public void clearFrameProcessors() {
        boolean z = this.mFrameProcessors.size() > 0;
        this.mFrameProcessors.clear();
        if (z) {
            this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(false);
        }
    }

    public void setFrameProcessingMaxWidth(int i) {
        this.getAuthRequestContext.moveToNextValue(i);
    }

    public void setFrameProcessingMaxHeight(int i) {
        this.getAuthRequestContext.getAuthRequestContext(i);
    }

    public int getFrameProcessingMaxWidth() {
        return this.getAuthRequestContext.getCallingPid();
    }

    public int getFrameProcessingMaxHeight() {
        return this.getAuthRequestContext.SubSequence();
    }

    public void setFrameProcessingFormat(int i) {
        this.getAuthRequestContext.MyBillsEntityDataFactory(i);
    }

    public int getFrameProcessingFormat() {
        return this.getAuthRequestContext.getSupportButtonTintMode();
    }

    public void setFrameProcessingPoolSize(int i) {
        this.getAuthRequestContext.scheduleImpl(i);
    }

    public int getFrameProcessingPoolSize() {
        return this.getAuthRequestContext.C();
    }

    public void setFrameProcessingExecutors(int i) {
        if (i <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Need at least 1 executor, got ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        this.moveToNextValue = i;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 4L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.otaliastudios.cameraview.CameraView.6
            private final AtomicInteger MyBillsEntityDataFactory = new AtomicInteger(1);

            {
                CameraView.this = this;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("FrameExecutor #");
                sb2.append(this.MyBillsEntityDataFactory.getAndIncrement());
                return new Thread(runnable, sb2.toString());
            }
        });
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.getErrorConfigVersion = threadPoolExecutor;
    }

    public int getFrameProcessingExecutors() {
        return this.moveToNextValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.mOverlayLayout.isOverlay(attributeSet)) {
            return this.mOverlayLayout.generateLayoutParams(attributeSet);
        }
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.mOverlayLayout.isOverlay(layoutParams)) {
            this.mOverlayLayout.addView(view, layoutParams);
        } else {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0 && layoutParams != null && this.mOverlayLayout.isOverlay(layoutParams)) {
            this.mOverlayLayout.removeView(view);
        } else {
            super.removeView(view);
        }
    }

    public void setFilter(Filter filter) {
        CameraPreview cameraPreview = this.BuiltInFictitiousFunctionClassFactory;
        if (cameraPreview == null) {
            this.initRecordTimeStamp = filter;
            return;
        }
        boolean z = cameraPreview instanceof FilterCameraPreview;
        if ((filter instanceof NoFilter) || z) {
            if (z) {
                ((FilterCameraPreview) cameraPreview).BuiltInFictitiousFunctionClassFactory(filter);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Filters are only supported by the GL_SURFACE preview. Current preview:");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        throw new RuntimeException(sb.toString());
    }

    public Filter getFilter() {
        CameraPreview cameraPreview = this.BuiltInFictitiousFunctionClassFactory;
        if (cameraPreview == null) {
            return this.initRecordTimeStamp;
        }
        if (cameraPreview instanceof FilterCameraPreview) {
            return ((FilterCameraPreview) cameraPreview).getErrorConfigVersion();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Filters are only supported by the GL_SURFACE preview. Current:");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        throw new RuntimeException(sb.toString());
    }

    static /* synthetic */ void access$500(CameraView cameraView, int i) {
        if (cameraView.PrepareContext) {
            if (cameraView.NetworkUserEntityData$$ExternalSyntheticLambda7 == null) {
                cameraView.NetworkUserEntityData$$ExternalSyntheticLambda7 = new MediaActionSound();
            }
            cameraView.NetworkUserEntityData$$ExternalSyntheticLambda7.play(i);
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(GestureFinder gestureFinder, CameraOptions cameraOptions) {
        Gesture gesture = gestureFinder.getAuthRequestContext;
        GestureAction gestureAction = this.scheduleImpl.get(gesture);
        PointF[] pointFArr = gestureFinder.KClassImpl$Data$declaredNonStaticMembers$2;
        switch (AnonymousClass7.BuiltInFictitiousFunctionClassFactory[gestureAction.ordinal()]) {
            case 1:
                takePicture();
                return;
            case 2:
                this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(gesture, MeteringRegions.MyBillsEntityDataFactory(new Size(getWidth(), getHeight()), pointFArr[0]), pointFArr[0]);
                return;
            case 3:
                float L = this.getAuthRequestContext.L();
                float KClassImpl$Data$declaredNonStaticMembers$22 = gestureFinder.KClassImpl$Data$declaredNonStaticMembers$2(L, 0.0f, 1.0f);
                if (KClassImpl$Data$declaredNonStaticMembers$22 != L) {
                    this.getAuthRequestContext.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22, pointFArr, true);
                    return;
                }
                return;
            case 4:
                float NetworkUserEntityData$$ExternalSyntheticLambda6 = this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda6();
                float authRequestContext = cameraOptions.getAuthRequestContext();
                float KClassImpl$Data$declaredNonStaticMembers$23 = cameraOptions.KClassImpl$Data$declaredNonStaticMembers$2();
                float KClassImpl$Data$declaredNonStaticMembers$24 = gestureFinder.KClassImpl$Data$declaredNonStaticMembers$2(NetworkUserEntityData$$ExternalSyntheticLambda6, authRequestContext, KClassImpl$Data$declaredNonStaticMembers$23);
                if (KClassImpl$Data$declaredNonStaticMembers$24 != NetworkUserEntityData$$ExternalSyntheticLambda6) {
                    this.getAuthRequestContext.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$24, new float[]{authRequestContext, KClassImpl$Data$declaredNonStaticMembers$23}, pointFArr, true);
                    return;
                }
                return;
            case 5:
                if (getFilter() instanceof OneParameterFilter) {
                    OneParameterFilter oneParameterFilter = (OneParameterFilter) getFilter();
                    float KClassImpl$Data$declaredNonStaticMembers$25 = oneParameterFilter.KClassImpl$Data$declaredNonStaticMembers$2();
                    float KClassImpl$Data$declaredNonStaticMembers$26 = gestureFinder.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$25, 0.0f, 1.0f);
                    if (KClassImpl$Data$declaredNonStaticMembers$26 != KClassImpl$Data$declaredNonStaticMembers$25) {
                        oneParameterFilter.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$26);
                        return;
                    }
                    return;
                }
                return;
            case 6:
                if (getFilter() instanceof TwoParameterFilter) {
                    TwoParameterFilter twoParameterFilter = (TwoParameterFilter) getFilter();
                    float MyBillsEntityDataFactory = twoParameterFilter.MyBillsEntityDataFactory();
                    float KClassImpl$Data$declaredNonStaticMembers$27 = gestureFinder.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, 0.0f, 1.0f);
                    if (KClassImpl$Data$declaredNonStaticMembers$27 != MyBillsEntityDataFactory) {
                        twoParameterFilter.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$27);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected boolean checkPermissions(Audio audio) {
        if (audio == Audio.ON || audio == Audio.MONO || audio == Audio.STEREO) {
            try {
                for (String str : getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 4096).requestedPermissions) {
                    if (!str.equals(ManifestPermission.RECORD_AUDIO)) {
                    }
                }
                throw new IllegalStateException(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(3, "Permission error: when audio is enabled (Audio.ON) the RECORD_AUDIO permission should be added to the app manifest file."));
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        Context context = getContext();
        boolean z = audio == Audio.ON || audio == Audio.MONO || audio == Audio.STEREO;
        boolean z2 = context.checkSelfPermission("android.permission.CAMERA") != 0;
        boolean z3 = z && context.checkSelfPermission(ManifestPermission.RECORD_AUDIO) != 0;
        if (z2 || z3) {
            if (this.newProxyInstance) {
                Activity activity = null;
                for (Context context2 = getContext(); context2 instanceof ContextWrapper; context2 = ((ContextWrapper) context2).getBaseContext()) {
                    if (context2 instanceof Activity) {
                        activity = (Activity) context2;
                    }
                }
                ArrayList arrayList = new ArrayList();
                if (z2) {
                    arrayList.add("android.permission.CAMERA");
                }
                if (z3) {
                    arrayList.add(ManifestPermission.RECORD_AUDIO);
                }
                if (activity != null) {
                    activity.requestPermissions((String[]) arrayList.toArray(new String[0]), 16);
                }
            }
            return false;
        }
        return true;
    }

    public void takeVideo(File file, int i) {
        addCameraListener(new AnonymousClass3(getVideoMaxDuration()));
        setVideoMaxDuration(i);
        BuiltInFictitiousFunctionClassFactory(file, (FileDescriptor) null);
    }

    public void takeVideo(FileDescriptor fileDescriptor, int i) {
        addCameraListener(new AnonymousClass3(getVideoMaxDuration()));
        setVideoMaxDuration(i);
        BuiltInFictitiousFunctionClassFactory((File) null, fileDescriptor);
    }
}
