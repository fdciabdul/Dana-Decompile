package com.otaliastudios.cameraview.engine;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.location.Location;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.CameraOptions;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.VideoResult;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.CameraEngine;
import com.otaliastudios.cameraview.engine.action.Action;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.Actions;
import com.otaliastudios.cameraview.engine.action.BaseAction;
import com.otaliastudios.cameraview.engine.action.CompletionCallback;
import com.otaliastudios.cameraview.engine.action.LogAction;
import com.otaliastudios.cameraview.engine.mappers.Camera2Mapper;
import com.otaliastudios.cameraview.engine.meter.MeterAction;
import com.otaliastudios.cameraview.engine.meter.MeterResetAction;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.options.Camera2Options;
import com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator;
import com.otaliastudios.cameraview.frame.Frame;
import com.otaliastudios.cameraview.frame.FrameManager;
import com.otaliastudios.cameraview.frame.ImageFrameManager;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.internal.utils.CropHelper;
import com.otaliastudios.cameraview.metering.MeteringRegions;
import com.otaliastudios.cameraview.picture.Full2PictureRecorder;
import com.otaliastudios.cameraview.picture.Snapshot2PictureRecorder;
import com.otaliastudios.cameraview.preview.GlCameraPreview;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;
import com.otaliastudios.cameraview.video.Full2VideoRecorder;
import com.otaliastudios.cameraview.video.SnapshotVideoRecorder;
import id.dana.ocr.model.SnapReceiptBroadcastData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

