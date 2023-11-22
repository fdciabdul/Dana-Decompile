package com.otaliastudios.cameraview.video;

import android.opengl.GLSurfaceView;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.engine.CameraEngine;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.overlay.Overlay;
import com.otaliastudios.cameraview.overlay.OverlayDrawer;
import com.otaliastudios.cameraview.preview.GlCameraPreview;
import com.otaliastudios.cameraview.preview.RendererFrameCallback;
import com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine;

/* loaded from: classes8.dex */
public class SnapshotVideoRecorder extends VideoRecorder implements RendererFrameCallback, MediaEncoderEngine.Listener {
    private static final CameraLogger BuiltInFictitiousFunctionClassFactory = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("SnapshotVideoRecorder");
    private OverlayDrawer DatabaseTableConfigUtil;
    private Filter KClassImpl$Data$declaredNonStaticMembers$2;
    private MediaEncoderEngine MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1;
    private GlCameraPreview NetworkUserEntityData$$ExternalSyntheticLambda2;
    private int PlaceComponentResult;
    private int getAuthRequestContext;
    private final Object getErrorConfigVersion;
    private int initRecordTimeStamp;
    private Overlay moveToNextValue;

    public SnapshotVideoRecorder(CameraEngine cameraEngine, GlCameraPreview glCameraPreview, Overlay overlay, int i) {
        super(cameraEngine);
        this.getErrorConfigVersion = new Object();
        this.PlaceComponentResult = 1;
        this.getAuthRequestContext = 1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = glCameraPreview;
        this.moveToNextValue = overlay;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = overlay != null && overlay.drawsOn(Overlay.Target.VIDEO_SNAPSHOT);
        this.initRecordTimeStamp = i;
    }

    @Override // com.otaliastudios.cameraview.video.VideoRecorder
    protected final void KClassImpl$Data$declaredNonStaticMembers$2() {
        GlCameraPreview glCameraPreview = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        ((GLSurfaceView) glCameraPreview.lookAheadTest).queueEvent(new GlCameraPreview.AnonymousClass2(this));
        this.getAuthRequestContext = 0;
        scheduleImpl();
    }

    @Override // com.otaliastudios.cameraview.video.VideoRecorder
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        if (!z) {
            this.getAuthRequestContext = 1;
            return;
        }
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "Stopping the encoder engine from isCameraShutdown.");
        this.getAuthRequestContext = 1;
        this.PlaceComponentResult = 1;
        synchronized (this.getErrorConfigVersion) {
            MediaEncoderEngine mediaEncoderEngine = this.MyBillsEntityDataFactory;
            if (mediaEncoderEngine != null) {
                mediaEncoderEngine.MyBillsEntityDataFactory();
                this.MyBillsEntityDataFactory = null;
            }
        }
    }

    @Override // com.otaliastudios.cameraview.preview.RendererFrameCallback
    public final void getAuthRequestContext(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = i;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            this.DatabaseTableConfigUtil = new OverlayDrawer(this.moveToNextValue, this.scheduleImpl.DatabaseTableConfigUtil);
        }
    }

    @Override // com.otaliastudios.cameraview.preview.RendererFrameCallback
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Filter filter) {
        Filter PlaceComponentResult = filter.PlaceComponentResult();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult;
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory, this.scheduleImpl.DatabaseTableConfigUtil.getAuthRequestContext);
        synchronized (this.getErrorConfigVersion) {
            MediaEncoderEngine mediaEncoderEngine = this.MyBillsEntityDataFactory;
            if (mediaEncoderEngine != null) {
                mediaEncoderEngine.PlaceComponentResult("filter", this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:240:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x024f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.otaliastudios.cameraview.preview.RendererFrameCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory(android.graphics.SurfaceTexture r25, float r26, float r27) {
        /*
            Method dump skipped, instructions count: 805
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.video.SnapshotVideoRecorder.BuiltInFictitiousFunctionClassFactory(android.graphics.SurfaceTexture, float, float):void");
    }

    /* renamed from: com.otaliastudios.cameraview.video.SnapshotVideoRecorder$1 */
    /* loaded from: classes8.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[VideoCodec.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[VideoCodec.H_263.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[VideoCodec.H_264.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PlaceComponentResult[VideoCodec.DEVICE_DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Listener
    public final void MyBillsEntityDataFactory() {
        getAuthRequestContext();
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Listener
    public final void PlaceComponentResult(int i, Exception exc) {
        if (exc != null) {
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(3, "Error onEncodingEnd", exc);
            this.scheduleImpl = null;
            this.lookAheadTest = exc;
        } else if (i == 1) {
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "onEncodingEnd because of max duration.");
            this.scheduleImpl.getAuthRequestContext = 2;
        } else if (i == 2) {
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "onEncodingEnd because of max size.");
            this.scheduleImpl.getAuthRequestContext = 1;
        } else {
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "onEncodingEnd because of user.");
        }
        this.PlaceComponentResult = 1;
        this.getAuthRequestContext = 1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda2.remove(this);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
        OverlayDrawer overlayDrawer = this.DatabaseTableConfigUtil;
        if (overlayDrawer != null) {
            overlayDrawer.PlaceComponentResult();
            this.DatabaseTableConfigUtil = null;
        }
        synchronized (this.getErrorConfigVersion) {
            this.MyBillsEntityDataFactory = null;
        }
        PlaceComponentResult();
    }
}
