package com.otaliastudios.cameraview.picture;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.engine.CameraEngine;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.internal.egl.EglCore;
import com.otaliastudios.cameraview.internal.egl.EglViewport;
import com.otaliastudios.cameraview.internal.egl.EglWindowSurface;
import com.otaliastudios.cameraview.internal.utils.CropHelper;
import com.otaliastudios.cameraview.internal.utils.WorkerHandler;
import com.otaliastudios.cameraview.overlay.Overlay;
import com.otaliastudios.cameraview.overlay.OverlayDrawer;
import com.otaliastudios.cameraview.preview.GlCameraPreview;
import com.otaliastudios.cameraview.preview.RendererFrameCallback;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;

/* loaded from: classes8.dex */
public class SnapshotGlPictureRecorder extends SnapshotPictureRecorder {
    private GlCameraPreview DatabaseTableConfigUtil;
    boolean KClassImpl$Data$declaredNonStaticMembers$2;
    Overlay MyBillsEntityDataFactory;
    float[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    private CameraEngine NetworkUserEntityData$$ExternalSyntheticLambda1;
    AspectRatio PlaceComponentResult;
    OverlayDrawer getErrorConfigVersion;
    int lookAheadTest;
    EglViewport scheduleImpl;

    public SnapshotGlPictureRecorder(PictureResult.Stub stub, CameraEngine cameraEngine, GlCameraPreview glCameraPreview, AspectRatio aspectRatio) {
        super(stub, cameraEngine);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = cameraEngine;
        this.DatabaseTableConfigUtil = glCameraPreview;
        this.PlaceComponentResult = aspectRatio;
        Overlay B = cameraEngine.B();
        this.MyBillsEntityDataFactory = B;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = B != null && B.drawsOn(Overlay.Target.PICTURE_SNAPSHOT);
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public void PlaceComponentResult() {
        GlCameraPreview glCameraPreview = this.DatabaseTableConfigUtil;
        ((GLSurfaceView) glCameraPreview.lookAheadTest).queueEvent(new GlCameraPreview.AnonymousClass2(new RendererFrameCallback() { // from class: com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder.1
            {
                SnapshotGlPictureRecorder.this = this;
            }

            @Override // com.otaliastudios.cameraview.preview.RendererFrameCallback
            public final void getAuthRequestContext(int i) {
                SnapshotGlPictureRecorder snapshotGlPictureRecorder = SnapshotGlPictureRecorder.this;
                snapshotGlPictureRecorder.lookAheadTest = i;
                snapshotGlPictureRecorder.scheduleImpl = new EglViewport();
                Rect BuiltInFictitiousFunctionClassFactory = CropHelper.BuiltInFictitiousFunctionClassFactory(snapshotGlPictureRecorder.moveToNextValue.scheduleImpl, snapshotGlPictureRecorder.PlaceComponentResult);
                snapshotGlPictureRecorder.moveToNextValue.scheduleImpl = new Size(BuiltInFictitiousFunctionClassFactory.width(), BuiltInFictitiousFunctionClassFactory.height());
                float[] fArr = new float[16];
                snapshotGlPictureRecorder.NetworkUserEntityData$$ExternalSyntheticLambda0 = fArr;
                Matrix.setIdentityM(fArr, 0);
                if (snapshotGlPictureRecorder.KClassImpl$Data$declaredNonStaticMembers$2) {
                    snapshotGlPictureRecorder.getErrorConfigVersion = new OverlayDrawer(snapshotGlPictureRecorder.MyBillsEntityDataFactory, snapshotGlPictureRecorder.moveToNextValue.scheduleImpl);
                }
            }

            @Override // com.otaliastudios.cameraview.preview.RendererFrameCallback
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Filter filter) {
                SnapshotGlPictureRecorder.this.scheduleImpl.getAuthRequestContext = filter.PlaceComponentResult();
            }

            @Override // com.otaliastudios.cameraview.preview.RendererFrameCallback
            public final void BuiltInFictitiousFunctionClassFactory(final SurfaceTexture surfaceTexture, final float f, final float f2) {
                SnapshotGlPictureRecorder.this.DatabaseTableConfigUtil.NetworkUserEntityData$$ExternalSyntheticLambda2.remove(this);
                final SnapshotGlPictureRecorder snapshotGlPictureRecorder = SnapshotGlPictureRecorder.this;
                final EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
                WorkerHandler.KClassImpl$Data$declaredNonStaticMembers$2(new Runnable() { // from class: com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder.2
                    @Override // java.lang.Runnable
                    public void run() {
                        snapshotGlPictureRecorder.BuiltInFictitiousFunctionClassFactory(surfaceTexture, f, f2, eglGetCurrentContext);
                    }
                });
            }
        }));
    }

    protected final void BuiltInFictitiousFunctionClassFactory(SurfaceTexture surfaceTexture, float f, float f2, EGLContext eGLContext) {
        SurfaceTexture surfaceTexture2 = new SurfaceTexture(9999);
        surfaceTexture2.setDefaultBufferSize(this.moveToNextValue.scheduleImpl.BuiltInFictitiousFunctionClassFactory, this.moveToNextValue.scheduleImpl.getAuthRequestContext);
        EglCore eglCore = new EglCore(eGLContext, 1);
        EglWindowSurface eglWindowSurface = new EglWindowSurface(eglCore, surfaceTexture2);
        eglWindowSurface.getAuthRequestContext();
        boolean PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda1.PrepareContext().PlaceComponentResult(Reference.VIEW, Reference.SENSOR);
        float f3 = PlaceComponentResult ? f2 : f;
        float f4 = !PlaceComponentResult ? f2 : f;
        Matrix.translateM(this.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, (1.0f - f3) / 2.0f, (1.0f - f4) / 2.0f, 0.0f);
        Matrix.scaleM(this.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, f3, f4, 1.0f);
        Matrix.translateM(this.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, 0.5f, 0.5f, 0.0f);
        Matrix.rotateM(this.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, -this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0, 0.0f, 0.0f, 1.0f);
        this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
        if (this.moveToNextValue.getAuthRequestContext == Facing.FRONT) {
            Matrix.scaleM(this.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, -1.0f, 1.0f, 1.0f);
        }
        Matrix.translateM(this.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, -0.5f, -0.5f, 0.0f);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            this.getErrorConfigVersion.getAuthRequestContext(Overlay.Target.PICTURE_SNAPSHOT);
            int KClassImpl$Data$declaredNonStaticMembers$2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1.PrepareContext().KClassImpl$Data$declaredNonStaticMembers$2(Reference.VIEW, Reference.OUTPUT, Axis.ABSOLUTE);
            Matrix.translateM(this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory, 0, 0.5f, 0.5f, 0.0f);
            Matrix.rotateM(this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory, 0, KClassImpl$Data$declaredNonStaticMembers$2, 0.0f, 0.0f, 1.0f);
            Matrix.scaleM(this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory, 0, 1.0f, -1.0f, 1.0f);
            Matrix.translateM(this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory, 0, -0.5f, -0.5f, 0.0f);
        }
        long timestamp = surfaceTexture.getTimestamp() / 1000;
        NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2(1, "takeFrame:", "timestampUs:", Long.valueOf(timestamp));
        this.scheduleImpl.BuiltInFictitiousFunctionClassFactory(timestamp, this.lookAheadTest, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(timestamp);
        }
        this.moveToNextValue.BuiltInFictitiousFunctionClassFactory = eglWindowSurface.getAuthRequestContext(Bitmap.CompressFormat.JPEG);
        eglWindowSurface.BuiltInFictitiousFunctionClassFactory();
        EglViewport eglViewport = this.scheduleImpl;
        if (eglViewport.PlaceComponentResult != -1) {
            eglViewport.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
            GLES20.glDeleteProgram(eglViewport.PlaceComponentResult);
            eglViewport.PlaceComponentResult = -1;
        }
        surfaceTexture2.release();
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            this.getErrorConfigVersion.PlaceComponentResult();
        }
        eglCore.BuiltInFictitiousFunctionClassFactory();
        MyBillsEntityDataFactory();
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public void MyBillsEntityDataFactory() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
        this.PlaceComponentResult = null;
        super.MyBillsEntityDataFactory();
    }
}
