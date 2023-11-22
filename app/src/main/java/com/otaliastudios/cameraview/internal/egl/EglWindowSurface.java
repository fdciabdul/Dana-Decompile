package com.otaliastudios.cameraview.internal.egl;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* loaded from: classes8.dex */
public class EglWindowSurface extends EglBaseSurface {
    public Surface MyBillsEntityDataFactory;
    public boolean getAuthRequestContext;

    public EglWindowSurface(EglCore eglCore, Surface surface) {
        super(eglCore);
        getAuthRequestContext(surface);
        this.MyBillsEntityDataFactory = surface;
        this.getAuthRequestContext = true;
    }

    public EglWindowSurface(EglCore eglCore, SurfaceTexture surfaceTexture) {
        super(eglCore);
        getAuthRequestContext(surfaceTexture);
    }
}
