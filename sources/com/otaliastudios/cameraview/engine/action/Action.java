package com.otaliastudios.cameraview.engine.action;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;

/* loaded from: classes8.dex */
public interface Action {
    void KClassImpl$Data$declaredNonStaticMembers$2(ActionCallback actionCallback);

    void PlaceComponentResult(ActionCallback actionCallback);

    void PlaceComponentResult(ActionHolder actionHolder);

    void PlaceComponentResult(ActionHolder actionHolder, CaptureRequest captureRequest, CaptureResult captureResult);

    void getAuthRequestContext(ActionHolder actionHolder);

    void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest);

    void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult);
}
