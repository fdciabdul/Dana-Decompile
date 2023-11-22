package com.otaliastudios.cameraview.engine;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.location.Location;
import android.os.Build;
import android.view.SurfaceHolder;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraException;
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
import com.otaliastudios.cameraview.engine.mappers.Camera1Mapper;
import com.otaliastudios.cameraview.engine.metering.Camera1MeteringTransform;
import com.otaliastudios.cameraview.engine.offset.Angles;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.options.Camera1Options;
import com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator;
import com.otaliastudios.cameraview.frame.ByteBufferFrameManager;
import com.otaliastudios.cameraview.frame.Frame;
import com.otaliastudios.cameraview.frame.FrameManager;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.internal.utils.CropHelper;
import com.otaliastudios.cameraview.metering.MeteringRegions;
import com.otaliastudios.cameraview.picture.Full1PictureRecorder;
import com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder;
import com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.preview.GlCameraPreview;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;
import com.otaliastudios.cameraview.video.Full1VideoRecorder;
import com.otaliastudios.cameraview.video.SnapshotVideoRecorder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class Camera1Engine extends CameraBaseEngine implements Camera.PreviewCallback, Camera.ErrorCallback, ByteBufferFrameManager.BufferCallback {
    private Camera BuiltInFictitiousFunctionClassFactory;
    private final Camera1Mapper MyBillsEntityDataFactory;
    int PlaceComponentResult;

    public Camera1Engine(CameraEngine.Callback callback) {
        super(callback);
        this.MyBillsEntityDataFactory = Camera1Mapper.PlaceComponentResult();
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i, Camera camera) {
        throw new CameraException(new RuntimeException(A.KClassImpl$Data$declaredNonStaticMembers$2(3, "Internal Camera1 error.", Integer.valueOf(i))), (i == 1 || i == 2 || i == 100) ? 3 : 0);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    protected final List<Size> MyBillsEntityDataFactory() {
        List<Camera.Size> supportedPreviewSizes = this.BuiltInFictitiousFunctionClassFactory.getParameters().getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList(supportedPreviewSizes.size());
        for (Camera.Size size : supportedPreviewSizes) {
            Size size2 = new Size(size.width, size.height);
            if (!arrayList.contains(size2)) {
                arrayList.add(size2);
            }
        }
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "getPreviewStreamAvailableSizes:", arrayList);
        return arrayList;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    protected final List<Size> getAuthRequestContext() {
        return Collections.singletonList(this.readMicros);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    protected final void BuiltInFictitiousFunctionClassFactory() {
        T();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final boolean PlaceComponentResult(Facing facing) {
        int MyBillsEntityDataFactory = Camera1Mapper.MyBillsEntityDataFactory(facing);
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "collectCameraInfo", "Facing:", facing, "Internal:", Integer.valueOf(MyBillsEntityDataFactory), "Cameras:", Integer.valueOf(Camera.getNumberOfCameras()));
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == MyBillsEntityDataFactory) {
                PrepareContext().MyBillsEntityDataFactory(facing, cameraInfo.orientation);
                this.PlaceComponentResult = i;
                return true;
            }
        }
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    protected final Task<CameraOptions> lookAheadTest() {
        try {
            Camera open = Camera.open(this.PlaceComponentResult);
            this.BuiltInFictitiousFunctionClassFactory = open;
            open.setErrorCallback(this);
            A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStartEngine:", "Applying default parameters.");
            Camera.Parameters parameters = this.BuiltInFictitiousFunctionClassFactory.getParameters();
            this.scheduleImpl = new Camera1Options(parameters, this.PlaceComponentResult, PrepareContext().PlaceComponentResult(Reference.SENSOR, Reference.VIEW));
            parameters.setRecordingHint(VerifyPinStateManager$executeRiskChallenge$2$1() == Mode.VIDEO);
            getAuthRequestContext(parameters);
            getAuthRequestContext(parameters, Flash.OFF);
            MyBillsEntityDataFactory(parameters);
            PlaceComponentResult(parameters, WhiteBalance.AUTO);
            MyBillsEntityDataFactory(parameters, Hdr.OFF);
            BuiltInFictitiousFunctionClassFactory(parameters, 0.0f);
            KClassImpl$Data$declaredNonStaticMembers$2(parameters, 0.0f);
            scheduleImpl(this.FragmentBottomSheetPaymentSettingBinding);
            MyBillsEntityDataFactory(parameters, 0.0f);
            this.BuiltInFictitiousFunctionClassFactory.setParameters(parameters);
            this.BuiltInFictitiousFunctionClassFactory.setDisplayOrientation(PrepareContext().KClassImpl$Data$declaredNonStaticMembers$2(Reference.SENSOR, Reference.VIEW, Axis.ABSOLUTE));
            A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStartEngine:", "Ended");
            return Tasks.forResult(this.scheduleImpl);
        } catch (Exception e) {
            A.KClassImpl$Data$declaredNonStaticMembers$2(3, "onStartEngine:", "Failed to connect. Maybe in use by another app?");
            throw new CameraException(e, 1);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    protected final Task<Void> NetworkUserEntityData$$ExternalSyntheticLambda0() {
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStartBind:", "Started");
        try {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda4.KClassImpl$Data$declaredNonStaticMembers$2() == SurfaceHolder.class) {
                this.BuiltInFictitiousFunctionClassFactory.setPreviewDisplay((SurfaceHolder) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getAuthRequestContext());
            } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda4.KClassImpl$Data$declaredNonStaticMembers$2() == SurfaceTexture.class) {
                this.BuiltInFictitiousFunctionClassFactory.setPreviewTexture((SurfaceTexture) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getAuthRequestContext());
            } else {
                throw new RuntimeException("Unknown CameraPreview output class.");
            }
            this.lookAheadTest = NetworkUserEntityData$$ExternalSyntheticLambda7();
            this.readMicros = newProxyInstance();
            return Tasks.forResult(null);
        } catch (IOException e) {
            A.KClassImpl$Data$declaredNonStaticMembers$2(3, "onStartBind:", "Failed to bind.", e);
            throw new CameraException(e, 2);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    protected final Task<Void> getErrorConfigVersion() {
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStartPreview", "Dispatching onCameraPreviewStreamSizeChanged.");
        this.VerifyPinStateManager$executeRiskChallenge$2$2.lookAheadTest();
        Size BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(Reference.VIEW);
        if (BuiltInFictitiousFunctionClassFactory == null) {
            throw new IllegalStateException("previewStreamSize should not be null at this point.");
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda4.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext);
        Camera.Parameters parameters = this.BuiltInFictitiousFunctionClassFactory.getParameters();
        parameters.setPreviewFormat(17);
        parameters.setPreviewSize(this.readMicros.BuiltInFictitiousFunctionClassFactory, this.readMicros.getAuthRequestContext);
        if (VerifyPinStateManager$executeRiskChallenge$2$1() == Mode.PICTURE) {
            parameters.setPictureSize(this.lookAheadTest.BuiltInFictitiousFunctionClassFactory, this.lookAheadTest.getAuthRequestContext);
        } else {
            Size KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(Mode.PICTURE);
            parameters.setPictureSize(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext);
        }
        this.BuiltInFictitiousFunctionClassFactory.setParameters(parameters);
        this.BuiltInFictitiousFunctionClassFactory.setPreviewCallbackWithBuffer(null);
        this.BuiltInFictitiousFunctionClassFactory.setPreviewCallbackWithBuffer(this);
        ((ByteBufferFrameManager) super.KClassImpl$Data$declaredNonStaticMembers$2()).PlaceComponentResult(17, this.readMicros);
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStartPreview", "Starting preview with startPreview().");
        try {
            this.BuiltInFictitiousFunctionClassFactory.startPreview();
            A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStartPreview", "Started preview.");
            return Tasks.forResult(null);
        } catch (Exception e) {
            A.KClassImpl$Data$declaredNonStaticMembers$2(3, "onStartPreview", "Failed to start preview.", e);
            throw new CameraException(e, 2);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    protected final Task<Void> NetworkUserEntityData$$ExternalSyntheticLambda1() {
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStopPreview:", "Started.");
        if (this.getCallingPid != null) {
            this.getCallingPid.MyBillsEntityDataFactory(true);
            this.getCallingPid = null;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = null;
        ((ByteBufferFrameManager) super.KClassImpl$Data$declaredNonStaticMembers$2()).MyBillsEntityDataFactory();
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStopPreview:", "Releasing preview buffers.");
        this.BuiltInFictitiousFunctionClassFactory.setPreviewCallbackWithBuffer(null);
        try {
            A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStopPreview:", "Stopping preview.");
            this.BuiltInFictitiousFunctionClassFactory.stopPreview();
            A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStopPreview:", "Stopped preview.");
        } catch (Exception e) {
            A.KClassImpl$Data$declaredNonStaticMembers$2(3, "stopPreview", "Could not stop preview", e);
        }
        return Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    protected final Task<Void> scheduleImpl() {
        this.readMicros = null;
        this.lookAheadTest = null;
        try {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda4.KClassImpl$Data$declaredNonStaticMembers$2() == SurfaceHolder.class) {
                this.BuiltInFictitiousFunctionClassFactory.setPreviewDisplay(null);
            } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda4.KClassImpl$Data$declaredNonStaticMembers$2() == SurfaceTexture.class) {
                this.BuiltInFictitiousFunctionClassFactory.setPreviewTexture(null);
            } else {
                throw new RuntimeException("Unknown CameraPreview output class.");
            }
        } catch (IOException e) {
            A.KClassImpl$Data$declaredNonStaticMembers$2(3, "onStopBind", "Could not release surface", e);
        }
        return Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    protected final Task<Void> moveToNextValue() {
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStopEngine:", "About to clean up.");
        this.getValueOfTouchPositionAbsolute.getAuthRequestContext("focus reset");
        this.getValueOfTouchPositionAbsolute.getAuthRequestContext("focus end");
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            try {
                A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStopEngine:", "Clean up.", "Releasing camera.");
                this.BuiltInFictitiousFunctionClassFactory.release();
                A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStopEngine:", "Clean up.", "Released camera.");
            } catch (Exception e) {
                A.KClassImpl$Data$declaredNonStaticMembers$2(2, "onStopEngine:", "Clean up.", "Exception while releasing camera.", e);
            }
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.scheduleImpl = null;
        }
        this.getCallingPid = null;
        this.scheduleImpl = null;
        this.BuiltInFictitiousFunctionClassFactory = null;
        A.KClassImpl$Data$declaredNonStaticMembers$2(2, "onStopEngine:", "Clean up.", "Returning.");
        return Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    protected final void getAuthRequestContext(PictureResult.Stub stub, boolean z) {
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onTakePicture:", "executing.");
        stub.NetworkUserEntityData$$ExternalSyntheticLambda0 = PrepareContext().KClassImpl$Data$declaredNonStaticMembers$2(Reference.SENSOR, Reference.OUTPUT, Axis.RELATIVE_TO_SENSOR);
        stub.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2(Reference.OUTPUT);
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new Full1PictureRecorder(stub, this, this.BuiltInFictitiousFunctionClassFactory);
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.PlaceComponentResult();
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onTakePicture:", "executed.");
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    protected final void MyBillsEntityDataFactory(PictureResult.Stub stub, AspectRatio aspectRatio, boolean z) {
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onTakePictureSnapshot:", "executing.");
        stub.scheduleImpl = getAuthRequestContext(Reference.OUTPUT);
        stub.NetworkUserEntityData$$ExternalSyntheticLambda0 = PrepareContext().KClassImpl$Data$declaredNonStaticMembers$2(Reference.SENSOR, Reference.OUTPUT, Axis.RELATIVE_TO_SENSOR);
        if ((this.NetworkUserEntityData$$ExternalSyntheticLambda4 instanceof GlCameraPreview) && Build.VERSION.SDK_INT >= 19) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new SnapshotGlPictureRecorder(stub, this, (GlCameraPreview) this.NetworkUserEntityData$$ExternalSyntheticLambda4, aspectRatio);
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new Snapshot1PictureRecorder(stub, this, this.BuiltInFictitiousFunctionClassFactory, aspectRatio);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.PlaceComponentResult();
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onTakePictureSnapshot:", "executed.");
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    protected final void PlaceComponentResult(VideoResult.Stub stub) {
        Size size;
        stub.initRecordTimeStamp = PrepareContext().KClassImpl$Data$declaredNonStaticMembers$2(Reference.SENSOR, Reference.OUTPUT, Axis.RELATIVE_TO_SENSOR);
        if (!PrepareContext().PlaceComponentResult(Reference.SENSOR, Reference.OUTPUT)) {
            size = this.lookAheadTest;
        } else {
            Size size2 = this.lookAheadTest;
            size = new Size(size2.getAuthRequestContext, size2.BuiltInFictitiousFunctionClassFactory);
        }
        stub.DatabaseTableConfigUtil = size;
        try {
            this.BuiltInFictitiousFunctionClassFactory.unlock();
            this.getCallingPid = new Full1VideoRecorder(this, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
            this.getCallingPid.PlaceComponentResult(stub);
        } catch (Exception e) {
            super.PlaceComponentResult((VideoResult.Stub) null, e);
            this.BuiltInFictitiousFunctionClassFactory.lock();
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    protected final void getAuthRequestContext(VideoResult.Stub stub, AspectRatio aspectRatio) {
        if (!(this.NetworkUserEntityData$$ExternalSyntheticLambda4 instanceof GlCameraPreview)) {
            throw new IllegalStateException("Video snapshots are only supported with GL_SURFACE.");
        }
        if (Build.VERSION.SDK_INT < 18) {
            throw new IllegalStateException("Video snapshots are only supported on API 18+.");
        }
        GlCameraPreview glCameraPreview = (GlCameraPreview) this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        Size authRequestContext = getAuthRequestContext(Reference.OUTPUT);
        if (authRequestContext == null) {
            throw new IllegalStateException("outputSize should not be null.");
        }
        Rect BuiltInFictitiousFunctionClassFactory = CropHelper.BuiltInFictitiousFunctionClassFactory(authRequestContext, aspectRatio);
        stub.DatabaseTableConfigUtil = new Size(BuiltInFictitiousFunctionClassFactory.width(), BuiltInFictitiousFunctionClassFactory.height());
        stub.initRecordTimeStamp = PrepareContext().KClassImpl$Data$declaredNonStaticMembers$2(Reference.VIEW, Reference.OUTPUT, Axis.ABSOLUTE);
        stub.NetworkUserEntityData$$ExternalSyntheticLambda1 = Math.round(this.whenAvailable);
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onTakeVideoSnapshot", "rotation:", Integer.valueOf(stub.initRecordTimeStamp), "size:", stub.DatabaseTableConfigUtil);
        this.getCallingPid = new SnapshotVideoRecorder(this, glCameraPreview, B(), stub.initRecordTimeStamp);
        this.getCallingPid.PlaceComponentResult(stub);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine, com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener
    public final void PlaceComponentResult(VideoResult.Stub stub, Exception exc) {
        super.PlaceComponentResult(stub, exc);
        if (stub == null) {
            this.BuiltInFictitiousFunctionClassFactory.lock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAuthRequestContext(Camera.Parameters parameters) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (VerifyPinStateManager$executeRiskChallenge$2$1() == Mode.VIDEO && supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        } else if (supportedFocusModes.contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
        } else if (supportedFocusModes.contains("infinity")) {
            parameters.setFocusMode("infinity");
        } else if (supportedFocusModes.contains("fixed")) {
            parameters.setFocusMode("fixed");
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void BuiltInFictitiousFunctionClassFactory(Flash flash) {
        final Flash flash2 = this.moveToNextValue;
        this.moveToNextValue = flash;
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        StringBuilder sb = new StringBuilder();
        sb.append("flash (");
        sb.append(flash);
        sb.append(")");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = cameraStateOrchestrator.PlaceComponentResult(sb.toString(), true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera1Engine.1
            @Override // java.lang.Runnable
            public void run() {
                Camera.Parameters parameters = Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.getParameters();
                if (Camera1Engine.this.getAuthRequestContext(parameters, flash2)) {
                    Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.setParameters(parameters);
                }
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAuthRequestContext(Camera.Parameters parameters, Flash flash) {
        if (this.scheduleImpl.PlaceComponentResult(this.moveToNextValue)) {
            parameters.setFlashMode(Camera1Mapper.PlaceComponentResult(this.moveToNextValue));
            return true;
        }
        this.moveToNextValue = flash;
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void getAuthRequestContext(Location location) {
        final Location location2 = this.newProxyInstance;
        this.newProxyInstance = location;
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = cameraStateOrchestrator.PlaceComponentResult("location", true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera1Engine.2
            @Override // java.lang.Runnable
            public void run() {
                Camera.Parameters parameters = Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.getParameters();
                if (Camera1Engine.this.MyBillsEntityDataFactory(parameters)) {
                    Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.setParameters(parameters);
                }
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MyBillsEntityDataFactory(Camera.Parameters parameters) {
        if (this.newProxyInstance != null) {
            parameters.setGpsLatitude(this.newProxyInstance.getLatitude());
            parameters.setGpsLongitude(this.newProxyInstance.getLongitude());
            parameters.setGpsAltitude(this.newProxyInstance.getAltitude());
            parameters.setGpsTimestamp(this.newProxyInstance.getTime());
            parameters.setGpsProcessingMethod(this.newProxyInstance.getProvider());
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
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = cameraStateOrchestrator.PlaceComponentResult(sb.toString(), true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera1Engine.3
            @Override // java.lang.Runnable
            public void run() {
                Camera.Parameters parameters = Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.getParameters();
                if (Camera1Engine.this.PlaceComponentResult(parameters, whiteBalance2)) {
                    Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.setParameters(parameters);
                }
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean PlaceComponentResult(Camera.Parameters parameters, WhiteBalance whiteBalance) {
        if (this.scheduleImpl.PlaceComponentResult(this.VerifyPinStateManager$executeRiskChallenge$2$1)) {
            parameters.setWhiteBalance(Camera1Mapper.BuiltInFictitiousFunctionClassFactory(this.VerifyPinStateManager$executeRiskChallenge$2$1));
            parameters.remove("auto-whitebalance-lock");
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
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = cameraStateOrchestrator.PlaceComponentResult(sb.toString(), true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera1Engine.4
            @Override // java.lang.Runnable
            public void run() {
                Camera.Parameters parameters = Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.getParameters();
                if (Camera1Engine.this.MyBillsEntityDataFactory(parameters, hdr2)) {
                    Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.setParameters(parameters);
                }
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MyBillsEntityDataFactory(Camera.Parameters parameters, Hdr hdr) {
        if (this.scheduleImpl.PlaceComponentResult(this.DatabaseTableConfigUtil)) {
            parameters.setSceneMode(Camera1Mapper.getAuthRequestContext(this.DatabaseTableConfigUtil));
            return true;
        }
        this.DatabaseTableConfigUtil = hdr;
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void PlaceComponentResult(float f, final PointF[] pointFArr, final boolean z) {
        final float f2 = this.B;
        this.B = f;
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        StringBuilder sb = new StringBuilder();
        sb.append("zoom (");
        sb.append(f);
        sb.append(")");
        this.C = cameraStateOrchestrator.PlaceComponentResult(sb.toString(), true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera1Engine.5
            @Override // java.lang.Runnable
            public void run() {
                Camera.Parameters parameters = Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.getParameters();
                if (Camera1Engine.this.BuiltInFictitiousFunctionClassFactory(parameters, f2)) {
                    Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.setParameters(parameters);
                    if (z) {
                        Camera1Engine.this.VerifyPinStateManager$executeRiskChallenge$2$2.PlaceComponentResult(Camera1Engine.this.B, pointFArr);
                    }
                }
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BuiltInFictitiousFunctionClassFactory(Camera.Parameters parameters, float f) {
        if (this.scheduleImpl.scheduleImpl()) {
            parameters.setZoom((int) (this.B * parameters.getMaxZoom()));
            this.BuiltInFictitiousFunctionClassFactory.setParameters(parameters);
            return true;
        }
        this.B = f;
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void getAuthRequestContext(float f, final float[] fArr, final PointF[] pointFArr, final boolean z) {
        final float f2 = this.getErrorConfigVersion;
        this.getErrorConfigVersion = f;
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        StringBuilder sb = new StringBuilder();
        sb.append("exposure correction (");
        sb.append(f);
        sb.append(")");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = cameraStateOrchestrator.PlaceComponentResult(sb.toString(), true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera1Engine.6
            @Override // java.lang.Runnable
            public void run() {
                Camera.Parameters parameters = Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.getParameters();
                if (Camera1Engine.this.KClassImpl$Data$declaredNonStaticMembers$2(parameters, f2)) {
                    Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.setParameters(parameters);
                    if (z) {
                        Camera1Engine.this.VerifyPinStateManager$executeRiskChallenge$2$2.MyBillsEntityDataFactory(Camera1Engine.this.getErrorConfigVersion, fArr, pointFArr);
                    }
                }
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2(Camera.Parameters parameters, float f) {
        if (this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            float KClassImpl$Data$declaredNonStaticMembers$2 = this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2();
            float authRequestContext = this.scheduleImpl.getAuthRequestContext();
            float f2 = this.getErrorConfigVersion;
            if (f2 < authRequestContext) {
                KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext;
            } else if (f2 <= KClassImpl$Data$declaredNonStaticMembers$2) {
                KClassImpl$Data$declaredNonStaticMembers$2 = f2;
            }
            this.getErrorConfigVersion = KClassImpl$Data$declaredNonStaticMembers$2;
            parameters.setExposureCompensation((int) (this.getErrorConfigVersion / parameters.getExposureCompensationStep()));
            return true;
        }
        this.getErrorConfigVersion = f;
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void MyBillsEntityDataFactory(boolean z) {
        final boolean z2 = this.FragmentBottomSheetPaymentSettingBinding;
        this.FragmentBottomSheetPaymentSettingBinding = z;
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        StringBuilder sb = new StringBuilder();
        sb.append("play sounds (");
        sb.append(z);
        sb.append(")");
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = cameraStateOrchestrator.PlaceComponentResult(sb.toString(), true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera1Engine.7
            @Override // java.lang.Runnable
            public void run() {
                Camera1Engine.this.scheduleImpl(z2);
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean scheduleImpl(boolean z) {
        if (Build.VERSION.SDK_INT >= 17) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(this.PlaceComponentResult, cameraInfo);
            if (cameraInfo.canDisableShutterSound) {
                try {
                    return this.BuiltInFictitiousFunctionClassFactory.enableShutterSound(this.FragmentBottomSheetPaymentSettingBinding);
                } catch (RuntimeException unused) {
                    return false;
                }
            }
        }
        if (this.FragmentBottomSheetPaymentSettingBinding) {
            return true;
        }
        this.FragmentBottomSheetPaymentSettingBinding = z;
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void PlaceComponentResult(final float f) {
        this.whenAvailable = f;
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        StringBuilder sb = new StringBuilder();
        sb.append("preview fps (");
        sb.append(f);
        sb.append(")");
        this.SubSequence = cameraStateOrchestrator.PlaceComponentResult(sb.toString(), true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera1Engine.8
            @Override // java.lang.Runnable
            public void run() {
                Camera.Parameters parameters = Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.getParameters();
                if (Camera1Engine.this.MyBillsEntityDataFactory(parameters, f)) {
                    Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.setParameters(parameters);
                }
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MyBillsEntityDataFactory(Camera.Parameters parameters, float f) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (this.whenAvailable == 0.0f) {
            for (int[] iArr : supportedPreviewFpsRange) {
                int i = iArr[0];
                float f2 = i / 1000.0f;
                int i2 = iArr[1];
                float f3 = i2 / 1000.0f;
                if ((f2 <= 30.0f && 30.0f <= f3) || (f2 <= 24.0f && 24.0f <= f3)) {
                    parameters.setPreviewFpsRange(i, i2);
                    return true;
                }
            }
        } else {
            this.whenAvailable = Math.min(this.whenAvailable, this.scheduleImpl.MyBillsEntityDataFactory());
            this.whenAvailable = Math.max(this.whenAvailable, this.scheduleImpl.PlaceComponentResult());
            for (int[] iArr2 : supportedPreviewFpsRange) {
                float f4 = iArr2[0] / 1000.0f;
                float f5 = iArr2[1] / 1000.0f;
                float round = Math.round(this.whenAvailable);
                if (f4 <= round && round <= f5) {
                    parameters.setPreviewFpsRange(iArr2[0], iArr2[1]);
                    return true;
                }
            }
        }
        this.whenAvailable = f;
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void KClassImpl$Data$declaredNonStaticMembers$2(PictureFormat pictureFormat) {
        if (pictureFormat != PictureFormat.JPEG) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported picture format: ");
            sb.append(pictureFormat);
            throw new UnsupportedOperationException(sb.toString());
        }
        this.isLayoutRequested = pictureFormat;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    protected final FrameManager KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return new ByteBufferFrameManager(i, this);
    }

    public final ByteBufferFrameManager PlaceComponentResult() {
        return (ByteBufferFrameManager) super.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void BuiltInFictitiousFunctionClassFactory(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = z;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void MyBillsEntityDataFactory(int i) {
        this.initRecordTimeStamp = 17;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (bArr == null) {
            return;
        }
        Frame BuiltInFictitiousFunctionClassFactory = ((ByteBufferFrameManager) super.KClassImpl$Data$declaredNonStaticMembers$2()).BuiltInFictitiousFunctionClassFactory(bArr, System.currentTimeMillis(), PrepareContext().KClassImpl$Data$declaredNonStaticMembers$2(Reference.SENSOR, Reference.OUTPUT, Axis.RELATIVE_TO_SENSOR));
        if (BuiltInFictitiousFunctionClassFactory != null) {
            this.VerifyPinStateManager$executeRiskChallenge$2$2.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera1Engine$9  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass9 implements Runnable {
        final /* synthetic */ Gesture BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ PointF KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ MeteringRegions MyBillsEntityDataFactory;

        AnonymousClass9(MeteringRegions meteringRegions, Gesture gesture, PointF pointF) {
            this.MyBillsEntityDataFactory = meteringRegions;
            this.BuiltInFictitiousFunctionClassFactory = gesture;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = pointF;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Camera1Engine.this.scheduleImpl.lookAheadTest()) {
                Angles angles = Camera1Engine.this.getAuthRequestContext;
                CameraPreview onBoardingScenario = Camera1Engine.this.getOnBoardingScenario();
                Camera1MeteringTransform camera1MeteringTransform = new Camera1MeteringTransform(angles, new Size(onBoardingScenario.getErrorConfigVersion, onBoardingScenario.scheduleImpl));
                MeteringRegions authRequestContext = this.MyBillsEntityDataFactory.getAuthRequestContext(camera1MeteringTransform);
                Camera.Parameters parameters = Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.getParameters();
                int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                if (maxNumFocusAreas > 0) {
                    parameters.setFocusAreas(authRequestContext.PlaceComponentResult(maxNumFocusAreas, camera1MeteringTransform));
                }
                if (maxNumMeteringAreas > 0) {
                    parameters.setMeteringAreas(authRequestContext.PlaceComponentResult(maxNumMeteringAreas, camera1MeteringTransform));
                }
                parameters.setFocusMode("auto");
                Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.setParameters(parameters);
                Camera1Engine.this.VerifyPinStateManager$executeRiskChallenge$2$2.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
                Camera1Engine.this.getValueOfTouchPositionAbsolute.getAuthRequestContext("focus end");
                Camera1Engine.this.getValueOfTouchPositionAbsolute.KClassImpl$Data$declaredNonStaticMembers$2("focus end", 2500L, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera1Engine.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Camera1Engine.this.VerifyPinStateManager$executeRiskChallenge$2$2.KClassImpl$Data$declaredNonStaticMembers$2(AnonymousClass9.this.BuiltInFictitiousFunctionClassFactory, false, AnonymousClass9.this.KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                });
                try {
                    Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.autoFocus(new Camera.AutoFocusCallback() { // from class: com.otaliastudios.cameraview.engine.Camera1Engine.9.2
                        @Override // android.hardware.Camera.AutoFocusCallback
                        public void onAutoFocus(boolean z, Camera camera) {
                            Camera1Engine.this.getValueOfTouchPositionAbsolute.getAuthRequestContext("focus end");
                            Camera1Engine.this.getValueOfTouchPositionAbsolute.getAuthRequestContext("focus reset");
                            Camera1Engine.this.VerifyPinStateManager$executeRiskChallenge$2$2.KClassImpl$Data$declaredNonStaticMembers$2(AnonymousClass9.this.BuiltInFictitiousFunctionClassFactory, z, AnonymousClass9.this.KClassImpl$Data$declaredNonStaticMembers$2);
                            if (Camera1Engine.this.SummaryVoucherView$$ExternalSyntheticLambda1()) {
                                CameraStateOrchestrator cameraStateOrchestrator = Camera1Engine.this.getValueOfTouchPositionAbsolute;
                                cameraStateOrchestrator.KClassImpl$Data$declaredNonStaticMembers$2("focus reset", ((CameraBaseEngine) Camera1Engine.this).KClassImpl$Data$declaredNonStaticMembers$2, new CameraStateOrchestrator.AnonymousClass4(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.Camera1Engine.9.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.cancelAutoFocus();
                                        Camera.Parameters parameters2 = Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.getParameters();
                                        int maxNumFocusAreas2 = parameters2.getMaxNumFocusAreas();
                                        int maxNumMeteringAreas2 = parameters2.getMaxNumMeteringAreas();
                                        if (maxNumFocusAreas2 > 0) {
                                            parameters2.setFocusAreas(null);
                                        }
                                        if (maxNumMeteringAreas2 > 0) {
                                            parameters2.setMeteringAreas(null);
                                        }
                                        Camera1Engine.this.getAuthRequestContext(parameters2);
                                        Camera1Engine.this.BuiltInFictitiousFunctionClassFactory.setParameters(parameters2);
                                    }
                                }));
                            }
                        }
                    });
                } catch (RuntimeException e) {
                    CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(3, "startAutoFocus:", "Error calling autoFocus", e);
                }
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    public final /* bridge */ /* synthetic */ FrameManager KClassImpl$Data$declaredNonStaticMembers$2() {
        return (ByteBufferFrameManager) super.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // com.otaliastudios.cameraview.frame.ByteBufferFrameManager.BufferCallback
    public final void BuiltInFictitiousFunctionClassFactory(byte[] bArr) {
        if (this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory.isAtLeast(CameraState.ENGINE) && this.getValueOfTouchPositionAbsolute.getErrorConfigVersion.isAtLeast(CameraState.ENGINE)) {
            this.BuiltInFictitiousFunctionClassFactory.addCallbackBuffer(bArr);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Gesture gesture, MeteringRegions meteringRegions, PointF pointF) {
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        cameraStateOrchestrator.PlaceComponentResult("auto focus", true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.BIND, new AnonymousClass9(meteringRegions, gesture, pointF))));
    }
}
