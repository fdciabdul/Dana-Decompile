package com.otaliastudios.cameraview.overlay;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.internal.Issue514Workaround;
import com.otaliastudios.cameraview.internal.egl.EglViewport;
import com.otaliastudios.cameraview.overlay.Overlay;
import com.otaliastudios.cameraview.size.Size;

/* loaded from: classes8.dex */
public class OverlayDrawer {
    private static final CameraLogger getAuthRequestContext = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("OverlayDrawer");
    int KClassImpl$Data$declaredNonStaticMembers$2;
    private Issue514Workaround MyBillsEntityDataFactory;
    private Overlay NetworkUserEntityData$$ExternalSyntheticLambda0;
    EglViewport PlaceComponentResult;
    private Surface moveToNextValue;
    private SurfaceTexture scheduleImpl;
    public float[] BuiltInFictitiousFunctionClassFactory = new float[16];
    private final Object getErrorConfigVersion = new Object();

    public OverlayDrawer(Overlay overlay, Size size) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = overlay;
        EglViewport eglViewport = new EglViewport();
        this.PlaceComponentResult = eglViewport;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = eglViewport.getAuthRequestContext();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.KClassImpl$Data$declaredNonStaticMembers$2);
        this.scheduleImpl = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(size.BuiltInFictitiousFunctionClassFactory, size.getAuthRequestContext);
        this.moveToNextValue = new Surface(this.scheduleImpl);
        this.MyBillsEntityDataFactory = new Issue514Workaround(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public final void getAuthRequestContext(Overlay.Target target) {
        try {
            Canvas lockCanvas = this.moveToNextValue.lockCanvas(null);
            lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.drawOn(target, lockCanvas);
            this.moveToNextValue.unlockCanvasAndPost(lockCanvas);
        } catch (Surface.OutOfResourcesException e) {
            getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(2, "Got Surface.OutOfResourcesException while drawing video overlays", e);
        }
        synchronized (this.getErrorConfigVersion) {
            GLES20.glBindTexture(36197, this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory);
            this.scheduleImpl.updateTexImage();
        }
        this.scheduleImpl.getTransformMatrix(this.BuiltInFictitiousFunctionClassFactory);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(long j) {
        GLES20.glDisable(2884);
        GLES20.glDisable(2929);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        synchronized (this.getErrorConfigVersion) {
            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(j, this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public final void PlaceComponentResult() {
        if (this.MyBillsEntityDataFactory != null) {
            GLES20.glBindTexture(36197, 0);
            this.MyBillsEntityDataFactory = null;
        }
        SurfaceTexture surfaceTexture = this.scheduleImpl;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.scheduleImpl = null;
        }
        Surface surface = this.moveToNextValue;
        if (surface != null) {
            surface.release();
            this.moveToNextValue = null;
        }
        EglViewport eglViewport = this.PlaceComponentResult;
        if (eglViewport != null) {
            if (eglViewport.PlaceComponentResult != -1) {
                eglViewport.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
                GLES20.glDeleteProgram(eglViewport.PlaceComponentResult);
                eglViewport.PlaceComponentResult = -1;
            }
            this.PlaceComponentResult = null;
        }
    }
}
