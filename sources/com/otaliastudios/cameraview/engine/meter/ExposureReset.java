package com.otaliastudios.cameraview.engine.meter;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;

/* loaded from: classes8.dex */
public class ExposureReset extends BaseReset {
    private static final CameraLogger getAuthRequestContext = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("ExposureReset");

    @Override // com.otaliastudios.cameraview.engine.meter.BaseReset
    protected final void BuiltInFictitiousFunctionClassFactory(ActionHolder actionHolder, MeteringRectangle meteringRectangle) {
        int intValue = ((Integer) KClassImpl$Data$declaredNonStaticMembers$2(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue();
        if (meteringRectangle != null && intValue > 0) {
            actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{meteringRectangle});
        }
        TotalCaptureResult GetContactSyncConfig = actionHolder.GetContactSyncConfig();
        Integer num = GetContactSyncConfig == null ? null : (Integer) GetContactSyncConfig.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        CameraLogger cameraLogger = getAuthRequestContext;
        cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStarted:", "last precapture trigger is", num);
        if (num != null && num.intValue() == 1) {
            cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStarted:", "canceling precapture.");
            actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(Build.VERSION.SDK_INT < 23 ? 0 : 2));
        }
        actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
        actionHolder.PlaceComponentResult();
        MyBillsEntityDataFactory(0);
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public final void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        super.getAuthRequestContext(actionHolder, captureRequest, totalCaptureResult);
        if (PlaceComponentResult() == 0) {
            actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
            actionHolder.PlaceComponentResult();
            MyBillsEntityDataFactory(Integer.MAX_VALUE);
        }
    }
}
