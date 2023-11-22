package com.journeyapps.barcodescanner.camera;

import android.hardware.Camera;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
public final /* synthetic */ class CameraInstance$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ PreviewCallback BuiltInFictitiousFunctionClassFactory;
    public final /* synthetic */ CameraInstance PlaceComponentResult;

    public /* synthetic */ CameraInstance$$ExternalSyntheticLambda3(CameraInstance cameraInstance, PreviewCallback previewCallback) {
        this.PlaceComponentResult = cameraInstance;
        this.BuiltInFictitiousFunctionClassFactory = previewCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final CameraInstance cameraInstance = this.PlaceComponentResult;
        final PreviewCallback previewCallback = this.BuiltInFictitiousFunctionClassFactory;
        if (!cameraInstance.moveToNextValue) {
            InstrumentInjector.log_d(CameraInstance.KClassImpl$Data$declaredNonStaticMembers$2, "Camera is closed, not requesting preview");
            return;
        }
        CameraThread cameraThread = cameraInstance.PlaceComponentResult;
        Runnable runnable = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                CameraInstance cameraInstance2 = CameraInstance.this;
                PreviewCallback previewCallback2 = previewCallback;
                CameraManager cameraManager = cameraInstance2.BuiltInFictitiousFunctionClassFactory;
                Camera camera = cameraManager.KClassImpl$Data$declaredNonStaticMembers$2;
                if (camera == null || !cameraManager.moveToNextValue) {
                    return;
                }
                cameraManager.lookAheadTest.getAuthRequestContext = previewCallback2;
                camera.setOneShotPreviewCallback(cameraManager.lookAheadTest);
            }
        };
        synchronized (cameraThread.getAuthRequestContext) {
            cameraThread.KClassImpl$Data$declaredNonStaticMembers$2();
            cameraThread.KClassImpl$Data$declaredNonStaticMembers$2.post(runnable);
        }
    }
}
