package com.otaliastudios.cameraview.internal.egl;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes8.dex */
public final class EglCore {
    private static final String MyBillsEntityDataFactory = "EglCore";
    private int BuiltInFictitiousFunctionClassFactory;
    EGLConfig KClassImpl$Data$declaredNonStaticMembers$2;
    EGLDisplay PlaceComponentResult;
    EGLContext getAuthRequestContext;

    public EglCore() {
        this(null, 0);
    }

    public EglCore(EGLContext eGLContext, int i) {
        EGLConfig authRequestContext;
        this.PlaceComponentResult = EGL14.EGL_NO_DISPLAY;
        this.getAuthRequestContext = EGL14.EGL_NO_CONTEXT;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.BuiltInFictitiousFunctionClassFactory = -1;
        if (this.PlaceComponentResult != EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.PlaceComponentResult = eglGetDisplay;
        if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.PlaceComponentResult, iArr, 0, iArr, 1)) {
            this.PlaceComponentResult = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        if ((i & 2) != 0 && (authRequestContext = getAuthRequestContext(i, 3)) != null) {
            EGLContext eglCreateContext = EGL14.eglCreateContext(this.PlaceComponentResult, authRequestContext, eGLContext, new int[]{12440, 3, 12344}, 0);
            if (EGL14.eglGetError() == 12288) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext;
                this.getAuthRequestContext = eglCreateContext;
                this.BuiltInFictitiousFunctionClassFactory = 3;
            }
        }
        if (this.getAuthRequestContext == EGL14.EGL_NO_CONTEXT) {
            EGLConfig authRequestContext2 = getAuthRequestContext(i, 2);
            if (authRequestContext2 == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.PlaceComponentResult, authRequestContext2, eGLContext, new int[]{12440, 2, 12344}, 0);
            getAuthRequestContext("eglCreateContext");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext2;
            this.getAuthRequestContext = eglCreateContext2;
            this.BuiltInFictitiousFunctionClassFactory = 2;
        }
        EGL14.eglQueryContext(this.PlaceComponentResult, this.getAuthRequestContext, 12440, new int[1], 0);
    }

    private EGLConfig getAuthRequestContext(int i, int i2) {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i2 >= 3 ? 68 : 4, 12344, 0, 12344};
        if ((i & 1) != 0) {
            iArr[10] = 12610;
            iArr[11] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.PlaceComponentResult, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        String str = MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append("unable to find RGB8888 / ");
        sb.append(i2);
        sb.append(" EGLConfig");
        InstrumentInjector.log_w(str, sb.toString());
        return null;
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        if (this.PlaceComponentResult != EGL14.EGL_NO_DISPLAY) {
            EGLDisplay eGLDisplay = this.PlaceComponentResult;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.PlaceComponentResult, this.getAuthRequestContext);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.PlaceComponentResult);
        }
        this.PlaceComponentResult = EGL14.EGL_NO_DISPLAY;
        this.getAuthRequestContext = EGL14.EGL_NO_CONTEXT;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.PlaceComponentResult != EGL14.EGL_NO_DISPLAY) {
                InstrumentInjector.log_w(MyBillsEntityDataFactory, "WARNING: EglCore was not explicitly released! State may be leaked");
                BuiltInFictitiousFunctionClassFactory();
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean PlaceComponentResult(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers(this.PlaceComponentResult, eGLSurface);
    }

    public final boolean MyBillsEntityDataFactory(EGLSurface eGLSurface) {
        return this.getAuthRequestContext.equals(EGL14.eglGetCurrentContext()) && eGLSurface.equals(EGL14.eglGetCurrentSurface(12377));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getAuthRequestContext(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(": EGL error: 0x");
        sb.append(Integer.toHexString(eglGetError));
        throw new RuntimeException(sb.toString());
    }
}
