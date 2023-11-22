package com.otaliastudios.cameraview.internal.egl;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;
import com.fullstory.instrumentation.InstrumentInjector;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.internal.GlUtils;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes8.dex */
public class EglBaseSurface {
    protected static final String KClassImpl$Data$declaredNonStaticMembers$2 = "EglBaseSurface";
    private static final CameraLogger getAuthRequestContext = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2);
    protected EglCore PlaceComponentResult;
    private EGLSurface BuiltInFictitiousFunctionClassFactory = EGL14.EGL_NO_SURFACE;
    private int scheduleImpl = -1;
    private int MyBillsEntityDataFactory = -1;

    public EglBaseSurface(EglCore eglCore) {
        this.PlaceComponentResult = eglCore;
    }

    public final void getAuthRequestContext(Object obj) {
        if (this.BuiltInFictitiousFunctionClassFactory != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        EglCore eglCore = this.PlaceComponentResult;
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            StringBuilder sb = new StringBuilder();
            sb.append("invalid surface: ");
            sb.append(obj);
            throw new RuntimeException(sb.toString());
        }
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(eglCore.PlaceComponentResult, eglCore.KClassImpl$Data$declaredNonStaticMembers$2, obj, new int[]{12344}, 0);
        EglCore.getAuthRequestContext("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            this.BuiltInFictitiousFunctionClassFactory = eglCreateWindowSurface;
            return;
        }
        throw new RuntimeException("surface was null");
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        EglCore eglCore = this.PlaceComponentResult;
        EGL14.eglDestroySurface(eglCore.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
        this.BuiltInFictitiousFunctionClassFactory = EGL14.EGL_NO_SURFACE;
        this.MyBillsEntityDataFactory = -1;
        this.scheduleImpl = -1;
    }

    public final void getAuthRequestContext() {
        EglCore eglCore = this.PlaceComponentResult;
        EGLSurface eGLSurface = this.BuiltInFictitiousFunctionClassFactory;
        if (!EGL14.eglMakeCurrent(eglCore.PlaceComponentResult, eGLSurface, eGLSurface, eglCore.getAuthRequestContext)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public final boolean MyBillsEntityDataFactory() {
        boolean PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
        if (!PlaceComponentResult) {
            InstrumentInjector.log_d(KClassImpl$Data$declaredNonStaticMembers$2, "WARNING: swapBuffers() failed");
        }
        return PlaceComponentResult;
    }

    public final void MyBillsEntityDataFactory(long j) {
        EglCore eglCore = this.PlaceComponentResult;
        EGLExt.eglPresentationTimeANDROID(eglCore.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory, j);
    }

    public final byte[] getAuthRequestContext(Bitmap.CompressFormat compressFormat) {
        if (!this.PlaceComponentResult.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory)) {
            throw new RuntimeException("Expected EGL context/surface is not current");
        }
        int i = this.scheduleImpl;
        if (i < 0) {
            EglCore eglCore = this.PlaceComponentResult;
            int[] iArr = new int[1];
            EGL14.eglQuerySurface(eglCore.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory, 12375, iArr, 0);
            i = iArr[0];
        }
        int i2 = this.MyBillsEntityDataFactory;
        if (i2 < 0) {
            EglCore eglCore2 = this.PlaceComponentResult;
            int[] iArr2 = new int[1];
            EGL14.eglQuerySurface(eglCore2.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory, 12374, iArr2, 0);
            i2 = iArr2[0];
        }
        int i3 = i2;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * i3 * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        GLES20.glReadPixels(0, 0, i, i3, 6408, 5121, allocateDirect);
        GlUtils.PlaceComponentResult("glReadPixels");
        allocateDirect.rewind();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(allocateDirect.array().length);
        Bitmap createBitmap = Bitmap.createBitmap(i, i3, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(allocateDirect);
        createBitmap.compress(compressFormat, 90, byteArrayOutputStream);
        createBitmap.recycle();
        return byteArrayOutputStream.toByteArray();
    }
}
