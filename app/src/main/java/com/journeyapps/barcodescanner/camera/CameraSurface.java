package com.journeyapps.barcodescanner.camera;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;

/* loaded from: classes3.dex */
public class CameraSurface {
    SurfaceHolder KClassImpl$Data$declaredNonStaticMembers$2;
    SurfaceTexture MyBillsEntityDataFactory;

    public CameraSurface(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalArgumentException("surfaceHolder may not be null");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = surfaceHolder;
    }

    public CameraSurface(SurfaceTexture surfaceTexture) {
        if (surfaceTexture == null) {
            throw new IllegalArgumentException("surfaceTexture may not be null");
        }
        this.MyBillsEntityDataFactory = surfaceTexture;
    }
}
