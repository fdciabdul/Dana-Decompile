package com.otaliastudios.cameraview.preview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.otaliastudios.cameraview.R;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.filter.NoFilter;
import com.otaliastudios.cameraview.internal.egl.EglViewport;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.size.AspectRatio;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes2.dex */
public class GlCameraPreview extends FilterCameraPreview<GLSurfaceView, SurfaceTexture> {
    float DatabaseTableConfigUtil;
    public final Set<RendererFrameCallback> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final float[] NetworkUserEntityData$$ExternalSyntheticLambda4;
    private View NetworkUserEntityData$$ExternalSyntheticLambda5;
    private int NetworkUserEntityData$$ExternalSyntheticLambda7;
    private SurfaceTexture NetworkUserEntityData$$ExternalSyntheticLambda8;
    private boolean PrepareContext;
    float initRecordTimeStamp;
    private Filter isLayoutRequested;
    private EglViewport newProxyInstance;

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public final boolean scheduleImpl() {
        return true;
    }

    public GlCameraPreview(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new float[16];
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new CopyOnWriteArraySet();
        this.DatabaseTableConfigUtil = 1.0f;
        this.initRecordTimeStamp = 1.0f;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    final View MyBillsEntityDataFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda5;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        super.NetworkUserEntityData$$ExternalSyntheticLambda0();
        ((GLSurfaceView) this.lookAheadTest).onResume();
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public final void lookAheadTest() {
        super.lookAheadTest();
        ((GLSurfaceView) this.lookAheadTest).onPause();
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public final void moveToNextValue() {
        super.moveToNextValue();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.clear();
    }

    /* loaded from: classes8.dex */
    public class Renderer implements GLSurfaceView.Renderer {
        public Renderer() {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            if (GlCameraPreview.this.isLayoutRequested == null) {
                GlCameraPreview.this.isLayoutRequested = new NoFilter();
            }
            GlCameraPreview.this.newProxyInstance = new EglViewport(GlCameraPreview.this.isLayoutRequested);
            GlCameraPreview glCameraPreview = GlCameraPreview.this;
            glCameraPreview.NetworkUserEntityData$$ExternalSyntheticLambda7 = glCameraPreview.newProxyInstance.getAuthRequestContext();
            GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new SurfaceTexture(GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            ((GLSurfaceView) GlCameraPreview.this.lookAheadTest).queueEvent(new Runnable() { // from class: com.otaliastudios.cameraview.preview.GlCameraPreview.Renderer.1
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda2.iterator();
                    while (it.hasNext()) {
                        ((RendererFrameCallback) it.next()).getAuthRequestContext(GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda7);
                    }
                }
            });
            GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.otaliastudios.cameraview.preview.GlCameraPreview.Renderer.2
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    ((GLSurfaceView) GlCameraPreview.this.lookAheadTest).requestRender();
                }
            });
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            gl10.glViewport(0, 0, i, i2);
            GlCameraPreview.this.isLayoutRequested.KClassImpl$Data$declaredNonStaticMembers$2(i, i2);
            if (!GlCameraPreview.this.PrepareContext) {
                GlCameraPreview.this.BuiltInFictitiousFunctionClassFactory(i, i2);
                GlCameraPreview.this.PrepareContext = true;
            } else if (i == GlCameraPreview.this.getErrorConfigVersion && i2 == GlCameraPreview.this.scheduleImpl) {
            } else {
                GlCameraPreview.this.MyBillsEntityDataFactory(i, i2);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8 != null && GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda0 > 0 && GlCameraPreview.this.getAuthRequestContext > 0) {
                GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.updateTexImage();
                GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.getTransformMatrix(GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda4);
                if (GlCameraPreview.this.MyBillsEntityDataFactory != 0) {
                    Matrix.translateM(GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda4, 0, 0.5f, 0.5f, 0.0f);
                    Matrix.rotateM(GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda4, 0, GlCameraPreview.this.MyBillsEntityDataFactory, 0.0f, 0.0f, 1.0f);
                    Matrix.translateM(GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda4, 0, -0.5f, -0.5f, 0.0f);
                }
                if (GlCameraPreview.this.BuiltInFictitiousFunctionClassFactory()) {
                    Matrix.translateM(GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda4, 0, (1.0f - GlCameraPreview.this.DatabaseTableConfigUtil) / 2.0f, (1.0f - GlCameraPreview.this.initRecordTimeStamp) / 2.0f, 0.0f);
                    Matrix.scaleM(GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda4, 0, GlCameraPreview.this.DatabaseTableConfigUtil, GlCameraPreview.this.initRecordTimeStamp, 1.0f);
                }
                GlCameraPreview.this.newProxyInstance.BuiltInFictitiousFunctionClassFactory(GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.getTimestamp() / 1000, GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda7, GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda4);
                Iterator it = GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda2.iterator();
                while (it.hasNext()) {
                    ((RendererFrameCallback) it.next()).BuiltInFictitiousFunctionClassFactory(GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8, GlCameraPreview.this.DatabaseTableConfigUtil, GlCameraPreview.this.initRecordTimeStamp);
                }
            }
        }
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public final Class<SurfaceTexture> KClassImpl$Data$declaredNonStaticMembers$2() {
        return SurfaceTexture.class;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    protected final void PlaceComponentResult(CameraPreview.CropCallback cropCallback) {
        float f;
        float f2;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 <= 0 || this.getAuthRequestContext <= 0 || this.getErrorConfigVersion <= 0 || this.scheduleImpl <= 0) {
            return;
        }
        AspectRatio BuiltInFictitiousFunctionClassFactory = AspectRatio.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, this.scheduleImpl);
        AspectRatio BuiltInFictitiousFunctionClassFactory2 = AspectRatio.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getAuthRequestContext);
        if (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext / BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory >= BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext / BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory) {
            f2 = (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext / BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory) / (BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext / BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory);
            f = 1.0f;
        } else {
            f = (BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext / BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory) / (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext / BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
            f2 = 1.0f;
        }
        this.PlaceComponentResult = f > 1.02f || f2 > 1.02f;
        this.DatabaseTableConfigUtil = 1.0f / f;
        this.initRecordTimeStamp = 1.0f / f2;
        ((GLSurfaceView) this.lookAheadTest).requestRender();
    }

    /* renamed from: com.otaliastudios.cameraview.preview.GlCameraPreview$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ RendererFrameCallback PlaceComponentResult;

        public AnonymousClass2(RendererFrameCallback rendererFrameCallback) {
            this.PlaceComponentResult = rendererFrameCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda2.add(this.PlaceComponentResult);
            if (GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda7 != 0) {
                this.PlaceComponentResult.getAuthRequestContext(GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            }
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(GlCameraPreview.this.isLayoutRequested);
        }
    }

    @Override // com.otaliastudios.cameraview.preview.FilterCameraPreview
    public final Filter getErrorConfigVersion() {
        return this.isLayoutRequested;
    }

    @Override // com.otaliastudios.cameraview.preview.FilterCameraPreview
    public final void BuiltInFictitiousFunctionClassFactory(final Filter filter) {
        this.isLayoutRequested = filter;
        if (PlaceComponentResult()) {
            filter.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion, this.scheduleImpl);
        }
        ((GLSurfaceView) this.lookAheadTest).queueEvent(new Runnable() { // from class: com.otaliastudios.cameraview.preview.GlCameraPreview.3
            @Override // java.lang.Runnable
            public void run() {
                if (GlCameraPreview.this.newProxyInstance != null) {
                    GlCameraPreview.this.newProxyInstance.getAuthRequestContext = filter;
                }
                Iterator it = GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda2.iterator();
                while (it.hasNext()) {
                    ((RendererFrameCallback) it.next()).KClassImpl$Data$declaredNonStaticMembers$2(filter);
                }
            }
        });
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public final /* bridge */ /* synthetic */ Object getAuthRequestContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    protected final /* synthetic */ View PlaceComponentResult(Context context, ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.cameraview_gl_view, viewGroup, false);
        final GLSurfaceView gLSurfaceView = (GLSurfaceView) viewGroup2.findViewById(R.id.gl_surface_view);
        final Renderer renderer = new Renderer();
        gLSurfaceView.setEGLContextClientVersion(2);
        gLSurfaceView.setRenderer(renderer);
        gLSurfaceView.setRenderMode(0);
        gLSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.otaliastudios.cameraview.preview.GlCameraPreview.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                GlCameraPreview glCameraPreview = GlCameraPreview.this;
                glCameraPreview.getErrorConfigVersion = 0;
                glCameraPreview.scheduleImpl = 0;
                CameraPreview.SurfaceCallback surfaceCallback = glCameraPreview.moveToNextValue;
                if (surfaceCallback != null) {
                    surfaceCallback.X();
                }
                gLSurfaceView.queueEvent(new Runnable() { // from class: com.otaliastudios.cameraview.preview.GlCameraPreview.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Renderer renderer2 = renderer;
                        if (GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8 != null) {
                            GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.setOnFrameAvailableListener(null);
                            GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8.release();
                            GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
                        }
                        GlCameraPreview.this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
                        if (GlCameraPreview.this.newProxyInstance != null) {
                            EglViewport eglViewport = GlCameraPreview.this.newProxyInstance;
                            if (eglViewport.PlaceComponentResult != -1) {
                                eglViewport.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
                                GLES20.glDeleteProgram(eglViewport.PlaceComponentResult);
                                eglViewport.PlaceComponentResult = -1;
                            }
                            GlCameraPreview.this.newProxyInstance = null;
                        }
                    }
                });
                GlCameraPreview.this.PrepareContext = false;
            }
        });
        viewGroup.addView(viewGroup2, 0);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = viewGroup2;
        return gLSurfaceView;
    }
}