/* loaded from: classes2.dex */
public class Camera2Engine extends CameraBaseEngine implements ImageReader.OnImageAvailableListener, ActionHolder {
    private String AppCompatEmojiTextHelper;
    private CameraCharacteristics F;
    private CameraDevice G;
    private Surface H;
    private ImageReader I;
    private final Camera2Mapper J;
    private TotalCaptureResult K;
    private VideoResult.Stub L;
    private MeterAction M;
    private final CameraCaptureSession.CaptureCallback N;
    private CaptureRequest.Builder O;
    private Surface P;
    private final List<Action> PlaceComponentResult;
    private ImageReader Q;
    private CameraCaptureSession R;
    private final boolean SummaryVoucherView$$ExternalSyntheticLambda0;
    private final CameraManager getNameOrBuilderList;
    public static final byte[] MyBillsEntityDataFactory = {3, -83, -69, 19, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int BuiltInFictitiousFunctionClassFactory = 225;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = 16 - r6
            byte[] r0 = com.otaliastudios.cameraview.engine.Camera2Engine.MyBillsEntityDataFactory
            int r8 = r8 * 12
            int r8 = r8 + 4
            int r7 = r7 * 7
            int r7 = r7 + 99
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r8
            r4 = 0
            goto L28
        L16:
            r3 = 0
        L17:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r6) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r3 = r0[r8]
        L28:
            int r8 = r8 + 1
            int r7 = r7 + r3
            int r7 = r7 + 2
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.engine.Camera2Engine.a(short, short, int, java.lang.Object[]):void");
    }

    public Camera2Engine(CameraEngine.Callback callback) {
        super(callback);
        this.J = Camera2Mapper.getAuthRequestContext();
        this.SummaryVoucherView$$ExternalSyntheticLambda0 = false;
        this.PlaceComponentResult = new CopyOnWriteArrayList();
        this.N = new CameraCaptureSession.CaptureCallback() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.1
            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
                Iterator it = Camera2Engine.this.PlaceComponentResult.iterator();
                while (it.hasNext()) {
                    ((Action) it.next()).getAuthRequestContext(Camera2Engine.this, captureRequest);
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
                Iterator it = Camera2Engine.this.PlaceComponentResult.iterator();
                while (it.hasNext()) {
                    ((Action) it.next()).PlaceComponentResult(Camera2Engine.this, captureRequest, captureResult);
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
                Camera2Engine.this.K = totalCaptureResult;
                Iterator it = Camera2Engine.this.PlaceComponentResult.iterator();
                while (it.hasNext()) {
                    ((Action) it.next()).getAuthRequestContext(Camera2Engine.this, captureRequest, totalCaptureResult);
                }
            }
        };
        this.getNameOrBuilderList = (CameraManager) this.VerifyPinStateManager$executeRiskChallenge$2$2.MyBillsEntityDataFactory().getSystemService("camera");
        new LogAction().PlaceComponentResult(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CameraException getAuthRequestContext(CameraAccessException cameraAccessException) {
        int reason = cameraAccessException.getReason();
        int i = 1;
        if (reason != 1) {
            if (reason == 2 || reason == 3) {
                i = 3;
            } else if (reason != 4 && reason != 5) {
                i = 0;
            }
        }
        return new CameraException(cameraAccessException, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CaptureRequest.Builder NetworkUserEntityData$$ExternalSyntheticLambda2(int i) throws CameraAccessException {
        CaptureRequest.Builder builder = this.O;
        CaptureRequest.Builder createCaptureRequest = this.G.createCaptureRequest(i);
        this.O = createCaptureRequest;
        createCaptureRequest.setTag(Integer.valueOf(i));
        BuiltInFictitiousFunctionClassFactory(this.O, builder);
        return this.O;
    }

    private void getAuthRequestContext(Surface... surfaceArr) {
        this.O.addTarget(this.P);
        Surface surface = this.H;
        if (surface != null) {
            this.O.addTarget(surface);
        }
        for (Surface surface2 : surfaceArr) {
            if (surface2 == null) {
                throw new IllegalArgumentException("Should not add a null surface.");
            }
            this.O.addTarget(surface2);
        }
    }

    protected final void initRecordTimeStamp() {
        KClassImpl$Data$declaredNonStaticMembers$2(true, 3);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    protected final List<Size> MyBillsEntityDataFactory() {
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.getNameOrBuilderList.getCameraCharacteristics(this.AppCompatEmojiTextHelper).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
            }
            android.util.Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.NetworkUserEntityData$$ExternalSyntheticLambda4.KClassImpl$Data$declaredNonStaticMembers$2());
            ArrayList arrayList = new ArrayList(outputSizes.length);
            for (android.util.Size size : outputSizes) {
                Size size2 = new Size(size.getWidth(), size.getHeight());
                if (!arrayList.contains(size2)) {
                    arrayList.add(size2);
                }
            }
            return arrayList;
        } catch (CameraAccessException e) {
            throw getAuthRequestContext(e);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    protected final List<Size> getAuthRequestContext() {
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.getNameOrBuilderList.getCameraCharacteristics(this.AppCompatEmojiTextHelper).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
            }
            android.util.Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.initRecordTimeStamp);
            ArrayList arrayList = new ArrayList(outputSizes.length);
            for (android.util.Size size : outputSizes) {
                Size size2 = new Size(size.getWidth(), size.getHeight());
                if (!arrayList.contains(size2)) {
                    arrayList.add(size2);
                }
            }
            return arrayList;
        } catch (CameraAccessException e) {
            throw getAuthRequestContext(e);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    protected final void BuiltInFictitiousFunctionClassFactory() {
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onPreviewStreamSizeChanged:", "Calling restartBind().");
        W();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final boolean PlaceComponentResult(Facing facing) {
        CameraCharacteristics cameraCharacteristics;
        Object obj;
        int authRequestContext = Camera2Mapper.getAuthRequestContext(facing);
        try {
            String[] cameraIdList = this.getNameOrBuilderList.getCameraIdList();
            A.KClassImpl$Data$declaredNonStaticMembers$2(1, "collectCameraInfo", "Facing:", facing, "Internal:", Integer.valueOf(authRequestContext), "Cameras:", Integer.valueOf(cameraIdList.length));
            for (String str : cameraIdList) {
                try {
                    cameraCharacteristics = this.getNameOrBuilderList.getCameraCharacteristics(str);
                    obj = cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                } catch (CameraAccessException unused) {
                }
                if (authRequestContext == ((Integer) (obj != null ? obj : -99)).intValue()) {
                    this.AppCompatEmojiTextHelper = str;
                    Object obj2 = cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
                    PrepareContext().MyBillsEntityDataFactory(facing, ((Integer) (obj2 != null ? obj2 : 0)).intValue());
                    return true;
                }
                continue;
            }
            return false;
        } catch (CameraAccessException e) {
            throw getAuthRequestContext(e);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    protected final Task<CameraOptions> lookAheadTest() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            this.getNameOrBuilderList.openCamera(this.AppCompatEmojiTextHelper, new CameraDevice.StateCallback() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.2
                @Override // android.hardware.camera2.CameraDevice.StateCallback
                public void onOpened(CameraDevice cameraDevice) {
                    int i;
                    Camera2Engine.this.G = cameraDevice;
                    try {
                        CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStartEngine:", "Opened camera device.");
                        Camera2Engine camera2Engine = Camera2Engine.this;
                        camera2Engine.F = camera2Engine.getNameOrBuilderList.getCameraCharacteristics(Camera2Engine.this.AppCompatEmojiTextHelper);
                        boolean PlaceComponentResult = Camera2Engine.this.getAuthRequestContext.PlaceComponentResult(Reference.SENSOR, Reference.VIEW);
                        int i2 = AnonymousClass23.getAuthRequestContext[Camera2Engine.this.isLayoutRequested.ordinal()];
                        if (i2 == 1) {
                            i = 256;
                        } else if (i2 != 2) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Unknown format:");
                            sb.append(Camera2Engine.this.isLayoutRequested);
                            throw new IllegalArgumentException(sb.toString());
                        } else {
                            i = 32;
                        }
                        Camera2Engine.this.scheduleImpl = new Camera2Options(Camera2Engine.this.getNameOrBuilderList, Camera2Engine.this.AppCompatEmojiTextHelper, PlaceComponentResult, i);
                        Camera2Engine.this.NetworkUserEntityData$$ExternalSyntheticLambda2(1);
                        taskCompletionSource.trySetResult(Camera2Engine.this.scheduleImpl);
                    } catch (CameraAccessException e) {
                        taskCompletionSource.trySetException(Camera2Engine.getAuthRequestContext(e));
                    }
                }

                @Override // android.hardware.camera2.CameraDevice.StateCallback
                public void onDisconnected(CameraDevice cameraDevice) {
                    CameraException cameraException = new CameraException(3);
                    if (!taskCompletionSource.getTask().isComplete()) {
                        taskCompletionSource.trySetException(cameraException);
                    } else {
                        CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(1, "CameraDevice.StateCallback reported disconnection.");
                        throw cameraException;
                    }
                }

                @Override // android.hardware.camera2.CameraDevice.StateCallback
                public void onError(CameraDevice cameraDevice, int i) {
                    if (!taskCompletionSource.getTask().isComplete()) {
                        taskCompletionSource.trySetException(Camera2Engine.BuiltInFictitiousFunctionClassFactory(i));
                    } else {
                        CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(3, "CameraDevice.StateCallback reported an error:", Integer.valueOf(i));
                        throw new CameraException(3);
                    }
                }
            }, (Handler) null);
            return taskCompletionSource.getTask();
        } catch (CameraAccessException e) {
            throw getAuthRequestContext(e);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$23  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass23 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[PictureFormat.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[PictureFormat.JPEG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[PictureFormat.DNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    protected final Task<Void> NetworkUserEntityData$$ExternalSyntheticLambda0() {
        int i;
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStartBind:", "Started");
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.lookAheadTest = NetworkUserEntityData$$ExternalSyntheticLambda7();
        this.readMicros = newProxyInstance();
        ArrayList arrayList = new ArrayList();
        Class KClassImpl$Data$declaredNonStaticMembers$2 = this.NetworkUserEntityData$$ExternalSyntheticLambda4.KClassImpl$Data$declaredNonStaticMembers$2();
        final Object authRequestContext = this.NetworkUserEntityData$$ExternalSyntheticLambda4.getAuthRequestContext();
        if (KClassImpl$Data$declaredNonStaticMembers$2 == SurfaceHolder.class) {
            try {
                Tasks.await(Tasks.call(new Callable<Void>() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.3
                    @Override // java.util.concurrent.Callable
                    public /* synthetic */ Void call() throws Exception {
                        ((SurfaceHolder) authRequestContext).setFixedSize(Camera2Engine.this.readMicros.BuiltInFictitiousFunctionClassFactory, Camera2Engine.this.readMicros.getAuthRequestContext);
                        return null;
                    }
                }));
                this.P = ((SurfaceHolder) authRequestContext).getSurface();
            } catch (InterruptedException | ExecutionException e) {
                throw new CameraException(e, 1);
            }
        } else if (KClassImpl$Data$declaredNonStaticMembers$2 == SurfaceTexture.class) {
            SurfaceTexture surfaceTexture = (SurfaceTexture) authRequestContext;
            surfaceTexture.setDefaultBufferSize(this.readMicros.BuiltInFictitiousFunctionClassFactory, this.readMicros.getAuthRequestContext);
            this.P = new Surface(surfaceTexture);
        } else {
            throw new RuntimeException("Unknown CameraPreview output class.");
        }
        arrayList.add(this.P);
        if (VerifyPinStateManager$executeRiskChallenge$2$1() == Mode.VIDEO && this.L != null) {
            Full2VideoRecorder full2VideoRecorder = new Full2VideoRecorder(this, this.AppCompatEmojiTextHelper);
            try {
                arrayList.add(full2VideoRecorder.getAuthRequestContext(this.L));
                this.getCallingPid = full2VideoRecorder;
            } catch (Full2VideoRecorder.PrepareException e2) {
                throw new CameraException(e2, 1);
            }
        }
        if (VerifyPinStateManager$executeRiskChallenge$2$1() == Mode.PICTURE) {
            int i2 = AnonymousClass23.getAuthRequestContext[this.isLayoutRequested.ordinal()];
            if (i2 == 1) {
                i = 256;
            } else if (i2 != 2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown format:");
                sb.append(this.isLayoutRequested);
                throw new IllegalArgumentException(sb.toString());
            } else {
                i = 32;
            }
            ImageReader newInstance = ImageReader.newInstance(this.lookAheadTest.BuiltInFictitiousFunctionClassFactory, this.lookAheadTest.getAuthRequestContext, i, 2);
            this.Q = newInstance;
            arrayList.add(newInstance.getSurface());
        }
        if (O()) {
            this.GetContactSyncConfig = NetworkUserEntityData$$ExternalSyntheticLambda8();
            ImageReader newInstance2 = ImageReader.newInstance(this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory, this.GetContactSyncConfig.getAuthRequestContext, this.initRecordTimeStamp, C() + 1);
            this.I = newInstance2;
            newInstance2.setOnImageAvailableListener(this, null);
            Surface surface = this.I.getSurface();
            this.H = surface;
            arrayList.add(surface);
        } else {
            this.I = null;
            this.GetContactSyncConfig = null;
            this.H = null;
        }
        try {
            this.G.createCaptureSession(arrayList, new CameraCaptureSession.StateCallback() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.4
                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                    Camera2Engine.this.R = cameraCaptureSession;
                    CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStartBind:", SnapReceiptBroadcastData.Status.Completed);
                    taskCompletionSource.trySetResult(null);
                }

                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                    throw new RuntimeException(CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(3, "onConfigureFailed! Session", cameraCaptureSession));
                }

                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onReady(CameraCaptureSession cameraCaptureSession) {
                    super.onReady(cameraCaptureSession);
                    CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(1, "CameraCaptureSession.StateCallback reported onReady.");
                }
            }, null);
            return taskCompletionSource.getTask();
        } catch (CameraAccessException e3) {
            throw getAuthRequestContext(e3);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    protected final Task<Void> getErrorConfigVersion() {
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStartPreview:", "Dispatching onCameraPreviewStreamSizeChanged.");
        this.VerifyPinStateManager$executeRiskChallenge$2$2.lookAheadTest();
        Size BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(Reference.VIEW);
        if (BuiltInFictitiousFunctionClassFactory2 == null) {
            throw new IllegalStateException("previewStreamSize should not be null at this point.");
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda4.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext);
        this.NetworkUserEntityData$$ExternalSyntheticLambda4.MyBillsEntityDataFactory(PrepareContext().KClassImpl$Data$declaredNonStaticMembers$2(Reference.BASE, Reference.VIEW, Axis.ABSOLUTE));
        if (O()) {
            KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult(this.initRecordTimeStamp, this.GetContactSyncConfig);
        }
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStartPreview:", "Starting preview.");
        getAuthRequestContext(new Surface[0]);
        KClassImpl$Data$declaredNonStaticMembers$2(false, 2);
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStartPreview:", "Started preview.");
        final VideoResult.Stub stub = this.L;
        if (stub != null) {
            this.L = null;
            CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
            cameraStateOrchestrator.PlaceComponentResult("do take video", true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.PREVIEW, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.5
                @Override // java.lang.Runnable
                public void run() {
                    Camera2Engine.PlaceComponentResult(Camera2Engine.this, stub);
                }
            })));
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        new BaseAction() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.6
            @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
            public final void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
                super.getAuthRequestContext(actionHolder, captureRequest, totalCaptureResult);
                MyBillsEntityDataFactory(Integer.MAX_VALUE);
                taskCompletionSource.trySetResult(null);
            }
        }.PlaceComponentResult(this);
        return taskCompletionSource.getTask();
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    protected final Task<Void> NetworkUserEntityData$$ExternalSyntheticLambda1() {
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStopPreview:", "Started.");
        if (this.getCallingPid != null) {
            this.getCallingPid.MyBillsEntityDataFactory(true);
            this.getCallingPid = null;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = null;
        if (O()) {
            KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory();
        }
        this.O.removeTarget(this.P);
        Surface surface = this.H;
        if (surface != null) {
            this.O.removeTarget(surface);
        }
        this.K = null;
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStopPreview:", "Returning.");
        return Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    protected final Task<Void> scheduleImpl() {
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStopBind:", "About to clean up.");
        this.H = null;
        this.P = null;
        this.readMicros = null;
        this.lookAheadTest = null;
        this.GetContactSyncConfig = null;
        ImageReader imageReader = this.I;
        if (imageReader != null) {
            imageReader.close();
            this.I = null;
        }
        ImageReader imageReader2 = this.Q;
        if (imageReader2 != null) {
            imageReader2.close();
            this.Q = null;
        }
        this.R.close();
        this.R = null;
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStopBind:", "Returning.");
        return Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    protected final Task<Void> moveToNextValue() {
        try {
            A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStopEngine:", "Clean up.", "Releasing camera.");
            this.G.close();
            A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStopEngine:", "Clean up.", "Released camera.");
        } catch (Exception e) {
            A.KClassImpl$Data$declaredNonStaticMembers$2(2, "onStopEngine:", "Clean up.", "Exception while releasing camera.", e);
        }
        this.G = null;
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStopEngine:", "Aborting actions.");
        Iterator<Action> it = this.PlaceComponentResult.iterator();
        while (it.hasNext()) {
            it.next().getAuthRequestContext(this);
        }
        this.F = null;
        this.scheduleImpl = null;
        this.getCallingPid = null;
        this.O = null;
        A.KClassImpl$Data$declaredNonStaticMembers$2(2, "onStopEngine:", "Returning.");
        return Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    protected final void MyBillsEntityDataFactory(final PictureResult.Stub stub, AspectRatio aspectRatio, boolean z) {
        if (z) {
            A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onTakePictureSnapshot:", "doMetering is true. Delaying.");
            BaseAction KClassImpl$Data$declaredNonStaticMembers$2 = Actions.KClassImpl$Data$declaredNonStaticMembers$2(2500L, BuiltInFictitiousFunctionClassFactory((MeteringRegions) null));
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(new CompletionCallback() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.7
                @Override // com.otaliastudios.cameraview.engine.action.CompletionCallback
                public final void getAuthRequestContext() {
                    Camera2Engine.this.getAuthRequestContext(false);
                    Camera2Engine.this.KClassImpl$Data$declaredNonStaticMembers$2(stub);
                    Camera2Engine.this.getAuthRequestContext(true);
                }
            });
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this);
            return;
        }
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onTakePictureSnapshot:", "doMetering is false. Performing.");
        if (!(this.NetworkUserEntityData$$ExternalSyntheticLambda4 instanceof GlCameraPreview)) {
            throw new RuntimeException("takePictureSnapshot with Camera2 is only supported with Preview.GL_SURFACE");
        }
        stub.scheduleImpl = getAuthRequestContext(Reference.OUTPUT);
        stub.NetworkUserEntityData$$ExternalSyntheticLambda0 = PrepareContext().KClassImpl$Data$declaredNonStaticMembers$2(Reference.SENSOR, Reference.OUTPUT, Axis.RELATIVE_TO_SENSOR);
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new Snapshot2PictureRecorder(stub, this, (GlCameraPreview) this.NetworkUserEntityData$$ExternalSyntheticLambda4, aspectRatio);
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.PlaceComponentResult();
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    protected final void getAuthRequestContext(final PictureResult.Stub stub, boolean z) {
        if (z) {
            A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onTakePicture:", "doMetering is true. Delaying.");
            BaseAction KClassImpl$Data$declaredNonStaticMembers$2 = Actions.KClassImpl$Data$declaredNonStaticMembers$2(2500L, BuiltInFictitiousFunctionClassFactory((MeteringRegions) null));
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(new CompletionCallback() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.8
                @Override // com.otaliastudios.cameraview.engine.action.CompletionCallback
                public final void getAuthRequestContext() {
                    Camera2Engine.this.KClassImpl$Data$declaredNonStaticMembers$2(false);
                    Camera2Engine.this.PlaceComponentResult(stub);
                    Camera2Engine.this.KClassImpl$Data$declaredNonStaticMembers$2(true);
                }
            });
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this);
            return;
        }
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onTakePicture:", "doMetering is false. Performing.");
        stub.NetworkUserEntityData$$ExternalSyntheticLambda0 = PrepareContext().KClassImpl$Data$declaredNonStaticMembers$2(Reference.SENSOR, Reference.OUTPUT, Axis.RELATIVE_TO_SENSOR);
        stub.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2(Reference.OUTPUT);
        try {
            CaptureRequest.Builder createCaptureRequest = this.G.createCaptureRequest(2);
            BuiltInFictitiousFunctionClassFactory(createCaptureRequest, this.O);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new Full2PictureRecorder(stub, this, createCaptureRequest, this.Q);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6.PlaceComponentResult();
        } catch (CameraAccessException e) {
            throw getAuthRequestContext(e);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine, com.otaliastudios.cameraview.picture.PictureRecorder.PictureResultListener
    public final void getAuthRequestContext(PictureResult.Stub stub, Exception exc) {
        boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda6 instanceof Full2PictureRecorder;
        super.getAuthRequestContext(stub, exc);
        if ((z && D()) || (!z && getValueOfTouchPositionAbsolute())) {
            CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
            cameraStateOrchestrator.PlaceComponentResult("reset metering after picture", true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.PREVIEW, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.9
                @Override // java.lang.Runnable
                public void run() {
                    Camera2Engine.PlaceComponentResult(Camera2Engine.this);
                }
            })));
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    protected final void PlaceComponentResult(VideoResult.Stub stub) {
        Size size;
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onTakeVideo", "called.");
        stub.initRecordTimeStamp = PrepareContext().KClassImpl$Data$declaredNonStaticMembers$2(Reference.SENSOR, Reference.OUTPUT, Axis.RELATIVE_TO_SENSOR);
        if (!PrepareContext().PlaceComponentResult(Reference.SENSOR, Reference.OUTPUT)) {
            size = this.lookAheadTest;
        } else {
            Size size2 = this.lookAheadTest;
            size = new Size(size2.getAuthRequestContext, size2.BuiltInFictitiousFunctionClassFactory);
        }
        stub.DatabaseTableConfigUtil = size;
        A.KClassImpl$Data$declaredNonStaticMembers$2(2, "onTakeVideo", "calling restartBind.");
        this.L = stub;
        W();
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    protected final void getAuthRequestContext(VideoResult.Stub stub, AspectRatio aspectRatio) {
        if (!(this.NetworkUserEntityData$$ExternalSyntheticLambda4 instanceof GlCameraPreview)) {
            throw new IllegalStateException("Video snapshots are only supported with GL_SURFACE.");
        }
        GlCameraPreview glCameraPreview = (GlCameraPreview) this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        Size authRequestContext = getAuthRequestContext(Reference.OUTPUT);
        if (authRequestContext == null) {
            throw new IllegalStateException("outputSize should not be null.");
        }
        Rect BuiltInFictitiousFunctionClassFactory2 = CropHelper.BuiltInFictitiousFunctionClassFactory(authRequestContext, aspectRatio);
        stub.DatabaseTableConfigUtil = new Size(BuiltInFictitiousFunctionClassFactory2.width(), BuiltInFictitiousFunctionClassFactory2.height());
        stub.initRecordTimeStamp = PrepareContext().KClassImpl$Data$declaredNonStaticMembers$2(Reference.BASE, Reference.OUTPUT, Axis.ABSOLUTE);
        stub.NetworkUserEntityData$$ExternalSyntheticLambda1 = Math.round(this.whenAvailable);
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onTakeVideoSnapshot", "rotation:", Integer.valueOf(stub.initRecordTimeStamp), "size:", stub.DatabaseTableConfigUtil);
        this.getCallingPid = new SnapshotVideoRecorder(this, glCameraPreview, B(), PrepareContext().KClassImpl$Data$declaredNonStaticMembers$2(Reference.VIEW, Reference.OUTPUT, Axis.ABSOLUTE));
        this.getCallingPid.PlaceComponentResult(stub);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094 A[ORIG_RETURN, RETURN] */
    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine, com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void isLayoutRequested() {
        /*
            r10 = this;
            super.isLayoutRequested()
            com.otaliastudios.cameraview.video.VideoRecorder r0 = r10.getCallingPid
            boolean r0 = r0 instanceof com.otaliastudios.cameraview.video.Full2VideoRecorder
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L26
            android.hardware.camera2.CameraCharacteristics$Key r0 = android.hardware.camera2.CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL
            r4 = -1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            android.hardware.camera2.CameraCharacteristics r5 = r10.F
            java.lang.Object r0 = r5.get(r0)
            if (r0 == 0) goto L1c
            r4 = r0
        L1c:
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r0 = r4.intValue()
            if (r0 != r1) goto L26
            r0 = 1
            goto L27
        L26:
            r0 = 0
        L27:
            if (r0 == 0) goto L94
            com.otaliastudios.cameraview.CameraLogger r0 = com.otaliastudios.cameraview.engine.Camera2Engine.A
            java.lang.Object[] r4 = new java.lang.Object[r1]
            java.lang.String r5 = "Applying the Issue549 workaround."
            r4[r2] = r5
            byte[] r5 = com.otaliastudios.cameraview.engine.Camera2Engine.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L8b
            r6 = 15
            r5 = r5[r6]     // Catch: java.lang.Throwable -> L8b
            int r5 = r5 - r3
            byte r5 = (byte) r5     // Catch: java.lang.Throwable -> L8b
            byte[] r7 = com.otaliastudios.cameraview.engine.Camera2Engine.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L8b
            r7 = r7[r6]     // Catch: java.lang.Throwable -> L8b
            byte r7 = (byte) r7     // Catch: java.lang.Throwable -> L8b
            byte r8 = (byte) r7     // Catch: java.lang.Throwable -> L8b
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L8b
            a(r5, r7, r8, r9)     // Catch: java.lang.Throwable -> L8b
            r5 = r9[r2]     // Catch: java.lang.Throwable -> L8b
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L8b
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch: java.lang.Throwable -> L8b
            byte[] r7 = com.otaliastudios.cameraview.engine.Camera2Engine.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L8b
            r6 = r7[r6]     // Catch: java.lang.Throwable -> L8b
            byte r6 = (byte) r6     // Catch: java.lang.Throwable -> L8b
            int r7 = r6 + (-1)
            byte r7 = (byte) r7     // Catch: java.lang.Throwable -> L8b
            byte r8 = (byte) r7     // Catch: java.lang.Throwable -> L8b
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L8b
            a(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L8b
            r6 = r9[r2]     // Catch: java.lang.Throwable -> L8b
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L8b
            r7 = 0
            java.lang.reflect.Method r5 = r5.getMethod(r6, r7)     // Catch: java.lang.Throwable -> L8b
            java.lang.Object r5 = r5.invoke(r7, r7)     // Catch: java.lang.Throwable -> L8b
            r4[r3] = r5
            r0.KClassImpl$Data$declaredNonStaticMembers$2(r1, r4)
            r10.Y()
            com.otaliastudios.cameraview.CameraLogger r0 = com.otaliastudios.cameraview.engine.Camera2Engine.A
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.String r5 = "Applied the Issue549 workaround. Sleeping..."
            r4[r2] = r5
            r0.KClassImpl$Data$declaredNonStaticMembers$2(r1, r4)
            r4 = 600(0x258, double:2.964E-321)
            java.lang.Thread.sleep(r4)     // Catch: java.lang.InterruptedException -> L7f
        L7f:
            com.otaliastudios.cameraview.CameraLogger r0 = com.otaliastudios.cameraview.engine.Camera2Engine.A
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "Applied the Issue549 workaround. Slept!"
            r3[r2] = r4
            r0.KClassImpl$Data$declaredNonStaticMembers$2(r1, r3)
            goto L94
        L8b:
            r0 = move-exception
            java.lang.Throwable r1 = r0.getCause()
            if (r1 == 0) goto L93
            throw r1
        L93:
            throw r0
        L94:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.engine.Camera2Engine.isLayoutRequested():void");
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine, com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener
    public final void PlaceComponentResult(VideoResult.Stub stub, Exception exc) {
        super.PlaceComponentResult(stub, exc);
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        cameraStateOrchestrator.PlaceComponentResult("restore preview template", true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.BIND, new AnonymousClass10())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$10  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass10 implements Runnable {
        AnonymousClass10() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine.this.Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        if (((Integer) this.O.build().getTag()).intValue() != 1) {
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda2(1);
                getAuthRequestContext(new Surface[0]);
                KClassImpl$Data$declaredNonStaticMembers$2(true, 3);
            } catch (CameraAccessException e) {
                throw getAuthRequestContext(e);
            }
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(CaptureRequest.Builder builder, CaptureRequest.Builder builder2) {
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "applyAllParameters:", "called for tag", builder.build().getTag());
        builder.set(CaptureRequest.CONTROL_MODE, 1);
        getAuthRequestContext(builder);
        PlaceComponentResult(builder, Flash.OFF);
        PlaceComponentResult(builder);
        PlaceComponentResult(builder, WhiteBalance.AUTO);
        BuiltInFictitiousFunctionClassFactory(builder, Hdr.OFF);
        getAuthRequestContext(builder, 0.0f);
        MyBillsEntityDataFactory(builder, 0.0f);
        BuiltInFictitiousFunctionClassFactory(builder, 0.0f);
        if (builder2 != null) {
            builder.set(CaptureRequest.CONTROL_AF_REGIONS, builder2.get(CaptureRequest.CONTROL_AF_REGIONS));
            builder.set(CaptureRequest.CONTROL_AE_REGIONS, builder2.get(CaptureRequest.CONTROL_AE_REGIONS));
            builder.set(CaptureRequest.CONTROL_AWB_REGIONS, builder2.get(CaptureRequest.CONTROL_AWB_REGIONS));
            builder.set(CaptureRequest.CONTROL_AF_MODE, builder2.get(CaptureRequest.CONTROL_AF_MODE));
        }
    }

    protected final void getAuthRequestContext(CaptureRequest.Builder builder) {
        Object obj = new int[0];
        Object obj2 = this.F.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (obj2 != null) {
            obj = obj2;
        }
        ArrayList arrayList = new ArrayList();
        for (int i : (int[]) obj) {
            arrayList.add(Integer.valueOf(i));
        }
        if (VerifyPinStateManager$executeRiskChallenge$2$1() == Mode.VIDEO && arrayList.contains(3)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
        } else if (arrayList.contains(4)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
        } else if (arrayList.contains(1)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        } else if (arrayList.contains(0)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 0);
            builder.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(0.0f));
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(CaptureRequest.Builder builder) {
        Object obj = new int[0];
        Object obj2 = this.F.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (obj2 != null) {
            obj = obj2;
        }
        ArrayList arrayList = new ArrayList();
        for (int i : (int[]) obj) {
            arrayList.add(Integer.valueOf(i));
        }
        if (arrayList.contains(1)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        } else if (VerifyPinStateManager$executeRiskChallenge$2$1() == Mode.VIDEO && arrayList.contains(3)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
        } else if (arrayList.contains(4)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void BuiltInFictitiousFunctionClassFactory(final Flash flash) {
        final Flash flash2 = this.moveToNextValue;
        this.moveToNextValue = flash;
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        StringBuilder sb = new StringBuilder();
        sb.append("flash (");
        sb.append(flash);
        sb.append(")");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = cameraStateOrchestrator.PlaceComponentResult(sb.toString(), true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.11
            @Override // java.lang.Runnable
            public void run() {
                Camera2Engine camera2Engine = Camera2Engine.this;
                boolean PlaceComponentResult = camera2Engine.PlaceComponentResult(camera2Engine.O, flash2);
                if (!(Camera2Engine.this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory == CameraState.PREVIEW)) {
                    if (PlaceComponentResult) {
                        Camera2Engine.this.initRecordTimeStamp();
                        return;
                    }
                    return;
                }
                Camera2Engine.this.moveToNextValue = Flash.OFF;
                Camera2Engine camera2Engine2 = Camera2Engine.this;
                camera2Engine2.PlaceComponentResult(camera2Engine2.O, flash2);
                try {
                    Camera2Engine.this.R.capture(Camera2Engine.this.O.build(), null, null);
                    Camera2Engine.this.moveToNextValue = flash;
                    Camera2Engine camera2Engine3 = Camera2Engine.this;
                    camera2Engine3.PlaceComponentResult(camera2Engine3.O, flash2);
                    Camera2Engine.this.initRecordTimeStamp();
                } catch (CameraAccessException e) {
                    throw Camera2Engine.getAuthRequestContext(e);
                }
            }
        })));
    }

    protected final boolean PlaceComponentResult(CaptureRequest.Builder builder, Flash flash) {
        if (this.scheduleImpl.PlaceComponentResult(this.moveToNextValue)) {
            Object obj = new int[0];
            Object obj2 = this.F.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
            if (obj2 != null) {
                obj = obj2;
            }
            ArrayList arrayList = new ArrayList();
            for (int i : (int[]) obj) {
                arrayList.add(Integer.valueOf(i));
            }
            for (Pair<Integer, Integer> pair : Camera2Mapper.PlaceComponentResult(this.moveToNextValue)) {
                if (arrayList.contains(pair.first)) {
                    A.KClassImpl$Data$declaredNonStaticMembers$2(1, "applyFlash: setting CONTROL_AE_MODE to", pair.first);
                    A.KClassImpl$Data$declaredNonStaticMembers$2(1, "applyFlash: setting FLASH_MODE to", pair.second);
                    builder.set(CaptureRequest.CONTROL_AE_MODE, pair.first);
                    builder.set(CaptureRequest.FLASH_MODE, pair.second);
                    return true;
                }
            }
        }
        this.moveToNextValue = flash;
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void getAuthRequestContext(Location location) {
        final Location location2 = this.newProxyInstance;
        this.newProxyInstance = location;
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = cameraStateOrchestrator.PlaceComponentResult("location", true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.12
            @Override // java.lang.Runnable
            public void run() {
                Camera2Engine camera2Engine = Camera2Engine.this;
                camera2Engine.PlaceComponentResult(camera2Engine.O);
                Camera2Engine.this.initRecordTimeStamp();
            }
        })));
    }

    protected final boolean PlaceComponentResult(CaptureRequest.Builder builder) {
        if (this.newProxyInstance != null) {
            builder.set(CaptureRequest.JPEG_GPS_LOCATION, this.newProxyInstance);
            return true;
        }
        return true;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void PlaceComponentResult(WhiteBalance whiteBalance) {
        final WhiteBalance whiteBalance2 = this.VerifyPinStateManager$executeRiskChallenge$2$1;
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = whiteBalance;
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        StringBuilder sb = new StringBuilder();
        sb.append("white balance (");
        sb.append(whiteBalance);
        sb.append(")");
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = cameraStateOrchestrator.PlaceComponentResult(sb.toString(), true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.13
            @Override // java.lang.Runnable
            public void run() {
                Camera2Engine camera2Engine = Camera2Engine.this;
                if (camera2Engine.PlaceComponentResult(camera2Engine.O, whiteBalance2)) {
                    Camera2Engine.this.initRecordTimeStamp();
                }
            }
        })));
    }

    protected final boolean PlaceComponentResult(CaptureRequest.Builder builder, WhiteBalance whiteBalance) {
        if (this.scheduleImpl.PlaceComponentResult(this.VerifyPinStateManager$executeRiskChallenge$2$1)) {
            builder.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(Camera2Mapper.getAuthRequestContext(this.VerifyPinStateManager$executeRiskChallenge$2$1)));
            return true;
        }
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = whiteBalance;
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Hdr hdr) {
        final Hdr hdr2 = this.DatabaseTableConfigUtil;
        this.DatabaseTableConfigUtil = hdr;
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        StringBuilder sb = new StringBuilder();
        sb.append("hdr (");
        sb.append(hdr);
        sb.append(")");
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = cameraStateOrchestrator.PlaceComponentResult(sb.toString(), true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.14
            @Override // java.lang.Runnable
            public void run() {
                Camera2Engine camera2Engine = Camera2Engine.this;
                if (camera2Engine.BuiltInFictitiousFunctionClassFactory(camera2Engine.O, hdr2)) {
                    Camera2Engine.this.initRecordTimeStamp();
                }
            }
        })));
    }

    protected final boolean BuiltInFictitiousFunctionClassFactory(CaptureRequest.Builder builder, Hdr hdr) {
        if (this.scheduleImpl.PlaceComponentResult(this.DatabaseTableConfigUtil)) {
            builder.set(CaptureRequest.CONTROL_SCENE_MODE, Integer.valueOf(Camera2Mapper.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil)));
            return true;
        }
        this.DatabaseTableConfigUtil = hdr;
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void PlaceComponentResult(final float f, final PointF[] pointFArr, final boolean z) {
        final float f2 = this.B;
        this.B = f;
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        StringBuilder sb = new StringBuilder();
        sb.append("zoom (");
        sb.append(f);
        sb.append(")");
        this.C = cameraStateOrchestrator.PlaceComponentResult(sb.toString(), true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.15
            @Override // java.lang.Runnable
            public void run() {
                Camera2Engine camera2Engine = Camera2Engine.this;
                if (camera2Engine.getAuthRequestContext(camera2Engine.O, f2)) {
                    Camera2Engine.this.initRecordTimeStamp();
                    if (z) {
                        Camera2Engine.this.VerifyPinStateManager$executeRiskChallenge$2$2.PlaceComponentResult(f, pointFArr);
                    }
                }
            }
        })));
    }

    protected final boolean getAuthRequestContext(CaptureRequest.Builder builder, float f) {
        if (this.scheduleImpl.scheduleImpl()) {
            CameraCharacteristics.Key key = CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM;
            Object valueOf = Float.valueOf(1.0f);
            Object obj = this.F.get(key);
            if (obj != null) {
                valueOf = obj;
            }
            float floatValue = ((Float) valueOf).floatValue();
            float f2 = floatValue - 1.0f;
            float f3 = (this.B * f2) + 1.0f;
            CameraCharacteristics.Key key2 = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
            Object rect = new Rect();
            Object obj2 = this.F.get(key2);
            if (obj2 != null) {
                rect = obj2;
            }
            Rect rect2 = (Rect) rect;
            int width = (int) (rect2.width() / floatValue);
            int height = (int) (rect2.height() / floatValue);
            float f4 = f3 - 1.0f;
            int width2 = (int) ((((rect2.width() - width) * f4) / f2) / 2.0f);
            int height2 = (int) ((((rect2.height() - height) * f4) / f2) / 2.0f);
            builder.set(CaptureRequest.SCALER_CROP_REGION, new Rect(width2, height2, rect2.width() - width2, rect2.height() - height2));
            return true;
        }
        this.B = f;
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void getAuthRequestContext(final float f, final float[] fArr, final PointF[] pointFArr, final boolean z) {
        final float f2 = this.getErrorConfigVersion;
        this.getErrorConfigVersion = f;
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        StringBuilder sb = new StringBuilder();
        sb.append("exposure correction (");
        sb.append(f);
        sb.append(")");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = cameraStateOrchestrator.PlaceComponentResult(sb.toString(), true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.16
            @Override // java.lang.Runnable
            public void run() {
                Camera2Engine camera2Engine = Camera2Engine.this;
                if (camera2Engine.MyBillsEntityDataFactory(camera2Engine.O, f2)) {
                    Camera2Engine.this.initRecordTimeStamp();
                    if (z) {
                        Camera2Engine.this.VerifyPinStateManager$executeRiskChallenge$2$2.MyBillsEntityDataFactory(f, fArr, pointFArr);
                    }
                }
            }
        })));
    }

    protected final boolean MyBillsEntityDataFactory(CaptureRequest.Builder builder, float f) {
        if (this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            CameraCharacteristics.Key key = CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP;
            Object rational = new Rational(1, 1);
            Object obj = this.F.get(key);
            if (obj != null) {
                rational = obj;
            }
            builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(Math.round(this.getErrorConfigVersion * ((Rational) rational).floatValue())));
            return true;
        }
        this.getErrorConfigVersion = f;
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void MyBillsEntityDataFactory(boolean z) {
        this.FragmentBottomSheetPaymentSettingBinding = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void PlaceComponentResult(float f) {
        final float f2 = this.whenAvailable;
        this.whenAvailable = f;
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        StringBuilder sb = new StringBuilder();
        sb.append("preview fps (");
        sb.append(f);
        sb.append(")");
        this.SubSequence = cameraStateOrchestrator.PlaceComponentResult(sb.toString(), true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.17
            @Override // java.lang.Runnable
            public void run() {
                Camera2Engine camera2Engine = Camera2Engine.this;
                if (camera2Engine.BuiltInFictitiousFunctionClassFactory(camera2Engine.O, f2)) {
                    Camera2Engine.this.initRecordTimeStamp();
                }
            }
        })));
    }

    protected final boolean BuiltInFictitiousFunctionClassFactory(CaptureRequest.Builder builder, float f) {
        Object obj = new Range[0];
        Object obj2 = this.F.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (obj2 != null) {
            obj = obj2;
        }
        Range[] rangeArr = (Range[]) obj;
        if (this.whenAvailable == 0.0f) {
            for (Range range : rangeArr) {
                if (range.contains((Range) 30) || range.contains((Range) 24)) {
                    builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
                    return true;
                }
            }
        } else {
            this.whenAvailable = Math.min(this.whenAvailable, this.scheduleImpl.MyBillsEntityDataFactory());
            this.whenAvailable = Math.max(this.whenAvailable, this.scheduleImpl.PlaceComponentResult());
            for (Range range2 : rangeArr) {
                if (range2.contains((Range) Integer.valueOf(Math.round(this.whenAvailable)))) {
                    builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range2);
                    return true;
                }
            }
        }
        this.whenAvailable = f;
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void KClassImpl$Data$declaredNonStaticMembers$2(PictureFormat pictureFormat) {
        if (pictureFormat != this.isLayoutRequested) {
            this.isLayoutRequested = pictureFormat;
            CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
            StringBuilder sb = new StringBuilder();
            sb.append("picture format (");
            sb.append(pictureFormat);
            sb.append(")");
            cameraStateOrchestrator.PlaceComponentResult(sb.toString(), true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.18
                @Override // java.lang.Runnable
                public void run() {
                    Camera2Engine.this.V();
                }
            })));
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    protected final FrameManager KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return new ImageFrameManager(i);
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader imageReader) {
        Image image;
        A.KClassImpl$Data$declaredNonStaticMembers$2(0, "onImageAvailable:", "trying to acquire Image.");
        try {
            image = imageReader.acquireLatestImage();
        } catch (Exception unused) {
            image = null;
        }
        if (image != null) {
            if (this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory == CameraState.PREVIEW && !R()) {
                Frame BuiltInFictitiousFunctionClassFactory2 = KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(image, System.currentTimeMillis(), PrepareContext().KClassImpl$Data$declaredNonStaticMembers$2(Reference.SENSOR, Reference.OUTPUT, Axis.RELATIVE_TO_SENSOR));
                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                    A.KClassImpl$Data$declaredNonStaticMembers$2(0, "onImageAvailable:", "Image acquired, dispatching.");
                    this.VerifyPinStateManager$executeRiskChallenge$2$2.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2);
                    return;
                }
                A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onImageAvailable:", "Image acquired, but no free frames. DROPPING.");
                return;
            }
            A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onImageAvailable:", "Image acquired in wrong state. Closing it now.");
            image.close();
            return;
        }
        A.KClassImpl$Data$declaredNonStaticMembers$2(2, "onImageAvailable:", "failed to acquire Image!");
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void MyBillsEntityDataFactory(final int i) {
        if (this.initRecordTimeStamp == 0) {
            this.initRecordTimeStamp = 35;
        }
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        StringBuilder sb = new StringBuilder();
        sb.append("frame processing format (");
        sb.append(i);
        sb.append(")");
        cameraStateOrchestrator.PlaceComponentResult(sb.toString(), true, new CameraOrchestrator.AnonymousClass1(new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.20
            @Override // java.lang.Runnable
            public void run() {
                if (Camera2Engine.this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory.isAtLeast(CameraState.BIND) && Camera2Engine.this.R()) {
                    Camera2Engine.this.MyBillsEntityDataFactory(i);
                    return;
                }
                Camera2Engine camera2Engine = Camera2Engine.this;
                int i2 = i;
                if (i2 <= 0) {
                    i2 = 35;
                }
                camera2Engine.initRecordTimeStamp = i2;
                if (Camera2Engine.this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory.isAtLeast(CameraState.BIND)) {
                    Camera2Engine.this.W();
                }
            }
        }));
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$21  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass21 implements Runnable {
        final /* synthetic */ PointF BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ MeteringRegions MyBillsEntityDataFactory;
        final /* synthetic */ Gesture PlaceComponentResult;

        AnonymousClass21(Gesture gesture, PointF pointF, MeteringRegions meteringRegions) {
            this.PlaceComponentResult = gesture;
            this.BuiltInFictitiousFunctionClassFactory = pointF;
            this.MyBillsEntityDataFactory = meteringRegions;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Camera2Engine.this.scheduleImpl.lookAheadTest()) {
                Camera2Engine.this.VerifyPinStateManager$executeRiskChallenge$2$2.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
                final MeterAction BuiltInFictitiousFunctionClassFactory = Camera2Engine.this.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
                BaseAction KClassImpl$Data$declaredNonStaticMembers$2 = Actions.KClassImpl$Data$declaredNonStaticMembers$2(RangedBeacon.DEFAULT_MAX_TRACKING_AGE, BuiltInFictitiousFunctionClassFactory);
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(Camera2Engine.this);
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(new CompletionCallback() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.21.1
                    @Override // com.otaliastudios.cameraview.engine.action.CompletionCallback
                    public final void getAuthRequestContext() {
                        Camera2Engine.this.VerifyPinStateManager$executeRiskChallenge$2$2.KClassImpl$Data$declaredNonStaticMembers$2(AnonymousClass21.this.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(), AnonymousClass21.this.BuiltInFictitiousFunctionClassFactory);
                        Camera2Engine.this.getValueOfTouchPositionAbsolute.getAuthRequestContext("reset metering");
                        if (Camera2Engine.this.SummaryVoucherView$$ExternalSyntheticLambda1()) {
                            CameraStateOrchestrator cameraStateOrchestrator = Camera2Engine.this.getValueOfTouchPositionAbsolute;
                            cameraStateOrchestrator.KClassImpl$Data$declaredNonStaticMembers$2("reset metering", ((CameraBaseEngine) Camera2Engine.this).KClassImpl$Data$declaredNonStaticMembers$2, new CameraStateOrchestrator.AnonymousClass4(CameraState.PREVIEW, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.21.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Camera2Engine.PlaceComponentResult(Camera2Engine.this);
                                }
                            }));
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MeterAction BuiltInFictitiousFunctionClassFactory(MeteringRegions meteringRegions) {
        MeterAction meterAction = this.M;
        if (meterAction != null) {
            meterAction.getAuthRequestContext(this);
        }
        KClassImpl$Data$declaredNonStaticMembers$2(this.O);
        MeterAction meterAction2 = new MeterAction(this, meteringRegions, meteringRegions == null);
        this.M = meterAction2;
        return meterAction2;
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    public final void PlaceComponentResult(Action action) {
        if (this.PlaceComponentResult.contains(action)) {
            return;
        }
        this.PlaceComponentResult.add(action);
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    public final void getAuthRequestContext(Action action) {
        this.PlaceComponentResult.remove(action);
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    public final CameraCharacteristics DatabaseTableConfigUtil() {
        return this.F;
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    public final TotalCaptureResult GetContactSyncConfig() {
        return this.K;
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    public final CaptureRequest.Builder NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return this.O;
    }

    static /* synthetic */ void PlaceComponentResult(Camera2Engine camera2Engine, VideoResult.Stub stub) {
        if (!(camera2Engine.getCallingPid instanceof Full2VideoRecorder)) {
            StringBuilder sb = new StringBuilder();
            sb.append("doTakeVideo called, but video recorder is not a Full2VideoRecorder! ");
            sb.append(camera2Engine.getCallingPid);
            throw new IllegalStateException(sb.toString());
        }
        Full2VideoRecorder full2VideoRecorder = (Full2VideoRecorder) camera2Engine.getCallingPid;
        try {
            camera2Engine.NetworkUserEntityData$$ExternalSyntheticLambda2(3);
            camera2Engine.getAuthRequestContext(full2VideoRecorder.BuiltInFictitiousFunctionClassFactory);
            camera2Engine.KClassImpl$Data$declaredNonStaticMembers$2(true, 3);
            camera2Engine.getCallingPid.PlaceComponentResult(stub);
        } catch (CameraAccessException e) {
            super.PlaceComponentResult((VideoResult.Stub) null, e);
            CameraStateOrchestrator cameraStateOrchestrator = camera2Engine.getValueOfTouchPositionAbsolute;
            cameraStateOrchestrator.PlaceComponentResult("restore preview template", true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.BIND, new AnonymousClass10())));
            throw getAuthRequestContext(e);
        } catch (CameraException e2) {
            super.PlaceComponentResult((VideoResult.Stub) null, e2);
            CameraStateOrchestrator cameraStateOrchestrator2 = camera2Engine.getValueOfTouchPositionAbsolute;
            cameraStateOrchestrator2.PlaceComponentResult("restore preview template", true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.BIND, new AnonymousClass10())));
            throw e2;
        }
    }

    static /* synthetic */ void PlaceComponentResult(Camera2Engine camera2Engine) {
        Actions.getAuthRequestContext(new BaseAction() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.22
            @Override // com.otaliastudios.cameraview.engine.action.BaseAction
            public final void MyBillsEntityDataFactory(ActionHolder actionHolder) {
                super.MyBillsEntityDataFactory(actionHolder);
                Camera2Engine.this.getAuthRequestContext(actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2());
                CaptureRequest.Builder NetworkUserEntityData$$ExternalSyntheticLambda2 = actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2();
                CaptureRequest.Key key = CaptureRequest.CONTROL_AE_LOCK;
                Boolean bool = Boolean.FALSE;
                NetworkUserEntityData$$ExternalSyntheticLambda2.set(key, bool);
                actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AWB_LOCK, bool);
                actionHolder.PlaceComponentResult();
                MyBillsEntityDataFactory(Integer.MAX_VALUE);
            }
        }, new MeterResetAction()).PlaceComponentResult(camera2Engine);
    }

    static /* synthetic */ CameraException BuiltInFictitiousFunctionClassFactory(int i) {
        int i2 = 1;
        if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
            i2 = 0;
        }
        return new CameraException(i2);
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(boolean z, int i) {
        if ((this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory != CameraState.PREVIEW || R()) && z) {
            return;
        }
        try {
            this.R.setRepeatingRequest(this.O.build(), this.N, null);
        } catch (CameraAccessException e) {
            throw new CameraException(e, i);
        } catch (IllegalStateException e2) {
            CameraLogger cameraLogger = A;
            Object[] objArr = new Object[10];
            objArr[0] = "applyRepeatingRequestBuilder: session is invalid!";
            objArr[1] = e2;
            objArr[2] = "checkStarted:";
            objArr[3] = Boolean.valueOf(z);
            objArr[4] = "currentThread:";
            try {
                byte b = (byte) (MyBillsEntityDataFactory[15] - 1);
                byte b2 = MyBillsEntityDataFactory[15];
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = MyBillsEntityDataFactory[15];
                byte b4 = (byte) (b3 - 1);
                Object[] objArr3 = new Object[1];
                a(b3, b4, b4, objArr3);
                objArr[5] = ((Thread) cls.getMethod((String) objArr3[0], null).invoke(null, null)).getName();
                objArr[6] = "state:";
                objArr[7] = this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory;
                objArr[8] = "targetState:";
                objArr[9] = this.getValueOfTouchPositionAbsolute.getErrorConfigVersion;
                cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(3, objArr);
                throw new CameraException(3);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    public final void PlaceComponentResult() {
        KClassImpl$Data$declaredNonStaticMembers$2(true, 3);
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    public final void MyBillsEntityDataFactory(CaptureRequest.Builder builder) throws CameraAccessException {
        if (this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory != CameraState.PREVIEW || R()) {
            return;
        }
        this.R.capture(builder.build(), this.N, null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void BuiltInFictitiousFunctionClassFactory(final boolean z) {
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        StringBuilder sb = new StringBuilder();
        sb.append("has frame processors (");
        sb.append(z);
        sb.append(")");
        cameraStateOrchestrator.PlaceComponentResult(sb.toString(), true, new CameraOrchestrator.AnonymousClass1(new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera2Engine.19
            @Override // java.lang.Runnable
            public void run() {
                if (Camera2Engine.this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory.isAtLeast(CameraState.BIND) && Camera2Engine.this.R()) {
                    Camera2Engine.this.BuiltInFictitiousFunctionClassFactory(z);
                    return;
                }
                Camera2Engine.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = z;
                if (Camera2Engine.this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory.isAtLeast(CameraState.BIND)) {
                    Camera2Engine.this.W();
                }
            }
        }));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Gesture gesture, MeteringRegions meteringRegions, PointF pointF) {
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        StringBuilder sb = new StringBuilder();
        sb.append("autofocus (");
        sb.append(gesture);
        sb.append(")");
        cameraStateOrchestrator.PlaceComponentResult(sb.toString(), true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.PREVIEW, new AnonymousClass21(gesture, pointF, meteringRegions))));
    }
}
